/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchSpaceAllocation0047DetailListVO.java
*@FileTitle : SearchSpaceAllocation0047DetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.05.10 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocation0047DetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocation0047DetailListVO> models = new ArrayList<SearchSpaceAllocation0047DetailListVO>();
	
	/* Column Info */
	private String ap20 = null;
	/* Column Info */
	private String bkgQuota = null;
	/* Column Info */
	private String btRf = null;
	/* Column Info */
	private String btRd = null;
	/* Column Info */
	private String apMd = null;
	/* Column Info */
	private String podCnt = null;
	/* Column Info */
	private String baseRhqCd = null;
	/* Column Info */
	private String fc20 = null;
	/* Column Info */
	private String fcTtlTeu = null;
	/* Column Info */
	private String guide = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ap53 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String usMod = null;
	/* Column Info */
	private String bkgQtaCmb = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String edit = null;
	/* Column Info */
	private String past = null;
	/* Column Info */
	private String apHc = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String leafCnt = null;
	/* Column Info */
	private String spcCtrlAlocRmk = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String fc53 = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String fcHc = null;
	/* Column Info */
	private String cmb = null;
	/* Column Info */
	private String bt20 = null;
	/* Column Info */
	private String spcCtrlAlocPodRmk = null;
	/* Column Info */
	private String fcD4 = null;
	/* Column Info */
	private String btHc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fcD2 = null;
	/* Column Info */
	private String childCnt = null;
	/* Column Info */
	private String cmOp = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String ap40 = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String spcCtrlAlocPolRmk = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cmbWgt = null;
	/* Column Info */
	private String fc45 = null;
	/* Column Info */
	private String cmb4 = null;
	/* Column Info */
	private String cmb2 = null;
	/* Column Info */
	private String cmb3 = null;
	/* Column Info */
	private String accountNm = null;
	/* Column Info */
	private String fctCmb = null;
	/* Column Info */
	private String fc40 = null;
	/* Column Info */
	private String cmb1 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ap45 = null;
	/* Column Info */
	private String bt53 = null;
	/* Column Info */
	private String fcRd = null;
	/* Column Info */
	private String bt40 = null;
	/* Column Info */
	private String polDblPortChk = null;
	/* Column Info */
	private String cmbAvg = null;
	/* Column Info */
	private String btTeu = null;
	/* Column Info */
	private String cmbWgtTrend = null;
	/* Column Info */
	private String btWgt = null;
	/* Column Info */
	private String fcTeu = null;
	/* Column Info */
	private String btD4 = null;
	/* Column Info */
	private String fcWgt = null;
	/* Column Info */
	private String apRd = null;
	/* Column Info */
	private String cmVl = null;
	/* Column Info */
	private String btD2 = null;
	/* Column Info */
	private String cmbTrend = null;
	/* Column Info */
	private String apRf = null;
	/* Column Info */
	private String cmbWgt3 = null;
	/* Column Info */
	private String cmOc = null;
	/* Column Info */
	private String apD2 = null;
	/* Column Info */
	private String cmbWgt2 = null;
	/* Column Info */
	private String cmbWgt1 = null;
	/* Column Info */
	private String apD4 = null;
	/* Column Info */
	private String accountCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bt45 = null;
	/* Column Info */
	private String bkgBsTeu = null;
	/* Column Info */
	private String bkgBsWgt = null;
	/* Column Info */
	private String apTeu = null;
	/* Column Info */
	private String fcRf = null;
	/* Column Info */
	private String apWgt = null;
	/* Column Info */
	private String cmbWgt4 = null;
	/* Column Info */
	private String bkgWgtVgm = null;
	/* Column Info */
	private String bkgVolVgm = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceAllocation0047DetailListVO() {}

	public SearchSpaceAllocation0047DetailListVO(String ibflag, String pagerows, String guide, String spcCtrlAlocPodRmk, String cmVl, String apTeu, String trdCd, String custCtrlCd, String fcRf, String fcRd, String polCd, String fcD2, String spcCtrlAlocRmk, String btTeu, String fcD4, String baseRhqCd, String fcTeu, String btD2, String cmbWgt, String podCnt, String btD4, String cmbWgtTrend, String fcTtlTeu, String rhqCd, String apWgt, String usMod, String delCd, String cmb4, String leafCnt, String cmb3, String ap45, String cmb2, String cmb1, String apHc, String bt20, String cmb, String podCd, String bkgQuota, String ap40, String cmbTrend, String fc20, String fctCmb, String apMd, String subTrdCd, String btHc, String cmbWgt4, String cmbWgt1, String ap53, String cmbWgt2, String fcWgt, String cmbWgt3, String cmOp, String fcHc, String apRf, String bt53, String apRd, String spcCtrlAlocPolRmk, String btRf, String btRd, String iocCd, String bkgQtaCmb, String cmOc, String edit, String bt40, String past, String cfmFlg, String apD4, String apD2, String ofcCd, String btWgt, String childCnt, String ap20, String bt45, String fc45, String fc40, String accountCd, String fc53, String bkgBsTeu, String bkgBsWgt, String lvl, String cmbAvg, String accountNm, String polDblPortChk,String bkgWgtVgm,String bkgVolVgm) {
		this.ap20 = ap20;
		this.bkgQuota = bkgQuota;
		this.btRf = btRf;
		this.btRd = btRd;
		this.apMd = apMd;
		this.podCnt = podCnt;
		this.baseRhqCd = baseRhqCd;
		this.fc20 = fc20;
		this.fcTtlTeu = fcTtlTeu;
		this.guide = guide;
		this.pagerows = pagerows;
		this.ap53 = ap53;
		this.ofcCd = ofcCd;
		this.usMod = usMod;
		this.bkgQtaCmb = bkgQtaCmb;
		this.lvl = lvl;
		this.edit = edit;
		this.past = past;
		this.apHc = apHc;
		this.cfmFlg = cfmFlg;
		this.leafCnt = leafCnt;
		this.spcCtrlAlocRmk = spcCtrlAlocRmk;
		this.trdCd = trdCd;
		this.fc53 = fc53;
		this.subTrdCd = subTrdCd;
		this.fcHc = fcHc;
		this.cmb = cmb;
		this.bt20 = bt20;
		this.spcCtrlAlocPodRmk = spcCtrlAlocPodRmk;
		this.fcD4 = fcD4;
		this.btHc = btHc;
		this.ibflag = ibflag;
		this.fcD2 = fcD2;
		this.childCnt = childCnt;
		this.cmOp = cmOp;
		this.iocCd = iocCd;
		this.ap40 = ap40;
		this.custCtrlCd = custCtrlCd;
		this.rhqCd = rhqCd;
		this.spcCtrlAlocPolRmk = spcCtrlAlocPolRmk;
		this.polCd = polCd;
		this.cmbWgt = cmbWgt;
		this.fc45 = fc45;
		this.cmb4 = cmb4;
		this.cmb2 = cmb2;
		this.cmb3 = cmb3;
		this.accountNm = accountNm;
		this.fctCmb = fctCmb;
		this.fc40 = fc40;
		this.cmb1 = cmb1;
		this.podCd = podCd;
		this.ap45 = ap45;
		this.bt53 = bt53;
		this.fcRd = fcRd;
		this.bt40 = bt40;
		this.polDblPortChk = polDblPortChk;
		this.cmbAvg = cmbAvg;
		this.btTeu = btTeu;
		this.cmbWgtTrend = cmbWgtTrend;
		this.btWgt = btWgt;
		this.fcTeu = fcTeu;
		this.btD4 = btD4;
		this.fcWgt = fcWgt;
		this.apRd = apRd;
		this.cmVl = cmVl;
		this.btD2 = btD2;
		this.cmbTrend = cmbTrend;
		this.apRf = apRf;
		this.cmbWgt3 = cmbWgt3;
		this.cmOc = cmOc;
		this.apD2 = apD2;
		this.cmbWgt2 = cmbWgt2;
		this.cmbWgt1 = cmbWgt1;
		this.apD4 = apD4;
		this.accountCd = accountCd;
		this.delCd = delCd;
		this.bt45 = bt45;
		this.bkgBsTeu = bkgBsTeu;
		this.bkgBsWgt = bkgBsWgt;
		this.apTeu = apTeu;
		this.fcRf = fcRf;
		this.apWgt = apWgt;
		this.cmbWgt4 = cmbWgt4;
		this.bkgWgtVgm = bkgWgtVgm;
		this.bkgVolVgm = bkgVolVgm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_20", getAp20());
		this.hashColumns.put("bkg_quota", getBkgQuota());
		this.hashColumns.put("bt_rf", getBtRf());
		this.hashColumns.put("bt_rd", getBtRd());
		this.hashColumns.put("ap_md", getApMd());
		this.hashColumns.put("pod_cnt", getPodCnt());
		this.hashColumns.put("base_rhq_cd", getBaseRhqCd());
		this.hashColumns.put("fc_20", getFc20());
		this.hashColumns.put("fc_ttl_teu", getFcTtlTeu());
		this.hashColumns.put("guide", getGuide());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ap_53", getAp53());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("us_mod", getUsMod());
		this.hashColumns.put("bkg_qta_cmb", getBkgQtaCmb());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("edit", getEdit());
		this.hashColumns.put("past", getPast());
		this.hashColumns.put("ap_hc", getApHc());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("leaf_cnt", getLeafCnt());
		this.hashColumns.put("spc_ctrl_aloc_rmk", getSpcCtrlAlocRmk());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("fc_53", getFc53());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("fc_hc", getFcHc());
		this.hashColumns.put("cmb", getCmb());
		this.hashColumns.put("bt_20", getBt20());
		this.hashColumns.put("spc_ctrl_aloc_pod_rmk", getSpcCtrlAlocPodRmk());
		this.hashColumns.put("fc_d4", getFcD4());
		this.hashColumns.put("bt_hc", getBtHc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fc_d2", getFcD2());
		this.hashColumns.put("child_cnt", getChildCnt());
		this.hashColumns.put("cm_op", getCmOp());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("ap_40", getAp40());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("spc_ctrl_aloc_pol_rmk", getSpcCtrlAlocPolRmk());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cmb_wgt", getCmbWgt());
		this.hashColumns.put("fc_45", getFc45());
		this.hashColumns.put("cmb4", getCmb4());
		this.hashColumns.put("cmb2", getCmb2());
		this.hashColumns.put("cmb3", getCmb3());
		this.hashColumns.put("account_nm", getAccountNm());
		this.hashColumns.put("fct_cmb", getFctCmb());
		this.hashColumns.put("fc_40", getFc40());
		this.hashColumns.put("cmb1", getCmb1());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ap_45", getAp45());
		this.hashColumns.put("bt_53", getBt53());
		this.hashColumns.put("fc_rd", getFcRd());
		this.hashColumns.put("bt_40", getBt40());
		this.hashColumns.put("pol_dbl_port_chk", getPolDblPortChk());
		this.hashColumns.put("cmb_avg", getCmbAvg());
		this.hashColumns.put("bt_teu", getBtTeu());
		this.hashColumns.put("cmb_wgt_trend", getCmbWgtTrend());
		this.hashColumns.put("bt_wgt", getBtWgt());
		this.hashColumns.put("fc_teu", getFcTeu());
		this.hashColumns.put("bt_d4", getBtD4());
		this.hashColumns.put("fc_wgt", getFcWgt());
		this.hashColumns.put("ap_rd", getApRd());
		this.hashColumns.put("cm_vl", getCmVl());
		this.hashColumns.put("bt_d2", getBtD2());
		this.hashColumns.put("cmb_trend", getCmbTrend());
		this.hashColumns.put("ap_rf", getApRf());
		this.hashColumns.put("cmb_wgt3", getCmbWgt3());
		this.hashColumns.put("cm_oc", getCmOc());
		this.hashColumns.put("ap_d2", getApD2());
		this.hashColumns.put("cmb_wgt2", getCmbWgt2());
		this.hashColumns.put("cmb_wgt1", getCmbWgt1());
		this.hashColumns.put("ap_d4", getApD4());
		this.hashColumns.put("account_cd", getAccountCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bt_45", getBt45());
		this.hashColumns.put("bkg_bs_teu", getBkgBsTeu());
		this.hashColumns.put("bkg_bs_wgt", getBkgBsWgt());
		this.hashColumns.put("ap_teu", getApTeu());
		this.hashColumns.put("fc_rf", getFcRf());
		this.hashColumns.put("ap_wgt", getApWgt());
		this.hashColumns.put("cmb_wgt4", getCmbWgt4());
		this.hashColumns.put("bkg_wgt_vgm", getBkgWgtVgm());
		this.hashColumns.put("bkg_vol_vgm", getBkgVolVgm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ap_20", "ap20");
		this.hashFields.put("bkg_quota", "bkgQuota");
		this.hashFields.put("bt_rf", "btRf");
		this.hashFields.put("bt_rd", "btRd");
		this.hashFields.put("ap_md", "apMd");
		this.hashFields.put("pod_cnt", "podCnt");
		this.hashFields.put("base_rhq_cd", "baseRhqCd");
		this.hashFields.put("fc_20", "fc20");
		this.hashFields.put("fc_ttl_teu", "fcTtlTeu");
		this.hashFields.put("guide", "guide");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ap_53", "ap53");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("us_mod", "usMod");
		this.hashFields.put("bkg_qta_cmb", "bkgQtaCmb");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("edit", "edit");
		this.hashFields.put("past", "past");
		this.hashFields.put("ap_hc", "apHc");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("leaf_cnt", "leafCnt");
		this.hashFields.put("spc_ctrl_aloc_rmk", "spcCtrlAlocRmk");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("fc_53", "fc53");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("fc_hc", "fcHc");
		this.hashFields.put("cmb", "cmb");
		this.hashFields.put("bt_20", "bt20");
		this.hashFields.put("spc_ctrl_aloc_pod_rmk", "spcCtrlAlocPodRmk");
		this.hashFields.put("fc_d4", "fcD4");
		this.hashFields.put("bt_hc", "btHc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fc_d2", "fcD2");
		this.hashFields.put("child_cnt", "childCnt");
		this.hashFields.put("cm_op", "cmOp");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("ap_40", "ap40");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("spc_ctrl_aloc_pol_rmk", "spcCtrlAlocPolRmk");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cmb_wgt", "cmbWgt");
		this.hashFields.put("fc_45", "fc45");
		this.hashFields.put("cmb4", "cmb4");
		this.hashFields.put("cmb2", "cmb2");
		this.hashFields.put("cmb3", "cmb3");
		this.hashFields.put("account_nm", "accountNm");
		this.hashFields.put("fct_cmb", "fctCmb");
		this.hashFields.put("fc_40", "fc40");
		this.hashFields.put("cmb1", "cmb1");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ap_45", "ap45");
		this.hashFields.put("bt_53", "bt53");
		this.hashFields.put("fc_rd", "fcRd");
		this.hashFields.put("bt_40", "bt40");
		this.hashFields.put("pol_dbl_port_chk", "polDblPortChk");
		this.hashFields.put("cmb_avg", "cmbAvg");
		this.hashFields.put("bt_teu", "btTeu");
		this.hashFields.put("cmb_wgt_trend", "cmbWgtTrend");
		this.hashFields.put("bt_wgt", "btWgt");
		this.hashFields.put("fc_teu", "fcTeu");
		this.hashFields.put("bt_d4", "btD4");
		this.hashFields.put("fc_wgt", "fcWgt");
		this.hashFields.put("ap_rd", "apRd");
		this.hashFields.put("cm_vl", "cmVl");
		this.hashFields.put("bt_d2", "btD2");
		this.hashFields.put("cmb_trend", "cmbTrend");
		this.hashFields.put("ap_rf", "apRf");
		this.hashFields.put("cmb_wgt3", "cmbWgt3");
		this.hashFields.put("cm_oc", "cmOc");
		this.hashFields.put("ap_d2", "apD2");
		this.hashFields.put("cmb_wgt2", "cmbWgt2");
		this.hashFields.put("cmb_wgt1", "cmbWgt1");
		this.hashFields.put("ap_d4", "apD4");
		this.hashFields.put("account_cd", "accountCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bt_45", "bt45");
		this.hashFields.put("bkg_bs_teu", "bkgBsTeu");
		this.hashFields.put("bkg_bs_wgt", "bkgBsWgt");
		this.hashFields.put("ap_teu", "apTeu");
		this.hashFields.put("fc_rf", "fcRf");
		this.hashFields.put("ap_wgt", "apWgt");
		this.hashFields.put("cmb_wgt4", "cmbWgt4");
		this.hashFields.put("bkg_wgt_vgm", "bkgWgtVgm");
		this.hashFields.put("bkg_vol_vgm", "bkgVolVgm");
		return this.hashFields;
	}
	/**
	 * Column Info			
	 * @return bkgVolVgm			
	 */		
	public String getBkgVolVgm() {
		return bkgVolVgm;
	}
	/**			
	 * Column Info			
	 * @param bkgVolVgm			
	 */		
	public void setBkgVolVgm(String bkgVolVgm) {
		this.bkgVolVgm = bkgVolVgm;
	}
	/**			
	 * Column Info			
	 * @return bkgWgtVgm			
	 */			
	public String getBkgWgtVgm() {			
		return this.bkgWgtVgm;		
	}			
	/**			
	 * Column Info			
	 * @param bkgWgtVgm			
	 */			
	public void setBkgWgtVgm(String bkgWgtVgm) {			
		this.bkgWgtVgm = bkgWgtVgm;		
	}			
	/**
	 * Column Info
	 * @return ap20
	 */
	public String getAp20() {
		return this.ap20;
	}
	
	/**
	 * Column Info
	 * @return bkgQuota
	 */
	public String getBkgQuota() {
		return this.bkgQuota;
	}
	
	/**
	 * Column Info
	 * @return btRf
	 */
	public String getBtRf() {
		return this.btRf;
	}
	
	/**
	 * Column Info
	 * @return btRd
	 */
	public String getBtRd() {
		return this.btRd;
	}
	
	/**
	 * Column Info
	 * @return apMd
	 */
	public String getApMd() {
		return this.apMd;
	}
	
	/**
	 * Column Info
	 * @return podCnt
	 */
	public String getPodCnt() {
		return this.podCnt;
	}
	
	/**
	 * Column Info
	 * @return baseRhqCd
	 */
	public String getBaseRhqCd() {
		return this.baseRhqCd;
	}
	
	/**
	 * Column Info
	 * @return fc20
	 */
	public String getFc20() {
		return this.fc20;
	}
	
	/**
	 * Column Info
	 * @return fcTtlTeu
	 */
	public String getFcTtlTeu() {
		return this.fcTtlTeu;
	}
	
	/**
	 * Column Info
	 * @return guide
	 */
	public String getGuide() {
		return this.guide;
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
	 * @return ap53
	 */
	public String getAp53() {
		return this.ap53;
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
	 * @return usMod
	 */
	public String getUsMod() {
		return this.usMod;
	}
	
	/**
	 * Column Info
	 * @return bkgQtaCmb
	 */
	public String getBkgQtaCmb() {
		return this.bkgQtaCmb;
	}
	
	/**
	 * Column Info
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return edit
	 */
	public String getEdit() {
		return this.edit;
	}
	
	/**
	 * Column Info
	 * @return past
	 */
	public String getPast() {
		return this.past;
	}
	
	/**
	 * Column Info
	 * @return apHc
	 */
	public String getApHc() {
		return this.apHc;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return leafCnt
	 */
	public String getLeafCnt() {
		return this.leafCnt;
	}
	
	/**
	 * Column Info
	 * @return spcCtrlAlocRmk
	 */
	public String getSpcCtrlAlocRmk() {
		return this.spcCtrlAlocRmk;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return fc53
	 */
	public String getFc53() {
		return this.fc53;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fcHc
	 */
	public String getFcHc() {
		return this.fcHc;
	}
	
	/**
	 * Column Info
	 * @return cmb
	 */
	public String getCmb() {
		return this.cmb;
	}
	
	/**
	 * Column Info
	 * @return bt20
	 */
	public String getBt20() {
		return this.bt20;
	}
	
	/**
	 * Column Info
	 * @return spcCtrlAlocPodRmk
	 */
	public String getSpcCtrlAlocPodRmk() {
		return this.spcCtrlAlocPodRmk;
	}
	
	/**
	 * Column Info
	 * @return fcD4
	 */
	public String getFcD4() {
		return this.fcD4;
	}
	
	/**
	 * Column Info
	 * @return btHc
	 */
	public String getBtHc() {
		return this.btHc;
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
	 * @return fcD2
	 */
	public String getFcD2() {
		return this.fcD2;
	}
	
	/**
	 * Column Info
	 * @return childCnt
	 */
	public String getChildCnt() {
		return this.childCnt;
	}
	
	/**
	 * Column Info
	 * @return cmOp
	 */
	public String getCmOp() {
		return this.cmOp;
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
	 * @return ap40
	 */
	public String getAp40() {
		return this.ap40;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return spcCtrlAlocPolRmk
	 */
	public String getSpcCtrlAlocPolRmk() {
		return this.spcCtrlAlocPolRmk;
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
	 * @return cmbWgt
	 */
	public String getCmbWgt() {
		return this.cmbWgt;
	}
	
	/**
	 * Column Info
	 * @return fc45
	 */
	public String getFc45() {
		return this.fc45;
	}
	
	/**
	 * Column Info
	 * @return cmb4
	 */
	public String getCmb4() {
		return this.cmb4;
	}
	
	/**
	 * Column Info
	 * @return cmb2
	 */
	public String getCmb2() {
		return this.cmb2;
	}
	
	/**
	 * Column Info
	 * @return cmb3
	 */
	public String getCmb3() {
		return this.cmb3;
	}
	
	/**
	 * Column Info
	 * @return accountNm
	 */
	public String getAccountNm() {
		return this.accountNm;
	}
	
	/**
	 * Column Info
	 * @return fctCmb
	 */
	public String getFctCmb() {
		return this.fctCmb;
	}
	
	/**
	 * Column Info
	 * @return fc40
	 */
	public String getFc40() {
		return this.fc40;
	}
	
	/**
	 * Column Info
	 * @return cmb1
	 */
	public String getCmb1() {
		return this.cmb1;
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
	 * @return ap45
	 */
	public String getAp45() {
		return this.ap45;
	}
	
	/**
	 * Column Info
	 * @return bt53
	 */
	public String getBt53() {
		return this.bt53;
	}
	
	/**
	 * Column Info
	 * @return fcRd
	 */
	public String getFcRd() {
		return this.fcRd;
	}
	
	/**
	 * Column Info
	 * @return bt40
	 */
	public String getBt40() {
		return this.bt40;
	}
	
	/**
	 * Column Info
	 * @return polDblPortChk
	 */
	public String getPolDblPortChk() {
		return this.polDblPortChk;
	}
	
	/**
	 * Column Info
	 * @return cmbAvg
	 */
	public String getCmbAvg() {
		return this.cmbAvg;
	}
	
	/**
	 * Column Info
	 * @return btTeu
	 */
	public String getBtTeu() {
		return this.btTeu;
	}
	
	/**
	 * Column Info
	 * @return cmbWgtTrend
	 */
	public String getCmbWgtTrend() {
		return this.cmbWgtTrend;
	}
	
	/**
	 * Column Info
	 * @return btWgt
	 */
	public String getBtWgt() {
		return this.btWgt;
	}
	
	/**
	 * Column Info
	 * @return fcTeu
	 */
	public String getFcTeu() {
		return this.fcTeu;
	}
	
	/**
	 * Column Info
	 * @return btD4
	 */
	public String getBtD4() {
		return this.btD4;
	}
	
	/**
	 * Column Info
	 * @return fcWgt
	 */
	public String getFcWgt() {
		return this.fcWgt;
	}
	
	/**
	 * Column Info
	 * @return apRd
	 */
	public String getApRd() {
		return this.apRd;
	}
	
	/**
	 * Column Info
	 * @return cmVl
	 */
	public String getCmVl() {
		return this.cmVl;
	}
	
	/**
	 * Column Info
	 * @return btD2
	 */
	public String getBtD2() {
		return this.btD2;
	}
	
	/**
	 * Column Info
	 * @return cmbTrend
	 */
	public String getCmbTrend() {
		return this.cmbTrend;
	}
	
	/**
	 * Column Info
	 * @return apRf
	 */
	public String getApRf() {
		return this.apRf;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt3
	 */
	public String getCmbWgt3() {
		return this.cmbWgt3;
	}
	
	/**
	 * Column Info
	 * @return cmOc
	 */
	public String getCmOc() {
		return this.cmOc;
	}
	
	/**
	 * Column Info
	 * @return apD2
	 */
	public String getApD2() {
		return this.apD2;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt2
	 */
	public String getCmbWgt2() {
		return this.cmbWgt2;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt1
	 */
	public String getCmbWgt1() {
		return this.cmbWgt1;
	}
	
	/**
	 * Column Info
	 * @return apD4
	 */
	public String getApD4() {
		return this.apD4;
	}
	
	/**
	 * Column Info
	 * @return accountCd
	 */
	public String getAccountCd() {
		return this.accountCd;
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
	 * @return bt45
	 */
	public String getBt45() {
		return this.bt45;
	}
	
	/**
	 * Column Info
	 * @return bkgBsTeu
	 */
	public String getBkgBsTeu() {
		return this.bkgBsTeu;
	}
	
	/**
	 * Column Info
	 * @return bkgBsWgt
	 */
	public String getBkgBsWgt() {
		return this.bkgBsWgt;
	}
	
	/**
	 * Column Info
	 * @return apTeu
	 */
	public String getApTeu() {
		return this.apTeu;
	}
	
	/**
	 * Column Info
	 * @return fcRf
	 */
	public String getFcRf() {
		return this.fcRf;
	}
	
	/**
	 * Column Info
	 * @return apWgt
	 */
	public String getApWgt() {
		return this.apWgt;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt4
	 */
	public String getCmbWgt4() {
		return this.cmbWgt4;
	}
	

	/**
	 * Column Info
	 * @param ap20
	 */
	public void setAp20(String ap20) {
		this.ap20 = ap20;
	}
	
	/**
	 * Column Info
	 * @param bkgQuota
	 */
	public void setBkgQuota(String bkgQuota) {
		this.bkgQuota = bkgQuota;
	}
	
	/**
	 * Column Info
	 * @param btRf
	 */
	public void setBtRf(String btRf) {
		this.btRf = btRf;
	}
	
	/**
	 * Column Info
	 * @param btRd
	 */
	public void setBtRd(String btRd) {
		this.btRd = btRd;
	}
	
	/**
	 * Column Info
	 * @param apMd
	 */
	public void setApMd(String apMd) {
		this.apMd = apMd;
	}
	
	/**
	 * Column Info
	 * @param podCnt
	 */
	public void setPodCnt(String podCnt) {
		this.podCnt = podCnt;
	}
	
	/**
	 * Column Info
	 * @param baseRhqCd
	 */
	public void setBaseRhqCd(String baseRhqCd) {
		this.baseRhqCd = baseRhqCd;
	}
	
	/**
	 * Column Info
	 * @param fc20
	 */
	public void setFc20(String fc20) {
		this.fc20 = fc20;
	}
	
	/**
	 * Column Info
	 * @param fcTtlTeu
	 */
	public void setFcTtlTeu(String fcTtlTeu) {
		this.fcTtlTeu = fcTtlTeu;
	}
	
	/**
	 * Column Info
	 * @param guide
	 */
	public void setGuide(String guide) {
		this.guide = guide;
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
	 * @param ap53
	 */
	public void setAp53(String ap53) {
		this.ap53 = ap53;
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
	 * @param usMod
	 */
	public void setUsMod(String usMod) {
		this.usMod = usMod;
	}
	
	/**
	 * Column Info
	 * @param bkgQtaCmb
	 */
	public void setBkgQtaCmb(String bkgQtaCmb) {
		this.bkgQtaCmb = bkgQtaCmb;
	}
	
	/**
	 * Column Info
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param edit
	 */
	public void setEdit(String edit) {
		this.edit = edit;
	}
	
	/**
	 * Column Info
	 * @param past
	 */
	public void setPast(String past) {
		this.past = past;
	}
	
	/**
	 * Column Info
	 * @param apHc
	 */
	public void setApHc(String apHc) {
		this.apHc = apHc;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param leafCnt
	 */
	public void setLeafCnt(String leafCnt) {
		this.leafCnt = leafCnt;
	}
	
	/**
	 * Column Info
	 * @param spcCtrlAlocRmk
	 */
	public void setSpcCtrlAlocRmk(String spcCtrlAlocRmk) {
		this.spcCtrlAlocRmk = spcCtrlAlocRmk;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param fc53
	 */
	public void setFc53(String fc53) {
		this.fc53 = fc53;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fcHc
	 */
	public void setFcHc(String fcHc) {
		this.fcHc = fcHc;
	}
	
	/**
	 * Column Info
	 * @param cmb
	 */
	public void setCmb(String cmb) {
		this.cmb = cmb;
	}
	
	/**
	 * Column Info
	 * @param bt20
	 */
	public void setBt20(String bt20) {
		this.bt20 = bt20;
	}
	
	/**
	 * Column Info
	 * @param spcCtrlAlocPodRmk
	 */
	public void setSpcCtrlAlocPodRmk(String spcCtrlAlocPodRmk) {
		this.spcCtrlAlocPodRmk = spcCtrlAlocPodRmk;
	}
	
	/**
	 * Column Info
	 * @param fcD4
	 */
	public void setFcD4(String fcD4) {
		this.fcD4 = fcD4;
	}
	
	/**
	 * Column Info
	 * @param btHc
	 */
	public void setBtHc(String btHc) {
		this.btHc = btHc;
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
	 * @param fcD2
	 */
	public void setFcD2(String fcD2) {
		this.fcD2 = fcD2;
	}
	
	/**
	 * Column Info
	 * @param childCnt
	 */
	public void setChildCnt(String childCnt) {
		this.childCnt = childCnt;
	}
	
	/**
	 * Column Info
	 * @param cmOp
	 */
	public void setCmOp(String cmOp) {
		this.cmOp = cmOp;
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
	 * @param ap40
	 */
	public void setAp40(String ap40) {
		this.ap40 = ap40;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param spcCtrlAlocPolRmk
	 */
	public void setSpcCtrlAlocPolRmk(String spcCtrlAlocPolRmk) {
		this.spcCtrlAlocPolRmk = spcCtrlAlocPolRmk;
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
	 * @param cmbWgt
	 */
	public void setCmbWgt(String cmbWgt) {
		this.cmbWgt = cmbWgt;
	}
	
	/**
	 * Column Info
	 * @param fc45
	 */
	public void setFc45(String fc45) {
		this.fc45 = fc45;
	}
	
	/**
	 * Column Info
	 * @param cmb4
	 */
	public void setCmb4(String cmb4) {
		this.cmb4 = cmb4;
	}
	
	/**
	 * Column Info
	 * @param cmb2
	 */
	public void setCmb2(String cmb2) {
		this.cmb2 = cmb2;
	}
	
	/**
	 * Column Info
	 * @param cmb3
	 */
	public void setCmb3(String cmb3) {
		this.cmb3 = cmb3;
	}
	
	/**
	 * Column Info
	 * @param accountNm
	 */
	public void setAccountNm(String accountNm) {
		this.accountNm = accountNm;
	}
	
	/**
	 * Column Info
	 * @param fctCmb
	 */
	public void setFctCmb(String fctCmb) {
		this.fctCmb = fctCmb;
	}
	
	/**
	 * Column Info
	 * @param fc40
	 */
	public void setFc40(String fc40) {
		this.fc40 = fc40;
	}
	
	/**
	 * Column Info
	 * @param cmb1
	 */
	public void setCmb1(String cmb1) {
		this.cmb1 = cmb1;
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
	 * @param ap45
	 */
	public void setAp45(String ap45) {
		this.ap45 = ap45;
	}
	
	/**
	 * Column Info
	 * @param bt53
	 */
	public void setBt53(String bt53) {
		this.bt53 = bt53;
	}
	
	/**
	 * Column Info
	 * @param fcRd
	 */
	public void setFcRd(String fcRd) {
		this.fcRd = fcRd;
	}
	
	/**
	 * Column Info
	 * @param bt40
	 */
	public void setBt40(String bt40) {
		this.bt40 = bt40;
	}
	
	/**
	 * Column Info
	 * @param polDblPortChk
	 */
	public void setPolDblPortChk(String polDblPortChk) {
		this.polDblPortChk = polDblPortChk;
	}
	
	/**
	 * Column Info
	 * @param cmbAvg
	 */
	public void setCmbAvg(String cmbAvg) {
		this.cmbAvg = cmbAvg;
	}
	
	/**
	 * Column Info
	 * @param btTeu
	 */
	public void setBtTeu(String btTeu) {
		this.btTeu = btTeu;
	}
	
	/**
	 * Column Info
	 * @param cmbWgtTrend
	 */
	public void setCmbWgtTrend(String cmbWgtTrend) {
		this.cmbWgtTrend = cmbWgtTrend;
	}
	
	/**
	 * Column Info
	 * @param btWgt
	 */
	public void setBtWgt(String btWgt) {
		this.btWgt = btWgt;
	}
	
	/**
	 * Column Info
	 * @param fcTeu
	 */
	public void setFcTeu(String fcTeu) {
		this.fcTeu = fcTeu;
	}
	
	/**
	 * Column Info
	 * @param btD4
	 */
	public void setBtD4(String btD4) {
		this.btD4 = btD4;
	}
	
	/**
	 * Column Info
	 * @param fcWgt
	 */
	public void setFcWgt(String fcWgt) {
		this.fcWgt = fcWgt;
	}
	
	/**
	 * Column Info
	 * @param apRd
	 */
	public void setApRd(String apRd) {
		this.apRd = apRd;
	}
	
	/**
	 * Column Info
	 * @param cmVl
	 */
	public void setCmVl(String cmVl) {
		this.cmVl = cmVl;
	}
	
	/**
	 * Column Info
	 * @param btD2
	 */
	public void setBtD2(String btD2) {
		this.btD2 = btD2;
	}
	
	/**
	 * Column Info
	 * @param cmbTrend
	 */
	public void setCmbTrend(String cmbTrend) {
		this.cmbTrend = cmbTrend;
	}
	
	/**
	 * Column Info
	 * @param apRf
	 */
	public void setApRf(String apRf) {
		this.apRf = apRf;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt3
	 */
	public void setCmbWgt3(String cmbWgt3) {
		this.cmbWgt3 = cmbWgt3;
	}
	
	/**
	 * Column Info
	 * @param cmOc
	 */
	public void setCmOc(String cmOc) {
		this.cmOc = cmOc;
	}
	
	/**
	 * Column Info
	 * @param apD2
	 */
	public void setApD2(String apD2) {
		this.apD2 = apD2;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt2
	 */
	public void setCmbWgt2(String cmbWgt2) {
		this.cmbWgt2 = cmbWgt2;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt1
	 */
	public void setCmbWgt1(String cmbWgt1) {
		this.cmbWgt1 = cmbWgt1;
	}
	
	/**
	 * Column Info
	 * @param apD4
	 */
	public void setApD4(String apD4) {
		this.apD4 = apD4;
	}
	
	/**
	 * Column Info
	 * @param accountCd
	 */
	public void setAccountCd(String accountCd) {
		this.accountCd = accountCd;
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
	 * @param bt45
	 */
	public void setBt45(String bt45) {
		this.bt45 = bt45;
	}
	
	/**
	 * Column Info
	 * @param bkgBsTeu
	 */
	public void setBkgBsTeu(String bkgBsTeu) {
		this.bkgBsTeu = bkgBsTeu;
	}
	
	/**
	 * Column Info
	 * @param bkgBsWgt
	 */
	public void setBkgBsWgt(String bkgBsWgt) {
		this.bkgBsWgt = bkgBsWgt;
	}
	
	/**
	 * Column Info
	 * @param apTeu
	 */
	public void setApTeu(String apTeu) {
		this.apTeu = apTeu;
	}
	
	/**
	 * Column Info
	 * @param fcRf
	 */
	public void setFcRf(String fcRf) {
		this.fcRf = fcRf;
	}
	
	/**
	 * Column Info
	 * @param apWgt
	 */
	public void setApWgt(String apWgt) {
		this.apWgt = apWgt;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt4
	 */
	public void setCmbWgt4(String cmbWgt4) {
		this.cmbWgt4 = cmbWgt4;
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
		setAp20(JSPUtil.getParameter(request, prefix + "ap_20", ""));
		setBkgQuota(JSPUtil.getParameter(request, prefix + "bkg_quota", ""));
		setBtRf(JSPUtil.getParameter(request, prefix + "bt_rf", ""));
		setBtRd(JSPUtil.getParameter(request, prefix + "bt_rd", ""));
		setApMd(JSPUtil.getParameter(request, prefix + "ap_md", ""));
		setPodCnt(JSPUtil.getParameter(request, prefix + "pod_cnt", ""));
		setBaseRhqCd(JSPUtil.getParameter(request, prefix + "base_rhq_cd", ""));
		setFc20(JSPUtil.getParameter(request, prefix + "fc_20", ""));
		setFcTtlTeu(JSPUtil.getParameter(request, prefix + "fc_ttl_teu", ""));
		setGuide(JSPUtil.getParameter(request, prefix + "guide", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAp53(JSPUtil.getParameter(request, prefix + "ap_53", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setUsMod(JSPUtil.getParameter(request, prefix + "us_mod", ""));
		setBkgQtaCmb(JSPUtil.getParameter(request, prefix + "bkg_qta_cmb", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setEdit(JSPUtil.getParameter(request, prefix + "edit", ""));
		setPast(JSPUtil.getParameter(request, prefix + "past", ""));
		setApHc(JSPUtil.getParameter(request, prefix + "ap_hc", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setLeafCnt(JSPUtil.getParameter(request, prefix + "leaf_cnt", ""));
		setSpcCtrlAlocRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_rmk", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setFc53(JSPUtil.getParameter(request, prefix + "fc_53", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setFcHc(JSPUtil.getParameter(request, prefix + "fc_hc", ""));
		setCmb(JSPUtil.getParameter(request, prefix + "cmb", ""));
		setBt20(JSPUtil.getParameter(request, prefix + "bt_20", ""));
		setSpcCtrlAlocPodRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_pod_rmk", ""));
		setFcD4(JSPUtil.getParameter(request, prefix + "fc_d4", ""));
		setBtHc(JSPUtil.getParameter(request, prefix + "bt_hc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcD2(JSPUtil.getParameter(request, prefix + "fc_d2", ""));
		setChildCnt(JSPUtil.getParameter(request, prefix + "child_cnt", ""));
		setCmOp(JSPUtil.getParameter(request, prefix + "cm_op", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setAp40(JSPUtil.getParameter(request, prefix + "ap_40", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setSpcCtrlAlocPolRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_pol_rmk", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCmbWgt(JSPUtil.getParameter(request, prefix + "cmb_wgt", ""));
		setFc45(JSPUtil.getParameter(request, prefix + "fc_45", ""));
		setCmb4(JSPUtil.getParameter(request, prefix + "cmb4", ""));
		setCmb2(JSPUtil.getParameter(request, prefix + "cmb2", ""));
		setCmb3(JSPUtil.getParameter(request, prefix + "cmb3", ""));
		setAccountNm(JSPUtil.getParameter(request, prefix + "account_nm", ""));
		setFctCmb(JSPUtil.getParameter(request, prefix + "fct_cmb", ""));
		setFc40(JSPUtil.getParameter(request, prefix + "fc_40", ""));
		setCmb1(JSPUtil.getParameter(request, prefix + "cmb1", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setAp45(JSPUtil.getParameter(request, prefix + "ap_45", ""));
		setBt53(JSPUtil.getParameter(request, prefix + "bt_53", ""));
		setFcRd(JSPUtil.getParameter(request, prefix + "fc_rd", ""));
		setBt40(JSPUtil.getParameter(request, prefix + "bt_40", ""));
		setPolDblPortChk(JSPUtil.getParameter(request, prefix + "pol_dbl_port_chk", ""));
		setCmbAvg(JSPUtil.getParameter(request, prefix + "cmb_avg", ""));
		setBtTeu(JSPUtil.getParameter(request, prefix + "bt_teu", ""));
		setCmbWgtTrend(JSPUtil.getParameter(request, prefix + "cmb_wgt_trend", ""));
		setBtWgt(JSPUtil.getParameter(request, prefix + "bt_wgt", ""));
		setFcTeu(JSPUtil.getParameter(request, prefix + "fc_teu", ""));
		setBtD4(JSPUtil.getParameter(request, prefix + "bt_d4", ""));
		setFcWgt(JSPUtil.getParameter(request, prefix + "fc_wgt", ""));
		setApRd(JSPUtil.getParameter(request, prefix + "ap_rd", ""));
		setCmVl(JSPUtil.getParameter(request, prefix + "cm_vl", ""));
		setBtD2(JSPUtil.getParameter(request, prefix + "bt_d2", ""));
		setCmbTrend(JSPUtil.getParameter(request, prefix + "cmb_trend", ""));
		setApRf(JSPUtil.getParameter(request, prefix + "ap_rf", ""));
		setCmbWgt3(JSPUtil.getParameter(request, prefix + "cmb_wgt3", ""));
		setCmOc(JSPUtil.getParameter(request, prefix + "cm_oc", ""));
		setApD2(JSPUtil.getParameter(request, prefix + "ap_d2", ""));
		setCmbWgt2(JSPUtil.getParameter(request, prefix + "cmb_wgt2", ""));
		setCmbWgt1(JSPUtil.getParameter(request, prefix + "cmb_wgt1", ""));
		setApD4(JSPUtil.getParameter(request, prefix + "ap_d4", ""));
		setAccountCd(JSPUtil.getParameter(request, prefix + "account_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBt45(JSPUtil.getParameter(request, prefix + "bt_45", ""));
		setBkgBsTeu(JSPUtil.getParameter(request, prefix + "bkg_bs_teu", ""));
		setBkgBsWgt(JSPUtil.getParameter(request, prefix + "bkg_bs_wgt", ""));
		setApTeu(JSPUtil.getParameter(request, prefix + "ap_teu", ""));
		setFcRf(JSPUtil.getParameter(request, prefix + "fc_rf", ""));
		setApWgt(JSPUtil.getParameter(request, prefix + "ap_wgt", ""));
		setCmbWgt4(JSPUtil.getParameter(request, prefix + "cmb_wgt4", ""));
		setBkgWgtVgm(JSPUtil.getParameter(request, prefix + "bkg_wgt_vgm", ""));
		setBkgVolVgm(JSPUtil.getParameter(request, prefix + "bkg_vol_vgm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocation0047DetailListVO[]
	 */
	public SearchSpaceAllocation0047DetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocation0047DetailListVO[]
	 */
	public SearchSpaceAllocation0047DetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocation0047DetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ap20 = (JSPUtil.getParameter(request, prefix	+ "ap_20", length));
			String[] bkgQuota = (JSPUtil.getParameter(request, prefix	+ "bkg_quota", length));
			String[] btRf = (JSPUtil.getParameter(request, prefix	+ "bt_rf", length));
			String[] btRd = (JSPUtil.getParameter(request, prefix	+ "bt_rd", length));
			String[] apMd = (JSPUtil.getParameter(request, prefix	+ "ap_md", length));
			String[] podCnt = (JSPUtil.getParameter(request, prefix	+ "pod_cnt", length));
			String[] baseRhqCd = (JSPUtil.getParameter(request, prefix	+ "base_rhq_cd", length));
			String[] fc20 = (JSPUtil.getParameter(request, prefix	+ "fc_20", length));
			String[] fcTtlTeu = (JSPUtil.getParameter(request, prefix	+ "fc_ttl_teu", length));
			String[] guide = (JSPUtil.getParameter(request, prefix	+ "guide", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ap53 = (JSPUtil.getParameter(request, prefix	+ "ap_53", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] usMod = (JSPUtil.getParameter(request, prefix	+ "us_mod", length));
			String[] bkgQtaCmb = (JSPUtil.getParameter(request, prefix	+ "bkg_qta_cmb", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] edit = (JSPUtil.getParameter(request, prefix	+ "edit", length));
			String[] past = (JSPUtil.getParameter(request, prefix	+ "past", length));
			String[] apHc = (JSPUtil.getParameter(request, prefix	+ "ap_hc", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] leafCnt = (JSPUtil.getParameter(request, prefix	+ "leaf_cnt", length));
			String[] spcCtrlAlocRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_rmk", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] fc53 = (JSPUtil.getParameter(request, prefix	+ "fc_53", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] fcHc = (JSPUtil.getParameter(request, prefix	+ "fc_hc", length));
			String[] cmb = (JSPUtil.getParameter(request, prefix	+ "cmb", length));
			String[] bt20 = (JSPUtil.getParameter(request, prefix	+ "bt_20", length));
			String[] spcCtrlAlocPodRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_pod_rmk", length));
			String[] fcD4 = (JSPUtil.getParameter(request, prefix	+ "fc_d4", length));
			String[] btHc = (JSPUtil.getParameter(request, prefix	+ "bt_hc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcD2 = (JSPUtil.getParameter(request, prefix	+ "fc_d2", length));
			String[] childCnt = (JSPUtil.getParameter(request, prefix	+ "child_cnt", length));
			String[] cmOp = (JSPUtil.getParameter(request, prefix	+ "cm_op", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] ap40 = (JSPUtil.getParameter(request, prefix	+ "ap_40", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] spcCtrlAlocPolRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_pol_rmk", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cmbWgt = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt", length));
			String[] fc45 = (JSPUtil.getParameter(request, prefix	+ "fc_45", length));
			String[] cmb4 = (JSPUtil.getParameter(request, prefix	+ "cmb4", length));
			String[] cmb2 = (JSPUtil.getParameter(request, prefix	+ "cmb2", length));
			String[] cmb3 = (JSPUtil.getParameter(request, prefix	+ "cmb3", length));
			String[] accountNm = (JSPUtil.getParameter(request, prefix	+ "account_nm", length));
			String[] fctCmb = (JSPUtil.getParameter(request, prefix	+ "fct_cmb", length));
			String[] fc40 = (JSPUtil.getParameter(request, prefix	+ "fc_40", length));
			String[] cmb1 = (JSPUtil.getParameter(request, prefix	+ "cmb1", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ap45 = (JSPUtil.getParameter(request, prefix	+ "ap_45", length));
			String[] bt53 = (JSPUtil.getParameter(request, prefix	+ "bt_53", length));
			String[] fcRd = (JSPUtil.getParameter(request, prefix	+ "fc_rd", length));
			String[] bt40 = (JSPUtil.getParameter(request, prefix	+ "bt_40", length));
			String[] polDblPortChk = (JSPUtil.getParameter(request, prefix	+ "pol_dbl_port_chk", length));
			String[] cmbAvg = (JSPUtil.getParameter(request, prefix	+ "cmb_avg", length));
			String[] btTeu = (JSPUtil.getParameter(request, prefix	+ "bt_teu", length));
			String[] cmbWgtTrend = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt_trend", length));
			String[] btWgt = (JSPUtil.getParameter(request, prefix	+ "bt_wgt", length));
			String[] fcTeu = (JSPUtil.getParameter(request, prefix	+ "fc_teu", length));
			String[] btD4 = (JSPUtil.getParameter(request, prefix	+ "bt_d4", length));
			String[] fcWgt = (JSPUtil.getParameter(request, prefix	+ "fc_wgt", length));
			String[] apRd = (JSPUtil.getParameter(request, prefix	+ "ap_rd", length));
			String[] cmVl = (JSPUtil.getParameter(request, prefix	+ "cm_vl", length));
			String[] btD2 = (JSPUtil.getParameter(request, prefix	+ "bt_d2", length));
			String[] cmbTrend = (JSPUtil.getParameter(request, prefix	+ "cmb_trend", length));
			String[] apRf = (JSPUtil.getParameter(request, prefix	+ "ap_rf", length));
			String[] cmbWgt3 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt3", length));
			String[] cmOc = (JSPUtil.getParameter(request, prefix	+ "cm_oc", length));
			String[] apD2 = (JSPUtil.getParameter(request, prefix	+ "ap_d2", length));
			String[] cmbWgt2 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt2", length));
			String[] cmbWgt1 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt1", length));
			String[] apD4 = (JSPUtil.getParameter(request, prefix	+ "ap_d4", length));
			String[] accountCd = (JSPUtil.getParameter(request, prefix	+ "account_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bt45 = (JSPUtil.getParameter(request, prefix	+ "bt_45", length));
			String[] bkgBsTeu = (JSPUtil.getParameter(request, prefix	+ "bkg_bs_teu", length));
			String[] bkgBsWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_bs_wgt", length));
			String[] apTeu = (JSPUtil.getParameter(request, prefix	+ "ap_teu", length));
			String[] fcRf = (JSPUtil.getParameter(request, prefix	+ "fc_rf", length));
			String[] apWgt = (JSPUtil.getParameter(request, prefix	+ "ap_wgt", length));
			String[] cmbWgt4 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt4", length));
			String[] bkgWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_vgm", length));
			String[] bkgVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_vol_vgm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocation0047DetailListVO();
				if (ap20[i] != null)
					model.setAp20(ap20[i]);
				if (bkgQuota[i] != null)
					model.setBkgQuota(bkgQuota[i]);
				if (btRf[i] != null)
					model.setBtRf(btRf[i]);
				if (btRd[i] != null)
					model.setBtRd(btRd[i]);
				if (apMd[i] != null)
					model.setApMd(apMd[i]);
				if (podCnt[i] != null)
					model.setPodCnt(podCnt[i]);
				if (baseRhqCd[i] != null)
					model.setBaseRhqCd(baseRhqCd[i]);
				if (fc20[i] != null)
					model.setFc20(fc20[i]);
				if (fcTtlTeu[i] != null)
					model.setFcTtlTeu(fcTtlTeu[i]);
				if (guide[i] != null)
					model.setGuide(guide[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ap53[i] != null)
					model.setAp53(ap53[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (usMod[i] != null)
					model.setUsMod(usMod[i]);
				if (bkgQtaCmb[i] != null)
					model.setBkgQtaCmb(bkgQtaCmb[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (edit[i] != null)
					model.setEdit(edit[i]);
				if (past[i] != null)
					model.setPast(past[i]);
				if (apHc[i] != null)
					model.setApHc(apHc[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (leafCnt[i] != null)
					model.setLeafCnt(leafCnt[i]);
				if (spcCtrlAlocRmk[i] != null)
					model.setSpcCtrlAlocRmk(spcCtrlAlocRmk[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (fc53[i] != null)
					model.setFc53(fc53[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (fcHc[i] != null)
					model.setFcHc(fcHc[i]);
				if (cmb[i] != null)
					model.setCmb(cmb[i]);
				if (bt20[i] != null)
					model.setBt20(bt20[i]);
				if (spcCtrlAlocPodRmk[i] != null)
					model.setSpcCtrlAlocPodRmk(spcCtrlAlocPodRmk[i]);
				if (fcD4[i] != null)
					model.setFcD4(fcD4[i]);
				if (btHc[i] != null)
					model.setBtHc(btHc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fcD2[i] != null)
					model.setFcD2(fcD2[i]);
				if (childCnt[i] != null)
					model.setChildCnt(childCnt[i]);
				if (cmOp[i] != null)
					model.setCmOp(cmOp[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (ap40[i] != null)
					model.setAp40(ap40[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (spcCtrlAlocPolRmk[i] != null)
					model.setSpcCtrlAlocPolRmk(spcCtrlAlocPolRmk[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cmbWgt[i] != null)
					model.setCmbWgt(cmbWgt[i]);
				if (fc45[i] != null)
					model.setFc45(fc45[i]);
				if (cmb4[i] != null)
					model.setCmb4(cmb4[i]);
				if (cmb2[i] != null)
					model.setCmb2(cmb2[i]);
				if (cmb3[i] != null)
					model.setCmb3(cmb3[i]);
				if (accountNm[i] != null)
					model.setAccountNm(accountNm[i]);
				if (fctCmb[i] != null)
					model.setFctCmb(fctCmb[i]);
				if (fc40[i] != null)
					model.setFc40(fc40[i]);
				if (cmb1[i] != null)
					model.setCmb1(cmb1[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ap45[i] != null)
					model.setAp45(ap45[i]);
				if (bt53[i] != null)
					model.setBt53(bt53[i]);
				if (fcRd[i] != null)
					model.setFcRd(fcRd[i]);
				if (bt40[i] != null)
					model.setBt40(bt40[i]);
				if (polDblPortChk[i] != null)
					model.setPolDblPortChk(polDblPortChk[i]);
				if (cmbAvg[i] != null)
					model.setCmbAvg(cmbAvg[i]);
				if (btTeu[i] != null)
					model.setBtTeu(btTeu[i]);
				if (cmbWgtTrend[i] != null)
					model.setCmbWgtTrend(cmbWgtTrend[i]);
				if (btWgt[i] != null)
					model.setBtWgt(btWgt[i]);
				if (fcTeu[i] != null)
					model.setFcTeu(fcTeu[i]);
				if (btD4[i] != null)
					model.setBtD4(btD4[i]);
				if (fcWgt[i] != null)
					model.setFcWgt(fcWgt[i]);
				if (apRd[i] != null)
					model.setApRd(apRd[i]);
				if (cmVl[i] != null)
					model.setCmVl(cmVl[i]);
				if (btD2[i] != null)
					model.setBtD2(btD2[i]);
				if (cmbTrend[i] != null)
					model.setCmbTrend(cmbTrend[i]);
				if (apRf[i] != null)
					model.setApRf(apRf[i]);
				if (cmbWgt3[i] != null)
					model.setCmbWgt3(cmbWgt3[i]);
				if (cmOc[i] != null)
					model.setCmOc(cmOc[i]);
				if (apD2[i] != null)
					model.setApD2(apD2[i]);
				if (cmbWgt2[i] != null)
					model.setCmbWgt2(cmbWgt2[i]);
				if (cmbWgt1[i] != null)
					model.setCmbWgt1(cmbWgt1[i]);
				if (apD4[i] != null)
					model.setApD4(apD4[i]);
				if (accountCd[i] != null)
					model.setAccountCd(accountCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bt45[i] != null)
					model.setBt45(bt45[i]);
				if (bkgBsTeu[i] != null)
					model.setBkgBsTeu(bkgBsTeu[i]);
				if (bkgBsWgt[i] != null)
					model.setBkgBsWgt(bkgBsWgt[i]);
				if (apTeu[i] != null)
					model.setApTeu(apTeu[i]);
				if (fcRf[i] != null)
					model.setFcRf(fcRf[i]);
				if (apWgt[i] != null)
					model.setApWgt(apWgt[i]);
				if (cmbWgt4[i] != null)
					model.setCmbWgt4(cmbWgt4[i]);
				if (bkgWgtVgm[i] != null) model.setBkgWgtVgm(bkgWgtVgm[i]);
				if (bkgVolVgm[i] != null) model.setBkgVolVgm(bkgVolVgm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocation0047DetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocation0047DetailListVO[]
	 */
	public SearchSpaceAllocation0047DetailListVO[] getSearchSpaceAllocation0047DetailListVOs(){
		SearchSpaceAllocation0047DetailListVO[] vos = (SearchSpaceAllocation0047DetailListVO[])models.toArray(new SearchSpaceAllocation0047DetailListVO[models.size()]);
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
		this.ap20 = this.ap20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQuota = this.bkgQuota .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btRf = this.btRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btRd = this.btRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apMd = this.apMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCnt = this.podCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.baseRhqCd = this.baseRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc20 = this.fc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTtlTeu = this.fcTtlTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.guide = this.guide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap53 = this.ap53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usMod = this.usMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQtaCmb = this.bkgQtaCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edit = this.edit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.past = this.past .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apHc = this.apHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leafCnt = this.leafCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocRmk = this.spcCtrlAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc53 = this.fc53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcHc = this.fcHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb = this.cmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt20 = this.bt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocPodRmk = this.spcCtrlAlocPodRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcD4 = this.fcD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btHc = this.btHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcD2 = this.fcD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.childCnt = this.childCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOp = this.cmOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap40 = this.ap40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocPolRmk = this.spcCtrlAlocPolRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt = this.cmbWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc45 = this.fc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb4 = this.cmb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb2 = this.cmb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb3 = this.cmb3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountNm = this.accountNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctCmb = this.fctCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc40 = this.fc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb1 = this.cmb1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap45 = this.ap45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt53 = this.bt53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcRd = this.fcRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt40 = this.bt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDblPortChk = this.polDblPortChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbAvg = this.cmbAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btTeu = this.btTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgtTrend = this.cmbWgtTrend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btWgt = this.btWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTeu = this.fcTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btD4 = this.btD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcWgt = this.fcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRd = this.apRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl = this.cmVl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btD2 = this.btD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbTrend = this.cmbTrend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRf = this.apRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt3 = this.cmbWgt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc = this.cmOc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apD2 = this.apD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt2 = this.cmbWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt1 = this.cmbWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apD4 = this.apD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountCd = this.accountCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt45 = this.bt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBsTeu = this.bkgBsTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBsWgt = this.bkgBsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apTeu = this.apTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcRf = this.fcRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apWgt = this.apWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt4 = this.cmbWgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtVgm = this.bkgWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
