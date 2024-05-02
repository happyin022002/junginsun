/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSMvmtBareMGTVO.java
*@FileTitle : CHSMvmtBareMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.10 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSMvmtBareMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSMvmtBareMGTVO> models = new ArrayList<MGSMvmtBareMGTVO>();
	
	/* Column Info */
	private String atDtStatus = null;
	/* Column Info */
	private String vl = null;
	/* Column Info */
	private String verify = null;
	/* Column Info */
	private String mvmtDtHd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String destYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chssMvmtDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String atCntrNo = null;
	/* Column Info */
	private String mvmtDtDay = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String gateIoCd = null;
	/* Column Info */
	private String mvmtCoCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dtCntrNo = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String mvmtRsnCd = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mnlInpFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String sysSeq = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String scac = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MGSMvmtBareMGTVO() {}

	public MGSMvmtBareMGTVO(String ibflag, String pagerows, String vl, String atDtStatus, String verify, String mvmtDtHd, String creDt, String crntYdCd, String destYdCd, String chssMvmtDt, String eqNo, String mvmtDtDay, String atCntrNo, String updUsrId, String gateIoCd, String mvmtCoCd, String updDt, String dtCntrNo, String mgstNo, String mvmtRsnCd, String delChk, String mvmtStsCd, String creUsrId, String diffRmk, String ydCd, String vndrSeq, String mnlInpFlg, String vndrAbbrNm, String mvmtDt, String sysSeq, String cntrNo, String cnmvYr, String cnmvIdNo, String chssNo, String spName, String scac) {
		this.atDtStatus = atDtStatus;
		this.vl = vl;
		this.verify = verify;
		this.mvmtDtHd = mvmtDtHd;
		this.creDt = creDt;
		this.crntYdCd = crntYdCd;
		this.destYdCd = destYdCd;
		this.pagerows = pagerows;
		this.chssMvmtDt = chssMvmtDt;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.atCntrNo = atCntrNo;
		this.mvmtDtDay = mvmtDtDay;
		this.updUsrId = updUsrId;
		this.gateIoCd = gateIoCd;
		this.mvmtCoCd = mvmtCoCd;
		this.updDt = updDt;
		this.dtCntrNo = dtCntrNo;
		this.mgstNo = mgstNo;
		this.cnmvIdNo = cnmvIdNo;
		this.mvmtRsnCd = mvmtRsnCd;
		this.delChk = delChk;
		this.mvmtStsCd = mvmtStsCd;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.vndrSeq = vndrSeq;
		this.mnlInpFlg = mnlInpFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.cnmvYr = cnmvYr;
		this.mvmtDt = mvmtDt;
		this.sysSeq = sysSeq;
		this.chssNo = chssNo;
		this.spName = spName;
		this.scac = scac;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("at_dt_status", getAtDtStatus());
		this.hashColumns.put("vl", getVl());
		this.hashColumns.put("verify", getVerify());
		this.hashColumns.put("mvmt_dt_hd", getMvmtDtHd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chss_mvmt_dt", getChssMvmtDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("at_cntr_no", getAtCntrNo());
		this.hashColumns.put("mvmt_dt_day", getMvmtDtDay());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gate_io_cd", getGateIoCd());
		this.hashColumns.put("mvmt_co_cd", getMvmtCoCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dt_cntr_no", getDtCntrNo());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("mvmt_rsn_cd", getMvmtRsnCd());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mnl_inp_flg", getMnlInpFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("sys_seq", getSysSeq());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("scac", getScac());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("at_dt_status", "atDtStatus");
		this.hashFields.put("vl", "vl");
		this.hashFields.put("verify", "verify");
		this.hashFields.put("mvmt_dt_hd", "mvmtDtHd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chss_mvmt_dt", "chssMvmtDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("at_cntr_no", "atCntrNo");
		this.hashFields.put("mvmt_dt_day", "mvmtDtDay");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gate_io_cd", "gateIoCd");
		this.hashFields.put("mvmt_co_cd", "mvmtCoCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dt_cntr_no", "dtCntrNo");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("mvmt_rsn_cd", "mvmtRsnCd");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mnl_inp_flg", "mnlInpFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("sys_seq", "sysSeq");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("scac", "scac");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return atDtStatus
	 */
	public String getAtDtStatus() {
		return this.atDtStatus;
	}
	
	/**
	 * Column Info
	 * @return vl
	 */
	public String getVl() {
		return this.vl;
	}
	
	/**
	 * Column Info
	 * @return verify
	 */
	public String getVerify() {
		return this.verify;
	}
	
	/**
	 * Column Info
	 * @return mvmtDtHd
	 */
	public String getMvmtDtHd() {
		return this.mvmtDtHd;
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
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
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
	 * @return chssMvmtDt
	 */
	public String getChssMvmtDt() {
		return this.chssMvmtDt;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return atCntrNo
	 */
	public String getAtCntrNo() {
		return this.atCntrNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtDtDay
	 */
	public String getMvmtDtDay() {
		return this.mvmtDtDay;
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
	 * @return gateIoCd
	 */
	public String getGateIoCd() {
		return this.gateIoCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtCoCd
	 */
	public String getMvmtCoCd() {
		return this.mvmtCoCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dtCntrNo
	 */
	public String getDtCntrNo() {
		return this.dtCntrNo;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtRsnCd
	 */
	public String getMvmtRsnCd() {
		return this.mvmtRsnCd;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlg
	 */
	public String getMnlInpFlg() {
		return this.mnlInpFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	
	/**
	 * Column Info
	 * @return sysSeq
	 */
	public String getSysSeq() {
		return this.sysSeq;
	}
	

	/**
	 * Column Info
	 * @param atDtStatus
	 */
	public void setAtDtStatus(String atDtStatus) {
		this.atDtStatus = atDtStatus;
	}
	
	/**
	 * Column Info
	 * @param vl
	 */
	public void setVl(String vl) {
		this.vl = vl;
	}
	
	/**
	 * Column Info
	 * @param verify
	 */
	public void setVerify(String verify) {
		this.verify = verify;
	}
	
	/**
	 * Column Info
	 * @param mvmtDtHd
	 */
	public void setMvmtDtHd(String mvmtDtHd) {
		this.mvmtDtHd = mvmtDtHd;
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
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
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
	 * @param chssMvmtDt
	 */
	public void setChssMvmtDt(String chssMvmtDt) {
		this.chssMvmtDt = chssMvmtDt;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param atCntrNo
	 */
	public void setAtCntrNo(String atCntrNo) {
		this.atCntrNo = atCntrNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtDtDay
	 */
	public void setMvmtDtDay(String mvmtDtDay) {
		this.mvmtDtDay = mvmtDtDay;
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
	 * @param gateIoCd
	 */
	public void setGateIoCd(String gateIoCd) {
		this.gateIoCd = gateIoCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtCoCd
	 */
	public void setMvmtCoCd(String mvmtCoCd) {
		this.mvmtCoCd = mvmtCoCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dtCntrNo
	 */
	public void setDtCntrNo(String dtCntrNo) {
		this.dtCntrNo = dtCntrNo;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtRsnCd
	 */
	public void setMvmtRsnCd(String mvmtRsnCd) {
		this.mvmtRsnCd = mvmtRsnCd;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param mnlInpFlg
	 */
	public void setMnlInpFlg(String mnlInpFlg) {
		this.mnlInpFlg = mnlInpFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Column Info
	 * @param sysSeq
	 */
	public void setSysSeq(String sysSeq) {
		this.sysSeq = sysSeq;
	}
	
	public String getChssNo() {
		return chssNo;
	}

	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getScac() {
		return scac;
	}

	public void setScac(String scac) {
		this.scac = scac;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAtDtStatus(JSPUtil.getParameter(request, "at_dt_status", ""));
		setVl(JSPUtil.getParameter(request, "vl", ""));
		setVerify(JSPUtil.getParameter(request, "verify", ""));
		setMvmtDtHd(JSPUtil.getParameter(request, "mvmt_dt_hd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setDestYdCd(JSPUtil.getParameter(request, "dest_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChssMvmtDt(JSPUtil.getParameter(request, "chss_mvmt_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setAtCntrNo(JSPUtil.getParameter(request, "at_cntr_no", ""));
		setMvmtDtDay(JSPUtil.getParameter(request, "mvmt_dt_day", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setGateIoCd(JSPUtil.getParameter(request, "gate_io_cd", ""));
		setMvmtCoCd(JSPUtil.getParameter(request, "mvmt_co_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDtCntrNo(JSPUtil.getParameter(request, "dt_cntr_no", ""));
		setMgstNo(JSPUtil.getParameter(request, "mgst_no", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setMvmtRsnCd(JSPUtil.getParameter(request, "mvmt_rsn_cd", ""));
		setDelChk(JSPUtil.getParameter(request, "del_chk", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setMnlInpFlg(JSPUtil.getParameter(request, "mnl_inp_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
		setSysSeq(JSPUtil.getParameter(request, "sys_seq", ""));
		setChssNo(JSPUtil.getParameter(request, "chss_no", ""));
		setSpName(JSPUtil.getParameter(request, "sp_name", ""));
		setScac(JSPUtil.getParameter(request, "scac", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSMvmtBareMGTVO[]
	 */
	public MGSMvmtBareMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSMvmtBareMGTVO[]
	 */
	public MGSMvmtBareMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSMvmtBareMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] atDtStatus = (JSPUtil.getParameter(request, prefix	+ "at_dt_status", length));
			String[] vl = (JSPUtil.getParameter(request, prefix	+ "vl", length));
			String[] verify = (JSPUtil.getParameter(request, prefix	+ "verify", length));
			String[] mvmtDtHd = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt_hd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chssMvmtDt = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] atCntrNo = (JSPUtil.getParameter(request, prefix	+ "at_cntr_no", length));
			String[] mvmtDtDay = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt_day", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] gateIoCd = (JSPUtil.getParameter(request, prefix	+ "gate_io_cd", length));
			String[] mvmtCoCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_co_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dtCntrNo = (JSPUtil.getParameter(request, prefix	+ "dt_cntr_no", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] mvmtRsnCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_rsn_cd", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mnlInpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] sysSeq = (JSPUtil.getParameter(request, prefix	+ "sys_seq", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] scac = (JSPUtil.getParameter(request, prefix	+ "scac", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSMvmtBareMGTVO();
				if (atDtStatus[i] != null)
					model.setAtDtStatus(atDtStatus[i]);
				if (vl[i] != null)
					model.setVl(vl[i]);
				if (verify[i] != null)
					model.setVerify(verify[i]);
				if (mvmtDtHd[i] != null)
					model.setMvmtDtHd(mvmtDtHd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chssMvmtDt[i] != null)
					model.setChssMvmtDt(chssMvmtDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (atCntrNo[i] != null)
					model.setAtCntrNo(atCntrNo[i]);
				if (mvmtDtDay[i] != null)
					model.setMvmtDtDay(mvmtDtDay[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (gateIoCd[i] != null)
					model.setGateIoCd(gateIoCd[i]);
				if (mvmtCoCd[i] != null)
					model.setMvmtCoCd(mvmtCoCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dtCntrNo[i] != null)
					model.setDtCntrNo(dtCntrNo[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (mvmtRsnCd[i] != null)
					model.setMvmtRsnCd(mvmtRsnCd[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mnlInpFlg[i] != null)
					model.setMnlInpFlg(mnlInpFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (sysSeq[i] != null)
					model.setSysSeq(sysSeq[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (scac[i] != null)
					model.setScac(scac[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSMvmtBareMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSMvmtBareMGTVO[]
	 */
	public MGSMvmtBareMGTVO[] getCHSMvmtBareMGTVOs(){
		MGSMvmtBareMGTVO[] vos = (MGSMvmtBareMGTVO[])models.toArray(new MGSMvmtBareMGTVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.atDtStatus = this.atDtStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vl = this.vl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verify = this.verify .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDtHd = this.mvmtDtHd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt = this.chssMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atCntrNo = this.atCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDtDay = this.mvmtDtDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateIoCd = this.gateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtCoCd = this.mvmtCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtCntrNo = this.dtCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRsnCd = this.mvmtRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlg = this.mnlInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSeq = this.sysSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scac = this.scac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
