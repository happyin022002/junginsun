/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MDM_COMMODITY.java
*@FileTitle : 사용자 관리5
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-12
*@LastModifier : Kildong_hong6
*@LastVersion : 1.0
* 2007-01-12 Kildong_hong6
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - 모든 업무에서 공통으로 사용하는 PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author Kildong_hong6
 * @since J2EE 1.4
 */
public final class MdmCommodity implements java.io.Serializable {

	private String          ibflag          = "";
	private String          page_rows       = "";
	private String          cmdt_cd         = "";
	private String          cmdt_nm         = "";
	private String          rep_imdg_lvl_cd = "";
	private String          rep_cmdt_cd     = "";
	private String          grp_cmdt_cd     = "";
	private String          cre_usr_id      = "";
	private String          cre_dt          = "";
	private String          upd_usr_id      = "";
	private String          upd_dt          = "";
	private String          delt_flg        = "";
	private String          eai_evnt_dt     = "";
	private String          chem_flg        = "";

	public MdmCommodity(){}

	public MdmCommodity(
			String          ibflag         ,
			String          page_rows      ,
			String          cmdt_cd        ,
			String          cmdt_nm        ,
			String          rep_imdg_lvl_cd,
			String          rep_cmdt_cd    ,
			String          grp_cmdt_cd    ,
			String          cre_usr_id     ,
			String          cre_dt         ,
			String          upd_usr_id     ,
			String          upd_dt         ,
			String          delt_flg       ,
			String          eai_evnt_dt    ,
			String          chem_flg        ){
		this.ibflag          = ibflag         ;
		this.page_rows       = page_rows      ;
		this.cmdt_cd         = cmdt_cd        ;
		this.cmdt_nm         = cmdt_nm        ;
		this.rep_imdg_lvl_cd = rep_imdg_lvl_cd;
		this.rep_cmdt_cd     = rep_cmdt_cd    ;
		this.grp_cmdt_cd     = grp_cmdt_cd    ;
		this.cre_usr_id      = cre_usr_id     ;
		this.cre_dt          = cre_dt         ;
		this.upd_usr_id      = upd_usr_id     ;
		this.upd_dt          = upd_dt         ;
		this.delt_flg        = delt_flg       ;
		this.eai_evnt_dt     = eai_evnt_dt    ;
		this.chem_flg        = chem_flg       ;
	}

	// getter method is proceeding ..
	public String          getIbflag         (){	return ibflag         	;	}
	public String          getPage_rows      (){	return page_rows      	;	}
	public String          getCmdt_cd        (){	return cmdt_cd        	;	}
	public String          getCmdt_nm        (){	return cmdt_nm        	;	}
	public String          getRep_imdg_lvl_cd(){	return rep_imdg_lvl_cd	;	}
	public String          getRep_cmdt_cd    (){	return rep_cmdt_cd    	;	}
	public String          getGrp_cmdt_cd    (){	return grp_cmdt_cd    	;	}
	public String          getCre_usr_id     (){	return cre_usr_id     	;	}
	public String          getCre_dt         (){	return cre_dt         	;	}
	public String          getUpd_usr_id     (){	return upd_usr_id     	;	}
	public String          getUpd_dt         (){	return upd_dt         	;	}
	public String          getDelt_flg       (){	return delt_flg       	;	}
	public String          getEai_evnt_dt    (){	return eai_evnt_dt    	;	}
	public String          getChem_flg       (){	return chem_flg     	;	}

	// setter method is proceeding ..
	public void setIbflag         ( String          ibflag          ){	this.ibflag          = ibflag         	;	}
	public void setPage_rows      ( String          page_rows       ){	this.page_rows       = page_rows      	;	}
	public void setCmdt_cd        ( String          cmdt_cd         ){	this.cmdt_cd         = cmdt_cd        	;	}
	public void setCmdt_nm        ( String          cmdt_nm         ){	this.cmdt_nm         = cmdt_nm        	;	}
	public void setRep_imdg_lvl_cd( String          rep_imdg_lvl_cd ){	this.rep_imdg_lvl_cd = rep_imdg_lvl_cd	;	}
	public void setRep_cmdt_cd    ( String          rep_cmdt_cd     ){	this.rep_cmdt_cd     = rep_cmdt_cd    	;	}
	public void setGrp_cmdt_cd    ( String          grp_cmdt_cd     ){	this.grp_cmdt_cd     = grp_cmdt_cd    	;	}
	public void setCre_usr_id     ( String          cre_usr_id      ){	this.cre_usr_id      = cre_usr_id     	;	}
	public void setCre_dt         ( String          cre_dt          ){	this.cre_dt          = cre_dt         	;	}
	public void setUpd_usr_id     ( String          upd_usr_id      ){	this.upd_usr_id      = upd_usr_id     	;	}
	public void setUpd_dt         ( String          upd_dt          ){	this.upd_dt          = upd_dt         	;	}
	public void setDelt_flg       ( String          delt_flg        ){	this.delt_flg        = delt_flg       	;	}
	public void setEai_evnt_dt    ( String          eai_evnt_dt     ){	this.eai_evnt_dt     = eai_evnt_dt    	;	}
	public void setChem_flg       ( String          chem_flg        ){	this.chem_flg        = chem_flg    	;	}

	public static MdmCommodity fromRequest(HttpServletRequest request) {
		MdmCommodity model = new MdmCommodity();
		try {
			model.setIbflag         	(JSPUtil.getParameter(request, "ibflag         		".trim(), ""));
			model.setPage_rows      	(JSPUtil.getParameter(request, "page_rows      		".trim(), ""));
			model.setCmdt_cd        	(JSPUtil.getParameter(request, "cmdt_cd        		".trim(), ""));
			model.setCmdt_nm        	(JSPUtil.getParameter(request, "cmdt_nm        		".trim(), ""));
			model.setRep_imdg_lvl_cd	(JSPUtil.getParameter(request, "rep_imdg_lvl_cd		".trim(), ""));
			model.setRep_cmdt_cd    	(JSPUtil.getParameter(request, "rep_cmdt_cd    		".trim(), ""));
			model.setGrp_cmdt_cd    	(JSPUtil.getParameter(request, "grp_cmdt_cd    		".trim(), ""));
			model.setCre_usr_id     	(JSPUtil.getParameter(request, "cre_usr_id     		".trim(), ""));
			model.setCre_dt         	(JSPUtil.getParameter(request, "cre_dt         		".trim(), ""));
			model.setUpd_usr_id     	(JSPUtil.getParameter(request, "upd_usr_id     		".trim(), ""));
			model.setUpd_dt         	(JSPUtil.getParameter(request, "upd_dt         		".trim(), ""));
			model.setDelt_flg       	(JSPUtil.getParameter(request, "delt_flg       		".trim(), ""));
			model.setEai_evnt_dt    	(JSPUtil.getParameter(request, "eai_evnt_dt    		".trim(), ""));
			model.setChem_flg       	(JSPUtil.getParameter(request, "chem_flg    		".trim(), ""));
		} catch (Exception ex) {
			//throw new Exception(ex.getMessage());
		}
		return model;
	}
	public static Collection fromRequest(HttpServletRequest request, int length) {
		MdmCommodity model = null;
		Collection models = new ArrayList();
		try {
			String[] ibflag          =  (JSPUtil.getParameter(request, "ibflag         		".trim(), length));
			String[] page_rows       =  (JSPUtil.getParameter(request, "page_rows      		".trim(), length));
			String[] cmdt_cd         =  (JSPUtil.getParameter(request, "cmdt_cd        		".trim(), length));
			String[] cmdt_nm         =  (JSPUtil.getParameter(request, "cmdt_nm        		".trim(), length));
			String[] rep_imdg_lvl_cd =  (JSPUtil.getParameter(request, "rep_imdg_lvl_cd		".trim(), length));
			String[] rep_cmdt_cd     =  (JSPUtil.getParameter(request, "rep_cmdt_cd    		".trim(), length));
			String[] grp_cmdt_cd     =  (JSPUtil.getParameter(request, "grp_cmdt_cd    		".trim(), length));
			String[] cre_usr_id      =  (JSPUtil.getParameter(request, "cre_usr_id     		".trim(), length));
			String[] cre_dt          =  (JSPUtil.getParameter(request, "cre_dt         		".trim(), length));
			String[] upd_usr_id      =  (JSPUtil.getParameter(request, "upd_usr_id     		".trim(), length));
			String[] upd_dt          =  (JSPUtil.getParameter(request, "upd_dt         		".trim(), length));
			String[] delt_flg        =  (JSPUtil.getParameter(request, "delt_flg       		".trim(), length));
			String[] eai_evnt_dt     =  (JSPUtil.getParameter(request, "eai_evnt_dt    		".trim(), length));
			String[] chem_flg        =  (JSPUtil.getParameter(request, "chem_flg    		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new MdmCommodity();
				model.setIbflag         		  (ibflag         	[i]);
				model.setPage_rows      		  (page_rows      	[i]);
				model.setCmdt_cd        		  (cmdt_cd        	[i]);
				model.setCmdt_nm        		  (cmdt_nm        	[i]);
				model.setRep_imdg_lvl_cd		  (rep_imdg_lvl_cd	[i]);
				model.setRep_cmdt_cd    		  (rep_cmdt_cd    	[i]);
				model.setGrp_cmdt_cd    		  (grp_cmdt_cd    	[i]);
				model.setCre_usr_id     		  (cre_usr_id     	[i]);
				model.setCre_dt         		  (cre_dt         	[i]);
				model.setUpd_usr_id     		  (upd_usr_id     	[i]);
				model.setUpd_dt         		  (upd_dt         	[i]);
				model.setDelt_flg       		  (delt_flg       	[i]);
				model.setEai_evnt_dt    		  (eai_evnt_dt    	[i]);
				model.setChem_flg       		  (chem_flg     	[i]);
				models.add(model);
			}
		} catch (Exception ex) {
		}
		return models;
	}
	public static Collection fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCommodity model = null;
		Collection models = new ArrayList();
		int length = request.getParameterValues("ibflag").length;
		try {
			String[] ibflag          =  (JSPUtil.getParameter(request, prefix + "ibflag         		".trim(), length));
			String[] page_rows       =  (JSPUtil.getParameter(request, prefix + "page_rows      		".trim(), length));
			String[] cmdt_cd         =  (JSPUtil.getParameter(request, prefix + "cmdt_cd        		".trim(), length));
			String[] cmdt_nm         =  (JSPUtil.getParameter(request, prefix + "cmdt_nm        		".trim(), length));
			String[] rep_imdg_lvl_cd =  (JSPUtil.getParameter(request, prefix + "rep_imdg_lvl_cd		".trim(), length));
			String[] rep_cmdt_cd     =  (JSPUtil.getParameter(request, prefix + "rep_cmdt_cd    		".trim(), length));
			String[] grp_cmdt_cd     =  (JSPUtil.getParameter(request, prefix + "grp_cmdt_cd    		".trim(), length));
			String[] cre_usr_id      =  (JSPUtil.getParameter(request, prefix + "cre_usr_id     		".trim(), length));
			String[] cre_dt          =  (JSPUtil.getParameter(request, prefix + "cre_dt         		".trim(), length));
			String[] upd_usr_id      =  (JSPUtil.getParameter(request, prefix + "upd_usr_id     		".trim(), length));
			String[] upd_dt          =  (JSPUtil.getParameter(request, prefix + "upd_dt         		".trim(), length));
			String[] delt_flg        =  (JSPUtil.getParameter(request, prefix + "delt_flg       		".trim(), length));
			String[] eai_evnt_dt     =  (JSPUtil.getParameter(request, prefix + "eai_evnt_dt    		".trim(), length));
			String[] chem_flg        =  (JSPUtil.getParameter(request, prefix + "chem_flg       		".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new MdmCommodity();
				model.setIbflag         		  ( ibflag         	[i]);
				model.setPage_rows      		  ( page_rows      	[i]);
				model.setCmdt_cd        		  ( cmdt_cd        	[i]);
				model.setCmdt_nm        		  ( cmdt_nm        	[i]);
				model.setRep_imdg_lvl_cd		  ( rep_imdg_lvl_cd	[i]);
				model.setRep_cmdt_cd    		  ( rep_cmdt_cd    	[i]);
				model.setGrp_cmdt_cd    		  ( grp_cmdt_cd    	[i]);
				model.setCre_usr_id     		  ( cre_usr_id     	[i]);
				model.setCre_dt         		  ( cre_dt         	[i]);
				model.setUpd_usr_id     		  ( upd_usr_id     	[i]);
				model.setUpd_dt         		  ( upd_dt         	[i]);
				model.setDelt_flg       		  ( delt_flg       	[i]);
				model.setEai_evnt_dt    		  ( eai_evnt_dt    	[i]);
				model.setChem_flg       		  ( chem_flg    	[i]);
				models.add(model);
			}
		} catch (Exception ex) {
		}
		return models;
	}

	// toString() method is overriding ..
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space="                              ";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr=null;
				try {
					arr = (String[]) field[i].get(this);
				}catch(Exception ex) {
					arr=new String[1];
					arr[0]=String.valueOf(field[i].get(this));
				}
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0,30).concat("= ") + arr[j] +"\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {}
		return ret.toString();
	}

}
