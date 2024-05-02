/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchUSIORListVO.java
*@FileTitle : SearchUSIORListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.04.10 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.visibilitymanage.vesselreport.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchUSIORListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUSIORListVO> models = new ArrayList<SearchUSIORListVO>();
	
	/* Column Info */
	private String guide = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String rlSoFlg = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Column Info */
	private String drSoFlg = null;
	/* Column Info */
	private String tsSoPlnFlg = null;
	/* Column Info */
	private String dupFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String unmatchFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String mvmtYd = null;
	/* Column Info */
	private String spe = null;
	/* Column Info */
	private String pkupAvalDt = null;
	/* Column Info */
	private String bkgCntrRmk = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String itNo = null;
	/* Column Info */
	private String addTrsp = null;
	/* Column Info */
	private String drSpNm = null;
	/* Column Info */
	private String drTo = null;
	/* Column Info */
	private String tsWoFlg = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String cstmsLocCd = null;
	/* Column Info */
	private String railDest = null;
	/* Column Info */
	private String tcSoFlg = null;
	/* Column Info */
	private String copDelCd = null;
	/* Column Info */
	private String dspoCd = null;
	/* Column Info */
	private String drSoPlnFlg = null;
	/* Column Info */
	private String rlWoFlg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String pkupFreeDt = null;
	/* Column Info */
	private String poNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String mvmtDt = null;
	/* Column Info */
	private String clmLoc = null;
	/* Column Info */
	private String drSp = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String from = null;
	/* Column Info */
	private String tcSoPlnFlg = null;
	/* Column Info */
	private String lane = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String clmState = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String pkupOfcCd = null;
	/* Column Info */
	private String drWoDt = null;
	/* Column Info */
	private String itDate = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String filer = null;
	/* Column Info */
	private String f = null;
	/* Column Info */
	private String mvmtSts = null;
	/* Column Info */
	private String drFm = null;
	/* Column Info */
	private String c = null;
	/* Column Info */
	private String clmCrntSts = null;
	/* Column Info */
	private String o = null;
	/* Column Info */
	private String clmDt = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String tsSoFlg = null;
	/* Column Info */
	private String copPodCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String pkupEnd = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String drWoFlg = null;
	/* Column Info */
	private String rlSoPlnFlg = null;
	/* Column Info */
	private String tcWoFlg = null;
	/* Column Info */
	private String ediSndTpCd = null;
	/* Column Info */
	private String ediSndDt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchUSIORListVO() {}

	public SearchUSIORListVO(String ibflag, String pagerows, String bkgNo, String blNo, String unmatchFlg, String bkgPodCd, String bkgDelCd, String copPodCd, String copDelCd, String cntrNo, String tpsz, String mvmtSts, String mvmtYd, String mvmtDt, String dupFlg, String vvd, String lane, String eta, String spe, String railDest, String cstmsLocCd, String eqCtrlOfcCd, String term, String addTrsp, String rlSoPlnFlg, String rlSoFlg, String rlWoFlg, String tsSoPlnFlg, String tsSoFlg, String tsWoFlg, String tcSoPlnFlg, String tcSoFlg, String tcWoFlg, String drSoPlnFlg, String drSoFlg, String drWoFlg, String drWoDt, String drFm, String drTo, String drSp, String drSpNm, String copStsCd, String from, String guide, String pkupYdCd, String pkupAvalDt, String pkupFreeDt, String f, String o, String c, String dspoCd, String pkupNo, String pkupOfcCd, String pkupEnd, String scNo, String cneeNm, String cneeAddr, String shprNm, String shprAddr, String ntfyNm, String ntfyAddr, String filer, String itNo, String itDate, String poNo, String sealNo, String cntrWgt, String clmCrntSts, String clmLoc, String clmState, String clmDt, String bkgCntrRmk
			                 ,String ediSndTpCd , String ediSndDt ,String vndrSeq , String vndrName) {
		this.guide = guide;
		this.eta = eta;
		this.rlSoFlg = rlSoFlg;
		this.cneeAddr = cneeAddr;
		this.drSoFlg = drSoFlg;
		this.tsSoPlnFlg = tsSoPlnFlg;
		this.dupFlg = dupFlg;
		this.blNo = blNo;
		this.unmatchFlg = unmatchFlg;
		this.pagerows = pagerows;
		this.pkupYdCd = pkupYdCd;
		this.bkgPodCd = bkgPodCd;
		this.mvmtYd = mvmtYd;
		this.spe = spe;
		this.pkupAvalDt = pkupAvalDt;
		this.bkgCntrRmk = bkgCntrRmk;
		this.scNo = scNo;
		this.copStsCd = copStsCd;
		this.itNo = itNo;
		this.addTrsp = addTrsp;
		this.drSpNm = drSpNm;
		this.drTo = drTo;
		this.tsWoFlg = tsWoFlg;
		this.cntrWgt = cntrWgt;
		this.cstmsLocCd = cstmsLocCd;
		this.railDest = railDest;
		this.tcSoFlg = tcSoFlg;
		this.copDelCd = copDelCd;
		this.dspoCd = dspoCd;
		this.drSoPlnFlg = drSoPlnFlg;
		this.rlWoFlg = rlWoFlg;
		this.vvd = vvd;
		this.pkupFreeDt = pkupFreeDt;
		this.poNo = poNo;
		this.bkgNo = bkgNo;
		this.tpsz = tpsz;
		this.mvmtDt = mvmtDt;
		this.clmLoc = clmLoc;
		this.drSp = drSp;
		this.pkupNo = pkupNo;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.from = from;
		this.tcSoPlnFlg = tcSoPlnFlg;
		this.lane = lane;
		this.ibflag = ibflag;
		this.shprAddr = shprAddr;
		this.clmState = clmState;
		this.bkgDelCd = bkgDelCd;
		this.pkupOfcCd = pkupOfcCd;
		this.drWoDt = drWoDt;
		this.itDate = itDate;
		this.shprNm = shprNm;
		this.ntfyAddr = ntfyAddr;
		this.sealNo = sealNo;
		this.filer = filer;
		this.f = f;
		this.mvmtSts = mvmtSts;
		this.drFm = drFm;
		this.c = c;
		this.clmCrntSts = clmCrntSts;
		this.o = o;
		this.clmDt = clmDt;
		this.ntfyNm = ntfyNm;
		this.tsSoFlg = tsSoFlg;
		this.copPodCd = copPodCd;
		this.cneeNm = cneeNm;
		this.pkupEnd = pkupEnd;
		this.term = term;
		this.cntrNo = cntrNo;
		this.drWoFlg = drWoFlg;
		this.rlSoPlnFlg = rlSoPlnFlg;
		this.tcWoFlg = tcWoFlg;
		this.ediSndDt = ediSndDt;
		this.ediSndTpCd = ediSndTpCd;
		this.vndrSeq = vndrSeq;
		this.vndrName = vndrName;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("guide", getGuide());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("rl_so_flg", getRlSoFlg());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("dr_so_flg", getDrSoFlg());
		this.hashColumns.put("ts_so_pln_flg", getTsSoPlnFlg());
		this.hashColumns.put("dup_flg", getDupFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("unmatch_flg", getUnmatchFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("mvmt_yd", getMvmtYd());
		this.hashColumns.put("spe", getSpe());
		this.hashColumns.put("pkup_aval_dt", getPkupAvalDt());
		this.hashColumns.put("bkg_cntr_rmk", getBkgCntrRmk());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("it_no", getItNo());
		this.hashColumns.put("add_trsp", getAddTrsp());
		this.hashColumns.put("dr_sp_nm", getDrSpNm());
		this.hashColumns.put("dr_to", getDrTo());
		this.hashColumns.put("ts_wo_flg", getTsWoFlg());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("cstms_loc_cd", getCstmsLocCd());
		this.hashColumns.put("rail_dest", getRailDest());
		this.hashColumns.put("tc_so_flg", getTcSoFlg());
		this.hashColumns.put("cop_del_cd", getCopDelCd());
		this.hashColumns.put("dspo_cd", getDspoCd());
		this.hashColumns.put("dr_so_pln_flg", getDrSoPlnFlg());
		this.hashColumns.put("rl_wo_flg", getRlWoFlg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pkup_free_dt", getPkupFreeDt());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("mvmt_dt", getMvmtDt());
		this.hashColumns.put("clm_loc", getClmLoc());
		this.hashColumns.put("dr_sp", getDrSp());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("from", getFrom());
		this.hashColumns.put("tc_so_pln_flg", getTcSoPlnFlg());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("clm_state", getClmState());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("pkup_ofc_cd", getPkupOfcCd());
		this.hashColumns.put("dr_wo_dt", getDrWoDt());
		this.hashColumns.put("it_date", getItDate());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("filer", getFiler());
		this.hashColumns.put("f", getF());
		this.hashColumns.put("mvmt_sts", getMvmtSts());
		this.hashColumns.put("dr_fm", getDrFm());
		this.hashColumns.put("c", getC());
		this.hashColumns.put("clm_crnt_sts", getClmCrntSts());
		this.hashColumns.put("o", getO());
		this.hashColumns.put("clm_dt", getClmDt());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("ts_so_flg", getTsSoFlg());
		this.hashColumns.put("cop_pod_cd", getCopPodCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("pkup_end", getPkupEnd());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dr_wo_flg", getDrWoFlg());
		this.hashColumns.put("rl_so_pln_flg", getRlSoPlnFlg());
		this.hashColumns.put("tc_wo_flg", getTcWoFlg());
		this.hashColumns.put("edi_snd_tp_cd", getEdiSndTpCd());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_name", getVndrName());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("guide", "guide");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("rl_so_flg", "rlSoFlg");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("dr_so_flg", "drSoFlg");
		this.hashFields.put("ts_so_pln_flg", "tsSoPlnFlg");
		this.hashFields.put("dup_flg", "dupFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("unmatch_flg", "unmatchFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("mvmt_yd", "mvmtYd");
		this.hashFields.put("spe", "spe");
		this.hashFields.put("pkup_aval_dt", "pkupAvalDt");
		this.hashFields.put("bkg_cntr_rmk", "bkgCntrRmk");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("it_no", "itNo");
		this.hashFields.put("add_trsp", "addTrsp");
		this.hashFields.put("dr_sp_nm", "drSpNm");
		this.hashFields.put("dr_to", "drTo");
		this.hashFields.put("ts_wo_flg", "tsWoFlg");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cstms_loc_cd", "cstmsLocCd");
		this.hashFields.put("rail_dest", "railDest");
		this.hashFields.put("tc_so_flg", "tcSoFlg");
		this.hashFields.put("cop_del_cd", "copDelCd");
		this.hashFields.put("dspo_cd", "dspoCd");
		this.hashFields.put("dr_so_pln_flg", "drSoPlnFlg");
		this.hashFields.put("rl_wo_flg", "rlWoFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pkup_free_dt", "pkupFreeDt");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("mvmt_dt", "mvmtDt");
		this.hashFields.put("clm_loc", "clmLoc");
		this.hashFields.put("dr_sp", "drSp");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("from", "from");
		this.hashFields.put("tc_so_pln_flg", "tcSoPlnFlg");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("clm_state", "clmState");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("pkup_ofc_cd", "pkupOfcCd");
		this.hashFields.put("dr_wo_dt", "drWoDt");
		this.hashFields.put("it_date", "itDate");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("filer", "filer");
		this.hashFields.put("f", "f");
		this.hashFields.put("mvmt_sts", "mvmtSts");
		this.hashFields.put("dr_fm", "drFm");
		this.hashFields.put("c", "c");
		this.hashFields.put("clm_crnt_sts", "clmCrntSts");
		this.hashFields.put("o", "o");
		this.hashFields.put("clm_dt", "clmDt");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("ts_so_flg", "tsSoFlg");
		this.hashFields.put("cop_pod_cd", "copPodCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("pkup_end", "pkupEnd");
		this.hashFields.put("term", "term");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dr_wo_flg", "drWoFlg");
		this.hashFields.put("rl_so_pln_flg", "rlSoPlnFlg");
		this.hashFields.put("tc_wo_flg", "tcWoFlg");
		this.hashFields.put("edi_snd_tp_cd", "ediSndTpCd");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_name", "vndrName");
		return this.hashFields;
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
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return rlSoFlg
	 */
	public String getRlSoFlg() {
		return this.rlSoFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
	}
	
	/**
	 * Column Info
	 * @return drSoFlg
	 */
	public String getDrSoFlg() {
		return this.drSoFlg;
	}
	
	/**
	 * Column Info
	 * @return tsSoPlnFlg
	 */
	public String getTsSoPlnFlg() {
		return this.tsSoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return dupFlg
	 */
	public String getDupFlg() {
		return this.dupFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return unmatchFlg
	 */
	public String getUnmatchFlg() {
		return this.unmatchFlg;
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
	 * @return pkupYdCd
	 */
	public String getPkupYdCd() {
		return this.pkupYdCd;
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
	 * @return mvmtYd
	 */
	public String getMvmtYd() {
		return this.mvmtYd;
	}
	
	/**
	 * Column Info
	 * @return spe
	 */
	public String getSpe() {
		return this.spe;
	}
	
	/**
	 * Column Info
	 * @return pkupAvalDt
	 */
	public String getPkupAvalDt() {
		return this.pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCntrRmk
	 */
	public String getBkgCntrRmk() {
		return this.bkgCntrRmk;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return itNo
	 */
	public String getItNo() {
		return this.itNo;
	}
	
	/**
	 * Column Info
	 * @return addTrsp
	 */
	public String getAddTrsp() {
		return this.addTrsp;
	}
	
	/**
	 * Column Info
	 * @return drSpNm
	 */
	public String getDrSpNm() {
		return this.drSpNm;
	}
	
	/**
	 * Column Info
	 * @return drTo
	 */
	public String getDrTo() {
		return this.drTo;
	}
	
	/**
	 * Column Info
	 * @return tsWoFlg
	 */
	public String getTsWoFlg() {
		return this.tsWoFlg;
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
	 * @return cstmsLocCd
	 */
	public String getCstmsLocCd() {
		return this.cstmsLocCd;
	}
	
	/**
	 * Column Info
	 * @return railDest
	 */
	public String getRailDest() {
		return this.railDest;
	}
	
	/**
	 * Column Info
	 * @return tcSoFlg
	 */
	public String getTcSoFlg() {
		return this.tcSoFlg;
	}
	
	/**
	 * Column Info
	 * @return copDelCd
	 */
	public String getCopDelCd() {
		return this.copDelCd;
	}
	
	/**
	 * Column Info
	 * @return dspoCd
	 */
	public String getDspoCd() {
		return this.dspoCd;
	}
	
	/**
	 * Column Info
	 * @return drSoPlnFlg
	 */
	public String getDrSoPlnFlg() {
		return this.drSoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return rlWoFlg
	 */
	public String getRlWoFlg() {
		return this.rlWoFlg;
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
	 * @return pkupFreeDt
	 */
	public String getPkupFreeDt() {
		return this.pkupFreeDt;
	}
	
	/**
	 * Column Info
	 * @return poNo
	 */
	public String getPoNo() {
		return this.poNo;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return mvmtDt
	 */
	public String getMvmtDt() {
		return this.mvmtDt;
	}
	
	/**
	 * Column Info
	 * @return clmLoc
	 */
	public String getClmLoc() {
		return this.clmLoc;
	}
	
	/**
	 * Column Info
	 * @return drSp
	 */
	public String getDrSp() {
		return this.drSp;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return from
	 */
	public String getFrom() {
		return this.from;
	}
	
	/**
	 * Column Info
	 * @return tcSoPlnFlg
	 */
	public String getTcSoPlnFlg() {
		return this.tcSoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return clmState
	 */
	public String getClmState() {
		return this.clmState;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @return pkupOfcCd
	 */
	public String getPkupOfcCd() {
		return this.pkupOfcCd;
	}
	
	/**
	 * Column Info
	 * @return drWoDt
	 */
	public String getDrWoDt() {
		return this.drWoDt;
	}
	
	/**
	 * Column Info
	 * @return itDate
	 */
	public String getItDate() {
		return this.itDate;
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
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return filer
	 */
	public String getFiler() {
		return this.filer;
	}
	
	/**
	 * Column Info
	 * @return f
	 */
	public String getF() {
		return this.f;
	}
	
	/**
	 * Column Info
	 * @return mvmtSts
	 */
	public String getMvmtSts() {
		return this.mvmtSts;
	}
	
	/**
	 * Column Info
	 * @return drFm
	 */
	public String getDrFm() {
		return this.drFm;
	}
	
	/**
	 * Column Info
	 * @return c
	 */
	public String getC() {
		return this.c;
	}
	
	/**
	 * Column Info
	 * @return clmCrntSts
	 */
	public String getClmCrntSts() {
		return this.clmCrntSts;
	}
	
	/**
	 * Column Info
	 * @return o
	 */
	public String getO() {
		return this.o;
	}
	
	/**
	 * Column Info
	 * @return clmDt
	 */
	public String getClmDt() {
		return this.clmDt;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return tsSoFlg
	 */
	public String getTsSoFlg() {
		return this.tsSoFlg;
	}
	
	/**
	 * Column Info
	 * @return copPodCd
	 */
	public String getCopPodCd() {
		return this.copPodCd;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return pkupEnd
	 */
	public String getPkupEnd() {
		return this.pkupEnd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return drWoFlg
	 */
	public String getDrWoFlg() {
		return this.drWoFlg;
	}
	
	/**
	 * Column Info
	 * @return rlSoPlnFlg
	 */
	public String getRlSoPlnFlg() {
		return this.rlSoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return tcWoFlg
	 */
	public String getTcWoFlg() {
		return this.tcWoFlg;
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
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param rlSoFlg
	 */
	public void setRlSoFlg(String rlSoFlg) {
		this.rlSoFlg = rlSoFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
	}
	
	/**
	 * Column Info
	 * @param drSoFlg
	 */
	public void setDrSoFlg(String drSoFlg) {
		this.drSoFlg = drSoFlg;
	}
	
	/**
	 * Column Info
	 * @param tsSoPlnFlg
	 */
	public void setTsSoPlnFlg(String tsSoPlnFlg) {
		this.tsSoPlnFlg = tsSoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param dupFlg
	 */
	public void setDupFlg(String dupFlg) {
		this.dupFlg = dupFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param unmatchFlg
	 */
	public void setUnmatchFlg(String unmatchFlg) {
		this.unmatchFlg = unmatchFlg;
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
	 * @param pkupYdCd
	 */
	public void setPkupYdCd(String pkupYdCd) {
		this.pkupYdCd = pkupYdCd;
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
	 * @param mvmtYd
	 */
	public void setMvmtYd(String mvmtYd) {
		this.mvmtYd = mvmtYd;
	}
	
	/**
	 * Column Info
	 * @param spe
	 */
	public void setSpe(String spe) {
		this.spe = spe;
	}
	
	/**
	 * Column Info
	 * @param pkupAvalDt
	 */
	public void setPkupAvalDt(String pkupAvalDt) {
		this.pkupAvalDt = pkupAvalDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCntrRmk
	 */
	public void setBkgCntrRmk(String bkgCntrRmk) {
		this.bkgCntrRmk = bkgCntrRmk;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param itNo
	 */
	public void setItNo(String itNo) {
		this.itNo = itNo;
	}
	
	/**
	 * Column Info
	 * @param addTrsp
	 */
	public void setAddTrsp(String addTrsp) {
		this.addTrsp = addTrsp;
	}
	
	/**
	 * Column Info
	 * @param drSpNm
	 */
	public void setDrSpNm(String drSpNm) {
		this.drSpNm = drSpNm;
	}
	
	/**
	 * Column Info
	 * @param drTo
	 */
	public void setDrTo(String drTo) {
		this.drTo = drTo;
	}
	
	/**
	 * Column Info
	 * @param tsWoFlg
	 */
	public void setTsWoFlg(String tsWoFlg) {
		this.tsWoFlg = tsWoFlg;
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
	 * @param cstmsLocCd
	 */
	public void setCstmsLocCd(String cstmsLocCd) {
		this.cstmsLocCd = cstmsLocCd;
	}
	
	/**
	 * Column Info
	 * @param railDest
	 */
	public void setRailDest(String railDest) {
		this.railDest = railDest;
	}
	
	/**
	 * Column Info
	 * @param tcSoFlg
	 */
	public void setTcSoFlg(String tcSoFlg) {
		this.tcSoFlg = tcSoFlg;
	}
	
	/**
	 * Column Info
	 * @param copDelCd
	 */
	public void setCopDelCd(String copDelCd) {
		this.copDelCd = copDelCd;
	}
	
	/**
	 * Column Info
	 * @param dspoCd
	 */
	public void setDspoCd(String dspoCd) {
		this.dspoCd = dspoCd;
	}
	
	/**
	 * Column Info
	 * @param drSoPlnFlg
	 */
	public void setDrSoPlnFlg(String drSoPlnFlg) {
		this.drSoPlnFlg = drSoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param rlWoFlg
	 */
	public void setRlWoFlg(String rlWoFlg) {
		this.rlWoFlg = rlWoFlg;
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
	 * @param pkupFreeDt
	 */
	public void setPkupFreeDt(String pkupFreeDt) {
		this.pkupFreeDt = pkupFreeDt;
	}
	
	/**
	 * Column Info
	 * @param poNo
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param mvmtDt
	 */
	public void setMvmtDt(String mvmtDt) {
		this.mvmtDt = mvmtDt;
	}
	
	/**
	 * Column Info
	 * @param clmLoc
	 */
	public void setClmLoc(String clmLoc) {
		this.clmLoc = clmLoc;
	}
	
	/**
	 * Column Info
	 * @param drSp
	 */
	public void setDrSp(String drSp) {
		this.drSp = drSp;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Column Info
	 * @param tcSoPlnFlg
	 */
	public void setTcSoPlnFlg(String tcSoPlnFlg) {
		this.tcSoPlnFlg = tcSoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param clmState
	 */
	public void setClmState(String clmState) {
		this.clmState = clmState;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @param pkupOfcCd
	 */
	public void setPkupOfcCd(String pkupOfcCd) {
		this.pkupOfcCd = pkupOfcCd;
	}
	
	/**
	 * Column Info
	 * @param drWoDt
	 */
	public void setDrWoDt(String drWoDt) {
		this.drWoDt = drWoDt;
	}
	
	/**
	 * Column Info
	 * @param itDate
	 */
	public void setItDate(String itDate) {
		this.itDate = itDate;
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
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param filer
	 */
	public void setFiler(String filer) {
		this.filer = filer;
	}
	
	/**
	 * Column Info
	 * @param f
	 */
	public void setF(String f) {
		this.f = f;
	}
	
	/**
	 * Column Info
	 * @param mvmtSts
	 */
	public void setMvmtSts(String mvmtSts) {
		this.mvmtSts = mvmtSts;
	}
	
	/**
	 * Column Info
	 * @param drFm
	 */
	public void setDrFm(String drFm) {
		this.drFm = drFm;
	}
	
	/**
	 * Column Info
	 * @param c
	 */
	public void setC(String c) {
		this.c = c;
	}
	
	/**
	 * Column Info
	 * @param clmCrntSts
	 */
	public void setClmCrntSts(String clmCrntSts) {
		this.clmCrntSts = clmCrntSts;
	}
	
	/**
	 * Column Info
	 * @param o
	 */
	public void setO(String o) {
		this.o = o;
	}
	
	/**
	 * Column Info
	 * @param clmDt
	 */
	public void setClmDt(String clmDt) {
		this.clmDt = clmDt;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param tsSoFlg
	 */
	public void setTsSoFlg(String tsSoFlg) {
		this.tsSoFlg = tsSoFlg;
	}
	
	/**
	 * Column Info
	 * @param copPodCd
	 */
	public void setCopPodCd(String copPodCd) {
		this.copPodCd = copPodCd;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param pkupEnd
	 */
	public void setPkupEnd(String pkupEnd) {
		this.pkupEnd = pkupEnd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param drWoFlg
	 */
	public void setDrWoFlg(String drWoFlg) {
		this.drWoFlg = drWoFlg;
	}
	
	/**
	 * Column Info
	 * @param rlSoPlnFlg
	 */
	public void setRlSoPlnFlg(String rlSoPlnFlg) {
		this.rlSoPlnFlg = rlSoPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param tcWoFlg
	 */
	public void setTcWoFlg(String tcWoFlg) {
		this.tcWoFlg = tcWoFlg;
	}
	
	
    /**
	 * @return the ediSndTpCd
	 */
	public String getEdiSndTpCd() {
		return ediSndTpCd;
	}

	/**
	 * @param ediSndTpCd the ediSndTpCd to set
	 */
	public void setEdiSndTpCd(String ediSndTpCd) {
		this.ediSndTpCd = ediSndTpCd;
	}

	/**
	 * @return the ediSndDt
	 */
	public String getEdiSndDt() {
		return ediSndDt;
	}

	/**
	 * @param ediSndDt the ediSndDt to set
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
	}

	/**
	 * @return the vndrSeq
	 */
	public String getVndrSeq() {
		return vndrSeq;
	}

	/**
	 * @param vndrSeq the vndrSeq to set
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	
    /**
	 * @return the vndrName
	 */
	public String getVndrName() {
		return vndrName;
	}

	/**
	 * @param vndrName the vndrName to set
	 */
	public void setVndrName(String vndrName) {
		this.vndrName = vndrName;
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
		setGuide(JSPUtil.getParameter(request, prefix + "guide", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setRlSoFlg(JSPUtil.getParameter(request, prefix + "rl_so_flg", ""));
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setDrSoFlg(JSPUtil.getParameter(request, prefix + "dr_so_flg", ""));
		setTsSoPlnFlg(JSPUtil.getParameter(request, prefix + "ts_so_pln_flg", ""));
		setDupFlg(JSPUtil.getParameter(request, prefix + "dup_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setUnmatchFlg(JSPUtil.getParameter(request, prefix + "unmatch_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPkupYdCd(JSPUtil.getParameter(request, prefix + "pkup_yd_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setMvmtYd(JSPUtil.getParameter(request, prefix + "mvmt_yd", ""));
		setSpe(JSPUtil.getParameter(request, prefix + "spe", ""));
		setPkupAvalDt(JSPUtil.getParameter(request, prefix + "pkup_aval_dt", ""));
		setBkgCntrRmk(JSPUtil.getParameter(request, prefix + "bkg_cntr_rmk", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCopStsCd(JSPUtil.getParameter(request, prefix + "cop_sts_cd", ""));
		setItNo(JSPUtil.getParameter(request, prefix + "it_no", ""));
		setAddTrsp(JSPUtil.getParameter(request, prefix + "add_trsp", ""));
		setDrSpNm(JSPUtil.getParameter(request, prefix + "dr_sp_nm", ""));
		setDrTo(JSPUtil.getParameter(request, prefix + "dr_to", ""));
		setTsWoFlg(JSPUtil.getParameter(request, prefix + "ts_wo_flg", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setCstmsLocCd(JSPUtil.getParameter(request, prefix + "cstms_loc_cd", ""));
		setRailDest(JSPUtil.getParameter(request, prefix + "rail_dest", ""));
		setTcSoFlg(JSPUtil.getParameter(request, prefix + "tc_so_flg", ""));
		setCopDelCd(JSPUtil.getParameter(request, prefix + "cop_del_cd", ""));
		setDspoCd(JSPUtil.getParameter(request, prefix + "dspo_cd", ""));
		setDrSoPlnFlg(JSPUtil.getParameter(request, prefix + "dr_so_pln_flg", ""));
		setRlWoFlg(JSPUtil.getParameter(request, prefix + "rl_wo_flg", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPkupFreeDt(JSPUtil.getParameter(request, prefix + "pkup_free_dt", ""));
		setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setMvmtDt(JSPUtil.getParameter(request, prefix + "mvmt_dt", ""));
		setClmLoc(JSPUtil.getParameter(request, prefix + "clm_loc", ""));
		setDrSp(JSPUtil.getParameter(request, prefix + "dr_sp", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setFrom(JSPUtil.getParameter(request, prefix + "from", ""));
		setTcSoPlnFlg(JSPUtil.getParameter(request, prefix + "tc_so_pln_flg", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setClmState(JSPUtil.getParameter(request, prefix + "clm_state", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setPkupOfcCd(JSPUtil.getParameter(request, prefix + "pkup_ofc_cd", ""));
		setDrWoDt(JSPUtil.getParameter(request, prefix + "dr_wo_dt", ""));
		setItDate(JSPUtil.getParameter(request, prefix + "it_date", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setNtfyAddr(JSPUtil.getParameter(request, prefix + "ntfy_addr", ""));
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setFiler(JSPUtil.getParameter(request, prefix + "filer", ""));
		setF(JSPUtil.getParameter(request, prefix + "f", ""));
		setMvmtSts(JSPUtil.getParameter(request, prefix + "mvmt_sts", ""));
		setDrFm(JSPUtil.getParameter(request, prefix + "dr_fm", ""));
		setC(JSPUtil.getParameter(request, prefix + "c", ""));
		setClmCrntSts(JSPUtil.getParameter(request, prefix + "clm_crnt_sts", ""));
		setO(JSPUtil.getParameter(request, prefix + "o", ""));
		setClmDt(JSPUtil.getParameter(request, prefix + "clm_dt", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setTsSoFlg(JSPUtil.getParameter(request, prefix + "ts_so_flg", ""));
		setCopPodCd(JSPUtil.getParameter(request, prefix + "cop_pod_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setPkupEnd(JSPUtil.getParameter(request, prefix + "pkup_end", ""));
		setTerm(JSPUtil.getParameter(request, prefix + "term", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDrWoFlg(JSPUtil.getParameter(request, prefix + "dr_wo_flg", ""));
		setRlSoPlnFlg(JSPUtil.getParameter(request, prefix + "rl_so_pln_flg", ""));
		setTcWoFlg(JSPUtil.getParameter(request, prefix + "tc_wo_flg", ""));
		setEdiSndTpCd(JSPUtil.getParameter(request, prefix + "edi_snd_tp_cd", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrName(JSPUtil.getParameter(request, prefix + "vndr_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUSIORListVO[]
	 */
	public SearchUSIORListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUSIORListVO[]
	 */
	public SearchUSIORListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUSIORListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] guide = (JSPUtil.getParameter(request, prefix	+ "guide", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] rlSoFlg = (JSPUtil.getParameter(request, prefix	+ "rl_so_flg", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] drSoFlg = (JSPUtil.getParameter(request, prefix	+ "dr_so_flg", length));
			String[] tsSoPlnFlg = (JSPUtil.getParameter(request, prefix	+ "ts_so_pln_flg", length));
			String[] dupFlg = (JSPUtil.getParameter(request, prefix	+ "dup_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] unmatchFlg = (JSPUtil.getParameter(request, prefix	+ "unmatch_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] mvmtYd = (JSPUtil.getParameter(request, prefix	+ "mvmt_yd", length));
			String[] spe = (JSPUtil.getParameter(request, prefix	+ "spe", length));
			String[] pkupAvalDt = (JSPUtil.getParameter(request, prefix	+ "pkup_aval_dt", length));
			String[] bkgCntrRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_rmk", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] itNo = (JSPUtil.getParameter(request, prefix	+ "it_no", length));
			String[] addTrsp = (JSPUtil.getParameter(request, prefix	+ "add_trsp", length));
			String[] drSpNm = (JSPUtil.getParameter(request, prefix	+ "dr_sp_nm", length));
			String[] drTo = (JSPUtil.getParameter(request, prefix	+ "dr_to", length));
			String[] tsWoFlg = (JSPUtil.getParameter(request, prefix	+ "ts_wo_flg", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] cstmsLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_cd", length));
			String[] railDest = (JSPUtil.getParameter(request, prefix	+ "rail_dest", length));
			String[] tcSoFlg = (JSPUtil.getParameter(request, prefix	+ "tc_so_flg", length));
			String[] copDelCd = (JSPUtil.getParameter(request, prefix	+ "cop_del_cd", length));
			String[] dspoCd = (JSPUtil.getParameter(request, prefix	+ "dspo_cd", length));
			String[] drSoPlnFlg = (JSPUtil.getParameter(request, prefix	+ "dr_so_pln_flg", length));
			String[] rlWoFlg = (JSPUtil.getParameter(request, prefix	+ "rl_wo_flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] pkupFreeDt = (JSPUtil.getParameter(request, prefix	+ "pkup_free_dt", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] mvmtDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_dt", length));
			String[] clmLoc = (JSPUtil.getParameter(request, prefix	+ "clm_loc", length));
			String[] drSp = (JSPUtil.getParameter(request, prefix	+ "dr_sp", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] from = (JSPUtil.getParameter(request, prefix	+ "from", length));
			String[] tcSoPlnFlg = (JSPUtil.getParameter(request, prefix	+ "tc_so_pln_flg", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] clmState = (JSPUtil.getParameter(request, prefix	+ "clm_state", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] pkupOfcCd = (JSPUtil.getParameter(request, prefix	+ "pkup_ofc_cd", length));
			String[] drWoDt = (JSPUtil.getParameter(request, prefix	+ "dr_wo_dt", length));
			String[] itDate = (JSPUtil.getParameter(request, prefix	+ "it_date", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] filer = (JSPUtil.getParameter(request, prefix	+ "filer", length));
			String[] f = (JSPUtil.getParameter(request, prefix	+ "f", length));
			String[] mvmtSts = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts", length));
			String[] drFm = (JSPUtil.getParameter(request, prefix	+ "dr_fm", length));
			String[] c = (JSPUtil.getParameter(request, prefix	+ "c", length));
			String[] clmCrntSts = (JSPUtil.getParameter(request, prefix	+ "clm_crnt_sts", length));
			String[] o = (JSPUtil.getParameter(request, prefix	+ "o", length));
			String[] clmDt = (JSPUtil.getParameter(request, prefix	+ "clm_dt", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] tsSoFlg = (JSPUtil.getParameter(request, prefix	+ "ts_so_flg", length));
			String[] copPodCd = (JSPUtil.getParameter(request, prefix	+ "cop_pod_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] pkupEnd = (JSPUtil.getParameter(request, prefix	+ "pkup_end", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] drWoFlg = (JSPUtil.getParameter(request, prefix	+ "dr_wo_flg", length));
			String[] rlSoPlnFlg = (JSPUtil.getParameter(request, prefix	+ "rl_so_pln_flg", length));
			String[] tcWoFlg = (JSPUtil.getParameter(request, prefix	+ "tc_wo_flg", length));
			String[] ediSndTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_tp_cd", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrName = (JSPUtil.getParameter(request, prefix	+ "vndr_name", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUSIORListVO();
				if (guide[i] != null)
					model.setGuide(guide[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (rlSoFlg[i] != null)
					model.setRlSoFlg(rlSoFlg[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (drSoFlg[i] != null)
					model.setDrSoFlg(drSoFlg[i]);
				if (tsSoPlnFlg[i] != null)
					model.setTsSoPlnFlg(tsSoPlnFlg[i]);
				if (dupFlg[i] != null)
					model.setDupFlg(dupFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (unmatchFlg[i] != null)
					model.setUnmatchFlg(unmatchFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (mvmtYd[i] != null)
					model.setMvmtYd(mvmtYd[i]);
				if (spe[i] != null)
					model.setSpe(spe[i]);
				if (pkupAvalDt[i] != null)
					model.setPkupAvalDt(pkupAvalDt[i]);
				if (bkgCntrRmk[i] != null)
					model.setBkgCntrRmk(bkgCntrRmk[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (itNo[i] != null)
					model.setItNo(itNo[i]);
				if (addTrsp[i] != null)
					model.setAddTrsp(addTrsp[i]);
				if (drSpNm[i] != null)
					model.setDrSpNm(drSpNm[i]);
				if (drTo[i] != null)
					model.setDrTo(drTo[i]);
				if (tsWoFlg[i] != null)
					model.setTsWoFlg(tsWoFlg[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (cstmsLocCd[i] != null)
					model.setCstmsLocCd(cstmsLocCd[i]);
				if (railDest[i] != null)
					model.setRailDest(railDest[i]);
				if (tcSoFlg[i] != null)
					model.setTcSoFlg(tcSoFlg[i]);
				if (copDelCd[i] != null)
					model.setCopDelCd(copDelCd[i]);
				if (dspoCd[i] != null)
					model.setDspoCd(dspoCd[i]);
				if (drSoPlnFlg[i] != null)
					model.setDrSoPlnFlg(drSoPlnFlg[i]);
				if (rlWoFlg[i] != null)
					model.setRlWoFlg(rlWoFlg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (pkupFreeDt[i] != null)
					model.setPkupFreeDt(pkupFreeDt[i]);
				if (poNo[i] != null)
					model.setPoNo(poNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (mvmtDt[i] != null)
					model.setMvmtDt(mvmtDt[i]);
				if (clmLoc[i] != null)
					model.setClmLoc(clmLoc[i]);
				if (drSp[i] != null)
					model.setDrSp(drSp[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (from[i] != null)
					model.setFrom(from[i]);
				if (tcSoPlnFlg[i] != null)
					model.setTcSoPlnFlg(tcSoPlnFlg[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (clmState[i] != null)
					model.setClmState(clmState[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (pkupOfcCd[i] != null)
					model.setPkupOfcCd(pkupOfcCd[i]);
				if (drWoDt[i] != null)
					model.setDrWoDt(drWoDt[i]);
				if (itDate[i] != null)
					model.setItDate(itDate[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (filer[i] != null)
					model.setFiler(filer[i]);
				if (f[i] != null)
					model.setF(f[i]);
				if (mvmtSts[i] != null)
					model.setMvmtSts(mvmtSts[i]);
				if (drFm[i] != null)
					model.setDrFm(drFm[i]);
				if (c[i] != null)
					model.setC(c[i]);
				if (clmCrntSts[i] != null)
					model.setClmCrntSts(clmCrntSts[i]);
				if (o[i] != null)
					model.setO(o[i]);
				if (clmDt[i] != null)
					model.setClmDt(clmDt[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (tsSoFlg[i] != null)
					model.setTsSoFlg(tsSoFlg[i]);
				if (copPodCd[i] != null)
					model.setCopPodCd(copPodCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (pkupEnd[i] != null)
					model.setPkupEnd(pkupEnd[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (drWoFlg[i] != null)
					model.setDrWoFlg(drWoFlg[i]);
				if (rlSoPlnFlg[i] != null)
					model.setRlSoPlnFlg(rlSoPlnFlg[i]);
				if (tcWoFlg[i] != null)
					model.setTcWoFlg(tcWoFlg[i]);
				if (ediSndTpCd[i] != null)
					model.setEdiSndTpCd(ediSndTpCd[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrName[i] != null)
					model.setVndrName(vndrName[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUSIORListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUSIORListVO[]
	 */
	public SearchUSIORListVO[] getSearchUSIORListVOs(){
		SearchUSIORListVO[] vos = (SearchUSIORListVO[])models.toArray(new SearchUSIORListVO[models.size()]);
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
		this.guide = this.guide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlSoFlg = this.rlSoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drSoFlg = this.drSoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSoPlnFlg = this.tsSoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dupFlg = this.dupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unmatchFlg = this.unmatchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtYd = this.mvmtYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spe = this.spe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupAvalDt = this.pkupAvalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrRmk = this.bkgCntrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itNo = this.itNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addTrsp = this.addTrsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drSpNm = this.drSpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drTo = this.drTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsWoFlg = this.tsWoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocCd = this.cstmsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railDest = this.railDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcSoFlg = this.tcSoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDelCd = this.copDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspoCd = this.dspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drSoPlnFlg = this.drSoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlWoFlg = this.rlWoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupFreeDt = this.pkupFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDt = this.mvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmLoc = this.clmLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drSp = this.drSp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.from = this.from .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcSoPlnFlg = this.tcSoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmState = this.clmState .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupOfcCd = this.pkupOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drWoDt = this.drWoDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itDate = this.itDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filer = this.filer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f = this.f .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtSts = this.mvmtSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drFm = this.drFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c = this.c .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCrntSts = this.clmCrntSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o = this.o .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmDt = this.clmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSoFlg = this.tsSoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copPodCd = this.copPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupEnd = this.pkupEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drWoFlg = this.drWoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlSoPlnFlg = this.rlSoPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tcWoFlg = this.tcWoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndTpCd = this.ediSndTpCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrName = this.vndrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
