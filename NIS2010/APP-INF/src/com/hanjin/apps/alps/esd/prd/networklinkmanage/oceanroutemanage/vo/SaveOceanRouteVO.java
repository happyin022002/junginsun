/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SaveOceanRouteVO.java
*@FileTitle : SaveOceanRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.21 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SaveOceanRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaveOceanRouteVO> models = new ArrayList<SaveOceanRouteVO>();
	
	/* Column Info */
	private String sTs3Lane = null;
	/* Column Info */
	private String sLnkCnt = null;
	/* Column Info */
	private String sTs3Tztm = null;
	/* Column Info */
	private String sSvcType = null;
	/* Column Info */
	private String tsIndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sTs2Tztm = null;
	/* Column Info */
	private String sTs2Type = null;
	/* Column Info */
	private String sPfInd = null;
	/* Column Info */
	private String sRouteFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sN1stTztmHrs = null;
	/* Column Info */
	private String sN2ndTztmHrs = null;
	/* Column Info */
	private String menu = null;
	/* Column Info */
	private String sTs2Port = null;
	/* Column Info */
	private String sPrior = null;
	/* Column Info */
	private String sTs1Tztm = null;
	/* Column Info */
	private String sTs1Port = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String sRoutSeq = null;
	/* Column Info */
	private String sPod = null;
	/* Column Info */
	private String sTs1Lane = null;
	/* Column Info */
	private String sPol = null;
	/* Column Info */
	private String sTs1StayTm = null;
	/* Column Info */
	private String sN1stStayTmHrs = null;
	/* Column Info */
	private String sLane = null;
	/* Column Info */
	private String sSTime = null;
	/* Column Info */
	private String sPod1 = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String sTTime = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String sN2ndStayTmHrs = null;
	/* Column Info */
	private String sTs2Lane = null;
	/* Column Info */
	private String sN3rdStayTmHrs = null;
	/* Column Info */
	private String sDupAllow = null;
	/* Column Info */
	private String sTsInd = null;
	/* Column Info */
	private String sFU = null;
	/* Column Info */
	private String sRouteRmk = null;
	/* Column Info */
	private String sRouteNote = null;  // 2011.07.07 LSJ 추가
	/* Column Info */
	private String sRmk = null;
	/* Column Info */
	private String sTs3Port = null;
	/* Column Info */
	private String sN4thTztmHrs = null;
	/* Column Info */
	private String sTs3Type = null;
	/* Column Info */
	private String sFdrFlg4 = null;
	/* Column Info */
	private String sN3rdTztmHrs = null;
	/* Column Info */
	private String pfIndCd = null;
	/* Column Info */
	private String sFdrFlg1 = null;
	/* Column Info */
	private String sPod2 = null;
	/* Column Info */
	private String sDir4 = null;
	/* Column Info */
	private String sPod3 = null;
	/* Column Info */
	private String sPol1 = null;
	/* Column Info */
	private String sDir2 = null;
	/* Column Info */
	private String sFdrFlg3 = null;
	/* Column Info */
	private String sPod4 = null;
	/* Column Info */
	private String sFdrFlg2 = null;
	/* Column Info */
	private String sDir3 = null;
	/* Column Info */
	private String sPol3 = null;
	/* Column Info */
	private String sDir1 = null;
	/* Column Info */
	private String sPol2 = null;
	/* Column Info */
	private String sTs2StayTm = null;
	/* Column Info */
	private String sPol4 = null;
	/* Column Info */
	private String sTs1Type = null;
	/* Column Info */
	private String sTs4Lane = null;
	/* Column Info */
	private String sTs4Type = null;
	/* Column Info */
	private String sErrTp = null;
	/* Column Info */
	private String sErrDesc = null;
	/* Column Info */
	private String sChk = null;
	/* Column Info */
	private String fmtTotTt = null;
	/* Column Info */
	private String fmtTotSt = null;
	/* Column Info */
	private String sSeq = null;
	/* Column Info */
	private String fullRout = null;
	/* Column Info */
	private String sOcnRoutTmpExpDt = null;
	/* Column Info */
	private String sOcnRoutTmpFlg = null;
	/* Column Info */
	private String sUpdIndCd = null; 
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SaveOceanRouteVO() {}

	public SaveOceanRouteVO(String ibflag, String pagerows, String sPol, String sLane, String sSvcType, String sTs1Port, String sTs1Lane, String sTs1Type, String sTs2Port, String sTs2Lane, String sTs2Type, String sPod, String sTTime, String sSTime, String sPrior, String sFU, String sRouteFlg, String sRoutSeq, String sTsInd, String sPfInd, String sTs1Tztm, String sTs2Tztm, String sTs3Tztm, String sTs1StayTm, String sTs2StayTm, String sRouteRmk, String sRouteNote, String sTs3Port, String sTs3Lane, String sTs3Type, String sPol1, String sPod1, String sDir1, String sFdrFlg1, String sPol2, String sPod2, String sDir2, String sFdrFlg2, String sPol3, String sPod3, String sDir3, String sFdrFlg3, String sPol4, String sPod4, String sDir4, String sFdrFlg4, String sN1stTztmHrs, String sN2ndTztmHrs, String sN3rdTztmHrs, String sN4thTztmHrs, String sN1stStayTmHrs, String sN2ndStayTmHrs, String sN3rdStayTmHrs, String sDupAllow, String sLnkCnt, String updUsrId, String creUsrId, String creOfcCd, String sRmk, String pfIndCd, String tsIndCd, String menu, String maxSeq,String sTs4Lane,String sTs4Type, String sErrTp, String sErrDesc, String sChk, String fmtTotTt, String fmtTotSt, String sSeq, String fullRout, String sOcnRoutTmpExpDt, String sOcnRoutTmpFlg, String sUpdIndCd) {
		this.sTs3Lane = sTs3Lane;
		this.sLnkCnt = sLnkCnt;
		this.sTs3Tztm = sTs3Tztm;
		this.sSvcType = sSvcType;
		this.tsIndCd = tsIndCd;
		this.pagerows = pagerows;
		this.sTs2Tztm = sTs2Tztm;
		this.sTs2Type = sTs2Type;
		this.sPfInd = sPfInd;
		this.sRouteFlg = sRouteFlg;
		this.updUsrId = updUsrId;
		this.sN1stTztmHrs = sN1stTztmHrs;
		this.sN2ndTztmHrs = sN2ndTztmHrs;
		this.menu = menu;
		this.sTs2Port = sTs2Port;
		this.sPrior = sPrior;
		this.sTs1Tztm = sTs1Tztm;
		this.sTs1Port = sTs1Port;
		this.creUsrId = creUsrId;
		this.maxSeq = maxSeq;
		this.sRoutSeq = sRoutSeq;
		this.sPod = sPod;
		this.sTs1Lane = sTs1Lane;
		this.sPol = sPol;
		this.sTs1StayTm = sTs1StayTm;
		this.sN1stStayTmHrs = sN1stStayTmHrs;
		this.sLane = sLane;
		this.sSTime = sSTime;
		this.sPod1 = sPod1;
		this.ibflag = ibflag;
		this.sTTime = sTTime;
		this.creOfcCd = creOfcCd;
		this.sN2ndStayTmHrs = sN2ndStayTmHrs;
		this.sTs2Lane = sTs2Lane;
		this.sN3rdStayTmHrs = sN3rdStayTmHrs;
		this.sDupAllow = sDupAllow;
		this.sTsInd = sTsInd;
		this.sFU = sFU;
		this.sRouteRmk = sRouteRmk;
		this.sRouteNote = sRouteNote;
		this.sRmk = sRmk;
		this.sTs3Port = sTs3Port;
		this.sN4thTztmHrs = sN4thTztmHrs;
		this.sTs3Type = sTs3Type;
		this.sFdrFlg4 = sFdrFlg4;
		this.sN3rdTztmHrs = sN3rdTztmHrs;
		this.pfIndCd = pfIndCd;
		this.sFdrFlg1 = sFdrFlg1;
		this.sPod2 = sPod2;
		this.sDir4 = sDir4;
		this.sPod3 = sPod3;
		this.sPol1 = sPol1;
		this.sDir2 = sDir2;
		this.sFdrFlg3 = sFdrFlg3;
		this.sPod4 = sPod4;
		this.sFdrFlg2 = sFdrFlg2;
		this.sDir3 = sDir3;
		this.sPol3 = sPol3;
		this.sDir1 = sDir1;
		this.sPol2 = sPol2;
		this.sTs2StayTm = sTs2StayTm;
		this.sPol4 = sPol4;
		this.sTs1Type = sTs1Type;
		this.sTs4Lane = sTs4Lane;
		this.sTs4Type = sTs4Type;
		this.sErrTp = sErrTp;
		this.sErrDesc = sErrDesc;
		this.sChk = sChk;
		this.fmtTotTt = fmtTotTt;
		this.fmtTotSt = fmtTotSt;
		this.sSeq = sSeq;
		this.fullRout = fullRout;
		this.sOcnRoutTmpExpDt = sOcnRoutTmpExpDt;
		this.sOcnRoutTmpFlg = sOcnRoutTmpFlg;
		this.sUpdIndCd = sUpdIndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_ts3_lane", getSTs3Lane());
		this.hashColumns.put("s_lnk_cnt", getSLnkCnt());
		this.hashColumns.put("s_ts3_tztm", getSTs3Tztm());
		this.hashColumns.put("s_svc_type", getSSvcType());
		this.hashColumns.put("ts_ind_cd", getTsIndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_ts2_tztm", getSTs2Tztm());
		this.hashColumns.put("s_ts2_type", getSTs2Type());
		this.hashColumns.put("s_pf_ind", getSPfInd());
		this.hashColumns.put("s_route_flg", getSRouteFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s_n1st_tztm_hrs", getSN1stTztmHrs());
		this.hashColumns.put("s_n2nd_tztm_hrs", getSN2ndTztmHrs());
		this.hashColumns.put("menu", getMenu());
		this.hashColumns.put("s_ts2_port", getSTs2Port());
		this.hashColumns.put("s_prior", getSPrior());
		this.hashColumns.put("s_ts1_tztm", getSTs1Tztm());
		this.hashColumns.put("s_ts1_port", getSTs1Port());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("s_rout_seq", getSRoutSeq());
		this.hashColumns.put("s_pod", getSPod());
		this.hashColumns.put("s_ts1_lane", getSTs1Lane());
		this.hashColumns.put("s_pol", getSPol());
		this.hashColumns.put("s_ts1_stay_tm", getSTs1StayTm());
		this.hashColumns.put("s_n1st_stay_tm_hrs", getSN1stStayTmHrs());
		this.hashColumns.put("s_lane", getSLane());
		this.hashColumns.put("s_s_time", getSSTime());
		this.hashColumns.put("s_pod1", getSPod1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_t_time", getSTTime());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("s_n2nd_stay_tm_hrs", getSN2ndStayTmHrs());
		this.hashColumns.put("s_ts2_lane", getSTs2Lane());
		this.hashColumns.put("s_n3rd_stay_tm_hrs", getSN3rdStayTmHrs());
		this.hashColumns.put("s_dup_allow", getSDupAllow());
		this.hashColumns.put("s_ts_ind", getSTsInd());
		this.hashColumns.put("s_f_u", getSFU());
		this.hashColumns.put("s_route_rmk", getSRouteRmk());
		this.hashColumns.put("s_route_note", getSRouteNote());
		this.hashColumns.put("s_rmk", getSRmk());
		this.hashColumns.put("s_ts3_port", getSTs3Port());
		this.hashColumns.put("s_n4th_tztm_hrs", getSN4thTztmHrs());
		this.hashColumns.put("s_ts3_type", getSTs3Type());
		this.hashColumns.put("s_fdr_flg4", getSFdrFlg4());
		this.hashColumns.put("s_n3rd_tztm_hrs", getSN3rdTztmHrs());
		this.hashColumns.put("pf_ind_cd", getPfIndCd());
		this.hashColumns.put("s_fdr_flg1", getSFdrFlg1());
		this.hashColumns.put("s_pod2", getSPod2());
		this.hashColumns.put("s_dir4", getSDir4());
		this.hashColumns.put("s_pod3", getSPod3());
		this.hashColumns.put("s_pol1", getSPol1());
		this.hashColumns.put("s_dir2", getSDir2());
		this.hashColumns.put("s_fdr_flg3", getSFdrFlg3());
		this.hashColumns.put("s_pod4", getSPod4());
		this.hashColumns.put("s_fdr_flg2", getSFdrFlg2());
		this.hashColumns.put("s_dir3", getSDir3());
		this.hashColumns.put("s_pol3", getSPol3());
		this.hashColumns.put("s_dir1", getSDir1());
		this.hashColumns.put("s_pol2", getSPol2());
		this.hashColumns.put("s_ts2_stay_tm", getSTs2StayTm());
		this.hashColumns.put("s_pol4", getSPol4());
		this.hashColumns.put("s_ts1_type", getSTs1Type());
		this.hashColumns.put("s_ts4_lane", getSTs4Lane());
		this.hashColumns.put("s_ts4_type", getSTs4Type());
		this.hashColumns.put("s_err_tp", getSErrTp());
		this.hashColumns.put("s_err_desc", getSErrDesc());
		this.hashColumns.put("s_chk", getSChk());
		this.hashColumns.put("fmt_tot_tt", getFmtTotTt());
		this.hashColumns.put("fmt_tot_st", getFmtTotSt());
		this.hashColumns.put("s_seq", getSSeq());
		this.hashColumns.put("full_rout", getFullRout());
		this.hashColumns.put("s_ocn_rout_tmp_exp_dt", getSOcnRoutTmpExpDt());
		this.hashColumns.put("s_ocn_rout_tmp_flg", getSOcnRoutTmpFlg());
		this.hashColumns.put("s_upd_ind_cd", getSUpdIndCd());
		return this.hashColumns;
	}
	
	public String getSTs4Lane() {
		return sTs4Lane;
	}

	public void setSTs4Lane(String ts4Lane) {
		sTs4Lane = ts4Lane;
	}

	public String getSTs4Type() {
		return sTs4Type;
	}

	public void setSTs4Type(String ts4Type) {
		sTs4Type = ts4Type;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_ts3_lane", "sTs3Lane");
		this.hashFields.put("s_lnk_cnt", "sLnkCnt");
		this.hashFields.put("s_ts3_tztm", "sTs3Tztm");
		this.hashFields.put("s_svc_type", "sSvcType");
		this.hashFields.put("ts_ind_cd", "tsIndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_ts2_tztm", "sTs2Tztm");
		this.hashFields.put("s_ts2_type", "sTs2Type");
		this.hashFields.put("s_pf_ind", "sPfInd");
		this.hashFields.put("s_route_flg", "sRouteFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s_n1st_tztm_hrs", "sN1stTztmHrs");
		this.hashFields.put("s_n2nd_tztm_hrs", "sN2ndTztmHrs");
		this.hashFields.put("menu", "menu");
		this.hashFields.put("s_ts2_port", "sTs2Port");
		this.hashFields.put("s_prior", "sPrior");
		this.hashFields.put("s_ts1_tztm", "sTs1Tztm");
		this.hashFields.put("s_ts1_port", "sTs1Port");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("s_rout_seq", "sRoutSeq");
		this.hashFields.put("s_pod", "sPod");
		this.hashFields.put("s_ts1_lane", "sTs1Lane");
		this.hashFields.put("s_pol", "sPol");
		this.hashFields.put("s_ts1_stay_tm", "sTs1StayTm");
		this.hashFields.put("s_n1st_stay_tm_hrs", "sN1stStayTmHrs");
		this.hashFields.put("s_lane", "sLane");
		this.hashFields.put("s_s_time", "sSTime");
		this.hashFields.put("s_pod1", "sPod1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_t_time", "sTTime");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("s_n2nd_stay_tm_hrs", "sN2ndStayTmHrs");
		this.hashFields.put("s_ts2_lane", "sTs2Lane");
		this.hashFields.put("s_n3rd_stay_tm_hrs", "sN3rdStayTmHrs");
		this.hashFields.put("s_dup_allow", "sDupAllow");
		this.hashFields.put("s_ts_ind", "sTsInd");
		this.hashFields.put("s_f_u", "sFU");
		this.hashFields.put("s_route_rmk", "sRouteRmk");
		
		this.hashFields.put("s_route_note", "sRouteNote");
		
		this.hashFields.put("s_rmk", "sRmk");
		this.hashFields.put("s_ts3_port", "sTs3Port");
		this.hashFields.put("s_n4th_tztm_hrs", "sN4thTztmHrs");
		this.hashFields.put("s_ts3_type", "sTs3Type");
		this.hashFields.put("s_fdr_flg4", "sFdrFlg4");
		this.hashFields.put("s_n3rd_tztm_hrs", "sN3rdTztmHrs");
		this.hashFields.put("pf_ind_cd", "pfIndCd");
		this.hashFields.put("s_fdr_flg1", "sFdrFlg1");
		this.hashFields.put("s_pod2", "sPod2");
		this.hashFields.put("s_dir4", "sDir4");
		this.hashFields.put("s_pod3", "sPod3");
		this.hashFields.put("s_pol1", "sPol1");
		this.hashFields.put("s_dir2", "sDir2");
		this.hashFields.put("s_fdr_flg3", "sFdrFlg3");
		this.hashFields.put("s_pod4", "sPod4");
		this.hashFields.put("s_fdr_flg2", "sFdrFlg2");
		this.hashFields.put("s_dir3", "sDir3");
		this.hashFields.put("s_pol3", "sPol3");
		this.hashFields.put("s_dir1", "sDir1");
		this.hashFields.put("s_pol2", "sPol2");
		this.hashFields.put("s_ts2_stay_tm", "sTs2StayTm");
		this.hashFields.put("s_pol4", "sPol4");
		this.hashFields.put("s_ts1_type", "sTs1Type");
		
		this.hashFields.put("s_ts4_lane", "sTs4Lane");
		this.hashFields.put("s_ts4_type", "sTs4Type");
		this.hashFields.put("s_err_tp", "sErrTp");
		this.hashFields.put("s_err_desc", "sErrDesc");
		this.hashFields.put("s_chk", "sChk");
		this.hashFields.put("fmt_tot_tt", "fmtTotTt");
		this.hashFields.put("fmt_tot_st", "fmtTotSt");
		this.hashFields.put("s_seq", "sSeq");
		this.hashFields.put("full_rout", "fullRout");
		this.hashFields.put("s_ocn_rout_tmp_exp_dt", "sOcnRoutTmpExpDt");
		this.hashFields.put("s_ocn_rout_tmp_flg", "sOcnRoutTmpFlg");
		this.hashFields.put("s_upd_ind_cd", "sUpdIndCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sTs3Lane
	 */
	public String getSTs3Lane() {
		return this.sTs3Lane;
	}
	
	/**
	 * Column Info
	 * @return sLnkCnt
	 */
	public String getSLnkCnt() {
		return this.sLnkCnt;
	}
	
	/**
	 * Column Info
	 * @return sTs3Tztm
	 */
	public String getSTs3Tztm() {
		return this.sTs3Tztm;
	}
	
	/**
	 * Column Info
	 * @return sSvcType
	 */
	public String getSSvcType() {
		return this.sSvcType;
	}
	
	/**
	 * Column Info
	 * @return tsIndCd
	 */
	public String getTsIndCd() {
		return this.tsIndCd;
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
	 * @return sTs2Tztm
	 */
	public String getSTs2Tztm() {
		return this.sTs2Tztm;
	}
	
	/**
	 * Column Info
	 * @return sTs2Type
	 */
	public String getSTs2Type() {
		return this.sTs2Type;
	}
	
	/**
	 * Column Info
	 * @return sPfInd
	 */
	public String getSPfInd() {
		return this.sPfInd;
	}
	
	/**
	 * Column Info
	 * @return sRouteFlg
	 */
	public String getSRouteFlg() {
		return this.sRouteFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return sN1stTztmHrs
	 */
	public String getSN1stTztmHrs() {
		return this.sN1stTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return sN2ndTztmHrs
	 */
	public String getSN2ndTztmHrs() {
		return this.sN2ndTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return menu
	 */
	public String getMenu() {
		return this.menu;
	}
	
	/**
	 * Column Info
	 * @return sTs2Port
	 */
	public String getSTs2Port() {
		return this.sTs2Port;
	}
	
	/**
	 * Column Info
	 * @return sPrior
	 */
	public String getSPrior() {
		return this.sPrior;
	}
	
	/**
	 * Column Info
	 * @return sTs1Tztm
	 */
	public String getSTs1Tztm() {
		return this.sTs1Tztm;
	}
	
	/**
	 * Column Info
	 * @return sTs1Port
	 */
	public String getSTs1Port() {
		return this.sTs1Port;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
	}
	
	/**
	 * Column Info
	 * @return sRoutSeq
	 */
	public String getSRoutSeq() {
		return this.sRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return sPod
	 */
	public String getSPod() {
		return this.sPod;
	}
	
	/**
	 * Column Info
	 * @return sTs1Lane
	 */
	public String getSTs1Lane() {
		return this.sTs1Lane;
	}
	
	/**
	 * Column Info
	 * @return sPol
	 */
	public String getSPol() {
		return this.sPol;
	}
	
	/**
	 * Column Info
	 * @return sTs1StayTm
	 */
	public String getSTs1StayTm() {
		return this.sTs1StayTm;
	}
	
	/**
	 * Column Info
	 * @return sN1stStayTmHrs
	 */
	public String getSN1stStayTmHrs() {
		return this.sN1stStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @return sLane
	 */
	public String getSLane() {
		return this.sLane;
	}
	
	/**
	 * Column Info
	 * @return sSTime
	 */
	public String getSSTime() {
		return this.sSTime;
	}
	
	/**
	 * Column Info
	 * @return sPod1
	 */
	public String getSPod1() {
		return this.sPod1;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return sTTime
	 */
	public String getSTTime() {
		return this.sTTime;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sN2ndStayTmHrs
	 */
	public String getSN2ndStayTmHrs() {
		return this.sN2ndStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @return sTs2Lane
	 */
	public String getSTs2Lane() {
		return this.sTs2Lane;
	}
	
	/**
	 * Column Info
	 * @return sN3rdStayTmHrs
	 */
	public String getSN3rdStayTmHrs() {
		return this.sN3rdStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @return sDupAllow
	 */
	public String getSDupAllow() {
		return this.sDupAllow;
	}
	
	/**
	 * Column Info
	 * @return sTsInd
	 */
	public String getSTsInd() {
		return this.sTsInd;
	}
	
	/**
	 * Column Info
	 * @return sFU
	 */
	public String getSFU() {
		return this.sFU;
	}
	
	/**
	 * Column Info
	 * @return sRouteRmk
	 */
	public String getSRouteRmk() {
		return this.sRouteRmk;
	}
	
	/**
	 * Column Info
	 * @return sRouteNote
	 */
	public String getSRouteNote() {
		return this.sRouteNote;
	}	
	
	
	
	
	/**
	 * Column Info
	 * @return sRmk
	 */
	public String getSRmk() {
		return this.sRmk;
	}
	
	/**
	 * Column Info
	 * @return sTs3Port
	 */
	public String getSTs3Port() {
		return this.sTs3Port;
	}
	
	/**
	 * Column Info
	 * @return sN4thTztmHrs
	 */
	public String getSN4thTztmHrs() {
		return this.sN4thTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return sTs3Type
	 */
	public String getSTs3Type() {
		return this.sTs3Type;
	}
	
	/**
	 * Column Info
	 * @return sFdrFlg4
	 */
	public String getSFdrFlg4() {
		return this.sFdrFlg4;
	}
	
	/**
	 * Column Info
	 * @return sN3rdTztmHrs
	 */
	public String getSN3rdTztmHrs() {
		return this.sN3rdTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return pfIndCd
	 */
	public String getPfIndCd() {
		return this.pfIndCd;
	}
	
	/**
	 * Column Info
	 * @return sFdrFlg1
	 */
	public String getSFdrFlg1() {
		return this.sFdrFlg1;
	}
	
	/**
	 * Column Info
	 * @return sPod2
	 */
	public String getSPod2() {
		return this.sPod2;
	}
	
	/**
	 * Column Info
	 * @return sDir4
	 */
	public String getSDir4() {
		return this.sDir4;
	}
	
	/**
	 * Column Info
	 * @return sPod3
	 */
	public String getSPod3() {
		return this.sPod3;
	}
	
	/**
	 * Column Info
	 * @return sPol1
	 */
	public String getSPol1() {
		return this.sPol1;
	}
	
	/**
	 * Column Info
	 * @return sDir2
	 */
	public String getSDir2() {
		return this.sDir2;
	}
	
	/**
	 * Column Info
	 * @return sFdrFlg3
	 */
	public String getSFdrFlg3() {
		return this.sFdrFlg3;
	}
	
	/**
	 * Column Info
	 * @return sPod4
	 */
	public String getSPod4() {
		return this.sPod4;
	}
	
	/**
	 * Column Info
	 * @return sFdrFlg2
	 */
	public String getSFdrFlg2() {
		return this.sFdrFlg2;
	}
	
	/**
	 * Column Info
	 * @return sDir3
	 */
	public String getSDir3() {
		return this.sDir3;
	}
	
	/**
	 * Column Info
	 * @return sPol3
	 */
	public String getSPol3() {
		return this.sPol3;
	}
	
	/**
	 * Column Info
	 * @return sDir1
	 */
	public String getSDir1() {
		return this.sDir1;
	}
	
	/**
	 * Column Info
	 * @return sPol2
	 */
	public String getSPol2() {
		return this.sPol2;
	}
	
	/**
	 * Column Info
	 * @return sTs2StayTm
	 */
	public String getSTs2StayTm() {
		return this.sTs2StayTm;
	}
	
	/**
	 * Column Info
	 * @return sPol4
	 */
	public String getSPol4() {
		return this.sPol4;
	}
	
	/**
	 * Column Info
	 * @return sTs1Type
	 */
	public String getSTs1Type() {
		return this.sTs1Type;
	}
	
	/**
	 * Column Info
	 * @return sErrTp
	 */
	public String getSErrTp() {
		return this.sErrTp;
	}
	
	/**
	 * Column Info
	 * @return sErrDesc
	 */
	public String getSErrDesc() {
		return this.sErrDesc;
	}
	
	/**
	 * Column Info
	 * @return sChk
	 */
	public String getSChk() {
		return this.sChk;
	}
	
	/**
	 * Column Info
	 * @return fmtTotTt
	 */
	public String getFmtTotTt() {
		return this.fmtTotTt;
	}
	
	/**
	 * Column Info
	 * @return fmtTotSt
	 */
	public String getFmtTotSt() {
		return this.fmtTotSt;
	}
	
	/**
	 * Column Info
	 * @return sSeq
	 */
	public String getSSeq() {
		return this.sSeq;
	}
	
	/**
	 * Column Info
	 * @return fullRout
	 */
	public String getFullRout() {
		return this.fullRout;
	}
	

	public String getSOcnRoutTmpExpDt() {
		return sOcnRoutTmpExpDt;
	}

	public String getSOcnRoutTmpFlg() {
		return sOcnRoutTmpFlg;
	}

	public String getSUpdIndCd() {
		return sUpdIndCd;
	}

	public void setSUpdIndCd(String sUpdIndCd) {
		this.sUpdIndCd = sUpdIndCd;
	}

	public void setSOcnRoutTmpFlg(String sOcnRoutTmpFlg) {
		this.sOcnRoutTmpFlg = sOcnRoutTmpFlg;
	}

	public void setSOcnRoutTmpExpDt(String sOcnRoutTmpExpDt) {
		this.sOcnRoutTmpExpDt = sOcnRoutTmpExpDt;
	}

	/**
	 * Column Info
	 * @param sTs3Lane
	 */
	public void setSTs3Lane(String sTs3Lane) {
		this.sTs3Lane = sTs3Lane;
	}
	
	/**
	 * Column Info
	 * @param sLnkCnt
	 */
	public void setSLnkCnt(String sLnkCnt) {
		this.sLnkCnt = sLnkCnt;
	}
	
	/**
	 * Column Info
	 * @param sTs3Tztm
	 */
	public void setSTs3Tztm(String sTs3Tztm) {
		this.sTs3Tztm = sTs3Tztm;
	}
	
	/**
	 * Column Info
	 * @param sSvcType
	 */
	public void setSSvcType(String sSvcType) {
		this.sSvcType = sSvcType;
	}
	
	/**
	 * Column Info
	 * @param tsIndCd
	 */
	public void setTsIndCd(String tsIndCd) {
		this.tsIndCd = tsIndCd;
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
	 * @param sTs2Tztm
	 */
	public void setSTs2Tztm(String sTs2Tztm) {
		this.sTs2Tztm = sTs2Tztm;
	}
	
	/**
	 * Column Info
	 * @param sTs2Type
	 */
	public void setSTs2Type(String sTs2Type) {
		this.sTs2Type = sTs2Type;
	}
	
	/**
	 * Column Info
	 * @param sPfInd
	 */
	public void setSPfInd(String sPfInd) {
		this.sPfInd = sPfInd;
	}
	
	/**
	 * Column Info
	 * @param sRouteFlg
	 */
	public void setSRouteFlg(String sRouteFlg) {
		this.sRouteFlg = sRouteFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param sN1stTztmHrs
	 */
	public void setSN1stTztmHrs(String sN1stTztmHrs) {
		this.sN1stTztmHrs = sN1stTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param sN2ndTztmHrs
	 */
	public void setSN2ndTztmHrs(String sN2ndTztmHrs) {
		this.sN2ndTztmHrs = sN2ndTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param menu
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	/**
	 * Column Info
	 * @param sTs2Port
	 */
	public void setSTs2Port(String sTs2Port) {
		this.sTs2Port = sTs2Port;
	}
	
	/**
	 * Column Info
	 * @param sPrior
	 */
	public void setSPrior(String sPrior) {
		this.sPrior = sPrior;
	}
	
	/**
	 * Column Info
	 * @param sTs1Tztm
	 */
	public void setSTs1Tztm(String sTs1Tztm) {
		this.sTs1Tztm = sTs1Tztm;
	}
	
	/**
	 * Column Info
	 * @param sTs1Port
	 */
	public void setSTs1Port(String sTs1Port) {
		this.sTs1Port = sTs1Port;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	
	/**
	 * Column Info
	 * @param sRoutSeq
	 */
	public void setSRoutSeq(String sRoutSeq) {
		this.sRoutSeq = sRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param sPod
	 */
	public void setSPod(String sPod) {
		this.sPod = sPod;
	}
	
	/**
	 * Column Info
	 * @param sTs1Lane
	 */
	public void setSTs1Lane(String sTs1Lane) {
		this.sTs1Lane = sTs1Lane;
	}
	
	/**
	 * Column Info
	 * @param sPol
	 */
	public void setSPol(String sPol) {
		this.sPol = sPol;
	}
	
	/**
	 * Column Info
	 * @param sTs1StayTm
	 */
	public void setSTs1StayTm(String sTs1StayTm) {
		this.sTs1StayTm = sTs1StayTm;
	}
	
	/**
	 * Column Info
	 * @param sN1stStayTmHrs
	 */
	public void setSN1stStayTmHrs(String sN1stStayTmHrs) {
		this.sN1stStayTmHrs = sN1stStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @param sLane
	 */
	public void setSLane(String sLane) {
		this.sLane = sLane;
	}
	
	/**
	 * Column Info
	 * @param sSTime
	 */
	public void setSSTime(String sSTime) {
		this.sSTime = sSTime;
	}
	
	/**
	 * Column Info
	 * @param sPod1
	 */
	public void setSPod1(String sPod1) {
		this.sPod1 = sPod1;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param sTTime
	 */
	public void setSTTime(String sTTime) {
		this.sTTime = sTTime;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sN2ndStayTmHrs
	 */
	public void setSN2ndStayTmHrs(String sN2ndStayTmHrs) {
		this.sN2ndStayTmHrs = sN2ndStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @param sTs2Lane
	 */
	public void setSTs2Lane(String sTs2Lane) {
		this.sTs2Lane = sTs2Lane;
	}
	
	/**
	 * Column Info
	 * @param sN3rdStayTmHrs
	 */
	public void setSN3rdStayTmHrs(String sN3rdStayTmHrs) {
		this.sN3rdStayTmHrs = sN3rdStayTmHrs;
	}
	
	/**
	 * Column Info
	 * @param sDupAllow
	 */
	public void setSDupAllow(String sDupAllow) {
		this.sDupAllow = sDupAllow;
	}
	
	/**
	 * Column Info
	 * @param sTsInd
	 */
	public void setSTsInd(String sTsInd) {
		this.sTsInd = sTsInd;
	}
	
	/**
	 * Column Info
	 * @param sFU
	 */
	public void setSFU(String sFU) {
		this.sFU = sFU;
	}
	
	/**
	 * Column Info
	 * @param sRouteRmk
	 */
	public void setSRouteRmk(String sRouteRmk) {
		this.sRouteRmk = sRouteRmk;
	}
	
	/**
	 * Column Info
	 * @param sRouteNote
	 */
	public void setSRouteNote(String sRouteNote) {
		this.sRouteNote = sRouteNote;
	}
	
	
	/**
	 * Column Info
	 * @param sRmk
	 */
	public void setSRmk(String sRmk) {
		this.sRmk = sRmk;
	}
	
	/**
	 * Column Info
	 * @param sTs3Port
	 */
	public void setSTs3Port(String sTs3Port) {
		this.sTs3Port = sTs3Port;
	}
	
	/**
	 * Column Info
	 * @param sN4thTztmHrs
	 */
	public void setSN4thTztmHrs(String sN4thTztmHrs) {
		this.sN4thTztmHrs = sN4thTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param sTs3Type
	 */
	public void setSTs3Type(String sTs3Type) {
		this.sTs3Type = sTs3Type;
	}
	
	/**
	 * Column Info
	 * @param sFdrFlg4
	 */
	public void setSFdrFlg4(String sFdrFlg4) {
		this.sFdrFlg4 = sFdrFlg4;
	}
	
	/**
	 * Column Info
	 * @param sN3rdTztmHrs
	 */
	public void setSN3rdTztmHrs(String sN3rdTztmHrs) {
		this.sN3rdTztmHrs = sN3rdTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param pfIndCd
	 */
	public void setPfIndCd(String pfIndCd) {
		this.pfIndCd = pfIndCd;
	}
	
	/**
	 * Column Info
	 * @param sFdrFlg1
	 */
	public void setSFdrFlg1(String sFdrFlg1) {
		this.sFdrFlg1 = sFdrFlg1;
	}
	
	/**
	 * Column Info
	 * @param sPod2
	 */
	public void setSPod2(String sPod2) {
		this.sPod2 = sPod2;
	}
	
	/**
	 * Column Info
	 * @param sDir4
	 */
	public void setSDir4(String sDir4) {
		this.sDir4 = sDir4;
	}
	
	/**
	 * Column Info
	 * @param sPod3
	 */
	public void setSPod3(String sPod3) {
		this.sPod3 = sPod3;
	}
	
	/**
	 * Column Info
	 * @param sPol1
	 */
	public void setSPol1(String sPol1) {
		this.sPol1 = sPol1;
	}
	
	/**
	 * Column Info
	 * @param sDir2
	 */
	public void setSDir2(String sDir2) {
		this.sDir2 = sDir2;
	}
	
	/**
	 * Column Info
	 * @param sFdrFlg3
	 */
	public void setSFdrFlg3(String sFdrFlg3) {
		this.sFdrFlg3 = sFdrFlg3;
	}
	
	/**
	 * Column Info
	 * @param sPod4
	 */
	public void setSPod4(String sPod4) {
		this.sPod4 = sPod4;
	}
	
	/**
	 * Column Info
	 * @param sFdrFlg2
	 */
	public void setSFdrFlg2(String sFdrFlg2) {
		this.sFdrFlg2 = sFdrFlg2;
	}
	
	/**
	 * Column Info
	 * @param sDir3
	 */
	public void setSDir3(String sDir3) {
		this.sDir3 = sDir3;
	}
	
	/**
	 * Column Info
	 * @param sPol3
	 */
	public void setSPol3(String sPol3) {
		this.sPol3 = sPol3;
	}
	
	/**
	 * Column Info
	 * @param sDir1
	 */
	public void setSDir1(String sDir1) {
		this.sDir1 = sDir1;
	}
	
	/**
	 * Column Info
	 * @param sPol2
	 */
	public void setSPol2(String sPol2) {
		this.sPol2 = sPol2;
	}
	
	/**
	 * Column Info
	 * @param sTs2StayTm
	 */
	public void setSTs2StayTm(String sTs2StayTm) {
		this.sTs2StayTm = sTs2StayTm;
	}
	
	/**
	 * Column Info
	 * @param sPol4
	 */
	public void setSPol4(String sPol4) {
		this.sPol4 = sPol4;
	}
	
	/**
	 * Column Info
	 * @param sTs1Type
	 */
	public void setSTs1Type(String sTs1Type) {
		this.sTs1Type = sTs1Type;
	}
	
	/**
	 * Column Info
	 * @param sErrTp
	 */
	public void setSErrTp(String sErrTp) {
		this.sErrTp = sErrTp;
	}
	
	/**
	 * Column Info
	 * @param sErrDesc
	 */
	public void setSErrDesc(String sErrDesc) {
		this.sErrDesc = sErrDesc;
	}
	
	/**
	 * Column Info
	 * @param sChk
	 */
	public void setSChk(String sChk) {
		this.sChk = sChk;
	}
	
	/**
	 * Column Info
	 * @param fmtTotTt
	 */
	public void setFmtTotTt(String fmtTotTt) {
		this.fmtTotTt = fmtTotTt;
	}
	
	/**
	 * Column Info
	 * @param fmtTotSt
	 */
	public void setFmtTotSt(String fmtTotSt) {
		this.fmtTotSt = fmtTotSt;
	}
	
	/**
	 * Column Info
	 * @param sSeq
	 */
	public void setSSeq(String sSeq) {
		this.sSeq = sSeq;
	}
	
	/**
	 * Column Info
	 * @param fullRout
	 */
	public void setFullRout(String fullRout) {
		this.fullRout = fullRout;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSTs3Lane(JSPUtil.getParameter(request, "s_ts3_lane", ""));
		setSLnkCnt(JSPUtil.getParameter(request, "s_lnk_cnt", ""));
		setSTs3Tztm(JSPUtil.getParameter(request, "s_ts3_tztm", ""));
		setSSvcType(JSPUtil.getParameter(request, "s_svc_type", ""));
		setTsIndCd(JSPUtil.getParameter(request, "ts_ind_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSTs2Tztm(JSPUtil.getParameter(request, "s_ts2_tztm", ""));
		setSTs2Type(JSPUtil.getParameter(request, "s_ts2_type", ""));
		setSPfInd(JSPUtil.getParameter(request, "s_pf_ind", ""));
		setSRouteFlg(JSPUtil.getParameter(request, "s_route_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSN1stTztmHrs(JSPUtil.getParameter(request, "s_n1st_tztm_hrs", ""));
		setSN2ndTztmHrs(JSPUtil.getParameter(request, "s_n2nd_tztm_hrs", ""));
		setMenu(JSPUtil.getParameter(request, "menu", ""));
		setSTs2Port(JSPUtil.getParameter(request, "s_ts2_port", ""));
		setSPrior(JSPUtil.getParameter(request, "s_prior", ""));
		setSTs1Tztm(JSPUtil.getParameter(request, "s_ts1_tztm", ""));
		setSTs1Port(JSPUtil.getParameter(request, "s_ts1_port", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMaxSeq(JSPUtil.getParameter(request, "max_seq", ""));
		setSRoutSeq(JSPUtil.getParameter(request, "s_rout_seq", ""));
		setSPod(JSPUtil.getParameter(request, "s_pod", ""));
		setSTs1Lane(JSPUtil.getParameter(request, "s_ts1_lane", ""));
		setSPol(JSPUtil.getParameter(request, "s_pol", ""));
		setSTs1StayTm(JSPUtil.getParameter(request, "s_ts1_stay_tm", ""));
		setSN1stStayTmHrs(JSPUtil.getParameter(request, "s_n1st_stay_tm_hrs", ""));
		setSLane(JSPUtil.getParameter(request, "s_lane", ""));
		setSSTime(JSPUtil.getParameter(request, "s_s_time", ""));
		setSPod1(JSPUtil.getParameter(request, "s_pod1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSTTime(JSPUtil.getParameter(request, "s_t_time", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setSN2ndStayTmHrs(JSPUtil.getParameter(request, "s_n2nd_stay_tm_hrs", ""));
		setSTs2Lane(JSPUtil.getParameter(request, "s_ts2_lane", ""));
		setSN3rdStayTmHrs(JSPUtil.getParameter(request, "s_n3rd_stay_tm_hrs", ""));
		setSDupAllow(JSPUtil.getParameter(request, "s_dup_allow", ""));
		setSTsInd(JSPUtil.getParameter(request, "s_ts_ind", ""));
		setSFU(JSPUtil.getParameter(request, "s_f_u", ""));
		setSRouteRmk(JSPUtil.getParameter(request, "s_route_rmk", ""));
		
		setSRouteNote(JSPUtil.getParameter(request, "s_route_note", ""));
		
		setSRmk(JSPUtil.getParameter(request, "s_rmk", ""));
		setSTs3Port(JSPUtil.getParameter(request, "s_ts3_port", ""));
		setSN4thTztmHrs(JSPUtil.getParameter(request, "s_n4th_tztm_hrs", ""));
		setSTs3Type(JSPUtil.getParameter(request, "s_ts3_type", ""));
		setSFdrFlg4(JSPUtil.getParameter(request, "s_fdr_flg4", ""));
		setSN3rdTztmHrs(JSPUtil.getParameter(request, "s_n3rd_tztm_hrs", ""));
		setPfIndCd(JSPUtil.getParameter(request, "pf_ind_cd", ""));
		setSFdrFlg1(JSPUtil.getParameter(request, "s_fdr_flg1", ""));
		setSPod2(JSPUtil.getParameter(request, "s_pod2", ""));
		setSDir4(JSPUtil.getParameter(request, "s_dir4", ""));
		setSPod3(JSPUtil.getParameter(request, "s_pod3", ""));
		setSPol1(JSPUtil.getParameter(request, "s_pol1", ""));
		setSDir2(JSPUtil.getParameter(request, "s_dir2", ""));
		setSFdrFlg3(JSPUtil.getParameter(request, "s_fdr_flg3", ""));
		setSPod4(JSPUtil.getParameter(request, "s_pod4", ""));
		setSFdrFlg2(JSPUtil.getParameter(request, "s_fdr_flg2", ""));
		setSDir3(JSPUtil.getParameter(request, "s_dir3", ""));
		setSPol3(JSPUtil.getParameter(request, "s_pol3", ""));
		setSDir1(JSPUtil.getParameter(request, "s_dir1", ""));
		setSPol2(JSPUtil.getParameter(request, "s_pol2", ""));
		setSTs2StayTm(JSPUtil.getParameter(request, "s_ts2_stay_tm", ""));
		setSPol4(JSPUtil.getParameter(request, "s_pol4", ""));
		setSTs1Type(JSPUtil.getParameter(request, "s_ts1_type", ""));
	
		setSTs4Lane(JSPUtil.getParameter(request, "s_ts4_lane", ""));
		setSTs4Type(JSPUtil.getParameter(request, "s_ts4_type", ""));
		setSErrTp(JSPUtil.getParameter(request, "s_err_tp", ""));
		setSErrDesc(JSPUtil.getParameter(request, "s_err_desc", ""));
		setSChk(JSPUtil.getParameter(request, "s_chk", ""));
		setFmtTotTt(JSPUtil.getParameter(request, "fmt_tot_tt", ""));
		setFmtTotSt(JSPUtil.getParameter(request, "fmt_tot_st", ""));
		setSSeq(JSPUtil.getParameter(request, "s_seq", ""));
		setFullRout(JSPUtil.getParameter(request, "full_rout", ""));
		setSOcnRoutTmpExpDt(JSPUtil.getParameter(request, "s_ocn_rout_tmp_exp_dt", ""));
		setSOcnRoutTmpFlg(JSPUtil.getParameter(request, "s_ocn_rout_tmp_flg", ""));
		setSUpdIndCd(JSPUtil.getParameter(request, "s_upd_ind_cd", ""));
		
	}
	
	

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaveOceanRouteVO[]
	 */
	public SaveOceanRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaveOceanRouteVO[]
	 */
	public SaveOceanRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaveOceanRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sTs3Lane = (JSPUtil.getParameter(request, prefix	+ "s_ts3_lane", length));
			String[] sLnkCnt = (JSPUtil.getParameter(request, prefix	+ "s_lnk_cnt", length));
			String[] sTs3Tztm = (JSPUtil.getParameter(request, prefix	+ "s_ts3_tztm", length));
			String[] sSvcType = (JSPUtil.getParameter(request, prefix	+ "s_svc_type", length));
			String[] tsIndCd = (JSPUtil.getParameter(request, prefix	+ "ts_ind_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sTs2Tztm = (JSPUtil.getParameter(request, prefix	+ "s_ts2_tztm", length));
			String[] sTs2Type = (JSPUtil.getParameter(request, prefix	+ "s_ts2_type", length));
			String[] sPfInd = (JSPUtil.getParameter(request, prefix	+ "s_pf_ind", length));
			String[] sRouteFlg = (JSPUtil.getParameter(request, prefix	+ "s_route_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sN1stTztmHrs = (JSPUtil.getParameter(request, prefix	+ "s_n1st_tztm_hrs", length));
			String[] sN2ndTztmHrs = (JSPUtil.getParameter(request, prefix	+ "s_n2nd_tztm_hrs", length));
			String[] menu = (JSPUtil.getParameter(request, prefix	+ "menu", length));
			String[] sTs2Port = (JSPUtil.getParameter(request, prefix	+ "s_ts2_port", length));
			String[] sPrior = (JSPUtil.getParameter(request, prefix	+ "s_prior", length));
			String[] sTs1Tztm = (JSPUtil.getParameter(request, prefix	+ "s_ts1_tztm", length));
			String[] sTs1Port = (JSPUtil.getParameter(request, prefix	+ "s_ts1_port", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] sRoutSeq = (JSPUtil.getParameter(request, prefix	+ "s_rout_seq", length));
			String[] sPod = (JSPUtil.getParameter(request, prefix	+ "s_pod", length));
			String[] sTs1Lane = (JSPUtil.getParameter(request, prefix	+ "s_ts1_lane", length));
			String[] sPol = (JSPUtil.getParameter(request, prefix	+ "s_pol", length));
			String[] sTs1StayTm = (JSPUtil.getParameter(request, prefix	+ "s_ts1_stay_tm", length));
			String[] sN1stStayTmHrs = (JSPUtil.getParameter(request, prefix	+ "s_n1st_stay_tm_hrs", length));
			String[] sLane = (JSPUtil.getParameter(request, prefix	+ "s_lane", length));
			String[] sSTime = (JSPUtil.getParameter(request, prefix	+ "s_s_time", length));
			String[] sPod1 = (JSPUtil.getParameter(request, prefix	+ "s_pod1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sTTime = (JSPUtil.getParameter(request, prefix	+ "s_t_time", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] sN2ndStayTmHrs = (JSPUtil.getParameter(request, prefix	+ "s_n2nd_stay_tm_hrs", length));
			String[] sTs2Lane = (JSPUtil.getParameter(request, prefix	+ "s_ts2_lane", length));
			String[] sN3rdStayTmHrs = (JSPUtil.getParameter(request, prefix	+ "s_n3rd_stay_tm_hrs", length));
			String[] sDupAllow = (JSPUtil.getParameter(request, prefix	+ "s_dup_allow", length));
			String[] sTsInd = (JSPUtil.getParameter(request, prefix	+ "s_ts_ind", length));
			String[] sFU = (JSPUtil.getParameter(request, prefix	+ "s_f_u", length));
			String[] sRouteRmk = (JSPUtil.getParameter(request, prefix	+ "s_route_rmk", length));
			
			String[] sRouteNote = (JSPUtil.getParameter(request, prefix	+ "s_route_note", length));
			
			String[] sRmk = (JSPUtil.getParameter(request, prefix	+ "s_rmk", length));
			String[] sTs3Port = (JSPUtil.getParameter(request, prefix	+ "s_ts3_port", length));
			String[] sN4thTztmHrs = (JSPUtil.getParameter(request, prefix	+ "s_n4th_tztm_hrs", length));
			String[] sTs3Type = (JSPUtil.getParameter(request, prefix	+ "s_ts3_type", length));
			String[] sFdrFlg4 = (JSPUtil.getParameter(request, prefix	+ "s_fdr_flg4", length));
			String[] sN3rdTztmHrs = (JSPUtil.getParameter(request, prefix	+ "s_n3rd_tztm_hrs", length));
			String[] pfIndCd = (JSPUtil.getParameter(request, prefix	+ "pf_ind_cd", length));
			String[] sFdrFlg1 = (JSPUtil.getParameter(request, prefix	+ "s_fdr_flg1", length));
			String[] sPod2 = (JSPUtil.getParameter(request, prefix	+ "s_pod2", length));
			String[] sDir4 = (JSPUtil.getParameter(request, prefix	+ "s_dir4", length));
			String[] sPod3 = (JSPUtil.getParameter(request, prefix	+ "s_pod3", length));
			String[] sPol1 = (JSPUtil.getParameter(request, prefix	+ "s_pol1", length));
			String[] sDir2 = (JSPUtil.getParameter(request, prefix	+ "s_dir2", length));
			String[] sFdrFlg3 = (JSPUtil.getParameter(request, prefix	+ "s_fdr_flg3", length));
			String[] sPod4 = (JSPUtil.getParameter(request, prefix	+ "s_pod4", length));
			String[] sFdrFlg2 = (JSPUtil.getParameter(request, prefix	+ "s_fdr_flg2", length));
			String[] sDir3 = (JSPUtil.getParameter(request, prefix	+ "s_dir3", length));
			String[] sPol3 = (JSPUtil.getParameter(request, prefix	+ "s_pol3", length));
			String[] sDir1 = (JSPUtil.getParameter(request, prefix	+ "s_dir1", length));
			String[] sPol2 = (JSPUtil.getParameter(request, prefix	+ "s_pol2", length));
			String[] sTs2StayTm = (JSPUtil.getParameter(request, prefix	+ "s_ts2_stay_tm", length));
			String[] sPol4 = (JSPUtil.getParameter(request, prefix	+ "s_pol4", length));
			String[] sTs1Type = (JSPUtil.getParameter(request, prefix	+ "s_ts1_type", length));
			
			String[] sTs4Lane = (JSPUtil.getParameter(request, prefix	+ "s_ts4_lane", length));
			String[] sTs4Type = (JSPUtil.getParameter(request, prefix	+ "s_ts4_type", length));
			String[] sErrTp = (JSPUtil.getParameter(request, prefix	+ "s_err_tp", length));
			String[] sErrDesc = (JSPUtil.getParameter(request, prefix	+ "s_err_desc", length));
			String[] sChk = (JSPUtil.getParameter(request, prefix	+ "s_chk", length));
			String[] fmtTotTt = (JSPUtil.getParameter(request, prefix	+ "fmt_tot_tt", length));
			String[] fmtTotSt = (JSPUtil.getParameter(request, prefix	+ "fmt_tot_st", length));
			String[] sSeq = (JSPUtil.getParameter(request, prefix	+ "s_seq", length));
			String[] fullRout = (JSPUtil.getParameter(request, prefix	+ "full_rout", length));
			String[] sOcnRoutTmpExpDt = (JSPUtil.getParameter(request, prefix	+ "s_ocn_rout_tmp_exp_dt", length));
			String[] sOcnRoutTmpFlg = (JSPUtil.getParameter(request, prefix	+ "s_ocn_rout_tmp_flg", length));
			String[] sUpdIndCd = (JSPUtil.getParameter(request, prefix	+ "s_upd_ind_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaveOceanRouteVO();
				if (sTs3Lane[i] != null)
					model.setSTs3Lane(sTs3Lane[i]);
				if (sLnkCnt[i] != null)
					model.setSLnkCnt(sLnkCnt[i]);
				if (sTs3Tztm[i] != null)
					model.setSTs3Tztm(sTs3Tztm[i]);
				if (sSvcType[i] != null)
					model.setSSvcType(sSvcType[i]);
				if (tsIndCd[i] != null)
					model.setTsIndCd(tsIndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sTs2Tztm[i] != null)
					model.setSTs2Tztm(sTs2Tztm[i]);
				if (sTs2Type[i] != null)
					model.setSTs2Type(sTs2Type[i]);
				if (sPfInd[i] != null)
					model.setSPfInd(sPfInd[i]);
				if (sRouteFlg[i] != null)
					model.setSRouteFlg(sRouteFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sN1stTztmHrs[i] != null)
					model.setSN1stTztmHrs(sN1stTztmHrs[i]);
				if (sN2ndTztmHrs[i] != null)
					model.setSN2ndTztmHrs(sN2ndTztmHrs[i]);
				if (menu[i] != null)
					model.setMenu(menu[i]);
				if (sTs2Port[i] != null)
					model.setSTs2Port(sTs2Port[i]);
				if (sPrior[i] != null)
					model.setSPrior(sPrior[i]);
				if (sTs1Tztm[i] != null)
					model.setSTs1Tztm(sTs1Tztm[i]);
				if (sTs1Port[i] != null)
					model.setSTs1Port(sTs1Port[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (sRoutSeq[i] != null)
					model.setSRoutSeq(sRoutSeq[i]);
				if (sPod[i] != null)
					model.setSPod(sPod[i]);
				if (sTs1Lane[i] != null)
					model.setSTs1Lane(sTs1Lane[i]);
				if (sPol[i] != null)
					model.setSPol(sPol[i]);
				if (sTs1StayTm[i] != null)
					model.setSTs1StayTm(sTs1StayTm[i]);
				if (sN1stStayTmHrs[i] != null)
					model.setSN1stStayTmHrs(sN1stStayTmHrs[i]);
				if (sLane[i] != null)
					model.setSLane(sLane[i]);
				if (sSTime[i] != null)
					model.setSSTime(sSTime[i]);
				if (sPod1[i] != null)
					model.setSPod1(sPod1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sTTime[i] != null)
					model.setSTTime(sTTime[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (sN2ndStayTmHrs[i] != null)
					model.setSN2ndStayTmHrs(sN2ndStayTmHrs[i]);
				if (sTs2Lane[i] != null)
					model.setSTs2Lane(sTs2Lane[i]);
				if (sN3rdStayTmHrs[i] != null)
					model.setSN3rdStayTmHrs(sN3rdStayTmHrs[i]);
				if (sDupAllow[i] != null)
					model.setSDupAllow(sDupAllow[i]);
				if (sTsInd[i] != null)
					model.setSTsInd(sTsInd[i]);
				if (sFU[i] != null)
					model.setSFU(sFU[i]);
				if (sRouteRmk[i] != null)
					model.setSRouteRmk(sRouteRmk[i]);
				
				if (sRouteNote[i] != null)
					model.setSRouteNote(sRouteNote[i]);				
				
				if (sRmk[i] != null)
					model.setSRmk(sRmk[i]);
				if (sTs3Port[i] != null)
					model.setSTs3Port(sTs3Port[i]);
				if (sN4thTztmHrs[i] != null)
					model.setSN4thTztmHrs(sN4thTztmHrs[i]);
				if (sTs3Type[i] != null)
					model.setSTs3Type(sTs3Type[i]);
				if (sFdrFlg4[i] != null)
					model.setSFdrFlg4(sFdrFlg4[i]);
				if (sN3rdTztmHrs[i] != null)
					model.setSN3rdTztmHrs(sN3rdTztmHrs[i]);
				if (pfIndCd[i] != null)
					model.setPfIndCd(pfIndCd[i]);
				if (sFdrFlg1[i] != null)
					model.setSFdrFlg1(sFdrFlg1[i]);
				if (sPod2[i] != null)
					model.setSPod2(sPod2[i]);
				if (sDir4[i] != null)
					model.setSDir4(sDir4[i]);
				if (sPod3[i] != null)
					model.setSPod3(sPod3[i]);
				if (sPol1[i] != null)
					model.setSPol1(sPol1[i]);
				if (sDir2[i] != null)
					model.setSDir2(sDir2[i]);
				if (sFdrFlg3[i] != null)
					model.setSFdrFlg3(sFdrFlg3[i]);
				if (sPod4[i] != null)
					model.setSPod4(sPod4[i]);
				if (sFdrFlg2[i] != null)
					model.setSFdrFlg2(sFdrFlg2[i]);
				if (sDir3[i] != null)
					model.setSDir3(sDir3[i]);
				if (sPol3[i] != null)
					model.setSPol3(sPol3[i]);
				if (sDir1[i] != null)
					model.setSDir1(sDir1[i]);
				if (sPol2[i] != null)
					model.setSPol2(sPol2[i]);
				if (sTs2StayTm[i] != null)
					model.setSTs2StayTm(sTs2StayTm[i]);
				if (sPol4[i] != null)
					model.setSPol4(sPol4[i]);
				if (sTs1Type[i] != null)
					model.setSTs1Type(sTs1Type[i]);
				
				if (sTs4Lane[i] != null)
					model.setSTs4Lane(sTs4Lane[i]);
				
				if (sTs4Type[i] != null)
					model.setSTs4Type(sTs4Type[i]);
				if (sErrTp[i] != null)
					model.setSErrTp(sErrTp[i]);
				if (sErrDesc[i] != null)
					model.setSErrDesc(sErrDesc[i]);
				if (sChk[i] != null)
					model.setSChk(sChk[i]);
				if (fmtTotTt[i] != null)
					model.setFmtTotTt(fmtTotTt[i]);
				if (fmtTotSt[i] != null)
					model.setFmtTotSt(fmtTotSt[i]);
				if (sSeq[i] != null)
					model.setSSeq(sSeq[i]);
				if (fullRout[i] != null)
					model.setFullRout(fullRout[i]);
				if (sOcnRoutTmpExpDt[i] != null)
					model.setSOcnRoutTmpExpDt(sOcnRoutTmpExpDt[i]);
				if (sOcnRoutTmpFlg[i] != null)
					model.setSOcnRoutTmpFlg(sOcnRoutTmpFlg[i]);
				if (sUpdIndCd[i] != null)
					model.setSUpdIndCd(sUpdIndCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaveOceanRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaveOceanRouteVO[]
	 */
	public SaveOceanRouteVO[] getSaveOceanRouteVOs(){
		SaveOceanRouteVO[] vos = (SaveOceanRouteVO[])models.toArray(new SaveOceanRouteVO[models.size()]);
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
		this.sTs3Lane = this.sTs3Lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLnkCnt = this.sLnkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs3Tztm = this.sTs3Tztm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSvcType = this.sSvcType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsIndCd = this.tsIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2Tztm = this.sTs2Tztm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2Type = this.sTs2Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPfInd = this.sPfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRouteFlg = this.sRouteFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN1stTztmHrs = this.sN1stTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN2ndTztmHrs = this.sN2ndTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.menu = this.menu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2Port = this.sTs2Port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPrior = this.sPrior .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1Tztm = this.sTs1Tztm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1Port = this.sTs1Port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq = this.maxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRoutSeq = this.sRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPod = this.sPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1Lane = this.sTs1Lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPol = this.sPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1StayTm = this.sTs1StayTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN1stStayTmHrs = this.sN1stStayTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLane = this.sLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSTime = this.sSTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPod1 = this.sPod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTTime = this.sTTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN2ndStayTmHrs = this.sN2ndStayTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2Lane = this.sTs2Lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3rdStayTmHrs = this.sN3rdStayTmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDupAllow = this.sDupAllow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTsInd = this.sTsInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFU = this.sFU .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRouteRmk = this.sRouteRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.sRouteNote = this.sRouteNote .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.sRmk = this.sRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs3Port = this.sTs3Port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN4thTztmHrs = this.sN4thTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs3Type = this.sTs3Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFdrFlg4 = this.sFdrFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3rdTztmHrs = this.sN3rdTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfIndCd = this.pfIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFdrFlg1 = this.sFdrFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPod2 = this.sPod2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDir4 = this.sDir4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPod3 = this.sPod3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPol1 = this.sPol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDir2 = this.sDir2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFdrFlg3 = this.sFdrFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPod4 = this.sPod4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFdrFlg2 = this.sFdrFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDir3 = this.sDir3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPol3 = this.sPol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDir1 = this.sDir1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPol2 = this.sPol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs2StayTm = this.sTs2StayTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPol4 = this.sPol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs1Type = this.sTs1Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.sTs4Lane = this.sTs4Lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTs4Type = this.sTs4Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sErrTp = this.sErrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sErrDesc = this.sErrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChk = this.sChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTotTt = this.fmtTotTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtTotSt = this.fmtTotSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSeq = this.sSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRout = this.fullRout .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOcnRoutTmpExpDt = this.sOcnRoutTmpExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOcnRoutTmpFlg = this.sOcnRoutTmpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUpdIndCd = this.sUpdIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
