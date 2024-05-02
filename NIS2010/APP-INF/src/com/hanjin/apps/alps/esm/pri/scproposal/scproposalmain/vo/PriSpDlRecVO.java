/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PriSpDlRecVO.java
*@FileTitle : PriSpDlRecVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSpDlRecVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpDlRecVO> models = new ArrayList<PriSpDlRecVO>();
	
	/* Column Info */
	private String sCurTpCd = null;
	/* Column Info */
	private String scrnDateFrom = null;
	/* Column Info */
	private String effDateFrom = null;
	/* Column Info */
	private String ipAddr = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String openTime = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String lginId = null;
	/* Column Info */
	private String effDateTo = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String lginOfc = null;
	/* Column Info */
	private String realCustNm = null;
	/* Column Info */
	private String sScrnProgCd = null;
	/* Column Info */
	private String closeTime = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String saveTime = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String dlScrn = null;
	/* Column Info */
	private String scrnDateTo = null;
	/* Column Info */
	private String sCustTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriSpDlRecVO() {}

	public PriSpDlRecVO(String ibflag, String pagerows, String scNo, String propNo, String amdtSeq, String custNm, String realCustNm, String custTpCd, String status, String fileDt, String lginId, String usrNm, String lginOfc, String srepCd, String ipAddr, String dlScrn, String openTime, String saveTime, String closeTime, String scrnDateFrom, String scrnDateTo, String effDateFrom, String effDateTo, String propOfcCd, String sCurTpCd, String sCustTpCd, String sScrnProgCd) {
		this.sCurTpCd = sCurTpCd;
		this.scrnDateFrom = scrnDateFrom;
		this.effDateFrom = effDateFrom;
		this.ipAddr = ipAddr;
		this.custNm = custNm;
		this.amdtSeq = amdtSeq;
		this.openTime = openTime;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.scNo = scNo;
		this.custTpCd = custTpCd;
		this.lginId = lginId;
		this.effDateTo = effDateTo;
		this.fileDt = fileDt;
		this.status = status;
		this.lginOfc = lginOfc;
		this.realCustNm = realCustNm;
		this.sScrnProgCd = sScrnProgCd;
		this.closeTime = closeTime;
		this.propOfcCd = propOfcCd;
		this.saveTime = saveTime;
		this.propNo = propNo;
		this.dlScrn = dlScrn;
		this.scrnDateTo = scrnDateTo;
		this.sCustTpCd = sCustTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_cur_tp_cd", getSCurTpCd());
		this.hashColumns.put("scrn_date_from", getScrnDateFrom());
		this.hashColumns.put("eff_date_from", getEffDateFrom());
		this.hashColumns.put("ip_addr", getIpAddr());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("open_time", getOpenTime());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("lgin_id", getLginId());
		this.hashColumns.put("eff_date_to", getEffDateTo());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("lgin_ofc", getLginOfc());
		this.hashColumns.put("real_cust_nm", getRealCustNm());
		this.hashColumns.put("s_scrn_prog_cd", getSScrnProgCd());
		this.hashColumns.put("close_time", getCloseTime());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("save_time", getSaveTime());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("dl_scrn", getDlScrn());
		this.hashColumns.put("scrn_date_to", getScrnDateTo());
		this.hashColumns.put("s_cust_tp_cd", getSCustTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_cur_tp_cd", "sCurTpCd");
		this.hashFields.put("scrn_date_from", "scrnDateFrom");
		this.hashFields.put("eff_date_from", "effDateFrom");
		this.hashFields.put("ip_addr", "ipAddr");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("open_time", "openTime");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("lgin_id", "lginId");
		this.hashFields.put("eff_date_to", "effDateTo");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("status", "status");
		this.hashFields.put("lgin_ofc", "lginOfc");
		this.hashFields.put("real_cust_nm", "realCustNm");
		this.hashFields.put("s_scrn_prog_cd", "sScrnProgCd");
		this.hashFields.put("close_time", "closeTime");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("save_time", "saveTime");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("dl_scrn", "dlScrn");
		this.hashFields.put("scrn_date_to", "scrnDateTo");
		this.hashFields.put("s_cust_tp_cd", "sCustTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sCurTpCd
	 */
	public String getSCurTpCd() {
		return this.sCurTpCd;
	}
	
	/**
	 * Column Info
	 * @return scrnDateFrom
	 */
	public String getScrnDateFrom() {
		return this.scrnDateFrom;
	}
	
	/**
	 * Column Info
	 * @return effDateFrom
	 */
	public String getEffDateFrom() {
		return this.effDateFrom;
	}
	
	/**
	 * Column Info
	 * @return ipAddr
	 */
	public String getIpAddr() {
		return this.ipAddr;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @return openTime
	 */
	public String getOpenTime() {
		return this.openTime;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return lginId
	 */
	public String getLginId() {
		return this.lginId;
	}
	
	/**
	 * Column Info
	 * @return effDateTo
	 */
	public String getEffDateTo() {
		return this.effDateTo;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return lginOfc
	 */
	public String getLginOfc() {
		return this.lginOfc;
	}
	
	/**
	 * Column Info
	 * @return realCustNm
	 */
	public String getRealCustNm() {
		return this.realCustNm;
	}
	
	/**
	 * Column Info
	 * @return sScrnProgCd
	 */
	public String getSScrnProgCd() {
		return this.sScrnProgCd;
	}
	
	/**
	 * Column Info
	 * @return closeTime
	 */
	public String getCloseTime() {
		return this.closeTime;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return saveTime
	 */
	public String getSaveTime() {
		return this.saveTime;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return dlScrn
	 */
	public String getDlScrn() {
		return this.dlScrn;
	}
	
	/**
	 * Column Info
	 * @return scrnDateTo
	 */
	public String getScrnDateTo() {
		return this.scrnDateTo;
	}
	
	/**
	 * Column Info
	 * @return sCustTpCd
	 */
	public String getSCustTpCd() {
		return this.sCustTpCd;
	}
	

	/**
	 * Column Info
	 * @param sCurTpCd
	 */
	public void setSCurTpCd(String sCurTpCd) {
		this.sCurTpCd = sCurTpCd;
	}
	
	/**
	 * Column Info
	 * @param scrnDateFrom
	 */
	public void setScrnDateFrom(String scrnDateFrom) {
		this.scrnDateFrom = scrnDateFrom;
	}
	
	/**
	 * Column Info
	 * @param effDateFrom
	 */
	public void setEffDateFrom(String effDateFrom) {
		this.effDateFrom = effDateFrom;
	}
	
	/**
	 * Column Info
	 * @param ipAddr
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
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
	 * @param openTime
	 */
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
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
	 * @param lginId
	 */
	public void setLginId(String lginId) {
		this.lginId = lginId;
	}
	
	/**
	 * Column Info
	 * @param effDateTo
	 */
	public void setEffDateTo(String effDateTo) {
		this.effDateTo = effDateTo;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param lginOfc
	 */
	public void setLginOfc(String lginOfc) {
		this.lginOfc = lginOfc;
	}
	
	/**
	 * Column Info
	 * @param realCustNm
	 */
	public void setRealCustNm(String realCustNm) {
		this.realCustNm = realCustNm;
	}
	
	/**
	 * Column Info
	 * @param sScrnProgCd
	 */
	public void setSScrnProgCd(String sScrnProgCd) {
		this.sScrnProgCd = sScrnProgCd;
	}
	
	/**
	 * Column Info
	 * @param closeTime
	 */
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param saveTime
	 */
	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param dlScrn
	 */
	public void setDlScrn(String dlScrn) {
		this.dlScrn = dlScrn;
	}
	
	/**
	 * Column Info
	 * @param scrnDateTo
	 */
	public void setScrnDateTo(String scrnDateTo) {
		this.scrnDateTo = scrnDateTo;
	}
	
	/**
	 * Column Info
	 * @param sCustTpCd
	 */
	public void setSCustTpCd(String sCustTpCd) {
		this.sCustTpCd = sCustTpCd;
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
		setSCurTpCd(JSPUtil.getParameter(request, prefix + "s_cur_tp_cd", ""));
		setScrnDateFrom(JSPUtil.getParameter(request, prefix + "scrn_date_from", ""));
		setEffDateFrom(JSPUtil.getParameter(request, prefix + "eff_date_from", ""));
		setIpAddr(JSPUtil.getParameter(request, prefix + "ip_addr", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setOpenTime(JSPUtil.getParameter(request, prefix + "open_time", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setLginId(JSPUtil.getParameter(request, prefix + "lgin_id", ""));
		setEffDateTo(JSPUtil.getParameter(request, prefix + "eff_date_to", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setLginOfc(JSPUtil.getParameter(request, prefix + "lgin_ofc", ""));
		setRealCustNm(JSPUtil.getParameter(request, prefix + "real_cust_nm", ""));
		setSScrnProgCd(JSPUtil.getParameter(request, prefix + "s_scrn_prog_cd", ""));
		setCloseTime(JSPUtil.getParameter(request, prefix + "close_time", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setSaveTime(JSPUtil.getParameter(request, prefix + "save_time", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setDlScrn(JSPUtil.getParameter(request, prefix + "dl_scrn", ""));
		setScrnDateTo(JSPUtil.getParameter(request, prefix + "scrn_date_to", ""));
		setSCustTpCd(JSPUtil.getParameter(request, prefix + "s_cust_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSpDlRecVO[]
	 */
	public PriSpDlRecVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSpDlRecVO[]
	 */
	public PriSpDlRecVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpDlRecVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sCurTpCd = (JSPUtil.getParameter(request, prefix	+ "s_cur_tp_cd", length));
			String[] scrnDateFrom = (JSPUtil.getParameter(request, prefix	+ "scrn_date_from", length));
			String[] effDateFrom = (JSPUtil.getParameter(request, prefix	+ "eff_date_from", length));
			String[] ipAddr = (JSPUtil.getParameter(request, prefix	+ "ip_addr", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] openTime = (JSPUtil.getParameter(request, prefix	+ "open_time", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] lginId = (JSPUtil.getParameter(request, prefix	+ "lgin_id", length));
			String[] effDateTo = (JSPUtil.getParameter(request, prefix	+ "eff_date_to", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] lginOfc = (JSPUtil.getParameter(request, prefix	+ "lgin_ofc", length));
			String[] realCustNm = (JSPUtil.getParameter(request, prefix	+ "real_cust_nm", length));
			String[] sScrnProgCd = (JSPUtil.getParameter(request, prefix	+ "s_scrn_prog_cd", length));
			String[] closeTime = (JSPUtil.getParameter(request, prefix	+ "close_time", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] saveTime = (JSPUtil.getParameter(request, prefix	+ "save_time", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] dlScrn = (JSPUtil.getParameter(request, prefix	+ "dl_scrn", length));
			String[] scrnDateTo = (JSPUtil.getParameter(request, prefix	+ "scrn_date_to", length));
			String[] sCustTpCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpDlRecVO();
				if (sCurTpCd[i] != null)
					model.setSCurTpCd(sCurTpCd[i]);
				if (scrnDateFrom[i] != null)
					model.setScrnDateFrom(scrnDateFrom[i]);
				if (effDateFrom[i] != null)
					model.setEffDateFrom(effDateFrom[i]);
				if (ipAddr[i] != null)
					model.setIpAddr(ipAddr[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (openTime[i] != null)
					model.setOpenTime(openTime[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (lginId[i] != null)
					model.setLginId(lginId[i]);
				if (effDateTo[i] != null)
					model.setEffDateTo(effDateTo[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (lginOfc[i] != null)
					model.setLginOfc(lginOfc[i]);
				if (realCustNm[i] != null)
					model.setRealCustNm(realCustNm[i]);
				if (sScrnProgCd[i] != null)
					model.setSScrnProgCd(sScrnProgCd[i]);
				if (closeTime[i] != null)
					model.setCloseTime(closeTime[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (saveTime[i] != null)
					model.setSaveTime(saveTime[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (dlScrn[i] != null)
					model.setDlScrn(dlScrn[i]);
				if (scrnDateTo[i] != null)
					model.setScrnDateTo(scrnDateTo[i]);
				if (sCustTpCd[i] != null)
					model.setSCustTpCd(sCustTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpDlRecVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpDlRecVO[]
	 */
	public PriSpDlRecVO[] getPriSpDlRecVOs(){
		PriSpDlRecVO[] vos = (PriSpDlRecVO[])models.toArray(new PriSpDlRecVO[models.size()]);
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
		this.sCurTpCd = this.sCurTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrnDateFrom = this.scrnDateFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDateFrom = this.effDateFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipAddr = this.ipAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.openTime = this.openTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginId = this.lginId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDateTo = this.effDateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginOfc = this.lginOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustNm = this.realCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sScrnProgCd = this.sScrnProgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closeTime = this.closeTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveTime = this.saveTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dlScrn = this.dlScrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrnDateTo = this.scrnDateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustTpCd = this.sCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
