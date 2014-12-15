package com.plm.conn.obj;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageFormatException;
import javax.jms.MessageNotWriteableException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.BaseCommand;
import org.apache.activemq.command.BrokerId;
import org.apache.activemq.command.ConsumerId;
import org.apache.activemq.command.DataStructure;
import org.apache.activemq.command.Endpoint;
import org.apache.activemq.command.Message;
import org.apache.activemq.command.MessageId;
import org.apache.activemq.command.ProducerId;
import org.apache.activemq.command.Response;
import org.apache.activemq.command.TransactionId;
import org.apache.activemq.state.CommandVisitor;
import org.apache.activemq.usage.MemoryUsage;
import org.apache.activemq.util.ByteSequence;
import org.apache.activemq.util.Callback;
import org.apache.activemq.wireformat.WireFormat;

public class FailedJobs extends ActiveMQMessage {

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

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#afterMarshall(org.apache.activemq.wireformat.WireFormat)
	 */
	@Override
	public void afterMarshall(WireFormat wireFormat) throws IOException {
		// TODO Auto-generated method stub
		super.afterMarshall(wireFormat);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#afterUnmarshall(org.apache.activemq.wireformat.WireFormat)
	 */
	@Override
	public void afterUnmarshall(WireFormat wireFormat) throws IOException {
		// TODO Auto-generated method stub
		super.afterUnmarshall(wireFormat);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#beforeMarshall(org.apache.activemq.wireformat.WireFormat)
	 */
	@Override
	public void beforeMarshall(WireFormat arg0) throws IOException {
		// TODO Auto-generated method stub
		super.beforeMarshall(arg0);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#beforeUnmarshall(org.apache.activemq.wireformat.WireFormat)
	 */
	@Override
	public void beforeUnmarshall(WireFormat wireFormat) throws IOException {
		// TODO Auto-generated method stub
		super.beforeUnmarshall(wireFormat);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#clearMarshalledState()
	 */
	@Override
	public void clearMarshalledState() throws JMSException {
		// TODO Auto-generated method stub
		super.clearMarshalledState();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#compress()
	 */
	@Override
	public void compress() throws IOException {
		// TODO Auto-generated method stub
		super.compress();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#copy(org.apache.activemq.command.Message)
	 */
	@Override
	protected void copy(Message copy) {
		// TODO Auto-generated method stub
		super.copy(copy);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#decrementReferenceCount()
	 */
	@Override
	public int decrementReferenceCount() {
		// TODO Auto-generated method stub
		return super.decrementReferenceCount();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#doCompress()
	 */
	@Override
	protected void doCompress() throws IOException {
		// TODO Auto-generated method stub
		super.doCompress();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getArrival()
	 */
	@Override
	public long getArrival() {
		// TODO Auto-generated method stub
		return super.getArrival();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getBrokerInTime()
	 */
	@Override
	public long getBrokerInTime() {
		// TODO Auto-generated method stub
		return super.getBrokerInTime();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getBrokerOutTime()
	 */
	@Override
	public long getBrokerOutTime() {
		// TODO Auto-generated method stub
		return super.getBrokerOutTime();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getBrokerPath()
	 */
	@Override
	public BrokerId[] getBrokerPath() {
		// TODO Auto-generated method stub
		return super.getBrokerPath();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getCluster()
	 */
	@Override
	public BrokerId[] getCluster() {
		// TODO Auto-generated method stub
		return super.getCluster();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getConnection()
	 */
	@Override
	public ActiveMQConnection getConnection() {
		// TODO Auto-generated method stub
		return super.getConnection();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getContent()
	 */
	@Override
	public ByteSequence getContent() {
		// TODO Auto-generated method stub
		return super.getContent();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getCorrelationId()
	 */
	@Override
	public String getCorrelationId() {
		// TODO Auto-generated method stub
		return super.getCorrelationId();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getDataStructure()
	 */
	@Override
	public DataStructure getDataStructure() {
		// TODO Auto-generated method stub
		return super.getDataStructure();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getDestination()
	 */
	@Override
	public ActiveMQDestination getDestination() {
		// TODO Auto-generated method stub
		return super.getDestination();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getExpiration()
	 */
	@Override
	public long getExpiration() {
		// TODO Auto-generated method stub
		return super.getExpiration();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getGroupID()
	 */
	@Override
	public String getGroupID() {
		// TODO Auto-generated method stub
		return super.getGroupID();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getGroupSequence()
	 */
	@Override
	public int getGroupSequence() {
		// TODO Auto-generated method stub
		return super.getGroupSequence();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getMarshalledProperties()
	 */
	@Override
	public ByteSequence getMarshalledProperties() {
		// TODO Auto-generated method stub
		return super.getMarshalledProperties();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getMemoryUsage()
	 */
	@Override
	public MemoryUsage getMemoryUsage() {
		// TODO Auto-generated method stub
		return super.getMemoryUsage();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getMessage()
	 */
	@Override
	public Message getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getMessageHardRef()
	 */
	@Override
	public Message getMessageHardRef() {
		// TODO Auto-generated method stub
		return super.getMessageHardRef();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getMessageId()
	 */
	@Override
	public MessageId getMessageId() {
		// TODO Auto-generated method stub
		return super.getMessageId();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getMinimumMessageSize()
	 */
	@Override
	protected int getMinimumMessageSize() {
		// TODO Auto-generated method stub
		return super.getMinimumMessageSize();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getOriginalDestination()
	 */
	@Override
	public ActiveMQDestination getOriginalDestination() {
		// TODO Auto-generated method stub
		return super.getOriginalDestination();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getOriginalTransactionId()
	 */
	@Override
	public TransactionId getOriginalTransactionId() {
		// TODO Auto-generated method stub
		return super.getOriginalTransactionId();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getPriority()
	 */
	@Override
	public byte getPriority() {
		// TODO Auto-generated method stub
		return super.getPriority();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getProducerId()
	 */
	@Override
	public ProducerId getProducerId() {
		// TODO Auto-generated method stub
		return super.getProducerId();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getProperties()
	 */
	@Override
	public Map<String, Object> getProperties() throws IOException {
		// TODO Auto-generated method stub
		return super.getProperties();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getProperty(java.lang.String)
	 */
	@Override
	public Object getProperty(String name) throws IOException {
		// TODO Auto-generated method stub
		return super.getProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getRedeliveryCounter()
	 */
	@Override
	public int getRedeliveryCounter() {
		// TODO Auto-generated method stub
		return super.getRedeliveryCounter();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getReferenceCount()
	 */
	@Override
	public int getReferenceCount() {
		// TODO Auto-generated method stub
		return super.getReferenceCount();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getRegionDestination()
	 */
	@Override
	public org.apache.activemq.broker.region.Destination getRegionDestination() {
		// TODO Auto-generated method stub
		return super.getRegionDestination();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getReplyTo()
	 */
	@Override
	public ActiveMQDestination getReplyTo() {
		// TODO Auto-generated method stub
		return super.getReplyTo();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getSize()
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return super.getSize();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getTargetConsumerId()
	 */
	@Override
	public ConsumerId getTargetConsumerId() {
		// TODO Auto-generated method stub
		return super.getTargetConsumerId();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getTimestamp()
	 */
	@Override
	public long getTimestamp() {
		// TODO Auto-generated method stub
		return super.getTimestamp();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getTransactionId()
	 */
	@Override
	public TransactionId getTransactionId() {
		// TODO Auto-generated method stub
		return super.getTransactionId();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getType()
	 */
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return super.getType();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#getUserID()
	 */
	@Override
	public String getUserID() {
		// TODO Auto-generated method stub
		return super.getUserID();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#incrementRedeliveryCounter()
	 */
	@Override
	public void incrementRedeliveryCounter() {
		// TODO Auto-generated method stub
		super.incrementRedeliveryCounter();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#incrementReferenceCount()
	 */
	@Override
	public int incrementReferenceCount() {
		// TODO Auto-generated method stub
		return super.incrementReferenceCount();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isAdvisory()
	 */
	@Override
	public boolean isAdvisory() {
		// TODO Auto-generated method stub
		return super.isAdvisory();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isCompressed()
	 */
	@Override
	public boolean isCompressed() {
		// TODO Auto-generated method stub
		return super.isCompressed();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isDroppable()
	 */
	@Override
	public boolean isDroppable() {
		// TODO Auto-generated method stub
		return super.isDroppable();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isDropped()
	 */
	@Override
	public boolean isDropped() {
		// TODO Auto-generated method stub
		return super.isDropped();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isExpired()
	 */
	@Override
	public boolean isExpired() {
		// TODO Auto-generated method stub
		return super.isExpired();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isInTransaction()
	 */
	@Override
	public boolean isInTransaction() {
		// TODO Auto-generated method stub
		return super.isInTransaction();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isMarshallAware()
	 */
	@Override
	public boolean isMarshallAware() {
		// TODO Auto-generated method stub
		return super.isMarshallAware();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isMessage()
	 */
	@Override
	public boolean isMessage() {
		// TODO Auto-generated method stub
		return super.isMessage();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isPersistent()
	 */
	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return super.isPersistent();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isReadOnlyBody()
	 */
	@Override
	public boolean isReadOnlyBody() {
		// TODO Auto-generated method stub
		return super.isReadOnlyBody();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isReadOnlyProperties()
	 */
	@Override
	public boolean isReadOnlyProperties() {
		// TODO Auto-generated method stub
		return super.isReadOnlyProperties();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isRecievedByDFBridge()
	 */
	@Override
	public boolean isRecievedByDFBridge() {
		// TODO Auto-generated method stub
		return super.isRecievedByDFBridge();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#isRedelivered()
	 */
	@Override
	public boolean isRedelivered() {
		// TODO Auto-generated method stub
		return super.isRedelivered();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#lazyCreateProperties()
	 */
	@Override
	protected void lazyCreateProperties() throws IOException {
		// TODO Auto-generated method stub
		super.lazyCreateProperties();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#onMessageRolledBack()
	 */
	@Override
	public void onMessageRolledBack() {
		// TODO Auto-generated method stub
		super.onMessageRolledBack();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#removeProperty(java.lang.String)
	 */
	@Override
	public void removeProperty(String name) throws IOException {
		// TODO Auto-generated method stub
		super.removeProperty(name);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setArrival(long)
	 */
	@Override
	public void setArrival(long arrival) {
		// TODO Auto-generated method stub
		super.setArrival(arrival);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setBrokerInTime(long)
	 */
	@Override
	public void setBrokerInTime(long brokerInTime) {
		// TODO Auto-generated method stub
		super.setBrokerInTime(brokerInTime);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setBrokerOutTime(long)
	 */
	@Override
	public void setBrokerOutTime(long brokerOutTime) {
		// TODO Auto-generated method stub
		super.setBrokerOutTime(brokerOutTime);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setBrokerPath(org.apache.activemq.command.BrokerId[])
	 */
	@Override
	public void setBrokerPath(BrokerId[] brokerPath) {
		// TODO Auto-generated method stub
		super.setBrokerPath(brokerPath);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setCluster(org.apache.activemq.command.BrokerId[])
	 */
	@Override
	public void setCluster(BrokerId[] cluster) {
		// TODO Auto-generated method stub
		super.setCluster(cluster);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setCompressed(boolean)
	 */
	@Override
	public void setCompressed(boolean compressed) {
		// TODO Auto-generated method stub
		super.setCompressed(compressed);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setConnection(org.apache.activemq.ActiveMQConnection)
	 */
	@Override
	public void setConnection(ActiveMQConnection connection) {
		// TODO Auto-generated method stub
		super.setConnection(connection);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setContent(org.apache.activemq.util.ByteSequence)
	 */
	@Override
	public void setContent(ByteSequence content) {
		// TODO Auto-generated method stub
		super.setContent(content);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setCorrelationId(java.lang.String)
	 */
	@Override
	public void setCorrelationId(String correlationId) {
		// TODO Auto-generated method stub
		super.setCorrelationId(correlationId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setDataStructure(org.apache.activemq.command.DataStructure)
	 */
	@Override
	public void setDataStructure(DataStructure data) {
		// TODO Auto-generated method stub
		super.setDataStructure(data);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setDestination(org.apache.activemq.command.ActiveMQDestination)
	 */
	@Override
	public void setDestination(ActiveMQDestination destination) {
		// TODO Auto-generated method stub
		super.setDestination(destination);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setDroppable(boolean)
	 */
	@Override
	public void setDroppable(boolean droppable) {
		// TODO Auto-generated method stub
		super.setDroppable(droppable);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setExpiration(long)
	 */
	@Override
	public void setExpiration(long expiration) {
		// TODO Auto-generated method stub
		super.setExpiration(expiration);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setGroupID(java.lang.String)
	 */
	@Override
	public void setGroupID(String groupID) {
		// TODO Auto-generated method stub
		super.setGroupID(groupID);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setGroupSequence(int)
	 */
	@Override
	public void setGroupSequence(int groupSequence) {
		// TODO Auto-generated method stub
		super.setGroupSequence(groupSequence);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setMarshalledProperties(org.apache.activemq.util.ByteSequence)
	 */
	@Override
	public void setMarshalledProperties(ByteSequence marshalledProperties) {
		// TODO Auto-generated method stub
		super.setMarshalledProperties(marshalledProperties);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setMemoryUsage(org.apache.activemq.usage.MemoryUsage)
	 */
	@Override
	public void setMemoryUsage(MemoryUsage usage) {
		// TODO Auto-generated method stub
		super.setMemoryUsage(usage);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setMessageId(org.apache.activemq.command.MessageId)
	 */
	@Override
	public void setMessageId(MessageId messageId) {
		// TODO Auto-generated method stub
		super.setMessageId(messageId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setOriginalDestination(org.apache.activemq.command.ActiveMQDestination)
	 */
	@Override
	public void setOriginalDestination(ActiveMQDestination destination) {
		// TODO Auto-generated method stub
		super.setOriginalDestination(destination);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setOriginalTransactionId(org.apache.activemq.command.TransactionId)
	 */
	@Override
	public void setOriginalTransactionId(TransactionId transactionId) {
		// TODO Auto-generated method stub
		super.setOriginalTransactionId(transactionId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setPersistent(boolean)
	 */
	@Override
	public void setPersistent(boolean deliveryMode) {
		// TODO Auto-generated method stub
		super.setPersistent(deliveryMode);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setPriority(byte)
	 */
	@Override
	public void setPriority(byte priority) {
		// TODO Auto-generated method stub
		super.setPriority(priority);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setProducerId(org.apache.activemq.command.ProducerId)
	 */
	@Override
	public void setProducerId(ProducerId producerId) {
		// TODO Auto-generated method stub
		super.setProducerId(producerId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public void setProperty(String name, Object value) throws IOException {
		// TODO Auto-generated method stub
		super.setProperty(name, value);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setReadOnlyBody(boolean)
	 */
	@Override
	public void setReadOnlyBody(boolean readOnlyBody) {
		// TODO Auto-generated method stub
		super.setReadOnlyBody(readOnlyBody);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setReadOnlyProperties(boolean)
	 */
	@Override
	public void setReadOnlyProperties(boolean readOnlyProperties) {
		// TODO Auto-generated method stub
		super.setReadOnlyProperties(readOnlyProperties);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setRecievedByDFBridge(boolean)
	 */
	@Override
	public void setRecievedByDFBridge(boolean recievedByDFBridge) {
		// TODO Auto-generated method stub
		super.setRecievedByDFBridge(recievedByDFBridge);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setRedelivered(boolean)
	 */
	@Override
	public void setRedelivered(boolean redelivered) {
		// TODO Auto-generated method stub
		super.setRedelivered(redelivered);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setRedeliveryCounter(int)
	 */
	@Override
	public void setRedeliveryCounter(int deliveryCounter) {
		// TODO Auto-generated method stub
		super.setRedeliveryCounter(deliveryCounter);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setRegionDestination(org.apache.activemq.broker.region.Destination)
	 */
	@Override
	public void setRegionDestination(
			org.apache.activemq.broker.region.Destination destination) {
		// TODO Auto-generated method stub
		super.setRegionDestination(destination);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setReplyTo(org.apache.activemq.command.ActiveMQDestination)
	 */
	@Override
	public void setReplyTo(ActiveMQDestination replyTo) {
		// TODO Auto-generated method stub
		super.setReplyTo(replyTo);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setTargetConsumerId(org.apache.activemq.command.ConsumerId)
	 */
	@Override
	public void setTargetConsumerId(ConsumerId targetConsumerId) {
		// TODO Auto-generated method stub
		super.setTargetConsumerId(targetConsumerId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setTimestamp(long)
	 */
	@Override
	public void setTimestamp(long timestamp) {
		// TODO Auto-generated method stub
		super.setTimestamp(timestamp);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setTransactionId(org.apache.activemq.command.TransactionId)
	 */
	@Override
	public void setTransactionId(TransactionId transactionId) {
		// TODO Auto-generated method stub
		super.setTransactionId(transactionId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		super.setType(type);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#setUserID(java.lang.String)
	 */
	@Override
	public void setUserID(String jmsxUserID) {
		// TODO Auto-generated method stub
		super.setUserID(jmsxUserID);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.Message#toString(java.util.Map)
	 */
	@Override
	public String toString(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		return super.toString(arg0);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#copy(org.apache.activemq.command.BaseCommand)
	 */
	@Override
	public void copy(BaseCommand copy) {
		// TODO Auto-generated method stub
		super.copy(copy);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#getCommandId()
	 */
	@Override
	public int getCommandId() {
		// TODO Auto-generated method stub
		return super.getCommandId();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#getFrom()
	 */
	@Override
	public Endpoint getFrom() {
		// TODO Auto-generated method stub
		return super.getFrom();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#getTo()
	 */
	@Override
	public Endpoint getTo() {
		// TODO Auto-generated method stub
		return super.getTo();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isBrokerInfo()
	 */
	@Override
	public boolean isBrokerInfo() {
		// TODO Auto-generated method stub
		return super.isBrokerInfo();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isConnectionControl()
	 */
	@Override
	public boolean isConnectionControl() {
		// TODO Auto-generated method stub
		return super.isConnectionControl();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isMessageAck()
	 */
	@Override
	public boolean isMessageAck() {
		// TODO Auto-generated method stub
		return super.isMessageAck();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isMessageDispatch()
	 */
	@Override
	public boolean isMessageDispatch() {
		// TODO Auto-generated method stub
		return super.isMessageDispatch();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isMessageDispatchNotification()
	 */
	@Override
	public boolean isMessageDispatchNotification() {
		// TODO Auto-generated method stub
		return super.isMessageDispatchNotification();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isResponse()
	 */
	@Override
	public boolean isResponse() {
		// TODO Auto-generated method stub
		return super.isResponse();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isResponseRequired()
	 */
	@Override
	public boolean isResponseRequired() {
		// TODO Auto-generated method stub
		return super.isResponseRequired();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isShutdownInfo()
	 */
	@Override
	public boolean isShutdownInfo() {
		// TODO Auto-generated method stub
		return super.isShutdownInfo();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#isWireFormatInfo()
	 */
	@Override
	public boolean isWireFormatInfo() {
		// TODO Auto-generated method stub
		return super.isWireFormatInfo();
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#setCommandId(int)
	 */
	@Override
	public void setCommandId(int commandId) {
		// TODO Auto-generated method stub
		super.setCommandId(commandId);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#setFrom(org.apache.activemq.command.Endpoint)
	 */
	@Override
	public void setFrom(Endpoint from) {
		// TODO Auto-generated method stub
		super.setFrom(from);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#setResponseRequired(boolean)
	 */
	@Override
	public void setResponseRequired(boolean responseRequired) {
		// TODO Auto-generated method stub
		super.setResponseRequired(responseRequired);
	}

	/* (non-Javadoc)
	 * @see org.apache.activemq.command.BaseCommand#setTo(org.apache.activemq.command.Endpoint)
	 */
	@Override
	public void setTo(Endpoint to) {
		// TODO Auto-generated method stub
		super.setTo(to);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}}
