/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CllCdlCheckCondVO.java
*@FileTitle : CllCdlCheckCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.09
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CllCdlCheckCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CllCdlCheckCondVO> models = new ArrayList<CllCdlCheckCondVO>();

	/* Column Info */
	private String inCrIndateStart = null;
	/* Column Info */
	private String inListType = null;
	/* Column Info */
	private String inCrYard = null;
	/* Column Info */
	private String inCrVslname = null;
	/* Column Info */
	private String inCheckGubun = null;
	/* Column Info */
	private String inCntrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inCrEdateStart = null;
	/* Column Info */
	private String inCrIndateEnd = null;
	/* Column Info */
	private String inCrEdateEnd = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inCrCallsign = null;
	/* Column Info */
	private String inPodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CllCdlCheckCondVO() {}

	public CllCdlCheckCondVO(String ibflag, String pagerows, String inCrIndateStart, String inCrIndateEnd, String inListType, String inCrEdateStart, String inCrEdateEnd, String inCrYard, String inVvdCd, String inPolCd, String inPodCd, String inCrVslname, String inCrCallsign, String inCntrNo, String inCheckGubun) {
		this.inCrIndateStart = inCrIndateStart;
		this.inListType = inListType;
		this.inCrYard = inCrYard;
		this.inCrVslname = inCrVslname;
		this.inCheckGubun = inCheckGubun;
		this.inCntrNo = inCntrNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inCrEdateStart = inCrEdateStart;
		this.inCrIndateEnd = inCrIndateEnd;
		this.inCrEdateEnd = inCrEdateEnd;
		this.inPolCd = inPolCd;
		this.inVvdCd = inVvdCd;
		this.inCrCallsign = inCrCallsign;
		this.inPodCd = inPodCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_cr_indate_start", getInCrIndateStart());
		this.hashColumns.put("in_list_type", getInListType());
		this.hashColumns.put("in_cr_yard", getInCrYard());
		this.hashColumns.put("in_cr_vslname", getInCrVslname());
		this.hashColumns.put("in_check_gubun", getInCheckGubun());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_cr_edate_start", getInCrEdateStart());
		this.hashColumns.put("in_cr_indate_end", getInCrIndateEnd());
		this.hashColumns.put("in_cr_edate_end", getInCrEdateEnd());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_cr_callsign", getInCrCallsign());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_cr_indate_start", "inCrIndateStart");
		this.hashFields.put("in_list_type", "inListType");
		this.hashFields.put("in_cr_yard", "inCrYard");
		this.hashFields.put("in_cr_vslname", "inCrVslname");
		this.hashFields.put("in_check_gubun", "inCheckGubun");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_cr_edate_start", "inCrEdateStart");
		this.hashFields.put("in_cr_indate_end", "inCrIndateEnd");
		this.hashFields.put("in_cr_edate_end", "inCrEdateEnd");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_cr_callsign", "inCrCallsign");
		this.hashFields.put("in_pod_cd", "inPodCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inCrIndateStart
	 */
	public String getInCrIndateStart() {
		return this.inCrIndateStart;
	}

	/**
	 * Column Info
	 * @return inListType
	 */
	public String getInListType() {
		return this.inListType;
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
	 * Column Info
	 * @return inCheckGubun
	 */
	public String getInCheckGubun() {
		return this.inCheckGubun;
	}

	/**
	 * Column Info
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
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
	 * @return inCrEdateStart
	 */
	public String getInCrEdateStart() {
		return this.inCrEdateStart;
	}

	/**
	 * Column Info
	 * @return inCrIndateEnd
	 */
	public String getInCrIndateEnd() {
		return this.inCrIndateEnd;
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
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
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
	 * @return inCrCallsign
	 */
	public String getInCrCallsign() {
		return this.inCrCallsign;
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
	 * @param inCrIndateStart
	 */
	public void setInCrIndateStart(String inCrIndateStart) {
		this.inCrIndateStart = inCrIndateStart;
	}

	/**
	 * Column Info
	 * @param inListType
	 */
	public void setInListType(String inListType) {
		this.inListType = inListType;
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
	 * Column Info
	 * @param inCheckGubun
	 */
	public void setInCheckGubun(String inCheckGubun) {
		this.inCheckGubun = inCheckGubun;
	}

	/**
	 * Column Info
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
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
	 * @param inCrEdateStart
	 */
	public void setInCrEdateStart(String inCrEdateStart) {
		this.inCrEdateStart = inCrEdateStart;
	}

	/**
	 * Column Info
	 * @param inCrIndateEnd
	 */
	public void setInCrIndateEnd(String inCrIndateEnd) {
		this.inCrIndateEnd = inCrIndateEnd;
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
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
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
	 * @param inCrCallsign
	 */
	public void setInCrCallsign(String inCrCallsign) {
		this.inCrCallsign = inCrCallsign;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInCrIndateStart(JSPUtil.getParameter(request, "in_cr_indate_start", ""));
		setInListType(JSPUtil.getParameter(request, "in_list_type", ""));
		setInCrYard(JSPUtil.getParameter(request, "in_cr_yard", ""));
		setInCrVslname(JSPUtil.getParameter(request, "in_cr_vslname", ""));
		setInCheckGubun(JSPUtil.getParameter(request, "in_check_gubun", ""));
		setInCntrNo(JSPUtil.getParameter(request, "in_cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInCrEdateStart(JSPUtil.getParameter(request, "in_cr_edate_start", ""));
		setInCrIndateEnd(JSPUtil.getParameter(request, "in_cr_indate_end", ""));
		setInCrEdateEnd(JSPUtil.getParameter(request, "in_cr_edate_end", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		setInCrCallsign(JSPUtil.getParameter(request, "in_cr_callsign", ""));
		setInPodCd(JSPUtil.getParameter(request, "in_pod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllCdlCheckCondVO[]
	 */
	public CllCdlCheckCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CllCdlCheckCondVO[]
	 */
	public CllCdlCheckCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllCdlCheckCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inCrIndateStart = (JSPUtil.getParameter(request, prefix	+ "in_cr_indate_start", length));
			String[] inListType = (JSPUtil.getParameter(request, prefix	+ "in_list_type", length));
			String[] inCrYard = (JSPUtil.getParameter(request, prefix	+ "in_cr_yard", length));
			String[] inCrVslname = (JSPUtil.getParameter(request, prefix	+ "in_cr_vslname", length));
			String[] inCheckGubun = (JSPUtil.getParameter(request, prefix	+ "in_check_gubun", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inCrEdateStart = (JSPUtil.getParameter(request, prefix	+ "in_cr_edate_start", length));
			String[] inCrIndateEnd = (JSPUtil.getParameter(request, prefix	+ "in_cr_indate_end", length));
			String[] inCrEdateEnd = (JSPUtil.getParameter(request, prefix	+ "in_cr_edate_end", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inCrCallsign = (JSPUtil.getParameter(request, prefix	+ "in_cr_callsign", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));

			for (int i = 0; i < length; i++) {
				model = new CllCdlCheckCondVO();
				if (inCrIndateStart[i] != null)
					model.setInCrIndateStart(inCrIndateStart[i]);
				if (inListType[i] != null)
					model.setInListType(inListType[i]);
				if (inCrYard[i] != null)
					model.setInCrYard(inCrYard[i]);
				if (inCrVslname[i] != null)
					model.setInCrVslname(inCrVslname[i]);
				if (inCheckGubun[i] != null)
					model.setInCheckGubun(inCheckGubun[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inCrEdateStart[i] != null)
					model.setInCrEdateStart(inCrEdateStart[i]);
				if (inCrIndateEnd[i] != null)
					model.setInCrIndateEnd(inCrIndateEnd[i]);
				if (inCrEdateEnd[i] != null)
					model.setInCrEdateEnd(inCrEdateEnd[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inCrCallsign[i] != null)
					model.setInCrCallsign(inCrCallsign[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllCdlCheckCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllCdlCheckCondVO[]
	 */
	public CllCdlCheckCondVO[] getCllCdlCheckCondVOs(){
		CllCdlCheckCondVO[] vos = (CllCdlCheckCondVO[])models.toArray(new CllCdlCheckCondVO[models.size()]);
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
		this.inCrIndateStart = this.inCrIndateStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inListType = this.inListType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrYard = this.inCrYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrVslname = this.inCrVslname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCheckGubun = this.inCheckGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrEdateStart = this.inCrEdateStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrIndateEnd = this.inCrIndateEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrEdateEnd = this.inCrEdateEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCrCallsign = this.inCrCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
