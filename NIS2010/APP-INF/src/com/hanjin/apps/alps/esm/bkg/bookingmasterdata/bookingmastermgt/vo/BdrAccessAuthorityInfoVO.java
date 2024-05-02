/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BdrAccessAuthorityInfoVO.java
*@FileTitle : BdrAccessAuthorityInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.27
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2014.03.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BdrAccessAuthorityInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BdrAccessAuthorityInfoVO> models = new ArrayList<BdrAccessAuthorityInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hrdCdgIdSeq = null;
	/* Column Info */
	private String openAuth = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String searchOption = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String closeAuth = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String sheetUsrId = null;
	/* Column Info */
	private String searchBox = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BdrAccessAuthorityInfoVO() {}

	public BdrAccessAuthorityInfoVO(String ibflag, String pagerows, String closeAuth, String openAuth, String usrId, String usrNm, String ofcCd, String updDt, String searchBox, String searchOption, String hrdCdgIdSeq, String creUsrId, String updUsrId, String sheetUsrId) {
		this.updDt = updDt;
		this.hrdCdgIdSeq = hrdCdgIdSeq;
		this.openAuth = openAuth;
		this.pagerows = pagerows;
		this.searchOption = searchOption;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.closeAuth = closeAuth;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.sheetUsrId = sheetUsrId;
		this.searchBox = searchBox;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hrd_cdg_id_seq", getHrdCdgIdSeq());
		this.hashColumns.put("open_auth", getOpenAuth());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("search_option", getSearchOption());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("close_auth", getCloseAuth());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("sheet_usr_id", getSheetUsrId());
		this.hashColumns.put("search_box", getSearchBox());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hrd_cdg_id_seq", "hrdCdgIdSeq");
		this.hashFields.put("open_auth", "openAuth");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("search_option", "searchOption");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("close_auth", "closeAuth");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("sheet_usr_id", "sheetUsrId");
		this.hashFields.put("search_box", "searchBox");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return hrdCdgIdSeq
	 */
	public String getHrdCdgIdSeq() {
		return this.hrdCdgIdSeq;
	}
	
	/**
	 * Column Info
	 * @return openAuth
	 */
	public String getOpenAuth() {
		return this.openAuth;
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
	 * @return searchOption
	 */
	public String getSearchOption() {
		return this.searchOption;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return closeAuth
	 */
	public String getCloseAuth() {
		return this.closeAuth;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return sheetUsrId
	 */
	public String getSheetUsrId() {
		return this.sheetUsrId;
	}
	
	/**
	 * Column Info
	 * @return searchBox
	 */
	public String getSearchBox() {
		return this.searchBox;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param hrdCdgIdSeq
	 */
	public void setHrdCdgIdSeq(String hrdCdgIdSeq) {
		this.hrdCdgIdSeq = hrdCdgIdSeq;
	}
	
	/**
	 * Column Info
	 * @param openAuth
	 */
	public void setOpenAuth(String openAuth) {
		this.openAuth = openAuth;
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
	 * @param searchOption
	 */
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param closeAuth
	 */
	public void setCloseAuth(String closeAuth) {
		this.closeAuth = closeAuth;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param sheetUsrId
	 */
	public void setSheetUsrId(String sheetUsrId) {
		this.sheetUsrId = sheetUsrId;
	}
	
	/**
	 * Column Info
	 * @param searchBox
	 */
	public void setSearchBox(String searchBox) {
		this.searchBox = searchBox;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setHrdCdgIdSeq(JSPUtil.getParameter(request, prefix + "hrd_cdg_id_seq", ""));
		setOpenAuth(JSPUtil.getParameter(request, prefix + "open_auth", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSearchOption(JSPUtil.getParameter(request, prefix + "search_option", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCloseAuth(JSPUtil.getParameter(request, prefix + "close_auth", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setSheetUsrId(JSPUtil.getParameter(request, prefix + "sheet_usr_id", ""));
		setSearchBox(JSPUtil.getParameter(request, prefix + "search_box", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BdrAccessAuthorityInfoVO[]
	 */
	public BdrAccessAuthorityInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BdrAccessAuthorityInfoVO[]
	 */
	public BdrAccessAuthorityInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BdrAccessAuthorityInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hrdCdgIdSeq = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_id_seq", length));
			String[] openAuth = (JSPUtil.getParameter(request, prefix	+ "open_auth", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] searchOption = (JSPUtil.getParameter(request, prefix	+ "search_option", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] closeAuth = (JSPUtil.getParameter(request, prefix	+ "close_auth", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] sheetUsrId = (JSPUtil.getParameter(request, prefix	+ "sheet_usr_id", length));
			String[] searchBox = (JSPUtil.getParameter(request, prefix	+ "search_box", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BdrAccessAuthorityInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hrdCdgIdSeq[i] != null)
					model.setHrdCdgIdSeq(hrdCdgIdSeq[i]);
				if (openAuth[i] != null)
					model.setOpenAuth(openAuth[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (searchOption[i] != null)
					model.setSearchOption(searchOption[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (closeAuth[i] != null)
					model.setCloseAuth(closeAuth[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (sheetUsrId[i] != null)
					model.setSheetUsrId(sheetUsrId[i]);
				if (searchBox[i] != null)
					model.setSearchBox(searchBox[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBdrAccessAuthorityInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BdrAccessAuthorityInfoVO[]
	 */
	public BdrAccessAuthorityInfoVO[] getBdrAccessAuthorityInfoVOs(){
		BdrAccessAuthorityInfoVO[] vos = (BdrAccessAuthorityInfoVO[])models.toArray(new BdrAccessAuthorityInfoVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgIdSeq = this.hrdCdgIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.openAuth = this.openAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchOption = this.searchOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closeAuth = this.closeAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetUsrId = this.sheetUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchBox = this.searchBox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
