/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ASAInquiryListVO.java
*@FileTitle : ASAInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class ASAInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ASAInquiryListVO> models = new ArrayList<ASAInquiryListVO>();
	
	/* Column Info */
	private String unsetBalAmt = null;
	/* Column Info */
	private String asaNo3Fm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String lastBalAmt = null;
	/* Column Info */
	private String prevBalAmt = null;
	/* Column Info */
	private String appro = null;
	/* Column Info */
	private String bilCrePrdToDt = null;
	/* Column Info */
	private String asaStsCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bilCrePrdFmDt = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String commAmt = null;
	/* Column Info */
	private String rmtcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revRfdAmt = null;
	/* Column Info */
	private String actualBalAmt = null;
	/* Column Info */
	private String asaNo3To = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String expenseAmt = null;
	/* Column Info */
	private String agnAsaCreDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ASAInquiryListVO() {}

	public ASAInquiryListVO(String ibflag, String pagerows, String asaNo, String currCd, String bilCrePrdFmDt, String bilCrePrdToDt, String prevBalAmt, String revRfdAmt, String expenseAmt, String commAmt, String rmtcAmt, String lastBalAmt, String actualBalAmt, String unsetBalAmt, String agnAsaCreDt, String aproDt, String ofcCd, String agnCd, String asaStsCd, String arOfcCd, String asaNo3Fm, String asaNo3To, String appro) {
		this.unsetBalAmt = unsetBalAmt;
		this.asaNo3Fm = asaNo3Fm;
		this.currCd = currCd;
		this.lastBalAmt = lastBalAmt;
		this.prevBalAmt = prevBalAmt;
		this.appro = appro;
		this.bilCrePrdToDt = bilCrePrdToDt;
		this.asaStsCd = asaStsCd;
		this.aproDt = aproDt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.bilCrePrdFmDt = bilCrePrdFmDt;
		this.agnCd = agnCd;
		this.ofcCd = ofcCd;
		this.commAmt = commAmt;
		this.rmtcAmt = rmtcAmt;
		this.ibflag = ibflag;
		this.revRfdAmt = revRfdAmt;
		this.actualBalAmt = actualBalAmt;
		this.asaNo3To = asaNo3To;
		this.asaNo = asaNo;
		this.expenseAmt = expenseAmt;
		this.agnAsaCreDt = agnAsaCreDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("unset_bal_amt", getUnsetBalAmt());
		this.hashColumns.put("asa_no3_fm", getAsaNo3Fm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("last_bal_amt", getLastBalAmt());
		this.hashColumns.put("prev_bal_amt", getPrevBalAmt());
		this.hashColumns.put("appro", getAppro());
		this.hashColumns.put("bil_cre_prd_to_dt", getBilCrePrdToDt());
		this.hashColumns.put("asa_sts_cd", getAsaStsCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bil_cre_prd_fm_dt", getBilCrePrdFmDt());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("comm_amt", getCommAmt());
		this.hashColumns.put("rmtc_amt", getRmtcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_rfd_amt", getRevRfdAmt());
		this.hashColumns.put("actual_bal_amt", getActualBalAmt());
		this.hashColumns.put("asa_no3_to", getAsaNo3To());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("expense_amt", getExpenseAmt());
		this.hashColumns.put("agn_asa_cre_dt", getAgnAsaCreDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("unset_bal_amt", "unsetBalAmt");
		this.hashFields.put("asa_no3_fm", "asaNo3Fm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("last_bal_amt", "lastBalAmt");
		this.hashFields.put("prev_bal_amt", "prevBalAmt");
		this.hashFields.put("appro", "appro");
		this.hashFields.put("bil_cre_prd_to_dt", "bilCrePrdToDt");
		this.hashFields.put("asa_sts_cd", "asaStsCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bil_cre_prd_fm_dt", "bilCrePrdFmDt");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("comm_amt", "commAmt");
		this.hashFields.put("rmtc_amt", "rmtcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_rfd_amt", "revRfdAmt");
		this.hashFields.put("actual_bal_amt", "actualBalAmt");
		this.hashFields.put("asa_no3_to", "asaNo3To");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("expense_amt", "expenseAmt");
		this.hashFields.put("agn_asa_cre_dt", "agnAsaCreDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return unsetBalAmt
	 */
	public String getUnsetBalAmt() {
		return this.unsetBalAmt;
	}
	
	/**
	 * Column Info
	 * @return asaNo3Fm
	 */
	public String getAsaNo3Fm() {
		return this.asaNo3Fm;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return lastBalAmt
	 */
	public String getLastBalAmt() {
		return this.lastBalAmt;
	}
	
	/**
	 * Column Info
	 * @return prevBalAmt
	 */
	public String getPrevBalAmt() {
		return this.prevBalAmt;
	}
	
	/**
	 * Column Info
	 * @return appro
	 */
	public String getAppro() {
		return this.appro;
	}
	
	/**
	 * Column Info
	 * @return bilCrePrdToDt
	 */
	public String getBilCrePrdToDt() {
		return this.bilCrePrdToDt;
	}
	
	/**
	 * Column Info
	 * @return asaStsCd
	 */
	public String getAsaStsCd() {
		return this.asaStsCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return bilCrePrdFmDt
	 */
	public String getBilCrePrdFmDt() {
		return this.bilCrePrdFmDt;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return commAmt
	 */
	public String getCommAmt() {
		return this.commAmt;
	}
	
	/**
	 * Column Info
	 * @return rmtcAmt
	 */
	public String getRmtcAmt() {
		return this.rmtcAmt;
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
	 * @return revRfdAmt
	 */
	public String getRevRfdAmt() {
		return this.revRfdAmt;
	}
	
	/**
	 * Column Info
	 * @return actualBalAmt
	 */
	public String getActualBalAmt() {
		return this.actualBalAmt;
	}
	
	/**
	 * Column Info
	 * @return asaNo3To
	 */
	public String getAsaNo3To() {
		return this.asaNo3To;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return expenseAmt
	 */
	public String getExpenseAmt() {
		return this.expenseAmt;
	}
	
	/**
	 * Column Info
	 * @return agnAsaCreDt
	 */
	public String getAgnAsaCreDt() {
		return this.agnAsaCreDt;
	}
	

	/**
	 * Column Info
	 * @param unsetBalAmt
	 */
	public void setUnsetBalAmt(String unsetBalAmt) {
		this.unsetBalAmt = unsetBalAmt;
	}
	
	/**
	 * Column Info
	 * @param asaNo3Fm
	 */
	public void setAsaNo3Fm(String asaNo3Fm) {
		this.asaNo3Fm = asaNo3Fm;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param lastBalAmt
	 */
	public void setLastBalAmt(String lastBalAmt) {
		this.lastBalAmt = lastBalAmt;
	}
	
	/**
	 * Column Info
	 * @param prevBalAmt
	 */
	public void setPrevBalAmt(String prevBalAmt) {
		this.prevBalAmt = prevBalAmt;
	}
	
	/**
	 * Column Info
	 * @param appro
	 */
	public void setAppro(String appro) {
		this.appro = appro;
	}
	
	/**
	 * Column Info
	 * @param bilCrePrdToDt
	 */
	public void setBilCrePrdToDt(String bilCrePrdToDt) {
		this.bilCrePrdToDt = bilCrePrdToDt;
	}
	
	/**
	 * Column Info
	 * @param asaStsCd
	 */
	public void setAsaStsCd(String asaStsCd) {
		this.asaStsCd = asaStsCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param bilCrePrdFmDt
	 */
	public void setBilCrePrdFmDt(String bilCrePrdFmDt) {
		this.bilCrePrdFmDt = bilCrePrdFmDt;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param commAmt
	 */
	public void setCommAmt(String commAmt) {
		this.commAmt = commAmt;
	}
	
	/**
	 * Column Info
	 * @param rmtcAmt
	 */
	public void setRmtcAmt(String rmtcAmt) {
		this.rmtcAmt = rmtcAmt;
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
	 * @param revRfdAmt
	 */
	public void setRevRfdAmt(String revRfdAmt) {
		this.revRfdAmt = revRfdAmt;
	}
	
	/**
	 * Column Info
	 * @param actualBalAmt
	 */
	public void setActualBalAmt(String actualBalAmt) {
		this.actualBalAmt = actualBalAmt;
	}
	
	/**
	 * Column Info
	 * @param asaNo3To
	 */
	public void setAsaNo3To(String asaNo3To) {
		this.asaNo3To = asaNo3To;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param expenseAmt
	 */
	public void setExpenseAmt(String expenseAmt) {
		this.expenseAmt = expenseAmt;
	}
	
	/**
	 * Column Info
	 * @param agnAsaCreDt
	 */
	public void setAgnAsaCreDt(String agnAsaCreDt) {
		this.agnAsaCreDt = agnAsaCreDt;
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
		setUnsetBalAmt(JSPUtil.getParameter(request, prefix + "unset_bal_amt", ""));
		setAsaNo3Fm(JSPUtil.getParameter(request, prefix + "asa_no3_fm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setLastBalAmt(JSPUtil.getParameter(request, prefix + "last_bal_amt", ""));
		setPrevBalAmt(JSPUtil.getParameter(request, prefix + "prev_bal_amt", ""));
		setAppro(JSPUtil.getParameter(request, prefix + "appro", ""));
		setBilCrePrdToDt(JSPUtil.getParameter(request, prefix + "bil_cre_prd_to_dt", ""));
		setAsaStsCd(JSPUtil.getParameter(request, prefix + "asa_sts_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBilCrePrdFmDt(JSPUtil.getParameter(request, prefix + "bil_cre_prd_fm_dt", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCommAmt(JSPUtil.getParameter(request, prefix + "comm_amt", ""));
		setRmtcAmt(JSPUtil.getParameter(request, prefix + "rmtc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRevRfdAmt(JSPUtil.getParameter(request, prefix + "rev_rfd_amt", ""));
		setActualBalAmt(JSPUtil.getParameter(request, prefix + "actual_bal_amt", ""));
		setAsaNo3To(JSPUtil.getParameter(request, prefix + "asa_no3_to", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setExpenseAmt(JSPUtil.getParameter(request, prefix + "expense_amt", ""));
		setAgnAsaCreDt(JSPUtil.getParameter(request, prefix + "agn_asa_cre_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ASAInquiryListVO[]
	 */
	public ASAInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ASAInquiryListVO[]
	 */
	public ASAInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ASAInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] unsetBalAmt = (JSPUtil.getParameter(request, prefix	+ "unset_bal_amt", length));
			String[] asaNo3Fm = (JSPUtil.getParameter(request, prefix	+ "asa_no3_fm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] lastBalAmt = (JSPUtil.getParameter(request, prefix	+ "last_bal_amt", length));
			String[] prevBalAmt = (JSPUtil.getParameter(request, prefix	+ "prev_bal_amt", length));
			String[] appro = (JSPUtil.getParameter(request, prefix	+ "appro", length));
			String[] bilCrePrdToDt = (JSPUtil.getParameter(request, prefix	+ "bil_cre_prd_to_dt", length));
			String[] asaStsCd = (JSPUtil.getParameter(request, prefix	+ "asa_sts_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bilCrePrdFmDt = (JSPUtil.getParameter(request, prefix	+ "bil_cre_prd_fm_dt", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] commAmt = (JSPUtil.getParameter(request, prefix	+ "comm_amt", length));
			String[] rmtcAmt = (JSPUtil.getParameter(request, prefix	+ "rmtc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revRfdAmt = (JSPUtil.getParameter(request, prefix	+ "rev_rfd_amt", length));
			String[] actualBalAmt = (JSPUtil.getParameter(request, prefix	+ "actual_bal_amt", length));
			String[] asaNo3To = (JSPUtil.getParameter(request, prefix	+ "asa_no3_to", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] expenseAmt = (JSPUtil.getParameter(request, prefix	+ "expense_amt", length));
			String[] agnAsaCreDt = (JSPUtil.getParameter(request, prefix	+ "agn_asa_cre_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ASAInquiryListVO();
				if (unsetBalAmt[i] != null)
					model.setUnsetBalAmt(unsetBalAmt[i]);
				if (asaNo3Fm[i] != null)
					model.setAsaNo3Fm(asaNo3Fm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (lastBalAmt[i] != null)
					model.setLastBalAmt(lastBalAmt[i]);
				if (prevBalAmt[i] != null)
					model.setPrevBalAmt(prevBalAmt[i]);
				if (appro[i] != null)
					model.setAppro(appro[i]);
				if (bilCrePrdToDt[i] != null)
					model.setBilCrePrdToDt(bilCrePrdToDt[i]);
				if (asaStsCd[i] != null)
					model.setAsaStsCd(asaStsCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bilCrePrdFmDt[i] != null)
					model.setBilCrePrdFmDt(bilCrePrdFmDt[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (commAmt[i] != null)
					model.setCommAmt(commAmt[i]);
				if (rmtcAmt[i] != null)
					model.setRmtcAmt(rmtcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revRfdAmt[i] != null)
					model.setRevRfdAmt(revRfdAmt[i]);
				if (actualBalAmt[i] != null)
					model.setActualBalAmt(actualBalAmt[i]);
				if (asaNo3To[i] != null)
					model.setAsaNo3To(asaNo3To[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (expenseAmt[i] != null)
					model.setExpenseAmt(expenseAmt[i]);
				if (agnAsaCreDt[i] != null)
					model.setAgnAsaCreDt(agnAsaCreDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getASAInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ASAInquiryListVO[]
	 */
	public ASAInquiryListVO[] getASAInquiryListVOs(){
		ASAInquiryListVO[] vos = (ASAInquiryListVO[])models.toArray(new ASAInquiryListVO[models.size()]);
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
		this.unsetBalAmt = this.unsetBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo3Fm = this.asaNo3Fm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastBalAmt = this.lastBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevBalAmt = this.prevBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appro = this.appro .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilCrePrdToDt = this.bilCrePrdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaStsCd = this.asaStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilCrePrdFmDt = this.bilCrePrdFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commAmt = this.commAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmtcAmt = this.rmtcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revRfdAmt = this.revRfdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualBalAmt = this.actualBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo3To = this.asaNo3To .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expenseAmt = this.expenseAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAsaCreDt = this.agnAsaCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
