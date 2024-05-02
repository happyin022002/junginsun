/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpcAlocCtrlOptVO.java
*@FileTitle : SpcAlocCtrlOptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.18  
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

public class SpcAlocCtrlOptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcAlocCtrlOptVO> models = new ArrayList<SpcAlocCtrlOptVO>();
	
	/* Column Info */
	private String ctrlPortFlg = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ctrlLocFlg = null;
	/* Column Info */
	private String ctrl40ftHcFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String ctrlDestLvlCd = null;
	/* Column Info */
	private String ctrlAcctFlg = null;
	/* Column Info */
	private String ctrlWgtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgCtrlAlocFlg = null;
	/* Column Info */
	private String ctrlEccFlg = null;
	/* Column Info */
	private String bkgCtrlFcstFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrlRdFlg = null;
	/* Column Info */
	private String ctrlRfFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String ctrlLvlCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ctrlD2Flg = null;
	/* Column Info */
	private String ctrlUsaSvcModFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ctrlEccGrpFlg = null;
	/* Column Info */
	private String bkgCtrlAcctGrpFlg = null;
	/* Column Info */
	private String acctGrpCtrlFlg = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ctrlSpcFlg = null;
	/* Column Info */
	private String ctrl45ftHcFlg = null;
	/* Column Info */
	private String bkgCtrlFcstRto = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bkgCtrlMstFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ctrl53ftFlg = null;
	/* Column Info */
	private String ctrlD4Flg = null;
	/* Column Info */
	private String ctrlTsFlg = null;
	/* Column Info */
	private String repSubTrdCd = null;
	/* Column Info */
	private String bkgCtrlAplyFlg = null;
	/* Column Info */
	private String mnlFlg = null;

	/* Column Info */
	private String alocMdfy = null;
	
	/* Column Info */
	private String desyncFlg = null;
	/* Column Info */
	private String ctrlFxRtFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpcAlocCtrlOptVO() {}

	public SpcAlocCtrlOptVO(String ibflag, String pagerows, String rlaneCd, String dirCd, String vslCd, String skdVoyNo, String skdDirCd, String repTrdCd, String repSubTrdCd, String ctrlPortFlg, String ctrlWgtFlg, String ctrlSpcFlg, String ctrl40ftHcFlg, String ctrl45ftHcFlg, String ctrlRfFlg, String ctrlTsFlg, String ctrlLvlCd, String creUsrId, String creDt, String updUsrId, String updDt, String ctrl53ftFlg, String acctGrpCtrlFlg, String ctrlD2Flg, String ctrlD4Flg, String ctrlRdFlg, String ctrlEccFlg, String ctrlLocFlg, String ctrlUsaSvcModFlg, String ctrlAcctFlg, String ctrlDestLvlCd, String mnlFlg, String bkgCtrlAlocFlg, String bkgCtrlAcctGrpFlg, String bkgCtrlMstFlg, String bkgCtrlAplyFlg, String bkgCtrlFcstFlg, String bkgCtrlFcstRto, String ctrlEccGrpFlg, String alocMdfy, String desyncFlg, String ctrlFxRtFlg) {
		this.ctrlPortFlg = ctrlPortFlg;
		this.vslCd = vslCd;
		this.ctrlLocFlg = ctrlLocFlg;
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
		this.creDt = creDt;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.ctrlDestLvlCd = ctrlDestLvlCd;
		this.ctrlAcctFlg = ctrlAcctFlg;
		this.ctrlWgtFlg = ctrlWgtFlg;
		this.pagerows = pagerows;
		this.bkgCtrlAlocFlg = bkgCtrlAlocFlg;
		this.ctrlEccFlg = ctrlEccFlg;
		this.bkgCtrlFcstFlg = bkgCtrlFcstFlg;
		this.ibflag = ibflag;
		this.ctrlRdFlg = ctrlRdFlg;
		this.ctrlRfFlg = ctrlRfFlg;
		this.dirCd = dirCd;
		this.ctrlLvlCd = ctrlLvlCd;
		this.updUsrId = updUsrId;
		this.ctrlD2Flg = ctrlD2Flg;
		this.ctrlUsaSvcModFlg = ctrlUsaSvcModFlg;
		this.updDt = updDt;
		this.ctrlEccGrpFlg = ctrlEccGrpFlg;
		this.bkgCtrlAcctGrpFlg = bkgCtrlAcctGrpFlg;
		this.acctGrpCtrlFlg = acctGrpCtrlFlg;
		this.skdVoyNo = skdVoyNo;
		this.ctrlSpcFlg = ctrlSpcFlg;
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
		this.bkgCtrlFcstRto = bkgCtrlFcstRto;
		this.skdDirCd = skdDirCd;
		this.bkgCtrlMstFlg = bkgCtrlMstFlg;
		this.creUsrId = creUsrId;
		this.ctrl53ftFlg = ctrl53ftFlg;
		this.ctrlD4Flg = ctrlD4Flg;
		this.ctrlTsFlg = ctrlTsFlg;
		this.repSubTrdCd = repSubTrdCd;
		this.bkgCtrlAplyFlg = bkgCtrlAplyFlg;
		this.alocMdfy = alocMdfy;
		this.mnlFlg = mnlFlg;
		this.desyncFlg = desyncFlg;
		this.ctrlFxRtFlg = ctrlFxRtFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrl_port_flg", getCtrlPortFlg());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ctrl_loc_flg", getCtrlLocFlg());
		this.hashColumns.put("ctrl_40ft_hc_flg", getCtrl40ftHcFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("ctrl_dest_lvl_cd", getCtrlDestLvlCd());
		this.hashColumns.put("ctrl_acct_flg", getCtrlAcctFlg());
		this.hashColumns.put("ctrl_wgt_flg", getCtrlWgtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_ctrl_aloc_flg", getBkgCtrlAlocFlg());
		this.hashColumns.put("ctrl_ecc_flg", getCtrlEccFlg());
		this.hashColumns.put("bkg_ctrl_fcst_flg", getBkgCtrlFcstFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrl_rd_flg", getCtrlRdFlg());
		this.hashColumns.put("ctrl_rf_flg", getCtrlRfFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ctrl_lvl_cd", getCtrlLvlCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ctrl_d2_flg", getCtrlD2Flg());
		this.hashColumns.put("ctrl_usa_svc_mod_flg", getCtrlUsaSvcModFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ctrl_ecc_grp_flg", getCtrlEccGrpFlg());
		this.hashColumns.put("bkg_ctrl_acct_grp_flg", getBkgCtrlAcctGrpFlg());
		this.hashColumns.put("acct_grp_ctrl_flg", getAcctGrpCtrlFlg());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ctrl_spc_flg", getCtrlSpcFlg());
		this.hashColumns.put("ctrl_45ft_hc_flg", getCtrl45ftHcFlg());
		this.hashColumns.put("bkg_ctrl_fcst_rto", getBkgCtrlFcstRto());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bkg_ctrl_mst_flg", getBkgCtrlMstFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ctrl_53ft_flg", getCtrl53ftFlg());
		this.hashColumns.put("ctrl_d4_flg", getCtrlD4Flg());
		this.hashColumns.put("ctrl_ts_flg", getCtrlTsFlg());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		this.hashColumns.put("bkg_ctrl_aply_flg", getBkgCtrlAplyFlg());
		this.hashColumns.put("aloc_mdfy", getAlocMdfy() );
		this.hashColumns.put("mnl_flg", getMnlFlg());
		this.hashColumns.put("desync_flg", getDesyncFlg());
		this.hashColumns.put("ctrl_fx_rt_flg", getCtrlFxRtFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrl_port_flg", "ctrlPortFlg");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ctrl_loc_flg", "ctrlLocFlg");
		this.hashFields.put("ctrl_40ft_hc_flg", "ctrl40ftHcFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("ctrl_dest_lvl_cd", "ctrlDestLvlCd");
		this.hashFields.put("ctrl_acct_flg", "ctrlAcctFlg");
		this.hashFields.put("ctrl_wgt_flg", "ctrlWgtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_ctrl_aloc_flg", "bkgCtrlAlocFlg");
		this.hashFields.put("ctrl_ecc_flg", "ctrlEccFlg");
		this.hashFields.put("bkg_ctrl_fcst_flg", "bkgCtrlFcstFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrl_rd_flg", "ctrlRdFlg");
		this.hashFields.put("ctrl_rf_flg", "ctrlRfFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ctrl_lvl_cd", "ctrlLvlCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ctrl_d2_flg", "ctrlD2Flg");
		this.hashFields.put("ctrl_usa_svc_mod_flg", "ctrlUsaSvcModFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ctrl_ecc_grp_flg", "ctrlEccGrpFlg");
		this.hashFields.put("bkg_ctrl_acct_grp_flg", "bkgCtrlAcctGrpFlg");
		this.hashFields.put("acct_grp_ctrl_flg", "acctGrpCtrlFlg");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ctrl_spc_flg", "ctrlSpcFlg");
		this.hashFields.put("ctrl_45ft_hc_flg", "ctrl45ftHcFlg");
		this.hashFields.put("bkg_ctrl_fcst_rto", "bkgCtrlFcstRto");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bkg_ctrl_mst_flg", "bkgCtrlMstFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ctrl_53ft_flg", "ctrl53ftFlg");
		this.hashFields.put("ctrl_d4_flg", "ctrlD4Flg");
		this.hashFields.put("ctrl_ts_flg", "ctrlTsFlg");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		this.hashFields.put("bkg_ctrl_aply_flg", "bkgCtrlAplyFlg");
		this.hashFields.put("aloc_mdfy", "alocMdfy");
		this.hashFields.put("mnl_flg", "mnlFlg");
		this.hashFields.put("desync_flg", "desyncFlg");
		this.hashFields.put("ctrl_fx_rt_flg", "ctrlFxRtFlg");
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return ctrl40ftHcFlg
	 */
	public String getCtrl40ftHcFlg() {
		return this.ctrl40ftHcFlg;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlDestLvlCd
	 */
	public String getCtrlDestLvlCd() {
		return this.ctrlDestLvlCd;
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
	 * @return ctrlWgtFlg
	 */
	public String getCtrlWgtFlg() {
		return this.ctrlWgtFlg;
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
	 * @return bkgCtrlAlocFlg
	 */
	public String getBkgCtrlAlocFlg() {
		return this.bkgCtrlAlocFlg;
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
	 * @return bkgCtrlFcstFlg
	 */
	public String getBkgCtrlFcstFlg() {
		return this.bkgCtrlFcstFlg;
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
	 * @return ctrlD2Flg
	 */
	public String getCtrlD2Flg() {
		return this.ctrlD2Flg;
	}
	
	/**
	 * Column Info
	 * @return ctrlUsaSvcModFlg
	 */
	public String getCtrlUsaSvcModFlg() {
		return this.ctrlUsaSvcModFlg;
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
	 * @return ctrlEccGrpFlg
	 */
	public String getCtrlEccGrpFlg() {
		return this.ctrlEccGrpFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAcctGrpFlg
	 */
	public String getBkgCtrlAcctGrpFlg() {
		return this.bkgCtrlAcctGrpFlg;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ctrlSpcFlg
	 */
	public String getCtrlSpcFlg() {
		return this.ctrlSpcFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrl45ftHcFlg
	 */
	public String getCtrl45ftHcFlg() {
		return this.ctrl45ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlFcstRto
	 */
	public String getBkgCtrlFcstRto() {
		return this.bkgCtrlFcstRto;
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
	 * @return bkgCtrlMstFlg
	 */
	public String getBkgCtrlMstFlg() {
		return this.bkgCtrlMstFlg;
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
	 * @return ctrl53ftFlg
	 */
	public String getCtrl53ftFlg() {
		return this.ctrl53ftFlg;
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
	 * @return ctrlTsFlg
	 */
	public String getCtrlTsFlg() {
		return this.ctrlTsFlg;
	}
	
	/**
	 * Column Info
	 * @return repSubTrdCd
	 */
	public String getRepSubTrdCd() {
		return this.repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAplyFlg
	 */
	public String getBkgCtrlAplyFlg() {
		return this.bkgCtrlAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return mnlFlg
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
	}
	
	/**
	 * Column Info
	 * @param alocMdfy
	 */
	public String getAlocMdfy() {
		return this.alocMdfy;
	}

	/**
	 * Column Info
	 * @param 
	 */
	public String getDesyncFlg() {
		return this.desyncFlg;
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
	 * @param ctrlPortFlg
	 */
	public void setCtrlPortFlg(String ctrlPortFlg) {
		this.ctrlPortFlg = ctrlPortFlg;
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
	 * @param ctrlLocFlg
	 */
	public void setCtrlLocFlg(String ctrlLocFlg) {
		this.ctrlLocFlg = ctrlLocFlg;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlDestLvlCd
	 */
	public void setCtrlDestLvlCd(String ctrlDestLvlCd) {
		this.ctrlDestLvlCd = ctrlDestLvlCd;
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
	 * @param ctrlWgtFlg
	 */
	public void setCtrlWgtFlg(String ctrlWgtFlg) {
		this.ctrlWgtFlg = ctrlWgtFlg;
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
	 * @param bkgCtrlAlocFlg
	 */
	public void setBkgCtrlAlocFlg(String bkgCtrlAlocFlg) {
		this.bkgCtrlAlocFlg = bkgCtrlAlocFlg;
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
	 * @param bkgCtrlFcstFlg
	 */
	public void setBkgCtrlFcstFlg(String bkgCtrlFcstFlg) {
		this.bkgCtrlFcstFlg = bkgCtrlFcstFlg;
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
	 * @param ctrlD2Flg
	 */
	public void setCtrlD2Flg(String ctrlD2Flg) {
		this.ctrlD2Flg = ctrlD2Flg;
	}
	
	/**
	 * Column Info
	 * @param ctrlUsaSvcModFlg
	 */
	public void setCtrlUsaSvcModFlg(String ctrlUsaSvcModFlg) {
		this.ctrlUsaSvcModFlg = ctrlUsaSvcModFlg;
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
	 * @param ctrlEccGrpFlg
	 */
	public void setCtrlEccGrpFlg(String ctrlEccGrpFlg) {
		this.ctrlEccGrpFlg = ctrlEccGrpFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAcctGrpFlg
	 */
	public void setBkgCtrlAcctGrpFlg(String bkgCtrlAcctGrpFlg) {
		this.bkgCtrlAcctGrpFlg = bkgCtrlAcctGrpFlg;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ctrlSpcFlg
	 */
	public void setCtrlSpcFlg(String ctrlSpcFlg) {
		this.ctrlSpcFlg = ctrlSpcFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrl45ftHcFlg
	 */
	public void setCtrl45ftHcFlg(String ctrl45ftHcFlg) {
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlFcstRto
	 */
	public void setBkgCtrlFcstRto(String bkgCtrlFcstRto) {
		this.bkgCtrlFcstRto = bkgCtrlFcstRto;
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
	 * @param bkgCtrlMstFlg
	 */
	public void setBkgCtrlMstFlg(String bkgCtrlMstFlg) {
		this.bkgCtrlMstFlg = bkgCtrlMstFlg;
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
	 * @param ctrl53ftFlg
	 */
	public void setCtrl53ftFlg(String ctrl53ftFlg) {
		this.ctrl53ftFlg = ctrl53ftFlg;
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
	 * @param ctrlTsFlg
	 */
	public void setCtrlTsFlg(String ctrlTsFlg) {
		this.ctrlTsFlg = ctrlTsFlg;
	}
	
	/**
	 * Column Info
	 * @param repSubTrdCd
	 */
	public void setRepSubTrdCd(String repSubTrdCd) {
		this.repSubTrdCd = repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAplyFlg
	 */
	public void setBkgCtrlAplyFlg(String bkgCtrlAplyFlg) {
		this.bkgCtrlAplyFlg = bkgCtrlAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param mnlFlg
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
	}
	
	/**
	 * Column Info
	 * @param alocMdfy
	 */
	public void setAlocMdfy(String alocMdfy) {
		this.alocMdfy = alocMdfy;
	}
	
	/**
	 * Column Info
	 * @param alocMdfy
	 */
	public void setDesyncFlg(String desyncFlg) {
		this.desyncFlg = desyncFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlFxRtFlg
	 */
	public void setCtrlFxRtFlg(String ctrlFxRtFlg) {
		this.ctrlFxRtFlg = ctrlFxRtFlg;
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
		setCtrlPortFlg(JSPUtil.getParameter(request, prefix + "ctrl_port_flg", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCtrlLocFlg(JSPUtil.getParameter(request, prefix + "ctrl_loc_flg", ""));
		setCtrl40ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_40ft_hc_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, prefix + "rep_trd_cd", ""));
		setCtrlDestLvlCd(JSPUtil.getParameter(request, prefix + "ctrl_dest_lvl_cd", ""));
		setCtrlAcctFlg(JSPUtil.getParameter(request, prefix + "ctrl_acct_flg", ""));
		setCtrlWgtFlg(JSPUtil.getParameter(request, prefix + "ctrl_wgt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgCtrlAlocFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_aloc_flg", ""));
		setCtrlEccFlg(JSPUtil.getParameter(request, prefix + "ctrl_ecc_flg", ""));
		setBkgCtrlFcstFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_fcst_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrlRdFlg(JSPUtil.getParameter(request, prefix + "ctrl_rd_flg", ""));
		setCtrlRfFlg(JSPUtil.getParameter(request, prefix + "ctrl_rf_flg", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setCtrlLvlCd(JSPUtil.getParameter(request, prefix + "ctrl_lvl_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCtrlD2Flg(JSPUtil.getParameter(request, prefix + "ctrl_d2_flg", ""));
		setCtrlUsaSvcModFlg(JSPUtil.getParameter(request, prefix + "ctrl_usa_svc_mod_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCtrlEccGrpFlg(JSPUtil.getParameter(request, prefix + "ctrl_ecc_grp_flg", ""));
		setBkgCtrlAcctGrpFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_acct_grp_flg", ""));
		setAcctGrpCtrlFlg(JSPUtil.getParameter(request, prefix + "acct_grp_ctrl_flg", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCtrlSpcFlg(JSPUtil.getParameter(request, prefix + "ctrl_spc_flg", ""));
		setCtrl45ftHcFlg(JSPUtil.getParameter(request, prefix + "ctrl_45ft_hc_flg", ""));
		setBkgCtrlFcstRto(JSPUtil.getParameter(request, prefix + "bkg_ctrl_fcst_rto", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBkgCtrlMstFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_mst_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCtrl53ftFlg(JSPUtil.getParameter(request, prefix + "ctrl_53ft_flg", ""));
		setCtrlD4Flg(JSPUtil.getParameter(request, prefix + "ctrl_d4_flg", ""));
		setCtrlTsFlg(JSPUtil.getParameter(request, prefix + "ctrl_ts_flg", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, prefix + "rep_sub_trd_cd", ""));
		setBkgCtrlAplyFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_aply_flg", ""));
		setAlocMdfy(JSPUtil.getParameter(request, "aloc_mdfy", ""));
		setMnlFlg(JSPUtil.getParameter(request, prefix + "mnl_flg", ""));
		setDesyncFlg(JSPUtil.getParameter(request, prefix + "desync_flg", ""));
		setCtrlFxRtFlg(JSPUtil.getParameter(request, prefix + "ctrl_fx_rt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcAlocCtrlOptVO[]
	 */
	public SpcAlocCtrlOptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcAlocCtrlOptVO[]
	 */
	public SpcAlocCtrlOptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcAlocCtrlOptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrlPortFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_port_flg", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ctrlLocFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_loc_flg", length));
			String[] ctrl40ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_40ft_hc_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] ctrlDestLvlCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_dest_lvl_cd", length));
			String[] ctrlAcctFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_acct_flg", length));
			String[] ctrlWgtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_wgt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgCtrlAlocFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_aloc_flg", length));
			String[] ctrlEccFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_ecc_flg", length));
			String[] bkgCtrlFcstFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_fcst_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrlRdFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rd_flg", length));
			String[] ctrlRfFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rf_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] ctrlLvlCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_lvl_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ctrlD2Flg = (JSPUtil.getParameter(request, prefix	+ "ctrl_d2_flg", length));
			String[] ctrlUsaSvcModFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_usa_svc_mod_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ctrlEccGrpFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_ecc_grp_flg", length));
			String[] bkgCtrlAcctGrpFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_acct_grp_flg", length));
			String[] acctGrpCtrlFlg = (JSPUtil.getParameter(request, prefix	+ "acct_grp_ctrl_flg", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ctrlSpcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_spc_flg", length));
			String[] ctrl45ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_45ft_hc_flg", length));
			String[] bkgCtrlFcstRto = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_fcst_rto", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] bkgCtrlMstFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_mst_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ctrl53ftFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_53ft_flg", length));
			String[] ctrlD4Flg = (JSPUtil.getParameter(request, prefix	+ "ctrl_d4_flg", length));
			String[] ctrlTsFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_ts_flg", length));
			String[] repSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd", length));
			String[] bkgCtrlAplyFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_aply_flg", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			String[] alocMdfy = (JSPUtil.getParameter(request, prefix	+ "aloc_mdfy"    , length));
			String[] desyncFlg = (JSPUtil.getParameter(request, prefix	+ "desync_flg"    , length));
			String[] ctrlFxRtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_fx_rt_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SpcAlocCtrlOptVO();
				if (ctrlPortFlg[i] != null)
					model.setCtrlPortFlg(ctrlPortFlg[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ctrlLocFlg[i] != null)
					model.setCtrlLocFlg(ctrlLocFlg[i]);
				if (ctrl40ftHcFlg[i] != null)
					model.setCtrl40ftHcFlg(ctrl40ftHcFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (ctrlDestLvlCd[i] != null)
					model.setCtrlDestLvlCd(ctrlDestLvlCd[i]);
				if (ctrlAcctFlg[i] != null)
					model.setCtrlAcctFlg(ctrlAcctFlg[i]);
				if (ctrlWgtFlg[i] != null)
					model.setCtrlWgtFlg(ctrlWgtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgCtrlAlocFlg[i] != null)
					model.setBkgCtrlAlocFlg(bkgCtrlAlocFlg[i]);
				if (ctrlEccFlg[i] != null)
					model.setCtrlEccFlg(ctrlEccFlg[i]);
				if (bkgCtrlFcstFlg[i] != null)
					model.setBkgCtrlFcstFlg(bkgCtrlFcstFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrlRdFlg[i] != null)
					model.setCtrlRdFlg(ctrlRdFlg[i]);
				if (ctrlRfFlg[i] != null)
					model.setCtrlRfFlg(ctrlRfFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (ctrlLvlCd[i] != null)
					model.setCtrlLvlCd(ctrlLvlCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ctrlD2Flg[i] != null)
					model.setCtrlD2Flg(ctrlD2Flg[i]);
				if (ctrlUsaSvcModFlg[i] != null)
					model.setCtrlUsaSvcModFlg(ctrlUsaSvcModFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ctrlEccGrpFlg[i] != null)
					model.setCtrlEccGrpFlg(ctrlEccGrpFlg[i]);
				if (bkgCtrlAcctGrpFlg[i] != null)
					model.setBkgCtrlAcctGrpFlg(bkgCtrlAcctGrpFlg[i]);
				if (acctGrpCtrlFlg[i] != null)
					model.setAcctGrpCtrlFlg(acctGrpCtrlFlg[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ctrlSpcFlg[i] != null)
					model.setCtrlSpcFlg(ctrlSpcFlg[i]);
				if (ctrl45ftHcFlg[i] != null)
					model.setCtrl45ftHcFlg(ctrl45ftHcFlg[i]);
				if (bkgCtrlFcstRto[i] != null)
					model.setBkgCtrlFcstRto(bkgCtrlFcstRto[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bkgCtrlMstFlg[i] != null)
					model.setBkgCtrlMstFlg(bkgCtrlMstFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ctrl53ftFlg[i] != null)
					model.setCtrl53ftFlg(ctrl53ftFlg[i]);
				if (ctrlD4Flg[i] != null)
					model.setCtrlD4Flg(ctrlD4Flg[i]);
				if (ctrlTsFlg[i] != null)
					model.setCtrlTsFlg(ctrlTsFlg[i]);
				if (repSubTrdCd[i] != null)
					model.setRepSubTrdCd(repSubTrdCd[i]);
				if (bkgCtrlAplyFlg[i] != null)
					model.setBkgCtrlAplyFlg(bkgCtrlAplyFlg[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				if (alocMdfy[i] != null)
					model.setAlocMdfy(alocMdfy[i]);
				if (desyncFlg[i] != null)
					model.setDesyncFlg(desyncFlg[i]);
				if (ctrlFxRtFlg[i] != null)
					model.setCtrlFxRtFlg(ctrlFxRtFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcAlocCtrlOptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcAlocCtrlOptVO[]
	 */
	public SpcAlocCtrlOptVO[] getSpcAlocCtrlOptVOs(){
		SpcAlocCtrlOptVO[] vos = (SpcAlocCtrlOptVO[])models.toArray(new SpcAlocCtrlOptVO[models.size()]);
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
		this.ctrlPortFlg = this.ctrlPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLocFlg = this.ctrlLocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl40ftHcFlg = this.ctrl40ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlDestLvlCd = this.ctrlDestLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAcctFlg = this.ctrlAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlWgtFlg = this.ctrlWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAlocFlg = this.bkgCtrlAlocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlEccFlg = this.ctrlEccFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlFcstFlg = this.bkgCtrlFcstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRdFlg = this.ctrlRdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRfFlg = this.ctrlRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlLvlCd = this.ctrlLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD2Flg = this.ctrlD2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUsaSvcModFlg = this.ctrlUsaSvcModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlEccGrpFlg = this.ctrlEccGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAcctGrpFlg = this.bkgCtrlAcctGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctGrpCtrlFlg = this.acctGrpCtrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlSpcFlg = this.ctrlSpcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl45ftHcFlg = this.ctrl45ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlFcstRto = this.bkgCtrlFcstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlMstFlg = this.bkgCtrlMstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl53ftFlg = this.ctrl53ftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlD4Flg = this.ctrlD4Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlTsFlg = this.ctrlTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAplyFlg = this.bkgCtrlAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocMdfy    = this.alocMdfy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desyncFlg    = this.desyncFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlFxRtFlg = this.ctrlFxRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
