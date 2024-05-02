/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SamsungEDIBLChargeVO.java
*@FileTitle : SamsungEDIBLChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.08 박정진 1.0 Creation
* 2012.07.12 김상현 [CHM-201218835] (Korea) Samsung Invoice EDI > Invoice No. Numbering 요청
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamsungEDIBLChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamsungEDIBLChargeVO> models = new ArrayList<SamsungEDIBLChargeVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String srInvNo = null;
	/* Column Info */
	private String othAmt = null;
	/* Column Info */
	private String cmsAmt = null;
	/* Column Info */
	private String invEdiD4Qty = null;
	/* Column Info */
	private String invEdiD7Qty = null;
	/* Column Info */
	private String cfrAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String invEdiD2Qty = null;
	/* Column Info */
	private String otrAmt = null;
	/* Column Info */
	private String invEdiD5Qty = null;
	/* Column Info */
	private String whfAmt = null;
	/* Column Info */
	private String thcAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grsCbmCapa = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bafAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String oftAmt = null;
	/* Column Info */
	private String grsCntrWgt = null;
	/* Column Info */
	private String dhfAmt = null;
	/* Column Info */
	private String invEdiEtcQty = null;
	/* Column Info */
	private String sndFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String blCntrGrpCtnt = null;
	/* Column Info */
	private String slfAmt = null;
	/* Column Info */
	private String srInvNoSeq = null;
	
	private List<SamsungInvoiceEDIBLVO> samsungInvoiceEDIBLList = null;
	
	private List<SamsungInvoiceEDIChargeVO> samsungInvoiceEDIChargeList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamsungEDIBLChargeVO() {}

	public SamsungEDIBLChargeVO(String ibflag, String pagerows, String blSrcNo, String srInvNo, String porCd, String polCd, String podCd, String delCd, String invEdiD2Qty, String invEdiD4Qty, String invEdiD5Qty, String invEdiD7Qty, String invEdiEtcQty, String grsCntrWgt, String grsCbmCapa, String oftAmt, String cmsAmt, String thcAmt, String dhfAmt, String whfAmt, String otrAmt, String cfrAmt, String bafAmt, String othAmt, String sndFlg, String cntrNo, String blCntrGrpCtnt, String slfAmt, String srInvNoSeq) {
		this.porCd = porCd;
		this.blSrcNo = blSrcNo;
		this.srInvNo = srInvNo;
		this.othAmt = othAmt;
		this.cmsAmt = cmsAmt;
		this.invEdiD4Qty = invEdiD4Qty;
		this.invEdiD7Qty = invEdiD7Qty;
		this.cfrAmt = cfrAmt;
		this.delCd = delCd;
		this.invEdiD2Qty = invEdiD2Qty;
		this.otrAmt = otrAmt;
		this.invEdiD5Qty = invEdiD5Qty;
		this.whfAmt = whfAmt;
		this.thcAmt = thcAmt;
		this.pagerows = pagerows;
		this.grsCbmCapa = grsCbmCapa;
		this.podCd = podCd;
		this.bafAmt = bafAmt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.oftAmt = oftAmt;
		this.grsCntrWgt = grsCntrWgt;
		this.dhfAmt = dhfAmt;
		this.invEdiEtcQty = invEdiEtcQty;
		this.sndFlg = sndFlg;
		this.cntrNo = cntrNo;
		this.blCntrGrpCtnt = blCntrGrpCtnt;
		this.slfAmt = slfAmt;
		this.srInvNoSeq = srInvNoSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("sr_inv_no", getSrInvNo());
		this.hashColumns.put("oth_amt", getOthAmt());
		this.hashColumns.put("cms_amt", getCmsAmt());
		this.hashColumns.put("inv_edi_d4_qty", getInvEdiD4Qty());
		this.hashColumns.put("inv_edi_d7_qty", getInvEdiD7Qty());
		this.hashColumns.put("cfr_amt", getCfrAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("inv_edi_d2_qty", getInvEdiD2Qty());
		this.hashColumns.put("otr_amt", getOtrAmt());
		this.hashColumns.put("inv_edi_d5_qty", getInvEdiD5Qty());
		this.hashColumns.put("whf_amt", getWhfAmt());
		this.hashColumns.put("thc_amt", getThcAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grs_cbm_capa", getGrsCbmCapa());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("baf_amt", getBafAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("oft_amt", getOftAmt());
		this.hashColumns.put("grs_cntr_wgt", getGrsCntrWgt());
		this.hashColumns.put("dhf_amt", getDhfAmt());
		this.hashColumns.put("inv_edi_etc_qty", getInvEdiEtcQty());
		this.hashColumns.put("snd_flg", getSndFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bl_cntr_grp_ctnt", getBlCntrGrpCtnt());
		this.hashColumns.put("slf_amt", getSlfAmt());
		this.hashColumns.put("sr_inv_no_seq", getSrInvNoSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("sr_inv_no", "srInvNo");
		this.hashFields.put("oth_amt", "othAmt");
		this.hashFields.put("cms_amt", "cmsAmt");
		this.hashFields.put("inv_edi_d4_qty", "invEdiD4Qty");
		this.hashFields.put("inv_edi_d7_qty", "invEdiD7Qty");
		this.hashFields.put("cfr_amt", "cfrAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("inv_edi_d2_qty", "invEdiD2Qty");
		this.hashFields.put("otr_amt", "otrAmt");
		this.hashFields.put("inv_edi_d5_qty", "invEdiD5Qty");
		this.hashFields.put("whf_amt", "whfAmt");
		this.hashFields.put("thc_amt", "thcAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grs_cbm_capa", "grsCbmCapa");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("baf_amt", "bafAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("oft_amt", "oftAmt");
		this.hashFields.put("grs_cntr_wgt", "grsCntrWgt");
		this.hashFields.put("dhf_amt", "dhfAmt");
		this.hashFields.put("inv_edi_etc_qty", "invEdiEtcQty");
		this.hashFields.put("snd_flg", "sndFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bl_cntr_grp_ctnt", "blCntrGrpCtnt");
		this.hashFields.put("slf_amt", "slfAmt");
		this.hashFields.put("sr_inv_no_seq", "srInvNoSeq");
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
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return srInvNo
	 */
	public String getSrInvNo() {
		return this.srInvNo;
	}
	
	/**
	 * Column Info
	 * @return othAmt
	 */
	public String getOthAmt() {
		return this.othAmt;
	}
	
	/**
	 * Column Info
	 * @return cmsAmt
	 */
	public String getCmsAmt() {
		return this.cmsAmt;
	}
	
	/**
	 * Column Info
	 * @return invEdiD4Qty
	 */
	public String getInvEdiD4Qty() {
		return this.invEdiD4Qty;
	}
	
	/**
	 * Column Info
	 * @return invEdiD7Qty
	 */
	public String getInvEdiD7Qty() {
		return this.invEdiD7Qty;
	}
	
	/**
	 * Column Info
	 * @return cfrAmt
	 */
	public String getCfrAmt() {
		return this.cfrAmt;
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
	 * @return invEdiD2Qty
	 */
	public String getInvEdiD2Qty() {
		return this.invEdiD2Qty;
	}
	
	/**
	 * Column Info
	 * @return otrAmt
	 */
	public String getOtrAmt() {
		return this.otrAmt;
	}
	
	/**
	 * Column Info
	 * @return invEdiD5Qty
	 */
	public String getInvEdiD5Qty() {
		return this.invEdiD5Qty;
	}
	
	/**
	 * Column Info
	 * @return whfAmt
	 */
	public String getWhfAmt() {
		return this.whfAmt;
	}
	
	/**
	 * Column Info
	 * @return thcAmt
	 */
	public String getThcAmt() {
		return this.thcAmt;
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
	 * @return grsCbmCapa
	 */
	public String getGrsCbmCapa() {
		return this.grsCbmCapa;
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
	 * @return bafAmt
	 */
	public String getBafAmt() {
		return this.bafAmt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return oftAmt
	 */
	public String getOftAmt() {
		return this.oftAmt;
	}
	
	/**
	 * Column Info
	 * @return grsCntrWgt
	 */
	public String getGrsCntrWgt() {
		return this.grsCntrWgt;
	}
	
	/**
	 * Column Info
	 * @return dhfAmt
	 */
	public String getDhfAmt() {
		return this.dhfAmt;
	}
	
	/**
	 * Column Info
	 * @return invEdiEtcQty
	 */
	public String getInvEdiEtcQty() {
		return this.invEdiEtcQty;
	}
	
	/**
	 * Column Info
	 * @return slfAmt
	 */
	public String getSlfAmt() {
		return this.slfAmt;
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
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param srInvNo
	 */
	public void setSrInvNo(String srInvNo) {
		this.srInvNo = srInvNo;
	}
	
	/**
	 * Column Info
	 * @param othAmt
	 */
	public void setOthAmt(String othAmt) {
		this.othAmt = othAmt;
	}
	
	/**
	 * Column Info
	 * @param cmsAmt
	 */
	public void setCmsAmt(String cmsAmt) {
		this.cmsAmt = cmsAmt;
	}
	
	/**
	 * Column Info
	 * @param invEdiD4Qty
	 */
	public void setInvEdiD4Qty(String invEdiD4Qty) {
		this.invEdiD4Qty = invEdiD4Qty;
	}
	
	/**
	 * Column Info
	 * @param invEdiD7Qty
	 */
	public void setInvEdiD7Qty(String invEdiD7Qty) {
		this.invEdiD7Qty = invEdiD7Qty;
	}
	
	/**
	 * Column Info
	 * @param cfrAmt
	 */
	public void setCfrAmt(String cfrAmt) {
		this.cfrAmt = cfrAmt;
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
	 * @param invEdiD2Qty
	 */
	public void setInvEdiD2Qty(String invEdiD2Qty) {
		this.invEdiD2Qty = invEdiD2Qty;
	}
	
	/**
	 * Column Info
	 * @param otrAmt
	 */
	public void setOtrAmt(String otrAmt) {
		this.otrAmt = otrAmt;
	}
	
	/**
	 * Column Info
	 * @param invEdiD5Qty
	 */
	public void setInvEdiD5Qty(String invEdiD5Qty) {
		this.invEdiD5Qty = invEdiD5Qty;
	}
	
	/**
	 * Column Info
	 * @param whfAmt
	 */
	public void setWhfAmt(String whfAmt) {
		this.whfAmt = whfAmt;
	}
	
	/**
	 * Column Info
	 * @param thcAmt
	 */
	public void setThcAmt(String thcAmt) {
		this.thcAmt = thcAmt;
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
	 * @param grsCbmCapa
	 */
	public void setGrsCbmCapa(String grsCbmCapa) {
		this.grsCbmCapa = grsCbmCapa;
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
	 * @param bafAmt
	 */
	public void setBafAmt(String bafAmt) {
		this.bafAmt = bafAmt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param oftAmt
	 */
	public void setOftAmt(String oftAmt) {
		this.oftAmt = oftAmt;
	}
	
	/**
	 * Column Info
	 * @param grsCntrWgt
	 */
	public void setGrsCntrWgt(String grsCntrWgt) {
		this.grsCntrWgt = grsCntrWgt;
	}
	
	/**
	 * Column Info
	 * @param dhfAmt
	 */
	public void setDhfAmt(String dhfAmt) {
		this.dhfAmt = dhfAmt;
	}
	
	/**
	 * Column Info
	 * @param invEdiEtcQty
	 */
	public void setInvEdiEtcQty(String invEdiEtcQty) {
		this.invEdiEtcQty = invEdiEtcQty;
	}
	
	/**
	 * Column Info
	 * @param slfAmt
	 */
	public void setSlfAmt(String slfAmt) {
		this.slfAmt = slfAmt;
	}
	
	public String getSndFlg() {
		return sndFlg;
	}

	public void setSndFlg(String sndFlg) {
		this.sndFlg = sndFlg;
	}
	
	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getBlCntrGrpCtnt() {
		return blCntrGrpCtnt;
	}

	public void setBlCntrGrpCtnt(String blCntrGrpCtnt) {
		this.blCntrGrpCtnt = blCntrGrpCtnt;
	}

	public List<SamsungInvoiceEDIBLVO> getSamsungInvoiceEDIBLList() {
		return samsungInvoiceEDIBLList;
	}

	public void setSamsungInvoiceEDIBLList(List<SamsungInvoiceEDIBLVO> samsungInvoiceEDIBLList) {
		this.samsungInvoiceEDIBLList = samsungInvoiceEDIBLList;
	}

	public List<SamsungInvoiceEDIChargeVO> getSamsungInvoiceEDIChargeList() {
		return samsungInvoiceEDIChargeList;
	}

	public void setSamsungInvoiceEDIChargeList(List<SamsungInvoiceEDIChargeVO> samsungInvoiceEDIChargeList) {
		this.samsungInvoiceEDIChargeList = samsungInvoiceEDIChargeList;
	}

	public String getSrInvNoSeq() {
		return srInvNoSeq;
	}

	public void setSrInvNoSeq(String srInvNoSeq) {
		this.srInvNoSeq = srInvNoSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setSrInvNo(JSPUtil.getParameter(request, "sr_inv_no", ""));
		setOthAmt(JSPUtil.getParameter(request, "oth_amt", ""));
		setCmsAmt(JSPUtil.getParameter(request, "cms_amt", ""));
		setInvEdiD4Qty(JSPUtil.getParameter(request, "inv_edi_d4_qty", ""));
		setInvEdiD7Qty(JSPUtil.getParameter(request, "inv_edi_d7_qty", ""));
		setCfrAmt(JSPUtil.getParameter(request, "cfr_amt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setInvEdiD2Qty(JSPUtil.getParameter(request, "inv_edi_d2_qty", ""));
		setOtrAmt(JSPUtil.getParameter(request, "otr_amt", ""));
		setInvEdiD5Qty(JSPUtil.getParameter(request, "inv_edi_d5_qty", ""));
		setWhfAmt(JSPUtil.getParameter(request, "whf_amt", ""));
		setThcAmt(JSPUtil.getParameter(request, "thc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGrsCbmCapa(JSPUtil.getParameter(request, "grs_cbm_capa", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBafAmt(JSPUtil.getParameter(request, "baf_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setOftAmt(JSPUtil.getParameter(request, "oft_amt", ""));
		setGrsCntrWgt(JSPUtil.getParameter(request, "grs_cntr_wgt", ""));
		setDhfAmt(JSPUtil.getParameter(request, "dhf_amt", ""));
		setInvEdiEtcQty(JSPUtil.getParameter(request, "inv_edi_etc_qty", ""));
		setSlfAmt(JSPUtil.getParameter(request, "slf_amt", ""));
		setSrInvNoSeq(JSPUtil.getParameter(request, "sr_inv_no_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamsungEDIBLChargeVO[]
	 */
	public SamsungEDIBLChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamsungEDIBLChargeVO[]
	 */
	public SamsungEDIBLChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamsungEDIBLChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] srInvNo = (JSPUtil.getParameter(request, prefix	+ "sr_inv_no", length));
			String[] othAmt = (JSPUtil.getParameter(request, prefix	+ "oth_amt", length));
			String[] cmsAmt = (JSPUtil.getParameter(request, prefix	+ "cms_amt", length));
			String[] invEdiD4Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_d4_qty", length));
			String[] invEdiD7Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_d7_qty", length));
			String[] cfrAmt = (JSPUtil.getParameter(request, prefix	+ "cfr_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] invEdiD2Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_d2_qty", length));
			String[] otrAmt = (JSPUtil.getParameter(request, prefix	+ "otr_amt", length));
			String[] invEdiD5Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_d5_qty", length));
			String[] whfAmt = (JSPUtil.getParameter(request, prefix	+ "whf_amt", length));
			String[] thcAmt = (JSPUtil.getParameter(request, prefix	+ "thc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] grsCbmCapa = (JSPUtil.getParameter(request, prefix	+ "grs_cbm_capa", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bafAmt = (JSPUtil.getParameter(request, prefix	+ "baf_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] oftAmt = (JSPUtil.getParameter(request, prefix	+ "oft_amt", length));
			String[] grsCntrWgt = (JSPUtil.getParameter(request, prefix	+ "grs_cntr_wgt", length));
			String[] dhfAmt = (JSPUtil.getParameter(request, prefix	+ "dhf_amt", length));
			String[] invEdiEtcQty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_etc_qty", length));
			String[] sndFlg = (JSPUtil.getParameter(request, prefix	+ "snd_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] blCntrGrpCtnt = (JSPUtil.getParameter(request, prefix	+ "bl_cntr_grp_ctnt", length));
			String[] slfAmt = (JSPUtil.getParameter(request, prefix + "slf_amt", length));
			String[] srInvNoSeq = (JSPUtil.getParameter(request, prefix + "sr_inv_no_seq", length));

			for (int i = 0; i < length; i++) {
				model = new SamsungEDIBLChargeVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (srInvNo[i] != null)
					model.setSrInvNo(srInvNo[i]);
				if (othAmt[i] != null)
					model.setOthAmt(othAmt[i]);
				if (cmsAmt[i] != null)
					model.setCmsAmt(cmsAmt[i]);
				if (invEdiD4Qty[i] != null)
					model.setInvEdiD4Qty(invEdiD4Qty[i]);
				if (invEdiD7Qty[i] != null)
					model.setInvEdiD7Qty(invEdiD7Qty[i]);
				if (cfrAmt[i] != null)
					model.setCfrAmt(cfrAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (invEdiD2Qty[i] != null)
					model.setInvEdiD2Qty(invEdiD2Qty[i]);
				if (otrAmt[i] != null)
					model.setOtrAmt(otrAmt[i]);
				if (invEdiD5Qty[i] != null)
					model.setInvEdiD5Qty(invEdiD5Qty[i]);
				if (whfAmt[i] != null)
					model.setWhfAmt(whfAmt[i]);
				if (thcAmt[i] != null)
					model.setThcAmt(thcAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grsCbmCapa[i] != null)
					model.setGrsCbmCapa(grsCbmCapa[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bafAmt[i] != null)
					model.setBafAmt(bafAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (oftAmt[i] != null)
					model.setOftAmt(oftAmt[i]);
				if (grsCntrWgt[i] != null)
					model.setGrsCntrWgt(grsCntrWgt[i]);
				if (dhfAmt[i] != null)
					model.setDhfAmt(dhfAmt[i]);
				if (invEdiEtcQty[i] != null)
					model.setInvEdiEtcQty(invEdiEtcQty[i]);
				if (sndFlg[i] != null)
					model.setSndFlg(sndFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (blCntrGrpCtnt[i] != null)
					model.setBlCntrGrpCtnt(blCntrGrpCtnt[i]);
				if (slfAmt[i] != null)
					model.setSlfAmt(slfAmt[i]);
				if (srInvNoSeq[i] != null)
					model.setSrInvNoSeq(srInvNoSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamsungEDIBLChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamsungEDIBLChargeVO[]
	 */
	public SamsungEDIBLChargeVO[] getSamsungEDIBLChargeVOs(){
		SamsungEDIBLChargeVO[] vos = (SamsungEDIBLChargeVO[])models.toArray(new SamsungEDIBLChargeVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srInvNo = this.srInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othAmt = this.othAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmsAmt = this.cmsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiD4Qty = this.invEdiD4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiD7Qty = this.invEdiD7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfrAmt = this.cfrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiD2Qty = this.invEdiD2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrAmt = this.otrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiD5Qty = this.invEdiD5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfAmt = this.whfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thcAmt = this.thcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsCbmCapa = this.grsCbmCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bafAmt = this.bafAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftAmt = this.oftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsCntrWgt = this.grsCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhfAmt = this.dhfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiEtcQty = this.invEdiEtcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg = this.sndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCntrGrpCtnt = this.blCntrGrpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slfAmt = this.slfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srInvNoSeq = this.srInvNoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
