/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EntryStatusVO.java
*@FileTitle : EntryStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.11.05 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EntryStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EntryStatusVO> models = new ArrayList<EntryStatusVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String insurClmPtyAbbrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String insurPtyNm = null;
	/* Column Info */
	private String ddctCgoAmt = null;
	/* Column Info */
	private String insurVslOshpCd = null;
	/* Column Info */
	private String insurPlcyYr = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String insurVslTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EntryStatusVO() {}

	public EntryStatusVO(String ibflag, String pagerows, String vslCd, String insurVslTpCd, String insurClmPtyNo, String insurPtyNm, String insurClmPtyAbbrNm, String insurVslOshpCd, String insurPlcyYr, String ddctCgoAmt) {
		this.vslCd = vslCd;
		this.insurClmPtyAbbrNm = insurClmPtyAbbrNm;
		this.ibflag = ibflag;
		this.insurPtyNm = insurPtyNm;
		this.ddctCgoAmt = ddctCgoAmt;
		this.insurVslOshpCd = insurVslOshpCd;
		this.insurPlcyYr = insurPlcyYr;
		this.insurClmPtyNo = insurClmPtyNo;
		this.insurVslTpCd = insurVslTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("insur_clm_pty_abbr_nm", getInsurClmPtyAbbrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("insur_pty_nm", getInsurPtyNm());
		this.hashColumns.put("ddct_cgo_amt", getDdctCgoAmt());
		this.hashColumns.put("insur_vsl_oshp_cd", getInsurVslOshpCd());
		this.hashColumns.put("insur_plcy_yr", getInsurPlcyYr());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("insur_vsl_tp_cd", getInsurVslTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("insur_clm_pty_abbr_nm", "insurClmPtyAbbrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("insur_pty_nm", "insurPtyNm");
		this.hashFields.put("ddct_cgo_amt", "ddctCgoAmt");
		this.hashFields.put("insur_vsl_oshp_cd", "insurVslOshpCd");
		this.hashFields.put("insur_plcy_yr", "insurPlcyYr");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("insur_vsl_tp_cd", "insurVslTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyAbbrNm
	 */
	public String getInsurClmPtyAbbrNm() {
		return this.insurClmPtyAbbrNm;
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
	 * @return insurPtyNm
	 */
	public String getInsurPtyNm() {
		return this.insurPtyNm;
	}
	
	/**
	 * Column Info
	 * @return ddctCgoAmt
	 */
	public String getDdctCgoAmt() {
		return this.ddctCgoAmt;
	}
	
	/**
	 * Column Info
	 * @return insurVslOshpCd
	 */
	public String getInsurVslOshpCd() {
		return this.insurVslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return insurPlcyYr
	 */
	public String getInsurPlcyYr() {
		return this.insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return insurVslTpCd
	 */
	public String getInsurVslTpCd() {
		return this.insurVslTpCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyAbbrNm
	 */
	public void setInsurClmPtyAbbrNm(String insurClmPtyAbbrNm) {
		this.insurClmPtyAbbrNm = insurClmPtyAbbrNm;
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
	 * @param insurPtyNm
	 */
	public void setInsurPtyNm(String insurPtyNm) {
		this.insurPtyNm = insurPtyNm;
	}
	
	/**
	 * Column Info
	 * @param ddctCgoAmt
	 */
	public void setDdctCgoAmt(String ddctCgoAmt) {
		this.ddctCgoAmt = ddctCgoAmt;
	}
	
	/**
	 * Column Info
	 * @param insurVslOshpCd
	 */
	public void setInsurVslOshpCd(String insurVslOshpCd) {
		this.insurVslOshpCd = insurVslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param insurPlcyYr
	 */
	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param insurVslTpCd
	 */
	public void setInsurVslTpCd(String insurVslTpCd) {
		this.insurVslTpCd = insurVslTpCd;
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
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setInsurClmPtyAbbrNm(JSPUtil.getParameter(request, "insur_clm_pty_abbr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInsurPtyNm(JSPUtil.getParameter(request, "insur_pty_nm", ""));
		setDdctCgoAmt(JSPUtil.getParameter(request, "ddct_cgo_amt", ""));
		setInsurVslOshpCd(JSPUtil.getParameter(request, "insur_vsl_oshp_cd", ""));
		setInsurPlcyYr(JSPUtil.getParameter(request, "insur_plcy_yr", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, "insur_clm_pty_no", ""));
		setInsurVslTpCd(JSPUtil.getParameter(request, "insur_vsl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EntryStatusVO[]
	 */
	public EntryStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EntryStatusVO[]
	 */
	public EntryStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EntryStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] insurClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_abbr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] insurPtyNm = (JSPUtil.getParameter(request, prefix	+ "insur_pty_nm", length));
			String[] ddctCgoAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_cgo_amt", length));
			String[] insurVslOshpCd = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_oshp_cd", length));
			String[] insurPlcyYr = (JSPUtil.getParameter(request, prefix	+ "insur_plcy_yr", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] insurVslTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EntryStatusVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (insurClmPtyAbbrNm[i] != null)
					model.setInsurClmPtyAbbrNm(insurClmPtyAbbrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (insurPtyNm[i] != null)
					model.setInsurPtyNm(insurPtyNm[i]);
				if (ddctCgoAmt[i] != null)
					model.setDdctCgoAmt(ddctCgoAmt[i]);
				if (insurVslOshpCd[i] != null)
					model.setInsurVslOshpCd(insurVslOshpCd[i]);
				if (insurPlcyYr[i] != null)
					model.setInsurPlcyYr(insurPlcyYr[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (insurVslTpCd[i] != null)
					model.setInsurVslTpCd(insurVslTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEntryStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EntryStatusVO[]
	 */
	public EntryStatusVO[] getEntryStatusVOs(){
		EntryStatusVO[] vos = (EntryStatusVO[])models.toArray(new EntryStatusVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyAbbrNm = this.insurClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPtyNm = this.insurPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctCgoAmt = this.ddctCgoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslOshpCd = this.insurVslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPlcyYr = this.insurPlcyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslTpCd = this.insurVslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
