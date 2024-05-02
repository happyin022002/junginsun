/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSFoundLostMGTVO.java
*@FileTitle : CHSFoundLostMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.19 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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

public class CHSFoundLostMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSFoundLostMGTVO> models = new ArrayList<CHSFoundLostMGTVO>();
	
	/* Column Info */
	private String lEvntDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fEvntYdCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String fEvntDtHm = null;
	/* Column Info */
	private String eqAsetStsCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String chssMvmtStsCd = null;
	/* Column Info */
	private String lEvntDtHm = null;
	/* Column Info */
	private String prestatus = null;
	/* Column Info */
	private String lEvntYdCd = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String stsEvntDt = null;
	/* Column Info */
	private String fEvntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSFoundLostMGTVO() {}

	public CHSFoundLostMGTVO(String ibflag, String pagerows, String lEvntDt, String vndrLglEngNm, String agmtLstmCd, String aciacDivCd, String fEvntDtHm, String eqTpszCd, String ofcCd, String fEvntYdCd, String lEvntDtHm, String eqNo, String eqAsetStsCd, String vndrSeq, String userId, String chssMvmtStsCd, String lEvntYdCd, String prestatus, String fEvntDt, String stsEvntDt, String mvmtDt) {
		this.lEvntDt = lEvntDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.agmtLstmCd = agmtLstmCd;
		this.aciacDivCd = aciacDivCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.fEvntYdCd = fEvntYdCd;
		this.eqNo = eqNo;
		this.fEvntDtHm = fEvntDtHm;
		this.eqAsetStsCd = eqAsetStsCd;
		this.vndrSeq = vndrSeq;
		this.userId = userId;
		this.chssMvmtStsCd = chssMvmtStsCd;
		this.lEvntDtHm = lEvntDtHm;
		this.prestatus = prestatus;
		this.lEvntYdCd = lEvntYdCd;
		this.mvmtDt = mvmtDt;
		this.stsEvntDt = stsEvntDt;
		this.fEvntDt = fEvntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("l_evnt_dt", getLEvntDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_evnt_yd_cd", getFEvntYdCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("f_evnt_dt_hm", getFEvntDtHm());
		this.hashColumns.put("eq_aset_sts_cd", getEqAsetStsCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("chss_mvmt_sts_cd", getChssMvmtStsCd());
		this.hashColumns.put("l_evnt_dt_hm", getLEvntDtHm());
		this.hashColumns.put("prestatus", getPrestatus());
		this.hashColumns.put("l_evnt_yd_cd", getLEvntYdCd());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("sts_evnt_dt", getStsEvntDt());
		this.hashColumns.put("f_evnt_dt", getFEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("l_evnt_dt", "lEvntDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_evnt_yd_cd", "fEvntYdCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("f_evnt_dt_hm", "fEvntDtHm");
		this.hashFields.put("eq_aset_sts_cd", "eqAsetStsCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("chss_mvmt_sts_cd", "chssMvmtStsCd");
		this.hashFields.put("l_evnt_dt_hm", "lEvntDtHm");
		this.hashFields.put("prestatus", "prestatus");
		this.hashFields.put("l_evnt_yd_cd", "lEvntYdCd");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("sts_evnt_dt", "stsEvntDt");
		this.hashFields.put("f_evnt_dt", "fEvntDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lEvntDt
	 */
	public String getLEvntDt() {
		return this.lEvntDt;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return fEvntYdCd
	 */
	public String getFEvntYdCd() {
		return this.fEvntYdCd;
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
	 * @return fEvntDtHm
	 */
	public String getFEvntDtHm() {
		return this.fEvntDtHm;
	}
	
	/**
	 * Column Info
	 * @return eqAsetStsCd
	 */
	public String getEqAsetStsCd() {
		return this.eqAsetStsCd;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return lEvntDtHm
	 */
	public String getLEvntDtHm() {
		return this.lEvntDtHm;
	}
	
	/**
	 * Column Info
	 * @return prestatus
	 */
	public String getPrestatus() {
		return this.prestatus;
	}
	
	/**
	 * Column Info
	 * @return lEvntYdCd
	 */
	public String getLEvntYdCd() {
		return this.lEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	
	/**
	 * Column Info
	 * @return stsEvntDt
	 */
	public String getStsEvntDt() {
		return this.stsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return fEvntDt
	 */
	public String getFEvntDt() {
		return this.fEvntDt;
	}
	

	/**
	 * Column Info
	 * @param lEvntDt
	 */
	public void setLEvntDt(String lEvntDt) {
		this.lEvntDt = lEvntDt;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param fEvntYdCd
	 */
	public void setFEvntYdCd(String fEvntYdCd) {
		this.fEvntYdCd = fEvntYdCd;
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
	 * @param fEvntDtHm
	 */
	public void setFEvntDtHm(String fEvntDtHm) {
		this.fEvntDtHm = fEvntDtHm;
	}
	
	/**
	 * Column Info
	 * @param eqAsetStsCd
	 */
	public void setEqAsetStsCd(String eqAsetStsCd) {
		this.eqAsetStsCd = eqAsetStsCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param lEvntDtHm
	 */
	public void setLEvntDtHm(String lEvntDtHm) {
		this.lEvntDtHm = lEvntDtHm;
	}
	
	/**
	 * Column Info
	 * @param prestatus
	 */
	public void setPrestatus(String prestatus) {
		this.prestatus = prestatus;
	}
	
	/**
	 * Column Info
	 * @param lEvntYdCd
	 */
	public void setLEvntYdCd(String lEvntYdCd) {
		this.lEvntYdCd = lEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Column Info
	 * @param stsEvntDt
	 */
	public void setStsEvntDt(String stsEvntDt) {
		this.stsEvntDt = stsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param fEvntDt
	 */
	public void setFEvntDt(String fEvntDt) {
		this.fEvntDt = fEvntDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLEvntDt(JSPUtil.getParameter(request, "l_evnt_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFEvntYdCd(JSPUtil.getParameter(request, "f_evnt_yd_cd", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setFEvntDtHm(JSPUtil.getParameter(request, "f_evnt_dt_hm", ""));
		setEqAsetStsCd(JSPUtil.getParameter(request, "eq_aset_sts_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setChssMvmtStsCd(JSPUtil.getParameter(request, "chss_mvmt_sts_cd", ""));
		setLEvntDtHm(JSPUtil.getParameter(request, "l_evnt_dt_hm", ""));
		setPrestatus(JSPUtil.getParameter(request, "prestatus", ""));
		setLEvntYdCd(JSPUtil.getParameter(request, "l_evnt_yd_cd", ""));
		setMvmtDt(JSPUtil.getParameter(request, "mvmt_dt", ""));
		setStsEvntDt(JSPUtil.getParameter(request, "sts_evnt_dt", ""));
		setFEvntDt(JSPUtil.getParameter(request, "f_evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSFoundLostMGTVO[]
	 */
	public CHSFoundLostMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSFoundLostMGTVO[]
	 */
	public CHSFoundLostMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSFoundLostMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lEvntDt = (JSPUtil.getParameter(request, prefix	+ "l_evnt_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "f_evnt_yd_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] fEvntDtHm = (JSPUtil.getParameter(request, prefix	+ "f_evnt_dt_hm", length));
			String[] eqAsetStsCd = (JSPUtil.getParameter(request, prefix	+ "eq_aset_sts_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] chssMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "chss_mvmt_sts_cd", length));
			String[] lEvntDtHm = (JSPUtil.getParameter(request, prefix	+ "l_evnt_dt_hm", length));
			String[] prestatus = (JSPUtil.getParameter(request, prefix	+ "prestatus", length));
			String[] lEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "l_evnt_yd_cd", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] stsEvntDt = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_dt", length));
			String[] fEvntDt = (JSPUtil.getParameter(request, prefix	+ "f_evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSFoundLostMGTVO();
				if (lEvntDt[i] != null)
					model.setLEvntDt(lEvntDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fEvntYdCd[i] != null)
					model.setFEvntYdCd(fEvntYdCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (fEvntDtHm[i] != null)
					model.setFEvntDtHm(fEvntDtHm[i]);
				if (eqAsetStsCd[i] != null)
					model.setEqAsetStsCd(eqAsetStsCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (chssMvmtStsCd[i] != null)
					model.setChssMvmtStsCd(chssMvmtStsCd[i]);
				if (lEvntDtHm[i] != null)
					model.setLEvntDtHm(lEvntDtHm[i]);
				if (prestatus[i] != null)
					model.setPrestatus(prestatus[i]);
				if (lEvntYdCd[i] != null)
					model.setLEvntYdCd(lEvntYdCd[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (stsEvntDt[i] != null)
					model.setStsEvntDt(stsEvntDt[i]);
				if (fEvntDt[i] != null)
					model.setFEvntDt(fEvntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSFoundLostMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSFoundLostMGTVO[]
	 */
	public CHSFoundLostMGTVO[] getCHSFoundLostMGTVOs(){
		CHSFoundLostMGTVO[] vos = (CHSFoundLostMGTVO[])models.toArray(new CHSFoundLostMGTVO[models.size()]);
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
		this.lEvntDt = this.lEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEvntYdCd = this.fEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEvntDtHm = this.fEvntDtHm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqAsetStsCd = this.eqAsetStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMvmtStsCd = this.chssMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lEvntDtHm = this.lEvntDtHm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prestatus = this.prestatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lEvntYdCd = this.lEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntDt = this.stsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEvntDt = this.fEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
