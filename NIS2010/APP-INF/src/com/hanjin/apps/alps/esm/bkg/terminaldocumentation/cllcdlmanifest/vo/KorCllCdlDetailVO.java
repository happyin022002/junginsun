/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCllCdlDetailVO.java
*@FileTitle : KorCllCdlDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
public class KorCllCdlDetailVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<KorCllCdlDetailVO> models = new ArrayList<KorCllCdlDetailVO>();

    /* Column Info */
    private String vgmWgtUtCd = null;

    /* Column Info */
    private String bkgCgoTpCd = null;

    /* Column Info */
    private String apolNm = null;

    /* Column Info */
    private String sealKndCd = null;

    /* Column Info */
    private String blckStwgCd = null;

    /* Column Info */
    private String pre3pol = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String spclCgoDescType = null;

    /* Column Info */
    private String aPodCd = null;

    /* Column Info */
    private String polCd = null;

    /* Column Info */
    private String pre1pol = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String woFlg = null;

    /* Column Info */
    private String prctFlg = null;

    /* Column Info */
    private String cntrTpszCd = null;

    /* Column Info */
    private String outVvdCd = null;

    /* Column Info */
    private String stwgCd = null;

    /* Column Info */
    private String cmdtHsCd = null;

    /* Column Info */
    private String custToOrdFlg = null;

    /* Column Info */
    private String delNodCd = null;

    /* Column Info */
    private String bpolNm = null;

    /* Column Info */
    private String cntrWgt = null;

    /* Column Info */
    private String post4pol = null;

    /* Column Info */
    private String awkCgoFlg = null;

    /* Column Info */
    private String trunkvvd = null;

    /* Column Info */
    private String delCd = null;

    /* Column Info */
    private String cnmvEvntDt = null;

    /* Column Info */
    private String post1pol = null;

    /* Column Info */
    private String blckStwgHubLocCd = null;

    /* Column Info */
    private String podCd = null;

    /* Column Info */
    private String porNm = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String podNodCd = null;

    /* Column Info */
    private String rcFlg = null;

    /* Column Info */
    private String porCd = null;

    /* Column Info */
    private String cntrNo2 = null;

    /* Column Info */
    private String prevvd3 = null;

    /* Column Info */
    private String prevvd4 = null;

    /* Column Info */
    private String prevvd1 = null;

    /* Column Info */
    private String prevvd2 = null;

    /* Column Info */
    private String custNm = null;

    /* Column Info */
    private String rdCgoFlg = null;

    /* Column Info */
    private String tsCd = null;

    /* Column Info */
    private String aPolCd = null;

    /* Column Info */
    private String eCntrWgt = null;

    /* Column Info */
    private String vgmWgt = null;

    /* Column Info */
    private String pre4pol = null;

    /* Column Info */
    private String hotDeFlg = null;

    /* Column Info */
    private String vgmKgs = null;

    /* Column Info */
    private String spclCgoDesc = null;

    /* Column Info */
    private String aCntrWgt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String sealPtyTpCd = null;

    /* Column Info */
    private String cstmsDesc = null;

    /* Column Info */
    private String bbCgoFlg = null;

    /* Column Info */
    private String measQty = null;

    /* Column Info */
    private String dcgoFlg = null;

    /* Column Info */
    private String pckQty = null;

    /* Column Info */
    private String rcvTermCd = null;

    /* Column Info */
    private String podYdCd = null;

    /* Column Info */
    private String pckTpCd = null;

    /* Column Info */
    private String post3pol = null;

    /* Column Info */
    private String hamoTrfCd = null;

    /* Column Info */
    private String porNodCd = null;

    /* Column Info */
    private String pre2pol = null;

    /* Column Info */
    private String vgmMzdTpCd = null;

    /* Column Info */
    private String delNm = null;

    /* Column Info */
    private String vent = null;

    /* Column Info */
    private String postvvd3 = null;

    /* Column Info */
    private String postvvd2 = null;

    /* Column Info */
    private String polNodCd = null;

    /* Column Info */
    private String postvvd1 = null;

    /* Column Info */
    private String apodNm = null;

    /* Column Info */
    private String post2pol = null;

    /* Column Info */
    private String orgYdCd = null;

    /* Column Info */
    private String socFlg = null;

    /* Column Info */
    private String bpodNm = null;

    /* Column Info */
    private String deTermCd = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String polYdCd = null;

    /* Column Info */
    private String cntrNo = null;

    /* Column Info */
    private String postvvd4 = null;

    /* Column Info */
    private String hngrFlg = null;

    /* Column Info */
    private String seq = null;

    /* Column Info */
    private String vgmVrfySigCtnt = null;

    /* Column Info */
    private String cntrSealNo = null;

    /* Column Info */
    private String oblSerNo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public KorCllCdlDetailVO() {
    }

    public KorCllCdlDetailVO(String ibflag, String pagerows, String bkgCgoTpCd, String apolNm, String sealKndCd, String blckStwgCd, String pre3pol, String blNo, String spclCgoDescType, String aPodCd, String polCd, String vvdCd, String pre1pol, String woFlg, String cntrTpszCd, String prctFlg, String stwgCd, String outVvdCd, String bpolNm, String delNodCd, String custToOrdFlg, String cmdtHsCd, String cntrWgt, String post4pol, String awkCgoFlg, String trunkvvd, String delCd, String cnmvEvntDt, String post1pol, String blckStwgHubLocCd, String podCd, String porNm, String bkgNo, String podNodCd, String rcFlg, String porCd, String cntrNo2, String prevvd3, String prevvd4, String prevvd1, String prevvd2, String custNm, String rdCgoFlg, String tsCd, String aPolCd, String eCntrWgt, String vgmWgt, String pre4pol, String hotDeFlg, String spclCgoDesc, String vgmKgs, String aCntrWgt, String sealPtyTpCd, String bbCgoFlg, String cstmsDesc, String dcgoFlg, String measQty, String pckQty, String rcvTermCd, String pckTpCd, String podYdCd, String post3pol, String hamoTrfCd, String pre2pol, String porNodCd, String delNm, String vent, String postvvd3, String postvvd2, String apodNm, String postvvd1, String polNodCd, String post2pol, String orgYdCd, String bpodNm, String socFlg, String deTermCd, String slanCd, String postvvd4, String cntrNo, String polYdCd, String seq, String hngrFlg, String cntrSealNo, String vgmWgtUtCd, String vgmVrfySigCtnt, String vgmMzdTpCd, String oblSerNo) {
        this.vgmWgtUtCd = vgmWgtUtCd;
        this.bkgCgoTpCd = bkgCgoTpCd;
        this.apolNm = apolNm;
        this.sealKndCd = sealKndCd;
        this.blckStwgCd = blckStwgCd;
        this.pre3pol = pre3pol;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.spclCgoDescType = spclCgoDescType;
        this.aPodCd = aPodCd;
        this.polCd = polCd;
        this.pre1pol = pre1pol;
        this.vvdCd = vvdCd;
        this.woFlg = woFlg;
        this.prctFlg = prctFlg;
        this.cntrTpszCd = cntrTpszCd;
        this.outVvdCd = outVvdCd;
        this.stwgCd = stwgCd;
        this.cmdtHsCd = cmdtHsCd;
        this.custToOrdFlg = custToOrdFlg;
        this.delNodCd = delNodCd;
        this.bpolNm = bpolNm;
        this.cntrWgt = cntrWgt;
        this.post4pol = post4pol;
        this.awkCgoFlg = awkCgoFlg;
        this.trunkvvd = trunkvvd;
        this.delCd = delCd;
        this.cnmvEvntDt = cnmvEvntDt;
        this.post1pol = post1pol;
        this.blckStwgHubLocCd = blckStwgHubLocCd;
        this.podCd = podCd;
        this.porNm = porNm;
        this.bkgNo = bkgNo;
        this.podNodCd = podNodCd;
        this.rcFlg = rcFlg;
        this.porCd = porCd;
        this.cntrNo2 = cntrNo2;
        this.prevvd3 = prevvd3;
        this.prevvd4 = prevvd4;
        this.prevvd1 = prevvd1;
        this.prevvd2 = prevvd2;
        this.custNm = custNm;
        this.rdCgoFlg = rdCgoFlg;
        this.tsCd = tsCd;
        this.aPolCd = aPolCd;
        this.eCntrWgt = eCntrWgt;
        this.vgmWgt = vgmWgt;
        this.pre4pol = pre4pol;
        this.hotDeFlg = hotDeFlg;
        this.vgmKgs = vgmKgs;
        this.spclCgoDesc = spclCgoDesc;
        this.aCntrWgt = aCntrWgt;
        this.ibflag = ibflag;
        this.sealPtyTpCd = sealPtyTpCd;
        this.cstmsDesc = cstmsDesc;
        this.bbCgoFlg = bbCgoFlg;
        this.measQty = measQty;
        this.dcgoFlg = dcgoFlg;
        this.pckQty = pckQty;
        this.rcvTermCd = rcvTermCd;
        this.podYdCd = podYdCd;
        this.pckTpCd = pckTpCd;
        this.post3pol = post3pol;
        this.hamoTrfCd = hamoTrfCd;
        this.porNodCd = porNodCd;
        this.pre2pol = pre2pol;
        this.vgmMzdTpCd = vgmMzdTpCd;
        this.delNm = delNm;
        this.vent = vent;
        this.postvvd3 = postvvd3;
        this.postvvd2 = postvvd2;
        this.polNodCd = polNodCd;
        this.postvvd1 = postvvd1;
        this.apodNm = apodNm;
        this.post2pol = post2pol;
        this.orgYdCd = orgYdCd;
        this.socFlg = socFlg;
        this.bpodNm = bpodNm;
        this.deTermCd = deTermCd;
        this.slanCd = slanCd;
        this.polYdCd = polYdCd;
        this.cntrNo = cntrNo;
        this.postvvd4 = postvvd4;
        this.hngrFlg = hngrFlg;
        this.seq = seq;
        this.vgmVrfySigCtnt = vgmVrfySigCtnt;
        this.cntrSealNo = cntrSealNo;
        this.oblSerNo = oblSerNo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
        this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
        this.hashColumns.put("apol_nm", getApolNm());
        this.hashColumns.put("seal_knd_cd", getSealKndCd());
        this.hashColumns.put("blck_stwg_cd", getBlckStwgCd());
        this.hashColumns.put("pre3pol", getPre3pol());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("spcl_cgo_desc_type", getSpclCgoDescType());
        this.hashColumns.put("a_pod_cd", getAPodCd());
        this.hashColumns.put("pol_cd", getPolCd());
        this.hashColumns.put("pre1pol", getPre1pol());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("wo_flg", getWoFlg());
        this.hashColumns.put("prct_flg", getPrctFlg());
        this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
        this.hashColumns.put("out_vvd_cd", getOutVvdCd());
        this.hashColumns.put("stwg_cd", getStwgCd());
        this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
        this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
        this.hashColumns.put("del_nod_cd", getDelNodCd());
        this.hashColumns.put("bpol_nm", getBpolNm());
        this.hashColumns.put("cntr_wgt", getCntrWgt());
        this.hashColumns.put("post4pol", getPost4pol());
        this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
        this.hashColumns.put("trunkvvd", getTrunkvvd());
        this.hashColumns.put("del_cd", getDelCd());
        this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());
        this.hashColumns.put("post1pol", getPost1pol());
        this.hashColumns.put("blck_stwg_hub_loc_cd", getBlckStwgHubLocCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("por_nm", getPorNm());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("pod_nod_cd", getPodNodCd());
        this.hashColumns.put("rc_flg", getRcFlg());
        this.hashColumns.put("por_cd", getPorCd());
        this.hashColumns.put("cntr_no2", getCntrNo2());
        this.hashColumns.put("prevvd3", getPrevvd3());
        this.hashColumns.put("prevvd4", getPrevvd4());
        this.hashColumns.put("prevvd1", getPrevvd1());
        this.hashColumns.put("prevvd2", getPrevvd2());
        this.hashColumns.put("cust_nm", getCustNm());
        this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
        this.hashColumns.put("ts_cd", getTsCd());
        this.hashColumns.put("a_pol_cd", getAPolCd());
        this.hashColumns.put("e_cntr_wgt", getECntrWgt());
        this.hashColumns.put("vgm_wgt", getVgmWgt());
        this.hashColumns.put("pre4pol", getPre4pol());
        this.hashColumns.put("hot_de_flg", getHotDeFlg());
        this.hashColumns.put("vgm_kgs", getVgmKgs());
        this.hashColumns.put("spcl_cgo_desc", getSpclCgoDesc());
        this.hashColumns.put("a_cntr_wgt", getACntrWgt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("seal_pty_tp_cd", getSealPtyTpCd());
        this.hashColumns.put("cstms_desc", getCstmsDesc());
        this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
        this.hashColumns.put("meas_qty", getMeasQty());
        this.hashColumns.put("dcgo_flg", getDcgoFlg());
        this.hashColumns.put("pck_qty", getPckQty());
        this.hashColumns.put("rcv_term_cd", getRcvTermCd());
        this.hashColumns.put("pod_yd_cd", getPodYdCd());
        this.hashColumns.put("pck_tp_cd", getPckTpCd());
        this.hashColumns.put("post3pol", getPost3pol());
        this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());
        this.hashColumns.put("por_nod_cd", getPorNodCd());
        this.hashColumns.put("pre2pol", getPre2pol());
        this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
        this.hashColumns.put("del_nm", getDelNm());
        this.hashColumns.put("vent", getVent());
        this.hashColumns.put("postvvd3", getPostvvd3());
        this.hashColumns.put("postvvd2", getPostvvd2());
        this.hashColumns.put("pol_nod_cd", getPolNodCd());
        this.hashColumns.put("postvvd1", getPostvvd1());
        this.hashColumns.put("apod_nm", getApodNm());
        this.hashColumns.put("post2pol", getPost2pol());
        this.hashColumns.put("org_yd_cd", getOrgYdCd());
        this.hashColumns.put("soc_flg", getSocFlg());
        this.hashColumns.put("bpod_nm", getBpodNm());
        this.hashColumns.put("de_term_cd", getDeTermCd());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("pol_yd_cd", getPolYdCd());
        this.hashColumns.put("cntr_no", getCntrNo());
        this.hashColumns.put("postvvd4", getPostvvd4());
        this.hashColumns.put("hngr_flg", getHngrFlg());
        this.hashColumns.put("seq", getSeq());
        this.hashColumns.put("vgm_vrfy_sig_ctnt", getVgmVrfySigCtnt());
        this.hashColumns.put("cntr_seal_no", getCntrSealNo());
        this.hashColumns.put("obl_ser_no", getOblSerNo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
        this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
        this.hashFields.put("apol_nm", "apolNm");
        this.hashFields.put("seal_knd_cd", "sealKndCd");
        this.hashFields.put("blck_stwg_cd", "blckStwgCd");
        this.hashFields.put("pre3pol", "pre3pol");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("spcl_cgo_desc_type", "spclCgoDescType");
        this.hashFields.put("a_pod_cd", "aPodCd");
        this.hashFields.put("pol_cd", "polCd");
        this.hashFields.put("pre1pol", "pre1pol");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("wo_flg", "woFlg");
        this.hashFields.put("prct_flg", "prctFlg");
        this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
        this.hashFields.put("out_vvd_cd", "outVvdCd");
        this.hashFields.put("stwg_cd", "stwgCd");
        this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
        this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
        this.hashFields.put("del_nod_cd", "delNodCd");
        this.hashFields.put("bpol_nm", "bpolNm");
        this.hashFields.put("cntr_wgt", "cntrWgt");
        this.hashFields.put("post4pol", "post4pol");
        this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
        this.hashFields.put("trunkvvd", "trunkvvd");
        this.hashFields.put("del_cd", "delCd");
        this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
        this.hashFields.put("post1pol", "post1pol");
        this.hashFields.put("blck_stwg_hub_loc_cd", "blckStwgHubLocCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("por_nm", "porNm");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("pod_nod_cd", "podNodCd");
        this.hashFields.put("rc_flg", "rcFlg");
        this.hashFields.put("por_cd", "porCd");
        this.hashFields.put("cntr_no2", "cntrNo2");
        this.hashFields.put("prevvd3", "prevvd3");
        this.hashFields.put("prevvd4", "prevvd4");
        this.hashFields.put("prevvd1", "prevvd1");
        this.hashFields.put("prevvd2", "prevvd2");
        this.hashFields.put("cust_nm", "custNm");
        this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
        this.hashFields.put("ts_cd", "tsCd");
        this.hashFields.put("a_pol_cd", "aPolCd");
        this.hashFields.put("e_cntr_wgt", "eCntrWgt");
        this.hashFields.put("vgm_wgt", "vgmWgt");
        this.hashFields.put("pre4pol", "pre4pol");
        this.hashFields.put("hot_de_flg", "hotDeFlg");
        this.hashFields.put("vgm_kgs", "vgmKgs");
        this.hashFields.put("spcl_cgo_desc", "spclCgoDesc");
        this.hashFields.put("a_cntr_wgt", "aCntrWgt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("seal_pty_tp_cd", "sealPtyTpCd");
        this.hashFields.put("cstms_desc", "cstmsDesc");
        this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
        this.hashFields.put("meas_qty", "measQty");
        this.hashFields.put("dcgo_flg", "dcgoFlg");
        this.hashFields.put("pck_qty", "pckQty");
        this.hashFields.put("rcv_term_cd", "rcvTermCd");
        this.hashFields.put("pod_yd_cd", "podYdCd");
        this.hashFields.put("pck_tp_cd", "pckTpCd");
        this.hashFields.put("post3pol", "post3pol");
        this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
        this.hashFields.put("por_nod_cd", "porNodCd");
        this.hashFields.put("pre2pol", "pre2pol");
        this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
        this.hashFields.put("del_nm", "delNm");
        this.hashFields.put("vent", "vent");
        this.hashFields.put("postvvd3", "postvvd3");
        this.hashFields.put("postvvd2", "postvvd2");
        this.hashFields.put("pol_nod_cd", "polNodCd");
        this.hashFields.put("postvvd1", "postvvd1");
        this.hashFields.put("apod_nm", "apodNm");
        this.hashFields.put("post2pol", "post2pol");
        this.hashFields.put("org_yd_cd", "orgYdCd");
        this.hashFields.put("soc_flg", "socFlg");
        this.hashFields.put("bpod_nm", "bpodNm");
        this.hashFields.put("de_term_cd", "deTermCd");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("pol_yd_cd", "polYdCd");
        this.hashFields.put("cntr_no", "cntrNo");
        this.hashFields.put("postvvd4", "postvvd4");
        this.hashFields.put("hngr_flg", "hngrFlg");
        this.hashFields.put("seq", "seq");
        this.hashFields.put("vgm_vrfy_sig_ctnt", "vgmVrfySigCtnt");
        this.hashFields.put("cntr_seal_no", "cntrSealNo");
        this.hashFields.put("obl_ser_no", "oblSerNo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
    public String getVgmWgtUtCd() {
        return this.vgmWgtUtCd;
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
	 * @return apolNm
	 */
    public String getApolNm() {
        return this.apolNm;
    }

    /**
	 * Column Info
	 * @return sealKndCd
	 */
    public String getSealKndCd() {
        return this.sealKndCd;
    }

    /**
	 * Column Info
	 * @return blckStwgCd
	 */
    public String getBlckStwgCd() {
        return this.blckStwgCd;
    }

    /**
	 * Column Info
	 * @return pre3pol
	 */
    public String getPre3pol() {
        return this.pre3pol;
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
	 * @return spclCgoDescType
	 */
    public String getSpclCgoDescType() {
        return this.spclCgoDescType;
    }

    /**
	 * Column Info
	 * @return aPodCd
	 */
    public String getAPodCd() {
        return this.aPodCd;
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
	 * @return pre1pol
	 */
    public String getPre1pol() {
        return this.pre1pol;
    }

    /**
	 * Column Info
	 * @return vvdCd
	 */
    public String getVvdCd() {
        return this.vvdCd;
    }

    /**
	 * Column Info
	 * @return woFlg
	 */
    public String getWoFlg() {
        return this.woFlg;
    }

    /**
	 * Column Info
	 * @return prctFlg
	 */
    public String getPrctFlg() {
        return this.prctFlg;
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
	 * @return outVvdCd
	 */
    public String getOutVvdCd() {
        return this.outVvdCd;
    }

    /**
	 * Column Info
	 * @return stwgCd
	 */
    public String getStwgCd() {
        return this.stwgCd;
    }

    /**
	 * Column Info
	 * @return cmdtHsCd
	 */
    public String getCmdtHsCd() {
        return this.cmdtHsCd;
    }

    /**
	 * Column Info
	 * @return custToOrdFlg
	 */
    public String getCustToOrdFlg() {
        return this.custToOrdFlg;
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
	 * @return bpolNm
	 */
    public String getBpolNm() {
        return this.bpolNm;
    }

    /**
	 * Column Info
	 * @return cntrWgt
	 */
    public String getCntrWgt() {
        return this.cntrWgt;
    }

    /**
	 * Column Info
	 * @return post4pol
	 */
    public String getPost4pol() {
        return this.post4pol;
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
	 * @return trunkvvd
	 */
    public String getTrunkvvd() {
        return this.trunkvvd;
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
	 * @return cnmvEvntDt
	 */
    public String getCnmvEvntDt() {
        return this.cnmvEvntDt;
    }

    /**
	 * Column Info
	 * @return post1pol
	 */
    public String getPost1pol() {
        return this.post1pol;
    }

    /**
	 * Column Info
	 * @return blckStwgHubLocCd
	 */
    public String getBlckStwgHubLocCd() {
        return this.blckStwgHubLocCd;
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
	 * @return porNm
	 */
    public String getPorNm() {
        return this.porNm;
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
	 * @return podNodCd
	 */
    public String getPodNodCd() {
        return this.podNodCd;
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
	 * @return porCd
	 */
    public String getPorCd() {
        return this.porCd;
    }

    /**
	 * Column Info
	 * @return cntrNo2
	 */
    public String getCntrNo2() {
        return this.cntrNo2;
    }

    /**
	 * Column Info
	 * @return prevvd3
	 */
    public String getPrevvd3() {
        return this.prevvd3;
    }

    /**
	 * Column Info
	 * @return prevvd4
	 */
    public String getPrevvd4() {
        return this.prevvd4;
    }

    /**
	 * Column Info
	 * @return prevvd1
	 */
    public String getPrevvd1() {
        return this.prevvd1;
    }

    /**
	 * Column Info
	 * @return prevvd2
	 */
    public String getPrevvd2() {
        return this.prevvd2;
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
	 * @return tsCd
	 */
    public String getTsCd() {
        return this.tsCd;
    }

    /**
	 * Column Info
	 * @return aPolCd
	 */
    public String getAPolCd() {
        return this.aPolCd;
    }

    /**
	 * Column Info
	 * @return eCntrWgt
	 */
    public String getECntrWgt() {
        return this.eCntrWgt;
    }

    /**
	 * Column Info
	 * @return vgmWgt
	 */
    public String getVgmWgt() {
        return this.vgmWgt;
    }

    /**
	 * Column Info
	 * @return pre4pol
	 */
    public String getPre4pol() {
        return this.pre4pol;
    }

    /**
	 * Column Info
	 * @return hotDeFlg
	 */
    public String getHotDeFlg() {
        return this.hotDeFlg;
    }

    /**
	 * Column Info
	 * @return vgmKgs
	 */
    public String getVgmKgs() {
        return this.vgmKgs;
    }

    /**
	 * Column Info
	 * @return spclCgoDesc
	 */
    public String getSpclCgoDesc() {
        return this.spclCgoDesc;
    }

    /**
	 * Column Info
	 * @return aCntrWgt
	 */
    public String getACntrWgt() {
        return this.aCntrWgt;
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
	 * @return sealPtyTpCd
	 */
    public String getSealPtyTpCd() {
        return this.sealPtyTpCd;
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
	 * @return bbCgoFlg
	 */
    public String getBbCgoFlg() {
        return this.bbCgoFlg;
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
	 * @return dcgoFlg
	 */
    public String getDcgoFlg() {
        return this.dcgoFlg;
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
	 * @return rcvTermCd
	 */
    public String getRcvTermCd() {
        return this.rcvTermCd;
    }

    /**
	 * Column Info
	 * @return podYdCd
	 */
    public String getPodYdCd() {
        return this.podYdCd;
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
	 * @return post3pol
	 */
    public String getPost3pol() {
        return this.post3pol;
    }

    /**
	 * Column Info
	 * @return hamoTrfCd
	 */
    public String getHamoTrfCd() {
        return this.hamoTrfCd;
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
	 * @return pre2pol
	 */
    public String getPre2pol() {
        return this.pre2pol;
    }

    /**
	 * Column Info
	 * @return vgmMzdTpCd
	 */
    public String getVgmMzdTpCd() {
        return this.vgmMzdTpCd;
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
	 * @return vent
	 */
    public String getVent() {
        return this.vent;
    }

    /**
	 * Column Info
	 * @return postvvd3
	 */
    public String getPostvvd3() {
        return this.postvvd3;
    }

    /**
	 * Column Info
	 * @return postvvd2
	 */
    public String getPostvvd2() {
        return this.postvvd2;
    }

    /**
	 * Column Info
	 * @return polNodCd
	 */
    public String getPolNodCd() {
        return this.polNodCd;
    }

    /**
	 * Column Info
	 * @return postvvd1
	 */
    public String getPostvvd1() {
        return this.postvvd1;
    }

    /**
	 * Column Info
	 * @return apodNm
	 */
    public String getApodNm() {
        return this.apodNm;
    }

    /**
	 * Column Info
	 * @return post2pol
	 */
    public String getPost2pol() {
        return this.post2pol;
    }

    /**
	 * Column Info
	 * @return orgYdCd
	 */
    public String getOrgYdCd() {
        return this.orgYdCd;
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
	 * @return bpodNm
	 */
    public String getBpodNm() {
        return this.bpodNm;
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
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
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
	 * @return cntrNo
	 */
    public String getCntrNo() {
        return this.cntrNo;
    }

    /**
	 * Column Info
	 * @return postvvd4
	 */
    public String getPostvvd4() {
        return this.postvvd4;
    }

    /**
	 * Column Info
	 * @return hngrFlg
	 */
    public String getHngrFlg() {
        return this.hngrFlg;
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
	 * @return vgmVrfySigCtnt
	 */
    public String getVgmVrfySigCtnt() {
        return this.vgmVrfySigCtnt;
    }

    /**
	 * Column Info
	 * @return cntrSealNo
	 */
    public String getCntrSealNo() {
        return this.cntrSealNo;
    }

    /**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
    public void setVgmWgtUtCd(String vgmWgtUtCd) {
        this.vgmWgtUtCd = vgmWgtUtCd;
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
	 * @param apolNm
	 */
    public void setApolNm(String apolNm) {
        this.apolNm = apolNm;
    }

    /**
	 * Column Info
	 * @param sealKndCd
	 */
    public void setSealKndCd(String sealKndCd) {
        this.sealKndCd = sealKndCd;
    }

    /**
	 * Column Info
	 * @param blckStwgCd
	 */
    public void setBlckStwgCd(String blckStwgCd) {
        this.blckStwgCd = blckStwgCd;
    }

    /**
	 * Column Info
	 * @param pre3pol
	 */
    public void setPre3pol(String pre3pol) {
        this.pre3pol = pre3pol;
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
	 * @param spclCgoDescType
	 */
    public void setSpclCgoDescType(String spclCgoDescType) {
        this.spclCgoDescType = spclCgoDescType;
    }

    /**
	 * Column Info
	 * @param aPodCd
	 */
    public void setAPodCd(String aPodCd) {
        this.aPodCd = aPodCd;
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
	 * @param pre1pol
	 */
    public void setPre1pol(String pre1pol) {
        this.pre1pol = pre1pol;
    }

    /**
	 * Column Info
	 * @param vvdCd
	 */
    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    /**
	 * Column Info
	 * @param woFlg
	 */
    public void setWoFlg(String woFlg) {
        this.woFlg = woFlg;
    }

    /**
	 * Column Info
	 * @param prctFlg
	 */
    public void setPrctFlg(String prctFlg) {
        this.prctFlg = prctFlg;
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
	 * @param outVvdCd
	 */
    public void setOutVvdCd(String outVvdCd) {
        this.outVvdCd = outVvdCd;
    }

    /**
	 * Column Info
	 * @param stwgCd
	 */
    public void setStwgCd(String stwgCd) {
        this.stwgCd = stwgCd;
    }

    /**
	 * Column Info
	 * @param cmdtHsCd
	 */
    public void setCmdtHsCd(String cmdtHsCd) {
        this.cmdtHsCd = cmdtHsCd;
    }

    /**
	 * Column Info
	 * @param custToOrdFlg
	 */
    public void setCustToOrdFlg(String custToOrdFlg) {
        this.custToOrdFlg = custToOrdFlg;
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
	 * @param bpolNm
	 */
    public void setBpolNm(String bpolNm) {
        this.bpolNm = bpolNm;
    }

    /**
	 * Column Info
	 * @param cntrWgt
	 */
    public void setCntrWgt(String cntrWgt) {
        this.cntrWgt = cntrWgt;
    }

    /**
	 * Column Info
	 * @param post4pol
	 */
    public void setPost4pol(String post4pol) {
        this.post4pol = post4pol;
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
	 * @param trunkvvd
	 */
    public void setTrunkvvd(String trunkvvd) {
        this.trunkvvd = trunkvvd;
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
	 * @param cnmvEvntDt
	 */
    public void setCnmvEvntDt(String cnmvEvntDt) {
        this.cnmvEvntDt = cnmvEvntDt;
    }

    /**
	 * Column Info
	 * @param post1pol
	 */
    public void setPost1pol(String post1pol) {
        this.post1pol = post1pol;
    }

    /**
	 * Column Info
	 * @param blckStwgHubLocCd
	 */
    public void setBlckStwgHubLocCd(String blckStwgHubLocCd) {
        this.blckStwgHubLocCd = blckStwgHubLocCd;
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
	 * @param porNm
	 */
    public void setPorNm(String porNm) {
        this.porNm = porNm;
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
	 * @param podNodCd
	 */
    public void setPodNodCd(String podNodCd) {
        this.podNodCd = podNodCd;
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
	 * @param porCd
	 */
    public void setPorCd(String porCd) {
        this.porCd = porCd;
    }

    /**
	 * Column Info
	 * @param cntrNo2
	 */
    public void setCntrNo2(String cntrNo2) {
        this.cntrNo2 = cntrNo2;
    }

    /**
	 * Column Info
	 * @param prevvd3
	 */
    public void setPrevvd3(String prevvd3) {
        this.prevvd3 = prevvd3;
    }

    /**
	 * Column Info
	 * @param prevvd4
	 */
    public void setPrevvd4(String prevvd4) {
        this.prevvd4 = prevvd4;
    }

    /**
	 * Column Info
	 * @param prevvd1
	 */
    public void setPrevvd1(String prevvd1) {
        this.prevvd1 = prevvd1;
    }

    /**
	 * Column Info
	 * @param prevvd2
	 */
    public void setPrevvd2(String prevvd2) {
        this.prevvd2 = prevvd2;
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
	 * @param tsCd
	 */
    public void setTsCd(String tsCd) {
        this.tsCd = tsCd;
    }

    /**
	 * Column Info
	 * @param aPolCd
	 */
    public void setAPolCd(String aPolCd) {
        this.aPolCd = aPolCd;
    }

    /**
	 * Column Info
	 * @param eCntrWgt
	 */
    public void setECntrWgt(String eCntrWgt) {
        this.eCntrWgt = eCntrWgt;
    }

    /**
	 * Column Info
	 * @param vgmWgt
	 */
    public void setVgmWgt(String vgmWgt) {
        this.vgmWgt = vgmWgt;
    }

    /**
	 * Column Info
	 * @param pre4pol
	 */
    public void setPre4pol(String pre4pol) {
        this.pre4pol = pre4pol;
    }

    /**
	 * Column Info
	 * @param hotDeFlg
	 */
    public void setHotDeFlg(String hotDeFlg) {
        this.hotDeFlg = hotDeFlg;
    }

    /**
	 * Column Info
	 * @param vgmKgs
	 */
    public void setVgmKgs(String vgmKgs) {
        this.vgmKgs = vgmKgs;
    }

    /**
	 * Column Info
	 * @param spclCgoDesc
	 */
    public void setSpclCgoDesc(String spclCgoDesc) {
        this.spclCgoDesc = spclCgoDesc;
    }

    /**
	 * Column Info
	 * @param aCntrWgt
	 */
    public void setACntrWgt(String aCntrWgt) {
        this.aCntrWgt = aCntrWgt;
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
	 * @param sealPtyTpCd
	 */
    public void setSealPtyTpCd(String sealPtyTpCd) {
        this.sealPtyTpCd = sealPtyTpCd;
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
	 * @param bbCgoFlg
	 */
    public void setBbCgoFlg(String bbCgoFlg) {
        this.bbCgoFlg = bbCgoFlg;
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
	 * @param dcgoFlg
	 */
    public void setDcgoFlg(String dcgoFlg) {
        this.dcgoFlg = dcgoFlg;
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
	 * @param rcvTermCd
	 */
    public void setRcvTermCd(String rcvTermCd) {
        this.rcvTermCd = rcvTermCd;
    }

    /**
	 * Column Info
	 * @param podYdCd
	 */
    public void setPodYdCd(String podYdCd) {
        this.podYdCd = podYdCd;
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
	 * @param post3pol
	 */
    public void setPost3pol(String post3pol) {
        this.post3pol = post3pol;
    }

    /**
	 * Column Info
	 * @param hamoTrfCd
	 */
    public void setHamoTrfCd(String hamoTrfCd) {
        this.hamoTrfCd = hamoTrfCd;
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
	 * @param pre2pol
	 */
    public void setPre2pol(String pre2pol) {
        this.pre2pol = pre2pol;
    }

    /**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
    public void setVgmMzdTpCd(String vgmMzdTpCd) {
        this.vgmMzdTpCd = vgmMzdTpCd;
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
	 * @param vent
	 */
    public void setVent(String vent) {
        this.vent = vent;
    }

    /**
	 * Column Info
	 * @param postvvd3
	 */
    public void setPostvvd3(String postvvd3) {
        this.postvvd3 = postvvd3;
    }

    /**
	 * Column Info
	 * @param postvvd2
	 */
    public void setPostvvd2(String postvvd2) {
        this.postvvd2 = postvvd2;
    }

    /**
	 * Column Info
	 * @param polNodCd
	 */
    public void setPolNodCd(String polNodCd) {
        this.polNodCd = polNodCd;
    }

    /**
	 * Column Info
	 * @param postvvd1
	 */
    public void setPostvvd1(String postvvd1) {
        this.postvvd1 = postvvd1;
    }

    /**
	 * Column Info
	 * @param apodNm
	 */
    public void setApodNm(String apodNm) {
        this.apodNm = apodNm;
    }

    /**
	 * Column Info
	 * @param post2pol
	 */
    public void setPost2pol(String post2pol) {
        this.post2pol = post2pol;
    }

    /**
	 * Column Info
	 * @param orgYdCd
	 */
    public void setOrgYdCd(String orgYdCd) {
        this.orgYdCd = orgYdCd;
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
	 * @param bpodNm
	 */
    public void setBpodNm(String bpodNm) {
        this.bpodNm = bpodNm;
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
	 * @param slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
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
	 * @param cntrNo
	 */
    public void setCntrNo(String cntrNo) {
        this.cntrNo = cntrNo;
    }

    /**
	 * Column Info
	 * @param postvvd4
	 */
    public void setPostvvd4(String postvvd4) {
        this.postvvd4 = postvvd4;
    }

    /**
	 * Column Info
	 * @param hngrFlg
	 */
    public void setHngrFlg(String hngrFlg) {
        this.hngrFlg = hngrFlg;
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
	 * @param vgmVrfySigCtnt
	 */
    public void setVgmVrfySigCtnt(String vgmVrfySigCtnt) {
        this.vgmVrfySigCtnt = vgmVrfySigCtnt;
    }

    /**
	 * Column Info
	 * @param cntrSealNo
	 */
    public void setCntrSealNo(String cntrSealNo) {
        this.cntrSealNo = cntrSealNo;
    }

    public void setOblSerNo(String oblSerNo) {
        this.oblSerNo = oblSerNo;
    }

    public String getOblSerNo() {
        return this.oblSerNo;
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
        setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
        setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
        setApolNm(JSPUtil.getParameter(request, prefix + "apol_nm", ""));
        setSealKndCd(JSPUtil.getParameter(request, prefix + "seal_knd_cd", ""));
        setBlckStwgCd(JSPUtil.getParameter(request, prefix + "blck_stwg_cd", ""));
        setPre3pol(JSPUtil.getParameter(request, prefix + "pre3pol", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setSpclCgoDescType(JSPUtil.getParameter(request, prefix + "spcl_cgo_desc_type", ""));
        setAPodCd(JSPUtil.getParameter(request, prefix + "a_pod_cd", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
        setPre1pol(JSPUtil.getParameter(request, prefix + "pre1pol", ""));
        setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
        setWoFlg(JSPUtil.getParameter(request, prefix + "wo_flg", ""));
        setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
        setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
        setOutVvdCd(JSPUtil.getParameter(request, prefix + "out_vvd_cd", ""));
        setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
        setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
        setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
        setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
        setBpolNm(JSPUtil.getParameter(request, prefix + "bpol_nm", ""));
        setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
        setPost4pol(JSPUtil.getParameter(request, prefix + "post4pol", ""));
        setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
        setTrunkvvd(JSPUtil.getParameter(request, prefix + "trunkvvd", ""));
        setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
        setCnmvEvntDt(JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", ""));
        setPost1pol(JSPUtil.getParameter(request, prefix + "post1pol", ""));
        setBlckStwgHubLocCd(JSPUtil.getParameter(request, prefix + "blck_stwg_hub_loc_cd", ""));
        setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
        setPorNm(JSPUtil.getParameter(request, prefix + "por_nm", ""));
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
        setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
        setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
        setCntrNo2(JSPUtil.getParameter(request, prefix + "cntr_no2", ""));
        setPrevvd3(JSPUtil.getParameter(request, prefix + "prevvd3", ""));
        setPrevvd4(JSPUtil.getParameter(request, prefix + "prevvd4", ""));
        setPrevvd1(JSPUtil.getParameter(request, prefix + "prevvd1", ""));
        setPrevvd2(JSPUtil.getParameter(request, prefix + "prevvd2", ""));
        setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
        setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
        setTsCd(JSPUtil.getParameter(request, prefix + "ts_cd", ""));
        setAPolCd(JSPUtil.getParameter(request, prefix + "a_pol_cd", ""));
        setECntrWgt(JSPUtil.getParameter(request, prefix + "e_cntr_wgt", ""));
        setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
        setPre4pol(JSPUtil.getParameter(request, prefix + "pre4pol", ""));
        setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
        setVgmKgs(JSPUtil.getParameter(request, prefix + "vgm_kgs", ""));
        setSpclCgoDesc(JSPUtil.getParameter(request, prefix + "spcl_cgo_desc", ""));
        setACntrWgt(JSPUtil.getParameter(request, prefix + "a_cntr_wgt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSealPtyTpCd(JSPUtil.getParameter(request, prefix + "seal_pty_tp_cd", ""));
        setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
        setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
        setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
        setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
        setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
        setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
        setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
        setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
        setPost3pol(JSPUtil.getParameter(request, prefix + "post3pol", ""));
        setHamoTrfCd(JSPUtil.getParameter(request, prefix + "hamo_trf_cd", ""));
        setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
        setPre2pol(JSPUtil.getParameter(request, prefix + "pre2pol", ""));
        setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
        setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
        setVent(JSPUtil.getParameter(request, prefix + "vent", ""));
        setPostvvd3(JSPUtil.getParameter(request, prefix + "postvvd3", ""));
        setPostvvd2(JSPUtil.getParameter(request, prefix + "postvvd2", ""));
        setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
        setPostvvd1(JSPUtil.getParameter(request, prefix + "postvvd1", ""));
        setApodNm(JSPUtil.getParameter(request, prefix + "apod_nm", ""));
        setPost2pol(JSPUtil.getParameter(request, prefix + "post2pol", ""));
        setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
        setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
        setBpodNm(JSPUtil.getParameter(request, prefix + "bpod_nm", ""));
        setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
        setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
        setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
        setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
        setPostvvd4(JSPUtil.getParameter(request, prefix + "postvvd4", ""));
        setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
        setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
        setVgmVrfySigCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", ""));
        setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
        setOblSerNo(JSPUtil.getParameter(request, prefix + "obl_ser_no", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllCdlDetailVO[]
	 */
    public KorCllCdlDetailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCllCdlDetailVO[]
	 */
    public KorCllCdlDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        KorCllCdlDetailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", length));
            String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
            String[] apolNm = (JSPUtil.getParameter(request, prefix + "apol_nm", length));
            String[] sealKndCd = (JSPUtil.getParameter(request, prefix + "seal_knd_cd", length));
            String[] blckStwgCd = (JSPUtil.getParameter(request, prefix + "blck_stwg_cd", length));
            String[] pre3pol = (JSPUtil.getParameter(request, prefix + "pre3pol", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] spclCgoDescType = (JSPUtil.getParameter(request, prefix + "spcl_cgo_desc_type", length));
            String[] aPodCd = (JSPUtil.getParameter(request, prefix + "a_pod_cd", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
            String[] pre1pol = (JSPUtil.getParameter(request, prefix + "pre1pol", length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
            String[] woFlg = (JSPUtil.getParameter(request, prefix + "wo_flg", length));
            String[] prctFlg = (JSPUtil.getParameter(request, prefix + "prct_flg", length));
            String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", length));
            String[] outVvdCd = (JSPUtil.getParameter(request, prefix + "out_vvd_cd", length));
            String[] stwgCd = (JSPUtil.getParameter(request, prefix + "stwg_cd", length));
            String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", length));
            String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", length));
            String[] delNodCd = (JSPUtil.getParameter(request, prefix + "del_nod_cd", length));
            String[] bpolNm = (JSPUtil.getParameter(request, prefix + "bpol_nm", length));
            String[] cntrWgt = (JSPUtil.getParameter(request, prefix + "cntr_wgt", length));
            String[] post4pol = (JSPUtil.getParameter(request, prefix + "post4pol", length));
            String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix + "awk_cgo_flg", length));
            String[] trunkvvd = (JSPUtil.getParameter(request, prefix + "trunkvvd", length));
            String[] delCd = (JSPUtil.getParameter(request, prefix + "del_cd", length));
            String[] cnmvEvntDt = (JSPUtil.getParameter(request, prefix + "cnmv_evnt_dt", length));
            String[] post1pol = (JSPUtil.getParameter(request, prefix + "post1pol", length));
            String[] blckStwgHubLocCd = (JSPUtil.getParameter(request, prefix + "blck_stwg_hub_loc_cd", length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
            String[] porNm = (JSPUtil.getParameter(request, prefix + "por_nm", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] podNodCd = (JSPUtil.getParameter(request, prefix + "pod_nod_cd", length));
            String[] rcFlg = (JSPUtil.getParameter(request, prefix + "rc_flg", length));
            String[] porCd = (JSPUtil.getParameter(request, prefix + "por_cd", length));
            String[] cntrNo2 = (JSPUtil.getParameter(request, prefix + "cntr_no2", length));
            String[] prevvd3 = (JSPUtil.getParameter(request, prefix + "prevvd3", length));
            String[] prevvd4 = (JSPUtil.getParameter(request, prefix + "prevvd4", length));
            String[] prevvd1 = (JSPUtil.getParameter(request, prefix + "prevvd1", length));
            String[] prevvd2 = (JSPUtil.getParameter(request, prefix + "prevvd2", length));
            String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
            String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix + "rd_cgo_flg", length));
            String[] tsCd = (JSPUtil.getParameter(request, prefix + "ts_cd", length));
            String[] aPolCd = (JSPUtil.getParameter(request, prefix + "a_pol_cd", length));
            String[] eCntrWgt = (JSPUtil.getParameter(request, prefix + "e_cntr_wgt", length));
            String[] vgmWgt = (JSPUtil.getParameter(request, prefix + "vgm_wgt", length));
            String[] pre4pol = (JSPUtil.getParameter(request, prefix + "pre4pol", length));
            String[] hotDeFlg = (JSPUtil.getParameter(request, prefix + "hot_de_flg", length));
            String[] vgmKgs = (JSPUtil.getParameter(request, prefix + "vgm_kgs", length));
            String[] spclCgoDesc = (JSPUtil.getParameter(request, prefix + "spcl_cgo_desc", length));
            String[] aCntrWgt = (JSPUtil.getParameter(request, prefix + "a_cntr_wgt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sealPtyTpCd = (JSPUtil.getParameter(request, prefix + "seal_pty_tp_cd", length));
            String[] cstmsDesc = (JSPUtil.getParameter(request, prefix + "cstms_desc", length));
            String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix + "bb_cgo_flg", length));
            String[] measQty = (JSPUtil.getParameter(request, prefix + "meas_qty", length));
            String[] dcgoFlg = (JSPUtil.getParameter(request, prefix + "dcgo_flg", length));
            String[] pckQty = (JSPUtil.getParameter(request, prefix + "pck_qty", length));
            String[] rcvTermCd = (JSPUtil.getParameter(request, prefix + "rcv_term_cd", length));
            String[] podYdCd = (JSPUtil.getParameter(request, prefix + "pod_yd_cd", length));
            String[] pckTpCd = (JSPUtil.getParameter(request, prefix + "pck_tp_cd", length));
            String[] post3pol = (JSPUtil.getParameter(request, prefix + "post3pol", length));
            String[] hamoTrfCd = (JSPUtil.getParameter(request, prefix + "hamo_trf_cd", length));
            String[] porNodCd = (JSPUtil.getParameter(request, prefix + "por_nod_cd", length));
            String[] pre2pol = (JSPUtil.getParameter(request, prefix + "pre2pol", length));
            String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", length));
            String[] delNm = (JSPUtil.getParameter(request, prefix + "del_nm", length));
            String[] vent = (JSPUtil.getParameter(request, prefix + "vent", length));
            String[] postvvd3 = (JSPUtil.getParameter(request, prefix + "postvvd3", length));
            String[] postvvd2 = (JSPUtil.getParameter(request, prefix + "postvvd2", length));
            String[] polNodCd = (JSPUtil.getParameter(request, prefix + "pol_nod_cd", length));
            String[] postvvd1 = (JSPUtil.getParameter(request, prefix + "postvvd1", length));
            String[] apodNm = (JSPUtil.getParameter(request, prefix + "apod_nm", length));
            String[] post2pol = (JSPUtil.getParameter(request, prefix + "post2pol", length));
            String[] orgYdCd = (JSPUtil.getParameter(request, prefix + "org_yd_cd", length));
            String[] socFlg = (JSPUtil.getParameter(request, prefix + "soc_flg", length));
            String[] bpodNm = (JSPUtil.getParameter(request, prefix + "bpod_nm", length));
            String[] deTermCd = (JSPUtil.getParameter(request, prefix + "de_term_cd", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] polYdCd = (JSPUtil.getParameter(request, prefix + "pol_yd_cd", length));
            String[] cntrNo = (JSPUtil.getParameter(request, prefix + "cntr_no", length));
            String[] postvvd4 = (JSPUtil.getParameter(request, prefix + "postvvd4", length));
            String[] hngrFlg = (JSPUtil.getParameter(request, prefix + "hngr_flg", length));
            String[] seq = (JSPUtil.getParameter(request, prefix + "seq", length));
            String[] vgmVrfySigCtnt = (JSPUtil.getParameter(request, prefix + "vgm_vrfy_sig_ctnt", length));
            String[] cntrSealNo = (JSPUtil.getParameter(request, prefix + "cntr_seal_no", length));
            String[] oblSerNo = (JSPUtil.getParameter(request, prefix + "obl_ser_no", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new KorCllCdlDetailVO();
                if (vgmWgtUtCd[i] != null)
                    model.setVgmWgtUtCd(vgmWgtUtCd[i]);
                if (bkgCgoTpCd[i] != null)
                    model.setBkgCgoTpCd(bkgCgoTpCd[i]);
                if (apolNm[i] != null)
                    model.setApolNm(apolNm[i]);
                if (sealKndCd[i] != null)
                    model.setSealKndCd(sealKndCd[i]);
                if (blckStwgCd[i] != null)
                    model.setBlckStwgCd(blckStwgCd[i]);
                if (pre3pol[i] != null)
                    model.setPre3pol(pre3pol[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (spclCgoDescType[i] != null)
                    model.setSpclCgoDescType(spclCgoDescType[i]);
                if (aPodCd[i] != null)
                    model.setAPodCd(aPodCd[i]);
                if (polCd[i] != null)
                    model.setPolCd(polCd[i]);
                if (pre1pol[i] != null)
                    model.setPre1pol(pre1pol[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (woFlg[i] != null)
                    model.setWoFlg(woFlg[i]);
                if (prctFlg[i] != null)
                    model.setPrctFlg(prctFlg[i]);
                if (cntrTpszCd[i] != null)
                    model.setCntrTpszCd(cntrTpszCd[i]);
                if (outVvdCd[i] != null)
                    model.setOutVvdCd(outVvdCd[i]);
                if (stwgCd[i] != null)
                    model.setStwgCd(stwgCd[i]);
                if (cmdtHsCd[i] != null)
                    model.setCmdtHsCd(cmdtHsCd[i]);
                if (custToOrdFlg[i] != null)
                    model.setCustToOrdFlg(custToOrdFlg[i]);
                if (delNodCd[i] != null)
                    model.setDelNodCd(delNodCd[i]);
                if (bpolNm[i] != null)
                    model.setBpolNm(bpolNm[i]);
                if (cntrWgt[i] != null)
                    model.setCntrWgt(cntrWgt[i]);
                if (post4pol[i] != null)
                    model.setPost4pol(post4pol[i]);
                if (awkCgoFlg[i] != null)
                    model.setAwkCgoFlg(awkCgoFlg[i]);
                if (trunkvvd[i] != null)
                    model.setTrunkvvd(trunkvvd[i]);
                if (delCd[i] != null)
                    model.setDelCd(delCd[i]);
                if (cnmvEvntDt[i] != null)
                    model.setCnmvEvntDt(cnmvEvntDt[i]);
                if (post1pol[i] != null)
                    model.setPost1pol(post1pol[i]);
                if (blckStwgHubLocCd[i] != null)
                    model.setBlckStwgHubLocCd(blckStwgHubLocCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (porNm[i] != null)
                    model.setPorNm(porNm[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (podNodCd[i] != null)
                    model.setPodNodCd(podNodCd[i]);
                if (rcFlg[i] != null)
                    model.setRcFlg(rcFlg[i]);
                if (porCd[i] != null)
                    model.setPorCd(porCd[i]);
                if (cntrNo2[i] != null)
                    model.setCntrNo2(cntrNo2[i]);
                if (prevvd3[i] != null)
                    model.setPrevvd3(prevvd3[i]);
                if (prevvd4[i] != null)
                    model.setPrevvd4(prevvd4[i]);
                if (prevvd1[i] != null)
                    model.setPrevvd1(prevvd1[i]);
                if (prevvd2[i] != null)
                    model.setPrevvd2(prevvd2[i]);
                if (custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if (rdCgoFlg[i] != null)
                    model.setRdCgoFlg(rdCgoFlg[i]);
                if (tsCd[i] != null)
                    model.setTsCd(tsCd[i]);
                if (aPolCd[i] != null)
                    model.setAPolCd(aPolCd[i]);
                if (eCntrWgt[i] != null)
                    model.setECntrWgt(eCntrWgt[i]);
                if (vgmWgt[i] != null)
                    model.setVgmWgt(vgmWgt[i]);
                if (pre4pol[i] != null)
                    model.setPre4pol(pre4pol[i]);
                if (hotDeFlg[i] != null)
                    model.setHotDeFlg(hotDeFlg[i]);
                if (vgmKgs[i] != null)
                    model.setVgmKgs(vgmKgs[i]);
                if (spclCgoDesc[i] != null)
                    model.setSpclCgoDesc(spclCgoDesc[i]);
                if (aCntrWgt[i] != null)
                    model.setACntrWgt(aCntrWgt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sealPtyTpCd[i] != null)
                    model.setSealPtyTpCd(sealPtyTpCd[i]);
                if (cstmsDesc[i] != null)
                    model.setCstmsDesc(cstmsDesc[i]);
                if (bbCgoFlg[i] != null)
                    model.setBbCgoFlg(bbCgoFlg[i]);
                if (measQty[i] != null)
                    model.setMeasQty(measQty[i]);
                if (dcgoFlg[i] != null)
                    model.setDcgoFlg(dcgoFlg[i]);
                if (pckQty[i] != null)
                    model.setPckQty(pckQty[i]);
                if (rcvTermCd[i] != null)
                    model.setRcvTermCd(rcvTermCd[i]);
                if (podYdCd[i] != null)
                    model.setPodYdCd(podYdCd[i]);
                if (pckTpCd[i] != null)
                    model.setPckTpCd(pckTpCd[i]);
                if (post3pol[i] != null)
                    model.setPost3pol(post3pol[i]);
                if (hamoTrfCd[i] != null)
                    model.setHamoTrfCd(hamoTrfCd[i]);
                if (porNodCd[i] != null)
                    model.setPorNodCd(porNodCd[i]);
                if (pre2pol[i] != null)
                    model.setPre2pol(pre2pol[i]);
                if (vgmMzdTpCd[i] != null)
                    model.setVgmMzdTpCd(vgmMzdTpCd[i]);
                if (delNm[i] != null)
                    model.setDelNm(delNm[i]);
                if (vent[i] != null)
                    model.setVent(vent[i]);
                if (postvvd3[i] != null)
                    model.setPostvvd3(postvvd3[i]);
                if (postvvd2[i] != null)
                    model.setPostvvd2(postvvd2[i]);
                if (polNodCd[i] != null)
                    model.setPolNodCd(polNodCd[i]);
                if (postvvd1[i] != null)
                    model.setPostvvd1(postvvd1[i]);
                if (apodNm[i] != null)
                    model.setApodNm(apodNm[i]);
                if (post2pol[i] != null)
                    model.setPost2pol(post2pol[i]);
                if (orgYdCd[i] != null)
                    model.setOrgYdCd(orgYdCd[i]);
                if (socFlg[i] != null)
                    model.setSocFlg(socFlg[i]);
                if (bpodNm[i] != null)
                    model.setBpodNm(bpodNm[i]);
                if (deTermCd[i] != null)
                    model.setDeTermCd(deTermCd[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (polYdCd[i] != null)
                    model.setPolYdCd(polYdCd[i]);
                if (cntrNo[i] != null)
                    model.setCntrNo(cntrNo[i]);
                if (postvvd4[i] != null)
                    model.setPostvvd4(postvvd4[i]);
                if (hngrFlg[i] != null)
                    model.setHngrFlg(hngrFlg[i]);
                if (seq[i] != null)
                    model.setSeq(seq[i]);
                if (vgmVrfySigCtnt[i] != null)
                    model.setVgmVrfySigCtnt(vgmVrfySigCtnt[i]);
                if (cntrSealNo[i] != null)
                    model.setCntrSealNo(cntrSealNo[i]);
                if (oblSerNo[i] != null) 
		    		model.setOblSerNo(oblSerNo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getKorCllCdlDetailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return KorCllCdlDetailVO[]
	 */
    public KorCllCdlDetailVO[] getKorCllCdlDetailVOs() {
        KorCllCdlDetailVO[] vos = (KorCllCdlDetailVO[]) models.toArray(new KorCllCdlDetailVO[models.size()]);
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
        this.vgmWgtUtCd = this.vgmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apolNm = this.apolNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealKndCd = this.sealKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blckStwgCd = this.blckStwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre3pol = this.pre3pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoDescType = this.spclCgoDescType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aPodCd = this.aPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre1pol = this.pre1pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.woFlg = this.woFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prctFlg = this.prctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrTpszCd = this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.outVvdCd = this.outVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgCd = this.stwgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdtHsCd = this.cmdtHsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custToOrdFlg = this.custToOrdFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNodCd = this.delNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bpolNm = this.bpolNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrWgt = this.cntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post4pol = this.post4pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.awkCgoFlg = this.awkCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trunkvvd = this.trunkvvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnmvEvntDt = this.cnmvEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post1pol = this.post1pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blckStwgHubLocCd = this.blckStwgHubLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNm = this.porNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podNodCd = this.podNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcFlg = this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo2 = this.cntrNo2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prevvd3 = this.prevvd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prevvd4 = this.prevvd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prevvd1 = this.prevvd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prevvd2 = this.prevvd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.custNm = this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rdCgoFlg = this.rdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsCd = this.tsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aPolCd = this.aPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eCntrWgt = this.eCntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmWgt = this.vgmWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre4pol = this.pre4pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hotDeFlg = this.hotDeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmKgs = this.vgmKgs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.spclCgoDesc = this.spclCgoDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aCntrWgt = this.aCntrWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sealPtyTpCd = this.sealPtyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cstmsDesc = this.cstmsDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bbCgoFlg = this.bbCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.measQty = this.measQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dcgoFlg = this.dcgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckQty = this.pckQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podYdCd = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pckTpCd = this.pckTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post3pol = this.post3pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hamoTrfCd = this.hamoTrfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.porNodCd = this.porNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pre2pol = this.pre2pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmMzdTpCd = this.vgmMzdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.delNm = this.delNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vent = this.vent.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.postvvd3 = this.postvvd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.postvvd2 = this.postvvd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polNodCd = this.polNodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.postvvd1 = this.postvvd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.apodNm = this.apodNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.post2pol = this.post2pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.orgYdCd = this.orgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.socFlg = this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bpodNm = this.bpodNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polYdCd = this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrNo = this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.postvvd4 = this.postvvd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hngrFlg = this.hngrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seq = this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vgmVrfySigCtnt = this.vgmVrfySigCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cntrSealNo = this.cntrSealNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.oblSerNo = this.oblSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
