/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselInfoVO.java
*@FileTitle : VesselInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
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

public class VesselInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VesselInfoVO> models = new ArrayList<VesselInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String fnlEtaDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String voyYr = null;
	/* Column Info */
	private String cssmVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VesselInfoVO() {}

	public VesselInfoVO(String ibflag, String pagerows, String vslCd, String lloydNo, String vslEngNm, String fnlEtaDt, String voyYr, String skdVoyNo, String cssmVoyNo, String skdDirCd) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.lloydNo = lloydNo;
		this.vslEngNm = vslEngNm;
		this.fnlEtaDt = fnlEtaDt;
		this.skdVoyNo = skdVoyNo;
		this.voyYr = voyYr;
		this.cssmVoyNo = cssmVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("fnl_eta_dt", getFnlEtaDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("voy_yr", getVoyYr());
		this.hashColumns.put("cssm_voy_no", getCssmVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("fnl_eta_dt", "fnlEtaDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("voy_yr", "voyYr");
		this.hashFields.put("cssm_voy_no", "cssmVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return fnlEtaDt
	 */
	public String getFnlEtaDt() {
		return this.fnlEtaDt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return voyYr
	 */
	public String getVoyYr() {
		return this.voyYr;
	}
	
	/**
	 * Column Info
	 * @return cssmVoyNo
	 */
	public String getCssmVoyNo() {
		return this.cssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param fnlEtaDt
	 */
	public void setFnlEtaDt(String fnlEtaDt) {
		this.fnlEtaDt = fnlEtaDt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param voyYr
	 */
	public void setVoyYr(String voyYr) {
		this.voyYr = voyYr;
	}
	
	/**
	 * Column Info
	 * @param cssmVoyNo
	 */
	public void setCssmVoyNo(String cssmVoyNo) {
		this.cssmVoyNo = cssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setFnlEtaDt(JSPUtil.getParameter(request, prefix + "fnl_eta_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVoyYr(JSPUtil.getParameter(request, prefix + "voy_yr", ""));
		setCssmVoyNo(JSPUtil.getParameter(request, prefix + "cssm_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VesselInfoVO[]
	 */
	public VesselInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselInfoVO[]
	 */
	public VesselInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VesselInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] fnlEtaDt = (JSPUtil.getParameter(request, prefix	+ "fnl_eta_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] voyYr = (JSPUtil.getParameter(request, prefix	+ "voy_yr", length));
			String[] cssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "cssm_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VesselInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (fnlEtaDt[i] != null)
					model.setFnlEtaDt(fnlEtaDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (voyYr[i] != null)
					model.setVoyYr(voyYr[i]);
				if (cssmVoyNo[i] != null)
					model.setCssmVoyNo(cssmVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVesselInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VesselInfoVO[]
	 */
	public VesselInfoVO[] getVesselInfoVOs(){
		VesselInfoVO[] vos = (VesselInfoVO[])models.toArray(new VesselInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlEtaDt = this.fnlEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyYr = this.voyYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cssmVoyNo = this.cssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
