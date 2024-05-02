/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VslSkdCngHisVO.java
*@FileTitle : VslSkdCngHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2013.07.30 정상기 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 정상기
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdCngHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdCngHisVO> models = new ArrayList<VslSkdCngHisVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String hisDtlDeltDt = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String skdStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hisCreDt = null;
	/* Column Info */
	private String psdoVvdCd = null;
	/* Column Info */
	private String dlsEdiSndTgtFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String skdUsdIndCd = null;
	/* Column Info */
	private String hisCreUsrId = null;
	/* Column Info */
	private String skdVoyTpCd = null;
	/* Column Info */
	private String skdRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vvdHisSeq = null;
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String n1stPortBrthDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vskdCngTpCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String skdStsMnlFlg = null;
	/* Column Info */
	private String actCrrCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hisDeltProhiFlg = null;
	/* Column Info */
	private String ruseProhiFlg = null;
	/* Column Info */
	private String stPortCd = null;
	
	/* Column Info */
	private String skdHisDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslSkdCngHisVO() {}

	public VslSkdCngHisVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vvdHisSeq, String vskdCngTpCd, String vslSlanCd, String skdStsCd, String ruseProhiFlg, String skdStsMnlFlg, String dlsEdiSndTgtFlg, String skdVoyTpCd, String skdUsdIndCd, String pfSkdTpCd, String stPortCd, String n1stPortBrthDt, String psdoVvdCd, String coCd, String actCrrCd, String skdRmk, String creUsrId, String creDt, String updUsrId, String updDt, String hisCreUsrId, String hisCreDt, String hisDeltProhiFlg, String hisDtlDeltDt, String skdHisDesc) {
		this.vslCd = vslCd;
		this.creDt = creDt;
		this.hisDtlDeltDt = hisDtlDeltDt;
		this.pfSkdTpCd = pfSkdTpCd;
		this.vslSlanCd = vslSlanCd;
		this.skdStsCd = skdStsCd;
		this.pagerows = pagerows;
		this.hisCreDt = hisCreDt;
		this.psdoVvdCd = psdoVvdCd;
		this.dlsEdiSndTgtFlg = dlsEdiSndTgtFlg;
		this.ibflag = ibflag;
		this.skdUsdIndCd = skdUsdIndCd;
		this.hisCreUsrId = hisCreUsrId;
		this.skdVoyTpCd = skdVoyTpCd;
		this.skdRmk = skdRmk;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.vvdHisSeq = vvdHisSeq;
		this.coCd = coCd;
		this.n1stPortBrthDt = n1stPortBrthDt;
		this.skdVoyNo = skdVoyNo;
		this.vskdCngTpCd = vskdCngTpCd;
		this.skdDirCd = skdDirCd;
		this.skdStsMnlFlg = skdStsMnlFlg;
		this.actCrrCd = actCrrCd;
		this.creUsrId = creUsrId;
		this.hisDeltProhiFlg = hisDeltProhiFlg;
		this.ruseProhiFlg = ruseProhiFlg;
		this.stPortCd = stPortCd;
		
		this.skdHisDesc = skdHisDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("his_dtl_delt_dt", getHisDtlDeltDt());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("skd_sts_cd", getSkdStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("his_cre_dt", getHisCreDt());
		this.hashColumns.put("psdo_vvd_cd", getPsdoVvdCd());
		this.hashColumns.put("dls_edi_snd_tgt_flg", getDlsEdiSndTgtFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("skd_usd_ind_cd", getSkdUsdIndCd());
		this.hashColumns.put("his_cre_usr_id", getHisCreUsrId());
		this.hashColumns.put("skd_voy_tp_cd", getSkdVoyTpCd());
		this.hashColumns.put("skd_rmk", getSkdRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vvd_his_seq", getVvdHisSeq());
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("n1st_port_brth_dt", getN1stPortBrthDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vskd_cng_tp_cd", getVskdCngTpCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_sts_mnl_flg", getSkdStsMnlFlg());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("his_delt_prohi_flg", getHisDeltProhiFlg());
		this.hashColumns.put("ruse_prohi_flg", getRuseProhiFlg());
		this.hashColumns.put("st_port_cd", getStPortCd());
		
		this.hashColumns.put("skd_his_desc", getSkdHisDesc());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("his_dtl_delt_dt", "hisDtlDeltDt");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("skd_sts_cd", "skdStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("his_cre_dt", "hisCreDt");
		this.hashFields.put("psdo_vvd_cd", "psdoVvdCd");
		this.hashFields.put("dls_edi_snd_tgt_flg", "dlsEdiSndTgtFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("skd_usd_ind_cd", "skdUsdIndCd");
		this.hashFields.put("his_cre_usr_id", "hisCreUsrId");
		this.hashFields.put("skd_voy_tp_cd", "skdVoyTpCd");
		this.hashFields.put("skd_rmk", "skdRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vvd_his_seq", "vvdHisSeq");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("n1st_port_brth_dt", "n1stPortBrthDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vskd_cng_tp_cd", "vskdCngTpCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_sts_mnl_flg", "skdStsMnlFlg");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("his_delt_prohi_flg", "hisDeltProhiFlg");
		this.hashFields.put("ruse_prohi_flg", "ruseProhiFlg");
		this.hashFields.put("st_port_cd", "stPortCd");
		
		this.hashFields.put("skd_his_desc", "skdHisDesc");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return hisDtlDeltDt
	 */
	public String getHisDtlDeltDt() {
		return this.hisDtlDeltDt;
	}
	
	/**
	 * Column Info
	 * @return pfSkdTpCd
	 */
	public String getPfSkdTpCd() {
		return this.pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return skdStsCd
	 */
	public String getSkdStsCd() {
		return this.skdStsCd;
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
	 * @return hisCreDt
	 */
	public String getHisCreDt() {
		return this.hisCreDt;
	}
	
	/**
	 * Column Info
	 * @return psdoVvdCd
	 */
	public String getPsdoVvdCd() {
		return this.psdoVvdCd;
	}
	
	/**
	 * Column Info
	 * @return dlsEdiSndTgtFlg
	 */
	public String getDlsEdiSndTgtFlg() {
		return this.dlsEdiSndTgtFlg;
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
	 * @return skdUsdIndCd
	 */
	public String getSkdUsdIndCd() {
		return this.skdUsdIndCd;
	}
	
	/**
	 * Column Info
	 * @return hisCreUsrId
	 */
	public String getHisCreUsrId() {
		return this.hisCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return skdVoyTpCd
	 */
	public String getSkdVoyTpCd() {
		return this.skdVoyTpCd;
	}
	
	/**
	 * Column Info
	 * @return skdRmk
	 */
	public String getSkdRmk() {
		return this.skdRmk;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return vvdHisSeq
	 */
	public String getVvdHisSeq() {
		return this.vvdHisSeq;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPortBrthDt
	 */
	public String getN1stPortBrthDt() {
		return this.n1stPortBrthDt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vskdCngTpCd
	 */
	public String getVskdCngTpCd() {
		return this.vskdCngTpCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return skdStsMnlFlg
	 */
	public String getSkdStsMnlFlg() {
		return this.skdStsMnlFlg;
	}
	
	/**
	 * Column Info
	 * @return actCrrCd
	 */
	public String getActCrrCd() {
		return this.actCrrCd;
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
	 * @return hisDeltProhiFlg
	 */
	public String getHisDeltProhiFlg() {
		return this.hisDeltProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return ruseProhiFlg
	 */
	public String getRuseProhiFlg() {
		return this.ruseProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return stPortCd
	 */
	public String getStPortCd() {
		return this.stPortCd;
	}
	
	/**
	 * Column Info
	 * @return skdHisDesc
	 */
	public String getSkdHisDesc() {
		return this.skdHisDesc;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param hisDtlDeltDt
	 */
	public void setHisDtlDeltDt(String hisDtlDeltDt) {
		this.hisDtlDeltDt = hisDtlDeltDt;
	}
	
	/**
	 * Column Info
	 * @param pfSkdTpCd
	 */
	public void setPfSkdTpCd(String pfSkdTpCd) {
		this.pfSkdTpCd = pfSkdTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param skdStsCd
	 */
	public void setSkdStsCd(String skdStsCd) {
		this.skdStsCd = skdStsCd;
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
	 * @param hisCreDt
	 */
	public void setHisCreDt(String hisCreDt) {
		this.hisCreDt = hisCreDt;
	}
	
	/**
	 * Column Info
	 * @param psdoVvdCd
	 */
	public void setPsdoVvdCd(String psdoVvdCd) {
		this.psdoVvdCd = psdoVvdCd;
	}
	
	/**
	 * Column Info
	 * @param dlsEdiSndTgtFlg
	 */
	public void setDlsEdiSndTgtFlg(String dlsEdiSndTgtFlg) {
		this.dlsEdiSndTgtFlg = dlsEdiSndTgtFlg;
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
	 * @param skdUsdIndCd
	 */
	public void setSkdUsdIndCd(String skdUsdIndCd) {
		this.skdUsdIndCd = skdUsdIndCd;
	}
	
	/**
	 * Column Info
	 * @param hisCreUsrId
	 */
	public void setHisCreUsrId(String hisCreUsrId) {
		this.hisCreUsrId = hisCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param skdVoyTpCd
	 */
	public void setSkdVoyTpCd(String skdVoyTpCd) {
		this.skdVoyTpCd = skdVoyTpCd;
	}
	
	/**
	 * Column Info
	 * @param skdRmk
	 */
	public void setSkdRmk(String skdRmk) {
		this.skdRmk = skdRmk;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param vvdHisSeq
	 */
	public void setVvdHisSeq(String vvdHisSeq) {
		this.vvdHisSeq = vvdHisSeq;
	}
	
	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPortBrthDt
	 */
	public void setN1stPortBrthDt(String n1stPortBrthDt) {
		this.n1stPortBrthDt = n1stPortBrthDt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vskdCngTpCd
	 */
	public void setVskdCngTpCd(String vskdCngTpCd) {
		this.vskdCngTpCd = vskdCngTpCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param skdStsMnlFlg
	 */
	public void setSkdStsMnlFlg(String skdStsMnlFlg) {
		this.skdStsMnlFlg = skdStsMnlFlg;
	}
	
	/**
	 * Column Info
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd) {
		this.actCrrCd = actCrrCd;
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
	 * @param hisDeltProhiFlg
	 */
	public void setHisDeltProhiFlg(String hisDeltProhiFlg) {
		this.hisDeltProhiFlg = hisDeltProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param ruseProhiFlg
	 */
	public void setRuseProhiFlg(String ruseProhiFlg) {
		this.ruseProhiFlg = ruseProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param stPortCd
	 */
	public void setStPortCd(String stPortCd) {
		this.stPortCd = stPortCd;
	}
	
	/**
	 * Column Info
	 * @param skdHisDesc
	 */
	public void setSkdHisDesc(String skdHisDesc) {
		this.skdHisDesc = skdHisDesc;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setHisDtlDeltDt(JSPUtil.getParameter(request, prefix + "his_dtl_delt_dt", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setSkdStsCd(JSPUtil.getParameter(request, prefix + "skd_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHisCreDt(JSPUtil.getParameter(request, prefix + "his_cre_dt", ""));
		setPsdoVvdCd(JSPUtil.getParameter(request, prefix + "psdo_vvd_cd", ""));
		setDlsEdiSndTgtFlg(JSPUtil.getParameter(request, prefix + "dls_edi_snd_tgt_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSkdUsdIndCd(JSPUtil.getParameter(request, prefix + "skd_usd_ind_cd", ""));
		setHisCreUsrId(JSPUtil.getParameter(request, prefix + "his_cre_usr_id", ""));
		setSkdVoyTpCd(JSPUtil.getParameter(request, prefix + "skd_voy_tp_cd", ""));
		setSkdRmk(JSPUtil.getParameter(request, prefix + "skd_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVvdHisSeq(JSPUtil.getParameter(request, prefix + "vvd_his_seq", ""));
		setCoCd(JSPUtil.getParameter(request, prefix + "co_cd", ""));
		setN1stPortBrthDt(JSPUtil.getParameter(request, prefix + "n1st_port_brth_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVskdCngTpCd(JSPUtil.getParameter(request, prefix + "vskd_cng_tp_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSkdStsMnlFlg(JSPUtil.getParameter(request, prefix + "skd_sts_mnl_flg", ""));
		setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setHisDeltProhiFlg(JSPUtil.getParameter(request, prefix + "his_delt_prohi_flg", ""));
		setRuseProhiFlg(JSPUtil.getParameter(request, prefix + "ruse_prohi_flg", ""));
		setStPortCd(JSPUtil.getParameter(request, prefix + "st_port_cd", ""));
		
		setSkdHisDesc(JSPUtil.getParameter(request, prefix + "skd_his_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdCngHisVO[]
	 */
	public VslSkdCngHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdCngHisVO[]
	 */
	public VslSkdCngHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdCngHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] hisDtlDeltDt = (JSPUtil.getParameter(request, prefix	+ "his_dtl_delt_dt", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] skdStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hisCreDt = (JSPUtil.getParameter(request, prefix	+ "his_cre_dt", length));
			String[] psdoVvdCd = (JSPUtil.getParameter(request, prefix	+ "psdo_vvd_cd", length));
			String[] dlsEdiSndTgtFlg = (JSPUtil.getParameter(request, prefix	+ "dls_edi_snd_tgt_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] skdUsdIndCd = (JSPUtil.getParameter(request, prefix	+ "skd_usd_ind_cd", length));
			String[] hisCreUsrId = (JSPUtil.getParameter(request, prefix	+ "his_cre_usr_id", length));
			String[] skdVoyTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_voy_tp_cd", length));
			String[] skdRmk = (JSPUtil.getParameter(request, prefix	+ "skd_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vvdHisSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_his_seq", length));
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] n1stPortBrthDt = (JSPUtil.getParameter(request, prefix	+ "n1st_port_brth_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vskdCngTpCd = (JSPUtil.getParameter(request, prefix	+ "vskd_cng_tp_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] skdStsMnlFlg = (JSPUtil.getParameter(request, prefix	+ "skd_sts_mnl_flg", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hisDeltProhiFlg = (JSPUtil.getParameter(request, prefix	+ "his_delt_prohi_flg", length));
			String[] ruseProhiFlg = (JSPUtil.getParameter(request, prefix	+ "ruse_prohi_flg", length));
			String[] stPortCd = (JSPUtil.getParameter(request, prefix	+ "st_port_cd", length));
			
			String[] skdHisDesc = (JSPUtil.getParameter(request, prefix	+ "skd_his_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdCngHisVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (hisDtlDeltDt[i] != null)
					model.setHisDtlDeltDt(hisDtlDeltDt[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (skdStsCd[i] != null)
					model.setSkdStsCd(skdStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hisCreDt[i] != null)
					model.setHisCreDt(hisCreDt[i]);
				if (psdoVvdCd[i] != null)
					model.setPsdoVvdCd(psdoVvdCd[i]);
				if (dlsEdiSndTgtFlg[i] != null)
					model.setDlsEdiSndTgtFlg(dlsEdiSndTgtFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (skdUsdIndCd[i] != null)
					model.setSkdUsdIndCd(skdUsdIndCd[i]);
				if (hisCreUsrId[i] != null)
					model.setHisCreUsrId(hisCreUsrId[i]);
				if (skdVoyTpCd[i] != null)
					model.setSkdVoyTpCd(skdVoyTpCd[i]);
				if (skdRmk[i] != null)
					model.setSkdRmk(skdRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vvdHisSeq[i] != null)
					model.setVvdHisSeq(vvdHisSeq[i]);
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (n1stPortBrthDt[i] != null)
					model.setN1stPortBrthDt(n1stPortBrthDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vskdCngTpCd[i] != null)
					model.setVskdCngTpCd(vskdCngTpCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (skdStsMnlFlg[i] != null)
					model.setSkdStsMnlFlg(skdStsMnlFlg[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hisDeltProhiFlg[i] != null)
					model.setHisDeltProhiFlg(hisDeltProhiFlg[i]);
				if (ruseProhiFlg[i] != null)
					model.setRuseProhiFlg(ruseProhiFlg[i]);
				if (stPortCd[i] != null)
					model.setStPortCd(stPortCd[i]);
				
				if (skdHisDesc[i] != null)
					model.setSkdHisDesc(skdHisDesc[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdCngHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdCngHisVO[]
	 */
	public VslSkdCngHisVO[] getVslSkdCngHisVOs(){
		VslSkdCngHisVO[] vos = (VslSkdCngHisVO[])models.toArray(new VslSkdCngHisVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisDtlDeltDt = this.hisDtlDeltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsCd = this.skdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCreDt = this.hisCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psdoVvdCd = this.psdoVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlsEdiSndTgtFlg = this.dlsEdiSndTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdUsdIndCd = this.skdUsdIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCreUsrId = this.hisCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyTpCd = this.skdVoyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdRmk = this.skdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdHisSeq = this.vvdHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortBrthDt = this.n1stPortBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdCngTpCd = this.vskdCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsMnlFlg = this.skdStsMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisDeltProhiFlg = this.hisDeltProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruseProhiFlg = this.ruseProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPortCd = this.stPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.skdHisDesc = this.skdHisDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
