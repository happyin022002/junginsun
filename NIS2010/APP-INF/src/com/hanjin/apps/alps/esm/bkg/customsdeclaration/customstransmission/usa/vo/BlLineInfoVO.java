/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlLineInfoVO.java
*@FileTitle : BlLineInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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

public class BlLineInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlLineInfoVO> models = new ArrayList<BlLineInfoVO>();
	
	/* Column Info */
	private String itItno = null;
	/* Column Info */
	private String b01 = null;
	/* Column Info */
	private String actFileSkdDirCd = null;
	/* Column Info */
	private String mfNo = null;
	/* Column Info */
	private String b04 = null;
	/* Column Info */
	private String b02 = null;
	/* Column Info */
	private String b042 = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String itPkgQty = null;
	/* Column Info */
	private String itHub = null;
	/* Column Info */
	private String mfStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String itIttype = null;
	/* Column Info */
	private String itIpiLocal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String itPkgAms = null;
	/* Column Info */
	private String itDel = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String itLstUsa = null;
	/* Column Info */
	private String b04isf5 = null;
	/* Column Info */
	private String cstmsLocCd = null;
	/* Column Info */
	private String amsCode = null;
	/* Column Info */
	private String b01isf5 = null;
	/* Column Info */
	private String bookingPodCd = null;
	/* Column Info */
	private String fpodCd = null;
	/* Column Info */
	private String wgtVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlLineInfoVO() {}

	public BlLineInfoVO(String ibflag, String pagerows, String b01, String b01isf5, String itItno, String itIttype, String itHub, String itLstUsa, String itDel, String wgtVal, String itPkgQty, String itPkgAms, String itIpiLocal, String cmdtCd, String amsCode, String b02, String b04, String b042, String b04isf5, String mfNo, String blNo, String actFileSkdDirCd, String fpodCd, String bookingPodCd, String mfStsCd, String cstmsLocCd) {
		this.itItno = itItno;
		this.b01 = b01;
		this.actFileSkdDirCd = actFileSkdDirCd;
		this.mfNo = mfNo;
		this.b04 = b04;
		this.b02 = b02;
		this.b042 = b042;
		this.blNo = blNo;
		this.itPkgQty = itPkgQty;
		this.itHub = itHub;
		this.mfStsCd = mfStsCd;
		this.pagerows = pagerows;
		this.itIttype = itIttype;
		this.itIpiLocal = itIpiLocal;
		this.ibflag = ibflag;
		this.itPkgAms = itPkgAms;
		this.itDel = itDel;
		this.cmdtCd = cmdtCd;
		this.itLstUsa = itLstUsa;
		this.b04isf5 = b04isf5;
		this.cstmsLocCd = cstmsLocCd;
		this.amsCode = amsCode;
		this.b01isf5 = b01isf5;
		this.bookingPodCd = bookingPodCd;
		this.fpodCd = fpodCd;
		this.wgtVal = wgtVal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("it_itno", getItItno());
		this.hashColumns.put("b01", getB01());
		this.hashColumns.put("act_file_skd_dir_cd", getActFileSkdDirCd());
		this.hashColumns.put("mf_no", getMfNo());
		this.hashColumns.put("b04", getB04());
		this.hashColumns.put("b02", getB02());
		this.hashColumns.put("b04_2", getB042());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("it_pkg_qty", getItPkgQty());
		this.hashColumns.put("it_hub", getItHub());
		this.hashColumns.put("mf_sts_cd", getMfStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("it_ittype", getItIttype());
		this.hashColumns.put("it_ipi_local", getItIpiLocal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("it_pkg_ams", getItPkgAms());
		this.hashColumns.put("it_del", getItDel());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("it_lst_usa", getItLstUsa());
		this.hashColumns.put("b04isf5", getB04isf5());
		this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
		this.hashColumns.put("ams_code", getAmsCode());
		this.hashColumns.put("b01isf5", getB01isf5());
		this.hashColumns.put("booking_pod_cd", getBookingPodCd());
		this.hashColumns.put("fpod_cd", getFpodCd());
		this.hashColumns.put("wgt_val", getWgtVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("it_itno", "itItno");
		this.hashFields.put("b01", "b01");
		this.hashFields.put("act_file_skd_dir_cd", "actFileSkdDirCd");
		this.hashFields.put("mf_no", "mfNo");
		this.hashFields.put("b04", "b04");
		this.hashFields.put("b02", "b02");
		this.hashFields.put("b04_2", "b042");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("it_pkg_qty", "itPkgQty");
		this.hashFields.put("it_hub", "itHub");
		this.hashFields.put("mf_sts_cd", "mfStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("it_ittype", "itIttype");
		this.hashFields.put("it_ipi_local", "itIpiLocal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("it_pkg_ams", "itPkgAms");
		this.hashFields.put("it_del", "itDel");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("it_lst_usa", "itLstUsa");
		this.hashFields.put("b04isf5", "b04isf5");
		this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
		this.hashFields.put("ams_code", "amsCode");
		this.hashFields.put("b01isf5", "b01isf5");
		this.hashFields.put("booking_pod_cd", "bookingPodCd");
		this.hashFields.put("fpod_cd", "fpodCd");
		this.hashFields.put("wgt_val", "wgtVal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return itItno
	 */
	public String getItItno() {
		return this.itItno;
	}
	
	/**
	 * Column Info
	 * @return b01
	 */
	public String getB01() {
		return this.b01;
	}
	
	/**
	 * Column Info
	 * @return actFileSkdDirCd
	 */
	public String getActFileSkdDirCd() {
		return this.actFileSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return mfNo
	 */
	public String getMfNo() {
		return this.mfNo;
	}
	
	/**
	 * Column Info
	 * @return b04
	 */
	public String getB04() {
		return this.b04;
	}
	
	/**
	 * Column Info
	 * @return b02
	 */
	public String getB02() {
		return this.b02;
	}
	
	/**
	 * Column Info
	 * @return b042
	 */
	public String getB042() {
		return this.b042;
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
	 * @return itPkgQty
	 */
	public String getItPkgQty() {
		return this.itPkgQty;
	}
	
	/**
	 * Column Info
	 * @return itHub
	 */
	public String getItHub() {
		return this.itHub;
	}
	
	/**
	 * Column Info
	 * @return mfStsCd
	 */
	public String getMfStsCd() {
		return this.mfStsCd;
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
	 * @return itIttype
	 */
	public String getItIttype() {
		return this.itIttype;
	}
	
	/**
	 * Column Info
	 * @return itIpiLocal
	 */
	public String getItIpiLocal() {
		return this.itIpiLocal;
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
	 * @return itPkgAms
	 */
	public String getItPkgAms() {
		return this.itPkgAms;
	}
	
	/**
	 * Column Info
	 * @return itDel
	 */
	public String getItDel() {
		return this.itDel;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return itLstUsa
	 */
	public String getItLstUsa() {
		return this.itLstUsa;
	}
	
	/**
	 * Column Info
	 * @return b04isf5
	 */
	public String getB04isf5() {
		return this.b04isf5;
	}
	
	/**
	 * Column Info
	 * @return cstmsLocCd
	 */
	public String getCstmsLocCd() {
		return this.cstmsLocCd;
	}
	
	/**
	 * Column Info
	 * @return amsCode
	 */
	public String getAmsCode() {
		return this.amsCode;
	}
	
	/**
	 * Column Info
	 * @return b01isf5
	 */
	public String getB01isf5() {
		return this.b01isf5;
	}
	
	/**
	 * Column Info
	 * @return bookingPodCd
	 */
	public String getBookingPodCd() {
		return this.bookingPodCd;
	}
	
	/**
	 * Column Info
	 * @return fpodCd
	 */
	public String getFpodCd() {
		return this.fpodCd;
	}
	
	/**
	 * Column Info
	 * @return wgtVal
	 */
	public String getWgtVal() {
		return this.wgtVal;
	}
	

	/**
	 * Column Info
	 * @param itItno
	 */
	public void setItItno(String itItno) {
		this.itItno = itItno;
	}
	
	/**
	 * Column Info
	 * @param b01
	 */
	public void setB01(String b01) {
		this.b01 = b01;
	}
	
	/**
	 * Column Info
	 * @param actFileSkdDirCd
	 */
	public void setActFileSkdDirCd(String actFileSkdDirCd) {
		this.actFileSkdDirCd = actFileSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param mfNo
	 */
	public void setMfNo(String mfNo) {
		this.mfNo = mfNo;
	}
	
	/**
	 * Column Info
	 * @param b04
	 */
	public void setB04(String b04) {
		this.b04 = b04;
	}
	
	/**
	 * Column Info
	 * @param b02
	 */
	public void setB02(String b02) {
		this.b02 = b02;
	}
	
	/**
	 * Column Info
	 * @param b042
	 */
	public void setB042(String b042) {
		this.b042 = b042;
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
	 * @param itPkgQty
	 */
	public void setItPkgQty(String itPkgQty) {
		this.itPkgQty = itPkgQty;
	}
	
	/**
	 * Column Info
	 * @param itHub
	 */
	public void setItHub(String itHub) {
		this.itHub = itHub;
	}
	
	/**
	 * Column Info
	 * @param mfStsCd
	 */
	public void setMfStsCd(String mfStsCd) {
		this.mfStsCd = mfStsCd;
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
	 * @param itIttype
	 */
	public void setItIttype(String itIttype) {
		this.itIttype = itIttype;
	}
	
	/**
	 * Column Info
	 * @param itIpiLocal
	 */
	public void setItIpiLocal(String itIpiLocal) {
		this.itIpiLocal = itIpiLocal;
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
	 * @param itPkgAms
	 */
	public void setItPkgAms(String itPkgAms) {
		this.itPkgAms = itPkgAms;
	}
	
	/**
	 * Column Info
	 * @param itDel
	 */
	public void setItDel(String itDel) {
		this.itDel = itDel;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param itLstUsa
	 */
	public void setItLstUsa(String itLstUsa) {
		this.itLstUsa = itLstUsa;
	}
	
	/**
	 * Column Info
	 * @param b04isf5
	 */
	public void setB04isf5(String b04isf5) {
		this.b04isf5 = b04isf5;
	}
	
	/**
	 * Column Info
	 * @param cstmsLocCd
	 */
	public void setCstmsLocCd(String cstmsLocCd) {
		this.cstmsLocCd = cstmsLocCd;
	}
	
	/**
	 * Column Info
	 * @param amsCode
	 */
	public void setAmsCode(String amsCode) {
		this.amsCode = amsCode;
	}
	
	/**
	 * Column Info
	 * @param b01isf5
	 */
	public void setB01isf5(String b01isf5) {
		this.b01isf5 = b01isf5;
	}
	
	/**
	 * Column Info
	 * @param bookingPodCd
	 */
	public void setBookingPodCd(String bookingPodCd) {
		this.bookingPodCd = bookingPodCd;
	}
	
	/**
	 * Column Info
	 * @param fpodCd
	 */
	public void setFpodCd(String fpodCd) {
		this.fpodCd = fpodCd;
	}
	
	/**
	 * Column Info
	 * @param wgtVal
	 */
	public void setWgtVal(String wgtVal) {
		this.wgtVal = wgtVal;
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
		setItItno(JSPUtil.getParameter(request, prefix + "it_itno", ""));
		setB01(JSPUtil.getParameter(request, prefix + "b01", ""));
		setActFileSkdDirCd(JSPUtil.getParameter(request, prefix + "act_file_skd_dir_cd", ""));
		setMfNo(JSPUtil.getParameter(request, prefix + "mf_no", ""));
		setB04(JSPUtil.getParameter(request, prefix + "b04", ""));
		setB02(JSPUtil.getParameter(request, prefix + "b02", ""));
		setB042(JSPUtil.getParameter(request, prefix + "b04_2", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setItPkgQty(JSPUtil.getParameter(request, prefix + "it_pkg_qty", ""));
		setItHub(JSPUtil.getParameter(request, prefix + "it_hub", ""));
		setMfStsCd(JSPUtil.getParameter(request, prefix + "mf_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setItIttype(JSPUtil.getParameter(request, prefix + "it_ittype", ""));
		setItIpiLocal(JSPUtil.getParameter(request, prefix + "it_ipi_local", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setItPkgAms(JSPUtil.getParameter(request, prefix + "it_pkg_ams", ""));
		setItDel(JSPUtil.getParameter(request, prefix + "it_del", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setItLstUsa(JSPUtil.getParameter(request, prefix + "it_lst_usa", ""));
		setB04isf5(JSPUtil.getParameter(request, prefix + "b04isf5", ""));
		setCstmsLocCd(JSPUtil.getParameter(request, prefix + "cstms_loc_cd", ""));
		setAmsCode(JSPUtil.getParameter(request, prefix + "ams_code", ""));
		setB01isf5(JSPUtil.getParameter(request, prefix + "b01isf5", ""));
		setBookingPodCd(JSPUtil.getParameter(request, prefix + "booking_pod_cd", ""));
		setFpodCd(JSPUtil.getParameter(request, prefix + "fpod_cd", ""));
		setWgtVal(JSPUtil.getParameter(request, prefix + "wgt_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlLineInfoVO[]
	 */
	public BlLineInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlLineInfoVO[]
	 */
	public BlLineInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlLineInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] itItno = (JSPUtil.getParameter(request, prefix	+ "it_itno", length));
			String[] b01 = (JSPUtil.getParameter(request, prefix	+ "b01", length));
			String[] actFileSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "act_file_skd_dir_cd", length));
			String[] mfNo = (JSPUtil.getParameter(request, prefix	+ "mf_no", length));
			String[] b04 = (JSPUtil.getParameter(request, prefix	+ "b04", length));
			String[] b02 = (JSPUtil.getParameter(request, prefix	+ "b02", length));
			String[] b042 = (JSPUtil.getParameter(request, prefix	+ "b04_2", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] itPkgQty = (JSPUtil.getParameter(request, prefix	+ "it_pkg_qty", length));
			String[] itHub = (JSPUtil.getParameter(request, prefix	+ "it_hub", length));
			String[] mfStsCd = (JSPUtil.getParameter(request, prefix	+ "mf_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] itIttype = (JSPUtil.getParameter(request, prefix	+ "it_ittype", length));
			String[] itIpiLocal = (JSPUtil.getParameter(request, prefix	+ "it_ipi_local", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] itPkgAms = (JSPUtil.getParameter(request, prefix	+ "it_pkg_ams", length));
			String[] itDel = (JSPUtil.getParameter(request, prefix	+ "it_del", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] itLstUsa = (JSPUtil.getParameter(request, prefix	+ "it_lst_usa", length));
			String[] b04isf5 = (JSPUtil.getParameter(request, prefix	+ "b04isf5", length));
			String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_cd", length));
			String[] amsCode = (JSPUtil.getParameter(request, prefix	+ "ams_code", length));
			String[] b01isf5 = (JSPUtil.getParameter(request, prefix	+ "b01isf5", length));
			String[] bookingPodCd = (JSPUtil.getParameter(request, prefix	+ "booking_pod_cd", length));
			String[] fpodCd = (JSPUtil.getParameter(request, prefix	+ "fpod_cd", length));
			String[] wgtVal = (JSPUtil.getParameter(request, prefix	+ "wgt_val", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlLineInfoVO();
				if (itItno[i] != null)
					model.setItItno(itItno[i]);
				if (b01[i] != null)
					model.setB01(b01[i]);
				if (actFileSkdDirCd[i] != null)
					model.setActFileSkdDirCd(actFileSkdDirCd[i]);
				if (mfNo[i] != null)
					model.setMfNo(mfNo[i]);
				if (b04[i] != null)
					model.setB04(b04[i]);
				if (b02[i] != null)
					model.setB02(b02[i]);
				if (b042[i] != null)
					model.setB042(b042[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (itPkgQty[i] != null)
					model.setItPkgQty(itPkgQty[i]);
				if (itHub[i] != null)
					model.setItHub(itHub[i]);
				if (mfStsCd[i] != null)
					model.setMfStsCd(mfStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (itIttype[i] != null)
					model.setItIttype(itIttype[i]);
				if (itIpiLocal[i] != null)
					model.setItIpiLocal(itIpiLocal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (itPkgAms[i] != null)
					model.setItPkgAms(itPkgAms[i]);
				if (itDel[i] != null)
					model.setItDel(itDel[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (itLstUsa[i] != null)
					model.setItLstUsa(itLstUsa[i]);
				if (b04isf5[i] != null)
					model.setB04isf5(b04isf5[i]);
				if (cstmsLocCd[i] != null)
					model.setCstmsLocCd(cstmsLocCd[i]);
				if (amsCode[i] != null)
					model.setAmsCode(amsCode[i]);
				if (b01isf5[i] != null)
					model.setB01isf5(b01isf5[i]);
				if (bookingPodCd[i] != null)
					model.setBookingPodCd(bookingPodCd[i]);
				if (fpodCd[i] != null)
					model.setFpodCd(fpodCd[i]);
				if (wgtVal[i] != null)
					model.setWgtVal(wgtVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlLineInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlLineInfoVO[]
	 */
	public BlLineInfoVO[] getBlLineInfoVOs(){
		BlLineInfoVO[] vos = (BlLineInfoVO[])models.toArray(new BlLineInfoVO[models.size()]);
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
		this.itItno = this.itItno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b01 = this.b01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFileSkdDirCd = this.actFileSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfNo = this.mfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b04 = this.b04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b02 = this.b02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b042 = this.b042 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itPkgQty = this.itPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itHub = this.itHub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfStsCd = this.mfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itIttype = this.itIttype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itIpiLocal = this.itIpiLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itPkgAms = this.itPkgAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itDel = this.itDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itLstUsa = this.itLstUsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b04isf5 = this.b04isf5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocCd = this.cstmsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsCode = this.amsCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b01isf5 = this.b01isf5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingPodCd = this.bookingPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpodCd = this.fpodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtVal = this.wgtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
