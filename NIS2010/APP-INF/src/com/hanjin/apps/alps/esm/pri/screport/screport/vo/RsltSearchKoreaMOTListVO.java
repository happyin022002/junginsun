/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RsltSearchKoreaMOTListVO.java
*@FileTitle : RsltSearchKoreaMOTListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.screport.screport.vo;

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

public class RsltSearchKoreaMOTListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchKoreaMOTListVO> models = new ArrayList<RsltSearchKoreaMOTListVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String dateBy = null;
	/* Column Info */
	private String fileAproDt = null;
	/* Column Info */
	private String apvlOfc = null;
	/* Column Info */
	private String fExpDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fCtrtTpS = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String fCtrtTpR = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String fEffDt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String ctrtType = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String fCtrtTp = null;
	/* Column Info */
	private String amdtEffDt = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String propSrepCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltSearchKoreaMOTListVO() {}

	public RsltSearchKoreaMOTListVO(String ibflag, String pagerows, String ctrtType, String ctrtNo, String propNo, String amdtSeq, String custNm, String propOfcCd, String propAproOfcCd, String ctrtEffDt, String ctrtExpDt, String amdtEffDt, String propStsCd, String fileAproDt, String dateBy, String fEffDt, String fExpDt, String apvlOfc, String fCtrtTp, String fCtrtTpR, String fCtrtTpS, String propSrepCd) {
		this.custNm = custNm;
		this.ctrtEffDt = ctrtEffDt;
		this.amdtSeq = amdtSeq;
		this.dateBy = dateBy;
		this.fileAproDt = fileAproDt;
		this.apvlOfc = apvlOfc;
		this.fExpDt = fExpDt;
		this.pagerows = pagerows;
		this.fCtrtTpS = fCtrtTpS;
		this.ctrtNo = ctrtNo;
		this.ibflag = ibflag;
		this.fCtrtTpR = fCtrtTpR;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.fEffDt = fEffDt;
		this.propNo = propNo;
		this.ctrtType = ctrtType;
		this.propStsCd = propStsCd;
		this.fCtrtTp = fCtrtTp;
		this.amdtEffDt = amdtEffDt;
		this.ctrtExpDt = ctrtExpDt;
		this.propSrepCd = propSrepCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("date_by", getDateBy());
		this.hashColumns.put("file_apro_dt", getFileAproDt());
		this.hashColumns.put("apvl_ofc", getApvlOfc());
		this.hashColumns.put("f_exp_dt", getFExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_ctrt_tp_s", getFCtrtTpS());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_ctrt_tp_r", getFCtrtTpR());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("f_eff_dt", getFEffDt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("ctrt_type", getCtrtType());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("f_ctrt_tp", getFCtrtTp());
		this.hashColumns.put("amdt_eff_dt", getAmdtEffDt());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("date_by", "dateBy");
		this.hashFields.put("file_apro_dt", "fileAproDt");
		this.hashFields.put("apvl_ofc", "apvlOfc");
		this.hashFields.put("f_exp_dt", "fExpDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_ctrt_tp_s", "fCtrtTpS");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_ctrt_tp_r", "fCtrtTpR");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("f_eff_dt", "fEffDt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("ctrt_type", "ctrtType");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("f_ctrt_tp", "fCtrtTp");
		this.hashFields.put("amdt_eff_dt", "amdtEffDt");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		return this.hashFields;
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
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
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
	 * @return dateBy
	 */
	public String getDateBy() {
		return this.dateBy;
	}
	
	/**
	 * Column Info
	 * @return fileAproDt
	 */
	public String getFileAproDt() {
		return this.fileAproDt;
	}
	
	/**
	 * Column Info
	 * @return apvlOfc
	 */
	public String getApvlOfc() {
		return this.apvlOfc;
	}
	
	/**
	 * Column Info
	 * @return fExpDt
	 */
	public String getFExpDt() {
		return this.fExpDt;
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
	 * @return fCtrtTpS
	 */
	public String getFCtrtTpS() {
		return this.fCtrtTpS;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return fCtrtTpR
	 */
	public String getFCtrtTpR() {
		return this.fCtrtTpR;
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
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fEffDt
	 */
	public String getFEffDt() {
		return this.fEffDt;
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
	 * @return ctrtType
	 */
	public String getCtrtType() {
		return this.ctrtType;
	}
	
	/**
	 * Column Info
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
	}
	
	/**
	 * Column Info
	 * @return fCtrtTp
	 */
	public String getFCtrtTp() {
		return this.fCtrtTp;
	}
	
	/**
	 * Column Info
	 * @return amdtEffDt
	 */
	public String getAmdtEffDt() {
		return this.amdtEffDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}
	

	/**
	 * @return the propSrepCd
	 */
	public String getPropSrepCd() {
		return propSrepCd;
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
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
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
	 * @param dateBy
	 */
	public void setDateBy(String dateBy) {
		this.dateBy = dateBy;
	}
	
	/**
	 * Column Info
	 * @param fileAproDt
	 */
	public void setFileAproDt(String fileAproDt) {
		this.fileAproDt = fileAproDt;
	}
	
	/**
	 * Column Info
	 * @param apvlOfc
	 */
	public void setApvlOfc(String apvlOfc) {
		this.apvlOfc = apvlOfc;
	}
	
	/**
	 * Column Info
	 * @param fExpDt
	 */
	public void setFExpDt(String fExpDt) {
		this.fExpDt = fExpDt;
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
	 * @param fCtrtTpS
	 */
	public void setFCtrtTpS(String fCtrtTpS) {
		this.fCtrtTpS = fCtrtTpS;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param fCtrtTpR
	 */
	public void setFCtrtTpR(String fCtrtTpR) {
		this.fCtrtTpR = fCtrtTpR;
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
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fEffDt
	 */
	public void setFEffDt(String fEffDt) {
		this.fEffDt = fEffDt;
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
	 * @param ctrtType
	 */
	public void setCtrtType(String ctrtType) {
		this.ctrtType = ctrtType;
	}
	
	/**
	 * Column Info
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
	}
	
	/**
	 * Column Info
	 * @param fCtrtTp
	 */
	public void setFCtrtTp(String fCtrtTp) {
		this.fCtrtTp = fCtrtTp;
	}
	
	/**
	 * Column Info
	 * @param amdtEffDt
	 */
	public void setAmdtEffDt(String amdtEffDt) {
		this.amdtEffDt = amdtEffDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
/**
	 * @param propSrepCd the propSrepCd to set
	 */
	public void setPropSrepCd(String propSrepCd) {
		this.propSrepCd = propSrepCd;
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
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setDateBy(JSPUtil.getParameter(request, prefix + "date_by", ""));
		setFileAproDt(JSPUtil.getParameter(request, prefix + "file_apro_dt", ""));
		setApvlOfc(JSPUtil.getParameter(request, prefix + "apvl_ofc", ""));
		setFExpDt(JSPUtil.getParameter(request, prefix + "f_exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFCtrtTpS(JSPUtil.getParameter(request, prefix + "f_ctrt_tp_s", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFCtrtTpR(JSPUtil.getParameter(request, prefix + "f_ctrt_tp_r", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setFEffDt(JSPUtil.getParameter(request, prefix + "f_eff_dt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCtrtType(JSPUtil.getParameter(request, prefix + "ctrt_type", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setFCtrtTp(JSPUtil.getParameter(request, prefix + "f_ctrt_tp", ""));
		setAmdtEffDt(JSPUtil.getParameter(request, prefix + "amdt_eff_dt", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setPropSrepCd(JSPUtil.getParameter(request, prefix + "prop_srep_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchKoreaMOTListVO[]
	 */
	public RsltSearchKoreaMOTListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchKoreaMOTListVO[]
	 */
	public RsltSearchKoreaMOTListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchKoreaMOTListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] dateBy = (JSPUtil.getParameter(request, prefix	+ "date_by", length));
			String[] fileAproDt = (JSPUtil.getParameter(request, prefix	+ "file_apro_dt", length));
			String[] apvlOfc = (JSPUtil.getParameter(request, prefix	+ "apvl_ofc", length));
			String[] fExpDt = (JSPUtil.getParameter(request, prefix	+ "f_exp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fCtrtTpS = (JSPUtil.getParameter(request, prefix	+ "f_ctrt_tp_s", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCtrtTpR = (JSPUtil.getParameter(request, prefix	+ "f_ctrt_tp_r", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] fEffDt = (JSPUtil.getParameter(request, prefix	+ "f_eff_dt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] ctrtType = (JSPUtil.getParameter(request, prefix	+ "ctrt_type", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] fCtrtTp = (JSPUtil.getParameter(request, prefix	+ "f_ctrt_tp", length));
			String[] amdtEffDt = (JSPUtil.getParameter(request, prefix	+ "amdt_eff_dt", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] propSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_srep_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchKoreaMOTListVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (dateBy[i] != null)
					model.setDateBy(dateBy[i]);
				if (fileAproDt[i] != null)
					model.setFileAproDt(fileAproDt[i]);
				if (apvlOfc[i] != null)
					model.setApvlOfc(apvlOfc[i]);
				if (fExpDt[i] != null)
					model.setFExpDt(fExpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fCtrtTpS[i] != null)
					model.setFCtrtTpS(fCtrtTpS[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCtrtTpR[i] != null)
					model.setFCtrtTpR(fCtrtTpR[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (fEffDt[i] != null)
					model.setFEffDt(fEffDt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (ctrtType[i] != null)
					model.setCtrtType(ctrtType[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (fCtrtTp[i] != null)
					model.setFCtrtTp(fCtrtTp[i]);
				if (amdtEffDt[i] != null)
					model.setAmdtEffDt(amdtEffDt[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (propSrepCd[i] != null)
					model.setPropSrepCd(propSrepCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchKoreaMOTListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchKoreaMOTListVO[]
	 */
	public RsltSearchKoreaMOTListVO[] getRsltSearchKoreaMOTListVOs(){
		RsltSearchKoreaMOTListVO[] vos = (RsltSearchKoreaMOTListVO[])models.toArray(new RsltSearchKoreaMOTListVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateBy = this.dateBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileAproDt = this.fileAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlOfc = this.apvlOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExpDt = this.fExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrtTpS = this.fCtrtTpS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrtTpR = this.fCtrtTpR .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEffDt = this.fEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtType = this.ctrtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCtrtTp = this.fCtrtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtEffDt = this.amdtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd = this.propSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
