/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExpMapgOfcListVO.java
*@FileTitle : SearchExpMapgOfcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.11.05 이중환 
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

public class SearchExpMapgOfcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExpMapgOfcListVO> models = new ArrayList<SearchExpMapgOfcListVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fMapgOfcNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fMapgOfcCd = null;
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
	
	public SearchExpMapgOfcListVO() {}

	public SearchExpMapgOfcListVO(String ibflag, String pagerows, String fOfcCd, String fMapgOfcCd, String fMapgOfcNm, String fLocCd, String creUsrId, String creDt, String deltFlg) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.fMapgOfcNm = fMapgOfcNm;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.fMapgOfcCd = fMapgOfcCd;
		this.fLocCd = fLocCd;
		this.fOfcCd = fOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_mapg_ofc_nm", getFMapgOfcNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("f_mapg_ofc_cd", getFMapgOfcCd());
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
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_mapg_ofc_nm", "fMapgOfcNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("f_mapg_ofc_cd", "fMapgOfcCd");
		this.hashFields.put("f_loc_cd", "fLocCd");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFMapgOfcNm(JSPUtil.getParameter(request, "f_mapg_ofc_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFMapgOfcCd(JSPUtil.getParameter(request, "f_mapg_ofc_cd", ""));
		setFLocCd(JSPUtil.getParameter(request, "f_loc_cd", ""));
		setFOfcCd(JSPUtil.getParameter(request, "f_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExpMapgOfcListVO[]
	 */
	public SearchExpMapgOfcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExpMapgOfcListVO[]
	 */
	public SearchExpMapgOfcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExpMapgOfcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fMapgOfcNm = (JSPUtil.getParameter(request, prefix	+ "f_mapg_ofc_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fMapgOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_mapg_ofc_cd", length));
			String[] fLocCd = (JSPUtil.getParameter(request, prefix	+ "f_loc_cd", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExpMapgOfcListVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fMapgOfcNm[i] != null)
					model.setFMapgOfcNm(fMapgOfcNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fMapgOfcCd[i] != null)
					model.setFMapgOfcCd(fMapgOfcCd[i]);
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
		return getSearchExpMapgOfcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExpMapgOfcListVO[]
	 */
	public SearchExpMapgOfcListVO[] getSearchExpMapgOfcListVOs(){
		SearchExpMapgOfcListVO[] vos = (SearchExpMapgOfcListVO[])models.toArray(new SearchExpMapgOfcListVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMapgOfcNm = this.fMapgOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMapgOfcCd = this.fMapgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLocCd = this.fLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
