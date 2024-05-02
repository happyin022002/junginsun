/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GemCsrRequestBodyVO.java
*@FileTitle : GemCsrRequestBodyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo;

import java.lang.reflect.Field;
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

public class GemCsrRequestBodyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemCsrRequestBodyVO> models = new ArrayList<GemCsrRequestBodyVO>();
	
	/* Column Info */
	private String invUsdAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subsCsrSeq = null;
	/* Column Info */
	private String genExpnNm = null;
	/* Column Info */
	private String subsCsrNo = null;
	/* Column Info */
	private String invLoclAmt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String invSlpDesc = null;
	/* Column Info */
	private String subsOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GemCsrRequestBodyVO() {}

	public GemCsrRequestBodyVO(String ibflag, String pagerows, String subsCsrNo, String subsOfcCd, String subsCsrSeq, String genExpnCd, String genExpnNm, String invLoclAmt, String invUsdAmt, String invSlpDesc) {
		this.invUsdAmt = invUsdAmt;
		this.ibflag = ibflag;
		this.subsCsrSeq = subsCsrSeq;
		this.genExpnNm = genExpnNm;
		this.subsCsrNo = subsCsrNo;
		this.invLoclAmt = invLoclAmt;
		this.genExpnCd = genExpnCd;
		this.invSlpDesc = invSlpDesc;
		this.subsOfcCd = subsOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("subs_csr_seq", getSubsCsrSeq());
		this.hashColumns.put("gen_expn_nm", getGenExpnNm());
		this.hashColumns.put("subs_csr_no", getSubsCsrNo());
		this.hashColumns.put("inv_locl_amt", getInvLoclAmt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("inv_slp_desc", getInvSlpDesc());
		this.hashColumns.put("subs_ofc_cd", getSubsOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("subs_csr_seq", "subsCsrSeq");
		this.hashFields.put("gen_expn_nm", "genExpnNm");
		this.hashFields.put("subs_csr_no", "subsCsrNo");
		this.hashFields.put("inv_locl_amt", "invLoclAmt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("inv_slp_desc", "invSlpDesc");
		this.hashFields.put("subs_ofc_cd", "subsOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
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
	 * @return subsCsrSeq
	 */
	public String getSubsCsrSeq() {
		return this.subsCsrSeq;
	}
	
	/**
	 * Column Info
	 * @return genExpnNm
	 */
	public String getGenExpnNm() {
		return this.genExpnNm;
	}
	
	/**
	 * Column Info
	 * @return subsCsrNo
	 */
	public String getSubsCsrNo() {
		return this.subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @return invLoclAmt
	 */
	public String getInvLoclAmt() {
		return this.invLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return invSlpDesc
	 */
	public String getInvSlpDesc() {
		return this.invSlpDesc;
	}
	
	/**
	 * Column Info
	 * @return subsOfcCd
	 */
	public String getSubsOfcCd() {
		return this.subsOfcCd;
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
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
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
	 * @param subsCsrSeq
	 */
	public void setSubsCsrSeq(String subsCsrSeq) {
		this.subsCsrSeq = subsCsrSeq;
	}
	
	/**
	 * Column Info
	 * @param genExpnNm
	 */
	public void setGenExpnNm(String genExpnNm) {
		this.genExpnNm = genExpnNm;
	}
	
	/**
	 * Column Info
	 * @param subsCsrNo
	 */
	public void setSubsCsrNo(String subsCsrNo) {
		this.subsCsrNo = subsCsrNo;
	}
	
	/**
	 * Column Info
	 * @param invLoclAmt
	 */
	public void setInvLoclAmt(String invLoclAmt) {
		this.invLoclAmt = invLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param invSlpDesc
	 */
	public void setInvSlpDesc(String invSlpDesc) {
		this.invSlpDesc = invSlpDesc;
	}
	
	/**
	 * Column Info
	 * @param subsOfcCd
	 */
	public void setSubsOfcCd(String subsOfcCd) {
		this.subsOfcCd = subsOfcCd;
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
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubsCsrSeq(JSPUtil.getParameter(request, prefix + "subs_csr_seq", ""));
		setGenExpnNm(JSPUtil.getParameter(request, prefix + "gen_expn_nm", ""));
		setSubsCsrNo(JSPUtil.getParameter(request, prefix + "subs_csr_no", ""));
		setInvLoclAmt(JSPUtil.getParameter(request, prefix + "inv_locl_amt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, prefix + "gen_expn_cd", ""));
		setInvSlpDesc(JSPUtil.getParameter(request, prefix + "inv_slp_desc", ""));
		setSubsOfcCd(JSPUtil.getParameter(request, prefix + "subs_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemCsrRequestBodyVO[]
	 */
	public GemCsrRequestBodyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemCsrRequestBodyVO[]
	 */
	public GemCsrRequestBodyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemCsrRequestBodyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subsCsrSeq = (JSPUtil.getParameter(request, prefix	+ "subs_csr_seq", length));
			String[] genExpnNm = (JSPUtil.getParameter(request, prefix	+ "gen_expn_nm", length));
			String[] subsCsrNo = (JSPUtil.getParameter(request, prefix	+ "subs_csr_no", length));
			String[] invLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_locl_amt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] invSlpDesc = (JSPUtil.getParameter(request, prefix	+ "inv_slp_desc", length));
			String[] subsOfcCd = (JSPUtil.getParameter(request, prefix	+ "subs_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemCsrRequestBodyVO();
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subsCsrSeq[i] != null)
					model.setSubsCsrSeq(subsCsrSeq[i]);
				if (genExpnNm[i] != null)
					model.setGenExpnNm(genExpnNm[i]);
				if (subsCsrNo[i] != null)
					model.setSubsCsrNo(subsCsrNo[i]);
				if (invLoclAmt[i] != null)
					model.setInvLoclAmt(invLoclAmt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (invSlpDesc[i] != null)
					model.setInvSlpDesc(invSlpDesc[i]);
				if (subsOfcCd[i] != null)
					model.setSubsOfcCd(subsOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemCsrRequestBodyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemCsrRequestBodyVO[]
	 */
	public GemCsrRequestBodyVO[] getGemCsrRequestBodyVOs(){
		GemCsrRequestBodyVO[] vos = (GemCsrRequestBodyVO[])models.toArray(new GemCsrRequestBodyVO[models.size()]);
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
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrSeq = this.subsCsrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnNm = this.genExpnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCsrNo = this.subsCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclAmt = this.invLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSlpDesc = this.invSlpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsOfcCd = this.subsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
