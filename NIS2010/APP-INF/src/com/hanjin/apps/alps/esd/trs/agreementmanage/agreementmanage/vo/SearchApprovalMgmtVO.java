/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchApprovalMgmtVO.java
*@FileTitle : SearchApprovalMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.22
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.07.22 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchApprovalMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchApprovalMgmtVO> models = new ArrayList<SearchApprovalMgmtVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cfmUsrNm = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String sel = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchApprovalMgmtVO() {}

	public SearchApprovalMgmtVO(String ibflag, String pagerows, String cfmUsrId, String cfmUsrNm, String cfmOfcCd, String creOfcCd, String creUsrId, String creUsrNm, String loclCreDt, String sel) {
		this.creUsrId = creUsrId;
		this.cfmOfcCd = cfmOfcCd;
		this.ibflag = ibflag;
		this.cfmUsrNm = cfmUsrNm;
		this.creOfcCd = creOfcCd;
		this.loclCreDt = loclCreDt;
		this.cfmUsrId = cfmUsrId;
		this.creUsrNm = creUsrNm;
		this.sel = sel;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfm_usr_nm", getCfmUsrNm());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfm_usr_nm", "cfmUsrNm");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("sel", "sel");
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
	 * Column Info
	 * @return cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
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
	 * @return cfmUsrNm
	 */
	public String getCfmUsrNm() {
		return this.cfmUsrNm;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
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
	 * Column Info
	 * @param cfmOfcCd
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
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
	 * @param cfmUsrNm
	 */
	public void setCfmUsrNm(String cfmUsrNm) {
		this.cfmUsrNm = cfmUsrNm;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, prefix + "cfm_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCfmUsrNm(JSPUtil.getParameter(request, prefix + "cfm_usr_nm", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchApprovalMgmtVO[]
	 */
	public SearchApprovalMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchApprovalMgmtVO[]
	 */
	public SearchApprovalMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchApprovalMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfmUsrNm = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_nm", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchApprovalMgmtVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cfmUsrNm[i] != null)
					model.setCfmUsrNm(cfmUsrNm[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchApprovalMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchApprovalMgmtVO[]
	 */
	public SearchApprovalMgmtVO[] getSearchApprovalMgmtVOs(){
		SearchApprovalMgmtVO[] vos = (SearchApprovalMgmtVO[])models.toArray(new SearchApprovalMgmtVO[models.size()]);
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
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrNm = this.cfmUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
