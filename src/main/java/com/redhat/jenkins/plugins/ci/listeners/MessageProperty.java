package com.redhat.jenkins.plugins.ci.listeners;

import hudson.Extension;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.util.ListBoxModel;

import java.io.Serializable;

import jenkins.model.Jenkins;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

public class MessageProperty implements Describable<MessageProperty>, Serializable {
    private static final long serialVersionUID = -5623407137358474920L;

    private MessagePropertyType type;
    private String name;
    private String value;

    @DataBoundConstructor
    public MessageProperty(MessagePropertyType type, String name, String value) {
        this.setType(type);
        this.setName(name);
        this.setValue(value);
    }

    public MessagePropertyType getType() {
        return type;
    }

    @DataBoundSetter
    public void setType(MessagePropertyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @DataBoundSetter
    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    @DataBoundSetter
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Descriptor<MessageProperty> getDescriptor() {
        return Jenkins.getInstance().getDescriptorByType(MessagePropertyDescriptor.class);
    }

    @Extension
    public static class MessagePropertyDescriptor extends Descriptor<MessageProperty> {

        @Override
        public String getDisplayName() {
            return "";
        }

        public ListBoxModel doFillTypeItems() {
            ListBoxModel items = new ListBoxModel();
            for (MessagePropertyType t : MessagePropertyType.values()) {
                items.add(t.displayName(), t.toString());
            }
            return items;
        }
    }
}
