/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomManHrChgVO.java
*@FileTitle : CustomManHrChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.11 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class CustomManHrChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomManHrChgVO> models = new ArrayList<CustomManHrChgVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String manHrListSeq = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String mbrWrkAmt = null;
	/* Column Info */
	private String orgManHrListSeq = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String agnWrkAmt = null;
	/* Column Info */
	private String mgrWrkAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String manHrItmNm = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String slpTeamCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String portCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomManHrChgVO() {}

	public CustomManHrChgVO(String ibflag, String pagerows, String slpTpCd, String slpFuncCd, String slpTeamCd, String slpIssDt, String slpSerNo, String slpSeqNo, String manHrListSeq, String orgManHrListSeq, String manHrItmNm, String portCd, String mgrWrkAmt, String mbrWrkAmt, String agnWrkAmt, String currCd, String creUsrId, String updUsrId) {
		this.ibflag = ibflag;
		this.manHrListSeq = manHrListSeq;
		this.slpFuncCd = slpFuncCd;
		this.mbrWrkAmt = mbrWrkAmt;
		this.orgManHrListSeq = orgManHrListSeq;
		this.slpTpCd = slpTpCd;
		this.slpIssDt = slpIssDt;
		this.agnWrkAmt = agnWrkAmt;
		this.mgrWrkAmt = mgrWrkAmt;
		this.updUsrId = updUsrId;
		this.manHrItmNm = manHrItmNm;
		this.slpSeqNo = slpSeqNo;
		this.slpTeamCd = slpTeamCd;
		this.creUsrId = creUsrId;
		this.currCd = currCd;
		this.slpSerNo = slpSerNo;
		this.portCd = portCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("man_hr_list_seq", getManHrListSeq());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("mbr_wrk_amt", getMbrWrkAmt());
		this.hashColumns.put("org_man_hr_list_seq", getOrgManHrListSeq());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("agn_wrk_amt", getAgnWrkAmt());
		this.hashColumns.put("mgr_wrk_amt", getMgrWrkAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("man_hr_itm_nm", getManHrItmNm());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("slp_team_cd", getSlpTeamCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("man_hr_list_seq", "manHrListSeq");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("mbr_wrk_amt", "mbrWrkAmt");
		this.hashFields.put("org_man_hr_list_seq", "orgManHrListSeq");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("agn_wrk_amt", "agnWrkAmt");
		this.hashFields.put("mgr_wrk_amt", "mgrWrkAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("man_hr_itm_nm", "manHrItmNm");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("slp_team_cd", "slpTeamCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getManHrListSeq() {
		return this.manHrListSeq;
	}
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	public String getMbrWrkAmt() {
		return this.mbrWrkAmt;
	}
	public String getOrgManHrListSeq() {
		return this.orgManHrListSeq;
	}
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	public String getAgnWrkAmt() {
		return this.agnWrkAmt;
	}
	public String getMgrWrkAmt() {
		return this.mgrWrkAmt;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getManHrItmNm() {
		return this.manHrItmNm;
	}
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	public String getSlpTeamCd() {
		return this.slpTeamCd;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getCurrCd() {
		return this.currCd;
	}
	public String getSlpSerNo() {
		return this.slpSerNo;
	}
	public String getPortCd() {
		return this.portCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setManHrListSeq(String manHrListSeq) {
		this.manHrListSeq = manHrListSeq;
		//this.manHrListSeq=true;
	}
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
		//this.slpFuncCd=true;
	}
	public void setMbrWrkAmt(String mbrWrkAmt) {
		this.mbrWrkAmt = mbrWrkAmt;
		//this.mbrWrkAmt=true;
	}
	public void setOrgManHrListSeq(String orgManHrListSeq) {
		this.orgManHrListSeq = orgManHrListSeq;
		//this.orgManHrListSeq=true;
	}
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
		//this.slpTpCd=true;
	}
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
		//this.slpIssDt=true;
	}
	public void setAgnWrkAmt(String agnWrkAmt) {
		this.agnWrkAmt = agnWrkAmt;
		//this.agnWrkAmt=true;
	}
	public void setMgrWrkAmt(String mgrWrkAmt) {
		this.mgrWrkAmt = mgrWrkAmt;
		//this.mgrWrkAmt=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setManHrItmNm(String manHrItmNm) {
		this.manHrItmNm = manHrItmNm;
		//this.manHrItmNm=true;
	}
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
		//this.slpSeqNo=true;
	}
	public void setSlpTeamCd(String slpTeamCd) {
		this.slpTeamCd = slpTeamCd;
		//this.slpTeamCd=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		//this.currCd=true;
	}
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
		//this.slpSerNo=true;
	}
	public void setPortCd(String portCd) {
		this.portCd = portCd;
		//this.portCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setManHrListSeq(JSPUtil.getParameter(request, "man_hr_list_seq", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setMbrWrkAmt(JSPUtil.getParameter(request, "mbr_wrk_amt", ""));
		setOrgManHrListSeq(JSPUtil.getParameter(request, "org_man_hr_list_seq", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setAgnWrkAmt(JSPUtil.getParameter(request, "agn_wrk_amt", ""));
		setMgrWrkAmt(JSPUtil.getParameter(request, "mgr_wrk_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setManHrItmNm(JSPUtil.getParameter(request, "man_hr_itm_nm", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setSlpTeamCd(JSPUtil.getParameter(request, "slp_team_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomManHrChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomManHrChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomManHrChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] manHrListSeq = (JSPUtil.getParameter(request, prefix	+ "man_hr_list_seq".trim(), length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd".trim(), length));
			String[] mbrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mbr_wrk_amt".trim(), length));
			String[] orgManHrListSeq = (JSPUtil.getParameter(request, prefix	+ "org_man_hr_list_seq".trim(), length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd".trim(), length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt".trim(), length));
			String[] agnWrkAmt = (JSPUtil.getParameter(request, prefix	+ "agn_wrk_amt".trim(), length));
			String[] mgrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mgr_wrk_amt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] manHrItmNm = (JSPUtil.getParameter(request, prefix	+ "man_hr_itm_nm".trim(), length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no".trim(), length));
			String[] slpTeamCd = (JSPUtil.getParameter(request, prefix	+ "slp_team_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomManHrChgVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (manHrListSeq[i] != null)
					model.setManHrListSeq(manHrListSeq[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (mbrWrkAmt[i] != null)
					model.setMbrWrkAmt(mbrWrkAmt[i]);
				if (orgManHrListSeq[i] != null)
					model.setOrgManHrListSeq(orgManHrListSeq[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (agnWrkAmt[i] != null)
					model.setAgnWrkAmt(agnWrkAmt[i]);
				if (mgrWrkAmt[i] != null)
					model.setMgrWrkAmt(mgrWrkAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (manHrItmNm[i] != null)
					model.setManHrItmNm(manHrItmNm[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (slpTeamCd[i] != null)
					model.setSlpTeamCd(slpTeamCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomManHrChgVOs();
	}

	public CustomManHrChgVO[] getCustomManHrChgVOs(){
		CustomManHrChgVO[] vos = (CustomManHrChgVO[])models.toArray(new CustomManHrChgVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHrListSeq = this.manHrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbrWrkAmt = this.mbrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgManHrListSeq = this.orgManHrListSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnWrkAmt = this.agnWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgrWrkAmt = this.mgrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHrItmNm = this.manHrItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTeamCd = this.slpTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
