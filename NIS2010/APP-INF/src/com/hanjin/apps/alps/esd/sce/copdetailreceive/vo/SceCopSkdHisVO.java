/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SceCopSkdHisVO.java
*@FileTitle : SceCopSkdHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copdetailreceive.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceCopSkdHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceCopSkdHisVO> models = new ArrayList<SceCopSkdHisVO>();
	
	/* Column Info ; Interface 6th*/
	private String skdRcvDt = null;
	/* Column Info ; Interface 7th*/
	private String actRcvNo = null;
	/* Column Info */
	private String dupFlg = null;
	/* Column Info */
	private String skdNodCd = null;
	/* Column Info; Interface 1st */
	private String copNo = null;
	/* Column Info ; Interface 2nd*/
	private String fmCopDtlSeq = null;
	/* Column Info */
	private String toCopDtlSeq = null;
	/* Column Info */
	private String clptCd = null;
	/* Column Info ; Interface 5th*/
	private String rcvEvntProcFlg = null;
	/* Column Info */
	private String skdBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info ; Interface 3rd*/
	private String aftActDt = null;
	/* Column Info */
	private String mstCopNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvEvntGapDesc = null;
	/* Column Info */
	private String bfrActDt = null;
	/* Column Info */
	private String aftEstmDt = null;
	/* Column Info */
	private String callYdIndSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String vslCd = null;	
	/* Column Info */
	private String skdRcvTpCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ediMsgTpCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info ; Interface 4th; Interface*/
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String bfrEstmDt = null;
	/* Column Info */
	private String skdMapgCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info ; VSK ETA일때 EDI 전송을 위해 OLD)SCE_EST_ETA_VSL_PRC*/
	private String ediSndDt = null;
	/* COP Detail에서 해당VVD의  VL Line Info. ; (cop_no+cop_dtl_seq)Related Vessel Schedule If  */
	private String vlRow = null;
	/* COP Detail에서 해당VVD의  Next VD Info. ; (cop_no+cop_dtl_seq)Related Vessel Schedule If  */
	private String trnkCop = null;
	/* Column Info 20130820 Inland Dwell 수정*/
	private String cntrTpszCd = null;



	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SceCopSkdHisVO() {}

	public SceCopSkdHisVO(String ibflag, String pagerows, String skdRcvDt, String actRcvNo, String dupFlg, String skdBndCd, String copNo, String fmCopDtlSeq, String toCopDtlSeq, String actCd, String bfrEstmDt, String aftEstmDt, String bfrActDt, String aftActDt, String nodCd, String rcvEvntGapDesc, String rcvEvntProcFlg, String skdMapgCd, String skdNodCd, String skdRcvTpCd, String vslCd, String skdVoyNo, String skdDirCd, String clptCd, String clptIndSeq, String callYdIndSeq, String ediMsgTpCd, String errMsg, String bkgNo, String cntrNo, String mstCopNo, String ediSndDt, String creUsrId, String creDt, String updUsrId, String updDt, String vlRow, String trnkCop, String cntrTpszCd) {
		this.vslCd = vslCd;
		this.skdMapgCd = skdMapgCd;
		this.skdRcvDt = skdRcvDt;
		this.creDt = creDt;
		this.copNo = copNo;
		this.skdNodCd = skdNodCd;
		this.clptCd = clptCd;
		this.dupFlg = dupFlg;
		this.rcvEvntProcFlg = rcvEvntProcFlg;
		this.skdBndCd = skdBndCd;
		this.pagerows = pagerows;
		this.aftActDt = aftActDt;
		this.mstCopNo = mstCopNo;
		this.actRcvNo = actRcvNo;
		this.ibflag = ibflag;
		this.rcvEvntGapDesc = rcvEvntGapDesc;
		this.bfrActDt = bfrActDt;
		this.aftEstmDt = aftEstmDt;
		this.callYdIndSeq = callYdIndSeq;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.actCd = actCd;
		this.fmCopDtlSeq = fmCopDtlSeq;
		this.toCopDtlSeq = toCopDtlSeq;
		this.skdRcvTpCd = skdRcvTpCd;
		this.skdVoyNo = skdVoyNo;
		this.ediMsgTpCd = ediMsgTpCd;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.errMsg = errMsg;
		this.clptIndSeq = clptIndSeq;
		this.nodCd = nodCd;
		this.bfrEstmDt = bfrEstmDt;
		this.ediSndDt = ediSndDt;
		this.vlRow = vlRow;
		this.trnkCop = trnkCop;
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_mapg_cd", getSkdMapgCd());
		this.hashColumns.put("skd_rcv_dt", getSkdRcvDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("skd_nod_cd", getSkdNodCd());
		this.hashColumns.put("clpt_cd", getClptCd());
		this.hashColumns.put("dup_flg", getDupFlg());
		this.hashColumns.put("rcv_evnt_proc_flg", getRcvEvntProcFlg());
		this.hashColumns.put("skd_bnd_cd", getSkdBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("aft_act_dt", getAftActDt());
		this.hashColumns.put("mst_cop_no", getMstCopNo());
		this.hashColumns.put("act_rcv_no", getActRcvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcv_evnt_gap_desc", getRcvEvntGapDesc());
		this.hashColumns.put("bfr_act_dt", getBfrActDt());
		this.hashColumns.put("aft_estm_dt", getAftEstmDt());
		this.hashColumns.put("call_yd_ind_seq", getCallYdIndSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("fm_cop_dtl_seq", getFmCopDtlSeq());
		this.hashColumns.put("to_cop_dtl_seq", getToCopDtlSeq());
		this.hashColumns.put("skd_rcv_tp_cd", getSkdRcvTpCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("edi_msg_tp_cd", getEdiMsgTpCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("bfr_estm_dt", getBfrEstmDt());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		this.hashColumns.put("vl_row", getVlRow());
		this.hashColumns.put("trnk_cop", getTrnkCop());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_mapg_cd", "skdMapgCd");
		this.hashFields.put("skd_rcv_dt", "skdRcvDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("skd_nod_cd", "skdNodCd");
		this.hashFields.put("clpt_cd", "clptCd");
		this.hashFields.put("dup_flg", "dupFlg");
		this.hashFields.put("rcv_evnt_proc_flg", "rcvEvntProcFlg");
		this.hashFields.put("skd_bnd_cd", "skdBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aft_act_dt", "aftActDt");
		this.hashFields.put("mst_cop_no", "mstCopNo");
		this.hashFields.put("act_rcv_no", "actRcvNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcv_evnt_gap_desc", "rcvEvntGapDesc");
		this.hashFields.put("bfr_act_dt", "bfrActDt");
		this.hashFields.put("aft_estm_dt", "aftEstmDt");
		this.hashFields.put("call_yd_ind_seq", "callYdIndSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("fm_cop_dtl_seq", "fmCopDtlSeq");
		this.hashFields.put("to_cop_dtl_seq", "toCopDtlSeq");
		this.hashFields.put("skd_rcv_tp_cd", "skdRcvTpCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("edi_msg_tp_cd", "ediMsgTpCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("bfr_estm_dt", "bfrEstmDt");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		this.hashFields.put("vl_row", "vlRow");
		this.hashFields.put("trnk_cop", "trnkCop");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
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
	 * @return skdMapgCd
	 */
	public String getSkdMapgCd() {
		return this.skdMapgCd;
	}
	
	/**
	 * Column Info
	 * @return skdRcvDt
	 */
	public String getSkdRcvDt() {
		return this.skdRcvDt;
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return skdNodCd
	 */
	public String getSkdNodCd() {
		return this.skdNodCd;
	}
	
	/**
	 * Column Info
	 * @return clptCd
	 */
	public String getClptCd() {
		return this.clptCd;
	}
	
	/**
	 * Column Info
	 * @return dupFlg
	 */
	public String getDupFlg() {
		return this.dupFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvEvntProcFlg
	 */
	public String getRcvEvntProcFlg() {
		return this.rcvEvntProcFlg;
	}
	
	/**
	 * Column Info
	 * @return skdBndCd
	 */
	public String getSkdBndCd() {
		return this.skdBndCd;
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
	 * @return aftActDt
	 */
	public String getAftActDt() {
		return this.aftActDt;
	}
	
	/**
	 * Column Info
	 * @return mstCopNo
	 */
	public String getMstCopNo() {
		return this.mstCopNo;
	}
	
	/**
	 * Column Info
	 * @return actRcvNo
	 */
	public String getActRcvNo() {
		return this.actRcvNo;
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
	 * @return rcvEvntGapDesc
	 */
	public String getRcvEvntGapDesc() {
		return this.rcvEvntGapDesc;
	}
	
	/**
	 * Column Info
	 * @return bfrActDt
	 */
	public String getBfrActDt() {
		return this.bfrActDt;
	}
	
	/**
	 * Column Info
	 * @return aftEstmDt
	 */
	public String getAftEstmDt() {
		return this.aftEstmDt;
	}
	
	/**
	 * Column Info
	 * @return callYdIndSeq
	 */
	public String getCallYdIndSeq() {
		return this.callYdIndSeq;
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
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
	}
	
	/**
	 * Column Info
	 * @return fmCopDtlSeq
	 */
	public String getFmCopDtlSeq() {
		return this.fmCopDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return toCopDtlSeq
	 */
	public String getToCopDtlSeq() {
		return this.toCopDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return skdRcvTpCd
	 */
	public String getSkdRcvTpCd() {
		return this.skdRcvTpCd;
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
	 * @return ediMsgTpCd
	 */
	public String getEdiMsgTpCd() {
		return this.ediMsgTpCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return bfrEstmDt
	 */
	public String getBfrEstmDt() {
		return this.bfrEstmDt;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getVlRow() {
		return this.vlRow;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getTrnkCop() {
		return this.trnkCop;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param skdMapgCd
	 */
	public void setSkdMapgCd(String skdMapgCd) {
		this.skdMapgCd = skdMapgCd;
	}
	
	/**
	 * Column Info
	 * @param skdRcvDt
	 */
	public void setSkdRcvDt(String skdRcvDt) {
		this.skdRcvDt = skdRcvDt;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param skdNodCd
	 */
	public void setSkdNodCd(String skdNodCd) {
		this.skdNodCd = skdNodCd;
	}
	
	/**
	 * Column Info
	 * @param clptCd
	 */
	public void setClptCd(String clptCd) {
		this.clptCd = clptCd;
	}
	
	/**
	 * Column Info
	 * @param dupFlg
	 */
	public void setDupFlg(String dupFlg) {
		this.dupFlg = dupFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvEvntProcFlg
	 */
	public void setRcvEvntProcFlg(String rcvEvntProcFlg) {
		this.rcvEvntProcFlg = rcvEvntProcFlg;
	}
	
	/**
	 * Column Info
	 * @param skdBndCd
	 */
	public void setSkdBndCd(String skdBndCd) {
		this.skdBndCd = skdBndCd;
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
	 * @param aftActDt
	 */
	public void setAftActDt(String aftActDt) {
		this.aftActDt = aftActDt;
	}
	
	/**
	 * Column Info
	 * @param mstCopNo
	 */
	public void setMstCopNo(String mstCopNo) {
		this.mstCopNo = mstCopNo;
	}
	
	/**
	 * Column Info
	 * @param actRcvNo
	 */
	public void setActRcvNo(String actRcvNo) {
		this.actRcvNo = actRcvNo;
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
	 * @param rcvEvntGapDesc
	 */
	public void setRcvEvntGapDesc(String rcvEvntGapDesc) {
		this.rcvEvntGapDesc = rcvEvntGapDesc;
	}
	
	/**
	 * Column Info
	 * @param bfrActDt
	 */
	public void setBfrActDt(String bfrActDt) {
		this.bfrActDt = bfrActDt;
	}
	
	/**
	 * Column Info
	 * @param aftEstmDt
	 */
	public void setAftEstmDt(String aftEstmDt) {
		this.aftEstmDt = aftEstmDt;
	}
	
	/**
	 * Column Info
	 * @param callYdIndSeq
	 */
	public void setCallYdIndSeq(String callYdIndSeq) {
		this.callYdIndSeq = callYdIndSeq;
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
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
	}
	
	/**
	 * Column Info
	 * @param fmCopDtlSeq
	 */
	public void setFmCopDtlSeq(String fmCopDtlSeq) {
		this.fmCopDtlSeq = fmCopDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param toCopDtlSeq
	 */
	public void setToCopDtlSeq(String toCopDtlSeq) {
		this.toCopDtlSeq = toCopDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param skdRcvTpCd
	 */
	public void setSkdRcvTpCd(String skdRcvTpCd) {
		this.skdRcvTpCd = skdRcvTpCd;
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
	 * @param ediMsgTpCd
	 */
	public void setEdiMsgTpCd(String ediMsgTpCd) {
		this.ediMsgTpCd = ediMsgTpCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param bfrEstmDt
	 */
	public void setBfrEstmDt(String bfrEstmDt) {
		this.bfrEstmDt = bfrEstmDt;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
	}
	
	/**
	 * Column Info
	 * @param vlRow
	 */
	public void setVlRow(String vlRow) {
		this.vlRow = vlRow;
	}
	
	/**
	 * Column Info
	 * @param trnkCop
	 */
	public void setTrnkCop(String trnkCop) {
		this.trnkCop = trnkCop;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdMapgCd(JSPUtil.getParameter(request, "skd_mapg_cd", ""));
		setSkdRcvDt(JSPUtil.getParameter(request, "skd_rcv_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setSkdNodCd(JSPUtil.getParameter(request, "skd_nod_cd", ""));
		setClptCd(JSPUtil.getParameter(request, "clpt_cd", ""));
		setDupFlg(JSPUtil.getParameter(request, "dup_flg", ""));
		setRcvEvntProcFlg(JSPUtil.getParameter(request, "rcv_evnt_proc_flg", ""));
		setSkdBndCd(JSPUtil.getParameter(request, "skd_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAftActDt(JSPUtil.getParameter(request, "aft_act_dt", ""));
		setMstCopNo(JSPUtil.getParameter(request, "mst_cop_no", ""));
		setActRcvNo(JSPUtil.getParameter(request, "act_rcv_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcvEvntGapDesc(JSPUtil.getParameter(request, "rcv_evnt_gap_desc", ""));
		setBfrActDt(JSPUtil.getParameter(request, "bfr_act_dt", ""));
		setAftEstmDt(JSPUtil.getParameter(request, "aft_estm_dt", ""));
		setCallYdIndSeq(JSPUtil.getParameter(request, "call_yd_ind_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setActCd(JSPUtil.getParameter(request, "act_cd", ""));
		setFmCopDtlSeq(JSPUtil.getParameter(request, "fm_cop_dtl_seq", ""));
		setToCopDtlSeq(JSPUtil.getParameter(request, "to_cop_dtl_seq", ""));
		setSkdRcvTpCd(JSPUtil.getParameter(request, "skd_rcv_tp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setEdiMsgTpCd(JSPUtil.getParameter(request, "edi_msg_tp_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setErrMsg(JSPUtil.getParameter(request, "err_msg", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setBfrEstmDt(JSPUtil.getParameter(request, "bfr_estm_dt", ""));
		setEdiSndDt(JSPUtil.getParameter(request, "edi_snd_dt", ""));
		setVlRow(JSPUtil.getParameter(request, "vl_row", ""));
		setTrnkCop(JSPUtil.getParameter(request, "trnk_cop", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceCopSkdHisVO[]
	 */
	public SceCopSkdHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceCopSkdHisVO[]
	 */
	public SceCopSkdHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceCopSkdHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdMapgCd = (JSPUtil.getParameter(request, prefix	+ "skd_mapg_cd", length));
			String[] skdRcvDt = (JSPUtil.getParameter(request, prefix	+ "skd_rcv_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] skdNodCd = (JSPUtil.getParameter(request, prefix	+ "skd_nod_cd", length));
			String[] clptCd = (JSPUtil.getParameter(request, prefix	+ "clpt_cd", length));
			String[] dupFlg = (JSPUtil.getParameter(request, prefix	+ "dup_flg", length));
			String[] rcvEvntProcFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_evnt_proc_flg", length));
			String[] skdBndCd = (JSPUtil.getParameter(request, prefix	+ "skd_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] aftActDt = (JSPUtil.getParameter(request, prefix	+ "aft_act_dt", length));
			String[] mstCopNo = (JSPUtil.getParameter(request, prefix	+ "mst_cop_no", length));
			String[] actRcvNo = (JSPUtil.getParameter(request, prefix	+ "act_rcv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvEvntGapDesc = (JSPUtil.getParameter(request, prefix	+ "rcv_evnt_gap_desc", length));
			String[] bfrActDt = (JSPUtil.getParameter(request, prefix	+ "bfr_act_dt", length));
			String[] aftEstmDt = (JSPUtil.getParameter(request, prefix	+ "aft_estm_dt", length));
			String[] callYdIndSeq = (JSPUtil.getParameter(request, prefix	+ "call_yd_ind_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] fmCopDtlSeq = (JSPUtil.getParameter(request, prefix	+ "fm_cop_dtl_seq", length));
			String[] toCopDtlSeq = (JSPUtil.getParameter(request, prefix	+ "to_cop_dtl_seq", length));
			String[] skdRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_rcv_tp_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ediMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] bfrEstmDt = (JSPUtil.getParameter(request, prefix	+ "bfr_estm_dt", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			String[] vlRow = (JSPUtil.getParameter(request, prefix	+ "vl_row", length));
			String[] trnkCop = (JSPUtil.getParameter(request, prefix	+ "trnk_cop", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceCopSkdHisVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdMapgCd[i] != null)
					model.setSkdMapgCd(skdMapgCd[i]);
				if (skdRcvDt[i] != null)
					model.setSkdRcvDt(skdRcvDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (skdNodCd[i] != null)
					model.setSkdNodCd(skdNodCd[i]);
				if (clptCd[i] != null)
					model.setClptCd(clptCd[i]);
				if (dupFlg[i] != null)
					model.setDupFlg(dupFlg[i]);
				if (rcvEvntProcFlg[i] != null)
					model.setRcvEvntProcFlg(rcvEvntProcFlg[i]);
				if (skdBndCd[i] != null)
					model.setSkdBndCd(skdBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (aftActDt[i] != null)
					model.setAftActDt(aftActDt[i]);
				if (mstCopNo[i] != null)
					model.setMstCopNo(mstCopNo[i]);
				if (actRcvNo[i] != null)
					model.setActRcvNo(actRcvNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvEvntGapDesc[i] != null)
					model.setRcvEvntGapDesc(rcvEvntGapDesc[i]);
				if (bfrActDt[i] != null)
					model.setBfrActDt(bfrActDt[i]);
				if (aftEstmDt[i] != null)
					model.setAftEstmDt(aftEstmDt[i]);
				if (callYdIndSeq[i] != null)
					model.setCallYdIndSeq(callYdIndSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (fmCopDtlSeq[i] != null)
					model.setFmCopDtlSeq(fmCopDtlSeq[i]);
				if (toCopDtlSeq[i] != null)
					model.setToCopDtlSeq(toCopDtlSeq[i]);
				if (skdRcvTpCd[i] != null)
					model.setSkdRcvTpCd(skdRcvTpCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ediMsgTpCd[i] != null)
					model.setEdiMsgTpCd(ediMsgTpCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (bfrEstmDt[i] != null)
					model.setBfrEstmDt(bfrEstmDt[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				if (vlRow[i] != null)
					model.setVlRow(vlRow[i]);
				if (trnkCop[i] != null)
					model.setTrnkCop(trnkCop[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceCopSkdHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceCopSkdHisVO[]
	 */
	public SceCopSkdHisVO[] getSceCopSkdHisVOs(){
		SceCopSkdHisVO[] vos = (SceCopSkdHisVO[])models.toArray(new SceCopSkdHisVO[models.size()]);
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
		this.skdMapgCd = this.skdMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdRcvDt = this.skdRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdNodCd = this.skdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptCd = this.clptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupFlg = this.dupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvEvntProcFlg = this.rcvEvntProcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdBndCd = this.skdBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftActDt = this.aftActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCopNo = this.mstCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvNo = this.actRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvEvntGapDesc = this.rcvEvntGapDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrActDt = this.bfrActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftEstmDt = this.aftEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYdIndSeq = this.callYdIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCopDtlSeq = this.fmCopDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCopDtlSeq = this.toCopDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdRcvTpCd = this.skdRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpCd = this.ediMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrEstmDt = this.bfrEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlRow = this.vlRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkCop = this.trnkCop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
