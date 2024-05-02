/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CmBkgInfoVO.java
*@FileTitle : CmBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.12.24 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CmBkgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CmBkgInfoVO> models = new ArrayList<CmBkgInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgMeasQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String corrFlg = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mypkgFlg = null;
	/* Column Info */
	private String bkgMeasUnit = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String bkgWgtUnit = null;
	/* Column Info */
	private String bkgPckUnit = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String htsFlg = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String bkgCstmsDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String bkgWgtQty = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String cneeSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgPckQty = null;
	/* Column Info */
	private String bkgMkDesc = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String eurFlg = null;
	/* Column Info */
	private String hsAplyDt = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CmBkgInfoVO() {}

	public CmBkgInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String tVvd, String vslCd, String skdVoyNo, String skdDirCd, String bkgCgoTpCd, String porCd, String polCd, String podCd, String delCd, String preRlyPortCd, String pstRlyPortCd, String bkgRcvTermCd, String bkgDeTermCd, String cmdtCd, String repCmdtCd, String bkgStsCd, String cmdtNm, String bdrFlg, String corrFlg, String htsFlg, String bkgPckQty, String bkgPckUnit, String bkgWgtQty, String bkgWgtUnit, String bkgMeasQty, String bkgMeasUnit, String shprCntCd, String shprSeq, String shprNm, String cneeCntCd, String cneeSeq, String cneeNm, String bkgMkDesc, String bkgCstmsDesc, String mypkgFlg, String creUsrId, String updUsrId, String eurFlg, String hsAplyDt) {
		this.porCd = porCd;
		this.bkgMeasQty = bkgMeasQty;
		this.vslCd = vslCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.blNo = blNo;
		this.cneeCntCd = cneeCntCd;
		this.pagerows = pagerows;
		this.corrFlg = corrFlg;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.mypkgFlg = mypkgFlg;
		this.bkgMeasUnit = bkgMeasUnit;
		this.tVvd = tVvd;
		this.bkgWgtUnit = bkgWgtUnit;
		this.bkgPckUnit = bkgPckUnit;
		this.cmdtCd = cmdtCd;
		this.htsFlg = htsFlg;
		this.shprNm = shprNm;
		this.bkgCstmsDesc = bkgCstmsDesc;
		this.updUsrId = updUsrId;
		this.preRlyPortCd = preRlyPortCd;
		this.bkgWgtQty = bkgWgtQty;
		this.shprCntCd = shprCntCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.cmdtNm = cmdtNm;
		this.blTpCd = blTpCd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.cneeNm = cneeNm;
		this.cneeSeq = cneeSeq;
		this.bkgNo = bkgNo;
		this.bkgPckQty = bkgPckQty;
		this.bkgMkDesc = bkgMkDesc;
		this.shprSeq = shprSeq;
		this.pstRlyPortCd = pstRlyPortCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.repCmdtCd = repCmdtCd;
		this.eurFlg = eurFlg;
		this.hsAplyDt = hsAplyDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_meas_qty", getBkgMeasQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("corr_flg", getCorrFlg());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mypkg_flg", getMypkgFlg());
		this.hashColumns.put("bkg_meas_unit", getBkgMeasUnit());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("bkg_wgt_unit", getBkgWgtUnit());
		this.hashColumns.put("bkg_pck_unit", getBkgPckUnit());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("hts_flg", getHtsFlg());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("bkg_cstms_desc", getBkgCstmsDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("bkg_wgt_qty", getBkgWgtQty());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_pck_qty", getBkgPckQty());
		this.hashColumns.put("bkg_mk_desc", getBkgMkDesc());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("eur_flg", getEurFlg());
		this.hashColumns.put("hs_aply_dt", getHsAplyDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_meas_qty", "bkgMeasQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("corr_flg", "corrFlg");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mypkg_flg", "mypkgFlg");
		this.hashFields.put("bkg_meas_unit", "bkgMeasUnit");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("bkg_wgt_unit", "bkgWgtUnit");
		this.hashFields.put("bkg_pck_unit", "bkgPckUnit");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("hts_flg", "htsFlg");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("bkg_cstms_desc", "bkgCstmsDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("bkg_wgt_qty", "bkgWgtQty");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cnee_seq", "cneeSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_pck_qty", "bkgPckQty");
		this.hashFields.put("bkg_mk_desc", "bkgMkDesc");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("eur_flg", "eurFlg");
		this.hashFields.put("hs_aply_dt", "hsAplyDt");
		return this.hashFields;
	}
	
	
	/**
	 * @return the eurFlg
	 */
	public String getEurFlg() {
		return eurFlg;
	}

	/**
	 * @param eurFlg the eurFlg to set
	 */
	public void setEurFlg(String eurFlg) {
		this.eurFlg = eurFlg;
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
	 * @return bkgMeasQty
	 */
	public String getBkgMeasQty() {
		return this.bkgMeasQty;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
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
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
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
	 * @return corrFlg
	 */
	public String getCorrFlg() {
		return this.corrFlg;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return mypkgFlg
	 */
	public String getMypkgFlg() {
		return this.mypkgFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgMeasUnit
	 */
	public String getBkgMeasUnit() {
		return this.bkgMeasUnit;
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
	 * @return bkgWgtUnit
	 */
	public String getBkgWgtUnit() {
		return this.bkgWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return bkgPckUnit
	 */
	public String getBkgPckUnit() {
		return this.bkgPckUnit;
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
	 * @return htsFlg
	 */
	public String getHtsFlg() {
		return this.htsFlg;
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
	 * @return bkgCstmsDesc
	 */
	public String getBkgCstmsDesc() {
		return this.bkgCstmsDesc;
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
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return bkgWgtQty
	 */
	public String getBkgWgtQty() {
		return this.bkgWgtQty;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
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
	 * @return bkgPckQty
	 */
	public String getBkgPckQty() {
		return this.bkgPckQty;
	}
	
	/**
	 * Column Info
	 * @return bkgMkDesc
	 */
	public String getBkgMkDesc() {
		return this.bkgMkDesc;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
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
	 * @return hsAplyDt
	 */
	public String getHsAplyDt() {
		return this.hsAplyDt;
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
	 * @param bkgMeasQty
	 */
	public void setBkgMeasQty(String bkgMeasQty) {
		this.bkgMeasQty = bkgMeasQty;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
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
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
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
	 * @param corrFlg
	 */
	public void setCorrFlg(String corrFlg) {
		this.corrFlg = corrFlg;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param mypkgFlg
	 */
	public void setMypkgFlg(String mypkgFlg) {
		this.mypkgFlg = mypkgFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgMeasUnit
	 */
	public void setBkgMeasUnit(String bkgMeasUnit) {
		this.bkgMeasUnit = bkgMeasUnit;
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
	 * @param bkgWgtUnit
	 */
	public void setBkgWgtUnit(String bkgWgtUnit) {
		this.bkgWgtUnit = bkgWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param bkgPckUnit
	 */
	public void setBkgPckUnit(String bkgPckUnit) {
		this.bkgPckUnit = bkgPckUnit;
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
	 * @param htsFlg
	 */
	public void setHtsFlg(String htsFlg) {
		this.htsFlg = htsFlg;
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
	 * @param bkgCstmsDesc
	 */
	public void setBkgCstmsDesc(String bkgCstmsDesc) {
		this.bkgCstmsDesc = bkgCstmsDesc;
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
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param bkgWgtQty
	 */
	public void setBkgWgtQty(String bkgWgtQty) {
		this.bkgWgtQty = bkgWgtQty;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
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
	 * @param bkgPckQty
	 */
	public void setBkgPckQty(String bkgPckQty) {
		this.bkgPckQty = bkgPckQty;
	}
	
	/**
	 * Column Info
	 * @param bkgMkDesc
	 */
	public void setBkgMkDesc(String bkgMkDesc) {
		this.bkgMkDesc = bkgMkDesc;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param hsAplyDt
	 */
	public void setHsAplyDt(String hsAplyDt) {
		this.hsAplyDt = hsAplyDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 * @param prefix
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBkgMeasQty(JSPUtil.getParameter(request, prefix + "bkg_meas_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCorrFlg(JSPUtil.getParameter(request, prefix + "corr_flg", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMypkgFlg(JSPUtil.getParameter(request, prefix + "mypkg_flg", ""));
		setBkgMeasUnit(JSPUtil.getParameter(request, prefix + "bkg_meas_unit", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setBkgWgtUnit(JSPUtil.getParameter(request, prefix + "bkg_wgt_unit", ""));
		setBkgPckUnit(JSPUtil.getParameter(request, prefix + "bkg_pck_unit", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setHtsFlg(JSPUtil.getParameter(request, prefix + "hts_flg", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setBkgCstmsDesc(JSPUtil.getParameter(request, prefix + "bkg_cstms_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, prefix + "pre_rly_port_cd", ""));
		setBkgWgtQty(JSPUtil.getParameter(request, prefix + "bkg_wgt_qty", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBkgPckQty(JSPUtil.getParameter(request, prefix + "bkg_pck_qty", ""));
		setBkgMkDesc(JSPUtil.getParameter(request, prefix + "bkg_mk_desc", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, prefix + "pst_rly_port_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setEurFlg(JSPUtil.getParameter(request, prefix + "eur_flg", ""));
		setHsAplyDt(JSPUtil.getParameter(request, prefix + "hs_aply_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CmBkgInfoVO[]
	 */
	public CmBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CmBkgInfoVO[]
	 */
	public CmBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CmBkgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgMeasQty = (JSPUtil.getParameter(request, prefix	+ "bkg_meas_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] corrFlg = (JSPUtil.getParameter(request, prefix	+ "corr_flg", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mypkgFlg = (JSPUtil.getParameter(request, prefix	+ "mypkg_flg", length));
			String[] bkgMeasUnit = (JSPUtil.getParameter(request, prefix	+ "bkg_meas_unit", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] bkgWgtUnit = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_unit", length));
			String[] bkgPckUnit = (JSPUtil.getParameter(request, prefix	+ "bkg_pck_unit", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] htsFlg = (JSPUtil.getParameter(request, prefix	+ "hts_flg", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] bkgCstmsDesc = (JSPUtil.getParameter(request, prefix	+ "bkg_cstms_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] bkgWgtQty = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_qty", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgPckQty = (JSPUtil.getParameter(request, prefix	+ "bkg_pck_qty", length));
			String[] bkgMkDesc = (JSPUtil.getParameter(request, prefix	+ "bkg_mk_desc", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] eurFlg = (JSPUtil.getParameter(request, prefix	+ "eur_flg", length));
			String[] hsAplyDt = (JSPUtil.getParameter(request, prefix	+ "hs_aply_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CmBkgInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgMeasQty[i] != null)
					model.setBkgMeasQty(bkgMeasQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (corrFlg[i] != null)
					model.setCorrFlg(corrFlg[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mypkgFlg[i] != null)
					model.setMypkgFlg(mypkgFlg[i]);
				if (bkgMeasUnit[i] != null)
					model.setBkgMeasUnit(bkgMeasUnit[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (bkgWgtUnit[i] != null)
					model.setBkgWgtUnit(bkgWgtUnit[i]);
				if (bkgPckUnit[i] != null)
					model.setBkgPckUnit(bkgPckUnit[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (htsFlg[i] != null)
					model.setHtsFlg(htsFlg[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (bkgCstmsDesc[i] != null)
					model.setBkgCstmsDesc(bkgCstmsDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (bkgWgtQty[i] != null)
					model.setBkgWgtQty(bkgWgtQty[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgPckQty[i] != null)
					model.setBkgPckQty(bkgPckQty[i]);
				if (bkgMkDesc[i] != null)
					model.setBkgMkDesc(bkgMkDesc[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (eurFlg[i] != null)
					model.setEurFlg(eurFlg[i]);
				if (hsAplyDt[i] != null)
					model.setHsAplyDt(hsAplyDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCmBkgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CmBkgInfoVO[]
	 */
	public CmBkgInfoVO[] getCmBkgInfoVOs(){
		CmBkgInfoVO[] vos = (CmBkgInfoVO[])models.toArray(new CmBkgInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeasQty = this.bkgMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrFlg = this.corrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mypkgFlg = this.mypkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeasUnit = this.bkgMeasUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtUnit = this.bkgWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPckUnit = this.bkgPckUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htsFlg = this.htsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCstmsDesc = this.bkgCstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtQty = this.bkgWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPckQty = this.bkgPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMkDesc = this.bkgMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurFlg = this.eurFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hsAplyDt = this.hsAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
