/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeDataVO.java
*@FileTitle : ChargeDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeDataVO> models = new ArrayList<ChargeDataVO>();
	
	/* Column Info */
	private String zPostRly = null;
	/* Column Info */
	private String zPolLoc = null;
	/* Column Info */
	private String zRfaApprNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String zScVerSeq = null;
	/* Column Info */
	private String zRfaDtlSeq = null;
	/* Column Info */
	private String zScCurCd = null;
	/* Column Info */
	private String zRfaCurCd = null;
	/* Column Info */
	private String zDcApplRate = null;
	/* Column Info */
	private String zRfaDarNo = null;
	/* Column Info */
	private String zDbcIoBnd = null;
	/* Column Info */
	private String zScNo = null;
	/* Column Info */
	private String bzcTrfAplyDt = null;
	/* Column Info */
	private String zRfaVerSeq = null;
	/* Column Info */
	private String zVslCd = null;
	/* Column Info */
	private String zDelLoc = null;
	/* Column Info */
	private String zDtgGrpId = null;
	/* Column Info */
	private String zDtnSeq = null;
	/* Column Info */
	private String zPreRly = null;
	/* Column Info */
	private String zCurCd = null;
	/* Column Info */
	private String zPorLoc = null;
	/* Column Info */
	private String zScRfaExptAplyDt = null;
	/* Column Info */
	private String zDccTrsInd = null;
	/* Column Info */
	private String zOfcCd = null;
	/* Column Info */
	private String zScGrpSeq = null;
	/* Column Info */
	private String zSkdDirCd = null;
	/* Column Info */
	private String zBkgNo = null;
	/* Column Info */
	private String zRfaMapgSeq = null;
	/* Column Info */
	private String zCntrtsCd = null;
	/* Column Info */
	private String zSkdVoyageNo = null;
	/* Column Info */
	private String zPodLoc = null;
	/* Column Info */
	private String zOfcRhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeDataVO() {}

	public ChargeDataVO(String ibflag, String pagerows, String zPostRly, String zPolLoc, String zRfaApprNo, String zScVerSeq, String zRfaDtlSeq, String zScCurCd, String zRfaCurCd, String zDcApplRate, String zRfaDarNo, String zDbcIoBnd, String zScNo, String bzcTrfAplyDt, String zRfaVerSeq, String zVslCd, String zDelLoc, String zDtgGrpId, String zDtnSeq, String zPreRly, String zCurCd, String zPorLoc, String zDccTrsInd, String zOfcCd, String zScGrpSeq, String zSkdDirCd, String zBkgNo, String zRfaMapgSeq, String zCntrtsCd, String zSkdVoyageNo, String zPodLoc, String zOfcRhq, String zScRfaExptAplyDt) {
		this.zPostRly = zPostRly;
		this.zPolLoc = zPolLoc;
		this.zRfaApprNo = zRfaApprNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.zScVerSeq = zScVerSeq;
		this.zRfaDtlSeq = zRfaDtlSeq;
		this.zScCurCd = zScCurCd;
		this.zRfaCurCd = zRfaCurCd;
		this.zDcApplRate = zDcApplRate;
		this.zRfaDarNo = zRfaDarNo;
		this.zDbcIoBnd = zDbcIoBnd;
		this.zScNo = zScNo;
		this.bzcTrfAplyDt = bzcTrfAplyDt;
		this.zRfaVerSeq = zRfaVerSeq;
		this.zVslCd = zVslCd;
		this.zDelLoc = zDelLoc;
		this.zDtgGrpId = zDtgGrpId;
		this.zDtnSeq = zDtnSeq;
		this.zPreRly = zPreRly;
		this.zCurCd = zCurCd;
		this.zPorLoc = zPorLoc;
		this.zScRfaExptAplyDt = zScRfaExptAplyDt;
		this.zDccTrsInd = zDccTrsInd;
		this.zOfcCd = zOfcCd;
		this.zScGrpSeq = zScGrpSeq;
		this.zSkdDirCd = zSkdDirCd;
		this.zBkgNo = zBkgNo;
		this.zRfaMapgSeq = zRfaMapgSeq;
		this.zCntrtsCd = zCntrtsCd;
		this.zSkdVoyageNo = zSkdVoyageNo;
		this.zPodLoc = zPodLoc;
		this.zOfcRhq = zOfcRhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("z_post_rly", getZPostRly());
		this.hashColumns.put("z_pol_loc", getZPolLoc());
		this.hashColumns.put("z_rfa_appr_no", getZRfaApprNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("z_sc_ver_seq", getZScVerSeq());
		this.hashColumns.put("z_rfa_dtl_seq", getZRfaDtlSeq());
		this.hashColumns.put("z_sc_cur_cd", getZScCurCd());
		this.hashColumns.put("z_rfa_cur_cd", getZRfaCurCd());
		this.hashColumns.put("z_dc_appl_rate", getZDcApplRate());
		this.hashColumns.put("z_rfa_dar_no", getZRfaDarNo());
		this.hashColumns.put("z_dbc_io_bnd", getZDbcIoBnd());
		this.hashColumns.put("z_sc_no", getZScNo());
		this.hashColumns.put("bzc_trf_aply_dt", getBzcTrfAplyDt());
		this.hashColumns.put("z_rfa_ver_seq", getZRfaVerSeq());
		this.hashColumns.put("z_vsl_cd", getZVslCd());
		this.hashColumns.put("z_del_loc", getZDelLoc());
		this.hashColumns.put("z_dtg_grp_id", getZDtgGrpId());
		this.hashColumns.put("z_dtn_seq", getZDtnSeq());
		this.hashColumns.put("z_pre_rly", getZPreRly());
		this.hashColumns.put("z_cur_cd", getZCurCd());
		this.hashColumns.put("z_por_loc", getZPorLoc());
		this.hashColumns.put("z_sc_rfa_expt_aply_dt", getZScRfaExptAplyDt());
		this.hashColumns.put("z_dcc_trs_ind", getZDccTrsInd());
		this.hashColumns.put("z_ofc_cd", getZOfcCd());
		this.hashColumns.put("z_sc_grp_seq", getZScGrpSeq());
		this.hashColumns.put("z_skd_dir_cd", getZSkdDirCd());
		this.hashColumns.put("z_bkg_no", getZBkgNo());
		this.hashColumns.put("z_rfa_mapg_seq", getZRfaMapgSeq());
		this.hashColumns.put("z_cntrts_cd", getZCntrtsCd());
		this.hashColumns.put("z_skd_voyage_no", getZSkdVoyageNo());
		this.hashColumns.put("z_pod_loc", getZPodLoc());
		this.hashColumns.put("z_ofc_rhq", getZOfcRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("z_post_rly", "zPostRly");
		this.hashFields.put("z_pol_loc", "zPolLoc");
		this.hashFields.put("z_rfa_appr_no", "zRfaApprNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("z_sc_ver_seq", "zScVerSeq");
		this.hashFields.put("z_rfa_dtl_seq", "zRfaDtlSeq");
		this.hashFields.put("z_sc_cur_cd", "zScCurCd");
		this.hashFields.put("z_rfa_cur_cd", "zRfaCurCd");
		this.hashFields.put("z_dc_appl_rate", "zDcApplRate");
		this.hashFields.put("z_rfa_dar_no", "zRfaDarNo");
		this.hashFields.put("z_dbc_io_bnd", "zDbcIoBnd");
		this.hashFields.put("z_sc_no", "zScNo");
		this.hashFields.put("bzc_trf_aply_dt", "bzcTrfAplyDt");
		this.hashFields.put("z_rfa_ver_seq", "zRfaVerSeq");
		this.hashFields.put("z_vsl_cd", "zVslCd");
		this.hashFields.put("z_del_loc", "zDelLoc");
		this.hashFields.put("z_dtg_grp_id", "zDtgGrpId");
		this.hashFields.put("z_dtn_seq", "zDtnSeq");
		this.hashFields.put("z_pre_rly", "zPreRly");
		this.hashFields.put("z_cur_cd", "zCurCd");
		this.hashFields.put("z_por_loc", "zPorLoc");
		this.hashFields.put("z_sc_rfa_expt_aply_dt", "zScRfaExptAplyDt");
		this.hashFields.put("z_dcc_trs_ind", "zDccTrsInd");
		this.hashFields.put("z_ofc_cd", "zOfcCd");
		this.hashFields.put("z_sc_grp_seq", "zScGrpSeq");
		this.hashFields.put("z_skd_dir_cd", "zSkdDirCd");
		this.hashFields.put("z_bkg_no", "zBkgNo");
		this.hashFields.put("z_rfa_mapg_seq", "zRfaMapgSeq");
		this.hashFields.put("z_cntrts_cd", "zCntrtsCd");
		this.hashFields.put("z_skd_voyage_no", "zSkdVoyageNo");
		this.hashFields.put("z_pod_loc", "zPodLoc");
		this.hashFields.put("z_ofc_rhq", "zOfcRhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return zPostRly
	 */
	public String getZPostRly() {
		return this.zPostRly;
	}
	
	/**
	 * Column Info
	 * @return zPolLoc
	 */
	public String getZPolLoc() {
		return this.zPolLoc;
	}
	
	/**
	 * Column Info
	 * @return zRfaApprNo
	 */
	public String getZRfaApprNo() {
		return this.zRfaApprNo;
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
	 * @return zScVerSeq
	 */
	public String getZScVerSeq() {
		return this.zScVerSeq;
	}
	
	/**
	 * Column Info
	 * @return zRfaDtlSeq
	 */
	public String getZRfaDtlSeq() {
		return this.zRfaDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return zScCurCd
	 */
	public String getZScCurCd() {
		return this.zScCurCd;
	}
	
	/**
	 * Column Info
	 * @return zRfaCurCd
	 */
	public String getZRfaCurCd() {
		return this.zRfaCurCd;
	}
	
	/**
	 * Column Info
	 * @return zDcApplRate
	 */
	public String getZDcApplRate() {
		return this.zDcApplRate;
	}
	
	/**
	 * Column Info
	 * @return zRfaDarNo
	 */
	public String getZRfaDarNo() {
		return this.zRfaDarNo;
	}
	
	/**
	 * Column Info
	 * @return zDbcIoBnd
	 */
	public String getZDbcIoBnd() {
		return this.zDbcIoBnd;
	}
	
	/**
	 * Column Info
	 * @return zScNo
	 */
	public String getZScNo() {
		return this.zScNo;
	}
	
	/**
	 * Column Info
	 * @return bzcTrfAplyDt
	 */
	public String getBzcTrfAplyDt() {
		return this.bzcTrfAplyDt;
	}
	
	/**
	 * Column Info
	 * @return zRfaVerSeq
	 */
	public String getZRfaVerSeq() {
		return this.zRfaVerSeq;
	}
	
	/**
	 * Column Info
	 * @return zVslCd
	 */
	public String getZVslCd() {
		return this.zVslCd;
	}
	
	/**
	 * Column Info
	 * @return zDelLoc
	 */
	public String getZDelLoc() {
		return this.zDelLoc;
	}
	
	/**
	 * Column Info
	 * @return zDtgGrpId
	 */
	public String getZDtgGrpId() {
		return this.zDtgGrpId;
	}
	
	/**
	 * Column Info
	 * @return zDtnSeq
	 */
	public String getZDtnSeq() {
		return this.zDtnSeq;
	}
	
	/**
	 * Column Info
	 * @return zPreRly
	 */
	public String getZPreRly() {
		return this.zPreRly;
	}
	
	/**
	 * Column Info
	 * @return zCurCd
	 */
	public String getZCurCd() {
		return this.zCurCd;
	}
	
	/**
	 * Column Info
	 * @return zPorLoc
	 */
	public String getZPorLoc() {
		return this.zPorLoc;
	}

	/**
	 * Column Info
	 * @return zScRfaExptAplyDt
	 */
	public String getZScRfaExptAplyDt() {
		return this.zScRfaExptAplyDt;
	}

	/**
	 * Column Info
	 * @return zDccTrsInd
	 */
	public String getZDccTrsInd() {
		return this.zDccTrsInd;
	}
	
	/**
	 * Column Info
	 * @return zOfcCd
	 */
	public String getZOfcCd() {
		return this.zOfcCd;
	}
	
	/**
	 * Column Info
	 * @return zScGrpSeq
	 */
	public String getZScGrpSeq() {
		return this.zScGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return zSkdDirCd
	 */
	public String getZSkdDirCd() {
		return this.zSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return zBkgNo
	 */
	public String getZBkgNo() {
		return this.zBkgNo;
	}
	
	/**
	 * Column Info
	 * @return zRfaMapgSeq
	 */
	public String getZRfaMapgSeq() {
		return this.zRfaMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return zCntrtsCd
	 */
	public String getZCntrtsCd() {
		return this.zCntrtsCd;
	}
	
	/**
	 * Column Info
	 * @return zSkdVoyageNo
	 */
	public String getZSkdVoyageNo() {
		return this.zSkdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @return zPodLoc
	 */
	public String getZPodLoc() {
		return this.zPodLoc;
	}
	
	/**
	 * Column Info
	 * @return zOfcRhq
	 */
	public String getZOfcRhq() {
		return this.zOfcRhq;
	}
	

	/**
	 * Column Info
	 * @param zPostRly
	 */
	public void setZPostRly(String zPostRly) {
		this.zPostRly = zPostRly;
	}
	
	/**
	 * Column Info
	 * @param zPolLoc
	 */
	public void setZPolLoc(String zPolLoc) {
		this.zPolLoc = zPolLoc;
	}
	
	/**
	 * Column Info
	 * @param zRfaApprNo
	 */
	public void setZRfaApprNo(String zRfaApprNo) {
		this.zRfaApprNo = zRfaApprNo;
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
	 * @param zScVerSeq
	 */
	public void setZScVerSeq(String zScVerSeq) {
		this.zScVerSeq = zScVerSeq;
	}
	
	/**
	 * Column Info
	 * @param zRfaDtlSeq
	 */
	public void setZRfaDtlSeq(String zRfaDtlSeq) {
		this.zRfaDtlSeq = zRfaDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param zScCurCd
	 */
	public void setZScCurCd(String zScCurCd) {
		this.zScCurCd = zScCurCd;
	}
	
	/**
	 * Column Info
	 * @param zRfaCurCd
	 */
	public void setZRfaCurCd(String zRfaCurCd) {
		this.zRfaCurCd = zRfaCurCd;
	}
	
	/**
	 * Column Info
	 * @param zDcApplRate
	 */
	public void setZDcApplRate(String zDcApplRate) {
		this.zDcApplRate = zDcApplRate;
	}
	
	/**
	 * Column Info
	 * @param zRfaDarNo
	 */
	public void setZRfaDarNo(String zRfaDarNo) {
		this.zRfaDarNo = zRfaDarNo;
	}
	
	/**
	 * Column Info
	 * @param zDbcIoBnd
	 */
	public void setZDbcIoBnd(String zDbcIoBnd) {
		this.zDbcIoBnd = zDbcIoBnd;
	}
	
	/**
	 * Column Info
	 * @param zScNo
	 */
	public void setZScNo(String zScNo) {
		this.zScNo = zScNo;
	}
	
	/**
	 * Column Info
	 * @param bzcTrfAplyDt
	 */
	public void setBzcTrfAplyDt(String bzcTrfAplyDt) {
		this.bzcTrfAplyDt = bzcTrfAplyDt;
	}
	
	/**
	 * Column Info
	 * @param zRfaVerSeq
	 */
	public void setZRfaVerSeq(String zRfaVerSeq) {
		this.zRfaVerSeq = zRfaVerSeq;
	}
	
	/**
	 * Column Info
	 * @param zVslCd
	 */
	public void setZVslCd(String zVslCd) {
		this.zVslCd = zVslCd;
	}
	
	/**
	 * Column Info
	 * @param zDelLoc
	 */
	public void setZDelLoc(String zDelLoc) {
		this.zDelLoc = zDelLoc;
	}
	
	/**
	 * Column Info
	 * @param zDtgGrpId
	 */
	public void setZDtgGrpId(String zDtgGrpId) {
		this.zDtgGrpId = zDtgGrpId;
	}
	
	/**
	 * Column Info
	 * @param zDtnSeq
	 */
	public void setZDtnSeq(String zDtnSeq) {
		this.zDtnSeq = zDtnSeq;
	}
	
	/**
	 * Column Info
	 * @param zPreRly
	 */
	public void setZPreRly(String zPreRly) {
		this.zPreRly = zPreRly;
	}
	
	/**
	 * Column Info
	 * @param zCurCd
	 */
	public void setZCurCd(String zCurCd) {
		this.zCurCd = zCurCd;
	}
	
	/**
	 * Column Info
	 * @param zPorLoc
	 */
	public void setZPorLoc(String zPorLoc) {
		this.zPorLoc = zPorLoc;
	}
	
	/**
	 * Column Info
	 * @param zScRfaExptAplyDt
	 */
	public void setZScRfaExptAplyDt(String zScRfaExptAplyDt) {
		this.zScRfaExptAplyDt = zScRfaExptAplyDt;
	}

	/**
	 * Column Info
	 * @param zDccTrsInd
	 */
	public void setZDccTrsInd(String zDccTrsInd) {
		this.zDccTrsInd = zDccTrsInd;
	}
	
	/**
	 * Column Info
	 * @param zOfcCd
	 */
	public void setZOfcCd(String zOfcCd) {
		this.zOfcCd = zOfcCd;
	}
	
	/**
	 * Column Info
	 * @param zScGrpSeq
	 */
	public void setZScGrpSeq(String zScGrpSeq) {
		this.zScGrpSeq = zScGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param zSkdDirCd
	 */
	public void setZSkdDirCd(String zSkdDirCd) {
		this.zSkdDirCd = zSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param zBkgNo
	 */
	public void setZBkgNo(String zBkgNo) {
		this.zBkgNo = zBkgNo;
	}
	
	/**
	 * Column Info
	 * @param zRfaMapgSeq
	 */
	public void setZRfaMapgSeq(String zRfaMapgSeq) {
		this.zRfaMapgSeq = zRfaMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param zCntrtsCd
	 */
	public void setZCntrtsCd(String zCntrtsCd) {
		this.zCntrtsCd = zCntrtsCd;
	}
	
	/**
	 * Column Info
	 * @param zSkdVoyageNo
	 */
	public void setZSkdVoyageNo(String zSkdVoyageNo) {
		this.zSkdVoyageNo = zSkdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @param zPodLoc
	 */
	public void setZPodLoc(String zPodLoc) {
		this.zPodLoc = zPodLoc;
	}
	
	/**
	 * Column Info
	 * @param zOfcRhq
	 */
	public void setZOfcRhq(String zOfcRhq) {
		this.zOfcRhq = zOfcRhq;
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
		setZPostRly(JSPUtil.getParameter(request, prefix + "z_post_rly", ""));
		setZPolLoc(JSPUtil.getParameter(request, prefix + "z_pol_loc", ""));
		setZRfaApprNo(JSPUtil.getParameter(request, prefix + "z_rfa_appr_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setZScVerSeq(JSPUtil.getParameter(request, prefix + "z_sc_ver_seq", ""));
		setZRfaDtlSeq(JSPUtil.getParameter(request, prefix + "z_rfa_dtl_seq", ""));
		setZScCurCd(JSPUtil.getParameter(request, prefix + "z_sc_cur_cd", ""));
		setZRfaCurCd(JSPUtil.getParameter(request, prefix + "z_rfa_cur_cd", ""));
		setZDcApplRate(JSPUtil.getParameter(request, prefix + "z_dc_appl_rate", ""));
		setZRfaDarNo(JSPUtil.getParameter(request, prefix + "z_rfa_dar_no", ""));
		setZDbcIoBnd(JSPUtil.getParameter(request, prefix + "z_dbc_io_bnd", ""));
		setZScNo(JSPUtil.getParameter(request, prefix + "z_sc_no", ""));
		setBzcTrfAplyDt(JSPUtil.getParameter(request, prefix + "bzc_trf_aply_dt", ""));
		setZRfaVerSeq(JSPUtil.getParameter(request, prefix + "z_rfa_ver_seq", ""));
		setZVslCd(JSPUtil.getParameter(request, prefix + "z_vsl_cd", ""));
		setZDelLoc(JSPUtil.getParameter(request, prefix + "z_del_loc", ""));
		setZDtgGrpId(JSPUtil.getParameter(request, prefix + "z_dtg_grp_id", ""));
		setZDtnSeq(JSPUtil.getParameter(request, prefix + "z_dtn_seq", ""));
		setZPreRly(JSPUtil.getParameter(request, prefix + "z_pre_rly", ""));
		setZCurCd(JSPUtil.getParameter(request, prefix + "z_cur_cd", ""));
		setZPorLoc(JSPUtil.getParameter(request, prefix + "z_por_loc", ""));
		setZScRfaExptAplyDt(JSPUtil.getParameter(request, prefix + "z_sc_rfa_expt_aply_dt", ""));
		setZDccTrsInd(JSPUtil.getParameter(request, prefix + "z_dcc_trs_ind", ""));
		setZOfcCd(JSPUtil.getParameter(request, prefix + "z_ofc_cd", ""));
		setZScGrpSeq(JSPUtil.getParameter(request, prefix + "z_sc_grp_seq", ""));
		setZSkdDirCd(JSPUtil.getParameter(request, prefix + "z_skd_dir_cd", ""));
		setZBkgNo(JSPUtil.getParameter(request, prefix + "z_bkg_no", ""));
		setZRfaMapgSeq(JSPUtil.getParameter(request, prefix + "z_rfa_mapg_seq", ""));
		setZCntrtsCd(JSPUtil.getParameter(request, prefix + "z_cntrts_cd", ""));
		setZSkdVoyageNo(JSPUtil.getParameter(request, prefix + "z_skd_voyage_no", ""));
		setZPodLoc(JSPUtil.getParameter(request, prefix + "z_pod_loc", ""));
		setZOfcRhq(JSPUtil.getParameter(request, prefix + "z_ofc_rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeDataVO[]
	 */
	public ChargeDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeDataVO[]
	 */
	public ChargeDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] zPostRly = (JSPUtil.getParameter(request, prefix	+ "z_post_rly", length));
			String[] zPolLoc = (JSPUtil.getParameter(request, prefix	+ "z_pol_loc", length));
			String[] zRfaApprNo = (JSPUtil.getParameter(request, prefix	+ "z_rfa_appr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] zScVerSeq = (JSPUtil.getParameter(request, prefix	+ "z_sc_ver_seq", length));
			String[] zRfaDtlSeq = (JSPUtil.getParameter(request, prefix	+ "z_rfa_dtl_seq", length));
			String[] zScCurCd = (JSPUtil.getParameter(request, prefix	+ "z_sc_cur_cd", length));
			String[] zRfaCurCd = (JSPUtil.getParameter(request, prefix	+ "z_rfa_cur_cd", length));
			String[] zDcApplRate = (JSPUtil.getParameter(request, prefix	+ "z_dc_appl_rate", length));
			String[] zRfaDarNo = (JSPUtil.getParameter(request, prefix	+ "z_rfa_dar_no", length));
			String[] zDbcIoBnd = (JSPUtil.getParameter(request, prefix	+ "z_dbc_io_bnd", length));
			String[] zScNo = (JSPUtil.getParameter(request, prefix	+ "z_sc_no", length));
			String[] bzcTrfAplyDt = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_aply_dt", length));
			String[] zRfaVerSeq = (JSPUtil.getParameter(request, prefix	+ "z_rfa_ver_seq", length));
			String[] zVslCd = (JSPUtil.getParameter(request, prefix	+ "z_vsl_cd", length));
			String[] zDelLoc = (JSPUtil.getParameter(request, prefix	+ "z_del_loc", length));
			String[] zDtgGrpId = (JSPUtil.getParameter(request, prefix	+ "z_dtg_grp_id", length));
			String[] zDtnSeq = (JSPUtil.getParameter(request, prefix	+ "z_dtn_seq", length));
			String[] zPreRly = (JSPUtil.getParameter(request, prefix	+ "z_pre_rly", length));
			String[] zCurCd = (JSPUtil.getParameter(request, prefix	+ "z_cur_cd", length));
			String[] zPorLoc = (JSPUtil.getParameter(request, prefix	+ "z_por_loc", length));
			String[] zScRfaExptAplyDt = (JSPUtil.getParameter(request, prefix	+ "z_sc_rfa_expt_aply_dt", length));
			String[] zDccTrsInd = (JSPUtil.getParameter(request, prefix	+ "z_dcc_trs_ind", length));
			String[] zOfcCd = (JSPUtil.getParameter(request, prefix	+ "z_ofc_cd", length));
			String[] zScGrpSeq = (JSPUtil.getParameter(request, prefix	+ "z_sc_grp_seq", length));
			String[] zSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "z_skd_dir_cd", length));
			String[] zBkgNo = (JSPUtil.getParameter(request, prefix	+ "z_bkg_no", length));
			String[] zRfaMapgSeq = (JSPUtil.getParameter(request, prefix	+ "z_rfa_mapg_seq", length));
			String[] zCntrtsCd = (JSPUtil.getParameter(request, prefix	+ "z_cntrts_cd", length));
			String[] zSkdVoyageNo = (JSPUtil.getParameter(request, prefix	+ "z_skd_voyage_no", length));
			String[] zPodLoc = (JSPUtil.getParameter(request, prefix	+ "z_pod_loc", length));
			String[] zOfcRhq = (JSPUtil.getParameter(request, prefix	+ "z_ofc_rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeDataVO();
				if (zPostRly[i] != null)
					model.setZPostRly(zPostRly[i]);
				if (zPolLoc[i] != null)
					model.setZPolLoc(zPolLoc[i]);
				if (zRfaApprNo[i] != null)
					model.setZRfaApprNo(zRfaApprNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (zScVerSeq[i] != null)
					model.setZScVerSeq(zScVerSeq[i]);
				if (zRfaDtlSeq[i] != null)
					model.setZRfaDtlSeq(zRfaDtlSeq[i]);
				if (zScCurCd[i] != null)
					model.setZScCurCd(zScCurCd[i]);
				if (zRfaCurCd[i] != null)
					model.setZRfaCurCd(zRfaCurCd[i]);
				if (zDcApplRate[i] != null)
					model.setZDcApplRate(zDcApplRate[i]);
				if (zRfaDarNo[i] != null)
					model.setZRfaDarNo(zRfaDarNo[i]);
				if (zDbcIoBnd[i] != null)
					model.setZDbcIoBnd(zDbcIoBnd[i]);
				if (zScNo[i] != null)
					model.setZScNo(zScNo[i]);
				if (bzcTrfAplyDt[i] != null)
					model.setBzcTrfAplyDt(bzcTrfAplyDt[i]);
				if (zRfaVerSeq[i] != null)
					model.setZRfaVerSeq(zRfaVerSeq[i]);
				if (zVslCd[i] != null)
					model.setZVslCd(zVslCd[i]);
				if (zDelLoc[i] != null)
					model.setZDelLoc(zDelLoc[i]);
				if (zDtgGrpId[i] != null)
					model.setZDtgGrpId(zDtgGrpId[i]);
				if (zDtnSeq[i] != null)
					model.setZDtnSeq(zDtnSeq[i]);
				if (zPreRly[i] != null)
					model.setZPreRly(zPreRly[i]);
				if (zCurCd[i] != null)
					model.setZCurCd(zCurCd[i]);
				if (zPorLoc[i] != null)
					model.setZPorLoc(zPorLoc[i]);
				if (zScRfaExptAplyDt[i] != null)
					model.setZScRfaExptAplyDt(zScRfaExptAplyDt[i]);
				if (zDccTrsInd[i] != null)
					model.setZDccTrsInd(zDccTrsInd[i]);
				if (zOfcCd[i] != null)
					model.setZOfcCd(zOfcCd[i]);
				if (zScGrpSeq[i] != null)
					model.setZScGrpSeq(zScGrpSeq[i]);
				if (zSkdDirCd[i] != null)
					model.setZSkdDirCd(zSkdDirCd[i]);
				if (zBkgNo[i] != null)
					model.setZBkgNo(zBkgNo[i]);
				if (zRfaMapgSeq[i] != null)
					model.setZRfaMapgSeq(zRfaMapgSeq[i]);
				if (zCntrtsCd[i] != null)
					model.setZCntrtsCd(zCntrtsCd[i]);
				if (zSkdVoyageNo[i] != null)
					model.setZSkdVoyageNo(zSkdVoyageNo[i]);
				if (zPodLoc[i] != null)
					model.setZPodLoc(zPodLoc[i]);
				if (zOfcRhq[i] != null)
					model.setZOfcRhq(zOfcRhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeDataVO[]
	 */
	public ChargeDataVO[] getChargeDataVOs(){
		ChargeDataVO[] vos = (ChargeDataVO[])models.toArray(new ChargeDataVO[models.size()]);
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
		this.zPostRly = this.zPostRly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zPolLoc = this.zPolLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zRfaApprNo = this.zRfaApprNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zScVerSeq = this.zScVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zRfaDtlSeq = this.zRfaDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zScCurCd = this.zScCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zRfaCurCd = this.zRfaCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zDcApplRate = this.zDcApplRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zRfaDarNo = this.zRfaDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zDbcIoBnd = this.zDbcIoBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zScNo = this.zScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfAplyDt = this.bzcTrfAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zRfaVerSeq = this.zRfaVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zVslCd = this.zVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zDelLoc = this.zDelLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zDtgGrpId = this.zDtgGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zDtnSeq = this.zDtnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zPreRly = this.zPreRly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zCurCd = this.zCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zPorLoc = this.zPorLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zScRfaExptAplyDt = this.zScRfaExptAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zDccTrsInd = this.zDccTrsInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zOfcCd = this.zOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zScGrpSeq = this.zScGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zSkdDirCd = this.zSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zBkgNo = this.zBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zRfaMapgSeq = this.zRfaMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zCntrtsCd = this.zCntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zSkdVoyageNo = this.zSkdVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zPodLoc = this.zPodLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zOfcRhq = this.zOfcRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
