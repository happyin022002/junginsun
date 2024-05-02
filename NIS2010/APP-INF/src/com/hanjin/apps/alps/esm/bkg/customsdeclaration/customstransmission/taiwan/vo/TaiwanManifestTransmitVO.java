/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanManifestTransmitVO.java
*@FileTitle : TaiwanManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.22 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaiwanManifestTransmitVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaiwanManifestTransmitVO> models = new ArrayList<TaiwanManifestTransmitVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String amendBl = null;
	/* Column Info */
	private String st9 = null;
	/* Column Info */
	private String cmdtdesc = null;
	/* Column Info */
	private String bkgcgotp = null;
	 
	/* Column Info */
	private String amendVvd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgspeak = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String st10 = null;
	/* Column Info */
	private String tmpstr9 = null;
	/* Column Info */
	private String tmpstr8 = null;
	/* Column Info */
	private String tmpstr7 = null;
	/* Column Info */
	private String tmpstr5 = null;
	/* Column Info */
	private String tmpstr4 = null;
	/* Column Info */
	private String bkgspedg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bkgspebb = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgsperd = null;
	/* Column Info */
	private String bkgsperf = null;
	/* Column Info */
	private String cmdtcd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaiwanManifestTransmitVO() {}

	public TaiwanManifestTransmitVO(String ibflag, String pagerows, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String userId, String ofcCd, String polCd, String podCd, String bkgNo, String amendBl, String bkgQty, String cntrNo, String bkgcgotp, String bkgsperf, String bkgspedg, String bkgspeak, String bkgspebb, String cmdtdesc, String cmdtcd, String bkgsperd, String amendVvd, String st9, String st10, String tmpstr4, String tmpstr5, String tmpstr7, String tmpstr8, String tmpstr9) {
		this.vslCd = vslCd;
		this.amendBl = amendBl;
		this.st9 = st9;
		this.cmdtdesc = cmdtdesc;
		this.bkgcgotp = bkgcgotp;
		this.amendVvd = amendVvd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.bkgspeak = bkgspeak;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgQty = bkgQty;
		this.userId = userId;
		this.st10 = st10;
		this.tmpstr9 = tmpstr9;
		this.tmpstr8 = tmpstr8;
		this.tmpstr7 = tmpstr7;
		this.tmpstr5 = tmpstr5;
		this.tmpstr4 = tmpstr4;
		this.bkgspedg = bkgspedg;
		this.skdVoyNo = skdVoyNo;
		this.bkgspebb = bkgspebb;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.bkgsperd = bkgsperd;
		this.bkgsperf = bkgsperf;
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("amend_bl", getAmendBl());
		this.hashColumns.put("st_9", getSt9());
		this.hashColumns.put("cmdtdesc", getCmdtdesc());
		this.hashColumns.put("bkgcgotp", getBkgcgotp());
		this.hashColumns.put("amend_vvd", getAmendVvd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkgspeak", getBkgspeak());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("st_10", getSt10());
		this.hashColumns.put("tmpstr9", getTmpstr9());
		this.hashColumns.put("tmpstr8", getTmpstr8());
		this.hashColumns.put("tmpstr7", getTmpstr7());
		this.hashColumns.put("tmpstr5", getTmpstr5());
		this.hashColumns.put("tmpstr4", getTmpstr4());
		this.hashColumns.put("bkgspedg", getBkgspedg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bkgspebb", getBkgspebb());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkgsperd", getBkgsperd());
		this.hashColumns.put("bkgsperf", getBkgsperf());
		this.hashColumns.put("cmdtcd", getCmdtcd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("amend_bl", "amendBl");
		this.hashFields.put("st_9", "st9");
		this.hashFields.put("cmdtdesc", "cmdtdesc");
		this.hashFields.put("bkgcgotp", "bkgcgotp");
		this.hashFields.put("amend_vvd", "amendVvd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkgspeak", "bkgspeak");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("st_10", "st10");
		this.hashFields.put("tmpstr9", "tmpstr9");
		this.hashFields.put("tmpstr8", "tmpstr8");
		this.hashFields.put("tmpstr7", "tmpstr7");
		this.hashFields.put("tmpstr5", "tmpstr5");
		this.hashFields.put("tmpstr4", "tmpstr4");
		this.hashFields.put("bkgspedg", "bkgspedg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bkgspebb", "bkgspebb");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkgsperd", "bkgsperd");
		this.hashFields.put("bkgsperf", "bkgsperf");
		this.hashFields.put("cmdtcd", "cmdtcd");
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
	 * @return amendBl
	 */
	public String getAmendBl() {
		return this.amendBl;
	}
	
	/**
	 * Column Info
	 * @return st9
	 */
	public String getSt9() {
		return this.st9;
	}
	
	/**
	 * Column Info
	 * @return cmdtdesc
	 */
	public String getCmdtdesc() {
		return this.cmdtdesc;
	}
	
	/**
	 * Column Info
	 * @return bkgcgotp
	 */
	public String getBkgcgotp() {
		return this.bkgcgotp;
	}
	
	/**
	 * Column Info
	 * @return amendVvd
	 */
	public String getAmendVvd() {
		return this.amendVvd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return bkgspeak
	 */
	public String getBkgspeak() {
		return this.bkgspeak;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return st10
	 */
	public String getSt10() {
		return this.st10;
	}
	
	/**
	 * Column Info
	 * @return tmpstr9
	 */
	public String getTmpstr9() {
		return this.tmpstr9;
	}
	
	/**
	 * Column Info
	 * @return tmpstr8
	 */
	public String getTmpstr8() {
		return this.tmpstr8;
	}
	
	/**
	 * Column Info
	 * @return tmpstr7
	 */
	public String getTmpstr7() {
		return this.tmpstr7;
	}
	
	/**
	 * Column Info
	 * @return tmpstr5
	 */
	public String getTmpstr5() {
		return this.tmpstr5;
	}
	
	/**
	 * Column Info
	 * @return tmpstr4
	 */
	public String getTmpstr4() {
		return this.tmpstr4;
	}
	
	/**
	 * Column Info
	 * @return bkgspedg
	 */
	public String getBkgspedg() {
		return this.bkgspedg;
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
	 * @return bkgspebb
	 */
	public String getBkgspebb() {
		return this.bkgspebb;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgsperd
	 */
	public String getBkgsperd() {
		return this.bkgsperd;
	}
	
	/**
	 * Column Info
	 * @return bkgsperf
	 */
	public String getBkgsperf() {
		return this.bkgsperf;
	}
	
	/**
	 * Column Info
	 * @return cmdtcd
	 */
	public String getCmdtcd() {
		return this.cmdtcd;
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
	 * @param amendBl
	 */
	public void setAmendBl(String amendBl) {
		this.amendBl = amendBl;
	}
	
	/**
	 * Column Info
	 * @param st9
	 */
	public void setSt9(String st9) {
		this.st9 = st9;
	}
	
	/**
	 * Column Info
	 * @param cmdtdesc
	 */
	public void setCmdtdesc(String cmdtdesc) {
		this.cmdtdesc = cmdtdesc;
	}
	
	/**
	 * Column Info
	 * @param bkgcgotp
	 */
	public void setBkgcgotp(String bkgcgotp) {
		this.bkgcgotp = bkgcgotp;
	}
	
	/**
	 * Column Info
	 * @param amendVvd
	 */
	public void setAmendVvd(String amendVvd) {
		this.amendVvd = amendVvd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param bkgspeak
	 */
	public void setBkgspeak(String bkgspeak) {
		this.bkgspeak = bkgspeak;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param st10
	 */
	public void setSt10(String st10) {
		this.st10 = st10;
	}
	
	/**
	 * Column Info
	 * @param tmpstr9
	 */
	public void setTmpstr9(String tmpstr9) {
		this.tmpstr9 = tmpstr9;
	}
	
	/**
	 * Column Info
	 * @param tmpstr8
	 */
	public void setTmpstr8(String tmpstr8) {
		this.tmpstr8 = tmpstr8;
	}
	
	/**
	 * Column Info
	 * @param tmpstr7
	 */
	public void setTmpstr7(String tmpstr7) {
		this.tmpstr7 = tmpstr7;
	}
	
	/**
	 * Column Info
	 * @param tmpstr5
	 */
	public void setTmpstr5(String tmpstr5) {
		this.tmpstr5 = tmpstr5;
	}
	
	/**
	 * Column Info
	 * @param tmpstr4
	 */
	public void setTmpstr4(String tmpstr4) {
		this.tmpstr4 = tmpstr4;
	}
	
	/**
	 * Column Info
	 * @param bkgspedg
	 */
	public void setBkgspedg(String bkgspedg) {
		this.bkgspedg = bkgspedg;
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
	 * @param bkgspebb
	 */
	public void setBkgspebb(String bkgspebb) {
		this.bkgspebb = bkgspebb;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgsperd
	 */
	public void setBkgsperd(String bkgsperd) {
		this.bkgsperd = bkgsperd;
	}
	
	/**
	 * Column Info
	 * @param bkgsperf
	 */
	public void setBkgsperf(String bkgsperf) {
		this.bkgsperf = bkgsperf;
	}
	
	/**
	 * Column Info
	 * @param cmdtcd
	 */
	public void setCmdtcd(String cmdtcd) {
		this.cmdtcd = cmdtcd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setAmendBl(JSPUtil.getParameter(request, "amend_bl", ""));
		setSt9(JSPUtil.getParameter(request, "st_9", ""));
		setCmdtdesc(JSPUtil.getParameter(request, "cmdtdesc", ""));
		setBkgcgotp(JSPUtil.getParameter(request, "bkgcgotp", ""));
		setAmendVvd(JSPUtil.getParameter(request, "amend_vvd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgspeak(JSPUtil.getParameter(request, "bkgspeak", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgQty(JSPUtil.getParameter(request, "bkg_qty", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setSt10(JSPUtil.getParameter(request, "st_10", ""));
		setTmpstr9(JSPUtil.getParameter(request, "tmpstr9", ""));
		setTmpstr8(JSPUtil.getParameter(request, "tmpstr8", ""));
		setTmpstr7(JSPUtil.getParameter(request, "tmpstr7", ""));
		setTmpstr5(JSPUtil.getParameter(request, "tmpstr5", ""));
		setTmpstr4(JSPUtil.getParameter(request, "tmpstr4", ""));
		setBkgspedg(JSPUtil.getParameter(request, "bkgspedg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBkgspebb(JSPUtil.getParameter(request, "bkgspebb", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBkgsperd(JSPUtil.getParameter(request, "bkgsperd", ""));
		setBkgsperf(JSPUtil.getParameter(request, "bkgsperf", ""));
		setCmdtcd(JSPUtil.getParameter(request, "cmdtcd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaiwanManifestTransmitVO[]
	 */
	public TaiwanManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaiwanManifestTransmitVO[]
	 */
	public TaiwanManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaiwanManifestTransmitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] amendBl = (JSPUtil.getParameter(request, prefix	+ "amend_bl", length));
			String[] st9 = (JSPUtil.getParameter(request, prefix	+ "st_9", length));
			String[] cmdtdesc = (JSPUtil.getParameter(request, prefix	+ "cmdtdesc", length));
			String[] bkgcgotp = (JSPUtil.getParameter(request, prefix	+ "bkgcgotp", length));
			String[] amendVvd = (JSPUtil.getParameter(request, prefix	+ "amend_vvd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgspeak = (JSPUtil.getParameter(request, prefix	+ "bkgspeak", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] st10 = (JSPUtil.getParameter(request, prefix	+ "st_10", length));
			String[] tmpstr9 = (JSPUtil.getParameter(request, prefix	+ "tmpstr9", length));
			String[] tmpstr8 = (JSPUtil.getParameter(request, prefix	+ "tmpstr8", length));
			String[] tmpstr7 = (JSPUtil.getParameter(request, prefix	+ "tmpstr7", length));
			String[] tmpstr5 = (JSPUtil.getParameter(request, prefix	+ "tmpstr5", length));
			String[] tmpstr4 = (JSPUtil.getParameter(request, prefix	+ "tmpstr4", length));
			String[] bkgspedg = (JSPUtil.getParameter(request, prefix	+ "bkgspedg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bkgspebb = (JSPUtil.getParameter(request, prefix	+ "bkgspebb", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgsperd = (JSPUtil.getParameter(request, prefix	+ "bkgsperd", length));
			String[] bkgsperf = (JSPUtil.getParameter(request, prefix	+ "bkgsperf", length));
			String[] cmdtcd = (JSPUtil.getParameter(request, prefix	+ "cmdtcd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaiwanManifestTransmitVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (amendBl[i] != null)
					model.setAmendBl(amendBl[i]);
				if (st9[i] != null)
					model.setSt9(st9[i]);
				if (cmdtdesc[i] != null)
					model.setCmdtdesc(cmdtdesc[i]);
				if (bkgcgotp[i] != null)
					model.setBkgcgotp(bkgcgotp[i]);
				if (amendVvd[i] != null)
					model.setAmendVvd(amendVvd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgspeak[i] != null)
					model.setBkgspeak(bkgspeak[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (st10[i] != null)
					model.setSt10(st10[i]);
				if (tmpstr9[i] != null)
					model.setTmpstr9(tmpstr9[i]);
				if (tmpstr8[i] != null)
					model.setTmpstr8(tmpstr8[i]);
				if (tmpstr7[i] != null)
					model.setTmpstr7(tmpstr7[i]);
				if (tmpstr5[i] != null)
					model.setTmpstr5(tmpstr5[i]);
				if (tmpstr4[i] != null)
					model.setTmpstr4(tmpstr4[i]);
				if (bkgspedg[i] != null)
					model.setBkgspedg(bkgspedg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bkgspebb[i] != null)
					model.setBkgspebb(bkgspebb[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgsperd[i] != null)
					model.setBkgsperd(bkgsperd[i]);
				if (bkgsperf[i] != null)
					model.setBkgsperf(bkgsperf[i]);
				if (cmdtcd[i] != null)
					model.setCmdtcd(cmdtcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaiwanManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaiwanManifestTransmitVO[]
	 */
	public TaiwanManifestTransmitVO[] getTaiwanManifestTransmitVOs(){
		TaiwanManifestTransmitVO[] vos = (TaiwanManifestTransmitVO[])models.toArray(new TaiwanManifestTransmitVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendBl = this.amendBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st9 = this.st9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtdesc = this.cmdtdesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgcgotp = this.bkgcgotp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendVvd = this.amendVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspeak = this.bkgspeak .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st10 = this.st10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpstr9 = this.tmpstr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpstr8 = this.tmpstr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpstr7 = this.tmpstr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpstr5 = this.tmpstr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpstr4 = this.tmpstr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspedg = this.bkgspedg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgspebb = this.bkgspebb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgsperd = this.bkgsperd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgsperf = this.bkgsperf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtcd = this.cmdtcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
