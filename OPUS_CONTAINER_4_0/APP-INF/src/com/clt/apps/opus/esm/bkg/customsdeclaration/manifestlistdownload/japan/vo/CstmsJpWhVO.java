/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CstmsJpWhVO.java
*@FileTitle : CstmsJpWhVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class CstmsJpWhVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsJpWhVO> models = new ArrayList<CstmsJpWhVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String orgCstmsCd = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String whNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CstmsJpWhVO() {}

	public CstmsJpWhVO(String ibflag, String pagerows, String ydCd, String cstmsCd, String whNm, String orgYdCd, String orgCstmsCd, String usrId) {
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.ydCd = ydCd;
		this.orgCstmsCd = orgCstmsCd;
		this.cstmsCd = cstmsCd;
		this.orgYdCd = orgYdCd;
		this.whNm = whNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("org_cstms_cd", getOrgCstmsCd());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("wh_nm", getWhNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("org_cstms_cd", "orgCstmsCd");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("wh_nm", "whNm");
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return orgCstmsCd
	 */
	public String getOrgCstmsCd() {
		return this.orgCstmsCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd
	 */
	public String getCstmsCd() {
		return this.cstmsCd;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return whNm
	 */
	public String getWhNm() {
		return this.whNm;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param orgCstmsCd
	 */
	public void setOrgCstmsCd(String orgCstmsCd) {
		this.orgCstmsCd = orgCstmsCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd
	 */
	public void setCstmsCd(String cstmsCd) {
		this.cstmsCd = cstmsCd;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param whNm
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setOrgCstmsCd(JSPUtil.getParameter(request, prefix + "org_cstms_cd", ""));
		setCstmsCd(JSPUtil.getParameter(request, prefix + "cstms_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setWhNm(JSPUtil.getParameter(request, prefix + "wh_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsJpWhVO[]
	 */
	public CstmsJpWhVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsJpWhVO[]
	 */
	public CstmsJpWhVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsJpWhVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] orgCstmsCd = (JSPUtil.getParameter(request, prefix	+ "org_cstms_cd", length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] whNm = (JSPUtil.getParameter(request, prefix	+ "wh_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsJpWhVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (orgCstmsCd[i] != null)
					model.setOrgCstmsCd(orgCstmsCd[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (whNm[i] != null)
					model.setWhNm(whNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsJpWhVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsJpWhVO[]
	 */
	public CstmsJpWhVO[] getCstmsJpWhVOs(){
		CstmsJpWhVO[] vos = (CstmsJpWhVO[])models.toArray(new CstmsJpWhVO[models.size()]);
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
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCstmsCd = this.orgCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm = this.whNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
