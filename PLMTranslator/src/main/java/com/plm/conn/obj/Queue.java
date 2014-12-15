/**
 * 
 */
package com.plm.conn.obj;

import java.util.Enumeration;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageFormatException;
import javax.jms.MessageNotWriteableException;

import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.Message;
import org.apache.activemq.command.ProducerId;
import org.apache.activemq.command.Response;
import org.apache.activemq.state.CommandVisitor;
import org.apache.activemq.util.Callback;

/**
 * 
 *
 */
public class Queue extends ActiveMQMessage {
  
	/**
	 * 
	 */
	public Queue() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#acknowledge()
	 */
	@Override
	public void acknowledge() throws JMSException {
		// TODO Auto-generated method stub
		super.acknowledge();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#checkReadOnlyBody()
	 */
	@Override
	protected void checkReadOnlyBody() throws MessageNotWriteableException {
		// TODO Auto-generated method stub
		super.checkReadOnlyBody();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#checkValidObject(java.lang.Object)
	 */
	@Override
	protected void checkValidObject(Object arg0) throws MessageFormatException {
		// TODO Auto-generated method stub
		super.checkValidObject(arg0);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#checkValidScheduled(java.lang.String, java.lang.Object)
	 */
	@Override
	protected void checkValidScheduled(String name, Object value)
			throws MessageFormatException {
		// TODO Auto-generated method stub
		super.checkValidScheduled(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#clearBody()
	 */
	@Override
	public void clearBody() throws JMSException {
		// TODO Auto-generated method stub
		super.clearBody();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#clearProperties()
	 */
	@Override
	public void clearProperties() {
		// TODO Auto-generated method stub
		super.clearProperties();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#convertScheduled(java.lang.String, java.lang.Object)
	 */
	@Override
	protected Object convertScheduled(String name, Object value)
			throws MessageFormatException {
		// TODO Auto-generated method stub
		return super.convertScheduled(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#copy()
	 */
	@Override
	public Message copy() {
		// TODO Auto-generated method stub
		return super.copy();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#copy(org.apache.activemq.command.ActiveMQMessage)
	 */
	@Override
	protected void copy(ActiveMQMessage copy) {
		// TODO Auto-generated method stub
		super.copy(copy);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return super.equals(o);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getAcknowledgeCallback()
	 */
	@Override
	public Callback getAcknowledgeCallback() {
		// TODO Auto-generated method stub
		return super.getAcknowledgeCallback();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getAllPropertyNames()
	 */
	@Override
	public Enumeration getAllPropertyNames() throws JMSException {
		// TODO Auto-generated method stub
		return super.getAllPropertyNames();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getBooleanProperty(java.lang.String)
	 */
	@Override
	public boolean getBooleanProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getBooleanProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getByteProperty(java.lang.String)
	 */
	@Override
	public byte getByteProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getByteProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getDataStructureType()
	 */
	@Override
	public byte getDataStructureType() {
		// TODO Auto-generated method stub
		return super.getDataStructureType();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getDoubleProperty(java.lang.String)
	 */
	@Override
	public double getDoubleProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getDoubleProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getFloatProperty(java.lang.String)
	 */
	@Override
	public float getFloatProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getFloatProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getIntProperty(java.lang.String)
	 */
	@Override
	public int getIntProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getIntProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSCorrelationID()
	 */
	@Override
	public String getJMSCorrelationID() {
		// TODO Auto-generated method stub
		return super.getJMSCorrelationID();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSCorrelationIDAsBytes()
	 */
	@Override
	public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
		// TODO Auto-generated method stub
		return super.getJMSCorrelationIDAsBytes();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSDeliveryMode()
	 */
	@Override
	public int getJMSDeliveryMode() {
		// TODO Auto-generated method stub
		return super.getJMSDeliveryMode();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSDestination()
	 */
	@Override
	public Destination getJMSDestination() {
		// TODO Auto-generated method stub
		return super.getJMSDestination();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSExpiration()
	 */
	@Override
	public long getJMSExpiration() {
		// TODO Auto-generated method stub
		return super.getJMSExpiration();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSMessageID()
	 */
	@Override
	public String getJMSMessageID() {
		// TODO Auto-generated method stub
		return super.getJMSMessageID();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSPriority()
	 */
	@Override
	public int getJMSPriority() {
		// TODO Auto-generated method stub
		return super.getJMSPriority();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSRedelivered()
	 */
	@Override
	public boolean getJMSRedelivered() {
		// TODO Auto-generated method stub
		return super.getJMSRedelivered();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSReplyTo()
	 */
	@Override
	public Destination getJMSReplyTo() {
		// TODO Auto-generated method stub
		return super.getJMSReplyTo();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSTimestamp()
	 */
	@Override
	public long getJMSTimestamp() {
		// TODO Auto-generated method stub
		return super.getJMSTimestamp();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSType()
	 */
	@Override
	public String getJMSType() {
		// TODO Auto-generated method stub
		return super.getJMSType();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getJMSXMimeType()
	 */
	@Override
	public String getJMSXMimeType() {
		// TODO Auto-generated method stub
		return super.getJMSXMimeType();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getLongProperty(java.lang.String)
	 */
	@Override
	public long getLongProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getLongProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getObjectProperty(java.lang.String)
	 */
	@Override
	public Object getObjectProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getObjectProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getPropertyNames()
	 */
	@Override
	public Enumeration getPropertyNames() throws JMSException {
		// TODO Auto-generated method stub
		return super.getPropertyNames();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getShortProperty(java.lang.String)
	 */
	@Override
	public short getShortProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getShortProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#getStringProperty(java.lang.String)
	 */
	@Override
	public String getStringProperty(String name) throws JMSException {
		// TODO Auto-generated method stub
		return super.getStringProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#onSend()
	 */
	@Override
	public void onSend() throws JMSException {
		// TODO Auto-generated method stub
		super.onSend();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#propertyExists(java.lang.String)
	 */
	@Override
	public boolean propertyExists(String arg0) throws JMSException {
		// TODO Auto-generated method stub
		return super.propertyExists(arg0);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setAcknowledgeCallback(org.apache.activemq.util.Callback)
	 */
	@Override
	public void setAcknowledgeCallback(Callback acknowledgeCallback) {
		// TODO Auto-generated method stub
		super.setAcknowledgeCallback(acknowledgeCallback);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setBooleanProperty(java.lang.String, boolean, boolean)
	 */
	@Override
	public void setBooleanProperty(String name, boolean value,
			boolean checkReadOnly) throws JMSException {
		// TODO Auto-generated method stub
		super.setBooleanProperty(name, value, checkReadOnly);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setBooleanProperty(java.lang.String, boolean)
	 */
	@Override
	public void setBooleanProperty(String name, boolean value)
			throws JMSException {
		// TODO Auto-generated method stub
		super.setBooleanProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setByteProperty(java.lang.String, byte)
	 */
	@Override
	public void setByteProperty(String name, byte value) throws JMSException {
		// TODO Auto-generated method stub
		super.setByteProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setDoubleProperty(java.lang.String, double)
	 */
	@Override
	public void setDoubleProperty(String name, double value)
			throws JMSException {
		// TODO Auto-generated method stub
		super.setDoubleProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setFloatProperty(java.lang.String, float)
	 */
	@Override
	public void setFloatProperty(String name, float value) throws JMSException {
		// TODO Auto-generated method stub
		super.setFloatProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setIntProperty(java.lang.String, int)
	 */
	@Override
	public void setIntProperty(String name, int value) throws JMSException {
		// TODO Auto-generated method stub
		super.setIntProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSCorrelationID(java.lang.String)
	 */
	@Override
	public void setJMSCorrelationID(String correlationId) {
		// TODO Auto-generated method stub
		super.setJMSCorrelationID(correlationId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSCorrelationIDAsBytes(byte[])
	 */
	@Override
	public void setJMSCorrelationIDAsBytes(byte[] correlationId)
			throws JMSException {
		// TODO Auto-generated method stub
		super.setJMSCorrelationIDAsBytes(correlationId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSDeliveryMode(int)
	 */
	@Override
	public void setJMSDeliveryMode(int mode) {
		// TODO Auto-generated method stub
		super.setJMSDeliveryMode(mode);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSDestination(javax.jms.Destination)
	 */
	@Override
	public void setJMSDestination(Destination destination) throws JMSException {
		// TODO Auto-generated method stub
		super.setJMSDestination(destination);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSExpiration(long)
	 */
	@Override
	public void setJMSExpiration(long expiration) {
		// TODO Auto-generated method stub
		super.setJMSExpiration(expiration);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSMessageID(org.apache.activemq.command.ProducerId, long)
	 */
	@Override
	public void setJMSMessageID(ProducerId arg0, long arg1) throws JMSException {
		// TODO Auto-generated method stub
		super.setJMSMessageID(arg0, arg1);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSMessageID(java.lang.String)
	 */
	@Override
	public void setJMSMessageID(String arg0) throws JMSException {
		// TODO Auto-generated method stub
		super.setJMSMessageID(arg0);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSPriority(int)
	 */
	@Override
	public void setJMSPriority(int priority) {
		// TODO Auto-generated method stub
		super.setJMSPriority(priority);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSRedelivered(boolean)
	 */
	@Override
	public void setJMSRedelivered(boolean redelivered) {
		// TODO Auto-generated method stub
		super.setJMSRedelivered(redelivered);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSReplyTo(javax.jms.Destination)
	 */
	@Override
	public void setJMSReplyTo(Destination destination) throws JMSException {
		// TODO Auto-generated method stub
		super.setJMSReplyTo(destination);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSTimestamp(long)
	 */
	@Override
	public void setJMSTimestamp(long timestamp) {
		// TODO Auto-generated method stub
		super.setJMSTimestamp(timestamp);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setJMSType(java.lang.String)
	 */
	@Override
	public void setJMSType(String type) {
		// TODO Auto-generated method stub
		super.setJMSType(type);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setLongProperty(java.lang.String, long)
	 */
	@Override
	public void setLongProperty(String name, long value) throws JMSException {
		// TODO Auto-generated method stub
		super.setLongProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setObjectProperty(java.lang.String, java.lang.Object, boolean)
	 */
	@Override
	public void setObjectProperty(String arg0, Object arg1, boolean arg2)
			throws JMSException {
		// TODO Auto-generated method stub
		super.setObjectProperty(arg0, arg1, arg2);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setObjectProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setObjectProperty(String name, Object value)
			throws JMSException {
		// TODO Auto-generated method stub
		super.setObjectProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setProperties(java.util.Map)
	 */
	@Override
	public void setProperties(Map<String, ?> arg0) throws JMSException {
		// TODO Auto-generated method stub
		super.setProperties(arg0);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setShortProperty(java.lang.String, short)
	 */
	@Override
	public void setShortProperty(String name, short value) throws JMSException {
		// TODO Auto-generated method stub
		super.setShortProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#setStringProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public void setStringProperty(String name, String value)
			throws JMSException {
		// TODO Auto-generated method stub
		super.setStringProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#storeContent()
	 */
	@Override
	public void storeContent() {
		// TODO Auto-generated method stub
		super.storeContent();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.ActiveMQMessage#visit(org.apache.activemq.state.CommandVisitor)
	 */
	@Override
	public Response visit(CommandVisitor visitor) throws Exception {
		// TODO Auto-generated method stub
		return super.visit(visitor);
	}

}
