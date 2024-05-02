/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiatransmitBlListVO.java
*@FileTitle : RussiatransmitBlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.vo;

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

public class RussiatransmitBlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RussiatransmitBlListVO> models = new ArrayList<RussiatransmitBlListVO>();
	
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String blpkgu = null;
	/* Column Info */
	private String blPodEtaDt = null;
	/* Column Info */
	private String bldel = null;
	/* Column Info */
	private String desc1 = null;
	/* Column Info */
	private String goodno = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blIssDt = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String blmea = null;
	/* Column Info */
	private String transInd = null;
	/* Column Info */
	private String issueLocName = null;
	/* Column Info */
	private String prflag = null;
	/* Column Info */
	private String bldelname = null;
	/* Column Info */
	private String cnee5 = null;
	/* Column Info */
	private String cnee3 = null;
	/* Column Info */
	private String cnee4 = null;
	/* Column Info */
	private String cnee1 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cnee2 = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String rdTerm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String blIssLocNm = null;
	/* Column Info */
	private String boarddate = null;
	/* Column Info */
	private String blpod = null;
	/* Column Info */
	private String issuedate = null;
	/* Column Info */
	private String sCustAddr = null;
	/* Column Info */
	private String blnbr = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String mark4 = null;
	/* Column Info */
	private String mark3 = null;
	/* Column Info */
	private String blpkg = null;
	/* Column Info */
	private String reeferInd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String mark2 = null;
	/* Column Info */
	private String blpodEta = null;
	/* Column Info */
	private String blpor = null;
	/* Column Info */
	private String mark1 = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String blpol = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Column Info */
	private String mark5 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String reefer = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String runit = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String blpkguNm = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String blpodname = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String issueLoc = null;
	/* Column Info */
	private String shpr2 = null;
	/* Column Info */
	private String shpr1 = null;
	/* Column Info */
	private String blwgt = null;
	/* Column Info */
	private String blpolname = null;
	/* Column Info */
	private String blporname = null;
	/* Column Info */
	private String shpr5 = null;
	/* Column Info */
	private String shpr4 = null;
	/* Column Info */
	private String shpr3 = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String ntfy5 = null;
	/* Column Info */
	private String blIssLocCd = null;
	/* Column Info */
	private String ntfy4 = null;
	/* Column Info */
	private String ntfy3 = null;
	/* Column Info */
	private String ntfy2 = null;
	/* Column Info */
	private String ntfy1 = null;
	/* Column Info */
	private String blMkDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RussiatransmitBlListVO() {}

	public RussiatransmitBlListVO(String ibflag, String pagerows, String polNm, String blpkgu, String blPodEtaDt, String bldel, String desc1, String goodno, String blIssDt, String bkgPodCd, String blmea, String transInd, String issueLocName, String blIssLocCd, String blIssLocNm, String prflag, String bldelname, String cnee5, String cnee3, String cnee4, String delCd, String cnee1, String cnee2, String locNm, String rdTerm, String bkgNo, String porNm, String boarddate, String blpod, String issuedate, String sCustAddr, String blnbr, String porCd, String mark4, String mark3, String blpkg, String reeferInd, String vpsEtbDt, String mark2, String blpodEta, String blpor, String mark1, String cCustNm, String blpol, String nCustAddr, String mark5, String cCustAddr, String cstmsDesc, String measQty, String reefer, String pckQty, String nCustNm, String pckTpCd, String runit, String blpkguNm, String bkgPolCd, String podNm, String sCustNm, String blpodname, String delNm, String issueLoc, String shpr2, String shpr1, String blwgt, String shpr5, String blporname, String blpolname, String shpr4, String actWgt, String shpr3, String ntfy5, String ntfy4, String ntfy3, String ntfy2, String ntfy1, String blMkDesc) {
		this.polNm = polNm;
		this.blpkgu = blpkgu;
		this.blPodEtaDt = blPodEtaDt;
		this.bldel = bldel;
		this.desc1 = desc1;
		this.goodno = goodno;
		this.pagerows = pagerows;
		this.blIssDt = blIssDt;
		this.bkgPodCd = bkgPodCd;
		this.blmea = blmea;
		this.transInd = transInd;
		this.issueLocName = issueLocName;
		this.prflag = prflag;
		this.bldelname = bldelname;
		this.cnee5 = cnee5;
		this.cnee3 = cnee3;
		this.cnee4 = cnee4;
		this.cnee1 = cnee1;
		this.delCd = delCd;
		this.cnee2 = cnee2;
		this.locNm = locNm;
		this.rdTerm = rdTerm;
		this.bkgNo = bkgNo;
		this.porNm = porNm;
		this.blIssLocNm = blIssLocNm;
		this.boarddate = boarddate;
		this.blpod = blpod;
		this.issuedate = issuedate;
		this.sCustAddr = sCustAddr;
		this.blnbr = blnbr;
		this.porCd = porCd;
		this.mark4 = mark4;
		this.mark3 = mark3;
		this.blpkg = blpkg;
		this.reeferInd = reeferInd;
		this.vpsEtbDt = vpsEtbDt;
		this.mark2 = mark2;
		this.blpodEta = blpodEta;
		this.blpor = blpor;
		this.mark1 = mark1;
		this.cCustNm = cCustNm;
		this.blpol = blpol;
		this.nCustAddr = nCustAddr;
		this.mark5 = mark5;
		this.ibflag = ibflag;
		this.cCustAddr = cCustAddr;
		this.cstmsDesc = cstmsDesc;
		this.reefer = reefer;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.nCustNm = nCustNm;
		this.pckTpCd = pckTpCd;
		this.runit = runit;
		this.bkgPolCd = bkgPolCd;
		this.blpkguNm = blpkguNm;
		this.podNm = podNm;
		this.blpodname = blpodname;
		this.sCustNm = sCustNm;
		this.delNm = delNm;
		this.issueLoc = issueLoc;
		this.shpr2 = shpr2;
		this.shpr1 = shpr1;
		this.blwgt = blwgt;
		this.blpolname = blpolname;
		this.blporname = blporname;
		this.shpr5 = shpr5;
		this.shpr4 = shpr4;
		this.shpr3 = shpr3;
		this.actWgt = actWgt;
		this.ntfy5 = ntfy5;
		this.blIssLocCd = blIssLocCd;
		this.ntfy4 = ntfy4;
		this.ntfy3 = ntfy3;
		this.ntfy2 = ntfy2;
		this.ntfy1 = ntfy1;
		this.blMkDesc = blMkDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("blpkgu", getBlpkgu());
		this.hashColumns.put("bl_pod_eta_dt", getBlPodEtaDt());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("desc1", getDesc1());
		this.hashColumns.put("goodno", getGoodno());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_iss_dt", getBlIssDt());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("blmea", getBlmea());
		this.hashColumns.put("trans_ind", getTransInd());
		this.hashColumns.put("issue_loc_name", getIssueLocName());
		this.hashColumns.put("prflag", getPrflag());
		this.hashColumns.put("bldelname", getBldelname());
		this.hashColumns.put("cnee5", getCnee5());
		this.hashColumns.put("cnee3", getCnee3());
		this.hashColumns.put("cnee4", getCnee4());
		this.hashColumns.put("cnee1", getCnee1());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cnee2", getCnee2());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("rd_term", getRdTerm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("bl_iss_loc_nm", getBlIssLocNm());
		this.hashColumns.put("boarddate", getBoarddate());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("issuedate", getIssuedate());
		this.hashColumns.put("s_cust_addr", getSCustAddr());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("mark4", getMark4());
		this.hashColumns.put("mark3", getMark3());
		this.hashColumns.put("blpkg", getBlpkg());
		this.hashColumns.put("reefer_ind", getReeferInd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("mark2", getMark2());
		this.hashColumns.put("blpod_eta", getBlpodEta());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("mark1", getMark1());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("mark5", getMark5());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("reefer", getReefer());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("runit", getRunit());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("blpkgu_nm", getBlpkguNm());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("blpodname", getBlpodname());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("issue_loc", getIssueLoc());
		this.hashColumns.put("shpr2", getShpr2());
		this.hashColumns.put("shpr1", getShpr1());
		this.hashColumns.put("blwgt", getBlwgt());
		this.hashColumns.put("blpolname", getBlpolname());
		this.hashColumns.put("blporname", getBlporname());
		this.hashColumns.put("shpr5", getShpr5());
		this.hashColumns.put("shpr4", getShpr4());
		this.hashColumns.put("shpr3", getShpr3());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("ntfy5", getNtfy5());
		this.hashColumns.put("bl_iss_loc_cd", getBlIssLocCd());
		this.hashColumns.put("ntfy4", getNtfy4());
		this.hashColumns.put("ntfy3", getNtfy3());
		this.hashColumns.put("ntfy2", getNtfy2());
		this.hashColumns.put("ntfy1", getNtfy1());
		this.hashColumns.put("bl_mk_desc", getBlMkDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("blpkgu", "blpkgu");
		this.hashFields.put("bl_pod_eta_dt", "blPodEtaDt");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("desc1", "desc1");
		this.hashFields.put("goodno", "goodno");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_iss_dt", "blIssDt");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("blmea", "blmea");
		this.hashFields.put("trans_ind", "transInd");
		this.hashFields.put("issue_loc_name", "issueLocName");
		this.hashFields.put("prflag", "prflag");
		this.hashFields.put("bldelname", "bldelname");
		this.hashFields.put("cnee5", "cnee5");
		this.hashFields.put("cnee3", "cnee3");
		this.hashFields.put("cnee4", "cnee4");
		this.hashFields.put("cnee1", "cnee1");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cnee2", "cnee2");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("rd_term", "rdTerm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("bl_iss_loc_nm", "blIssLocNm");
		this.hashFields.put("boarddate", "boarddate");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("issuedate", "issuedate");
		this.hashFields.put("s_cust_addr", "sCustAddr");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("mark4", "mark4");
		this.hashFields.put("mark3", "mark3");
		this.hashFields.put("blpkg", "blpkg");
		this.hashFields.put("reefer_ind", "reeferInd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("mark2", "mark2");
		this.hashFields.put("blpod_eta", "blpodEta");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("mark1", "mark1");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("mark5", "mark5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("reefer", "reefer");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("runit", "runit");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("blpkgu_nm", "blpkguNm");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("blpodname", "blpodname");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("issue_loc", "issueLoc");
		this.hashFields.put("shpr2", "shpr2");
		this.hashFields.put("shpr1", "shpr1");
		this.hashFields.put("blwgt", "blwgt");
		this.hashFields.put("blpolname", "blpolname");
		this.hashFields.put("blporname", "blporname");
		this.hashFields.put("shpr5", "shpr5");
		this.hashFields.put("shpr4", "shpr4");
		this.hashFields.put("shpr3", "shpr3");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("ntfy5", "ntfy5");
		this.hashFields.put("bl_iss_loc_cd", "blIssLocCd");
		this.hashFields.put("ntfy4", "ntfy4");
		this.hashFields.put("ntfy3", "ntfy3");
		this.hashFields.put("ntfy2", "ntfy2");
		this.hashFields.put("ntfy1", "ntfy1");
		this.hashFields.put("bl_mk_desc", "blMkDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return blpkgu
	 */
	public String getBlpkgu() {
		return this.blpkgu;
	}
	
	/**
	 * Column Info
	 * @return blPodEtaDt
	 */
	public String getBlPodEtaDt() {
		return this.blPodEtaDt;
	}
	
	/**
	 * Column Info
	 * @return bldel
	 */
	public String getBldel() {
		return this.bldel;
	}
	
	/**
	 * Column Info
	 * @return desc1
	 */
	public String getDesc1() {
		return this.desc1;
	}
	
	/**
	 * Column Info
	 * @return goodno
	 */
	public String getGoodno() {
		return this.goodno;
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
	 * @return blIssDt
	 */
	public String getBlIssDt() {
		return this.blIssDt;
	}
	
	/**
	 * Column Info
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @return blmea
	 */
	public String getBlmea() {
		return this.blmea;
	}
	
	/**
	 * Column Info
	 * @return transInd
	 */
	public String getTransInd() {
		return this.transInd;
	}
	
	/**
	 * Column Info
	 * @return issueLocName
	 */
	public String getIssueLocName() {
		return this.issueLocName;
	}
	
	/**
	 * Column Info
	 * @return prflag
	 */
	public String getPrflag() {
		return this.prflag;
	}
	
	/**
	 * Column Info
	 * @return bldelname
	 */
	public String getBldelname() {
		return this.bldelname;
	}
	
	/**
	 * Column Info
	 * @return cnee5
	 */
	public String getCnee5() {
		return this.cnee5;
	}
	
	/**
	 * Column Info
	 * @return cnee3
	 */
	public String getCnee3() {
		return this.cnee3;
	}
	
	/**
	 * Column Info
	 * @return cnee4
	 */
	public String getCnee4() {
		return this.cnee4;
	}
	
	/**
	 * Column Info
	 * @return cnee1
	 */
	public String getCnee1() {
		return this.cnee1;
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
	 * @return cnee2
	 */
	public String getCnee2() {
		return this.cnee2;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return rdTerm
	 */
	public String getRdTerm() {
		return this.rdTerm;
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
	 * @return porNm
	 */
	public String getPorNm() {
		return this.porNm;
	}
	
	/**
	 * Column Info
	 * @return blIssLocNm
	 */
	public String getBlIssLocNm() {
		return this.blIssLocNm;
	}
	
	/**
	 * Column Info
	 * @return boarddate
	 */
	public String getBoarddate() {
		return this.boarddate;
	}
	
	/**
	 * Column Info
	 * @return blpod
	 */
	public String getBlpod() {
		return this.blpod;
	}
	
	/**
	 * Column Info
	 * @return issuedate
	 */
	public String getIssuedate() {
		return this.issuedate;
	}
	
	/**
	 * Column Info
	 * @return sCustAddr
	 */
	public String getSCustAddr() {
		return this.sCustAddr;
	}
	
	/**
	 * Column Info
	 * @return blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return mark4
	 */
	public String getMark4() {
		return this.mark4;
	}
	
	/**
	 * Column Info
	 * @return mark3
	 */
	public String getMark3() {
		return this.mark3;
	}
	
	/**
	 * Column Info
	 * @return blpkg
	 */
	public String getBlpkg() {
		return this.blpkg;
	}
	
	/**
	 * Column Info
	 * @return reeferInd
	 */
	public String getReeferInd() {
		return this.reeferInd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return mark2
	 */
	public String getMark2() {
		return this.mark2;
	}
	
	/**
	 * Column Info
	 * @return blpodEta
	 */
	public String getBlpodEta() {
		return this.blpodEta;
	}
	
	/**
	 * Column Info
	 * @return blpor
	 */
	public String getBlpor() {
		return this.blpor;
	}
	
	/**
	 * Column Info
	 * @return mark1
	 */
	public String getMark1() {
		return this.mark1;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return blpol
	 */
	public String getBlpol() {
		return this.blpol;
	}
	
	/**
	 * Column Info
	 * @return nCustAddr
	 */
	public String getNCustAddr() {
		return this.nCustAddr;
	}
	
	/**
	 * Column Info
	 * @return mark5
	 */
	public String getMark5() {
		return this.mark5;
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
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return reefer
	 */
	public String getReefer() {
		return this.reefer;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return runit
	 */
	public String getRunit() {
		return this.runit;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return blpkguNm
	 */
	public String getBlpkguNm() {
		return this.blpkguNm;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return blpodname
	 */
	public String getBlpodname() {
		return this.blpodname;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return issueLoc
	 */
	public String getIssueLoc() {
		return this.issueLoc;
	}
	
	/**
	 * Column Info
	 * @return shpr2
	 */
	public String getShpr2() {
		return this.shpr2;
	}
	
	/**
	 * Column Info
	 * @return shpr1
	 */
	public String getShpr1() {
		return this.shpr1;
	}
	
	/**
	 * Column Info
	 * @return blwgt
	 */
	public String getBlwgt() {
		return this.blwgt;
	}
	
	/**
	 * Column Info
	 * @return blpolname
	 */
	public String getBlpolname() {
		return this.blpolname;
	}
	
	/**
	 * Column Info
	 * @return blporname
	 */
	public String getBlporname() {
		return this.blporname;
	}
	
	/**
	 * Column Info
	 * @return shpr5
	 */
	public String getShpr5() {
		return this.shpr5;
	}
	
	/**
	 * Column Info
	 * @return shpr4
	 */
	public String getShpr4() {
		return this.shpr4;
	}
	
	/**
	 * Column Info
	 * @return shpr3
	 */
	public String getShpr3() {
		return this.shpr3;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return ntfy5
	 */
	public String getNtfy5() {
		return this.ntfy5;
	}
	
	/**
	 * Column Info
	 * @return blIssLocCd
	 */
	public String getBlIssLocCd() {
		return this.blIssLocCd;
	}
	
	/**
	 * Column Info
	 * @return ntfy4
	 */
	public String getNtfy4() {
		return this.ntfy4;
	}
	
	/**
	 * Column Info
	 * @return ntfy3
	 */
	public String getNtfy3() {
		return this.ntfy3;
	}
	
	/**
	 * Column Info
	 * @return ntfy2
	 */
	public String getNtfy2() {
		return this.ntfy2;
	}
	
	/**
	 * Column Info
	 * @return ntfy1
	 */
	public String getNtfy1() {
		return this.ntfy1;
	}
	
	/**
	 * Column Info
	 * @return blMkDesc
	 */
	public String getBlMkDesc() {
		return this.blMkDesc;
	}
	

	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param blpkgu
	 */
	public void setBlpkgu(String blpkgu) {
		this.blpkgu = blpkgu;
	}
	
	/**
	 * Column Info
	 * @param blPodEtaDt
	 */
	public void setBlPodEtaDt(String blPodEtaDt) {
		this.blPodEtaDt = blPodEtaDt;
	}
	
	/**
	 * Column Info
	 * @param bldel
	 */
	public void setBldel(String bldel) {
		this.bldel = bldel;
	}
	
	/**
	 * Column Info
	 * @param desc1
	 */
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	
	/**
	 * Column Info
	 * @param goodno
	 */
	public void setGoodno(String goodno) {
		this.goodno = goodno;
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
	 * @param blIssDt
	 */
	public void setBlIssDt(String blIssDt) {
		this.blIssDt = blIssDt;
	}
	
	/**
	 * Column Info
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @param blmea
	 */
	public void setBlmea(String blmea) {
		this.blmea = blmea;
	}
	
	/**
	 * Column Info
	 * @param transInd
	 */
	public void setTransInd(String transInd) {
		this.transInd = transInd;
	}
	
	/**
	 * Column Info
	 * @param issueLocName
	 */
	public void setIssueLocName(String issueLocName) {
		this.issueLocName = issueLocName;
	}
	
	/**
	 * Column Info
	 * @param prflag
	 */
	public void setPrflag(String prflag) {
		this.prflag = prflag;
	}
	
	/**
	 * Column Info
	 * @param bldelname
	 */
	public void setBldelname(String bldelname) {
		this.bldelname = bldelname;
	}
	
	/**
	 * Column Info
	 * @param cnee5
	 */
	public void setCnee5(String cnee5) {
		this.cnee5 = cnee5;
	}
	
	/**
	 * Column Info
	 * @param cnee3
	 */
	public void setCnee3(String cnee3) {
		this.cnee3 = cnee3;
	}
	
	/**
	 * Column Info
	 * @param cnee4
	 */
	public void setCnee4(String cnee4) {
		this.cnee4 = cnee4;
	}
	
	/**
	 * Column Info
	 * @param cnee1
	 */
	public void setCnee1(String cnee1) {
		this.cnee1 = cnee1;
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
	 * @param cnee2
	 */
	public void setCnee2(String cnee2) {
		this.cnee2 = cnee2;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param rdTerm
	 */
	public void setRdTerm(String rdTerm) {
		this.rdTerm = rdTerm;
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
	 * @param porNm
	 */
	public void setPorNm(String porNm) {
		this.porNm = porNm;
	}
	
	/**
	 * Column Info
	 * @param blIssLocNm
	 */
	public void setBlIssLocNm(String blIssLocNm) {
		this.blIssLocNm = blIssLocNm;
	}
	
	/**
	 * Column Info
	 * @param boarddate
	 */
	public void setBoarddate(String boarddate) {
		this.boarddate = boarddate;
	}
	
	/**
	 * Column Info
	 * @param blpod
	 */
	public void setBlpod(String blpod) {
		this.blpod = blpod;
	}
	
	/**
	 * Column Info
	 * @param issuedate
	 */
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	
	/**
	 * Column Info
	 * @param sCustAddr
	 */
	public void setSCustAddr(String sCustAddr) {
		this.sCustAddr = sCustAddr;
	}
	
	/**
	 * Column Info
	 * @param blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param mark4
	 */
	public void setMark4(String mark4) {
		this.mark4 = mark4;
	}
	
	/**
	 * Column Info
	 * @param mark3
	 */
	public void setMark3(String mark3) {
		this.mark3 = mark3;
	}
	
	/**
	 * Column Info
	 * @param blpkg
	 */
	public void setBlpkg(String blpkg) {
		this.blpkg = blpkg;
	}
	
	/**
	 * Column Info
	 * @param reeferInd
	 */
	public void setReeferInd(String reeferInd) {
		this.reeferInd = reeferInd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param mark2
	 */
	public void setMark2(String mark2) {
		this.mark2 = mark2;
	}
	
	/**
	 * Column Info
	 * @param blpodEta
	 */
	public void setBlpodEta(String blpodEta) {
		this.blpodEta = blpodEta;
	}
	
	/**
	 * Column Info
	 * @param blpor
	 */
	public void setBlpor(String blpor) {
		this.blpor = blpor;
	}
	
	/**
	 * Column Info
	 * @param mark1
	 */
	public void setMark1(String mark1) {
		this.mark1 = mark1;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param blpol
	 */
	public void setBlpol(String blpol) {
		this.blpol = blpol;
	}
	
	/**
	 * Column Info
	 * @param nCustAddr
	 */
	public void setNCustAddr(String nCustAddr) {
		this.nCustAddr = nCustAddr;
	}
	
	/**
	 * Column Info
	 * @param mark5
	 */
	public void setMark5(String mark5) {
		this.mark5 = mark5;
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
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param reefer
	 */
	public void setReefer(String reefer) {
		this.reefer = reefer;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param runit
	 */
	public void setRunit(String runit) {
		this.runit = runit;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param blpkguNm
	 */
	public void setBlpkguNm(String blpkguNm) {
		this.blpkguNm = blpkguNm;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param blpodname
	 */
	public void setBlpodname(String blpodname) {
		this.blpodname = blpodname;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param issueLoc
	 */
	public void setIssueLoc(String issueLoc) {
		this.issueLoc = issueLoc;
	}
	
	/**
	 * Column Info
	 * @param shpr2
	 */
	public void setShpr2(String shpr2) {
		this.shpr2 = shpr2;
	}
	
	/**
	 * Column Info
	 * @param shpr1
	 */
	public void setShpr1(String shpr1) {
		this.shpr1 = shpr1;
	}
	
	/**
	 * Column Info
	 * @param blwgt
	 */
	public void setBlwgt(String blwgt) {
		this.blwgt = blwgt;
	}
	
	/**
	 * Column Info
	 * @param blpolname
	 */
	public void setBlpolname(String blpolname) {
		this.blpolname = blpolname;
	}
	
	/**
	 * Column Info
	 * @param blporname
	 */
	public void setBlporname(String blporname) {
		this.blporname = blporname;
	}
	
	/**
	 * Column Info
	 * @param shpr5
	 */
	public void setShpr5(String shpr5) {
		this.shpr5 = shpr5;
	}
	
	/**
	 * Column Info
	 * @param shpr4
	 */
	public void setShpr4(String shpr4) {
		this.shpr4 = shpr4;
	}
	
	/**
	 * Column Info
	 * @param shpr3
	 */
	public void setShpr3(String shpr3) {
		this.shpr3 = shpr3;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param ntfy5
	 */
	public void setNtfy5(String ntfy5) {
		this.ntfy5 = ntfy5;
	}
	
	/**
	 * Column Info
	 * @param blIssLocCd
	 */
	public void setBlIssLocCd(String blIssLocCd) {
		this.blIssLocCd = blIssLocCd;
	}
	
	/**
	 * Column Info
	 * @param ntfy4
	 */
	public void setNtfy4(String ntfy4) {
		this.ntfy4 = ntfy4;
	}
	
	/**
	 * Column Info
	 * @param ntfy3
	 */
	public void setNtfy3(String ntfy3) {
		this.ntfy3 = ntfy3;
	}
	
	/**
	 * Column Info
	 * @param ntfy2
	 */
	public void setNtfy2(String ntfy2) {
		this.ntfy2 = ntfy2;
	}
	
	/**
	 * Column Info
	 * @param ntfy1
	 */
	public void setNtfy1(String ntfy1) {
		this.ntfy1 = ntfy1;
	}
	
	/**
	 * Column Info
	 * @param blMkDesc
	 */
	public void setBlMkDesc(String blMkDesc) {
		this.blMkDesc = blMkDesc;
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
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setBlpkgu(JSPUtil.getParameter(request, prefix + "blpkgu", ""));
		setBlPodEtaDt(JSPUtil.getParameter(request, prefix + "bl_pod_eta_dt", ""));
		setBldel(JSPUtil.getParameter(request, prefix + "bldel", ""));
		setDesc1(JSPUtil.getParameter(request, prefix + "desc1", ""));
		setGoodno(JSPUtil.getParameter(request, prefix + "goodno", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlIssDt(JSPUtil.getParameter(request, prefix + "bl_iss_dt", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setBlmea(JSPUtil.getParameter(request, prefix + "blmea", ""));
		setTransInd(JSPUtil.getParameter(request, prefix + "trans_ind", ""));
		setIssueLocName(JSPUtil.getParameter(request, prefix + "issue_loc_name", ""));
		setPrflag(JSPUtil.getParameter(request, prefix + "prflag", ""));
		setBldelname(JSPUtil.getParameter(request, prefix + "bldelname", ""));
		setCnee5(JSPUtil.getParameter(request, prefix + "cnee5", ""));
		setCnee3(JSPUtil.getParameter(request, prefix + "cnee3", ""));
		setCnee4(JSPUtil.getParameter(request, prefix + "cnee4", ""));
		setCnee1(JSPUtil.getParameter(request, prefix + "cnee1", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCnee2(JSPUtil.getParameter(request, prefix + "cnee2", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setRdTerm(JSPUtil.getParameter(request, prefix + "rd_term", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
		setBlIssLocNm(JSPUtil.getParameter(request, prefix + "bl_iss_loc_nm", ""));
		setBoarddate(JSPUtil.getParameter(request, prefix + "boarddate", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setIssuedate(JSPUtil.getParameter(request, prefix + "issuedate", ""));
		setSCustAddr(JSPUtil.getParameter(request, prefix + "s_cust_addr", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setMark4(JSPUtil.getParameter(request, prefix + "mark4", ""));
		setMark3(JSPUtil.getParameter(request, prefix + "mark3", ""));
		setBlpkg(JSPUtil.getParameter(request, prefix + "blpkg", ""));
		setReeferInd(JSPUtil.getParameter(request, prefix + "reefer_ind", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setMark2(JSPUtil.getParameter(request, prefix + "mark2", ""));
		setBlpodEta(JSPUtil.getParameter(request, prefix + "blpod_eta", ""));
		setBlpor(JSPUtil.getParameter(request, prefix + "blpor", ""));
		setMark1(JSPUtil.getParameter(request, prefix + "mark1", ""));
		setCCustNm(JSPUtil.getParameter(request, prefix + "c_cust_nm", ""));
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setNCustAddr(JSPUtil.getParameter(request, prefix + "n_cust_addr", ""));
		setMark5(JSPUtil.getParameter(request, prefix + "mark5", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCCustAddr(JSPUtil.getParameter(request, prefix + "c_cust_addr", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setReefer(JSPUtil.getParameter(request, prefix + "reefer", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setRunit(JSPUtil.getParameter(request, prefix + "runit", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setBlpkguNm(JSPUtil.getParameter(request, prefix + "blpkgu_nm", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setBlpodname(JSPUtil.getParameter(request, prefix + "blpodname", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setIssueLoc(JSPUtil.getParameter(request, prefix + "issue_loc", ""));
		setShpr2(JSPUtil.getParameter(request, prefix + "shpr2", ""));
		setShpr1(JSPUtil.getParameter(request, prefix + "shpr1", ""));
		setBlwgt(JSPUtil.getParameter(request, prefix + "blwgt", ""));
		setBlpolname(JSPUtil.getParameter(request, prefix + "blpolname", ""));
		setBlporname(JSPUtil.getParameter(request, prefix + "blporname", ""));
		setShpr5(JSPUtil.getParameter(request, prefix + "shpr5", ""));
		setShpr4(JSPUtil.getParameter(request, prefix + "shpr4", ""));
		setShpr3(JSPUtil.getParameter(request, prefix + "shpr3", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setNtfy5(JSPUtil.getParameter(request, prefix + "ntfy5", ""));
		setBlIssLocCd(JSPUtil.getParameter(request, prefix + "bl_iss_loc_cd", ""));
		setNtfy4(JSPUtil.getParameter(request, prefix + "ntfy4", ""));
		setNtfy3(JSPUtil.getParameter(request, prefix + "ntfy3", ""));
		setNtfy2(JSPUtil.getParameter(request, prefix + "ntfy2", ""));
		setNtfy1(JSPUtil.getParameter(request, prefix + "ntfy1", ""));
		setBlMkDesc(JSPUtil.getParameter(request, prefix + "bl_mk_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RussiatransmitBlListVO[]
	 */
	public RussiatransmitBlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RussiatransmitBlListVO[]
	 */
	public RussiatransmitBlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RussiatransmitBlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] blpkgu = (JSPUtil.getParameter(request, prefix	+ "blpkgu", length));
			String[] blPodEtaDt = (JSPUtil.getParameter(request, prefix	+ "bl_pod_eta_dt", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] desc1 = (JSPUtil.getParameter(request, prefix	+ "desc1", length));
			String[] goodno = (JSPUtil.getParameter(request, prefix	+ "goodno", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blIssDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_dt", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] blmea = (JSPUtil.getParameter(request, prefix	+ "blmea", length));
			String[] transInd = (JSPUtil.getParameter(request, prefix	+ "trans_ind", length));
			String[] issueLocName = (JSPUtil.getParameter(request, prefix	+ "issue_loc_name", length));
			String[] prflag = (JSPUtil.getParameter(request, prefix	+ "prflag", length));
			String[] bldelname = (JSPUtil.getParameter(request, prefix	+ "bldelname", length));
			String[] cnee5 = (JSPUtil.getParameter(request, prefix	+ "cnee5", length));
			String[] cnee3 = (JSPUtil.getParameter(request, prefix	+ "cnee3", length));
			String[] cnee4 = (JSPUtil.getParameter(request, prefix	+ "cnee4", length));
			String[] cnee1 = (JSPUtil.getParameter(request, prefix	+ "cnee1", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cnee2 = (JSPUtil.getParameter(request, prefix	+ "cnee2", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] rdTerm = (JSPUtil.getParameter(request, prefix	+ "rd_term", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] blIssLocNm = (JSPUtil.getParameter(request, prefix	+ "bl_iss_loc_nm", length));
			String[] boarddate = (JSPUtil.getParameter(request, prefix	+ "boarddate", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] issuedate = (JSPUtil.getParameter(request, prefix	+ "issuedate", length));
			String[] sCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] mark4 = (JSPUtil.getParameter(request, prefix	+ "mark4", length));
			String[] mark3 = (JSPUtil.getParameter(request, prefix	+ "mark3", length));
			String[] blpkg = (JSPUtil.getParameter(request, prefix	+ "blpkg", length));
			String[] reeferInd = (JSPUtil.getParameter(request, prefix	+ "reefer_ind", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] mark2 = (JSPUtil.getParameter(request, prefix	+ "mark2", length));
			String[] blpodEta = (JSPUtil.getParameter(request, prefix	+ "blpod_eta", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] mark1 = (JSPUtil.getParameter(request, prefix	+ "mark1", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] mark5 = (JSPUtil.getParameter(request, prefix	+ "mark5", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] reefer = (JSPUtil.getParameter(request, prefix	+ "reefer", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] runit = (JSPUtil.getParameter(request, prefix	+ "runit", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] blpkguNm = (JSPUtil.getParameter(request, prefix	+ "blpkgu_nm", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] blpodname = (JSPUtil.getParameter(request, prefix	+ "blpodname", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] issueLoc = (JSPUtil.getParameter(request, prefix	+ "issue_loc", length));
			String[] shpr2 = (JSPUtil.getParameter(request, prefix	+ "shpr2", length));
			String[] shpr1 = (JSPUtil.getParameter(request, prefix	+ "shpr1", length));
			String[] blwgt = (JSPUtil.getParameter(request, prefix	+ "blwgt", length));
			String[] blpolname = (JSPUtil.getParameter(request, prefix	+ "blpolname", length));
			String[] blporname = (JSPUtil.getParameter(request, prefix	+ "blporname", length));
			String[] shpr5 = (JSPUtil.getParameter(request, prefix	+ "shpr5", length));
			String[] shpr4 = (JSPUtil.getParameter(request, prefix	+ "shpr4", length));
			String[] shpr3 = (JSPUtil.getParameter(request, prefix	+ "shpr3", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] ntfy5 = (JSPUtil.getParameter(request, prefix	+ "ntfy5", length));
			String[] blIssLocCd = (JSPUtil.getParameter(request, prefix	+ "bl_iss_loc_cd", length));
			String[] ntfy4 = (JSPUtil.getParameter(request, prefix	+ "ntfy4", length));
			String[] ntfy3 = (JSPUtil.getParameter(request, prefix	+ "ntfy3", length));
			String[] ntfy2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2", length));
			String[] ntfy1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1", length));
			String[] blMkDesc = (JSPUtil.getParameter(request, prefix	+ "bl_mk_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new RussiatransmitBlListVO();
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (blpkgu[i] != null)
					model.setBlpkgu(blpkgu[i]);
				if (blPodEtaDt[i] != null)
					model.setBlPodEtaDt(blPodEtaDt[i]);
				if (bldel[i] != null)
					model.setBldel(bldel[i]);
				if (desc1[i] != null)
					model.setDesc1(desc1[i]);
				if (goodno[i] != null)
					model.setGoodno(goodno[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blIssDt[i] != null)
					model.setBlIssDt(blIssDt[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (blmea[i] != null)
					model.setBlmea(blmea[i]);
				if (transInd[i] != null)
					model.setTransInd(transInd[i]);
				if (issueLocName[i] != null)
					model.setIssueLocName(issueLocName[i]);
				if (prflag[i] != null)
					model.setPrflag(prflag[i]);
				if (bldelname[i] != null)
					model.setBldelname(bldelname[i]);
				if (cnee5[i] != null)
					model.setCnee5(cnee5[i]);
				if (cnee3[i] != null)
					model.setCnee3(cnee3[i]);
				if (cnee4[i] != null)
					model.setCnee4(cnee4[i]);
				if (cnee1[i] != null)
					model.setCnee1(cnee1[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cnee2[i] != null)
					model.setCnee2(cnee2[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (rdTerm[i] != null)
					model.setRdTerm(rdTerm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (blIssLocNm[i] != null)
					model.setBlIssLocNm(blIssLocNm[i]);
				if (boarddate[i] != null)
					model.setBoarddate(boarddate[i]);
				if (blpod[i] != null)
					model.setBlpod(blpod[i]);
				if (issuedate[i] != null)
					model.setIssuedate(issuedate[i]);
				if (sCustAddr[i] != null)
					model.setSCustAddr(sCustAddr[i]);
				if (blnbr[i] != null)
					model.setBlnbr(blnbr[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (mark4[i] != null)
					model.setMark4(mark4[i]);
				if (mark3[i] != null)
					model.setMark3(mark3[i]);
				if (blpkg[i] != null)
					model.setBlpkg(blpkg[i]);
				if (reeferInd[i] != null)
					model.setReeferInd(reeferInd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (mark2[i] != null)
					model.setMark2(mark2[i]);
				if (blpodEta[i] != null)
					model.setBlpodEta(blpodEta[i]);
				if (blpor[i] != null)
					model.setBlpor(blpor[i]);
				if (mark1[i] != null)
					model.setMark1(mark1[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (blpol[i] != null)
					model.setBlpol(blpol[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (mark5[i] != null)
					model.setMark5(mark5[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (reefer[i] != null)
					model.setReefer(reefer[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (runit[i] != null)
					model.setRunit(runit[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (blpkguNm[i] != null)
					model.setBlpkguNm(blpkguNm[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (blpodname[i] != null)
					model.setBlpodname(blpodname[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (issueLoc[i] != null)
					model.setIssueLoc(issueLoc[i]);
				if (shpr2[i] != null)
					model.setShpr2(shpr2[i]);
				if (shpr1[i] != null)
					model.setShpr1(shpr1[i]);
				if (blwgt[i] != null)
					model.setBlwgt(blwgt[i]);
				if (blpolname[i] != null)
					model.setBlpolname(blpolname[i]);
				if (blporname[i] != null)
					model.setBlporname(blporname[i]);
				if (shpr5[i] != null)
					model.setShpr5(shpr5[i]);
				if (shpr4[i] != null)
					model.setShpr4(shpr4[i]);
				if (shpr3[i] != null)
					model.setShpr3(shpr3[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (ntfy5[i] != null)
					model.setNtfy5(ntfy5[i]);
				if (blIssLocCd[i] != null)
					model.setBlIssLocCd(blIssLocCd[i]);
				if (ntfy4[i] != null)
					model.setNtfy4(ntfy4[i]);
				if (ntfy3[i] != null)
					model.setNtfy3(ntfy3[i]);
				if (ntfy2[i] != null)
					model.setNtfy2(ntfy2[i]);
				if (ntfy1[i] != null)
					model.setNtfy1(ntfy1[i]);
				if (blMkDesc[i] != null)
					model.setBlMkDesc(blMkDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRussiatransmitBlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RussiatransmitBlListVO[]
	 */
	public RussiatransmitBlListVO[] getRussiatransmitBlListVOs(){
		RussiatransmitBlListVO[] vos = (RussiatransmitBlListVO[])models.toArray(new RussiatransmitBlListVO[models.size()]);
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
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkgu = this.blpkgu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPodEtaDt = this.blPodEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc1 = this.desc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodno = this.goodno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssDt = this.blIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmea = this.blmea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transInd = this.transInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueLocName = this.issueLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prflag = this.prflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldelname = this.bldelname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee5 = this.cnee5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee3 = this.cnee3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee4 = this.cnee4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee1 = this.cnee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee2 = this.cnee2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTerm = this.rdTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssLocNm = this.blIssLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boarddate = this.boarddate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issuedate = this.issuedate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddr = this.sCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark4 = this.mark4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark3 = this.mark3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkg = this.blpkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reeferInd = this.reeferInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark2 = this.mark2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpodEta = this.blpodEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark1 = this.mark1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark5 = this.mark5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reefer = this.reefer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runit = this.runit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkguNm = this.blpkguNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpodname = this.blpodname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueLoc = this.issueLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr2 = this.shpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr1 = this.shpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blwgt = this.blwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpolname = this.blpolname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blporname = this.blporname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr5 = this.shpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr4 = this.shpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr3 = this.shpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy5 = this.ntfy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssLocCd = this.blIssLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy4 = this.ntfy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy3 = this.ntfy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2 = this.ntfy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1 = this.ntfy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMkDesc = this.blMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
