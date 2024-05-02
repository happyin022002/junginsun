/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchDpcsPerfByVolListVO.java
*@FileTitle : SearchDpcsPerfByVolListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDpcsPerfByVolListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDpcsPerfByVolListVO> models = new ArrayList<SearchDpcsPerfByVolListVO>();
	
	/* Column Info */
	private String fFlg = null;
	/* Column Info */
	private String qFlg = null;
	/* Column Info */
	private String selfAudit = null;
	/* Column Info */
	private String stsPnt = null;
	/* Column Info */
	private String totSrVolAuditor = null;
	/* Column Info */
	private String preRate = null;
	/* Column Info */
	private String totElapsed = null;
	/* Column Info */
	private String totSrVolFofc = null;
	/* Column Info */
	private String iPnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inputElapsed = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cmPnt = null;
	/* Column Info */
	private String totBkgVol = null;
	/* Column Info */
	private String selfPnt = null;
	/* Column Info */
	private String icEnd = null;
	/* Column Info */
	private String hPnt = null;
	/* Column Info */
	private String totSrKind = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String qaElapsed = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String amendFreq = null;
	/* Column Info */
	private String totSrKindBlCnfm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String basPnt = null;
	/* Column Info */
	private String dpcsWrkGrpCd = null;
	/* Column Info */
	private String rtnFreq = null;
	/* Column Info */
	private String totSrVol = null;
	/* Column Info */
	private String totStaffsAuditor = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String totSrKindAmend = null;
	/* Column Info */
	private String totStaffsFofc = null;
	/* Column Info */
	private String totSrKindNew = null;
	/* Column Info */
	private String totStaffsRater = null;
	/* Column Info */
	private String prePnt = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String rateType = null;
	/* Column Info */
	private String siNo = null;
	/* Column Info */
	private String rateElapsed = null;
	/* Column Info */
	private String isStart = null;
	/* Column Info */
	private String qPnt = null;
	/* Column Info */
	private String riPnt = null;
	/* Column Info */
	private String totSrKindAddition = null;
	/* Column Info */
	private String blRtStDt = null;
	/* Column Info */
	private String hSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String rFlg = null;
	/* Column Info */
	private String cmCount = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String scPnt = null;
	/* Column Info */
	private String srAmdTpCd = null;
	/* Column Info */
	private String rPnt = null;
	/* Column Info */
	private String blRtDt = null;
	/* Column Info */
	private String src = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String cnPnt = null;
	/* Column Info */
	private String rfaPnt = null;
	/* Column Info */
	private String riderCount = null;
	/* Column Info */
	private String urgent = null;
	/* Column Info */
	private String totSrVolRater = null;
	/* Column Info */
	private String siKind = null;
	/* Column Info */
	private String iFlg = null;
	/* Column Info */
	private String totSrVolInputter = null;
	/* Column Info */
	private String srHisSeq = null;
	/* Column Info */
	private String fPnt = null;
	/* Column Info */
	private String totStaffsInputter = null;
	/* Column Info */
	private String userGroup = null;
	/* Column Info */
	private String bkgHrdCdgCtntJoin = null;
	/* Column Info */
	private String totPnt = null;
	/* Column Info */
	private String totStaffs = null;
	/* Column Info */
	private String taaPnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDpcsPerfByVolListVO() {}

	public SearchDpcsPerfByVolListVO(String ibflag, String pagerows, String totPnt, String totStaffs, String totSrVol, String totSrKind, String totBkgVol, String totStaffsInputter, String totStaffsRater, String totStaffsAuditor, String totStaffsFofc, String totSrVolInputter, String totSrVolRater, String totSrVolAuditor, String totSrVolFofc, String totSrKindNew, String totSrKindAmend, String totSrKindBlCnfm, String totSrKindAddition, String creUsrId, String name, String srStsCd, String userGroup, String dpcsWrkGrpCd, String siKind, String bkgOfcCd, String region, String bkgNo, String srHisSeq, String siNo, String srAmdTpCd, String urgent, String srKndCd, String src, String rtnFreq, String amendFreq, String vvd, String polCd, String delCd, String riderCount, String cmCount, String cntrCnt, String bkgCtrtTpCd, String rateType, String selfAudit, String preRate, String iFlg, String rFlg, String qFlg, String fFlg, String sts, String iPnt, String rPnt, String qPnt, String fPnt, String stsPnt, String bkgHrdCdgCtntJoin, String basPnt, String riPnt, String hSeq, String hPnt, String cmPnt, String cnPnt, String bkgCnt, String icEnd, String isStart, String inputElapsed, String blRtDt, String blRtStDt, String rateElapsed, String qaElapsed, String totElapsed, String rfaPnt, String taaPnt, String scPnt, String selfPnt, String prePnt) {
		this.fFlg = fFlg;
		this.qFlg = qFlg;
		this.selfAudit = selfAudit;
		this.stsPnt = stsPnt;
		this.totSrVolAuditor = totSrVolAuditor;
		this.preRate = preRate;
		this.totElapsed = totElapsed;
		this.totSrVolFofc = totSrVolFofc;
		this.iPnt = iPnt;
		this.pagerows = pagerows;
		this.inputElapsed = inputElapsed;
		this.polCd = polCd;
		this.cmPnt = cmPnt;
		this.totBkgVol = totBkgVol;
		this.selfPnt = selfPnt;
		this.icEnd = icEnd;
		this.hPnt = hPnt;
		this.totSrKind = totSrKind;
		this.bkgOfcCd = bkgOfcCd;
		this.qaElapsed = qaElapsed;
		this.srStsCd = srStsCd;
		this.amendFreq = amendFreq;
		this.totSrKindBlCnfm = totSrKindBlCnfm;
		this.delCd = delCd;
		this.cntrCnt = cntrCnt;
		this.bkgCnt = bkgCnt;
		this.basPnt = basPnt;
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
		this.rtnFreq = rtnFreq;
		this.totSrVol = totSrVol;
		this.totStaffsAuditor = totStaffsAuditor;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.sts = sts;
		this.totSrKindAmend = totSrKindAmend;
		this.totStaffsFofc = totStaffsFofc;
		this.totSrKindNew = totSrKindNew;
		this.totStaffsRater = totStaffsRater;
		this.prePnt = prePnt;
		this.region = region;
		this.rateType = rateType;
		this.siNo = siNo;
		this.rateElapsed = rateElapsed;
		this.isStart = isStart;
		this.qPnt = qPnt;
		this.riPnt = riPnt;
		this.totSrKindAddition = totSrKindAddition;
		this.blRtStDt = blRtStDt;
		this.hSeq = hSeq;
		this.ibflag = ibflag;
		this.srKndCd = srKndCd;
		this.rFlg = rFlg;
		this.cmCount = cmCount;
		this.name = name;
		this.scPnt = scPnt;
		this.srAmdTpCd = srAmdTpCd;
		this.rPnt = rPnt;
		this.blRtDt = blRtDt;
		this.src = src;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.cnPnt = cnPnt;
		this.rfaPnt = rfaPnt;
		this.riderCount = riderCount;
		this.urgent = urgent;
		this.totSrVolRater = totSrVolRater;
		this.siKind = siKind;
		this.iFlg = iFlg;
		this.totSrVolInputter = totSrVolInputter;
		this.srHisSeq = srHisSeq;
		this.fPnt = fPnt;
		this.totStaffsInputter = totStaffsInputter;
		this.userGroup = userGroup;
		this.bkgHrdCdgCtntJoin = bkgHrdCdgCtntJoin;
		this.totPnt = totPnt;
		this.totStaffs = totStaffs;
		this.taaPnt = taaPnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_flg", getFFlg());
		this.hashColumns.put("q_flg", getQFlg());
		this.hashColumns.put("self_audit", getSelfAudit());
		this.hashColumns.put("sts_pnt", getStsPnt());
		this.hashColumns.put("tot_sr_vol_auditor", getTotSrVolAuditor());
		this.hashColumns.put("pre_rate", getPreRate());
		this.hashColumns.put("tot_elapsed", getTotElapsed());
		this.hashColumns.put("tot_sr_vol_fofc", getTotSrVolFofc());
		this.hashColumns.put("i_pnt", getIPnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("input_elapsed", getInputElapsed());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cm_pnt", getCmPnt());
		this.hashColumns.put("tot_bkg_vol", getTotBkgVol());
		this.hashColumns.put("self_pnt", getSelfPnt());
		this.hashColumns.put("ic_end", getIcEnd());
		this.hashColumns.put("h_pnt", getHPnt());
		this.hashColumns.put("tot_sr_kind", getTotSrKind());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("qa_elapsed", getQaElapsed());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("amend_freq", getAmendFreq());
		this.hashColumns.put("tot_sr_kind_bl_cnfm", getTotSrKindBlCnfm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("bas_pnt", getBasPnt());
		this.hashColumns.put("dpcs_wrk_grp_cd", getDpcsWrkGrpCd());
		this.hashColumns.put("rtn_freq", getRtnFreq());
		this.hashColumns.put("tot_sr_vol", getTotSrVol());
		this.hashColumns.put("tot_staffs_auditor", getTotStaffsAuditor());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("tot_sr_kind_amend", getTotSrKindAmend());
		this.hashColumns.put("tot_staffs_fofc", getTotStaffsFofc());
		this.hashColumns.put("tot_sr_kind_new", getTotSrKindNew());
		this.hashColumns.put("tot_staffs_rater", getTotStaffsRater());
		this.hashColumns.put("pre_pnt", getPrePnt());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("rate_type", getRateType());
		this.hashColumns.put("si_no", getSiNo());
		this.hashColumns.put("rate_elapsed", getRateElapsed());
		this.hashColumns.put("is_start", getIsStart());
		this.hashColumns.put("q_pnt", getQPnt());
		this.hashColumns.put("ri_pnt", getRiPnt());
		this.hashColumns.put("tot_sr_kind_addition", getTotSrKindAddition());
		this.hashColumns.put("bl_rt_st_dt", getBlRtStDt());
		this.hashColumns.put("h_seq", getHSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("r_flg", getRFlg());
		this.hashColumns.put("cm_count", getCmCount());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("sc_pnt", getScPnt());
		this.hashColumns.put("sr_amd_tp_cd", getSrAmdTpCd());
		this.hashColumns.put("r_pnt", getRPnt());
		this.hashColumns.put("bl_rt_dt", getBlRtDt());
		this.hashColumns.put("src", getSrc());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("cn_pnt", getCnPnt());
		this.hashColumns.put("rfa_pnt", getRfaPnt());
		this.hashColumns.put("rider_count", getRiderCount());
		this.hashColumns.put("urgent", getUrgent());
		this.hashColumns.put("tot_sr_vol_rater", getTotSrVolRater());
		this.hashColumns.put("si_kind", getSiKind());
		this.hashColumns.put("i_flg", getIFlg());
		this.hashColumns.put("tot_sr_vol_inputter", getTotSrVolInputter());
		this.hashColumns.put("sr_his_seq", getSrHisSeq());
		this.hashColumns.put("f_pnt", getFPnt());
		this.hashColumns.put("tot_staffs_inputter", getTotStaffsInputter());
		this.hashColumns.put("user_group", getUserGroup());
		this.hashColumns.put("bkg_hrd_cdg_ctnt_join", getBkgHrdCdgCtntJoin());
		this.hashColumns.put("tot_pnt", getTotPnt());
		this.hashColumns.put("tot_staffs", getTotStaffs());
		this.hashColumns.put("taa_pnt", getTaaPnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_flg", "fFlg");
		this.hashFields.put("q_flg", "qFlg");
		this.hashFields.put("self_audit", "selfAudit");
		this.hashFields.put("sts_pnt", "stsPnt");
		this.hashFields.put("tot_sr_vol_auditor", "totSrVolAuditor");
		this.hashFields.put("pre_rate", "preRate");
		this.hashFields.put("tot_elapsed", "totElapsed");
		this.hashFields.put("tot_sr_vol_fofc", "totSrVolFofc");
		this.hashFields.put("i_pnt", "iPnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("input_elapsed", "inputElapsed");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cm_pnt", "cmPnt");
		this.hashFields.put("tot_bkg_vol", "totBkgVol");
		this.hashFields.put("self_pnt", "selfPnt");
		this.hashFields.put("ic_end", "icEnd");
		this.hashFields.put("h_pnt", "hPnt");
		this.hashFields.put("tot_sr_kind", "totSrKind");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("qa_elapsed", "qaElapsed");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("amend_freq", "amendFreq");
		this.hashFields.put("tot_sr_kind_bl_cnfm", "totSrKindBlCnfm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("bas_pnt", "basPnt");
		this.hashFields.put("dpcs_wrk_grp_cd", "dpcsWrkGrpCd");
		this.hashFields.put("rtn_freq", "rtnFreq");
		this.hashFields.put("tot_sr_vol", "totSrVol");
		this.hashFields.put("tot_staffs_auditor", "totStaffsAuditor");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("tot_sr_kind_amend", "totSrKindAmend");
		this.hashFields.put("tot_staffs_fofc", "totStaffsFofc");
		this.hashFields.put("tot_sr_kind_new", "totSrKindNew");
		this.hashFields.put("tot_staffs_rater", "totStaffsRater");
		this.hashFields.put("pre_pnt", "prePnt");
		this.hashFields.put("region", "region");
		this.hashFields.put("rate_type", "rateType");
		this.hashFields.put("si_no", "siNo");
		this.hashFields.put("rate_elapsed", "rateElapsed");
		this.hashFields.put("is_start", "isStart");
		this.hashFields.put("q_pnt", "qPnt");
		this.hashFields.put("ri_pnt", "riPnt");
		this.hashFields.put("tot_sr_kind_addition", "totSrKindAddition");
		this.hashFields.put("bl_rt_st_dt", "blRtStDt");
		this.hashFields.put("h_seq", "hSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("r_flg", "rFlg");
		this.hashFields.put("cm_count", "cmCount");
		this.hashFields.put("name", "name");
		this.hashFields.put("sc_pnt", "scPnt");
		this.hashFields.put("sr_amd_tp_cd", "srAmdTpCd");
		this.hashFields.put("r_pnt", "rPnt");
		this.hashFields.put("bl_rt_dt", "blRtDt");
		this.hashFields.put("src", "src");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("cn_pnt", "cnPnt");
		this.hashFields.put("rfa_pnt", "rfaPnt");
		this.hashFields.put("rider_count", "riderCount");
		this.hashFields.put("urgent", "urgent");
		this.hashFields.put("tot_sr_vol_rater", "totSrVolRater");
		this.hashFields.put("si_kind", "siKind");
		this.hashFields.put("i_flg", "iFlg");
		this.hashFields.put("tot_sr_vol_inputter", "totSrVolInputter");
		this.hashFields.put("sr_his_seq", "srHisSeq");
		this.hashFields.put("f_pnt", "fPnt");
		this.hashFields.put("tot_staffs_inputter", "totStaffsInputter");
		this.hashFields.put("user_group", "userGroup");
		this.hashFields.put("bkg_hrd_cdg_ctnt_join", "bkgHrdCdgCtntJoin");
		this.hashFields.put("tot_pnt", "totPnt");
		this.hashFields.put("tot_staffs", "totStaffs");
		this.hashFields.put("taa_pnt", "taaPnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fFlg
	 */
	public String getFFlg() {
		return this.fFlg;
	}
	
	/**
	 * Column Info
	 * @return qFlg
	 */
	public String getQFlg() {
		return this.qFlg;
	}
	
	/**
	 * Column Info
	 * @return selfAudit
	 */
	public String getSelfAudit() {
		return this.selfAudit;
	}
	
	/**
	 * Column Info
	 * @return stsPnt
	 */
	public String getStsPnt() {
		return this.stsPnt;
	}
	
	/**
	 * Column Info
	 * @return totSrVolAuditor
	 */
	public String getTotSrVolAuditor() {
		return this.totSrVolAuditor;
	}
	
	/**
	 * Column Info
	 * @return preRate
	 */
	public String getPreRate() {
		return this.preRate;
	}
	
	/**
	 * Column Info
	 * @return totElapsed
	 */
	public String getTotElapsed() {
		return this.totElapsed;
	}
	
	/**
	 * Column Info
	 * @return totSrVolFofc
	 */
	public String getTotSrVolFofc() {
		return this.totSrVolFofc;
	}
	
	/**
	 * Column Info
	 * @return iPnt
	 */
	public String getIPnt() {
		return this.iPnt;
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
	 * @return inputElapsed
	 */
	public String getInputElapsed() {
		return this.inputElapsed;
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
	 * @return cmPnt
	 */
	public String getCmPnt() {
		return this.cmPnt;
	}
	
	/**
	 * Column Info
	 * @return totBkgVol
	 */
	public String getTotBkgVol() {
		return this.totBkgVol;
	}
	
	/**
	 * Column Info
	 * @return selfPnt
	 */
	public String getSelfPnt() {
		return this.selfPnt;
	}
	
	/**
	 * Column Info
	 * @return icEnd
	 */
	public String getIcEnd() {
		return this.icEnd;
	}
	
	/**
	 * Column Info
	 * @return hPnt
	 */
	public String getHPnt() {
		return this.hPnt;
	}
	
	/**
	 * Column Info
	 * @return totSrKind
	 */
	public String getTotSrKind() {
		return this.totSrKind;
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
	 * @return qaElapsed
	 */
	public String getQaElapsed() {
		return this.qaElapsed;
	}
	
	/**
	 * Column Info
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return amendFreq
	 */
	public String getAmendFreq() {
		return this.amendFreq;
	}
	
	/**
	 * Column Info
	 * @return totSrKindBlCnfm
	 */
	public String getTotSrKindBlCnfm() {
		return this.totSrKindBlCnfm;
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
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
	}
	
	/**
	 * Column Info
	 * @return basPnt
	 */
	public String getBasPnt() {
		return this.basPnt;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkGrpCd
	 */
	public String getDpcsWrkGrpCd() {
		return this.dpcsWrkGrpCd;
	}
	
	/**
	 * Column Info
	 * @return rtnFreq
	 */
	public String getRtnFreq() {
		return this.rtnFreq;
	}
	
	/**
	 * Column Info
	 * @return totSrVol
	 */
	public String getTotSrVol() {
		return this.totSrVol;
	}
	
	/**
	 * Column Info
	 * @return totStaffsAuditor
	 */
	public String getTotStaffsAuditor() {
		return this.totStaffsAuditor;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return totSrKindAmend
	 */
	public String getTotSrKindAmend() {
		return this.totSrKindAmend;
	}
	
	/**
	 * Column Info
	 * @return totStaffsFofc
	 */
	public String getTotStaffsFofc() {
		return this.totStaffsFofc;
	}
	
	/**
	 * Column Info
	 * @return totSrKindNew
	 */
	public String getTotSrKindNew() {
		return this.totSrKindNew;
	}
	
	/**
	 * Column Info
	 * @return totStaffsRater
	 */
	public String getTotStaffsRater() {
		return this.totStaffsRater;
	}
	
	/**
	 * Column Info
	 * @return prePnt
	 */
	public String getPrePnt() {
		return this.prePnt;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return rateType
	 */
	public String getRateType() {
		return this.rateType;
	}
	
	/**
	 * Column Info
	 * @return siNo
	 */
	public String getSiNo() {
		return this.siNo;
	}
	
	/**
	 * Column Info
	 * @return rateElapsed
	 */
	public String getRateElapsed() {
		return this.rateElapsed;
	}
	
	/**
	 * Column Info
	 * @return isStart
	 */
	public String getIsStart() {
		return this.isStart;
	}
	
	/**
	 * Column Info
	 * @return qPnt
	 */
	public String getQPnt() {
		return this.qPnt;
	}
	
	/**
	 * Column Info
	 * @return riPnt
	 */
	public String getRiPnt() {
		return this.riPnt;
	}
	
	/**
	 * Column Info
	 * @return totSrKindAddition
	 */
	public String getTotSrKindAddition() {
		return this.totSrKindAddition;
	}
	
	/**
	 * Column Info
	 * @return blRtStDt
	 */
	public String getBlRtStDt() {
		return this.blRtStDt;
	}
	
	/**
	 * Column Info
	 * @return hSeq
	 */
	public String getHSeq() {
		return this.hSeq;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
	}
	
	/**
	 * Column Info
	 * @return rFlg
	 */
	public String getRFlg() {
		return this.rFlg;
	}
	
	/**
	 * Column Info
	 * @return cmCount
	 */
	public String getCmCount() {
		return this.cmCount;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return scPnt
	 */
	public String getScPnt() {
		return this.scPnt;
	}
	
	/**
	 * Column Info
	 * @return srAmdTpCd
	 */
	public String getSrAmdTpCd() {
		return this.srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @return rPnt
	 */
	public String getRPnt() {
		return this.rPnt;
	}
	
	/**
	 * Column Info
	 * @return blRtDt
	 */
	public String getBlRtDt() {
		return this.blRtDt;
	}
	
	/**
	 * Column Info
	 * @return src
	 */
	public String getSrc() {
		return this.src;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return cnPnt
	 */
	public String getCnPnt() {
		return this.cnPnt;
	}
	
	/**
	 * Column Info
	 * @return rfaPnt
	 */
	public String getRfaPnt() {
		return this.rfaPnt;
	}
	
	/**
	 * Column Info
	 * @return riderCount
	 */
	public String getRiderCount() {
		return this.riderCount;
	}
	
	/**
	 * Column Info
	 * @return urgent
	 */
	public String getUrgent() {
		return this.urgent;
	}
	
	/**
	 * Column Info
	 * @return totSrVolRater
	 */
	public String getTotSrVolRater() {
		return this.totSrVolRater;
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
	 * @return iFlg
	 */
	public String getIFlg() {
		return this.iFlg;
	}
	
	/**
	 * Column Info
	 * @return totSrVolInputter
	 */
	public String getTotSrVolInputter() {
		return this.totSrVolInputter;
	}
	
	/**
	 * Column Info
	 * @return srHisSeq
	 */
	public String getSrHisSeq() {
		return this.srHisSeq;
	}
	
	/**
	 * Column Info
	 * @return fPnt
	 */
	public String getFPnt() {
		return this.fPnt;
	}
	
	/**
	 * Column Info
	 * @return totStaffsInputter
	 */
	public String getTotStaffsInputter() {
		return this.totStaffsInputter;
	}
	
	/**
	 * Column Info
	 * @return userGroup
	 */
	public String getUserGroup() {
		return this.userGroup;
	}
	
	/**
	 * Column Info
	 * @return bkgHrdCdgCtntJoin
	 */
	public String getBkgHrdCdgCtntJoin() {
		return this.bkgHrdCdgCtntJoin;
	}
	
	/**
	 * Column Info
	 * @return totPnt
	 */
	public String getTotPnt() {
		return this.totPnt;
	}
	
	/**
	 * Column Info
	 * @return totStaffs
	 */
	public String getTotStaffs() {
		return this.totStaffs;
	}
	
	/**
	 * Column Info
	 * @return taaPnt
	 */
	public String getTaaPnt() {
		return this.taaPnt;
	}
	

	/**
	 * Column Info
	 * @param fFlg
	 */
	public void setFFlg(String fFlg) {
		this.fFlg = fFlg;
	}
	
	/**
	 * Column Info
	 * @param qFlg
	 */
	public void setQFlg(String qFlg) {
		this.qFlg = qFlg;
	}
	
	/**
	 * Column Info
	 * @param selfAudit
	 */
	public void setSelfAudit(String selfAudit) {
		this.selfAudit = selfAudit;
	}
	
	/**
	 * Column Info
	 * @param stsPnt
	 */
	public void setStsPnt(String stsPnt) {
		this.stsPnt = stsPnt;
	}
	
	/**
	 * Column Info
	 * @param totSrVolAuditor
	 */
	public void setTotSrVolAuditor(String totSrVolAuditor) {
		this.totSrVolAuditor = totSrVolAuditor;
	}
	
	/**
	 * Column Info
	 * @param preRate
	 */
	public void setPreRate(String preRate) {
		this.preRate = preRate;
	}
	
	/**
	 * Column Info
	 * @param totElapsed
	 */
	public void setTotElapsed(String totElapsed) {
		this.totElapsed = totElapsed;
	}
	
	/**
	 * Column Info
	 * @param totSrVolFofc
	 */
	public void setTotSrVolFofc(String totSrVolFofc) {
		this.totSrVolFofc = totSrVolFofc;
	}
	
	/**
	 * Column Info
	 * @param iPnt
	 */
	public void setIPnt(String iPnt) {
		this.iPnt = iPnt;
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
	 * @param inputElapsed
	 */
	public void setInputElapsed(String inputElapsed) {
		this.inputElapsed = inputElapsed;
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
	 * @param cmPnt
	 */
	public void setCmPnt(String cmPnt) {
		this.cmPnt = cmPnt;
	}
	
	/**
	 * Column Info
	 * @param totBkgVol
	 */
	public void setTotBkgVol(String totBkgVol) {
		this.totBkgVol = totBkgVol;
	}
	
	/**
	 * Column Info
	 * @param selfPnt
	 */
	public void setSelfPnt(String selfPnt) {
		this.selfPnt = selfPnt;
	}
	
	/**
	 * Column Info
	 * @param icEnd
	 */
	public void setIcEnd(String icEnd) {
		this.icEnd = icEnd;
	}
	
	/**
	 * Column Info
	 * @param hPnt
	 */
	public void setHPnt(String hPnt) {
		this.hPnt = hPnt;
	}
	
	/**
	 * Column Info
	 * @param totSrKind
	 */
	public void setTotSrKind(String totSrKind) {
		this.totSrKind = totSrKind;
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
	 * @param qaElapsed
	 */
	public void setQaElapsed(String qaElapsed) {
		this.qaElapsed = qaElapsed;
	}
	
	/**
	 * Column Info
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param amendFreq
	 */
	public void setAmendFreq(String amendFreq) {
		this.amendFreq = amendFreq;
	}
	
	/**
	 * Column Info
	 * @param totSrKindBlCnfm
	 */
	public void setTotSrKindBlCnfm(String totSrKindBlCnfm) {
		this.totSrKindBlCnfm = totSrKindBlCnfm;
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
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	
	/**
	 * Column Info
	 * @param basPnt
	 */
	public void setBasPnt(String basPnt) {
		this.basPnt = basPnt;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkGrpCd
	 */
	public void setDpcsWrkGrpCd(String dpcsWrkGrpCd) {
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
	}
	
	/**
	 * Column Info
	 * @param rtnFreq
	 */
	public void setRtnFreq(String rtnFreq) {
		this.rtnFreq = rtnFreq;
	}
	
	/**
	 * Column Info
	 * @param totSrVol
	 */
	public void setTotSrVol(String totSrVol) {
		this.totSrVol = totSrVol;
	}
	
	/**
	 * Column Info
	 * @param totStaffsAuditor
	 */
	public void setTotStaffsAuditor(String totStaffsAuditor) {
		this.totStaffsAuditor = totStaffsAuditor;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param totSrKindAmend
	 */
	public void setTotSrKindAmend(String totSrKindAmend) {
		this.totSrKindAmend = totSrKindAmend;
	}
	
	/**
	 * Column Info
	 * @param totStaffsFofc
	 */
	public void setTotStaffsFofc(String totStaffsFofc) {
		this.totStaffsFofc = totStaffsFofc;
	}
	
	/**
	 * Column Info
	 * @param totSrKindNew
	 */
	public void setTotSrKindNew(String totSrKindNew) {
		this.totSrKindNew = totSrKindNew;
	}
	
	/**
	 * Column Info
	 * @param totStaffsRater
	 */
	public void setTotStaffsRater(String totStaffsRater) {
		this.totStaffsRater = totStaffsRater;
	}
	
	/**
	 * Column Info
	 * @param prePnt
	 */
	public void setPrePnt(String prePnt) {
		this.prePnt = prePnt;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param rateType
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	
	/**
	 * Column Info
	 * @param siNo
	 */
	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}
	
	/**
	 * Column Info
	 * @param rateElapsed
	 */
	public void setRateElapsed(String rateElapsed) {
		this.rateElapsed = rateElapsed;
	}
	
	/**
	 * Column Info
	 * @param isStart
	 */
	public void setIsStart(String isStart) {
		this.isStart = isStart;
	}
	
	/**
	 * Column Info
	 * @param qPnt
	 */
	public void setQPnt(String qPnt) {
		this.qPnt = qPnt;
	}
	
	/**
	 * Column Info
	 * @param riPnt
	 */
	public void setRiPnt(String riPnt) {
		this.riPnt = riPnt;
	}
	
	/**
	 * Column Info
	 * @param totSrKindAddition
	 */
	public void setTotSrKindAddition(String totSrKindAddition) {
		this.totSrKindAddition = totSrKindAddition;
	}
	
	/**
	 * Column Info
	 * @param blRtStDt
	 */
	public void setBlRtStDt(String blRtStDt) {
		this.blRtStDt = blRtStDt;
	}
	
	/**
	 * Column Info
	 * @param hSeq
	 */
	public void setHSeq(String hSeq) {
		this.hSeq = hSeq;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}
	
	/**
	 * Column Info
	 * @param rFlg
	 */
	public void setRFlg(String rFlg) {
		this.rFlg = rFlg;
	}
	
	/**
	 * Column Info
	 * @param cmCount
	 */
	public void setCmCount(String cmCount) {
		this.cmCount = cmCount;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param scPnt
	 */
	public void setScPnt(String scPnt) {
		this.scPnt = scPnt;
	}
	
	/**
	 * Column Info
	 * @param srAmdTpCd
	 */
	public void setSrAmdTpCd(String srAmdTpCd) {
		this.srAmdTpCd = srAmdTpCd;
	}
	
	/**
	 * Column Info
	 * @param rPnt
	 */
	public void setRPnt(String rPnt) {
		this.rPnt = rPnt;
	}
	
	/**
	 * Column Info
	 * @param blRtDt
	 */
	public void setBlRtDt(String blRtDt) {
		this.blRtDt = blRtDt;
	}
	
	/**
	 * Column Info
	 * @param src
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param cnPnt
	 */
	public void setCnPnt(String cnPnt) {
		this.cnPnt = cnPnt;
	}
	
	/**
	 * Column Info
	 * @param rfaPnt
	 */
	public void setRfaPnt(String rfaPnt) {
		this.rfaPnt = rfaPnt;
	}
	
	/**
	 * Column Info
	 * @param riderCount
	 */
	public void setRiderCount(String riderCount) {
		this.riderCount = riderCount;
	}
	
	/**
	 * Column Info
	 * @param urgent
	 */
	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
	
	/**
	 * Column Info
	 * @param totSrVolRater
	 */
	public void setTotSrVolRater(String totSrVolRater) {
		this.totSrVolRater = totSrVolRater;
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
	 * @param iFlg
	 */
	public void setIFlg(String iFlg) {
		this.iFlg = iFlg;
	}
	
	/**
	 * Column Info
	 * @param totSrVolInputter
	 */
	public void setTotSrVolInputter(String totSrVolInputter) {
		this.totSrVolInputter = totSrVolInputter;
	}
	
	/**
	 * Column Info
	 * @param srHisSeq
	 */
	public void setSrHisSeq(String srHisSeq) {
		this.srHisSeq = srHisSeq;
	}
	
	/**
	 * Column Info
	 * @param fPnt
	 */
	public void setFPnt(String fPnt) {
		this.fPnt = fPnt;
	}
	
	/**
	 * Column Info
	 * @param totStaffsInputter
	 */
	public void setTotStaffsInputter(String totStaffsInputter) {
		this.totStaffsInputter = totStaffsInputter;
	}
	
	/**
	 * Column Info
	 * @param userGroup
	 */
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	
	/**
	 * Column Info
	 * @param bkgHrdCdgCtntJoin
	 */
	public void setBkgHrdCdgCtntJoin(String bkgHrdCdgCtntJoin) {
		this.bkgHrdCdgCtntJoin = bkgHrdCdgCtntJoin;
	}
	
	/**
	 * Column Info
	 * @param totPnt
	 */
	public void setTotPnt(String totPnt) {
		this.totPnt = totPnt;
	}
	
	/**
	 * Column Info
	 * @param totStaffs
	 */
	public void setTotStaffs(String totStaffs) {
		this.totStaffs = totStaffs;
	}
	
	/**
	 * Column Info
	 * @param taaPnt
	 */
	public void setTaaPnt(String taaPnt) {
		this.taaPnt = taaPnt;
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
		setFFlg(JSPUtil.getParameter(request, prefix + "f_flg", ""));
		setQFlg(JSPUtil.getParameter(request, prefix + "q_flg", ""));
		setSelfAudit(JSPUtil.getParameter(request, prefix + "self_audit", ""));
		setStsPnt(JSPUtil.getParameter(request, prefix + "sts_pnt", ""));
		setTotSrVolAuditor(JSPUtil.getParameter(request, prefix + "tot_sr_vol_auditor", ""));
		setPreRate(JSPUtil.getParameter(request, prefix + "pre_rate", ""));
		setTotElapsed(JSPUtil.getParameter(request, prefix + "tot_elapsed", ""));
		setTotSrVolFofc(JSPUtil.getParameter(request, prefix + "tot_sr_vol_fofc", ""));
		setIPnt(JSPUtil.getParameter(request, prefix + "i_pnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInputElapsed(JSPUtil.getParameter(request, prefix + "input_elapsed", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCmPnt(JSPUtil.getParameter(request, prefix + "cm_pnt", ""));
		setTotBkgVol(JSPUtil.getParameter(request, prefix + "tot_bkg_vol", ""));
		setSelfPnt(JSPUtil.getParameter(request, prefix + "self_pnt", ""));
		setIcEnd(JSPUtil.getParameter(request, prefix + "ic_end", ""));
		setHPnt(JSPUtil.getParameter(request, prefix + "h_pnt", ""));
		setTotSrKind(JSPUtil.getParameter(request, prefix + "tot_sr_kind", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setQaElapsed(JSPUtil.getParameter(request, prefix + "qa_elapsed", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setAmendFreq(JSPUtil.getParameter(request, prefix + "amend_freq", ""));
		setTotSrKindBlCnfm(JSPUtil.getParameter(request, prefix + "tot_sr_kind_bl_cnfm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setBasPnt(JSPUtil.getParameter(request, prefix + "bas_pnt", ""));
		setDpcsWrkGrpCd(JSPUtil.getParameter(request, prefix + "dpcs_wrk_grp_cd", ""));
		setRtnFreq(JSPUtil.getParameter(request, prefix + "rtn_freq", ""));
		setTotSrVol(JSPUtil.getParameter(request, prefix + "tot_sr_vol", ""));
		setTotStaffsAuditor(JSPUtil.getParameter(request, prefix + "tot_staffs_auditor", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSts(JSPUtil.getParameter(request, prefix + "sts", ""));
		setTotSrKindAmend(JSPUtil.getParameter(request, prefix + "tot_sr_kind_amend", ""));
		setTotStaffsFofc(JSPUtil.getParameter(request, prefix + "tot_staffs_fofc", ""));
		setTotSrKindNew(JSPUtil.getParameter(request, prefix + "tot_sr_kind_new", ""));
		setTotStaffsRater(JSPUtil.getParameter(request, prefix + "tot_staffs_rater", ""));
		setPrePnt(JSPUtil.getParameter(request, prefix + "pre_pnt", ""));
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setRateType(JSPUtil.getParameter(request, prefix + "rate_type", ""));
		setSiNo(JSPUtil.getParameter(request, prefix + "si_no", ""));
		setRateElapsed(JSPUtil.getParameter(request, prefix + "rate_elapsed", ""));
		setIsStart(JSPUtil.getParameter(request, prefix + "is_start", ""));
		setQPnt(JSPUtil.getParameter(request, prefix + "q_pnt", ""));
		setRiPnt(JSPUtil.getParameter(request, prefix + "ri_pnt", ""));
		setTotSrKindAddition(JSPUtil.getParameter(request, prefix + "tot_sr_kind_addition", ""));
		setBlRtStDt(JSPUtil.getParameter(request, prefix + "bl_rt_st_dt", ""));
		setHSeq(JSPUtil.getParameter(request, prefix + "h_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setRFlg(JSPUtil.getParameter(request, prefix + "r_flg", ""));
		setCmCount(JSPUtil.getParameter(request, prefix + "cm_count", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setScPnt(JSPUtil.getParameter(request, prefix + "sc_pnt", ""));
		setSrAmdTpCd(JSPUtil.getParameter(request, prefix + "sr_amd_tp_cd", ""));
		setRPnt(JSPUtil.getParameter(request, prefix + "r_pnt", ""));
		setBlRtDt(JSPUtil.getParameter(request, prefix + "bl_rt_dt", ""));
		setSrc(JSPUtil.getParameter(request, prefix + "src", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setCnPnt(JSPUtil.getParameter(request, prefix + "cn_pnt", ""));
		setRfaPnt(JSPUtil.getParameter(request, prefix + "rfa_pnt", ""));
		setRiderCount(JSPUtil.getParameter(request, prefix + "rider_count", ""));
		setUrgent(JSPUtil.getParameter(request, prefix + "urgent", ""));
		setTotSrVolRater(JSPUtil.getParameter(request, prefix + "tot_sr_vol_rater", ""));
		setSiKind(JSPUtil.getParameter(request, prefix + "si_kind", ""));
		setIFlg(JSPUtil.getParameter(request, prefix + "i_flg", ""));
		setTotSrVolInputter(JSPUtil.getParameter(request, prefix + "tot_sr_vol_inputter", ""));
		setSrHisSeq(JSPUtil.getParameter(request, prefix + "sr_his_seq", ""));
		setFPnt(JSPUtil.getParameter(request, prefix + "f_pnt", ""));
		setTotStaffsInputter(JSPUtil.getParameter(request, prefix + "tot_staffs_inputter", ""));
		setUserGroup(JSPUtil.getParameter(request, prefix + "user_group", ""));
		setBkgHrdCdgCtntJoin(JSPUtil.getParameter(request, prefix + "bkg_hrd_cdg_ctnt_join", ""));
		setTotPnt(JSPUtil.getParameter(request, prefix + "tot_pnt", ""));
		setTotStaffs(JSPUtil.getParameter(request, prefix + "tot_staffs", ""));
		setTaaPnt(JSPUtil.getParameter(request, prefix + "taa_pnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDpcsPerfByVolListVO[]
	 */
	public SearchDpcsPerfByVolListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDpcsPerfByVolListVO[]
	 */
	public SearchDpcsPerfByVolListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDpcsPerfByVolListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fFlg = (JSPUtil.getParameter(request, prefix	+ "f_flg", length));
			String[] qFlg = (JSPUtil.getParameter(request, prefix	+ "q_flg", length));
			String[] selfAudit = (JSPUtil.getParameter(request, prefix	+ "self_audit", length));
			String[] stsPnt = (JSPUtil.getParameter(request, prefix	+ "sts_pnt", length));
			String[] totSrVolAuditor = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol_auditor", length));
			String[] preRate = (JSPUtil.getParameter(request, prefix	+ "pre_rate", length));
			String[] totElapsed = (JSPUtil.getParameter(request, prefix	+ "tot_elapsed", length));
			String[] totSrVolFofc = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol_fofc", length));
			String[] iPnt = (JSPUtil.getParameter(request, prefix	+ "i_pnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inputElapsed = (JSPUtil.getParameter(request, prefix	+ "input_elapsed", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cmPnt = (JSPUtil.getParameter(request, prefix	+ "cm_pnt", length));
			String[] totBkgVol = (JSPUtil.getParameter(request, prefix	+ "tot_bkg_vol", length));
			String[] selfPnt = (JSPUtil.getParameter(request, prefix	+ "self_pnt", length));
			String[] icEnd = (JSPUtil.getParameter(request, prefix	+ "ic_end", length));
			String[] hPnt = (JSPUtil.getParameter(request, prefix	+ "h_pnt", length));
			String[] totSrKind = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] qaElapsed = (JSPUtil.getParameter(request, prefix	+ "qa_elapsed", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] amendFreq = (JSPUtil.getParameter(request, prefix	+ "amend_freq", length));
			String[] totSrKindBlCnfm = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind_bl_cnfm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] basPnt = (JSPUtil.getParameter(request, prefix	+ "bas_pnt", length));
			String[] dpcsWrkGrpCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_grp_cd", length));
			String[] rtnFreq = (JSPUtil.getParameter(request, prefix	+ "rtn_freq", length));
			String[] totSrVol = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol", length));
			String[] totStaffsAuditor = (JSPUtil.getParameter(request, prefix	+ "tot_staffs_auditor", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] totSrKindAmend = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind_amend", length));
			String[] totStaffsFofc = (JSPUtil.getParameter(request, prefix	+ "tot_staffs_fofc", length));
			String[] totSrKindNew = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind_new", length));
			String[] totStaffsRater = (JSPUtil.getParameter(request, prefix	+ "tot_staffs_rater", length));
			String[] prePnt = (JSPUtil.getParameter(request, prefix	+ "pre_pnt", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] rateType = (JSPUtil.getParameter(request, prefix	+ "rate_type", length));
			String[] siNo = (JSPUtil.getParameter(request, prefix	+ "si_no", length));
			String[] rateElapsed = (JSPUtil.getParameter(request, prefix	+ "rate_elapsed", length));
			String[] isStart = (JSPUtil.getParameter(request, prefix	+ "is_start", length));
			String[] qPnt = (JSPUtil.getParameter(request, prefix	+ "q_pnt", length));
			String[] riPnt = (JSPUtil.getParameter(request, prefix	+ "ri_pnt", length));
			String[] totSrKindAddition = (JSPUtil.getParameter(request, prefix	+ "tot_sr_kind_addition", length));
			String[] blRtStDt = (JSPUtil.getParameter(request, prefix	+ "bl_rt_st_dt", length));
			String[] hSeq = (JSPUtil.getParameter(request, prefix	+ "h_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] rFlg = (JSPUtil.getParameter(request, prefix	+ "r_flg", length));
			String[] cmCount = (JSPUtil.getParameter(request, prefix	+ "cm_count", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] scPnt = (JSPUtil.getParameter(request, prefix	+ "sc_pnt", length));
			String[] srAmdTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_amd_tp_cd", length));
			String[] rPnt = (JSPUtil.getParameter(request, prefix	+ "r_pnt", length));
			String[] blRtDt = (JSPUtil.getParameter(request, prefix	+ "bl_rt_dt", length));
			String[] src = (JSPUtil.getParameter(request, prefix	+ "src", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] cnPnt = (JSPUtil.getParameter(request, prefix	+ "cn_pnt", length));
			String[] rfaPnt = (JSPUtil.getParameter(request, prefix	+ "rfa_pnt", length));
			String[] riderCount = (JSPUtil.getParameter(request, prefix	+ "rider_count", length));
			String[] urgent = (JSPUtil.getParameter(request, prefix	+ "urgent", length));
			String[] totSrVolRater = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol_rater", length));
			String[] siKind = (JSPUtil.getParameter(request, prefix	+ "si_kind", length));
			String[] iFlg = (JSPUtil.getParameter(request, prefix	+ "i_flg", length));
			String[] totSrVolInputter = (JSPUtil.getParameter(request, prefix	+ "tot_sr_vol_inputter", length));
			String[] srHisSeq = (JSPUtil.getParameter(request, prefix	+ "sr_his_seq", length));
			String[] fPnt = (JSPUtil.getParameter(request, prefix	+ "f_pnt", length));
			String[] totStaffsInputter = (JSPUtil.getParameter(request, prefix	+ "tot_staffs_inputter", length));
			String[] userGroup = (JSPUtil.getParameter(request, prefix	+ "user_group", length));
			String[] bkgHrdCdgCtntJoin = (JSPUtil.getParameter(request, prefix	+ "bkg_hrd_cdg_ctnt_join", length));
			String[] totPnt = (JSPUtil.getParameter(request, prefix	+ "tot_pnt", length));
			String[] totStaffs = (JSPUtil.getParameter(request, prefix	+ "tot_staffs", length));
			String[] taaPnt = (JSPUtil.getParameter(request, prefix	+ "taa_pnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDpcsPerfByVolListVO();
				if (fFlg[i] != null)
					model.setFFlg(fFlg[i]);
				if (qFlg[i] != null)
					model.setQFlg(qFlg[i]);
				if (selfAudit[i] != null)
					model.setSelfAudit(selfAudit[i]);
				if (stsPnt[i] != null)
					model.setStsPnt(stsPnt[i]);
				if (totSrVolAuditor[i] != null)
					model.setTotSrVolAuditor(totSrVolAuditor[i]);
				if (preRate[i] != null)
					model.setPreRate(preRate[i]);
				if (totElapsed[i] != null)
					model.setTotElapsed(totElapsed[i]);
				if (totSrVolFofc[i] != null)
					model.setTotSrVolFofc(totSrVolFofc[i]);
				if (iPnt[i] != null)
					model.setIPnt(iPnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inputElapsed[i] != null)
					model.setInputElapsed(inputElapsed[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cmPnt[i] != null)
					model.setCmPnt(cmPnt[i]);
				if (totBkgVol[i] != null)
					model.setTotBkgVol(totBkgVol[i]);
				if (selfPnt[i] != null)
					model.setSelfPnt(selfPnt[i]);
				if (icEnd[i] != null)
					model.setIcEnd(icEnd[i]);
				if (hPnt[i] != null)
					model.setHPnt(hPnt[i]);
				if (totSrKind[i] != null)
					model.setTotSrKind(totSrKind[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (qaElapsed[i] != null)
					model.setQaElapsed(qaElapsed[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (amendFreq[i] != null)
					model.setAmendFreq(amendFreq[i]);
				if (totSrKindBlCnfm[i] != null)
					model.setTotSrKindBlCnfm(totSrKindBlCnfm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (basPnt[i] != null)
					model.setBasPnt(basPnt[i]);
				if (dpcsWrkGrpCd[i] != null)
					model.setDpcsWrkGrpCd(dpcsWrkGrpCd[i]);
				if (rtnFreq[i] != null)
					model.setRtnFreq(rtnFreq[i]);
				if (totSrVol[i] != null)
					model.setTotSrVol(totSrVol[i]);
				if (totStaffsAuditor[i] != null)
					model.setTotStaffsAuditor(totStaffsAuditor[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (totSrKindAmend[i] != null)
					model.setTotSrKindAmend(totSrKindAmend[i]);
				if (totStaffsFofc[i] != null)
					model.setTotStaffsFofc(totStaffsFofc[i]);
				if (totSrKindNew[i] != null)
					model.setTotSrKindNew(totSrKindNew[i]);
				if (totStaffsRater[i] != null)
					model.setTotStaffsRater(totStaffsRater[i]);
				if (prePnt[i] != null)
					model.setPrePnt(prePnt[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (rateType[i] != null)
					model.setRateType(rateType[i]);
				if (siNo[i] != null)
					model.setSiNo(siNo[i]);
				if (rateElapsed[i] != null)
					model.setRateElapsed(rateElapsed[i]);
				if (isStart[i] != null)
					model.setIsStart(isStart[i]);
				if (qPnt[i] != null)
					model.setQPnt(qPnt[i]);
				if (riPnt[i] != null)
					model.setRiPnt(riPnt[i]);
				if (totSrKindAddition[i] != null)
					model.setTotSrKindAddition(totSrKindAddition[i]);
				if (blRtStDt[i] != null)
					model.setBlRtStDt(blRtStDt[i]);
				if (hSeq[i] != null)
					model.setHSeq(hSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (rFlg[i] != null)
					model.setRFlg(rFlg[i]);
				if (cmCount[i] != null)
					model.setCmCount(cmCount[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (scPnt[i] != null)
					model.setScPnt(scPnt[i]);
				if (srAmdTpCd[i] != null)
					model.setSrAmdTpCd(srAmdTpCd[i]);
				if (rPnt[i] != null)
					model.setRPnt(rPnt[i]);
				if (blRtDt[i] != null)
					model.setBlRtDt(blRtDt[i]);
				if (src[i] != null)
					model.setSrc(src[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (cnPnt[i] != null)
					model.setCnPnt(cnPnt[i]);
				if (rfaPnt[i] != null)
					model.setRfaPnt(rfaPnt[i]);
				if (riderCount[i] != null)
					model.setRiderCount(riderCount[i]);
				if (urgent[i] != null)
					model.setUrgent(urgent[i]);
				if (totSrVolRater[i] != null)
					model.setTotSrVolRater(totSrVolRater[i]);
				if (siKind[i] != null)
					model.setSiKind(siKind[i]);
				if (iFlg[i] != null)
					model.setIFlg(iFlg[i]);
				if (totSrVolInputter[i] != null)
					model.setTotSrVolInputter(totSrVolInputter[i]);
				if (srHisSeq[i] != null)
					model.setSrHisSeq(srHisSeq[i]);
				if (fPnt[i] != null)
					model.setFPnt(fPnt[i]);
				if (totStaffsInputter[i] != null)
					model.setTotStaffsInputter(totStaffsInputter[i]);
				if (userGroup[i] != null)
					model.setUserGroup(userGroup[i]);
				if (bkgHrdCdgCtntJoin[i] != null)
					model.setBkgHrdCdgCtntJoin(bkgHrdCdgCtntJoin[i]);
				if (totPnt[i] != null)
					model.setTotPnt(totPnt[i]);
				if (totStaffs[i] != null)
					model.setTotStaffs(totStaffs[i]);
				if (taaPnt[i] != null)
					model.setTaaPnt(taaPnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDpcsPerfByVolListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDpcsPerfByVolListVO[]
	 */
	public SearchDpcsPerfByVolListVO[] getSearchDpcsPerfByVolListVOs(){
		SearchDpcsPerfByVolListVO[] vos = (SearchDpcsPerfByVolListVO[])models.toArray(new SearchDpcsPerfByVolListVO[models.size()]);
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
		this.fFlg = this.fFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qFlg = this.qFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfAudit = this.selfAudit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsPnt = this.stsPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVolAuditor = this.totSrVolAuditor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRate = this.preRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totElapsed = this.totElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVolFofc = this.totSrVolFofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPnt = this.iPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputElapsed = this.inputElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPnt = this.cmPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totBkgVol = this.totBkgVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfPnt = this.selfPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.icEnd = this.icEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hPnt = this.hPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKind = this.totSrKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaElapsed = this.qaElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendFreq = this.amendFreq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKindBlCnfm = this.totSrKindBlCnfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basPnt = this.basPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkGrpCd = this.dpcsWrkGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFreq = this.rtnFreq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVol = this.totSrVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffsAuditor = this.totStaffsAuditor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKindAmend = this.totSrKindAmend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffsFofc = this.totStaffsFofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKindNew = this.totSrKindNew .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffsRater = this.totStaffsRater .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePnt = this.prePnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateType = this.rateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siNo = this.siNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateElapsed = this.rateElapsed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isStart = this.isStart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qPnt = this.qPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.riPnt = this.riPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrKindAddition = this.totSrKindAddition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtStDt = this.blRtStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hSeq = this.hSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rFlg = this.rFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCount = this.cmCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scPnt = this.scPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srAmdTpCd = this.srAmdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rPnt = this.rPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRtDt = this.blRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.src = this.src .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnPnt = this.cnPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaPnt = this.rfaPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.riderCount = this.riderCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urgent = this.urgent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVolRater = this.totSrVolRater .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siKind = this.siKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iFlg = this.iFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSrVolInputter = this.totSrVolInputter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srHisSeq = this.srHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPnt = this.fPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffsInputter = this.totStaffsInputter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userGroup = this.userGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHrdCdgCtntJoin = this.bkgHrdCdgCtntJoin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totPnt = this.totPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totStaffs = this.totStaffs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaPnt = this.taaPnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
