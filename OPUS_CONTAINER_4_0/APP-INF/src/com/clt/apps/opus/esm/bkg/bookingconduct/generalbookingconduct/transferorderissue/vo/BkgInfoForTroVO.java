/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgInfoForTroVO.java
*@FileTitle : BkgInfoForTroVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2010.01.25 이남경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgInfoForTroVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgInfoForTroVO> models = new ArrayList<BkgInfoForTroVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String bkgRepCmdtCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String bkgRepCmdtNm = null;
	/* Column Info */
	private String dorArrDt = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String fdGrdFlg = null;
	/* Column Info */
	private String spclHideFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String pkupDtHhmi = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String hcdg = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String rtnDtHhmi = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String pickupCy = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String rtnDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dorArrDtHhmi = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String pkupDt = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String returnCy = null;
	/* Column Info */
	private String repZnCd = null;
	/* Column Info */
	private String flexHgtFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgInfoForTroVO() {}

	public BkgInfoForTroVO(String ibflag, String pagerows, String bkgNo, String bkgCgoTpCd, String term, String custCntCd, String blNo, String bkgStsCd, String contiCd, String cmdtCd, String cmdtNm, String bkgRepCmdtCd, String bkgRepCmdtNm, String vslCd, String skdVoyNo, String skdDirCd, String porCd, String porNodCd, String polCd, String podCd, String delCd, String returnCy, String pickupCy, String dorArrDt, String dorArrDtHhmi, String rtnDt, String rtnDtHhmi, String pkupDt, String pkupDtHhmi, String dcgoFlg, String hcdg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String fdGrdFlg, String spclHideFlg, String custSeq, String custNm, String etbDt, String actWgt, String wgtUtCd, String repZnCd, String flexHgtFlg) {
		this.porCd = porCd;
		this.contiCd = contiCd;
		this.vslCd = vslCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.custNm = custNm;
		this.bkgRepCmdtCd = bkgRepCmdtCd;
		this.rdCgoFlg = rdCgoFlg;
		this.bkgRepCmdtNm = bkgRepCmdtNm;
		this.dorArrDt = dorArrDt;
		this.bkgStsCd = bkgStsCd;
		this.fdGrdFlg = fdGrdFlg;
		this.spclHideFlg = spclHideFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.pkupDtHhmi = pkupDtHhmi;
		this.cmdtCd = cmdtCd;
		this.bbCgoFlg = bbCgoFlg;
		this.wgtUtCd = wgtUtCd;
		this.dcgoFlg = dcgoFlg;
		this.etbDt = etbDt;
		this.custCntCd = custCntCd;
		this.hcdg = hcdg;
		this.porNodCd = porNodCd;
		this.awkCgoFlg = awkCgoFlg;
		this.rtnDtHhmi = rtnDtHhmi;
		this.delCd = delCd;
		this.pickupCy = pickupCy;
		this.skdVoyNo = skdVoyNo;
		this.custSeq = custSeq;
		this.cmdtNm = cmdtNm;
		this.skdDirCd = skdDirCd;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.rtnDt = rtnDt;
		this.bkgNo = bkgNo;
		this.dorArrDtHhmi = dorArrDtHhmi;
		this.term = term;
		this.pkupDt = pkupDt;
		this.rcFlg = rcFlg;
		this.returnCy = returnCy;
		this.repZnCd = repZnCd;
		this.flexHgtFlg = flexHgtFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bkg_rep_cmdt_cd", getBkgRepCmdtCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("bkg_rep_cmdt_nm", getBkgRepCmdtNm());
		this.hashColumns.put("dor_arr_dt", getDorArrDt());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("fd_grd_flg", getFdGrdFlg());
		this.hashColumns.put("spcl_hide_flg", getSpclHideFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pkup_dt_hhmi", getPkupDtHhmi());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("hcdg", getHcdg());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("rtn_dt_hhmi", getRtnDtHhmi());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pickup_cy", getPickupCy());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("rtn_dt", getRtnDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dor_arr_dt_hhmi", getDorArrDtHhmi());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("pkup_dt", getPkupDt());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("return_cy", getReturnCy());
		this.hashColumns.put("rep_zn_cd", getRepZnCd());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bkg_rep_cmdt_cd", "bkgRepCmdtCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("bkg_rep_cmdt_nm", "bkgRepCmdtNm");
		this.hashFields.put("dor_arr_dt", "dorArrDt");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("fd_grd_flg", "fdGrdFlg");
		this.hashFields.put("spcl_hide_flg", "spclHideFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pkup_dt_hhmi", "pkupDtHhmi");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("hcdg", "hcdg");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("rtn_dt_hhmi", "rtnDtHhmi");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pickup_cy", "pickupCy");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("rtn_dt", "rtnDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dor_arr_dt_hhmi", "dorArrDtHhmi");
		this.hashFields.put("term", "term");
		this.hashFields.put("pkup_dt", "pkupDt");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("return_cy", "returnCy");
		this.hashFields.put("rep_zn_cd", "repZnCd");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
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
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return bkgRepCmdtCd
	 */
	public String getBkgRepCmdtCd() {
		return this.bkgRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgRepCmdtNm
	 */
	public String getBkgRepCmdtNm() {
		return this.bkgRepCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return dorArrDt
	 */
	public String getDorArrDt() {
		return this.dorArrDt;
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
	 * @return fdGrdFlg
	 */
	public String getFdGrdFlg() {
		return this.fdGrdFlg;
	}
	
	/**
	 * Column Info
	 * @return spclHideFlg
	 */
	public String getSpclHideFlg() {
		return this.spclHideFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return pkupDtHhmi
	 */
	public String getPkupDtHhmi() {
		return this.pkupDtHhmi;
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
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return hcdg
	 */
	public String getHcdg() {
		return this.hcdg;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rtnDtHhmi
	 */
	public String getRtnDtHhmi() {
		return this.rtnDtHhmi;
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
	 * @return pickupCy
	 */
	public String getPickupCy() {
		return this.pickupCy;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return rtnDt
	 */
	public String getRtnDt() {
		return this.rtnDt;
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
	 * @return dorArrDtHhmi
	 */
	public String getDorArrDtHhmi() {
		return this.dorArrDtHhmi;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return pkupDt
	 */
	public String getPkupDt() {
		return this.pkupDt;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return returnCy
	 */
	public String getReturnCy() {
		return this.returnCy;
	}
	
	/**
	 * @return the repZnCd
	 */
	public String getRepZnCd() {
		return this.repZnCd;
	}
	
	/**
	 * @return the flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return this.flexHgtFlg;
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
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param bkgRepCmdtCd
	 */
	public void setBkgRepCmdtCd(String bkgRepCmdtCd) {
		this.bkgRepCmdtCd = bkgRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgRepCmdtNm
	 */
	public void setBkgRepCmdtNm(String bkgRepCmdtNm) {
		this.bkgRepCmdtNm = bkgRepCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param dorArrDt
	 */
	public void setDorArrDt(String dorArrDt) {
		this.dorArrDt = dorArrDt;
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
	 * @param fdGrdFlg
	 */
	public void setFdGrdFlg(String fdGrdFlg) {
		this.fdGrdFlg = fdGrdFlg;
	}

	/**
	 * Column Info
	 * @param spclHideFlg
	 */
	public void setSpclHideFlg(String spclHideFlg) {
		this.spclHideFlg = spclHideFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param pkupDtHhmi
	 */
	public void setPkupDtHhmi(String pkupDtHhmi) {
		this.pkupDtHhmi = pkupDtHhmi;
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
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param hcdg
	 */
	public void setHcdg(String hcdg) {
		this.hcdg = hcdg;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rtnDtHhmi
	 */
	public void setRtnDtHhmi(String rtnDtHhmi) {
		this.rtnDtHhmi = rtnDtHhmi;
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
	 * @param pickupCy
	 */
	public void setPickupCy(String pickupCy) {
		this.pickupCy = pickupCy;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param rtnDt
	 */
	public void setRtnDt(String rtnDt) {
		this.rtnDt = rtnDt;
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
	 * @param dorArrDtHhmi
	 */
	public void setDorArrDtHhmi(String dorArrDtHhmi) {
		this.dorArrDtHhmi = dorArrDtHhmi;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param pkupDt
	 */
	public void setPkupDt(String pkupDt) {
		this.pkupDt = pkupDt;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param returnCy
	 */
	public void setReturnCy(String returnCy) {
		this.returnCy = returnCy;
	}
	
	/**
	 * @param repZnCd the repZnCd to set
	 */
	public void setRepZnCd(String repZnCd) {
		this.repZnCd = repZnCd;
	}
	
	/**
	 * @param flexHgtFlg the flexHgtFlg to set
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBkgRepCmdtCd(JSPUtil.getParameter(request, prefix + "bkg_rep_cmdt_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setBkgRepCmdtNm(JSPUtil.getParameter(request, prefix + "bkg_rep_cmdt_nm", ""));
		setDorArrDt(JSPUtil.getParameter(request, prefix + "dor_arr_dt", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setFdGrdFlg(JSPUtil.getParameter(request, prefix + "fd_grd_flg", ""));
		setSpclHideFlg(JSPUtil.getParameter(request, prefix + "spcl_hide_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPkupDtHhmi(JSPUtil.getParameter(request, prefix + "pkup_dt_hhmi", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setEtbDt(JSPUtil.getParameter(request, prefix + "etb_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setHcdg(JSPUtil.getParameter(request, prefix + "hcdg", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setRtnDtHhmi(JSPUtil.getParameter(request, prefix + "rtn_dt_hhmi", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPickupCy(JSPUtil.getParameter(request, prefix + "pickup_cy", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setRtnDt(JSPUtil.getParameter(request, prefix + "rtn_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDorArrDtHhmi(JSPUtil.getParameter(request, prefix + "dor_arr_dt_hhmi", ""));
		setTerm(JSPUtil.getParameter(request, prefix + "term", ""));
		setPkupDt(JSPUtil.getParameter(request, prefix + "pkup_dt", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setReturnCy(JSPUtil.getParameter(request, prefix + "return_cy", ""));
		setRepZnCd(JSPUtil.getParameter(request, prefix + "rep_zn_cd", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgInfoForTroVO[]
	 */
	public BkgInfoForTroVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgInfoForTroVO[]
	 */
	public BkgInfoForTroVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgInfoForTroVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] bkgRepCmdtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rep_cmdt_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] bkgRepCmdtNm = (JSPUtil.getParameter(request, prefix	+ "bkg_rep_cmdt_nm", length));
			String[] dorArrDt = (JSPUtil.getParameter(request, prefix	+ "dor_arr_dt", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] fdGrdFlg = (JSPUtil.getParameter(request, prefix	+ "fd_grd_flg", length));
			String[] spclHideFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_hide_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] pkupDtHhmi = (JSPUtil.getParameter(request, prefix	+ "pkup_dt_hhmi", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] hcdg = (JSPUtil.getParameter(request, prefix	+ "hcdg", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] rtnDtHhmi = (JSPUtil.getParameter(request, prefix	+ "rtn_dt_hhmi", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pickupCy = (JSPUtil.getParameter(request, prefix	+ "pickup_cy", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] rtnDt = (JSPUtil.getParameter(request, prefix	+ "rtn_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dorArrDtHhmi = (JSPUtil.getParameter(request, prefix	+ "dor_arr_dt_hhmi", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] pkupDt = (JSPUtil.getParameter(request, prefix	+ "pkup_dt", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] returnCy = (JSPUtil.getParameter(request, prefix	+ "return_cy", length));
			String[] repZnCd = (JSPUtil.getParameter(request, prefix	+ "rep_zn_cd", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgInfoForTroVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (bkgRepCmdtCd[i] != null)
					model.setBkgRepCmdtCd(bkgRepCmdtCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (bkgRepCmdtNm[i] != null)
					model.setBkgRepCmdtNm(bkgRepCmdtNm[i]);
				if (dorArrDt[i] != null)
					model.setDorArrDt(dorArrDt[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (fdGrdFlg[i] != null)
					model.setFdGrdFlg(fdGrdFlg[i]);
				if (spclHideFlg[i] != null)
					model.setSpclHideFlg(spclHideFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (pkupDtHhmi[i] != null)
					model.setPkupDtHhmi(pkupDtHhmi[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (hcdg[i] != null)
					model.setHcdg(hcdg[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (rtnDtHhmi[i] != null)
					model.setRtnDtHhmi(rtnDtHhmi[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pickupCy[i] != null)
					model.setPickupCy(pickupCy[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (rtnDt[i] != null)
					model.setRtnDt(rtnDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dorArrDtHhmi[i] != null)
					model.setDorArrDtHhmi(dorArrDtHhmi[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (pkupDt[i] != null)
					model.setPkupDt(pkupDt[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (returnCy[i] != null)
					model.setReturnCy(returnCy[i]);
				if (repZnCd[i] != null)
					model.setRepZnCd(repZnCd[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgInfoForTroVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgInfoForTroVO[]
	 */
	public BkgInfoForTroVO[] getBkgInfoForTroVOs(){
		BkgInfoForTroVO[] vos = (BkgInfoForTroVO[])models.toArray(new BkgInfoForTroVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRepCmdtCd = this.bkgRepCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRepCmdtNm = this.bkgRepCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorArrDt = this.dorArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdGrdFlg = this.fdGrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclHideFlg = this.spclHideFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDtHhmi = this.pkupDtHhmi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcdg = this.hcdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDtHhmi = this.rtnDtHhmi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickupCy = this.pickupCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDt = this.rtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorArrDtHhmi = this.dorArrDtHhmi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDt = this.pkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCy = this.returnCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repZnCd = this.repZnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
