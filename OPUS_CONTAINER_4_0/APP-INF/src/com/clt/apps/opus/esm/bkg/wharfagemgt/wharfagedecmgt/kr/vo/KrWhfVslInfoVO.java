/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfVslInfoVO.java
*@FileTitle : KrWhfVslInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.05 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfVslInfoVO extends WhfVslInfoVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfVslInfoVO> models = new ArrayList<KrWhfVslInfoVO>();
	
	/* Column Info */
	private String whfPayDt = null;
	/* Column Info */
	private String mrnChkNo = null;
	/* Column Info */
	private String whfBndCd = null;
	/* Column Info */
	private String arrYr = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String vpsDt = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String mfRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String unldAgnCd1 = null;
	/* Column Info */
	private String arrTmsNo = null;
	/* Column Info */
	private String portNm = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String unldAgnCd2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String unldAgnCd3 = null;
	/* Column Info */
	private String whfVolDcCd = null;
	/* Column Info */
	private String unldTpCd = null;
	/* Column Info */
	private String ioPortCd = null;
	/* Column Info */
	private String vslCallSgnCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String whfRt = null;

	private String brthCd = null;
	
	private String payDt = null;

	private String arIfFlg = null;

	private String newChgAmt = null;

	private String chgRtSeq = null;
	
	private String updUsrId = null;
	
	private String updDt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfVslInfoVO() {}

	public KrWhfVslInfoVO(String ibflag, String pagerows, String vvd, String portCd, String whfBndCd, String vpsDt, 
			String mrnNo, String whfDeclNo, String mrnChkNo, String vslCallSgnCd, String tmlCd, String arrTmsNo, String arrYr, 
			String ioPortCd, String unldTpCd, String unldAgnCd1, String unldAgnCd2, String unldAgnCd3, String whfVolDcCd, 
			String whfRt, String mfRefNo, String whfPayDt, String portNm, String vslNm, String sailDt, String brthCd, String payDt, 
			String arIfFlg, String newChgAmt, String chgRtSeq, String updUsrId, String updDt) {
		this.whfPayDt = whfPayDt;
		this.mrnChkNo = mrnChkNo;
		this.whfBndCd = whfBndCd;
		this.arrYr = arrYr;
		this.mrnNo = mrnNo;
		this.whfDeclNo = whfDeclNo;
		this.tmlCd = tmlCd;
		this.vpsDt = vpsDt;
		this.sailDt = sailDt;
		this.mfRefNo = mfRefNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.unldAgnCd1 = unldAgnCd1;
		this.arrTmsNo = arrTmsNo;
		this.portNm = portNm;
		this.vslNm = vslNm;
		this.unldAgnCd2 = unldAgnCd2;
		this.ibflag = ibflag;
		this.unldAgnCd3 = unldAgnCd3;
		this.whfVolDcCd = whfVolDcCd;
		this.unldTpCd = unldTpCd;
		this.ioPortCd = ioPortCd;
		this.vslCallSgnCd = vslCallSgnCd;
		this.portCd = portCd;
		this.whfRt = whfRt;
		this.brthCd = brthCd;
		this.payDt = payDt;
		this.arIfFlg = arIfFlg;
		this.newChgAmt = newChgAmt;
		this.chgRtSeq = chgRtSeq;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("whf_pay_dt", getWhfPayDt());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("whf_bnd_cd", getWhfBndCd());
		this.hashColumns.put("arr_yr", getArrYr());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("vps_dt", getVpsDt());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("mf_ref_no", getMfRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("unld_agn_cd1", getUnldAgnCd1());
		this.hashColumns.put("arr_tms_no", getArrTmsNo());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("unld_agn_cd2", getUnldAgnCd2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("unld_agn_cd3", getUnldAgnCd3());
		this.hashColumns.put("whf_vol_dc_cd", getWhfVolDcCd());
		this.hashColumns.put("unld_tp_cd", getUnldTpCd());
		this.hashColumns.put("io_port_cd", getIoPortCd());
		this.hashColumns.put("vsl_call_sgn_cd", getVslCallSgnCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("whf_rt", getWhfRt());
		this.hashColumns.put("brth_cd", getBrthCd());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("ar_if_flg", getArIfFlg());
		this.hashColumns.put("new_chg_amt", getNewChgAmt());
		this.hashColumns.put("chg_rt_seq", getChgRtSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("whf_pay_dt", "whfPayDt");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("whf_bnd_cd", "whfBndCd");
		this.hashFields.put("arr_yr", "arrYr");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("vps_dt", "vpsDt");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("mf_ref_no", "mfRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("unld_agn_cd1", "unldAgnCd1");
		this.hashFields.put("arr_tms_no", "arrTmsNo");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("unld_agn_cd2", "unldAgnCd2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("unld_agn_cd3", "unldAgnCd3");
		this.hashFields.put("whf_vol_dc_cd", "whfVolDcCd");
		this.hashFields.put("unld_tp_cd", "unldTpCd");
		this.hashFields.put("io_port_cd", "ioPortCd");
		this.hashFields.put("vsl_call_sgn_cd", "vslCallSgnCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("whf_rt", "whfRt");
		this.hashFields.put("brth_cd", "brthCd");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("ar_if_flg", "arIfFlg");
		this.hashFields.put("new_chg_amt", "newChgAmt");
		this.hashFields.put("chg_rt_seq", "chgRtSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	public String getChgRtSeq() {
		return chgRtSeq;
	}

	public void setChgRtSeq(String chgRtSeq) {
		this.chgRtSeq = chgRtSeq;
	}

	public String getNewChgAmt() {
		return newChgAmt;
	}

	public void setNewChgAmt(String newChgAmt) {
		this.newChgAmt = newChgAmt;
	}

	public String getArIfFlg() {
		return arIfFlg;
	}

	public void setArIfFlg(String arIfFlg) {
		this.arIfFlg = arIfFlg;
	}

	public String getPayDt() {
		return payDt;
	}

	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}

	public String getBrthCd() {
		return brthCd;
	}

	public void setBrthCd(String brthCd) {
		this.brthCd = brthCd;
	}

	/**
	 * Column Info
	 * @return whfPayDt
	 */
	public String getWhfPayDt() {
		return this.whfPayDt;
	}
	
	/**
	 * Column Info
	 * @return mrnChkNo
	 */
	public String getMrnChkNo() {
		return this.mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @return whfBndCd
	 */
	public String getWhfBndCd() {
		return this.whfBndCd;
	}
	
	/**
	 * Column Info
	 * @return arrYr
	 */
	public String getArrYr() {
		return this.arrYr;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}
	
	/**
	 * Column Info
	 * @return whfDeclNo
	 */
	public String getWhfDeclNo() {
		return this.whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return vpsDt
	 */
	public String getVpsDt() {
		return this.vpsDt;
	}
	
	/**
	 * Column Info
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
	}
	
	/**
	 * Column Info
	 * @return mfRefNo
	 */
	public String getMfRefNo() {
		return this.mfRefNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return unldAgnCd1
	 */
	public String getUnldAgnCd1() {
		return this.unldAgnCd1;
	}
	
	/**
	 * Column Info
	 * @return arrTmsNo
	 */
	public String getArrTmsNo() {
		return this.arrTmsNo;
	}
	
	/**
	 * Column Info
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return unldAgnCd2
	 */
	public String getUnldAgnCd2() {
		return this.unldAgnCd2;
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
	 * @return unldAgnCd3
	 */
	public String getUnldAgnCd3() {
		return this.unldAgnCd3;
	}
	
	/**
	 * Column Info
	 * @return whfVolDcCd
	 */
	public String getWhfVolDcCd() {
		return this.whfVolDcCd;
	}
	
	/**
	 * Column Info
	 * @return unldTpCd
	 */
	public String getUnldTpCd() {
		return this.unldTpCd;
	}
	
	/**
	 * Column Info
	 * @return ioPortCd
	 */
	public String getIoPortCd() {
		return this.ioPortCd;
	}
	
	/**
	 * Column Info
	 * @return vslCallSgnCd
	 */
	public String getVslCallSgnCd() {
		return this.vslCallSgnCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return whfRt
	 */
	public String getWhfRt() {
		return this.whfRt;
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
	 * @param whfPayDt
	 */
	public void setWhfPayDt(String whfPayDt) {
		this.whfPayDt = whfPayDt;
	}
	
	/**
	 * Column Info
	 * @param mrnChkNo
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @param whfBndCd
	 */
	public void setWhfBndCd(String whfBndCd) {
		this.whfBndCd = whfBndCd;
	}
	
	/**
	 * Column Info
	 * @param arrYr
	 */
	public void setArrYr(String arrYr) {
		this.arrYr = arrYr;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}
	
	/**
	 * Column Info
	 * @param whfDeclNo
	 */
	public void setWhfDeclNo(String whfDeclNo) {
		this.mrnNo = whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param vpsDt
	 */
	public void setVpsDt(String vpsDt) {
		this.vpsDt = vpsDt;
	}
	
	/**
	 * Column Info
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}
	
	/**
	 * Column Info
	 * @param mfRefNo
	 */
	public void setMfRefNo(String mfRefNo) {
		this.mfRefNo = mfRefNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param unldAgnCd1
	 */
	public void setUnldAgnCd1(String unldAgnCd1) {
		this.unldAgnCd1 = unldAgnCd1;
	}
	
	/**
	 * Column Info
	 * @param arrTmsNo
	 */
	public void setArrTmsNo(String arrTmsNo) {
		this.arrTmsNo = arrTmsNo;
	}
	
	/**
	 * Column Info
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param unldAgnCd2
	 */
	public void setUnldAgnCd2(String unldAgnCd2) {
		this.unldAgnCd2 = unldAgnCd2;
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
	 * @param unldAgnCd3
	 */
	public void setUnldAgnCd3(String unldAgnCd3) {
		this.unldAgnCd3 = unldAgnCd3;
	}
	
	/**
	 * Column Info
	 * @param whfVolDcCd
	 */
	public void setWhfVolDcCd(String whfVolDcCd) {
		this.whfVolDcCd = whfVolDcCd;
	}
	
	/**
	 * Column Info
	 * @param unldTpCd
	 */
	public void setUnldTpCd(String unldTpCd) {
		this.unldTpCd = unldTpCd;
	}
	
	/**
	 * Column Info
	 * @param ioPortCd
	 */
	public void setIoPortCd(String ioPortCd) {
		this.ioPortCd = ioPortCd;
	}
	
	/**
	 * Column Info
	 * @param vslCallSgnCd
	 */
	public void setVslCallSgnCd(String vslCallSgnCd) {
		this.vslCallSgnCd = vslCallSgnCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param whfRt
	 */
	public void setWhfRt(String whfRt) {
		this.whfRt = whfRt;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setWhfPayDt(JSPUtil.getParameter(request, "whf_pay_dt", ""));
		setMrnChkNo(JSPUtil.getParameter(request, "mrn_chk_no", ""));
		setWhfBndCd(JSPUtil.getParameter(request, "whf_bnd_cd", ""));
		setArrYr(JSPUtil.getParameter(request, "arr_yr", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setVpsDt(JSPUtil.getParameter(request, "vps_dt", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setMfRefNo(JSPUtil.getParameter(request, "mf_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setUnldAgnCd1(JSPUtil.getParameter(request, "unld_agn_cd1", ""));
		setArrTmsNo(JSPUtil.getParameter(request, "arr_tms_no", ""));
		setPortNm(JSPUtil.getParameter(request, "port_nm", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setUnldAgnCd2(JSPUtil.getParameter(request, "unld_agn_cd2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUnldAgnCd3(JSPUtil.getParameter(request, "unld_agn_cd3", ""));
		setWhfVolDcCd(JSPUtil.getParameter(request, "whf_vol_dc_cd", ""));
		setUnldTpCd(JSPUtil.getParameter(request, "unld_tp_cd", ""));
		setIoPortCd(JSPUtil.getParameter(request, "io_port_cd", ""));
		setVslCallSgnCd(JSPUtil.getParameter(request, "vsl_call_sgn_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setWhfRt(JSPUtil.getParameter(request, "whf_rt", ""));
		setBrthCd(JSPUtil.getParameter(request, "brth_cd", ""));
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setArIfFlg(JSPUtil.getParameter(request, "ar_if_flg", ""));
		setNewChgAmt(JSPUtil.getParameter(request, "new_chg_amt", ""));
		setChgRtSeq(JSPUtil.getParameter(request, "chg_rt_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id"));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt"));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfVslInfoVO[]
	 */
	public KrWhfVslInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfVslInfoVO[]
	 */
	public KrWhfVslInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfVslInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] whfPayDt = (JSPUtil.getParameter(request, prefix	+ "whf_pay_dt", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] whfBndCd = (JSPUtil.getParameter(request, prefix	+ "whf_bnd_cd", length));
			String[] arrYr = (JSPUtil.getParameter(request, prefix	+ "arr_yr", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] vpsDt = (JSPUtil.getParameter(request, prefix	+ "vps_dt", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] mfRefNo = (JSPUtil.getParameter(request, prefix	+ "mf_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] unldAgnCd1 = (JSPUtil.getParameter(request, prefix	+ "unld_agn_cd1", length));
			String[] arrTmsNo = (JSPUtil.getParameter(request, prefix	+ "arr_tms_no", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] unldAgnCd2 = (JSPUtil.getParameter(request, prefix	+ "unld_agn_cd2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] unldAgnCd3 = (JSPUtil.getParameter(request, prefix	+ "unld_agn_cd3", length));
			String[] whfVolDcCd = (JSPUtil.getParameter(request, prefix	+ "whf_vol_dc_cd", length));
			String[] unldTpCd = (JSPUtil.getParameter(request, prefix	+ "unld_tp_cd", length));
			String[] ioPortCd = (JSPUtil.getParameter(request, prefix	+ "io_port_cd", length));
			String[] vslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] whfRt = (JSPUtil.getParameter(request, prefix	+ "whf_rt", length));
			String[] brthCd = (JSPUtil.getParameter(request, prefix	+ "brth_cd", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] arIfFlg = (JSPUtil.getParameter(request, prefix	+ "ar_if_flg", length));
			String[] newChgAmt = (JSPUtil.getParameter(request, prefix	+ "new_chg_amt", length));
			String[] chgRtSeq = (JSPUtil.getParameter(request, prefix	+ "chg_rt_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfVslInfoVO();
				if (whfPayDt[i] != null)
					model.setWhfPayDt(whfPayDt[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (whfBndCd[i] != null)
					model.setWhfBndCd(whfBndCd[i]);
				if (arrYr[i] != null)
					model.setArrYr(arrYr[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (vpsDt[i] != null)
					model.setVpsDt(vpsDt[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (mfRefNo[i] != null)
					model.setMfRefNo(mfRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (unldAgnCd1[i] != null)
					model.setUnldAgnCd1(unldAgnCd1[i]);
				if (arrTmsNo[i] != null)
					model.setArrTmsNo(arrTmsNo[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (unldAgnCd2[i] != null)
					model.setUnldAgnCd2(unldAgnCd2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (unldAgnCd3[i] != null)
					model.setUnldAgnCd3(unldAgnCd3[i]);
				if (whfVolDcCd[i] != null)
					model.setWhfVolDcCd(whfVolDcCd[i]);
				if (unldTpCd[i] != null)
					model.setUnldTpCd(unldTpCd[i]);
				if (ioPortCd[i] != null)
					model.setIoPortCd(ioPortCd[i]);
				if (vslCallSgnCd[i] != null)
					model.setVslCallSgnCd(vslCallSgnCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (whfRt[i] != null)
					model.setWhfRt(whfRt[i]);
				if (brthCd[i] != null)
					model.setBrthCd(brthCd[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (arIfFlg[i] != null)
					model.setArIfFlg(arIfFlg[i]);
				if (newChgAmt[i] != null)
					model.setNewChgAmt(newChgAmt[i]);
				if (chgRtSeq[i] != null)
					model.setChgRtSeq(chgRtSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfVslInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfVslInfoVO[]
	 */
	public KrWhfVslInfoVO[] getKrWhfVslInfoVOs(){
		KrWhfVslInfoVO[] vos = (KrWhfVslInfoVO[])models.toArray(new KrWhfVslInfoVO[models.size()]);
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
		this.whfPayDt = this.whfPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChkNo = this.mrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBndCd = this.whfBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrYr = this.arrYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsDt = this.vpsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRefNo = this.mfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unldAgnCd1 = this.unldAgnCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTmsNo = this.arrTmsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unldAgnCd2 = this.unldAgnCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unldAgnCd3 = this.unldAgnCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfVolDcCd = this.whfVolDcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unldTpCd = this.unldTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioPortCd = this.ioPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnCd = this.vslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfRt  = this.whfRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthCd = this.brthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt  = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfFlg   = this.arIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newChgAmt = this.newChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRtSeq  = this.chgRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId  = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt  = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
