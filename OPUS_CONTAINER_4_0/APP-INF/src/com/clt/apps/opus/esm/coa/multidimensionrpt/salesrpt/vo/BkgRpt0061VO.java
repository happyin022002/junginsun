/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgRpt0061VO.java
*@FileTitle : BkgRpt0061VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.08 송호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo; 

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgRpt0061VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgRpt0061VO> models = new ArrayList<BkgRpt0061VO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String costRoutNo = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String spclRcFlg = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String n2ndRlaneCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String n2ndTsPortCd = null;
	/* Column Info */
	private String ibItchgCtnt = null;
	/* Column Info */
	private String n1stTsPortCd = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obItchgCtnt = null;
	/* Column Info */
	private String hrs = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String spclDgCgoFlg = null;
	/* Column Info */
	private String n1stRlaneCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String spclAwkCgoFlg = null; 
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String n4thRlaneCd = null;
	/* Column Info */
	private String bkgCgoWgt = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String bkgWgtTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String spclBbCgoFlg = null;
	/* Column Info */
	private String n3rdRlaneCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String costRoutNo2 = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String n3rdTsPortCd = null;
	
	/* Column Info */
	private String mtyPkupEcc = null;			//SJH.20141016.ADD
	/* Column Info */
	private String mtyRtnEcc = null;			//SJH.20141016.ADD

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgRpt0061VO() {}

	public BkgRpt0061VO(String ibflag, String pagerows, String pctlNo, String bkgNo, String costRoutNo, String costRoutNo2, String porCd, String polCd, String n1stTsPortCd, String n2ndTsPortCd, String n3rdTsPortCd, String podCd, String delCd, String obItchgCtnt, String ibItchgCtnt, String spclDgCgoFlg, String spclRcFlg, String spclAwkCgoFlg, String spclBbCgoFlg, String socFlg, String bkgCgoTpCd, String n1stRlaneCd, String n2ndRlaneCd, String n3rdRlaneCd, String n4thRlaneCd, String cltOfcCd, String slsOfcCd, String shipper, String iocCd, String vvd, String bkgDeTermCd, String bkgRcvTermCd, String repCmdtCd, String shprNm, String rlaneCd, String hrs, String bkgStsCd, String slsYrmon, String costYrmon, String costWk, String bkgCgoWgt, String bkgWgtTpCd, String mtyPkupEcc, String mtyRtnEcc) {
		this.porCd = porCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.costRoutNo = costRoutNo;
		this.bkgStsCd = bkgStsCd;
		this.spclRcFlg = spclRcFlg;
		this.cltOfcCd = cltOfcCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.n2ndRlaneCd = n2ndRlaneCd;
		this.rlaneCd = rlaneCd;
		this.n2ndTsPortCd = n2ndTsPortCd;
		this.ibItchgCtnt = ibItchgCtnt;
		this.n1stTsPortCd = n1stTsPortCd;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.obItchgCtnt = obItchgCtnt;
		this.hrs = hrs;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.slsOfcCd = slsOfcCd;
		this.spclDgCgoFlg = spclDgCgoFlg;
		this.n1stRlaneCd = n1stRlaneCd;
		this.shprNm = shprNm;
		this.spclAwkCgoFlg = spclAwkCgoFlg;
		this.iocCd = iocCd;
		this.shipper = shipper;
		this.delCd = delCd;
		this.n4thRlaneCd = n4thRlaneCd;
		this.bkgCgoWgt = bkgCgoWgt;
		this.slsYrmon = slsYrmon;
		this.vvd = vvd;
		this.podCd = podCd;
		this.socFlg = socFlg;
		this.bkgWgtTpCd = bkgWgtTpCd;
		this.bkgNo = bkgNo;
		this.spclBbCgoFlg = spclBbCgoFlg;
		this.n3rdRlaneCd = n3rdRlaneCd;
		this.costWk = costWk;
		this.costRoutNo2 = costRoutNo2;
		this.repCmdtCd = repCmdtCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.n3rdTsPortCd = n3rdTsPortCd;		
		this.mtyPkupEcc = mtyPkupEcc;			//SJH.20141016.ADD
		this.mtyRtnEcc = mtyRtnEcc;				//SJH.20141016.ADD
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cost_rout_no", getCostRoutNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("spcl_rc_flg", getSpclRcFlg());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("n2nd_rlane_cd", getN2ndRlaneCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("n2nd_ts_port_cd", getN2ndTsPortCd());
		this.hashColumns.put("ib_itchg_ctnt", getIbItchgCtnt());
		this.hashColumns.put("n1st_ts_port_cd", getN1stTsPortCd());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_itchg_ctnt", getObItchgCtnt());
		this.hashColumns.put("hrs", getHrs());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("spcl_dg_cgo_flg", getSpclDgCgoFlg());
		this.hashColumns.put("n1st_rlane_cd", getN1stRlaneCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("spcl_awk_cgo_flg", getSpclAwkCgoFlg());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("n4th_rlane_cd", getN4thRlaneCd());
		this.hashColumns.put("bkg_cgo_wgt", getBkgCgoWgt());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("bkg_wgt_tp_cd", getBkgWgtTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("spcl_bb_cgo_flg", getSpclBbCgoFlg());
		this.hashColumns.put("n3rd_rlane_cd", getN3rdRlaneCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("cost_rout_no2", getCostRoutNo2());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("n3rd_ts_port_cd", getN3rdTsPortCd());		
		this.hashColumns.put("mty_pkup_ecc", getMtyPkupEcc());		//SJH.20141016.ADD
		this.hashColumns.put("mty_rtn_ecc", getMtyRtnEcc());		//SJH.20141016.ADD
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cost_rout_no", "costRoutNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("spcl_rc_flg", "spclRcFlg");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("n2nd_rlane_cd", "n2ndRlaneCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("n2nd_ts_port_cd", "n2ndTsPortCd");
		this.hashFields.put("ib_itchg_ctnt", "ibItchgCtnt");
		this.hashFields.put("n1st_ts_port_cd", "n1stTsPortCd");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_itchg_ctnt", "obItchgCtnt");
		this.hashFields.put("hrs", "hrs");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("spcl_dg_cgo_flg", "spclDgCgoFlg");
		this.hashFields.put("n1st_rlane_cd", "n1stRlaneCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("spcl_awk_cgo_flg", "spclAwkCgoFlg");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("n4th_rlane_cd", "n4thRlaneCd");
		this.hashFields.put("bkg_cgo_wgt", "bkgCgoWgt");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("bkg_wgt_tp_cd", "bkgWgtTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("spcl_bb_cgo_flg", "spclBbCgoFlg");
		this.hashFields.put("n3rd_rlane_cd", "n3rdRlaneCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("cost_rout_no2", "costRoutNo2");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("n3rd_ts_port_cd", "n3rdTsPortCd");
		this.hashFields.put("mty_pkup_ecc", "mtyPkupEcc");		//SJH.20141016.ADD
		this.hashFields.put("mty_rtn_ecc", "mtyRtnEcc");		//SJH.20141016.ADD
		return this.hashFields;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return costRoutNo
	 */
	public String getCostRoutNo() {
		return this.costRoutNo;
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
	 * @return spclRcFlg
	 */
	public String getSpclRcFlg() {
		return this.spclRcFlg;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndRlaneCd
	 */
	public String getN2ndRlaneCd() {
		return this.n2ndRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndTsPortCd
	 */
	public String getN2ndTsPortCd() {
		return this.n2ndTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return ibItchgCtnt
	 */
	public String getIbItchgCtnt() {
		return this.ibItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPortCd
	 */
	public String getN1stTsPortCd() {
		return this.n1stTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return obItchgCtnt
	 */
	public String getObItchgCtnt() {
		return this.obItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @return hrs
	 */
	public String getHrs() {
		return this.hrs;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spclDgCgoFlg
	 */
	public String getSpclDgCgoFlg() {
		return this.spclDgCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return n1stRlaneCd
	 */
	public String getN1stRlaneCd() {
		return this.n1stRlaneCd;
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
	 * @return spclAwkCgoFlg
	 */
	public String getSpclAwkCgoFlg() {
		return this.spclAwkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
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
	 * @return n4thRlaneCd
	 */
	public String getN4thRlaneCd() {
		return this.n4thRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoWgt
	 */
	public String getBkgCgoWgt() {
		return this.bkgCgoWgt;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgWgtTpCd
	 */
	public String getBkgWgtTpCd() {
		return this.bkgWgtTpCd;
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
	 * @return spclBbCgoFlg
	 */
	public String getSpclBbCgoFlg() {
		return this.spclBbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return n3rdRlaneCd
	 */
	public String getN3rdRlaneCd() {
		return this.n3rdRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return costRoutNo2
	 */
	public String getCostRoutNo2() {
		return this.costRoutNo2;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdTsPortCd
	 */
	public String getN3rdTsPortCd() {
		return this.n3rdTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupEcc
	 * @SJH.20141016.ADD
	 */
	public String getMtyPkupEcc() {
		return this.mtyPkupEcc;
	}
	
	/**
	 * Column Info
	 * @return mtyRtnEcc
	 * @SJH.20141016.ADD
	 */
	public String getMtyRtnEcc() {
		return this.mtyRtnEcc;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param costRoutNo
	 */
	public void setCostRoutNo(String costRoutNo) {
		this.costRoutNo = costRoutNo;
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
	 * @param spclRcFlg
	 */
	public void setSpclRcFlg(String spclRcFlg) {
		this.spclRcFlg = spclRcFlg;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndRlaneCd
	 */
	public void setN2ndRlaneCd(String n2ndRlaneCd) {
		this.n2ndRlaneCd = n2ndRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndTsPortCd
	 */
	public void setN2ndTsPortCd(String n2ndTsPortCd) {
		this.n2ndTsPortCd = n2ndTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param ibItchgCtnt
	 */
	public void setIbItchgCtnt(String ibItchgCtnt) {
		this.ibItchgCtnt = ibItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPortCd
	 */
	public void setN1stTsPortCd(String n1stTsPortCd) {
		this.n1stTsPortCd = n1stTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param obItchgCtnt
	 */
	public void setObItchgCtnt(String obItchgCtnt) {
		this.obItchgCtnt = obItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @param hrs
	 */
	public void setHrs(String hrs) {
		this.hrs = hrs;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spclDgCgoFlg
	 */
	public void setSpclDgCgoFlg(String spclDgCgoFlg) {
		this.spclDgCgoFlg = spclDgCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param n1stRlaneCd
	 */
	public void setN1stRlaneCd(String n1stRlaneCd) {
		this.n1stRlaneCd = n1stRlaneCd;
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
	 * @param spclAwkCgoFlg
	 */
	public void setSpclAwkCgoFlg(String spclAwkCgoFlg) {
		this.spclAwkCgoFlg = spclAwkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
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
	 * @param n4thRlaneCd
	 */
	public void setN4thRlaneCd(String n4thRlaneCd) {
		this.n4thRlaneCd = n4thRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoWgt
	 */
	public void setBkgCgoWgt(String bkgCgoWgt) {
		this.bkgCgoWgt = bkgCgoWgt;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgWgtTpCd
	 */
	public void setBkgWgtTpCd(String bkgWgtTpCd) {
		this.bkgWgtTpCd = bkgWgtTpCd;
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
	 * @param spclBbCgoFlg
	 */
	public void setSpclBbCgoFlg(String spclBbCgoFlg) {
		this.spclBbCgoFlg = spclBbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param n3rdRlaneCd
	 */
	public void setN3rdRlaneCd(String n3rdRlaneCd) {
		this.n3rdRlaneCd = n3rdRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param costRoutNo2
	 */
	public void setCostRoutNo2(String costRoutNo2) {
		this.costRoutNo2 = costRoutNo2;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdTsPortCd
	 */
	public void setN3rdTsPortCd(String n3rdTsPortCd) {
		this.n3rdTsPortCd = n3rdTsPortCd;
	}	
	
	/**
	 * Column Info
	 * @param mtyPkupEcc
	 * @SJH.20141016.ADD
	 */
	public void setMtyPkupEcc(String mtyPkupEcc) {
		this.mtyPkupEcc = mtyPkupEcc;
	}
	
	/**
	 * Column Info
	 * @param mtyRtnEcc
	 * @SJH.20141016.ADD
	 */
	public void setMtyRtnEcc(String mtyRtnEcc) {
		this.mtyRtnEcc = mtyRtnEcc;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setCostRoutNo(JSPUtil.getParameter(request, "cost_rout_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setSpclRcFlg(JSPUtil.getParameter(request, "spcl_rc_flg", ""));
		setCltOfcCd(JSPUtil.getParameter(request, "clt_ofc_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, "bkg_rcv_term_cd", ""));
		setN2ndRlaneCd(JSPUtil.getParameter(request, "n2nd_rlane_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setN2ndTsPortCd(JSPUtil.getParameter(request, "n2nd_ts_port_cd", ""));
		setIbItchgCtnt(JSPUtil.getParameter(request, "ib_itchg_ctnt", ""));
		setN1stTsPortCd(JSPUtil.getParameter(request, "n1st_ts_port_cd", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObItchgCtnt(JSPUtil.getParameter(request, "ob_itchg_ctnt", ""));
		setHrs(JSPUtil.getParameter(request, "hrs", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setSpclDgCgoFlg(JSPUtil.getParameter(request, "spcl_dg_cgo_flg", ""));
		setN1stRlaneCd(JSPUtil.getParameter(request, "n1st_rlane_cd", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setSpclAwkCgoFlg(JSPUtil.getParameter(request, "spcl_awk_cgo_flg", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setShipper(JSPUtil.getParameter(request, "shipper", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setN4thRlaneCd(JSPUtil.getParameter(request, "n4th_rlane_cd", ""));
		setBkgCgoWgt(JSPUtil.getParameter(request, "bkg_cgo_wgt", ""));
		setSlsYrmon(JSPUtil.getParameter(request, "sls_yrmon", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setBkgWgtTpCd(JSPUtil.getParameter(request, "bkg_wgt_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSpclBbCgoFlg(JSPUtil.getParameter(request, "spcl_bb_cgo_flg", ""));
		setN3rdRlaneCd(JSPUtil.getParameter(request, "n3rd_rlane_cd", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setCostRoutNo2(JSPUtil.getParameter(request, "cost_rout_no2", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, "bkg_de_term_cd", ""));
		setN3rdTsPortCd(JSPUtil.getParameter(request, "n3rd_ts_port_cd", ""));		
		setMtyPkupEcc(JSPUtil.getParameter(request, "mty_pkup_ecc", ""));		//SJH.20141016.ADD
		setMtyRtnEcc(JSPUtil.getParameter(request, "mty_rtn_ecc", ""));			//SJH.20141016.ADD
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgRpt0061VO[]
	 */
	public BkgRpt0061VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgRpt0061VO[]
	 */
	public BkgRpt0061VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgRpt0061VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] costRoutNo = (JSPUtil.getParameter(request, prefix	+ "cost_rout_no", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] spclRcFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_rc_flg", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] n2ndRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_rlane_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] n2ndTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_port_cd", length));
			String[] ibItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ib_itchg_ctnt", length));
			String[] n1stTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_port_cd", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ob_itchg_ctnt", length));
			String[] hrs = (JSPUtil.getParameter(request, prefix	+ "hrs", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] spclDgCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_dg_cgo_flg", length));
			String[] n1stRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n1st_rlane_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] spclAwkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_awk_cgo_flg", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] n4thRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n4th_rlane_cd", length));
			String[] bkgCgoWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_wgt", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] bkgWgtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] spclBbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_bb_cgo_flg", length));
			String[] n3rdRlaneCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_rlane_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] costRoutNo2 = (JSPUtil.getParameter(request, prefix	+ "cost_rout_no2", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] n3rdTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_ts_port_cd", length));			
			String[] mtyPkupEcc = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_ecc", length));		//SJH.20141016.ADD
			String[] mtyRtnEcc = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_ecc", length));		//SJH.20141016.ADD
			
			for (int i = 0; i < length; i++) {
				model = new BkgRpt0061VO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (costRoutNo[i] != null)
					model.setCostRoutNo(costRoutNo[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (spclRcFlg[i] != null)
					model.setSpclRcFlg(spclRcFlg[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (n2ndRlaneCd[i] != null)
					model.setN2ndRlaneCd(n2ndRlaneCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (n2ndTsPortCd[i] != null)
					model.setN2ndTsPortCd(n2ndTsPortCd[i]);
				if (ibItchgCtnt[i] != null)
					model.setIbItchgCtnt(ibItchgCtnt[i]);
				if (n1stTsPortCd[i] != null)
					model.setN1stTsPortCd(n1stTsPortCd[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obItchgCtnt[i] != null)
					model.setObItchgCtnt(obItchgCtnt[i]);
				if (hrs[i] != null)
					model.setHrs(hrs[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (spclDgCgoFlg[i] != null)
					model.setSpclDgCgoFlg(spclDgCgoFlg[i]);
				if (n1stRlaneCd[i] != null)
					model.setN1stRlaneCd(n1stRlaneCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (spclAwkCgoFlg[i] != null)
					model.setSpclAwkCgoFlg(spclAwkCgoFlg[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (n4thRlaneCd[i] != null)
					model.setN4thRlaneCd(n4thRlaneCd[i]);
				if (bkgCgoWgt[i] != null)
					model.setBkgCgoWgt(bkgCgoWgt[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (bkgWgtTpCd[i] != null)
					model.setBkgWgtTpCd(bkgWgtTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (spclBbCgoFlg[i] != null)
					model.setSpclBbCgoFlg(spclBbCgoFlg[i]);
				if (n3rdRlaneCd[i] != null)
					model.setN3rdRlaneCd(n3rdRlaneCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (costRoutNo2[i] != null)
					model.setCostRoutNo2(costRoutNo2[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (n3rdTsPortCd[i] != null)
					model.setN3rdTsPortCd(n3rdTsPortCd[i]);
				if (mtyPkupEcc[i] != null)
					model.setMtyPkupEcc(mtyPkupEcc[i]);			//SJH.20141016.ADD		
				if (mtyRtnEcc[i] != null)
					model.setMtyRtnEcc(mtyRtnEcc[i]);			//SJH.20141016.ADD		
				models.add(model);	
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgRpt0061VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgRpt0061VO[]
	 */
	public BkgRpt0061VO[] getBkgRpt0061VOs(){
		BkgRpt0061VO[] vos = (BkgRpt0061VO[])models.toArray(new BkgRpt0061VO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutNo = this.costRoutNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclRcFlg = this.spclRcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRlaneCd = this.n2ndRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPortCd = this.n2ndTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibItchgCtnt = this.ibItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPortCd = this.n1stTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obItchgCtnt = this.obItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrs = this.hrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclDgCgoFlg = this.spclDgCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stRlaneCd = this.n1stRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclAwkCgoFlg = this.spclAwkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thRlaneCd = this.n4thRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoWgt = this.bkgCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtTpCd = this.bkgWgtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBbCgoFlg = this.spclBbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRlaneCd = this.n3rdRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutNo2 = this.costRoutNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdTsPortCd = this.n3rdTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.mtyPkupEcc = this.mtyPkupEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		//SJH.20141016.ADD
		this.mtyRtnEcc = this.mtyRtnEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		//SJH.20141016.ADD
	}
}
