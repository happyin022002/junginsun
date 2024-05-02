/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CHSMvmtMGTVO.java
*@FileTitle : CHSMvmtMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.27 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSMvmtMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSMvmtMGTVO> models = new ArrayList<MGSMvmtMGTVO>();
	
	/* Column Info */
	private String cntrOwnrCoCd = null;
	/* Column Info */
	private String booking = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mgSetNo = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String conignee = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chssMvmtDt = null;
	/* Column Info */
	private String conignee1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String days = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String ttlKnt = null;
	/* Column Info */
	private String consigne = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSMvmtMGTVO() {}

	public MGSMvmtMGTVO(String ibflag, String pagerows, String ttlKnt, String cntrOwnrCoCd, String booking, String custNm, String chssNo, String mgSetNo, String crntYdCd, String agmtLstmCd, String aciacDivCd, String conignee, String blNo, String eqTpszCd, String chssMvmtDt, String conignee1, String eqNo, String days, String vndrSeq, String chssMvmtStsCd, String vndrAbbrNm, String consigne, String updUsrId, String cntrNo) {
		this.cntrOwnrCoCd = cntrOwnrCoCd;
		this.booking = booking;
		this.custNm = custNm;
		this.chssNo = chssNo;
		this.mgSetNo = mgSetNo;
		this.crntYdCd = crntYdCd;
		this.agmtLstmCd = agmtLstmCd;
		this.aciacDivCd = aciacDivCd;
		this.conignee = conignee;
		this.blNo = blNo;
		this.eqTpszCd = eqTpszCd;
		this.pagerows = pagerows;
		this.chssMvmtDt = chssMvmtDt;
		this.conignee1 = conignee1;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.days = days;
		this.vndrSeq = vndrSeq;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.vndrAbbrNm = vndrAbbrNm;
		this.ttlKnt = ttlKnt;
		this.consigne = consigne;
		this.updUsrId = updUsrId;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_ownr_co_cd", getCntrOwnrCoCd());
		this.hashColumns.put("booking", getBooking());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mg_set_no", getMgSetNo());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("conignee", getConignee());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chss_mvmt_dt", getChssMvmtDt());
		this.hashColumns.put("conignee1", getConignee1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("days", getDays());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("ttl_knt", getTtlKnt());
		this.hashColumns.put("consigne", getConsigne());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_ownr_co_cd", "cntrOwnrCoCd");
		this.hashFields.put("booking", "booking");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mg_set_no", "mgSetNo");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("conignee", "conignee");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chss_mvmt_dt", "chssMvmtDt");
		this.hashFields.put("conignee1", "conignee1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("days", "days");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("ttl_knt", "ttlKnt");
		this.hashFields.put("consigne", "consigne");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrOwnrCoCd
	 */
	public String getCntrOwnrCoCd() {
		return this.cntrOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @return booking
	 */
	public String getBooking() {
		return this.booking;
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
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return mgSetNo
	 */
	public String getMgSetNo() {
		return this.mgSetNo;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return conignee
	 */
	public String getConignee() {
		return this.conignee;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return chssMvmtDt
	 */
	public String getChssMvmtDt() {
		return this.chssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @return conignee1
	 */
	public String getConignee1() {
		return this.conignee1;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return days
	 */
	public String getDays() {
		return this.days;
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
	 * @return chssMvmtStsCd
	 */
	public String getChssMvmtStsCd() {
		return this.chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return ttlKnt
	 */
	public String getTtlKnt() {
		return this.ttlKnt;
	}
	
	/**
	 * Column Info
	 * @return consigne
	 */
	public String getConsigne() {
		return this.consigne;
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
	 * @param cntrOwnrCoCd
	 */
	public void setCntrOwnrCoCd(String cntrOwnrCoCd) {
		this.cntrOwnrCoCd = cntrOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @param booking
	 */
	public void setBooking(String booking) {
		this.booking = booking;
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
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param mgSetNo
	 */
	public void setMgSetNo(String mgSetNo) {
		this.mgSetNo = mgSetNo;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param conignee
	 */
	public void setConignee(String conignee) {
		this.conignee = conignee;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param chssMvmtDt
	 */
	public void setChssMvmtDt(String chssMvmtDt) {
		this.chssMvmtDt = chssMvmtDt;
	}
	
	/**
	 * Column Info
	 * @param conignee1
	 */
	public void setConignee1(String conignee1) {
		this.conignee1 = conignee1;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param days
	 */
	public void setDays(String days) {
		this.days = days;
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
	 * @param chssMvmtStsCd
	 */
	public void setChssMvmtStsCd(String chssMvmtStsCd) {
		this.chssMvmtStsCd = chssMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param ttlKnt
	 */
	public void setTtlKnt(String ttlKnt) {
		this.ttlKnt = ttlKnt;
	}
	
	/**
	 * Column Info
	 * @param consigne
	 */
	public void setConsigne(String consigne) {
		this.consigne = consigne;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setCntrOwnrCoCd(JSPUtil.getParameter(request, prefix + "cntr_ownr_co_cd", ""));
		setBooking(JSPUtil.getParameter(request, prefix + "booking", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setMgSetNo(JSPUtil.getParameter(request, prefix + "mg_set_no", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, prefix + "agmt_lstm_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setConignee(JSPUtil.getParameter(request, prefix + "conignee", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChssMvmtDt(JSPUtil.getParameter(request, prefix + "chss_mvmt_dt", ""));
		setConignee1(JSPUtil.getParameter(request, prefix + "conignee1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setDays(JSPUtil.getParameter(request, prefix + "days", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, prefix + "chss_mvmt_sts_cd", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setTtlKnt(JSPUtil.getParameter(request, prefix + "ttl_knt", ""));
		setConsigne(JSPUtil.getParameter(request, prefix + "consigne", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSMvmtMGTVO[]
	 */
	public MGSMvmtMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSMvmtMGTVO[]
	 */
	public MGSMvmtMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSMvmtMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_ownr_co_cd", length));
			String[] booking = (JSPUtil.getParameter(request, prefix	+ "booking", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mgSetNo = (JSPUtil.getParameter(request, prefix	+ "mg_set_no", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] conignee = (JSPUtil.getParameter(request, prefix	+ "conignee", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chssMvmtDt = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_dt", length));
			String[] conignee1 = (JSPUtil.getParameter(request, prefix	+ "conignee1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] days = (JSPUtil.getParameter(request, prefix	+ "days", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] ttlKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_knt", length));
			String[] consigne = (JSPUtil.getParameter(request, prefix	+ "consigne", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSMvmtMGTVO();
				if (cntrOwnrCoCd[i] != null)
					model.setCntrOwnrCoCd(cntrOwnrCoCd[i]);
				if (booking[i] != null)
					model.setBooking(booking[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mgSetNo[i] != null)
					model.setMgSetNo(mgSetNo[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (conignee[i] != null)
					model.setConignee(conignee[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chssMvmtDt[i] != null)
					model.setChssMvmtDt(chssMvmtDt[i]);
				if (conignee1[i] != null)
					model.setConignee1(conignee1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (days[i] != null)
					model.setDays(days[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (ttlKnt[i] != null)
					model.setTtlKnt(ttlKnt[i]);
				if (consigne[i] != null)
					model.setConsigne(consigne[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSMvmtMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSMvmtMGTVO[]
	 */
	public MGSMvmtMGTVO[] getCHSMvmtMGTVOs(){
		MGSMvmtMGTVO[] vos = (MGSMvmtMGTVO[])models.toArray(new MGSMvmtMGTVO[models.size()]);
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
		this.cntrOwnrCoCd = this.cntrOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.booking = this.booking .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgSetNo = this.mgSetNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conignee = this.conignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtDt = this.chssMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conignee1 = this.conignee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.days = this.days .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlKnt = this.ttlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigne = this.consigne .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
