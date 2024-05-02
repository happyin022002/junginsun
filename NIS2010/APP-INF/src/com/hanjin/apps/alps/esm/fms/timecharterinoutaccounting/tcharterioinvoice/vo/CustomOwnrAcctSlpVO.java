/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomOwnrAcctSlpVO.java
*@FileTitle : CustomOwnrAcctSlpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.30 최우석 
* 1.0 Creation
* 2013.01.24 이수진 [CHM-201322477] OWNERS ACCOUNT 접수확인 항목 개발 요청 - flet_rct_flg vo 추가
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class CustomOwnrAcctSlpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomOwnrAcctSlpVO> models = new ArrayList<CustomOwnrAcctSlpVO>();
	
	/* Column Info */
	private String n2ndCurrCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String actXchRtAmt = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String apDesc4 = null;
	/* Column Info */
	private String fletPpayRltCd = null;
	/* Column Info */
	private String apDesc1 = null;
	/* Column Info */
	private String vvdCd1 = null;
	/* Column Info */
	private String n1stAmt1 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String apDesc = null;
	/* Column Info */
	private String manHrFlg = null;
	/* Column Info */
	private String orgSlpNo1 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String slpTeamCd = null;
	/* Column Info */
	private String apDesc2 = null;
	/* Column Info */
	private String apDesc3 = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String orgSlpNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String aproFlg = null;
	/* Column Info */
	private String n2ndAmt = null;
	/* Column Info */
	private String n1stAmt = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String apDesc5 = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String stlFlg1 = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String n1stCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletRctFlg = null;	

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomOwnrAcctSlpVO() {}

	public CustomOwnrAcctSlpVO(String ibflag, String pagerows, String stlFlg, String stlFlg1, String fletPpayRltCd, String acctCd, String ctrCd, String effDt, String n1stCurrCd, String n1stAmt, String n1stAmt1, String n2ndCurrCd, String n2ndAmt, String actXchRtAmt, String aproFlg, String apDesc, String apDesc1, String apDesc2, String apDesc3, String apDesc4, String apDesc5, String vvdCd, String vvdCd1, String orgSlpNo, String orgSlpNo1, String manHrFlg, String slpTpCd, String slpFuncCd, String slpTeamCd, String slpIssDt, String slpSerNo, String slpSeqNo, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String updUsrId, String fletRctFlg) {
		this.n2ndCurrCd = n2ndCurrCd;
		this.acctCd = acctCd;
		this.actXchRtAmt = actXchRtAmt;
		this.slpFuncCd = slpFuncCd;
		this.apDesc4 = apDesc4;
		this.fletPpayRltCd = fletPpayRltCd;
		this.apDesc1 = apDesc1;
		this.vvdCd1 = vvdCd1;
		this.n1stAmt1 = n1stAmt1;
		this.updUsrId = updUsrId;
		this.apDesc = apDesc;
		this.manHrFlg = manHrFlg;
		this.orgSlpNo1 = orgSlpNo1;
		this.vslCd = vslCd;
		this.slpTeamCd = slpTeamCd;
		this.apDesc2 = apDesc2;
		this.apDesc3 = apDesc3;
		this.ibflag = ibflag;
		this.orgSlpNo = orgSlpNo;
		this.skdDirCd = skdDirCd;
		this.aproFlg = aproFlg;
		this.n2ndAmt = n2ndAmt;
		this.n1stAmt = n1stAmt;
		this.slpIssDt = slpIssDt;
		this.slpTpCd = slpTpCd;
		this.apDesc5 = apDesc5;
		this.revDirCd = revDirCd;
		this.ctrCd = ctrCd;
		this.stlFlg1 = stlFlg1;
		this.effDt = effDt;
		this.slpSeqNo = slpSeqNo;
		this.vvdCd = vvdCd;
		this.skdVoyNo = skdVoyNo;
		this.stlFlg = stlFlg;
		this.slpSerNo = slpSerNo;
		this.n1stCurrCd = n1stCurrCd;
		this.pagerows = pagerows;
		this.fletRctFlg = fletRctFlg;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n2nd_curr_cd", getN2ndCurrCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("act_xch_rt_amt", getActXchRtAmt());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("ap_desc4", getApDesc4());
		this.hashColumns.put("flet_ppay_rlt_cd", getFletPpayRltCd());
		this.hashColumns.put("ap_desc1", getApDesc1());
		this.hashColumns.put("vvd_cd1", getVvdCd1());
		this.hashColumns.put("n1st_amt1", getN1stAmt1());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ap_desc", getApDesc());
		this.hashColumns.put("man_hr_flg", getManHrFlg());
		this.hashColumns.put("org_slp_no1", getOrgSlpNo1());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("slp_team_cd", getSlpTeamCd());
		this.hashColumns.put("ap_desc2", getApDesc2());
		this.hashColumns.put("ap_desc3", getApDesc3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_slp_no", getOrgSlpNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("apro_flg", getAproFlg());
		this.hashColumns.put("n2nd_amt", getN2ndAmt());
		this.hashColumns.put("n1st_amt", getN1stAmt());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("ap_desc5", getApDesc5());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("stl_flg1", getStlFlg1());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("n1st_curr_cd", getN1stCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_rct_flg", getFletRctFlg());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n2nd_curr_cd", "n2ndCurrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("act_xch_rt_amt", "actXchRtAmt");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("ap_desc4", "apDesc4");
		this.hashFields.put("flet_ppay_rlt_cd", "fletPpayRltCd");
		this.hashFields.put("ap_desc1", "apDesc1");
		this.hashFields.put("vvd_cd1", "vvdCd1");
		this.hashFields.put("n1st_amt1", "n1stAmt1");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ap_desc", "apDesc");
		this.hashFields.put("man_hr_flg", "manHrFlg");
		this.hashFields.put("org_slp_no1", "orgSlpNo1");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("slp_team_cd", "slpTeamCd");
		this.hashFields.put("ap_desc2", "apDesc2");
		this.hashFields.put("ap_desc3", "apDesc3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_slp_no", "orgSlpNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("n2nd_amt", "n2ndAmt");
		this.hashFields.put("n1st_amt", "n1stAmt");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("ap_desc5", "apDesc5");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("stl_flg1", "stlFlg1");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("n1st_curr_cd", "n1stCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_rct_flg", "fletRctFlg");
		return this.hashFields;
	}
	
	public String getN2ndCurrCd() {
		return this.n2ndCurrCd;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getActXchRtAmt() {
		return this.actXchRtAmt;
	}
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	public String getApDesc4() {
		return this.apDesc4;
	}
	public String getFletPpayRltCd() {
		return this.fletPpayRltCd;
	}
	public String getApDesc1() {
		return this.apDesc1;
	}
	public String getVvdCd1() {
		return this.vvdCd1;
	}
	public String getN1stAmt1() {
		return this.n1stAmt1;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getApDesc() {
		return this.apDesc;
	}
	public String getManHrFlg() {
		return this.manHrFlg;
	}
	public String getOrgSlpNo1() {
		return this.orgSlpNo1;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getSlpTeamCd() {
		return this.slpTeamCd;
	}
	public String getApDesc2() {
		return this.apDesc2;
	}
	public String getApDesc3() {
		return this.apDesc3;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getOrgSlpNo() {
		return this.orgSlpNo;
	}
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getAproFlg() {
		return this.aproFlg;
	}
	public String getN2ndAmt() {
		return this.n2ndAmt;
	}
	public String getN1stAmt() {
		return this.n1stAmt;
	}
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	public String getApDesc5() {
		return this.apDesc5;
	}
	public String getRevDirCd() {
		return this.revDirCd;
	}
	public String getCtrCd() {
		return this.ctrCd;
	}
	public String getStlFlg1() {
		return this.stlFlg1;
	}
	public String getEffDt() {
		return this.effDt;
	}
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	public String getVvdCd() {
		return this.vvdCd;
	}
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	public String getStlFlg() {
		return this.stlFlg;
	}
	public String getSlpSerNo() {
		return this.slpSerNo;
	}
	public String getN1stCurrCd() {
		return this.n1stCurrCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getFletRctFlg() {
		return this.fletRctFlg;
	}	

	public void setN2ndCurrCd(String n2ndCurrCd) {
		this.n2ndCurrCd = n2ndCurrCd;
		//this.n2ndCurrCd=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setActXchRtAmt(String actXchRtAmt) {
		this.actXchRtAmt = actXchRtAmt;
		//this.actXchRtAmt=true;
	}
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
		//this.slpFuncCd=true;
	}
	public void setApDesc4(String apDesc4) {
		this.apDesc4 = apDesc4;
		//this.apDesc4=true;
	}
	public void setFletPpayRltCd(String fletPpayRltCd) {
		this.fletPpayRltCd = fletPpayRltCd;
		//this.fletPpayRltCd=true;
	}
	public void setApDesc1(String apDesc1) {
		this.apDesc1 = apDesc1;
		//this.apDesc1=true;
	}
	public void setVvdCd1(String vvdCd1) {
		this.vvdCd1 = vvdCd1;
		//this.vvdCd1=true;
	}
	public void setN1stAmt1(String n1stAmt1) {
		this.n1stAmt1 = n1stAmt1;
		//this.n1stAmt1=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setApDesc(String apDesc) {
		this.apDesc = apDesc;
		//this.apDesc=true;
	}
	public void setManHrFlg(String manHrFlg) {
		this.manHrFlg = manHrFlg;
		//this.manHrFlg=true;
	}
	public void setOrgSlpNo1(String orgSlpNo1) {
		this.orgSlpNo1 = orgSlpNo1;
		//this.orgSlpNo1=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setSlpTeamCd(String slpTeamCd) {
		this.slpTeamCd = slpTeamCd;
		//this.slpTeamCd=true;
	}
	public void setApDesc2(String apDesc2) {
		this.apDesc2 = apDesc2;
		//this.apDesc2=true;
	}
	public void setApDesc3(String apDesc3) {
		this.apDesc3 = apDesc3;
		//this.apDesc3=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setOrgSlpNo(String orgSlpNo) {
		this.orgSlpNo = orgSlpNo;
		//this.orgSlpNo=true;
	}
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setAproFlg(String aproFlg) {
		this.aproFlg = aproFlg;
		//this.aproFlg=true;
	}
	public void setN2ndAmt(String n2ndAmt) {
		this.n2ndAmt = n2ndAmt;
		//this.n2ndAmt=true;
	}
	public void setN1stAmt(String n1stAmt) {
		this.n1stAmt = n1stAmt;
		//this.n1stAmt=true;
	}
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
		//this.slpIssDt=true;
	}
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
		//this.slpTpCd=true;
	}
	public void setApDesc5(String apDesc5) {
		this.apDesc5 = apDesc5;
		//this.apDesc5=true;
	}
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
		//this.revDirCd=true;
	}
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
		//this.ctrCd=true;
	}
	public void setStlFlg1(String stlFlg1) {
		this.stlFlg1 = stlFlg1;
		//this.stlFlg1=true;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
		//this.slpSeqNo=true;
	}
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
		//this.vvdCd=true;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
		//this.skdVoyNo=true;
	}
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
		//this.stlFlg=true;
	}
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
		//this.slpSerNo=true;
	}
	public void setN1stCurrCd(String n1stCurrCd) {
		this.n1stCurrCd = n1stCurrCd;
		//this.n1stCurrCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setFletRctFlg(String fletRctFlg) {
		this.fletRctFlg = fletRctFlg;
	}
	
	public void fromRequest(HttpServletRequest request) {
		setN2ndCurrCd(JSPUtil.getParameter(request, "n2nd_curr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setActXchRtAmt(JSPUtil.getParameter(request, "act_xch_rt_amt", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setApDesc4(JSPUtil.getParameter(request, "ap_desc4", ""));
		setFletPpayRltCd(JSPUtil.getParameter(request, "flet_ppay_rlt_cd", ""));
		setApDesc1(JSPUtil.getParameter(request, "ap_desc1", ""));
		setVvdCd1(JSPUtil.getParameter(request, "vvd_cd1", ""));
		setN1stAmt1(JSPUtil.getParameter(request, "n1st_amt1", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setApDesc(JSPUtil.getParameter(request, "ap_desc", ""));
		setManHrFlg(JSPUtil.getParameter(request, "man_hr_flg", ""));
		setOrgSlpNo1(JSPUtil.getParameter(request, "org_slp_no1", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSlpTeamCd(JSPUtil.getParameter(request, "slp_team_cd", ""));
		setApDesc2(JSPUtil.getParameter(request, "ap_desc2", ""));
		setApDesc3(JSPUtil.getParameter(request, "ap_desc3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrgSlpNo(JSPUtil.getParameter(request, "org_slp_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setAproFlg(JSPUtil.getParameter(request, "apro_flg", ""));
		setN2ndAmt(JSPUtil.getParameter(request, "n2nd_amt", ""));
		setN1stAmt(JSPUtil.getParameter(request, "n1st_amt", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setApDesc5(JSPUtil.getParameter(request, "ap_desc5", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setStlFlg1(JSPUtil.getParameter(request, "stl_flg1", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setStlFlg(JSPUtil.getParameter(request, "stl_flg", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setN1stCurrCd(JSPUtil.getParameter(request, "n1st_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletRctFlg(JSPUtil.getParameter(request, "flet_rct_flg", ""));
	}

	public CustomOwnrAcctSlpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomOwnrAcctSlpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomOwnrAcctSlpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n2ndCurrCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_curr_cd".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] actXchRtAmt = (JSPUtil.getParameter(request, prefix	+ "act_xch_rt_amt".trim(), length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd".trim(), length));
			String[] apDesc4 = (JSPUtil.getParameter(request, prefix	+ "ap_desc4".trim(), length));
			String[] fletPpayRltCd = (JSPUtil.getParameter(request, prefix	+ "flet_ppay_rlt_cd".trim(), length));
			String[] apDesc1 = (JSPUtil.getParameter(request, prefix	+ "ap_desc1".trim(), length));
			String[] vvdCd1 = (JSPUtil.getParameter(request, prefix	+ "vvd_cd1".trim(), length));
			String[] n1stAmt1 = (JSPUtil.getParameter(request, prefix	+ "n1st_amt1".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] apDesc = (JSPUtil.getParameter(request, prefix	+ "ap_desc".trim(), length));
			String[] manHrFlg = (JSPUtil.getParameter(request, prefix	+ "man_hr_flg".trim(), length));
			String[] orgSlpNo1 = (JSPUtil.getParameter(request, prefix	+ "org_slp_no1".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] slpTeamCd = (JSPUtil.getParameter(request, prefix	+ "slp_team_cd".trim(), length));
			String[] apDesc2 = (JSPUtil.getParameter(request, prefix	+ "ap_desc2".trim(), length));
			String[] apDesc3 = (JSPUtil.getParameter(request, prefix	+ "ap_desc3".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] orgSlpNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_no".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] aproFlg = (JSPUtil.getParameter(request, prefix	+ "apro_flg".trim(), length));
			String[] n2ndAmt = (JSPUtil.getParameter(request, prefix	+ "n2nd_amt".trim(), length));
			String[] n1stAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_amt".trim(), length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt".trim(), length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd".trim(), length));
			String[] apDesc5 = (JSPUtil.getParameter(request, prefix	+ "ap_desc5".trim(), length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd".trim(), length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd".trim(), length));
			String[] stlFlg1 = (JSPUtil.getParameter(request, prefix	+ "stl_flg1".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg".trim(), length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no".trim(), length));
			String[] n1stCurrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_curr_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletRctFlg = (JSPUtil.getParameter(request, prefix	+ "flet_rct_flg".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomOwnrAcctSlpVO();
				if (n2ndCurrCd[i] != null)
					model.setN2ndCurrCd(n2ndCurrCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (actXchRtAmt[i] != null)
					model.setActXchRtAmt(actXchRtAmt[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (apDesc4[i] != null)
					model.setApDesc4(apDesc4[i]);
				if (fletPpayRltCd[i] != null)
					model.setFletPpayRltCd(fletPpayRltCd[i]);
				if (apDesc1[i] != null)
					model.setApDesc1(apDesc1[i]);
				if (vvdCd1[i] != null)
					model.setVvdCd1(vvdCd1[i]);
				if (n1stAmt1[i] != null)
					model.setN1stAmt1(n1stAmt1[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (apDesc[i] != null)
					model.setApDesc(apDesc[i]);
				if (manHrFlg[i] != null)
					model.setManHrFlg(manHrFlg[i]);
				if (orgSlpNo1[i] != null)
					model.setOrgSlpNo1(orgSlpNo1[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (slpTeamCd[i] != null)
					model.setSlpTeamCd(slpTeamCd[i]);
				if (apDesc2[i] != null)
					model.setApDesc2(apDesc2[i]);
				if (apDesc3[i] != null)
					model.setApDesc3(apDesc3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgSlpNo[i] != null)
					model.setOrgSlpNo(orgSlpNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (aproFlg[i] != null)
					model.setAproFlg(aproFlg[i]);
				if (n2ndAmt[i] != null)
					model.setN2ndAmt(n2ndAmt[i]);
				if (n1stAmt[i] != null)
					model.setN1stAmt(n1stAmt[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (apDesc5[i] != null)
					model.setApDesc5(apDesc5[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (stlFlg1[i] != null)
					model.setStlFlg1(stlFlg1[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (n1stCurrCd[i] != null)
					model.setN1stCurrCd(n1stCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletRctFlg[i] != null)
					model.setFletRctFlg(fletRctFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomOwnrAcctSlpVOs();
	}

	public CustomOwnrAcctSlpVO[] getCustomOwnrAcctSlpVOs(){
		CustomOwnrAcctSlpVO[] vos = (CustomOwnrAcctSlpVO[])models.toArray(new CustomOwnrAcctSlpVO[models.size()]);
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
		this.n2ndCurrCd = this.n2ndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actXchRtAmt = this.actXchRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc4 = this.apDesc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletPpayRltCd = this.fletPpayRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc1 = this.apDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd1 = this.vvdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt1 = this.n1stAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc = this.apDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHrFlg = this.manHrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpNo1 = this.orgSlpNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTeamCd = this.slpTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc2 = this.apDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc3 = this.apDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpNo = this.orgSlpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg = this.aproFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndAmt = this.n2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt = this.n1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc5 = this.apDesc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg1 = this.stlFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCurrCd = this.n1stCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletRctFlg = this.fletRctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
