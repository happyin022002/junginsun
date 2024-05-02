/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchSpaceAllocation0042DetailListVO.java
*@FileTitle : SearchSpaceAllocation0042DetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.05.02 최성민 
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

public class SearchSpaceAllocation0042DetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocation0042DetailListVO> models = new ArrayList<SearchSpaceAllocation0042DetailListVO>();
	
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String bkgQuota = null;
	/* Column Info */
	private String btRf = null;
	/* Column Info */
	private String repSubTrdCd = null;
	/* Column Info */
	private String bsWgt = null;
	/* Column Info */
	private String mrTeu = null;
	/* Column Info */
	private String bkHc = null;
	/* Column Info */
	private String btRd = null;
	/* Column Info */
	private String apMd = null;
	/* Column Info */
	private String bkWgt = null;
	/* Column Info */
	private String ugWgt = null;
	/* Column Info */
	private String gtTeu = null;
	/* Column Info */
	private String fcTtlTeu = null;
	/* Column Info */
	private String ugHc = null;
	/* Column Info */
	private String gt45 = null;
	/* Column Info */
	private String guide = null;
	/* Column Info */
	private String ap53 = null;
	/* Column Info */
	private String bkgQtaCmb = null;
	/* Column Info */
	private String usMod = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String edit = null;
	/* Column Info */
	private String past = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String leafCnt = null;
	/* Column Info */
	private String spcCtrlAlocRmk = null;
	/* Column Info */
	private String mr53 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String gtRf = null;
	/* Column Info */
	private String fc53 = null;
	/* Column Info */
	private String areaCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String cmb = null;
	/* Column Info */
	private String bt20 = null;
	/* Column Info */
	private String childCnt = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String ugRf = null;
	/* Column Info */
	private String cmbWgt = null;
	/* Column Info */
	private String polSkip = null;
	/* Column Info */
	private String bt53 = null;
	/* Column Info */
	private String bt40 = null;
	/* Column Info */
	private String cmbAvg = null;
	/* Column Info */
	private String cmbWgtTrend = null;
	/* Column Info */
	private String bk20 = null;
	/* Column Info */
	private String btWgt = null;
	/* Column Info */
	private String fcWgt = null;
	/* Column Info */
	private String btD4 = null;
	/* Column Info */
	private String btD2 = null;
	/* Column Info */
	private String cmbTrend = null;
	/* Column Info */
	private String bkRf = null;
	/* Column Info */
	private String accountCd = null;
	/* Column Info */
	private String polDblPortChk = null;
	/* Column Info */
	private String gt53 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bt45 = null;
	/* Column Info */
	private String apWgt = null;
	/* Column Info */
	private String ug53 = null;
	/* Column Info */
	private String bk53 = null;
	/* Column Info */
	private String bsTeu = null;
	/* Column Info */
	private String mrRf = null;
	/* Column Info */
	private String mrWgt = null;
	/* Column Info */
	private String bkTeu = null;
	/* Column Info */
	private String podCnt = null;
	/* Column Info */
	private String ugTeu = null;
	/* Column Info */
	private String baseRhqCd = null;
	/* Column Info */
	private String gtWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bk45 = null;
	/* Column Info */
	private String ug45 = null;
	/* Column Info */
	private String apHc = null;
	/* Column Info */
	private String podSkip = null;
	/* Column Info */
	private String bk40 = null;
	/* Column Info */
	private String mrHc = null;
	/* Column Info */
	private String podSeq = null;
	/* Column Info */
	private String fcHc = null;
	/* Column Info */
	private String polSeq = null;
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
	private String cmOp = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String spcCtrlAlocPolRmk = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fc45 = null;
	/* Column Info */
	private String cmb4 = null;
	/* Column Info */
	private String cmb2 = null;
	/* Column Info */
	private String cmb3 = null;
	/* Column Info */
	private String mr45 = null;
	/* Column Info */
	private String accountNm = null;
	/* Column Info */
	private String cmb1 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ap45 = null;
	/* Column Info */
	private String fcRd = null;
	/* Column Info */
	private String btTeu = null;
	/* Column Info */
	private String fcTeu = null;
	/* Column Info */
	private String apRd = null;
	/* Column Info */
	private String cmVl = null;
	/* Column Info */
	private String apRf = null;
	/* Column Info */
	private String cmOc = null;
	/* Column Info */
	private String cmbWgt3 = null;
	/* Column Info */
	private String apD2 = null;
	/* Column Info */
	private String cmbWgt2 = null;
	/* Column Info */
	private String cmbWgt1 = null;
	/* Column Info */
	private String apD4 = null;
	/* Column Info */
	private String gtHc = null;
	/* Column Info */
	private String apTeu = null;
	/* Column Info */
	private String fcRf = null;
	/* Column Info */
	private String cmbWgt4 = null;
	/* Column Info */
	private String bkgWgtVgm;
	/* Column Info */
	private String bkgVolVgm = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceAllocation0042DetailListVO() {}

	public SearchSpaceAllocation0042DetailListVO(String ibflag, String pagerows, String mrTeu, String gtHc, String apTeu, String cmVl, String bkWgt, String repTrdCd, String fcRf, String fcRd, String ug53, String fcD2, String ugTeu, String spcCtrlAlocRmk, String fcD4, String mrRf, String cmbWgt, String mrHc, String fcTtlTeu, String cmbWgtTrend, String polSkip, String gtRf, String rhqCd, String apWgt, String cmb4, String cmb3, String cmb2, String cmb1, String cmb, String podCd, String bt20, String lvl, String ug45, String bkgQuota, String apMd, String btHc, String bk45, String bkRf, String ap53, String fcWgt, String mrWgt, String bk40, String fcHc, String cmOp, String bt53, String ugWgt, String gtWgt, String bkgQtaCmb, String cmOc, String bkTeu, String bt40, String bk53, String mr45, String ofcCd, String childCnt, String gtTeu, String bt45, String ugRf, String bk20, String spcCtrlAlocPodRmk, String mr53, String trdCd, String polCd, String btTeu, String baseRhqCd, String fcTeu, String btD2, String podCnt, String btD4, String usMod, String delCd, String gt53, String leafCnt, String ap45, String podSeq, String apHc, String ugHc, String cmbTrend, String areaCd, String subTrdCd, String cmbWgt4, String polSeq, String podSkip, String gt45, String cmbWgt1, String cmbWgt2, String cmbWgt3, String bkHc, String apRf, String apRd, String spcCtrlAlocPolRmk, String btRf, String iocCd, String edit, String past, String apD4, String cfmFlg, String apD2, String btWgt, String fc45, String repSubTrdCd, String fc53, String accountCd, String custCtrlCd, String cmbAvg, String guide, String btRd, String bsTeu, String bsWgt, String accountNm, String polDblPortChk,String bkgWgtVgm,String bkgVolVgm) {
		this.repTrdCd = repTrdCd;
		this.bkgQuota = bkgQuota;
		this.btRf = btRf;
		this.repSubTrdCd = repSubTrdCd;
		this.bsWgt = bsWgt;
		this.mrTeu = mrTeu;
		this.bkHc = bkHc;
		this.btRd = btRd;
		this.apMd = apMd;
		this.bkWgt = bkWgt;
		this.ugWgt = ugWgt;
		this.gtTeu = gtTeu;
		this.fcTtlTeu = fcTtlTeu;
		this.ugHc = ugHc;
		this.gt45 = gt45;
		this.guide = guide;
		this.ap53 = ap53;
		this.bkgQtaCmb = bkgQtaCmb;
		this.usMod = usMod;
		this.lvl = lvl;
		this.edit = edit;
		this.past = past;
		this.cfmFlg = cfmFlg;
		this.leafCnt = leafCnt;
		this.spcCtrlAlocRmk = spcCtrlAlocRmk;
		this.mr53 = mr53;
		this.trdCd = trdCd;
		this.gtRf = gtRf;
		this.fc53 = fc53;
		this.areaCd = areaCd;
		this.subTrdCd = subTrdCd;
		this.cmb = cmb;
		this.bt20 = bt20;
		this.childCnt = childCnt;
		this.custCtrlCd = custCtrlCd;
		this.ugRf = ugRf;
		this.cmbWgt = cmbWgt;
		this.polSkip = polSkip;
		this.bt53 = bt53;
		this.bt40 = bt40;
		this.cmbAvg = cmbAvg;
		this.cmbWgtTrend = cmbWgtTrend;
		this.bk20 = bk20;
		this.btWgt = btWgt;
		this.fcWgt = fcWgt;
		this.btD4 = btD4;
		this.btD2 = btD2;
		this.cmbTrend = cmbTrend;
		this.bkRf = bkRf;
		this.accountCd = accountCd;
		this.polDblPortChk = polDblPortChk;
		this.gt53 = gt53;
		this.delCd = delCd;
		this.bt45 = bt45;
		this.apWgt = apWgt;
		this.ug53 = ug53;
		this.bk53 = bk53;
		this.bsTeu = bsTeu;
		this.mrRf = mrRf;
		this.mrWgt = mrWgt;
		this.bkTeu = bkTeu;
		this.podCnt = podCnt;
		this.ugTeu = ugTeu;
		this.baseRhqCd = baseRhqCd;
		this.gtWgt = gtWgt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.bk45 = bk45;
		this.ug45 = ug45;
		this.apHc = apHc;
		this.podSkip = podSkip;
		this.bk40 = bk40;
		this.mrHc = mrHc;
		this.podSeq = podSeq;
		this.fcHc = fcHc;
		this.polSeq = polSeq;
		this.spcCtrlAlocPodRmk = spcCtrlAlocPodRmk;
		this.fcD4 = fcD4;
		this.btHc = btHc;
		this.ibflag = ibflag;
		this.fcD2 = fcD2;
		this.cmOp = cmOp;
		this.iocCd = iocCd;
		this.rhqCd = rhqCd;
		this.spcCtrlAlocPolRmk = spcCtrlAlocPolRmk;
		this.polCd = polCd;
		this.fc45 = fc45;
		this.cmb4 = cmb4;
		this.cmb2 = cmb2;
		this.cmb3 = cmb3;
		this.mr45 = mr45;
		this.accountNm = accountNm;
		this.cmb1 = cmb1;
		this.podCd = podCd;
		this.ap45 = ap45;
		this.fcRd = fcRd;
		this.btTeu = btTeu;
		this.fcTeu = fcTeu;
		this.apRd = apRd;
		this.cmVl = cmVl;
		this.apRf = apRf;
		this.cmOc = cmOc;
		this.cmbWgt3 = cmbWgt3;
		this.apD2 = apD2;
		this.cmbWgt2 = cmbWgt2;
		this.cmbWgt1 = cmbWgt1;
		this.apD4 = apD4;
		this.gtHc = gtHc;
		this.apTeu = apTeu;
		this.fcRf = fcRf;
		this.cmbWgt4 = cmbWgt4;
		this.bkgWgtVgm = bkgWgtVgm;
		this.bkgVolVgm = bkgVolVgm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("bkg_quota", getBkgQuota());
		this.hashColumns.put("bt_rf", getBtRf());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		this.hashColumns.put("bs_wgt", getBsWgt());
		this.hashColumns.put("mr_teu", getMrTeu());
		this.hashColumns.put("bk_hc", getBkHc());
		this.hashColumns.put("bt_rd", getBtRd());
		this.hashColumns.put("ap_md", getApMd());
		this.hashColumns.put("bk_wgt", getBkWgt());
		this.hashColumns.put("ug_wgt", getUgWgt());
		this.hashColumns.put("gt_teu", getGtTeu());
		this.hashColumns.put("fc_ttl_teu", getFcTtlTeu());
		this.hashColumns.put("ug_hc", getUgHc());
		this.hashColumns.put("gt_45", getGt45());
		this.hashColumns.put("guide", getGuide());
		this.hashColumns.put("ap_53", getAp53());
		this.hashColumns.put("bkg_qta_cmb", getBkgQtaCmb());
		this.hashColumns.put("us_mod", getUsMod());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("edit", getEdit());
		this.hashColumns.put("past", getPast());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("leaf_cnt", getLeafCnt());
		this.hashColumns.put("spc_ctrl_aloc_rmk", getSpcCtrlAlocRmk());
		this.hashColumns.put("mr_53", getMr53());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("gt_rf", getGtRf());
		this.hashColumns.put("fc_53", getFc53());
		this.hashColumns.put("area_cd", getAreaCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cmb", getCmb());
		this.hashColumns.put("bt_20", getBt20());
		this.hashColumns.put("child_cnt", getChildCnt());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("ug_rf", getUgRf());
		this.hashColumns.put("cmb_wgt", getCmbWgt());
		this.hashColumns.put("pol_skip", getPolSkip());
		this.hashColumns.put("bt_53", getBt53());
		this.hashColumns.put("bt_40", getBt40());
		this.hashColumns.put("cmb_avg", getCmbAvg());
		this.hashColumns.put("cmb_wgt_trend", getCmbWgtTrend());
		this.hashColumns.put("bk_20", getBk20());
		this.hashColumns.put("bt_wgt", getBtWgt());
		this.hashColumns.put("fc_wgt", getFcWgt());
		this.hashColumns.put("bt_d4", getBtD4());
		this.hashColumns.put("bt_d2", getBtD2());
		this.hashColumns.put("cmb_trend", getCmbTrend());
		this.hashColumns.put("bk_rf", getBkRf());
		this.hashColumns.put("account_cd", getAccountCd());
		this.hashColumns.put("pol_dbl_port_chk", getPolDblPortChk());
		this.hashColumns.put("gt_53", getGt53());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bt_45", getBt45());
		this.hashColumns.put("ap_wgt", getApWgt());
		this.hashColumns.put("ug_53", getUg53());
		this.hashColumns.put("bk_53", getBk53());
		this.hashColumns.put("bs_teu", getBsTeu());
		this.hashColumns.put("mr_rf", getMrRf());
		this.hashColumns.put("mr_wgt", getMrWgt());
		this.hashColumns.put("bk_teu", getBkTeu());
		this.hashColumns.put("pod_cnt", getPodCnt());
		this.hashColumns.put("ug_teu", getUgTeu());
		this.hashColumns.put("base_rhq_cd", getBaseRhqCd());
		this.hashColumns.put("gt_wgt", getGtWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bk_45", getBk45());
		this.hashColumns.put("ug_45", getUg45());
		this.hashColumns.put("ap_hc", getApHc());
		this.hashColumns.put("pod_skip", getPodSkip());
		this.hashColumns.put("bk_40", getBk40());
		this.hashColumns.put("mr_hc", getMrHc());
		this.hashColumns.put("pod_seq", getPodSeq());
		this.hashColumns.put("fc_hc", getFcHc());
		this.hashColumns.put("pol_seq", getPolSeq());
		this.hashColumns.put("spc_ctrl_aloc_pod_rmk", getSpcCtrlAlocPodRmk());
		this.hashColumns.put("fc_d4", getFcD4());
		this.hashColumns.put("bt_hc", getBtHc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fc_d2", getFcD2());
		this.hashColumns.put("cm_op", getCmOp());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("spc_ctrl_aloc_pol_rmk", getSpcCtrlAlocPolRmk());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("fc_45", getFc45());
		this.hashColumns.put("cmb4", getCmb4());
		this.hashColumns.put("cmb2", getCmb2());
		this.hashColumns.put("cmb3", getCmb3());
		this.hashColumns.put("mr_45", getMr45());
		this.hashColumns.put("account_nm", getAccountNm());
		this.hashColumns.put("cmb1", getCmb1());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ap_45", getAp45());
		this.hashColumns.put("fc_rd", getFcRd());
		this.hashColumns.put("bt_teu", getBtTeu());
		this.hashColumns.put("fc_teu", getFcTeu());
		this.hashColumns.put("ap_rd", getApRd());
		this.hashColumns.put("cm_vl", getCmVl());
		this.hashColumns.put("ap_rf", getApRf());
		this.hashColumns.put("cm_oc", getCmOc());
		this.hashColumns.put("cmb_wgt3", getCmbWgt3());
		this.hashColumns.put("ap_d2", getApD2());
		this.hashColumns.put("cmb_wgt2", getCmbWgt2());
		this.hashColumns.put("cmb_wgt1", getCmbWgt1());
		this.hashColumns.put("ap_d4", getApD4());
		this.hashColumns.put("gt_hc", getGtHc());
		this.hashColumns.put("ap_teu", getApTeu());
		this.hashColumns.put("fc_rf", getFcRf());
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
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("bkg_quota", "bkgQuota");
		this.hashFields.put("bt_rf", "btRf");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		this.hashFields.put("bs_wgt", "bsWgt");
		this.hashFields.put("mr_teu", "mrTeu");
		this.hashFields.put("bk_hc", "bkHc");
		this.hashFields.put("bt_rd", "btRd");
		this.hashFields.put("ap_md", "apMd");
		this.hashFields.put("bk_wgt", "bkWgt");
		this.hashFields.put("ug_wgt", "ugWgt");
		this.hashFields.put("gt_teu", "gtTeu");
		this.hashFields.put("fc_ttl_teu", "fcTtlTeu");
		this.hashFields.put("ug_hc", "ugHc");
		this.hashFields.put("gt_45", "gt45");
		this.hashFields.put("guide", "guide");
		this.hashFields.put("ap_53", "ap53");
		this.hashFields.put("bkg_qta_cmb", "bkgQtaCmb");
		this.hashFields.put("us_mod", "usMod");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("edit", "edit");
		this.hashFields.put("past", "past");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("leaf_cnt", "leafCnt");
		this.hashFields.put("spc_ctrl_aloc_rmk", "spcCtrlAlocRmk");
		this.hashFields.put("mr_53", "mr53");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("gt_rf", "gtRf");
		this.hashFields.put("fc_53", "fc53");
		this.hashFields.put("area_cd", "areaCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cmb", "cmb");
		this.hashFields.put("bt_20", "bt20");
		this.hashFields.put("child_cnt", "childCnt");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("ug_rf", "ugRf");
		this.hashFields.put("cmb_wgt", "cmbWgt");
		this.hashFields.put("pol_skip", "polSkip");
		this.hashFields.put("bt_53", "bt53");
		this.hashFields.put("bt_40", "bt40");
		this.hashFields.put("cmb_avg", "cmbAvg");
		this.hashFields.put("cmb_wgt_trend", "cmbWgtTrend");
		this.hashFields.put("bk_20", "bk20");
		this.hashFields.put("bt_wgt", "btWgt");
		this.hashFields.put("fc_wgt", "fcWgt");
		this.hashFields.put("bt_d4", "btD4");
		this.hashFields.put("bt_d2", "btD2");
		this.hashFields.put("cmb_trend", "cmbTrend");
		this.hashFields.put("bk_rf", "bkRf");
		this.hashFields.put("account_cd", "accountCd");
		this.hashFields.put("pol_dbl_port_chk", "polDblPortChk");
		this.hashFields.put("gt_53", "gt53");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bt_45", "bt45");
		this.hashFields.put("ap_wgt", "apWgt");
		this.hashFields.put("ug_53", "ug53");
		this.hashFields.put("bk_53", "bk53");
		this.hashFields.put("bs_teu", "bsTeu");
		this.hashFields.put("mr_rf", "mrRf");
		this.hashFields.put("mr_wgt", "mrWgt");
		this.hashFields.put("bk_teu", "bkTeu");
		this.hashFields.put("pod_cnt", "podCnt");
		this.hashFields.put("ug_teu", "ugTeu");
		this.hashFields.put("base_rhq_cd", "baseRhqCd");
		this.hashFields.put("gt_wgt", "gtWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bk_45", "bk45");
		this.hashFields.put("ug_45", "ug45");
		this.hashFields.put("ap_hc", "apHc");
		this.hashFields.put("pod_skip", "podSkip");
		this.hashFields.put("bk_40", "bk40");
		this.hashFields.put("mr_hc", "mrHc");
		this.hashFields.put("pod_seq", "podSeq");
		this.hashFields.put("fc_hc", "fcHc");
		this.hashFields.put("pol_seq", "polSeq");
		this.hashFields.put("spc_ctrl_aloc_pod_rmk", "spcCtrlAlocPodRmk");
		this.hashFields.put("fc_d4", "fcD4");
		this.hashFields.put("bt_hc", "btHc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fc_d2", "fcD2");
		this.hashFields.put("cm_op", "cmOp");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("spc_ctrl_aloc_pol_rmk", "spcCtrlAlocPolRmk");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("fc_45", "fc45");
		this.hashFields.put("cmb4", "cmb4");
		this.hashFields.put("cmb2", "cmb2");
		this.hashFields.put("cmb3", "cmb3");
		this.hashFields.put("mr_45", "mr45");
		this.hashFields.put("account_nm", "accountNm");
		this.hashFields.put("cmb1", "cmb1");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ap_45", "ap45");
		this.hashFields.put("fc_rd", "fcRd");
		this.hashFields.put("bt_teu", "btTeu");
		this.hashFields.put("fc_teu", "fcTeu");
		this.hashFields.put("ap_rd", "apRd");
		this.hashFields.put("cm_vl", "cmVl");
		this.hashFields.put("ap_rf", "apRf");
		this.hashFields.put("cm_oc", "cmOc");
		this.hashFields.put("cmb_wgt3", "cmbWgt3");
		this.hashFields.put("ap_d2", "apD2");
		this.hashFields.put("cmb_wgt2", "cmbWgt2");
		this.hashFields.put("cmb_wgt1", "cmbWgt1");
		this.hashFields.put("ap_d4", "apD4");
		this.hashFields.put("gt_hc", "gtHc");
		this.hashFields.put("ap_teu", "apTeu");
		this.hashFields.put("fc_rf", "fcRf");
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
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
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
	 * @return repSubTrdCd
	 */
	public String getRepSubTrdCd() {
		return this.repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bsWgt
	 */
	public String getBsWgt() {
		return this.bsWgt;
	}
	
	/**
	 * Column Info
	 * @return mrTeu
	 */
	public String getMrTeu() {
		return this.mrTeu;
	}
	
	/**
	 * Column Info
	 * @return bkHc
	 */
	public String getBkHc() {
		return this.bkHc;
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
	 * @return bkWgt
	 */
	public String getBkWgt() {
		return this.bkWgt;
	}
	
	/**
	 * Column Info
	 * @return ugWgt
	 */
	public String getUgWgt() {
		return this.ugWgt;
	}
	
	/**
	 * Column Info
	 * @return gtTeu
	 */
	public String getGtTeu() {
		return this.gtTeu;
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
	 * @return ugHc
	 */
	public String getUgHc() {
		return this.ugHc;
	}
	
	/**
	 * Column Info
	 * @return gt45
	 */
	public String getGt45() {
		return this.gt45;
	}
	
	/**
	 * Column Info
	 * @return guide
	 */
	public String getGuide() {
		return this.guide;
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
	 * @return bkgQtaCmb
	 */
	public String getBkgQtaCmb() {
		return this.bkgQtaCmb;
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
	 * @return mr53
	 */
	public String getMr53() {
		return this.mr53;
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
	 * @return gtRf
	 */
	public String getGtRf() {
		return this.gtRf;
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
	 * @return areaCd
	 */
	public String getAreaCd() {
		return this.areaCd;
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
	 * @return childCnt
	 */
	public String getChildCnt() {
		return this.childCnt;
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
	 * @return ugRf
	 */
	public String getUgRf() {
		return this.ugRf;
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
	 * @return polSkip
	 */
	public String getPolSkip() {
		return this.polSkip;
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
	 * @return bt40
	 */
	public String getBt40() {
		return this.bt40;
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
	 * @return cmbWgtTrend
	 */
	public String getCmbWgtTrend() {
		return this.cmbWgtTrend;
	}
	
	/**
	 * Column Info
	 * @return bk20
	 */
	public String getBk20() {
		return this.bk20;
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
	 * @return fcWgt
	 */
	public String getFcWgt() {
		return this.fcWgt;
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
	 * @return bkRf
	 */
	public String getBkRf() {
		return this.bkRf;
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
	 * @return polDblPortChk
	 */
	public String getPolDblPortChk() {
		return this.polDblPortChk;
	}
	
	/**
	 * Column Info
	 * @return gt53
	 */
	public String getGt53() {
		return this.gt53;
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
	 * @return apWgt
	 */
	public String getApWgt() {
		return this.apWgt;
	}
	
	/**
	 * Column Info
	 * @return ug53
	 */
	public String getUg53() {
		return this.ug53;
	}
	
	/**
	 * Column Info
	 * @return bk53
	 */
	public String getBk53() {
		return this.bk53;
	}
	
	/**
	 * Column Info
	 * @return bsTeu
	 */
	public String getBsTeu() {
		return this.bsTeu;
	}
	
	/**
	 * Column Info
	 * @return mrRf
	 */
	public String getMrRf() {
		return this.mrRf;
	}
	
	/**
	 * Column Info
	 * @return mrWgt
	 */
	public String getMrWgt() {
		return this.mrWgt;
	}
	
	/**
	 * Column Info
	 * @return bkTeu
	 */
	public String getBkTeu() {
		return this.bkTeu;
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
	 * @return ugTeu
	 */
	public String getUgTeu() {
		return this.ugTeu;
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
	 * @return gtWgt
	 */
	public String getGtWgt() {
		return this.gtWgt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return bk45
	 */
	public String getBk45() {
		return this.bk45;
	}
	
	/**
	 * Column Info
	 * @return ug45
	 */
	public String getUg45() {
		return this.ug45;
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
	 * @return podSkip
	 */
	public String getPodSkip() {
		return this.podSkip;
	}
	
	/**
	 * Column Info
	 * @return bk40
	 */
	public String getBk40() {
		return this.bk40;
	}
	
	/**
	 * Column Info
	 * @return mrHc
	 */
	public String getMrHc() {
		return this.mrHc;
	}
	
	/**
	 * Column Info
	 * @return podSeq
	 */
	public String getPodSeq() {
		return this.podSeq;
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
	 * @return polSeq
	 */
	public String getPolSeq() {
		return this.polSeq;
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
	 * @return mr45
	 */
	public String getMr45() {
		return this.mr45;
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
	 * @return fcRd
	 */
	public String getFcRd() {
		return this.fcRd;
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
	 * @return fcTeu
	 */
	public String getFcTeu() {
		return this.fcTeu;
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
	 * @return apRf
	 */
	public String getApRf() {
		return this.apRf;
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
	 * @return cmbWgt3
	 */
	public String getCmbWgt3() {
		return this.cmbWgt3;
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
	 * @return gtHc
	 */
	public String getGtHc() {
		return this.gtHc;
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
	 * @return cmbWgt4
	 */
	public String getCmbWgt4() {
		return this.cmbWgt4;
	}
	

	/**
	 * Column Info
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
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
	 * @param repSubTrdCd
	 */
	public void setRepSubTrdCd(String repSubTrdCd) {
		this.repSubTrdCd = repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bsWgt
	 */
	public void setBsWgt(String bsWgt) {
		this.bsWgt = bsWgt;
	}
	
	/**
	 * Column Info
	 * @param mrTeu
	 */
	public void setMrTeu(String mrTeu) {
		this.mrTeu = mrTeu;
	}
	
	/**
	 * Column Info
	 * @param bkHc
	 */
	public void setBkHc(String bkHc) {
		this.bkHc = bkHc;
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
	 * @param bkWgt
	 */
	public void setBkWgt(String bkWgt) {
		this.bkWgt = bkWgt;
	}
	
	/**
	 * Column Info
	 * @param ugWgt
	 */
	public void setUgWgt(String ugWgt) {
		this.ugWgt = ugWgt;
	}
	
	/**
	 * Column Info
	 * @param gtTeu
	 */
	public void setGtTeu(String gtTeu) {
		this.gtTeu = gtTeu;
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
	 * @param ugHc
	 */
	public void setUgHc(String ugHc) {
		this.ugHc = ugHc;
	}
	
	/**
	 * Column Info
	 * @param gt45
	 */
	public void setGt45(String gt45) {
		this.gt45 = gt45;
	}
	
	/**
	 * Column Info
	 * @param guide
	 */
	public void setGuide(String guide) {
		this.guide = guide;
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
	 * @param bkgQtaCmb
	 */
	public void setBkgQtaCmb(String bkgQtaCmb) {
		this.bkgQtaCmb = bkgQtaCmb;
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
	 * @param mr53
	 */
	public void setMr53(String mr53) {
		this.mr53 = mr53;
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
	 * @param gtRf
	 */
	public void setGtRf(String gtRf) {
		this.gtRf = gtRf;
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
	 * @param areaCd
	 */
	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd;
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
	 * @param childCnt
	 */
	public void setChildCnt(String childCnt) {
		this.childCnt = childCnt;
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
	 * @param ugRf
	 */
	public void setUgRf(String ugRf) {
		this.ugRf = ugRf;
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
	 * @param polSkip
	 */
	public void setPolSkip(String polSkip) {
		this.polSkip = polSkip;
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
	 * @param bt40
	 */
	public void setBt40(String bt40) {
		this.bt40 = bt40;
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
	 * @param cmbWgtTrend
	 */
	public void setCmbWgtTrend(String cmbWgtTrend) {
		this.cmbWgtTrend = cmbWgtTrend;
	}
	
	/**
	 * Column Info
	 * @param bk20
	 */
	public void setBk20(String bk20) {
		this.bk20 = bk20;
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
	 * @param fcWgt
	 */
	public void setFcWgt(String fcWgt) {
		this.fcWgt = fcWgt;
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
	 * @param bkRf
	 */
	public void setBkRf(String bkRf) {
		this.bkRf = bkRf;
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
	 * @param polDblPortChk
	 */
	public void setPolDblPortChk(String polDblPortChk) {
		this.polDblPortChk = polDblPortChk;
	}
	
	/**
	 * Column Info
	 * @param gt53
	 */
	public void setGt53(String gt53) {
		this.gt53 = gt53;
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
	 * @param apWgt
	 */
	public void setApWgt(String apWgt) {
		this.apWgt = apWgt;
	}
	
	/**
	 * Column Info
	 * @param ug53
	 */
	public void setUg53(String ug53) {
		this.ug53 = ug53;
	}
	
	/**
	 * Column Info
	 * @param bk53
	 */
	public void setBk53(String bk53) {
		this.bk53 = bk53;
	}
	
	/**
	 * Column Info
	 * @param bsTeu
	 */
	public void setBsTeu(String bsTeu) {
		this.bsTeu = bsTeu;
	}
	
	/**
	 * Column Info
	 * @param mrRf
	 */
	public void setMrRf(String mrRf) {
		this.mrRf = mrRf;
	}
	
	/**
	 * Column Info
	 * @param mrWgt
	 */
	public void setMrWgt(String mrWgt) {
		this.mrWgt = mrWgt;
	}
	
	/**
	 * Column Info
	 * @param bkTeu
	 */
	public void setBkTeu(String bkTeu) {
		this.bkTeu = bkTeu;
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
	 * @param ugTeu
	 */
	public void setUgTeu(String ugTeu) {
		this.ugTeu = ugTeu;
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
	 * @param gtWgt
	 */
	public void setGtWgt(String gtWgt) {
		this.gtWgt = gtWgt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param bk45
	 */
	public void setBk45(String bk45) {
		this.bk45 = bk45;
	}
	
	/**
	 * Column Info
	 * @param ug45
	 */
	public void setUg45(String ug45) {
		this.ug45 = ug45;
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
	 * @param podSkip
	 */
	public void setPodSkip(String podSkip) {
		this.podSkip = podSkip;
	}
	
	/**
	 * Column Info
	 * @param bk40
	 */
	public void setBk40(String bk40) {
		this.bk40 = bk40;
	}
	
	/**
	 * Column Info
	 * @param mrHc
	 */
	public void setMrHc(String mrHc) {
		this.mrHc = mrHc;
	}
	
	/**
	 * Column Info
	 * @param podSeq
	 */
	public void setPodSeq(String podSeq) {
		this.podSeq = podSeq;
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
	 * @param polSeq
	 */
	public void setPolSeq(String polSeq) {
		this.polSeq = polSeq;
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
	 * @param mr45
	 */
	public void setMr45(String mr45) {
		this.mr45 = mr45;
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
	 * @param fcRd
	 */
	public void setFcRd(String fcRd) {
		this.fcRd = fcRd;
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
	 * @param fcTeu
	 */
	public void setFcTeu(String fcTeu) {
		this.fcTeu = fcTeu;
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
	 * @param apRf
	 */
	public void setApRf(String apRf) {
		this.apRf = apRf;
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
	 * @param cmbWgt3
	 */
	public void setCmbWgt3(String cmbWgt3) {
		this.cmbWgt3 = cmbWgt3;
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
	 * @param gtHc
	 */
	public void setGtHc(String gtHc) {
		this.gtHc = gtHc;
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
		setRepTrdCd(JSPUtil.getParameter(request, prefix + "rep_trd_cd", ""));
		setBkgQuota(JSPUtil.getParameter(request, prefix + "bkg_quota", ""));
		setBtRf(JSPUtil.getParameter(request, prefix + "bt_rf", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, prefix + "rep_sub_trd_cd", ""));
		setBsWgt(JSPUtil.getParameter(request, prefix + "bs_wgt", ""));
		setMrTeu(JSPUtil.getParameter(request, prefix + "mr_teu", ""));
		setBkHc(JSPUtil.getParameter(request, prefix + "bk_hc", ""));
		setBtRd(JSPUtil.getParameter(request, prefix + "bt_rd", ""));
		setApMd(JSPUtil.getParameter(request, prefix + "ap_md", ""));
		setBkWgt(JSPUtil.getParameter(request, prefix + "bk_wgt", ""));
		setUgWgt(JSPUtil.getParameter(request, prefix + "ug_wgt", ""));
		setGtTeu(JSPUtil.getParameter(request, prefix + "gt_teu", ""));
		setFcTtlTeu(JSPUtil.getParameter(request, prefix + "fc_ttl_teu", ""));
		setUgHc(JSPUtil.getParameter(request, prefix + "ug_hc", ""));
		setGt45(JSPUtil.getParameter(request, prefix + "gt_45", ""));
		setGuide(JSPUtil.getParameter(request, prefix + "guide", ""));
		setAp53(JSPUtil.getParameter(request, prefix + "ap_53", ""));
		setBkgQtaCmb(JSPUtil.getParameter(request, prefix + "bkg_qta_cmb", ""));
		setUsMod(JSPUtil.getParameter(request, prefix + "us_mod", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setEdit(JSPUtil.getParameter(request, prefix + "edit", ""));
		setPast(JSPUtil.getParameter(request, prefix + "past", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setLeafCnt(JSPUtil.getParameter(request, prefix + "leaf_cnt", ""));
		setSpcCtrlAlocRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_rmk", ""));
		setMr53(JSPUtil.getParameter(request, prefix + "mr_53", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setGtRf(JSPUtil.getParameter(request, prefix + "gt_rf", ""));
		setFc53(JSPUtil.getParameter(request, prefix + "fc_53", ""));
		setAreaCd(JSPUtil.getParameter(request, prefix + "area_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setCmb(JSPUtil.getParameter(request, prefix + "cmb", ""));
		setBt20(JSPUtil.getParameter(request, prefix + "bt_20", ""));
		setChildCnt(JSPUtil.getParameter(request, prefix + "child_cnt", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setUgRf(JSPUtil.getParameter(request, prefix + "ug_rf", ""));
		setCmbWgt(JSPUtil.getParameter(request, prefix + "cmb_wgt", ""));
		setPolSkip(JSPUtil.getParameter(request, prefix + "pol_skip", ""));
		setBt53(JSPUtil.getParameter(request, prefix + "bt_53", ""));
		setBt40(JSPUtil.getParameter(request, prefix + "bt_40", ""));
		setCmbAvg(JSPUtil.getParameter(request, prefix + "cmb_avg", ""));
		setCmbWgtTrend(JSPUtil.getParameter(request, prefix + "cmb_wgt_trend", ""));
		setBk20(JSPUtil.getParameter(request, prefix + "bk_20", ""));
		setBtWgt(JSPUtil.getParameter(request, prefix + "bt_wgt", ""));
		setFcWgt(JSPUtil.getParameter(request, prefix + "fc_wgt", ""));
		setBtD4(JSPUtil.getParameter(request, prefix + "bt_d4", ""));
		setBtD2(JSPUtil.getParameter(request, prefix + "bt_d2", ""));
		setCmbTrend(JSPUtil.getParameter(request, prefix + "cmb_trend", ""));
		setBkRf(JSPUtil.getParameter(request, prefix + "bk_rf", ""));
		setAccountCd(JSPUtil.getParameter(request, prefix + "account_cd", ""));
		setPolDblPortChk(JSPUtil.getParameter(request, prefix + "pol_dbl_port_chk", ""));
		setGt53(JSPUtil.getParameter(request, prefix + "gt_53", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBt45(JSPUtil.getParameter(request, prefix + "bt_45", ""));
		setApWgt(JSPUtil.getParameter(request, prefix + "ap_wgt", ""));
		setUg53(JSPUtil.getParameter(request, prefix + "ug_53", ""));
		setBk53(JSPUtil.getParameter(request, prefix + "bk_53", ""));
		setBsTeu(JSPUtil.getParameter(request, prefix + "bs_teu", ""));
		setMrRf(JSPUtil.getParameter(request, prefix + "mr_rf", ""));
		setMrWgt(JSPUtil.getParameter(request, prefix + "mr_wgt", ""));
		setBkTeu(JSPUtil.getParameter(request, prefix + "bk_teu", ""));
		setPodCnt(JSPUtil.getParameter(request, prefix + "pod_cnt", ""));
		setUgTeu(JSPUtil.getParameter(request, prefix + "ug_teu", ""));
		setBaseRhqCd(JSPUtil.getParameter(request, prefix + "base_rhq_cd", ""));
		setGtWgt(JSPUtil.getParameter(request, prefix + "gt_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBk45(JSPUtil.getParameter(request, prefix + "bk_45", ""));
		setUg45(JSPUtil.getParameter(request, prefix + "ug_45", ""));
		setApHc(JSPUtil.getParameter(request, prefix + "ap_hc", ""));
		setPodSkip(JSPUtil.getParameter(request, prefix + "pod_skip", ""));
		setBk40(JSPUtil.getParameter(request, prefix + "bk_40", ""));
		setMrHc(JSPUtil.getParameter(request, prefix + "mr_hc", ""));
		setPodSeq(JSPUtil.getParameter(request, prefix + "pod_seq", ""));
		setFcHc(JSPUtil.getParameter(request, prefix + "fc_hc", ""));
		setPolSeq(JSPUtil.getParameter(request, prefix + "pol_seq", ""));
		setSpcCtrlAlocPodRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_pod_rmk", ""));
		setFcD4(JSPUtil.getParameter(request, prefix + "fc_d4", ""));
		setBtHc(JSPUtil.getParameter(request, prefix + "bt_hc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFcD2(JSPUtil.getParameter(request, prefix + "fc_d2", ""));
		setCmOp(JSPUtil.getParameter(request, prefix + "cm_op", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setSpcCtrlAlocPolRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_pol_rmk", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setFc45(JSPUtil.getParameter(request, prefix + "fc_45", ""));
		setCmb4(JSPUtil.getParameter(request, prefix + "cmb4", ""));
		setCmb2(JSPUtil.getParameter(request, prefix + "cmb2", ""));
		setCmb3(JSPUtil.getParameter(request, prefix + "cmb3", ""));
		setMr45(JSPUtil.getParameter(request, prefix + "mr_45", ""));
		setAccountNm(JSPUtil.getParameter(request, prefix + "account_nm", ""));
		setCmb1(JSPUtil.getParameter(request, prefix + "cmb1", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setAp45(JSPUtil.getParameter(request, prefix + "ap_45", ""));
		setFcRd(JSPUtil.getParameter(request, prefix + "fc_rd", ""));
		setBtTeu(JSPUtil.getParameter(request, prefix + "bt_teu", ""));
		setFcTeu(JSPUtil.getParameter(request, prefix + "fc_teu", ""));
		setApRd(JSPUtil.getParameter(request, prefix + "ap_rd", ""));
		setCmVl(JSPUtil.getParameter(request, prefix + "cm_vl", ""));
		setApRf(JSPUtil.getParameter(request, prefix + "ap_rf", ""));
		setCmOc(JSPUtil.getParameter(request, prefix + "cm_oc", ""));
		setCmbWgt3(JSPUtil.getParameter(request, prefix + "cmb_wgt3", ""));
		setApD2(JSPUtil.getParameter(request, prefix + "ap_d2", ""));
		setCmbWgt2(JSPUtil.getParameter(request, prefix + "cmb_wgt2", ""));
		setCmbWgt1(JSPUtil.getParameter(request, prefix + "cmb_wgt1", ""));
		setApD4(JSPUtil.getParameter(request, prefix + "ap_d4", ""));
		setGtHc(JSPUtil.getParameter(request, prefix + "gt_hc", ""));
		setApTeu(JSPUtil.getParameter(request, prefix + "ap_teu", ""));
		setFcRf(JSPUtil.getParameter(request, prefix + "fc_rf", ""));
		setCmbWgt4(JSPUtil.getParameter(request, prefix + "cmb_wgt4", ""));
		setBkgWgtVgm(JSPUtil.getParameter(request, prefix + "bkg_wgt_vgm", ""));
		setBkgVolVgm(JSPUtil.getParameter(request, prefix + "bkg_vol_vgm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocation0042DetailListVO[]
	 */
	public SearchSpaceAllocation0042DetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocation0042DetailListVO[]
	 */
	public SearchSpaceAllocation0042DetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocation0042DetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] bkgQuota = (JSPUtil.getParameter(request, prefix	+ "bkg_quota", length));
			String[] btRf = (JSPUtil.getParameter(request, prefix	+ "bt_rf", length));
			String[] repSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd", length));
			String[] bsWgt = (JSPUtil.getParameter(request, prefix	+ "bs_wgt", length));
			String[] mrTeu = (JSPUtil.getParameter(request, prefix	+ "mr_teu", length));
			String[] bkHc = (JSPUtil.getParameter(request, prefix	+ "bk_hc", length));
			String[] btRd = (JSPUtil.getParameter(request, prefix	+ "bt_rd", length));
			String[] apMd = (JSPUtil.getParameter(request, prefix	+ "ap_md", length));
			String[] bkWgt = (JSPUtil.getParameter(request, prefix	+ "bk_wgt", length));
			String[] ugWgt = (JSPUtil.getParameter(request, prefix	+ "ug_wgt", length));
			String[] gtTeu = (JSPUtil.getParameter(request, prefix	+ "gt_teu", length));
			String[] fcTtlTeu = (JSPUtil.getParameter(request, prefix	+ "fc_ttl_teu", length));
			String[] ugHc = (JSPUtil.getParameter(request, prefix	+ "ug_hc", length));
			String[] gt45 = (JSPUtil.getParameter(request, prefix	+ "gt_45", length));
			String[] guide = (JSPUtil.getParameter(request, prefix	+ "guide", length));
			String[] ap53 = (JSPUtil.getParameter(request, prefix	+ "ap_53", length));
			String[] bkgQtaCmb = (JSPUtil.getParameter(request, prefix	+ "bkg_qta_cmb", length));
			String[] usMod = (JSPUtil.getParameter(request, prefix	+ "us_mod", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] edit = (JSPUtil.getParameter(request, prefix	+ "edit", length));
			String[] past = (JSPUtil.getParameter(request, prefix	+ "past", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] leafCnt = (JSPUtil.getParameter(request, prefix	+ "leaf_cnt", length));
			String[] spcCtrlAlocRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_rmk", length));
			String[] mr53 = (JSPUtil.getParameter(request, prefix	+ "mr_53", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] gtRf = (JSPUtil.getParameter(request, prefix	+ "gt_rf", length));
			String[] fc53 = (JSPUtil.getParameter(request, prefix	+ "fc_53", length));
			String[] areaCd = (JSPUtil.getParameter(request, prefix	+ "area_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] cmb = (JSPUtil.getParameter(request, prefix	+ "cmb", length));
			String[] bt20 = (JSPUtil.getParameter(request, prefix	+ "bt_20", length));
			String[] childCnt = (JSPUtil.getParameter(request, prefix	+ "child_cnt", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] ugRf = (JSPUtil.getParameter(request, prefix	+ "ug_rf", length));
			String[] cmbWgt = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt", length));
			String[] polSkip = (JSPUtil.getParameter(request, prefix	+ "pol_skip", length));
			String[] bt53 = (JSPUtil.getParameter(request, prefix	+ "bt_53", length));
			String[] bt40 = (JSPUtil.getParameter(request, prefix	+ "bt_40", length));
			String[] cmbAvg = (JSPUtil.getParameter(request, prefix	+ "cmb_avg", length));
			String[] cmbWgtTrend = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt_trend", length));
			String[] bk20 = (JSPUtil.getParameter(request, prefix	+ "bk_20", length));
			String[] btWgt = (JSPUtil.getParameter(request, prefix	+ "bt_wgt", length));
			String[] fcWgt = (JSPUtil.getParameter(request, prefix	+ "fc_wgt", length));
			String[] btD4 = (JSPUtil.getParameter(request, prefix	+ "bt_d4", length));
			String[] btD2 = (JSPUtil.getParameter(request, prefix	+ "bt_d2", length));
			String[] cmbTrend = (JSPUtil.getParameter(request, prefix	+ "cmb_trend", length));
			String[] bkRf = (JSPUtil.getParameter(request, prefix	+ "bk_rf", length));
			String[] accountCd = (JSPUtil.getParameter(request, prefix	+ "account_cd", length));
			String[] polDblPortChk = (JSPUtil.getParameter(request, prefix	+ "pol_dbl_port_chk", length));
			String[] gt53 = (JSPUtil.getParameter(request, prefix	+ "gt_53", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bt45 = (JSPUtil.getParameter(request, prefix	+ "bt_45", length));
			String[] apWgt = (JSPUtil.getParameter(request, prefix	+ "ap_wgt", length));
			String[] ug53 = (JSPUtil.getParameter(request, prefix	+ "ug_53", length));
			String[] bk53 = (JSPUtil.getParameter(request, prefix	+ "bk_53", length));
			String[] bsTeu = (JSPUtil.getParameter(request, prefix	+ "bs_teu", length));
			String[] mrRf = (JSPUtil.getParameter(request, prefix	+ "mr_rf", length));
			String[] mrWgt = (JSPUtil.getParameter(request, prefix	+ "mr_wgt", length));
			String[] bkTeu = (JSPUtil.getParameter(request, prefix	+ "bk_teu", length));
			String[] podCnt = (JSPUtil.getParameter(request, prefix	+ "pod_cnt", length));
			String[] ugTeu = (JSPUtil.getParameter(request, prefix	+ "ug_teu", length));
			String[] baseRhqCd = (JSPUtil.getParameter(request, prefix	+ "base_rhq_cd", length));
			String[] gtWgt = (JSPUtil.getParameter(request, prefix	+ "gt_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bk45 = (JSPUtil.getParameter(request, prefix	+ "bk_45", length));
			String[] ug45 = (JSPUtil.getParameter(request, prefix	+ "ug_45", length));
			String[] apHc = (JSPUtil.getParameter(request, prefix	+ "ap_hc", length));
			String[] podSkip = (JSPUtil.getParameter(request, prefix	+ "pod_skip", length));
			String[] bk40 = (JSPUtil.getParameter(request, prefix	+ "bk_40", length));
			String[] mrHc = (JSPUtil.getParameter(request, prefix	+ "mr_hc", length));
			String[] podSeq = (JSPUtil.getParameter(request, prefix	+ "pod_seq", length));
			String[] fcHc = (JSPUtil.getParameter(request, prefix	+ "fc_hc", length));
			String[] polSeq = (JSPUtil.getParameter(request, prefix	+ "pol_seq", length));
			String[] spcCtrlAlocPodRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_pod_rmk", length));
			String[] fcD4 = (JSPUtil.getParameter(request, prefix	+ "fc_d4", length));
			String[] btHc = (JSPUtil.getParameter(request, prefix	+ "bt_hc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fcD2 = (JSPUtil.getParameter(request, prefix	+ "fc_d2", length));
			String[] cmOp = (JSPUtil.getParameter(request, prefix	+ "cm_op", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] spcCtrlAlocPolRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_pol_rmk", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] fc45 = (JSPUtil.getParameter(request, prefix	+ "fc_45", length));
			String[] cmb4 = (JSPUtil.getParameter(request, prefix	+ "cmb4", length));
			String[] cmb2 = (JSPUtil.getParameter(request, prefix	+ "cmb2", length));
			String[] cmb3 = (JSPUtil.getParameter(request, prefix	+ "cmb3", length));
			String[] mr45 = (JSPUtil.getParameter(request, prefix	+ "mr_45", length));
			String[] accountNm = (JSPUtil.getParameter(request, prefix	+ "account_nm", length));
			String[] cmb1 = (JSPUtil.getParameter(request, prefix	+ "cmb1", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ap45 = (JSPUtil.getParameter(request, prefix	+ "ap_45", length));
			String[] fcRd = (JSPUtil.getParameter(request, prefix	+ "fc_rd", length));
			String[] btTeu = (JSPUtil.getParameter(request, prefix	+ "bt_teu", length));
			String[] fcTeu = (JSPUtil.getParameter(request, prefix	+ "fc_teu", length));
			String[] apRd = (JSPUtil.getParameter(request, prefix	+ "ap_rd", length));
			String[] cmVl = (JSPUtil.getParameter(request, prefix	+ "cm_vl", length));
			String[] apRf = (JSPUtil.getParameter(request, prefix	+ "ap_rf", length));
			String[] cmOc = (JSPUtil.getParameter(request, prefix	+ "cm_oc", length));
			String[] cmbWgt3 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt3", length));
			String[] apD2 = (JSPUtil.getParameter(request, prefix	+ "ap_d2", length));
			String[] cmbWgt2 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt2", length));
			String[] cmbWgt1 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt1", length));
			String[] apD4 = (JSPUtil.getParameter(request, prefix	+ "ap_d4", length));
			String[] gtHc = (JSPUtil.getParameter(request, prefix	+ "gt_hc", length));
			String[] apTeu = (JSPUtil.getParameter(request, prefix	+ "ap_teu", length));
			String[] fcRf = (JSPUtil.getParameter(request, prefix	+ "fc_rf", length));
			String[] cmbWgt4 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt4", length));
			String[] bkgWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_vgm", length));
			String[] bkgVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_vol_vgm", length));
			  
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocation0042DetailListVO();
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (bkgQuota[i] != null)
					model.setBkgQuota(bkgQuota[i]);
				if (btRf[i] != null)
					model.setBtRf(btRf[i]);
				if (repSubTrdCd[i] != null)
					model.setRepSubTrdCd(repSubTrdCd[i]);
				if (bsWgt[i] != null)
					model.setBsWgt(bsWgt[i]);
				if (mrTeu[i] != null)
					model.setMrTeu(mrTeu[i]);
				if (bkHc[i] != null)
					model.setBkHc(bkHc[i]);
				if (btRd[i] != null)
					model.setBtRd(btRd[i]);
				if (apMd[i] != null)
					model.setApMd(apMd[i]);
				if (bkWgt[i] != null)
					model.setBkWgt(bkWgt[i]);
				if (ugWgt[i] != null)
					model.setUgWgt(ugWgt[i]);
				if (gtTeu[i] != null)
					model.setGtTeu(gtTeu[i]);
				if (fcTtlTeu[i] != null)
					model.setFcTtlTeu(fcTtlTeu[i]);
				if (ugHc[i] != null)
					model.setUgHc(ugHc[i]);
				if (gt45[i] != null)
					model.setGt45(gt45[i]);
				if (guide[i] != null)
					model.setGuide(guide[i]);
				if (ap53[i] != null)
					model.setAp53(ap53[i]);
				if (bkgQtaCmb[i] != null)
					model.setBkgQtaCmb(bkgQtaCmb[i]);
				if (usMod[i] != null)
					model.setUsMod(usMod[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (edit[i] != null)
					model.setEdit(edit[i]);
				if (past[i] != null)
					model.setPast(past[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (leafCnt[i] != null)
					model.setLeafCnt(leafCnt[i]);
				if (spcCtrlAlocRmk[i] != null)
					model.setSpcCtrlAlocRmk(spcCtrlAlocRmk[i]);
				if (mr53[i] != null)
					model.setMr53(mr53[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (gtRf[i] != null)
					model.setGtRf(gtRf[i]);
				if (fc53[i] != null)
					model.setFc53(fc53[i]);
				if (areaCd[i] != null)
					model.setAreaCd(areaCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (cmb[i] != null)
					model.setCmb(cmb[i]);
				if (bt20[i] != null)
					model.setBt20(bt20[i]);
				if (childCnt[i] != null)
					model.setChildCnt(childCnt[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (ugRf[i] != null)
					model.setUgRf(ugRf[i]);
				if (cmbWgt[i] != null)
					model.setCmbWgt(cmbWgt[i]);
				if (polSkip[i] != null)
					model.setPolSkip(polSkip[i]);
				if (bt53[i] != null)
					model.setBt53(bt53[i]);
				if (bt40[i] != null)
					model.setBt40(bt40[i]);
				if (cmbAvg[i] != null)
					model.setCmbAvg(cmbAvg[i]);
				if (cmbWgtTrend[i] != null)
					model.setCmbWgtTrend(cmbWgtTrend[i]);
				if (bk20[i] != null)
					model.setBk20(bk20[i]);
				if (btWgt[i] != null)
					model.setBtWgt(btWgt[i]);
				if (fcWgt[i] != null)
					model.setFcWgt(fcWgt[i]);
				if (btD4[i] != null)
					model.setBtD4(btD4[i]);
				if (btD2[i] != null)
					model.setBtD2(btD2[i]);
				if (cmbTrend[i] != null)
					model.setCmbTrend(cmbTrend[i]);
				if (bkRf[i] != null)
					model.setBkRf(bkRf[i]);
				if (accountCd[i] != null)
					model.setAccountCd(accountCd[i]);
				if (polDblPortChk[i] != null)
					model.setPolDblPortChk(polDblPortChk[i]);
				if (gt53[i] != null)
					model.setGt53(gt53[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bt45[i] != null)
					model.setBt45(bt45[i]);
				if (apWgt[i] != null)
					model.setApWgt(apWgt[i]);
				if (ug53[i] != null)
					model.setUg53(ug53[i]);
				if (bk53[i] != null)
					model.setBk53(bk53[i]);
				if (bsTeu[i] != null)
					model.setBsTeu(bsTeu[i]);
				if (mrRf[i] != null)
					model.setMrRf(mrRf[i]);
				if (mrWgt[i] != null)
					model.setMrWgt(mrWgt[i]);
				if (bkTeu[i] != null)
					model.setBkTeu(bkTeu[i]);
				if (podCnt[i] != null)
					model.setPodCnt(podCnt[i]);
				if (ugTeu[i] != null)
					model.setUgTeu(ugTeu[i]);
				if (baseRhqCd[i] != null)
					model.setBaseRhqCd(baseRhqCd[i]);
				if (gtWgt[i] != null)
					model.setGtWgt(gtWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bk45[i] != null)
					model.setBk45(bk45[i]);
				if (ug45[i] != null)
					model.setUg45(ug45[i]);
				if (apHc[i] != null)
					model.setApHc(apHc[i]);
				if (podSkip[i] != null)
					model.setPodSkip(podSkip[i]);
				if (bk40[i] != null)
					model.setBk40(bk40[i]);
				if (mrHc[i] != null)
					model.setMrHc(mrHc[i]);
				if (podSeq[i] != null)
					model.setPodSeq(podSeq[i]);
				if (fcHc[i] != null)
					model.setFcHc(fcHc[i]);
				if (polSeq[i] != null)
					model.setPolSeq(polSeq[i]);
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
				if (cmOp[i] != null)
					model.setCmOp(cmOp[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (spcCtrlAlocPolRmk[i] != null)
					model.setSpcCtrlAlocPolRmk(spcCtrlAlocPolRmk[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fc45[i] != null)
					model.setFc45(fc45[i]);
				if (cmb4[i] != null)
					model.setCmb4(cmb4[i]);
				if (cmb2[i] != null)
					model.setCmb2(cmb2[i]);
				if (cmb3[i] != null)
					model.setCmb3(cmb3[i]);
				if (mr45[i] != null)
					model.setMr45(mr45[i]);
				if (accountNm[i] != null)
					model.setAccountNm(accountNm[i]);
				if (cmb1[i] != null)
					model.setCmb1(cmb1[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ap45[i] != null)
					model.setAp45(ap45[i]);
				if (fcRd[i] != null)
					model.setFcRd(fcRd[i]);
				if (btTeu[i] != null)
					model.setBtTeu(btTeu[i]);
				if (fcTeu[i] != null)
					model.setFcTeu(fcTeu[i]);
				if (apRd[i] != null)
					model.setApRd(apRd[i]);
				if (cmVl[i] != null)
					model.setCmVl(cmVl[i]);
				if (apRf[i] != null)
					model.setApRf(apRf[i]);
				if (cmOc[i] != null)
					model.setCmOc(cmOc[i]);
				if (cmbWgt3[i] != null)
					model.setCmbWgt3(cmbWgt3[i]);
				if (apD2[i] != null)
					model.setApD2(apD2[i]);
				if (cmbWgt2[i] != null)
					model.setCmbWgt2(cmbWgt2[i]);
				if (cmbWgt1[i] != null)
					model.setCmbWgt1(cmbWgt1[i]);
				if (apD4[i] != null)
					model.setApD4(apD4[i]);
				if (gtHc[i] != null)
					model.setGtHc(gtHc[i]);
				if (apTeu[i] != null)
					model.setApTeu(apTeu[i]);
				if (fcRf[i] != null)
					model.setFcRf(fcRf[i]);
				if (cmbWgt4[i] != null)
					model.setCmbWgt4(cmbWgt4[i]);
				if (bkgWgtVgm[i] != null) model.setBkgWgtVgm(bkgWgtVgm[i]);
				if (bkgVolVgm[i] != null) model.setBkgVolVgm(bkgVolVgm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocation0042DetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocation0042DetailListVO[]
	 */
	public SearchSpaceAllocation0042DetailListVO[] getSearchSpaceAllocation0042DetailListVOs(){
		SearchSpaceAllocation0042DetailListVO[] vos = (SearchSpaceAllocation0042DetailListVO[])models.toArray(new SearchSpaceAllocation0042DetailListVO[models.size()]);
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
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQuota = this.bkgQuota .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btRf = this.btRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsWgt = this.bsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrTeu = this.mrTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkHc = this.bkHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btRd = this.btRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apMd = this.apMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkWgt = this.bkWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ugWgt = this.ugWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtTeu = this.gtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTtlTeu = this.fcTtlTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ugHc = this.ugHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gt45 = this.gt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.guide = this.guide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap53 = this.ap53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQtaCmb = this.bkgQtaCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usMod = this.usMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edit = this.edit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.past = this.past .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leafCnt = this.leafCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocRmk = this.spcCtrlAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mr53 = this.mr53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtRf = this.gtRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc53 = this.fc53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.areaCd = this.areaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb = this.cmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt20 = this.bt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.childCnt = this.childCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ugRf = this.ugRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt = this.cmbWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSkip = this.polSkip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt53 = this.bt53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt40 = this.bt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbAvg = this.cmbAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgtTrend = this.cmbWgtTrend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk20 = this.bk20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btWgt = this.btWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcWgt = this.fcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btD4 = this.btD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btD2 = this.btD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbTrend = this.cmbTrend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkRf = this.bkRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountCd = this.accountCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDblPortChk = this.polDblPortChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gt53 = this.gt53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt45 = this.bt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apWgt = this.apWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ug53 = this.ug53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk53 = this.bk53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsTeu = this.bsTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrRf = this.mrRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrWgt = this.mrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkTeu = this.bkTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCnt = this.podCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ugTeu = this.ugTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.baseRhqCd = this.baseRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtWgt = this.gtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk45 = this.bk45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ug45 = this.ug45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apHc = this.apHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSkip = this.podSkip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk40 = this.bk40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrHc = this.mrHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSeq = this.podSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcHc = this.fcHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSeq = this.polSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocPodRmk = this.spcCtrlAlocPodRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcD4 = this.fcD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btHc = this.btHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcD2 = this.fcD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOp = this.cmOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocPolRmk = this.spcCtrlAlocPolRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc45 = this.fc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb4 = this.cmb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb2 = this.cmb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb3 = this.cmb3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mr45 = this.mr45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountNm = this.accountNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb1 = this.cmb1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap45 = this.ap45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcRd = this.fcRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btTeu = this.btTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTeu = this.fcTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRd = this.apRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmVl = this.cmVl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRf = this.apRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmOc = this.cmOc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt3 = this.cmbWgt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apD2 = this.apD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt2 = this.cmbWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt1 = this.cmbWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apD4 = this.apD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtHc = this.gtHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apTeu = this.apTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcRf = this.fcRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt4 = this.cmbWgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtVgm = this.bkgWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
