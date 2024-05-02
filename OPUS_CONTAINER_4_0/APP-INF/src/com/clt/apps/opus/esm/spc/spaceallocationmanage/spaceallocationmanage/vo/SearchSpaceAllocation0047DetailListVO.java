/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSpaceAllocation0047DetailListVO.java
*@FileTitle : SearchSpaceAllocation0047DetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.07.05 최윤성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocation0047DetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocation0047DetailListVO> models = new ArrayList<SearchSpaceAllocation0047DetailListVO>();
	
	/* Column Info */
	private String ugRf = null;
	/* Column Info */
	private String bk20 = null;
	/* Column Info */
	private String mrTeu = null;
	/* Column Info */
	private String gtHc = null;
	/* Column Info */
	private String spcCtrlAlocPodRmk = null;
	/* Column Info */
	private String apTeu = null;
	/* Column Info */
	private String bkWgt = null;
	/* Column Info */
	private String mr53 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String fcRf = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ug53 = null;
	/* Column Info */
	private String ugTeu = null;
	/* Column Info */
	private String spcCtrlAlocRmk = null;
	/* Column Info */
	private String btTeu = null;
	/* Column Info */
	private String mrRf = null;
	/* Column Info */
	private String baseRhqCd = null;
	/* Column Info */
	private String fcTeu = null;
	/* Column Info */
	private String mrHc = null;
	/* Column Info */
	private String podCnt = null;
	/* Column Info */
	private String fcTtlTeu = null;
	/* Column Info */
	private String gtRf = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String apWgt = null;
	/* Column Info */
	private String gt53 = null;
	/* Column Info */
	private String leafCnt = null;
	/* Column Info */
	private String ap45 = null;
	/* Column Info */
	private String ug40 = null;
	/* Column Info */
	private String apHc = null;
	/* Column Info */
	private String bt20 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cmb = null;
	/* Column Info */
	private String ugHc = null;
	/* Column Info */
	private String mr20 = null;
	/* Column Info */
	private String bkgQuota = null;
	/* Column Info */
	private String ug45 = null;
	/* Column Info */
	private String ap40 = null;
	/* Column Info */
	private String fc20 = null;
	/* Column Info */
	private String apMd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String fctCmb = null;
	/* Column Info */
	private String btHc = null;
	/* Column Info */
	private String bk45 = null;
	/* Column Info */
	private String bkRf = null;
	/* Column Info */
	private String gt45 = null;
	/* Column Info */
	private String ap53 = null;
	/* Column Info */
	private String gt40 = null;
	/* Column Info */
	private String fcWgt = null;
	/* Column Info */
	private String mrWgt = null;
	/* Column Info */
	private String bk40 = null;
	/* Column Info */
	private String fcHc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkHc = null;
	/* Column Info */
	private String apRf = null;
	/* Column Info */
	private String bt53 = null;
	/* Column Info */
	private String gtWgt = null;
	/* Column Info */
	private String ugWgt = null;
	/* Column Info */
	private String spcCtrlAlocPolRmk = null;
	/* Column Info */
	private String btRf = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String edit = null;
	/* Column Info */
	private String bkTeu = null;
	/* Column Info */
	private String bt40 = null;
	/* Column Info */
	private String past = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String bk53 = null;
	/* Column Info */
	private String mr45 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String btWgt = null;
	/* Column Info */
	private String childCnt = null;
	/* Column Info */
	private String ap20 = null;
	/* Column Info */
	private String gtTeu = null;
	/* Column Info */
	private String bt45 = null;
	/* Column Info */
	private String mr40 = null;
	/* Column Info */
	private String fc45 = null;
	/* Column Info */
	private String fc40 = null;
	/* Column Info */
	private String ug20 = null;
	/* Column Info */
	private String gt20 = null;
	/* Column Info */
	private String fc53 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceAllocation0047DetailListVO() {}

	public SearchSpaceAllocation0047DetailListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String baseRhqCd, String rhqCd, String iocCd, String ofcCd, String polCd, String podCd, String bkgQuota, String cmb, String fctCmb, String fcTtlTeu, String fcTeu, String fc20, String fc40, String fcHc, String fc45, String fc53, String fcRf, String fcWgt, String ugTeu, String ug20, String ug40, String ugHc, String ug45, String ug53, String ugRf, String ugWgt, String mrTeu, String mr20, String mr40, String mrHc, String mr45, String mr53, String mrRf, String mrWgt, String apTeu, String ap20, String ap40, String apHc, String ap45, String ap53, String apRf, String apWgt, String bkTeu, String bk20, String bk40, String bkHc, String bk45, String bk53, String bkRf, String bkWgt, String btTeu, String bt20, String bt40, String btHc, String bt45, String bt53, String btRf, String btWgt, String gtTeu, String gt20, String gt40, String gtHc, String gt45, String gt53, String gtRf, String gtWgt, String apMd, String past, String edit, String childCnt, String leafCnt, String podCnt, String cfmFlg, String spcCtrlAlocRmk, String spcCtrlAlocPolRmk, String spcCtrlAlocPodRmk) {
		this.ugRf = ugRf;
		this.bk20 = bk20;
		this.mrTeu = mrTeu;
		this.gtHc = gtHc;
		this.spcCtrlAlocPodRmk = spcCtrlAlocPodRmk;
		this.apTeu = apTeu;
		this.bkWgt = bkWgt;
		this.mr53 = mr53;
		this.trdCd = trdCd;
		this.fcRf = fcRf;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ug53 = ug53;
		this.ugTeu = ugTeu;
		this.spcCtrlAlocRmk = spcCtrlAlocRmk;
		this.btTeu = btTeu;
		this.mrRf = mrRf;
		this.baseRhqCd = baseRhqCd;
		this.fcTeu = fcTeu;
		this.mrHc = mrHc;
		this.podCnt = podCnt;
		this.fcTtlTeu = fcTtlTeu;
		this.gtRf = gtRf;
		this.rhqCd = rhqCd;
		this.apWgt = apWgt;
		this.gt53 = gt53;
		this.leafCnt = leafCnt;
		this.ap45 = ap45;
		this.ug40 = ug40;
		this.apHc = apHc;
		this.bt20 = bt20;
		this.podCd = podCd;
		this.cmb = cmb;
		this.ugHc = ugHc;
		this.mr20 = mr20;
		this.bkgQuota = bkgQuota;
		this.ug45 = ug45;
		this.ap40 = ap40;
		this.fc20 = fc20;
		this.apMd = apMd;
		this.subTrdCd = subTrdCd;
		this.fctCmb = fctCmb;
		this.btHc = btHc;
		this.bk45 = bk45;
		this.bkRf = bkRf;
		this.gt45 = gt45;
		this.ap53 = ap53;
		this.gt40 = gt40;
		this.fcWgt = fcWgt;
		this.mrWgt = mrWgt;
		this.bk40 = bk40;
		this.fcHc = fcHc;
		this.ibflag = ibflag;
		this.bkHc = bkHc;
		this.apRf = apRf;
		this.bt53 = bt53;
		this.gtWgt = gtWgt;
		this.ugWgt = ugWgt;
		this.spcCtrlAlocPolRmk = spcCtrlAlocPolRmk;
		this.btRf = btRf;
		this.iocCd = iocCd;
		this.edit = edit;
		this.bkTeu = bkTeu;
		this.bt40 = bt40;
		this.past = past;
		this.cfmFlg = cfmFlg;
		this.bk53 = bk53;
		this.mr45 = mr45;
		this.ofcCd = ofcCd;
		this.btWgt = btWgt;
		this.childCnt = childCnt;
		this.ap20 = ap20;
		this.gtTeu = gtTeu;
		this.bt45 = bt45;
		this.mr40 = mr40;
		this.fc45 = fc45;
		this.fc40 = fc40;
		this.ug20 = ug20;
		this.gt20 = gt20;
		this.fc53 = fc53;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ug_rf", getUgRf());
		this.hashColumns.put("bk_20", getBk20());
		this.hashColumns.put("mr_teu", getMrTeu());
		this.hashColumns.put("gt_hc", getGtHc());
		this.hashColumns.put("spc_ctrl_aloc_pod_rmk", getSpcCtrlAlocPodRmk());
		this.hashColumns.put("ap_teu", getApTeu());
		this.hashColumns.put("bk_wgt", getBkWgt());
		this.hashColumns.put("mr_53", getMr53());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("fc_rf", getFcRf());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ug_53", getUg53());
		this.hashColumns.put("ug_teu", getUgTeu());
		this.hashColumns.put("spc_ctrl_aloc_rmk", getSpcCtrlAlocRmk());
		this.hashColumns.put("bt_teu", getBtTeu());
		this.hashColumns.put("mr_rf", getMrRf());
		this.hashColumns.put("base_rhq_cd", getBaseRhqCd());
		this.hashColumns.put("fc_teu", getFcTeu());
		this.hashColumns.put("mr_hc", getMrHc());
		this.hashColumns.put("pod_cnt", getPodCnt());
		this.hashColumns.put("fc_ttl_teu", getFcTtlTeu());
		this.hashColumns.put("gt_rf", getGtRf());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ap_wgt", getApWgt());
		this.hashColumns.put("gt_53", getGt53());
		this.hashColumns.put("leaf_cnt", getLeafCnt());
		this.hashColumns.put("ap_45", getAp45());
		this.hashColumns.put("ug_40", getUg40());
		this.hashColumns.put("ap_hc", getApHc());
		this.hashColumns.put("bt_20", getBt20());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cmb", getCmb());
		this.hashColumns.put("ug_hc", getUgHc());
		this.hashColumns.put("mr_20", getMr20());
		this.hashColumns.put("bkg_quota", getBkgQuota());
		this.hashColumns.put("ug_45", getUg45());
		this.hashColumns.put("ap_40", getAp40());
		this.hashColumns.put("fc_20", getFc20());
		this.hashColumns.put("ap_md", getApMd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("fct_cmb", getFctCmb());
		this.hashColumns.put("bt_hc", getBtHc());
		this.hashColumns.put("bk_45", getBk45());
		this.hashColumns.put("bk_rf", getBkRf());
		this.hashColumns.put("gt_45", getGt45());
		this.hashColumns.put("ap_53", getAp53());
		this.hashColumns.put("gt_40", getGt40());
		this.hashColumns.put("fc_wgt", getFcWgt());
		this.hashColumns.put("mr_wgt", getMrWgt());
		this.hashColumns.put("bk_40", getBk40());
		this.hashColumns.put("fc_hc", getFcHc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bk_hc", getBkHc());
		this.hashColumns.put("ap_rf", getApRf());
		this.hashColumns.put("bt_53", getBt53());
		this.hashColumns.put("gt_wgt", getGtWgt());
		this.hashColumns.put("ug_wgt", getUgWgt());
		this.hashColumns.put("spc_ctrl_aloc_pol_rmk", getSpcCtrlAlocPolRmk());
		this.hashColumns.put("bt_rf", getBtRf());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("edit", getEdit());
		this.hashColumns.put("bk_teu", getBkTeu());
		this.hashColumns.put("bt_40", getBt40());
		this.hashColumns.put("past", getPast());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("bk_53", getBk53());
		this.hashColumns.put("mr_45", getMr45());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bt_wgt", getBtWgt());
		this.hashColumns.put("child_cnt", getChildCnt());
		this.hashColumns.put("ap_20", getAp20());
		this.hashColumns.put("gt_teu", getGtTeu());
		this.hashColumns.put("bt_45", getBt45());
		this.hashColumns.put("mr_40", getMr40());
		this.hashColumns.put("fc_45", getFc45());
		this.hashColumns.put("fc_40", getFc40());
		this.hashColumns.put("ug_20", getUg20());
		this.hashColumns.put("gt_20", getGt20());
		this.hashColumns.put("fc_53", getFc53());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ug_rf", "ugRf");
		this.hashFields.put("bk_20", "bk20");
		this.hashFields.put("mr_teu", "mrTeu");
		this.hashFields.put("gt_hc", "gtHc");
		this.hashFields.put("spc_ctrl_aloc_pod_rmk", "spcCtrlAlocPodRmk");
		this.hashFields.put("ap_teu", "apTeu");
		this.hashFields.put("bk_wgt", "bkWgt");
		this.hashFields.put("mr_53", "mr53");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("fc_rf", "fcRf");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ug_53", "ug53");
		this.hashFields.put("ug_teu", "ugTeu");
		this.hashFields.put("spc_ctrl_aloc_rmk", "spcCtrlAlocRmk");
		this.hashFields.put("bt_teu", "btTeu");
		this.hashFields.put("mr_rf", "mrRf");
		this.hashFields.put("base_rhq_cd", "baseRhqCd");
		this.hashFields.put("fc_teu", "fcTeu");
		this.hashFields.put("mr_hc", "mrHc");
		this.hashFields.put("pod_cnt", "podCnt");
		this.hashFields.put("fc_ttl_teu", "fcTtlTeu");
		this.hashFields.put("gt_rf", "gtRf");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ap_wgt", "apWgt");
		this.hashFields.put("gt_53", "gt53");
		this.hashFields.put("leaf_cnt", "leafCnt");
		this.hashFields.put("ap_45", "ap45");
		this.hashFields.put("ug_40", "ug40");
		this.hashFields.put("ap_hc", "apHc");
		this.hashFields.put("bt_20", "bt20");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cmb", "cmb");
		this.hashFields.put("ug_hc", "ugHc");
		this.hashFields.put("mr_20", "mr20");
		this.hashFields.put("bkg_quota", "bkgQuota");
		this.hashFields.put("ug_45", "ug45");
		this.hashFields.put("ap_40", "ap40");
		this.hashFields.put("fc_20", "fc20");
		this.hashFields.put("ap_md", "apMd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("fct_cmb", "fctCmb");
		this.hashFields.put("bt_hc", "btHc");
		this.hashFields.put("bk_45", "bk45");
		this.hashFields.put("bk_rf", "bkRf");
		this.hashFields.put("gt_45", "gt45");
		this.hashFields.put("ap_53", "ap53");
		this.hashFields.put("gt_40", "gt40");
		this.hashFields.put("fc_wgt", "fcWgt");
		this.hashFields.put("mr_wgt", "mrWgt");
		this.hashFields.put("bk_40", "bk40");
		this.hashFields.put("fc_hc", "fcHc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bk_hc", "bkHc");
		this.hashFields.put("ap_rf", "apRf");
		this.hashFields.put("bt_53", "bt53");
		this.hashFields.put("gt_wgt", "gtWgt");
		this.hashFields.put("ug_wgt", "ugWgt");
		this.hashFields.put("spc_ctrl_aloc_pol_rmk", "spcCtrlAlocPolRmk");
		this.hashFields.put("bt_rf", "btRf");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("edit", "edit");
		this.hashFields.put("bk_teu", "bkTeu");
		this.hashFields.put("bt_40", "bt40");
		this.hashFields.put("past", "past");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("bk_53", "bk53");
		this.hashFields.put("mr_45", "mr45");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bt_wgt", "btWgt");
		this.hashFields.put("child_cnt", "childCnt");
		this.hashFields.put("ap_20", "ap20");
		this.hashFields.put("gt_teu", "gtTeu");
		this.hashFields.put("bt_45", "bt45");
		this.hashFields.put("mr_40", "mr40");
		this.hashFields.put("fc_45", "fc45");
		this.hashFields.put("fc_40", "fc40");
		this.hashFields.put("ug_20", "ug20");
		this.hashFields.put("gt_20", "gt20");
		this.hashFields.put("fc_53", "fc53");
		return this.hashFields;
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
	 * @return bk20
	 */
	public String getBk20() {
		return this.bk20;
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
	 * @return gtHc
	 */
	public String getGtHc() {
		return this.gtHc;
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
	 * @return apTeu
	 */
	public String getApTeu() {
		return this.apTeu;
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
	 * @return fcRf
	 */
	public String getFcRf() {
		return this.fcRf;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return ugTeu
	 */
	public String getUgTeu() {
		return this.ugTeu;
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
	 * @return btTeu
	 */
	public String getBtTeu() {
		return this.btTeu;
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
	 * @return baseRhqCd
	 */
	public String getBaseRhqCd() {
		return this.baseRhqCd;
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
	 * @return mrHc
	 */
	public String getMrHc() {
		return this.mrHc;
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
	 * @return fcTtlTeu
	 */
	public String getFcTtlTeu() {
		return this.fcTtlTeu;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @return gt53
	 */
	public String getGt53() {
		return this.gt53;
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
	 * @return ap45
	 */
	public String getAp45() {
		return this.ap45;
	}
	
	/**
	 * Column Info
	 * @return ug40
	 */
	public String getUg40() {
		return this.ug40;
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
	 * @return bt20
	 */
	public String getBt20() {
		return this.bt20;
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
	 * @return cmb
	 */
	public String getCmb() {
		return this.cmb;
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
	 * @return mr20
	 */
	public String getMr20() {
		return this.mr20;
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
	 * @return ug45
	 */
	public String getUg45() {
		return this.ug45;
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
	 * @return fc20
	 */
	public String getFc20() {
		return this.fc20;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @return btHc
	 */
	public String getBtHc() {
		return this.btHc;
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
	 * @return bkRf
	 */
	public String getBkRf() {
		return this.bkRf;
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
	 * @return ap53
	 */
	public String getAp53() {
		return this.ap53;
	}
	
	/**
	 * Column Info
	 * @return gt40
	 */
	public String getGt40() {
		return this.gt40;
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
	 * @return mrWgt
	 */
	public String getMrWgt() {
		return this.mrWgt;
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
	 * @return fcHc
	 */
	public String getFcHc() {
		return this.fcHc;
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
	 * @return bkHc
	 */
	public String getBkHc() {
		return this.bkHc;
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
	 * @return bt53
	 */
	public String getBt53() {
		return this.bt53;
	}
	
	/**
	 * Column Info
	 * @return gtWgt
	 */
	public String getGtWgt() {
		return this.gtWgt;
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
	 * @return spcCtrlAlocPolRmk
	 */
	public String getSpcCtrlAlocPolRmk() {
		return this.spcCtrlAlocPolRmk;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return bkTeu
	 */
	public String getBkTeu() {
		return this.bkTeu;
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
	 * @return bk53
	 */
	public String getBk53() {
		return this.bk53;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return childCnt
	 */
	public String getChildCnt() {
		return this.childCnt;
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
	 * @return gtTeu
	 */
	public String getGtTeu() {
		return this.gtTeu;
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
	 * @return mr40
	 */
	public String getMr40() {
		return this.mr40;
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
	 * @return fc40
	 */
	public String getFc40() {
		return this.fc40;
	}
	
	/**
	 * Column Info
	 * @return ug20
	 */
	public String getUg20() {
		return this.ug20;
	}
	
	/**
	 * Column Info
	 * @return gt20
	 */
	public String getGt20() {
		return this.gt20;
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
	 * @param ugRf
	 */
	public void setUgRf(String ugRf) {
		this.ugRf = ugRf;
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
	 * @param mrTeu
	 */
	public void setMrTeu(String mrTeu) {
		this.mrTeu = mrTeu;
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
	 * @param spcCtrlAlocPodRmk
	 */
	public void setSpcCtrlAlocPodRmk(String spcCtrlAlocPodRmk) {
		this.spcCtrlAlocPodRmk = spcCtrlAlocPodRmk;
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
	 * @param bkWgt
	 */
	public void setBkWgt(String bkWgt) {
		this.bkWgt = bkWgt;
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
	 * @param fcRf
	 */
	public void setFcRf(String fcRf) {
		this.fcRf = fcRf;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param ugTeu
	 */
	public void setUgTeu(String ugTeu) {
		this.ugTeu = ugTeu;
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
	 * @param btTeu
	 */
	public void setBtTeu(String btTeu) {
		this.btTeu = btTeu;
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
	 * @param baseRhqCd
	 */
	public void setBaseRhqCd(String baseRhqCd) {
		this.baseRhqCd = baseRhqCd;
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
	 * @param mrHc
	 */
	public void setMrHc(String mrHc) {
		this.mrHc = mrHc;
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
	 * @param fcTtlTeu
	 */
	public void setFcTtlTeu(String fcTtlTeu) {
		this.fcTtlTeu = fcTtlTeu;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
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
	 * @param gt53
	 */
	public void setGt53(String gt53) {
		this.gt53 = gt53;
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
	 * @param ap45
	 */
	public void setAp45(String ap45) {
		this.ap45 = ap45;
	}
	
	/**
	 * Column Info
	 * @param ug40
	 */
	public void setUg40(String ug40) {
		this.ug40 = ug40;
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
	 * @param bt20
	 */
	public void setBt20(String bt20) {
		this.bt20 = bt20;
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
	 * @param cmb
	 */
	public void setCmb(String cmb) {
		this.cmb = cmb;
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
	 * @param mr20
	 */
	public void setMr20(String mr20) {
		this.mr20 = mr20;
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
	 * @param ug45
	 */
	public void setUg45(String ug45) {
		this.ug45 = ug45;
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
	 * @param fc20
	 */
	public void setFc20(String fc20) {
		this.fc20 = fc20;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
	 * @param btHc
	 */
	public void setBtHc(String btHc) {
		this.btHc = btHc;
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
	 * @param bkRf
	 */
	public void setBkRf(String bkRf) {
		this.bkRf = bkRf;
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
	 * @param ap53
	 */
	public void setAp53(String ap53) {
		this.ap53 = ap53;
	}
	
	/**
	 * Column Info
	 * @param gt40
	 */
	public void setGt40(String gt40) {
		this.gt40 = gt40;
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
	 * @param mrWgt
	 */
	public void setMrWgt(String mrWgt) {
		this.mrWgt = mrWgt;
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
	 * @param fcHc
	 */
	public void setFcHc(String fcHc) {
		this.fcHc = fcHc;
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
	 * @param bkHc
	 */
	public void setBkHc(String bkHc) {
		this.bkHc = bkHc;
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
	 * @param bt53
	 */
	public void setBt53(String bt53) {
		this.bt53 = bt53;
	}
	
	/**
	 * Column Info
	 * @param gtWgt
	 */
	public void setGtWgt(String gtWgt) {
		this.gtWgt = gtWgt;
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
	 * @param spcCtrlAlocPolRmk
	 */
	public void setSpcCtrlAlocPolRmk(String spcCtrlAlocPolRmk) {
		this.spcCtrlAlocPolRmk = spcCtrlAlocPolRmk;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param bkTeu
	 */
	public void setBkTeu(String bkTeu) {
		this.bkTeu = bkTeu;
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
	 * @param bk53
	 */
	public void setBk53(String bk53) {
		this.bk53 = bk53;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param childCnt
	 */
	public void setChildCnt(String childCnt) {
		this.childCnt = childCnt;
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
	 * @param gtTeu
	 */
	public void setGtTeu(String gtTeu) {
		this.gtTeu = gtTeu;
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
	 * @param mr40
	 */
	public void setMr40(String mr40) {
		this.mr40 = mr40;
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
	 * @param fc40
	 */
	public void setFc40(String fc40) {
		this.fc40 = fc40;
	}
	
	/**
	 * Column Info
	 * @param ug20
	 */
	public void setUg20(String ug20) {
		this.ug20 = ug20;
	}
	
	/**
	 * Column Info
	 * @param gt20
	 */
	public void setGt20(String gt20) {
		this.gt20 = gt20;
	}
	
	/**
	 * Column Info
	 * @param fc53
	 */
	public void setFc53(String fc53) {
		this.fc53 = fc53;
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
		setUgRf(JSPUtil.getParameter(request, prefix + "ug_rf", ""));
		setBk20(JSPUtil.getParameter(request, prefix + "bk_20", ""));
		setMrTeu(JSPUtil.getParameter(request, prefix + "mr_teu", ""));
		setGtHc(JSPUtil.getParameter(request, prefix + "gt_hc", ""));
		setSpcCtrlAlocPodRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_pod_rmk", ""));
		setApTeu(JSPUtil.getParameter(request, prefix + "ap_teu", ""));
		setBkWgt(JSPUtil.getParameter(request, prefix + "bk_wgt", ""));
		setMr53(JSPUtil.getParameter(request, prefix + "mr_53", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setFcRf(JSPUtil.getParameter(request, prefix + "fc_rf", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setUg53(JSPUtil.getParameter(request, prefix + "ug_53", ""));
		setUgTeu(JSPUtil.getParameter(request, prefix + "ug_teu", ""));
		setSpcCtrlAlocRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_rmk", ""));
		setBtTeu(JSPUtil.getParameter(request, prefix + "bt_teu", ""));
		setMrRf(JSPUtil.getParameter(request, prefix + "mr_rf", ""));
		setBaseRhqCd(JSPUtil.getParameter(request, prefix + "base_rhq_cd", ""));
		setFcTeu(JSPUtil.getParameter(request, prefix + "fc_teu", ""));
		setMrHc(JSPUtil.getParameter(request, prefix + "mr_hc", ""));
		setPodCnt(JSPUtil.getParameter(request, prefix + "pod_cnt", ""));
		setFcTtlTeu(JSPUtil.getParameter(request, prefix + "fc_ttl_teu", ""));
		setGtRf(JSPUtil.getParameter(request, prefix + "gt_rf", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setApWgt(JSPUtil.getParameter(request, prefix + "ap_wgt", ""));
		setGt53(JSPUtil.getParameter(request, prefix + "gt_53", ""));
		setLeafCnt(JSPUtil.getParameter(request, prefix + "leaf_cnt", ""));
		setAp45(JSPUtil.getParameter(request, prefix + "ap_45", ""));
		setUg40(JSPUtil.getParameter(request, prefix + "ug_40", ""));
		setApHc(JSPUtil.getParameter(request, prefix + "ap_hc", ""));
		setBt20(JSPUtil.getParameter(request, prefix + "bt_20", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCmb(JSPUtil.getParameter(request, prefix + "cmb", ""));
		setUgHc(JSPUtil.getParameter(request, prefix + "ug_hc", ""));
		setMr20(JSPUtil.getParameter(request, prefix + "mr_20", ""));
		setBkgQuota(JSPUtil.getParameter(request, prefix + "bkg_quota", ""));
		setUg45(JSPUtil.getParameter(request, prefix + "ug_45", ""));
		setAp40(JSPUtil.getParameter(request, prefix + "ap_40", ""));
		setFc20(JSPUtil.getParameter(request, prefix + "fc_20", ""));
		setApMd(JSPUtil.getParameter(request, prefix + "ap_md", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setFctCmb(JSPUtil.getParameter(request, prefix + "fct_cmb", ""));
		setBtHc(JSPUtil.getParameter(request, prefix + "bt_hc", ""));
		setBk45(JSPUtil.getParameter(request, prefix + "bk_45", ""));
		setBkRf(JSPUtil.getParameter(request, prefix + "bk_rf", ""));
		setGt45(JSPUtil.getParameter(request, prefix + "gt_45", ""));
		setAp53(JSPUtil.getParameter(request, prefix + "ap_53", ""));
		setGt40(JSPUtil.getParameter(request, prefix + "gt_40", ""));
		setFcWgt(JSPUtil.getParameter(request, prefix + "fc_wgt", ""));
		setMrWgt(JSPUtil.getParameter(request, prefix + "mr_wgt", ""));
		setBk40(JSPUtil.getParameter(request, prefix + "bk_40", ""));
		setFcHc(JSPUtil.getParameter(request, prefix + "fc_hc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkHc(JSPUtil.getParameter(request, prefix + "bk_hc", ""));
		setApRf(JSPUtil.getParameter(request, prefix + "ap_rf", ""));
		setBt53(JSPUtil.getParameter(request, prefix + "bt_53", ""));
		setGtWgt(JSPUtil.getParameter(request, prefix + "gt_wgt", ""));
		setUgWgt(JSPUtil.getParameter(request, prefix + "ug_wgt", ""));
		setSpcCtrlAlocPolRmk(JSPUtil.getParameter(request, prefix + "spc_ctrl_aloc_pol_rmk", ""));
		setBtRf(JSPUtil.getParameter(request, prefix + "bt_rf", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setEdit(JSPUtil.getParameter(request, prefix + "edit", ""));
		setBkTeu(JSPUtil.getParameter(request, prefix + "bk_teu", ""));
		setBt40(JSPUtil.getParameter(request, prefix + "bt_40", ""));
		setPast(JSPUtil.getParameter(request, prefix + "past", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setBk53(JSPUtil.getParameter(request, prefix + "bk_53", ""));
		setMr45(JSPUtil.getParameter(request, prefix + "mr_45", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBtWgt(JSPUtil.getParameter(request, prefix + "bt_wgt", ""));
		setChildCnt(JSPUtil.getParameter(request, prefix + "child_cnt", ""));
		setAp20(JSPUtil.getParameter(request, prefix + "ap_20", ""));
		setGtTeu(JSPUtil.getParameter(request, prefix + "gt_teu", ""));
		setBt45(JSPUtil.getParameter(request, prefix + "bt_45", ""));
		setMr40(JSPUtil.getParameter(request, prefix + "mr_40", ""));
		setFc45(JSPUtil.getParameter(request, prefix + "fc_45", ""));
		setFc40(JSPUtil.getParameter(request, prefix + "fc_40", ""));
		setUg20(JSPUtil.getParameter(request, prefix + "ug_20", ""));
		setGt20(JSPUtil.getParameter(request, prefix + "gt_20", ""));
		setFc53(JSPUtil.getParameter(request, prefix + "fc_53", ""));
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
			String[] ugRf = (JSPUtil.getParameter(request, prefix	+ "ug_rf", length));
			String[] bk20 = (JSPUtil.getParameter(request, prefix	+ "bk_20", length));
			String[] mrTeu = (JSPUtil.getParameter(request, prefix	+ "mr_teu", length));
			String[] gtHc = (JSPUtil.getParameter(request, prefix	+ "gt_hc", length));
			String[] spcCtrlAlocPodRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_pod_rmk", length));
			String[] apTeu = (JSPUtil.getParameter(request, prefix	+ "ap_teu", length));
			String[] bkWgt = (JSPUtil.getParameter(request, prefix	+ "bk_wgt", length));
			String[] mr53 = (JSPUtil.getParameter(request, prefix	+ "mr_53", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] fcRf = (JSPUtil.getParameter(request, prefix	+ "fc_rf", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ug53 = (JSPUtil.getParameter(request, prefix	+ "ug_53", length));
			String[] ugTeu = (JSPUtil.getParameter(request, prefix	+ "ug_teu", length));
			String[] spcCtrlAlocRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_rmk", length));
			String[] btTeu = (JSPUtil.getParameter(request, prefix	+ "bt_teu", length));
			String[] mrRf = (JSPUtil.getParameter(request, prefix	+ "mr_rf", length));
			String[] baseRhqCd = (JSPUtil.getParameter(request, prefix	+ "base_rhq_cd", length));
			String[] fcTeu = (JSPUtil.getParameter(request, prefix	+ "fc_teu", length));
			String[] mrHc = (JSPUtil.getParameter(request, prefix	+ "mr_hc", length));
			String[] podCnt = (JSPUtil.getParameter(request, prefix	+ "pod_cnt", length));
			String[] fcTtlTeu = (JSPUtil.getParameter(request, prefix	+ "fc_ttl_teu", length));
			String[] gtRf = (JSPUtil.getParameter(request, prefix	+ "gt_rf", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] apWgt = (JSPUtil.getParameter(request, prefix	+ "ap_wgt", length));
			String[] gt53 = (JSPUtil.getParameter(request, prefix	+ "gt_53", length));
			String[] leafCnt = (JSPUtil.getParameter(request, prefix	+ "leaf_cnt", length));
			String[] ap45 = (JSPUtil.getParameter(request, prefix	+ "ap_45", length));
			String[] ug40 = (JSPUtil.getParameter(request, prefix	+ "ug_40", length));
			String[] apHc = (JSPUtil.getParameter(request, prefix	+ "ap_hc", length));
			String[] bt20 = (JSPUtil.getParameter(request, prefix	+ "bt_20", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cmb = (JSPUtil.getParameter(request, prefix	+ "cmb", length));
			String[] ugHc = (JSPUtil.getParameter(request, prefix	+ "ug_hc", length));
			String[] mr20 = (JSPUtil.getParameter(request, prefix	+ "mr_20", length));
			String[] bkgQuota = (JSPUtil.getParameter(request, prefix	+ "bkg_quota", length));
			String[] ug45 = (JSPUtil.getParameter(request, prefix	+ "ug_45", length));
			String[] ap40 = (JSPUtil.getParameter(request, prefix	+ "ap_40", length));
			String[] fc20 = (JSPUtil.getParameter(request, prefix	+ "fc_20", length));
			String[] apMd = (JSPUtil.getParameter(request, prefix	+ "ap_md", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] fctCmb = (JSPUtil.getParameter(request, prefix	+ "fct_cmb", length));
			String[] btHc = (JSPUtil.getParameter(request, prefix	+ "bt_hc", length));
			String[] bk45 = (JSPUtil.getParameter(request, prefix	+ "bk_45", length));
			String[] bkRf = (JSPUtil.getParameter(request, prefix	+ "bk_rf", length));
			String[] gt45 = (JSPUtil.getParameter(request, prefix	+ "gt_45", length));
			String[] ap53 = (JSPUtil.getParameter(request, prefix	+ "ap_53", length));
			String[] gt40 = (JSPUtil.getParameter(request, prefix	+ "gt_40", length));
			String[] fcWgt = (JSPUtil.getParameter(request, prefix	+ "fc_wgt", length));
			String[] mrWgt = (JSPUtil.getParameter(request, prefix	+ "mr_wgt", length));
			String[] bk40 = (JSPUtil.getParameter(request, prefix	+ "bk_40", length));
			String[] fcHc = (JSPUtil.getParameter(request, prefix	+ "fc_hc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkHc = (JSPUtil.getParameter(request, prefix	+ "bk_hc", length));
			String[] apRf = (JSPUtil.getParameter(request, prefix	+ "ap_rf", length));
			String[] bt53 = (JSPUtil.getParameter(request, prefix	+ "bt_53", length));
			String[] gtWgt = (JSPUtil.getParameter(request, prefix	+ "gt_wgt", length));
			String[] ugWgt = (JSPUtil.getParameter(request, prefix	+ "ug_wgt", length));
			String[] spcCtrlAlocPolRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_pol_rmk", length));
			String[] btRf = (JSPUtil.getParameter(request, prefix	+ "bt_rf", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] edit = (JSPUtil.getParameter(request, prefix	+ "edit", length));
			String[] bkTeu = (JSPUtil.getParameter(request, prefix	+ "bk_teu", length));
			String[] bt40 = (JSPUtil.getParameter(request, prefix	+ "bt_40", length));
			String[] past = (JSPUtil.getParameter(request, prefix	+ "past", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] bk53 = (JSPUtil.getParameter(request, prefix	+ "bk_53", length));
			String[] mr45 = (JSPUtil.getParameter(request, prefix	+ "mr_45", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] btWgt = (JSPUtil.getParameter(request, prefix	+ "bt_wgt", length));
			String[] childCnt = (JSPUtil.getParameter(request, prefix	+ "child_cnt", length));
			String[] ap20 = (JSPUtil.getParameter(request, prefix	+ "ap_20", length));
			String[] gtTeu = (JSPUtil.getParameter(request, prefix	+ "gt_teu", length));
			String[] bt45 = (JSPUtil.getParameter(request, prefix	+ "bt_45", length));
			String[] mr40 = (JSPUtil.getParameter(request, prefix	+ "mr_40", length));
			String[] fc45 = (JSPUtil.getParameter(request, prefix	+ "fc_45", length));
			String[] fc40 = (JSPUtil.getParameter(request, prefix	+ "fc_40", length));
			String[] ug20 = (JSPUtil.getParameter(request, prefix	+ "ug_20", length));
			String[] gt20 = (JSPUtil.getParameter(request, prefix	+ "gt_20", length));
			String[] fc53 = (JSPUtil.getParameter(request, prefix	+ "fc_53", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocation0047DetailListVO();
				if (ugRf[i] != null)
					model.setUgRf(ugRf[i]);
				if (bk20[i] != null)
					model.setBk20(bk20[i]);
				if (mrTeu[i] != null)
					model.setMrTeu(mrTeu[i]);
				if (gtHc[i] != null)
					model.setGtHc(gtHc[i]);
				if (spcCtrlAlocPodRmk[i] != null)
					model.setSpcCtrlAlocPodRmk(spcCtrlAlocPodRmk[i]);
				if (apTeu[i] != null)
					model.setApTeu(apTeu[i]);
				if (bkWgt[i] != null)
					model.setBkWgt(bkWgt[i]);
				if (mr53[i] != null)
					model.setMr53(mr53[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (fcRf[i] != null)
					model.setFcRf(fcRf[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ug53[i] != null)
					model.setUg53(ug53[i]);
				if (ugTeu[i] != null)
					model.setUgTeu(ugTeu[i]);
				if (spcCtrlAlocRmk[i] != null)
					model.setSpcCtrlAlocRmk(spcCtrlAlocRmk[i]);
				if (btTeu[i] != null)
					model.setBtTeu(btTeu[i]);
				if (mrRf[i] != null)
					model.setMrRf(mrRf[i]);
				if (baseRhqCd[i] != null)
					model.setBaseRhqCd(baseRhqCd[i]);
				if (fcTeu[i] != null)
					model.setFcTeu(fcTeu[i]);
				if (mrHc[i] != null)
					model.setMrHc(mrHc[i]);
				if (podCnt[i] != null)
					model.setPodCnt(podCnt[i]);
				if (fcTtlTeu[i] != null)
					model.setFcTtlTeu(fcTtlTeu[i]);
				if (gtRf[i] != null)
					model.setGtRf(gtRf[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (apWgt[i] != null)
					model.setApWgt(apWgt[i]);
				if (gt53[i] != null)
					model.setGt53(gt53[i]);
				if (leafCnt[i] != null)
					model.setLeafCnt(leafCnt[i]);
				if (ap45[i] != null)
					model.setAp45(ap45[i]);
				if (ug40[i] != null)
					model.setUg40(ug40[i]);
				if (apHc[i] != null)
					model.setApHc(apHc[i]);
				if (bt20[i] != null)
					model.setBt20(bt20[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cmb[i] != null)
					model.setCmb(cmb[i]);
				if (ugHc[i] != null)
					model.setUgHc(ugHc[i]);
				if (mr20[i] != null)
					model.setMr20(mr20[i]);
				if (bkgQuota[i] != null)
					model.setBkgQuota(bkgQuota[i]);
				if (ug45[i] != null)
					model.setUg45(ug45[i]);
				if (ap40[i] != null)
					model.setAp40(ap40[i]);
				if (fc20[i] != null)
					model.setFc20(fc20[i]);
				if (apMd[i] != null)
					model.setApMd(apMd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (fctCmb[i] != null)
					model.setFctCmb(fctCmb[i]);
				if (btHc[i] != null)
					model.setBtHc(btHc[i]);
				if (bk45[i] != null)
					model.setBk45(bk45[i]);
				if (bkRf[i] != null)
					model.setBkRf(bkRf[i]);
				if (gt45[i] != null)
					model.setGt45(gt45[i]);
				if (ap53[i] != null)
					model.setAp53(ap53[i]);
				if (gt40[i] != null)
					model.setGt40(gt40[i]);
				if (fcWgt[i] != null)
					model.setFcWgt(fcWgt[i]);
				if (mrWgt[i] != null)
					model.setMrWgt(mrWgt[i]);
				if (bk40[i] != null)
					model.setBk40(bk40[i]);
				if (fcHc[i] != null)
					model.setFcHc(fcHc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkHc[i] != null)
					model.setBkHc(bkHc[i]);
				if (apRf[i] != null)
					model.setApRf(apRf[i]);
				if (bt53[i] != null)
					model.setBt53(bt53[i]);
				if (gtWgt[i] != null)
					model.setGtWgt(gtWgt[i]);
				if (ugWgt[i] != null)
					model.setUgWgt(ugWgt[i]);
				if (spcCtrlAlocPolRmk[i] != null)
					model.setSpcCtrlAlocPolRmk(spcCtrlAlocPolRmk[i]);
				if (btRf[i] != null)
					model.setBtRf(btRf[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (edit[i] != null)
					model.setEdit(edit[i]);
				if (bkTeu[i] != null)
					model.setBkTeu(bkTeu[i]);
				if (bt40[i] != null)
					model.setBt40(bt40[i]);
				if (past[i] != null)
					model.setPast(past[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (bk53[i] != null)
					model.setBk53(bk53[i]);
				if (mr45[i] != null)
					model.setMr45(mr45[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (btWgt[i] != null)
					model.setBtWgt(btWgt[i]);
				if (childCnt[i] != null)
					model.setChildCnt(childCnt[i]);
				if (ap20[i] != null)
					model.setAp20(ap20[i]);
				if (gtTeu[i] != null)
					model.setGtTeu(gtTeu[i]);
				if (bt45[i] != null)
					model.setBt45(bt45[i]);
				if (mr40[i] != null)
					model.setMr40(mr40[i]);
				if (fc45[i] != null)
					model.setFc45(fc45[i]);
				if (fc40[i] != null)
					model.setFc40(fc40[i]);
				if (ug20[i] != null)
					model.setUg20(ug20[i]);
				if (gt20[i] != null)
					model.setGt20(gt20[i]);
				if (fc53[i] != null)
					model.setFc53(fc53[i]);
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
		this.ugRf = this.ugRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk20 = this.bk20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrTeu = this.mrTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtHc = this.gtHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocPodRmk = this.spcCtrlAlocPodRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apTeu = this.apTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkWgt = this.bkWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mr53 = this.mr53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcRf = this.fcRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ug53 = this.ug53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ugTeu = this.ugTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocRmk = this.spcCtrlAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btTeu = this.btTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrRf = this.mrRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.baseRhqCd = this.baseRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTeu = this.fcTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrHc = this.mrHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCnt = this.podCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTtlTeu = this.fcTtlTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtRf = this.gtRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apWgt = this.apWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gt53 = this.gt53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leafCnt = this.leafCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap45 = this.ap45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ug40 = this.ug40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apHc = this.apHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt20 = this.bt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb = this.cmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ugHc = this.ugHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mr20 = this.mr20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQuota = this.bkgQuota .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ug45 = this.ug45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap40 = this.ap40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc20 = this.fc20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apMd = this.apMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctCmb = this.fctCmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btHc = this.btHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk45 = this.bk45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkRf = this.bkRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gt45 = this.gt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap53 = this.ap53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gt40 = this.gt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcWgt = this.fcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrWgt = this.mrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk40 = this.bk40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcHc = this.fcHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkHc = this.bkHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRf = this.apRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt53 = this.bt53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtWgt = this.gtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ugWgt = this.ugWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocPolRmk = this.spcCtrlAlocPolRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btRf = this.btRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edit = this.edit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkTeu = this.bkTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt40 = this.bt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.past = this.past .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bk53 = this.bk53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mr45 = this.mr45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btWgt = this.btWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.childCnt = this.childCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ap20 = this.ap20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gtTeu = this.gtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bt45 = this.bt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mr40 = this.mr40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc45 = this.fc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc40 = this.fc40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ug20 = this.ug20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gt20 = this.gt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fc53 = this.fc53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
