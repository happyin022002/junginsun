/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RsltSlpErrorInformationVO.java
*@FileTitle : RsltSlpErrorInformationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSlpErrorInformationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSlpErrorInformationVO> models = new ArrayList<RsltSlpErrorInformationVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String slpAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpIfErrRsn = null;
	/* Column Info */
	private String slpCtrCd = null;
	/* Column Info */
	private String slpCurrCd = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String slpTjNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSlpErrorInformationVO() {}

	public RsltSlpErrorInformationVO(String ibflag, String pagerows, String slpTjNo, String slpSeqNo, String slpCurrCd, String slpCtrCd, String acctCd, String glEffDt, String ofcCd, String slpAmt, String slpIfErrRsn) {
		this.ofcCd = ofcCd;
		this.slpAmt = slpAmt;
		this.ibflag = ibflag;
		this.glEffDt = glEffDt;
		this.acctCd = acctCd;
		this.slpIfErrRsn = slpIfErrRsn;
		this.slpCtrCd = slpCtrCd;
		this.slpCurrCd = slpCurrCd;
		this.slpSeqNo = slpSeqNo;
		this.slpTjNo = slpTjNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("slp_amt", getSlpAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_if_err_rsn", getSlpIfErrRsn());
		this.hashColumns.put("slp_ctr_cd", getSlpCtrCd());
		this.hashColumns.put("slp_curr_cd", getSlpCurrCd());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("slp_tj_no", getSlpTjNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("slp_amt", "slpAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_if_err_rsn", "slpIfErrRsn");
		this.hashFields.put("slp_ctr_cd", "slpCtrCd");
		this.hashFields.put("slp_curr_cd", "slpCurrCd");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("slp_tj_no", "slpTjNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return slpAmt
	 */
	public String getSlpAmt() {
		return this.slpAmt;
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
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return slpIfErrRsn
	 */
	public String getSlpIfErrRsn() {
		return this.slpIfErrRsn;
	}
	
	/**
	 * Column Info
	 * @return slpCtrCd
	 */
	public String getSlpCtrCd() {
		return this.slpCtrCd;
	}
	
	/**
	 * Column Info
	 * @return slpCurrCd
	 */
	public String getSlpCurrCd() {
		return this.slpCurrCd;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return slpTjNo
	 */
	public String getSlpTjNo() {
		return this.slpTjNo;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param slpAmt
	 */
	public void setSlpAmt(String slpAmt) {
		this.slpAmt = slpAmt;
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
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param slpIfErrRsn
	 */
	public void setSlpIfErrRsn(String slpIfErrRsn) {
		this.slpIfErrRsn = slpIfErrRsn;
	}
	
	/**
	 * Column Info
	 * @param slpCtrCd
	 */
	public void setSlpCtrCd(String slpCtrCd) {
		this.slpCtrCd = slpCtrCd;
	}
	
	/**
	 * Column Info
	 * @param slpCurrCd
	 */
	public void setSlpCurrCd(String slpCurrCd) {
		this.slpCurrCd = slpCurrCd;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param slpTjNo
	 */
	public void setSlpTjNo(String slpTjNo) {
		this.slpTjNo = slpTjNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setSlpAmt(JSPUtil.getParameter(request, prefix + "slp_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGlEffDt(JSPUtil.getParameter(request, prefix + "gl_eff_dt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setSlpIfErrRsn(JSPUtil.getParameter(request, prefix + "slp_if_err_rsn", ""));
		setSlpCtrCd(JSPUtil.getParameter(request, prefix + "slp_ctr_cd", ""));
		setSlpCurrCd(JSPUtil.getParameter(request, prefix + "slp_curr_cd", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, prefix + "slp_seq_no", ""));
		setSlpTjNo(JSPUtil.getParameter(request, prefix + "slp_tj_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSlpErrorInformationVO[]
	 */
	public RsltSlpErrorInformationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSlpErrorInformationVO[]
	 */
	public RsltSlpErrorInformationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSlpErrorInformationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] slpAmt = (JSPUtil.getParameter(request, prefix	+ "slp_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpIfErrRsn = (JSPUtil.getParameter(request, prefix	+ "slp_if_err_rsn", length));
			String[] slpCtrCd = (JSPUtil.getParameter(request, prefix	+ "slp_ctr_cd", length));
			String[] slpCurrCd = (JSPUtil.getParameter(request, prefix	+ "slp_curr_cd", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] slpTjNo = (JSPUtil.getParameter(request, prefix	+ "slp_tj_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSlpErrorInformationVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (slpAmt[i] != null)
					model.setSlpAmt(slpAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpIfErrRsn[i] != null)
					model.setSlpIfErrRsn(slpIfErrRsn[i]);
				if (slpCtrCd[i] != null)
					model.setSlpCtrCd(slpCtrCd[i]);
				if (slpCurrCd[i] != null)
					model.setSlpCurrCd(slpCurrCd[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (slpTjNo[i] != null)
					model.setSlpTjNo(slpTjNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSlpErrorInformationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSlpErrorInformationVO[]
	 */
	public RsltSlpErrorInformationVO[] getRsltSlpErrorInformationVOs(){
		RsltSlpErrorInformationVO[] vos = (RsltSlpErrorInformationVO[])models.toArray(new RsltSlpErrorInformationVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpAmt = this.slpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIfErrRsn = this.slpIfErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpCtrCd = this.slpCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpCurrCd = this.slpCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTjNo = this.slpTjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
