/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChargeDdtSetVO.java
*@FileTitle : ChargeDdtSetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.25 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeDdtSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChargeDdtSetVO> models = new ArrayList<ChargeDdtSetVO>();

	/* Column Info */
	private String orgChgDdctGrpNm = null;
	/* Column Info */
	private String repChgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String chgDivCd = null;
	/* Column Info */
	private String orgChgCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String chgDdctGrpNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChargeDdtSetVO() {}

	public ChargeDdtSetVO(String ibflag, String pagerows, String chgDdctGrpNm, String repChgCd, String chgCd, String chgNm, String chgDivCd, String orgChgCd, String orgChgDdctGrpNm, String usrId) {
		this.orgChgDdctGrpNm = orgChgDdctGrpNm;
		this.repChgCd = repChgCd;
		this.ibflag = ibflag;
		this.chgNm = chgNm;
		this.usrId = usrId;
		this.chgDivCd = chgDivCd;
		this.orgChgCd = orgChgCd;
		this.chgCd = chgCd;
		this.chgDdctGrpNm = chgDdctGrpNm;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_chg_ddct_grp_nm", getOrgChgDdctGrpNm());
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("chg_div_cd", getChgDivCd());
		this.hashColumns.put("org_chg_cd", getOrgChgCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("chg_ddct_grp_nm", getChgDdctGrpNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_chg_ddct_grp_nm", "orgChgDdctGrpNm");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("chg_div_cd", "chgDivCd");
		this.hashFields.put("org_chg_cd", "orgChgCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("chg_ddct_grp_nm", "chgDdctGrpNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return orgChgDdctGrpNm
	 */
	public String getOrgChgDdctGrpNm() {
		return this.orgChgDdctGrpNm;
	}

	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
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
	 * @return chgNm
	 */
	public String getChgNm() {
		return this.chgNm;
	}

	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}

	/**
	 * Column Info
	 * @return chgDivCd
	 */
	public String getChgDivCd() {
		return this.chgDivCd;
	}

	/**
	 * Column Info
	 * @return orgChgCd
	 */
	public String getOrgChgCd() {
		return this.orgChgCd;
	}

	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}

	/**
	 * Column Info
	 * @return chgDdctGrpNm
	 */
	public String getChgDdctGrpNm() {
		return this.chgDdctGrpNm;
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
	 * @param orgChgDdctGrpNm
	 */
	public void setOrgChgDdctGrpNm(String orgChgDdctGrpNm) {
		this.orgChgDdctGrpNm = orgChgDdctGrpNm;
	}

	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
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
	 * @param chgNm
	 */
	public void setChgNm(String chgNm) {
		this.chgNm = chgNm;
	}

	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Column Info
	 * @param chgDivCd
	 */
	public void setChgDivCd(String chgDivCd) {
		this.chgDivCd = chgDivCd;
	}

	/**
	 * Column Info
	 * @param orgChgCd
	 */
	public void setOrgChgCd(String orgChgCd) {
		this.orgChgCd = orgChgCd;
	}

	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}

	/**
	 * Column Info
	 * @param chgDdctGrpNm
	 */
	public void setChgDdctGrpNm(String chgDdctGrpNm) {
		this.chgDdctGrpNm = chgDdctGrpNm;
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
		setOrgChgDdctGrpNm(JSPUtil.getParameter(request, prefix + "org_chg_ddct_grp_nm", ""));
		setRepChgCd(JSPUtil.getParameter(request, prefix + "rep_chg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChgNm(JSPUtil.getParameter(request, prefix + "chg_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setChgDivCd(JSPUtil.getParameter(request, prefix + "chg_div_cd", ""));
		setOrgChgCd(JSPUtil.getParameter(request, prefix + "org_chg_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setChgDdctGrpNm(JSPUtil.getParameter(request, prefix + "chg_ddct_grp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeDdtSetVO[]
	 */
	public ChargeDdtSetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChargeDdtSetVO[]
	 */
	public ChargeDdtSetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeDdtSetVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] orgChgDdctGrpNm = (JSPUtil.getParameter(request, prefix	+ "org_chg_ddct_grp_nm", length));
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] chgDivCd = (JSPUtil.getParameter(request, prefix	+ "chg_div_cd", length));
			String[] orgChgCd = (JSPUtil.getParameter(request, prefix	+ "org_chg_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] chgDdctGrpNm = (JSPUtil.getParameter(request, prefix	+ "chg_ddct_grp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ChargeDdtSetVO();
				if (orgChgDdctGrpNm[i] != null)
					model.setOrgChgDdctGrpNm(orgChgDdctGrpNm[i]);
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (chgDivCd[i] != null)
					model.setChgDivCd(chgDivCd[i]);
				if (orgChgCd[i] != null)
					model.setOrgChgCd(orgChgCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (chgDdctGrpNm[i] != null)
					model.setChgDdctGrpNm(chgDdctGrpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeDdtSetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeDdtSetVO[]
	 */
	public ChargeDdtSetVO[] getChargeDdtSetVOs(){
		ChargeDdtSetVO[] vos = (ChargeDdtSetVO[])models.toArray(new ChargeDdtSetVO[models.size()]);
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
		this.orgChgDdctGrpNm = this.orgChgDdctGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDivCd = this.chgDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgChgCd = this.orgChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDdctGrpNm = this.chgDdctGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
