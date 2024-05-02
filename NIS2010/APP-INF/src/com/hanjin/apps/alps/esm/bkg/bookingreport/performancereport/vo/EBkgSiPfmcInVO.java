/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBkgSiPfmcInVO.java
*@FileTitle : EBkgSiPfmcInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.10
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.01.10 서미진 
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.02.15 김보배 [CHM-201216103] [BKG] e-SI PFMC Report 수정 요청
* 2013.03.11 임재관 [CHM-201323202] [BKG] e-SVC Performance Report 항목 분리 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EBkgSiPfmcInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EBkgSiPfmcInVO> models = new ArrayList<EBkgSiPfmcInVO>();
	
	/* Column Info */
	private String durationMonth = null;
	/* Column Info */
	private String bkUsrCnt = null;
	/* Column Info */
	private String durationYear = null;
	/* Column Info */
	private String blKind = null;
	/* Column Info */
	private String reportType = null;
	/* Column Info */
	private String bkgGtn = null;
	/* Column Info */
	private String siDesktop = null;
	/* Column Info */
	private String blWebObl = null;
	/* Column Info */
	private String blCompleteDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String siUsrId = null;
	/* Column Info */
	private String bkgSvc = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String durationToWeek = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String prnUsrId = null;
	/* Column Info */
	private String siWeb = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String siUsrNm = null;
	/* Column Info */
	private String bkgTtl = null;
	/* Column Info */
	private String bkgNis = null;
	/* Column Info */
	private String zoneCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String gso = null;
	/* Column Info */
	private String blTtlSwb = null;
	/* Column Info */
	private String oblSndAdmUsrId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String durationFromDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String siCsm = null;
	/* Column Info */
	private String siSim = null;
	/* Column Info */
	private String blEdi = null;
	/* Column Info */
	private String bkgEdi = null;
	/* Column Info */
	private String bkgCsm = null;
	/* Column Info */
	private String salOfc = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String siEdi = null;
	/* Column Info */
	private String siEml = null;
	/* Column Info */
	private String siUld = null;	
	/* Column Info */
	private String siDt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String blDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String siNis = null;
	/* Column Info */
	private String scRfaType = null;
	/* Column Info */
	private String siUsrCnt = null;
	/* Column Info */
	private String siTtl = null;
	/* Column Info */
	private String bkgInttra = null;
	/* Column Info */
	private String bkgWeb = null;
	/* Column Info */
	private String oblKnt = null;
	/* Column Info */
	private String hblCnt = null;
	/* Column Info */
	private String blUsrCnt = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String regionCd = null;
	/* Column Info */
	private String prnDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String bkUsrId = null;
	/* Column Info */
	private String bkDt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String blSvc = null;
	/* Column Info */
	private String blCompleteUsrId = null;
	/* Column Info */
	private String blTtlObl = null;
	/* Column Info */
	private String blSwbEmail = null;
	/* Column Info */
	private String blWebSwb = null;
	/* Column Info */
	private String blPending = null;
	/* Column Info */
	private String durationFromWeek = null;
	/* Column Info */
	private String blUsrNm = null;
	/* Column Info */
	private String blNis = null;
	/* Column Info */
	private String docTpS = null;
	/* Column Info */
	private String siSvc = null;
	/* Column Info */
	private String siKind = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String docTpL = null;
	/* Column Info */
	private String siGtn = null;
	/* Column Info */
	private String blCompleteCnt = null;
	/* Column Info */
	private String bkgDesktop = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String bkKind = null;
	/* Column Info */
	private String bkUsrNm = null;
	/* Column Info */
	private String durationToDt = null;
	/* Column Info */
	private String siInttra = null;
	/* Column Info */
	private String inetBlSndViaCd = null;
	/* Column Info */
	private String blUsrId = null;
	/* Column Info */
	private String docTpB = null;
	/* Column Info */
	private String admUsrId = null;
	/* Column Info */
	private String durationOpt = null;
	/* Column Info */
	private String cust = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String ctrtOfc = null;
	/* Column Info */
	private String siHjstools = null;
	/* Column Info */
	private String siPortal = null;
	/* Column Info */
	private String bkgHjstools = null;
	/* Column Info */
	private String bkgPortal = null;
	/* Column Info */
	private String bkgEml = null;
	/* Column Info */
	private String dpcs = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String siCnt = null;
	/* Column Info */
	private String emlFlg = null;
	/* Column Info */
	private String uldFlg = null;
	/* Column Info */
	private String faxFlg = null;
	/* Column Info */
	private String eml = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String bkgSim = null;
	private String siAutoBkgCnt = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EBkgSiPfmcInVO() {}

	public EBkgSiPfmcInVO(String ibflag, String pagerows, String durationMonth, String bkUsrCnt, String durationYear, String blKind, String reportType, String bkgGtn, String siDesktop, String blWebObl, String blNo, String siUsrId, String bkgSvc, String polCd, String vvdCd, String durationToWeek, String prnUsrId, String siWeb, String bkgCustTpCd, String custCntCd, String siUsrNm, String bkgTtl, String bkgNis, String delCd, String gso, String blTtlSwb, String oblSndAdmUsrId, String podCd, String durationFromDt, String bkgNo, String siCsm, String siSim, String blEdi, String bkgEdi, String bkgCsm, String salOfc, String blObrdDt, String siEdi, String siEml, String siUld, String siDt, String porCd, String blDt, String custNm, String siNis, String scRfaType, String siUsrCnt, String siTtl, String bkgInttra, String bkgWeb, String oblKnt, String blUsrCnt, String hblCnt, String svrId, String prnDt, String regionCd, String bkUsrId, String bkgOfc, String bkDt, String usrNm, String usrId, String blSvc, String blTtlObl, String blSwbEmail, String blWebSwb, String blPending, String blUsrNm, String durationFromWeek, String blNis, String siKind, String siSvc, String docTpS, String custSeq, String siGtn, String docTpL, String ofcCd, String bkgDesktop, String duration, String bkUsrNm, String bkKind, String scRfaNo, String siInttra, String durationToDt, String inetBlSndViaCd, String blUsrId, String docTpB, String admUsrId, String cust, String durationOpt, String zoneCd, String blCompleteCnt, String blCompleteDt, String blCompleteUsrId, String obSlsOfcCd, String obSrepCd, String propOfcCd, String ctrtOfc, String siHjstools, String siPortal, String bkgHjstools, String bkgPortal, String bkgEml, String dpcs, String bkgCnt, String siCnt, String emlFlg, String uldFlg, String faxFlg, String eml, String faxNo, String week,  String bkgSim, String siAutoBkgCnt) {
		this.durationMonth = durationMonth;
		this.bkUsrCnt = bkUsrCnt;
		this.durationYear = durationYear;
		this.blKind = blKind;
		this.reportType = reportType;
		this.bkgGtn = bkgGtn;
		this.siDesktop = siDesktop;
		this.blWebObl = blWebObl;
		this.blCompleteDt = blCompleteDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.siUsrId = siUsrId;
		this.bkgSvc = bkgSvc;
		this.polCd = polCd;
		this.durationToWeek = durationToWeek;
		this.vvdCd = vvdCd;
		this.prnUsrId = prnUsrId;
		this.siWeb = siWeb;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custCntCd = custCntCd;
		this.siUsrNm = siUsrNm;
		this.bkgTtl = bkgTtl;
		this.bkgNis = bkgNis;
		this.zoneCd = zoneCd;
		this.delCd = delCd;
		this.gso = gso;
		this.blTtlSwb = blTtlSwb;
		this.oblSndAdmUsrId = oblSndAdmUsrId;
		this.podCd = podCd;
		this.durationFromDt = durationFromDt;
		this.bkgNo = bkgNo;
		this.siCsm = siCsm;
		this.siSim = siSim;
		this.blEdi = blEdi;
		this.bkgEdi = bkgEdi;
		this.bkgCsm = bkgCsm;
		this.salOfc = salOfc;
		this.blObrdDt = blObrdDt;
		this.siEdi = siEdi;
		this.siEml = siEml;
		this.siUld = siUld;		
		this.siDt = siDt;
		this.porCd = porCd;
		this.blDt = blDt;
		this.custNm = custNm;
		this.siNis = siNis;
		this.scRfaType = scRfaType;
		this.siUsrCnt = siUsrCnt;
		this.siTtl = siTtl;
		this.bkgInttra = bkgInttra;
		this.bkgWeb = bkgWeb;
		this.oblKnt = oblKnt;
		this.hblCnt = hblCnt;
		this.blUsrCnt = blUsrCnt;
		this.svrId = svrId;
		this.regionCd = regionCd;
		this.prnDt = prnDt;
		this.ibflag = ibflag;
		this.bkgOfc = bkgOfc;
		this.bkUsrId = bkUsrId;
		this.bkDt = bkDt;
		this.usrId = usrId;
		this.usrNm = usrNm;
		this.blSvc = blSvc;
		this.blCompleteUsrId = blCompleteUsrId;
		this.blTtlObl = blTtlObl;
		this.blSwbEmail = blSwbEmail;
		this.blWebSwb = blWebSwb;
		this.blPending = blPending;
		this.durationFromWeek = durationFromWeek;
		this.blUsrNm = blUsrNm;
		this.blNis = blNis;
		this.docTpS = docTpS;
		this.siSvc = siSvc;
		this.siKind = siKind;
		this.custSeq = custSeq;
		this.docTpL = docTpL;
		this.siGtn = siGtn;
		this.blCompleteCnt = blCompleteCnt;
		this.bkgDesktop = bkgDesktop;
		this.ofcCd = ofcCd;
		this.duration = duration;
		this.scRfaNo = scRfaNo;
		this.bkKind = bkKind;
		this.bkUsrNm = bkUsrNm;
		this.durationToDt = durationToDt;
		this.siInttra = siInttra;
		this.inetBlSndViaCd = inetBlSndViaCd;
		this.blUsrId = blUsrId;
		this.docTpB = docTpB;
		this.admUsrId = admUsrId;
		this.durationOpt = durationOpt;
		this.cust = cust;
		this.obSlsOfcCd = obSlsOfcCd;
		this.obSrepCd = obSrepCd;
		this.propOfcCd = propOfcCd;
		this.ctrtOfc = ctrtOfc;
		this.siHjstools = siHjstools;
		this.siPortal = siPortal;
		this.bkgHjstools = bkgHjstools;
		this.bkgPortal = bkgPortal;
		this.bkgEml = bkgEml;
		this.dpcs = dpcs;
		this.bkgCnt = bkgCnt;
		this.siCnt = siCnt;
		this.emlFlg = emlFlg;
		this.uldFlg = uldFlg;
		this.faxFlg = faxFlg;
		this.eml = eml;
		this.faxNo = faxNo;
		this.week = week;
		this.bkgSim = bkgSim;
		this.siAutoBkgCnt = siAutoBkgCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("duration_month", getDurationMonth());
		this.hashColumns.put("bk_usr_cnt", getBkUsrCnt());
		this.hashColumns.put("duration_year", getDurationYear());
		this.hashColumns.put("bl_kind", getBlKind());
		this.hashColumns.put("report_type", getReportType());
		this.hashColumns.put("bkg_gtn", getBkgGtn());
		this.hashColumns.put("si_desktop", getSiDesktop());
		this.hashColumns.put("bl_web_obl", getBlWebObl());
		this.hashColumns.put("bl_complete_dt", getBlCompleteDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("si_usr_id", getSiUsrId());
		this.hashColumns.put("bkg_svc", getBkgSvc());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("duration_to_week", getDurationToWeek());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("prn_usr_id", getPrnUsrId());
		this.hashColumns.put("si_web", getSiWeb());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("si_usr_nm", getSiUsrNm());
		this.hashColumns.put("bkg_ttl", getBkgTtl());
		this.hashColumns.put("bkg_nis", getBkgNis());
		this.hashColumns.put("zone_cd", getZoneCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("gso", getGso());
		this.hashColumns.put("bl_ttl_swb", getBlTtlSwb());
		this.hashColumns.put("obl_snd_adm_usr_id", getOblSndAdmUsrId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("duration_from_dt", getDurationFromDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("si_csm", getSiCsm());
		this.hashColumns.put("si_sim", getSiSim());
		this.hashColumns.put("bl_edi", getBlEdi());
		this.hashColumns.put("bkg_edi", getBkgEdi());
		this.hashColumns.put("bkg_csm", getBkgCsm());
		this.hashColumns.put("sal_ofc", getSalOfc());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("si_edi", getSiEdi());
		this.hashColumns.put("si_eml", getSiEml());
		this.hashColumns.put("si_uld", getSiUld());		
		this.hashColumns.put("si_dt", getSiDt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bl_dt", getBlDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("si_nis", getSiNis());
		this.hashColumns.put("sc_rfa_type", getScRfaType());
		this.hashColumns.put("si_usr_cnt", getSiUsrCnt());
		this.hashColumns.put("si_ttl", getSiTtl());
		this.hashColumns.put("bkg_inttra", getBkgInttra());
		this.hashColumns.put("bkg_web", getBkgWeb());
		this.hashColumns.put("obl_knt", getOblKnt());
		this.hashColumns.put("hbl_cnt", getHblCnt());
		this.hashColumns.put("bl_usr_cnt", getBlUsrCnt());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("region_cd", getRegionCd());
		this.hashColumns.put("prn_dt", getPrnDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("bk_usr_id", getBkUsrId());
		this.hashColumns.put("bk_dt", getBkDt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("bl_svc", getBlSvc());
		this.hashColumns.put("bl_complete_usr_id", getBlCompleteUsrId());
		this.hashColumns.put("bl_ttl_obl", getBlTtlObl());
		this.hashColumns.put("bl_swb_email", getBlSwbEmail());
		this.hashColumns.put("bl_web_swb", getBlWebSwb());
		this.hashColumns.put("bl_pending", getBlPending());
		this.hashColumns.put("duration_from_week", getDurationFromWeek());
		this.hashColumns.put("bl_usr_nm", getBlUsrNm());
		this.hashColumns.put("bl_nis", getBlNis());
		this.hashColumns.put("doc_tp_s", getDocTpS());
		this.hashColumns.put("si_svc", getSiSvc());
		this.hashColumns.put("si_kind", getSiKind());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("doc_tp_l", getDocTpL());
		this.hashColumns.put("si_gtn", getSiGtn());
		this.hashColumns.put("bl_complete_cnt", getBlCompleteCnt());
		this.hashColumns.put("bkg_desktop", getBkgDesktop());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("bk_kind", getBkKind());
		this.hashColumns.put("bk_usr_nm", getBkUsrNm());
		this.hashColumns.put("duration_to_dt", getDurationToDt());
		this.hashColumns.put("si_inttra", getSiInttra());
		this.hashColumns.put("inet_bl_snd_via_cd", getInetBlSndViaCd());
		this.hashColumns.put("bl_usr_id", getBlUsrId());
		this.hashColumns.put("doc_tp_b", getDocTpB());
		this.hashColumns.put("adm_usr_id", getAdmUsrId());
		this.hashColumns.put("duration_opt", getDurationOpt());
		this.hashColumns.put("cust", getCust());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("ctrt_ofc", getCtrtOfc());
		this.hashColumns.put("si_hjstools", getSiHjstools());
		this.hashColumns.put("si_portal", getSiPortal());
		this.hashColumns.put("bkg_hjstools", getBkgHjstools());
		this.hashColumns.put("bkg_portal", getBkgPortal());
		this.hashColumns.put("bkg_eml", getBkgEml());
		this.hashColumns.put("dpcs", getDpcs());
		
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("si_cnt", getSiCnt());
		this.hashColumns.put("eml_flg", getEmlFlg());
		this.hashColumns.put("uld_flg", getUldFlg());
		this.hashColumns.put("fax_flg", getFaxFlg());
		this.hashColumns.put("eml", getEml());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("bkg_sim", getBkgSim());
		this.hashColumns.put("si_auto_bkg_cnt", getSiAutoBkgCnt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("duration_month", "durationMonth");
		this.hashFields.put("bk_usr_cnt", "bkUsrCnt");
		this.hashFields.put("duration_year", "durationYear");
		this.hashFields.put("bl_kind", "blKind");
		this.hashFields.put("report_type", "reportType");
		this.hashFields.put("bkg_gtn", "bkgGtn");
		this.hashFields.put("si_desktop", "siDesktop");
		this.hashFields.put("bl_web_obl", "blWebObl");
		this.hashFields.put("bl_complete_dt", "blCompleteDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("si_usr_id", "siUsrId");
		this.hashFields.put("bkg_svc", "bkgSvc");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("duration_to_week", "durationToWeek");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("prn_usr_id", "prnUsrId");
		this.hashFields.put("si_web", "siWeb");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("si_usr_nm", "siUsrNm");
		this.hashFields.put("bkg_ttl", "bkgTtl");
		this.hashFields.put("bkg_nis", "bkgNis");
		this.hashFields.put("zone_cd", "zoneCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("gso", "gso");
		this.hashFields.put("bl_ttl_swb", "blTtlSwb");
		this.hashFields.put("obl_snd_adm_usr_id", "oblSndAdmUsrId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("duration_from_dt", "durationFromDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("si_csm", "siCsm");
		this.hashFields.put("si_sim", "siSim");
		this.hashFields.put("bl_edi", "blEdi");
		this.hashFields.put("bkg_edi", "bkgEdi");
		this.hashFields.put("bkg_csm", "bkgCsm");
		this.hashFields.put("sal_ofc", "salOfc");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("si_edi", "siEdi");
		this.hashFields.put("si_eml", "siEml");
		this.hashFields.put("si_uld", "siUld");
		this.hashFields.put("si_dt", "siDt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bl_dt", "blDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("si_nis", "siNis");
		this.hashFields.put("sc_rfa_type", "scRfaType");
		this.hashFields.put("si_usr_cnt", "siUsrCnt");
		this.hashFields.put("si_ttl", "siTtl");
		this.hashFields.put("bkg_inttra", "bkgInttra");
		this.hashFields.put("bkg_web", "bkgWeb");
		this.hashFields.put("obl_knt", "oblKnt");
		this.hashFields.put("hbl_cnt", "hblCnt");
		this.hashFields.put("bl_usr_cnt", "blUsrCnt");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("region_cd", "regionCd");
		this.hashFields.put("prn_dt", "prnDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("bk_usr_id", "bkUsrId");
		this.hashFields.put("bk_dt", "bkDt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("bl_svc", "blSvc");
		this.hashFields.put("bl_complete_usr_id", "blCompleteUsrId");
		this.hashFields.put("bl_ttl_obl", "blTtlObl");
		this.hashFields.put("bl_swb_email", "blSwbEmail");
		this.hashFields.put("bl_web_swb", "blWebSwb");
		this.hashFields.put("bl_pending", "blPending");
		this.hashFields.put("duration_from_week", "durationFromWeek");
		this.hashFields.put("bl_usr_nm", "blUsrNm");
		this.hashFields.put("bl_nis", "blNis");
		this.hashFields.put("doc_tp_s", "docTpS");
		this.hashFields.put("si_svc", "siSvc");
		this.hashFields.put("si_kind", "siKind");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("doc_tp_l", "docTpL");
		this.hashFields.put("si_gtn", "siGtn");
		this.hashFields.put("bl_complete_cnt", "blCompleteCnt");
		this.hashFields.put("bkg_desktop", "bkgDesktop");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("bk_kind", "bkKind");
		this.hashFields.put("bk_usr_nm", "bkUsrNm");
		this.hashFields.put("duration_to_dt", "durationToDt");
		this.hashFields.put("si_inttra", "siInttra");
		this.hashFields.put("inet_bl_snd_via_cd", "inetBlSndViaCd");
		this.hashFields.put("bl_usr_id", "blUsrId");
		this.hashFields.put("doc_tp_b", "docTpB");
		this.hashFields.put("adm_usr_id", "admUsrId");
		this.hashFields.put("duration_opt", "durationOpt");
		this.hashFields.put("cust", "cust");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("ctrt_ofc", "ctrtOfc");
		this.hashFields.put("si_hjstools", "siHjstools");
		this.hashFields.put("si_portal", "siPortal");
		this.hashFields.put("bkg_hjstools", "bkgHjstools");
		this.hashFields.put("bkg_portal", "bkgPortal");
		this.hashFields.put("bkg_eml", "bkgEml");
		this.hashFields.put("dpcs", "dpcs");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("si_cnt", "siCnt");
		this.hashFields.put("eml_flg", "emlFlg");
		this.hashFields.put("uld_flg", "uldFlg");
		this.hashFields.put("fax_flg", "faxFlg");
		this.hashFields.put("eml", "eml");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("week", "week");
		this.hashFields.put("bkg_sim", "bkgSim");
		this.hashFields.put("si_auto_bkg_cnt", "siAutoBkgCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return durationMonth
	 */
	public String getDurationMonth() {
		return this.durationMonth;
	}
	
	/**
	 * Column Info
	 * @return bkUsrCnt
	 */
	public String getBkUsrCnt() {
		return this.bkUsrCnt;
	}
	
	/**
	 * Column Info
	 * @return durationYear
	 */
	public String getDurationYear() {
		return this.durationYear;
	}
	
	/**
	 * Column Info
	 * @return blKind
	 */
	public String getBlKind() {
		return this.blKind;
	}
	
	/**
	 * Column Info
	 * @return reportType
	 */
	public String getReportType() {
		return this.reportType;
	}
	
	/**
	 * Column Info
	 * @return bkgGtn
	 */
	public String getBkgGtn() {
		return this.bkgGtn;
	}
	
	/**
	 * Column Info
	 * @return siDesktop
	 */
	public String getSiDesktop() {
		return this.siDesktop;
	}
	
	/**
	 * Column Info
	 * @return blWebObl
	 */
	public String getBlWebObl() {
		return this.blWebObl;
	}
	
	/**
	 * Column Info
	 * @return blCompleteDt
	 */
	public String getBlCompleteDt() {
		return this.blCompleteDt;
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
	 * @return siUsrId
	 */
	public String getSiUsrId() {
		return this.siUsrId;
	}
	
	/**
	 * Column Info
	 * @return bkgSvc
	 */
	public String getBkgSvc() {
		return this.bkgSvc;
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
	 * @return durationToWeek
	 */
	public String getDurationToWeek() {
		return this.durationToWeek;
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
	 * @return prnUsrId
	 */
	public String getPrnUsrId() {
		return this.prnUsrId;
	}
	
	/**
	 * Column Info
	 * @return siWeb
	 */
	public String getSiWeb() {
		return this.siWeb;
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
	 * @return siUsrNm
	 */
	public String getSiUsrNm() {
		return this.siUsrNm;
	}
	
	/**
	 * Column Info
	 * @return bkgTtl
	 */
	public String getBkgTtl() {
		return this.bkgTtl;
	}
	
	/**
	 * Column Info
	 * @return bkgNis
	 */
	public String getBkgNis() {
		return this.bkgNis;
	}
	
	/**
	 * Column Info
	 * @return zoneCd
	 */
	public String getZoneCd() {
		return this.zoneCd;
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
	 * @return gso
	 */
	public String getGso() {
		return this.gso;
	}
	
	/**
	 * Column Info
	 * @return blTtlSwb
	 */
	public String getBlTtlSwb() {
		return this.blTtlSwb;
	}
	
	/**
	 * Column Info
	 * @return oblSndAdmUsrId
	 */
	public String getOblSndAdmUsrId() {
		return this.oblSndAdmUsrId;
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
	 * @return durationFromDt
	 */
	public String getDurationFromDt() {
		return this.durationFromDt;
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
	 * @return siCsm
	 */
	public String getSiCsm() {
		return this.siCsm;
	}
	
	/**
	 * Column Info
	 * @return siSim
	 */
	public String getSiSim() {
		return this.siSim;
	}
	
	/**
	 * Column Info
	 * @return blEdi
	 */
	public String getBlEdi() {
		return this.blEdi;
	}
	
	/**
	 * Column Info
	 * @return bkgEdi
	 */
	public String getBkgEdi() {
		return this.bkgEdi;
	}
	
	/**
	 * Column Info
	 * @return bkgCsm
	 */
	public String getBkgCsm() {
		return this.bkgCsm;
	}
	
	/**
	 * Column Info
	 * @return salOfc
	 */
	public String getSalOfc() {
		return this.salOfc;
	}
	
	/**
	 * Column Info
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
	}
	
	/**
	 * Column Info
	 * @return siEdi
	 */
	public String getSiEdi() {
		return this.siEdi;
	}
	
	/**
	 * Column Info
	 * @return siEml
	 */
	public String getSiEml() {
		return this.siEml;
	}
	
	/**
	 * Column Info
	 * @return siUld
	 */
	public String getSiUld() {
		return this.siUld;
	}	
	
	/**
	 * Column Info
	 * @return siDt
	 */
	public String getSiDt() {
		return this.siDt;
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
	 * @return blDt
	 */
	public String getBlDt() {
		return this.blDt;
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
	 * @return siNis
	 */
	public String getSiNis() {
		return this.siNis;
	}
	
	/**
	 * Column Info
	 * @return scRfaType
	 */
	public String getScRfaType() {
		return this.scRfaType;
	}
	
	/**
	 * Column Info
	 * @return siUsrCnt
	 */
	public String getSiUsrCnt() {
		return this.siUsrCnt;
	}
	
	/**
	 * Column Info
	 * @return siTtl
	 */
	public String getSiTtl() {
		return this.siTtl;
	}
	
	/**
	 * Column Info
	 * @return bkgInttra
	 */
	public String getBkgInttra() {
		return this.bkgInttra;
	}
	
	/**
	 * Column Info
	 * @return bkgWeb
	 */
	public String getBkgWeb() {
		return this.bkgWeb;
	}
	
	/**
	 * Column Info
	 * @return oblKnt
	 */
	public String getOblKnt() {
		return this.oblKnt;
	}
	
	/**
	 * Column Info
	 * @return hblCnt
	 */
	public String getHblCnt() {
		return this.hblCnt;
	}
	
	/**
	 * Column Info
	 * @return blUsrCnt
	 */
	public String getBlUsrCnt() {
		return this.blUsrCnt;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return regionCd
	 */
	public String getRegionCd() {
		return this.regionCd;
	}
	
	/**
	 * Column Info
	 * @return prnDt
	 */
	public String getPrnDt() {
		return this.prnDt;
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
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return bkUsrId
	 */
	public String getBkUsrId() {
		return this.bkUsrId;
	}
	
	/**
	 * Column Info
	 * @return bkDt
	 */
	public String getBkDt() {
		return this.bkDt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return blSvc
	 */
	public String getBlSvc() {
		return this.blSvc;
	}
	
	/**
	 * Column Info
	 * @return blCompleteUsrId
	 */
	public String getBlCompleteUsrId() {
		return this.blCompleteUsrId;
	}
	
	/**
	 * Column Info
	 * @return blTtlObl
	 */
	public String getBlTtlObl() {
		return this.blTtlObl;
	}
	
	/**
	 * Column Info
	 * @return blSwbEmail
	 */
	public String getBlSwbEmail() {
		return this.blSwbEmail;
	}
	
	/**
	 * Column Info
	 * @return blWebSwb
	 */
	public String getBlWebSwb() {
		return this.blWebSwb;
	}
	
	/**
	 * Column Info
	 * @return blPending
	 */
	public String getBlPending() {
		return this.blPending;
	}
	
	/**
	 * Column Info
	 * @return durationFromWeek
	 */
	public String getDurationFromWeek() {
		return this.durationFromWeek;
	}
	
	/**
	 * Column Info
	 * @return blUsrNm
	 */
	public String getBlUsrNm() {
		return this.blUsrNm;
	}
	
	/**
	 * Column Info
	 * @return blNis
	 */
	public String getBlNis() {
		return this.blNis;
	}
	
	/**
	 * Column Info
	 * @return docTpS
	 */
	public String getDocTpS() {
		return this.docTpS;
	}
	
	/**
	 * Column Info
	 * @return siSvc
	 */
	public String getSiSvc() {
		return this.siSvc;
	}
	
	/**
	 * Column Info
	 * @return siKind
	 */
	public String getSiKind() {
		return this.siKind;
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
	 * @return docTpL
	 */
	public String getDocTpL() {
		return this.docTpL;
	}
	
	/**
	 * Column Info
	 * @return siGtn
	 */
	public String getSiGtn() {
		return this.siGtn;
	}
	
	/**
	 * Column Info
	 * @return blCompleteCnt
	 */
	public String getBlCompleteCnt() {
		return this.blCompleteCnt;
	}
	
	/**
	 * Column Info
	 * @return bkgDesktop
	 */
	public String getBkgDesktop() {
		return this.bkgDesktop;
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
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return bkKind
	 */
	public String getBkKind() {
		return this.bkKind;
	}
	
	/**
	 * Column Info
	 * @return bkUsrNm
	 */
	public String getBkUsrNm() {
		return this.bkUsrNm;
	}
	
	/**
	 * Column Info
	 * @return durationToDt
	 */
	public String getDurationToDt() {
		return this.durationToDt;
	}
	
	/**
	 * Column Info
	 * @return siInttra
	 */
	public String getSiInttra() {
		return this.siInttra;
	}
	
	/**
	 * Column Info
	 * @return inetBlSndViaCd
	 */
	public String getInetBlSndViaCd() {
		return this.inetBlSndViaCd;
	}
	
	/**
	 * Column Info
	 * @return blUsrId
	 */
	public String getBlUsrId() {
		return this.blUsrId;
	}
	
	/**
	 * Column Info
	 * @return docTpB
	 */
	public String getDocTpB() {
		return this.docTpB;
	}
	
	/**
	 * Column Info
	 * @return admUsrId
	 */
	public String getAdmUsrId() {
		return this.admUsrId;
	}
	
	/**
	 * Column Info
	 * @return durationOpt
	 */
	public String getDurationOpt() {
		return this.durationOpt;
	}
	
	/**
	 * Column Info
	 * @return cust
	 */
	public String getCust() {
		return this.cust;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfc
	 */
	public String getCtrtOfc() {
		return ctrtOfc;
	}
	
	/**
	 * Column Info
	 * @return siHjstools
	 */
	public String getSiHjstools() {
		return siHjstools;
	}

	/**
	 * Column Info
	 * @return siPortal
	 */
	public String getSiPortal() {
		return siPortal;
	}

	/**
	 * Column Info
	 * @return bkgHjstools
	 */
	public String getBkgHjstools() {
		return bkgHjstools;
	}

	/**
	 * Column Info
	 * @return bkgPortal
	 */
	public String getBkgPortal() {
		return bkgPortal;
	}

	/**
	 * Column Info
	 * @return bkgSim
	 */
	public String getBkgSim() {
		return bkgSim;
	}	

	/**
	 * Column Info
	 * @param durationMonth
	 */
	public void setDurationMonth(String durationMonth) {
		this.durationMonth = durationMonth;
	}
	
	/**
	 * Column Info
	 * @param bkUsrCnt
	 */
	public void setBkUsrCnt(String bkUsrCnt) {
		this.bkUsrCnt = bkUsrCnt;
	}
	
	/**
	 * Column Info
	 * @param durationYear
	 */
	public void setDurationYear(String durationYear) {
		this.durationYear = durationYear;
	}
	
	/**
	 * Column Info
	 * @param blKind
	 */
	public void setBlKind(String blKind) {
		this.blKind = blKind;
	}
	
	/**
	 * Column Info
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	
	/**
	 * Column Info
	 * @param bkgGtn
	 */
	public void setBkgGtn(String bkgGtn) {
		this.bkgGtn = bkgGtn;
	}
	
	/**
	 * Column Info
	 * @param siDesktop
	 */
	public void setSiDesktop(String siDesktop) {
		this.siDesktop = siDesktop;
	}
	
	/**
	 * Column Info
	 * @param blWebObl
	 */
	public void setBlWebObl(String blWebObl) {
		this.blWebObl = blWebObl;
	}
	
	/**
	 * Column Info
	 * @param blCompleteDt
	 */
	public void setBlCompleteDt(String blCompleteDt) {
		this.blCompleteDt = blCompleteDt;
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
	 * @param siUsrId
	 */
	public void setSiUsrId(String siUsrId) {
		this.siUsrId = siUsrId;
	}
	
	/**
	 * Column Info
	 * @param bkgSvc
	 */
	public void setBkgSvc(String bkgSvc) {
		this.bkgSvc = bkgSvc;
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
	 * @param durationToWeek
	 */
	public void setDurationToWeek(String durationToWeek) {
		this.durationToWeek = durationToWeek;
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
	 * @param prnUsrId
	 */
	public void setPrnUsrId(String prnUsrId) {
		this.prnUsrId = prnUsrId;
	}
	
	/**
	 * Column Info
	 * @param siWeb
	 */
	public void setSiWeb(String siWeb) {
		this.siWeb = siWeb;
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
	 * @param siUsrNm
	 */
	public void setSiUsrNm(String siUsrNm) {
		this.siUsrNm = siUsrNm;
	}
	
	/**
	 * Column Info
	 * @param bkgTtl
	 */
	public void setBkgTtl(String bkgTtl) {
		this.bkgTtl = bkgTtl;
	}
	
	/**
	 * Column Info
	 * @param bkgNis
	 */
	public void setBkgNis(String bkgNis) {
		this.bkgNis = bkgNis;
	}
	
	/**
	 * Column Info
	 * @param zoneCd
	 */
	public void setZoneCd(String zoneCd) {
		this.zoneCd = zoneCd;
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
	 * @param gso
	 */
	public void setGso(String gso) {
		this.gso = gso;
	}
	
	/**
	 * Column Info
	 * @param blTtlSwb
	 */
	public void setBlTtlSwb(String blTtlSwb) {
		this.blTtlSwb = blTtlSwb;
	}
	
	/**
	 * Column Info
	 * @param oblSndAdmUsrId
	 */
	public void setOblSndAdmUsrId(String oblSndAdmUsrId) {
		this.oblSndAdmUsrId = oblSndAdmUsrId;
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
	 * @param durationFromDt
	 */
	public void setDurationFromDt(String durationFromDt) {
		this.durationFromDt = durationFromDt;
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
	 * @param siCsm
	 */
	public void setSiCsm(String siCsm) {
		this.siCsm = siCsm;
	}
	
	/**
	 * Column Info
	 * @param siSim
	 */
	public void setSiSim(String siSim) {
		this.siSim = siSim;
	}
	
	/**
	 * Column Info
	 * @param blEdi
	 */
	public void setBlEdi(String blEdi) {
		this.blEdi = blEdi;
	}
	
	/**
	 * Column Info
	 * @param bkgEdi
	 */
	public void setBkgEdi(String bkgEdi) {
		this.bkgEdi = bkgEdi;
	}
	
	/**
	 * Column Info
	 * @param bkgCsm
	 */
	public void setBkgCsm(String bkgCsm) {
		this.bkgCsm = bkgCsm;
	}
	
	/**
	 * Column Info
	 * @param salOfc
	 */
	public void setSalOfc(String salOfc) {
		this.salOfc = salOfc;
	}
	
	/**
	 * Column Info
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}
	
	/**
	 * Column Info
	 * @param siEdi
	 */
	public void setSiEdi(String siEdi) {
		this.siEdi = siEdi;
	}
	
	/**
	 * Column Info
	 * @param siEml
	 */
	public void setSiEml(String siEml) {
		this.siEml = siEml;
	}
	
	/**
	 * Column Info
	 * @param siUld
	 */
	public void setSiUld(String siUld) {
		this.siUld = siUld;
	}	
	
	/**
	 * Column Info
	 * @param siDt
	 */
	public void setSiDt(String siDt) {
		this.siDt = siDt;
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
	 * @param blDt
	 */
	public void setBlDt(String blDt) {
		this.blDt = blDt;
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
	 * @param siNis
	 */
	public void setSiNis(String siNis) {
		this.siNis = siNis;
	}
	
	/**
	 * Column Info
	 * @param scRfaType
	 */
	public void setScRfaType(String scRfaType) {
		this.scRfaType = scRfaType;
	}
	
	/**
	 * Column Info
	 * @param siUsrCnt
	 */
	public void setSiUsrCnt(String siUsrCnt) {
		this.siUsrCnt = siUsrCnt;
	}
	
	/**
	 * Column Info
	 * @param siTtl
	 */
	public void setSiTtl(String siTtl) {
		this.siTtl = siTtl;
	}
	
	/**
	 * Column Info
	 * @param bkgInttra
	 */
	public void setBkgInttra(String bkgInttra) {
		this.bkgInttra = bkgInttra;
	}
	
	/**
	 * Column Info
	 * @param bkgWeb
	 */
	public void setBkgWeb(String bkgWeb) {
		this.bkgWeb = bkgWeb;
	}
	
	/**
	 * Column Info
	 * @param oblKnt
	 */
	public void setOblKnt(String oblKnt) {
		this.oblKnt = oblKnt;
	}
	
	/**
	 * Column Info
	 * @param hblCnt
	 */
	public void setHblCnt(String hblCnt) {
		this.hblCnt = hblCnt;
	}
	
	/**
	 * Column Info
	 * @param blUsrCnt
	 */
	public void setBlUsrCnt(String blUsrCnt) {
		this.blUsrCnt = blUsrCnt;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param regionCd
	 */
	public void setRegionCd(String regionCd) {
		this.regionCd = regionCd;
	}
	
	/**
	 * Column Info
	 * @param prnDt
	 */
	public void setPrnDt(String prnDt) {
		this.prnDt = prnDt;
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
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param bkUsrId
	 */
	public void setBkUsrId(String bkUsrId) {
		this.bkUsrId = bkUsrId;
	}
	
	/**
	 * Column Info
	 * @param bkDt
	 */
	public void setBkDt(String bkDt) {
		this.bkDt = bkDt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param blSvc
	 */
	public void setBlSvc(String blSvc) {
		this.blSvc = blSvc;
	}
	
	/**
	 * Column Info
	 * @param blCompleteUsrId
	 */
	public void setBlCompleteUsrId(String blCompleteUsrId) {
		this.blCompleteUsrId = blCompleteUsrId;
	}
	
	/**
	 * Column Info
	 * @param blTtlObl
	 */
	public void setBlTtlObl(String blTtlObl) {
		this.blTtlObl = blTtlObl;
	}
	
	/**
	 * Column Info
	 * @param blSwbEmail
	 */
	public void setBlSwbEmail(String blSwbEmail) {
		this.blSwbEmail = blSwbEmail;
	}
	
	/**
	 * Column Info
	 * @param blWebSwb
	 */
	public void setBlWebSwb(String blWebSwb) {
		this.blWebSwb = blWebSwb;
	}
	
	/**
	 * Column Info
	 * @param blPending
	 */
	public void setBlPending(String blPending) {
		this.blPending = blPending;
	}
	
	/**
	 * Column Info
	 * @param durationFromWeek
	 */
	public void setDurationFromWeek(String durationFromWeek) {
		this.durationFromWeek = durationFromWeek;
	}
	
	/**
	 * Column Info
	 * @param blUsrNm
	 */
	public void setBlUsrNm(String blUsrNm) {
		this.blUsrNm = blUsrNm;
	}
	
	/**
	 * Column Info
	 * @param blNis
	 */
	public void setBlNis(String blNis) {
		this.blNis = blNis;
	}
	
	/**
	 * Column Info
	 * @param docTpS
	 */
	public void setDocTpS(String docTpS) {
		this.docTpS = docTpS;
	}
	
	/**
	 * Column Info
	 * @param siSvc
	 */
	public void setSiSvc(String siSvc) {
		this.siSvc = siSvc;
	}
	
	/**
	 * Column Info
	 * @param siKind
	 */
	public void setSiKind(String siKind) {
		this.siKind = siKind;
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
	 * @param docTpL
	 */
	public void setDocTpL(String docTpL) {
		this.docTpL = docTpL;
	}
	
	/**
	 * Column Info
	 * @param siGtn
	 */
	public void setSiGtn(String siGtn) {
		this.siGtn = siGtn;
	}
	
	/**
	 * Column Info
	 * @param blCompleteCnt
	 */
	public void setBlCompleteCnt(String blCompleteCnt) {
		this.blCompleteCnt = blCompleteCnt;
	}
	
	/**
	 * Column Info
	 * @param bkgDesktop
	 */
	public void setBkgDesktop(String bkgDesktop) {
		this.bkgDesktop = bkgDesktop;
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
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param bkKind
	 */
	public void setBkKind(String bkKind) {
		this.bkKind = bkKind;
	}
	
	/**
	 * Column Info
	 * @param bkUsrNm
	 */
	public void setBkUsrNm(String bkUsrNm) {
		this.bkUsrNm = bkUsrNm;
	}
	
	/**
	 * Column Info
	 * @param durationToDt
	 */
	public void setDurationToDt(String durationToDt) {
		this.durationToDt = durationToDt;
	}
	
	/**
	 * Column Info
	 * @param siInttra
	 */
	public void setSiInttra(String siInttra) {
		this.siInttra = siInttra;
	}
	
	/**
	 * Column Info
	 * @param inetBlSndViaCd
	 */
	public void setInetBlSndViaCd(String inetBlSndViaCd) {
		this.inetBlSndViaCd = inetBlSndViaCd;
	}
	
	/**
	 * Column Info
	 * @param blUsrId
	 */
	public void setBlUsrId(String blUsrId) {
		this.blUsrId = blUsrId;
	}
	
	/**
	 * Column Info
	 * @param docTpB
	 */
	public void setDocTpB(String docTpB) {
		this.docTpB = docTpB;
	}
	
	/**
	 * Column Info
	 * @param admUsrId
	 */
	public void setAdmUsrId(String admUsrId) {
		this.admUsrId = admUsrId;
	}
	
	/**
	 * Column Info
	 * @param durationOpt
	 */
	public void setDurationOpt(String durationOpt) {
		this.durationOpt = durationOpt;
	}
	
	/**
	 * Column Info
	 * @param cust
	 */
	public void setCust(String cust) {
		this.cust = cust;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfc
	 */
	public void setCtrtOfc(String ctrtOfc) {
		this.ctrtOfc = ctrtOfc;
	}
	
	/**
	 * Column Info
	 * @return siHjstools
	 */
	public void setSiHjstools(String siHjstools) {
		this.siHjstools = siHjstools;
	}
	
	/**
	 * Column Info
	 * @return siPortal
	 */
	public void setSiPortal(String siPortal) {
		this.siPortal = siPortal;
	}
	
	/**
	 * Column Info
	 * @return bkgHjstools
	 */
	public void setBkgHjstools(String bkgHjstools) {
		this.bkgHjstools = bkgHjstools;
	}
	
	/**
	 * Column Info
	 * @return bkgPortal
	 */
	public void setBkgPortal(String bkgPortal) {
		this.bkgPortal = bkgPortal;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * @return the bkgEml
	 */
	public String getBkgEml() {
		return bkgEml;
	}
	
	/**
	 * @param bkgEml the bkgEml to set
	 */
	public void setBkgEml(String bkgEml) {
		this.bkgEml = bkgEml;
	}

	/**
	 * @return the dpcs
	 */
	public String getDpcs() {
		return dpcs;
	}

	/**
	 * @param dpcs the dpcs to set
	 */
	public void setDpcs(String dpcs) {
		this.dpcs = dpcs;
	}

	
	/**
	 * @return the bkgCnt
	 */
	public String getBkgCnt() {
		return bkgCnt;
	}

	/**
	 * @param bkgCnt the bkgCnt to set
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}

	/**
	 * @return the siCnt
	 */
	public String getSiCnt() {
		return siCnt;
	}

	/**
	 * @param siCnt the siCnt to set
	 */
	public void setSiCnt(String siCnt) {
		this.siCnt = siCnt;
	}

	/**
	 * @return the emlFlg
	 */
	public String getEmlFlg() {
		return emlFlg;
	}

	/**
	 * @return the uldFlg
	 */
	public String getUldFlg() {
		return uldFlg;
	}

	/**
	 * @param emlFlg the emlFlg to set
	 */
	public void setEmlFlg(String emlFlg) {
		this.emlFlg = emlFlg;
	}
	
	/**
	 * @param uldFlg the uldFlg to set
	 */
	public void setUldFlg(String uldFlg) {
		this.uldFlg = uldFlg;
	}	

	/**
	 * @return the faxFlg
	 */
	public String getFaxFlg() {
		return faxFlg;
	}

	/**
	 * @param faxFlg the faxFlg to set
	 */
	public void setFaxFlg(String faxFlg) {
		this.faxFlg = faxFlg;
	}

	/**
	 * @return the eml
	 */
	public String getEml() {
		return eml;
	}

	/**
	 * @param eml the eml to set
	 */
	public void setEml(String eml) {
		this.eml = eml;
	}

	/**
	 * @return the faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}

	/**
	 * @param faxNo the faxNo to set
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	
	/**
	 * @return the week
	 */
	public String getWeek() {
		return week;
	}

	/**
	 * @param week the week to set
	 */
	public void setWeek(String week) {
		this.week = week;
	}

	/**
	 * @param bkg sim
	 */
	public void setBkgSim(String bkgSim) {
		this.bkgSim = bkgSim;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setDurationMonth(JSPUtil.getParameter(request, prefix + "duration_month", ""));
		setBkUsrCnt(JSPUtil.getParameter(request, prefix + "bk_usr_cnt", ""));
		setDurationYear(JSPUtil.getParameter(request, prefix + "duration_year", ""));
		setBlKind(JSPUtil.getParameter(request, prefix + "bl_kind", ""));
		setReportType(JSPUtil.getParameter(request, prefix + "report_type", ""));
		setBkgGtn(JSPUtil.getParameter(request, prefix + "bkg_gtn", ""));
		setSiDesktop(JSPUtil.getParameter(request, prefix + "si_desktop", ""));
		setBlWebObl(JSPUtil.getParameter(request, prefix + "bl_web_obl", ""));
		setBlCompleteDt(JSPUtil.getParameter(request, prefix + "bl_complete_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSiUsrId(JSPUtil.getParameter(request, prefix + "si_usr_id", ""));
		setBkgSvc(JSPUtil.getParameter(request, prefix + "bkg_svc", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDurationToWeek(JSPUtil.getParameter(request, prefix + "duration_to_week", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setPrnUsrId(JSPUtil.getParameter(request, prefix + "prn_usr_id", ""));
		setSiWeb(JSPUtil.getParameter(request, prefix + "si_web", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setSiUsrNm(JSPUtil.getParameter(request, prefix + "si_usr_nm", ""));
		setBkgTtl(JSPUtil.getParameter(request, prefix + "bkg_ttl", ""));
		setBkgNis(JSPUtil.getParameter(request, prefix + "bkg_nis", ""));
		setZoneCd(JSPUtil.getParameter(request, prefix + "zone_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setGso(JSPUtil.getParameter(request, prefix + "gso", ""));
		setBlTtlSwb(JSPUtil.getParameter(request, prefix + "bl_ttl_swb", ""));
		setOblSndAdmUsrId(JSPUtil.getParameter(request, prefix + "obl_snd_adm_usr_id", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDurationFromDt(JSPUtil.getParameter(request, prefix + "duration_from_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSiCsm(JSPUtil.getParameter(request, prefix + "si_csm", ""));
		setSiSim(JSPUtil.getParameter(request, prefix + "si_sim", ""));
		setBlEdi(JSPUtil.getParameter(request, prefix + "bl_edi", ""));
		setBkgEdi(JSPUtil.getParameter(request, prefix + "bkg_edi", ""));
		setBkgCsm(JSPUtil.getParameter(request, prefix + "bkg_csm", ""));
		setSalOfc(JSPUtil.getParameter(request, prefix + "sal_ofc", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setSiEdi(JSPUtil.getParameter(request, prefix + "si_edi", ""));
		setSiEml(JSPUtil.getParameter(request, prefix + "si_eml", ""));
		setSiUld(JSPUtil.getParameter(request, prefix + "si_uld", ""));
		setSiDt(JSPUtil.getParameter(request, prefix + "si_dt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBlDt(JSPUtil.getParameter(request, prefix + "bl_dt", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSiNis(JSPUtil.getParameter(request, prefix + "si_nis", ""));
		setScRfaType(JSPUtil.getParameter(request, prefix + "sc_rfa_type", ""));
		setSiUsrCnt(JSPUtil.getParameter(request, prefix + "si_usr_cnt", ""));
		setSiTtl(JSPUtil.getParameter(request, prefix + "si_ttl", ""));
		setBkgInttra(JSPUtil.getParameter(request, prefix + "bkg_inttra", ""));
		setBkgWeb(JSPUtil.getParameter(request, prefix + "bkg_web", ""));
		setOblKnt(JSPUtil.getParameter(request, prefix + "obl_knt", ""));
		setHblCnt(JSPUtil.getParameter(request, prefix + "hbl_cnt", ""));
		setBlUsrCnt(JSPUtil.getParameter(request, prefix + "bl_usr_cnt", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setRegionCd(JSPUtil.getParameter(request, prefix + "region_cd", ""));
		setPrnDt(JSPUtil.getParameter(request, prefix + "prn_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgOfc(JSPUtil.getParameter(request, prefix + "bkg_ofc", ""));
		setBkUsrId(JSPUtil.getParameter(request, prefix + "bk_usr_id", ""));
		setBkDt(JSPUtil.getParameter(request, prefix + "bk_dt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setBlSvc(JSPUtil.getParameter(request, prefix + "bl_svc", ""));
		setBlCompleteUsrId(JSPUtil.getParameter(request, prefix + "bl_complete_usr_id", ""));
		setBlTtlObl(JSPUtil.getParameter(request, prefix + "bl_ttl_obl", ""));
		setBlSwbEmail(JSPUtil.getParameter(request, prefix + "bl_swb_email", ""));
		setBlWebSwb(JSPUtil.getParameter(request, prefix + "bl_web_swb", ""));
		setBlPending(JSPUtil.getParameter(request, prefix + "bl_pending", ""));
		setDurationFromWeek(JSPUtil.getParameter(request, prefix + "duration_from_week", ""));
		setBlUsrNm(JSPUtil.getParameter(request, prefix + "bl_usr_nm", ""));
		setBlNis(JSPUtil.getParameter(request, prefix + "bl_nis", ""));
		setDocTpS(JSPUtil.getParameter(request, prefix + "doc_tp_s", ""));
		setSiSvc(JSPUtil.getParameter(request, prefix + "si_svc", ""));
		setSiKind(JSPUtil.getParameter(request, prefix + "si_kind", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setDocTpL(JSPUtil.getParameter(request, prefix + "doc_tp_l", ""));
		setSiGtn(JSPUtil.getParameter(request, prefix + "si_gtn", ""));
		setBlCompleteCnt(JSPUtil.getParameter(request, prefix + "bl_complete_cnt", ""));
		setBkgDesktop(JSPUtil.getParameter(request, prefix + "bkg_desktop", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDuration(JSPUtil.getParameter(request, prefix + "duration", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setBkKind(JSPUtil.getParameter(request, prefix + "bk_kind", ""));
		setBkUsrNm(JSPUtil.getParameter(request, prefix + "bk_usr_nm", ""));
		setDurationToDt(JSPUtil.getParameter(request, prefix + "duration_to_dt", ""));
		setSiInttra(JSPUtil.getParameter(request, prefix + "si_inttra", ""));
		setInetBlSndViaCd(JSPUtil.getParameter(request, prefix + "inet_bl_snd_via_cd", ""));
		setBlUsrId(JSPUtil.getParameter(request, prefix + "bl_usr_id", ""));
		setDocTpB(JSPUtil.getParameter(request, prefix + "doc_tp_b", ""));
		setAdmUsrId(JSPUtil.getParameter(request, prefix + "adm_usr_id", ""));
		setDurationOpt(JSPUtil.getParameter(request, prefix + "duration_opt", ""));
		setCust(JSPUtil.getParameter(request, prefix + "cust", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setCtrtOfc(JSPUtil.getParameter(request, prefix + "ctrt_ofc", ""));
		setSiHjstools(JSPUtil.getParameter(request, prefix + "si_hjstools", ""));
		setSiPortal(JSPUtil.getParameter(request, prefix + "si_portal", ""));
		setBkgHjstools(JSPUtil.getParameter(request, prefix + "bkg_hjstools", ""));
		setBkgPortal(JSPUtil.getParameter(request, prefix + "bkg_portal", ""));
		setBkgEml(JSPUtil.getParameter(request, prefix + "bkg_eml", ""));
		setDpcs(JSPUtil.getParameter(request, prefix + "dpcs", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setSiCnt(JSPUtil.getParameter(request, prefix + "si_cnt", ""));
		setEmlFlg(JSPUtil.getParameter(request, prefix + "eml_flg", ""));
		setUldFlg(JSPUtil.getParameter(request, prefix + "uld_flg", ""));
		setFaxFlg(JSPUtil.getParameter(request, prefix + "fax_flg", ""));
		setEml(JSPUtil.getParameter(request, prefix + "eml", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
		setBkgSim(JSPUtil.getParameter(request, prefix + "bkg_sim", ""));
		setSiAutoBkgCnt(JSPUtil.getParameter(request, prefix + "si_auto_bkg_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EBkgSiPfmcInVO[]
	 */
	public EBkgSiPfmcInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EBkgSiPfmcInVO[]
	 */
	public EBkgSiPfmcInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EBkgSiPfmcInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] durationMonth = (JSPUtil.getParameter(request, prefix	+ "duration_month", length));
			String[] bkUsrCnt = (JSPUtil.getParameter(request, prefix	+ "bk_usr_cnt", length));
			String[] durationYear = (JSPUtil.getParameter(request, prefix	+ "duration_year", length));
			String[] blKind = (JSPUtil.getParameter(request, prefix	+ "bl_kind", length));
			String[] reportType = (JSPUtil.getParameter(request, prefix	+ "report_type", length));
			String[] bkgGtn = (JSPUtil.getParameter(request, prefix	+ "bkg_gtn", length));
			String[] siDesktop = (JSPUtil.getParameter(request, prefix	+ "si_desktop", length));
			String[] blWebObl = (JSPUtil.getParameter(request, prefix	+ "bl_web_obl", length));
			String[] blCompleteDt = (JSPUtil.getParameter(request, prefix	+ "bl_complete_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] siUsrId = (JSPUtil.getParameter(request, prefix	+ "si_usr_id", length));
			String[] bkgSvc = (JSPUtil.getParameter(request, prefix	+ "bkg_svc", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] durationToWeek = (JSPUtil.getParameter(request, prefix	+ "duration_to_week", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] prnUsrId = (JSPUtil.getParameter(request, prefix	+ "prn_usr_id", length));
			String[] siWeb = (JSPUtil.getParameter(request, prefix	+ "si_web", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] siUsrNm = (JSPUtil.getParameter(request, prefix	+ "si_usr_nm", length));
			String[] bkgTtl = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl", length));
			String[] bkgNis = (JSPUtil.getParameter(request, prefix	+ "bkg_nis", length));
			String[] zoneCd = (JSPUtil.getParameter(request, prefix	+ "zone_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] gso = (JSPUtil.getParameter(request, prefix	+ "gso", length));
			String[] blTtlSwb = (JSPUtil.getParameter(request, prefix	+ "bl_ttl_swb", length));
			String[] oblSndAdmUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_snd_adm_usr_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] durationFromDt = (JSPUtil.getParameter(request, prefix	+ "duration_from_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] siCsm = (JSPUtil.getParameter(request, prefix	+ "si_csm", length));
			String[] siSim = (JSPUtil.getParameter(request, prefix	+ "si_sim", length));
			String[] blEdi = (JSPUtil.getParameter(request, prefix	+ "bl_edi", length));
			String[] bkgEdi = (JSPUtil.getParameter(request, prefix	+ "bkg_edi", length));
			String[] bkgCsm = (JSPUtil.getParameter(request, prefix	+ "bkg_csm", length));
			String[] salOfc = (JSPUtil.getParameter(request, prefix	+ "sal_ofc", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] siEdi = (JSPUtil.getParameter(request, prefix	+ "si_edi", length));
			String[] siEml = (JSPUtil.getParameter(request, prefix	+ "si_eml", length));
			String[] siUld = (JSPUtil.getParameter(request, prefix	+ "si_uld", length));
			String[] siDt = (JSPUtil.getParameter(request, prefix	+ "si_dt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] blDt = (JSPUtil.getParameter(request, prefix	+ "bl_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] siNis = (JSPUtil.getParameter(request, prefix	+ "si_nis", length));
			String[] scRfaType = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_type", length));
			String[] siUsrCnt = (JSPUtil.getParameter(request, prefix	+ "si_usr_cnt", length));
			String[] siTtl = (JSPUtil.getParameter(request, prefix	+ "si_ttl", length));
			String[] bkgInttra = (JSPUtil.getParameter(request, prefix	+ "bkg_inttra", length));
			String[] bkgWeb = (JSPUtil.getParameter(request, prefix	+ "bkg_web", length));
			String[] oblKnt = (JSPUtil.getParameter(request, prefix	+ "obl_knt", length));
			String[] hblCnt = (JSPUtil.getParameter(request, prefix	+ "hbl_cnt", length));
			String[] blUsrCnt = (JSPUtil.getParameter(request, prefix	+ "bl_usr_cnt", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] regionCd = (JSPUtil.getParameter(request, prefix	+ "region_cd", length));
			String[] prnDt = (JSPUtil.getParameter(request, prefix	+ "prn_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] bkUsrId = (JSPUtil.getParameter(request, prefix	+ "bk_usr_id", length));
			String[] bkDt = (JSPUtil.getParameter(request, prefix	+ "bk_dt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] blSvc = (JSPUtil.getParameter(request, prefix	+ "bl_svc", length));
			String[] blCompleteUsrId = (JSPUtil.getParameter(request, prefix	+ "bl_complete_usr_id", length));
			String[] blTtlObl = (JSPUtil.getParameter(request, prefix	+ "bl_ttl_obl", length));
			String[] blSwbEmail = (JSPUtil.getParameter(request, prefix	+ "bl_swb_email", length));
			String[] blWebSwb = (JSPUtil.getParameter(request, prefix	+ "bl_web_swb", length));
			String[] blPending = (JSPUtil.getParameter(request, prefix	+ "bl_pending", length));
			String[] durationFromWeek = (JSPUtil.getParameter(request, prefix	+ "duration_from_week", length));
			String[] blUsrNm = (JSPUtil.getParameter(request, prefix	+ "bl_usr_nm", length));
			String[] blNis = (JSPUtil.getParameter(request, prefix	+ "bl_nis", length));
			String[] docTpS = (JSPUtil.getParameter(request, prefix	+ "doc_tp_s", length));
			String[] siSvc = (JSPUtil.getParameter(request, prefix	+ "si_svc", length));
			String[] siKind = (JSPUtil.getParameter(request, prefix	+ "si_kind", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] docTpL = (JSPUtil.getParameter(request, prefix	+ "doc_tp_l", length));
			String[] siGtn = (JSPUtil.getParameter(request, prefix	+ "si_gtn", length));
			String[] blCompleteCnt = (JSPUtil.getParameter(request, prefix	+ "bl_complete_cnt", length));
			String[] bkgDesktop = (JSPUtil.getParameter(request, prefix	+ "bkg_desktop", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] bkKind = (JSPUtil.getParameter(request, prefix	+ "bk_kind", length));
			String[] bkUsrNm = (JSPUtil.getParameter(request, prefix	+ "bk_usr_nm", length));
			String[] durationToDt = (JSPUtil.getParameter(request, prefix	+ "duration_to_dt", length));
			String[] siInttra = (JSPUtil.getParameter(request, prefix	+ "si_inttra", length));
			String[] inetBlSndViaCd = (JSPUtil.getParameter(request, prefix	+ "inet_bl_snd_via_cd", length));
			String[] blUsrId = (JSPUtil.getParameter(request, prefix	+ "bl_usr_id", length));
			String[] docTpB = (JSPUtil.getParameter(request, prefix	+ "doc_tp_b", length));
			String[] admUsrId = (JSPUtil.getParameter(request, prefix	+ "adm_usr_id", length));
			String[] durationOpt = (JSPUtil.getParameter(request, prefix	+ "duration_opt", length));
			String[] cust = (JSPUtil.getParameter(request, prefix	+ "cust", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] ctrtOfc = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc", length));
			String[] siHjstools = (JSPUtil.getParameter(request, prefix	+ "si_hjstools", length));
			String[] siPortal = (JSPUtil.getParameter(request, prefix	+ "si_portal", length));
			String[] bkgHjstools = (JSPUtil.getParameter(request, prefix	+ "bkg_hjstools", length));
			String[] bkgPortal = (JSPUtil.getParameter(request, prefix	+ "bkg_portal", length));
			String[] bkgEml = (JSPUtil.getParameter(request, prefix	+ "bkg_eml", length));
			String[] dpcs = (JSPUtil.getParameter(request, prefix	+ "dpcs", length));
			
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] siCnt = (JSPUtil.getParameter(request, prefix	+ "si_cnt", length));
			String[] emlFlg = (JSPUtil.getParameter(request, prefix	+ "eml_flg", length));
			String[] uldFlg = (JSPUtil.getParameter(request, prefix	+ "uld_flg", length));
			String[] faxFlg = (JSPUtil.getParameter(request, prefix	+ "fax_flg", length));
			String[] eml = (JSPUtil.getParameter(request, prefix	+ "eml", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] bkgSim = (JSPUtil.getParameter(request, prefix	+ "bkg_sim", length));
			String[] siAutoBkgCnt = (JSPUtil.getParameter(request, prefix	+ "si_auto_bkg_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EBkgSiPfmcInVO();
				if (durationMonth[i] != null)
					model.setDurationMonth(durationMonth[i]);
				if (bkUsrCnt[i] != null)
					model.setBkUsrCnt(bkUsrCnt[i]);
				if (durationYear[i] != null)
					model.setDurationYear(durationYear[i]);
				if (blKind[i] != null)
					model.setBlKind(blKind[i]);
				if (reportType[i] != null)
					model.setReportType(reportType[i]);
				if (bkgGtn[i] != null)
					model.setBkgGtn(bkgGtn[i]);
				if (siDesktop[i] != null)
					model.setSiDesktop(siDesktop[i]);
				if (blWebObl[i] != null)
					model.setBlWebObl(blWebObl[i]);
				if (blCompleteDt[i] != null)
					model.setBlCompleteDt(blCompleteDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (siUsrId[i] != null)
					model.setSiUsrId(siUsrId[i]);
				if (bkgSvc[i] != null)
					model.setBkgSvc(bkgSvc[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (durationToWeek[i] != null)
					model.setDurationToWeek(durationToWeek[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (prnUsrId[i] != null)
					model.setPrnUsrId(prnUsrId[i]);
				if (siWeb[i] != null)
					model.setSiWeb(siWeb[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (siUsrNm[i] != null)
					model.setSiUsrNm(siUsrNm[i]);
				if (bkgTtl[i] != null)
					model.setBkgTtl(bkgTtl[i]);
				if (bkgNis[i] != null)
					model.setBkgNis(bkgNis[i]);
				if (zoneCd[i] != null)
					model.setZoneCd(zoneCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (gso[i] != null)
					model.setGso(gso[i]);
				if (blTtlSwb[i] != null)
					model.setBlTtlSwb(blTtlSwb[i]);
				if (oblSndAdmUsrId[i] != null)
					model.setOblSndAdmUsrId(oblSndAdmUsrId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (durationFromDt[i] != null)
					model.setDurationFromDt(durationFromDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (siCsm[i] != null)
					model.setSiCsm(siCsm[i]);
				if (siSim[i] != null)
					model.setSiSim(siSim[i]);
				if (blEdi[i] != null)
					model.setBlEdi(blEdi[i]);
				if (bkgEdi[i] != null)
					model.setBkgEdi(bkgEdi[i]);
				if (bkgCsm[i] != null)
					model.setBkgCsm(bkgCsm[i]);
				if (salOfc[i] != null)
					model.setSalOfc(salOfc[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (siEdi[i] != null)
					model.setSiEdi(siEdi[i]);
				if (siEml[i] != null)
					model.setSiEml(siEml[i]);
				if (siUld[i] != null)
					model.setSiUld(siUld[i]);				
				if (siDt[i] != null)
					model.setSiDt(siDt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (blDt[i] != null)
					model.setBlDt(blDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (siNis[i] != null)
					model.setSiNis(siNis[i]);
				if (scRfaType[i] != null)
					model.setScRfaType(scRfaType[i]);
				if (siUsrCnt[i] != null)
					model.setSiUsrCnt(siUsrCnt[i]);
				if (siTtl[i] != null)
					model.setSiTtl(siTtl[i]);
				if (bkgInttra[i] != null)
					model.setBkgInttra(bkgInttra[i]);
				if (bkgWeb[i] != null)
					model.setBkgWeb(bkgWeb[i]);
				if (oblKnt[i] != null)
					model.setOblKnt(oblKnt[i]);
				if (hblCnt[i] != null)
					model.setHblCnt(hblCnt[i]);
				if (blUsrCnt[i] != null)
					model.setBlUsrCnt(blUsrCnt[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (regionCd[i] != null)
					model.setRegionCd(regionCd[i]);
				if (prnDt[i] != null)
					model.setPrnDt(prnDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (bkUsrId[i] != null)
					model.setBkUsrId(bkUsrId[i]);
				if (bkDt[i] != null)
					model.setBkDt(bkDt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (blSvc[i] != null)
					model.setBlSvc(blSvc[i]);
				if (blCompleteUsrId[i] != null)
					model.setBlCompleteUsrId(blCompleteUsrId[i]);
				if (blTtlObl[i] != null)
					model.setBlTtlObl(blTtlObl[i]);
				if (blSwbEmail[i] != null)
					model.setBlSwbEmail(blSwbEmail[i]);
				if (blWebSwb[i] != null)
					model.setBlWebSwb(blWebSwb[i]);
				if (blPending[i] != null)
					model.setBlPending(blPending[i]);
				if (durationFromWeek[i] != null)
					model.setDurationFromWeek(durationFromWeek[i]);
				if (blUsrNm[i] != null)
					model.setBlUsrNm(blUsrNm[i]);
				if (blNis[i] != null)
					model.setBlNis(blNis[i]);
				if (docTpS[i] != null)
					model.setDocTpS(docTpS[i]);
				if (siSvc[i] != null)
					model.setSiSvc(siSvc[i]);
				if (siKind[i] != null)
					model.setSiKind(siKind[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (docTpL[i] != null)
					model.setDocTpL(docTpL[i]);
				if (siGtn[i] != null)
					model.setSiGtn(siGtn[i]);
				if (blCompleteCnt[i] != null)
					model.setBlCompleteCnt(blCompleteCnt[i]);
				if (bkgDesktop[i] != null)
					model.setBkgDesktop(bkgDesktop[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (bkKind[i] != null)
					model.setBkKind(bkKind[i]);
				if (bkUsrNm[i] != null)
					model.setBkUsrNm(bkUsrNm[i]);
				if (durationToDt[i] != null)
					model.setDurationToDt(durationToDt[i]);
				if (siInttra[i] != null)
					model.setSiInttra(siInttra[i]);
				if (inetBlSndViaCd[i] != null)
					model.setInetBlSndViaCd(inetBlSndViaCd[i]);
				if (blUsrId[i] != null)
					model.setBlUsrId(blUsrId[i]);
				if (docTpB[i] != null)
					model.setDocTpB(docTpB[i]);
				if (admUsrId[i] != null)
					model.setAdmUsrId(admUsrId[i]);
				if (durationOpt[i] != null)
					model.setDurationOpt(durationOpt[i]);
				if (cust[i] != null)
					model.setCust(cust[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (ctrtOfc[i] != null)
					model.setCtrtOfc(ctrtOfc[i]);
				if (siHjstools[i] != null)
					model.setSiHjstools(siHjstools[i]);
				if (siPortal[i] != null)
					model.setSiPortal(siPortal[i]);
				if (bkgHjstools[i] != null)
					model.setBkgHjstools(bkgHjstools[i]);
				if (bkgPortal[i] != null)
					model.setBkgPortal(bkgPortal[i]);
				if (bkgEml[i] != null)
					model.setBkgEml(bkgEml[i]);
				if (dpcs[i] != null)
					model.setDpcs(dpcs[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (siCnt[i] != null)
					model.setSiCnt(siCnt[i]);
				if (emlFlg[i] != null)
					model.setEmlFlg(emlFlg[i]);
				if (uldFlg[i] != null)
					model.setUldFlg(uldFlg[i]);
				if (faxFlg[i] != null)
					model.setFaxFlg(faxFlg[i]);
				if (eml[i] != null)
					model.setEml(eml[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (bkgSim[i] != null)
					model.setBkgSim(bkgSim[i]);
				if (siAutoBkgCnt[i] != null)
					model.setSiAutoBkgCnt(siAutoBkgCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEBkgSiPfmcInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EBkgSiPfmcInVO[]
	 */
	public EBkgSiPfmcInVO[] getEBkgSiPfmcInVOs(){
		EBkgSiPfmcInVO[] vos = (EBkgSiPfmcInVO[])models.toArray(new EBkgSiPfmcInVO[models.size()]);
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
		this.durationMonth = this.durationMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkUsrCnt = this.bkUsrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationYear = this.durationYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blKind = this.blKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reportType = this.reportType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgGtn = this.bkgGtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siDesktop = this.siDesktop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWebObl = this.blWebObl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCompleteDt = this.blCompleteDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siUsrId = this.siUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSvc = this.bkgSvc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationToWeek = this.durationToWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnUsrId = this.prnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siWeb = this.siWeb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siUsrNm = this.siUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtl = this.bkgTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNis = this.bkgNis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zoneCd = this.zoneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gso = this.gso .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTtlSwb = this.blTtlSwb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblSndAdmUsrId = this.oblSndAdmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationFromDt = this.durationFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCsm = this.siCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siSim = this.siSim .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blEdi = this.blEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEdi = this.bkgEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCsm = this.bkgCsm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salOfc = this.salOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siEdi = this.siEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siEml = this.siEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siUld = this.siUld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siDt = this.siDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDt = this.blDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siNis = this.siNis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaType = this.scRfaType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siUsrCnt = this.siUsrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siTtl = this.siTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgInttra = this.bkgInttra .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWeb = this.bkgWeb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblKnt = this.oblKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblCnt = this.hblCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blUsrCnt = this.blUsrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionCd = this.regionCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnDt = this.prnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkUsrId = this.bkUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkDt = this.bkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSvc = this.blSvc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCompleteUsrId = this.blCompleteUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTtlObl = this.blTtlObl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSwbEmail = this.blSwbEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWebSwb = this.blWebSwb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPending = this.blPending .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationFromWeek = this.durationFromWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blUsrNm = this.blUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNis = this.blNis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpS = this.docTpS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siSvc = this.siSvc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siKind = this.siKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpL = this.docTpL .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siGtn = this.siGtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCompleteCnt = this.blCompleteCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDesktop = this.bkgDesktop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkKind = this.bkKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkUsrNm = this.bkUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationToDt = this.durationToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siInttra = this.siInttra .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inetBlSndViaCd = this.inetBlSndViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blUsrId = this.blUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpB = this.docTpB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.admUsrId = this.admUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durationOpt = this.durationOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cust = this.cust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfc = this.ctrtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siHjstools = this.siHjstools .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siPortal = this.siPortal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHjstools = this.bkgHjstools .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPortal = this.bkgPortal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgEml = this.bkgEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcs = this.dpcs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCnt = this.siCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFlg = this.emlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uldFlg = this.uldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxFlg = this.faxFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eml = this.eml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSim = this.bkgSim .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siAutoBkgCnt = this.siAutoBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}

	public String getSiAutoBkgCnt() {
		return siAutoBkgCnt;
	}

	public void setSiAutoBkgCnt(String siAutoBkgCnt) {
		this.siAutoBkgCnt = siAutoBkgCnt;
	}
}
