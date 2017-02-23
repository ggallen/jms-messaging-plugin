package com.redhat.jenkins.plugins.ci.listeners.activemq;

import hudson.Extension;
import hudson.model.Descriptor;

import java.util.List;
import java.util.logging.Logger;

import jenkins.model.Jenkins;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

import com.redhat.jenkins.plugins.ci.listeners.CompletedBuildListener;
import com.redhat.jenkins.plugins.ci.listeners.MessageProperty;

/*
 * The MIT License
 *
 * Copyright (c) Red Hat, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
public class ActiveMQCompletedBuildListener extends CompletedBuildListener {
    private transient static final long serialVersionUID = 750529245969670107L;
    private transient static final Logger log = Logger.getLogger(ActiveMQCompletedBuildListener.class.getName());

    private String topic;
    private List<MessageProperty> props;
    private String message;

    @DataBoundConstructor
    public ActiveMQCompletedBuildListener(String topic, List<MessageProperty> props, String message) {
        this.topic = topic;
        this.props = props;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    @DataBoundSetter
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<MessageProperty> getProps() {
        return props;
    }

    @DataBoundSetter
    public void setProps(List<MessageProperty> props) {
        this.props = props;
    }

    public String getMessage() {
        return message;
    }

    @DataBoundSetter
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Descriptor<CompletedBuildListener> getDescriptor() {
        return Jenkins.getInstance().getDescriptorByType(ActiveMQCompletedBuildListenerDescriptor.class);
    }

    @Extension
    public static class ActiveMQCompletedBuildListenerDescriptor extends CompletedBuildListenerDescriptor {

        public ActiveMQCompletedBuildListenerDescriptor() {
            load();
        }

        @Override
        public String getDisplayName() {
            return "Active MQ Completed Build Listener";
        }
    }
}
