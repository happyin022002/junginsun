/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnDetailHistorybyBlVO.java
*@FileTitle : FFCmpnDetailHistorybyBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.16 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.vo;

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

public class FFCmpnDetailHistorybyBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FFCmpnDetailHistorybyBlVO> models = new ArrayList<FFCmpnDetailHistorybyBlVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String ffBxAmt = null;
	/* Column Info */
	private String ffFeuAmt = null;
	/* Column Info */
	private String ffCmpnStsCd = null;
	/* Column Info */
	private String cntrCommAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ffBkgRt = null;
	/* Column Info */
	private String actCommAble = null;
	/* Column Info */
	private String ffAgmtSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* Column Info */
	private String ffTeuAmt = null;
	/* Column Info */
	private String ffSeq = null;
	/* Column Info */
	private String ffCmpnSeq = null;
	/* Column Info */
	private String ffRfAmt = null;
	/* Column Info */
	private String actCommAmt = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String ffCmpnRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FFCmpnDetailHistorybyBlVO() {}

	public FFCmpnDetailHistorybyBlVO(String ibflag, String pagerows, String ffCmpnSeq, String actCommAble, String ffBkgRt, String actCommAmt, String bkgBxQty, String ffBxAmt, String bkgTeuQty, String ffTeuAmt, String bkgFeuQty, String ffFeuAmt, String bkgRfQty, String ffRfAmt, String cntrCommAmt, String ifAmt, String creDt, String ffCmpnStsCd, String ffCmpnRmk, String ifDt, String ffCntCd, String ffSeq, String ffAgmtSeq) {
		this.ifDt = ifDt;
		this.ffBxAmt = ffBxAmt;
		this.ffFeuAmt = ffFeuAmt;
		this.ffCmpnStsCd = ffCmpnStsCd;
		this.cntrCommAmt = cntrCommAmt;
		this.creDt = creDt;
		this.ffBkgRt = ffBkgRt;
		this.actCommAble = actCommAble;
		this.ffAgmtSeq = ffAgmtSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgFeuQty = bkgFeuQty;
		this.ffTeuAmt = ffTeuAmt;
		this.ffSeq = ffSeq;
		this.ffCmpnSeq = ffCmpnSeq;
		this.ffRfAmt = ffRfAmt;
		this.actCommAmt = actCommAmt;
		this.ffCntCd = ffCntCd;
		this.ifAmt = ifAmt;
		this.bkgTeuQty = bkgTeuQty;
		this.bkgBxQty = bkgBxQty;
		this.bkgRfQty = bkgRfQty;
		this.ffCmpnRmk = ffCmpnRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("ff_bx_amt", getFfBxAmt());
		this.hashColumns.put("ff_feu_amt", getFfFeuAmt());
		this.hashColumns.put("ff_cmpn_sts_cd", getFfCmpnStsCd());
		this.hashColumns.put("cntr_comm_amt", getCntrCommAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ff_bkg_rt", getFfBkgRt());
		this.hashColumns.put("act_comm_able", getActCommAble());
		this.hashColumns.put("ff_agmt_seq", getFfAgmtSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ff_teu_amt", getFfTeuAmt());
		this.hashColumns.put("ff_seq", getFfSeq());
		this.hashColumns.put("ff_cmpn_seq", getFfCmpnSeq());
		this.hashColumns.put("ff_rf_amt", getFfRfAmt());
		this.hashColumns.put("act_comm_amt", getActCommAmt());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("ff_cmpn_rmk", getFfCmpnRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("ff_bx_amt", "ffBxAmt");
		this.hashFields.put("ff_feu_amt", "ffFeuAmt");
		this.hashFields.put("ff_cmpn_sts_cd", "ffCmpnStsCd");
		this.hashFields.put("cntr_comm_amt", "cntrCommAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ff_bkg_rt", "ffBkgRt");
		this.hashFields.put("act_comm_able", "actCommAble");
		this.hashFields.put("ff_agmt_seq", "ffAgmtSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ff_teu_amt", "ffTeuAmt");
		this.hashFields.put("ff_seq", "ffSeq");
		this.hashFields.put("ff_cmpn_seq", "ffCmpnSeq");
		this.hashFields.put("ff_rf_amt", "ffRfAmt");
		this.hashFields.put("act_comm_amt", "actCommAmt");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("ff_cmpn_rmk", "ffCmpnRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return ffBxAmt
	 */
	public String getFfBxAmt() {
		return this.ffBxAmt;
	}
	
	/**
	 * Column Info
	 * @return ffFeuAmt
	 */
	public String getFfFeuAmt() {
		return this.ffFeuAmt;
	}
	
	/**
	 * Column Info
	 * @return ffCmpnStsCd
	 */
	public String getFfCmpnStsCd() {
		return this.ffCmpnStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCommAmt
	 */
	public String getCntrCommAmt() {
		return this.cntrCommAmt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ffBkgRt
	 */
	public String getFfBkgRt() {
		return this.ffBkgRt;
	}
	
	/**
	 * Column Info
	 * @return actCommAble
	 */
	public String getActCommAble() {
		return this.actCommAble;
	}
	
	/**
	 * Column Info
	 * @return ffAgmtSeq
	 */
	public String getFfAgmtSeq() {
		return this.ffAgmtSeq;
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
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
	}
	
	/**
	 * Column Info
	 * @return ffTeuAmt
	 */
	public String getFfTeuAmt() {
		return this.ffTeuAmt;
	}
	
	/**
	 * Column Info
	 * @return ffSeq
	 */
	public String getFfSeq() {
		return this.ffSeq;
	}
	
	/**
	 * Column Info
	 * @return ffCmpnSeq
	 */
	public String getFfCmpnSeq() {
		return this.ffCmpnSeq;
	}
	
	/**
	 * Column Info
	 * @return ffRfAmt
	 */
	public String getFfRfAmt() {
		return this.ffRfAmt;
	}
	
	/**
	 * Column Info
	 * @return actCommAmt
	 */
	public String getActCommAmt() {
		return this.actCommAmt;
	}
	
	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}
	
	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @return bkgBxQty
	 */
	public String getBkgBxQty() {
		return this.bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRfQty
	 */
	public String getBkgRfQty() {
		return this.bkgRfQty;
	}
	
	/**
	 * Column Info
	 * @return ffCmpnRmk
	 */
	public String getFfCmpnRmk() {
		return this.ffCmpnRmk;
	}
	

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param ffBxAmt
	 */
	public void setFfBxAmt(String ffBxAmt) {
		this.ffBxAmt = ffBxAmt;
	}
	
	/**
	 * Column Info
	 * @param ffFeuAmt
	 */
	public void setFfFeuAmt(String ffFeuAmt) {
		this.ffFeuAmt = ffFeuAmt;
	}
	
	/**
	 * Column Info
	 * @param ffCmpnStsCd
	 */
	public void setFfCmpnStsCd(String ffCmpnStsCd) {
		this.ffCmpnStsCd = ffCmpnStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCommAmt
	 */
	public void setCntrCommAmt(String cntrCommAmt) {
		this.cntrCommAmt = cntrCommAmt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ffBkgRt
	 */
	public void setFfBkgRt(String ffBkgRt) {
		this.ffBkgRt = ffBkgRt;
	}
	
	/**
	 * Column Info
	 * @param actCommAble
	 */
	public void setActCommAble(String actCommAble) {
		this.actCommAble = actCommAble;
	}
	
	/**
	 * Column Info
	 * @param ffAgmtSeq
	 */
	public void setFfAgmtSeq(String ffAgmtSeq) {
		this.ffAgmtSeq = ffAgmtSeq;
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
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
	}
	
	/**
	 * Column Info
	 * @param ffTeuAmt
	 */
	public void setFfTeuAmt(String ffTeuAmt) {
		this.ffTeuAmt = ffTeuAmt;
	}
	
	/**
	 * Column Info
	 * @param ffSeq
	 */
	public void setFfSeq(String ffSeq) {
		this.ffSeq = ffSeq;
	}
	
	/**
	 * Column Info
	 * @param ffCmpnSeq
	 */
	public void setFfCmpnSeq(String ffCmpnSeq) {
		this.ffCmpnSeq = ffCmpnSeq;
	}
	
	/**
	 * Column Info
	 * @param ffRfAmt
	 */
	public void setFfRfAmt(String ffRfAmt) {
		this.ffRfAmt = ffRfAmt;
	}
	
	/**
	 * Column Info
	 * @param actCommAmt
	 */
	public void setActCommAmt(String actCommAmt) {
		this.actCommAmt = actCommAmt;
	}
	
	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}
	
	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @param bkgBxQty
	 */
	public void setBkgBxQty(String bkgBxQty) {
		this.bkgBxQty = bkgBxQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRfQty
	 */
	public void setBkgRfQty(String bkgRfQty) {
		this.bkgRfQty = bkgRfQty;
	}
	
	/**
	 * Column Info
	 * @param ffCmpnRmk
	 */
	public void setFfCmpnRmk(String ffCmpnRmk) {
		this.ffCmpnRmk = ffCmpnRmk;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setFfBxAmt(JSPUtil.getParameter(request, prefix + "ff_bx_amt", ""));
		setFfFeuAmt(JSPUtil.getParameter(request, prefix + "ff_feu_amt", ""));
		setFfCmpnStsCd(JSPUtil.getParameter(request, prefix + "ff_cmpn_sts_cd", ""));
		setCntrCommAmt(JSPUtil.getParameter(request, prefix + "cntr_comm_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFfBkgRt(JSPUtil.getParameter(request, prefix + "ff_bkg_rt", ""));
		setActCommAble(JSPUtil.getParameter(request, prefix + "act_comm_able", ""));
		setFfAgmtSeq(JSPUtil.getParameter(request, prefix + "ff_agmt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, prefix + "bkg_feu_qty", ""));
		setFfTeuAmt(JSPUtil.getParameter(request, prefix + "ff_teu_amt", ""));
		setFfSeq(JSPUtil.getParameter(request, prefix + "ff_seq", ""));
		setFfCmpnSeq(JSPUtil.getParameter(request, prefix + "ff_cmpn_seq", ""));
		setFfRfAmt(JSPUtil.getParameter(request, prefix + "ff_rf_amt", ""));
		setActCommAmt(JSPUtil.getParameter(request, prefix + "act_comm_amt", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
		setFfCmpnRmk(JSPUtil.getParameter(request, prefix + "ff_cmpn_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FFCmpnDetailHistorybyBlVO[]
	 */
	public FFCmpnDetailHistorybyBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FFCmpnDetailHistorybyBlVO[]
	 */
	public FFCmpnDetailHistorybyBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FFCmpnDetailHistorybyBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] ffBxAmt = (JSPUtil.getParameter(request, prefix	+ "ff_bx_amt", length));
			String[] ffFeuAmt = (JSPUtil.getParameter(request, prefix	+ "ff_feu_amt", length));
			String[] ffCmpnStsCd = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_sts_cd", length));
			String[] cntrCommAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_comm_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ffBkgRt = (JSPUtil.getParameter(request, prefix	+ "ff_bkg_rt", length));
			String[] actCommAble = (JSPUtil.getParameter(request, prefix	+ "act_comm_able", length));
			String[] ffAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "ff_agmt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ffTeuAmt = (JSPUtil.getParameter(request, prefix	+ "ff_teu_amt", length));
			String[] ffSeq = (JSPUtil.getParameter(request, prefix	+ "ff_seq", length));
			String[] ffCmpnSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_seq", length));
			String[] ffRfAmt = (JSPUtil.getParameter(request, prefix	+ "ff_rf_amt", length));
			String[] actCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_comm_amt", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] ffCmpnRmk = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new FFCmpnDetailHistorybyBlVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (ffBxAmt[i] != null)
					model.setFfBxAmt(ffBxAmt[i]);
				if (ffFeuAmt[i] != null)
					model.setFfFeuAmt(ffFeuAmt[i]);
				if (ffCmpnStsCd[i] != null)
					model.setFfCmpnStsCd(ffCmpnStsCd[i]);
				if (cntrCommAmt[i] != null)
					model.setCntrCommAmt(cntrCommAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ffBkgRt[i] != null)
					model.setFfBkgRt(ffBkgRt[i]);
				if (actCommAble[i] != null)
					model.setActCommAble(actCommAble[i]);
				if (ffAgmtSeq[i] != null)
					model.setFfAgmtSeq(ffAgmtSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ffTeuAmt[i] != null)
					model.setFfTeuAmt(ffTeuAmt[i]);
				if (ffSeq[i] != null)
					model.setFfSeq(ffSeq[i]);
				if (ffCmpnSeq[i] != null)
					model.setFfCmpnSeq(ffCmpnSeq[i]);
				if (ffRfAmt[i] != null)
					model.setFfRfAmt(ffRfAmt[i]);
				if (actCommAmt[i] != null)
					model.setActCommAmt(actCommAmt[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (ffCmpnRmk[i] != null)
					model.setFfCmpnRmk(ffCmpnRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFFCmpnDetailHistorybyBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FFCmpnDetailHistorybyBlVO[]
	 */
	public FFCmpnDetailHistorybyBlVO[] getFFCmpnDetailHistorybyBlVOs(){
		FFCmpnDetailHistorybyBlVO[] vos = (FFCmpnDetailHistorybyBlVO[])models.toArray(new FFCmpnDetailHistorybyBlVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffBxAmt = this.ffBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffFeuAmt = this.ffFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnStsCd = this.ffCmpnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCommAmt = this.cntrCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffBkgRt = this.ffBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAble = this.actCommAble .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffAgmtSeq = this.ffAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffTeuAmt = this.ffTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffSeq = this.ffSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnSeq = this.ffCmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRfAmt = this.ffRfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCommAmt = this.actCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnRmk = this.ffCmpnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
