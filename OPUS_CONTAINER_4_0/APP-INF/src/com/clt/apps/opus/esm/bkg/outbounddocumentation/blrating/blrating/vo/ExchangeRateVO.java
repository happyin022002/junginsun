/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExchangeRateVO.java
*@FileTitle : ExchangeRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.03.19 이진서 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExchangeRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExchangeRateVO> models = new ArrayList<ExchangeRateVO>();
	
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vsl = null;
	/* Column Info */
	private String lCurrCd = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String invXchRt = null;
	/* Page Number */
	private String pagerows = null;
	private String preCurr = null;
	private String colCurr = null;
	private String chgCd = null;
	private String pChgCd = null;
	private String rateUtCd = null;
	private String cgoTpCd = null;
	private String rcvTermCd = null;
	private String deTermCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExchangeRateVO() {}

	public ExchangeRateVO(String ibflag, String pagerows, String vpsPortCd, String bkgNo, String vpsEtdDt, String currCd, String lCurrCd, String vsl, String type, String invXchRt, String preCurr, String colCurr, String chgCd, String pChgCd, String rateUtCd, String cgoTpCd, String rcvTermCd, String deTermCd) {
		this.vpsPortCd = vpsPortCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.vpsEtdDt = vpsEtdDt;
		this.vsl = vsl;
		this.lCurrCd = lCurrCd;
		this.type = type;
		this.invXchRt = invXchRt;
		this.pagerows = pagerows;
		this.preCurr = preCurr;
		this.colCurr = colCurr;
		this.chgCd = chgCd;
		this.pChgCd = pChgCd;
		this.rateUtCd = rateUtCd;
		this.cgoTpCd = cgoTpCd;
		this.rcvTermCd = rcvTermCd;
		this.deTermCd = deTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vsl", getVsl());
		this.hashColumns.put("l_curr_cd", getLCurrCd());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_curr", getPreCurr());
		this.hashColumns.put("col_curr", getColCurr());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("p_chg_cd", getPChgCd());
		this.hashColumns.put("rate_ut_cd", getRateUtCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vsl", "vsl");
		this.hashFields.put("l_curr_cd", "lCurrCd");
		this.hashFields.put("type", "type");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_curr", "preCurr");
		this.hashFields.put("col_curr", "colCurr");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("p_chg_cd", "pChgCd");
		this.hashFields.put("rate_ut_cd", "rateUtCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return vsl
	 */
	public String getVsl() {
		return this.vsl;
	}
	
	/**
	 * Column Info
	 * @return lCurrCd
	 */
	public String getLCurrCd() {
		return this.lCurrCd;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param vsl
	 */
	public void setVsl(String vsl) {
		this.vsl = vsl;
	}
	
	/**
	 * Column Info
	 * @param lCurrCd
	 */
	public void setLCurrCd(String lCurrCd) {
		this.lCurrCd = lCurrCd;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @return the preCurr
	 */
	public String getPreCurr() {
		return preCurr;
	}

	/**
	 * @param preCurr the preCurr to set
	 */
	public void setPreCurr(String preCurr) {
		this.preCurr = preCurr;
	}

	/**
	 * @return the colCurr
	 */
	public String getColCurr() {
		return colCurr;
	}

	/**
	 * @param colCurr the colCurr to set
	 */
	public void setColCurr(String colCurr) {
		this.colCurr = colCurr;
	}

	/**
	 * @return the chgCd
	 */
	public String getChgCd() {
		return chgCd;
	}

	/**
	 * @param chgCd the chgCd to set
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	
	/**
	 * @return the pChgCd
	 */
	public String getPChgCd() {
		return pChgCd;
	}

	/**
	 * @param pChgCd the pChgCd to set
	 */
	public void setPChgCd(String pChgCd) {
		this.pChgCd = pChgCd;
	}
	
	/**
	 * @return the rateUtCd
	 */
	public String getRateUtCd() {
		return rateUtCd;
	}

	/**
	 * @param rateUtCd the rateUtCd to set
	 */
	public void setRateUtCd(String rateUtCd) {
		this.rateUtCd = rateUtCd;
	}

	/**
	 * @return the cgoTpCd
	 */
	public String getCgoTpCd() {
		return cgoTpCd;
	}

	/**
	 * @param cgoTpCd the cgoTpCd to set
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * @return the rcvTermCd
	 */
	public String getRcvTermCd() {
		return rcvTermCd;
	}
	
	/**
	 * @param rcvTermCd the rcvTermCd to set
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * @return the deTermCd
	 */
	public String getDeTermCd() {
		return deTermCd;
	}
	
	/**
	 * @param deTermCd the deTermCd to set
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setVsl(JSPUtil.getParameter(request, prefix + "vsl", ""));
		setLCurrCd(JSPUtil.getParameter(request, prefix + "l_curr_cd", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPreCurr(JSPUtil.getParameter(request, prefix + "pre_curr", ""));
		setColCurr(JSPUtil.getParameter(request, prefix + "col_curr", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPChgCd(JSPUtil.getParameter(request, prefix + "p_chg_cd", ""));
		setRateUtCd(JSPUtil.getParameter(request, prefix + "rate_ut_cd", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExchangeRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] vsl = (JSPUtil.getParameter(request, prefix	+ "vsl", length));
			String[] lCurrCd = (JSPUtil.getParameter(request, prefix	+ "l_curr_cd", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preCur = (JSPUtil.getParameter(request, prefix	+ "pre_curr", length));
			String[] colCur = (JSPUtil.getParameter(request, prefix	+ "col_curr", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pChgCd = (JSPUtil.getParameter(request, prefix	+ "p_chg_cd", length));
			String[] rateUtCd = (JSPUtil.getParameter(request, prefix	+ "rate_ut_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExchangeRateVO();
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vsl[i] != null)
					model.setVsl(vsl[i]);
				if (lCurrCd[i] != null)
					model.setLCurrCd(lCurrCd[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preCur[i] != null)
					model.setPreCurr(preCur[i]);
				if (colCur[i] != null)
					model.setColCurr(colCur[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pChgCd[i] != null)
					model.setPChgCd(pChgCd[i]);
				if (rateUtCd[i] != null)
					model.setRateUtCd(rateUtCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExchangeRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[] getExchangeRateVOs(){
		ExchangeRateVO[] vos = (ExchangeRateVO[])models.toArray(new ExchangeRateVO[models.size()]);
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
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsl = this.vsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lCurrCd = this.lCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCurr = this.preCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colCurr = this.colCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pChgCd = this.pChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateUtCd = this.rateUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
