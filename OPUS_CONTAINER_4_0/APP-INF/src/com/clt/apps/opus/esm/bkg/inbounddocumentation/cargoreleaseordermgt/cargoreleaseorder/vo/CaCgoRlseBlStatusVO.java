/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaCgoRlseBlStatusVO.java
*@FileTitle : CaCgoRlseBlStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.12.23 박성호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
 
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaCgoRlseBlStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaCgoRlseBlStatusVO> models = new ArrayList<CaCgoRlseBlStatusVO>();
	
	/* Column Info */
	private String blIbdUsrId = null;
	/* Column Info */
	private String blRlse = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String otrDocRcvOfcCd = null;
	/* Column Info */
	private String blRlseOfcCd = null;
	/* Column Info */
	private String otrDocRcvUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oblRdemDt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String blOtrDocRcvCd = null;
	/* Column Info */
	private String oblIssRmk = null;
	/* Column Info */
	private String blCpyKnt = null;
	/* Column Info */
	private String blIbdDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String otrDocRcvDt = null;
	/* Column Info */
	private String oblRdemKnt = null;
	/* Column Info */
	private String blRlseDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String oblRdemUsrId = null;
	/* Column Info */
	private String blStatus = null;
	/* Column Info */
	private String blIbd = null;
	/* Column Info */
	private String blRlseUsrId = null;
	/* Column Info */
	private String oblRdemOfcCd = null;
	/* Column Info */
	private String blIbdOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaCgoRlseBlStatusVO() {}

	public CaCgoRlseBlStatusVO(String ibflag, String pagerows, String bkgNo, String blNo, String blStatus, String blCpyKnt, String blRlse, String blRlseOfcCd, String blRlseUsrId, String blRlseDt, String oblRdemKnt, String oblRdemOfcCd, String oblRdemUsrId, String oblRdemDt, String blIbd, String blIbdOfcCd, String blIbdUsrId, String blIbdDt, String blOtrDocRcvCd, String otrDocRcvOfcCd, String otrDocRcvUsrId, String otrDocRcvDt, String cntCd, String delCd, String oblIssRmk) {
		this.blIbdUsrId = blIbdUsrId;
		this.blRlse = blRlse;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.otrDocRcvOfcCd = otrDocRcvOfcCd;
		this.blRlseOfcCd = blRlseOfcCd;
		this.otrDocRcvUsrId = otrDocRcvUsrId;
		this.ibflag = ibflag;
		this.oblRdemDt = oblRdemDt;
		this.cntCd = cntCd;
		this.blOtrDocRcvCd = blOtrDocRcvCd;
		this.oblIssRmk = oblIssRmk;
		this.blCpyKnt = blCpyKnt;
		this.blIbdDt = blIbdDt;
		this.delCd = delCd;
		this.otrDocRcvDt = otrDocRcvDt;
		this.oblRdemKnt = oblRdemKnt;
		this.blRlseDt = blRlseDt;
		this.bkgNo = bkgNo;
		this.oblRdemUsrId = oblRdemUsrId;
		this.blStatus = blStatus;
		this.blIbd = blIbd;
		this.blRlseUsrId = blRlseUsrId;
		this.oblRdemOfcCd = oblRdemOfcCd;
		this.blIbdOfcCd = blIbdOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_ibd_usr_id", getBlIbdUsrId());
		this.hashColumns.put("bl_rlse", getBlRlse());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("otr_doc_rcv_ofc_cd", getOtrDocRcvOfcCd());
		this.hashColumns.put("bl_rlse_ofc_cd", getBlRlseOfcCd());
		this.hashColumns.put("otr_doc_rcv_usr_id", getOtrDocRcvUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("obl_rdem_dt", getOblRdemDt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("bl_otr_doc_rcv_cd", getBlOtrDocRcvCd());
		this.hashColumns.put("obl_iss_rmk", getOblIssRmk());
		this.hashColumns.put("bl_cpy_knt", getBlCpyKnt());
		this.hashColumns.put("bl_ibd_dt", getBlIbdDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("otr_doc_rcv_dt", getOtrDocRcvDt());
		this.hashColumns.put("obl_rdem_knt", getOblRdemKnt());
		this.hashColumns.put("bl_rlse_dt", getBlRlseDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("obl_rdem_usr_id", getOblRdemUsrId());
		this.hashColumns.put("bl_status", getBlStatus());
		this.hashColumns.put("bl_ibd", getBlIbd());
		this.hashColumns.put("bl_rlse_usr_id", getBlRlseUsrId());
		this.hashColumns.put("obl_rdem_ofc_cd", getOblRdemOfcCd());
		this.hashColumns.put("bl_ibd_ofc_cd", getBlIbdOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_ibd_usr_id", "blIbdUsrId");
		this.hashFields.put("bl_rlse", "blRlse");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("otr_doc_rcv_ofc_cd", "otrDocRcvOfcCd");
		this.hashFields.put("bl_rlse_ofc_cd", "blRlseOfcCd");
		this.hashFields.put("otr_doc_rcv_usr_id", "otrDocRcvUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obl_rdem_dt", "oblRdemDt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("bl_otr_doc_rcv_cd", "blOtrDocRcvCd");
		this.hashFields.put("obl_iss_rmk", "oblIssRmk");
		this.hashFields.put("bl_cpy_knt", "blCpyKnt");
		this.hashFields.put("bl_ibd_dt", "blIbdDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("otr_doc_rcv_dt", "otrDocRcvDt");
		this.hashFields.put("obl_rdem_knt", "oblRdemKnt");
		this.hashFields.put("bl_rlse_dt", "blRlseDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("obl_rdem_usr_id", "oblRdemUsrId");
		this.hashFields.put("bl_status", "blStatus");
		this.hashFields.put("bl_ibd", "blIbd");
		this.hashFields.put("bl_rlse_usr_id", "blRlseUsrId");
		this.hashFields.put("obl_rdem_ofc_cd", "oblRdemOfcCd");
		this.hashFields.put("bl_ibd_ofc_cd", "blIbdOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blIbdUsrId
	 */
	public String getBlIbdUsrId() {
		return this.blIbdUsrId;
	}
	
	/**
	 * Column Info
	 * @return blRlse
	 */
	public String getBlRlse() {
		return this.blRlse;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return otrDocRcvOfcCd
	 */
	public String getOtrDocRcvOfcCd() {
		return this.otrDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blRlseOfcCd
	 */
	public String getBlRlseOfcCd() {
		return this.blRlseOfcCd;
	}
	
	/**
	 * Column Info
	 * @return otrDocRcvUsrId
	 */
	public String getOtrDocRcvUsrId() {
		return this.otrDocRcvUsrId;
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
	 * @return oblRdemDt
	 */
	public String getOblRdemDt() {
		return this.oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return blOtrDocRcvCd
	 */
	public String getBlOtrDocRcvCd() {
		return this.blOtrDocRcvCd;
	}
	
	/**
	 * Column Info
	 * @return oblIssRmk
	 */
	public String getOblIssRmk() {
		return this.oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @return blCpyKnt
	 */
	public String getBlCpyKnt() {
		return this.blCpyKnt;
	}
	
	/**
	 * Column Info
	 * @return blIbdDt
	 */
	public String getBlIbdDt() {
		return this.blIbdDt;
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
	 * @return otrDocRcvDt
	 */
	public String getOtrDocRcvDt() {
		return this.otrDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @return oblRdemKnt
	 */
	public String getOblRdemKnt() {
		return this.oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @return blRlseDt
	 */
	public String getBlRlseDt() {
		return this.blRlseDt;
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
	 * @return oblRdemUsrId
	 */
	public String getOblRdemUsrId() {
		return this.oblRdemUsrId;
	}
	
	/**
	 * Column Info
	 * @return blStatus
	 */
	public String getBlStatus() {
		return this.blStatus;
	}
	
	/**
	 * Column Info
	 * @return blIbd
	 */
	public String getBlIbd() {
		return this.blIbd;
	}
	
	/**
	 * Column Info
	 * @return blRlseUsrId
	 */
	public String getBlRlseUsrId() {
		return this.blRlseUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblRdemOfcCd
	 */
	public String getOblRdemOfcCd() {
		return this.oblRdemOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blIbdOfcCd
	 */
	public String getBlIbdOfcCd() {
		return this.blIbdOfcCd;
	}
	

	/**
	 * Column Info
	 * @param blIbdUsrId
	 */
	public void setBlIbdUsrId(String blIbdUsrId) {
		this.blIbdUsrId = blIbdUsrId;
	}
	
	/**
	 * Column Info
	 * @param blRlse
	 */
	public void setBlRlse(String blRlse) {
		this.blRlse = blRlse;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param otrDocRcvOfcCd
	 */
	public void setOtrDocRcvOfcCd(String otrDocRcvOfcCd) {
		this.otrDocRcvOfcCd = otrDocRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blRlseOfcCd
	 */
	public void setBlRlseOfcCd(String blRlseOfcCd) {
		this.blRlseOfcCd = blRlseOfcCd;
	}
	
	/**
	 * Column Info
	 * @param otrDocRcvUsrId
	 */
	public void setOtrDocRcvUsrId(String otrDocRcvUsrId) {
		this.otrDocRcvUsrId = otrDocRcvUsrId;
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
	 * @param oblRdemDt
	 */
	public void setOblRdemDt(String oblRdemDt) {
		this.oblRdemDt = oblRdemDt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param blOtrDocRcvCd
	 */
	public void setBlOtrDocRcvCd(String blOtrDocRcvCd) {
		this.blOtrDocRcvCd = blOtrDocRcvCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssRmk
	 */
	public void setOblIssRmk(String oblIssRmk) {
		this.oblIssRmk = oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @param blCpyKnt
	 */
	public void setBlCpyKnt(String blCpyKnt) {
		this.blCpyKnt = blCpyKnt;
	}
	
	/**
	 * Column Info
	 * @param blIbdDt
	 */
	public void setBlIbdDt(String blIbdDt) {
		this.blIbdDt = blIbdDt;
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
	 * @param otrDocRcvDt
	 */
	public void setOtrDocRcvDt(String otrDocRcvDt) {
		this.otrDocRcvDt = otrDocRcvDt;
	}
	
	/**
	 * Column Info
	 * @param oblRdemKnt
	 */
	public void setOblRdemKnt(String oblRdemKnt) {
		this.oblRdemKnt = oblRdemKnt;
	}
	
	/**
	 * Column Info
	 * @param blRlseDt
	 */
	public void setBlRlseDt(String blRlseDt) {
		this.blRlseDt = blRlseDt;
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
	 * @param oblRdemUsrId
	 */
	public void setOblRdemUsrId(String oblRdemUsrId) {
		this.oblRdemUsrId = oblRdemUsrId;
	}
	
	/**
	 * Column Info
	 * @param blStatus
	 */
	public void setBlStatus(String blStatus) {
		this.blStatus = blStatus;
	}
	
	/**
	 * Column Info
	 * @param blIbd
	 */
	public void setBlIbd(String blIbd) {
		this.blIbd = blIbd;
	}
	
	/**
	 * Column Info
	 * @param blRlseUsrId
	 */
	public void setBlRlseUsrId(String blRlseUsrId) {
		this.blRlseUsrId = blRlseUsrId;
	}
	
	/**
	 * Column Info
	 * @param oblRdemOfcCd
	 */
	public void setOblRdemOfcCd(String oblRdemOfcCd) {
		this.oblRdemOfcCd = oblRdemOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blIbdOfcCd
	 */
	public void setBlIbdOfcCd(String blIbdOfcCd) {
		this.blIbdOfcCd = blIbdOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlIbdUsrId(JSPUtil.getParameter(request, "bl_ibd_usr_id", ""));
		setBlRlse(JSPUtil.getParameter(request, "bl_rlse", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOtrDocRcvOfcCd(JSPUtil.getParameter(request, "otr_doc_rcv_ofc_cd", ""));
		setBlRlseOfcCd(JSPUtil.getParameter(request, "bl_rlse_ofc_cd", ""));
		setOtrDocRcvUsrId(JSPUtil.getParameter(request, "otr_doc_rcv_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOblRdemDt(JSPUtil.getParameter(request, "obl_rdem_dt", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setBlOtrDocRcvCd(JSPUtil.getParameter(request, "bl_otr_doc_rcv_cd", ""));
		setOblIssRmk(JSPUtil.getParameter(request, "obl_iss_rmk", ""));
		setBlCpyKnt(JSPUtil.getParameter(request, "bl_cpy_knt", ""));
		setBlIbdDt(JSPUtil.getParameter(request, "bl_ibd_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setOtrDocRcvDt(JSPUtil.getParameter(request, "otr_doc_rcv_dt", ""));
		setOblRdemKnt(JSPUtil.getParameter(request, "obl_rdem_knt", ""));
		setBlRlseDt(JSPUtil.getParameter(request, "bl_rlse_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setOblRdemUsrId(JSPUtil.getParameter(request, "obl_rdem_usr_id", ""));
		setBlStatus(JSPUtil.getParameter(request, "bl_status", ""));
		setBlIbd(JSPUtil.getParameter(request, "bl_ibd", ""));
		setBlRlseUsrId(JSPUtil.getParameter(request, "bl_rlse_usr_id", ""));
		setOblRdemOfcCd(JSPUtil.getParameter(request, "obl_rdem_ofc_cd", ""));
		setBlIbdOfcCd(JSPUtil.getParameter(request, "bl_ibd_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaCgoRlseBlStatusVO[]
	 */
	public CaCgoRlseBlStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaCgoRlseBlStatusVO[]
	 */
	public CaCgoRlseBlStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaCgoRlseBlStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blIbdUsrId = (JSPUtil.getParameter(request, prefix	+ "bl_ibd_usr_id", length));
			String[] blRlse = (JSPUtil.getParameter(request, prefix	+ "bl_rlse", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] otrDocRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_ofc_cd", length));
			String[] blRlseOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_rlse_ofc_cd", length));
			String[] otrDocRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oblRdemDt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_dt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] blOtrDocRcvCd = (JSPUtil.getParameter(request, prefix	+ "bl_otr_doc_rcv_cd", length));
			String[] oblIssRmk = (JSPUtil.getParameter(request, prefix	+ "obl_iss_rmk", length));
			String[] blCpyKnt = (JSPUtil.getParameter(request, prefix	+ "bl_cpy_knt", length));
			String[] blIbdDt = (JSPUtil.getParameter(request, prefix	+ "bl_ibd_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] otrDocRcvDt = (JSPUtil.getParameter(request, prefix	+ "otr_doc_rcv_dt", length));
			String[] oblRdemKnt = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_knt", length));
			String[] blRlseDt = (JSPUtil.getParameter(request, prefix	+ "bl_rlse_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] oblRdemUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_usr_id", length));
			String[] blStatus = (JSPUtil.getParameter(request, prefix	+ "bl_status", length));
			String[] blIbd = (JSPUtil.getParameter(request, prefix	+ "bl_ibd", length));
			String[] blRlseUsrId = (JSPUtil.getParameter(request, prefix	+ "bl_rlse_usr_id", length));
			String[] oblRdemOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_ofc_cd", length));
			String[] blIbdOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_ibd_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaCgoRlseBlStatusVO();
				if (blIbdUsrId[i] != null)
					model.setBlIbdUsrId(blIbdUsrId[i]);
				if (blRlse[i] != null)
					model.setBlRlse(blRlse[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (otrDocRcvOfcCd[i] != null)
					model.setOtrDocRcvOfcCd(otrDocRcvOfcCd[i]);
				if (blRlseOfcCd[i] != null)
					model.setBlRlseOfcCd(blRlseOfcCd[i]);
				if (otrDocRcvUsrId[i] != null)
					model.setOtrDocRcvUsrId(otrDocRcvUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oblRdemDt[i] != null)
					model.setOblRdemDt(oblRdemDt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (blOtrDocRcvCd[i] != null)
					model.setBlOtrDocRcvCd(blOtrDocRcvCd[i]);
				if (oblIssRmk[i] != null)
					model.setOblIssRmk(oblIssRmk[i]);
				if (blCpyKnt[i] != null)
					model.setBlCpyKnt(blCpyKnt[i]);
				if (blIbdDt[i] != null)
					model.setBlIbdDt(blIbdDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (otrDocRcvDt[i] != null)
					model.setOtrDocRcvDt(otrDocRcvDt[i]);
				if (oblRdemKnt[i] != null)
					model.setOblRdemKnt(oblRdemKnt[i]);
				if (blRlseDt[i] != null)
					model.setBlRlseDt(blRlseDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (oblRdemUsrId[i] != null)
					model.setOblRdemUsrId(oblRdemUsrId[i]);
				if (blStatus[i] != null)
					model.setBlStatus(blStatus[i]);
				if (blIbd[i] != null)
					model.setBlIbd(blIbd[i]);
				if (blRlseUsrId[i] != null)
					model.setBlRlseUsrId(blRlseUsrId[i]);
				if (oblRdemOfcCd[i] != null)
					model.setOblRdemOfcCd(oblRdemOfcCd[i]);
				if (blIbdOfcCd[i] != null)
					model.setBlIbdOfcCd(blIbdOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaCgoRlseBlStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaCgoRlseBlStatusVO[]
	 */
	public CaCgoRlseBlStatusVO[] getCaCgoRlseBlStatusVOs(){
		CaCgoRlseBlStatusVO[] vos = (CaCgoRlseBlStatusVO[])models.toArray(new CaCgoRlseBlStatusVO[models.size()]);
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
		this.blIbdUsrId = this.blIbdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRlse = this.blRlse .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvOfcCd = this.otrDocRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRlseOfcCd = this.blRlseOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvUsrId = this.otrDocRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemDt = this.oblRdemDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOtrDocRcvCd = this.blOtrDocRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssRmk = this.oblIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCpyKnt = this.blCpyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIbdDt = this.blIbdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDocRcvDt = this.otrDocRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemKnt = this.oblRdemKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRlseDt = this.blRlseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemUsrId = this.oblRdemUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blStatus = this.blStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIbd = this.blIbd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRlseUsrId = this.blRlseUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemOfcCd = this.oblRdemOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIbdOfcCd = this.blIbdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
