/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName       : SearchSaqComCodeListVO.java
*@FileTitle      : SearchSaqComCodeListVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSaqComCodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSaqComCodeListVO> models = new ArrayList<SearchSaqComCodeListVO>();
	
	/* Column Info */
	private String searchFlag = null;
	/* Column Info */
	private String comFlag = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String targetGroup = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String objName = null;
	/* Column Info */
	private String rlaneNm = null;
	/* Column Info */
	private String codeCd = null;
	/* Column Info */
	private String mcode = null;
	/* Column Info */
	private String codeNm = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String subTrdNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSaqComCodeListVO() {}

	public SearchSaqComCodeListVO(String ibflag, String pagerows, String mcode, String comFlag, String objName, String codeCd, String codeNm, String trdCd, String subTrdCd, String rlaneCd, String rlaneNm, String bseYr, String bseQtrCd, String ofcCd, String searchFlag, String targetGroup, String subTrdNm) {
		this.searchFlag = searchFlag;
		this.comFlag = comFlag;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.bseYr = bseYr;
		this.targetGroup = targetGroup;
		this.pagerows = pagerows;
		this.bseQtrCd = bseQtrCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.objName = objName;
		this.rlaneNm = rlaneNm;
		this.codeCd = codeCd;
		this.mcode = mcode;
		this.codeNm = codeNm;
		this.subTrdCd = subTrdCd;
		this.subTrdNm = subTrdNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_flag", getSearchFlag());
		this.hashColumns.put("com_flag", getComFlag());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("target_group", getTargetGroup());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("obj_name", getObjName());
		this.hashColumns.put("rlane_nm", getRlaneNm());
		this.hashColumns.put("code_cd", getCodeCd());
		this.hashColumns.put("mcode", getMcode());
		this.hashColumns.put("code_nm", getCodeNm());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("sub_trd_nm", getSubTrdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_flag", "searchFlag");
		this.hashFields.put("com_flag", "comFlag");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("target_group", "targetGroup");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("obj_name", "objName");
		this.hashFields.put("rlane_nm", "rlaneNm");
		this.hashFields.put("code_cd", "codeCd");
		this.hashFields.put("mcode", "mcode");
		this.hashFields.put("code_nm", "codeNm");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("sub_trd_nm", "subTrdNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchFlag
	 */
	public String getSearchFlag() {
		return this.searchFlag;
	}
	
	/**
	 * Column Info
	 * @return comFlag
	 */
	public String getComFlag() {
		return this.comFlag;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return targetGroup
	 */
	public String getTargetGroup() {
		return this.targetGroup;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return objName
	 */
	public String getObjName() {
		return this.objName;
	}
	
	/**
	 * Column Info
	 * @return rlaneNm
	 */
	public String getRlaneNm() {
		return this.rlaneNm;
	}
	
	/**
	 * Column Info
	 * @return codeCd
	 */
	public String getCodeCd() {
		return this.codeCd;
	}
	
	/**
	 * Column Info
	 * @return mcode
	 */
	public String getMcode() {
		return this.mcode;
	}
	
	/**
	 * Column Info
	 * @return codeNm
	 */
	public String getCodeNm() {
		return this.codeNm;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdNm
	 */
	public String getSubTrdNm() {
		return this.subTrdNm;
	}
	

	/**
	 * Column Info
	 * @param searchFlag
	 */
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	
	/**
	 * Column Info
	 * @param comFlag
	 */
	public void setComFlag(String comFlag) {
		this.comFlag = comFlag;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param targetGroup
	 */
	public void setTargetGroup(String targetGroup) {
		this.targetGroup = targetGroup;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param objName
	 */
	public void setObjName(String objName) {
		this.objName = objName;
	}
	
	/**
	 * Column Info
	 * @param rlaneNm
	 */
	public void setRlaneNm(String rlaneNm) {
		this.rlaneNm = rlaneNm;
	}
	
	/**
	 * Column Info
	 * @param codeCd
	 */
	public void setCodeCd(String codeCd) {
		this.codeCd = codeCd;
	}
	
	/**
	 * Column Info
	 * @param mcode
	 */
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	
	/**
	 * Column Info
	 * @param codeNm
	 */
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdNm
	 */
	public void setSubTrdNm(String subTrdNm) {
		this.subTrdNm = subTrdNm;
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
		setSearchFlag(JSPUtil.getParameter(request, prefix + "search_flag", ""));
		setComFlag(JSPUtil.getParameter(request, prefix + "com_flag", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setTargetGroup(JSPUtil.getParameter(request, prefix + "target_group", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setObjName(JSPUtil.getParameter(request, prefix + "obj_name", ""));
		setRlaneNm(JSPUtil.getParameter(request, prefix + "rlane_nm", ""));
		setCodeCd(JSPUtil.getParameter(request, prefix + "code_cd", ""));
		setMcode(JSPUtil.getParameter(request, prefix + "mcode", ""));
		setCodeNm(JSPUtil.getParameter(request, prefix + "code_nm", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setSubTrdNm(JSPUtil.getParameter(request, prefix + "sub_trd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSaqComCodeListVO[]
	 */
	public SearchSaqComCodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSaqComCodeListVO[]
	 */
	public SearchSaqComCodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSaqComCodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchFlag = (JSPUtil.getParameter(request, prefix	+ "search_flag", length));
			String[] comFlag = (JSPUtil.getParameter(request, prefix	+ "com_flag", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] targetGroup = (JSPUtil.getParameter(request, prefix	+ "target_group", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] objName = (JSPUtil.getParameter(request, prefix	+ "obj_name", length));
			String[] rlaneNm = (JSPUtil.getParameter(request, prefix	+ "rlane_nm", length));
			String[] codeCd = (JSPUtil.getParameter(request, prefix	+ "code_cd", length));
			String[] mcode = (JSPUtil.getParameter(request, prefix	+ "mcode", length));
			String[] codeNm = (JSPUtil.getParameter(request, prefix	+ "code_nm", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] subTrdNm = (JSPUtil.getParameter(request, prefix	+ "sub_trd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSaqComCodeListVO();
				if (searchFlag[i] != null)
					model.setSearchFlag(searchFlag[i]);
				if (comFlag[i] != null)
					model.setComFlag(comFlag[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (targetGroup[i] != null)
					model.setTargetGroup(targetGroup[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (objName[i] != null)
					model.setObjName(objName[i]);
				if (rlaneNm[i] != null)
					model.setRlaneNm(rlaneNm[i]);
				if (codeCd[i] != null)
					model.setCodeCd(codeCd[i]);
				if (mcode[i] != null)
					model.setMcode(mcode[i]);
				if (codeNm[i] != null)
					model.setCodeNm(codeNm[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (subTrdNm[i] != null)
					model.setSubTrdNm(subTrdNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSaqComCodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSaqComCodeListVO[]
	 */
	public SearchSaqComCodeListVO[] getSearchSaqComCodeListVOs(){
		SearchSaqComCodeListVO[] vos = (SearchSaqComCodeListVO[])models.toArray(new SearchSaqComCodeListVO[models.size()]);
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
		this.searchFlag = this.searchFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comFlag = this.comFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetGroup = this.targetGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objName = this.objName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneNm = this.rlaneNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeCd = this.codeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcode = this.mcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeNm = this.codeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdNm = this.subTrdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
