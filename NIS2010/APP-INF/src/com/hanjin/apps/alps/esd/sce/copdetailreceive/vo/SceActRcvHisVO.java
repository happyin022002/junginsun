/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SceActRcvHisVO.java
*@FileTitle : SceActRcvHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2011.04.28 황효근 
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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SceActRcvHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SceActRcvHisVO> models = new ArrayList<SceActRcvHisVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String actGdt = null;
	/* Column Info */
	private String mstBkgNo = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dupFlg = null;
	/* Column Info */
	private String trspClzFlg = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String actUmchTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actRcvNo = null;
	/* Column Info */
	private String mstCopNo = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediSndRsltFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bndVskdSeqCd = null;
	/* Column Info */
	private String railDestN1stEtaDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creTpCd = null;
	/* Column Info */
	private String emlSndRsltFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String actGapDesc = null;
	/* Column Info */
	private String ediMsgTpCd = null;
	/* Column Info */
	private String cxSndFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String faxSndRsltFlg = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String umchChkDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String actRcvDt = null;
	/* Column Info */
	private String railItchgFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SceActRcvHisVO() {}

	public SceActRcvHisVO(String ibflag, String pagerows, String vslCd, String actGdt, String creDt, String copNo, String mstBkgNo, String dupFlg, String actStsMapgCd, String trspClzFlg, String actUmchTpCd, String mstCopNo, String actRcvNo, String vpsPortCd, String ediSndRsltFlg, String bndVskdSeqCd, String railDestN1stEtaDt, String updUsrId, String creTpCd, String emlSndRsltFlg, String updDt, String actCd, String actRcvTpCd, String skdVoyNo, String actGapDesc, String ediMsgTpCd, String skdDirCd, String faxSndRsltFlg, String creUsrId, String bkgNo, String umchChkDt, String actDt, String cntrNo, String vndrSeq, String clptIndSeq, String errMsg, String nodCd, String actRcvDt, String cxSndFlg, String cntrTpszCd, String blNo, String podNodCd, String railItchgFlg) {
		this.vslCd = vslCd;
		this.actGdt = actGdt;
		this.mstBkgNo = mstBkgNo;
		this.copNo = copNo;
		this.creDt = creDt;
		this.dupFlg = dupFlg;
		this.trspClzFlg = trspClzFlg;
		this.actStsMapgCd = actStsMapgCd;
		this.blNo = blNo;
		this.actUmchTpCd = actUmchTpCd;
		this.pagerows = pagerows;
		this.actRcvNo = actRcvNo;
		this.mstCopNo = mstCopNo;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.ediSndRsltFlg = ediSndRsltFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.bndVskdSeqCd = bndVskdSeqCd;
		this.railDestN1stEtaDt = railDestN1stEtaDt;
		this.updUsrId = updUsrId;
		this.creTpCd = creTpCd;
		this.emlSndRsltFlg = emlSndRsltFlg;
		this.updDt = updDt;
		this.actCd = actCd;
		this.actRcvTpCd = actRcvTpCd;
		this.skdVoyNo = skdVoyNo;
		this.actGapDesc = actGapDesc;
		this.ediMsgTpCd = ediMsgTpCd;
		this.cxSndFlg = cxSndFlg;
		this.skdDirCd = skdDirCd;
		this.faxSndRsltFlg = faxSndRsltFlg;
		this.podNodCd = podNodCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.actDt = actDt;
		this.umchChkDt = umchChkDt;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.errMsg = errMsg;
		this.clptIndSeq = clptIndSeq;
		this.nodCd = nodCd;
		this.actRcvDt = actRcvDt;
		this.railItchgFlg = railItchgFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("act_gdt", getActGdt());
		this.hashColumns.put("mst_bkg_no", getMstBkgNo());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dup_flg", getDupFlg());
		this.hashColumns.put("trsp_clz_flg", getTrspClzFlg());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("act_umch_tp_cd", getActUmchTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_rcv_no", getActRcvNo());
		this.hashColumns.put("mst_cop_no", getMstCopNo());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_snd_rslt_flg", getEdiSndRsltFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bnd_vskd_seq_cd", getBndVskdSeqCd());
		this.hashColumns.put("rail_dest_n1st_eta_dt", getRailDestN1stEtaDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_tp_cd", getCreTpCd());
		this.hashColumns.put("eml_snd_rslt_flg", getEmlSndRsltFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("act_gap_desc", getActGapDesc());
		this.hashColumns.put("edi_msg_tp_cd", getEdiMsgTpCd());
		this.hashColumns.put("cx_snd_flg", getCxSndFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fax_snd_rslt_flg", getFaxSndRsltFlg());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("umch_chk_dt", getUmchChkDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("act_rcv_dt", getActRcvDt());
		this.hashColumns.put("rail_itchg_flg", getRailItchgFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("act_gdt", "actGdt");
		this.hashFields.put("mst_bkg_no", "mstBkgNo");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dup_flg", "dupFlg");
		this.hashFields.put("trsp_clz_flg", "trspClzFlg");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("act_umch_tp_cd", "actUmchTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_rcv_no", "actRcvNo");
		this.hashFields.put("mst_cop_no", "mstCopNo");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_snd_rslt_flg", "ediSndRsltFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bnd_vskd_seq_cd", "bndVskdSeqCd");
		this.hashFields.put("rail_dest_n1st_eta_dt", "railDestN1stEtaDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_tp_cd", "creTpCd");
		this.hashFields.put("eml_snd_rslt_flg", "emlSndRsltFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("act_gap_desc", "actGapDesc");
		this.hashFields.put("edi_msg_tp_cd", "ediMsgTpCd");
		this.hashFields.put("cx_snd_flg", "cxSndFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fax_snd_rslt_flg", "faxSndRsltFlg");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("umch_chk_dt", "umchChkDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("act_rcv_dt", "actRcvDt");
		this.hashFields.put("rail_itchg_flg", "railItchgFlg");
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
	 * @return actGdt
	 */
	public String getActGdt() {
		return this.actGdt;
	}
	
	/**
	 * Column Info
	 * @return mstBkgNo
	 */
	public String getMstBkgNo() {
		return this.mstBkgNo;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return trspClzFlg
	 */
	public String getTrspClzFlg() {
		return this.trspClzFlg;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return actUmchTpCd
	 */
	public String getActUmchTpCd() {
		return this.actUmchTpCd;
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
	 * @return actRcvNo
	 */
	public String getActRcvNo() {
		return this.actRcvNo;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return ediSndRsltFlg
	 */
	public String getEdiSndRsltFlg() {
		return this.ediSndRsltFlg;
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
	 * @return bndVskdSeqCd
	 */
	public String getBndVskdSeqCd() {
		return this.bndVskdSeqCd;
	}
	
	/**
	 * Column Info
	 * @return railDestN1stEtaDt
	 */
	public String getRailDestN1stEtaDt() {
		return this.railDestN1stEtaDt;
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
	 * @return creTpCd
	 */
	public String getCreTpCd() {
		return this.creTpCd;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltFlg
	 */
	public String getEmlSndRsltFlg() {
		return this.emlSndRsltFlg;
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
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
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
	 * @return actGapDesc
	 */
	public String getActGapDesc() {
		return this.actGapDesc;
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
	 * @return cxSndFlg
	 */
	public String getCxSndFlg() {
		return this.cxSndFlg;
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
	 * @return faxSndRsltFlg
	 */
	public String getFaxSndRsltFlg() {
		return this.faxSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return umchChkDt
	 */
	public String getUmchChkDt() {
		return this.umchChkDt;
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
	 * @return actRcvDt
	 */
	public String getActRcvDt() {
		return this.actRcvDt;
	}
	
	/**
	 * Column Info
	 * @return railItchgFlg
	 */
	public String getRailItchgFlg() {
		return this.railItchgFlg;
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
	 * @param actGdt
	 */
	public void setActGdt(String actGdt) {
		this.actGdt = actGdt;
	}
	
	/**
	 * Column Info
	 * @param mstBkgNo
	 */
	public void setMstBkgNo(String mstBkgNo) {
		this.mstBkgNo = mstBkgNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param trspClzFlg
	 */
	public void setTrspClzFlg(String trspClzFlg) {
		this.trspClzFlg = trspClzFlg;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param actUmchTpCd
	 */
	public void setActUmchTpCd(String actUmchTpCd) {
		this.actUmchTpCd = actUmchTpCd;
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
	 * @param actRcvNo
	 */
	public void setActRcvNo(String actRcvNo) {
		this.actRcvNo = actRcvNo;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param ediSndRsltFlg
	 */
	public void setEdiSndRsltFlg(String ediSndRsltFlg) {
		this.ediSndRsltFlg = ediSndRsltFlg;
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
	 * @param bndVskdSeqCd
	 */
	public void setBndVskdSeqCd(String bndVskdSeqCd) {
		this.bndVskdSeqCd = bndVskdSeqCd;
	}
	
	/**
	 * Column Info
	 * @param railDestN1stEtaDt
	 */
	public void setRailDestN1stEtaDt(String railDestN1stEtaDt) {
		this.railDestN1stEtaDt = railDestN1stEtaDt;
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
	 * @param creTpCd
	 */
	public void setCreTpCd(String creTpCd) {
		this.creTpCd = creTpCd;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltFlg
	 */
	public void setEmlSndRsltFlg(String emlSndRsltFlg) {
		this.emlSndRsltFlg = emlSndRsltFlg;
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
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
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
	 * @param actGapDesc
	 */
	public void setActGapDesc(String actGapDesc) {
		this.actGapDesc = actGapDesc;
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
	 * @param cxSndFlg
	 */
	public void setCxSndFlg(String cxSndFlg) {
		this.cxSndFlg = cxSndFlg;
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
	 * @param faxSndRsltFlg
	 */
	public void setFaxSndRsltFlg(String faxSndRsltFlg) {
		this.faxSndRsltFlg = faxSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param umchChkDt
	 */
	public void setUmchChkDt(String umchChkDt) {
		this.umchChkDt = umchChkDt;
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
	 * @param actRcvDt
	 */
	public void setActRcvDt(String actRcvDt) {
		this.actRcvDt = actRcvDt;
	}
	
	/**
	 * Column Info
	 * @param railItchgFlg
	 */
	public void setRailItchgFlg(String railItchgFlg) {
		this.railItchgFlg = railItchgFlg;
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
		setActGdt(JSPUtil.getParameter(request, prefix + "act_gdt", ""));
		setMstBkgNo(JSPUtil.getParameter(request, prefix + "mst_bkg_no", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDupFlg(JSPUtil.getParameter(request, prefix + "dup_flg", ""));
		setTrspClzFlg(JSPUtil.getParameter(request, prefix + "trsp_clz_flg", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setActUmchTpCd(JSPUtil.getParameter(request, prefix + "act_umch_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setActRcvNo(JSPUtil.getParameter(request, prefix + "act_rcv_no", ""));
		setMstCopNo(JSPUtil.getParameter(request, prefix + "mst_cop_no", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiSndRsltFlg(JSPUtil.getParameter(request, prefix + "edi_snd_rslt_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setBndVskdSeqCd(JSPUtil.getParameter(request, prefix + "bnd_vskd_seq_cd", ""));
		setRailDestN1stEtaDt(JSPUtil.getParameter(request, prefix + "rail_dest_n1st_eta_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreTpCd(JSPUtil.getParameter(request, prefix + "cre_tp_cd", ""));
		setEmlSndRsltFlg(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, prefix + "act_rcv_tp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setActGapDesc(JSPUtil.getParameter(request, prefix + "act_gap_desc", ""));
		setEdiMsgTpCd(JSPUtil.getParameter(request, prefix + "edi_msg_tp_cd", ""));
		setCxSndFlg(JSPUtil.getParameter(request, prefix + "cx_snd_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setFaxSndRsltFlg(JSPUtil.getParameter(request, prefix + "fax_snd_rslt_flg", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setUmchChkDt(JSPUtil.getParameter(request, prefix + "umch_chk_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setActRcvDt(JSPUtil.getParameter(request, prefix + "act_rcv_dt", ""));
		setRailItchgFlg(JSPUtil.getParameter(request, prefix + "rail_itchg_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SceActRcvHisVO[]
	 */
	public SceActRcvHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SceActRcvHisVO[]
	 */
	public SceActRcvHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SceActRcvHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] actGdt = (JSPUtil.getParameter(request, prefix	+ "act_gdt", length));
			String[] mstBkgNo = (JSPUtil.getParameter(request, prefix	+ "mst_bkg_no", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dupFlg = (JSPUtil.getParameter(request, prefix	+ "dup_flg", length));
			String[] trspClzFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_clz_flg", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_mapg_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] actUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "act_umch_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actRcvNo = (JSPUtil.getParameter(request, prefix	+ "act_rcv_no", length));
			String[] mstCopNo = (JSPUtil.getParameter(request, prefix	+ "mst_cop_no", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_rslt_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] bndVskdSeqCd = (JSPUtil.getParameter(request, prefix	+ "bnd_vskd_seq_cd", length));
			String[] railDestN1stEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_dest_n1st_eta_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creTpCd = (JSPUtil.getParameter(request, prefix	+ "cre_tp_cd", length));
			String[] emlSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] actGapDesc = (JSPUtil.getParameter(request, prefix	+ "act_gap_desc", length));
			String[] ediMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_cd", length));
			String[] cxSndFlg = (JSPUtil.getParameter(request, prefix	+ "cx_snd_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] faxSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_flg", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] umchChkDt = (JSPUtil.getParameter(request, prefix	+ "umch_chk_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] actRcvDt = (JSPUtil.getParameter(request, prefix	+ "act_rcv_dt", length));
			String[] railItchgFlg = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SceActRcvHisVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (actGdt[i] != null)
					model.setActGdt(actGdt[i]);
				if (mstBkgNo[i] != null)
					model.setMstBkgNo(mstBkgNo[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dupFlg[i] != null)
					model.setDupFlg(dupFlg[i]);
				if (trspClzFlg[i] != null)
					model.setTrspClzFlg(trspClzFlg[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (actUmchTpCd[i] != null)
					model.setActUmchTpCd(actUmchTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actRcvNo[i] != null)
					model.setActRcvNo(actRcvNo[i]);
				if (mstCopNo[i] != null)
					model.setMstCopNo(mstCopNo[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediSndRsltFlg[i] != null)
					model.setEdiSndRsltFlg(ediSndRsltFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (bndVskdSeqCd[i] != null)
					model.setBndVskdSeqCd(bndVskdSeqCd[i]);
				if (railDestN1stEtaDt[i] != null)
					model.setRailDestN1stEtaDt(railDestN1stEtaDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creTpCd[i] != null)
					model.setCreTpCd(creTpCd[i]);
				if (emlSndRsltFlg[i] != null)
					model.setEmlSndRsltFlg(emlSndRsltFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (actGapDesc[i] != null)
					model.setActGapDesc(actGapDesc[i]);
				if (ediMsgTpCd[i] != null)
					model.setEdiMsgTpCd(ediMsgTpCd[i]);
				if (cxSndFlg[i] != null)
					model.setCxSndFlg(cxSndFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (faxSndRsltFlg[i] != null)
					model.setFaxSndRsltFlg(faxSndRsltFlg[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (umchChkDt[i] != null)
					model.setUmchChkDt(umchChkDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (actRcvDt[i] != null)
					model.setActRcvDt(actRcvDt[i]);
				if (railItchgFlg[i] != null)
					model.setRailItchgFlg(railItchgFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSceActRcvHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SceActRcvHisVO[]
	 */
	public SceActRcvHisVO[] getSceActRcvHisVOs(){
		SceActRcvHisVO[] vos = (SceActRcvHisVO[])models.toArray(new SceActRcvHisVO[models.size()]);
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
		this.actGdt = this.actGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBkgNo = this.mstBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupFlg = this.dupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspClzFlg = this.trspClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actUmchTpCd = this.actUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvNo = this.actRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCopNo = this.mstCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndRsltFlg = this.ediSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndVskdSeqCd = this.bndVskdSeqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDestN1stEtaDt = this.railDestN1stEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTpCd = this.creTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltFlg = this.emlSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGapDesc = this.actGapDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpCd = this.ediMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxSndFlg = this.cxSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltFlg = this.faxSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchChkDt = this.umchChkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvDt = this.actRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgFlg = this.railItchgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
