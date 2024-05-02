/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AverageCostVO.java
*@FileTitle : AverageCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.common.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AverageCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AverageCostVO> models = new ArrayList<AverageCostVO>();
	
	/* Column Info */
	private String fRpbYrmon = null;
	/* Column Info */
	private String fBkgPorSccCd = null;
	/* Column Info */
	private String bkgDelSccCd = null;
	/* Column Info */
	private String rpbCustNo = null;
	/* Column Info */
	private String scrChgAvgRpbRev = null;
	/* Column Info */
	private String fProcNm = null;
	/* Column Info */
	private String net40ftAvgRev = null;
	/* Column Info */
	private String fDirCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bkgMiscAvgRpbRev = null;
	/* Column Info */
	private String fCntrTpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fBkgDelCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String oft40ftAvgRev = null;
	/* Column Info */
	private String misc40ftAvgRev = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rpbYrmon = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String scr40ftAvgRev = null;
	/* Column Info */
	private String fFmYrmm = null;
	/* Column Info */
	private String net20ftAvgRev = null;
	/* Column Info */
	private String scr20ftAvgRev = null;
	/* Column Info */
	private String fBkgDelSccCd = null;
	/* Column Info */
	private String fToYrwk = null;
	/* Column Info */
	private String bkgOftAvgRpbRev = null;
	/* Column Info */
	private String bkgAvgRpbRev = null;
	/* Column Info */
	private String fFmYrwk = null;
	/* Column Info */
	private String fTrdCd = null;
	/* Column Info */
	private String oft20ftAvgRev = null;
	/* Column Info */
	private String fDuration = null;
	/* Column Info */
	private String misc20ftAvgRev = null;
	/* Column Info */
	private String bkgPorSccCd = null;
	/* Column Info */
	private String fRlaneCd = null;
	/* Column Info */
	private String fBkgPorCd = null;
	/* Column Info */
	private String fIocCd = null;
	/* Column Info */
	private String fToYrmm = null;
	/* Column Info */
	private String fCostType = null;
	/* Column Info */
	private String fTargetYrmon = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AverageCostVO() {}

	public AverageCostVO(String ibflag, String pagerows, String fBkgPorSccCd, String fRpbYrmon, String bkgDelSccCd, String scrChgAvgRpbRev, String rpbCustNo, String fDirCd, String net40ftAvgRev, String trdCd, String rlaneCd, String fCntrTpszCd, String bkgMiscAvgRpbRev, String fBkgDelCd, String usrId, String bkgDelCd, String cntrTpszCd, String oft40ftAvgRev, String misc40ftAvgRev, String dirCd, String rpbYrmon, String iocCd, String bkgPorCd, String scr40ftAvgRev, String net20ftAvgRev, String scr20ftAvgRev, String fToYrwk, String fToYrmm, String fFmYrmm, String fCostType, String fProcNm, String fBkgDelSccCd, String bkgOftAvgRpbRev, String fFmYrwk, String bkgAvgRpbRev, String fTrdCd, String fDuration, String oft20ftAvgRev, String bkgPorSccCd, String misc20ftAvgRev, String fRlaneCd, String fBkgPorCd, String fIocCd, String fTargetYrmon) {
		this.fRpbYrmon = fRpbYrmon;
		this.fBkgPorSccCd = fBkgPorSccCd;
		this.bkgDelSccCd = bkgDelSccCd;
		this.rpbCustNo = rpbCustNo;
		this.scrChgAvgRpbRev = scrChgAvgRpbRev;
		this.fProcNm = fProcNm;
		this.net40ftAvgRev = net40ftAvgRev;
		this.fDirCd = fDirCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.bkgMiscAvgRpbRev = bkgMiscAvgRpbRev;
		this.fCntrTpszCd = fCntrTpszCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.fBkgDelCd = fBkgDelCd;
		this.usrId = usrId;
		this.bkgDelCd = bkgDelCd;
		this.cntrTpszCd = cntrTpszCd;
		this.oft40ftAvgRev = oft40ftAvgRev;
		this.misc40ftAvgRev = misc40ftAvgRev;
		this.dirCd = dirCd;
		this.rpbYrmon = rpbYrmon;
		this.iocCd = iocCd;
		this.bkgPorCd = bkgPorCd;
		this.scr40ftAvgRev = scr40ftAvgRev;
		this.fFmYrmm = fFmYrmm;
		this.net20ftAvgRev = net20ftAvgRev;
		this.scr20ftAvgRev = scr20ftAvgRev;
		this.fBkgDelSccCd = fBkgDelSccCd;
		this.fToYrwk = fToYrwk;
		this.bkgOftAvgRpbRev = bkgOftAvgRpbRev;
		this.bkgAvgRpbRev = bkgAvgRpbRev;
		this.fFmYrwk = fFmYrwk;
		this.fTrdCd = fTrdCd;
		this.oft20ftAvgRev = oft20ftAvgRev;
		this.fDuration = fDuration;
		this.misc20ftAvgRev = misc20ftAvgRev;
		this.bkgPorSccCd = bkgPorSccCd;
		this.fRlaneCd = fRlaneCd;
		this.fBkgPorCd = fBkgPorCd;
		this.fIocCd = fIocCd;
		this.fToYrmm = fToYrmm;
		this.fCostType = fCostType;
		this.fTargetYrmon = fTargetYrmon;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_rpb_yrmon", getFRpbYrmon());
		this.hashColumns.put("f_bkg_por_scc_cd", getFBkgPorSccCd());
		this.hashColumns.put("bkg_del_scc_cd", getBkgDelSccCd());
		this.hashColumns.put("rpb_cust_no", getRpbCustNo());
		this.hashColumns.put("scr_chg_avg_rpb_rev", getScrChgAvgRpbRev());
		this.hashColumns.put("f_proc_nm", getFProcNm());
		this.hashColumns.put("net_40ft_avg_rev", getNet40ftAvgRev());
		this.hashColumns.put("f_dir_cd", getFDirCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bkg_misc_avg_rpb_rev", getBkgMiscAvgRpbRev());
		this.hashColumns.put("f_cntr_tpsz_cd", getFCntrTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_bkg_del_cd", getFBkgDelCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("oft_40ft_avg_rev", getOft40ftAvgRev());
		this.hashColumns.put("misc_40ft_avg_rev", getMisc40ftAvgRev());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rpb_yrmon", getRpbYrmon());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("scr_40ft_avg_rev", getScr40ftAvgRev());
		this.hashColumns.put("f_fm_yrmm", getFFmYrmm());
		this.hashColumns.put("net_20ft_avg_rev", getNet20ftAvgRev());
		this.hashColumns.put("scr_20ft_avg_rev", getScr20ftAvgRev());
		this.hashColumns.put("f_bkg_del_scc_cd", getFBkgDelSccCd());
		this.hashColumns.put("f_to_yrwk", getFToYrwk());
		this.hashColumns.put("bkg_oft_avg_rpb_rev", getBkgOftAvgRpbRev());
		this.hashColumns.put("bkg_avg_rpb_rev", getBkgAvgRpbRev());
		this.hashColumns.put("f_fm_yrwk", getFFmYrwk());
		this.hashColumns.put("f_trd_cd", getFTrdCd());
		this.hashColumns.put("oft_20ft_avg_rev", getOft20ftAvgRev());
		this.hashColumns.put("f_duration", getFDuration());
		this.hashColumns.put("misc_20ft_avg_rev", getMisc20ftAvgRev());
		this.hashColumns.put("bkg_por_scc_cd", getBkgPorSccCd());
		this.hashColumns.put("f_rlane_cd", getFRlaneCd());
		this.hashColumns.put("f_bkg_por_cd", getFBkgPorCd());
		this.hashColumns.put("f_ioc_cd", getFIocCd());
		this.hashColumns.put("f_to_yrmm", getFToYrmm());
		this.hashColumns.put("f_cost_type", getFCostType());
		this.hashColumns.put("f_target_yrmon", getFTargetYrmon());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_rpb_yrmon", "fRpbYrmon");
		this.hashFields.put("f_bkg_por_scc_cd", "fBkgPorSccCd");
		this.hashFields.put("bkg_del_scc_cd", "bkgDelSccCd");
		this.hashFields.put("rpb_cust_no", "rpbCustNo");
		this.hashFields.put("scr_chg_avg_rpb_rev", "scrChgAvgRpbRev");
		this.hashFields.put("f_proc_nm", "fProcNm");
		this.hashFields.put("net_40ft_avg_rev", "net40ftAvgRev");
		this.hashFields.put("f_dir_cd", "fDirCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bkg_misc_avg_rpb_rev", "bkgMiscAvgRpbRev");
		this.hashFields.put("f_cntr_tpsz_cd", "fCntrTpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_bkg_del_cd", "fBkgDelCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("oft_40ft_avg_rev", "oft40ftAvgRev");
		this.hashFields.put("misc_40ft_avg_rev", "misc40ftAvgRev");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rpb_yrmon", "rpbYrmon");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("scr_40ft_avg_rev", "scr40ftAvgRev");
		this.hashFields.put("f_fm_yrmm", "fFmYrmm");
		this.hashFields.put("net_20ft_avg_rev", "net20ftAvgRev");
		this.hashFields.put("scr_20ft_avg_rev", "scr20ftAvgRev");
		this.hashFields.put("f_bkg_del_scc_cd", "fBkgDelSccCd");
		this.hashFields.put("f_to_yrwk", "fToYrwk");
		this.hashFields.put("bkg_oft_avg_rpb_rev", "bkgOftAvgRpbRev");
		this.hashFields.put("bkg_avg_rpb_rev", "bkgAvgRpbRev");
		this.hashFields.put("f_fm_yrwk", "fFmYrwk");
		this.hashFields.put("f_trd_cd", "fTrdCd");
		this.hashFields.put("oft_20ft_avg_rev", "oft20ftAvgRev");
		this.hashFields.put("f_duration", "fDuration");
		this.hashFields.put("misc_20ft_avg_rev", "misc20ftAvgRev");
		this.hashFields.put("bkg_por_scc_cd", "bkgPorSccCd");
		this.hashFields.put("f_rlane_cd", "fRlaneCd");
		this.hashFields.put("f_bkg_por_cd", "fBkgPorCd");
		this.hashFields.put("f_ioc_cd", "fIocCd");
		this.hashFields.put("f_to_yrmm", "fToYrmm");
		this.hashFields.put("f_cost_type", "fCostType");
		this.hashFields.put("f_target_yrmon", "fTargetYrmon");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fRpbYrmon
	 */
	public String getFRpbYrmon() {
		return this.fRpbYrmon;
	}
	
	/**
	 * Column Info
	 * @return fBkgPorSccCd
	 */
	public String getFBkgPorSccCd() {
		return this.fBkgPorSccCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDelSccCd
	 */
	public String getBkgDelSccCd() {
		return this.bkgDelSccCd;
	}
	
	/**
	 * Column Info
	 * @return rpbCustNo
	 */
	public String getRpbCustNo() {
		return this.rpbCustNo;
	}
	
	/**
	 * Column Info
	 * @return scrChgAvgRpbRev
	 */
	public String getScrChgAvgRpbRev() {
		return this.scrChgAvgRpbRev;
	}
	
	/**
	 * Column Info
	 * @return fProcNm
	 */
	public String getFProcNm() {
		return this.fProcNm;
	}
	
	/**
	 * Column Info
	 * @return net40ftAvgRev
	 */
	public String getNet40ftAvgRev() {
		return this.net40ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @return fDirCd
	 */
	public String getFDirCd() {
		return this.fDirCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bkgMiscAvgRpbRev
	 */
	public String getBkgMiscAvgRpbRev() {
		return this.bkgMiscAvgRpbRev;
	}
	
	/**
	 * Column Info
	 * @return fCntrTpszCd
	 */
	public String getFCntrTpszCd() {
		return this.fCntrTpszCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return fBkgDelCd
	 */
	public String getFBkgDelCd() {
		return this.fBkgDelCd;
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
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
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
	 * @return oft40ftAvgRev
	 */
	public String getOft40ftAvgRev() {
		return this.oft40ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @return misc40ftAvgRev
	 */
	public String getMisc40ftAvgRev() {
		return this.misc40ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return rpbYrmon
	 */
	public String getRpbYrmon() {
		return this.rpbYrmon;
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
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return scr40ftAvgRev
	 */
	public String getScr40ftAvgRev() {
		return this.scr40ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @return fFmYrmm
	 */
	public String getFFmYrmm() {
		return this.fFmYrmm;
	}
	
	/**
	 * Column Info
	 * @return net20ftAvgRev
	 */
	public String getNet20ftAvgRev() {
		return this.net20ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @return scr20ftAvgRev
	 */
	public String getScr20ftAvgRev() {
		return this.scr20ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @return fBkgDelSccCd
	 */
	public String getFBkgDelSccCd() {
		return this.fBkgDelSccCd;
	}
	
	/**
	 * Column Info
	 * @return fToYrwk
	 */
	public String getFToYrwk() {
		return this.fToYrwk;
	}
	
	/**
	 * Column Info
	 * @return bkgOftAvgRpbRev
	 */
	public String getBkgOftAvgRpbRev() {
		return this.bkgOftAvgRpbRev;
	}
	
	/**
	 * Column Info
	 * @return bkgAvgRpbRev
	 */
	public String getBkgAvgRpbRev() {
		return this.bkgAvgRpbRev;
	}
	
	/**
	 * Column Info
	 * @return fFmYrwk
	 */
	public String getFFmYrwk() {
		return this.fFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return fTrdCd
	 */
	public String getFTrdCd() {
		return this.fTrdCd;
	}
	
	/**
	 * Column Info
	 * @return oft20ftAvgRev
	 */
	public String getOft20ftAvgRev() {
		return this.oft20ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @return fDuration
	 */
	public String getFDuration() {
		return this.fDuration;
	}
	
	/**
	 * Column Info
	 * @return misc20ftAvgRev
	 */
	public String getMisc20ftAvgRev() {
		return this.misc20ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @return bkgPorSccCd
	 */
	public String getBkgPorSccCd() {
		return this.bkgPorSccCd;
	}
	
	/**
	 * Column Info
	 * @return fRlaneCd
	 */
	public String getFRlaneCd() {
		return this.fRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fBkgPorCd
	 */
	public String getFBkgPorCd() {
		return this.fBkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return fIocCd
	 */
	public String getFIocCd() {
		return this.fIocCd;
	}
	
	/**
	 * Column Info
	 * @return fToYrmm
	 */
	public String getFToYrmm() {
		return this.fToYrmm;
	}
	
	/**
	 * Column Info
	 * @return fCostType
	 */
	public String getFCostType() {
		return this.fCostType;
	}
	
	/**
	 * Column Info
	 * @return fTargetYrmon
	 */
	public String getFTargetYrmon() {
		return this.fTargetYrmon;
	}
	

	/**
	 * Column Info
	 * @param fRpbYrmon
	 */
	public void setFRpbYrmon(String fRpbYrmon) {
		this.fRpbYrmon = fRpbYrmon;
	}
	
	/**
	 * Column Info
	 * @param fBkgPorSccCd
	 */
	public void setFBkgPorSccCd(String fBkgPorSccCd) {
		this.fBkgPorSccCd = fBkgPorSccCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDelSccCd
	 */
	public void setBkgDelSccCd(String bkgDelSccCd) {
		this.bkgDelSccCd = bkgDelSccCd;
	}
	
	/**
	 * Column Info
	 * @param rpbCustNo
	 */
	public void setRpbCustNo(String rpbCustNo) {
		this.rpbCustNo = rpbCustNo;
	}
	
	/**
	 * Column Info
	 * @param scrChgAvgRpbRev
	 */
	public void setScrChgAvgRpbRev(String scrChgAvgRpbRev) {
		this.scrChgAvgRpbRev = scrChgAvgRpbRev;
	}
	
	/**
	 * Column Info
	 * @param fProcNm
	 */
	public void setFProcNm(String fProcNm) {
		this.fProcNm = fProcNm;
	}
	
	/**
	 * Column Info
	 * @param net40ftAvgRev
	 */
	public void setNet40ftAvgRev(String net40ftAvgRev) {
		this.net40ftAvgRev = net40ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @param fDirCd
	 */
	public void setFDirCd(String fDirCd) {
		this.fDirCd = fDirCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bkgMiscAvgRpbRev
	 */
	public void setBkgMiscAvgRpbRev(String bkgMiscAvgRpbRev) {
		this.bkgMiscAvgRpbRev = bkgMiscAvgRpbRev;
	}
	
	/**
	 * Column Info
	 * @param fCntrTpszCd
	 */
	public void setFCntrTpszCd(String fCntrTpszCd) {
		this.fCntrTpszCd = fCntrTpszCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param fBkgDelCd
	 */
	public void setFBkgDelCd(String fBkgDelCd) {
		this.fBkgDelCd = fBkgDelCd;
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
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
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
	 * @param oft40ftAvgRev
	 */
	public void setOft40ftAvgRev(String oft40ftAvgRev) {
		this.oft40ftAvgRev = oft40ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @param misc40ftAvgRev
	 */
	public void setMisc40ftAvgRev(String misc40ftAvgRev) {
		this.misc40ftAvgRev = misc40ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param rpbYrmon
	 */
	public void setRpbYrmon(String rpbYrmon) {
		this.rpbYrmon = rpbYrmon;
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
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param scr40ftAvgRev
	 */
	public void setScr40ftAvgRev(String scr40ftAvgRev) {
		this.scr40ftAvgRev = scr40ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @param fFmYrmm
	 */
	public void setFFmYrmm(String fFmYrmm) {
		this.fFmYrmm = fFmYrmm;
	}
	
	/**
	 * Column Info
	 * @param net20ftAvgRev
	 */
	public void setNet20ftAvgRev(String net20ftAvgRev) {
		this.net20ftAvgRev = net20ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @param scr20ftAvgRev
	 */
	public void setScr20ftAvgRev(String scr20ftAvgRev) {
		this.scr20ftAvgRev = scr20ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @param fBkgDelSccCd
	 */
	public void setFBkgDelSccCd(String fBkgDelSccCd) {
		this.fBkgDelSccCd = fBkgDelSccCd;
	}
	
	/**
	 * Column Info
	 * @param fToYrwk
	 */
	public void setFToYrwk(String fToYrwk) {
		this.fToYrwk = fToYrwk;
	}
	
	/**
	 * Column Info
	 * @param bkgOftAvgRpbRev
	 */
	public void setBkgOftAvgRpbRev(String bkgOftAvgRpbRev) {
		this.bkgOftAvgRpbRev = bkgOftAvgRpbRev;
	}
	
	/**
	 * Column Info
	 * @param bkgAvgRpbRev
	 */
	public void setBkgAvgRpbRev(String bkgAvgRpbRev) {
		this.bkgAvgRpbRev = bkgAvgRpbRev;
	}
	
	/**
	 * Column Info
	 * @param fFmYrwk
	 */
	public void setFFmYrwk(String fFmYrwk) {
		this.fFmYrwk = fFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param fTrdCd
	 */
	public void setFTrdCd(String fTrdCd) {
		this.fTrdCd = fTrdCd;
	}
	
	/**
	 * Column Info
	 * @param oft20ftAvgRev
	 */
	public void setOft20ftAvgRev(String oft20ftAvgRev) {
		this.oft20ftAvgRev = oft20ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @param fDuration
	 */
	public void setFDuration(String fDuration) {
		this.fDuration = fDuration;
	}
	
	/**
	 * Column Info
	 * @param misc20ftAvgRev
	 */
	public void setMisc20ftAvgRev(String misc20ftAvgRev) {
		this.misc20ftAvgRev = misc20ftAvgRev;
	}
	
	/**
	 * Column Info
	 * @param bkgPorSccCd
	 */
	public void setBkgPorSccCd(String bkgPorSccCd) {
		this.bkgPorSccCd = bkgPorSccCd;
	}
	
	/**
	 * Column Info
	 * @param fRlaneCd
	 */
	public void setFRlaneCd(String fRlaneCd) {
		this.fRlaneCd = fRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fBkgPorCd
	 */
	public void setFBkgPorCd(String fBkgPorCd) {
		this.fBkgPorCd = fBkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param fIocCd
	 */
	public void setFIocCd(String fIocCd) {
		this.fIocCd = fIocCd;
	}
	
	/**
	 * Column Info
	 * @param fToYrmm
	 */
	public void setFToYrmm(String fToYrmm) {
		this.fToYrmm = fToYrmm;
	}
	
	/**
	 * Column Info
	 * @param fCostType
	 */
	public void setFCostType(String fCostType) {
		this.fCostType = fCostType;
	}
	
	/**
	 * Column Info
	 * @param fTargetYrmon
	 */
	public void setFTargetYrmon(String fTargetYrmon) {
		this.fTargetYrmon = fTargetYrmon;
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
		setFRpbYrmon(JSPUtil.getParameter(request, prefix + "f_rpb_yrmon", ""));
		setFBkgPorSccCd(JSPUtil.getParameter(request, prefix + "f_bkg_por_scc_cd", ""));
		setBkgDelSccCd(JSPUtil.getParameter(request, prefix + "bkg_del_scc_cd", ""));
		setRpbCustNo(JSPUtil.getParameter(request, prefix + "rpb_cust_no", ""));
		setScrChgAvgRpbRev(JSPUtil.getParameter(request, prefix + "scr_chg_avg_rpb_rev", ""));
		setFProcNm(JSPUtil.getParameter(request, prefix + "f_proc_nm", ""));
		setNet40ftAvgRev(JSPUtil.getParameter(request, prefix + "net_40ft_avg_rev", ""));
		setFDirCd(JSPUtil.getParameter(request, prefix + "f_dir_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setBkgMiscAvgRpbRev(JSPUtil.getParameter(request, prefix + "bkg_misc_avg_rpb_rev", ""));
		setFCntrTpszCd(JSPUtil.getParameter(request, prefix + "f_cntr_tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFBkgDelCd(JSPUtil.getParameter(request, prefix + "f_bkg_del_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setOft40ftAvgRev(JSPUtil.getParameter(request, prefix + "oft_40ft_avg_rev", ""));
		setMisc40ftAvgRev(JSPUtil.getParameter(request, prefix + "misc_40ft_avg_rev", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRpbYrmon(JSPUtil.getParameter(request, prefix + "rpb_yrmon", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setBkgPorCd(JSPUtil.getParameter(request, prefix + "bkg_por_cd", ""));
		setScr40ftAvgRev(JSPUtil.getParameter(request, prefix + "scr_40ft_avg_rev", ""));
		setFFmYrmm(JSPUtil.getParameter(request, prefix + "f_fm_yrmm", ""));
		setNet20ftAvgRev(JSPUtil.getParameter(request, prefix + "net_20ft_avg_rev", ""));
		setScr20ftAvgRev(JSPUtil.getParameter(request, prefix + "scr_20ft_avg_rev", ""));
		setFBkgDelSccCd(JSPUtil.getParameter(request, prefix + "f_bkg_del_scc_cd", ""));
		setFToYrwk(JSPUtil.getParameter(request, prefix + "f_to_yrwk", ""));
		setBkgOftAvgRpbRev(JSPUtil.getParameter(request, prefix + "bkg_oft_avg_rpb_rev", ""));
		setBkgAvgRpbRev(JSPUtil.getParameter(request, prefix + "bkg_avg_rpb_rev", ""));
		setFFmYrwk(JSPUtil.getParameter(request, prefix + "f_fm_yrwk", ""));
		setFTrdCd(JSPUtil.getParameter(request, prefix + "f_trd_cd", ""));
		setOft20ftAvgRev(JSPUtil.getParameter(request, prefix + "oft_20ft_avg_rev", ""));
		setFDuration(JSPUtil.getParameter(request, prefix + "f_duration", ""));
		setMisc20ftAvgRev(JSPUtil.getParameter(request, prefix + "misc_20ft_avg_rev", ""));
		setBkgPorSccCd(JSPUtil.getParameter(request, prefix + "bkg_por_scc_cd", ""));
		setFRlaneCd(JSPUtil.getParameter(request, prefix + "f_rlane_cd", ""));
		setFBkgPorCd(JSPUtil.getParameter(request, prefix + "f_bkg_por_cd", ""));
		setFIocCd(JSPUtil.getParameter(request, prefix + "f_ioc_cd", ""));
		setFToYrmm(JSPUtil.getParameter(request, prefix + "f_to_yrmm", ""));
		setFCostType(JSPUtil.getParameter(request, prefix + "f_cost_type", ""));
		setFTargetYrmon(JSPUtil.getParameter(request, prefix + "f_target_yrmon", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AverageCostVO[]
	 */
	public AverageCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AverageCostVO[]
	 */
	public AverageCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AverageCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fRpbYrmon = (JSPUtil.getParameter(request, prefix	+ "f_rpb_yrmon", length));
			String[] fBkgPorSccCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_por_scc_cd", length));
			String[] bkgDelSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_scc_cd", length));
			String[] rpbCustNo = (JSPUtil.getParameter(request, prefix	+ "rpb_cust_no", length));
			String[] scrChgAvgRpbRev = (JSPUtil.getParameter(request, prefix	+ "scr_chg_avg_rpb_rev", length));
			String[] fProcNm = (JSPUtil.getParameter(request, prefix	+ "f_proc_nm", length));
			String[] net40ftAvgRev = (JSPUtil.getParameter(request, prefix	+ "net_40ft_avg_rev", length));
			String[] fDirCd = (JSPUtil.getParameter(request, prefix	+ "f_dir_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bkgMiscAvgRpbRev = (JSPUtil.getParameter(request, prefix	+ "bkg_misc_avg_rpb_rev", length));
			String[] fCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "f_cntr_tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fBkgDelCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_del_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] oft40ftAvgRev = (JSPUtil.getParameter(request, prefix	+ "oft_40ft_avg_rev", length));
			String[] misc40ftAvgRev = (JSPUtil.getParameter(request, prefix	+ "misc_40ft_avg_rev", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rpbYrmon = (JSPUtil.getParameter(request, prefix	+ "rpb_yrmon", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] scr40ftAvgRev = (JSPUtil.getParameter(request, prefix	+ "scr_40ft_avg_rev", length));
			String[] fFmYrmm = (JSPUtil.getParameter(request, prefix	+ "f_fm_yrmm", length));
			String[] net20ftAvgRev = (JSPUtil.getParameter(request, prefix	+ "net_20ft_avg_rev", length));
			String[] scr20ftAvgRev = (JSPUtil.getParameter(request, prefix	+ "scr_20ft_avg_rev", length));
			String[] fBkgDelSccCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_del_scc_cd", length));
			String[] fToYrwk = (JSPUtil.getParameter(request, prefix	+ "f_to_yrwk", length));
			String[] bkgOftAvgRpbRev = (JSPUtil.getParameter(request, prefix	+ "bkg_oft_avg_rpb_rev", length));
			String[] bkgAvgRpbRev = (JSPUtil.getParameter(request, prefix	+ "bkg_avg_rpb_rev", length));
			String[] fFmYrwk = (JSPUtil.getParameter(request, prefix	+ "f_fm_yrwk", length));
			String[] fTrdCd = (JSPUtil.getParameter(request, prefix	+ "f_trd_cd", length));
			String[] oft20ftAvgRev = (JSPUtil.getParameter(request, prefix	+ "oft_20ft_avg_rev", length));
			String[] fDuration = (JSPUtil.getParameter(request, prefix	+ "f_duration", length));
			String[] misc20ftAvgRev = (JSPUtil.getParameter(request, prefix	+ "misc_20ft_avg_rev", length));
			String[] bkgPorSccCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_scc_cd", length));
			String[] fRlaneCd = (JSPUtil.getParameter(request, prefix	+ "f_rlane_cd", length));
			String[] fBkgPorCd = (JSPUtil.getParameter(request, prefix	+ "f_bkg_por_cd", length));
			String[] fIocCd = (JSPUtil.getParameter(request, prefix	+ "f_ioc_cd", length));
			String[] fToYrmm = (JSPUtil.getParameter(request, prefix	+ "f_to_yrmm", length));
			String[] fCostType = (JSPUtil.getParameter(request, prefix	+ "f_cost_type", length));
			String[] fTargetYrmon = (JSPUtil.getParameter(request, prefix	+ "f_target_yrmon", length));
			
			for (int i = 0; i < length; i++) {
				model = new AverageCostVO();
				if (fRpbYrmon[i] != null)
					model.setFRpbYrmon(fRpbYrmon[i]);
				if (fBkgPorSccCd[i] != null)
					model.setFBkgPorSccCd(fBkgPorSccCd[i]);
				if (bkgDelSccCd[i] != null)
					model.setBkgDelSccCd(bkgDelSccCd[i]);
				if (rpbCustNo[i] != null)
					model.setRpbCustNo(rpbCustNo[i]);
				if (scrChgAvgRpbRev[i] != null)
					model.setScrChgAvgRpbRev(scrChgAvgRpbRev[i]);
				if (fProcNm[i] != null)
					model.setFProcNm(fProcNm[i]);
				if (net40ftAvgRev[i] != null)
					model.setNet40ftAvgRev(net40ftAvgRev[i]);
				if (fDirCd[i] != null)
					model.setFDirCd(fDirCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bkgMiscAvgRpbRev[i] != null)
					model.setBkgMiscAvgRpbRev(bkgMiscAvgRpbRev[i]);
				if (fCntrTpszCd[i] != null)
					model.setFCntrTpszCd(fCntrTpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fBkgDelCd[i] != null)
					model.setFBkgDelCd(fBkgDelCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (oft40ftAvgRev[i] != null)
					model.setOft40ftAvgRev(oft40ftAvgRev[i]);
				if (misc40ftAvgRev[i] != null)
					model.setMisc40ftAvgRev(misc40ftAvgRev[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rpbYrmon[i] != null)
					model.setRpbYrmon(rpbYrmon[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (scr40ftAvgRev[i] != null)
					model.setScr40ftAvgRev(scr40ftAvgRev[i]);
				if (fFmYrmm[i] != null)
					model.setFFmYrmm(fFmYrmm[i]);
				if (net20ftAvgRev[i] != null)
					model.setNet20ftAvgRev(net20ftAvgRev[i]);
				if (scr20ftAvgRev[i] != null)
					model.setScr20ftAvgRev(scr20ftAvgRev[i]);
				if (fBkgDelSccCd[i] != null)
					model.setFBkgDelSccCd(fBkgDelSccCd[i]);
				if (fToYrwk[i] != null)
					model.setFToYrwk(fToYrwk[i]);
				if (bkgOftAvgRpbRev[i] != null)
					model.setBkgOftAvgRpbRev(bkgOftAvgRpbRev[i]);
				if (bkgAvgRpbRev[i] != null)
					model.setBkgAvgRpbRev(bkgAvgRpbRev[i]);
				if (fFmYrwk[i] != null)
					model.setFFmYrwk(fFmYrwk[i]);
				if (fTrdCd[i] != null)
					model.setFTrdCd(fTrdCd[i]);
				if (oft20ftAvgRev[i] != null)
					model.setOft20ftAvgRev(oft20ftAvgRev[i]);
				if (fDuration[i] != null)
					model.setFDuration(fDuration[i]);
				if (misc20ftAvgRev[i] != null)
					model.setMisc20ftAvgRev(misc20ftAvgRev[i]);
				if (bkgPorSccCd[i] != null)
					model.setBkgPorSccCd(bkgPorSccCd[i]);
				if (fRlaneCd[i] != null)
					model.setFRlaneCd(fRlaneCd[i]);
				if (fBkgPorCd[i] != null)
					model.setFBkgPorCd(fBkgPorCd[i]);
				if (fIocCd[i] != null)
					model.setFIocCd(fIocCd[i]);
				if (fToYrmm[i] != null)
					model.setFToYrmm(fToYrmm[i]);
				if (fCostType[i] != null)
					model.setFCostType(fCostType[i]);
				if (fTargetYrmon[i] != null)
					model.setFTargetYrmon(fTargetYrmon[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAverageCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AverageCostVO[]
	 */
	public AverageCostVO[] getAverageCostVOs(){
		AverageCostVO[] vos = (AverageCostVO[])models.toArray(new AverageCostVO[models.size()]);
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
		this.fRpbYrmon = this.fRpbYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgPorSccCd = this.fBkgPorSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelSccCd = this.bkgDelSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpbCustNo = this.rpbCustNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrChgAvgRpbRev = this.scrChgAvgRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fProcNm = this.fProcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.net40ftAvgRev = this.net40ftAvgRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDirCd = this.fDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMiscAvgRpbRev = this.bkgMiscAvgRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCntrTpszCd = this.fCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgDelCd = this.fBkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oft40ftAvgRev = this.oft40ftAvgRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misc40ftAvgRev = this.misc40ftAvgRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpbYrmon = this.rpbYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scr40ftAvgRev = this.scr40ftAvgRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmYrmm = this.fFmYrmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.net20ftAvgRev = this.net20ftAvgRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scr20ftAvgRev = this.scr20ftAvgRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgDelSccCd = this.fBkgDelSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToYrwk = this.fToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOftAvgRpbRev = this.bkgOftAvgRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvgRpbRev = this.bkgAvgRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFmYrwk = this.fFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrdCd = this.fTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oft20ftAvgRev = this.oft20ftAvgRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDuration = this.fDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misc20ftAvgRev = this.misc20ftAvgRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorSccCd = this.bkgPorSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRlaneCd = this.fRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBkgPorCd = this.fBkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fIocCd = this.fIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fToYrmm = this.fToYrmm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostType = this.fCostType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTargetYrmon = this.fTargetYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
