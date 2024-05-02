/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchActualDataListVO.java
*@FileTitle : SearchActualDataListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.05.15 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActualDataListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActualDataListVO> models = new ArrayList<SearchActualDataListVO>();
	
	/* Column Info */
	private String onTimeCk = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String stndEdiStsCd = null;
	/* Column Info */
	private String nonOnTime = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String actNm = null;
	/* Column Info */
	private String actTime = null;
	/* Column Info */
	private String actDate = null;
	/* Column Info */
	private String rcvTime = null;
	/* Column Info */
	private String plnTime = null;
	/* Column Info */
	private String actCd = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String actRcvTpNm = null;
	/* Column Info */
	private String ediMsgTpCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String plnDate = null;
	/* Column Info */
	private String onTime = null;
	/* Column Info */
	private String rcvDate = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String nodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActualDataListVO() {}

	public SearchActualDataListVO(String ibflag, String pagerows, String onTimeCk, String copNo, String stndEdiStsCd, String actStsMapgCd, String nonOnTime, String usrId, String actNm, String actTime, String actDate, String rcvTime, String plnTime, String actCd, String actRcvTpCd, String actRcvTpNm, String ediMsgTpCd, String plnDate, String onTime, String rcvDate, String bkgNo, String actDt, String vndrSeq, String cntrNo, String nodCd, String vvd) {
		this.onTimeCk = onTimeCk;
		this.copNo = copNo;
		this.stndEdiStsCd = stndEdiStsCd;
		this.nonOnTime = nonOnTime;
		this.actStsMapgCd = actStsMapgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.actNm = actNm;
		this.actTime = actTime;
		this.actDate = actDate;
		this.rcvTime = rcvTime;
		this.plnTime = plnTime;
		this.actCd = actCd;
		this.actRcvTpCd = actRcvTpCd;
		this.actRcvTpNm = actRcvTpNm;
		this.ediMsgTpCd = ediMsgTpCd;
		this.vvd = vvd;
		this.plnDate = plnDate;
		this.onTime = onTime;
		this.rcvDate = rcvDate;
		this.bkgNo = bkgNo;
		this.actDt = actDt;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.nodCd = nodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("on_time_ck", getOnTimeCk());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("stnd_edi_sts_cd", getStndEdiStsCd());
		this.hashColumns.put("non_on_time", getNonOnTime());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("act_nm", getActNm());
		this.hashColumns.put("act_time", getActTime());
		this.hashColumns.put("act_date", getActDate());
		this.hashColumns.put("rcv_time", getRcvTime());
		this.hashColumns.put("pln_time", getPlnTime());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("act_rcv_tp_nm", getActRcvTpNm());
		this.hashColumns.put("edi_msg_tp_cd", getEdiMsgTpCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pln_date", getPlnDate());
		this.hashColumns.put("on_time", getOnTime());
		this.hashColumns.put("rcv_date", getRcvDate());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("nod_cd", getNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("on_time_ck", "onTimeCk");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("stnd_edi_sts_cd", "stndEdiStsCd");
		this.hashFields.put("non_on_time", "nonOnTime");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("act_nm", "actNm");
		this.hashFields.put("act_time", "actTime");
		this.hashFields.put("act_date", "actDate");
		this.hashFields.put("rcv_time", "rcvTime");
		this.hashFields.put("pln_time", "plnTime");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("act_rcv_tp_nm", "actRcvTpNm");
		this.hashFields.put("edi_msg_tp_cd", "ediMsgTpCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pln_date", "plnDate");
		this.hashFields.put("on_time", "onTime");
		this.hashFields.put("rcv_date", "rcvDate");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("nod_cd", "nodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return onTimeCk
	 */
	public String getOnTimeCk() {
		return this.onTimeCk;
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
	 * @return stndEdiStsCd
	 */
	public String getStndEdiStsCd() {
		return this.stndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return nonOnTime
	 */
	public String getNonOnTime() {
		return this.nonOnTime;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return actNm
	 */
	public String getActNm() {
		return this.actNm;
	}
	
	/**
	 * Column Info
	 * @return actTime
	 */
	public String getActTime() {
		return this.actTime;
	}
	
	/**
	 * Column Info
	 * @return actDate
	 */
	public String getActDate() {
		return this.actDate;
	}
	
	/**
	 * Column Info
	 * @return rcvTime
	 */
	public String getRcvTime() {
		return this.rcvTime;
	}
	
	/**
	 * Column Info
	 * @return plnTime
	 */
	public String getPlnTime() {
		return this.plnTime;
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
	 * @return actRcvTpNm
	 */
	public String getActRcvTpNm() {
		return this.actRcvTpNm;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return plnDate
	 */
	public String getPlnDate() {
		return this.plnDate;
	}
	
	/**
	 * Column Info
	 * @return onTime
	 */
	public String getOnTime() {
		return this.onTime;
	}
	
	/**
	 * Column Info
	 * @return rcvDate
	 */
	public String getRcvDate() {
		return this.rcvDate;
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
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
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
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	

	/**
	 * Column Info
	 * @param onTimeCk
	 */
	public void setOnTimeCk(String onTimeCk) {
		this.onTimeCk = onTimeCk;
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
	 * @param stndEdiStsCd
	 */
	public void setStndEdiStsCd(String stndEdiStsCd) {
		this.stndEdiStsCd = stndEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param nonOnTime
	 */
	public void setNonOnTime(String nonOnTime) {
		this.nonOnTime = nonOnTime;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param actNm
	 */
	public void setActNm(String actNm) {
		this.actNm = actNm;
	}
	
	/**
	 * Column Info
	 * @param actTime
	 */
	public void setActTime(String actTime) {
		this.actTime = actTime;
	}
	
	/**
	 * Column Info
	 * @param actDate
	 */
	public void setActDate(String actDate) {
		this.actDate = actDate;
	}
	
	/**
	 * Column Info
	 * @param rcvTime
	 */
	public void setRcvTime(String rcvTime) {
		this.rcvTime = rcvTime;
	}
	
	/**
	 * Column Info
	 * @param plnTime
	 */
	public void setPlnTime(String plnTime) {
		this.plnTime = plnTime;
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
	 * @param actRcvTpNm
	 */
	public void setActRcvTpNm(String actRcvTpNm) {
		this.actRcvTpNm = actRcvTpNm;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param plnDate
	 */
	public void setPlnDate(String plnDate) {
		this.plnDate = plnDate;
	}
	
	/**
	 * Column Info
	 * @param onTime
	 */
	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}
	
	/**
	 * Column Info
	 * @param rcvDate
	 */
	public void setRcvDate(String rcvDate) {
		this.rcvDate = rcvDate;
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
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
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
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
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
		setOnTimeCk(JSPUtil.getParameter(request, prefix + "on_time_ck", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setStndEdiStsCd(JSPUtil.getParameter(request, prefix + "stnd_edi_sts_cd", ""));
		setNonOnTime(JSPUtil.getParameter(request, prefix + "non_on_time", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setActNm(JSPUtil.getParameter(request, prefix + "act_nm", ""));
		setActTime(JSPUtil.getParameter(request, prefix + "act_time", ""));
		setActDate(JSPUtil.getParameter(request, prefix + "act_date", ""));
		setRcvTime(JSPUtil.getParameter(request, prefix + "rcv_time", ""));
		setPlnTime(JSPUtil.getParameter(request, prefix + "pln_time", ""));
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, prefix + "act_rcv_tp_cd", ""));
		setActRcvTpNm(JSPUtil.getParameter(request, prefix + "act_rcv_tp_nm", ""));
		setEdiMsgTpCd(JSPUtil.getParameter(request, prefix + "edi_msg_tp_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPlnDate(JSPUtil.getParameter(request, prefix + "pln_date", ""));
		setOnTime(JSPUtil.getParameter(request, prefix + "on_time", ""));
		setRcvDate(JSPUtil.getParameter(request, prefix + "rcv_date", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActualDataListVO[]
	 */
	public SearchActualDataListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActualDataListVO[]
	 */
	public SearchActualDataListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActualDataListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] onTimeCk = (JSPUtil.getParameter(request, prefix	+ "on_time_ck", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] stndEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "stnd_edi_sts_cd", length));
			String[] nonOnTime = (JSPUtil.getParameter(request, prefix	+ "non_on_time", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_mapg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] actNm = (JSPUtil.getParameter(request, prefix	+ "act_nm", length));
			String[] actTime = (JSPUtil.getParameter(request, prefix	+ "act_time", length));
			String[] actDate = (JSPUtil.getParameter(request, prefix	+ "act_date", length));
			String[] rcvTime = (JSPUtil.getParameter(request, prefix	+ "rcv_time", length));
			String[] plnTime = (JSPUtil.getParameter(request, prefix	+ "pln_time", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] actRcvTpNm = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_nm", length));
			String[] ediMsgTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] plnDate = (JSPUtil.getParameter(request, prefix	+ "pln_date", length));
			String[] onTime = (JSPUtil.getParameter(request, prefix	+ "on_time", length));
			String[] rcvDate = (JSPUtil.getParameter(request, prefix	+ "rcv_date", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActualDataListVO();
				if (onTimeCk[i] != null)
					model.setOnTimeCk(onTimeCk[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (stndEdiStsCd[i] != null)
					model.setStndEdiStsCd(stndEdiStsCd[i]);
				if (nonOnTime[i] != null)
					model.setNonOnTime(nonOnTime[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (actNm[i] != null)
					model.setActNm(actNm[i]);
				if (actTime[i] != null)
					model.setActTime(actTime[i]);
				if (actDate[i] != null)
					model.setActDate(actDate[i]);
				if (rcvTime[i] != null)
					model.setRcvTime(rcvTime[i]);
				if (plnTime[i] != null)
					model.setPlnTime(plnTime[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (actRcvTpNm[i] != null)
					model.setActRcvTpNm(actRcvTpNm[i]);
				if (ediMsgTpCd[i] != null)
					model.setEdiMsgTpCd(ediMsgTpCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (plnDate[i] != null)
					model.setPlnDate(plnDate[i]);
				if (onTime[i] != null)
					model.setOnTime(onTime[i]);
				if (rcvDate[i] != null)
					model.setRcvDate(rcvDate[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActualDataListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActualDataListVO[]
	 */
	public SearchActualDataListVO[] getSearchActualDataListVOs(){
		SearchActualDataListVO[] vos = (SearchActualDataListVO[])models.toArray(new SearchActualDataListVO[models.size()]);
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
		this.onTimeCk = this.onTimeCk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndEdiStsCd = this.stndEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonOnTime = this.nonOnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actNm = this.actNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actTime = this.actTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDate = this.actDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTime = this.rcvTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnTime = this.plnTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpNm = this.actRcvTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpCd = this.ediMsgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnDate = this.plnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTime = this.onTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDate = this.rcvDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
