/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchRetroActFilterVO.java
*@FileTitle : RsltSearchRetroActFilterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.27 김대호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchRetroActFilterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchRetroActFilterVO> models = new ArrayList<RsltSearchRetroActFilterVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String ctrtRhqCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String rtAcptDt = null;
	/* Column Info */
	private String convAcptDt = null;
	/* Column Info */
	private String dayDiff = null;
	/* Column Info */
	private String ctrtTp = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String reqDt = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String reqOfc = null;
	/* Column Info */
	private String reqSrep = null;
	/* Column Info */
	private String aproOfc = null;
	/* Column Info */
	private String aproUsr = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String ctrtCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String ctrtPtyNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchRetroActFilterVO() {}

	public RsltSearchRetroActFilterVO(String ibflag, String rhqCd, String bkgOfcCd, String ctrtOfcCd, String ctrtRhqCd, String bkgNo, String tVvd, String etdDt, String rtAplyDt, String rtAcptDt, String convAcptDt, String dayDiff, String ctrtTp, String ctrtNo, String amdtSeq, String creDt, String reqDt, String effDt, String expDt, String aproDt, String fileDt, String reqOfc, String reqSrep, String aproOfc, String aproUsr, String svcScpCd, String porCd, String polCd, String podCd, String delCd, String shpr, String shprNm, String cnee, String cneeNm, String ntfy, String ntfyNm, String bkgCnt, String ctrtCnt, String pagerows, String obSlsOfcCd, String obSrepCd, String ctrtPtyNm ) {
		this.ibflag = ibflag;
		this.rhqCd = rhqCd;
		this.bkgOfcCd = bkgOfcCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.ctrtRhqCd = ctrtRhqCd;
		this.bkgNo = bkgNo;
		this.tVvd = tVvd;
		this.etdDt = etdDt;
		this.rtAplyDt = rtAplyDt;
		this.rtAcptDt = rtAcptDt;
		this.convAcptDt = convAcptDt;
		this.dayDiff = dayDiff;
		this.ctrtTp = ctrtTp;
		this.ctrtNo = ctrtNo;
		this.amdtSeq = amdtSeq;
		this.creDt = creDt;
		this.reqDt = reqDt;
		this.effDt = effDt;
		this.expDt = expDt;
		this.aproDt = aproDt;
		this.fileDt = fileDt;
		this.reqOfc = reqOfc;
		this.reqSrep = reqSrep;
		this.aproOfc = aproOfc;
		this.aproUsr = aproUsr;
		this.svcScpCd = svcScpCd;
		this.porCd = porCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.delCd = delCd;
		this.shpr = shpr;
		this.shprNm = shprNm;
		this.cnee = cnee;
		this.cneeNm = cneeNm;
		this.ntfy = ntfy;
		this.ntfyNm = ntfyNm;
		this.bkgCnt = bkgCnt;
		this.ctrtCnt = ctrtCnt;
		this.pagerows = pagerows;
		this.obSlsOfcCd = obSlsOfcCd;
		this.obSrepCd = obSrepCd;
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("ctrt_rhq_cd", getCtrtRhqCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("rt_acpt_dt", getRtAcptDt());
		this.hashColumns.put("conv_acpt_dt", getConvAcptDt());
		this.hashColumns.put("day_diff", getDayDiff());
		this.hashColumns.put("ctrt_tp", getCtrtTp());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("req_dt", getReqDt());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("req_ofc", getReqOfc());
		this.hashColumns.put("req_srep", getReqSrep());
		this.hashColumns.put("apro_ofc", getAproOfc());
		this.hashColumns.put("apro_usr", getAproUsr());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("ctrt_cnt", getCtrtCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("ctrt_rhq_cd", "ctrtRhqCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("rt_acpt_dt", "rtAcptDt");
		this.hashFields.put("conv_acpt_dt", "convAcptDt");
		this.hashFields.put("day_diff", "dayDiff");
		this.hashFields.put("ctrt_tp", "ctrtTp");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("req_dt", "reqDt");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("req_ofc", "reqOfc");
		this.hashFields.put("req_srep", "reqSrep");
		this.hashFields.put("apro_ofc", "aproOfc");
		this.hashFields.put("apro_usr", "aproUsr");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("ctrt_cnt", "ctrtCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		return this.hashFields;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtRhqCd
	 */
	public String getCtrtRhqCd() {
		return this.ctrtRhqCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return rtAcptDt
	 */
	public String getRtAcptDt() {
		return this.rtAcptDt;
	}
	
	/**
	 * Column Info
	 * @return convAcptDt
	 */
	public String getConvAcptDt() {
		return this.convAcptDt;
	}
	
	/**
	 * Column Info
	 * @return dayDiff
	 */
	public String getDayDiff() {
		return this.dayDiff;
	}
	
	/**
	 * Column Info
	 * @return ctrtTp
	 */
	public String getCtrtTp() {
		return this.ctrtTp;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return reqDt
	 */
	public String getReqDt() {
		return this.reqDt;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return reqOfc
	 */
	public String getReqOfc() {
		return this.reqOfc;
	}
	
	/**
	 * Column Info
	 * @return reqSrep
	 */
	public String getReqSrep() {
		return this.reqSrep;
	}
	
	/**
	 * Column Info
	 * @return aproOfc
	 */
	public String getAproOfc() {
		return this.aproOfc;
	}
	
	/**
	 * Column Info
	 * @return aproUsr
	 */
	public String getAproUsr() {
		return this.aproUsr;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
	}
	
	/**
	 * Column Info
	 * @return ctrtCnt
	 */
	public String getCtrtCnt() {
		return this.ctrtCnt;
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
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	
	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
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
	 * @param RhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtRhqCd
	 */
	public void setCtrtRhqCd(String ctrtRhqCd) {
		this.ctrtRhqCd = ctrtRhqCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param rtAcptDt
	 */
	public void setRtAcptDt(String rtAcptDt) {
		this.rtAcptDt = rtAcptDt;
	}
	
	/**
	 * Column Info
	 * @param convAcptDt
	 */
	public void setConvAcptDt(String convAcptDt) {
		this.convAcptDt = convAcptDt;
	}
	
	/**
	 * Column Info
	 * @param dayDiff
	 */
	public void setDayDiff(String dayDiff) {
		this.dayDiff = dayDiff;
	}
	
	/**
	 * Column Info
	 * @param CtrtTp
	 */
	public void setCtrtTp(String ctrtTp) {
		this.ctrtTp = ctrtTp;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param reqDt
	 */
	public void setReqDt(String reqDt) {
		this.reqDt = reqDt;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param reqOfc
	 */
	public void setReqOfc(String reqOfc) {
		this.reqOfc = reqOfc;
	}
	
	/**
	 * Column Info
	 * @param reqSrep
	 */
	public void setReqSrep(String reqSrep) {
		this.reqSrep = reqSrep;
	}
	
	/**
	 * Column Info
	 * @param aproOfc
	 */
	public void setAproOfc(String aproOfc) {
		this.aproOfc = aproOfc;
	}
	
	/**
	 * Column Info
	 * @param aproUsr
	 */
	public void setAproUsr(String aproUsr) {
		this.aproUsr = aproUsr;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	
	/**
	 * Column Info
	 * @param ctrtCnt
	 */
	public void setCtrtCnt(String ctrtCnt) {
		this.ctrtCnt = ctrtCnt;
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
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setCtrtRhqCd(JSPUtil.getParameter(request, prefix + "ctrt_rhq_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setRtAcptDt(JSPUtil.getParameter(request, prefix + "rt_acpt_dt", ""));
		setConvAcptDt(JSPUtil.getParameter(request, prefix + "conv_acpt_dt", ""));
		setDayDiff(JSPUtil.getParameter(request, prefix + "day_diff", ""));
		setCtrtTp(JSPUtil.getParameter(request, prefix + "ctrt_tp", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setReqDt(JSPUtil.getParameter(request, prefix + "req_dt", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setReqOfc(JSPUtil.getParameter(request, prefix + "req_ofc", ""));
		setReqSrep(JSPUtil.getParameter(request, prefix + "req_srep", ""));
		setAproOfc(JSPUtil.getParameter(request, prefix + "apro_ofc", ""));
		setAproUsr(JSPUtil.getParameter(request, prefix + "apro_usr", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setNtfy(JSPUtil.getParameter(request, prefix + "ntfy", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setCtrtCnt(JSPUtil.getParameter(request, prefix + "ctrt_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchRetroActFilterVO[]
	 */
	public RsltSearchRetroActFilterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchRetroActFilterVO[]
	 */
	public RsltSearchRetroActFilterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchRetroActFilterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] ctrtRhqCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_rhq_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] rtAcptDt = (JSPUtil.getParameter(request, prefix	+ "rt_acpt_dt", length));
			String[] convAcptDt = (JSPUtil.getParameter(request, prefix	+ "conv_acpt_dt", length));
			String[] dayDiff = (JSPUtil.getParameter(request, prefix	+ "day_diff", length));
			String[] ctrtTp = (JSPUtil.getParameter(request, prefix	+ "ctrt_tp", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] reqDt = (JSPUtil.getParameter(request, prefix	+ "req_dt", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] reqOfc = (JSPUtil.getParameter(request, prefix	+ "req_ofc", length));
			String[] reqSrep = (JSPUtil.getParameter(request, prefix	+ "req_srep", length));
			String[] aproOfc = (JSPUtil.getParameter(request, prefix	+ "apro_ofc", length));
			String[] aproUsr = (JSPUtil.getParameter(request, prefix	+ "apro_usr", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] ctrtCnt = (JSPUtil.getParameter(request, prefix	+ "ctrt_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchRetroActFilterVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (ctrtRhqCd[i] != null)
					model.setCtrtRhqCd(ctrtRhqCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (rtAcptDt[i] != null)
					model.setRtAcptDt(rtAcptDt[i]);
				if (convAcptDt[i] != null)
					model.setConvAcptDt(convAcptDt[i]);
				if (dayDiff[i] != null)
					model.setDayDiff(dayDiff[i]);
				if (ctrtTp[i] != null)
					model.setCtrtTp(ctrtTp[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (reqDt[i] != null)
					model.setReqDt(reqDt[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (reqOfc[i] != null)
					model.setReqOfc(reqOfc[i]);
				if (reqSrep[i] != null)
					model.setReqSrep(reqSrep[i]);
				if (aproOfc[i] != null)
					model.setAproOfc(aproOfc[i]);
				if (aproUsr[i] != null)
					model.setAproUsr(aproUsr[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (ctrtCnt[i] != null)
					model.setCtrtCnt(ctrtCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchRetroActFilterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchBkgStatusVO[]
	 */
	public RsltSearchRetroActFilterVO[] getRsltSearchRetroActFilterVOs(){
		RsltSearchRetroActFilterVO[] vos = (RsltSearchRetroActFilterVO[])models.toArray(new RsltSearchRetroActFilterVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRhqCd = this.ctrtRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAcptDt = this.rtAcptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convAcptDt = this.convAcptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dayDiff = this.dayDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtTp = this.ctrtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqDt = this.reqDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqOfc = this.reqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqSrep = this.reqSrep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfc = this.aproOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsr = this.aproUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCnt = this.ctrtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
