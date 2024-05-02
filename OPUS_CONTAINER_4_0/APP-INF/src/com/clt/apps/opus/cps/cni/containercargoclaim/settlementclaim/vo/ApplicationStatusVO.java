/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ApplicationStatusVO.java
*@FileTitle : ApplicationStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.16
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.02.16 이준범 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo;

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
 * @author 이준범
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ApplicationStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ApplicationStatusVO> models = new ArrayList<ApplicationStatusVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String clmStlAuthNo = null;
	/* Column Info */
	private String clmStlAuthUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clmStlAuthRmk = null;
	/* Column Info */
	private String clmStlApplOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String clmStlAuthDt = null;
	/* Column Info */
	private String clmStlAuthCd = null;
	/* Column Info */
	private String clmStlApplUsrId = null;
	/* Column Info */
	private String clmStlAuthOfcCd = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String clmStlApplDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ApplicationStatusVO() {}

	public ApplicationStatusVO(String ibflag, String pagerows, String cgoClmNo, String clmStlApplDt, String clmStlApplUsrId, String clmStlApplOfcCd, String clmStlAuthDt, String clmStlAuthUsrId, String clmStlAuthOfcCd, String clmStlAuthCd, String clmStlAuthRmk, String clmStlAuthNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.clmStlAuthNo = clmStlAuthNo;
		this.clmStlAuthUsrId = clmStlAuthUsrId;
		this.pagerows = pagerows;
		this.clmStlAuthRmk = clmStlAuthRmk;
		this.clmStlApplOfcCd = clmStlApplOfcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.clmStlAuthDt = clmStlAuthDt;
		this.clmStlAuthCd = clmStlAuthCd;
		this.clmStlApplUsrId = clmStlApplUsrId;
		this.clmStlAuthOfcCd = clmStlAuthOfcCd;
		this.cgoClmNo = cgoClmNo;
		this.clmStlApplDt = clmStlApplDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clm_stl_auth_no", getClmStlAuthNo());
		this.hashColumns.put("clm_stl_auth_usr_id", getClmStlAuthUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clm_stl_auth_rmk", getClmStlAuthRmk());
		this.hashColumns.put("clm_stl_appl_ofc_cd", getClmStlApplOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("clm_stl_auth_dt", getClmStlAuthDt());
		this.hashColumns.put("clm_stl_auth_cd", getClmStlAuthCd());
		this.hashColumns.put("clm_stl_appl_usr_id", getClmStlApplUsrId());
		this.hashColumns.put("clm_stl_auth_ofc_cd", getClmStlAuthOfcCd());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("clm_stl_appl_dt", getClmStlApplDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clm_stl_auth_no", "clmStlAuthNo");
		this.hashFields.put("clm_stl_auth_usr_id", "clmStlAuthUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clm_stl_auth_rmk", "clmStlAuthRmk");
		this.hashFields.put("clm_stl_appl_ofc_cd", "clmStlApplOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("clm_stl_auth_dt", "clmStlAuthDt");
		this.hashFields.put("clm_stl_auth_cd", "clmStlAuthCd");
		this.hashFields.put("clm_stl_appl_usr_id", "clmStlApplUsrId");
		this.hashFields.put("clm_stl_auth_ofc_cd", "clmStlAuthOfcCd");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("clm_stl_appl_dt", "clmStlApplDt");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthNo
	 */
	public String getClmStlAuthNo() {
		return this.clmStlAuthNo;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthUsrId
	 */
	public String getClmStlAuthUsrId() {
		return this.clmStlAuthUsrId;
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
	 * @return clmStlAuthRmk
	 */
	public String getClmStlAuthRmk() {
		return this.clmStlAuthRmk;
	}
	
	/**
	 * Column Info
	 * @return clmStlApplOfcCd
	 */
	public String getClmStlApplOfcCd() {
		return this.clmStlApplOfcCd;
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
	 * @return clmStlAuthDt
	 */
	public String getClmStlAuthDt() {
		return this.clmStlAuthDt;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthCd
	 */
	public String getClmStlAuthCd() {
		return this.clmStlAuthCd;
	}
	
	/**
	 * Column Info
	 * @return clmStlApplUsrId
	 */
	public String getClmStlApplUsrId() {
		return this.clmStlApplUsrId;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthOfcCd
	 */
	public String getClmStlAuthOfcCd() {
		return this.clmStlAuthOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return clmStlApplDt
	 */
	public String getClmStlApplDt() {
		return this.clmStlApplDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthNo
	 */
	public void setClmStlAuthNo(String clmStlAuthNo) {
		this.clmStlAuthNo = clmStlAuthNo;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthUsrId
	 */
	public void setClmStlAuthUsrId(String clmStlAuthUsrId) {
		this.clmStlAuthUsrId = clmStlAuthUsrId;
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
	 * @param clmStlAuthRmk
	 */
	public void setClmStlAuthRmk(String clmStlAuthRmk) {
		this.clmStlAuthRmk = clmStlAuthRmk;
	}
	
	/**
	 * Column Info
	 * @param clmStlApplOfcCd
	 */
	public void setClmStlApplOfcCd(String clmStlApplOfcCd) {
		this.clmStlApplOfcCd = clmStlApplOfcCd;
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
	 * @param clmStlAuthDt
	 */
	public void setClmStlAuthDt(String clmStlAuthDt) {
		this.clmStlAuthDt = clmStlAuthDt;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthCd
	 */
	public void setClmStlAuthCd(String clmStlAuthCd) {
		this.clmStlAuthCd = clmStlAuthCd;
	}
	
	/**
	 * Column Info
	 * @param clmStlApplUsrId
	 */
	public void setClmStlApplUsrId(String clmStlApplUsrId) {
		this.clmStlApplUsrId = clmStlApplUsrId;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthOfcCd
	 */
	public void setClmStlAuthOfcCd(String clmStlAuthOfcCd) {
		this.clmStlAuthOfcCd = clmStlAuthOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param clmStlApplDt
	 */
	public void setClmStlApplDt(String clmStlApplDt) {
		this.clmStlApplDt = clmStlApplDt;
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
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setClmStlAuthNo(JSPUtil.getParameter(request, prefix + "clm_stl_auth_no", ""));
		setClmStlAuthUsrId(JSPUtil.getParameter(request, prefix + "clm_stl_auth_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClmStlAuthRmk(JSPUtil.getParameter(request, prefix + "clm_stl_auth_rmk", ""));
		setClmStlApplOfcCd(JSPUtil.getParameter(request, prefix + "clm_stl_appl_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setClmStlAuthDt(JSPUtil.getParameter(request, prefix + "clm_stl_auth_dt", ""));
		setClmStlAuthCd(JSPUtil.getParameter(request, prefix + "clm_stl_auth_cd", ""));
		setClmStlApplUsrId(JSPUtil.getParameter(request, prefix + "clm_stl_appl_usr_id", ""));
		setClmStlAuthOfcCd(JSPUtil.getParameter(request, prefix + "clm_stl_auth_ofc_cd", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setClmStlApplDt(JSPUtil.getParameter(request, prefix + "clm_stl_appl_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApplicationStatusVO[]
	 */
	public ApplicationStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApplicationStatusVO[]
	 */
	public ApplicationStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ApplicationStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] clmStlAuthNo = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_no", length));
			String[] clmStlAuthUsrId = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clmStlAuthRmk = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_rmk", length));
			String[] clmStlApplOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] clmStlAuthDt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_dt", length));
			String[] clmStlAuthCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_cd", length));
			String[] clmStlApplUsrId = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_usr_id", length));
			String[] clmStlAuthOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_ofc_cd", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] clmStlApplDt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ApplicationStatusVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (clmStlAuthNo[i] != null)
					model.setClmStlAuthNo(clmStlAuthNo[i]);
				if (clmStlAuthUsrId[i] != null)
					model.setClmStlAuthUsrId(clmStlAuthUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clmStlAuthRmk[i] != null)
					model.setClmStlAuthRmk(clmStlAuthRmk[i]);
				if (clmStlApplOfcCd[i] != null)
					model.setClmStlApplOfcCd(clmStlApplOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (clmStlAuthDt[i] != null)
					model.setClmStlAuthDt(clmStlAuthDt[i]);
				if (clmStlAuthCd[i] != null)
					model.setClmStlAuthCd(clmStlAuthCd[i]);
				if (clmStlApplUsrId[i] != null)
					model.setClmStlApplUsrId(clmStlApplUsrId[i]);
				if (clmStlAuthOfcCd[i] != null)
					model.setClmStlAuthOfcCd(clmStlAuthOfcCd[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (clmStlApplDt[i] != null)
					model.setClmStlApplDt(clmStlApplDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getApplicationStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ApplicationStatusVO[]
	 */
	public ApplicationStatusVO[] getApplicationStatusVOs(){
		ApplicationStatusVO[] vos = (ApplicationStatusVO[])models.toArray(new ApplicationStatusVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthNo = this.clmStlAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthUsrId = this.clmStlAuthUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthRmk = this.clmStlAuthRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplOfcCd = this.clmStlApplOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthDt = this.clmStlAuthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthCd = this.clmStlAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplUsrId = this.clmStlApplUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthOfcCd = this.clmStlAuthOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplDt = this.clmStlApplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
