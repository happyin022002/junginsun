/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChinaInfoForLaneVO.java
*@FileTitle : ChinaInfoForLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.15 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo;

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

public class ChinaInfoForLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaInfoForLaneVO> models = new ArrayList<ChinaInfoForLaneVO>();

	/* Column Info */
	private String orgAgnCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String vndrDeltFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String agnArOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String orgSlanCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String orgPodCd = null;
	/* Column Info */
	private String orgVndrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaInfoForLaneVO() {}

	public ChinaInfoForLaneVO(String ibflag, String pagerows, String podCd, String slanCd, String agnCd, String vndrSeq, String vndrLglEngNm, String agnArOfcCd, String deltFlg, String vndrDeltFlg, String usrId, String orgPodCd, String orgSlanCd, String orgAgnCd, String orgVndrSeq) {
		this.orgAgnCd = orgAgnCd;
		this.deltFlg = deltFlg;
		this.vndrLglEngNm = vndrLglEngNm;
		this.vndrDeltFlg = vndrDeltFlg;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.agnCd = agnCd;
		this.agnArOfcCd = agnArOfcCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.orgSlanCd = orgSlanCd;
		this.usrId = usrId;
		this.vndrSeq = vndrSeq;
		this.orgPodCd = orgPodCd;
		this.orgVndrSeq = orgVndrSeq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_agn_cd", getOrgAgnCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("vndr_delt_flg", getVndrDeltFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("agn_ar_ofc_cd", getAgnArOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("org_slan_cd", getOrgSlanCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("org_pod_cd", getOrgPodCd());
		this.hashColumns.put("org_vndr_seq", getOrgVndrSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_agn_cd", "orgAgnCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("vndr_delt_flg", "vndrDeltFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("agn_ar_ofc_cd", "agnArOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("org_slan_cd", "orgSlanCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("org_pod_cd", "orgPodCd");
		this.hashFields.put("org_vndr_seq", "orgVndrSeq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return orgAgnCd
	 */
	public String getOrgAgnCd() {
		return this.orgAgnCd;
	}

	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}

	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @return vndrDeltFlg
	 */
	public String getVndrDeltFlg() {
		return this.vndrDeltFlg;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}

	/**
	 * Column Info
	 * @return agnArOfcCd
	 */
	public String getAgnArOfcCd() {
		return this.agnArOfcCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}

	/**
	 * Column Info
	 * @return orgSlanCd
	 */
	public String getOrgSlanCd() {
		return this.orgSlanCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}

	/**
	 * Column Info
	 * @return orgPodCd
	 */
	public String getOrgPodCd() {
		return this.orgPodCd;
	}

	/**
	 * Column Info
	 * @return orgVndrSeq
	 */
	public String getOrgVndrSeq() {
		return this.orgVndrSeq;
	}


	/**
	 * Column Info
	 * @param orgAgnCd
	 */
	public void setOrgAgnCd(String orgAgnCd) {
		this.orgAgnCd = orgAgnCd;
	}

	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @param vndrDeltFlg
	 */
	public void setVndrDeltFlg(String vndrDeltFlg) {
		this.vndrDeltFlg = vndrDeltFlg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}

	/**
	 * Column Info
	 * @param agnArOfcCd
	 */
	public void setAgnArOfcCd(String agnArOfcCd) {
		this.agnArOfcCd = agnArOfcCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	/**
	 * Column Info
	 * @param orgSlanCd
	 */
	public void setOrgSlanCd(String orgSlanCd) {
		this.orgSlanCd = orgSlanCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	/**
	 * Column Info
	 * @param orgPodCd
	 */
	public void setOrgPodCd(String orgPodCd) {
		this.orgPodCd = orgPodCd;
	}

	/**
	 * Column Info
	 * @param orgVndrSeq
	 */
	public void setOrgVndrSeq(String orgVndrSeq) {
		this.orgVndrSeq = orgVndrSeq;
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
		setOrgAgnCd(JSPUtil.getParameter(request, prefix + "org_agn_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setVndrDeltFlg(JSPUtil.getParameter(request, prefix + "vndr_delt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setAgnArOfcCd(JSPUtil.getParameter(request, prefix + "agn_ar_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setOrgSlanCd(JSPUtil.getParameter(request, prefix + "org_slan_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setOrgPodCd(JSPUtil.getParameter(request, prefix + "org_pod_cd", ""));
		setOrgVndrSeq(JSPUtil.getParameter(request, prefix + "org_vndr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaInfoForLaneVO[]
	 */
	public ChinaInfoForLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaInfoForLaneVO[]
	 */
	public ChinaInfoForLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaInfoForLaneVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] orgAgnCd = (JSPUtil.getParameter(request, prefix	+ "org_agn_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] vndrDeltFlg = (JSPUtil.getParameter(request, prefix	+ "vndr_delt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] agnArOfcCd = (JSPUtil.getParameter(request, prefix	+ "agn_ar_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] orgSlanCd = (JSPUtil.getParameter(request, prefix	+ "org_slan_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] orgPodCd = (JSPUtil.getParameter(request, prefix	+ "org_pod_cd", length));
			String[] orgVndrSeq = (JSPUtil.getParameter(request, prefix	+ "org_vndr_seq", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaInfoForLaneVO();
				if (orgAgnCd[i] != null)
					model.setOrgAgnCd(orgAgnCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (vndrDeltFlg[i] != null)
					model.setVndrDeltFlg(vndrDeltFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (agnArOfcCd[i] != null)
					model.setAgnArOfcCd(agnArOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (orgSlanCd[i] != null)
					model.setOrgSlanCd(orgSlanCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (orgPodCd[i] != null)
					model.setOrgPodCd(orgPodCd[i]);
				if (orgVndrSeq[i] != null)
					model.setOrgVndrSeq(orgVndrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaInfoForLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaInfoForLaneVO[]
	 */
	public ChinaInfoForLaneVO[] getChinaInfoForLaneVOs(){
		ChinaInfoForLaneVO[] vos = (ChinaInfoForLaneVO[])models.toArray(new ChinaInfoForLaneVO[models.size()]);
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
		this.orgAgnCd = this.orgAgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrDeltFlg = this.vndrDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnArOfcCd = this.agnArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlanCd = this.orgSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPodCd = this.orgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrSeq = this.orgVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
