/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : opfPrnrEdiCgoBkgFcastVO.java
*@FileTitle : opfPrnrEdiCgoBkgFcastVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class OpfPrnrEdiCgoBkgFcastVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfPrnrEdiCgoBkgFcastVO> models = new ArrayList<OpfPrnrEdiCgoBkgFcastVO>();
	
	/* Column Info */
	private String ediRcvDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String isoCntrTpszCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String crrNm = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lfSdOvrDimLen = null;
	/* Column Info */
	private String ediPodCd = null;
	/* Column Info */
	private String cntrWgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fwrdOvrDimLen = null;
	/* Column Info */
	private String prctFlg = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ediSndId = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String ediBlNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ediSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String hgtOvrDimLen = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ttlWgt = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String rtSdOvrDimLen = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ediPolYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediVslNm = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String upldDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cbfRmk = null;
	/* Column Info */
	private String mtyBkgFlg = null;
	/* Column Info */
	private String bkwdOvrDimLen = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String stwgCgoFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String crnPstStsCd = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfPrnrEdiCgoBkgFcastVO() {}

	public OpfPrnrEdiCgoBkgFcastVO(String ibflag, String pagerows, String ediRcvDt, String ediSndId, String ediSeq, String ediPolYdCd, String crrNm, String ediVslNm, String ediPodCd, String isoCntrTpszCd, String etaDt, String etdDt, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String polClptIndSeq, String crrCd, String podCd, String ediBlNo, String cntrNo, String cntrTpszCd, String ttlWgt, String cntrWgtUtCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String stwgCgoFlg, String mtyBkgFlg, String crnPstStsCd, String imdgUnNo, String imdgClssCd, String mrnPolutFlg, String stwgCd, String fwrdOvrDimLen, String bkwdOvrDimLen, String hgtOvrDimLen, String lfSdOvrDimLen, String rtSdOvrDimLen, String imdgLmtQtyFlg, String imdgSubsRskLblCd, String prctFlg, String imdgPckGrpCd, String cbfRmk, String upldDt, String creUsrId, String creDt, String updUsrId, String updDt, String vgmWgt, String vgmWgtUtCd) {
		this.ediRcvDt = ediRcvDt;
		this.vslCd = vslCd;
		this.isoCntrTpszCd = isoCntrTpszCd;
		this.etaDt = etaDt;
		this.crrNm = crrNm;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.lfSdOvrDimLen = lfSdOvrDimLen;
		this.ediPodCd = ediPodCd;
		this.cntrWgtUtCd = cntrWgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.fwrdOvrDimLen = fwrdOvrDimLen;
		this.prctFlg = prctFlg;
		this.polClptIndSeq = polClptIndSeq;
		this.stwgCd = stwgCd;
		this.mrnPolutFlg = mrnPolutFlg;
		this.imdgUnNo = imdgUnNo;
		this.updUsrId = updUsrId;
		this.ediSndId = ediSndId;
		this.awkCgoFlg = awkCgoFlg;
		this.ediBlNo = ediBlNo;
		this.skdVoyNo = skdVoyNo;
		this.ediSeq = ediSeq;
		this.podCd = podCd;
		this.hgtOvrDimLen = hgtOvrDimLen;
		this.creUsrId = creUsrId;
		this.ttlWgt = ttlWgt;
		this.rcFlg = rcFlg;
		this.imdgClssCd = imdgClssCd;
		this.rtSdOvrDimLen = rtSdOvrDimLen;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.creDt = creDt;
		this.ediPolYdCd = ediPolYdCd;
		this.ibflag = ibflag;
		this.ediVslNm = ediVslNm;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.upldDt = upldDt;
		this.updDt = updDt;
		this.cbfRmk = cbfRmk;
		this.mtyBkgFlg = mtyBkgFlg;
		this.bkwdOvrDimLen = bkwdOvrDimLen;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.etdDt = etdDt;
		this.stwgCgoFlg = stwgCgoFlg;
		this.skdDirCd = skdDirCd;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.crnPstStsCd = crnPstStsCd;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
		this.vgmWgt        = vgmWgt;
		this.vgmWgtUtCd    = vgmWgtUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_rcv_dt", getEdiRcvDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("iso_cntr_tpsz_cd", getIsoCntrTpszCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("crr_nm", getCrrNm());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lf_sd_ovr_dim_len", getLfSdOvrDimLen());
		this.hashColumns.put("edi_pod_cd", getEdiPodCd());
		this.hashColumns.put("cntr_wgt_ut_cd", getCntrWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("fwrd_ovr_dim_len", getFwrdOvrDimLen());
		this.hashColumns.put("prct_flg", getPrctFlg());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("edi_snd_id", getEdiSndId());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("edi_bl_no", getEdiBlNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("edi_seq", getEdiSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("hgt_ovr_dim_len", getHgtOvrDimLen());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ttl_wgt", getTtlWgt());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("rt_sd_ovr_dim_len", getRtSdOvrDimLen());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("edi_pol_yd_cd", getEdiPolYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_vsl_nm", getEdiVslNm());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("upld_dt", getUpldDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cbf_rmk", getCbfRmk());
		this.hashColumns.put("mty_bkg_flg", getMtyBkgFlg());
		this.hashColumns.put("bkwd_ovr_dim_len", getBkwdOvrDimLen());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("stwg_cgo_flg", getStwgCgoFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("crn_pst_sts_cd", getCrnPstStsCd());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_rcv_dt", "ediRcvDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("iso_cntr_tpsz_cd", "isoCntrTpszCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("crr_nm", "crrNm");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lf_sd_ovr_dim_len", "lfSdOvrDimLen");
		this.hashFields.put("edi_pod_cd", "ediPodCd");
		this.hashFields.put("cntr_wgt_ut_cd", "cntrWgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("fwrd_ovr_dim_len", "fwrdOvrDimLen");
		this.hashFields.put("prct_flg", "prctFlg");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_snd_id", "ediSndId");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("edi_bl_no", "ediBlNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("edi_seq", "ediSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("hgt_ovr_dim_len", "hgtOvrDimLen");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ttl_wgt", "ttlWgt");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("rt_sd_ovr_dim_len", "rtSdOvrDimLen");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("edi_pol_yd_cd", "ediPolYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_vsl_nm", "ediVslNm");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("upld_dt", "upldDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cbf_rmk", "cbfRmk");
		this.hashFields.put("mty_bkg_flg", "mtyBkgFlg");
		this.hashFields.put("bkwd_ovr_dim_len", "bkwdOvrDimLen");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("stwg_cgo_flg", "stwgCgoFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("crn_pst_sts_cd", "crnPstStsCd");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ediRcvDt
	 */
	public String getEdiRcvDt() {
		return this.ediRcvDt;
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
	 * @return isoCntrTpszCd
	 */
	public String getIsoCntrTpszCd() {
		return this.isoCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return crrNm
	 */
	public String getCrrNm() {
		return this.crrNm;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return lfSdOvrDimLen
	 */
	public String getLfSdOvrDimLen() {
		return this.lfSdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @return ediPodCd
	 */
	public String getEdiPodCd() {
		return this.ediPodCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtUtCd
	 */
	public String getCntrWgtUtCd() {
		return this.cntrWgtUtCd;
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
	 * @return fwrdOvrDimLen
	 */
	public String getFwrdOvrDimLen() {
		return this.fwrdOvrDimLen;
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
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
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
	 * @return mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @return ediSndId
	 */
	public String getEdiSndId() {
		return this.ediSndId;
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
	 * @return ediBlNo
	 */
	public String getEdiBlNo() {
		return this.ediBlNo;
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
	 * @return ediSeq
	 */
	public String getEdiSeq() {
		return this.ediSeq;
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
	 * @return hgtOvrDimLen
	 */
	public String getHgtOvrDimLen() {
		return this.hgtOvrDimLen;
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
	 * @return ttlWgt
	 */
	public String getTtlWgt() {
		return this.ttlWgt;
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
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return rtSdOvrDimLen
	 */
	public String getRtSdOvrDimLen() {
		return this.rtSdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
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
	 * @return ediPolYdCd
	 */
	public String getEdiPolYdCd() {
		return this.ediPolYdCd;
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
	 * @return ediVslNm
	 */
	public String getEdiVslNm() {
		return this.ediVslNm;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return upldDt
	 */
	public String getUpldDt() {
		return this.upldDt;
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
	 * @return cbfRmk
	 */
	public String getCbfRmk() {
		return this.cbfRmk;
	}
	
	/**
	 * Column Info
	 * @return mtyBkgFlg
	 */
	public String getMtyBkgFlg() {
		return this.mtyBkgFlg;
	}
	
	/**
	 * Column Info
	 * @return bkwdOvrDimLen
	 */
	public String getBkwdOvrDimLen() {
		return this.bkwdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return this.imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return stwgCgoFlg
	 */
	public String getStwgCgoFlg() {
		return this.stwgCgoFlg;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return crnPstStsCd
	 */
	public String getCrnPstStsCd() {
		return this.crnPstStsCd;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
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
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
	}
	

	/**
	 * Column Info
	 * @param ediRcvDt
	 */
	public void setEdiRcvDt(String ediRcvDt) {
		this.ediRcvDt = ediRcvDt;
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
	 * @param isoCntrTpszCd
	 */
	public void setIsoCntrTpszCd(String isoCntrTpszCd) {
		this.isoCntrTpszCd = isoCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param crrNm
	 */
	public void setCrrNm(String crrNm) {
		this.crrNm = crrNm;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param lfSdOvrDimLen
	 */
	public void setLfSdOvrDimLen(String lfSdOvrDimLen) {
		this.lfSdOvrDimLen = lfSdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @param ediPodCd
	 */
	public void setEdiPodCd(String ediPodCd) {
		this.ediPodCd = ediPodCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtUtCd
	 */
	public void setCntrWgtUtCd(String cntrWgtUtCd) {
		this.cntrWgtUtCd = cntrWgtUtCd;
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
	 * @param fwrdOvrDimLen
	 */
	public void setFwrdOvrDimLen(String fwrdOvrDimLen) {
		this.fwrdOvrDimLen = fwrdOvrDimLen;
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
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
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
	 * @param mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
	 * @param ediSndId
	 */
	public void setEdiSndId(String ediSndId) {
		this.ediSndId = ediSndId;
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
	 * @param ediBlNo
	 */
	public void setEdiBlNo(String ediBlNo) {
		this.ediBlNo = ediBlNo;
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
	 * @param ediSeq
	 */
	public void setEdiSeq(String ediSeq) {
		this.ediSeq = ediSeq;
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
	 * @param hgtOvrDimLen
	 */
	public void setHgtOvrDimLen(String hgtOvrDimLen) {
		this.hgtOvrDimLen = hgtOvrDimLen;
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
	 * @param ttlWgt
	 */
	public void setTtlWgt(String ttlWgt) {
		this.ttlWgt = ttlWgt;
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
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param rtSdOvrDimLen
	 */
	public void setRtSdOvrDimLen(String rtSdOvrDimLen) {
		this.rtSdOvrDimLen = rtSdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
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
	 * @param ediPolYdCd
	 */
	public void setEdiPolYdCd(String ediPolYdCd) {
		this.ediPolYdCd = ediPolYdCd;
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
	 * @param ediVslNm
	 */
	public void setEdiVslNm(String ediVslNm) {
		this.ediVslNm = ediVslNm;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param upldDt
	 */
	public void setUpldDt(String upldDt) {
		this.upldDt = upldDt;
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
	 * @param cbfRmk
	 */
	public void setCbfRmk(String cbfRmk) {
		this.cbfRmk = cbfRmk;
	}
	
	/**
	 * Column Info
	 * @param mtyBkgFlg
	 */
	public void setMtyBkgFlg(String mtyBkgFlg) {
		this.mtyBkgFlg = mtyBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param bkwdOvrDimLen
	 */
	public void setBkwdOvrDimLen(String bkwdOvrDimLen) {
		this.bkwdOvrDimLen = bkwdOvrDimLen;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param stwgCgoFlg
	 */
	public void setStwgCgoFlg(String stwgCgoFlg) {
		this.stwgCgoFlg = stwgCgoFlg;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param crnPstStsCd
	 */
	public void setCrnPstStsCd(String crnPstStsCd) {
		this.crnPstStsCd = crnPstStsCd;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
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
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
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
		setEdiRcvDt(JSPUtil.getParameter(request, prefix + "edi_rcv_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIsoCntrTpszCd(JSPUtil.getParameter(request, prefix + "iso_cntr_tpsz_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setCrrNm(JSPUtil.getParameter(request, prefix + "crr_nm", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLfSdOvrDimLen(JSPUtil.getParameter(request, prefix + "lf_sd_ovr_dim_len", ""));
		setEdiPodCd(JSPUtil.getParameter(request, prefix + "edi_pod_cd", ""));
		setCntrWgtUtCd(JSPUtil.getParameter(request, prefix + "cntr_wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFwrdOvrDimLen(JSPUtil.getParameter(request, prefix + "fwrd_ovr_dim_len", ""));
		setPrctFlg(JSPUtil.getParameter(request, prefix + "prct_flg", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEdiSndId(JSPUtil.getParameter(request, prefix + "edi_snd_id", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setEdiBlNo(JSPUtil.getParameter(request, prefix + "edi_bl_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEdiSeq(JSPUtil.getParameter(request, prefix + "edi_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setHgtOvrDimLen(JSPUtil.getParameter(request, prefix + "hgt_ovr_dim_len", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTtlWgt(JSPUtil.getParameter(request, prefix + "ttl_wgt", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setRtSdOvrDimLen(JSPUtil.getParameter(request, prefix + "rt_sd_ovr_dim_len", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEdiPolYdCd(JSPUtil.getParameter(request, prefix + "edi_pol_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiVslNm(JSPUtil.getParameter(request, prefix + "edi_vsl_nm", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setUpldDt(JSPUtil.getParameter(request, prefix + "upld_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCbfRmk(JSPUtil.getParameter(request, prefix + "cbf_rmk", ""));
		setMtyBkgFlg(JSPUtil.getParameter(request, prefix + "mty_bkg_flg", ""));
		setBkwdOvrDimLen(JSPUtil.getParameter(request, prefix + "bkwd_ovr_dim_len", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setStwgCgoFlg(JSPUtil.getParameter(request, prefix + "stwg_cgo_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCrnPstStsCd(JSPUtil.getParameter(request, prefix + "crn_pst_sts_cd", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TESTTESTVO[]
	 */
	public OpfPrnrEdiCgoBkgFcastVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TESTTESTVO[]
	 */
	public OpfPrnrEdiCgoBkgFcastVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfPrnrEdiCgoBkgFcastVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] isoCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "iso_cntr_tpsz_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] crrNm = (JSPUtil.getParameter(request, prefix	+ "crr_nm", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lfSdOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "lf_sd_ovr_dim_len", length));
			String[] ediPodCd = (JSPUtil.getParameter(request, prefix	+ "edi_pod_cd", length));
			String[] cntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fwrdOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "fwrd_ovr_dim_len", length));
			String[] prctFlg = (JSPUtil.getParameter(request, prefix	+ "prct_flg", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediSndId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_id", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] ediBlNo = (JSPUtil.getParameter(request, prefix	+ "edi_bl_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ediSeq = (JSPUtil.getParameter(request, prefix	+ "edi_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] hgtOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "hgt_ovr_dim_len", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ttlWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] rtSdOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "rt_sd_ovr_dim_len", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ediPolYdCd = (JSPUtil.getParameter(request, prefix	+ "edi_pol_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediVslNm = (JSPUtil.getParameter(request, prefix	+ "edi_vsl_nm", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] upldDt = (JSPUtil.getParameter(request, prefix	+ "upld_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cbfRmk = (JSPUtil.getParameter(request, prefix	+ "cbf_rmk", length));
			String[] mtyBkgFlg = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_flg", length));
			String[] bkwdOvrDimLen = (JSPUtil.getParameter(request, prefix	+ "bkwd_ovr_dim_len", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] stwgCgoFlg = (JSPUtil.getParameter(request, prefix	+ "stwg_cgo_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] crnPstStsCd = (JSPUtil.getParameter(request, prefix	+ "crn_pst_sts_cd", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfPrnrEdiCgoBkgFcastVO();
				if (ediRcvDt[i] != null)
					model.setEdiRcvDt(ediRcvDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (isoCntrTpszCd[i] != null)
					model.setIsoCntrTpszCd(isoCntrTpszCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (crrNm[i] != null)
					model.setCrrNm(crrNm[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lfSdOvrDimLen[i] != null)
					model.setLfSdOvrDimLen(lfSdOvrDimLen[i]);
				if (ediPodCd[i] != null)
					model.setEdiPodCd(ediPodCd[i]);
				if (cntrWgtUtCd[i] != null)
					model.setCntrWgtUtCd(cntrWgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fwrdOvrDimLen[i] != null)
					model.setFwrdOvrDimLen(fwrdOvrDimLen[i]);
				if (prctFlg[i] != null)
					model.setPrctFlg(prctFlg[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediSndId[i] != null)
					model.setEdiSndId(ediSndId[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (ediBlNo[i] != null)
					model.setEdiBlNo(ediBlNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ediSeq[i] != null)
					model.setEdiSeq(ediSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (hgtOvrDimLen[i] != null)
					model.setHgtOvrDimLen(hgtOvrDimLen[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ttlWgt[i] != null)
					model.setTtlWgt(ttlWgt[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (rtSdOvrDimLen[i] != null)
					model.setRtSdOvrDimLen(rtSdOvrDimLen[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ediPolYdCd[i] != null)
					model.setEdiPolYdCd(ediPolYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediVslNm[i] != null)
					model.setEdiVslNm(ediVslNm[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (upldDt[i] != null)
					model.setUpldDt(upldDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cbfRmk[i] != null)
					model.setCbfRmk(cbfRmk[i]);
				if (mtyBkgFlg[i] != null)
					model.setMtyBkgFlg(mtyBkgFlg[i]);
				if (bkwdOvrDimLen[i] != null)
					model.setBkwdOvrDimLen(bkwdOvrDimLen[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (stwgCgoFlg[i] != null)
					model.setStwgCgoFlg(stwgCgoFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (crnPstStsCd[i] != null)
					model.setCrnPstStsCd(crnPstStsCd[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTESTTESTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TESTTESTVO[]
	 */
	public OpfPrnrEdiCgoBkgFcastVO[] getTESTTESTVOs(){
		OpfPrnrEdiCgoBkgFcastVO[] vos = (OpfPrnrEdiCgoBkgFcastVO[])models.toArray(new OpfPrnrEdiCgoBkgFcastVO[models.size()]);
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
		this.ediRcvDt = this.ediRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isoCntrTpszCd = this.isoCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrNm = this.crrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lfSdOvrDimLen = this.lfSdOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediPodCd = this.ediPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUtCd = this.cntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdOvrDimLen = this.fwrdOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prctFlg = this.prctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndId = this.ediSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediBlNo = this.ediBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSeq = this.ediSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hgtOvrDimLen = this.hgtOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgt = this.ttlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSdOvrDimLen = this.rtSdOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediPolYdCd = this.ediPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVslNm = this.ediVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upldDt = this.upldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbfRmk = this.cbfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgFlg = this.mtyBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkwdOvrDimLen = this.bkwdOvrDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCgoFlg = this.stwgCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnPstStsCd = this.crnPstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
