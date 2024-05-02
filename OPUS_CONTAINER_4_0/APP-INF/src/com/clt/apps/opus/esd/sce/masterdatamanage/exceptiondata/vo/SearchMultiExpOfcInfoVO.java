/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMultiExpOfcInfoVO.java
*@FileTitle : SearchMultiExpOfcInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.11.10 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMultiExpOfcInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMultiExpOfcInfoVO> models = new ArrayList<SearchMultiExpOfcInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fMapgOfcNm = null;
	/* Column Info */
	private String fActFlg = null;
	/* Column Info */
	private String fIbflag = null;
	/* Column Info */
	private String fMapgOfcCd = null;
	/* Column Info */
	private String fUsrId = null;
	/* Column Info */
	private String fLocCd = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMultiExpOfcInfoVO() {}

	public SearchMultiExpOfcInfoVO(String ibflag, String pagerows, String fOfcCd, String fMapgOfcCd, String fActFlg, String fIbflag, String fUsrId, String fMapgOfcNm, String fLocCd) {
		this.ibflag = ibflag;
		this.fMapgOfcNm = fMapgOfcNm;
		this.fActFlg = fActFlg;
		this.fIbflag = fIbflag;
		this.fMapgOfcCd = fMapgOfcCd;
		this.fUsrId = fUsrId;
		this.fLocCd = fLocCd;
		this.fOfcCd = fOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_mapg_ofc_nm", getFMapgOfcNm());
		this.hashColumns.put("f_act_flg", getFActFlg());
		this.hashColumns.put("f_ibflag", getFIbflag());
		this.hashColumns.put("f_mapg_ofc_cd", getFMapgOfcCd());
		this.hashColumns.put("f_usr_id", getFUsrId());
		this.hashColumns.put("f_loc_cd", getFLocCd());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_mapg_ofc_nm", "fMapgOfcNm");
		this.hashFields.put("f_act_flg", "fActFlg");
		this.hashFields.put("f_ibflag", "fIbflag");
		this.hashFields.put("f_mapg_ofc_cd", "fMapgOfcCd");
		this.hashFields.put("f_usr_id", "fUsrId");
		this.hashFields.put("f_loc_cd", "fLocCd");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
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
	 * @return fMapgOfcNm
	 */
	public String getFMapgOfcNm() {
		return this.fMapgOfcNm;
	}
	
	/**
	 * Column Info
	 * @return fActFlg
	 */
	public String getFActFlg() {
		return this.fActFlg;
	}
	
	/**
	 * Column Info
	 * @return fIbflag
	 */
	public String getFIbflag() {
		return this.fIbflag;
	}
	
	/**
	 * Column Info
	 * @return fMapgOfcCd
	 */
	public String getFMapgOfcCd() {
		return this.fMapgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fUsrId
	 */
	public String getFUsrId() {
		return this.fUsrId;
	}
	
	/**
	 * Column Info
	 * @return fLocCd
	 */
	public String getFLocCd() {
		return this.fLocCd;
	}
	
	/**
	 * Column Info
	 * @return fOfcCd
	 */
	public String getFOfcCd() {
		return this.fOfcCd;
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
	 * @param fMapgOfcNm
	 */
	public void setFMapgOfcNm(String fMapgOfcNm) {
		this.fMapgOfcNm = fMapgOfcNm;
	}
	
	/**
	 * Column Info
	 * @param fActFlg
	 */
	public void setFActFlg(String fActFlg) {
		this.fActFlg = fActFlg;
	}
	
	/**
	 * Column Info
	 * @param fIbflag
	 */
	public void setFIbflag(String fIbflag) {
		this.fIbflag = fIbflag;
	}
	
	/**
	 * Column Info
	 * @param fMapgOfcCd
	 */
	public void setFMapgOfcCd(String fMapgOfcCd) {
		this.fMapgOfcCd = fMapgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fUsrId
	 */
	public void setFUsrId(String fUsrId) {
		this.fUsrId = fUsrId;
	}
	
	/**
	 * Column Info
	 * @param fLocCd
	 */
	public void setFLocCd(String fLocCd) {
		this.fLocCd = fLocCd;
	}
	
	/**
	 * Column Info
	 * @param fOfcCd
	 */
	public void setFOfcCd(String fOfcCd) {
		this.fOfcCd = fOfcCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFMapgOfcNm(JSPUtil.getParameter(request, "f_mapg_ofc_nm", ""));
		setFActFlg(JSPUtil.getParameter(request, "f_act_flg", ""));
		setFIbflag(JSPUtil.getParameter(request, "f_ibflag", ""));
		setFMapgOfcCd(JSPUtil.getParameter(request, "f_mapg_ofc_cd", ""));
		setFUsrId(JSPUtil.getParameter(request, "f_usr_id", ""));
		setFLocCd(JSPUtil.getParameter(request, "f_loc_cd", ""));
		setFOfcCd(JSPUtil.getParameter(request, "f_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMultiExpOfcInfoVO[]
	 */
	public SearchMultiExpOfcInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMultiExpOfcInfoVO[]
	 */
	public SearchMultiExpOfcInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMultiExpOfcInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "f_ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "f_ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fMapgOfcNm = (JSPUtil.getParameter(request, prefix	+ "f_mapg_ofc_nm", length));
			String[] fActFlg = (JSPUtil.getParameter(request, prefix	+ "f_act_flg", length));
			String[] fIbflag = (JSPUtil.getParameter(request, prefix	+ "f_ibflag", length));
			String[] fMapgOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_mapg_ofc_cd", length));
			String[] fUsrId = (JSPUtil.getParameter(request, prefix	+ "f_usr_id", length));
			String[] fLocCd = (JSPUtil.getParameter(request, prefix	+ "f_loc_cd", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMultiExpOfcInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fMapgOfcNm[i] != null)
					model.setFMapgOfcNm(fMapgOfcNm[i]);
				if (fActFlg[i] != null)
					model.setFActFlg(fActFlg[i]);
				if (fIbflag[i] != null)
					model.setFIbflag(fIbflag[i]);
				if (fMapgOfcCd[i] != null)
					model.setFMapgOfcCd(fMapgOfcCd[i]);
				if (fUsrId[i] != null)
					model.setFUsrId(fUsrId[i]);
				if (fLocCd[i] != null)
					model.setFLocCd(fLocCd[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMultiExpOfcInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMultiExpOfcInfoVO[]
	 */
	public SearchMultiExpOfcInfoVO[] getSearchMultiExpOfcInfoVOs(){
		SearchMultiExpOfcInfoVO[] vos = (SearchMultiExpOfcInfoVO[])models.toArray(new SearchMultiExpOfcInfoVO[models.size()]);
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
		this.fMapgOfcNm = this.fMapgOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fActFlg = this.fActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIbflag = this.fIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMapgOfcCd = this.fMapgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUsrId = this.fUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLocCd = this.fLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
