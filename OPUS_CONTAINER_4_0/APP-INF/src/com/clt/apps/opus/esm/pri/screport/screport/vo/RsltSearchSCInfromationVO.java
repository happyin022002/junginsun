/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltSearchSCInfromationVO.java
*@FileTitle : RsltSearchSCInfromationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.12.21 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCInfromationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCInfromationVO> models = new ArrayList<RsltSearchSCInfromationVO>();
	
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String ctrtCustSlsOfcCd = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCInfromationVO() {}

	public RsltSearchSCInfromationVO(String ibflag, String pagerows, String custCntCd, String custSeq, String ctrtPtyNm, String prcCtrtCustTpCd, String ctrtCustSlsOfcCd, String ctrtCustSrepCd, String srepNm, String ctrtEffDt, String ctrtExpDt, String scNo) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
		this.ctrtPtyNm = ctrtPtyNm;
		this.ibflag = ibflag;
		this.ctrtEffDt = ctrtEffDt;
		this.scNo = scNo;
		this.srepNm = srepNm;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.custSeq = custSeq;
		this.custCntCd = custCntCd;
		this.ctrtExpDt = ctrtExpDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("ctrt_cust_sls_ofc_cd", getCtrtCustSlsOfcCd());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("ctrt_cust_sls_ofc_cd", "ctrtCustSlsOfcCd");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSlsOfcCd
	 */
	public String getCtrtCustSlsOfcCd() {
		return this.ctrtCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
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
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
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
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
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
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSlsOfcCd
	 */
	public void setCtrtCustSlsOfcCd(String ctrtCustSlsOfcCd) {
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
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
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
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
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
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
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, "prc_ctrt_cust_tp_cd", ""));
		setCtrtCustSlsOfcCd(JSPUtil.getParameter(request, "ctrt_cust_sls_ofc_cd", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, "ctrt_pty_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, "ctrt_eff_dt", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setSrepNm(JSPUtil.getParameter(request, "srep_nm", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, "ctrt_cust_srep_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, "ctrt_exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCInfromationVO[]
	 */
	public RsltSearchSCInfromationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCInfromationVO[]
	 */
	public RsltSearchSCInfromationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCInfromationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] ctrtCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_sls_ofc_cd", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCInfromationVO();
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (ctrtCustSlsOfcCd[i] != null)
					model.setCtrtCustSlsOfcCd(ctrtCustSlsOfcCd[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCInfromationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCInfromationVO[]
	 */
	public RsltSearchSCInfromationVO[] getRsltSearchSCInfromationVOs(){
		RsltSearchSCInfromationVO[] vos = (RsltSearchSCInfromationVO[])models.toArray(new RsltSearchSCInfromationVO[models.size()]);
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
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSlsOfcCd = this.ctrtCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
