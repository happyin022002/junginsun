/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CstShInqVO.java
*@FileTitle : CstShInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.07
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.05.07 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstShInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstShInqVO> models = new ArrayList<CstShInqVO>();
	
	/* Column Info */
	private String sscNo = null;
	/* Column Info */
	private String smqcSignNm = null;
	/* Column Info */
	private String seffDt1 = null;
	/* Column Info */
	private String sscTypeCd = null;
	/* Column Info */
	private String spropOfcCd = null;
	/* Column Info */
	private String spropSrepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spropAproOfcCd = null;
	/* Column Info */
	private String spropMqcQty = null;
	/* Column Info */
	private String spropStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sprcCtrtCustTpCd = null;
	/* Column Info */
	private String spropNo = null;
	/* Column Info */
	private String smqcSignCd = null;
	/* Column Info */
	private String scustCntCd = null;
	/* Column Info */
	private String scustSeq = null;
	/* Column Info */
	private String screDt1 = null;
	/* Column Info */
	private String screDt2 = null;
	/* Column Info */
	private String seffDt2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstShInqVO() {}

	public CstShInqVO(String ibflag, String pagerows, String sscNo, String spropNo, String spropOfcCd, String spropSrepCd, String spropAproOfcCd, String spropStsCd, String scustCntCd, String scustSeq, String screDt1, String screDt2, String seffDt1, String seffDt2, String spropMqcQty, String smqcSignCd, String sscTypeCd, String smqcSignNm, String sprcCtrtCustTpCd) {
		this.sscNo = sscNo;
		this.smqcSignNm = smqcSignNm;
		this.seffDt1 = seffDt1;
		this.sscTypeCd = sscTypeCd;
		this.spropOfcCd = spropOfcCd;
		this.spropSrepCd = spropSrepCd;
		this.pagerows = pagerows;
		this.spropAproOfcCd = spropAproOfcCd;
		this.spropMqcQty = spropMqcQty;
		this.spropStsCd = spropStsCd;
		this.ibflag = ibflag;
		this.sprcCtrtCustTpCd = sprcCtrtCustTpCd;
		this.spropNo = spropNo;
		this.smqcSignCd = smqcSignCd;
		this.scustCntCd = scustCntCd;
		this.scustSeq = scustSeq;
		this.screDt1 = screDt1;
		this.screDt2 = screDt2;
		this.seffDt2 = seffDt2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ssc_no", getSscNo());
		this.hashColumns.put("smqc_sign_nm", getSmqcSignNm());
		this.hashColumns.put("seff_dt1", getSeffDt1());
		this.hashColumns.put("ssc_type_cd", getSscTypeCd());
		this.hashColumns.put("sprop_ofc_cd", getSpropOfcCd());
		this.hashColumns.put("sprop_srep_cd", getSpropSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sprop_apro_ofc_cd", getSpropAproOfcCd());
		this.hashColumns.put("sprop_mqc_qty", getSpropMqcQty());
		this.hashColumns.put("sprop_sts_cd", getSpropStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sprc_ctrt_cust_tp_cd", getSprcCtrtCustTpCd());
		this.hashColumns.put("sprop_no", getSpropNo());
		this.hashColumns.put("smqc_sign_cd", getSmqcSignCd());
		this.hashColumns.put("scust_cnt_cd", getScustCntCd());
		this.hashColumns.put("scust_seq", getScustSeq());
		this.hashColumns.put("scre_dt1", getScreDt1());
		this.hashColumns.put("scre_dt2", getScreDt2());
		this.hashColumns.put("seff_dt2", getSeffDt2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ssc_no", "sscNo");
		this.hashFields.put("smqc_sign_nm", "smqcSignNm");
		this.hashFields.put("seff_dt1", "seffDt1");
		this.hashFields.put("ssc_type_cd", "sscTypeCd");
		this.hashFields.put("sprop_ofc_cd", "spropOfcCd");
		this.hashFields.put("sprop_srep_cd", "spropSrepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sprop_apro_ofc_cd", "spropAproOfcCd");
		this.hashFields.put("sprop_mqc_qty", "spropMqcQty");
		this.hashFields.put("sprop_sts_cd", "spropStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sprc_ctrt_cust_tp_cd", "sprcCtrtCustTpCd");
		this.hashFields.put("sprop_no", "spropNo");
		this.hashFields.put("smqc_sign_cd", "smqcSignCd");
		this.hashFields.put("scust_cnt_cd", "scustCntCd");
		this.hashFields.put("scust_seq", "scustSeq");
		this.hashFields.put("scre_dt1", "screDt1");
		this.hashFields.put("scre_dt2", "screDt2");
		this.hashFields.put("seff_dt2", "seffDt2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sscNo
	 */
	public String getSscNo() {
		return this.sscNo;
	}
	
	/**
	 * Column Info
	 * @return smqcSignNm
	 */
	public String getSmqcSignNm() {
		return this.smqcSignNm;
	}
	
	/**
	 * Column Info
	 * @return seffDt1
	 */
	public String getSeffDt1() {
		return this.seffDt1;
	}
	
	/**
	 * Column Info
	 * @return sscTypeCd
	 */
	public String getSscTypeCd() {
		return this.sscTypeCd;
	}
	
	/**
	 * Column Info
	 * @return spropOfcCd
	 */
	public String getSpropOfcCd() {
		return this.spropOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spropSrepCd
	 */
	public String getSpropSrepCd() {
		return this.spropSrepCd;
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
	 * @return spropAproOfcCd
	 */
	public String getSpropAproOfcCd() {
		return this.spropAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spropMqcQty
	 */
	public String getSpropMqcQty() {
		return this.spropMqcQty;
	}
	
	/**
	 * Column Info
	 * @return spropStsCd
	 */
	public String getSpropStsCd() {
		return this.spropStsCd;
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
	 * @return sprcCtrtCustTpCd
	 */
	public String getSprcCtrtCustTpCd() {
		return this.sprcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return spropNo
	 */
	public String getSpropNo() {
		return this.spropNo;
	}
	
	/**
	 * Column Info
	 * @return smqcSignCd
	 */
	public String getSmqcSignCd() {
		return this.smqcSignCd;
	}
	
	/**
	 * Column Info
	 * @return scustCntCd
	 */
	public String getScustCntCd() {
		return this.scustCntCd;
	}
	
	/**
	 * Column Info
	 * @return scustSeq
	 */
	public String getScustSeq() {
		return this.scustSeq;
	}
	
	/**
	 * Column Info
	 * @return screDt1
	 */
	public String getScreDt1() {
		return this.screDt1;
	}
	
	/**
	 * Column Info
	 * @return screDt2
	 */
	public String getScreDt2() {
		return this.screDt2;
	}
	
	/**
	 * Column Info
	 * @return seffDt2
	 */
	public String getSeffDt2() {
		return this.seffDt2;
	}
	

	/**
	 * Column Info
	 * @param sscNo
	 */
	public void setSscNo(String sscNo) {
		this.sscNo = sscNo;
	}
	
	/**
	 * Column Info
	 * @param smqcSignNm
	 */
	public void setSmqcSignNm(String smqcSignNm) {
		this.smqcSignNm = smqcSignNm;
	}
	
	/**
	 * Column Info
	 * @param seffDt1
	 */
	public void setSeffDt1(String seffDt1) {
		this.seffDt1 = seffDt1;
	}
	
	/**
	 * Column Info
	 * @param sscTypeCd
	 */
	public void setSscTypeCd(String sscTypeCd) {
		this.sscTypeCd = sscTypeCd;
	}
	
	/**
	 * Column Info
	 * @param spropOfcCd
	 */
	public void setSpropOfcCd(String spropOfcCd) {
		this.spropOfcCd = spropOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spropSrepCd
	 */
	public void setSpropSrepCd(String spropSrepCd) {
		this.spropSrepCd = spropSrepCd;
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
	 * @param spropAproOfcCd
	 */
	public void setSpropAproOfcCd(String spropAproOfcCd) {
		this.spropAproOfcCd = spropAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spropMqcQty
	 */
	public void setSpropMqcQty(String spropMqcQty) {
		this.spropMqcQty = spropMqcQty;
	}
	
	/**
	 * Column Info
	 * @param spropStsCd
	 */
	public void setSpropStsCd(String spropStsCd) {
		this.spropStsCd = spropStsCd;
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
	 * @param sprcCtrtCustTpCd
	 */
	public void setSprcCtrtCustTpCd(String sprcCtrtCustTpCd) {
		this.sprcCtrtCustTpCd = sprcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param spropNo
	 */
	public void setSpropNo(String spropNo) {
		this.spropNo = spropNo;
	}
	
	/**
	 * Column Info
	 * @param smqcSignCd
	 */
	public void setSmqcSignCd(String smqcSignCd) {
		this.smqcSignCd = smqcSignCd;
	}
	
	/**
	 * Column Info
	 * @param scustCntCd
	 */
	public void setScustCntCd(String scustCntCd) {
		this.scustCntCd = scustCntCd;
	}
	
	/**
	 * Column Info
	 * @param scustSeq
	 */
	public void setScustSeq(String scustSeq) {
		this.scustSeq = scustSeq;
	}
	
	/**
	 * Column Info
	 * @param screDt1
	 */
	public void setScreDt1(String screDt1) {
		this.screDt1 = screDt1;
	}
	
	/**
	 * Column Info
	 * @param screDt2
	 */
	public void setScreDt2(String screDt2) {
		this.screDt2 = screDt2;
	}
	
	/**
	 * Column Info
	 * @param seffDt2
	 */
	public void setSeffDt2(String seffDt2) {
		this.seffDt2 = seffDt2;
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
		setSscNo(JSPUtil.getParameter(request, prefix + "ssc_no", ""));
		setSmqcSignNm(JSPUtil.getParameter(request, prefix + "smqc_sign_nm", ""));
		setSeffDt1(JSPUtil.getParameter(request, prefix + "seff_dt1", ""));
		setSscTypeCd(JSPUtil.getParameter(request, prefix + "ssc_type_cd", ""));
		setSpropOfcCd(JSPUtil.getParameter(request, prefix + "sprop_ofc_cd", ""));
		setSpropSrepCd(JSPUtil.getParameter(request, prefix + "sprop_srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpropAproOfcCd(JSPUtil.getParameter(request, prefix + "sprop_apro_ofc_cd", ""));
		setSpropMqcQty(JSPUtil.getParameter(request, prefix + "sprop_mqc_qty", ""));
		setSpropStsCd(JSPUtil.getParameter(request, prefix + "sprop_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSprcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "sprc_ctrt_cust_tp_cd", ""));
		setSpropNo(JSPUtil.getParameter(request, prefix + "sprop_no", ""));
		setSmqcSignCd(JSPUtil.getParameter(request, prefix + "smqc_sign_cd", ""));
		setScustCntCd(JSPUtil.getParameter(request, prefix + "scust_cnt_cd", ""));
		setScustSeq(JSPUtil.getParameter(request, prefix + "scust_seq", ""));
		setScreDt1(JSPUtil.getParameter(request, prefix + "scre_dt1", ""));
		setScreDt2(JSPUtil.getParameter(request, prefix + "scre_dt2", ""));
		setSeffDt2(JSPUtil.getParameter(request, prefix + "seff_dt2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstShInqVO[]
	 */
	public CstShInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstShInqVO[]
	 */
	public CstShInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstShInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sscNo = (JSPUtil.getParameter(request, prefix	+ "ssc_no", length));
			String[] smqcSignNm = (JSPUtil.getParameter(request, prefix	+ "smqc_sign_nm", length));
			String[] seffDt1 = (JSPUtil.getParameter(request, prefix	+ "seff_dt1", length));
			String[] sscTypeCd = (JSPUtil.getParameter(request, prefix	+ "ssc_type_cd", length));
			String[] spropOfcCd = (JSPUtil.getParameter(request, prefix	+ "sprop_ofc_cd", length));
			String[] spropSrepCd = (JSPUtil.getParameter(request, prefix	+ "sprop_srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spropAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "sprop_apro_ofc_cd", length));
			String[] spropMqcQty = (JSPUtil.getParameter(request, prefix	+ "sprop_mqc_qty", length));
			String[] spropStsCd = (JSPUtil.getParameter(request, prefix	+ "sprop_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sprcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "sprc_ctrt_cust_tp_cd", length));
			String[] spropNo = (JSPUtil.getParameter(request, prefix	+ "sprop_no", length));
			String[] smqcSignCd = (JSPUtil.getParameter(request, prefix	+ "smqc_sign_cd", length));
			String[] scustCntCd = (JSPUtil.getParameter(request, prefix	+ "scust_cnt_cd", length));
			String[] scustSeq = (JSPUtil.getParameter(request, prefix	+ "scust_seq", length));
			String[] screDt1 = (JSPUtil.getParameter(request, prefix	+ "scre_dt1", length));
			String[] screDt2 = (JSPUtil.getParameter(request, prefix	+ "scre_dt2", length));
			String[] seffDt2 = (JSPUtil.getParameter(request, prefix	+ "seff_dt2", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstShInqVO();
				if (sscNo[i] != null)
					model.setSscNo(sscNo[i]);
				if (smqcSignNm[i] != null)
					model.setSmqcSignNm(smqcSignNm[i]);
				if (seffDt1[i] != null)
					model.setSeffDt1(seffDt1[i]);
				if (sscTypeCd[i] != null)
					model.setSscTypeCd(sscTypeCd[i]);
				if (spropOfcCd[i] != null)
					model.setSpropOfcCd(spropOfcCd[i]);
				if (spropSrepCd[i] != null)
					model.setSpropSrepCd(spropSrepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spropAproOfcCd[i] != null)
					model.setSpropAproOfcCd(spropAproOfcCd[i]);
				if (spropMqcQty[i] != null)
					model.setSpropMqcQty(spropMqcQty[i]);
				if (spropStsCd[i] != null)
					model.setSpropStsCd(spropStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sprcCtrtCustTpCd[i] != null)
					model.setSprcCtrtCustTpCd(sprcCtrtCustTpCd[i]);
				if (spropNo[i] != null)
					model.setSpropNo(spropNo[i]);
				if (smqcSignCd[i] != null)
					model.setSmqcSignCd(smqcSignCd[i]);
				if (scustCntCd[i] != null)
					model.setScustCntCd(scustCntCd[i]);
				if (scustSeq[i] != null)
					model.setScustSeq(scustSeq[i]);
				if (screDt1[i] != null)
					model.setScreDt1(screDt1[i]);
				if (screDt2[i] != null)
					model.setScreDt2(screDt2[i]);
				if (seffDt2[i] != null)
					model.setSeffDt2(seffDt2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstShInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstShInqVO[]
	 */
	public CstShInqVO[] getCstShInqVOs(){
		CstShInqVO[] vos = (CstShInqVO[])models.toArray(new CstShInqVO[models.size()]);
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
		this.sscNo = this.sscNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smqcSignNm = this.smqcSignNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seffDt1 = this.seffDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sscTypeCd = this.sscTypeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropOfcCd = this.spropOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropSrepCd = this.spropSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropAproOfcCd = this.spropAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropMqcQty = this.spropMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropStsCd = this.spropStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprcCtrtCustTpCd = this.sprcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropNo = this.spropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smqcSignCd = this.smqcSignCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustCntCd = this.scustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustSeq = this.scustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.screDt1 = this.screDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.screDt2 = this.screDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seffDt2 = this.seffDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
