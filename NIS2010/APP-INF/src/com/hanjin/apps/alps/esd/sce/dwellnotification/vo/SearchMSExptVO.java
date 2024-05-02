/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchMSExptVO.java
*@FileTitle : SearchMSExptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMSExptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMSExptVO> models = new ArrayList<SearchMSExptVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sntFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String csGrpId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMSExptVO() {}

	public SearchMSExptVO(String ibflag, String pagerows, String podCd, String delCd, String vvd, String blNo, String cntrNo, String sntFlg, String csGrpId) {
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.sntFlg = sntFlg;
		this.cntrNo = cntrNo;
		this.delCd = delCd;
		this.blNo = blNo;
		this.csGrpId = csGrpId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd_", getVvd());
		this.hashColumns.put("pod_cd_", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snt_flg_", getSntFlg());
		this.hashColumns.put("cntr_no_", getCntrNo());
		this.hashColumns.put("del_cd_", getDelCd());
		this.hashColumns.put("bl_no_", getBlNo());
		this.hashColumns.put("cs_grp_id", getCsGrpId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd_", "vvd");
		this.hashFields.put("pod_cd_", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snt_flg_", "sntFlg");
		this.hashFields.put("cntr_no_", "cntrNo");
		this.hashFields.put("del_cd_", "delCd");
		this.hashFields.put("bl_no_", "blNo");
		this.hashFields.put("cs_grp_id", "csGrpId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return sntFlg
	 */
	public String getSntFlg() {
		return this.sntFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return csGrpId
	 */
	public String getCsGrpId() {
		return this.csGrpId;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param sntFlg
	 */
	public void setSntFlg(String sntFlg) {
		this.sntFlg = sntFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param csGrpId
	 */
	public void setCsGrpId(String csGrpId) {
		this.csGrpId = csGrpId;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd_", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd_", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSntFlg(JSPUtil.getParameter(request, prefix + "snt_flg_", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no_", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd_", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no_", ""));
		setCsGrpId(JSPUtil.getParameter(request, prefix + "cs_grp_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMSExptVO[]
	 */
	public SearchMSExptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMSExptVO[]
	 */
	public SearchMSExptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMSExptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd_", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd_", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sntFlg = (JSPUtil.getParameter(request, prefix	+ "snt_flg_", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no_", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd_", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no_", length));
			String[] csGrpId = (JSPUtil.getParameter(request, prefix	+ "cs_grp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMSExptVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sntFlg[i] != null)
					model.setSntFlg(sntFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (csGrpId[i] != null)
					model.setCsGrpId(csGrpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMSExptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMSExptVO[]
	 */
	public SearchMSExptVO[] getSearchMSExptVOs(){
		SearchMSExptVO[] vos = (SearchMSExptVO[])models.toArray(new SearchMSExptVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntFlg = this.sntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csGrpId = this.csGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
