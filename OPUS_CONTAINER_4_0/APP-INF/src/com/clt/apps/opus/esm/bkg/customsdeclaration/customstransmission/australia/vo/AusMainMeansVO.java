/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AusMainMeansVO.java
*@FileTitle : AusMainMeansVO
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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

public class AusMainMeansVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AusMainMeansVO> models = new ArrayList<AusMainMeansVO>();

	/* Column Info */
	private String bkgDateTypeEta1 = null;
	/* Column Info */
	private String bkgDateEtd1 = null;
	/* Column Info */
	private String mainNation = null;
	/* Column Info */
	private String bkgDateTypeEta2 = null;
	/* Column Info */
	private String mainName = null;
	/* Column Info */
	private String mainMode = null;
	/* Column Info */
	private String bkgDateEtd0 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgLocBer = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mainMeansType = null;
	/* Column Info */
	private String bkgLocTypeLc1 = null;
	/* Column Info */
	private String bkgLocTypeLc2 = null;
	/* Column Info */
	private String bkgLocTypeLc0 = null;
	/* Column Info */
	private String conMainVvd = null;
	/* Column Info */
	private String mainVvd = null;
	/* Column Info */
	private String bkgDateEta2 = null;
	/* Column Info */
	private String bkgDateEta1 = null;
	/* Column Info */
	private String bkgLocLc0 = null;
	/* Column Info */
	private String mainSsr = null;
	/* Column Info */
	private String bkgLocLc1 = null;
	/* Column Info */
	private String bkgLocLc2 = null;
	/* Column Info */
	private String bkgDateTypeEtd1 = null;
	/* Column Info */
	private String mainLicense = null;
	/* Column Info */
	private String lMainId = null;
	/* Column Info */
	private String lMainIdType = null;
	/* Column Info */
	private String bkgDateTypeEtd0 = null;
	/* Column Info */
	private String bkgLocTypeBer = null;
	/* Column Info */
	private String cMainIdType = null;
	/* Column Info */
	private String cMainId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public AusMainMeansVO() {}

	public AusMainMeansVO(String ibflag, String pagerows, String bkgDateTypeEta1, String bkgDateEtd1, String mainNation, String bkgDateTypeEta2, String mainName, String mainMode, String bkgDateEtd0, String bkgLocBer, String mainMeansType, String bkgLocTypeLc1, String bkgLocTypeLc2, String bkgLocTypeLc0, String mainVvd, String conMainVvd, String bkgDateEta2, String bkgDateEta1, String bkgLocLc0, String mainSsr, String bkgLocLc1, String bkgLocLc2, String bkgDateTypeEtd1, String mainLicense, String lMainId, String lMainIdType, String bkgDateTypeEtd0, String cMainIdType, String bkgLocTypeBer, String cMainId) {
		this.bkgDateTypeEta1 = bkgDateTypeEta1;
		this.bkgDateEtd1 = bkgDateEtd1;
		this.mainNation = mainNation;
		this.bkgDateTypeEta2 = bkgDateTypeEta2;
		this.mainName = mainName;
		this.mainMode = mainMode;
		this.bkgDateEtd0 = bkgDateEtd0;
		this.pagerows = pagerows;
		this.bkgLocBer = bkgLocBer;
		this.ibflag = ibflag;
		this.mainMeansType = mainMeansType;
		this.bkgLocTypeLc1 = bkgLocTypeLc1;
		this.bkgLocTypeLc2 = bkgLocTypeLc2;
		this.bkgLocTypeLc0 = bkgLocTypeLc0;
		this.conMainVvd = conMainVvd;
		this.mainVvd = mainVvd;
		this.bkgDateEta2 = bkgDateEta2;
		this.bkgDateEta1 = bkgDateEta1;
		this.bkgLocLc0 = bkgLocLc0;
		this.mainSsr = mainSsr;
		this.bkgLocLc1 = bkgLocLc1;
		this.bkgLocLc2 = bkgLocLc2;
		this.bkgDateTypeEtd1 = bkgDateTypeEtd1;
		this.mainLicense = mainLicense;
		this.lMainId = lMainId;
		this.lMainIdType = lMainIdType;
		this.bkgDateTypeEtd0 = bkgDateTypeEtd0;
		this.bkgLocTypeBer = bkgLocTypeBer;
		this.cMainIdType = cMainIdType;
		this.cMainId = cMainId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_date_type_eta1", getBkgDateTypeEta1());
		this.hashColumns.put("bkg_date_etd1", getBkgDateEtd1());
		this.hashColumns.put("main_nation", getMainNation());
		this.hashColumns.put("bkg_date_type_eta2", getBkgDateTypeEta2());
		this.hashColumns.put("main_name", getMainName());
		this.hashColumns.put("main_mode", getMainMode());
		this.hashColumns.put("bkg_date_etd0", getBkgDateEtd0());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_loc_ber", getBkgLocBer());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("main_means_type", getMainMeansType());
		this.hashColumns.put("bkg_loc_type_lc1", getBkgLocTypeLc1());
		this.hashColumns.put("bkg_loc_type_lc2", getBkgLocTypeLc2());
		this.hashColumns.put("bkg_loc_type_lc0", getBkgLocTypeLc0());
		this.hashColumns.put("con_main_vvd", getConMainVvd());
		this.hashColumns.put("main_vvd", getMainVvd());
		this.hashColumns.put("bkg_date_eta2", getBkgDateEta2());
		this.hashColumns.put("bkg_date_eta1", getBkgDateEta1());
		this.hashColumns.put("bkg_loc_lc0", getBkgLocLc0());
		this.hashColumns.put("main_ssr", getMainSsr());
		this.hashColumns.put("bkg_loc_lc1", getBkgLocLc1());
		this.hashColumns.put("bkg_loc_lc2", getBkgLocLc2());
		this.hashColumns.put("bkg_date_type_etd1", getBkgDateTypeEtd1());
		this.hashColumns.put("main_license", getMainLicense());
		this.hashColumns.put("l_main_id", getLMainId());
		this.hashColumns.put("l_main_id_type", getLMainIdType());
		this.hashColumns.put("bkg_date_type_etd0", getBkgDateTypeEtd0());
		this.hashColumns.put("bkg_loc_type_ber", getBkgLocTypeBer());
		this.hashColumns.put("c_main_id_type", getCMainIdType());
		this.hashColumns.put("c_main_id", getCMainId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_date_type_eta1", "bkgDateTypeEta1");
		this.hashFields.put("bkg_date_etd1", "bkgDateEtd1");
		this.hashFields.put("main_nation", "mainNation");
		this.hashFields.put("bkg_date_type_eta2", "bkgDateTypeEta2");
		this.hashFields.put("main_name", "mainName");
		this.hashFields.put("main_mode", "mainMode");
		this.hashFields.put("bkg_date_etd0", "bkgDateEtd0");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_loc_ber", "bkgLocBer");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("main_means_type", "mainMeansType");
		this.hashFields.put("bkg_loc_type_lc1", "bkgLocTypeLc1");
		this.hashFields.put("bkg_loc_type_lc2", "bkgLocTypeLc2");
		this.hashFields.put("bkg_loc_type_lc0", "bkgLocTypeLc0");
		this.hashFields.put("con_main_vvd", "conMainVvd");
		this.hashFields.put("main_vvd", "mainVvd");
		this.hashFields.put("bkg_date_eta2", "bkgDateEta2");
		this.hashFields.put("bkg_date_eta1", "bkgDateEta1");
		this.hashFields.put("bkg_loc_lc0", "bkgLocLc0");
		this.hashFields.put("main_ssr", "mainSsr");
		this.hashFields.put("bkg_loc_lc1", "bkgLocLc1");
		this.hashFields.put("bkg_loc_lc2", "bkgLocLc2");
		this.hashFields.put("bkg_date_type_etd1", "bkgDateTypeEtd1");
		this.hashFields.put("main_license", "mainLicense");
		this.hashFields.put("l_main_id", "lMainId");
		this.hashFields.put("l_main_id_type", "lMainIdType");
		this.hashFields.put("bkg_date_type_etd0", "bkgDateTypeEtd0");
		this.hashFields.put("bkg_loc_type_ber", "bkgLocTypeBer");
		this.hashFields.put("c_main_id_type", "cMainIdType");
		this.hashFields.put("c_main_id", "cMainId");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return bkgDateTypeEta1
	 */
	public String getBkgDateTypeEta1() {
		return this.bkgDateTypeEta1;
	}

	/**
	 * Column Info
	 * @return bkgDateEtd1
	 */
	public String getBkgDateEtd1() {
		return this.bkgDateEtd1;
	}

	/**
	 * Column Info
	 * @return mainNation
	 */
	public String getMainNation() {
		return this.mainNation;
	}

	/**
	 * Column Info
	 * @return bkgDateTypeEta2
	 */
	public String getBkgDateTypeEta2() {
		return this.bkgDateTypeEta2;
	}

	/**
	 * Column Info
	 * @return mainName
	 */
	public String getMainName() {
		return this.mainName;
	}

	/**
	 * Column Info
	 * @return mainMode
	 */
	public String getMainMode() {
		return this.mainMode;
	}

	/**
	 * Column Info
	 * @return bkgDateEtd0
	 */
	public String getBkgDateEtd0() {
		return this.bkgDateEtd0;
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
	 * @return bkgLocBer
	 */
	public String getBkgLocBer() {
		return this.bkgLocBer;
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
	 * @return mainMeansType
	 */
	public String getMainMeansType() {
		return this.mainMeansType;
	}

	/**
	 * Column Info
	 * @return bkgLocTypeLc1
	 */
	public String getBkgLocTypeLc1() {
		return this.bkgLocTypeLc1;
	}

	/**
	 * Column Info
	 * @return bkgLocTypeLc2
	 */
	public String getBkgLocTypeLc2() {
		return this.bkgLocTypeLc2;
	}

	/**
	 * Column Info
	 * @return bkgLocTypeLc0
	 */
	public String getBkgLocTypeLc0() {
		return this.bkgLocTypeLc0;
	}

	/**
	 * Column Info
	 * @return conMainVvd
	 */
	public String getConMainVvd() {
		return this.conMainVvd;
	}

	/**
	 * Column Info
	 * @return mainVvd
	 */
	public String getMainVvd() {
		return this.mainVvd;
	}

	/**
	 * Column Info
	 * @return bkgDateEta2
	 */
	public String getBkgDateEta2() {
		return this.bkgDateEta2;
	}

	/**
	 * Column Info
	 * @return bkgDateEta1
	 */
	public String getBkgDateEta1() {
		return this.bkgDateEta1;
	}

	/**
	 * Column Info
	 * @return bkgLocLc0
	 */
	public String getBkgLocLc0() {
		return this.bkgLocLc0;
	}

	/**
	 * Column Info
	 * @return mainSsr
	 */
	public String getMainSsr() {
		return this.mainSsr;
	}

	/**
	 * Column Info
	 * @return bkgLocLc1
	 */
	public String getBkgLocLc1() {
		return this.bkgLocLc1;
	}

	/**
	 * Column Info
	 * @return bkgLocLc2
	 */
	public String getBkgLocLc2() {
		return this.bkgLocLc2;
	}

	/**
	 * Column Info
	 * @return bkgDateTypeEtd1
	 */
	public String getBkgDateTypeEtd1() {
		return this.bkgDateTypeEtd1;
	}

	/**
	 * Column Info
	 * @return mainLicense
	 */
	public String getMainLicense() {
		return this.mainLicense;
	}

	/**
	 * Column Info
	 * @return lMainId
	 */
	public String getLMainId() {
		return this.lMainId;
	}

	/**
	 * Column Info
	 * @return lMainIdType
	 */
	public String getLMainIdType() {
		return this.lMainIdType;
	}

	/**
	 * Column Info
	 * @return bkgDateTypeEtd0
	 */
	public String getBkgDateTypeEtd0() {
		return this.bkgDateTypeEtd0;
	}

	/**
	 * Column Info
	 * @return bkgLocTypeBer
	 */
	public String getBkgLocTypeBer() {
		return this.bkgLocTypeBer;
	}

	/**
	 * Column Info
	 * @return cMainIdType
	 */
	public String getCMainIdType() {
		return this.cMainIdType;
	}

	/**
	 * Column Info
	 * @return cMainId
	 */
	public String getCMainId() {
		return this.cMainId;
	}


	/**
	 * Column Info
	 * @param bkgDateTypeEta1
	 */
	public void setBkgDateTypeEta1(String bkgDateTypeEta1) {
		this.bkgDateTypeEta1 = bkgDateTypeEta1;
	}

	/**
	 * Column Info
	 * @param bkgDateEtd1
	 */
	public void setBkgDateEtd1(String bkgDateEtd1) {
		this.bkgDateEtd1 = bkgDateEtd1;
	}

	/**
	 * Column Info
	 * @param mainNation
	 */
	public void setMainNation(String mainNation) {
		this.mainNation = mainNation;
	}

	/**
	 * Column Info
	 * @param bkgDateTypeEta2
	 */
	public void setBkgDateTypeEta2(String bkgDateTypeEta2) {
		this.bkgDateTypeEta2 = bkgDateTypeEta2;
	}

	/**
	 * Column Info
	 * @param mainName
	 */
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	/**
	 * Column Info
	 * @param mainMode
	 */
	public void setMainMode(String mainMode) {
		this.mainMode = mainMode;
	}

	/**
	 * Column Info
	 * @param bkgDateEtd0
	 */
	public void setBkgDateEtd0(String bkgDateEtd0) {
		this.bkgDateEtd0 = bkgDateEtd0;
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
	 * @param bkgLocBer
	 */
	public void setBkgLocBer(String bkgLocBer) {
		this.bkgLocBer = bkgLocBer;
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
	 * @param mainMeansType
	 */
	public void setMainMeansType(String mainMeansType) {
		this.mainMeansType = mainMeansType;
	}

	/**
	 * Column Info
	 * @param bkgLocTypeLc1
	 */
	public void setBkgLocTypeLc1(String bkgLocTypeLc1) {
		this.bkgLocTypeLc1 = bkgLocTypeLc1;
	}

	/**
	 * Column Info
	 * @param bkgLocTypeLc2
	 */
	public void setBkgLocTypeLc2(String bkgLocTypeLc2) {
		this.bkgLocTypeLc2 = bkgLocTypeLc2;
	}

	/**
	 * Column Info
	 * @param bkgLocTypeLc0
	 */
	public void setBkgLocTypeLc0(String bkgLocTypeLc0) {
		this.bkgLocTypeLc0 = bkgLocTypeLc0;
	}

	/**
	 * Column Info
	 * @param conMainVvd
	 */
	public void setConMainVvd(String conMainVvd) {
		this.conMainVvd = conMainVvd;
	}

	/**
	 * Column Info
	 * @param mainVvd
	 */
	public void setMainVvd(String mainVvd) {
		this.mainVvd = mainVvd;
	}

	/**
	 * Column Info
	 * @param bkgDateEta2
	 */
	public void setBkgDateEta2(String bkgDateEta2) {
		this.bkgDateEta2 = bkgDateEta2;
	}

	/**
	 * Column Info
	 * @param bkgDateEta1
	 */
	public void setBkgDateEta1(String bkgDateEta1) {
		this.bkgDateEta1 = bkgDateEta1;
	}

	/**
	 * Column Info
	 * @param bkgLocLc0
	 */
	public void setBkgLocLc0(String bkgLocLc0) {
		this.bkgLocLc0 = bkgLocLc0;
	}

	/**
	 * Column Info
	 * @param mainSsr
	 */
	public void setMainSsr(String mainSsr) {
		this.mainSsr = mainSsr;
	}

	/**
	 * Column Info
	 * @param bkgLocLc1
	 */
	public void setBkgLocLc1(String bkgLocLc1) {
		this.bkgLocLc1 = bkgLocLc1;
	}

	/**
	 * Column Info
	 * @param bkgLocLc2
	 */
	public void setBkgLocLc2(String bkgLocLc2) {
		this.bkgLocLc2 = bkgLocLc2;
	}

	/**
	 * Column Info
	 * @param bkgDateTypeEtd1
	 */
	public void setBkgDateTypeEtd1(String bkgDateTypeEtd1) {
		this.bkgDateTypeEtd1 = bkgDateTypeEtd1;
	}

	/**
	 * Column Info
	 * @param mainLicense
	 */
	public void setMainLicense(String mainLicense) {
		this.mainLicense = mainLicense;
	}

	/**
	 * Column Info
	 * @param lMainId
	 */
	public void setLMainId(String lMainId) {
		this.lMainId = lMainId;
	}

	/**
	 * Column Info
	 * @param lMainIdType
	 */
	public void setLMainIdType(String lMainIdType) {
		this.lMainIdType = lMainIdType;
	}

	/**
	 * Column Info
	 * @param bkgDateTypeEtd0
	 */
	public void setBkgDateTypeEtd0(String bkgDateTypeEtd0) {
		this.bkgDateTypeEtd0 = bkgDateTypeEtd0;
	}

	/**
	 * Column Info
	 * @param bkgLocTypeBer
	 */
	public void setBkgLocTypeBer(String bkgLocTypeBer) {
		this.bkgLocTypeBer = bkgLocTypeBer;
	}

	/**
	 * Column Info
	 * @param cMainIdType
	 */
	public void setCMainIdType(String cMainIdType) {
		this.cMainIdType = cMainIdType;
	}

	/**
	 * Column Info
	 * @param cMainId
	 */
	public void setCMainId(String cMainId) {
		this.cMainId = cMainId;
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
		setBkgDateTypeEta1(JSPUtil.getParameter(request, prefix + "bkg_date_type_eta1", ""));
		setBkgDateEtd1(JSPUtil.getParameter(request, prefix + "bkg_date_etd1", ""));
		setMainNation(JSPUtil.getParameter(request, prefix + "main_nation", ""));
		setBkgDateTypeEta2(JSPUtil.getParameter(request, prefix + "bkg_date_type_eta2", ""));
		setMainName(JSPUtil.getParameter(request, prefix + "main_name", ""));
		setMainMode(JSPUtil.getParameter(request, prefix + "main_mode", ""));
		setBkgDateEtd0(JSPUtil.getParameter(request, prefix + "bkg_date_etd0", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgLocBer(JSPUtil.getParameter(request, prefix + "bkg_loc_ber", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMainMeansType(JSPUtil.getParameter(request, prefix + "main_means_type", ""));
		setBkgLocTypeLc1(JSPUtil.getParameter(request, prefix + "bkg_loc_type_lc1", ""));
		setBkgLocTypeLc2(JSPUtil.getParameter(request, prefix + "bkg_loc_type_lc2", ""));
		setBkgLocTypeLc0(JSPUtil.getParameter(request, prefix + "bkg_loc_type_lc0", ""));
		setConMainVvd(JSPUtil.getParameter(request, prefix + "con_main_vvd", ""));
		setMainVvd(JSPUtil.getParameter(request, prefix + "main_vvd", ""));
		setBkgDateEta2(JSPUtil.getParameter(request, prefix + "bkg_date_eta2", ""));
		setBkgDateEta1(JSPUtil.getParameter(request, prefix + "bkg_date_eta1", ""));
		setBkgLocLc0(JSPUtil.getParameter(request, prefix + "bkg_loc_lc0", ""));
		setMainSsr(JSPUtil.getParameter(request, prefix + "main_ssr", ""));
		setBkgLocLc1(JSPUtil.getParameter(request, prefix + "bkg_loc_lc1", ""));
		setBkgLocLc2(JSPUtil.getParameter(request, prefix + "bkg_loc_lc2", ""));
		setBkgDateTypeEtd1(JSPUtil.getParameter(request, prefix + "bkg_date_type_etd1", ""));
		setMainLicense(JSPUtil.getParameter(request, prefix + "main_license", ""));
		setLMainId(JSPUtil.getParameter(request, prefix + "l_main_id", ""));
		setLMainIdType(JSPUtil.getParameter(request, prefix + "l_main_id_type", ""));
		setBkgDateTypeEtd0(JSPUtil.getParameter(request, prefix + "bkg_date_type_etd0", ""));
		setBkgLocTypeBer(JSPUtil.getParameter(request, prefix + "bkg_loc_type_ber", ""));
		setCMainIdType(JSPUtil.getParameter(request, prefix + "c_main_id_type", ""));
		setCMainId(JSPUtil.getParameter(request, prefix + "c_main_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusMainMeansVO[]
	 */
	public AusMainMeansVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AusMainMeansVO[]
	 */
	public AusMainMeansVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusMainMeansVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgDateTypeEta1 = (JSPUtil.getParameter(request, prefix	+ "bkg_date_type_eta1", length));
			String[] bkgDateEtd1 = (JSPUtil.getParameter(request, prefix	+ "bkg_date_etd1", length));
			String[] mainNation = (JSPUtil.getParameter(request, prefix	+ "main_nation", length));
			String[] bkgDateTypeEta2 = (JSPUtil.getParameter(request, prefix	+ "bkg_date_type_eta2", length));
			String[] mainName = (JSPUtil.getParameter(request, prefix	+ "main_name", length));
			String[] mainMode = (JSPUtil.getParameter(request, prefix	+ "main_mode", length));
			String[] bkgDateEtd0 = (JSPUtil.getParameter(request, prefix	+ "bkg_date_etd0", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgLocBer = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_ber", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mainMeansType = (JSPUtil.getParameter(request, prefix	+ "main_means_type", length));
			String[] bkgLocTypeLc1 = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_type_lc1", length));
			String[] bkgLocTypeLc2 = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_type_lc2", length));
			String[] bkgLocTypeLc0 = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_type_lc0", length));
			String[] conMainVvd = (JSPUtil.getParameter(request, prefix	+ "con_main_vvd", length));
			String[] mainVvd = (JSPUtil.getParameter(request, prefix	+ "main_vvd", length));
			String[] bkgDateEta2 = (JSPUtil.getParameter(request, prefix	+ "bkg_date_eta2", length));
			String[] bkgDateEta1 = (JSPUtil.getParameter(request, prefix	+ "bkg_date_eta1", length));
			String[] bkgLocLc0 = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_lc0", length));
			String[] mainSsr = (JSPUtil.getParameter(request, prefix	+ "main_ssr", length));
			String[] bkgLocLc1 = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_lc1", length));
			String[] bkgLocLc2 = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_lc2", length));
			String[] bkgDateTypeEtd1 = (JSPUtil.getParameter(request, prefix	+ "bkg_date_type_etd1", length));
			String[] mainLicense = (JSPUtil.getParameter(request, prefix	+ "main_license", length));
			String[] lMainId = (JSPUtil.getParameter(request, prefix	+ "l_main_id", length));
			String[] lMainIdType = (JSPUtil.getParameter(request, prefix	+ "l_main_id_type", length));
			String[] bkgDateTypeEtd0 = (JSPUtil.getParameter(request, prefix	+ "bkg_date_type_etd0", length));
			String[] bkgLocTypeBer = (JSPUtil.getParameter(request, prefix	+ "bkg_loc_type_ber", length));
			String[] cMainIdType = (JSPUtil.getParameter(request, prefix	+ "c_main_id_type", length));
			String[] cMainId = (JSPUtil.getParameter(request, prefix	+ "c_main_id", length));

			for (int i = 0; i < length; i++) {
				model = new AusMainMeansVO();
				if (bkgDateTypeEta1[i] != null)
					model.setBkgDateTypeEta1(bkgDateTypeEta1[i]);
				if (bkgDateEtd1[i] != null)
					model.setBkgDateEtd1(bkgDateEtd1[i]);
				if (mainNation[i] != null)
					model.setMainNation(mainNation[i]);
				if (bkgDateTypeEta2[i] != null)
					model.setBkgDateTypeEta2(bkgDateTypeEta2[i]);
				if (mainName[i] != null)
					model.setMainName(mainName[i]);
				if (mainMode[i] != null)
					model.setMainMode(mainMode[i]);
				if (bkgDateEtd0[i] != null)
					model.setBkgDateEtd0(bkgDateEtd0[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgLocBer[i] != null)
					model.setBkgLocBer(bkgLocBer[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mainMeansType[i] != null)
					model.setMainMeansType(mainMeansType[i]);
				if (bkgLocTypeLc1[i] != null)
					model.setBkgLocTypeLc1(bkgLocTypeLc1[i]);
				if (bkgLocTypeLc2[i] != null)
					model.setBkgLocTypeLc2(bkgLocTypeLc2[i]);
				if (bkgLocTypeLc0[i] != null)
					model.setBkgLocTypeLc0(bkgLocTypeLc0[i]);
				if (conMainVvd[i] != null)
					model.setConMainVvd(conMainVvd[i]);
				if (mainVvd[i] != null)
					model.setMainVvd(mainVvd[i]);
				if (bkgDateEta2[i] != null)
					model.setBkgDateEta2(bkgDateEta2[i]);
				if (bkgDateEta1[i] != null)
					model.setBkgDateEta1(bkgDateEta1[i]);
				if (bkgLocLc0[i] != null)
					model.setBkgLocLc0(bkgLocLc0[i]);
				if (mainSsr[i] != null)
					model.setMainSsr(mainSsr[i]);
				if (bkgLocLc1[i] != null)
					model.setBkgLocLc1(bkgLocLc1[i]);
				if (bkgLocLc2[i] != null)
					model.setBkgLocLc2(bkgLocLc2[i]);
				if (bkgDateTypeEtd1[i] != null)
					model.setBkgDateTypeEtd1(bkgDateTypeEtd1[i]);
				if (mainLicense[i] != null)
					model.setMainLicense(mainLicense[i]);
				if (lMainId[i] != null)
					model.setLMainId(lMainId[i]);
				if (lMainIdType[i] != null)
					model.setLMainIdType(lMainIdType[i]);
				if (bkgDateTypeEtd0[i] != null)
					model.setBkgDateTypeEtd0(bkgDateTypeEtd0[i]);
				if (bkgLocTypeBer[i] != null)
					model.setBkgLocTypeBer(bkgLocTypeBer[i]);
				if (cMainIdType[i] != null)
					model.setCMainIdType(cMainIdType[i]);
				if (cMainId[i] != null)
					model.setCMainId(cMainId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusMainMeansVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusMainMeansVO[]
	 */
	public AusMainMeansVO[] getAusMainMeansVOs(){
		AusMainMeansVO[] vos = (AusMainMeansVO[])models.toArray(new AusMainMeansVO[models.size()]);
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
		this.bkgDateTypeEta1 = this.bkgDateTypeEta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateEtd1 = this.bkgDateEtd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainNation = this.mainNation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateTypeEta2 = this.bkgDateTypeEta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainName = this.mainName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainMode = this.mainMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateEtd0 = this.bkgDateEtd0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocBer = this.bkgLocBer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainMeansType = this.mainMeansType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocTypeLc1 = this.bkgLocTypeLc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocTypeLc2 = this.bkgLocTypeLc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocTypeLc0 = this.bkgLocTypeLc0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conMainVvd = this.conMainVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainVvd = this.mainVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateEta2 = this.bkgDateEta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateEta1 = this.bkgDateEta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocLc0 = this.bkgLocLc0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainSsr = this.mainSsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocLc1 = this.bkgLocLc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocLc2 = this.bkgLocLc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateTypeEtd1 = this.bkgDateTypeEtd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainLicense = this.mainLicense .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lMainId = this.lMainId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lMainIdType = this.lMainIdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateTypeEtd0 = this.bkgDateTypeEtd0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLocTypeBer = this.bkgLocTypeBer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cMainIdType = this.cMainIdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cMainId = this.cMainId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
