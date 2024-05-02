/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0925Event.java
*@FileTitle : Rail Invoice Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-11
*@LastModifier : Kildong_hong
*@LastVersion : 1.0 
* 2006-12-11 Kildong_hong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event;

import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_925 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0925HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kildong_hong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0925Event extends EventSupport {


	private String wblDt          = null;
	private String selSheetIdx   = null;
	private String eqNo           = null;
	private String formCreUsrId = null;
	private String railRoadCode  = null;
	private String mode            = null;
	private String formUsrOfcCd = null;
	
	private HashMap hashParam = new HashMap();
	
	public EsdTrs0925Event(){}

	
	
	public String getWbl_dt() {
		return wblDt;
	}
	public void setWbl_dt(String wbl_dt) {
		this.wblDt = wbl_dt;
	}


	public String getSel_sheet_idx() {
		return selSheetIdx;
	}
	public void setSel_sheet_idx(String selSheetIdx) {
		this.selSheetIdx = selSheetIdx;
	}


	public String getEq_no() {
		return eqNo;
	}
	public void setEq_no(String eqNo) {
		this.eqNo = eqNo;
	}


	public String getForm_cre_usr_id() {
		return formCreUsrId;
	}
	public void setForm_cre_usr_id(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}

	public String getRail_road_code() {
		return railRoadCode;
	}
	public void setRail_road_code(String railRoadCode) {
		this.railRoadCode = railRoadCode;
	}


	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}


	public String getForm_usr_ofc_cd() {
		return formUsrOfcCd;
	}
	public void setForm_usr_ofc_cd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}

	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("wbl_dt"         , getWbl_dt());
		this.hashColumns.put("sel_sheet_idx"  , getSel_sheet_idx());
		this.hashColumns.put("eq_no"          , getEq_no());
		this.hashColumns.put("form_cre_usr_id", getForm_cre_usr_id());
		this.hashColumns.put("rail_road_code" , getRail_road_code());
		this.hashColumns.put("mode"           , getMode());
		this.hashColumns.put("form_usr_ofc_cd", getForm_usr_ofc_cd());
		return this.hashColumns;
	}
	
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("wbl_dt"         , "wbl_dt");
		this.hashFields.put("sel_sheet_idx"  , "sel_sheet_idx");
		this.hashFields.put("eq_no"          , "eq_no");
		this.hashFields.put("form_cre_usr_id", "form_cre_usr_id");
		this.hashFields.put("rail_road_code" , "rail_road_code");
		this.hashFields.put("mode"           , "mode");
		this.hashFields.put("form_usr_ofc_cd", "form_usr_ofc_cd");		
		return this.hashFields;
	}
	

	public HashMap getHashParam(){
		return this.hashParam;
	}
	
	public void setHashParam(HashMap hashParamValue){
		this.hashParam = hashParamValue;
	}
	
	public String getEventName() {
		return "EsdTrs0925Event";
	}

	public String toString() {
		return "EsdTrs0925Event";
	}

}
