/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MDM_CUST_ADDR.java
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
public final class MdmCustAddr implements java.io.Serializable {

	private String        ibflag        = "";
	private String        page_rows     = "";
	private String        cust_cnt_cd   = "";
	private String        cust_seq      = "";
	private String        addr_tp_cd    = "";
	private String        addr_seq      = "";
	private String        prmry_chk_flg = "";
	private String        bzet_nm       = "";
	private String        bzet_addr     = "";
	private String        cty_nm        = "";
	private String        ste_cd        = "";
	private String        zip_cd        = "";
	private String        cntc_eml      = "";
	private String        cntc_pson_nm  = "";
	private String        bzet_rmk      = "";
	private String        cre_usr_id    = "";
	private String        cre_dt        = "";
	private String        upd_usr_id    = "";
	private String        upd_dt        = "";
	private String        delt_flg      = "";
	private String        eai_evnt_dt   = "";
	private String 		  crm_row_id	= ""; 

	public MdmCustAddr(){}

	public MdmCustAddr(
			String        ibflag       ,
			String        page_rows    ,
			String        cust_cnt_cd  ,
			String        cust_seq     ,
			String        addr_tp_cd   ,
			String        addr_seq     ,
			String        prmry_chk_flg,
			String        bzet_nm      ,
			String        bzet_addr    ,
			String        cty_nm       ,
			String        ste_cd       ,
			String        zip_cd       ,
			String        cntc_eml     ,
			String        cntc_pson_nm ,
			String        bzet_rmk     ,
			String        cre_usr_id   ,
			String        cre_dt       ,
			String        upd_usr_id   ,
			String        upd_dt       ,
			String        delt_flg     ,
			String        eai_evnt_dt  ,
			String		  crm_row_id){
		this.ibflag        = ibflag       ;
		this.page_rows     = page_rows    ;
		this.cust_cnt_cd   = cust_cnt_cd  ;
		this.cust_seq      = cust_seq     ;
		this.addr_tp_cd    = addr_tp_cd   ;
		this.addr_seq      = addr_seq     ;
		this.prmry_chk_flg = prmry_chk_flg;
		this.bzet_nm       = bzet_nm      ;
		this.bzet_addr     = bzet_addr    ;
		this.cty_nm        = cty_nm       ;
		this.ste_cd        = ste_cd       ;
		this.zip_cd        = zip_cd       ;
		this.cntc_eml      = cntc_eml     ;
		this.cntc_pson_nm  = cntc_pson_nm ;
		this.bzet_rmk      = bzet_rmk     ;
		this.cre_usr_id    = cre_usr_id   ;
		this.cre_dt        = cre_dt       ;
		this.upd_usr_id    = upd_usr_id   ;
		this.upd_dt        = upd_dt       ;
		this.delt_flg      = delt_flg     ;
		this.eai_evnt_dt   = eai_evnt_dt  ;
		this.crm_row_id    = crm_row_id	  ;
	}

	// getter method is proceeding ..
	public String        getIbflag       (){	return ibflag       	;	}
	public String        getPage_rows    (){	return page_rows    	;	}
	public String        getCust_cnt_cd  (){	return cust_cnt_cd  	;	}
	public String        getCust_seq     (){	return cust_seq     	;	}
	public String        getAddr_tp_cd   (){	return addr_tp_cd   	;	}
	public String        getAddr_seq     (){	return addr_seq     	;	}
	public String        getPrmry_chk_flg(){	return prmry_chk_flg	;	}
	public String        getBzet_nm      (){	return bzet_nm      	;	}
	public String        getBzet_addr    (){	return bzet_addr    	;	}
	public String        getCty_nm       (){	return cty_nm       	;	}
	public String        getSte_cd       (){	return ste_cd       	;	}
	public String        getZip_cd       (){	return zip_cd       	;	}
	public String        getCntc_eml     (){	return cntc_eml     	;	}
	public String        getCntc_pson_nm (){	return cntc_pson_nm 	;	}
	public String        getBzet_rmk     (){	return bzet_rmk     	;	}
	public String        getCre_usr_id   (){	return cre_usr_id   	;	}
	public String        getCre_dt       (){	return cre_dt       	;	}
	public String        getUpd_usr_id   (){	return upd_usr_id   	;	}
	public String        getUpd_dt       (){	return upd_dt       	;	}
	public String        getDelt_flg     (){	return delt_flg     	;	}
	public String        getEai_evnt_dt  (){	return eai_evnt_dt  	;	}
	public String		 getCrm_row_id	 (){	return crm_row_id		;	}

	// setter method is proceeding ..
	public void setIbflag       ( String        ibflag        ){	this.ibflag        = ibflag       	;	}
	public void setPage_rows    ( String        page_rows     ){	this.page_rows     = page_rows    	;	}
	public void setCust_cnt_cd  ( String        cust_cnt_cd   ){	this.cust_cnt_cd   = cust_cnt_cd  	;	}
	public void setCust_seq     ( String        cust_seq      ){	this.cust_seq      = cust_seq     	;	}
	public void setAddr_tp_cd   ( String        addr_tp_cd    ){	this.addr_tp_cd    = addr_tp_cd   	;	}
	public void setAddr_seq     ( String        addr_seq      ){	this.addr_seq      = addr_seq     	;	}
	public void setPrmry_chk_flg( String        prmry_chk_flg ){	this.prmry_chk_flg = prmry_chk_flg	;	}
	public void setBzet_nm      ( String        bzet_nm       ){	this.bzet_nm       = bzet_nm      	;	}
	public void setBzet_addr    ( String        bzet_addr     ){	this.bzet_addr     = bzet_addr    	;	}
	public void setCty_nm       ( String        cty_nm        ){	this.cty_nm        = cty_nm       	;	}
	public void setSte_cd       ( String        ste_cd        ){	this.ste_cd        = ste_cd       	;	}
	public void setZip_cd       ( String        zip_cd        ){	this.zip_cd        = zip_cd       	;	}
	public void setCntc_eml     ( String        cntc_eml      ){	this.cntc_eml      = cntc_eml     	;	}
	public void setCntc_pson_nm ( String        cntc_pson_nm  ){	this.cntc_pson_nm  = cntc_pson_nm 	;	}
	public void setBzet_rmk     ( String        bzet_rmk      ){	this.bzet_rmk      = bzet_rmk     	;	}
	public void setCre_usr_id   ( String        cre_usr_id    ){	this.cre_usr_id    = cre_usr_id   	;	}
	public void setCre_dt       ( String        cre_dt        ){	this.cre_dt        = cre_dt       	;	}
	public void setUpd_usr_id   ( String        upd_usr_id    ){	this.upd_usr_id    = upd_usr_id   	;	}
	public void setUpd_dt       ( String        upd_dt        ){	this.upd_dt        = upd_dt       	;	}
	public void setDelt_flg     ( String        delt_flg      ){	this.delt_flg      = delt_flg     	;	}
	public void setEai_evnt_dt  ( String        eai_evnt_dt   ){	this.eai_evnt_dt   = eai_evnt_dt  	;	}
	public void setCrm_row_id	( String		crm_row_id	  ){	this.crm_row_id	   = crm_row_id		;	}

	public static MdmCustAddr fromRequest(HttpServletRequest request) {
		MdmCustAddr model = new MdmCustAddr();
		try {
			model.setIbflag       	(JSPUtil.getParameter(request, "ibflag       		".trim(), ""));
			model.setPage_rows    	(JSPUtil.getParameter(request, "page_rows    		".trim(), ""));
			model.setCust_cnt_cd  	(JSPUtil.getParameter(request, "cust_cnt_cd  		".trim(), ""));
			model.setCust_seq     	(JSPUtil.getParameter(request, "cust_seq     		".trim(), ""));
			model.setAddr_tp_cd   	(JSPUtil.getParameter(request, "addr_tp_cd   		".trim(), ""));
			model.setAddr_seq     	(JSPUtil.getParameter(request, "addr_seq     		".trim(), ""));
			model.setPrmry_chk_flg	(JSPUtil.getParameter(request, "prmry_chk_flg		".trim(), ""));
			model.setBzet_nm      	(JSPUtil.getParameter(request, "bzet_nm      		".trim(), ""));
			model.setBzet_addr    	(JSPUtil.getParameter(request, "bzet_addr    		".trim(), ""));
			model.setCty_nm       	(JSPUtil.getParameter(request, "cty_nm       		".trim(), ""));
			model.setSte_cd       	(JSPUtil.getParameter(request, "ste_cd       		".trim(), ""));
			model.setZip_cd       	(JSPUtil.getParameter(request, "zip_cd       		".trim(), ""));
			model.setCntc_eml     	(JSPUtil.getParameter(request, "cntc_eml     		".trim(), ""));
			model.setCntc_pson_nm 	(JSPUtil.getParameter(request, "cntc_pson_nm 		".trim(), ""));
			model.setBzet_rmk     	(JSPUtil.getParameter(request, "bzet_rmk     		".trim(), ""));
			model.setCre_usr_id   	(JSPUtil.getParameter(request, "cre_usr_id   		".trim(), ""));
			model.setCre_dt       	(JSPUtil.getParameter(request, "cre_dt       		".trim(), ""));
			model.setUpd_usr_id   	(JSPUtil.getParameter(request, "upd_usr_id   		".trim(), ""));
			model.setUpd_dt       	(JSPUtil.getParameter(request, "upd_dt       		".trim(), ""));
			model.setDelt_flg     	(JSPUtil.getParameter(request, "delt_flg     		".trim(), ""));
			model.setEai_evnt_dt  	(JSPUtil.getParameter(request, "eai_evnt_dt  		".trim(), ""));
			model.setCrm_row_id		(JSPUtil.getParameter(request, "crm_row_id          ".trim(), ""));	
		} catch (Exception ex) {
			//throw new Exception(ex.getMessage());
		}
		return model;
	}
	public static Collection fromRequest(HttpServletRequest request, int length) {
		MdmCustAddr model = null;
		Collection models = new ArrayList();
		try {
			String[] ibflag        =  (JSPUtil.getParameter(request, "ibflag       		".trim(), length));
			String[] page_rows     =  (JSPUtil.getParameter(request, "page_rows    		".trim(), length));
			String[] cust_cnt_cd   =  (JSPUtil.getParameter(request, "cust_cnt_cd  		".trim(), length));
			String[] cust_seq      =  (JSPUtil.getParameter(request, "cust_seq     		".trim(), length));
			String[] addr_tp_cd    =  (JSPUtil.getParameter(request, "addr_tp_cd   		".trim(), length));
			String[] addr_seq      =  (JSPUtil.getParameter(request, "addr_seq     		".trim(), length));
			String[] prmry_chk_flg =  (JSPUtil.getParameter(request, "prmry_chk_flg		".trim(), length));
			String[] bzet_nm       =  (JSPUtil.getParameter(request, "bzet_nm      		".trim(), length));
			String[] bzet_addr     =  (JSPUtil.getParameter(request, "bzet_addr    		".trim(), length));
			String[] cty_nm        =  (JSPUtil.getParameter(request, "cty_nm       		".trim(), length));
			String[] ste_cd        =  (JSPUtil.getParameter(request, "ste_cd       		".trim(), length));
			String[] zip_cd        =  (JSPUtil.getParameter(request, "zip_cd       		".trim(), length));
			String[] cntc_eml      =  (JSPUtil.getParameter(request, "cntc_eml     		".trim(), length));
			String[] cntc_pson_nm  =  (JSPUtil.getParameter(request, "cntc_pson_nm 		".trim(), length));
			String[] bzet_rmk      =  (JSPUtil.getParameter(request, "bzet_rmk     		".trim(), length));
			String[] cre_usr_id    =  (JSPUtil.getParameter(request, "cre_usr_id   		".trim(), length));
			String[] cre_dt        =  (JSPUtil.getParameter(request, "cre_dt       		".trim(), length));
			String[] upd_usr_id    =  (JSPUtil.getParameter(request, "upd_usr_id   		".trim(), length));
			String[] upd_dt        =  (JSPUtil.getParameter(request, "upd_dt       		".trim(), length));
			String[] delt_flg      =  (JSPUtil.getParameter(request, "delt_flg     		".trim(), length));
			String[] eai_evnt_dt   =  (JSPUtil.getParameter(request, "eai_evnt_dt  		".trim(), length));
			String[] crm_row_id	   =  (JSPUtil.getParameter(request, "crm_row_id        ".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new MdmCustAddr();
				model.setIbflag       		  (ibflag       	[i]);
				model.setPage_rows    		  (page_rows    	[i]);
				model.setCust_cnt_cd  		  (cust_cnt_cd  	[i]);
				model.setCust_seq     		  (cust_seq     	[i]);
				model.setAddr_tp_cd   		  (addr_tp_cd   	[i]);
				model.setAddr_seq     		  (addr_seq     	[i]);
				model.setPrmry_chk_flg		  (prmry_chk_flg	[i]);
				model.setBzet_nm      		  (bzet_nm      	[i]);
				model.setBzet_addr    		  (bzet_addr    	[i]);
				model.setCty_nm       		  (cty_nm       	[i]);
				model.setSte_cd       		  (ste_cd       	[i]);
				model.setZip_cd       		  (zip_cd       	[i]);
				model.setCntc_eml     		  (cntc_eml     	[i]);
				model.setCntc_pson_nm 		  (cntc_pson_nm 	[i]);
				model.setBzet_rmk     		  (bzet_rmk     	[i]);
				model.setCre_usr_id   		  (cre_usr_id   	[i]);
				model.setCre_dt       		  (cre_dt       	[i]);
				model.setUpd_usr_id   		  (upd_usr_id   	[i]);
				model.setUpd_dt       		  (upd_dt       	[i]);
				model.setDelt_flg     		  (delt_flg     	[i]);
				model.setEai_evnt_dt  		  (eai_evnt_dt  	[i]);
				model.setCrm_row_id			  (crm_row_id		[i]);
				models.add(model);
			}
		} catch (Exception ex) {
		}
		return models;
	}
	public static Collection fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmCustAddr model = null;
		Collection models = new ArrayList();
		int length = request.getParameterValues("ibflag").length;
		try {
			String[] ibflag        =  (JSPUtil.getParameter(request, prefix + "ibflag       		".trim(), length));
			String[] page_rows     =  (JSPUtil.getParameter(request, prefix + "page_rows    		".trim(), length));
			String[] cust_cnt_cd   =  (JSPUtil.getParameter(request, prefix + "cust_cnt_cd  		".trim(), length));
			String[] cust_seq      =  (JSPUtil.getParameter(request, prefix + "cust_seq     		".trim(), length));
			String[] addr_tp_cd    =  (JSPUtil.getParameter(request, prefix + "addr_tp_cd   		".trim(), length));
			String[] addr_seq      =  (JSPUtil.getParameter(request, prefix + "addr_seq     		".trim(), length));
			String[] prmry_chk_flg =  (JSPUtil.getParameter(request, prefix + "prmry_chk_flg		".trim(), length));
			String[] bzet_nm       =  (JSPUtil.getParameter(request, prefix + "bzet_nm      		".trim(), length));
			String[] bzet_addr     =  (JSPUtil.getParameter(request, prefix + "bzet_addr    		".trim(), length));
			String[] cty_nm        =  (JSPUtil.getParameter(request, prefix + "cty_nm       		".trim(), length));
			String[] ste_cd        =  (JSPUtil.getParameter(request, prefix + "ste_cd       		".trim(), length));
			String[] zip_cd        =  (JSPUtil.getParameter(request, prefix + "zip_cd       		".trim(), length));
			String[] cntc_eml      =  (JSPUtil.getParameter(request, prefix + "cntc_eml     		".trim(), length));
			String[] cntc_pson_nm  =  (JSPUtil.getParameter(request, prefix + "cntc_pson_nm 		".trim(), length));
			String[] bzet_rmk      =  (JSPUtil.getParameter(request, prefix + "bzet_rmk     		".trim(), length));
			String[] cre_usr_id    =  (JSPUtil.getParameter(request, prefix + "cre_usr_id   		".trim(), length));
			String[] cre_dt        =  (JSPUtil.getParameter(request, prefix + "cre_dt       		".trim(), length));
			String[] upd_usr_id    =  (JSPUtil.getParameter(request, prefix + "upd_usr_id   		".trim(), length));
			String[] upd_dt        =  (JSPUtil.getParameter(request, prefix + "upd_dt       		".trim(), length));
			String[] delt_flg      =  (JSPUtil.getParameter(request, prefix + "delt_flg     		".trim(), length));
			String[] eai_evnt_dt   =  (JSPUtil.getParameter(request, prefix + "eai_evnt_dt  		".trim(), length));
			String[] crm_row_id	   =  (JSPUtil.getParameter(request, prefix + "crm_row_id           ".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new MdmCustAddr();
				model.setIbflag       		  ( ibflag       	[i]);
				model.setPage_rows    		  ( page_rows    	[i]);
				model.setCust_cnt_cd  		  ( cust_cnt_cd  	[i]);
				model.setCust_seq     		  ( cust_seq     	[i]);
				model.setAddr_tp_cd   		  ( addr_tp_cd   	[i]);
				model.setAddr_seq     		  ( addr_seq     	[i]);
				model.setPrmry_chk_flg		  ( prmry_chk_flg	[i]);
				model.setBzet_nm      		  ( bzet_nm      	[i]);
				model.setBzet_addr    		  ( bzet_addr    	[i]);
				model.setCty_nm       		  ( cty_nm       	[i]);
				model.setSte_cd       		  ( ste_cd       	[i]);
				model.setZip_cd       		  ( zip_cd       	[i]);
				model.setCntc_eml     		  ( cntc_eml     	[i]);
				model.setCntc_pson_nm 		  ( cntc_pson_nm 	[i]);
				model.setBzet_rmk     		  ( bzet_rmk     	[i]);
				model.setCre_usr_id   		  ( cre_usr_id   	[i]);
				model.setCre_dt       		  ( cre_dt       	[i]);
				model.setUpd_usr_id   		  ( upd_usr_id   	[i]);
				model.setUpd_dt       		  ( upd_dt       	[i]);
				model.setDelt_flg     		  ( delt_flg     	[i]);
				model.setEai_evnt_dt  		  ( eai_evnt_dt  	[i]);
				model.setCrm_row_id			  (crm_row_id		[i]);
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
