/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SqlNameVO.java
*@FileTitle : SqlNameVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2010.02.04 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SqlNameVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SqlNameVO> models = new ArrayList<SqlNameVO>();
	
	/* Column Info */
	private String formBkgNo = null;
	/* Column Info */
	private String inSpecialFlag = null;
	/* Column Info */
	private String inCrYard = null;
	/* Column Info */
	private String inCrVslname = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inCntrNo = null;
	/* Column Info */
	private String inCheckGubun = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inCrEdateStart = null;
	/* Column Info */
	private String inCrEdateEnd = null;
	/* Column Info */
	private String formTermPol = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inDcgoSeq = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String formHjsVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SqlNameVO() {}

	public SqlNameVO(String ibflag, String pagerows, String formHjsVvd, String inCntrNo, String inCrYard, String inCrVslname, String inCheckGubun, String formBkgNo, String inCrEdateStart, String inDcgoSeq, String inCrEdateEnd, String formTermPol, String inVvdCd, String inSpecialFlag, String inPodCd) {
		this.formBkgNo = formBkgNo;
		this.inSpecialFlag = inSpecialFlag;
		this.inCrYard = inCrYard;
		this.inCrVslname = inCrVslname;
		this.pagerows = pagerows;
		this.inCntrNo = inCntrNo;
		this.inCheckGubun = inCheckGubun;
		this.ibflag = ibflag;
		this.inCrEdateStart = inCrEdateStart;
		this.inCrEdateEnd = inCrEdateEnd;
		this.formTermPol = formTermPol;
		this.inVvdCd = inVvdCd;
		this.inDcgoSeq = inDcgoSeq;
		this.inPodCd = inPodCd;
		this.formHjsVvd = formHjsVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("form_bkg_no", getFormBkgNo());
		this.hashColumns.put("in_special_flag", getInSpecialFlag());
		this.hashColumns.put("in_cr_yard", getInCrYard());
		this.hashColumns.put("in_cr_vslname", getInCrVslname());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("in_check_gubun", getInCheckGubun());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_cr_edate_start", getInCrEdateStart());
		this.hashColumns.put("in_cr_edate_end", getInCrEdateEnd());
		this.hashColumns.put("form_term_pol", getFormTermPol());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_dcgo_seq", getInDcgoSeq());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("form_hjs_vvd", getFormHjsVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("form_bkg_no", "formBkgNo");
		this.hashFields.put("in_special_flag", "inSpecialFlag");
		this.hashFields.put("in_cr_yard", "inCrYard");
		this.hashFields.put("in_cr_vslname", "inCrVslname");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("in_check_gubun", "inCheckGubun");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_cr_edate_start", "inCrEdateStart");
		this.hashFields.put("in_cr_edate_end", "inCrEdateEnd");
		this.hashFields.put("form_term_pol", "formTermPol");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_dcgo_seq", "inDcgoSeq");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("form_hjs_vvd", "formHjsVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return formBkgNo
	 */
	public String getFormBkgNo() {
		return this.formBkgNo;
	}
	
	/**
	 * Column Info
	 * @return inSpecialFlag
	 */
	public String getInSpecialFlag() {
		return this.inSpecialFlag;
	}
	
	/**
	 * Column Info
	 * @return inCrYard
	 */
	public String getInCrYard() {
		return this.inCrYard;
	}
	
	/**
	 * Column Info
	 * @return inCrVslname
	 */
	public String getInCrVslname() {
		return this.inCrVslname;
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
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
	}
	
	/**
	 * Column Info
	 * @return inCheckGubun
	 */
	public String getInCheckGubun() {
		return this.inCheckGubun;
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
	 * @return inCrEdateStart
	 */
	public String getInCrEdateStart() {
		return this.inCrEdateStart;
	}
	
	/**
	 * Column Info
	 * @return inCrEdateEnd
	 */
	public String getInCrEdateEnd() {
		return this.inCrEdateEnd;
	}
	
	/**
	 * Column Info
	 * @return formTermPol
	 */
	public String getFormTermPol() {
		return this.formTermPol;
	}
	
	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}
	
	/**
	 * Column Info
	 * @return inDcgoSeq
	 */
	public String getInDcgoSeq() {
		return this.inDcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}
	
	/**
	 * Column Info
	 * @return formHjsVvd
	 */
	public String getFormHjsVvd() {
		return this.formHjsVvd;
	}
	

	/**
	 * Column Info
	 * @param formBkgNo
	 */
	public void setFormBkgNo(String formBkgNo) {
		this.formBkgNo = formBkgNo;
	}
	
	/**
	 * Column Info
	 * @param inSpecialFlag
	 */
	public void setInSpecialFlag(String inSpecialFlag) {
		this.inSpecialFlag = inSpecialFlag;
	}
	
	/**
	 * Column Info
	 * @param inCrYard
	 */
	public void setInCrYard(String inCrYard) {
		this.inCrYard = inCrYard;
	}
	
	/**
	 * Column Info
	 * @param inCrVslname
	 */
	public void setInCrVslname(String inCrVslname) {
		this.inCrVslname = inCrVslname;
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
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
	}
	
	/**
	 * Column Info
	 * @param inCheckGubun
	 */
	public void setInCheckGubun(String inCheckGubun) {
		this.inCheckGubun = inCheckGubun;
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
	 * @param inCrEdateStart
	 */
	public void setInCrEdateStart(String inCrEdateStart) {
		this.inCrEdateStart = inCrEdateStart;
	}
	
	/**
	 * Column Info
	 * @param inCrEdateEnd
	 */
	public void setInCrEdateEnd(String inCrEdateEnd) {
		this.inCrEdateEnd = inCrEdateEnd;
	}
	
	/**
	 * Column Info
	 * @param formTermPol
	 */
	public void setFormTermPol(String formTermPol) {
		this.formTermPol = formTermPol;
	}
	
	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}
	
	/**
	 * Column Info
	 * @param inDcgoSeq
	 */
	public void setInDcgoSeq(String inDcgoSeq) {
		this.inDcgoSeq = inDcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}
	
	/**
	 * Column Info
	 * @param formHjsVvd
	 */
	public void setFormHjsVvd(String formHjsVvd) {
		this.formHjsVvd = formHjsVvd;
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
		setFormBkgNo(JSPUtil.getParameter(request, prefix + "form_bkg_no", ""));
		setInSpecialFlag(JSPUtil.getParameter(request, prefix + "in_special_flag", ""));
		setInCrYard(JSPUtil.getParameter(request, prefix + "in_cr_yard", ""));
		setInCrVslname(JSPUtil.getParameter(request, prefix + "in_cr_vslname", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInCntrNo(JSPUtil.getParameter(request, prefix + "in_cntr_no", ""));
		setInCheckGubun(JSPUtil.getParameter(request, prefix + "in_check_gubun", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInCrEdateStart(JSPUtil.getParameter(request, prefix + "in_cr_edate_start", ""));
		setInCrEdateEnd(JSPUtil.getParameter(request, prefix + "in_cr_edate_end", ""));
		setFormTermPol(JSPUtil.getParameter(request, prefix + "form_term_pol", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setInDcgoSeq(JSPUtil.getParameter(request, prefix + "in_dcgo_seq", ""));
		setInPodCd(JSPUtil.getParameter(request, prefix + "in_pod_cd", ""));
		setFormHjsVvd(JSPUtil.getParameter(request, prefix + "form_hjs_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SqlNameVO[]
	 */
	public SqlNameVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SqlNameVO[]
	 */
	public SqlNameVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SqlNameVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] formBkgNo = (JSPUtil.getParameter(request, prefix	+ "form_bkg_no", length));
			String[] inSpecialFlag = (JSPUtil.getParameter(request, prefix	+ "in_special_flag", length));
			String[] inCrYard = (JSPUtil.getParameter(request, prefix	+ "in_cr_yard", length));
			String[] inCrVslname = (JSPUtil.getParameter(request, prefix	+ "in_cr_vslname", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] inCheckGubun = (JSPUtil.getParameter(request, prefix	+ "in_check_gubun", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inCrEdateStart = (JSPUtil.getParameter(request, prefix	+ "in_cr_edate_start", length));
			String[] inCrEdateEnd = (JSPUtil.getParameter(request, prefix	+ "in_cr_edate_end", length));
			String[] formTermPol = (JSPUtil.getParameter(request, prefix	+ "form_term_pol", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inDcgoSeq = (JSPUtil.getParameter(request, prefix	+ "in_dcgo_seq", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] formHjsVvd = (JSPUtil.getParameter(request, prefix	+ "form_hjs_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SqlNameVO();
				if (formBkgNo[i] != null)
					model.setFormBkgNo(formBkgNo[i]);
				if (inSpecialFlag[i] != null)
					model.setInSpecialFlag(inSpecialFlag[i]);
				if (inCrYard[i] != null)
					model.setInCrYard(inCrYard[i]);
				if (inCrVslname[i] != null)
					model.setInCrVslname(inCrVslname[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (inCheckGubun[i] != null)
					model.setInCheckGubun(inCheckGubun[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inCrEdateStart[i] != null)
					model.setInCrEdateStart(inCrEdateStart[i]);
				if (inCrEdateEnd[i] != null)
					model.setInCrEdateEnd(inCrEdateEnd[i]);
				if (formTermPol[i] != null)
					model.setFormTermPol(formTermPol[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inDcgoSeq[i] != null)
					model.setInDcgoSeq(inDcgoSeq[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (formHjsVvd[i] != null)
					model.setFormHjsVvd(formHjsVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSqlNameVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SqlNameVO[]
	 */
	public SqlNameVO[] getSqlNameVOs(){
		SqlNameVO[] vos = (SqlNameVO[])models.toArray(new SqlNameVO[models.size()]);
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
		this.formBkgNo = this.formBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSpecialFlag = this.inSpecialFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrYard = this.inCrYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrVslname = this.inCrVslname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCheckGubun = this.inCheckGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrEdateStart = this.inCrEdateStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrEdateEnd = this.inCrEdateEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formTermPol = this.formTermPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDcgoSeq = this.inDcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formHjsVvd = this.formHjsVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
