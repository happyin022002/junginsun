/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchOfficHierarchyVO.java
*@FileTitle : SearchOfficHierarchyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.04.05 채창호 
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOfficHierarchyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficHierarchyVO> models = new ArrayList<SearchOfficHierarchyVO>();
	
	/* Column Info */
	private String subBb = null;
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String ofcLvl = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String bbAa = null;
	/* Column Info */
	private String bbAa3 = null;
	/* Column Info */
	private String bbAa4 = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String ho = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String statusCd = null;
	/* Column Info */
	private String ofcCodeCd = null;
	/* Column Info */
	private String ofcKindCd = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOfficHierarchyVO() {}

	public SearchOfficHierarchyVO(String ibflag, String pagerows, String ofcKndCd, String ofcCd, String ofcLvl, String ho, String rhq, String bbAa, String subBb, String ofcEngNm, String status, String ofcKindCd, String ofcCodeCd, String statusCd, String bbAa3, String bbAa4, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.subBb = subBb;
		this.ofcKndCd = ofcKndCd;
		this.ofcLvl = ofcLvl;
		this.status = status;
		this.bbAa = bbAa;
		this.ofcEngNm = ofcEngNm;
		this.ho = ho;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.statusCd = statusCd;
		this.ofcCodeCd = ofcCodeCd;
		this.ofcKindCd = ofcKindCd;
		this.rhq = rhq;
		this.bbAa3 = bbAa3;
		this.bbAa4 = bbAa4;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sub_bb", getSubBb());
		this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
		this.hashColumns.put("ofc_lvl", getOfcLvl());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("bb_aa", getBbAa());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("ho", getHo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("ofc_code_cd", getOfcCodeCd());
		this.hashColumns.put("ofc_kind_cd", getOfcKindCd());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("bb_aa3", getBbAa3());
		this.hashColumns.put("bb_aa4", getBbAa4());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sub_bb", "subBb");
		this.hashFields.put("ofc_knd_cd", "ofcKndCd");
		this.hashFields.put("ofc_lvl", "ofcLvl");
		this.hashFields.put("status", "status");
		this.hashFields.put("bb_aa", "bbAa");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("ho", "ho");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("ofc_code_cd", "ofcCodeCd");
		this.hashFields.put("ofc_kind_cd", "ofcKindCd");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("bb_aa3", "bbAa3");
		this.hashFields.put("bb_aa4", "bbAa4");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return subBb
	 */
	public String getSubBb() {
		return this.subBb;
	}
	
	/**
	 * Column Info
	 * @return ofcKndCd
	 */
	public String getOfcKndCd() {
		return this.ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl
	 */
	public String getOfcLvl() {
		return this.ofcLvl;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return bbAa
	 */
	public String getBbAa() {
		return this.bbAa;
	}
	
	/**
	 * Column Info
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return ho
	 */
	public String getHo() {
		return this.ho;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return statusCd
	 */
	public String getStatusCd() {
		return this.statusCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCodeCd
	 */
	public String getOfcCodeCd() {
		return this.ofcCodeCd;
	}
	
	/**
	 * Column Info
	 * @return ofcKindCd
	 */
	public String getOfcKindCd() {
		return this.ofcKindCd;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param subBb
	 */
	public void setSubBb(String subBb) {
		this.subBb = subBb;
	}
	
	/**
	 * Column Info
	 * @param ofcKndCd
	 */
	public void setOfcKndCd(String ofcKndCd) {
		this.ofcKndCd = ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl
	 */
	public void setOfcLvl(String ofcLvl) {
		this.ofcLvl = ofcLvl;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param bbAa
	 */
	public void setBbAa(String bbAa) {
		this.bbAa = bbAa;
	}
	
	/**
	 * Column Info
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param ho
	 */
	public void setHo(String ho) {
		this.ho = ho;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param statusCd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCodeCd
	 */
	public void setOfcCodeCd(String ofcCodeCd) {
		this.ofcCodeCd = ofcCodeCd;
	}
	
	/**
	 * Column Info
	 * @param ofcKindCd
	 */
	public void setOfcKindCd(String ofcKindCd) {
		this.ofcKindCd = ofcKindCd;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}

	public String getBbAa3() {
		return bbAa3;
	}

	public void setBbAa3(String bbAa3) {
		this.bbAa3 = bbAa3;
	}

	public String getBbAa4() {
		return bbAa4;
	}

	public void setBbAa4(String bbAa4) {
		this.bbAa4 = bbAa4;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setSubBb(JSPUtil.getParameter(request, prefix + "sub_bb", ""));
		setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
		setOfcLvl(JSPUtil.getParameter(request, prefix + "ofc_lvl", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setBbAa(JSPUtil.getParameter(request, prefix + "bb_aa", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setHo(JSPUtil.getParameter(request, prefix + "ho", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStatusCd(JSPUtil.getParameter(request, prefix + "status_cd", ""));
		setOfcCodeCd(JSPUtil.getParameter(request, prefix + "ofc_code_cd", ""));
		setOfcKindCd(JSPUtil.getParameter(request, prefix + "ofc_kind_cd", ""));
		setRhq(JSPUtil.getParameter(request, prefix + "rhq", ""));
		setBbAa3(JSPUtil.getParameter(request, prefix + "bb_aa3", ""));
		setBbAa4(JSPUtil.getParameter(request, prefix + "bb_aa4", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOfficHierarchyVO[]
	 */
	public SearchOfficHierarchyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOfficHierarchyVO[]
	 */
	public SearchOfficHierarchyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOfficHierarchyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] subBb = (JSPUtil.getParameter(request, prefix	+ "sub_bb", length));
			String[] ofcKndCd = (JSPUtil.getParameter(request, prefix	+ "ofc_knd_cd", length));
			String[] ofcLvl = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] bbAa = (JSPUtil.getParameter(request, prefix	+ "bb_aa", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] ho = (JSPUtil.getParameter(request, prefix	+ "ho", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd", length));
			String[] ofcCodeCd = (JSPUtil.getParameter(request, prefix	+ "ofc_code_cd", length));
			String[] ofcKindCd = (JSPUtil.getParameter(request, prefix	+ "ofc_kind_cd", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] bbAa3 = (JSPUtil.getParameter(request, prefix	+ "bb_aa3", length));
			String[] bbAa4 = (JSPUtil.getParameter(request, prefix	+ "bb_aa4", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficHierarchyVO();
				if (subBb[i] != null)
					model.setSubBb(subBb[i]);
				if (ofcKndCd[i] != null)
					model.setOfcKndCd(ofcKndCd[i]);
				if (ofcLvl[i] != null)
					model.setOfcLvl(ofcLvl[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (bbAa[i] != null)
					model.setBbAa(bbAa[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (ho[i] != null)
					model.setHo(ho[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (ofcCodeCd[i] != null)
					model.setOfcCodeCd(ofcCodeCd[i]);
				if (ofcKindCd[i] != null)
					model.setOfcKindCd(ofcKindCd[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (bbAa3[i] != null)
					model.setBbAa3(bbAa3[i]);
				if (bbAa4[i] != null)
					model.setBbAa4(bbAa4[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOfficHierarchyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOfficHierarchyVO[]
	 */
	public SearchOfficHierarchyVO[] getSearchOfficHierarchyVOs(){
		SearchOfficHierarchyVO[] vos = (SearchOfficHierarchyVO[])models.toArray(new SearchOfficHierarchyVO[models.size()]);
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
		this.subBb = this.subBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKndCd = this.ofcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl = this.ofcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbAa = this.bbAa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ho = this.ho .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCodeCd = this.ofcCodeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKindCd = this.ofcKindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbAa3 = this.bbAa3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbAa4 = this.bbAa4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
