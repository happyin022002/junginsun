/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchOfficeGeneralInfoListDataVO.java
*@FileTitle : searchOfficeGeneralInfoListDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.19 정영훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchOfficeGeneralInfoListDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchOfficeGeneralInfoListDataVO> models = new ArrayList<searchOfficeGeneralInfoListDataVO>();
	
	/* Column Info */
	private String aftAutoAproAmt = null;
	/* Column Info */
	private String orgOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aftSelfAuthAmt = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String upprOfcCd = null;
	/* Column Info */
	private String orgMnrGrpTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String orgCostCd = null;
	/* Column Info */
	private String bfrSelfAuthAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bfrAutoAproAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	 /**
	 * searchOfficeGeneralInfoListDataVO을 생성함
	 */
	public searchOfficeGeneralInfoListDataVO() {}

     /**
     * searchOfficeGeneralInfoListDataVO을 생성함
     */
	public searchOfficeGeneralInfoListDataVO(String ibflag, String pagerows, String arHdQtrOfcCd, String ofcCd, String mnrGrpTpCd, String costCd, String eqKndCd, String upprOfcCd, String effDt, String currCd, String bfrAutoAproAmt, String bfrSelfAuthAmt, String aftAutoAproAmt, String aftSelfAuthAmt, String creUsrId, String creDt, String updUsrId, String orgOfcCd, String orgMnrGrpTpCd, String orgCostCd) {
		this.aftAutoAproAmt = aftAutoAproAmt;
		this.orgOfcCd = orgOfcCd;
		this.currCd = currCd;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.creDt = creDt;
		this.aftSelfAuthAmt = aftSelfAuthAmt;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.upprOfcCd = upprOfcCd;
		this.orgMnrGrpTpCd = orgMnrGrpTpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.costCd = costCd;
		this.orgCostCd = orgCostCd;
		this.bfrSelfAuthAmt = bfrSelfAuthAmt;
		this.updUsrId = updUsrId;
		this.bfrAutoAproAmt = bfrAutoAproAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aft_auto_apro_amt", getAftAutoAproAmt());
		this.hashColumns.put("org_ofc_cd", getOrgOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aft_self_auth_amt", getAftSelfAuthAmt());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("uppr_ofc_cd", getUpprOfcCd());
		this.hashColumns.put("org_mnr_grp_tp_cd", getOrgMnrGrpTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("org_cost_cd", getOrgCostCd());
		this.hashColumns.put("bfr_self_auth_amt", getBfrSelfAuthAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bfr_auto_apro_amt", getBfrAutoAproAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aft_auto_apro_amt", "aftAutoAproAmt");
		this.hashFields.put("org_ofc_cd", "orgOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aft_self_auth_amt", "aftSelfAuthAmt");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("uppr_ofc_cd", "upprOfcCd");
		this.hashFields.put("org_mnr_grp_tp_cd", "orgMnrGrpTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("org_cost_cd", "orgCostCd");
		this.hashFields.put("bfr_self_auth_amt", "bfrSelfAuthAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bfr_auto_apro_amt", "bfrAutoAproAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aftAutoAproAmt
	 */
	public String getAftAutoAproAmt() {
		return this.aftAutoAproAmt;
	}
	
	/**
	 * Column Info
	 * @return orgOfcCd
	 */
	public String getOrgOfcCd() {
		return this.orgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return aftSelfAuthAmt
	 */
	public String getAftSelfAuthAmt() {
		return this.aftSelfAuthAmt;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return upprOfcCd
	 */
	public String getUpprOfcCd() {
		return this.upprOfcCd;
	}
	
	/**
	 * Column Info
	 * @return orgMnrGrpTpCd
	 */
	public String getOrgMnrGrpTpCd() {
		return this.orgMnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return orgCostCd
	 */
	public String getOrgCostCd() {
		return this.orgCostCd;
	}
	
	/**
	 * Column Info
	 * @return bfrSelfAuthAmt
	 */
	public String getBfrSelfAuthAmt() {
		return this.bfrSelfAuthAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return bfrAutoAproAmt
	 */
	public String getBfrAutoAproAmt() {
		return this.bfrAutoAproAmt;
	}
	

	/**
	 * Column Info
	 * @param aftAutoAproAmt
	 */
	public void setAftAutoAproAmt(String aftAutoAproAmt) {
		this.aftAutoAproAmt = aftAutoAproAmt;
	}
	
	/**
	 * Column Info
	 * @param orgOfcCd
	 */
	public void setOrgOfcCd(String orgOfcCd) {
		this.orgOfcCd = orgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param aftSelfAuthAmt
	 */
	public void setAftSelfAuthAmt(String aftSelfAuthAmt) {
		this.aftSelfAuthAmt = aftSelfAuthAmt;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param upprOfcCd
	 */
	public void setUpprOfcCd(String upprOfcCd) {
		this.upprOfcCd = upprOfcCd;
	}
	
	/**
	 * Column Info
	 * @param orgMnrGrpTpCd
	 */
	public void setOrgMnrGrpTpCd(String orgMnrGrpTpCd) {
		this.orgMnrGrpTpCd = orgMnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param orgCostCd
	 */
	public void setOrgCostCd(String orgCostCd) {
		this.orgCostCd = orgCostCd;
	}
	
	/**
	 * Column Info
	 * @param bfrSelfAuthAmt
	 */
	public void setBfrSelfAuthAmt(String bfrSelfAuthAmt) {
		this.bfrSelfAuthAmt = bfrSelfAuthAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param bfrAutoAproAmt
	 */
	public void setBfrAutoAproAmt(String bfrAutoAproAmt) {
		this.bfrAutoAproAmt = bfrAutoAproAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAftAutoAproAmt(JSPUtil.getParameter(request, "aft_auto_apro_amt", ""));
		setOrgOfcCd(JSPUtil.getParameter(request, "org_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAftSelfAuthAmt(JSPUtil.getParameter(request, "aft_self_auth_amt", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setUpprOfcCd(JSPUtil.getParameter(request, "uppr_ofc_cd", ""));
		setOrgMnrGrpTpCd(JSPUtil.getParameter(request, "org_mnr_grp_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setOrgCostCd(JSPUtil.getParameter(request, "org_cost_cd", ""));
		setBfrSelfAuthAmt(JSPUtil.getParameter(request, "bfr_self_auth_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setBfrAutoAproAmt(JSPUtil.getParameter(request, "bfr_auto_apro_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchOfficeGeneralInfoListDataVO[]
	 */
	public searchOfficeGeneralInfoListDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchOfficeGeneralInfoListDataVO[]
	 */
	public searchOfficeGeneralInfoListDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchOfficeGeneralInfoListDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aftAutoAproAmt = (JSPUtil.getParameter(request, prefix	+ "aft_auto_apro_amt", length));
			String[] orgOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_ofc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aftSelfAuthAmt = (JSPUtil.getParameter(request, prefix	+ "aft_self_auth_amt", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] upprOfcCd = (JSPUtil.getParameter(request, prefix	+ "uppr_ofc_cd", length));
			String[] orgMnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_mnr_grp_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] orgCostCd = (JSPUtil.getParameter(request, prefix	+ "org_cost_cd", length));
			String[] bfrSelfAuthAmt = (JSPUtil.getParameter(request, prefix	+ "bfr_self_auth_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bfrAutoAproAmt = (JSPUtil.getParameter(request, prefix	+ "bfr_auto_apro_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchOfficeGeneralInfoListDataVO();
				if (aftAutoAproAmt[i] != null)
					model.setAftAutoAproAmt(aftAutoAproAmt[i]);
				if (orgOfcCd[i] != null)
					model.setOrgOfcCd(orgOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aftSelfAuthAmt[i] != null)
					model.setAftSelfAuthAmt(aftSelfAuthAmt[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (upprOfcCd[i] != null)
					model.setUpprOfcCd(upprOfcCd[i]);
				if (orgMnrGrpTpCd[i] != null)
					model.setOrgMnrGrpTpCd(orgMnrGrpTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (orgCostCd[i] != null)
					model.setOrgCostCd(orgCostCd[i]);
				if (bfrSelfAuthAmt[i] != null)
					model.setBfrSelfAuthAmt(bfrSelfAuthAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bfrAutoAproAmt[i] != null)
					model.setBfrAutoAproAmt(bfrAutoAproAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchOfficeGeneralInfoListDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchOfficeGeneralInfoListDataVO[]
	 */
	public searchOfficeGeneralInfoListDataVO[] getsearchOfficeGeneralInfoListDataVOs(){
		searchOfficeGeneralInfoListDataVO[] vos = (searchOfficeGeneralInfoListDataVO[])models.toArray(new searchOfficeGeneralInfoListDataVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.aftAutoAproAmt = this.aftAutoAproAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOfcCd = this.orgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftSelfAuthAmt = this.aftSelfAuthAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upprOfcCd = this.upprOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMnrGrpTpCd = this.orgMnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCostCd = this.orgCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrSelfAuthAmt = this.bfrSelfAuthAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrAutoAproAmt = this.bfrAutoAproAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
