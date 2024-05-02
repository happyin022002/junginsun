/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InPriTrfRuleDiffVO.java
*@FileTitle : InPriTrfRuleDiffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.11.03 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.tariff.tariffrule.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InPriTrfRuleDiffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InPriTrfRuleDiffVO> models = new ArrayList<InPriTrfRuleDiffVO>();
	
	/* Column Info */
	private String amdtSeq2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq1 = null;
	/* Column Info */
	private String trfNo = null;
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
	
	public InPriTrfRuleDiffVO() {}

	public InPriTrfRuleDiffVO(String ibflag, String pagerows, String trfPfxCd, String trfNo, String trfRuleNo, String amdtSeq1, String amdtSeq2) {
		this.amdtSeq2 = amdtSeq2;
		this.ibflag = ibflag;
		this.amdtSeq1 = amdtSeq1;
		this.trfNo = trfNo;
		this.trfRuleNo = trfRuleNo;
		this.trfPfxCd = trfPfxCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq2", getAmdtSeq2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq1", getAmdtSeq1());
		this.hashColumns.put("trf_no", getTrfNo());
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
		this.hashFields.put("amdt_seq2", "amdtSeq2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq1", "amdtSeq1");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("trf_rule_no", "trfRuleNo");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq2
	 */
	public String getAmdtSeq2() {
		return this.amdtSeq2;
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
	 * @return amdtSeq1
	 */
	public String getAmdtSeq1() {
		return this.amdtSeq1;
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
	 * Column Info
	 * @param amdtSeq2
	 */
	public void setAmdtSeq2(String amdtSeq2) {
		this.amdtSeq2 = amdtSeq2;
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
	 * @param amdtSeq1
	 */
	public void setAmdtSeq1(String amdtSeq1) {
		this.amdtSeq1 = amdtSeq1;
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
		setAmdtSeq2(JSPUtil.getParameter(request, prefix + "amdt_seq2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmdtSeq1(JSPUtil.getParameter(request, prefix + "amdt_seq1", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setTrfRuleNo(JSPUtil.getParameter(request, prefix + "trf_rule_no", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InPriTrfRuleDiffVO[]
	 */
	public InPriTrfRuleDiffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InPriTrfRuleDiffVO[]
	 */
	public InPriTrfRuleDiffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InPriTrfRuleDiffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq2 = (JSPUtil.getParameter(request, prefix	+ "amdt_seq2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtSeq1 = (JSPUtil.getParameter(request, prefix	+ "amdt_seq1", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] trfRuleNo = (JSPUtil.getParameter(request, prefix	+ "trf_rule_no", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InPriTrfRuleDiffVO();
				if (amdtSeq2[i] != null)
					model.setAmdtSeq2(amdtSeq2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq1[i] != null)
					model.setAmdtSeq1(amdtSeq1[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
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
		return getInPriTrfRuleDiffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InPriTrfRuleDiffVO[]
	 */
	public InPriTrfRuleDiffVO[] getInPriTrfRuleDiffVOs(){
		InPriTrfRuleDiffVO[] vos = (InPriTrfRuleDiffVO[])models.toArray(new InPriTrfRuleDiffVO[models.size()]);
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
		this.amdtSeq2 = this.amdtSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq1 = this.amdtSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRuleNo = this.trfRuleNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
