/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HusBlInpChkVO.java
*@FileTitle : HusBlInpChkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.23 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HusBlInpChkVO extends HouseBlDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<HusBlInpChkVO> models = new ArrayList<HusBlInpChkVO>();
	
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String totHblEtc = null;
	/* Column Info */
	private String mblFiler = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String totMbl = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totBl = null;
	/* Column Info */
	private String shprTp = null;
	/* Column Info */
	private String totMbl01 = null;
	/* Column Info */
	private String errFlg = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String totBkg = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String etcFiler = null;
	/* Column Info */
	private String hblFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String totFilenoEtc = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntrMfNo = null;
	/* Column Info */
	private String totMbl03 = null;
	/* Column Info */
	private String hblFilenoFlg = null;
	/* Column Info */
	private String totMbl02 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String totHbl = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String totFileno = null;
	/* Column Info */
	private String hblCmFlg = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String hblSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HusBlInpChkVO() {}

	public HusBlInpChkVO(String ibflag, String pagerows, String bkgNo, String bkgStsCd, String polCd, String podCd, String delCd, String blNo, String mblFiler, String hblSeq, String hblFlg, String hblFilenoFlg, String hblCmFlg, String shprTp, String shprNm, String bkgOfcCd, String hblNo, String cntrMfNo, String etcFiler, String errFlg, String seq, String totBkg, String totBl, String totMbl01, String totMbl02, String totMbl03, String totMbl, String totHbl, String totFileno, String totHblEtc, String totFilenoEtc) {
		this.bkgStsCd = bkgStsCd;
		this.totHblEtc = totHblEtc;
		this.mblFiler = mblFiler;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.totMbl = totMbl;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.totBl = totBl;
		this.shprTp = shprTp;
		this.totMbl01 = totMbl01;
		this.errFlg = errFlg;
		this.hblNo = hblNo;
		this.totBkg = totBkg;
		this.shprNm = shprNm;
		this.etcFiler = etcFiler;
		this.hblFlg = hblFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.totFilenoEtc = totFilenoEtc;
		this.delCd = delCd;
		this.cntrMfNo = cntrMfNo;
		this.totMbl03 = totMbl03;
		this.hblFilenoFlg = hblFilenoFlg;
		this.totMbl02 = totMbl02;
		this.podCd = podCd;
		this.totHbl = totHbl;
		this.bkgNo = bkgNo;
		this.totFileno = totFileno;
		this.hblCmFlg = hblCmFlg;
		this.seq = seq;
		this.hblSeq = hblSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("tot_hbl_etc", getTotHblEtc());
		this.hashColumns.put("mbl_filer", getMblFiler());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tot_mbl", getTotMbl());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_bl", getTotBl());
		this.hashColumns.put("shpr_tp", getShprTp());
		this.hashColumns.put("tot_mbl01", getTotMbl01());
		this.hashColumns.put("err_flg", getErrFlg());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("tot_bkg", getTotBkg());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("etc_filer", getEtcFiler());
		this.hashColumns.put("hbl_flg", getHblFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("tot_fileno_etc", getTotFilenoEtc());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_mf_no", getCntrMfNo());
		this.hashColumns.put("tot_mbl03", getTotMbl03());
		this.hashColumns.put("hbl_fileno_flg", getHblFilenoFlg());
		this.hashColumns.put("tot_mbl02", getTotMbl02());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("tot_hbl", getTotHbl());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tot_fileno", getTotFileno());
		this.hashColumns.put("hbl_cm_flg", getHblCmFlg());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("hbl_seq", getHblSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("tot_hbl_etc", "totHblEtc");
		this.hashFields.put("mbl_filer", "mblFiler");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tot_mbl", "totMbl");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_bl", "totBl");
		this.hashFields.put("shpr_tp", "shprTp");
		this.hashFields.put("tot_mbl01", "totMbl01");
		this.hashFields.put("err_flg", "errFlg");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("tot_bkg", "totBkg");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("etc_filer", "etcFiler");
		this.hashFields.put("hbl_flg", "hblFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("tot_fileno_etc", "totFilenoEtc");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_mf_no", "cntrMfNo");
		this.hashFields.put("tot_mbl03", "totMbl03");
		this.hashFields.put("hbl_fileno_flg", "hblFilenoFlg");
		this.hashFields.put("tot_mbl02", "totMbl02");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("tot_hbl", "totHbl");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tot_fileno", "totFileno");
		this.hashFields.put("hbl_cm_flg", "hblCmFlg");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("hbl_seq", "hblSeq");
		return this.hashFields;
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
	 * @return totHblEtc
	 */
	public String getTotHblEtc() {
		return this.totHblEtc;
	}
	
	/**
	 * Column Info
	 * @return mblFiler
	 */
	public String getMblFiler() {
		return this.mblFiler;
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
	 * @return totMbl
	 */
	public String getTotMbl() {
		return this.totMbl;
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
	 * @return totBl
	 */
	public String getTotBl() {
		return this.totBl;
	}
	
	/**
	 * Column Info
	 * @return shprTp
	 */
	public String getShprTp() {
		return this.shprTp;
	}
	
	/**
	 * Column Info
	 * @return totMbl01
	 */
	public String getTotMbl01() {
		return this.totMbl01;
	}
	
	/**
	 * Column Info
	 * @return errFlg
	 */
	public String getErrFlg() {
		return this.errFlg;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return totBkg
	 */
	public String getTotBkg() {
		return this.totBkg;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return etcFiler
	 */
	public String getEtcFiler() {
		return this.etcFiler;
	}
	
	/**
	 * Column Info
	 * @return hblFlg
	 */
	public String getHblFlg() {
		return this.hblFlg;
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
	 * @return totFilenoEtc
	 */
	public String getTotFilenoEtc() {
		return this.totFilenoEtc;
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
	 * @return cntrMfNo
	 */
	public String getCntrMfNo() {
		return this.cntrMfNo;
	}
	
	/**
	 * Column Info
	 * @return totMbl03
	 */
	public String getTotMbl03() {
		return this.totMbl03;
	}
	
	/**
	 * Column Info
	 * @return hblFilenoFlg
	 */
	public String getHblFilenoFlg() {
		return this.hblFilenoFlg;
	}
	
	/**
	 * Column Info
	 * @return totMbl02
	 */
	public String getTotMbl02() {
		return this.totMbl02;
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
	 * @return totHbl
	 */
	public String getTotHbl() {
		return this.totHbl;
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
	 * @return totFileno
	 */
	public String getTotFileno() {
		return this.totFileno;
	}
	
	/**
	 * Column Info
	 * @return hblCmFlg
	 */
	public String getHblCmFlg() {
		return this.hblCmFlg;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return hblSeq
	 */
	public String getHblSeq() {
		return this.hblSeq;
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
	 * @param totHblEtc
	 */
	public void setTotHblEtc(String totHblEtc) {
		this.totHblEtc = totHblEtc;
	}
	
	/**
	 * Column Info
	 * @param mblFiler
	 */
	public void setMblFiler(String mblFiler) {
		this.mblFiler = mblFiler;
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
	 * @param totMbl
	 */
	public void setTotMbl(String totMbl) {
		this.totMbl = totMbl;
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
	 * @param totBl
	 */
	public void setTotBl(String totBl) {
		this.totBl = totBl;
	}
	
	/**
	 * Column Info
	 * @param shprTp
	 */
	public void setShprTp(String shprTp) {
		this.shprTp = shprTp;
	}
	
	/**
	 * Column Info
	 * @param totMbl01
	 */
	public void setTotMbl01(String totMbl01) {
		this.totMbl01 = totMbl01;
	}
	
	/**
	 * Column Info
	 * @param errFlg
	 */
	public void setErrFlg(String errFlg) {
		this.errFlg = errFlg;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param totBkg
	 */
	public void setTotBkg(String totBkg) {
		this.totBkg = totBkg;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param etcFiler
	 */
	public void setEtcFiler(String etcFiler) {
		this.etcFiler = etcFiler;
	}
	
	/**
	 * Column Info
	 * @param hblFlg
	 */
	public void setHblFlg(String hblFlg) {
		this.hblFlg = hblFlg;
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
	 * @param totFilenoEtc
	 */
	public void setTotFilenoEtc(String totFilenoEtc) {
		this.totFilenoEtc = totFilenoEtc;
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
	 * @param cntrMfNo
	 */
	public void setCntrMfNo(String cntrMfNo) {
		this.cntrMfNo = cntrMfNo;
	}
	
	/**
	 * Column Info
	 * @param totMbl03
	 */
	public void setTotMbl03(String totMbl03) {
		this.totMbl03 = totMbl03;
	}
	
	/**
	 * Column Info
	 * @param hblFilenoFlg
	 */
	public void setHblFilenoFlg(String hblFilenoFlg) {
		this.hblFilenoFlg = hblFilenoFlg;
	}
	
	/**
	 * Column Info
	 * @param totMbl02
	 */
	public void setTotMbl02(String totMbl02) {
		this.totMbl02 = totMbl02;
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
	 * @param totHbl
	 */
	public void setTotHbl(String totHbl) {
		this.totHbl = totHbl;
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
	 * @param totFileno
	 */
	public void setTotFileno(String totFileno) {
		this.totFileno = totFileno;
	}
	
	/**
	 * Column Info
	 * @param hblCmFlg
	 */
	public void setHblCmFlg(String hblCmFlg) {
		this.hblCmFlg = hblCmFlg;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param hblSeq
	 */
	public void setHblSeq(String hblSeq) {
		this.hblSeq = hblSeq;
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
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setTotHblEtc(JSPUtil.getParameter(request, prefix + "tot_hbl_etc", ""));
		setMblFiler(JSPUtil.getParameter(request, prefix + "mbl_filer", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTotMbl(JSPUtil.getParameter(request, prefix + "tot_mbl", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotBl(JSPUtil.getParameter(request, prefix + "tot_bl", ""));
		setShprTp(JSPUtil.getParameter(request, prefix + "shpr_tp", ""));
		setTotMbl01(JSPUtil.getParameter(request, prefix + "tot_mbl01", ""));
		setErrFlg(JSPUtil.getParameter(request, prefix + "err_flg", ""));
		setHblNo(JSPUtil.getParameter(request, prefix + "hbl_no", ""));
		setTotBkg(JSPUtil.getParameter(request, prefix + "tot_bkg", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setEtcFiler(JSPUtil.getParameter(request, prefix + "etc_filer", ""));
		setHblFlg(JSPUtil.getParameter(request, prefix + "hbl_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTotFilenoEtc(JSPUtil.getParameter(request, prefix + "tot_fileno_etc", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCntrMfNo(JSPUtil.getParameter(request, prefix + "cntr_mf_no", ""));
		setTotMbl03(JSPUtil.getParameter(request, prefix + "tot_mbl03", ""));
		setHblFilenoFlg(JSPUtil.getParameter(request, prefix + "hbl_fileno_flg", ""));
		setTotMbl02(JSPUtil.getParameter(request, prefix + "tot_mbl02", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTotHbl(JSPUtil.getParameter(request, prefix + "tot_hbl", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTotFileno(JSPUtil.getParameter(request, prefix + "tot_fileno", ""));
		setHblCmFlg(JSPUtil.getParameter(request, prefix + "hbl_cm_flg", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setHblSeq(JSPUtil.getParameter(request, prefix + "hbl_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HusBlInpChkVO[]
	 */
	public HusBlInpChkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HusBlInpChkVO[]
	 */
	public HusBlInpChkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HusBlInpChkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] totHblEtc = (JSPUtil.getParameter(request, prefix	+ "tot_hbl_etc", length));
			String[] mblFiler = (JSPUtil.getParameter(request, prefix	+ "mbl_filer", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] totMbl = (JSPUtil.getParameter(request, prefix	+ "tot_mbl", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totBl = (JSPUtil.getParameter(request, prefix	+ "tot_bl", length));
			String[] shprTp = (JSPUtil.getParameter(request, prefix	+ "shpr_tp", length));
			String[] totMbl01 = (JSPUtil.getParameter(request, prefix	+ "tot_mbl01", length));
			String[] errFlg = (JSPUtil.getParameter(request, prefix	+ "err_flg", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] totBkg = (JSPUtil.getParameter(request, prefix	+ "tot_bkg", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] etcFiler = (JSPUtil.getParameter(request, prefix	+ "etc_filer", length));
			String[] hblFlg = (JSPUtil.getParameter(request, prefix	+ "hbl_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] totFilenoEtc = (JSPUtil.getParameter(request, prefix	+ "tot_fileno_etc", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrMfNo = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_no", length));
			String[] totMbl03 = (JSPUtil.getParameter(request, prefix	+ "tot_mbl03", length));
			String[] hblFilenoFlg = (JSPUtil.getParameter(request, prefix	+ "hbl_fileno_flg", length));
			String[] totMbl02 = (JSPUtil.getParameter(request, prefix	+ "tot_mbl02", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] totHbl = (JSPUtil.getParameter(request, prefix	+ "tot_hbl", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] totFileno = (JSPUtil.getParameter(request, prefix	+ "tot_fileno", length));
			String[] hblCmFlg = (JSPUtil.getParameter(request, prefix	+ "hbl_cm_flg", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] hblSeq = (JSPUtil.getParameter(request, prefix	+ "hbl_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new HusBlInpChkVO();
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (totHblEtc[i] != null)
					model.setTotHblEtc(totHblEtc[i]);
				if (mblFiler[i] != null)
					model.setMblFiler(mblFiler[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (totMbl[i] != null)
					model.setTotMbl(totMbl[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totBl[i] != null)
					model.setTotBl(totBl[i]);
				if (shprTp[i] != null)
					model.setShprTp(shprTp[i]);
				if (totMbl01[i] != null)
					model.setTotMbl01(totMbl01[i]);
				if (errFlg[i] != null)
					model.setErrFlg(errFlg[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (totBkg[i] != null)
					model.setTotBkg(totBkg[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (etcFiler[i] != null)
					model.setEtcFiler(etcFiler[i]);
				if (hblFlg[i] != null)
					model.setHblFlg(hblFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (totFilenoEtc[i] != null)
					model.setTotFilenoEtc(totFilenoEtc[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrMfNo[i] != null)
					model.setCntrMfNo(cntrMfNo[i]);
				if (totMbl03[i] != null)
					model.setTotMbl03(totMbl03[i]);
				if (hblFilenoFlg[i] != null)
					model.setHblFilenoFlg(hblFilenoFlg[i]);
				if (totMbl02[i] != null)
					model.setTotMbl02(totMbl02[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (totHbl[i] != null)
					model.setTotHbl(totHbl[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (totFileno[i] != null)
					model.setTotFileno(totFileno[i]);
				if (hblCmFlg[i] != null)
					model.setHblCmFlg(hblCmFlg[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (hblSeq[i] != null)
					model.setHblSeq(hblSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHusBlInpChkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HusBlInpChkVO[]
	 */
	public HusBlInpChkVO[] getHusBlInpChkVOs(){
		HusBlInpChkVO[] vos = (HusBlInpChkVO[])models.toArray(new HusBlInpChkVO[models.size()]);
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
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHblEtc = this.totHblEtc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblFiler = this.mblFiler .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMbl = this.totMbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBl = this.totBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprTp = this.shprTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMbl01 = this.totMbl01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errFlg = this.errFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBkg = this.totBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcFiler = this.etcFiler .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblFlg = this.hblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totFilenoEtc = this.totFilenoEtc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNo = this.cntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMbl03 = this.totMbl03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblFilenoFlg = this.hblFilenoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMbl02 = this.totMbl02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHbl = this.totHbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totFileno = this.totFileno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblCmFlg = this.hblCmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblSeq = this.hblSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
