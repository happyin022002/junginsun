package com.hanjin.apps.alps.esd.sce.copdetailreceive.vo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

public class Actual322VO {

	private static final long serialVersionUID = 1L;
	
	private Collection<Actual322VO> models = new ArrayList<Actual322VO>();
	
	/**
	 * xml Object 정의
	 */
	private XmlObject xmlObject = null;
	
	/* Column Info */
	private DBRowSet list1 = null;
	/* Column Info */
	private DBRowSet list2 = null;
	/* Column Info */
	private DBRowSet list3 = null;
	/* Column Info */
	private DBRowSet list4 = null;
	
	public DBRowSet getList3() {
		return list3;
	}


	public void setList3(DBRowSet list3) {
		this.list3 = list3;
	}


	public DBRowSet getList4() {
		return list4;
	}


	public void setList4(DBRowSet list4) {
		this.list4 = list4;
	}
	/**
	 * Column Info
	 * @return list2
	 */
	public DBRowSet getList2() {
		return this.list2;
	}
	
	/**
	 * Column Info
	 * @return list1
	 */
	public DBRowSet getList1() {
		return this.list1;
	}
	

	/**
	 * Column Info
	 * @param list2
	 */
	public void setList2(DBRowSet list2) {
		this.list2 = list2;
	}
	
	/**
	 * Column Info
	 * @param list1
	 */
	public void setList1(DBRowSet list1) {
		this.list1 = list1;
	}


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Actual322VO() {}

	public Actual322VO(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}


	/**
	 * xmlObject 반환
	 * @return xmlObject
    */
	public XmlObject getXmlObject() {
		return xmlObject;
	}

	/**
	 * xmlObject 지정
	 * @param xmlObject 
    */
	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}	
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("list2", "list2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("list1", "list1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
}
