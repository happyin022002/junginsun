/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ComEdm001Event.java
*@FileTitle : 공통코드관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-07 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.edm.codepublish.event;

import java.util.Collection;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.COM_CODEDOMAIN;
import com.hanjin.syscommon.common.table.COM_CODEVALUE;


/**
 * UI_COM_EDM_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_COM_EDM_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SeongWook Kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComEdm001Event extends EventSupport {

	/** t_codedomain Table  Value Object */
	private COM_CODEDOMAIN tCodedomain = null;

	/** t_codedomains Multi Action을 위한 Collection */
	private Collection tCodedomains = null;

	/** t_codevalue Table  Value Object */
	private COM_CODEVALUE tCodevalue = null;

	/** t_codevalues Multi Action을 위한 Collection */
	private Collection tCodevalues = null;

	/** id 변수 (Form 객체) */
	private String id = null;

	/** codeid 변수 (Form 객체) */
	private String codeid = null;

	/** name 변수 (Form 객체) */
	private String name = null;

	/** definition 변수 (Form 객체) */
	private String definition = null;

	/** datatype 변수 (Form 객체) */
	private String datatype = null;

	/** precision 변수 (Form 객체) */
	private String precision = null;

	/** var1 변수 (Form 객체) */
	private String var1 = null;

	/** var2 변수 (Form 객체) */
	private String var2 = null;

	/** var4 변수 (Form 객체) */
	private String var4 = null;

	/** var5 변수 (Form 객체) */
	private String var5 = null;
	
	private String searchtype = null;
	
	private String selectedcodes = null;
	
	private DBRowSet dbrowset1 = null;
	
	private DBRowSet dbrowset2 = null;

	public ComEdm001Event(){}

	/**
	 * 
	 * ComEdm001Event 생성
	 * It's Constructor
	 * @param t_codedomain
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain) {
		this.tCodedomain = t_codedomain;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name, String definition) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name, String definition, String datatype) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 * @param precision
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name, String definition, String datatype, String precision) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
		this.precision = precision;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 * @param precision
	 * @param var1
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name, String definition, String datatype, String precision, String var1) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
		this.precision = precision;
		this.var1 = var1;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 * @param precision
	 * @param var1
	 * @param var2
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name, String definition, String datatype, String precision, String var1, String var2) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
		this.precision = precision;
		this.var1 = var1;
		this.var2 = var2;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 * @param precision
	 * @param var1
	 * @param var2
	 * @param var4
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name, String definition, String datatype, String precision, String var1, String var2, String var4) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
		this.precision = precision;
		this.var1 = var1;
		this.var2 = var2;
		this.var4 = var4;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 * @param precision
	 * @param var1
	 * @param var2
	 * @param var4
	 * @param var5
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name, String definition, String datatype, String precision, String var1, String var2, String var4, String var5) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
		this.precision = precision;
		this.var1 = var1;
		this.var2 = var2;
		this.var4 = var4;
		this.var5 = var5;
    }

	/**
	 * 
	 * It's Constructor
	 * @param t_codedomain
	 * @param t_codevalue
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 * @param precision
	 * @param var1
	 * @param var2
	 * @param var4
	 * @param var5
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, COM_CODEVALUE t_codevalue, String id, String codeid, String name, String definition, String datatype, String precision, String var1, String var2, String var4, String var5) {
		this.tCodedomain = t_codedomain;
		this.tCodevalue = t_codevalue;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
		this.precision = precision;
		this.var1 = var1;
		this.var2 = var2;
		this.var4 = var4;
		this.var5 = var5;
    }

	/**
	 * 
	 * It's Constructor
	 * @author 2e Consulting
	 * @param t_codedomain
	 * @param t_codedomains
	 * @param t_codevalue
	 * @param t_codevalues
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 * @param precision
	 * @param var1
	 * @param var2
	 * @param var4
	 * @param var5
	 * @param searchtype
	 * @param selectedcodes
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, Collection t_codedomains, COM_CODEVALUE t_codevalue, Collection t_codevalues, String id, String codeid, String name, String definition, String datatype, String precision, String var1, String var2, String var4, String var5,String searchtype,String selectedcodes) {
		this.tCodedomain = t_codedomain;
		this.tCodedomains = t_codedomains;
		this.tCodevalue = t_codevalue;
		this.tCodevalues = t_codevalues;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
		this.precision = precision;
		this.var1 = var1;
		this.var2 = var2;
		this.var4 = var4;
		this.var5 = var5;
		this.searchtype = searchtype;
		this.selectedcodes = selectedcodes;
    }

	/**
	 * 
	 * It's Constructor
	 * @author 2e Consulting
	 * @param t_codedomain
	 * @param t_codevalue
	 * @param id
	 * @param codeid
	 * @param name
	 * @param definition
	 * @param datatype
	 * @param precision
	 * @param var1
	 * @param var2
	 * @param var4
	 * @param var5
	 * @param searchtype
	 * @param selectedcodes
	 */
	public ComEdm001Event(COM_CODEDOMAIN t_codedomain, COM_CODEVALUE t_codevalue, String id, String codeid, String name, String definition, String datatype, String precision, String var1, String var2, String var4, String var5,String searchtype,String selectedcodes) {
		this.tCodedomain = t_codedomain;
		this.tCodevalue = t_codevalue;
		this.id = id;
		this.codeid = codeid;
		this.name = name;
		this.definition = definition;
		this.datatype = datatype;
		this.precision = precision;
		this.var1 = var1;
		this.var2 = var2;
		this.var4 = var4;
		this.var5 = var5;
		this.searchtype = searchtype;
		this.selectedcodes = selectedcodes;
    }

	/**
	 * 
	 * @author 2e Consulting
	 * @return COM_CODEDOMAIN
	 */
	public COM_CODEDOMAIN getT_CODEDOMAIN(){
		return tCodedomain;
	}
	/**
	 * 
	 * @author 2e Consulting
	 * @return Collection
	 */
	public Collection getT_CODEDOMAINS(){
		return tCodedomains;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return COM_CODEVALUE
	 */
	public COM_CODEVALUE getT_CODEVALUE(){
		return tCodevalue;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return Collection
	 */
	public Collection getT_CODEVALUES(){
		return tCodevalues;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getId(){
		return id;
	}


	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getCodeid(){
		return codeid;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getName(){
		return name;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getDefinition(){
		return definition;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getDatatype(){
		return datatype;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getPrecision(){
		return precision;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getVar1(){
		return var1;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getVar2(){
		return var2;
	}


	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getVar4(){
		return var4;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getVar5(){
		return var5;
	}

	/**
	 * 
	 */
	public String getEventName() {
		return "UI_COM_EDM_001Event";
	}

	/**
	 * 
	 */
	public String toString() {
		return "UI_COM_EDM_001Event";
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getSearchtype() {
		return searchtype;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @param searchtype void
	 */
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return String
	 */
	public String getSelectedcodes() {
		return selectedcodes;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @param selectedcodes void
	 */
	public void setSelectedcodes(String selectedcodes) {
		this.selectedcodes = selectedcodes;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return DBRowSet
	 */
	public DBRowSet getDbrowset1() {
		return dbrowset1;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @param dbrowset1 void
	 */
	public void setDbrowset1(DBRowSet dbrowset1) {
		this.dbrowset1 = dbrowset1;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @return DBRowSet
	 */
	public DBRowSet getDbrowset2() {
		return dbrowset2;
	}

	/**
	 * 
	 * @author 2e Consulting
	 * @param dbrowset2 void
	 */
	public void setDbrowset2(DBRowSet dbrowset2) {
		this.dbrowset2 = dbrowset2;
	}

}
