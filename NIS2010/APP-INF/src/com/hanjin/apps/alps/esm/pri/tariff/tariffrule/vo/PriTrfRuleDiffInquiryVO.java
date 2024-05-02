/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PriTrfRuleDiffInquiryVO.java
*@FileTitle : PriTrfRuleDiffInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.11.03 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriTrfRuleDiffInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriTrfRuleDiffInquiryVO> models = new ArrayList<PriTrfRuleDiffInquiryVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String trfRuleNm = null;
	/* Column Info */
	private String trfRuleCtnt = null;
	/* Column Info */
	private String trfRuleNo = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriTrfRuleDiffInquiryVO() {}

	public PriTrfRuleDiffInquiryVO(String ibflag, String pagerows, String trfPfxCd, String trfNo, String trfRuleNo, String amdtSeq, String trfRuleNm, String trfRuleCtnt) {
		this.ibflag = ibflag;
		this.amdtSeq = amdtSeq;
		this.trfNo = trfNo;
		this.trfRuleNm = trfRuleNm;
		this.trfRuleCtnt = trfRuleCtnt;
		this.trfRuleNo = trfRuleNo;
		this.trfPfxCd = trfPfxCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("trf_rule_nm", getTrfRuleNm());
		this.hashColumns.put("trf_rule_ctnt", getTrfRuleCtnt());
		this.hashColumns.put("trf_rule_no", getTrfRuleNo());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("trf_rule_nm", "trfRuleNm");
		this.hashFields.put("trf_rule_ctnt", "trfRuleCtnt");
		this.hashFields.put("trf_rule_no", "trfRuleNo");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return trfRuleNm
	 */
	public String getTrfRuleNm() {
		return this.trfRuleNm;
	}
	
	/**
	 * Column Info
	 * @return trfRuleCtnt
	 */
	public String getTrfRuleCtnt() {
		return this.trfRuleCtnt;
	}
	
	/**
	 * Column Info
	 * @return trfRuleNo
	 */
	public String getTrfRuleNo() {
		return this.trfRuleNo;
	}
	
	/**
	 * Column Info
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param trfRuleNm
	 */
	public void setTrfRuleNm(String trfRuleNm) {
		this.trfRuleNm = trfRuleNm;
	}
	
	/**
	 * Column Info
	 * @param trfRuleCtnt
	 */
	public void setTrfRuleCtnt(String trfRuleCtnt) {
		this.trfRuleCtnt = trfRuleCtnt;
	}
	
	/**
	 * Column Info
	 * @param trfRuleNo
	 */
	public void setTrfRuleNo(String trfRuleNo) {
		this.trfRuleNo = trfRuleNo;
	}
	
	/**
	 * Column Info
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setTrfRuleNm(JSPUtil.getParameter(request, prefix + "trf_rule_nm", ""));
		setTrfRuleCtnt(JSPUtil.getParameter(request, prefix + "trf_rule_ctnt", ""));
		setTrfRuleNo(JSPUtil.getParameter(request, prefix + "trf_rule_no", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriTrfRuleDiffInquiryVO[]
	 */
	public PriTrfRuleDiffInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriTrfRuleDiffInquiryVO[]
	 */
	public PriTrfRuleDiffInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriTrfRuleDiffInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] trfRuleNm = (JSPUtil.getParameter(request, prefix	+ "trf_rule_nm", length));
			String[] trfRuleCtnt = (JSPUtil.getParameter(request, prefix	+ "trf_rule_ctnt", length));
			String[] trfRuleNo = (JSPUtil.getParameter(request, prefix	+ "trf_rule_no", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriTrfRuleDiffInquiryVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (trfRuleNm[i] != null)
					model.setTrfRuleNm(trfRuleNm[i]);
				if (trfRuleCtnt[i] != null)
					model.setTrfRuleCtnt(trfRuleCtnt[i]);
				if (trfRuleNo[i] != null)
					model.setTrfRuleNo(trfRuleNo[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriTrfRuleDiffInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriTrfRuleDiffInquiryVO[]
	 */
	public PriTrfRuleDiffInquiryVO[] getPriTrfRuleDiffInquiryVOs(){
		PriTrfRuleDiffInquiryVO[] vos = (PriTrfRuleDiffInquiryVO[])models.toArray(new PriTrfRuleDiffInquiryVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleNm = this.trfRuleNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleCtnt = this.trfRuleCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleNo = this.trfRuleNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
