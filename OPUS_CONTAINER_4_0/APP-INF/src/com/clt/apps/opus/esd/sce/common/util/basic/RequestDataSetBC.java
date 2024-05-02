/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RequestDataSet.java
*@FileTitle : request의 정보를 map 형태로 저장
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-27
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-09-27 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.sce.common.util.basic;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * DataSet 클래스
 * 
 * @author Seong-mun Kang
 * @see 
 * @since J2EE 1.4
 */
public class RequestDataSetBC {

	protected transient Logger log = Logger.getLogger(super.getClass().getName());
	
	Object[]           names   = null ;
	@SuppressWarnings("rawtypes")
	HashMap            hm      = null ;
	@SuppressWarnings("rawtypes")
	ArrayList          list    = null ;
	HttpServletRequest request = null ;	
	
	/**
	 * 생성자
	 */
	@SuppressWarnings("rawtypes")
	public RequestDataSetBC(){
		this.names = new String[0] ;
		this.hm    = new HashMap() ;
		this.list  = new ArrayList() ;
	}
	
	/**
	 * 생성자
	 * 
	 * @param request HttpServletRequest
	 */
	@SuppressWarnings("rawtypes")
	public RequestDataSetBC(HttpServletRequest request){
		this.request = request ;
		this.hm      = new HashMap() ;
		this.list    = new ArrayList() ;
	}
	
	/**
	 * request에 저장되어 있는 parameter를 HashMap에 저장
	 * 
	 * @param request HttpServletRequest
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setRequestToHashMap(HttpServletRequest request){
	
		// 파라메터 저장
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
	 * RequestDataSet 객체를 생성
	 * 
	 * @param request HttpServletRequest
	 * @return dataSet RequestDataSet
	 */
	static public RequestDataSetBC getInstance(){
		RequestDataSetBC dataSet = new RequestDataSetBC() ;
		return dataSet ;
	}
	
	/**
	 * RequestDataSet 객체를 생성
	 * 
	 * @param request HttpServletRequest
	 * @return dataSet RequestDataSet
	 */
	static public RequestDataSetBC getInstance(HttpServletRequest request){
		RequestDataSetBC dataSet = new RequestDataSetBC(request) ;
		dataSet.setRequestToHashMap(request);
		return dataSet ;
	}
		
	/**
	 * RequestDataSet 객체에 값을 저장
	 * 
	 * @param Object key 
	 * @param Object value
	 */
	@SuppressWarnings("unchecked")
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
	 * RequestDataSet 객체에 값을 저장
	 * 
	 * @param Object key 
	 * @param Object value
	 */
	@SuppressWarnings("unchecked")
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
	 * HashMap에 반환
	 * 
	 * @return hm HashMap
	 */
	@SuppressWarnings("rawtypes")
	public HashMap getHashMap(){
		return this.hm ;
	}
	
	/**
	 * ArrayList에 반환
	 * 
	 * @return list ArrayList
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList getArrayList(){
		return this.list ;
	}
	
	/**
	 * name 해당하는 파라메터의 array 반환 
	 * 
	 * @param name key
	 * @return values 
	 */
	public Object[] getParameterArray(String name){
		Object[] values = (Object[])hm.get(name) ;
		return values ;
	}
	
	/**
	 * key에 해당하는 파라메터의 배열 길이 리턴 
	 * 
	 * @param name key
	 * @return length 파라메터의 배열 길이
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
	 * DataSet의 개수 
	 * 
	 * @return count DataSet의 row 개수
	 */
	public int getSize(){
		int count = 0 ;
		if(list!=null){
			count = list.size() ;
		}
		return count ;
	}
	
	/**
	 * idx에 해당하는 key명 
	 * 
	 * @param idx
	 * @return name 
	 */
	public String getName(int idx){
		String name = names!=null?names[idx].toString():"" ;
		
		return name ;
	}
	
	/**
	 * name 해당하는 Object 값 반환 
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
	 *  해당하는 name의 idx 번째 Object 값 반환 
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
	 * idx 번째 Row에 해당하는 0번째 Object 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
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
	 * rowIdx 번째 Row에 해당하는 colIdx번째 Object 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
	 * @param colIdx 배열에 저장되어 있는 index
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
	 * name 해당하는 String 값 반환 
	 * 
	 * @param name key
	 * @return value 
	 */
	public String getString(String name){
		String value  = get(name).toString() ;
		
		return value ;
	}
	
	/**
	 * idx 번째 Row에 해당하는 0번째 String 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
	 * @return value 
	 */
	public String getString(int rowIdx){
		String value = get(rowIdx).toString() ;
		
		return value ;
	}
	
	/**
	 * rowIdx 번째 Row에 해당하는 colIdx번째 String 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
	 * @param colIdx 배열에 저장되어 있는 index
	 * @return value 
	 */
	public String getString(int rowIdx, int colIdx){
		String value = get(rowIdx, colIdx).toString() ;
		
		return value ;
	}
	
	/**
	 *  해당하는 name의 idx 번째 String 값 반환 
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
	 * name 해당하는 int 값 반환 
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
	 *  해당하는 name의 idx 번째 int 값 반환 
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
	 * idx 번째 Row에 해당하는 0번째 int 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
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
	 * rowIdx 번째 Row에 해당하는 colIdx번째 int 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
	 * @param colIdx 배열에 저장되어 있는 index
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
	 * name 해당하는 long 값 반환 
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
	 *  해당하는 name의 idx 번째 long 값 반환 
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
	 * idx 번째 Row에 해당하는 0번째 long 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
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
	 * rowIdx 번째 Row에 해당하는 colIdx번째 long 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
	 * @param colIdx 배열에 저장되어 있는 index
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
	 * name 해당하는 float 값 반환 
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
	 *  해당하는 name의 idx 번째 float 값 반환 
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
	 * idx 번째 Row에 해당하는 0번째 float 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
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
	 * rowIdx 번째 Row에 해당하는 colIdx번째 float 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
	 * @param colIdx 배열에 저장되어 있는 index
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
	 * name 해당하는 double 값 반환 
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
	 *  해당하는 name의 idx 번째 double 값 반환 
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
	 * idx 번째 Row에 해당하는 0번째 double 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
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
	 * rowIdx 번째 Row에 해당하는 colIdx번째 double 값 반환 
	 * 
	 * @param rowIdx ArrayList에 저장되어 있는 index
	 * @param colIdx 배열에 저장되어 있는 index
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
