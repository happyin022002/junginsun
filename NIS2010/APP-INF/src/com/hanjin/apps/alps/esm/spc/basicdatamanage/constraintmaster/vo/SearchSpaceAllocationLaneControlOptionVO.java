/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchSpaceAllocationLaneControlOptionVO.java
*@FileTitle : SearchSpaceAllocationLaneControlOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo;

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

public class SearchSpaceAllocationLaneControlOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocationLaneControlOptionVO> models = new ArrayList<SearchSpaceAllocationLaneControlOptionVO>();
	
	/* Column Info */
	private String alocCtrlTpCd = null;
	/* Column Info */
	private String bkgCtrlAlocFcastFlg = null;
	/* Column Info */
	private String ctrlPortFlg = null;
	/* Column Info */
	private String bkgCtrlMstTblFcastRto = null;
	/* Column Info */
	private String ctrlLocFlg = null;
	/* Column Info */
	private String bkgCtrlMstTblAplyFlg = null;
	/* Column Info */
	private String ctrl40ftHcFlg = null;
	/* Column Info */
	private String alocCtrlDtlCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String ctrlDestLvlCd = null;
	/* Page Number */
	private String pagerows = null;
//	/* Column Info */
//	private String bkgCtrlAlocFlg = null;
//	/* Column Info */
//	private String bkgCtrlFcstFlg = null;
	/* Column Info */
	private String ctrtNm = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrlLvlCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String aplyToYrwk = null;
	/* Column Info */
	private String ctrlUsaSvcModFlg = null;
//	/* Column Info */
//	private String bkgCtrlAcctGrpFlg = null;
	/* Column Info */
	private String aplyFmYrwk = null;
	/* Column Info */
	private String bkgCtrlAcctGrpRto = null;
	/* Column Info */
	private String bkgCtrlAlocFcastRto = null;
	/* Column Info */
	private String bkgCtrlAlocAplyFlg = null;
	/* Column Info */
	private String ctrlFxRtFlg = null;
	/* Column Info */
	private String ctrl53ftFlg = null;
	/* Column Info */
	private String isUpload = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String bkgCtrlAcctGrpAplyFlg = null;
	/* Column Info */
	private String rdFlg = null;
	/* Column Info */
	private String ctrlWgtFlg = null;
	/* Column Info */
	private String ctrlAcctFlg = null;
	/* Column Info */
	private String ctrlEccFlg = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrlRdFlg = null;
	/* Column Info */
	private String ctrlRfFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String ctrlLocAcctCd = null;
	/* Column Info */
	private String bkgCtrlAcctGrpFcastFlg = null;
	/* Column Info */
	private String ctrlD2Flg = null;
	/* Column Info */
	private String tmpAcctFlg = null;
	/* Column Info */
	private String ctrlEccGrpFlg = null;
	/* Column Info */
	private String tmpToYrwk = null;
	/* Column Info */
	private String acctGrpCtrlFlg = null;
	/* Column Info */
	private String hhFlg = null;
	/* Column Info */
	private String ctrl45ftHcFlg = null;
//	/* Column Info */
//	private String bkgCtrlFcstRto = null;
	/* Column Info */
	private String ofcCd = null;
//	/* Column Info */
//	private String bkgCtrlMstFlg = null;
	/* Column Info */
	private String tmpFmYrwk = null;
	/* Column Info */
	private String ctrlD4Flg = null;
	/* Column Info */
	private String bkgCtrlMstTblFcastFlg = null;
//	/* Column Info */
//	private String bkgCtrlAplyFlg = null;
	/* Column Info*/
	private String bkgCtrlFcastFmYrwk = null;
	private String bkgCtrlAlocTpCd = null;  
	private String bkgCtrlAcctGrpTpCd = null; 
	/* Column Info */
	private String bkgCtrlLaneFlg = null;
	/* Column Info */
	private String bkgCtrlLaneUpdFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpaceAllocationLaneControlOptionVO() {}

	public SearchSpaceAllocationLaneControlOptionVO(String ibflag, String pagerows, String alocCtrlTpCd, String bkgCtrlAlocFcastFlg, String ctrlPortFlg, String bkgCtrlMstTblFcastRto, String ctrlLocFlg, String bkgCtrlMstTblAplyFlg, String ctrl40ftHcFlg, String alocCtrlDtlCd, String trdCd, String rlaneCd, String ctrlDestLvlCd, String scNo, String ctrtNm, String ctrlLvlCd, String aplyToYrwk, String updUsrId, String ctrlUsaSvcModFlg, String aplyFmYrwk, String bkgCtrlAcctGrpRto, String bkgCtrlAlocFcastRto, String bkgCtrlAlocAplyFlg, String ctrl53ftFlg, String isUpload, String subTrdCd, String acctNm, String bkgCtrlAcctGrpAplyFlg, String rdFlg, String ctrlWgtFlg, String ctrlAcctFlg, String ctrlEccFlg, String rfaNo, String ctrlRdFlg, String ctrlRfFlg, String dirCd, String ctrlLocAcctCd, String bkgCtrlAcctGrpFcastFlg, String ctrlD2Flg, String tmpAcctFlg, String ctrlEccGrpFlg, String tmpToYrwk, String acctGrpCtrlFlg, String hhFlg, String ctrl45ftHcFlg, String ofcCd, String ctrlD4Flg, String tmpFmYrwk, String bkgCtrlMstTblFcastFlg, String ctrlFxRtFlg, String bkgCtrlFcastFmYrwk, String bkgCtrlAlocTpCd ,String bkgCtrlAcctGrpTpCd, String bkgCtrlLaneFlg, String bkgCtrlLaneUpdFlg ) {
		this.alocCtrlTpCd = alocCtrlTpCd;
		this.bkgCtrlAlocFcastFlg = bkgCtrlAlocFcastFlg;
		this.ctrlPortFlg = ctrlPortFlg;
		this.bkgCtrlMstTblFcastRto = bkgCtrlMstTblFcastRto;
		this.ctrlLocFlg = ctrlLocFlg;
		this.bkgCtrlMstTblAplyFlg = bkgCtrlMstTblAplyFlg;
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
		this.alocCtrlDtlCd = alocCtrlDtlCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.ctrlDestLvlCd = ctrlDestLvlCd;
		this.pagerows = pagerows;
//		this.bkgCtrlAlocFlg = bkgCtrlAlocFlg;
//		this.bkgCtrlFcstFlg = bkgCtrlFcstFlg;
		this.ctrtNm = ctrtNm;
		this.scNo = scNo;
		this.ctrlLvlCd = ctrlLvlCd;
		this.updUsrId = updUsrId;
		this.aplyToYrwk = aplyToYrwk;
		this.ctrlUsaSvcModFlg = ctrlUsaSvcModFlg;
//		this.bkgCtrlAcctGrpFlg = bkgCtrlAcctGrpFlg;
		this.aplyFmYrwk = aplyFmYrwk;
		this.bkgCtrlAcctGrpRto = bkgCtrlAcctGrpRto;
		this.bkgCtrlAlocFcastRto = bkgCtrlAlocFcastRto;
		this.bkgCtrlAlocAplyFlg = bkgCtrlAlocAplyFlg;
		this.ctrlFxRtFlg = ctrlFxRtFlg;
		this.ctrl53ftFlg = ctrl53ftFlg;
		this.isUpload = isUpload;
		this.subTrdCd = subTrdCd;
		this.acctNm = acctNm;
		this.bkgCtrlAcctGrpAplyFlg = bkgCtrlAcctGrpAplyFlg;
		this.rdFlg = rdFlg;
		this.ctrlWgtFlg = ctrlWgtFlg;
		this.ctrlAcctFlg = ctrlAcctFlg;
		this.ctrlEccFlg = ctrlEccFlg;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.ctrlRdFlg = ctrlRdFlg;
		this.ctrlRfFlg = ctrlRfFlg;
		this.dirCd = dirCd;
		this.ctrlLocAcctCd = ctrlLocAcctCd;
		this.bkgCtrlAcctGrpFcastFlg = bkgCtrlAcctGrpFcastFlg;
		this.ctrlD2Flg = ctrlD2Flg;
		this.tmpAcctFlg = tmpAcctFlg;
		this.ctrlEccGrpFlg = ctrlEccGrpFlg;
		this.tmpToYrwk = tmpToYrwk;
		this.acctGrpCtrlFlg = acctGrpCtrlFlg;
		this.hhFlg = hhFlg;
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
//		this.bkgCtrlFcstRto = bkgCtrlFcstRto;
		this.ofcCd = ofcCd;
//		this.bkgCtrlMstFlg = bkgCtrlMstFlg;
		this.tmpFmYrwk = tmpFmYrwk;
		this.ctrlD4Flg = ctrlD4Flg;
		this.bkgCtrlMstTblFcastFlg = bkgCtrlMstTblFcastFlg;
//		this.bkgCtrlAplyFlg = bkgCtrlAplyFlg;
		this.bkgCtrlFcastFmYrwk = bkgCtrlFcastFmYrwk;
		this.bkgCtrlAlocTpCd=bkgCtrlAlocTpCd;
		this.bkgCtrlAcctGrpTpCd=bkgCtrlAcctGrpTpCd;
		this.bkgCtrlLaneFlg = bkgCtrlLaneFlg;
		this.bkgCtrlLaneUpdFlg = bkgCtrlLaneUpdFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aloc_ctrl_tp_cd", getAlocCtrlTpCd());
		this.hashColumns.put("bkg_ctrl_aloc_fcast_flg", getBkgCtrlAlocFcastFlg());
		this.hashColumns.put("ctrl_port_flg", getCtrlPortFlg());
		this.hashColumns.put("bkg_ctrl_mst_tbl_fcast_rto", getBkgCtrlMstTblFcastRto());
		this.hashColumns.put("ctrl_loc_flg", getCtrlLocFlg());
		this.hashColumns.put("bkg_ctrl_mst_tbl_aply_flg", getBkgCtrlMstTblAplyFlg());
		this.hashColumns.put("ctrl_40ft_hc_flg", getCtrl40ftHcFlg());
		this.hashColumns.put("aloc_ctrl_dtl_cd", getAlocCtrlDtlCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ctrl_dest_lvl_cd", getCtrlDestLvlCd());
		this.hashColumns.put("pagerows", getPagerows());
//		this.hashColumns.put("bkg_ctrl_aloc_flg", getBkgCtrlAlocFlg());
//		this.hashColumns.put("bkg_ctrl_fcst_flg", getBkgCtrlFcstFlg());
		this.hashColumns.put("ctrt_nm", getCtrtNm());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrl_lvl_cd", getCtrlLvlCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("aply_to_yrwk", getAplyToYrwk());
		this.hashColumns.put("ctrl_usa_svc_mod_flg", getCtrlUsaSvcModFlg());
//		this.hashColumns.put("bkg_ctrl_acct_grp_flg", getBkgCtrlAcctGrpFlg());
		this.hashColumns.put("aply_fm_yrwk", getAplyFmYrwk());
		this.hashColumns.put("bkg_ctrl_acct_grp_rto", getBkgCtrlAcctGrpRto());
		this.hashColumns.put("bkg_ctrl_aloc_fcast_rto", getBkgCtrlAlocFcastRto());
		this.hashColumns.put("bkg_ctrl_aloc_aply_flg", getBkgCtrlAlocAplyFlg());
		this.hashColumns.put("ctrl_fx_rt_flg", getCtrlFxRtFlg());
		this.hashColumns.put("ctrl_53ft_flg", getCtrl53ftFlg());
		this.hashColumns.put("is_upload", getIsUpload());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("bkg_ctrl_acct_grp_aply_flg", getBkgCtrlAcctGrpAplyFlg());
		this.hashColumns.put("rd_flg", getRdFlg());
		this.hashColumns.put("ctrl_wgt_flg", getCtrlWgtFlg());
		this.hashColumns.put("ctrl_acct_flg", getCtrlAcctFlg());
		this.hashColumns.put("ctrl_ecc_flg", getCtrlEccFlg());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrl_rd_flg", getCtrlRdFlg());
		this.hashColumns.put("ctrl_rf_flg", getCtrlRfFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ctrl_loc_acct_cd", getCtrlLocAcctCd());
		this.hashColumns.put("bkg_ctrl_acct_grp_fcast_flg", getBkgCtrlAcctGrpFcastFlg());
		this.hashColumns.put("ctrl_d2_flg", getCtrlD2Flg());
		this.hashColumns.put("tmp_acct_flg", getTmpAcctFlg());
		this.hashColumns.put("ctrl_ecc_grp_flg", getCtrlEccGrpFlg());
		this.hashColumns.put("tmp_to_yrwk", getTmpToYrwk());
		this.hashColumns.put("acct_grp_ctrl_flg", getAcctGrpCtrlFlg());
		this.hashColumns.put("hh_flg", getHhFlg());
		this.hashColumns.put("ctrl_45ft_hc_flg", getCtrl45ftHcFlg());
//		this.hashColumns.put("bkg_ctrl_fcst_rto", getBkgCtrlFcstRto());
		this.hashColumns.put("ofc_cd", getOfcCd());
//		this.hashColumns.put("bkg_ctrl_mst_flg", getBkgCtrlMstFlg());
		this.hashColumns.put("tmp_fm_yrwk", getTmpFmYrwk());
		this.hashColumns.put("ctrl_d4_flg", getCtrlD4Flg());
		this.hashColumns.put("bkg_ctrl_mst_tbl_fcast_flg", getBkgCtrlMstTblFcastFlg());
//		this.hashColumns.put("bkg_ctrl_aply_flg", getBkgCtrlAplyFlg());
		this.hashColumns.put("bkg_ctrl_fcast_fm_yrwk", getBkgCtrlFcastFmYrwk());
		this.hashColumns.put("bkg_ctrl_aloc_tp_cd", getBkgCtrlAlocTpCd());
		this.hashColumns.put("bkg_ctrl_acct_grp_tp_cd", getBkgCtrlAcctGrpTpCd());
		this.hashColumns.put("bkg_ctrl_lane_flg", getBkgCtrlLaneFlg());
		this.hashColumns.put("bkg_ctrl_lane_upd_flg", getBkgCtrlLaneUpdFlg());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aloc_ctrl_tp_cd", "alocCtrlTpCd");
		this.hashFields.put("bkg_ctrl_aloc_fcast_flg", "bkgCtrlAlocFcastFlg");
		this.hashFields.put("ctrl_port_flg", "ctrlPortFlg");
		this.hashFields.put("bkg_ctrl_mst_tbl_fcast_rto", "bkgCtrlMstTblFcastRto");
		this.hashFields.put("ctrl_loc_flg", "ctrlLocFlg");
		this.hashFields.put("bkg_ctrl_mst_tbl_aply_flg", "bkgCtrlMstTblAplyFlg");
		this.hashFields.put("ctrl_40ft_hc_flg", "ctrl40ftHcFlg");
		this.hashFields.put("aloc_ctrl_dtl_cd", "alocCtrlDtlCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ctrl_dest_lvl_cd", "ctrlDestLvlCd");
		this.hashFields.put("pagerows", "pagerows");
//		this.hashFields.put("bkg_ctrl_aloc_flg", "bkgCtrlAlocFlg");
//		this.hashFields.put("bkg_ctrl_fcst_flg", "bkgCtrlFcstFlg");
		this.hashFields.put("ctrt_nm", "ctrtNm");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrl_lvl_cd", "ctrlLvlCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("aply_to_yrwk", "aplyToYrwk");
		this.hashFields.put("ctrl_usa_svc_mod_flg", "ctrlUsaSvcModFlg");
//		this.hashFields.put("bkg_ctrl_acct_grp_flg", "bkgCtrlAcctGrpFlg");
		this.hashFields.put("aply_fm_yrwk", "aplyFmYrwk");
		this.hashFields.put("bkg_ctrl_acct_grp_rto", "bkgCtrlAcctGrpRto");
		this.hashFields.put("bkg_ctrl_aloc_fcast_rto", "bkgCtrlAlocFcastRto");
		this.hashFields.put("bkg_ctrl_aloc_aply_flg", "bkgCtrlAlocAplyFlg");
		this.hashFields.put("ctrl_fx_rt_flg", "ctrlFxRtFlg");
		this.hashFields.put("ctrl_53ft_flg", "ctrl53ftFlg");
		this.hashFields.put("is_upload", "isUpload");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("bkg_ctrl_acct_grp_aply_flg", "bkgCtrlAcctGrpAplyFlg");
		this.hashFields.put("rd_flg", "rdFlg");
		this.hashFields.put("ctrl_wgt_flg", "ctrlWgtFlg");
		this.hashFields.put("ctrl_acct_flg", "ctrlAcctFlg");
		this.hashFields.put("ctrl_ecc_flg", "ctrlEccFlg");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrl_rd_flg", "ctrlRdFlg");
		this.hashFields.put("ctrl_rf_flg", "ctrlRfFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ctrl_loc_acct_cd", "ctrlLocAcctCd");
		this.hashFields.put("bkg_ctrl_acct_grp_fcast_flg", "bkgCtrlAcctGrpFcastFlg");
		this.hashFields.put("ctrl_d2_flg", "ctrlD2Flg");
		this.hashFields.put("tmp_acct_flg", "tmpAcctFlg");
		this.hashFields.put("ctrl_ecc_grp_flg", "ctrlEccGrpFlg");
		this.hashFields.put("tmp_to_yrwk", "tmpToYrwk");
		this.hashFields.put("acct_grp_ctrl_flg", "acctGrpCtrlFlg");
		this.hashFields.put("hh_flg", "hhFlg");
		this.hashFields.put("ctrl_45ft_hc_flg", "ctrl45ftHcFlg");
//		this.hashFields.put("bkg_ctrl_fcst_rto", "bkgCtrlFcstRto");
		this.hashFields.put("ofc_cd", "ofcCd");
//		this.hashFields.put("bkg_ctrl_mst_flg", "bkgCtrlMstFlg");
		this.hashFields.put("tmp_fm_yrwk", "tmpFmYrwk");
		this.hashFields.put("ctrl_d4_flg", "ctrlD4Flg");
		this.hashFields.put("bkg_ctrl_mst_tbl_fcast_flg", "bkgCtrlMstTblFcastFlg");
//		this.hashFields.put("bkg_ctrl_aply_flg", "bkgCtrlAplyFlg");
		this.hashFields.put("bkg_ctrl_fcast_fm_yrwk", "bkgCtrlFcastFmYrwk");
		this.hashFields.put("bkg_ctrl_aloc_tp_cd", "bkgCtrlAlocTpCd");
		this.hashFields.put("bkg_ctrl_acct_grp_tp_cd", "bkgCtrlAcctGrpTpCd");
		this.hashFields.put("bkg_ctrl_lane_flg", "bkgCtrlLaneFlg");
		this.hashFields.put("bkg_ctrl_lane_upd_flg", "bkgCtrlLaneUpdFlg");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return alocCtrlTpCd
	 */
	public String getAlocCtrlTpCd() {
		return this.alocCtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAlocFcastFlg
	 */
	public String getBkgCtrlAlocFcastFlg() {
		return this.bkgCtrlAlocFcastFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlPortFlg
	 */
	public String getCtrlPortFlg() {
		return this.ctrlPortFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlMstTblFcastRto
	 */
	public String getBkgCtrlMstTblFcastRto() {
		return this.bkgCtrlMstTblFcastRto;
	}
	
	/**
	 * Column Info
	 * @return ctrlLocFlg
	 */
	public String getCtrlLocFlg() {
		return this.ctrlLocFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlMstTblAplyFlg
	 */
	public String getBkgCtrlMstTblAplyFlg() {
		return this.bkgCtrlMstTblAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrl40ftHcFlg
	 */
	public String getCtrl40ftHcFlg() {
		return this.ctrl40ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @return alocCtrlDtlCd
	 */
	public String getAlocCtrlDtlCd() {
		return this.alocCtrlDtlCd;
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
	 * @return ctrlDestLvlCd
	 */
	public String getCtrlDestLvlCd() {
		return this.ctrlDestLvlCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
//	/**
//	 * Column Info
//	 * @return bkgCtrlAlocFlg
//	 */
//	public String getBkgCtrlAlocFlg() {
//		return this.bkgCtrlAlocFlg;
//	}
//	
//	/**
//	 * Column Info
//	 * @return bkgCtrlFcstFlg
//	 */
//	public String getBkgCtrlFcstFlg() {
//		return this.bkgCtrlFcstFlg;
//	}
	
	/**
	 * Column Info
	 * @return ctrtNm
	 */
	public String getCtrtNm() {
		return this.ctrtNm;
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
	 * @return ctrlLvlCd
	 */
	public String getCtrlLvlCd() {
		return this.ctrlLvlCd;
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
	 * @return aplyToYrwk
	 */
	public String getAplyToYrwk() {
		return this.aplyToYrwk;
	}
	
	/**
	 * Column Info
	 * @return ctrlUsaSvcModFlg
	 */
	public String getCtrlUsaSvcModFlg() {
		return this.ctrlUsaSvcModFlg;
	}
	
//	/**
//	 * Column Info
//	 * @return bkgCtrlAcctGrpFlg
//	 */
//	public String getBkgCtrlAcctGrpFlg() {
//		return this.bkgCtrlAcctGrpFlg;
//	}
	
	/**
	 * Column Info
	 * @return aplyFmYrwk
	 */
	public String getAplyFmYrwk() {
		return this.aplyFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAcctGrpRto
	 */
	public String getBkgCtrlAcctGrpRto() {
		return this.bkgCtrlAcctGrpRto;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAlocFcastRto
	 */
	public String getBkgCtrlAlocFcastRto() {
		return this.bkgCtrlAlocFcastRto;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAlocAplyFlg
	 */
	public String getBkgCtrlAlocAplyFlg() {
		return this.bkgCtrlAlocAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlFxRtFlg
	 */
	public String getCtrlFxRtFlg() {
		return this.ctrlFxRtFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrl53ftFlg
	 */
	public String getCtrl53ftFlg() {
		return this.ctrl53ftFlg;
	}
	
	/**
	 * Column Info
	 * @return isUpload
	 */
	public String getIsUpload() {
		return this.isUpload;
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
	 * @return acctNm
	 */
	public String getAcctNm() {
		return this.acctNm;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAcctGrpAplyFlg
	 */
	public String getBkgCtrlAcctGrpAplyFlg() {
		return this.bkgCtrlAcctGrpAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return rdFlg
	 */
	public String getRdFlg() {
		return this.rdFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlWgtFlg
	 */
	public String getCtrlWgtFlg() {
		return this.ctrlWgtFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlAcctFlg
	 */
	public String getCtrlAcctFlg() {
		return this.ctrlAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlEccFlg
	 */
	public String getCtrlEccFlg() {
		return this.ctrlEccFlg;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return ctrlRdFlg
	 */
	public String getCtrlRdFlg() {
		return this.ctrlRdFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlRfFlg
	 */
	public String getCtrlRfFlg() {
		return this.ctrlRfFlg;
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
	 * @return ctrlLocAcctCd
	 */
	public String getCtrlLocAcctCd() {
		return this.ctrlLocAcctCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAcctGrpFcastFlg
	 */
	public String getBkgCtrlAcctGrpFcastFlg() {
		return this.bkgCtrlAcctGrpFcastFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlD2Flg
	 */
	public String getCtrlD2Flg() {
		return this.ctrlD2Flg;
	}
	
	/**
	 * Column Info
	 * @return tmpAcctFlg
	 */
	public String getTmpAcctFlg() {
		return this.tmpAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlEccGrpFlg
	 */
	public String getCtrlEccGrpFlg() {
		return this.ctrlEccGrpFlg;
	}
	
	/**
	 * Column Info
	 * @return tmpToYrwk
	 */
	public String getTmpToYrwk() {
		return this.tmpToYrwk;
	}
	
	/**
	 * Column Info
	 * @return acctGrpCtrlFlg
	 */
	public String getAcctGrpCtrlFlg() {
		return this.acctGrpCtrlFlg;
	}
	
	/**
	 * Column Info
	 * @return hhFlg
	 */
	public String getHhFlg() {
		return this.hhFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrl45ftHcFlg
	 */
	public String getCtrl45ftHcFlg() {
		return this.ctrl45ftHcFlg;
	}
	
//	/**
//	 * Column Info
//	 * @return bkgCtrlFcstRto
//	 */
//	public String getBkgCtrlFcstRto() {
//		return this.bkgCtrlFcstRto;
//	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
//	/**
//	 * Column Info
//	 * @return bkgCtrlMstFlg
//	 */
//	public String getBkgCtrlMstFlg() {
//		return this.bkgCtrlMstFlg;
//	}
	
	/**
	 * Column Info
	 * @return tmpFmYrwk
	 */
	public String getTmpFmYrwk() {
		return this.tmpFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return ctrlD4Flg
	 */
	public String getCtrlD4Flg() {
		return this.ctrlD4Flg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlMstTblFcastFlg
	 */
	public String getBkgCtrlMstTblFcastFlg() {
		return this.bkgCtrlMstTblFcastFlg;
	}
	
//	/**
//	 * Column Info
//	 * @return bkgCtrlAplyFlg
//	 */
//	public String getBkgCtrlAplyFlg() {
//		return this.bkgCtrlAplyFlg;
//	}
	
	
	/**
	 * Column Info
	 * @return bkgCtrlFcastFmYrwk
	 */
	public String getBkgCtrlFcastFmYrwk() {
		return this.bkgCtrlFcastFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlLaneFlg
	 */
	public String getBkgCtrlLaneFlg() {
		return this.bkgCtrlLaneFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlLaneUpdFlg
	 */
	public String getBkgCtrlLaneUpdFlg() {
		return this.bkgCtrlLaneUpdFlg;
	}
	

	/**
	 * Column Info
	 * @param alocCtrlTpCd
	 */
	public void setAlocCtrlTpCd(String alocCtrlTpCd) {
		this.alocCtrlTpCd = alocCtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAlocFcastFlg
	 */
	public void setBkgCtrlAlocFcastFlg(String bkgCtrlAlocFcastFlg) {
		this.bkgCtrlAlocFcastFlg = bkgCtrlAlocFcastFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlPortFlg
	 */
	public void setCtrlPortFlg(String ctrlPortFlg) {
		this.ctrlPortFlg = ctrlPortFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlMstTblFcastRto
	 */
	public void setBkgCtrlMstTblFcastRto(String bkgCtrlMstTblFcastRto) {
		this.bkgCtrlMstTblFcastRto = bkgCtrlMstTblFcastRto;
	}
	
	/**
	 * Column Info
	 * @param ctrlLocFlg
	 */
	public void setCtrlLocFlg(String ctrlLocFlg) {
		this.ctrlLocFlg = ctrlLocFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlMstTblAplyFlg
	 */
	public void setBkgCtrlMstTblAplyFlg(String bkgCtrlMstTblAplyFlg) {
		this.bkgCtrlMstTblAplyFlg = bkgCtrlMstTblAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrl40ftHcFlg
	 */
	public void setCtrl40ftHcFlg(String ctrl40ftHcFlg) {
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @param alocCtrlDtlCd
	 */
	public void setAlocCtrlDtlCd(String alocCtrlDtlCd) {
		this.alocCtrlDtlCd = alocCtrlDtlCd;
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
	 * @param ctrlDestLvlCd
	 */
	public void setCtrlDestLvlCd(String ctrlDestLvlCd) {
		this.ctrlDestLvlCd = ctrlDestLvlCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
//	/**
//	 * Column Info
//	 * @param bkgCtrlAlocFlg
//	 */
//	public void setBkgCtrlAlocFlg(String bkgCtrlAlocFlg) {
//		this.bkgCtrlAlocFlg = bkgCtrlAlocFlg;
//	}
	
//	/**
//	 * Column Info
//	 * @param bkgCtrlFcstFlg
//	 */
//	public void setBkgCtrlFcstFlg(String bkgCtrlFcstFlg) {
//		this.bkgCtrlFcstFlg = bkgCtrlFcstFlg;
//	}
	
	/**
	 * Column Info
	 * @param ctrtNm
	 */
	public void setCtrtNm(String ctrtNm) {
		this.ctrtNm = ctrtNm;
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
	 * @param ctrlLvlCd
	 */
	public void setCtrlLvlCd(String ctrlLvlCd) {
		this.ctrlLvlCd = ctrlLvlCd;
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
	 * @param aplyToYrwk
	 */
	public void setAplyToYrwk(String aplyToYrwk) {
		this.aplyToYrwk = aplyToYrwk;
	}
	
	/**
	 * Column Info
	 * @param ctrlUsaSvcModFlg
	 */
	public void setCtrlUsaSvcModFlg(String ctrlUsaSvcModFlg) {
		this.ctrlUsaSvcModFlg = ctrlUsaSvcModFlg;
	}
	
//	/**
//	 * Column Info
//	 * @param bkgCtrlAcctGrpFlg
//	 */
//	public void setBkgCtrlAcctGrpFlg(String bkgCtrlAcctGrpFlg) {
//		this.bkgCtrlAcctGrpFlg = bkgCtrlAcctGrpFlg;
//	}
	
	/**
	 * Column Info
	 * @param aplyFmYrwk
	 */
	public void setAplyFmYrwk(String aplyFmYrwk) {
		this.aplyFmYrwk = aplyFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAcctGrpRto
	 */
	public void setBkgCtrlAcctGrpRto(String bkgCtrlAcctGrpRto) {
		this.bkgCtrlAcctGrpRto = bkgCtrlAcctGrpRto;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAlocFcastRto
	 */
	public void setBkgCtrlAlocFcastRto(String bkgCtrlAlocFcastRto) {
		this.bkgCtrlAlocFcastRto = bkgCtrlAlocFcastRto;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAlocAplyFlg
	 */
	public void setBkgCtrlAlocAplyFlg(String bkgCtrlAlocAplyFlg) {
		this.bkgCtrlAlocAplyFlg = bkgCtrlAlocAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlFxRtFlg
	 */
	public void setCtrlFxRtFlg(String ctrlFxRtFlg) {
		this.ctrlFxRtFlg = ctrlFxRtFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrl53ftFlg
	 */
	public void setCtrl53ftFlg(String ctrl53ftFlg) {
		this.ctrl53ftFlg = ctrl53ftFlg;
	}
	
	/**
	 * Column Info
	 * @param isUpload
	 */
	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param acctNm
	 */
	public void setAcctNm(String acctNm) {
		this.acctNm = acctNm;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAcctGrpAplyFlg
	 */
	public void setBkgCtrlAcctGrpAplyFlg(String bkgCtrlAcctGrpAplyFlg) {
		this.bkgCtrlAcctGrpAplyFlg = bkgCtrlAcctGrpAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param rdFlg
	 */
	public void setRdFlg(String rdFlg) {
		this.rdFlg = rdFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlWgtFlg
	 */
	public void setCtrlWgtFlg(String ctrlWgtFlg) {
		this.ctrlWgtFlg = ctrlWgtFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlAcctFlg
	 */
	public void setCtrlAcctFlg(String ctrlAcctFlg) {
		this.ctrlAcctFlg = ctrlAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlEccFlg
	 */
	public void setCtrlEccFlg(String ctrlEccFlg) {
		this.ctrlEccFlg = ctrlEccFlg;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param ctrlRdFlg
	 */
	public void setCtrlRdFlg(String ctrlRdFlg) {
		this.ctrlRdFlg = ctrlRdFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlRfFlg
	 */
	public void setCtrlRfFlg(String ctrlRfFlg) {
		this.ctrlRfFlg = ctrlRfFlg;
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
	 * @param ctrlLocAcctCd
	 */
	public void setCtrlLocAcctCd(String ctrlLocAcctCd) {
		this.ctrlLocAcctCd = ctrlLocAcctCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAcctGrpFcastFlg
	 */
	public void setBkgCtrlAcctGrpFcastFlg(String bkgCtrlAcctGrpFcastFlg) {
		this.bkgCtrlAcctGrpFcastFlg = bkgCtrlAcctGrpFcastFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlD2Flg
	 */
	public void setCtrlD2Flg(String ctrlD2Flg) {
		this.ctrlD2Flg = ctrlD2Flg;
	}
	
	/**
	 * Column Info
	 * @param tmpAcctFlg
	 */
	public void setTmpAcctFlg(String tmpAcctFlg) {
		this.tmpAcctFlg = tmpAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlEccGrpFlg
	 */
	public void setCtrlEccGrpFlg(String ctrlEccGrpFlg) {
		this.ctrlEccGrpFlg = ctrlEccGrpFlg;
	}
	
	/**
	 * Column Info
	 * @param tmpToYrwk
	 */
	public void setTmpToYrwk(String tmpToYrwk) {
		this.tmpToYrwk = tmpToYrwk;
	}
	
	/**
	 * Column Info
	 * @param acctGrpCtrlFlg
	 */
	public void setAcctGrpCtrlFlg(String acctGrpCtrlFlg) {
		this.acctGrpCtrlFlg = acctGrpCtrlFlg;
	}
	
	/**
	 * Column Info
	 * @param hhFlg
	 */
	public void setHhFlg(String hhFlg) {
		this.hhFlg = hhFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrl45ftHcFlg
	 */
	public void setCtrl45ftHcFlg(String ctrl45ftHcFlg) {
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
	}
	
//	/**
//	 * Column Info
//	 * @param bkgCtrlFcstRto
//	 */
//	public void setBkgCtrlFcstRto(String bkgCtrlFcstRto) {
//		this.bkgCtrlFcstRto = bkgCtrlFcstRto;
//	}
//	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
//	/**
//	 * Column Info
//	 * @param bkgCtrlMstFlg
//	 */
//	public void setBkgCtrlMstFlg(String bkgCtrlMstFlg) {
//		this.bkgCtrlMstFlg = bkgCtrlMstFlg;
//	}
	
	/**
	 * Column Info
	 * @param tmpFmYrwk
	 */
	public void setTmpFmYrwk(String tmpFmYrwk) {
		this.tmpFmYrwk = tmpFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param ctrlD4Flg
	 */
	public void setCtrlD4Flg(String ctrlD4Flg) {
		this.ctrlD4Flg = ctrlD4Flg;
	}
	/**
	 * Column Info
	 * @param bkgCtrlAlocTpCd
	 */
	public String getBkgCtrlAlocTpCd() {
		return bkgCtrlAlocTpCd;
	}
	/**
	 * Column Info
	 * @param bkgCtrlAlocTpCd
	 */
	public void setBkgCtrlAlocTpCd(String bkgCtrlAlocTpCd) {
		this.bkgCtrlAlocTpCd = bkgCtrlAlocTpCd;
	}
	/**
	 * Column Info
	 * @param bkgCtrlAcctGrpTpCd
	 */
	public String getBkgCtrlAcctGrpTpCd() {
		return bkgCtrlAcctGrpTpCd;
	}
	/**
	 * Column Info
	 * @param bkgCtrlAcctGrpTpCd
	 */
	public void setBkgCtrlAcctGrpTpCd(String bkgCtrlAcctGrpTpCd) {
		this.bkgCtrlAcctGrpTpCd = bkgCtrlAcctGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlMstTblFcastFlg
	 */
	public void setBkgCtrlMstTblFcastFlg(String bkgCtrlMstTblFcastFlg) {
		this.bkgCtrlMstTblFcastFlg = bkgCtrlMstTblFcastFlg;
	}
	
//	/**
//	 * Column Info
//	 * @param bkgCtrlAplyFlg
//	 */
//	public void setBkgCtrlAplyFlg(String bkgCtrlAplyFlg) {
//		this.bkgCtrlAplyFlg = bkgCtrlAplyFlg;
//	}
	
	/**
	 * Column Info
	 * @param bkgCtrlFcastFmYrwk
	 */
	public void setBkgCtrlFcastFmYrwk(String bkgCtrlFcastFmYrwk) {
		this.bkgCtrlFcastFmYrwk = bkgCtrlFcastFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlLaneFlg
	 */
	public void setBkgCtrlLaneFlg(String bkgCtrlLaneFlg) {
		this.bkgCtrlLaneFlg = bkgCtrlLaneFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlLaneUpdFlg
	 */
	public void setBkgCtrlLaneUpdFlg(String bkgCtrlLaneUpdFlg) {
		this.bkgCtrlLaneUpdFlg = bkgCtrlLaneUpdFlg;
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
		setAlocCtrlTpCd(JSPUtil.getParameter(request, prefix + "aloc_ctrl_tp_cd", ""));
		setBkgCtrlAlocFcastFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_aloc_fcast_flg", ""));
		setCtrlPortFlg(JSPUtil.getParameter(request, prefix + "ctrl_port_flg", ""));
		setBkgCtrlMstTblFcastRto(JSPUtil.getParameter(request, prefix + "bkg_ctrl_mst_tbl_fcast_rto", ""));
		setCtrlLocFlg(JSPUtil.getParameter(request, prefix + "ctrl_loc_flg", ""));
		setBkgCtrlMstTblAplyFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_mst_tbl_aply_flg", ""));
		setCtrl40ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_40ft_hc_flg", ""));
		setAlocCtrlDtlCd(JSPUtil.getParameter(request, prefix + "aloc_ctrl_dtl_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCtrlDestLvlCd(JSPUtil.getParameter(request, prefix + "ctrl_dest_lvl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
//		setBkgCtrlAlocFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_aloc_flg", ""));
//		setBkgCtrlFcstFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_fcst_flg", ""));
		setCtrtNm(JSPUtil.getParameter(request, prefix + "ctrt_nm", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrlLvlCd(JSPUtil.getParameter(request, prefix + "ctrl_lvl_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAplyToYrwk(JSPUtil.getParameter(request, prefix + "aply_to_yrwk", ""));
		setCtrlUsaSvcModFlg(JSPUtil.getParameter(request, prefix + "ctrl_usa_svc_mod_flg", ""));
//		setBkgCtrlAcctGrpFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_acct_grp_flg", ""));
		setAplyFmYrwk(JSPUtil.getParameter(request, prefix + "aply_fm_yrwk", ""));
		setBkgCtrlAcctGrpRto(JSPUtil.getParameter(request, prefix + "bkg_ctrl_acct_grp_rto", ""));
		setBkgCtrlAlocFcastRto(JSPUtil.getParameter(request, prefix + "bkg_ctrl_aloc_fcast_rto", ""));
		setBkgCtrlAlocAplyFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_aloc_aply_flg", ""));
		setCtrlFxRtFlg(JSPUtil.getParameter(request, prefix + "ctrl_fx_rt_flg", ""));
		setCtrl53ftFlg(JSPUtil.getParameter(request, prefix + "ctrl_53ft_flg", ""));
		setIsUpload(JSPUtil.getParameter(request, prefix + "is_upload", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
		setBkgCtrlAcctGrpAplyFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_acct_grp_aply_flg", ""));
		setRdFlg(JSPUtil.getParameter(request, prefix + "rd_flg", ""));
		setCtrlWgtFlg(JSPUtil.getParameter(request, prefix + "ctrl_wgt_flg", ""));
		setCtrlAcctFlg(JSPUtil.getParameter(request, prefix + "ctrl_acct_flg", ""));
		setCtrlEccFlg(JSPUtil.getParameter(request, prefix + "ctrl_ecc_flg", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrlRdFlg(JSPUtil.getParameter(request, prefix + "ctrl_rd_flg", ""));
		setCtrlRfFlg(JSPUtil.getParameter(request, prefix + "ctrl_rf_flg", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setCtrlLocAcctCd(JSPUtil.getParameter(request, prefix + "ctrl_loc_acct_cd", ""));
		setBkgCtrlAcctGrpFcastFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_acct_grp_fcast_flg", ""));
		setCtrlD2Flg(JSPUtil.getParameter(request, prefix + "ctrl_d2_flg", ""));
		setTmpAcctFlg(JSPUtil.getParameter(request, prefix + "tmp_acct_flg", ""));
		setCtrlEccGrpFlg(JSPUtil.getParameter(request, prefix + "ctrl_ecc_grp_flg", ""));
		setTmpToYrwk(JSPUtil.getParameter(request, prefix + "tmp_to_yrwk", ""));
		setAcctGrpCtrlFlg(JSPUtil.getParameter(request, prefix + "acct_grp_ctrl_flg", ""));
		setHhFlg(JSPUtil.getParameter(request, prefix + "hh_flg", ""));
		setCtrl45ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_45ft_hc_flg", ""));
//		setBkgCtrlFcstRto(JSPUtil.getParameter(request, prefix + "bkg_ctrl_fcst_rto", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
//		setBkgCtrlMstFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_mst_flg", ""));
		setTmpFmYrwk(JSPUtil.getParameter(request, prefix + "tmp_fm_yrwk", ""));
		setCtrlD4Flg(JSPUtil.getParameter(request, prefix + "ctrl_d4_flg", ""));
		setBkgCtrlMstTblFcastFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_mst_tbl_fcast_flg", ""));
//		setBkgCtrlAplyFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_aply_flg", ""));
		setBkgCtrlFcastFmYrwk(JSPUtil.getParameter(request, prefix + "bkg_ctrl_fcast_fm_yrwk", ""));
		setBkgCtrlAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_aloc_tp_cd", ""));
		setBkgCtrlAcctGrpTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_acct_grp_tp_cd", ""));
		setBkgCtrlLaneFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_lane_flg", ""));
		setBkgCtrlLaneUpdFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_lane_upd_flg", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocationLaneControlOptionVO[]
	 */
	public SearchSpaceAllocationLaneControlOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocationLaneControlOptionVO[]
	 */
	public SearchSpaceAllocationLaneControlOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocationLaneControlOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] alocCtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "aloc_ctrl_tp_cd", length));
			String[] bkgCtrlAlocFcastFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_aloc_fcast_flg", length));
			String[] ctrlPortFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_port_flg", length));
			String[] bkgCtrlMstTblFcastRto = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_mst_tbl_fcast_rto", length));
			String[] ctrlLocFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_loc_flg", length));
			String[] bkgCtrlMstTblAplyFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_mst_tbl_aply_flg", length));
			String[] ctrl40ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_40ft_hc_flg", length));
			String[] alocCtrlDtlCd = (JSPUtil.getParameter(request, prefix	+ "aloc_ctrl_dtl_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ctrlDestLvlCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_dest_lvl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
//			String[] bkgCtrlAlocFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_aloc_flg", length));
//			String[] bkgCtrlFcstFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_fcst_flg", length));
			String[] ctrtNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_nm", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrlLvlCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_lvl_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] aplyToYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_to_yrwk", length));
			String[] ctrlUsaSvcModFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_usa_svc_mod_flg", length));
//			String[] bkgCtrlAcctGrpFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_acct_grp_flg", length));
			String[] aplyFmYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_fm_yrwk", length));
			String[] bkgCtrlAcctGrpRto = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_acct_grp_rto", length));
			String[] bkgCtrlAlocFcastRto = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_aloc_fcast_rto", length));
			String[] bkgCtrlAlocAplyFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_aloc_aply_flg", length));
			String[] ctrlFxRtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_fx_rt_flg", length));
			String[] ctrl53ftFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_53ft_flg", length));
			String[] isUpload = (JSPUtil.getParameter(request, prefix	+ "is_upload", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] bkgCtrlAcctGrpAplyFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_acct_grp_aply_flg", length));
			String[] rdFlg = (JSPUtil.getParameter(request, prefix	+ "rd_flg", length));
			String[] ctrlWgtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_wgt_flg", length));
			String[] ctrlAcctFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_acct_flg", length));
			String[] ctrlEccFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_ecc_flg", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrlRdFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rd_flg", length));
			String[] ctrlRfFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rf_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] ctrlLocAcctCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_loc_acct_cd", length));
			String[] bkgCtrlAcctGrpFcastFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_acct_grp_fcast_flg", length));
			String[] ctrlD2Flg = (JSPUtil.getParameter(request, prefix	+ "ctrl_d2_flg", length));
			String[] tmpAcctFlg = (JSPUtil.getParameter(request, prefix	+ "tmp_acct_flg", length));
			String[] ctrlEccGrpFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_ecc_grp_flg", length));
			String[] tmpToYrwk = (JSPUtil.getParameter(request, prefix	+ "tmp_to_yrwk", length));
			String[] acctGrpCtrlFlg = (JSPUtil.getParameter(request, prefix	+ "acct_grp_ctrl_flg", length));
			String[] hhFlg = (JSPUtil.getParameter(request, prefix	+ "hh_flg", length));
			String[] ctrl45ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_45ft_hc_flg", length));
//			String[] bkgCtrlFcstRto = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_fcst_rto", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
//			String[] bkgCtrlMstFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_mst_flg", length));
			String[] tmpFmYrwk = (JSPUtil.getParameter(request, prefix	+ "tmp_fm_yrwk", length));
			String[] ctrlD4Flg = (JSPUtil.getParameter(request, prefix	+ "ctrl_d4_flg", length));
			String[] bkgCtrlMstTblFcastFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_mst_tbl_fcast_flg", length));
//			String[] bkgCtrlAplyFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_aply_flg", length));
			String[] bkgCtrlFcastFmYrwk = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_fcast_fm_yrwk", length));
			String[] bkgCtrlAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_aloc_tp_cd", length));
			String[] bkgCtrlAcctGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_acct_grp_tp_cd", length));
			String[] bkgCtrlLaneFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_lane_flg", length));
			String[] bkgCtrlLaneUpdFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_lane_upd_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocationLaneControlOptionVO();
				if (alocCtrlTpCd[i] != null)
					model.setAlocCtrlTpCd(alocCtrlTpCd[i]);
				if (bkgCtrlAlocFcastFlg[i] != null)
					model.setBkgCtrlAlocFcastFlg(bkgCtrlAlocFcastFlg[i]);
				if (ctrlPortFlg[i] != null)
					model.setCtrlPortFlg(ctrlPortFlg[i]);
				if (bkgCtrlMstTblFcastRto[i] != null)
					model.setBkgCtrlMstTblFcastRto(bkgCtrlMstTblFcastRto[i]);
				if (ctrlLocFlg[i] != null)
					model.setCtrlLocFlg(ctrlLocFlg[i]);
				if (bkgCtrlMstTblAplyFlg[i] != null)
					model.setBkgCtrlMstTblAplyFlg(bkgCtrlMstTblAplyFlg[i]);
				if (ctrl40ftHcFlg[i] != null)
					model.setCtrl40ftHcFlg(ctrl40ftHcFlg[i]);
				if (alocCtrlDtlCd[i] != null)
					model.setAlocCtrlDtlCd(alocCtrlDtlCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ctrlDestLvlCd[i] != null)
					model.setCtrlDestLvlCd(ctrlDestLvlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
//				if (bkgCtrlAlocFlg[i] != null)
//					model.setBkgCtrlAlocFlg(bkgCtrlAlocFlg[i]);
//				if (bkgCtrlFcstFlg[i] != null)
//					model.setBkgCtrlFcstFlg(bkgCtrlFcstFlg[i]);
				if (ctrtNm[i] != null)
					model.setCtrtNm(ctrtNm[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrlLvlCd[i] != null)
					model.setCtrlLvlCd(ctrlLvlCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (aplyToYrwk[i] != null)
					model.setAplyToYrwk(aplyToYrwk[i]);
				if (ctrlUsaSvcModFlg[i] != null)
					model.setCtrlUsaSvcModFlg(ctrlUsaSvcModFlg[i]);
//				if (bkgCtrlAcctGrpFlg[i] != null)
//					model.setBkgCtrlAcctGrpFlg(bkgCtrlAcctGrpFlg[i]);
				if (aplyFmYrwk[i] != null)
					model.setAplyFmYrwk(aplyFmYrwk[i]);
				if (bkgCtrlAcctGrpRto[i] != null)
					model.setBkgCtrlAcctGrpRto(bkgCtrlAcctGrpRto[i]);
				if (bkgCtrlAlocFcastRto[i] != null)
					model.setBkgCtrlAlocFcastRto(bkgCtrlAlocFcastRto[i]);
				if (bkgCtrlAlocAplyFlg[i] != null)
					model.setBkgCtrlAlocAplyFlg(bkgCtrlAlocAplyFlg[i]);
				if (ctrlFxRtFlg[i] != null)
					model.setCtrlFxRtFlg(ctrlFxRtFlg[i]);
				if (ctrl53ftFlg[i] != null)
					model.setCtrl53ftFlg(ctrl53ftFlg[i]);
				if (isUpload[i] != null)
					model.setIsUpload(isUpload[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (bkgCtrlAcctGrpAplyFlg[i] != null)
					model.setBkgCtrlAcctGrpAplyFlg(bkgCtrlAcctGrpAplyFlg[i]);
				if (rdFlg[i] != null)
					model.setRdFlg(rdFlg[i]);
				if (ctrlWgtFlg[i] != null)
					model.setCtrlWgtFlg(ctrlWgtFlg[i]);
				if (ctrlAcctFlg[i] != null)
					model.setCtrlAcctFlg(ctrlAcctFlg[i]);
				if (ctrlEccFlg[i] != null)
					model.setCtrlEccFlg(ctrlEccFlg[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrlRdFlg[i] != null)
					model.setCtrlRdFlg(ctrlRdFlg[i]);
				if (ctrlRfFlg[i] != null)
					model.setCtrlRfFlg(ctrlRfFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (ctrlLocAcctCd[i] != null)
					model.setCtrlLocAcctCd(ctrlLocAcctCd[i]);
				if (bkgCtrlAcctGrpFcastFlg[i] != null)
					model.setBkgCtrlAcctGrpFcastFlg(bkgCtrlAcctGrpFcastFlg[i]);
				if (ctrlD2Flg[i] != null)
					model.setCtrlD2Flg(ctrlD2Flg[i]);
				if (tmpAcctFlg[i] != null)
					model.setTmpAcctFlg(tmpAcctFlg[i]);
				if (ctrlEccGrpFlg[i] != null)
					model.setCtrlEccGrpFlg(ctrlEccGrpFlg[i]);
				if (tmpToYrwk[i] != null)
					model.setTmpToYrwk(tmpToYrwk[i]);
				if (acctGrpCtrlFlg[i] != null)
					model.setAcctGrpCtrlFlg(acctGrpCtrlFlg[i]);
				if (hhFlg[i] != null)
					model.setHhFlg(hhFlg[i]);
				if (ctrl45ftHcFlg[i] != null)
					model.setCtrl45ftHcFlg(ctrl45ftHcFlg[i]);
//				if (bkgCtrlFcstRto[i] != null)
//					model.setBkgCtrlFcstRto(bkgCtrlFcstRto[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
//				if (bkgCtrlMstFlg[i] != null)
//					model.setBkgCtrlMstFlg(bkgCtrlMstFlg[i]);
				if (tmpFmYrwk[i] != null)
					model.setTmpFmYrwk(tmpFmYrwk[i]);
				if (ctrlD4Flg[i] != null)
					model.setCtrlD4Flg(ctrlD4Flg[i]);
				if (bkgCtrlMstTblFcastFlg[i] != null)
					model.setBkgCtrlMstTblFcastFlg(bkgCtrlMstTblFcastFlg[i]);
//				if (bkgCtrlAplyFlg[i] != null)
//					model.setBkgCtrlAplyFlg(bkgCtrlAplyFlg[i]);
				if (bkgCtrlFcastFmYrwk[i] != null)
					model.setBkgCtrlFcastFmYrwk(bkgCtrlFcastFmYrwk[i]);
				if (bkgCtrlAlocTpCd[i] != null)
					model.setBkgCtrlAlocTpCd(bkgCtrlAlocTpCd[i]);
				if (bkgCtrlAcctGrpTpCd[i] != null)
					model.setBkgCtrlAcctGrpTpCd(bkgCtrlAcctGrpTpCd[i]);
				if (bkgCtrlLaneFlg[i] != null)
					model.setBkgCtrlLaneFlg(bkgCtrlLaneFlg[i]);
				if (bkgCtrlLaneUpdFlg[i] != null)
					model.setBkgCtrlLaneUpdFlg(bkgCtrlLaneUpdFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocationLaneControlOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocationLaneControlOptionVO[]
	 */
	public SearchSpaceAllocationLaneControlOptionVO[] getSearchSpaceAllocationLaneControlOptionVOs(){
		SearchSpaceAllocationLaneControlOptionVO[] vos = (SearchSpaceAllocationLaneControlOptionVO[])models.toArray(new SearchSpaceAllocationLaneControlOptionVO[models.size()]);
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
		this.alocCtrlTpCd = this.alocCtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAlocFcastFlg = this.bkgCtrlAlocFcastFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlPortFlg = this.ctrlPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlMstTblFcastRto = this.bkgCtrlMstTblFcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLocFlg = this.ctrlLocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlMstTblAplyFlg = this.bkgCtrlMstTblAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl40ftHcFlg = this.ctrl40ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocCtrlDtlCd = this.alocCtrlDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlDestLvlCd = this.ctrlDestLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.bkgCtrlAlocFlg = this.bkgCtrlAlocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.bkgCtrlFcstFlg = this.bkgCtrlFcstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNm = this.ctrtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLvlCd = this.ctrlLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyToYrwk = this.aplyToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUsaSvcModFlg = this.ctrlUsaSvcModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.bkgCtrlAcctGrpFlg = this.bkgCtrlAcctGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyFmYrwk = this.aplyFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAcctGrpRto = this.bkgCtrlAcctGrpRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAlocFcastRto = this.bkgCtrlAlocFcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAlocAplyFlg = this.bkgCtrlAlocAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlFxRtFlg = this.ctrlFxRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl53ftFlg = this.ctrl53ftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isUpload = this.isUpload .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAcctGrpAplyFlg = this.bkgCtrlAcctGrpAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlg = this.rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlWgtFlg = this.ctrlWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAcctFlg = this.ctrlAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlEccFlg = this.ctrlEccFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRdFlg = this.ctrlRdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRfFlg = this.ctrlRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLocAcctCd = this.ctrlLocAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAcctGrpFcastFlg = this.bkgCtrlAcctGrpFcastFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD2Flg = this.ctrlD2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpAcctFlg = this.tmpAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlEccGrpFlg = this.ctrlEccGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpToYrwk = this.tmpToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctGrpCtrlFlg = this.acctGrpCtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hhFlg = this.hhFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl45ftHcFlg = this.ctrl45ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.bkgCtrlFcstRto = this.bkgCtrlFcstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.bkgCtrlMstFlg = this.bkgCtrlMstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpFmYrwk = this.tmpFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD4Flg = this.ctrlD4Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlMstTblFcastFlg = this.bkgCtrlMstTblFcastFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.bkgCtrlAplyFlg = this.bkgCtrlAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlFcastFmYrwk = this.bkgCtrlFcastFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAlocTpCd = this.bkgCtrlAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAcctGrpTpCd = this.bkgCtrlAcctGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlLaneFlg = this.bkgCtrlLaneFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlLaneUpdFlg = this.bkgCtrlLaneUpdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
