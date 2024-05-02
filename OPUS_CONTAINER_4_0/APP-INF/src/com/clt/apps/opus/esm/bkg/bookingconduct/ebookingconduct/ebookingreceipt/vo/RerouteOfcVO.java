/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RerouteOfcVO.java
*@FileTitle : RerouteOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.14
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.10.14 이도형 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RerouteOfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RerouteOfcVO> models = new ArrayList<RerouteOfcVO>();
	
	/* Column Info */
	private String bkgNtfcEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String siNtfcEml = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RerouteOfcVO() {}

	public RerouteOfcVO(String ibflag, String pagerows, String hndlOfcCd, String ofcEngNm, String bkgNtfcEml, String siNtfcEml, String actDt) {
		this.bkgNtfcEml = bkgNtfcEml;
		this.ibflag = ibflag;
		this.actDt = actDt;
		this.ofcEngNm = ofcEngNm;
		this.siNtfcEml = siNtfcEml;
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ntfc_eml", getBkgNtfcEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("si_ntfc_eml", getSiNtfcEml());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ntfc_eml", "bkgNtfcEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("si_ntfc_eml", "siNtfcEml");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNtfcEml
	 */
	public String getBkgNtfcEml() {
		return this.bkgNtfcEml;
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
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return siNtfcEml
	 */
	public String getSiNtfcEml() {
		return this.siNtfcEml;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
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
	 * @param bkgNtfcEml
	 */
	public void setBkgNtfcEml(String bkgNtfcEml) {
		this.bkgNtfcEml = bkgNtfcEml;
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
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param siNtfcEml
	 */
	public void setSiNtfcEml(String siNtfcEml) {
		this.siNtfcEml = siNtfcEml;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
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
		setBkgNtfcEml(JSPUtil.getParameter(request, prefix + "bkg_ntfc_eml", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setSiNtfcEml(JSPUtil.getParameter(request, prefix + "si_ntfc_eml", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RerouteOfcVO[]
	 */
	public RerouteOfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RerouteOfcVO[]
	 */
	public RerouteOfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RerouteOfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNtfcEml = (JSPUtil.getParameter(request, prefix	+ "bkg_ntfc_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] siNtfcEml = (JSPUtil.getParameter(request, prefix	+ "si_ntfc_eml", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RerouteOfcVO();
				if (bkgNtfcEml[i] != null)
					model.setBkgNtfcEml(bkgNtfcEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (siNtfcEml[i] != null)
					model.setSiNtfcEml(siNtfcEml[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRerouteOfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RerouteOfcVO[]
	 */
	public RerouteOfcVO[] getRerouteOfcVOs(){
		RerouteOfcVO[] vos = (RerouteOfcVO[])models.toArray(new RerouteOfcVO[models.size()]);
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
		this.bkgNtfcEml = this.bkgNtfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siNtfcEml = this.siNtfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
