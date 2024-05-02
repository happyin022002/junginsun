/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingInfoVO.java
*@FileTitle : BookingInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.08 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BookingInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BookingInfoVO> models = new ArrayList<BookingInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgMeasQty = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String shCustCntCd = null;
	/* Column Info */
	private String bkgHotDeFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cnCustCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnCustSeq = null;
	/* Column Info */
	private String shCustSeq = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String bkgMeasTpCd = null;
	/* Column Info */
	private String nfCustCntCd = null;
	/* Column Info */
	private String nfCustNm = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String actBkgWgt = null;
	/* Column Info */
	private String nfCustSeq = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String shCustNm = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String cnCustNm = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String actBkgWgtTpCd = null;
	/* Column Info */
	private String repCmdtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BookingInfoVO() {}

	public BookingInfoVO(String ibflag, String pagerows, String blNo, String refNo, String vslCd, String skdVoyNo, String skdDirCd, String porCd, String polCd, String podCd, String delCd, String rcvTermCd, String deTermCd, String bkgMeasQty, String bkgMeasTpCd, String actBkgWgt, String actBkgWgtTpCd, String bkgHotDeFlg, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String bkgOfcCd, String obSlsOfcCd, String docUsrId, String obSrepCd, String repCmdtCd, String shCustCntCd, String shCustSeq, String shCustNm, String cnCustCntCd, String cnCustSeq, String cnCustNm, String nfCustCntCd, String nfCustSeq, String nfCustNm, String bkgCreDt, String cntrTpszCd, String vslPrePstCd) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.bkgMeasQty = bkgMeasQty;
		this.docUsrId = docUsrId;
		this.rdCgoFlg = rdCgoFlg;
		this.shCustCntCd = shCustCntCd;
		this.bkgHotDeFlg = bkgHotDeFlg;
		this.blNo = blNo;
		this.cnCustCntCd = cnCustCntCd;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cnCustSeq = cnCustSeq;
		this.shCustSeq = shCustSeq;
		this.bbCgoFlg = bbCgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.bkgCreDt = bkgCreDt;
		this.obSlsOfcCd = obSlsOfcCd;
		this.vslPrePstCd = vslPrePstCd;
		this.rcvTermCd = rcvTermCd;
		this.bkgMeasTpCd = bkgMeasTpCd;
		this.nfCustCntCd = nfCustCntCd;
		this.nfCustNm = nfCustNm;
		this.bkgOfcCd = bkgOfcCd;
		this.actBkgWgt = actBkgWgt;
		this.nfCustSeq = nfCustSeq;
		this.awkCgoFlg = awkCgoFlg;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.shCustNm = shCustNm;
		this.refNo = refNo;
		this.cnCustNm = cnCustNm;
		this.rcFlg = rcFlg;
		this.actBkgWgtTpCd = actBkgWgtTpCd;
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_meas_qty", getBkgMeasQty());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("sh_cust_cnt_cd", getShCustCntCd());
		this.hashColumns.put("bkg_hot_de_flg", getBkgHotDeFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cn_cust_cnt_cd", getCnCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cn_cust_seq", getCnCustSeq());
		this.hashColumns.put("sh_cust_seq", getShCustSeq());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("bkg_meas_tp_cd", getBkgMeasTpCd());
		this.hashColumns.put("nf_cust_cnt_cd", getNfCustCntCd());
		this.hashColumns.put("nf_cust_nm", getNfCustNm());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("act_bkg_wgt", getActBkgWgt());
		this.hashColumns.put("nf_cust_seq", getNfCustSeq());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("sh_cust_nm", getShCustNm());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("cn_cust_nm", getCnCustNm());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("act_bkg_wgt_tp_cd", getActBkgWgtTpCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_meas_qty", "bkgMeasQty");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("sh_cust_cnt_cd", "shCustCntCd");
		this.hashFields.put("bkg_hot_de_flg", "bkgHotDeFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cn_cust_cnt_cd", "cnCustCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cn_cust_seq", "cnCustSeq");
		this.hashFields.put("sh_cust_seq", "shCustSeq");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("bkg_meas_tp_cd", "bkgMeasTpCd");
		this.hashFields.put("nf_cust_cnt_cd", "nfCustCntCd");
		this.hashFields.put("nf_cust_nm", "nfCustNm");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("act_bkg_wgt", "actBkgWgt");
		this.hashFields.put("nf_cust_seq", "nfCustSeq");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("sh_cust_nm", "shCustNm");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cn_cust_nm", "cnCustNm");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("act_bkg_wgt_tp_cd", "actBkgWgtTpCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return bkgMeasQty
	 */
	public String getBkgMeasQty() {
		return this.bkgMeasQty;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return shCustCntCd
	 */
	public String getShCustCntCd() {
		return this.shCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgHotDeFlg
	 */
	public String getBkgHotDeFlg() {
		return this.bkgHotDeFlg;
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
	 * @return cnCustCntCd
	 */
	public String getCnCustCntCd() {
		return this.cnCustCntCd;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cnCustSeq
	 */
	public String getCnCustSeq() {
		return this.cnCustSeq;
	}
	
	/**
	 * Column Info
	 * @return shCustSeq
	 */
	public String getShCustSeq() {
		return this.shCustSeq;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
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
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgMeasTpCd
	 */
	public String getBkgMeasTpCd() {
		return this.bkgMeasTpCd;
	}
	
	/**
	 * Column Info
	 * @return nfCustCntCd
	 */
	public String getNfCustCntCd() {
		return this.nfCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return nfCustNm
	 */
	public String getNfCustNm() {
		return this.nfCustNm;
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
	 * @return actBkgWgt
	 */
	public String getActBkgWgt() {
		return this.actBkgWgt;
	}
	
	/**
	 * Column Info
	 * @return nfCustSeq
	 */
	public String getNfCustSeq() {
		return this.nfCustSeq;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return shCustNm
	 */
	public String getShCustNm() {
		return this.shCustNm;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return cnCustNm
	 */
	public String getCnCustNm() {
		return this.cnCustNm;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return actBkgWgtTpCd
	 */
	public String getActBkgWgtTpCd() {
		return this.actBkgWgtTpCd;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param bkgMeasQty
	 */
	public void setBkgMeasQty(String bkgMeasQty) {
		this.bkgMeasQty = bkgMeasQty;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param shCustCntCd
	 */
	public void setShCustCntCd(String shCustCntCd) {
		this.shCustCntCd = shCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgHotDeFlg
	 */
	public void setBkgHotDeFlg(String bkgHotDeFlg) {
		this.bkgHotDeFlg = bkgHotDeFlg;
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
	 * @param cnCustCntCd
	 */
	public void setCnCustCntCd(String cnCustCntCd) {
		this.cnCustCntCd = cnCustCntCd;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cnCustSeq
	 */
	public void setCnCustSeq(String cnCustSeq) {
		this.cnCustSeq = cnCustSeq;
	}
	
	/**
	 * Column Info
	 * @param shCustSeq
	 */
	public void setShCustSeq(String shCustSeq) {
		this.shCustSeq = shCustSeq;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
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
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgMeasTpCd
	 */
	public void setBkgMeasTpCd(String bkgMeasTpCd) {
		this.bkgMeasTpCd = bkgMeasTpCd;
	}
	
	/**
	 * Column Info
	 * @param nfCustCntCd
	 */
	public void setNfCustCntCd(String nfCustCntCd) {
		this.nfCustCntCd = nfCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param nfCustNm
	 */
	public void setNfCustNm(String nfCustNm) {
		this.nfCustNm = nfCustNm;
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
	 * @param actBkgWgt
	 */
	public void setActBkgWgt(String actBkgWgt) {
		this.actBkgWgt = actBkgWgt;
	}
	
	/**
	 * Column Info
	 * @param nfCustSeq
	 */
	public void setNfCustSeq(String nfCustSeq) {
		this.nfCustSeq = nfCustSeq;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param shCustNm
	 */
	public void setShCustNm(String shCustNm) {
		this.shCustNm = shCustNm;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param cnCustNm
	 */
	public void setCnCustNm(String cnCustNm) {
		this.cnCustNm = cnCustNm;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param actBkgWgtTpCd
	 */
	public void setActBkgWgtTpCd(String actBkgWgtTpCd) {
		this.actBkgWgtTpCd = actBkgWgtTpCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBkgMeasQty(JSPUtil.getParameter(request, "bkg_meas_qty", ""));
		setDocUsrId(JSPUtil.getParameter(request, "doc_usr_id", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setShCustCntCd(JSPUtil.getParameter(request, "sh_cust_cnt_cd", ""));
		setBkgHotDeFlg(JSPUtil.getParameter(request, "bkg_hot_de_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCnCustCntCd(JSPUtil.getParameter(request, "cn_cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnCustSeq(JSPUtil.getParameter(request, "cn_cust_seq", ""));
		setShCustSeq(JSPUtil.getParameter(request, "sh_cust_seq", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setBkgCreDt(JSPUtil.getParameter(request, "bkg_cre_dt", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setBkgMeasTpCd(JSPUtil.getParameter(request, "bkg_meas_tp_cd", ""));
		setNfCustCntCd(JSPUtil.getParameter(request, "nf_cust_cnt_cd", ""));
		setNfCustNm(JSPUtil.getParameter(request, "nf_cust_nm", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setActBkgWgt(JSPUtil.getParameter(request, "act_bkg_wgt", ""));
		setNfCustSeq(JSPUtil.getParameter(request, "nf_cust_seq", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setShCustNm(JSPUtil.getParameter(request, "sh_cust_nm", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setCnCustNm(JSPUtil.getParameter(request, "cn_cust_nm", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setActBkgWgtTpCd(JSPUtil.getParameter(request, "act_bkg_wgt_tp_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BookingInfoVO[]
	 */
	public BookingInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BookingInfoVO[]
	 */
	public BookingInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BookingInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bkgMeasQty = (JSPUtil.getParameter(request, prefix	+ "bkg_meas_qty", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] shCustCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cnt_cd", length));
			String[] bkgHotDeFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_hot_de_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cnCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnCustSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cust_seq", length));
			String[] shCustSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cust_seq", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] bkgMeasTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_meas_tp_cd", length));
			String[] nfCustCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cnt_cd", length));
			String[] nfCustNm = (JSPUtil.getParameter(request, prefix	+ "nf_cust_nm", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] actBkgWgt = (JSPUtil.getParameter(request, prefix	+ "act_bkg_wgt", length));
			String[] nfCustSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cust_seq", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] shCustNm = (JSPUtil.getParameter(request, prefix	+ "sh_cust_nm", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] cnCustNm = (JSPUtil.getParameter(request, prefix	+ "cn_cust_nm", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] actBkgWgtTpCd = (JSPUtil.getParameter(request, prefix	+ "act_bkg_wgt_tp_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BookingInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgMeasQty[i] != null)
					model.setBkgMeasQty(bkgMeasQty[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (shCustCntCd[i] != null)
					model.setShCustCntCd(shCustCntCd[i]);
				if (bkgHotDeFlg[i] != null)
					model.setBkgHotDeFlg(bkgHotDeFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cnCustCntCd[i] != null)
					model.setCnCustCntCd(cnCustCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnCustSeq[i] != null)
					model.setCnCustSeq(cnCustSeq[i]);
				if (shCustSeq[i] != null)
					model.setShCustSeq(shCustSeq[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (bkgMeasTpCd[i] != null)
					model.setBkgMeasTpCd(bkgMeasTpCd[i]);
				if (nfCustCntCd[i] != null)
					model.setNfCustCntCd(nfCustCntCd[i]);
				if (nfCustNm[i] != null)
					model.setNfCustNm(nfCustNm[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (actBkgWgt[i] != null)
					model.setActBkgWgt(actBkgWgt[i]);
				if (nfCustSeq[i] != null)
					model.setNfCustSeq(nfCustSeq[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (shCustNm[i] != null)
					model.setShCustNm(shCustNm[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (cnCustNm[i] != null)
					model.setCnCustNm(cnCustNm[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (actBkgWgtTpCd[i] != null)
					model.setActBkgWgtTpCd(actBkgWgtTpCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBookingInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BookingInfoVO[]
	 */
	public BookingInfoVO[] getBookingInfoVOs(){
		BookingInfoVO[] vos = (BookingInfoVO[])models.toArray(new BookingInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeasQty = this.bkgMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCntCd = this.shCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHotDeFlg = this.bkgHotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCntCd = this.cnCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSeq = this.cnCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSeq = this.shCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeasTpCd = this.bkgMeasTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCntCd = this.nfCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustNm = this.nfCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBkgWgt = this.actBkgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSeq = this.nfCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustNm = this.shCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustNm = this.cnCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBkgWgtTpCd = this.actBkgWgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
