/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArrNtcCustCodeErrListVO.java
*@FileTitle : ArrNtcCustCodeErrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcCustCodeErrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcCustCodeErrListVO> models = new ArrayList<ArrNtcCustCodeErrListVO>();
	
	/* Column Info */
	private String evlOfcCd = null;
	/* Column Info */
	private String custTpCdNm = null;
	/* Column Info */
	private String evlUsrId = null;
	/* Column Info */
	private String crtCdCreDt = null;
	/* Column Info */
	private String evlRstNm = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String evlRstCd = null;
	/* Column Info */
	private String ibEvCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String hqEvCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String obEvCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cdCreDt = null;
	/* Column Info */
	private String cdInputUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String crtCd = null;
	/* Column Info */
	private String cdInputDt = null;
	/* Column Info */
	private String evlDt = null;
	/* Column Info */
	private String cdInputOfcCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String errCd = null;
	/* Column Info */
	private String bkgOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcCustCodeErrListVO() {}

	public ArrNtcCustCodeErrListVO(String ibflag, String pagerows, String blNo, String custTpCd, String custTpCdNm, String errCd, String crtCd, String cdCreDt, String evlRstCd, String evlRstNm, String cdInputOfcCd, String cdInputUsrId, String cdInputDt, String evlOfcCd, String evlUsrId, String evlDt, String obEvCd, String ibEvCd, String hqEvCd, String crtCdCreDt, String bkgNo, String bkgCustTpCd, String usrId, String rowCount, String bkgOfcCd) {
		this.evlOfcCd = evlOfcCd;
		this.custTpCdNm = custTpCdNm;
		this.evlUsrId = evlUsrId;
		this.crtCdCreDt = crtCdCreDt;
		this.evlRstNm = evlRstNm;
		this.rowCount = rowCount;
		this.evlRstCd = evlRstCd;
		this.ibEvCd = ibEvCd;
		this.blNo = blNo;
		this.hqEvCd = hqEvCd;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.obEvCd = obEvCd;
		this.ibflag = ibflag;
		this.cdCreDt = cdCreDt;
		this.cdInputUsrId = cdInputUsrId;
		this.usrId = usrId;
		this.crtCd = crtCd;
		this.cdInputDt = cdInputDt;
		this.evlDt = evlDt;
		this.cdInputOfcCd = cdInputOfcCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custTpCd = custTpCd;
		this.errCd = errCd;
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("evl_ofc_cd", getEvlOfcCd());
		this.hashColumns.put("cust_tp_cd_nm", getCustTpCdNm());
		this.hashColumns.put("evl_usr_id", getEvlUsrId());
		this.hashColumns.put("crt_cd_cre_dt", getCrtCdCreDt());
		this.hashColumns.put("evl_rst_nm", getEvlRstNm());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("evl_rst_cd", getEvlRstCd());
		this.hashColumns.put("ib_ev_cd", getIbEvCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("hq_ev_cd", getHqEvCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ob_ev_cd", getObEvCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cd_cre_dt", getCdCreDt());
		this.hashColumns.put("cd_input_usr_id", getCdInputUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("crt_cd", getCrtCd());
		this.hashColumns.put("cd_input_dt", getCdInputDt());
		this.hashColumns.put("evl_dt", getEvlDt());
		this.hashColumns.put("cd_input_ofc_cd", getCdInputOfcCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("err_cd", getErrCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("evl_ofc_cd", "evlOfcCd");
		this.hashFields.put("cust_tp_cd_nm", "custTpCdNm");
		this.hashFields.put("evl_usr_id", "evlUsrId");
		this.hashFields.put("crt_cd_cre_dt", "crtCdCreDt");
		this.hashFields.put("evl_rst_nm", "evlRstNm");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("evl_rst_cd", "evlRstCd");
		this.hashFields.put("ib_ev_cd", "ibEvCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("hq_ev_cd", "hqEvCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ob_ev_cd", "obEvCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cd_cre_dt", "cdCreDt");
		this.hashFields.put("cd_input_usr_id", "cdInputUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("crt_cd", "crtCd");
		this.hashFields.put("cd_input_dt", "cdInputDt");
		this.hashFields.put("evl_dt", "evlDt");
		this.hashFields.put("cd_input_ofc_cd", "cdInputOfcCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("err_cd", "errCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return evlOfcCd
	 */
	public String getEvlOfcCd() {
		return this.evlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCdNm
	 */
	public String getCustTpCdNm() {
		return this.custTpCdNm;
	}
	
	/**
	 * Column Info
	 * @return evlUsrId
	 */
	public String getEvlUsrId() {
		return this.evlUsrId;
	}
	
	/**
	 * Column Info
	 * @return crtCdCreDt
	 */
	public String getCrtCdCreDt() {
		return this.crtCdCreDt;
	}
	
	/**
	 * Column Info
	 * @return evlRstNm
	 */
	public String getEvlRstNm() {
		return this.evlRstNm;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return evlRstCd
	 */
	public String getEvlRstCd() {
		return this.evlRstCd;
	}
	
	/**
	 * Column Info
	 * @return ibEvCd
	 */
	public String getIbEvCd() {
		return this.ibEvCd;
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
	 * @return hqEvCd
	 */
	public String getHqEvCd() {
		return this.hqEvCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return obEvCd
	 */
	public String getObEvCd() {
		return this.obEvCd;
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
	 * @return cdCreDt
	 */
	public String getCdCreDt() {
		return this.cdCreDt;
	}
	
	/**
	 * Column Info
	 * @return cdInputUsrId
	 */
	public String getCdInputUsrId() {
		return this.cdInputUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return crtCd
	 */
	public String getCrtCd() {
		return this.crtCd;
	}
	
	/**
	 * Column Info
	 * @return cdInputDt
	 */
	public String getCdInputDt() {
		return this.cdInputDt;
	}
	
	/**
	 * Column Info
	 * @return evlDt
	 */
	public String getEvlDt() {
		return this.evlDt;
	}
	
	/**
	 * Column Info
	 * @return cdInputOfcCd
	 */
	public String getCdInputOfcCd() {
		return this.cdInputOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return errCd
	 */
	public String getErrCd() {
		return this.errCd;
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
	 * @param evlOfcCd
	 */
	public void setEvlOfcCd(String evlOfcCd) {
		this.evlOfcCd = evlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCdNm
	 */
	public void setCustTpCdNm(String custTpCdNm) {
		this.custTpCdNm = custTpCdNm;
	}
	
	/**
	 * Column Info
	 * @param evlUsrId
	 */
	public void setEvlUsrId(String evlUsrId) {
		this.evlUsrId = evlUsrId;
	}
	
	/**
	 * Column Info
	 * @param crtCdCreDt
	 */
	public void setCrtCdCreDt(String crtCdCreDt) {
		this.crtCdCreDt = crtCdCreDt;
	}
	
	/**
	 * Column Info
	 * @param evlRstNm
	 */
	public void setEvlRstNm(String evlRstNm) {
		this.evlRstNm = evlRstNm;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param evlRstCd
	 */
	public void setEvlRstCd(String evlRstCd) {
		this.evlRstCd = evlRstCd;
	}
	
	/**
	 * Column Info
	 * @param ibEvCd
	 */
	public void setIbEvCd(String ibEvCd) {
		this.ibEvCd = ibEvCd;
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
	 * @param hqEvCd
	 */
	public void setHqEvCd(String hqEvCd) {
		this.hqEvCd = hqEvCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param obEvCd
	 */
	public void setObEvCd(String obEvCd) {
		this.obEvCd = obEvCd;
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
	 * @param cdCreDt
	 */
	public void setCdCreDt(String cdCreDt) {
		this.cdCreDt = cdCreDt;
	}
	
	/**
	 * Column Info
	 * @param cdInputUsrId
	 */
	public void setCdInputUsrId(String cdInputUsrId) {
		this.cdInputUsrId = cdInputUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param crtCd
	 */
	public void setCrtCd(String crtCd) {
		this.crtCd = crtCd;
	}
	
	/**
	 * Column Info
	 * @param cdInputDt
	 */
	public void setCdInputDt(String cdInputDt) {
		this.cdInputDt = cdInputDt;
	}
	
	/**
	 * Column Info
	 * @param evlDt
	 */
	public void setEvlDt(String evlDt) {
		this.evlDt = evlDt;
	}
	
	/**
	 * Column Info
	 * @param cdInputOfcCd
	 */
	public void setCdInputOfcCd(String cdInputOfcCd) {
		this.cdInputOfcCd = cdInputOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param errCd
	 */
	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
		setEvlOfcCd(JSPUtil.getParameter(request, prefix + "evl_ofc_cd", ""));
		setCustTpCdNm(JSPUtil.getParameter(request, prefix + "cust_tp_cd_nm", ""));
		setEvlUsrId(JSPUtil.getParameter(request, prefix + "evl_usr_id", ""));
		setCrtCdCreDt(JSPUtil.getParameter(request, prefix + "crt_cd_cre_dt", ""));
		setEvlRstNm(JSPUtil.getParameter(request, prefix + "evl_rst_nm", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setEvlRstCd(JSPUtil.getParameter(request, prefix + "evl_rst_cd", ""));
		setIbEvCd(JSPUtil.getParameter(request, prefix + "ib_ev_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setHqEvCd(JSPUtil.getParameter(request, prefix + "hq_ev_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setObEvCd(JSPUtil.getParameter(request, prefix + "ob_ev_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCdCreDt(JSPUtil.getParameter(request, prefix + "cd_cre_dt", ""));
		setCdInputUsrId(JSPUtil.getParameter(request, prefix + "cd_input_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCrtCd(JSPUtil.getParameter(request, prefix + "crt_cd", ""));
		setCdInputDt(JSPUtil.getParameter(request, prefix + "cd_input_dt", ""));
		setEvlDt(JSPUtil.getParameter(request, prefix + "evl_dt", ""));
		setCdInputOfcCd(JSPUtil.getParameter(request, prefix + "cd_input_ofc_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setErrCd(JSPUtil.getParameter(request, prefix + "err_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcCustCodeErrListVO[]
	 */
	public ArrNtcCustCodeErrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcCustCodeErrListVO[]
	 */
	public ArrNtcCustCodeErrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcCustCodeErrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] evlOfcCd = (JSPUtil.getParameter(request, prefix	+ "evl_ofc_cd", length));
			String[] custTpCdNm = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd_nm", length));
			String[] evlUsrId = (JSPUtil.getParameter(request, prefix	+ "evl_usr_id", length));
			String[] crtCdCreDt = (JSPUtil.getParameter(request, prefix	+ "crt_cd_cre_dt", length));
			String[] evlRstNm = (JSPUtil.getParameter(request, prefix	+ "evl_rst_nm", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] evlRstCd = (JSPUtil.getParameter(request, prefix	+ "evl_rst_cd", length));
			String[] ibEvCd = (JSPUtil.getParameter(request, prefix	+ "ib_ev_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] hqEvCd = (JSPUtil.getParameter(request, prefix	+ "hq_ev_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] obEvCd = (JSPUtil.getParameter(request, prefix	+ "ob_ev_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cdCreDt = (JSPUtil.getParameter(request, prefix	+ "cd_cre_dt", length));
			String[] cdInputUsrId = (JSPUtil.getParameter(request, prefix	+ "cd_input_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] crtCd = (JSPUtil.getParameter(request, prefix	+ "crt_cd", length));
			String[] cdInputDt = (JSPUtil.getParameter(request, prefix	+ "cd_input_dt", length));
			String[] evlDt = (JSPUtil.getParameter(request, prefix	+ "evl_dt", length));
			String[] cdInputOfcCd = (JSPUtil.getParameter(request, prefix	+ "cd_input_ofc_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] errCd = (JSPUtil.getParameter(request, prefix	+ "err_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcCustCodeErrListVO();
				if (evlOfcCd[i] != null)
					model.setEvlOfcCd(evlOfcCd[i]);
				if (custTpCdNm[i] != null)
					model.setCustTpCdNm(custTpCdNm[i]);
				if (evlUsrId[i] != null)
					model.setEvlUsrId(evlUsrId[i]);
				if (crtCdCreDt[i] != null)
					model.setCrtCdCreDt(crtCdCreDt[i]);
				if (evlRstNm[i] != null)
					model.setEvlRstNm(evlRstNm[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (evlRstCd[i] != null)
					model.setEvlRstCd(evlRstCd[i]);
				if (ibEvCd[i] != null)
					model.setIbEvCd(ibEvCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (hqEvCd[i] != null)
					model.setHqEvCd(hqEvCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (obEvCd[i] != null)
					model.setObEvCd(obEvCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cdCreDt[i] != null)
					model.setCdCreDt(cdCreDt[i]);
				if (cdInputUsrId[i] != null)
					model.setCdInputUsrId(cdInputUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (crtCd[i] != null)
					model.setCrtCd(crtCd[i]);
				if (cdInputDt[i] != null)
					model.setCdInputDt(cdInputDt[i]);
				if (evlDt[i] != null)
					model.setEvlDt(evlDt[i]);
				if (cdInputOfcCd[i] != null)
					model.setCdInputOfcCd(cdInputOfcCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (errCd[i] != null)
					model.setErrCd(errCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcCustCodeErrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcCustCodeErrListVO[]
	 */
	public ArrNtcCustCodeErrListVO[] getArrNtcCustCodeErrListVOs(){
		ArrNtcCustCodeErrListVO[] vos = (ArrNtcCustCodeErrListVO[])models.toArray(new ArrNtcCustCodeErrListVO[models.size()]);
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
		this.evlOfcCd = this.evlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCdNm = this.custTpCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlUsrId = this.evlUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtCdCreDt = this.crtCdCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRstNm = this.evlRstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlRstCd = this.evlRstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEvCd = this.ibEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hqEvCd = this.hqEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obEvCd = this.obEvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdCreDt = this.cdCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdInputUsrId = this.cdInputUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtCd = this.crtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdInputDt = this.cdInputDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evlDt = this.evlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdInputOfcCd = this.cdInputOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCd = this.errCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
