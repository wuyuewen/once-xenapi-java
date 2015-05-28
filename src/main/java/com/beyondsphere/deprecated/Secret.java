package com.beyondsphere.deprecated;
///*
// * Copyright (c) Citrix Systems, Inc.
// *
// * This library is free software; you can redistribute it and/or modify it
// * under the terms of version 2 of the GNU General Public License as published
// * by the Free Software Foundation, with the additional linking exception as
// * follows:
// * 
// *   Linking this library statically or dynamically with other modules is
// *   making a combined work based on this library. Thus, the terms and
// *   conditions of the GNU General Public License cover the whole combination.
// * 
// *   As a special exception, the copyright holders of this library give you
// *   permission to link this library with independent modules to produce an
// *   executable, regardless of the license terms of these independent modules,
// *   and to copy and distribute the resulting executable under terms of your
// *   choice, provided that you also meet, for each linked independent module,
// *   the terms and conditions of the license of that module. An independent
// *   module is a module which is not derived from or based on this library. If
// *   you modify this library, you may extend this exception to your version of
// *   the library, but you are not obligated to do so. If you do not wish to do
// *   so, delete this exception statement from your version.
// * 
// * This program is distributed in the hope that it will be useful, but WITHOUT
// * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
// * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
// * more details.
// * 
// * You should have received a copy of the GNU General Public License along
// * with this program; if not, write to the Free Software Foundation, Inc., 51
// * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
// */
//
//package com.once.xenapi;
//
//import com.once.xenapi.Types.BadServerResponse;
//import com.once.xenapi.Types.VersionException;
//import com.once.xenapi.Types.XenAPIException;
//
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashSet;
//import java.util.Map;
//import java.util.Set;
//
//import org.apache.xmlrpc.XmlRpcException;
//
///**
// * A secret
// *
// * @author Citrix Systems, Inc.
// */
//public class Secret extends XenAPIObject {
//
//    /**
//     * The XenAPI reference to this object.
//     */
//    protected final String ref;
//
//    /**
//     * For internal use only.
//     */
//    Secret(String ref) {
//       this.ref = ref;
//    }
//
//    public String toWireString() {
//       return this.ref;
//    }
//
//    /**
//     * If obj is a Secret, compares XenAPI references for equality.
//     */
//    @Override
//    public boolean equals(Object obj)
//    {
//        if (obj != null && obj instanceof Secret)
//        {
//            Secret other = (Secret) obj;
//            return other.ref.equals(this.ref);
//        } else
//        {
//            return false;
//        }
//    }
//
//    @Override
//    public int hashCode()
//    {
//        return ref.hashCode();
//    }
//
//    /**
//     * Represents all the fields in a Secret
//     */
//    public static class Record implements Types.Record {
//        public String toString() {
//            StringWriter writer = new StringWriter();
//            PrintWriter print = new PrintWriter(writer);
//            print.printf("%1$20s: %2$s\n", "uuid", this.uuid);
//            print.printf("%1$20s: %2$s\n", "value", this.value);
//            print.printf("%1$20s: %2$s\n", "otherConfig", this.otherConfig);
//            return writer.toString();
//        }
//
//        /**
//         * Convert a secret.Record to a Map
//         */
//        public Map<String,Object> toMap() {
//            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("uuid", this.uuid == null ? "" : this.uuid);
//            map.put("value", this.value == null ? "" : this.value);
//            map.put("other_config", this.otherConfig == null ? new HashMap<String, String>() : this.otherConfig);
//            return map;
//        }
//
//        /**
//         * Unique identifier/object reference
//         */
//        public String uuid;
//        /**
//         * the secret
//         */
//        public String value;
//        /**
//         * other_config
//         */
//        public Map<String, String> otherConfig;
//    }
//
//    /**
//     * Get a record containing the current state of the given secret.
//     *
//     * @return all fields from the object
//     */
//    public Secret.Record getRecord(Connection c) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.get_record";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//            return Types.toSecretRecord(result);
//    }
//
//    /**
//     * Get a reference to the secret instance with the specified UUID.
//     *
//     * @param uuid UUID of object to return
//     * @return reference to the object
//     */
//    public static Secret getByUuid(Connection c, String uuid) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.get_by_uuid";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(uuid)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//            return Types.toSecret(result);
//    }
//
//    /**
//     * Create a new secret instance, and return its handle.
//     *
//     * @param record All constructor arguments
//     * @return Task
//     */
//    public static Task createAsync(Connection c, Secret.Record record) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "Async.secret.create";
//        String session = c.getSessionReference();
//        Map<String, Object> record_map = record.toMap();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(record_map)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//        return Types.toTask(result);
//    }
//
//    /**
//     * Create a new secret instance, and return its handle.
//     *
//     * @param record All constructor arguments
//     * @return reference to the newly created object
//     */
//    public static Secret create(Connection c, Secret.Record record) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.create";
//        String session = c.getSessionReference();
//        Map<String, Object> record_map = record.toMap();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(record_map)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//            return Types.toSecret(result);
//    }
//
//    /**
//     * Destroy the specified secret instance.
//     *
//     * @return Task
//     */
//    public Task destroyAsync(Connection c) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "Async.secret.destroy";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//        return Types.toTask(result);
//    }
//
//    /**
//     * Destroy the specified secret instance.
//     *
//     */
//    public void destroy(Connection c) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.destroy";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
//        Map response = c.dispatch(method_call, method_params);
//        return;
//    }
//
//    /**
//     * Get the uuid field of the given secret.
//     *
//     * @return value of the field
//     */
//    public String getUuid(Connection c) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.get_uuid";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//            return Types.toString(result);
//    }
//
//    /**
//     * Get the value field of the given secret.
//     *
//     * @return value of the field
//     */
//    public String getValue(Connection c) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.get_value";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//            return Types.toString(result);
//    }
//
//    /**
//     * Get the other_config field of the given secret.
//     *
//     * @return value of the field
//     */
//    public Map<String, String> getOtherConfig(Connection c) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.get_other_config";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//            return Types.toMapOfStringString(result);
//    }
//
//    /**
//     * Set the value field of the given secret.
//     *
//     * @param value New value to set
//     */
//    public void setValue(Connection c, String value) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.set_value";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(value)};
//        Map response = c.dispatch(method_call, method_params);
//        return;
//    }
//
//    /**
//     * Set the other_config field of the given secret.
//     *
//     * @param otherConfig New value to set
//     */
//    public void setOtherConfig(Connection c, Map<String, String> otherConfig) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.set_other_config";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(otherConfig)};
//        Map response = c.dispatch(method_call, method_params);
//        return;
//    }
//
//    /**
//     * Add the given key-value pair to the other_config field of the given secret.
//     *
//     * @param key Key to add
//     * @param value Value to add
//     */
//    public void addToOtherConfig(Connection c, String key, String value) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.add_to_other_config";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(key), Marshalling.toXMLRPC(value)};
//        Map response = c.dispatch(method_call, method_params);
//        return;
//    }
//
//    /**
//     * Remove the given key and its corresponding value from the other_config field of the given secret.  If the key is not in that Map, then do nothing.
//     *
//     * @param key Key to remove
//     */
//    public void removeFromOtherConfig(Connection c, String key) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.remove_from_other_config";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session), Marshalling.toXMLRPC(this.ref), Marshalling.toXMLRPC(key)};
//        Map response = c.dispatch(method_call, method_params);
//        return;
//    }
//
//    /**
//     * Return a list of all the secrets known to the system.
//     *
//     * @return references to all objects
//     */
//    public static Set<Secret> getAll(Connection c) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.get_all";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//            return Types.toSetOfSecret(result);
//    }
//
//    /**
//     * Return a map of secret references to secret records for all secrets known to the system.
//     *
//     * @return records of all objects
//     */
//    public static Map<Secret, Secret.Record> getAllRecords(Connection c) throws
//       BadServerResponse,
//       XenAPIException,
//       XmlRpcException {
//        String method_call = "secret.get_all_records";
//        String session = c.getSessionReference();
//        Object[] method_params = {Marshalling.toXMLRPC(session)};
//        Map response = c.dispatch(method_call, method_params);
//        Object result = response.get("Value");
//            return Types.toMapOfSecretSecretRecord(result);
//    }
//
//}