/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreatorVO.java
*@FileTitle : CreatorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.10 손윤석 
* 1.0 Creation
=========================================================*/


package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsKrXptLicVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsKrXptLicVO> models = new ArrayList<BkgCstmsKrXptLicVO>();
	
	/* Column Info */
	private String elnoCheck = null;
	/* Column Info */
	private String trCd = null;
	/* Column Info */
	private String bmePkgQty = null;
	/* Column Info */
	private String bmeDivSeq = null;
	/* Column Info */
	private String bmeWgtTp = null;
	/* Column Info */
	private String kcdTp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bmeDwgtQty = null;
	/* Column Info */
	private String ktSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String username = null;
	/* Column Info */
	private String ktPort = null;
	/* Column Info */
	private String bmeDwgtTp = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String prtLodgFlg = null;
	/* Column Info */
	private String bmeDivInd = null;
	/* Column Info */
	private String bmeSmpSeq = null;
	/* Column Info */
	private String exptKcdTp = null;
	/* Column Info */
	private String bmePkgCd = null;
	/* Column Info */
	private String bmeDpkgCd = null;
	/* Column Info */
	private String bmeDpkgQty = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bmeElno = null;
	/* Column Info */
	private String elnoWgt = null;
	/* Column Info */
	private String bmeWgtQty = null;
	/* Column Info */
	private String cBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsKrXptLicVO() {}

	public BkgCstmsKrXptLicVO(String ibflag, String pagerows, String elnoCheck, String bmePkgQty, String bmeDivSeq, String bkgNoSplit, String bmeDivInd, String bmeWgtTp, String bmeSmpSeq, String kcdTp, String exptKcdTp, String bmeDpkgCd, String bmePkgCd, String bmeDwgtQty, String bmeDpkgQty, String ktSeq, String bkgNo, String bmeElno, String elnoWgt, String bmeWgtQty, String ktPort, String bmeDwgtTp, String trCd, String username, String cBlNo, String prtLodgFlg) {
		this.elnoCheck = elnoCheck;
		this.trCd = trCd;
		this.bmePkgQty = bmePkgQty;
		this.bmeDivSeq = bmeDivSeq;
		this.bmeWgtTp = bmeWgtTp;
		this.kcdTp = kcdTp;
		this.pagerows = pagerows;
		this.bmeDwgtQty = bmeDwgtQty;
		this.ktSeq = ktSeq;
		this.ibflag = ibflag;
		this.username = username;
		this.ktPort = ktPort;
		this.bmeDwgtTp = bmeDwgtTp;
		this.bkgNoSplit = bkgNoSplit;
		this.prtLodgFlg = prtLodgFlg;
		this.bmeDivInd = bmeDivInd;
		this.bmeSmpSeq = bmeSmpSeq;
		this.exptKcdTp = exptKcdTp;
		this.bmePkgCd = bmePkgCd;
		this.bmeDpkgCd = bmeDpkgCd;
		this.bmeDpkgQty = bmeDpkgQty;
		this.bkgNo = bkgNo;
		this.bmeElno = bmeElno;
		this.elnoWgt = elnoWgt;
		this.bmeWgtQty = bmeWgtQty;
		this.cBlNo = cBlNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("elno_check", getElnoCheck());
		this.hashColumns.put("tr_cd", getTrCd());
		this.hashColumns.put("bme_pkg_qty", getBmePkgQty());
		this.hashColumns.put("bme_div_seq", getBmeDivSeq());
		this.hashColumns.put("bme_wgt_tp", getBmeWgtTp());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bme_dwgt_qty", getBmeDwgtQty());
		this.hashColumns.put("kt_seq", getKtSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("username", getUsername());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("bme_dwgt_tp", getBmeDwgtTp());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("prt_lodg_flg", getPrtLodgFlg());
		this.hashColumns.put("bme_div_ind", getBmeDivInd());
		this.hashColumns.put("bme_smp_seq", getBmeSmpSeq());
		this.hashColumns.put("expt_kcd_tp", getExptKcdTp());
		this.hashColumns.put("bme_pkg_cd", getBmePkgCd());
		this.hashColumns.put("bme_dpkg_cd", getBmeDpkgCd());
		this.hashColumns.put("bme_dpkg_qty", getBmeDpkgQty());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bme_elno", getBmeElno());
		this.hashColumns.put("elno_wgt", getElnoWgt());
		this.hashColumns.put("bme_wgt_qty", getBmeWgtQty());
		this.hashColumns.put("c_bl_no", getCBlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("elno_check", "elnoCheck");
		this.hashFields.put("tr_cd", "trCd");
		this.hashFields.put("bme_pkg_qty", "bmePkgQty");
		this.hashFields.put("bme_div_seq", "bmeDivSeq");
		this.hashFields.put("bme_wgt_tp", "bmeWgtTp");
		this.hashFields.put("kcd_tp", "kcdTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bme_dwgt_qty", "bmeDwgtQty");
		this.hashFields.put("kt_seq", "ktSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("username", "username");
		this.hashFields.put("kt_port", "ktPort");
		this.hashFields.put("bme_dwgt_tp", "bmeDwgtTp");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("prt_lodg_flg", "prtLodgFlg");
		this.hashFields.put("bme_div_ind", "bmeDivInd");
		this.hashFields.put("bme_smp_seq", "bmeSmpSeq");
		this.hashFields.put("expt_kcd_tp", "exptKcdTp");
		this.hashFields.put("bme_pkg_cd", "bmePkgCd");
		this.hashFields.put("bme_dpkg_cd", "bmeDpkgCd");
		this.hashFields.put("bme_dpkg_qty", "bmeDpkgQty");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bme_elno", "bmeElno");
		this.hashFields.put("elno_wgt", "elnoWgt");
		this.hashFields.put("bme_wgt_qty", "bmeWgtQty");
		this.hashFields.put("c_bl_no", "cBlNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return elnoCheck
	 */
	public String getElnoCheck() {
		return this.elnoCheck;
	}
	
	/**
	 * Column Info
	 * @return trCd
	 */
	public String getTrCd() {
		return this.trCd;
	}
	
	/**
	 * Column Info
	 * @return bmePkgQty
	 */
	public String getBmePkgQty() {
		return this.bmePkgQty;
	}
	
	/**
	 * Column Info
	 * @return bmeDivSeq
	 */
	public String getBmeDivSeq() {
		return this.bmeDivSeq;
	}
	
	/**
	 * Column Info
	 * @return bmeWgtTp
	 */
	public String getBmeWgtTp() {
		return this.bmeWgtTp;
	}
	
	/**
	 * Column Info
	 * @return kcdTp
	 */
	public String getKcdTp() {
		return this.kcdTp;
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
	 * @return bmeDwgtQty
	 */
	public String getBmeDwgtQty() {
		return this.bmeDwgtQty;
	}
	
	/**
	 * Column Info
	 * @return ktSeq
	 */
	public String getKtSeq() {
		return this.ktSeq;
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
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Column Info
	 * @return ktPort
	 */
	public String getKtPort() {
		return this.ktPort;
	}
	
	/**
	 * Column Info
	 * @return bmeDwgtTp
	 */
	public String getBmeDwgtTp() {
		return this.bmeDwgtTp;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return prtLodgFlg
	 */
	public String getPrtLodgFlg() {
		return this.prtLodgFlg;
	}
	
	/**
	 * Column Info
	 * @return bmeDivInd
	 */
	public String getBmeDivInd() {
		return this.bmeDivInd;
	}
	
	/**
	 * Column Info
	 * @return bmeSmpSeq
	 */
	public String getBmeSmpSeq() {
		return this.bmeSmpSeq;
	}
	
	/**
	 * Column Info
	 * @return exptKcdTp
	 */
	public String getExptKcdTp() {
		return this.exptKcdTp;
	}
	
	/**
	 * Column Info
	 * @return bmePkgCd
	 */
	public String getBmePkgCd() {
		return this.bmePkgCd;
	}
	
	/**
	 * Column Info
	 * @return bmeDpkgCd
	 */
	public String getBmeDpkgCd() {
		return this.bmeDpkgCd;
	}
	
	/**
	 * Column Info
	 * @return bmeDpkgQty
	 */
	public String getBmeDpkgQty() {
		return this.bmeDpkgQty;
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
	 * @return bmeElno
	 */
	public String getBmeElno() {
		return this.bmeElno;
	}
	
	/**
	 * Column Info
	 * @return elnoWgt
	 */
	public String getElnoWgt() {
		return this.elnoWgt;
	}
	
	/**
	 * Column Info
	 * @return bmeWgtQty
	 */
	public String getBmeWgtQty() {
		return this.bmeWgtQty;
	}
	
	/**
	 * Column Info
	 * @return cBlNo
	 */
	public String getCBlNo() {
		return this.cBlNo;
	}
	

	/**
	 * Column Info
	 * @param elnoCheck
	 */
	public void setElnoCheck(String elnoCheck) {
		this.elnoCheck = elnoCheck;
	}
	
	/**
	 * Column Info
	 * @param trCd
	 */
	public void setTrCd(String trCd) {
		this.trCd = trCd;
	}
	
	/**
	 * Column Info
	 * @param bmePkgQty
	 */
	public void setBmePkgQty(String bmePkgQty) {
		this.bmePkgQty = bmePkgQty;
	}
	
	/**
	 * Column Info
	 * @param bmeDivSeq
	 */
	public void setBmeDivSeq(String bmeDivSeq) {
		this.bmeDivSeq = bmeDivSeq;
	}
	
	/**
	 * Column Info
	 * @param bmeWgtTp
	 */
	public void setBmeWgtTp(String bmeWgtTp) {
		this.bmeWgtTp = bmeWgtTp;
	}
	
	/**
	 * Column Info
	 * @param kcdTp
	 */
	public void setKcdTp(String kcdTp) {
		this.kcdTp = kcdTp;
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
	 * @param bmeDwgtQty
	 */
	public void setBmeDwgtQty(String bmeDwgtQty) {
		this.bmeDwgtQty = bmeDwgtQty;
	}
	
	/**
	 * Column Info
	 * @param ktSeq
	 */
	public void setKtSeq(String ktSeq) {
		this.ktSeq = ktSeq;
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
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Column Info
	 * @param ktPort
	 */
	public void setKtPort(String ktPort) {
		this.ktPort = ktPort;
	}
	
	/**
	 * Column Info
	 * @param bmeDwgtTp
	 */
	public void setBmeDwgtTp(String bmeDwgtTp) {
		this.bmeDwgtTp = bmeDwgtTp;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param prtLodgFlg
	 */
	public void setPrtLodgFlg(String prtLodgFlg) {
		this.prtLodgFlg = prtLodgFlg;
	}
	
	/**
	 * Column Info
	 * @param bmeDivInd
	 */
	public void setBmeDivInd(String bmeDivInd) {
		this.bmeDivInd = bmeDivInd;
	}
	
	/**
	 * Column Info
	 * @param bmeSmpSeq
	 */
	public void setBmeSmpSeq(String bmeSmpSeq) {
		this.bmeSmpSeq = bmeSmpSeq;
	}
	
	/**
	 * Column Info
	 * @param exptKcdTp
	 */
	public void setExptKcdTp(String exptKcdTp) {
		this.exptKcdTp = exptKcdTp;
	}
	
	/**
	 * Column Info
	 * @param bmePkgCd
	 */
	public void setBmePkgCd(String bmePkgCd) {
		this.bmePkgCd = bmePkgCd;
	}
	
	/**
	 * Column Info
	 * @param bmeDpkgCd
	 */
	public void setBmeDpkgCd(String bmeDpkgCd) {
		this.bmeDpkgCd = bmeDpkgCd;
	}
	
	/**
	 * Column Info
	 * @param bmeDpkgQty
	 */
	public void setBmeDpkgQty(String bmeDpkgQty) {
		this.bmeDpkgQty = bmeDpkgQty;
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
	 * @param bmeElno
	 */
	public void setBmeElno(String bmeElno) {
		this.bmeElno = bmeElno;
	}
	
	/**
	 * Column Info
	 * @param elnoWgt
	 */
	public void setElnoWgt(String elnoWgt) {
		this.elnoWgt = elnoWgt;
	}
	
	/**
	 * Column Info
	 * @param bmeWgtQty
	 */
	public void setBmeWgtQty(String bmeWgtQty) {
		this.bmeWgtQty = bmeWgtQty;
	}
	
	/**
	 * Column Info
	 * @param cBlNo
	 */
	public void setCBlNo(String cBlNo) {
		this.cBlNo = cBlNo;
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
		setElnoCheck(JSPUtil.getParameter(request, prefix + "elno_check", ""));
		setTrCd(JSPUtil.getParameter(request, prefix + "tr_cd", ""));
		setBmePkgQty(JSPUtil.getParameter(request, prefix + "bme_pkg_qty", ""));
		setBmeDivSeq(JSPUtil.getParameter(request, prefix + "bme_div_seq", ""));
		setBmeWgtTp(JSPUtil.getParameter(request, prefix + "bme_wgt_tp", ""));
		setKcdTp(JSPUtil.getParameter(request, prefix + "kcd_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBmeDwgtQty(JSPUtil.getParameter(request, prefix + "bme_dwgt_qty", ""));
		setKtSeq(JSPUtil.getParameter(request, prefix + "kt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsername(JSPUtil.getParameter(request, prefix + "username", ""));
		setKtPort(JSPUtil.getParameter(request, prefix + "kt_port", ""));
		setBmeDwgtTp(JSPUtil.getParameter(request, prefix + "bme_dwgt_tp", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
		setPrtLodgFlg(JSPUtil.getParameter(request, prefix + "prt_lodg_flg", ""));
		setBmeDivInd(JSPUtil.getParameter(request, prefix + "bme_div_ind", ""));
		setBmeSmpSeq(JSPUtil.getParameter(request, prefix + "bme_smp_seq", ""));
		setExptKcdTp(JSPUtil.getParameter(request, prefix + "expt_kcd_tp", ""));
		setBmePkgCd(JSPUtil.getParameter(request, prefix + "bme_pkg_cd", ""));
		setBmeDpkgCd(JSPUtil.getParameter(request, prefix + "bme_dpkg_cd", ""));
		setBmeDpkgQty(JSPUtil.getParameter(request, prefix + "bme_dpkg_qty", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBmeElno(JSPUtil.getParameter(request, prefix + "bme_elno", ""));
		setElnoWgt(JSPUtil.getParameter(request, prefix + "elno_wgt", ""));
		setBmeWgtQty(JSPUtil.getParameter(request, prefix + "bme_wgt_qty", ""));
		setCBlNo(JSPUtil.getParameter(request, prefix + "c_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsKrXptLicVO[]
	 */
	public BkgCstmsKrXptLicVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsKrXptLicVO[]
	 */
	public BkgCstmsKrXptLicVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsKrXptLicVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] elnoCheck = (JSPUtil.getParameter(request, prefix	+ "elno_check", length));
			String[] trCd = (JSPUtil.getParameter(request, prefix	+ "tr_cd", length));
			String[] bmePkgQty = (JSPUtil.getParameter(request, prefix	+ "bme_pkg_qty", length));
			String[] bmeDivSeq = (JSPUtil.getParameter(request, prefix	+ "bme_div_seq", length));
			String[] bmeWgtTp = (JSPUtil.getParameter(request, prefix	+ "bme_wgt_tp", length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bmeDwgtQty = (JSPUtil.getParameter(request, prefix	+ "bme_dwgt_qty", length));
			String[] ktSeq = (JSPUtil.getParameter(request, prefix	+ "kt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] username = (JSPUtil.getParameter(request, prefix	+ "username", length));
			String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));
			String[] bmeDwgtTp = (JSPUtil.getParameter(request, prefix	+ "bme_dwgt_tp", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] prtLodgFlg = (JSPUtil.getParameter(request, prefix	+ "prt_lodg_flg", length));
			String[] bmeDivInd = (JSPUtil.getParameter(request, prefix	+ "bme_div_ind", length));
			String[] bmeSmpSeq = (JSPUtil.getParameter(request, prefix	+ "bme_smp_seq", length));
			String[] exptKcdTp = (JSPUtil.getParameter(request, prefix	+ "expt_kcd_tp", length));
			String[] bmePkgCd = (JSPUtil.getParameter(request, prefix	+ "bme_pkg_cd", length));
			String[] bmeDpkgCd = (JSPUtil.getParameter(request, prefix	+ "bme_dpkg_cd", length));
			String[] bmeDpkgQty = (JSPUtil.getParameter(request, prefix	+ "bme_dpkg_qty", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bmeElno = (JSPUtil.getParameter(request, prefix	+ "bme_elno", length));
			String[] elnoWgt = (JSPUtil.getParameter(request, prefix	+ "elno_wgt", length));
			String[] bmeWgtQty = (JSPUtil.getParameter(request, prefix	+ "bme_wgt_qty", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsKrXptLicVO();
				if (elnoCheck[i] != null)
					model.setElnoCheck(elnoCheck[i]);
				if (trCd[i] != null)
					model.setTrCd(trCd[i]);
				if (bmePkgQty[i] != null)
					model.setBmePkgQty(bmePkgQty[i]);
				if (bmeDivSeq[i] != null)
					model.setBmeDivSeq(bmeDivSeq[i]);
				if (bmeWgtTp[i] != null)
					model.setBmeWgtTp(bmeWgtTp[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bmeDwgtQty[i] != null)
					model.setBmeDwgtQty(bmeDwgtQty[i]);
				if (ktSeq[i] != null)
					model.setKtSeq(ktSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (username[i] != null)
					model.setUsername(username[i]);
				if (ktPort[i] != null)
					model.setKtPort(ktPort[i]);
				if (bmeDwgtTp[i] != null)
					model.setBmeDwgtTp(bmeDwgtTp[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (prtLodgFlg[i] != null)
					model.setPrtLodgFlg(prtLodgFlg[i]);
				if (bmeDivInd[i] != null)
					model.setBmeDivInd(bmeDivInd[i]);
				if (bmeSmpSeq[i] != null)
					model.setBmeSmpSeq(bmeSmpSeq[i]);
				if (exptKcdTp[i] != null)
					model.setExptKcdTp(exptKcdTp[i]);
				if (bmePkgCd[i] != null)
					model.setBmePkgCd(bmePkgCd[i]);
				if (bmeDpkgCd[i] != null)
					model.setBmeDpkgCd(bmeDpkgCd[i]);
				if (bmeDpkgQty[i] != null)
					model.setBmeDpkgQty(bmeDpkgQty[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bmeElno[i] != null)
					model.setBmeElno(bmeElno[i]);
				if (elnoWgt[i] != null)
					model.setElnoWgt(elnoWgt[i]);
				if (bmeWgtQty[i] != null)
					model.setBmeWgtQty(bmeWgtQty[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsKrXptLicVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsKrXptLicVO[]
	 */
	public BkgCstmsKrXptLicVO[] getBkgCstmsKrXptLicVOs(){
		BkgCstmsKrXptLicVO[] vos = (BkgCstmsKrXptLicVO[])models.toArray(new BkgCstmsKrXptLicVO[models.size()]);
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
		this.elnoCheck = this.elnoCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trCd = this.trCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmePkgQty = this.bmePkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeDivSeq = this.bmeDivSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeWgtTp = this.bmeWgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeDwgtQty = this.bmeDwgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktSeq = this.ktSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.username = this.username .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeDwgtTp = this.bmeDwgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtLodgFlg = this.prtLodgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeDivInd = this.bmeDivInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeSmpSeq = this.bmeSmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptKcdTp = this.exptKcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmePkgCd = this.bmePkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeDpkgCd = this.bmeDpkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeDpkgQty = this.bmeDpkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeElno = this.bmeElno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elnoWgt = this.elnoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeWgtQty = this.bmeWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
