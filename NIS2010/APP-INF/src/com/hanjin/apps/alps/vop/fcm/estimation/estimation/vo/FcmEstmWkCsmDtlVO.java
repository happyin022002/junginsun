/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FcmEstmWkCsmDtlVO.java
*@FileTitle : FcmEstmWkCsmDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.03.28 진마리아 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.estimation.estimation.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
/*
--FcmEstmWkCsmDtlVO
SELECT
'' ESTM_SEQ,
'' BSE_YRMON,
'' BSE_WK,
'' VSL_CD,
'' ESTM_SKD_VOY_NO,
'' ESTM_SKD_DIR_CD,
'' FCM_ESTM_WRK_DT,
'' FCM_ESTM_WRK_SEQ,
'' TRD_CD,
'' SUB_TRD_CD,
'' PORT_FOIL_ESTM_CSM_WGT,
'' PORT_DOIL_ESTM_CSM_WGT,
'' SEA_FOIL_ESTM_CSM_WGT,
'' SEA_DOIL_ESTM_CSM_WGT,
'' VVD_SEQ,
'' SKD_VOY_NO,
'' SKD_DIR_CD,
'' VPS_PORT_CD,
'' YD_CD,
'' CLPT_IND_SEQ,
'' CLPT_SEQ,
'' VPS_ETA_DT,
'' VPS_ETB_DT,
'' VPS_ETD_DT,
'' GMT,
'' MNVR_IN_HRS,
'' MNVR_OUT_HRS,
'' SEA_BUF_HRS,
'' PORT_SEQ,
'' NXT_SKD_VOY_NO,
'' NXT_SKD_DIR_CD,
'' NXT_PORT_CD,
'' NXT_ETA_DT,
'' NXT_GMT,
'' NXT_MNVR_IN_HRS,
'' SEA_SAIL_HRS,
'' PORT_BRTH_HRS,
'' SEA_SAIL_SPD,
'' LNK_DIST,
'' TRND_LINE_SEQ,
'' TRND_LINE_NO,
'' CRE_USR_ID,
'' CRE_DT,
'' UPD_USR_ID,
'' UPD_DT
FROM DUAL
 */
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmEstmWkCsmDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmEstmWkCsmDtlVO> models = new ArrayList<FcmEstmWkCsmDtlVO>();
	
	/* Column Info */
	private String estmSkdVoyNo = null;
	/* Column Info */
	private String mnvrOutHrs = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String nxtSkdDirCd = null;
	/* Column Info */
	private String seaBufHrs = null;
	/* Column Info */
	private String nxtSkdVoyNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String seaSailSpd = null;
	/* Column Info */
	private String portBrthHrs = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String estmSkdDirCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String nxtPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseYrmon = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String fcmEstmWrkSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String seaFoilEstmCsmWgt = null;
	/* Column Info */
	private String seaSailHrs = null;
	/* Column Info */
	private String nxtMnvrInHrs = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String portFoilEstmCsmWgt = null;
	/* Column Info */
	private String lnkDist = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String trndLineNo = null;
	/* Column Info */
	private String nxtGmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String nxtEtaDt = null;
	/* Column Info */
	private String bseWk = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String mnvrInHrs = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String portDoilEstmCsmWgt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String gmt = null;
	/* Column Info */
	private String trndLineSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String fcmEstmWrkDt = null;
	/* Column Info */
	private String seaDoilEstmCsmWgt = null;
	/* Column Info */
	private String estmSeq = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmEstmWkCsmDtlVO() {}

	public FcmEstmWkCsmDtlVO(String ibflag, String pagerows, String estmSeq, String bseYrmon, String bseWk, String vslCd, String estmSkdVoyNo, String estmSkdDirCd, String fcmEstmWrkDt, String fcmEstmWrkSeq, String trdCd, String subTrdCd, String portFoilEstmCsmWgt, String portDoilEstmCsmWgt, String seaFoilEstmCsmWgt, String seaDoilEstmCsmWgt, String vvdSeq, String skdVoyNo, String skdDirCd, String vpsPortCd, String ydCd, String clptIndSeq, String clptSeq, String vpsEtaDt, String vpsEtbDt, String vpsEtdDt, String gmt, String mnvrInHrs, String mnvrOutHrs, String seaBufHrs, String portSeq, String nxtSkdVoyNo, String nxtSkdDirCd, String nxtPortCd, String nxtEtaDt, String nxtGmt, String nxtMnvrInHrs, String seaSailHrs, String portBrthHrs, String seaSailSpd, String lnkDist, String trndLineSeq, String trndLineNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.estmSkdVoyNo = estmSkdVoyNo;
		this.mnvrOutHrs = mnvrOutHrs;
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.nxtSkdDirCd = nxtSkdDirCd;
		this.seaBufHrs = seaBufHrs;
		this.nxtSkdVoyNo = nxtSkdVoyNo;
		this.creDt = creDt;
		this.seaSailSpd = seaSailSpd;
		this.portBrthHrs = portBrthHrs;
		this.trdCd = trdCd;
		this.estmSkdDirCd = estmSkdDirCd;
		this.vpsEtaDt = vpsEtaDt;
		this.nxtPortCd = nxtPortCd;
		this.pagerows = pagerows;
		this.bseYrmon = bseYrmon;
		this.vpsPortCd = vpsPortCd;
		this.clptSeq = clptSeq;
		this.fcmEstmWrkSeq = fcmEstmWrkSeq;
		this.ibflag = ibflag;
		this.seaFoilEstmCsmWgt = seaFoilEstmCsmWgt;
		this.seaSailHrs = seaSailHrs;
		this.nxtMnvrInHrs = nxtMnvrInHrs;
		this.updUsrId = updUsrId;
		this.vvdSeq = vvdSeq;
		this.updDt = updDt;
		this.portFoilEstmCsmWgt = portFoilEstmCsmWgt;
		this.lnkDist = lnkDist;
		this.vpsEtdDt = vpsEtdDt;
		this.trndLineNo = trndLineNo;
		this.nxtGmt = nxtGmt;
		this.skdVoyNo = skdVoyNo;
		this.nxtEtaDt = nxtEtaDt;
		this.bseWk = bseWk;
		this.skdDirCd = skdDirCd;
		this.mnvrInHrs = mnvrInHrs;
		this.portSeq = portSeq;
		this.portDoilEstmCsmWgt = portDoilEstmCsmWgt;
		this.creUsrId = creUsrId;
		this.gmt = gmt;
		this.trndLineSeq = trndLineSeq;
		this.ydCd = ydCd;
		this.clptIndSeq = clptIndSeq;
		this.fcmEstmWrkDt = fcmEstmWrkDt;
		this.seaDoilEstmCsmWgt = seaDoilEstmCsmWgt;
		this.estmSeq = estmSeq;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("estm_skd_voy_no", getEstmSkdVoyNo());
		this.hashColumns.put("mnvr_out_hrs", getMnvrOutHrs());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("nxt_skd_dir_cd", getNxtSkdDirCd());
		this.hashColumns.put("sea_buf_hrs", getSeaBufHrs());
		this.hashColumns.put("nxt_skd_voy_no", getNxtSkdVoyNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sea_sail_spd", getSeaSailSpd());
		this.hashColumns.put("port_brth_hrs", getPortBrthHrs());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("estm_skd_dir_cd", getEstmSkdDirCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("nxt_port_cd", getNxtPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_yrmon", getBseYrmon());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("fcm_estm_wrk_seq", getFcmEstmWrkSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sea_foil_estm_csm_wgt", getSeaFoilEstmCsmWgt());
		this.hashColumns.put("sea_sail_hrs", getSeaSailHrs());
		this.hashColumns.put("nxt_mnvr_in_hrs", getNxtMnvrInHrs());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("port_foil_estm_csm_wgt", getPortFoilEstmCsmWgt());
		this.hashColumns.put("lnk_dist", getLnkDist());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("trnd_line_no", getTrndLineNo());
		this.hashColumns.put("nxt_gmt", getNxtGmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("nxt_eta_dt", getNxtEtaDt());
		this.hashColumns.put("bse_wk", getBseWk());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("mnvr_in_hrs", getMnvrInHrs());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("port_doil_estm_csm_wgt", getPortDoilEstmCsmWgt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("gmt", getGmt());
		this.hashColumns.put("trnd_line_seq", getTrndLineSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("fcm_estm_wrk_dt", getFcmEstmWrkDt());
		this.hashColumns.put("sea_doil_estm_csm_wgt", getSeaDoilEstmCsmWgt());
		this.hashColumns.put("estm_seq", getEstmSeq());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("estm_skd_voy_no", "estmSkdVoyNo");
		this.hashFields.put("mnvr_out_hrs", "mnvrOutHrs");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("nxt_skd_dir_cd", "nxtSkdDirCd");
		this.hashFields.put("sea_buf_hrs", "seaBufHrs");
		this.hashFields.put("nxt_skd_voy_no", "nxtSkdVoyNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sea_sail_spd", "seaSailSpd");
		this.hashFields.put("port_brth_hrs", "portBrthHrs");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("estm_skd_dir_cd", "estmSkdDirCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("nxt_port_cd", "nxtPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_yrmon", "bseYrmon");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("fcm_estm_wrk_seq", "fcmEstmWrkSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sea_foil_estm_csm_wgt", "seaFoilEstmCsmWgt");
		this.hashFields.put("sea_sail_hrs", "seaSailHrs");
		this.hashFields.put("nxt_mnvr_in_hrs", "nxtMnvrInHrs");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("port_foil_estm_csm_wgt", "portFoilEstmCsmWgt");
		this.hashFields.put("lnk_dist", "lnkDist");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("trnd_line_no", "trndLineNo");
		this.hashFields.put("nxt_gmt", "nxtGmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("nxt_eta_dt", "nxtEtaDt");
		this.hashFields.put("bse_wk", "bseWk");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("mnvr_in_hrs", "mnvrInHrs");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("port_doil_estm_csm_wgt", "portDoilEstmCsmWgt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("gmt", "gmt");
		this.hashFields.put("trnd_line_seq", "trndLineSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("fcm_estm_wrk_dt", "fcmEstmWrkDt");
		this.hashFields.put("sea_doil_estm_csm_wgt", "seaDoilEstmCsmWgt");
		this.hashFields.put("estm_seq", "estmSeq");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return estmSkdVoyNo
	 */
	public String getEstmSkdVoyNo() {
		return this.estmSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return mnvrOutHrs
	 */
	public String getMnvrOutHrs() {
		return this.mnvrOutHrs;
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
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return nxtSkdDirCd
	 */
	public String getNxtSkdDirCd() {
		return this.nxtSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return seaBufHrs
	 */
	public String getSeaBufHrs() {
		return this.seaBufHrs;
	}
	
	/**
	 * Column Info
	 * @return nxtSkdVoyNo
	 */
	public String getNxtSkdVoyNo() {
		return this.nxtSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return seaSailSpd
	 */
	public String getSeaSailSpd() {
		return this.seaSailSpd;
	}
	
	/**
	 * Column Info
	 * @return portBrthHrs
	 */
	public String getPortBrthHrs() {
		return this.portBrthHrs;
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
	 * @return estmSkdDirCd
	 */
	public String getEstmSkdDirCd() {
		return this.estmSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return nxtPortCd
	 */
	public String getNxtPortCd() {
		return this.nxtPortCd;
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
	 * @return bseYrmon
	 */
	public String getBseYrmon() {
		return this.bseYrmon;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return clptSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return fcmEstmWrkSeq
	 */
	public String getFcmEstmWrkSeq() {
		return this.fcmEstmWrkSeq;
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
	 * @return seaFoilEstmCsmWgt
	 */
	public String getSeaFoilEstmCsmWgt() {
		return this.seaFoilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return seaSailHrs
	 */
	public String getSeaSailHrs() {
		return this.seaSailHrs;
	}
	
	/**
	 * Column Info
	 * @return nxtMnvrInHrs
	 */
	public String getNxtMnvrInHrs() {
		return this.nxtMnvrInHrs;
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
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
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
	 * @return portFoilEstmCsmWgt
	 */
	public String getPortFoilEstmCsmWgt() {
		return this.portFoilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return lnkDist
	 */
	public String getLnkDist() {
		return this.lnkDist;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return trndLineNo
	 */
	public String getTrndLineNo() {
		return this.trndLineNo;
	}
	
	/**
	 * Column Info
	 * @return nxtGmt
	 */
	public String getNxtGmt() {
		return this.nxtGmt;
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
	 * @return nxtEtaDt
	 */
	public String getNxtEtaDt() {
		return this.nxtEtaDt;
	}
	
	/**
	 * Column Info
	 * @return bseWk
	 */
	public String getBseWk() {
		return this.bseWk;
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
	 * @return mnvrInHrs
	 */
	public String getMnvrInHrs() {
		return this.mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return portDoilEstmCsmWgt
	 */
	public String getPortDoilEstmCsmWgt() {
		return this.portDoilEstmCsmWgt;
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
	 * @return gmt
	 */
	public String getGmt() {
		return this.gmt;
	}
	
	/**
	 * Column Info
	 * @return trndLineSeq
	 */
	public String getTrndLineSeq() {
		return this.trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return fcmEstmWrkDt
	 */
	public String getFcmEstmWrkDt() {
		return this.fcmEstmWrkDt;
	}
	
	/**
	 * Column Info
	 * @return seaDoilEstmCsmWgt
	 */
	public String getSeaDoilEstmCsmWgt() {
		return this.seaDoilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @return estmSeq
	 */
	public String getEstmSeq() {
		return this.estmSeq;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param estmSkdVoyNo
	 */
	public void setEstmSkdVoyNo(String estmSkdVoyNo) {
		this.estmSkdVoyNo = estmSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param mnvrOutHrs
	 */
	public void setMnvrOutHrs(String mnvrOutHrs) {
		this.mnvrOutHrs = mnvrOutHrs;
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
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param nxtSkdDirCd
	 */
	public void setNxtSkdDirCd(String nxtSkdDirCd) {
		this.nxtSkdDirCd = nxtSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param seaBufHrs
	 */
	public void setSeaBufHrs(String seaBufHrs) {
		this.seaBufHrs = seaBufHrs;
	}
	
	/**
	 * Column Info
	 * @param nxtSkdVoyNo
	 */
	public void setNxtSkdVoyNo(String nxtSkdVoyNo) {
		this.nxtSkdVoyNo = nxtSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param seaSailSpd
	 */
	public void setSeaSailSpd(String seaSailSpd) {
		this.seaSailSpd = seaSailSpd;
	}
	
	/**
	 * Column Info
	 * @param portBrthHrs
	 */
	public void setPortBrthHrs(String portBrthHrs) {
		this.portBrthHrs = portBrthHrs;
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
	 * @param estmSkdDirCd
	 */
	public void setEstmSkdDirCd(String estmSkdDirCd) {
		this.estmSkdDirCd = estmSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param nxtPortCd
	 */
	public void setNxtPortCd(String nxtPortCd) {
		this.nxtPortCd = nxtPortCd;
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
	 * @param bseYrmon
	 */
	public void setBseYrmon(String bseYrmon) {
		this.bseYrmon = bseYrmon;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param clptSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param fcmEstmWrkSeq
	 */
	public void setFcmEstmWrkSeq(String fcmEstmWrkSeq) {
		this.fcmEstmWrkSeq = fcmEstmWrkSeq;
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
	 * @param seaFoilEstmCsmWgt
	 */
	public void setSeaFoilEstmCsmWgt(String seaFoilEstmCsmWgt) {
		this.seaFoilEstmCsmWgt = seaFoilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param seaSailHrs
	 */
	public void setSeaSailHrs(String seaSailHrs) {
		this.seaSailHrs = seaSailHrs;
	}
	
	/**
	 * Column Info
	 * @param nxtMnvrInHrs
	 */
	public void setNxtMnvrInHrs(String nxtMnvrInHrs) {
		this.nxtMnvrInHrs = nxtMnvrInHrs;
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
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
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
	 * @param portFoilEstmCsmWgt
	 */
	public void setPortFoilEstmCsmWgt(String portFoilEstmCsmWgt) {
		this.portFoilEstmCsmWgt = portFoilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param lnkDist
	 */
	public void setLnkDist(String lnkDist) {
		this.lnkDist = lnkDist;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param trndLineNo
	 */
	public void setTrndLineNo(String trndLineNo) {
		this.trndLineNo = trndLineNo;
	}
	
	/**
	 * Column Info
	 * @param nxtGmt
	 */
	public void setNxtGmt(String nxtGmt) {
		this.nxtGmt = nxtGmt;
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
	 * @param nxtEtaDt
	 */
	public void setNxtEtaDt(String nxtEtaDt) {
		this.nxtEtaDt = nxtEtaDt;
	}
	
	/**
	 * Column Info
	 * @param bseWk
	 */
	public void setBseWk(String bseWk) {
		this.bseWk = bseWk;
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
	 * @param mnvrInHrs
	 */
	public void setMnvrInHrs(String mnvrInHrs) {
		this.mnvrInHrs = mnvrInHrs;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param portDoilEstmCsmWgt
	 */
	public void setPortDoilEstmCsmWgt(String portDoilEstmCsmWgt) {
		this.portDoilEstmCsmWgt = portDoilEstmCsmWgt;
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
	 * @param gmt
	 */
	public void setGmt(String gmt) {
		this.gmt = gmt;
	}
	
	/**
	 * Column Info
	 * @param trndLineSeq
	 */
	public void setTrndLineSeq(String trndLineSeq) {
		this.trndLineSeq = trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param fcmEstmWrkDt
	 */
	public void setFcmEstmWrkDt(String fcmEstmWrkDt) {
		this.fcmEstmWrkDt = fcmEstmWrkDt;
	}
	
	/**
	 * Column Info
	 * @param seaDoilEstmCsmWgt
	 */
	public void setSeaDoilEstmCsmWgt(String seaDoilEstmCsmWgt) {
		this.seaDoilEstmCsmWgt = seaDoilEstmCsmWgt;
	}
	
	/**
	 * Column Info
	 * @param estmSeq
	 */
	public void setEstmSeq(String estmSeq) {
		this.estmSeq = estmSeq;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setEstmSkdVoyNo(JSPUtil.getParameter(request, prefix + "estm_skd_voy_no", ""));
		setMnvrOutHrs(JSPUtil.getParameter(request, prefix + "mnvr_out_hrs", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, prefix + "vps_etb_dt", ""));
		setNxtSkdDirCd(JSPUtil.getParameter(request, prefix + "nxt_skd_dir_cd", ""));
		setSeaBufHrs(JSPUtil.getParameter(request, prefix + "sea_buf_hrs", ""));
		setNxtSkdVoyNo(JSPUtil.getParameter(request, prefix + "nxt_skd_voy_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSeaSailSpd(JSPUtil.getParameter(request, prefix + "sea_sail_spd", ""));
		setPortBrthHrs(JSPUtil.getParameter(request, prefix + "port_brth_hrs", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setEstmSkdDirCd(JSPUtil.getParameter(request, prefix + "estm_skd_dir_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setNxtPortCd(JSPUtil.getParameter(request, prefix + "nxt_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBseYrmon(JSPUtil.getParameter(request, prefix + "bse_yrmon", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, prefix + "clpt_seq", ""));
		setFcmEstmWrkSeq(JSPUtil.getParameter(request, prefix + "fcm_estm_wrk_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSeaFoilEstmCsmWgt(JSPUtil.getParameter(request, prefix + "sea_foil_estm_csm_wgt", ""));
		setSeaSailHrs(JSPUtil.getParameter(request, prefix + "sea_sail_hrs", ""));
		setNxtMnvrInHrs(JSPUtil.getParameter(request, prefix + "nxt_mnvr_in_hrs", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVvdSeq(JSPUtil.getParameter(request, prefix + "vvd_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPortFoilEstmCsmWgt(JSPUtil.getParameter(request, prefix + "port_foil_estm_csm_wgt", ""));
		setLnkDist(JSPUtil.getParameter(request, prefix + "lnk_dist", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setTrndLineNo(JSPUtil.getParameter(request, prefix + "trnd_line_no", ""));
		setNxtGmt(JSPUtil.getParameter(request, prefix + "nxt_gmt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setNxtEtaDt(JSPUtil.getParameter(request, prefix + "nxt_eta_dt", ""));
		setBseWk(JSPUtil.getParameter(request, prefix + "bse_wk", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setMnvrInHrs(JSPUtil.getParameter(request, prefix + "mnvr_in_hrs", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setPortDoilEstmCsmWgt(JSPUtil.getParameter(request, prefix + "port_doil_estm_csm_wgt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setGmt(JSPUtil.getParameter(request, prefix + "gmt", ""));
		setTrndLineSeq(JSPUtil.getParameter(request, prefix + "trnd_line_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setFcmEstmWrkDt(JSPUtil.getParameter(request, prefix + "fcm_estm_wrk_dt", ""));
		setSeaDoilEstmCsmWgt(JSPUtil.getParameter(request, prefix + "sea_doil_estm_csm_wgt", ""));
		setEstmSeq(JSPUtil.getParameter(request, prefix + "estm_seq", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmEstmWkCsmDtlVO[]
	 */
	public FcmEstmWkCsmDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmEstmWkCsmDtlVO[]
	 */
	public FcmEstmWkCsmDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmEstmWkCsmDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] estmSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "estm_skd_voy_no", length));
			String[] mnvrOutHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_out_hrs", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] nxtSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "nxt_skd_dir_cd", length));
			String[] seaBufHrs = (JSPUtil.getParameter(request, prefix	+ "sea_buf_hrs", length));
			String[] nxtSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "nxt_skd_voy_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] seaSailSpd = (JSPUtil.getParameter(request, prefix	+ "sea_sail_spd", length));
			String[] portBrthHrs = (JSPUtil.getParameter(request, prefix	+ "port_brth_hrs", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] estmSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "estm_skd_dir_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] nxtPortCd = (JSPUtil.getParameter(request, prefix	+ "nxt_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseYrmon = (JSPUtil.getParameter(request, prefix	+ "bse_yrmon", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] fcmEstmWrkSeq = (JSPUtil.getParameter(request, prefix	+ "fcm_estm_wrk_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] seaFoilEstmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sea_foil_estm_csm_wgt", length));
			String[] seaSailHrs = (JSPUtil.getParameter(request, prefix	+ "sea_sail_hrs", length));
			String[] nxtMnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "nxt_mnvr_in_hrs", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] portFoilEstmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "port_foil_estm_csm_wgt", length));
			String[] lnkDist = (JSPUtil.getParameter(request, prefix	+ "lnk_dist", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] trndLineNo = (JSPUtil.getParameter(request, prefix	+ "trnd_line_no", length));
			String[] nxtGmt = (JSPUtil.getParameter(request, prefix	+ "nxt_gmt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] nxtEtaDt = (JSPUtil.getParameter(request, prefix	+ "nxt_eta_dt", length));
			String[] bseWk = (JSPUtil.getParameter(request, prefix	+ "bse_wk", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] mnvrInHrs = (JSPUtil.getParameter(request, prefix	+ "mnvr_in_hrs", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] portDoilEstmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "port_doil_estm_csm_wgt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] gmt = (JSPUtil.getParameter(request, prefix	+ "gmt", length));
			String[] trndLineSeq = (JSPUtil.getParameter(request, prefix	+ "trnd_line_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] fcmEstmWrkDt = (JSPUtil.getParameter(request, prefix	+ "fcm_estm_wrk_dt", length));
			String[] seaDoilEstmCsmWgt = (JSPUtil.getParameter(request, prefix	+ "sea_doil_estm_csm_wgt", length));
			String[] estmSeq = (JSPUtil.getParameter(request, prefix	+ "estm_seq", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmEstmWkCsmDtlVO();
				if (estmSkdVoyNo[i] != null)
					model.setEstmSkdVoyNo(estmSkdVoyNo[i]);
				if (mnvrOutHrs[i] != null)
					model.setMnvrOutHrs(mnvrOutHrs[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (nxtSkdDirCd[i] != null)
					model.setNxtSkdDirCd(nxtSkdDirCd[i]);
				if (seaBufHrs[i] != null)
					model.setSeaBufHrs(seaBufHrs[i]);
				if (nxtSkdVoyNo[i] != null)
					model.setNxtSkdVoyNo(nxtSkdVoyNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (seaSailSpd[i] != null)
					model.setSeaSailSpd(seaSailSpd[i]);
				if (portBrthHrs[i] != null)
					model.setPortBrthHrs(portBrthHrs[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (estmSkdDirCd[i] != null)
					model.setEstmSkdDirCd(estmSkdDirCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (nxtPortCd[i] != null)
					model.setNxtPortCd(nxtPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseYrmon[i] != null)
					model.setBseYrmon(bseYrmon[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (fcmEstmWrkSeq[i] != null)
					model.setFcmEstmWrkSeq(fcmEstmWrkSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (seaFoilEstmCsmWgt[i] != null)
					model.setSeaFoilEstmCsmWgt(seaFoilEstmCsmWgt[i]);
				if (seaSailHrs[i] != null)
					model.setSeaSailHrs(seaSailHrs[i]);
				if (nxtMnvrInHrs[i] != null)
					model.setNxtMnvrInHrs(nxtMnvrInHrs[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (portFoilEstmCsmWgt[i] != null)
					model.setPortFoilEstmCsmWgt(portFoilEstmCsmWgt[i]);
				if (lnkDist[i] != null)
					model.setLnkDist(lnkDist[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (trndLineNo[i] != null)
					model.setTrndLineNo(trndLineNo[i]);
				if (nxtGmt[i] != null)
					model.setNxtGmt(nxtGmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (nxtEtaDt[i] != null)
					model.setNxtEtaDt(nxtEtaDt[i]);
				if (bseWk[i] != null)
					model.setBseWk(bseWk[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (mnvrInHrs[i] != null)
					model.setMnvrInHrs(mnvrInHrs[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (portDoilEstmCsmWgt[i] != null)
					model.setPortDoilEstmCsmWgt(portDoilEstmCsmWgt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (gmt[i] != null)
					model.setGmt(gmt[i]);
				if (trndLineSeq[i] != null)
					model.setTrndLineSeq(trndLineSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (fcmEstmWrkDt[i] != null)
					model.setFcmEstmWrkDt(fcmEstmWrkDt[i]);
				if (seaDoilEstmCsmWgt[i] != null)
					model.setSeaDoilEstmCsmWgt(seaDoilEstmCsmWgt[i]);
				if (estmSeq[i] != null)
					model.setEstmSeq(estmSeq[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmEstmWkCsmDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmEstmWkCsmDtlVO[]
	 */
	public FcmEstmWkCsmDtlVO[] getFcmEstmWkCsmDtlVOs(){
		FcmEstmWkCsmDtlVO[] vos = (FcmEstmWkCsmDtlVO[])models.toArray(new FcmEstmWkCsmDtlVO[models.size()]);
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
		this.estmSkdVoyNo = this.estmSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrOutHrs = this.mnvrOutHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtSkdDirCd = this.nxtSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaBufHrs = this.seaBufHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtSkdVoyNo = this.nxtSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaSailSpd = this.seaSailSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBrthHrs = this.portBrthHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSkdDirCd = this.estmSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPortCd = this.nxtPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYrmon = this.bseYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmEstmWrkSeq = this.fcmEstmWrkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaFoilEstmCsmWgt = this.seaFoilEstmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaSailHrs = this.seaSailHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtMnvrInHrs = this.nxtMnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portFoilEstmCsmWgt = this.portFoilEstmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lnkDist = this.lnkDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineNo = this.trndLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtGmt = this.nxtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtEtaDt = this.nxtEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseWk = this.bseWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnvrInHrs = this.mnvrInHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDoilEstmCsmWgt = this.portDoilEstmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmt = this.gmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineSeq = this.trndLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcmEstmWrkDt = this.fcmEstmWrkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDoilEstmCsmWgt = this.seaDoilEstmCsmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmSeq = this.estmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
