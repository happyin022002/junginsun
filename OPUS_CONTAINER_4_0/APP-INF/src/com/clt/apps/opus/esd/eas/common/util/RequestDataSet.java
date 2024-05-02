/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RequestDataSet.java
*@FileTitle : request의 정보를 map 형태로 저장
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/

package com.clt.apps.opus.esd.eas.common.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * DataSet Class
 * @see 
 * @since J2EE 1.4
 */
public class RequestDataSet extends BasicCommandSupport{
	Object[]           names   = null ;
	HashMap            hm      = null ;
	ArrayList          list    = null ;
	HttpServletRequest request = null ;	
	
	/**
	 * creater
	 */
	public RequestDataSet(){
		this.names = new String[0] ;
		this.hm    = new HashMap() ;
		this.list  = new ArrayList() ;
	}
	
	/**
	 * creater
	 * 
	 * @param request HttpServletRequest
	 */
	public RequestDataSet(HttpServletRequest request){
		this.request = request ;
		this.hm      = new HashMap() ;
		this.list    = new ArrayList() ;
	}
	
	/**
	 * request parameter to save HashMap
	 * 
	 * @param request HttpServletRequest
	 */
	public void setRequestToHashMap(HttpServletRequest request){
	
		
		Enumeration paramNames  = request.getParameterNames() ;
		String      paramName   = null ;
		String[]    paramValues = null ;
		
		int cnt = 0;
		
		for(cnt=0; paramNames.hasMoreElements(); cnt++){
			paramName  = paramNames.nextElement().toString() ;
			paramValues = request.getParameterValues(paramName) ;
			if(paramValues==null){
				paramValues = new String[1] ;
				paramValues[0] = "" ;
			}
			
			hm.put(paramName, paramValues);
			list.add(cnt, paramValues) ;
		}
		
		names = new Object[cnt] ;
		paramNames = request.getParameterNames() ; 
		for(int i=0; paramNames.hasMoreElements(); i++){
			names[i] = paramNames.nextElement() ;
		}
	}
	
	/**
	 * RequestDataSet create object
	 * 
	 * @param request HttpServletRequest
	 * @return dataSet RequestDataSet
	 */
	static public RequestDataSet getInstance(){
		RequestDataSet dataSet = new RequestDataSet() ;
		return dataSet ;
	}
	
	/**
	 * RequestDataSet create object
	 * 
	 * @param request HttpServletRequest
	 * @return dataSet RequestDataSet
	 */
	static public RequestDataSet getInstance(HttpServletRequest request){
		RequestDataSet dataSet = new RequestDataSet(request) ;
		dataSet.setRequestToHashMap(request);
		return dataSet ;
	}
		
	/**
	 * RequestDataSet save value in the object 
	 * 
	 * @param Object key
	 * @param Object value 
	 */
	public void put(Object key, Object value){
		Object removeValue = hm.remove(key) ;
		
		Object[] values   = new Object[1] ;
		Object[] addNames = new Object[names.length+1] ;
		values[0] = value ;
		
		hm.put(key, values) ;
		
		if(removeValue!=null){
			for(int i=0; i<names.length; i++){
				if(names[i].equals(key)){
					list.set(i,values) ;
					break ;
				}
			}
		}
		else{
			for(int i=0; i<addNames.length; i++){
				if(i<addNames.length-1){
					addNames[i] = names[i] ;
				}
				else {
					addNames[i] = key ;
				}
			}
			
			list.add(values) ;
			names = addNames ;
		}
	}
	
	
	/**
	 * RequestDataSet save value in the object
	 * 
	 * @param Object key 
	 * @param Object value
	 */
	public void add(Object key, Object value){
		
		Object[] values = (Object[])hm.get(key) ;
		int      cnt     = values==null ? 0 : values.length ;
		
		if(cnt>0){
			Object[] addValues = new Object[cnt + 1] ;
			
			int i = 0 ;
			for(i=0 ; i<cnt; i++){
				addValues[i] = values[i] ;
			}
			
			addValues[i] = value ;
			
			hm.put(key, addValues) ;
			
			for(i=0; i<list.size(); i++){
				if(values.equals(list.get(i))){
					list.set(i, addValues) ;
					break ;
				}
			}
		}
		else{
			Object[] addNames = new Object[names.length+1] ;
			values = new Object[1] ;
			values[0] = value ;
			
			for(int i=0; i<addNames.length; i++){
				if(i<addNames.length-1){
					addNames[i] = names[i] ;
				}
				else {
					addNames[i] = key ;
				}
			}
			
			names = addNames ;
			hm.put(key, values) ;
			list.add(values) ;
		}
	}
	
	/**
	 * Return to HashMap
	 * 
	 * @return hm HashMap
	 */
	public HashMap getHashMap(){
		return this.hm ;
	}
	
	/**
	 * Return to ArrayList
	 * 
	 * @return list ArrayList
	 */
	public ArrayList getArrayList(){
		return this.list ;
	}
	
	/**
	 * Return Array  
	 * 
	 * @param name key
	 * @return values 
	 */
	public Object[] getParameterArray(String name){
		Object[] values = (Object[])hm.get(name) ;
		return values ;
	}
	
	/**
	 * Return length of Parameter 
	 * 
	 * @param name key
	 * @return length of Parameter 
	 */
	public int getParameterLength(String name){
		Object[] values = (Object[])hm.get(name) ;

		if(values==null){
			return 0 ;
		}
		else{ 
			return values.length ;
		}
	}
	
	/**
	 * Count of DataSet
	 * 
	 * @return row count of DataSet의 row Count
	 */
	public int getSize(){
		int count = 0 ;
		if(list!=null){
			count = list.size() ;
		}
		return count ;
	}
	
	/**
	 * key index
	 * 
	 * @param idx
	 * @return String name 
	 */
	public String getName(int idx){
		String name = names!=null?names[idx].toString():"" ;
		
		return name ;
	}
	
	/**
	 * return name  
	 * 
	 * @param name key
	 * @return value 
	 */
	public Object get(String name){
		Object   value  = null ;
		Object[] values = (Object[])hm.get(name) ;

		
		if(values==null || values.length==0){
			value = "" ;
		}
		else {
			value = values[0] ;
		}
		
		return value ;
	}
	
	/**
	 *  return  name and index
	 * 
	 * @param name key
	 * @param idx 
	 * @return value 
	 */
	public Object get(String name, int idx){
		Object   value  = null ;
		Object[] values = (Object[])hm.get(name) ;
		
		if(values==null || values.length-1<idx){
			value = "" ;
		}
		else {
			value = values[idx] ;
		}
		
		return value ;
	}
	
	/**
	 * Return first Object value of Row index 
	 * 
	 * @param rowIdx ArrayList index
	 * @return value 
	 */
	public Object get(int rowIdx){
		Object   value  = null ;
		Object[] values = (Object[])list.get(rowIdx) ;

		
		if(values==null || values.length==0){
			value = "" ;
		}
		else {
			value = values[0] ;
		}
		
		return value ;
	}
	
	/**
	 * Return rowIdx Object value of colIdx Row
	 * 
	 * @param rowIdx ArrayList
	 * @param colIdx index
	 * @return value 
	 */
	public Object get(int rowIdx, int colIdx){
		Object   value  = null ;
		Object[] values = (Object[])list.get(rowIdx) ;
		
		if(values==null || values.length-1<colIdx){
			value = "" ;
		}
		else {
			value = values[colIdx] ;
		}
		
		return value ;
	}
	
	/**
	 * return name
	 * 
	 * @param name key
	 * @return value 
	 */
	public String getString(String name){
		String value  = get(name).toString() ;
		
		return value ;
	}
	
	/**
	 * Return first Object value of Row index 
	 * 
	 * @param rowIdx ArrayList 
	 * @return value 
	 */
	public String getString(int rowIdx){
		String value = get(rowIdx).toString() ;
		
		return value ;
	}
	
	/**
	 * Return rowIdx Object value of colIdx Row 
	 * 
	 * @param rowIdx ArrayList
	 * @param colIdx 
	 * @return value 
	 */
	public String getString(int rowIdx, int colIdx){
		String value = get(rowIdx, colIdx).toString() ;
		
		return value ;
	}
	
	/**
	 *  return name of idx
	 * 
	 * @param name key
	 * @param idx 
	 * @return value 
	 */
	public String getString(String name, int idx){
		String value  = get(name,idx).toString() ;
		
		return value ;
	}
	
	/**
	 * return name 
	 * 
	 * @param name key 
	 * @return value 
	 */
	public int getInt(String name){
		int    value    = 0 ;
		String strValue = getString(name) ;
		
		//20070109;NumberFormatException("For input string: "")에러 때문에 추가
		if(strValue==null || strValue.equals("")){
			strValue = "-1";
		}
		try{
			value = Integer.parseInt(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 *  return int type value of idx th name 
	 * 
	 * @param name key
	 * @param idx 
	 * @return value 
	 */
	public int getInt(String name, int idx){
		int    value    = 0 ;
		String strValue = getString(name, idx) ;
		try{
			value = Integer.parseInt(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * return first int type value of idx th Row
	 * 
	 * @param rowIdx ArrayList
	 * @return value 
	 */
	public int getInt(int rowIdx){
		int    value    = 0 ;
		String strValue = getString(rowIdx) ;
		try{
			value = Integer.parseInt(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * return colIdx th int type value of rowIdx th Row 
	 * 
	 * @param rowIdx ArrayList
	 * @param colIdx index
	 * @return value 
	 */
	public int getInt(int rowIdx, int colIdx){
		int    value    = 0 ;
		String strValue = getString(rowIdx, colIdx) ;
		try{
			value = Integer.parseInt(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * return long type value of name
	 * 
	 * @param name key
	 * @return value 
	 */
	public long getLong(String name){
		long   value    = 0 ;
		String strValue = getString(name) ;
		try{
			value = Long.parseLong(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 *  return idx th long type value of name 
	 * 
	 * @param name key
	 * @param idx 
	 * @return value 
	 */
	public long getLong(String name, int idx){
		long   value    = 0 ;
		String strValue = getString(name,idx) ;
		try{
			value = Long.parseLong(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * Return first long type value of idx th Row 
	 * 
	 * @param rowIdx ArrayList
	 * @return value 
	 */
	public long getLong(int rowIdx){
		long   value    = 0 ;
		String strValue = getString(rowIdx) ;
		try{
			value = Long.parseLong(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * Return colIdx th long type value of rowIdx th Row   rowIdx 번째 Row에 해당하는 colIdx번째 long 값 반환 
	 * 
	 * @param rowIdx ArrayList
	 * @param colIdx 
	 * @return value 
	 */
	public long getLong(int rowIdx, int colIdx){
		long   value    = 0 ;
		String strValue = getString(rowIdx, colIdx) ;
		try{
			value = Long.parseLong(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * Return float type value of name 
	 * 
	 * @param name key
	 * @return value 
	 */
	public float getFloat(String name){
		float  value    = 0 ;
		String strValue = getString(name) ;
		try{
			value = Float.parseFloat(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 *  Return idx th float type value of name
	 * 
	 * @param name key
	 * @param idx 
	 * @return value 
	 */
	public float getFloat(String name, int idx){
		float value     = 0 ;
		String strValue = getString(name,idx) ;
		try{
			value = Float.parseFloat(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * Return first float type value of idx th Row
	 * 
	 * @param rowIdx ArrayList
	 * @return value 
	 */
	public float getFloat(int rowIdx){
		float  value    = 0 ;
		String strValue = getString(rowIdx) ;
		try{
			value = Float.parseFloat(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * Return colIdx th float type value of rowIdx th Row 
	 * 
	 * @param rowIdx ArrayList
	 * @param colIdx
	 * @return value 
	 */
	public float getFloat(int rowIdx, int colIdx){
		float  value    = 0 ;
		String strValue = getString(rowIdx, colIdx) ;
		try{
			value = Float.parseFloat(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	
	/**
	 * Return double type value of name 
	 * 
	 * @param name key
	 * @return value 
	 */
	public double getDouble(String name){
		double  value    = 0 ;
		String  strValue = getString(name) ;
		try{
			value = Double.parseDouble(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 *  Return idx th double type value of name 
	 * 
	 * @param name key
	 * @param idx 
	 * @return value 
	 */
	public double getDouble(String name, int idx){
		double  value    = 0 ;
		String  strValue = getString(name,idx) ;
		try{
			value = Double.parseDouble(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * Return first double type value of  idx th Row
	 * 
	 * @param rowIdx ArrayList
	 * @return value 
	 */
	public double getDouble(int rowIdx){
		double value    = 0 ;
		String strValue = getString(rowIdx) ;
		try{
			value = Double.parseDouble(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
	
	/**
	 * Return colIdx th double type value of rowIdx th Row
	 * 
	 * @param rowIdx ArrayList
	 * @param colIdx
	 * @return value 
	 */
	public double getDouble(int rowIdx, int colIdx){
		double value    = 0 ;
		String strValue = getString(rowIdx, colIdx) ;
		try{
			value = Double.parseDouble(strValue) ;
		}catch(NumberFormatException e){
			value = -1 ;
			log.error(e.getMessage(), e) ;
		}
		
		return value ;
	}
}
