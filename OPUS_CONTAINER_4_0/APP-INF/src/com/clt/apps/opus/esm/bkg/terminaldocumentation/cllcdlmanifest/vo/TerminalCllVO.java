/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalCllVO.java
*@FileTitle : TerminalCllVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.10
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TerminalCllVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TerminalCllVO> models = new ArrayList<TerminalCllVO>();

	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inPolTs = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String inQty = null;
	/* Column Info */
	private String inFeu = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String tbnSeq = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inTeu = null;
	/* Column Info */
	private String tbxSeq = null;
	/* Column Info */
	private String inUsrId = null;
	/* Column Info */
	private String inIncludingType = null;
	private String prtInTeu       = null;
	private String prtInFeu       = null;
	private String prtInQty       = null;
	private String prtPckQty      = null;
	private String prtPckTpCd     = null;
	private String prtCntrWgt     = null;
	private String prtCntrWgtUtCd = null;
	private String prtDocActWgt   = null;
	private String prtDocWgtUtCd  = null;
	private String prtMeasQty     = null;
	private String prtMeasQtyUtCd = null;
	private String prtDocMeasQty  = null;
	private String prtDocMeasUtCd = null;
	/* Column Info */
	private String prtVgmWgt = null;
	/* Column Info */
	private String prtVgmWgtUtCd = null;
	private String inCntrMatch = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TerminalCllVO() {}

	public TerminalCllVO(String ibflag, String pagerows, String inVvdCd, String inPolCd, String inPolTs, String bkgNo, String cntrNo, String cntrTpszCd, String inUsrId, String vpsEtaDt, String vpsEtdDt, String tbxSeq, String inQty, String tbnSeq, String inTeu, String inFeu, String inIncludingType, String prtInTeu, String prtInFeu, String prtInQty, String prtPckQty, String prtPckTpCd, String prtCntrWgt, String prtCntrWgtUtCd, String prtDocActWgt, String prtDocWgtUtCd, String prtMeasQty, String prtMeasQtyUtCd, String prtDocMeasQty, String prtDocMeasUtCd, String prtVgmWgt, String prtVgmWgtUtCd, String inCntrMatch) {
		this.vpsEtdDt = vpsEtdDt;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inPolTs = inPolTs;
		this.bkgNo = bkgNo;
		this.inQty = inQty;
		this.inFeu = inFeu;
		this.cntrNo = cntrNo;
		this.tbnSeq = tbnSeq;
		this.inPolCd = inPolCd;
		this.cntrTpszCd = cntrTpszCd;
		this.inVvdCd = inVvdCd;
		this.inTeu = inTeu;
		this.tbxSeq = tbxSeq;
		this.inUsrId = inUsrId;
		this.inIncludingType = inIncludingType;
		this.prtInTeu       = prtInTeu      ;
		this.prtInFeu       = prtInFeu      ;
		this.prtInQty       = prtInQty      ;
		this.prtPckQty      = prtPckQty     ;
		this.prtPckTpCd     = prtPckTpCd    ;
		this.prtCntrWgt     = prtCntrWgt    ;
		this.prtCntrWgtUtCd = prtCntrWgtUtCd;
		this.prtDocActWgt   = prtDocActWgt  ;
		this.prtDocWgtUtCd  = prtDocWgtUtCd ;
		this.prtMeasQty     = prtMeasQty    ;
		this.prtMeasQtyUtCd = prtMeasQtyUtCd;
		this.prtDocMeasQty  = prtDocMeasQty ;
		this.prtDocMeasUtCd = prtDocMeasUtCd;
		this.prtVgmWgt = prtVgmWgt;
		this.prtVgmWgtUtCd = prtVgmWgtUtCd;
		this.inCntrMatch = inCntrMatch;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_pol_ts", getInPolTs());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("in_qty", getInQty());
		this.hashColumns.put("in_feu", getInFeu());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("tbn_seq", getTbnSeq());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_teu", getInTeu());
		this.hashColumns.put("tbx_seq", getTbxSeq());
		this.hashColumns.put("in_usr_id", getInUsrId());
		this.hashColumns.put("in_including_type", getInIncludingType());
		this.hashColumns.put("prt_in_teu", getPrtInTeu());
		this.hashColumns.put("prt_in_feu", getPrtInFeu());
		this.hashColumns.put("prt_in_qty", getPrtInQty());
		this.hashColumns.put("prt_pck_qty", getPrtPckQty());
		this.hashColumns.put("prt_pck_tp_cd", getPrtPckTpCd());
		this.hashColumns.put("prt_cntr_wgt", getPrtCntrWgt());
		this.hashColumns.put("prt_cntr_wgt_ut_cd", getPrtCntrWgtUtCd());
		this.hashColumns.put("prt_doc_act_wgt", getPrtDocActWgt());
		this.hashColumns.put("prt_doc_wgt_ut_cd", getPrtDocWgtUtCd());
		this.hashColumns.put("prt_meas_qty", getPrtMeasQty());
		this.hashColumns.put("prt_meas_qty_ut_cd", getPrtMeasQtyUtCd());
		this.hashColumns.put("prt_doc_meas_qty", getPrtDocMeasQty());
		this.hashColumns.put("prt_doc_meas_ut_cd", getPrtDocMeasUtCd());
		this.hashColumns.put("prt_vgm_wgt", getPrtVgmWgt());
		this.hashColumns.put("prt_vgm_wgt_ut_cd", getPrtVgmWgtUtCd());
		this.hashColumns.put("in_cntr_match", getInCntrMatch());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_pol_ts", "inPolTs");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("in_qty", "inQty");
		this.hashFields.put("in_feu", "inFeu");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("tbn_seq", "tbnSeq");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_teu", "inTeu");
		this.hashFields.put("tbx_seq", "tbxSeq");
		this.hashFields.put("in_usr_id", "inUsrId");
		this.hashFields.put("in_including_type", "inIncludingType");
		this.hashFields.put("prt_in_teu", "prtInTeu");
		this.hashFields.put("prt_in_feu", "prtInFeu");
		this.hashFields.put("prt_in_qty", "prtInQty");
		this.hashFields.put("prt_pck_qty", "prtPckQty");
		this.hashFields.put("prt_pck_tp_cd", "prtPckTpCd");
		this.hashFields.put("prt_cntr_wgt", "prtCntrWgt");
		this.hashFields.put("prt_cntr_wgt_ut_cd", "prtCntrWgtUtCd");
		this.hashFields.put("prt_doc_act_wgt", "prtDocActWgt");
		this.hashFields.put("prt_doc_wgt_ut_cd", "prtDocWgtUtCd");
		this.hashFields.put("prt_meas_qty", "prtMeasQty");
		this.hashFields.put("prt_meas_qty_ut_cd", "prtMeasQtyUtCd");
		this.hashFields.put("prt_doc_meas_qty", "prtDocMeasQty");
		this.hashFields.put("prt_doc_meas_ut_cd", "prtDocMeasUtCd");
		this.hashFields.put("prt_vgm_wgt", "prtVgmWgt");
		this.hashFields.put("prt_vgm_wgt_ut_cd", "prtVgmWgtUtCd");
		this.hashFields.put("in_cntr_match", "inCntrMatch");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}

	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return inPolTs
	 */
	public String getInPolTs() {
		return this.inPolTs;
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
	 * @return inQty
	 */
	public String getInQty() {
		return this.inQty;
	}

	/**
	 * Column Info
	 * @return inFeu
	 */
	public String getInFeu() {
		return this.inFeu;
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
	 * @return tbnSeq
	 */
	public String getTbnSeq() {
		return this.tbnSeq;
	}

	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
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
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return inTeu
	 */
	public String getInTeu() {
		return this.inTeu;
	}

	/**
	 * Column Info
	 * @return tbxSeq
	 */
	public String getTbxSeq() {
		return this.tbxSeq;
	}

	/**
	 * Column Info
	 * @return inUsrId
	 */
	public String getInUsrId() {
		return this.inUsrId;
	}
	
	/**
	 * Column Info
	 * @return inIncludingType
	 */
	public String getInIncludingType() {
		return this.inIncludingType;
	}
	
	/**
	 * Column Info
	 * @return prtVgmWgt
	 */
	public String getPrtVgmWgt() {
		return this.prtVgmWgt;
	}
	
	/**
	 * Column Info
	 * @return prtVgmWgtUtCd
	 */
	public String getPrtVgmWgtUtCd() {
		return this.prtVgmWgtUtCd;
	}

	/**
	 * Column Info
	 * @return inCntrMatch
	 */
	public String getInCntrMatch() {
		return this.inCntrMatch;
	}


	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}

	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param inPolTs
	 */
	public void setInPolTs(String inPolTs) {
		this.inPolTs = inPolTs;
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
	 * @param inQty
	 */
	public void setInQty(String inQty) {
		this.inQty = inQty;
	}

	/**
	 * Column Info
	 * @param inFeu
	 */
	public void setInFeu(String inFeu) {
		this.inFeu = inFeu;
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
	 * @param tbnSeq
	 */
	public void setTbnSeq(String tbnSeq) {
		this.tbnSeq = tbnSeq;
	}

	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
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
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param inTeu
	 */
	public void setInTeu(String inTeu) {
		this.inTeu = inTeu;
	}

	/**
	 * Column Info
	 * @param tbxSeq
	 */
	public void setTbxSeq(String tbxSeq) {
		this.tbxSeq = tbxSeq;
	}

	/**
	 * Column Info
	 * @param inUsrId
	 */
	public void setInUsrId(String inUsrId) {
		this.inUsrId = inUsrId;
	}
	
	/**
	 * Column Info
	 * @param inIncludingType
	 */
	public void setInIncludingType(String inIncludingType) {
		this.inIncludingType = inIncludingType;
	}
	
	public String getPrtInTeu() {
		return prtInTeu;
	}

	public void setPrtInTeu(String prtInTeu) {
		this.prtInTeu = prtInTeu;
	}

	public String getPrtInFeu() {
		return prtInFeu;
	}

	public void setPrtInFeu(String prtInFeu) {
		this.prtInFeu = prtInFeu;
	}

	public String getPrtInQty() {
		return prtInQty;
	}

	public void setPrtInQty(String prtInQty) {
		this.prtInQty = prtInQty;
	}

	public String getPrtPckQty() {
		return prtPckQty;
	}

	public void setPrtPckQty(String prtPckQty) {
		this.prtPckQty = prtPckQty;
	}

	public String getPrtPckTpCd() {
		return prtPckTpCd;
	}

	public void setPrtPckTpCd(String prtPckTpCd) {
		this.prtPckTpCd = prtPckTpCd;
	}

	public String getPrtCntrWgt() {
		return prtCntrWgt;
	}

	public void setPrtCntrWgt(String prtCntrWgt) {
		this.prtCntrWgt = prtCntrWgt;
	}

	public String getPrtCntrWgtUtCd() {
		return prtCntrWgtUtCd;
	}

	public void setPrtCntrWgtUtCd(String prtCntrWgtUtCd) {
		this.prtCntrWgtUtCd = prtCntrWgtUtCd;
	}

	public String getPrtDocActWgt() {
		return prtDocActWgt;
	}

	public void setPrtDocActWgt(String prtDocActWgt) {
		this.prtDocActWgt = prtDocActWgt;
	}

	public String getPrtDocWgtUtCd() {
		return prtDocWgtUtCd;
	}

	public void setPrtDocWgtUtCd(String prtDocWgtUtCd) {
		this.prtDocWgtUtCd = prtDocWgtUtCd;
	}

	public String getPrtMeasQty() {
		return prtMeasQty;
	}

	public void setPrtMeasQty(String prtMeasQty) {
		this.prtMeasQty = prtMeasQty;
	}

	public String getPrtMeasQtyUtCd() {
		return prtMeasQtyUtCd;
	}

	public void setPrtMeasQtyUtCd(String prtMeasQtyUtCd) {
		this.prtMeasQtyUtCd = prtMeasQtyUtCd;
	}

	public String getPrtDocMeasQty() {
		return prtDocMeasQty;
	}

	public void setPrtDocMeasQty(String prtDocMeasQty) {
		this.prtDocMeasQty = prtDocMeasQty;
	}

	public String getPrtDocMeasUtCd() {
		return prtDocMeasUtCd;
	}

	public void setPrtDocMeasUtCd(String prtDocMeasUtCd) {
		this.prtDocMeasUtCd = prtDocMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param prtVgmWgt
	 */
	public void setPrtVgmWgt(String prtVgmWgt) {
		this.prtVgmWgt = prtVgmWgt;
	}
	
	/**
	 * Column Info
	 * @param prtVgmWgtUtCd
	 */
	public void setPrtVgmWgtUtCd(String prtVgmWgtUtCd) {
		this.prtVgmWgtUtCd = prtVgmWgtUtCd;
	}

	/**
	 * Column Info
	 * @param inCntrMatch
	 */
	public void setInCntrMatch(String inCntrMatch) {
		this.inCntrMatch = inCntrMatch;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInPolTs(JSPUtil.getParameter(request, "in_pol_ts", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setInQty(JSPUtil.getParameter(request, "in_qty", ""));
		setInFeu(JSPUtil.getParameter(request, "in_feu", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setTbnSeq(JSPUtil.getParameter(request, "tbn_seq", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		setInTeu(JSPUtil.getParameter(request, "in_teu", ""));
		setTbxSeq(JSPUtil.getParameter(request, "tbx_seq", ""));
		setInUsrId(JSPUtil.getParameter(request, "in_usr_id", ""));
		setInIncludingType(JSPUtil.getParameter(request, "in_including_type", ""));
		setPrtInTeu(JSPUtil.getParameter(request, "prt_in_teu", ""));
		setPrtInFeu(JSPUtil.getParameter(request, "prt_in_feu", ""));
		setPrtInQty(JSPUtil.getParameter(request, "prt_in_qty", ""));
		setPrtPckQty(JSPUtil.getParameter(request, "prt_pck_qty", ""));
		setPrtPckTpCd(JSPUtil.getParameter(request, "prt_pck_tp_cd", ""));
		setPrtCntrWgt(JSPUtil.getParameter(request, "prt_cntr_wgt", ""));
		setPrtCntrWgtUtCd(JSPUtil.getParameter(request, "prt_cntr_wgt_ut_cd", ""));
		setPrtDocActWgt(JSPUtil.getParameter(request, "prt_doc_act_wgt", ""));
		setPrtDocWgtUtCd(JSPUtil.getParameter(request, "prt_doc_wgt_ut_cd", ""));
		setPrtMeasQty(JSPUtil.getParameter(request, "prt_meas_qty", ""));
		setPrtMeasQtyUtCd(JSPUtil.getParameter(request, "prt_meas_qty_ut_cd", ""));
		setPrtDocMeasQty(JSPUtil.getParameter(request, "prt_doc_meas_qty", ""));
		setPrtDocMeasUtCd(JSPUtil.getParameter(request, "prt_doc_meas_ut_cd", ""));
		setPrtVgmWgt(JSPUtil.getParameter(request, "prt_vgm_wgt", ""));
		setPrtVgmWgtUtCd(JSPUtil.getParameter(request, "prt_vgm_wgt_ut_cd", ""));
		setInCntrMatch(JSPUtil.getParameter(request, "in_cntr_match", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TerminalCllVO[]
	 */
	public TerminalCllVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TerminalCllVO[]
	 */
	public TerminalCllVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TerminalCllVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inPolTs = (JSPUtil.getParameter(request, prefix	+ "in_pol_ts", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] inQty = (JSPUtil.getParameter(request, prefix	+ "in_qty", length));
			String[] inFeu = (JSPUtil.getParameter(request, prefix	+ "in_feu", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] tbnSeq = (JSPUtil.getParameter(request, prefix	+ "tbn_seq", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inTeu = (JSPUtil.getParameter(request, prefix	+ "in_teu", length));
			String[] tbxSeq = (JSPUtil.getParameter(request, prefix	+ "tbx_seq", length));
			String[] inUsrId = (JSPUtil.getParameter(request, prefix	+ "in_usr_id", length));
			String[] inIncludingType = (JSPUtil.getParameter(request, prefix	+ "in_including_type", length));
			String[] prtInTeu = (JSPUtil.getParameter(request, prefix + "prt_in_teu", length));
			String[] prtInFeu = (JSPUtil.getParameter(request, prefix + "prt_in_feu", length));
			String[] prtInQty = (JSPUtil.getParameter(request, prefix + "prt_in_qty", length));
			String[] prtPckQty = (JSPUtil.getParameter(request, prefix + "prt_pck_qty", length));
			String[] prtPckTpCd = (JSPUtil.getParameter(request, prefix + "prt_pck_tp_cd", length));
			String[] prtCntrWgt = (JSPUtil.getParameter(request, prefix + "prt_cntr_wgt", length));
			String[] prtCntrWgtUtCd = (JSPUtil.getParameter(request, prefix + "prt_cntr_wgt_ut_cd", length));
			String[] prtDocActWgt = (JSPUtil.getParameter(request, prefix + "prt_doc_act_wgt", length));
			String[] prtDocWgtUtCd = (JSPUtil.getParameter(request, prefix + "prt_doc_wgt_ut_cd", length));
			String[] prtMeasQty = (JSPUtil.getParameter(request, prefix + "prt_meas_qty", length));
			String[] prtMeasQtyUtCd = (JSPUtil.getParameter(request, prefix + "prt_meas_qty_ut_cd", length));
			String[] prtDocMeasQty = (JSPUtil.getParameter(request, prefix + "prt_doc_meas_qty", length));
			String[] prtDocMeasUtCd = (JSPUtil.getParameter(request, prefix + "prt_doc_meas_ut_cd", length));
			String[] prtVgmWgt = (JSPUtil.getParameter(request, prefix + "prt_vgm_wgt", length));
			String[] prtVgmWgtUtCd = (JSPUtil.getParameter(request, prefix + "prt_vgm_wgt_ut_cd", length));
			String[] inCntrMatch = (JSPUtil.getParameter(request, prefix	+ "in_cntr_match", length));

			for (int i = 0; i < length; i++) {
				model = new TerminalCllVO();
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inPolTs[i] != null)
					model.setInPolTs(inPolTs[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (inQty[i] != null)
					model.setInQty(inQty[i]);
				if (inFeu[i] != null)
					model.setInFeu(inFeu[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tbnSeq[i] != null)
					model.setTbnSeq(tbnSeq[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inTeu[i] != null)
					model.setInTeu(inTeu[i]);
				if (tbxSeq[i] != null)
					model.setTbxSeq(tbxSeq[i]);
				if (inUsrId[i] != null)
					model.setInUsrId(inUsrId[i]);
				if (inIncludingType[i] != null)
					model.setInIncludingType(inIncludingType[i]);
				if (prtInTeu[i] != null)
					model.setPrtInTeu(prtInTeu[i]);
				if (prtInFeu[i] != null)
					model.setPrtInFeu(prtInFeu[i]);
				if (prtInQty[i] != null)
					model.setPrtInQty(prtInQty[i]);
				if (prtPckQty[i] != null)
					model.setPrtPckQty(prtPckQty[i]);
				if (prtPckTpCd[i] != null)
					model.setPrtPckTpCd(prtPckTpCd[i]);
				if (prtCntrWgt[i] != null)
					model.setPrtCntrWgt(prtCntrWgt[i]);
				if (prtCntrWgtUtCd[i] != null)
					model.setPrtCntrWgtUtCd(prtCntrWgtUtCd[i]);
				if (prtDocActWgt[i] != null)
					model.setPrtDocActWgt(prtDocActWgt[i]);
				if (prtDocWgtUtCd[i] != null)
					model.setPrtDocWgtUtCd(prtDocWgtUtCd[i]);
				if (prtMeasQty[i] != null)
					model.setPrtMeasQty(prtMeasQty[i]);
				if (prtMeasQtyUtCd[i] != null)
					model.setPrtMeasQtyUtCd(prtMeasQtyUtCd[i]);
				if (prtDocMeasQty[i] != null)
					model.setPrtDocMeasQty(prtDocMeasQty[i]);
				if (prtDocMeasUtCd[i] != null)
					model.setPrtDocMeasUtCd(prtDocMeasUtCd[i]);
				if (prtVgmWgt[i] != null)
					model.setPrtVgmWgt(prtVgmWgt[i]);
				if (prtVgmWgtUtCd[i] != null)
					model.setPrtVgmWgtUtCd(prtVgmWgtUtCd[i]);
				if (inCntrMatch[i] != null)
					model.setInCntrMatch(inCntrMatch[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTerminalCllVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TerminalCllVO[]
	 */
	public TerminalCllVO[] getTerminalCllVOs(){
		TerminalCllVO[] vos = (TerminalCllVO[])models.toArray(new TerminalCllVO[models.size()]);
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
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolTs = this.inPolTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inQty = this.inQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFeu = this.inFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbnSeq = this.tbnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTeu = this.inTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbxSeq = this.tbxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUsrId = this.inUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inIncludingType = this.inIncludingType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtInTeu = this.prtInTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtInFeu = this.prtInFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtInQty = this.prtInQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtPckQty = this.prtPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtPckTpCd = this.prtPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtCntrWgt = this.prtCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtCntrWgtUtCd = this.prtCntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtDocActWgt = this.prtDocActWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtDocWgtUtCd = this.prtDocWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtMeasQty = this.prtMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtMeasQtyUtCd = this.prtMeasQtyUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtDocMeasQty = this.prtDocMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtDocMeasUtCd = this.prtDocMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtVgmWgt = this.prtVgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtVgmWgtUtCd = this.prtVgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrMatch = this.inCntrMatch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
