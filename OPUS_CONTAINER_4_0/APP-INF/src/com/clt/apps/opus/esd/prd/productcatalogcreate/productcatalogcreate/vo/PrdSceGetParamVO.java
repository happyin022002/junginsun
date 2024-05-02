/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : PrdSceGetParamVO.java
 *@FileTitle : PrdSceGetParamVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.05.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2010.05.27  
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdSceGetParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PrdSceGetParamVO> models = new ArrayList<PrdSceGetParamVO>();

	/* Column Info */
	private String ibTrspMode = null;
	/* Column Info */
	private String mtRtn = null;
	/* Column Info */
	private String inBound = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String polT = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String cct = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String podT = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String n2PodClptSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String manualFlag = null;
	/* Column Info */
	private String n1PodClptSeq = null;
	/* Column Info */
	private String n4PolClptSeq = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String pod1 = null;
	/* Column Info */
	private String pod4 = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String pod3 = null;
	/* Column Info */
	private String newPod = null;
	/* Column Info */
	private String mtPu = null;
	/* Column Info */
	private String obInclShtlSoFlg = null;
	/* Column Info */
	private String outBound = null;
	/* Column Info */
	private String newPol = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String orgLocCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Column Info */
	private String n3PolClptSeq = null;
	/* Column Info */
	private String ocnBound = null;
	/* Column Info */
	private String n2PolClptSeq = null;
	/* Column Info */
	private String eurCheck = null;
	/* Column Info */
	private String n3PodClptSeq = null;
	/* Column Info */
	private String obTroFlg = null;
	/* Column Info */
	private String obTrspMode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n1PolClptSeq = null;
	/* Column Info */
	private String fullPkupYdCd = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String lane4 = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String ocnSeq = null;
	/* Column Info */
	private String lane2 = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String lane3 = null;
	/* Column Info */
	private String lane1 = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String n4PodClptSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ibTroFlg = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String ibInclShtlSoFlg = null;
	/* Column Info */
	private String skipActValFlg = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PrdSceGetParamVO() {
	}

	public PrdSceGetParamVO(String ibflag, String pagerows, String copNo, String cntrNo, String cntrTpszCd, String pctlNo, String obTroFlg, String ibTroFlg, String porNodCd, String polYdCd,
			String newPol, String newPod, String eurCheck, String manualFlag, String skipActValFlg, String porCd, String polCd, String podCd, String delCd, String obTrspMode, String ibTrspMode,
			String delNodCd, String fullRtnYdCd, String fullPkupYdCd, String rcvTermCd, String deTermCd, String mtPu, String mtRtn, String ioBndCd, String obInclShtlSoFlg, String ibInclShtlSoFlg,
			String routOrgNodCd, String routDestNodCd, String routSeq, String cct, String polT, String podT, String outBound, String inBound, String ocnBound, String tVvd, String orgLocCd,
			String destLocCd, String ocnSeq, String vvd1, String pol1, String pod1, String lane1, String vvd2, String pol2, String pod2, String lane2, String vvd3, String pol3, String pod3,
			String lane3, String vvd4, String pol4, String pod4, String lane4, String n1PolClptSeq, String n1PodClptSeq, String n2PolClptSeq, String n2PodClptSeq, String n3PolClptSeq,
			String n3PodClptSeq, String n4PolClptSeq, String n4PodClptSeq) {
		this.ibTrspMode = ibTrspMode;
		this.mtRtn = mtRtn;
		this.inBound = inBound;
		this.copNo = copNo;
		this.polT = polT;
		this.routOrgNodCd = routOrgNodCd;
		this.cct = cct;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.podT = podT;
		this.polCd = polCd;
		this.tVvd = tVvd;
		this.n2PodClptSeq = n2PodClptSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.delNodCd = delNodCd;
		this.manualFlag = manualFlag;
		this.n1PodClptSeq = n1PodClptSeq;
		this.n4PolClptSeq = n4PolClptSeq;
		this.pol4 = pol4;
		this.delCd = delCd;
		this.pol3 = pol3;
		this.pol2 = pol2;
		this.pol1 = pol1;
		this.fullRtnYdCd = fullRtnYdCd;
		this.vvd2 = vvd2;
		this.vvd3 = vvd3;
		this.routSeq = routSeq;
		this.vvd1 = vvd1;
		this.pod2 = pod2;
		this.podCd = podCd;
		this.pod1 = pod1;
		this.pod4 = pod4;
		this.vvd4 = vvd4;
		this.pod3 = pod3;
		this.newPod = newPod;
		this.mtPu = mtPu;
		this.obInclShtlSoFlg = obInclShtlSoFlg;
		this.outBound = outBound;
		this.newPol = newPol;
		this.porCd = porCd;
		this.orgLocCd = orgLocCd;
		this.destLocCd = destLocCd;
		this.n3PolClptSeq = n3PolClptSeq;
		this.ocnBound = ocnBound;
		this.n2PolClptSeq = n2PolClptSeq;
		this.eurCheck = eurCheck;
		this.n3PodClptSeq = n3PodClptSeq;
		this.obTroFlg = obTroFlg;
		this.obTrspMode = obTrspMode;
		this.ibflag = ibflag;
		this.n1PolClptSeq = n1PolClptSeq;
		this.fullPkupYdCd = fullPkupYdCd;
		this.routDestNodCd = routDestNodCd;
		this.rcvTermCd = rcvTermCd;
		this.lane4 = lane4;
		this.porNodCd = porNodCd;
		this.ocnSeq = ocnSeq;
		this.lane2 = lane2;
		this.ioBndCd = ioBndCd;
		this.lane3 = lane3;
		this.lane1 = lane1;
		this.deTermCd = deTermCd;
		this.n4PodClptSeq = n4PodClptSeq;
		this.cntrNo = cntrNo;
		this.ibTroFlg = ibTroFlg;
		this.polYdCd = polYdCd;
		this.ibInclShtlSoFlg = ibInclShtlSoFlg;
		this.skipActValFlg = skipActValFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("ib_trsp_mode", getIbTrspMode());
		this.hashColumns.put("mt_rtn", getMtRtn());
		this.hashColumns.put("in_bound", getInBound());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("pol_t", getPolT());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pod_t", getPodT());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("n2_pod_clpt_seq", getN2PodClptSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("manual_flag", getManualFlag());
		this.hashColumns.put("n1_pod_clpt_seq", getN1PodClptSeq());
		this.hashColumns.put("n4_pol_clpt_seq", getN4PolClptSeq());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod1", getPod1());
		this.hashColumns.put("pod4", getPod4());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("pod3", getPod3());
		this.hashColumns.put("new_pod", getNewPod());
		this.hashColumns.put("mt_pu", getMtPu());
		this.hashColumns.put("ob_incl_shtl_so_flg", getObInclShtlSoFlg());
		this.hashColumns.put("out_bound", getOutBound());
		this.hashColumns.put("new_pol", getNewPol());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("org_loc_cd", getOrgLocCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("n3_pol_clpt_seq", getN3PolClptSeq());
		this.hashColumns.put("ocn_bound", getOcnBound());
		this.hashColumns.put("n2_pol_clpt_seq", getN2PolClptSeq());
		this.hashColumns.put("eur_check", getEurCheck());
		this.hashColumns.put("n3_pod_clpt_seq", getN3PodClptSeq());
		this.hashColumns.put("ob_tro_flg", getObTroFlg());
		this.hashColumns.put("ob_trsp_mode", getObTrspMode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n1_pol_clpt_seq", getN1PolClptSeq());
		this.hashColumns.put("full_pkup_yd_cd", getFullPkupYdCd());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("lane4", getLane4());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("ocn_seq", getOcnSeq());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("lane3", getLane3());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("n4_pod_clpt_seq", getN4PodClptSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ib_tro_flg", getIbTroFlg());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("ib_incl_shtl_so_flg", getIbInclShtlSoFlg());
		this.hashColumns.put("skip_act_val_flg", getSkipActValFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("ib_trsp_mode", "ibTrspMode");
		this.hashFields.put("mt_rtn", "mtRtn");
		this.hashFields.put("in_bound", "inBound");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("pol_t", "polT");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pod_t", "podT");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("n2_pod_clpt_seq", "n2PodClptSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("manual_flag", "manualFlag");
		this.hashFields.put("n1_pod_clpt_seq", "n1PodClptSeq");
		this.hashFields.put("n4_pol_clpt_seq", "n4PolClptSeq");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod1", "pod1");
		this.hashFields.put("pod4", "pod4");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("pod3", "pod3");
		this.hashFields.put("new_pod", "newPod");
		this.hashFields.put("mt_pu", "mtPu");
		this.hashFields.put("ob_incl_shtl_so_flg", "obInclShtlSoFlg");
		this.hashFields.put("out_bound", "outBound");
		this.hashFields.put("new_pol", "newPol");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("org_loc_cd", "orgLocCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("n3_pol_clpt_seq", "n3PolClptSeq");
		this.hashFields.put("ocn_bound", "ocnBound");
		this.hashFields.put("n2_pol_clpt_seq", "n2PolClptSeq");
		this.hashFields.put("eur_check", "eurCheck");
		this.hashFields.put("n3_pod_clpt_seq", "n3PodClptSeq");
		this.hashFields.put("ob_tro_flg", "obTroFlg");
		this.hashFields.put("ob_trsp_mode", "obTrspMode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n1_pol_clpt_seq", "n1PolClptSeq");
		this.hashFields.put("full_pkup_yd_cd", "fullPkupYdCd");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("lane4", "lane4");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("ocn_seq", "ocnSeq");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("lane3", "lane3");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("n4_pod_clpt_seq", "n4PodClptSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ib_tro_flg", "ibTroFlg");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("ib_incl_shtl_so_flg", "ibInclShtlSoFlg");
		this.hashFields.put("skip_act_val_flg", "skipActValFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ibTrspMode
	 */
	public String getIbTrspMode() {
		return this.ibTrspMode;
	}

	/**
	 * Column Info
	 * @return mtRtn
	 */
	public String getMtRtn() {
		return this.mtRtn;
	}

	/**
	 * Column Info
	 * @return inBound
	 */
	public String getInBound() {
		return this.inBound;
	}

	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}

	/**
	 * Column Info
	 * @return polT
	 */
	public String getPolT() {
		return this.polT;
	}

	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}

	/**
	 * Column Info
	 * @return cct
	 */
	public String getCct() {
		return this.cct;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}

	/**
	 * Column Info
	 * @return podT
	 */
	public String getPodT() {
		return this.podT;
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
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}

	/**
	 * Column Info
	 * @return n2PodClptSeq
	 */
	public String getN2PodClptSeq() {
		return this.n2PodClptSeq;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}

	/**
	 * Column Info
	 * @return manualFlag
	 */
	public String getManualFlag() {
		return this.manualFlag;
	}

	/**
	 * Column Info
	 * @return n1PodClptSeq
	 */
	public String getN1PodClptSeq() {
		return this.n1PodClptSeq;
	}

	/**
	 * Column Info
	 * @return n4PolClptSeq
	 */
	public String getN4PolClptSeq() {
		return this.n4PolClptSeq;
	}

	/**
	 * Column Info
	 * @return pol4
	 */
	public String getPol4() {
		return this.pol4;
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
	 * @return pol3
	 */
	public String getPol3() {
		return this.pol3;
	}

	/**
	 * Column Info
	 * @return pol2
	 */
	public String getPol2() {
		return this.pol2;
	}

	/**
	 * Column Info
	 * @return pol1
	 */
	public String getPol1() {
		return this.pol1;
	}

	/**
	 * Column Info
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
	}

	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}

	/**
	 * Column Info
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}

	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}

	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}

	/**
	 * Column Info
	 * @return pod2
	 */
	public String getPod2() {
		return this.pod2;
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
	 * @return pod1
	 */
	public String getPod1() {
		return this.pod1;
	}

	/**
	 * Column Info
	 * @return pod4
	 */
	public String getPod4() {
		return this.pod4;
	}

	/**
	 * Column Info
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}

	/**
	 * Column Info
	 * @return pod3
	 */
	public String getPod3() {
		return this.pod3;
	}

	/**
	 * Column Info
	 * @return newPod
	 */
	public String getNewPod() {
		return this.newPod;
	}

	/**
	 * Column Info
	 * @return mtPu
	 */
	public String getMtPu() {
		return this.mtPu;
	}

	/**
	 * Column Info
	 * @return obInclShtlSoFlg
	 */
	public String getObInclShtlSoFlg() {
		return this.obInclShtlSoFlg;
	}

	/**
	 * Column Info
	 * @return outBound
	 */
	public String getOutBound() {
		return this.outBound;
	}

	/**
	 * Column Info
	 * @return newPol
	 */
	public String getNewPol() {
		return this.newPol;
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
	 * @return orgLocCd
	 */
	public String getOrgLocCd() {
		return this.orgLocCd;
	}

	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
	}

	/**
	 * Column Info
	 * @return n3PolClptSeq
	 */
	public String getN3PolClptSeq() {
		return this.n3PolClptSeq;
	}

	/**
	 * Column Info
	 * @return ocnBound
	 */
	public String getOcnBound() {
		return this.ocnBound;
	}

	/**
	 * Column Info
	 * @return n2PolClptSeq
	 */
	public String getN2PolClptSeq() {
		return this.n2PolClptSeq;
	}

	/**
	 * Column Info
	 * @return eurCheck
	 */
	public String getEurCheck() {
		return this.eurCheck;
	}

	/**
	 * Column Info
	 * @return n3PodClptSeq
	 */
	public String getN3PodClptSeq() {
		return this.n3PodClptSeq;
	}

	/**
	 * Column Info
	 * @return obTroFlg
	 */
	public String getObTroFlg() {
		return this.obTroFlg;
	}

	/**
	 * Column Info
	 * @return obTrspMode
	 */
	public String getObTrspMode() {
		return this.obTrspMode;
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
	 * @return n1PolClptSeq
	 */
	public String getN1PolClptSeq() {
		return this.n1PolClptSeq;
	}

	/**
	 * Column Info
	 * @return fullPkupYdCd
	 */
	public String getFullPkupYdCd() {
		return this.fullPkupYdCd;
	}

	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}

	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}

	/**
	 * Column Info
	 * @return lane4
	 */
	public String getLane4() {
		return this.lane4;
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
	 * @return ocnSeq
	 */
	public String getOcnSeq() {
		return this.ocnSeq;
	}

	/**
	 * Column Info
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Column Info
	 * @return lane3
	 */
	public String getLane3() {
		return this.lane3;
	}

	/**
	 * Column Info
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
	}

	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}

	/**
	 * Column Info
	 * @return n4PodClptSeq
	 */
	public String getN4PodClptSeq() {
		return this.n4PodClptSeq;
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
	 * @return ibTroFlg
	 */
	public String getIbTroFlg() {
		return this.ibTroFlg;
	}

	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}

	/**
	 * Column Info
	 * @return ibInclShtlSoFlg
	 */
	public String getIbInclShtlSoFlg() {
		return this.ibInclShtlSoFlg;
	}

	/**
	 * Column Info
	 * @return skipActValFlg
	 */
	public String getSkipActValFlg() {
		return this.skipActValFlg;
	}

	/**
	 * Column Info
	 * @param ibTrspMode
	 */
	public void setIbTrspMode(String ibTrspMode) {
		this.ibTrspMode = ibTrspMode;
	}

	/**
	 * Column Info
	 * @param mtRtn
	 */
	public void setMtRtn(String mtRtn) {
		this.mtRtn = mtRtn;
	}

	/**
	 * Column Info
	 * @param inBound
	 */
	public void setInBound(String inBound) {
		this.inBound = inBound;
	}

	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	/**
	 * Column Info
	 * @param polT
	 */
	public void setPolT(String polT) {
		this.polT = polT;
	}

	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}

	/**
	 * Column Info
	 * @param cct
	 */
	public void setCct(String cct) {
		this.cct = cct;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}

	/**
	 * Column Info
	 * @param podT
	 */
	public void setPodT(String podT) {
		this.podT = podT;
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
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}

	/**
	 * Column Info
	 * @param n2PodClptSeq
	 */
	public void setN2PodClptSeq(String n2PodClptSeq) {
		this.n2PodClptSeq = n2PodClptSeq;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}

	/**
	 * Column Info
	 * @param manualFlag
	 */
	public void setManualFlag(String manualFlag) {
		this.manualFlag = manualFlag;
	}

	/**
	 * Column Info
	 * @param n1PodClptSeq
	 */
	public void setN1PodClptSeq(String n1PodClptSeq) {
		this.n1PodClptSeq = n1PodClptSeq;
	}

	/**
	 * Column Info
	 * @param n4PolClptSeq
	 */
	public void setN4PolClptSeq(String n4PolClptSeq) {
		this.n4PolClptSeq = n4PolClptSeq;
	}

	/**
	 * Column Info
	 * @param pol4
	 */
	public void setPol4(String pol4) {
		this.pol4 = pol4;
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
	 * @param pol3
	 */
	public void setPol3(String pol3) {
		this.pol3 = pol3;
	}

	/**
	 * Column Info
	 * @param pol2
	 */
	public void setPol2(String pol2) {
		this.pol2 = pol2;
	}

	/**
	 * Column Info
	 * @param pol1
	 */
	public void setPol1(String pol1) {
		this.pol1 = pol1;
	}

	/**
	 * Column Info
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
	}

	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}

	/**
	 * Column Info
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}

	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}

	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}

	/**
	 * Column Info
	 * @param pod2
	 */
	public void setPod2(String pod2) {
		this.pod2 = pod2;
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
	 * @param pod1
	 */
	public void setPod1(String pod1) {
		this.pod1 = pod1;
	}

	/**
	 * Column Info
	 * @param pod4
	 */
	public void setPod4(String pod4) {
		this.pod4 = pod4;
	}

	/**
	 * Column Info
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}

	/**
	 * Column Info
	 * @param pod3
	 */
	public void setPod3(String pod3) {
		this.pod3 = pod3;
	}

	/**
	 * Column Info
	 * @param newPod
	 */
	public void setNewPod(String newPod) {
		this.newPod = newPod;
	}

	/**
	 * Column Info
	 * @param mtPu
	 */
	public void setMtPu(String mtPu) {
		this.mtPu = mtPu;
	}

	/**
	 * Column Info
	 * @param obInclShtlSoFlg
	 */
	public void setObInclShtlSoFlg(String obInclShtlSoFlg) {
		this.obInclShtlSoFlg = obInclShtlSoFlg;
	}

	/**
	 * Column Info
	 * @param outBound
	 */
	public void setOutBound(String outBound) {
		this.outBound = outBound;
	}

	/**
	 * Column Info
	 * @param newPol
	 */
	public void setNewPol(String newPol) {
		this.newPol = newPol;
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
	 * @param orgLocCd
	 */
	public void setOrgLocCd(String orgLocCd) {
		this.orgLocCd = orgLocCd;
	}

	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
	}

	/**
	 * Column Info
	 * @param n3PolClptSeq
	 */
	public void setN3PolClptSeq(String n3PolClptSeq) {
		this.n3PolClptSeq = n3PolClptSeq;
	}

	/**
	 * Column Info
	 * @param ocnBound
	 */
	public void setOcnBound(String ocnBound) {
		this.ocnBound = ocnBound;
	}

	/**
	 * Column Info
	 * @param n2PolClptSeq
	 */
	public void setN2PolClptSeq(String n2PolClptSeq) {
		this.n2PolClptSeq = n2PolClptSeq;
	}

	/**
	 * Column Info
	 * @param eurCheck
	 */
	public void setEurCheck(String eurCheck) {
		this.eurCheck = eurCheck;
	}

	/**
	 * Column Info
	 * @param n3PodClptSeq
	 */
	public void setN3PodClptSeq(String n3PodClptSeq) {
		this.n3PodClptSeq = n3PodClptSeq;
	}

	/**
	 * Column Info
	 * @param obTroFlg
	 */
	public void setObTroFlg(String obTroFlg) {
		this.obTroFlg = obTroFlg;
	}

	/**
	 * Column Info
	 * @param obTrspMode
	 */
	public void setObTrspMode(String obTrspMode) {
		this.obTrspMode = obTrspMode;
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
	 * @param n1PolClptSeq
	 */
	public void setN1PolClptSeq(String n1PolClptSeq) {
		this.n1PolClptSeq = n1PolClptSeq;
	}

	/**
	 * Column Info
	 * @param fullPkupYdCd
	 */
	public void setFullPkupYdCd(String fullPkupYdCd) {
		this.fullPkupYdCd = fullPkupYdCd;
	}

	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}

	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}

	/**
	 * Column Info
	 * @param lane4
	 */
	public void setLane4(String lane4) {
		this.lane4 = lane4;
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
	 * @param ocnSeq
	 */
	public void setOcnSeq(String ocnSeq) {
		this.ocnSeq = ocnSeq;
	}

	/**
	 * Column Info
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @param lane3
	 */
	public void setLane3(String lane3) {
		this.lane3 = lane3;
	}

	/**
	 * Column Info
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}

	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}

	/**
	 * Column Info
	 * @param n4PodClptSeq
	 */
	public void setN4PodClptSeq(String n4PodClptSeq) {
		this.n4PodClptSeq = n4PodClptSeq;
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
	 * @param ibTroFlg
	 */
	public void setIbTroFlg(String ibTroFlg) {
		this.ibTroFlg = ibTroFlg;
	}

	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}

	/**
	 * Column Info
	 * @param ibInclShtlSoFlg
	 */
	public void setIbInclShtlSoFlg(String ibInclShtlSoFlg) {
		this.ibInclShtlSoFlg = ibInclShtlSoFlg;
	}

	/**
	 * Column Info
	 * @param skipActValFlg
	 */
	public void setSkipActValFlg(String skipActValFlg) {
		this.skipActValFlg = skipActValFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbTrspMode(JSPUtil.getParameter(request, prefix + "ib_trsp_mode", ""));
		setMtRtn(JSPUtil.getParameter(request, prefix + "mt_rtn", ""));
		setInBound(JSPUtil.getParameter(request, prefix + "in_bound", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setPolT(JSPUtil.getParameter(request, prefix + "pol_t", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, prefix + "rout_org_nod_cd", ""));
		setCct(JSPUtil.getParameter(request, prefix + "cct", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setPodT(JSPUtil.getParameter(request, prefix + "pod_t", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setN2PodClptSeq(JSPUtil.getParameter(request, prefix + "n2_pod_clpt_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setManualFlag(JSPUtil.getParameter(request, prefix + "manual_flag", ""));
		setN1PodClptSeq(JSPUtil.getParameter(request, prefix + "n1_pod_clpt_seq", ""));
		setN4PolClptSeq(JSPUtil.getParameter(request, prefix + "n4_pol_clpt_seq", ""));
		setPol4(JSPUtil.getParameter(request, prefix + "pol4", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPol3(JSPUtil.getParameter(request, prefix + "pol3", ""));
		setPol2(JSPUtil.getParameter(request, prefix + "pol2", ""));
		setPol1(JSPUtil.getParameter(request, prefix + "pol1", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setPod2(JSPUtil.getParameter(request, prefix + "pod2", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPod1(JSPUtil.getParameter(request, prefix + "pod1", ""));
		setPod4(JSPUtil.getParameter(request, prefix + "pod4", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setPod3(JSPUtil.getParameter(request, prefix + "pod3", ""));
		setNewPod(JSPUtil.getParameter(request, prefix + "new_pod", ""));
		setMtPu(JSPUtil.getParameter(request, prefix + "mt_pu", ""));
		setObInclShtlSoFlg(JSPUtil.getParameter(request, prefix + "ob_incl_shtl_so_flg", ""));
		setOutBound(JSPUtil.getParameter(request, prefix + "out_bound", ""));
		setNewPol(JSPUtil.getParameter(request, prefix + "new_pol", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setOrgLocCd(JSPUtil.getParameter(request, prefix + "org_loc_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setN3PolClptSeq(JSPUtil.getParameter(request, prefix + "n3_pol_clpt_seq", ""));
		setOcnBound(JSPUtil.getParameter(request, prefix + "ocn_bound", ""));
		setN2PolClptSeq(JSPUtil.getParameter(request, prefix + "n2_pol_clpt_seq", ""));
		setEurCheck(JSPUtil.getParameter(request, prefix + "eur_check", ""));
		setN3PodClptSeq(JSPUtil.getParameter(request, prefix + "n3_pod_clpt_seq", ""));
		setObTroFlg(JSPUtil.getParameter(request, prefix + "ob_tro_flg", ""));
		setObTrspMode(JSPUtil.getParameter(request, prefix + "ob_trsp_mode", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN1PolClptSeq(JSPUtil.getParameter(request, prefix + "n1_pol_clpt_seq", ""));
		setFullPkupYdCd(JSPUtil.getParameter(request, prefix + "full_pkup_yd_cd", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, prefix + "rout_dest_nod_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setLane4(JSPUtil.getParameter(request, prefix + "lane4", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setOcnSeq(JSPUtil.getParameter(request, prefix + "ocn_seq", ""));
		setLane2(JSPUtil.getParameter(request, prefix + "lane2", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setLane3(JSPUtil.getParameter(request, prefix + "lane3", ""));
		setLane1(JSPUtil.getParameter(request, prefix + "lane1", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setN4PodClptSeq(JSPUtil.getParameter(request, prefix + "n4_pod_clpt_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setIbTroFlg(JSPUtil.getParameter(request, prefix + "ib_tro_flg", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setIbInclShtlSoFlg(JSPUtil.getParameter(request, prefix + "ib_incl_shtl_so_flg", ""));
		setSkipActValFlg(JSPUtil.getParameter(request, prefix + "skip_act_val_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdSceGetParamVO[]
	 */
	public PrdSceGetParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PrdSceGetParamVO[]
	 */
	public PrdSceGetParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdSceGetParamVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibTrspMode = (JSPUtil.getParameter(request, prefix + "ib_trsp_mode", length));
			String[] mtRtn = (JSPUtil.getParameter(request, prefix + "mt_rtn", length));
			String[] inBound = (JSPUtil.getParameter(request, prefix + "in_bound", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix + "cop_no", length));
			String[] polT = (JSPUtil.getParameter(request, prefix + "pol_t", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix + "rout_org_nod_cd", length));
			String[] cct = (JSPUtil.getParameter(request, prefix + "cct", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix + "pctl_no", length));
			String[] podT = (JSPUtil.getParameter(request, prefix + "pod_t", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix + "t_vvd", length));
			String[] n2PodClptSeq = (JSPUtil.getParameter(request, prefix + "n2_pod_clpt_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
			String[] manualFlag = (JSPUtil.getParameter(request, prefix + "manual_flag", length));
			String[] n1PodClptSeq = (JSPUtil.getParameter(request, prefix + "n1_pod_clpt_seq", length));
			String[] n4PolClptSeq = (JSPUtil.getParameter(request, prefix + "n4_pol_clpt_seq", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix + "pol4", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix + "pol3", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix + "pol2", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix + "pol1", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix + "vvd2", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix + "vvd3", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix + "rout_seq", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix + "vvd1", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix + "pod2", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
			String[] pod1 = (JSPUtil.getParameter(request, prefix + "pod1", length));
			String[] pod4 = (JSPUtil.getParameter(request, prefix + "pod4", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix + "vvd4", length));
			String[] pod3 = (JSPUtil.getParameter(request, prefix + "pod3", length));
			String[] newPod = (JSPUtil.getParameter(request, prefix + "new_pod", length));
			String[] mtPu = (JSPUtil.getParameter(request, prefix + "mt_pu", length));
			String[] obInclShtlSoFlg = (JSPUtil.getParameter(request, prefix + "ob_incl_shtl_so_flg", length));
			String[] outBound = (JSPUtil.getParameter(request, prefix + "out_bound", length));
			String[] newPol = (JSPUtil.getParameter(request, prefix + "new_pol", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
			String[] orgLocCd = (JSPUtil.getParameter(request, prefix + "org_loc_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix + "dest_loc_cd", length));
			String[] n3PolClptSeq = (JSPUtil.getParameter(request, prefix + "n3_pol_clpt_seq", length));
			String[] ocnBound = (JSPUtil.getParameter(request, prefix + "ocn_bound", length));
			String[] n2PolClptSeq = (JSPUtil.getParameter(request, prefix + "n2_pol_clpt_seq", length));
			String[] eurCheck = (JSPUtil.getParameter(request, prefix + "eur_check", length));
			String[] n3PodClptSeq = (JSPUtil.getParameter(request, prefix + "n3_pod_clpt_seq", length));
			String[] obTroFlg = (JSPUtil.getParameter(request, prefix + "ob_tro_flg", length));
			String[] obTrspMode = (JSPUtil.getParameter(request, prefix + "ob_trsp_mode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] n1PolClptSeq = (JSPUtil.getParameter(request, prefix + "n1_pol_clpt_seq", length));
			String[] fullPkupYdCd = (JSPUtil.getParameter(request, prefix + "full_pkup_yd_cd", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix + "rout_dest_nod_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
			String[] lane4 = (JSPUtil.getParameter(request, prefix + "lane4", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
			String[] ocnSeq = (JSPUtil.getParameter(request, prefix + "ocn_seq", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix + "lane2", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
			String[] lane3 = (JSPUtil.getParameter(request, prefix + "lane3", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix + "lane1", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
			String[] n4PodClptSeq = (JSPUtil.getParameter(request, prefix + "n4_pod_clpt_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
			String[] ibTroFlg = (JSPUtil.getParameter(request, prefix + "ib_tro_flg", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
			String[] ibInclShtlSoFlg = (JSPUtil.getParameter(request, prefix + "ib_incl_shtl_so_flg", length));
			String[] skipActValFlg = (JSPUtil.getParameter(request, prefix + "skip_act_val_flg", length));

			for (int i = 0; i < length; i++) {
				model = new PrdSceGetParamVO();
				if (ibTrspMode[i] != null)
					model.setIbTrspMode(ibTrspMode[i]);
				if (mtRtn[i] != null)
					model.setMtRtn(mtRtn[i]);
				if (inBound[i] != null)
					model.setInBound(inBound[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (polT[i] != null)
					model.setPolT(polT[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (cct[i] != null)
					model.setCct(cct[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (podT[i] != null)
					model.setPodT(podT[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (n2PodClptSeq[i] != null)
					model.setN2PodClptSeq(n2PodClptSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (manualFlag[i] != null)
					model.setManualFlag(manualFlag[i]);
				if (n1PodClptSeq[i] != null)
					model.setN1PodClptSeq(n1PodClptSeq[i]);
				if (n4PolClptSeq[i] != null)
					model.setN4PolClptSeq(n4PolClptSeq[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (pod1[i] != null)
					model.setPod1(pod1[i]);
				if (pod4[i] != null)
					model.setPod4(pod4[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (pod3[i] != null)
					model.setPod3(pod3[i]);
				if (newPod[i] != null)
					model.setNewPod(newPod[i]);
				if (mtPu[i] != null)
					model.setMtPu(mtPu[i]);
				if (obInclShtlSoFlg[i] != null)
					model.setObInclShtlSoFlg(obInclShtlSoFlg[i]);
				if (outBound[i] != null)
					model.setOutBound(outBound[i]);
				if (newPol[i] != null)
					model.setNewPol(newPol[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (orgLocCd[i] != null)
					model.setOrgLocCd(orgLocCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (n3PolClptSeq[i] != null)
					model.setN3PolClptSeq(n3PolClptSeq[i]);
				if (ocnBound[i] != null)
					model.setOcnBound(ocnBound[i]);
				if (n2PolClptSeq[i] != null)
					model.setN2PolClptSeq(n2PolClptSeq[i]);
				if (eurCheck[i] != null)
					model.setEurCheck(eurCheck[i]);
				if (n3PodClptSeq[i] != null)
					model.setN3PodClptSeq(n3PodClptSeq[i]);
				if (obTroFlg[i] != null)
					model.setObTroFlg(obTroFlg[i]);
				if (obTrspMode[i] != null)
					model.setObTrspMode(obTrspMode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n1PolClptSeq[i] != null)
					model.setN1PolClptSeq(n1PolClptSeq[i]);
				if (fullPkupYdCd[i] != null)
					model.setFullPkupYdCd(fullPkupYdCd[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (lane4[i] != null)
					model.setLane4(lane4[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (ocnSeq[i] != null)
					model.setOcnSeq(ocnSeq[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (lane3[i] != null)
					model.setLane3(lane3[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (n4PodClptSeq[i] != null)
					model.setN4PodClptSeq(n4PodClptSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ibTroFlg[i] != null)
					model.setIbTroFlg(ibTroFlg[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (ibInclShtlSoFlg[i] != null)
					model.setIbInclShtlSoFlg(ibInclShtlSoFlg[i]);
				if (skipActValFlg[i] != null)
					model.setSkipActValFlg(skipActValFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdSceGetParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdSceGetParamVO[]
	 */
	public PrdSceGetParamVO[] getPrdSceGetParamVOs() {
		PrdSceGetParamVO[] vos = (PrdSceGetParamVO[]) models.toArray(new PrdSceGetParamVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.ibTrspMode = this.ibTrspMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRtn = this.mtRtn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBound = this.inBound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polT = this.polT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podT = this.podT.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2PodClptSeq = this.n2PodClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manualFlag = this.manualFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1PodClptSeq = this.n1PodClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4PolClptSeq = this.n4PolClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 = this.pod1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 = this.pod4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 = this.pod3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPod = this.newPod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtPu = this.mtPu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obInclShtlSoFlg = this.obInclShtlSoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outBound = this.outBound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPol = this.newPol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLocCd = this.orgLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3PolClptSeq = this.n3PolClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnBound = this.ocnBound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2PolClptSeq = this.n2PolClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurCheck = this.eurCheck.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3PodClptSeq = this.n3PodClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTroFlg = this.obTroFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTrspMode = this.obTrspMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1PolClptSeq = this.n1PolClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullPkupYdCd = this.fullPkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane4 = this.lane4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnSeq = this.ocnSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane3 = this.lane3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4PodClptSeq = this.n4PodClptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTroFlg = this.ibTroFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibInclShtlSoFlg = this.ibInclShtlSoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skipActValFlg = this.skipActValFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
