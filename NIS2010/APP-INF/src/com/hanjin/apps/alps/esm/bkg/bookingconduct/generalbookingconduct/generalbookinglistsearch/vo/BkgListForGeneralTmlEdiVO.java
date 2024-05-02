/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgListForGeneralTmlEdiVO.java
*@FileTitle : BkgListForGeneralTmlEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

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

public class BkgListForGeneralTmlEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForGeneralTmlEdiVO> models = new ArrayList<BkgListForGeneralTmlEdiVO>();
	
	/* Column Info */
	private String uvi = null;
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String bpXmrn = null;
	/* Column Info */
	private String firstVvd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bkgDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String sendDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fM = null;
	/* Column Info */
	private String myFwrdRefCd = null;
	/* Column Info */
	private String bkgStaffNm = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String sendUsrId = null;
	/* Column Info */
	private String crn = null;
	/* Column Info */
	private String myFwrdVslDesc = null;
	/* Column Info */
	private String bkgStaff = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgListForGeneralTmlEdiVO() {}

	public BkgListForGeneralTmlEdiVO(String ibflag, String pagerows, String bkgNo, String bkgStsCd, String fM, String firstVvd, String etb, String lane, String polCd, String polYdCd, String myFwrdRefCd, String myFwrdVslDesc, String crn, String uvi, String bkgDate, String bkgStaff, String bkgStaffNm, String sendDate, String sendUsrId, String bpXmrn) {
		this.uvi = uvi;
		this.etb = etb;
		this.bpXmrn = bpXmrn;
		this.firstVvd = firstVvd;
		this.bkgStsCd = bkgStsCd;
		this.bkgDate = bkgDate;
		this.pagerows = pagerows;
		this.lane = lane;
		this.sendDate = sendDate;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.fM = fM;
		this.myFwrdRefCd = myFwrdRefCd;
		this.bkgStaffNm = bkgStaffNm;
		this.polYdCd = polYdCd;
		this.sendUsrId = sendUsrId;
		this.crn = crn;
		this.myFwrdVslDesc = myFwrdVslDesc;
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("uvi", getUvi());
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("bp_xmrn", getBpXmrn());
		this.hashColumns.put("first_vvd", getFirstVvd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bkg_date", getBkgDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("send_date", getSendDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("f_m", getFM());
		this.hashColumns.put("my_fwrd_ref_cd", getMyFwrdRefCd());
		this.hashColumns.put("bkg_staff_nm", getBkgStaffNm());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("send_usr_id", getSendUsrId());
		this.hashColumns.put("crn", getCrn());
		this.hashColumns.put("my_fwrd_vsl_desc", getMyFwrdVslDesc());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("uvi", "uvi");
		this.hashFields.put("etb", "etb");
		this.hashFields.put("bp_xmrn", "bpXmrn");
		this.hashFields.put("first_vvd", "firstVvd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bkg_date", "bkgDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("send_date", "sendDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("f_m", "fM");
		this.hashFields.put("my_fwrd_ref_cd", "myFwrdRefCd");
		this.hashFields.put("bkg_staff_nm", "bkgStaffNm");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("send_usr_id", "sendUsrId");
		this.hashFields.put("crn", "crn");
		this.hashFields.put("my_fwrd_vsl_desc", "myFwrdVslDesc");
		this.hashFields.put("bkg_staff", "bkgStaff");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return uvi
	 */
	public String getUvi() {
		return this.uvi;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return bpXmrn
	 */
	public String getBpXmrn() {
		return this.bpXmrn;
	}
	
	/**
	 * Column Info
	 * @return firstVvd
	 */
	public String getFirstVvd() {
		return this.firstVvd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDate
	 */
	public String getBkgDate() {
		return this.bkgDate;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return sendDate
	 */
	public String getSendDate() {
		return this.sendDate;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return fM
	 */
	public String getFM() {
		return this.fM;
	}
	
	/**
	 * Column Info
	 * @return myFwrdRefCd
	 */
	public String getMyFwrdRefCd() {
		return this.myFwrdRefCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStaffNm
	 */
	public String getBkgStaffNm() {
		return this.bkgStaffNm;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return sendUsrId
	 */
	public String getSendUsrId() {
		return this.sendUsrId;
	}
	
	/**
	 * Column Info
	 * @return crn
	 */
	public String getCrn() {
		return this.crn;
	}
	
	/**
	 * Column Info
	 * @return myFwrdVslDesc
	 */
	public String getMyFwrdVslDesc() {
		return this.myFwrdVslDesc;
	}
	
	/**
	 * Column Info
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
	}
	

	/**
	 * Column Info
	 * @param uvi
	 */
	public void setUvi(String uvi) {
		this.uvi = uvi;
	}
	
	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param bpXmrn
	 */
	public void setBpXmrn(String bpXmrn) {
		this.bpXmrn = bpXmrn;
	}
	
	/**
	 * Column Info
	 * @param firstVvd
	 */
	public void setFirstVvd(String firstVvd) {
		this.firstVvd = firstVvd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDate
	 */
	public void setBkgDate(String bkgDate) {
		this.bkgDate = bkgDate;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param sendDate
	 */
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param fM
	 */
	public void setFM(String fM) {
		this.fM = fM;
	}
	
	/**
	 * Column Info
	 * @param myFwrdRefCd
	 */
	public void setMyFwrdRefCd(String myFwrdRefCd) {
		this.myFwrdRefCd = myFwrdRefCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStaffNm
	 */
	public void setBkgStaffNm(String bkgStaffNm) {
		this.bkgStaffNm = bkgStaffNm;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param sendUsrId
	 */
	public void setSendUsrId(String sendUsrId) {
		this.sendUsrId = sendUsrId;
	}
	
	/**
	 * Column Info
	 * @param crn
	 */
	public void setCrn(String crn) {
		this.crn = crn;
	}
	
	/**
	 * Column Info
	 * @param myFwrdVslDesc
	 */
	public void setMyFwrdVslDesc(String myFwrdVslDesc) {
		this.myFwrdVslDesc = myFwrdVslDesc;
	}
	
	/**
	 * Column Info
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
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
		setUvi(JSPUtil.getParameter(request, prefix + "uvi", ""));
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setBpXmrn(JSPUtil.getParameter(request, prefix + "bp_xmrn", ""));
		setFirstVvd(JSPUtil.getParameter(request, prefix + "first_vvd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBkgDate(JSPUtil.getParameter(request, prefix + "bkg_date", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setSendDate(JSPUtil.getParameter(request, prefix + "send_date", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setFM(JSPUtil.getParameter(request, prefix + "f_m", ""));
		setMyFwrdRefCd(JSPUtil.getParameter(request, prefix + "my_fwrd_ref_cd", ""));
		setBkgStaffNm(JSPUtil.getParameter(request, prefix + "bkg_staff_nm", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setSendUsrId(JSPUtil.getParameter(request, prefix + "send_usr_id", ""));
		setCrn(JSPUtil.getParameter(request, prefix + "crn", ""));
		setMyFwrdVslDesc(JSPUtil.getParameter(request, prefix + "my_fwrd_vsl_desc", ""));
		setBkgStaff(JSPUtil.getParameter(request, prefix + "bkg_staff", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForGeneralTmlEdiVO[]
	 */
	public BkgListForGeneralTmlEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForGeneralTmlEdiVO[]
	 */
	public BkgListForGeneralTmlEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForGeneralTmlEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] uvi = (JSPUtil.getParameter(request, prefix	+ "uvi", length));
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] bpXmrn = (JSPUtil.getParameter(request, prefix	+ "bp_xmrn", length));
			String[] firstVvd = (JSPUtil.getParameter(request, prefix	+ "first_vvd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bkgDate = (JSPUtil.getParameter(request, prefix	+ "bkg_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] sendDate = (JSPUtil.getParameter(request, prefix	+ "send_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] fM = (JSPUtil.getParameter(request, prefix	+ "f_m", length));
			String[] myFwrdRefCd = (JSPUtil.getParameter(request, prefix	+ "my_fwrd_ref_cd", length));
			String[] bkgStaffNm = (JSPUtil.getParameter(request, prefix	+ "bkg_staff_nm", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] sendUsrId = (JSPUtil.getParameter(request, prefix	+ "send_usr_id", length));
			String[] crn = (JSPUtil.getParameter(request, prefix	+ "crn", length));
			String[] myFwrdVslDesc = (JSPUtil.getParameter(request, prefix	+ "my_fwrd_vsl_desc", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForGeneralTmlEdiVO();
				if (uvi[i] != null)
					model.setUvi(uvi[i]);
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (bpXmrn[i] != null)
					model.setBpXmrn(bpXmrn[i]);
				if (firstVvd[i] != null)
					model.setFirstVvd(firstVvd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bkgDate[i] != null)
					model.setBkgDate(bkgDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (sendDate[i] != null)
					model.setSendDate(sendDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fM[i] != null)
					model.setFM(fM[i]);
				if (myFwrdRefCd[i] != null)
					model.setMyFwrdRefCd(myFwrdRefCd[i]);
				if (bkgStaffNm[i] != null)
					model.setBkgStaffNm(bkgStaffNm[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (sendUsrId[i] != null)
					model.setSendUsrId(sendUsrId[i]);
				if (crn[i] != null)
					model.setCrn(crn[i]);
				if (myFwrdVslDesc[i] != null)
					model.setMyFwrdVslDesc(myFwrdVslDesc[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForGeneralTmlEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForGeneralTmlEdiVO[]
	 */
	public BkgListForGeneralTmlEdiVO[] getBkgListForGeneralTmlEdiVOs(){
		BkgListForGeneralTmlEdiVO[] vos = (BkgListForGeneralTmlEdiVO[])models.toArray(new BkgListForGeneralTmlEdiVO[models.size()]);
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
		this.uvi = this.uvi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bpXmrn = this.bpXmrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstVvd = this.firstVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDate = this.bkgDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDate = this.sendDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fM = this.fM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.myFwrdRefCd = this.myFwrdRefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaffNm = this.bkgStaffNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendUsrId = this.sendUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crn = this.crn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.myFwrdVslDesc = this.myFwrdVslDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
