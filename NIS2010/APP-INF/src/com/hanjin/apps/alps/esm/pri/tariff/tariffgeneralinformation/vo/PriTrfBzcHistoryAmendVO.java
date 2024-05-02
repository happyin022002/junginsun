/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PriTrfBzcHistoryAmendVO.java
*@FileTitle : PriTrfBzcHistoryAmendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.19
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.11.19 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo;

import java.lang.reflect.Field;
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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriTrfBzcHistoryAmendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriTrfBzcHistoryAmendVO> models = new ArrayList<PriTrfBzcHistoryAmendVO>();
	
	/* Column Info */
	private String pubCntcPsonNm = null;
	/* Column Info */
	private String trfBzcVolQty = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String trfBzcWgt = null;
	/* Column Info */
	private String pubDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String accessDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pubOfcAddr = null;
	/* Column Info */
	private String pubOfcSteCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String pubOfcCtyNm = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String pubOfcCntNm = null;
	/* Column Info */
	private String trfBzcTpCd = null;
	/* Column Info */
	private String trfBzcStsCdNm = null;
	/* Column Info */
	private String pubOfcPhnNo = null;
	/* Column Info */
	private String trfBzcVolUtCd = null;
	/* Column Info */
	private String pubOfcZipCd = null;
	/* Column Info */
	private String pubOfcFaxNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trfBzcWgtUtCd = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String trfNm = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String trfInlndFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriTrfBzcHistoryAmendVO() {}

	public PriTrfBzcHistoryAmendVO(String ibflag, String pagerows, String amdtSeq, String creDt, String effDt, String expDt, String pubDt, String trfBzcStsCdNm, String rqstOfcCd, String creUsrId, String aproOfcCd, String trfBzcTpCd, String trfBzcWgt, String trfBzcWgtUtCd, String trfBzcVolQty, String trfBzcVolUtCd, String currCd, String pubCntcPsonNm, String pubOfcAddr, String pubOfcPhnNo, String pubOfcCtyNm, String pubOfcSteCd, String pubOfcZipCd, String pubOfcCntNm, String pubOfcFaxNo, String trfNo, String trfPfxCd, String trfNm, String trfInlndFlg, String accessDt) {
		this.pubCntcPsonNm = pubCntcPsonNm;
		this.trfBzcVolQty = trfBzcVolQty;
		this.currCd = currCd;
		this.amdtSeq = amdtSeq;
		this.trfBzcWgt = trfBzcWgt;
		this.pubDt = pubDt;
		this.creDt = creDt;
		this.aproOfcCd = aproOfcCd;
		this.accessDt = accessDt;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.pubOfcAddr = pubOfcAddr;
		this.pubOfcSteCd = pubOfcSteCd;
		this.expDt = expDt;
		this.pubOfcCtyNm = pubOfcCtyNm;
		this.trfPfxCd = trfPfxCd;
		this.pubOfcCntNm = pubOfcCntNm;
		this.trfBzcTpCd = trfBzcTpCd;
		this.trfBzcStsCdNm = trfBzcStsCdNm;
		this.pubOfcPhnNo = pubOfcPhnNo;
		this.trfBzcVolUtCd = trfBzcVolUtCd;
		this.pubOfcZipCd = pubOfcZipCd;
		this.pubOfcFaxNo = pubOfcFaxNo;
		this.creUsrId = creUsrId;
		this.trfBzcWgtUtCd = trfBzcWgtUtCd;
		this.trfNo = trfNo;
		this.trfNm = trfNm;
		this.rqstOfcCd = rqstOfcCd;
		this.trfInlndFlg = trfInlndFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pub_cntc_pson_nm", getPubCntcPsonNm());
		this.hashColumns.put("trf_bzc_vol_qty", getTrfBzcVolQty());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("trf_bzc_wgt", getTrfBzcWgt());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("access_dt", getAccessDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pub_ofc_addr", getPubOfcAddr());
		this.hashColumns.put("pub_ofc_ste_cd", getPubOfcSteCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("pub_ofc_cty_nm", getPubOfcCtyNm());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("pub_ofc_cnt_nm", getPubOfcCntNm());
		this.hashColumns.put("trf_bzc_tp_cd", getTrfBzcTpCd());
		this.hashColumns.put("trf_bzc_sts_cd_nm", getTrfBzcStsCdNm());
		this.hashColumns.put("pub_ofc_phn_no", getPubOfcPhnNo());
		this.hashColumns.put("trf_bzc_vol_ut_cd", getTrfBzcVolUtCd());
		this.hashColumns.put("pub_ofc_zip_cd", getPubOfcZipCd());
		this.hashColumns.put("pub_ofc_fax_no", getPubOfcFaxNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trf_bzc_wgt_ut_cd", getTrfBzcWgtUtCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("trf_nm", getTrfNm());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("trf_inlnd_flg", getTrfInlndFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pub_cntc_pson_nm", "pubCntcPsonNm");
		this.hashFields.put("trf_bzc_vol_qty", "trfBzcVolQty");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("trf_bzc_wgt", "trfBzcWgt");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("access_dt", "accessDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pub_ofc_addr", "pubOfcAddr");
		this.hashFields.put("pub_ofc_ste_cd", "pubOfcSteCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("pub_ofc_cty_nm", "pubOfcCtyNm");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("pub_ofc_cnt_nm", "pubOfcCntNm");
		this.hashFields.put("trf_bzc_tp_cd", "trfBzcTpCd");
		this.hashFields.put("trf_bzc_sts_cd_nm", "trfBzcStsCdNm");
		this.hashFields.put("pub_ofc_phn_no", "pubOfcPhnNo");
		this.hashFields.put("trf_bzc_vol_ut_cd", "trfBzcVolUtCd");
		this.hashFields.put("pub_ofc_zip_cd", "pubOfcZipCd");
		this.hashFields.put("pub_ofc_fax_no", "pubOfcFaxNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trf_bzc_wgt_ut_cd", "trfBzcWgtUtCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("trf_nm", "trfNm");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("trf_inlnd_flg", "trfInlndFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pubCntcPsonNm
	 */
	public String getPubCntcPsonNm() {
		return this.pubCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return trfBzcVolQty
	 */
	public String getTrfBzcVolQty() {
		return this.trfBzcVolQty;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return trfBzcWgt
	 */
	public String getTrfBzcWgt() {
		return this.trfBzcWgt;
	}
	
	/**
	 * Column Info
	 * @return pubDt
	 */
	public String getPubDt() {
		return this.pubDt;
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
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return accessDt
	 */
	public String getAccessDt() {
		return this.accessDt;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return pubOfcAddr
	 */
	public String getPubOfcAddr() {
		return this.pubOfcAddr;
	}
	
	/**
	 * Column Info
	 * @return pubOfcSteCd
	 */
	public String getPubOfcSteCd() {
		return this.pubOfcSteCd;
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
	 * @return pubOfcCtyNm
	 */
	public String getPubOfcCtyNm() {
		return this.pubOfcCtyNm;
	}
	
	/**
	 * Column Info
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @return pubOfcCntNm
	 */
	public String getPubOfcCntNm() {
		return this.pubOfcCntNm;
	}
	
	/**
	 * Column Info
	 * @return trfBzcTpCd
	 */
	public String getTrfBzcTpCd() {
		return this.trfBzcTpCd;
	}
	
	/**
	 * Column Info
	 * @return trfBzcStsCdNm
	 */
	public String getTrfBzcStsCdNm() {
		return this.trfBzcStsCdNm;
	}
	
	/**
	 * Column Info
	 * @return pubOfcPhnNo
	 */
	public String getPubOfcPhnNo() {
		return this.pubOfcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return trfBzcVolUtCd
	 */
	public String getTrfBzcVolUtCd() {
		return this.trfBzcVolUtCd;
	}
	
	/**
	 * Column Info
	 * @return pubOfcZipCd
	 */
	public String getPubOfcZipCd() {
		return this.pubOfcZipCd;
	}
	
	/**
	 * Column Info
	 * @return pubOfcFaxNo
	 */
	public String getPubOfcFaxNo() {
		return this.pubOfcFaxNo;
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
	 * @return trfBzcWgtUtCd
	 */
	public String getTrfBzcWgtUtCd() {
		return this.trfBzcWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return trfNm
	 */
	public String getTrfNm() {
		return this.trfNm;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trfInlndFlg
	 */
	public String getTrfInlndFlg() {
		return this.trfInlndFlg;
	}
	

	/**
	 * Column Info
	 * @param pubCntcPsonNm
	 */
	public void setPubCntcPsonNm(String pubCntcPsonNm) {
		this.pubCntcPsonNm = pubCntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param trfBzcVolQty
	 */
	public void setTrfBzcVolQty(String trfBzcVolQty) {
		this.trfBzcVolQty = trfBzcVolQty;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param trfBzcWgt
	 */
	public void setTrfBzcWgt(String trfBzcWgt) {
		this.trfBzcWgt = trfBzcWgt;
	}
	
	/**
	 * Column Info
	 * @param pubDt
	 */
	public void setPubDt(String pubDt) {
		this.pubDt = pubDt;
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
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param accessDt
	 */
	public void setAccessDt(String accessDt) {
		this.accessDt = accessDt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param pubOfcAddr
	 */
	public void setPubOfcAddr(String pubOfcAddr) {
		this.pubOfcAddr = pubOfcAddr;
	}
	
	/**
	 * Column Info
	 * @param pubOfcSteCd
	 */
	public void setPubOfcSteCd(String pubOfcSteCd) {
		this.pubOfcSteCd = pubOfcSteCd;
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
	 * @param pubOfcCtyNm
	 */
	public void setPubOfcCtyNm(String pubOfcCtyNm) {
		this.pubOfcCtyNm = pubOfcCtyNm;
	}
	
	/**
	 * Column Info
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @param pubOfcCntNm
	 */
	public void setPubOfcCntNm(String pubOfcCntNm) {
		this.pubOfcCntNm = pubOfcCntNm;
	}
	
	/**
	 * Column Info
	 * @param trfBzcTpCd
	 */
	public void setTrfBzcTpCd(String trfBzcTpCd) {
		this.trfBzcTpCd = trfBzcTpCd;
	}
	
	/**
	 * Column Info
	 * @param trfBzcStsCdNm
	 */
	public void setTrfBzcStsCdNm(String trfBzcStsCdNm) {
		this.trfBzcStsCdNm = trfBzcStsCdNm;
	}
	
	/**
	 * Column Info
	 * @param pubOfcPhnNo
	 */
	public void setPubOfcPhnNo(String pubOfcPhnNo) {
		this.pubOfcPhnNo = pubOfcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param trfBzcVolUtCd
	 */
	public void setTrfBzcVolUtCd(String trfBzcVolUtCd) {
		this.trfBzcVolUtCd = trfBzcVolUtCd;
	}
	
	/**
	 * Column Info
	 * @param pubOfcZipCd
	 */
	public void setPubOfcZipCd(String pubOfcZipCd) {
		this.pubOfcZipCd = pubOfcZipCd;
	}
	
	/**
	 * Column Info
	 * @param pubOfcFaxNo
	 */
	public void setPubOfcFaxNo(String pubOfcFaxNo) {
		this.pubOfcFaxNo = pubOfcFaxNo;
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
	 * @param trfBzcWgtUtCd
	 */
	public void setTrfBzcWgtUtCd(String trfBzcWgtUtCd) {
		this.trfBzcWgtUtCd = trfBzcWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param trfNm
	 */
	public void setTrfNm(String trfNm) {
		this.trfNm = trfNm;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trfInlndFlg
	 */
	public void setTrfInlndFlg(String trfInlndFlg) {
		this.trfInlndFlg = trfInlndFlg;
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
		setPubCntcPsonNm(JSPUtil.getParameter(request, prefix + "pub_cntc_pson_nm", ""));
		setTrfBzcVolQty(JSPUtil.getParameter(request, prefix + "trf_bzc_vol_qty", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setTrfBzcWgt(JSPUtil.getParameter(request, prefix + "trf_bzc_wgt", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setAccessDt(JSPUtil.getParameter(request, prefix + "access_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPubOfcAddr(JSPUtil.getParameter(request, prefix + "pub_ofc_addr", ""));
		setPubOfcSteCd(JSPUtil.getParameter(request, prefix + "pub_ofc_ste_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setPubOfcCtyNm(JSPUtil.getParameter(request, prefix + "pub_ofc_cty_nm", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setPubOfcCntNm(JSPUtil.getParameter(request, prefix + "pub_ofc_cnt_nm", ""));
		setTrfBzcTpCd(JSPUtil.getParameter(request, prefix + "trf_bzc_tp_cd", ""));
		setTrfBzcStsCdNm(JSPUtil.getParameter(request, prefix + "trf_bzc_sts_cd_nm", ""));
		setPubOfcPhnNo(JSPUtil.getParameter(request, prefix + "pub_ofc_phn_no", ""));
		setTrfBzcVolUtCd(JSPUtil.getParameter(request, prefix + "trf_bzc_vol_ut_cd", ""));
		setPubOfcZipCd(JSPUtil.getParameter(request, prefix + "pub_ofc_zip_cd", ""));
		setPubOfcFaxNo(JSPUtil.getParameter(request, prefix + "pub_ofc_fax_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrfBzcWgtUtCd(JSPUtil.getParameter(request, prefix + "trf_bzc_wgt_ut_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setTrfNm(JSPUtil.getParameter(request, prefix + "trf_nm", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setTrfInlndFlg(JSPUtil.getParameter(request, prefix + "trf_inlnd_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriTrfBzcHistoryAmendVO[]
	 */
	public PriTrfBzcHistoryAmendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriTrfBzcHistoryAmendVO[]
	 */
	public PriTrfBzcHistoryAmendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriTrfBzcHistoryAmendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pubCntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "pub_cntc_pson_nm", length));
			String[] trfBzcVolQty = (JSPUtil.getParameter(request, prefix	+ "trf_bzc_vol_qty", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] trfBzcWgt = (JSPUtil.getParameter(request, prefix	+ "trf_bzc_wgt", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] accessDt = (JSPUtil.getParameter(request, prefix	+ "access_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pubOfcAddr = (JSPUtil.getParameter(request, prefix	+ "pub_ofc_addr", length));
			String[] pubOfcSteCd = (JSPUtil.getParameter(request, prefix	+ "pub_ofc_ste_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] pubOfcCtyNm = (JSPUtil.getParameter(request, prefix	+ "pub_ofc_cty_nm", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] pubOfcCntNm = (JSPUtil.getParameter(request, prefix	+ "pub_ofc_cnt_nm", length));
			String[] trfBzcTpCd = (JSPUtil.getParameter(request, prefix	+ "trf_bzc_tp_cd", length));
			String[] trfBzcStsCdNm = (JSPUtil.getParameter(request, prefix	+ "trf_bzc_sts_cd_nm", length));
			String[] pubOfcPhnNo = (JSPUtil.getParameter(request, prefix	+ "pub_ofc_phn_no", length));
			String[] trfBzcVolUtCd = (JSPUtil.getParameter(request, prefix	+ "trf_bzc_vol_ut_cd", length));
			String[] pubOfcZipCd = (JSPUtil.getParameter(request, prefix	+ "pub_ofc_zip_cd", length));
			String[] pubOfcFaxNo = (JSPUtil.getParameter(request, prefix	+ "pub_ofc_fax_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trfBzcWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "trf_bzc_wgt_ut_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] trfNm = (JSPUtil.getParameter(request, prefix	+ "trf_nm", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] trfInlndFlg = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriTrfBzcHistoryAmendVO();
				if (pubCntcPsonNm[i] != null)
					model.setPubCntcPsonNm(pubCntcPsonNm[i]);
				if (trfBzcVolQty[i] != null)
					model.setTrfBzcVolQty(trfBzcVolQty[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (trfBzcWgt[i] != null)
					model.setTrfBzcWgt(trfBzcWgt[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (accessDt[i] != null)
					model.setAccessDt(accessDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pubOfcAddr[i] != null)
					model.setPubOfcAddr(pubOfcAddr[i]);
				if (pubOfcSteCd[i] != null)
					model.setPubOfcSteCd(pubOfcSteCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (pubOfcCtyNm[i] != null)
					model.setPubOfcCtyNm(pubOfcCtyNm[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (pubOfcCntNm[i] != null)
					model.setPubOfcCntNm(pubOfcCntNm[i]);
				if (trfBzcTpCd[i] != null)
					model.setTrfBzcTpCd(trfBzcTpCd[i]);
				if (trfBzcStsCdNm[i] != null)
					model.setTrfBzcStsCdNm(trfBzcStsCdNm[i]);
				if (pubOfcPhnNo[i] != null)
					model.setPubOfcPhnNo(pubOfcPhnNo[i]);
				if (trfBzcVolUtCd[i] != null)
					model.setTrfBzcVolUtCd(trfBzcVolUtCd[i]);
				if (pubOfcZipCd[i] != null)
					model.setPubOfcZipCd(pubOfcZipCd[i]);
				if (pubOfcFaxNo[i] != null)
					model.setPubOfcFaxNo(pubOfcFaxNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trfBzcWgtUtCd[i] != null)
					model.setTrfBzcWgtUtCd(trfBzcWgtUtCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (trfNm[i] != null)
					model.setTrfNm(trfNm[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (trfInlndFlg[i] != null)
					model.setTrfInlndFlg(trfInlndFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriTrfBzcHistoryAmendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriTrfBzcHistoryAmendVO[]
	 */
	public PriTrfBzcHistoryAmendVO[] getPriTrfBzcHistoryAmendVOs(){
		PriTrfBzcHistoryAmendVO[] vos = (PriTrfBzcHistoryAmendVO[])models.toArray(new PriTrfBzcHistoryAmendVO[models.size()]);
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
		this.pubCntcPsonNm = this.pubCntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfBzcVolQty = this.trfBzcVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfBzcWgt = this.trfBzcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accessDt = this.accessDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubOfcAddr = this.pubOfcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubOfcSteCd = this.pubOfcSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubOfcCtyNm = this.pubOfcCtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubOfcCntNm = this.pubOfcCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfBzcTpCd = this.trfBzcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfBzcStsCdNm = this.trfBzcStsCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubOfcPhnNo = this.pubOfcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfBzcVolUtCd = this.trfBzcVolUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubOfcZipCd = this.pubOfcZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubOfcFaxNo = this.pubOfcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfBzcWgtUtCd = this.trfBzcWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNm = this.trfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndFlg = this.trfInlndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
