/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SaelsPerformanceReportInVO.java
*@FileTitle : SaelsPerformanceReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.21 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SaelsPerformanceReportInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaelsPerformanceReportInVO> models = new ArrayList<SaelsPerformanceReportInVO>();
	
	/* Column Info */
	private String vvdSig = null;
	/* Column Info */
	private String destRoutCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cuntractNo = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String vvdIdx = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String orgCnt = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String destCnt = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String ctrtSrepCd = null;
	/* Column Info */
	private String grpCol = null;
	/* Column Info */
	private String orgRoutCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String grpCon = null;
	/* Column Info */
	private String grpBy = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String opTo = null;
	/* Column Info */
	private String opFrom = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String bkgOfcSub = null;
	/* Column Info */
	private String obSlsOfcSub = null;
	/* Column Info */
	private String orgSvcModCd = null;
	/* Column Info */
	private String ibSlsOfcSub = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String destInlndSvcModCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String cuntractTp = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String ibSlsOfcCd = null;
	/* Column Info */
	private String loadView = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String repKnd = null;
	/* Column Info */
	private String rOption = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String repCmdtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SaelsPerformanceReportInVO() {}

	public SaelsPerformanceReportInVO(String ibflag, String pagerows, String vvd, String vvdSig, String vslCd, String skdVoyNo, String skdDirCd, String slanCd, String vvdIdx, String bkgCgoTpCd, String bkgCustTpCd, String custCntCd, String custSeq, String custNm, String cuntractTp, String cuntractNo, String polCd, String podCd, String porCd, String delCd, String repCmdtCd, String cmdtCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String loadView, String blTpCd, String bkgOfcCd, String bkgOfcSub, String obSlsOfcCd, String obSlsOfcSub, String obSrepCd, String ctrtOfcCd, String ctrtSrepCd, String ibSlsOfcCd, String ibSlsOfcSub, String orgRoutCd, String destRoutCd, String orgSvcModCd, String destInlndSvcModCd, String orgCnt, String destCnt, String repKnd, String grpBy, String grpCol, String grpCon, String frtTermCd, String iocCd, String rOption, String opFrom, String opTo, String custCd) {
		this.vvdSig = vvdSig;
		this.destRoutCd = destRoutCd;
		this.vslCd = vslCd;
		this.cuntractNo = cuntractNo;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.vvdIdx = vvdIdx;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.polCd = polCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custCntCd = custCntCd;
		this.orgCnt = orgCnt;
		this.bkgOfcCd = bkgOfcCd;
		this.awkCgoFlg = awkCgoFlg;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.podCd = podCd;
		this.vvd = vvd;
		this.destCnt = destCnt;
		this.custCd = custCd;
		this.ctrtSrepCd = ctrtSrepCd;
		this.grpCol = grpCol;
		this.orgRoutCd = orgRoutCd;
		this.rcFlg = rcFlg;
		this.grpCon = grpCon;
		this.grpBy = grpBy;
		this.porCd = porCd;
		this.opTo = opTo;
		this.opFrom = opFrom;
		this.custNm = custNm;
		this.rdCgoFlg = rdCgoFlg;
		this.bkgOfcSub = bkgOfcSub;
		this.obSlsOfcSub = obSlsOfcSub;
		this.orgSvcModCd = orgSvcModCd;
		this.ibSlsOfcSub = ibSlsOfcSub;
		this.ibflag = ibflag;
		this.destInlndSvcModCd = destInlndSvcModCd;
		this.cmdtCd = cmdtCd;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.cuntractTp = cuntractTp;
		this.iocCd = iocCd;
		this.ibSlsOfcCd = ibSlsOfcCd;
		this.loadView = loadView;
		this.custSeq = custSeq;
		this.repKnd = repKnd;
		this.rOption = rOption;
		this.skdDirCd = skdDirCd;
		this.blTpCd = blTpCd;
		this.slanCd = slanCd;
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd_sig", getVvdSig());
		this.hashColumns.put("dest_rout_cd", getDestRoutCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cuntract_no", getCuntractNo());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("vvd_idx", getVvdIdx());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("org_cnt", getOrgCnt());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("dest_cnt", getDestCnt());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("ctrt_srep_cd", getCtrtSrepCd());
		this.hashColumns.put("grp_col", getGrpCol());
		this.hashColumns.put("org_rout_cd", getOrgRoutCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("grp_con", getGrpCon());
		this.hashColumns.put("grp_by", getGrpBy());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("op_to", getOpTo());
		this.hashColumns.put("op_from", getOpFrom());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("bkg_ofc_sub", getBkgOfcSub());
		this.hashColumns.put("ob_sls_ofc_sub", getObSlsOfcSub());
		this.hashColumns.put("org_svc_mod_cd", getOrgSvcModCd());
		this.hashColumns.put("ib_sls_ofc_sub", getIbSlsOfcSub());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest_inlnd_svc_mod_cd", getDestInlndSvcModCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("cuntract_tp", getCuntractTp());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("ib_sls_ofc_cd", getIbSlsOfcCd());
		this.hashColumns.put("load_view", getLoadView());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("rep_knd", getRepKnd());
		this.hashColumns.put("r_option", getROption());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd_sig", "vvdSig");
		this.hashFields.put("dest_rout_cd", "destRoutCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cuntract_no", "cuntractNo");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("vvd_idx", "vvdIdx");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("org_cnt", "orgCnt");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("dest_cnt", "destCnt");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("ctrt_srep_cd", "ctrtSrepCd");
		this.hashFields.put("grp_col", "grpCol");
		this.hashFields.put("org_rout_cd", "orgRoutCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("grp_con", "grpCon");
		this.hashFields.put("grp_by", "grpBy");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("op_to", "opTo");
		this.hashFields.put("op_from", "opFrom");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("bkg_ofc_sub", "bkgOfcSub");
		this.hashFields.put("ob_sls_ofc_sub", "obSlsOfcSub");
		this.hashFields.put("org_svc_mod_cd", "orgSvcModCd");
		this.hashFields.put("ib_sls_ofc_sub", "ibSlsOfcSub");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest_inlnd_svc_mod_cd", "destInlndSvcModCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("cuntract_tp", "cuntractTp");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("ib_sls_ofc_cd", "ibSlsOfcCd");
		this.hashFields.put("load_view", "loadView");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("rep_knd", "repKnd");
		this.hashFields.put("r_option", "rOption");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvdSig
	 */
	public String getVvdSig() {
		return this.vvdSig;
	}
	
	/**
	 * Column Info
	 * @return destRoutCd
	 */
	public String getDestRoutCd() {
		return this.destRoutCd;
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
	 * @return cuntractNo
	 */
	public String getCuntractNo() {
		return this.cuntractNo;
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
	 * @return vvdIdx
	 */
	public String getVvdIdx() {
		return this.vvdIdx;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
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
	 * @return orgCnt
	 */
	public String getOrgCnt() {
		return this.orgCnt;
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
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return destCnt
	 */
	public String getDestCnt() {
		return this.destCnt;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtSrepCd
	 */
	public String getCtrtSrepCd() {
		return this.ctrtSrepCd;
	}
	
	/**
	 * Column Info
	 * @return grpCol
	 */
	public String getGrpCol() {
		return this.grpCol;
	}
	
	/**
	 * Column Info
	 * @return orgRoutCd
	 */
	public String getOrgRoutCd() {
		return this.orgRoutCd;
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
	 * @return grpCon
	 */
	public String getGrpCon() {
		return this.grpCon;
	}
	
	/**
	 * Column Info
	 * @return grpBy
	 */
	public String getGrpBy() {
		return this.grpBy;
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
	 * @return opTo
	 */
	public String getOpTo() {
		return this.opTo;
	}
	
	/**
	 * Column Info
	 * @return opFrom
	 */
	public String getOpFrom() {
		return this.opFrom;
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
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcSub
	 */
	public String getBkgOfcSub() {
		return this.bkgOfcSub;
	}
	
	/**
	 * Column Info
	 * @return obSlsOfcSub
	 */
	public String getObSlsOfcSub() {
		return this.obSlsOfcSub;
	}
	
	/**
	 * Column Info
	 * @return orgSvcModCd
	 */
	public String getOrgSvcModCd() {
		return this.orgSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return ibSlsOfcSub
	 */
	public String getIbSlsOfcSub() {
		return this.ibSlsOfcSub;
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
	 * @return destInlndSvcModCd
	 */
	public String getDestInlndSvcModCd() {
		return this.destInlndSvcModCd;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cuntractTp
	 */
	public String getCuntractTp() {
		return this.cuntractTp;
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
	 * @return ibSlsOfcCd
	 */
	public String getIbSlsOfcCd() {
		return this.ibSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return loadView
	 */
	public String getLoadView() {
		return this.loadView;
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
	 * @return repKnd
	 */
	public String getRepKnd() {
		return this.repKnd;
	}
	
	/**
	 * Column Info
	 * @return rOption
	 */
	public String getROption() {
		return this.rOption;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @param vvdSig
	 */
	public void setVvdSig(String vvdSig) {
		this.vvdSig = vvdSig;
	}
	
	/**
	 * Column Info
	 * @param destRoutCd
	 */
	public void setDestRoutCd(String destRoutCd) {
		this.destRoutCd = destRoutCd;
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
	 * @param cuntractNo
	 */
	public void setCuntractNo(String cuntractNo) {
		this.cuntractNo = cuntractNo;
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
	 * @param vvdIdx
	 */
	public void setVvdIdx(String vvdIdx) {
		this.vvdIdx = vvdIdx;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
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
	 * @param orgCnt
	 */
	public void setOrgCnt(String orgCnt) {
		this.orgCnt = orgCnt;
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
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param destCnt
	 */
	public void setDestCnt(String destCnt) {
		this.destCnt = destCnt;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtSrepCd
	 */
	public void setCtrtSrepCd(String ctrtSrepCd) {
		this.ctrtSrepCd = ctrtSrepCd;
	}
	
	/**
	 * Column Info
	 * @param grpCol
	 */
	public void setGrpCol(String grpCol) {
		this.grpCol = grpCol;
	}
	
	/**
	 * Column Info
	 * @param orgRoutCd
	 */
	public void setOrgRoutCd(String orgRoutCd) {
		this.orgRoutCd = orgRoutCd;
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
	 * @param grpCon
	 */
	public void setGrpCon(String grpCon) {
		this.grpCon = grpCon;
	}
	
	/**
	 * Column Info
	 * @param grpBy
	 */
	public void setGrpBy(String grpBy) {
		this.grpBy = grpBy;
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
	 * @param opTo
	 */
	public void setOpTo(String opTo) {
		this.opTo = opTo;
	}
	
	/**
	 * Column Info
	 * @param opFrom
	 */
	public void setOpFrom(String opFrom) {
		this.opFrom = opFrom;
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
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcSub
	 */
	public void setBkgOfcSub(String bkgOfcSub) {
		this.bkgOfcSub = bkgOfcSub;
	}
	
	/**
	 * Column Info
	 * @param obSlsOfcSub
	 */
	public void setObSlsOfcSub(String obSlsOfcSub) {
		this.obSlsOfcSub = obSlsOfcSub;
	}
	
	/**
	 * Column Info
	 * @param orgSvcModCd
	 */
	public void setOrgSvcModCd(String orgSvcModCd) {
		this.orgSvcModCd = orgSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param ibSlsOfcSub
	 */
	public void setIbSlsOfcSub(String ibSlsOfcSub) {
		this.ibSlsOfcSub = ibSlsOfcSub;
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
	 * @param destInlndSvcModCd
	 */
	public void setDestInlndSvcModCd(String destInlndSvcModCd) {
		this.destInlndSvcModCd = destInlndSvcModCd;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cuntractTp
	 */
	public void setCuntractTp(String cuntractTp) {
		this.cuntractTp = cuntractTp;
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
	 * @param ibSlsOfcCd
	 */
	public void setIbSlsOfcCd(String ibSlsOfcCd) {
		this.ibSlsOfcCd = ibSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param loadView
	 */
	public void setLoadView(String loadView) {
		this.loadView = loadView;
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
	 * @param repKnd
	 */
	public void setRepKnd(String repKnd) {
		this.repKnd = repKnd;
	}
	
	/**
	 * Column Info
	 * @param rOption
	 */
	public void setROption(String rOption) {
		this.rOption = rOption;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvdSig(JSPUtil.getParameter(request, "vvd_sig", ""));
		setDestRoutCd(JSPUtil.getParameter(request, "dest_rout_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCuntractNo(JSPUtil.getParameter(request, "cuntract_no", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setVvdIdx(JSPUtil.getParameter(request, "vvd_idx", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, "ctrt_ofc_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setOrgCnt(JSPUtil.getParameter(request, "org_cnt", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setDestCnt(JSPUtil.getParameter(request, "dest_cnt", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCtrtSrepCd(JSPUtil.getParameter(request, "ctrt_srep_cd", ""));
		setGrpCol(JSPUtil.getParameter(request, "grp_col", ""));
		setOrgRoutCd(JSPUtil.getParameter(request, "org_rout_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setGrpCon(JSPUtil.getParameter(request, "grp_con", ""));
		setGrpBy(JSPUtil.getParameter(request, "grp_by", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setOpTo(JSPUtil.getParameter(request, "op_to", ""));
		setOpFrom(JSPUtil.getParameter(request, "op_from", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setBkgOfcSub(JSPUtil.getParameter(request, "bkg_ofc_sub", ""));
		setObSlsOfcSub(JSPUtil.getParameter(request, "ob_sls_ofc_sub", ""));
		setOrgSvcModCd(JSPUtil.getParameter(request, "org_svc_mod_cd", ""));
		setIbSlsOfcSub(JSPUtil.getParameter(request, "ib_sls_ofc_sub", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDestInlndSvcModCd(JSPUtil.getParameter(request, "dest_inlnd_svc_mod_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setCuntractTp(JSPUtil.getParameter(request, "cuntract_tp", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setIbSlsOfcCd(JSPUtil.getParameter(request, "ib_sls_ofc_cd", ""));
		setLoadView(JSPUtil.getParameter(request, "load_view", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setRepKnd(JSPUtil.getParameter(request, "rep_knd", ""));
		setROption(JSPUtil.getParameter(request, "r_option", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaelsPerformanceReportInVO[]
	 */
	public SaelsPerformanceReportInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaelsPerformanceReportInVO[]
	 */
	public SaelsPerformanceReportInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaelsPerformanceReportInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvdSig = (JSPUtil.getParameter(request, prefix	+ "vvd_sig", length));
			String[] destRoutCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cuntractNo = (JSPUtil.getParameter(request, prefix	+ "cuntract_no", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] vvdIdx = (JSPUtil.getParameter(request, prefix	+ "vvd_idx", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] orgCnt = (JSPUtil.getParameter(request, prefix	+ "org_cnt", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] destCnt = (JSPUtil.getParameter(request, prefix	+ "dest_cnt", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] ctrtSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_srep_cd", length));
			String[] grpCol = (JSPUtil.getParameter(request, prefix	+ "grp_col", length));
			String[] orgRoutCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] grpCon = (JSPUtil.getParameter(request, prefix	+ "grp_con", length));
			String[] grpBy = (JSPUtil.getParameter(request, prefix	+ "grp_by", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] opTo = (JSPUtil.getParameter(request, prefix	+ "op_to", length));
			String[] opFrom = (JSPUtil.getParameter(request, prefix	+ "op_from", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] bkgOfcSub = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_sub", length));
			String[] obSlsOfcSub = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_sub", length));
			String[] orgSvcModCd = (JSPUtil.getParameter(request, prefix	+ "org_svc_mod_cd", length));
			String[] ibSlsOfcSub = (JSPUtil.getParameter(request, prefix	+ "ib_sls_ofc_sub", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] destInlndSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_inlnd_svc_mod_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] cuntractTp = (JSPUtil.getParameter(request, prefix	+ "cuntract_tp", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] ibSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ib_sls_ofc_cd", length));
			String[] loadView = (JSPUtil.getParameter(request, prefix	+ "load_view", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] repKnd = (JSPUtil.getParameter(request, prefix	+ "rep_knd", length));
			String[] rOption = (JSPUtil.getParameter(request, prefix	+ "r_option", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaelsPerformanceReportInVO();
				if (vvdSig[i] != null)
					model.setVvdSig(vvdSig[i]);
				if (destRoutCd[i] != null)
					model.setDestRoutCd(destRoutCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cuntractNo[i] != null)
					model.setCuntractNo(cuntractNo[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (vvdIdx[i] != null)
					model.setVvdIdx(vvdIdx[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (orgCnt[i] != null)
					model.setOrgCnt(orgCnt[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (destCnt[i] != null)
					model.setDestCnt(destCnt[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (ctrtSrepCd[i] != null)
					model.setCtrtSrepCd(ctrtSrepCd[i]);
				if (grpCol[i] != null)
					model.setGrpCol(grpCol[i]);
				if (orgRoutCd[i] != null)
					model.setOrgRoutCd(orgRoutCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (grpCon[i] != null)
					model.setGrpCon(grpCon[i]);
				if (grpBy[i] != null)
					model.setGrpBy(grpBy[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (opTo[i] != null)
					model.setOpTo(opTo[i]);
				if (opFrom[i] != null)
					model.setOpFrom(opFrom[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (bkgOfcSub[i] != null)
					model.setBkgOfcSub(bkgOfcSub[i]);
				if (obSlsOfcSub[i] != null)
					model.setObSlsOfcSub(obSlsOfcSub[i]);
				if (orgSvcModCd[i] != null)
					model.setOrgSvcModCd(orgSvcModCd[i]);
				if (ibSlsOfcSub[i] != null)
					model.setIbSlsOfcSub(ibSlsOfcSub[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (destInlndSvcModCd[i] != null)
					model.setDestInlndSvcModCd(destInlndSvcModCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (cuntractTp[i] != null)
					model.setCuntractTp(cuntractTp[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (ibSlsOfcCd[i] != null)
					model.setIbSlsOfcCd(ibSlsOfcCd[i]);
				if (loadView[i] != null)
					model.setLoadView(loadView[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (repKnd[i] != null)
					model.setRepKnd(repKnd[i]);
				if (rOption[i] != null)
					model.setROption(rOption[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaelsPerformanceReportInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaelsPerformanceReportInVO[]
	 */
	public SaelsPerformanceReportInVO[] getSaelsPerformanceReportInVOs(){
		SaelsPerformanceReportInVO[] vos = (SaelsPerformanceReportInVO[])models.toArray(new SaelsPerformanceReportInVO[models.size()]);
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
		this.vvdSig = this.vvdSig .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutCd = this.destRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cuntractNo = this.cuntractNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdIdx = this.vvdIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCnt = this.orgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCnt = this.destCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrepCd = this.ctrtSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCol = this.grpCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutCd = this.orgRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCon = this.grpCon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpBy = this.grpBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opTo = this.opTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opFrom = this.opFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcSub = this.bkgOfcSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcSub = this.obSlsOfcSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSvcModCd = this.orgSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSlsOfcSub = this.ibSlsOfcSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destInlndSvcModCd = this.destInlndSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cuntractTp = this.cuntractTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibSlsOfcCd = this.ibSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadView = this.loadView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repKnd = this.repKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rOption = this.rOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
