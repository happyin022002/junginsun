/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RollOverNoticeParamVO.java
*@FileTitle : RollOverNoticeParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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

public class RollOverNoticeParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RollOverNoticeParamVO> models = new ArrayList<RollOverNoticeParamVO>();
	
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String newLane = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String srepEml = null;
	/* Column Info */
	private String newVvd = null;
	/* Column Info */
	private String preLane = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RollOverNoticeParamVO() {}

	public RollOverNoticeParamVO(String ibflag, String pagerows, String bkgNo, String preLane, String newLane, String preVvd, String newVvd, String bkgOfcCd, String srepEml, String ctrtNo, String custNm) {
		this.ctrtNo = ctrtNo;
		this.bkgOfcCd = bkgOfcCd;
		this.newLane = newLane;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.custNm = custNm;
		this.preVvd = preVvd;
		this.srepEml = srepEml;
		this.newVvd = newVvd;
		this.preLane = preLane;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("new_lane", getNewLane());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("new_vvd", getNewVvd());
		this.hashColumns.put("pre_lane", getPreLane());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("new_lane", "newLane");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("new_vvd", "newVvd");
		this.hashFields.put("pre_lane", "preLane");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return newLane
	 */
	public String getNewLane() {
		return this.newLane;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return srepEml
	 */
	public String getSrepEml() {
		return this.srepEml;
	}
	
	/**
	 * Column Info
	 * @return newVvd
	 */
	public String getNewVvd() {
		return this.newVvd;
	}
	
	/**
	 * Column Info
	 * @return preLane
	 */
	public String getPreLane() {
		return this.preLane;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param newLane
	 */
	public void setNewLane(String newLane) {
		this.newLane = newLane;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param srepEml
	 */
	public void setSrepEml(String srepEml) {
		this.srepEml = srepEml;
	}
	
	/**
	 * Column Info
	 * @param newVvd
	 */
	public void setNewVvd(String newVvd) {
		this.newVvd = newVvd;
	}
	
	/**
	 * Column Info
	 * @param preLane
	 */
	public void setPreLane(String preLane) {
		this.preLane = preLane;
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
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setNewLane(JSPUtil.getParameter(request, prefix + "new_lane", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
		setNewVvd(JSPUtil.getParameter(request, prefix + "new_vvd", ""));
		setPreLane(JSPUtil.getParameter(request, prefix + "pre_lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RollOverNoticeParamVO[]
	 */
	public RollOverNoticeParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RollOverNoticeParamVO[]
	 */
	public RollOverNoticeParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RollOverNoticeParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] newLane = (JSPUtil.getParameter(request, prefix	+ "new_lane", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] newVvd = (JSPUtil.getParameter(request, prefix	+ "new_vvd", length));
			String[] preLane = (JSPUtil.getParameter(request, prefix	+ "pre_lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RollOverNoticeParamVO();
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (newLane[i] != null)
					model.setNewLane(newLane[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (srepEml[i] != null)
					model.setSrepEml(srepEml[i]);
				if (newVvd[i] != null)
					model.setNewVvd(newVvd[i]);
				if (preLane[i] != null)
					model.setPreLane(preLane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRollOverNoticeParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RollOverNoticeParamVO[]
	 */
	public RollOverNoticeParamVO[] getRollOverNoticeParamVOs(){
		RollOverNoticeParamVO[] vos = (RollOverNoticeParamVO[])models.toArray(new RollOverNoticeParamVO[models.size()]);
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
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newLane = this.newLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVvd = this.newVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preLane = this.preLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
