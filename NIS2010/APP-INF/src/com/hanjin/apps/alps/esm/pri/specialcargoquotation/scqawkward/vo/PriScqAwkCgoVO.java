/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PriScqAwkCgoVO.java
*@FileTitle : PriScqAwkCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.20
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.04.20 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriScqAwkCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScqAwkCgoVO> models = new ArrayList<PriScqAwkCgoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlDimWdt = null;
	/* Column Info */
	private String ovrFwrdLen = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String ovrRtLen = null;
	/* Column Info */
	private String scqRqstNo = null;
	/* Column Info */
	private String scqVerNo = null;
	/* Column Info */
	private String ovrVoidSltQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproBsrtAmt = null;
	/* Column Info */
	private String ovrRtLenVw = null;
	/* Column Info */
	private String propBsrtAmt = null;
	/* Column Info */
	private String ttlDimLen = null;
	/* Column Info */
	private String ttlDimHgt = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String ovrFwrdLenVw = null;
	/* Column Info */
	private String cgoSeq = null;
	/* Column Info */
	private String ovrLfLenVw = null;
	/* Column Info */
	private String aproVoidRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovrBkwdLen = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String ovrBkwdLenVw = null;
	/* Column Info */
	private String grsWgtVw = null;
	/* Column Info */
	private String propVoidRtAmt = null;
	/* Column Info */
	private String scqVerNoTmp = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ttlDimWdtVw = null;
	/* Column Info */
	private String ttlDimHgtVw = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String ovrLfLen = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String ovrHgtVw = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ttlDimLenVw = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriScqAwkCgoVO() {}

	public PriScqAwkCgoVO(String ibflag, String pagerows, String scqRqstNo, String scqVerNo, String cgoSeq, String cntrTpszCd, String cntrQty, String cmdtCd, String ttlDimLen, String ttlDimWdt, String ttlDimHgt, String ovrFwrdLen, String ovrBkwdLen, String ovrLfLen, String ovrRtLen, String ovrHgt, String grsWgt, String ttlDimLenVw, String ttlDimWdtVw, String ttlDimHgtVw, String ovrFwrdLenVw, String ovrBkwdLenVw, String ovrLfLenVw, String ovrRtLenVw, String ovrHgtVw, String grsWgtVw, String ovrVoidSltQty, String propBsrtAmt, String propVoidRtAmt, String aproBsrtAmt, String aproVoidRtAmt, String creUsrId, String creDt, String updUsrId, String updDt, String cmdtNm, String scqVerNoTmp) {
		this.ibflag = ibflag;
		this.ttlDimWdt = ttlDimWdt;
		this.ovrFwrdLen = ovrFwrdLen;
		this.cmdtNm = cmdtNm;
		this.ovrRtLen = ovrRtLen;
		this.scqRqstNo = scqRqstNo;
		this.scqVerNo = scqVerNo;
		this.ovrVoidSltQty = ovrVoidSltQty;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.aproBsrtAmt = aproBsrtAmt;
		this.ovrRtLenVw = ovrRtLenVw;
		this.propBsrtAmt = propBsrtAmt;
		this.ttlDimLen = ttlDimLen;
		this.ttlDimHgt = ttlDimHgt;
		this.cntrQty = cntrQty;
		this.ovrFwrdLenVw = ovrFwrdLenVw;
		this.cgoSeq = cgoSeq;
		this.ovrLfLenVw = ovrLfLenVw;
		this.aproVoidRtAmt = aproVoidRtAmt;
		this.pagerows = pagerows;
		this.ovrBkwdLen = ovrBkwdLen;
		this.grsWgt = grsWgt;
		this.cmdtCd = cmdtCd;
		this.ovrBkwdLenVw = ovrBkwdLenVw;
		this.grsWgtVw = grsWgtVw;
		this.propVoidRtAmt = propVoidRtAmt;
		this.scqVerNoTmp = scqVerNoTmp;
		this.creDt = creDt;
		this.ttlDimWdtVw = ttlDimWdtVw;
		this.ttlDimHgtVw = ttlDimHgtVw;
		this.ovrHgt = ovrHgt;
		this.ovrLfLen = ovrLfLen;
		this.cntrTpszCd = cntrTpszCd;
		this.ovrHgtVw = ovrHgtVw;
		this.updDt = updDt;
		this.ttlDimLenVw = ttlDimLenVw;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
		this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("ovr_rt_len", getOvrRtLen());
		this.hashColumns.put("scq_rqst_no", getScqRqstNo());
		this.hashColumns.put("scq_ver_no", getScqVerNo());
		this.hashColumns.put("ovr_void_slt_qty", getOvrVoidSltQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_bsrt_amt", getAproBsrtAmt());
		this.hashColumns.put("ovr_rt_len_vw", getOvrRtLenVw());
		this.hashColumns.put("prop_bsrt_amt", getPropBsrtAmt());
		this.hashColumns.put("ttl_dim_len", getTtlDimLen());
		this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("ovr_fwrd_len_vw", getOvrFwrdLenVw());
		this.hashColumns.put("cgo_seq", getCgoSeq());
		this.hashColumns.put("ovr_lf_len_vw", getOvrLfLenVw());
		this.hashColumns.put("apro_void_rt_amt", getAproVoidRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("ovr_bkwd_len_vw", getOvrBkwdLenVw());
		this.hashColumns.put("grs_wgt_vw", getGrsWgtVw());
		this.hashColumns.put("prop_void_rt_amt", getPropVoidRtAmt());
		this.hashColumns.put("scq_ver_no_tmp", getScqVerNoTmp());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ttl_dim_wdt_vw", getTtlDimWdtVw());
		this.hashColumns.put("ttl_dim_hgt_vw", getTtlDimHgtVw());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("ovr_lf_len", getOvrLfLen());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ovr_hgt_vw", getOvrHgtVw());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ttl_dim_len_vw", getTtlDimLenVw());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
		this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("ovr_rt_len", "ovrRtLen");
		this.hashFields.put("scq_rqst_no", "scqRqstNo");
		this.hashFields.put("scq_ver_no", "scqVerNo");
		this.hashFields.put("ovr_void_slt_qty", "ovrVoidSltQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_bsrt_amt", "aproBsrtAmt");
		this.hashFields.put("ovr_rt_len_vw", "ovrRtLenVw");
		this.hashFields.put("prop_bsrt_amt", "propBsrtAmt");
		this.hashFields.put("ttl_dim_len", "ttlDimLen");
		this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("ovr_fwrd_len_vw", "ovrFwrdLenVw");
		this.hashFields.put("cgo_seq", "cgoSeq");
		this.hashFields.put("ovr_lf_len_vw", "ovrLfLenVw");
		this.hashFields.put("apro_void_rt_amt", "aproVoidRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("ovr_bkwd_len_vw", "ovrBkwdLenVw");
		this.hashFields.put("grs_wgt_vw", "grsWgtVw");
		this.hashFields.put("prop_void_rt_amt", "propVoidRtAmt");
		this.hashFields.put("scq_ver_no_tmp", "scqVerNoTmp");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ttl_dim_wdt_vw", "ttlDimWdtVw");
		this.hashFields.put("ttl_dim_hgt_vw", "ttlDimHgtVw");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("ovr_lf_len", "ovrLfLen");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ovr_hgt_vw", "ovrHgtVw");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_dim_len_vw", "ttlDimLenVw");
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
	 * @return ttlDimWdt
	 */
	public String getTtlDimWdt() {
		return this.ttlDimWdt;
	}
	
	/**
	 * Column Info
	 * @return ovrFwrdLen
	 */
	public String getOvrFwrdLen() {
		return this.ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return ovrRtLen
	 */
	public String getOvrRtLen() {
		return this.ovrRtLen;
	}
	
	/**
	 * Column Info
	 * @return scqRqstNo
	 */
	public String getScqRqstNo() {
		return this.scqRqstNo;
	}
	
	/**
	 * Column Info
	 * @return scqVerNo
	 */
	public String getScqVerNo() {
		return this.scqVerNo;
	}
	
	/**
	 * Column Info
	 * @return ovrVoidSltQty
	 */
	public String getOvrVoidSltQty() {
		return this.ovrVoidSltQty;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproBsrtAmt
	 */
	public String getAproBsrtAmt() {
		return this.aproBsrtAmt;
	}
	
	/**
	 * Column Info
	 * @return ovrRtLenVw
	 */
	public String getOvrRtLenVw() {
		return this.ovrRtLenVw;
	}
	
	/**
	 * Column Info
	 * @return propBsrtAmt
	 */
	public String getPropBsrtAmt() {
		return this.propBsrtAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlDimLen
	 */
	public String getTtlDimLen() {
		return this.ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @return ttlDimHgt
	 */
	public String getTtlDimHgt() {
		return this.ttlDimHgt;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return ovrFwrdLenVw
	 */
	public String getOvrFwrdLenVw() {
		return this.ovrFwrdLenVw;
	}
	
	/**
	 * Column Info
	 * @return cgoSeq
	 */
	public String getCgoSeq() {
		return this.cgoSeq;
	}
	
	/**
	 * Column Info
	 * @return ovrLfLenVw
	 */
	public String getOvrLfLenVw() {
		return this.ovrLfLenVw;
	}
	
	/**
	 * Column Info
	 * @return aproVoidRtAmt
	 */
	public String getAproVoidRtAmt() {
		return this.aproVoidRtAmt;
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
	 * @return ovrBkwdLen
	 */
	public String getOvrBkwdLen() {
		return this.ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return ovrBkwdLenVw
	 */
	public String getOvrBkwdLenVw() {
		return this.ovrBkwdLenVw;
	}
	
	/**
	 * Column Info
	 * @return grsWgtVw
	 */
	public String getGrsWgtVw() {
		return this.grsWgtVw;
	}
	
	/**
	 * Column Info
	 * @return propVoidRtAmt
	 */
	public String getPropVoidRtAmt() {
		return this.propVoidRtAmt;
	}
	
	/**
	 * Column Info
	 * @return scqVerNoTmp
	 */
	public String getScqVerNoTmp() {
		return this.scqVerNoTmp;
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
	 * @return ttlDimWdtVw
	 */
	public String getTtlDimWdtVw() {
		return this.ttlDimWdtVw;
	}
	
	/**
	 * Column Info
	 * @return ttlDimHgtVw
	 */
	public String getTtlDimHgtVw() {
		return this.ttlDimHgtVw;
	}
	
	/**
	 * Column Info
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
	}
	
	/**
	 * Column Info
	 * @return ovrLfLen
	 */
	public String getOvrLfLen() {
		return this.ovrLfLen;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return ovrHgtVw
	 */
	public String getOvrHgtVw() {
		return this.ovrHgtVw;
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
	 * @return ttlDimLenVw
	 */
	public String getTtlDimLenVw() {
		return this.ttlDimLenVw;
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
	 * @param ttlDimWdt
	 */
	public void setTtlDimWdt(String ttlDimWdt) {
		this.ttlDimWdt = ttlDimWdt;
	}
	
	/**
	 * Column Info
	 * @param ovrFwrdLen
	 */
	public void setOvrFwrdLen(String ovrFwrdLen) {
		this.ovrFwrdLen = ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param ovrRtLen
	 */
	public void setOvrRtLen(String ovrRtLen) {
		this.ovrRtLen = ovrRtLen;
	}
	
	/**
	 * Column Info
	 * @param scqRqstNo
	 */
	public void setScqRqstNo(String scqRqstNo) {
		this.scqRqstNo = scqRqstNo;
	}
	
	/**
	 * Column Info
	 * @param scqVerNo
	 */
	public void setScqVerNo(String scqVerNo) {
		this.scqVerNo = scqVerNo;
	}
	
	/**
	 * Column Info
	 * @param ovrVoidSltQty
	 */
	public void setOvrVoidSltQty(String ovrVoidSltQty) {
		this.ovrVoidSltQty = ovrVoidSltQty;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproBsrtAmt
	 */
	public void setAproBsrtAmt(String aproBsrtAmt) {
		this.aproBsrtAmt = aproBsrtAmt;
	}
	
	/**
	 * Column Info
	 * @param ovrRtLenVw
	 */
	public void setOvrRtLenVw(String ovrRtLenVw) {
		this.ovrRtLenVw = ovrRtLenVw;
	}
	
	/**
	 * Column Info
	 * @param propBsrtAmt
	 */
	public void setPropBsrtAmt(String propBsrtAmt) {
		this.propBsrtAmt = propBsrtAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlDimLen
	 */
	public void setTtlDimLen(String ttlDimLen) {
		this.ttlDimLen = ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @param ttlDimHgt
	 */
	public void setTtlDimHgt(String ttlDimHgt) {
		this.ttlDimHgt = ttlDimHgt;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param ovrFwrdLenVw
	 */
	public void setOvrFwrdLenVw(String ovrFwrdLenVw) {
		this.ovrFwrdLenVw = ovrFwrdLenVw;
	}
	
	/**
	 * Column Info
	 * @param cgoSeq
	 */
	public void setCgoSeq(String cgoSeq) {
		this.cgoSeq = cgoSeq;
	}
	
	/**
	 * Column Info
	 * @param ovrLfLenVw
	 */
	public void setOvrLfLenVw(String ovrLfLenVw) {
		this.ovrLfLenVw = ovrLfLenVw;
	}
	
	/**
	 * Column Info
	 * @param aproVoidRtAmt
	 */
	public void setAproVoidRtAmt(String aproVoidRtAmt) {
		this.aproVoidRtAmt = aproVoidRtAmt;
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
	 * @param ovrBkwdLen
	 */
	public void setOvrBkwdLen(String ovrBkwdLen) {
		this.ovrBkwdLen = ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param ovrBkwdLenVw
	 */
	public void setOvrBkwdLenVw(String ovrBkwdLenVw) {
		this.ovrBkwdLenVw = ovrBkwdLenVw;
	}
	
	/**
	 * Column Info
	 * @param grsWgtVw
	 */
	public void setGrsWgtVw(String grsWgtVw) {
		this.grsWgtVw = grsWgtVw;
	}
	
	/**
	 * Column Info
	 * @param propVoidRtAmt
	 */
	public void setPropVoidRtAmt(String propVoidRtAmt) {
		this.propVoidRtAmt = propVoidRtAmt;
	}
	
	/**
	 * Column Info
	 * @param scqVerNoTmp
	 */
	public void setScqVerNoTmp(String scqVerNoTmp) {
		this.scqVerNoTmp = scqVerNoTmp;
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
	 * @param ttlDimWdtVw
	 */
	public void setTtlDimWdtVw(String ttlDimWdtVw) {
		this.ttlDimWdtVw = ttlDimWdtVw;
	}
	
	/**
	 * Column Info
	 * @param ttlDimHgtVw
	 */
	public void setTtlDimHgtVw(String ttlDimHgtVw) {
		this.ttlDimHgtVw = ttlDimHgtVw;
	}
	
	/**
	 * Column Info
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
	}
	
	/**
	 * Column Info
	 * @param ovrLfLen
	 */
	public void setOvrLfLen(String ovrLfLen) {
		this.ovrLfLen = ovrLfLen;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param ovrHgtVw
	 */
	public void setOvrHgtVw(String ovrHgtVw) {
		this.ovrHgtVw = ovrHgtVw;
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
	 * @param ttlDimLenVw
	 */
	public void setTtlDimLenVw(String ttlDimLenVw) {
		this.ttlDimLenVw = ttlDimLenVw;
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
		setTtlDimWdt(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt", ""));
		setOvrFwrdLen(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setOvrRtLen(JSPUtil.getParameter(request, prefix + "ovr_rt_len", ""));
		setScqRqstNo(JSPUtil.getParameter(request, prefix + "scq_rqst_no", ""));
		setScqVerNo(JSPUtil.getParameter(request, prefix + "scq_ver_no", ""));
		setOvrVoidSltQty(JSPUtil.getParameter(request, prefix + "ovr_void_slt_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAproBsrtAmt(JSPUtil.getParameter(request, prefix + "apro_bsrt_amt", ""));
		setOvrRtLenVw(JSPUtil.getParameter(request, prefix + "ovr_rt_len_vw", ""));
		setPropBsrtAmt(JSPUtil.getParameter(request, prefix + "prop_bsrt_amt", ""));
		setTtlDimLen(JSPUtil.getParameter(request, prefix + "ttl_dim_len", ""));
		setTtlDimHgt(JSPUtil.getParameter(request, prefix + "ttl_dim_hgt", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setOvrFwrdLenVw(JSPUtil.getParameter(request, prefix + "ovr_fwrd_len_vw", ""));
		setCgoSeq(JSPUtil.getParameter(request, prefix + "cgo_seq", ""));
		setOvrLfLenVw(JSPUtil.getParameter(request, prefix + "ovr_lf_len_vw", ""));
		setAproVoidRtAmt(JSPUtil.getParameter(request, prefix + "apro_void_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOvrBkwdLen(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setOvrBkwdLenVw(JSPUtil.getParameter(request, prefix + "ovr_bkwd_len_vw", ""));
		setGrsWgtVw(JSPUtil.getParameter(request, prefix + "grs_wgt_vw", ""));
		setPropVoidRtAmt(JSPUtil.getParameter(request, prefix + "prop_void_rt_amt", ""));
		setScqVerNoTmp(JSPUtil.getParameter(request, prefix + "scq_ver_no_tmp", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTtlDimWdtVw(JSPUtil.getParameter(request, prefix + "ttl_dim_wdt_vw", ""));
		setTtlDimHgtVw(JSPUtil.getParameter(request, prefix + "ttl_dim_hgt_vw", ""));
		setOvrHgt(JSPUtil.getParameter(request, prefix + "ovr_hgt", ""));
		setOvrLfLen(JSPUtil.getParameter(request, prefix + "ovr_lf_len", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setOvrHgtVw(JSPUtil.getParameter(request, prefix + "ovr_hgt_vw", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTtlDimLenVw(JSPUtil.getParameter(request, prefix + "ttl_dim_len_vw", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScqAwkCgoVO[]
	 */
	public PriScqAwkCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScqAwkCgoVO[]
	 */
	public PriScqAwkCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScqAwkCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_wdt", length));
			String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] ovrRtLen = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_len", length));
			String[] scqRqstNo = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no", length));
			String[] scqVerNo = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no", length));
			String[] ovrVoidSltQty = (JSPUtil.getParameter(request, prefix	+ "ovr_void_slt_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproBsrtAmt = (JSPUtil.getParameter(request, prefix	+ "apro_bsrt_amt", length));
			String[] ovrRtLenVw = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_len_vw", length));
			String[] propBsrtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_bsrt_amt", length));
			String[] ttlDimLen = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_len", length));
			String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_hgt", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] ovrFwrdLenVw = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len_vw", length));
			String[] cgoSeq = (JSPUtil.getParameter(request, prefix	+ "cgo_seq", length));
			String[] ovrLfLenVw = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_len_vw", length));
			String[] aproVoidRtAmt = (JSPUtil.getParameter(request, prefix	+ "apro_void_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] ovrBkwdLenVw = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len_vw", length));
			String[] grsWgtVw = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_vw", length));
			String[] propVoidRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_void_rt_amt", length));
			String[] scqVerNoTmp = (JSPUtil.getParameter(request, prefix	+ "scq_ver_no_tmp", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ttlDimWdtVw = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_wdt_vw", length));
			String[] ttlDimHgtVw = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_hgt_vw", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] ovrLfLen = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_len", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] ovrHgtVw = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt_vw", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ttlDimLenVw = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_len_vw", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScqAwkCgoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlDimWdt[i] != null)
					model.setTtlDimWdt(ttlDimWdt[i]);
				if (ovrFwrdLen[i] != null)
					model.setOvrFwrdLen(ovrFwrdLen[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (ovrRtLen[i] != null)
					model.setOvrRtLen(ovrRtLen[i]);
				if (scqRqstNo[i] != null)
					model.setScqRqstNo(scqRqstNo[i]);
				if (scqVerNo[i] != null)
					model.setScqVerNo(scqVerNo[i]);
				if (ovrVoidSltQty[i] != null)
					model.setOvrVoidSltQty(ovrVoidSltQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproBsrtAmt[i] != null)
					model.setAproBsrtAmt(aproBsrtAmt[i]);
				if (ovrRtLenVw[i] != null)
					model.setOvrRtLenVw(ovrRtLenVw[i]);
				if (propBsrtAmt[i] != null)
					model.setPropBsrtAmt(propBsrtAmt[i]);
				if (ttlDimLen[i] != null)
					model.setTtlDimLen(ttlDimLen[i]);
				if (ttlDimHgt[i] != null)
					model.setTtlDimHgt(ttlDimHgt[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (ovrFwrdLenVw[i] != null)
					model.setOvrFwrdLenVw(ovrFwrdLenVw[i]);
				if (cgoSeq[i] != null)
					model.setCgoSeq(cgoSeq[i]);
				if (ovrLfLenVw[i] != null)
					model.setOvrLfLenVw(ovrLfLenVw[i]);
				if (aproVoidRtAmt[i] != null)
					model.setAproVoidRtAmt(aproVoidRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovrBkwdLen[i] != null)
					model.setOvrBkwdLen(ovrBkwdLen[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (ovrBkwdLenVw[i] != null)
					model.setOvrBkwdLenVw(ovrBkwdLenVw[i]);
				if (grsWgtVw[i] != null)
					model.setGrsWgtVw(grsWgtVw[i]);
				if (propVoidRtAmt[i] != null)
					model.setPropVoidRtAmt(propVoidRtAmt[i]);
				if (scqVerNoTmp[i] != null)
					model.setScqVerNoTmp(scqVerNoTmp[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ttlDimWdtVw[i] != null)
					model.setTtlDimWdtVw(ttlDimWdtVw[i]);
				if (ttlDimHgtVw[i] != null)
					model.setTtlDimHgtVw(ttlDimHgtVw[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (ovrLfLen[i] != null)
					model.setOvrLfLen(ovrLfLen[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (ovrHgtVw[i] != null)
					model.setOvrHgtVw(ovrHgtVw[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ttlDimLenVw[i] != null)
					model.setTtlDimLenVw(ttlDimLenVw[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScqAwkCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScqAwkCgoVO[]
	 */
	public PriScqAwkCgoVO[] getPriScqAwkCgoVOs(){
		PriScqAwkCgoVO[] vos = (PriScqAwkCgoVO[])models.toArray(new PriScqAwkCgoVO[models.size()]);
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
		this.ttlDimWdt = this.ttlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLen = this.ovrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrRtLen = this.ovrRtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNo = this.scqRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNo = this.scqVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrVoidSltQty = this.ovrVoidSltQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproBsrtAmt = this.aproBsrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrRtLenVw = this.ovrRtLenVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propBsrtAmt = this.propBsrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimLen = this.ttlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimHgt = this.ttlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLenVw = this.ovrFwrdLenVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoSeq = this.cgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfLenVw = this.ovrLfLenVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproVoidRtAmt = this.aproVoidRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLen = this.ovrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLenVw = this.ovrBkwdLenVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgtVw = this.grsWgtVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propVoidRtAmt = this.propVoidRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqVerNoTmp = this.scqVerNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimWdtVw = this.ttlDimWdtVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimHgtVw = this.ttlDimHgtVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfLen = this.ovrLfLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgtVw = this.ovrHgtVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimLenVw = this.ttlDimLenVw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
