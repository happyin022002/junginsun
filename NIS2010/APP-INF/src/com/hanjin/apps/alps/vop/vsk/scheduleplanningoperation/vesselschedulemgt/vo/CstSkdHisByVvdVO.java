/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CstSkdHisByVvdVO.java
*@FileTitle : CstSkdHisByVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.26  
* 1.0 Creation
* 2011.10.26 김민아 [CHM-201114112-01] VSL SKD History Inquiry 화면 로직 변경
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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

public class CstSkdHisByVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstSkdHisByVvdVO> models = new ArrayList<CstSkdHisByVvdVO>();
	
	/* Column Info */
	private String bfrSkdDirCd = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String aftYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftVslSlanCd = null;
	/* Column Info */
	private String aftSkdVoyNo = null;
	/* Column Info */
	private String bfrSkdVoyNo = null;
	/* Column Info */
	private String bfrVslCd = null;
	/* Column Info */
	private String aftVpsEtbDt = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String bfrVpsPortCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sortDate = null;
	/* Column Info */
	private String aftVpsEtaDt = null;
	/* Column Info */
	private String bfrYdCd = null;
	/* Column Info */
	private String bfrVpsEtbDt = null;
	/* Column Info */
	private String bfrVslSlanCd = null;
	/* Column Info */
	private String aftVpsPortCd = null;
	/* Column Info */
	private String vskdCngTpCd = null;
	/* Column Info */
	private String bfrVpsEtaDt = null;
	/* Column Info */
	private String bfrVpsEtdDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String aftVpsEtdDt = null;
	/* Column Info */
	private String aftVslCd = null;
	/* Column Info */
	private String aftSkdDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstSkdHisByVvdVO() {}

	public CstSkdHisByVvdVO(String ibflag, String pagerows, String bfrVslCd, String bfrSkdVoyNo, String bfrSkdDirCd, String bfrVslSlanCd, String bfrVpsEtaDt, String bfrVpsEtbDt, String bfrVpsEtdDt, String bfrVpsPortCd, String bfrYdCd, String aftVslCd, String aftSkdVoyNo, String aftSkdDirCd, String aftVslSlanCd, String aftVpsEtaDt, String aftVpsEtbDt, String aftVpsEtdDt, String aftVpsPortCd, String aftYdCd, String vskdCngTpCd, String creDt, String creUsrId, String updDt, String updUsrId, String diffRmk, String sortDate, String totalCnt) {
		this.bfrSkdDirCd = bfrSkdDirCd;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.aftYdCd = aftYdCd;
		this.ibflag = ibflag;
		this.aftVslSlanCd = aftVslSlanCd;
		this.aftSkdVoyNo = aftSkdVoyNo;
		this.bfrSkdVoyNo = bfrSkdVoyNo;
		this.bfrVslCd = bfrVslCd;
		this.aftVpsEtbDt = aftVpsEtbDt;
		this.totalCnt = totalCnt;
		this.bfrVpsPortCd = bfrVpsPortCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.sortDate = sortDate;
		this.aftVpsEtaDt = aftVpsEtaDt;
		this.bfrYdCd = bfrYdCd;
		this.bfrVpsEtbDt = bfrVpsEtbDt;
		this.bfrVslSlanCd = bfrVslSlanCd;
		this.aftVpsPortCd = aftVpsPortCd;
		this.vskdCngTpCd = vskdCngTpCd;
		this.bfrVpsEtaDt = bfrVpsEtaDt;
		this.bfrVpsEtdDt = bfrVpsEtdDt;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.aftVpsEtdDt = aftVpsEtdDt;
		this.aftVslCd = aftVslCd;
		this.aftSkdDirCd = aftSkdDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bfr_skd_dir_cd", getBfrSkdDirCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("aft_yd_cd", getAftYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_vsl_slan_cd", getAftVslSlanCd());
		this.hashColumns.put("aft_skd_voy_no", getAftSkdVoyNo());
		this.hashColumns.put("bfr_skd_voy_no", getBfrSkdVoyNo());
		this.hashColumns.put("bfr_vsl_cd", getBfrVslCd());
		this.hashColumns.put("aft_vps_etb_dt", getAftVpsEtbDt());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("bfr_vps_port_cd", getBfrVpsPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sort_date", getSortDate());
		this.hashColumns.put("aft_vps_eta_dt", getAftVpsEtaDt());
		this.hashColumns.put("bfr_yd_cd", getBfrYdCd());
		this.hashColumns.put("bfr_vps_etb_dt", getBfrVpsEtbDt());
		this.hashColumns.put("bfr_vsl_slan_cd", getBfrVslSlanCd());
		this.hashColumns.put("aft_vps_port_cd", getAftVpsPortCd());
		this.hashColumns.put("vskd_cng_tp_cd", getVskdCngTpCd());
		this.hashColumns.put("bfr_vps_eta_dt", getBfrVpsEtaDt());
		this.hashColumns.put("bfr_vps_etd_dt", getBfrVpsEtdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("aft_vps_etd_dt", getAftVpsEtdDt());
		this.hashColumns.put("aft_vsl_cd", getAftVslCd());
		this.hashColumns.put("aft_skd_dir_cd", getAftSkdDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bfr_skd_dir_cd", "bfrSkdDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aft_yd_cd", "aftYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_vsl_slan_cd", "aftVslSlanCd");
		this.hashFields.put("aft_skd_voy_no", "aftSkdVoyNo");
		this.hashFields.put("bfr_skd_voy_no", "bfrSkdVoyNo");
		this.hashFields.put("bfr_vsl_cd", "bfrVslCd");
		this.hashFields.put("aft_vps_etb_dt", "aftVpsEtbDt");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("bfr_vps_port_cd", "bfrVpsPortCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sort_date", "sortDate");
		this.hashFields.put("aft_vps_eta_dt", "aftVpsEtaDt");
		this.hashFields.put("bfr_yd_cd", "bfrYdCd");
		this.hashFields.put("bfr_vps_etb_dt", "bfrVpsEtbDt");
		this.hashFields.put("bfr_vsl_slan_cd", "bfrVslSlanCd");
		this.hashFields.put("aft_vps_port_cd", "aftVpsPortCd");
		this.hashFields.put("vskd_cng_tp_cd", "vskdCngTpCd");
		this.hashFields.put("bfr_vps_eta_dt", "bfrVpsEtaDt");
		this.hashFields.put("bfr_vps_etd_dt", "bfrVpsEtdDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("aft_vps_etd_dt", "aftVpsEtdDt");
		this.hashFields.put("aft_vsl_cd", "aftVslCd");
		this.hashFields.put("aft_skd_dir_cd", "aftSkdDirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bfrSkdDirCd
	 */
	public String getBfrSkdDirCd() {
		return this.bfrSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return aftYdCd
	 */
	public String getAftYdCd() {
		return this.aftYdCd;
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
	 * @return aftVslSlanCd
	 */
	public String getAftVslSlanCd() {
		return this.aftVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return aftSkdVoyNo
	 */
	public String getAftSkdVoyNo() {
		return this.aftSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bfrSkdVoyNo
	 */
	public String getBfrSkdVoyNo() {
		return this.bfrSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bfrVslCd
	 */
	public String getBfrVslCd() {
		return this.bfrVslCd;
	}
	
	/**
	 * Column Info
	 * @return aftVpsEtbDt
	 */
	public String getAftVpsEtbDt() {
		return this.aftVpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return bfrVpsPortCd
	 */
	public String getBfrVpsPortCd() {
		return this.bfrVpsPortCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return sortDate
	 */
	public String getSortDate() {
		return this.sortDate;
	}
	
	/**
	 * Column Info
	 * @return aftVpsEtaDt
	 */
	public String getAftVpsEtaDt() {
		return this.aftVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return bfrYdCd
	 */
	public String getBfrYdCd() {
		return this.bfrYdCd;
	}
	
	/**
	 * Column Info
	 * @return bfrVpsEtbDt
	 */
	public String getBfrVpsEtbDt() {
		return this.bfrVpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return bfrVslSlanCd
	 */
	public String getBfrVslSlanCd() {
		return this.bfrVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return aftVpsPortCd
	 */
	public String getAftVpsPortCd() {
		return this.aftVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return vskdCngTpCd
	 */
	public String getVskdCngTpCd() {
		return this.vskdCngTpCd;
	}
	
	/**
	 * Column Info
	 * @return bfrVpsEtaDt
	 */
	public String getBfrVpsEtaDt() {
		return this.bfrVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return bfrVpsEtdDt
	 */
	public String getBfrVpsEtdDt() {
		return this.bfrVpsEtdDt;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return aftVpsEtdDt
	 */
	public String getAftVpsEtdDt() {
		return this.aftVpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return aftVslCd
	 */
	public String getAftVslCd() {
		return this.aftVslCd;
	}
	
	/**
	 * Column Info
	 * @return aftSkdDirCd
	 */
	public String getAftSkdDirCd() {
		return this.aftSkdDirCd;
	}
	

	/**
	 * Column Info
	 * @param bfrSkdDirCd
	 */
	public void setBfrSkdDirCd(String bfrSkdDirCd) {
		this.bfrSkdDirCd = bfrSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param aftYdCd
	 */
	public void setAftYdCd(String aftYdCd) {
		this.aftYdCd = aftYdCd;
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
	 * @param aftVslSlanCd
	 */
	public void setAftVslSlanCd(String aftVslSlanCd) {
		this.aftVslSlanCd = aftVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param aftSkdVoyNo
	 */
	public void setAftSkdVoyNo(String aftSkdVoyNo) {
		this.aftSkdVoyNo = aftSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bfrSkdVoyNo
	 */
	public void setBfrSkdVoyNo(String bfrSkdVoyNo) {
		this.bfrSkdVoyNo = bfrSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param bfrVslCd
	 */
	public void setBfrVslCd(String bfrVslCd) {
		this.bfrVslCd = bfrVslCd;
	}
	
	/**
	 * Column Info
	 * @param aftVpsEtbDt
	 */
	public void setAftVpsEtbDt(String aftVpsEtbDt) {
		this.aftVpsEtbDt = aftVpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param bfrVpsPortCd
	 */
	public void setBfrVpsPortCd(String bfrVpsPortCd) {
		this.bfrVpsPortCd = bfrVpsPortCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param sortDate
	 */
	public void setSortDate(String sortDate) {
		this.sortDate = sortDate;
	}
	
	/**
	 * Column Info
	 * @param aftVpsEtaDt
	 */
	public void setAftVpsEtaDt(String aftVpsEtaDt) {
		this.aftVpsEtaDt = aftVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param bfrYdCd
	 */
	public void setBfrYdCd(String bfrYdCd) {
		this.bfrYdCd = bfrYdCd;
	}
	
	/**
	 * Column Info
	 * @param bfrVpsEtbDt
	 */
	public void setBfrVpsEtbDt(String bfrVpsEtbDt) {
		this.bfrVpsEtbDt = bfrVpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param bfrVslSlanCd
	 */
	public void setBfrVslSlanCd(String bfrVslSlanCd) {
		this.bfrVslSlanCd = bfrVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param aftVpsPortCd
	 */
	public void setAftVpsPortCd(String aftVpsPortCd) {
		this.aftVpsPortCd = aftVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param vskdCngTpCd
	 */
	public void setVskdCngTpCd(String vskdCngTpCd) {
		this.vskdCngTpCd = vskdCngTpCd;
	}
	
	/**
	 * Column Info
	 * @param bfrVpsEtaDt
	 */
	public void setBfrVpsEtaDt(String bfrVpsEtaDt) {
		this.bfrVpsEtaDt = bfrVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param bfrVpsEtdDt
	 */
	public void setBfrVpsEtdDt(String bfrVpsEtdDt) {
		this.bfrVpsEtdDt = bfrVpsEtdDt;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param aftVpsEtdDt
	 */
	public void setAftVpsEtdDt(String aftVpsEtdDt) {
		this.aftVpsEtdDt = aftVpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param aftVslCd
	 */
	public void setAftVslCd(String aftVslCd) {
		this.aftVslCd = aftVslCd;
	}
	
	/**
	 * Column Info
	 * @param aftSkdDirCd
	 */
	public void setAftSkdDirCd(String aftSkdDirCd) {
		this.aftSkdDirCd = aftSkdDirCd;
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
		setBfrSkdDirCd(JSPUtil.getParameter(request, prefix + "bfr_skd_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAftYdCd(JSPUtil.getParameter(request, prefix + "aft_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAftVslSlanCd(JSPUtil.getParameter(request, prefix + "aft_vsl_slan_cd", ""));
		setAftSkdVoyNo(JSPUtil.getParameter(request, prefix + "aft_skd_voy_no", ""));
		setBfrSkdVoyNo(JSPUtil.getParameter(request, prefix + "bfr_skd_voy_no", ""));
		setBfrVslCd(JSPUtil.getParameter(request, prefix + "bfr_vsl_cd", ""));
		setAftVpsEtbDt(JSPUtil.getParameter(request, prefix + "aft_vps_etb_dt", ""));
		setTotalCnt(JSPUtil.getParameter(request, prefix + "total_cnt", ""));
		setBfrVpsPortCd(JSPUtil.getParameter(request, prefix + "bfr_vps_port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSortDate(JSPUtil.getParameter(request, prefix + "sort_date", ""));
		setAftVpsEtaDt(JSPUtil.getParameter(request, prefix + "aft_vps_eta_dt", ""));
		setBfrYdCd(JSPUtil.getParameter(request, prefix + "bfr_yd_cd", ""));
		setBfrVpsEtbDt(JSPUtil.getParameter(request, prefix + "bfr_vps_etb_dt", ""));
		setBfrVslSlanCd(JSPUtil.getParameter(request, prefix + "bfr_vsl_slan_cd", ""));
		setAftVpsPortCd(JSPUtil.getParameter(request, prefix + "aft_vps_port_cd", ""));
		setVskdCngTpCd(JSPUtil.getParameter(request, prefix + "vskd_cng_tp_cd", ""));
		setBfrVpsEtaDt(JSPUtil.getParameter(request, prefix + "bfr_vps_eta_dt", ""));
		setBfrVpsEtdDt(JSPUtil.getParameter(request, prefix + "bfr_vps_etd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setAftVpsEtdDt(JSPUtil.getParameter(request, prefix + "aft_vps_etd_dt", ""));
		setAftVslCd(JSPUtil.getParameter(request, prefix + "aft_vsl_cd", ""));
		setAftSkdDirCd(JSPUtil.getParameter(request, prefix + "aft_skd_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstSkdHisByVvdVO[]
	 */
	public CstSkdHisByVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstSkdHisByVvdVO[]
	 */
	public CstSkdHisByVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstSkdHisByVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bfrSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "bfr_skd_dir_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] aftYdCd = (JSPUtil.getParameter(request, prefix	+ "aft_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "aft_vsl_slan_cd", length));
			String[] aftSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "aft_skd_voy_no", length));
			String[] bfrSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "bfr_skd_voy_no", length));
			String[] bfrVslCd = (JSPUtil.getParameter(request, prefix	+ "bfr_vsl_cd", length));
			String[] aftVpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "aft_vps_etb_dt", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] bfrVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "bfr_vps_port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sortDate = (JSPUtil.getParameter(request, prefix	+ "sort_date", length));
			String[] aftVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "aft_vps_eta_dt", length));
			String[] bfrYdCd = (JSPUtil.getParameter(request, prefix	+ "bfr_yd_cd", length));
			String[] bfrVpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "bfr_vps_etb_dt", length));
			String[] bfrVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "bfr_vsl_slan_cd", length));
			String[] aftVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "aft_vps_port_cd", length));
			String[] vskdCngTpCd = (JSPUtil.getParameter(request, prefix	+ "vskd_cng_tp_cd", length));
			String[] bfrVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "bfr_vps_eta_dt", length));
			String[] bfrVpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "bfr_vps_etd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] aftVpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "aft_vps_etd_dt", length));
			String[] aftVslCd = (JSPUtil.getParameter(request, prefix	+ "aft_vsl_cd", length));
			String[] aftSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "aft_skd_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstSkdHisByVvdVO();
				if (bfrSkdDirCd[i] != null)
					model.setBfrSkdDirCd(bfrSkdDirCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (aftYdCd[i] != null)
					model.setAftYdCd(aftYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftVslSlanCd[i] != null)
					model.setAftVslSlanCd(aftVslSlanCd[i]);
				if (aftSkdVoyNo[i] != null)
					model.setAftSkdVoyNo(aftSkdVoyNo[i]);
				if (bfrSkdVoyNo[i] != null)
					model.setBfrSkdVoyNo(bfrSkdVoyNo[i]);
				if (bfrVslCd[i] != null)
					model.setBfrVslCd(bfrVslCd[i]);
				if (aftVpsEtbDt[i] != null)
					model.setAftVpsEtbDt(aftVpsEtbDt[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (bfrVpsPortCd[i] != null)
					model.setBfrVpsPortCd(bfrVpsPortCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sortDate[i] != null)
					model.setSortDate(sortDate[i]);
				if (aftVpsEtaDt[i] != null)
					model.setAftVpsEtaDt(aftVpsEtaDt[i]);
				if (bfrYdCd[i] != null)
					model.setBfrYdCd(bfrYdCd[i]);
				if (bfrVpsEtbDt[i] != null)
					model.setBfrVpsEtbDt(bfrVpsEtbDt[i]);
				if (bfrVslSlanCd[i] != null)
					model.setBfrVslSlanCd(bfrVslSlanCd[i]);
				if (aftVpsPortCd[i] != null)
					model.setAftVpsPortCd(aftVpsPortCd[i]);
				if (vskdCngTpCd[i] != null)
					model.setVskdCngTpCd(vskdCngTpCd[i]);
				if (bfrVpsEtaDt[i] != null)
					model.setBfrVpsEtaDt(bfrVpsEtaDt[i]);
				if (bfrVpsEtdDt[i] != null)
					model.setBfrVpsEtdDt(bfrVpsEtdDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (aftVpsEtdDt[i] != null)
					model.setAftVpsEtdDt(aftVpsEtdDt[i]);
				if (aftVslCd[i] != null)
					model.setAftVslCd(aftVslCd[i]);
				if (aftSkdDirCd[i] != null)
					model.setAftSkdDirCd(aftSkdDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstSkdHisByVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstSkdHisByVvdVO[]
	 */
	public CstSkdHisByVvdVO[] getCstSkdHisByVvdVOs(){
		CstSkdHisByVvdVO[] vos = (CstSkdHisByVvdVO[])models.toArray(new CstSkdHisByVvdVO[models.size()]);
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
		this.bfrSkdDirCd = this.bfrSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftYdCd = this.aftYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVslSlanCd = this.aftVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftSkdVoyNo = this.aftSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrSkdVoyNo = this.bfrSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrVslCd = this.bfrVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVpsEtbDt = this.aftVpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrVpsPortCd = this.bfrVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortDate = this.sortDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVpsEtaDt = this.aftVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrYdCd = this.bfrYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrVpsEtbDt = this.bfrVpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrVslSlanCd = this.bfrVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVpsPortCd = this.aftVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdCngTpCd = this.vskdCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrVpsEtaDt = this.bfrVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrVpsEtdDt = this.bfrVpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVpsEtdDt = this.aftVpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVslCd = this.aftVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftSkdDirCd = this.aftSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
