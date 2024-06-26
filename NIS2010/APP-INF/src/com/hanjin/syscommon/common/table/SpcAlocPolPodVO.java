/*=========================================================
**Copyright(c) 2009 CyberLogitec
*@FileName : SpcAlocPolPodVO.java
*@FileTitle : SpcAlocPolPodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.07.20 최윤성 
* 1.0 Creation
* 2009.08.20 CHOI.Y.S
* - modeRmk field 추가
* 2010.07.01 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 - 53Ft field 관련 내용 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcAlocPolPodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcAlocPolPodVO> models = new ArrayList<SpcAlocPolPodVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgAval40ftQty = null;
	/* Column Info */
	private String asgnTtlWgt = null;
	/* Column Info */
	private String spcCtrlAlocPodRmk = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String asgnRfQty = null;
	/* Column Info */
	private String usdBkg40ftQty = null;
	/* Column Info */
	private String bkgAvalTtlWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spcCtrlAlocRmk = null;
	/* Column Info */
	private String mnlAlocRmk = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String alocUsrId = null;
	/* Column Info */
	private String asgn40ftQty = null;
	/* Column Info */
	private String usdBkg40ftHcQty = null;
	/* Column Info */
	private String bkgAvalRfQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String slsAqCd = null;
	/* Column Info */
	private String asgn20ftQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String fcastRfQty = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usdBkg45ftHcQty = null;
	/* Column Info */
	private String alocGdt = null;
	/* Column Info */
	private String fcast40ftHcQty = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String asgn45ftHcQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String usdBkg20ftQty = null;
	/* Column Info */
	private String bkgAval40ftHcQty = null;
	/* Column Info */
	private String asgnTtlQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tsFlg = null;
	/* Column Info */
	private String fcastTtlQty = null;
	/* Column Info */
	private String usdBkgTtlQty = null;
	/* Column Info */
	private String usdBkgRfQty = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String fcastTtlWgt = null;
	/* Column Info */
	private String spcCtrlAlocPolRmk = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String asgn40ftHcQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bkgAvalTtlQty = null;
	/* Column Info */
	private String bkgAval45ftHcQty = null;
	/* Column Info */
	private String bkgAval20ftQty = null;
	/* Column Info */
	private String fcast45ftHcQty = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
//	private String delYdCd = null;
	/* Column Info */
	private String usdBkgTtlWgt = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String repSubTrdCd = null;
	/* Column Info */
	private String mnlFlg = null;
	
	private String modeRmk = null;
	/* Column Info */
	private String usdBkg53ftQty = null;
	/* Column Info */
	private String asgn53ftQty = null;
	/* Column Info */
	private String bkgAval53ftQty = null;
	/* Column Info */
	private String fcast53ftQty = null;

	/* Column Info */
	private String  newVslVd= null;
	/* Column Info */
	private String newSkdVoyNo = null;
	/* Column Info */
	private String newSkdDirCd = null;
	
	/* Column Info */
	private String year = null;	
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String fcast = null;
	
	/* Column Info */
	private String usMod = null;
	/* Column Info */
	private String accountCd = null;
	/* Column Info */
	private String delYdCd = null;
	/* Column Info */
	private String asgnD2Qty = null;
	/* Column Info */
	private String asgnD4Qty = null;
	/* Column Info */
	private String asgnRdQty = null;
	/* Column Info */
	private String usdBkgD2Qty = null;
	/* Column Info */
	private String usdBkgD4Qty = null;
	/* Column Info */
	private String usdBkgRdQty = null;
	/* Column Info */
	private String fcastD2Qty = null;
	/* Column Info */
	private String fcastD4Qty = null;
	/* Column Info */
	private String fcastRdQty = null;
	/* Column Info */
	private String bkgAvalD2Qty = null;
	/* Column Info */
	private String bkgAvalD4Qty = null;
	/* Column Info */
	private String bkgAvalRdQty = null;
	/* Column Info */
	private String alocMdfy = null;
	
	/* Column Info */
	private String ctrtNo = null;

	/* Column Info */
	private String bsTeu = null;
	
	/* Column Info */
	private String bsWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ctrlLvl = null;
	/* Column Info */
	private String chkPort = null;
	/* Column Info */
	private String ctrlWt = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcAlocPolPodVO() {}

	public SpcAlocPolPodVO(String ibflag, String pagerows, String rlaneCd, String dirCd, String vslCd, String skdVoyNo, String skdDirCd, String slsOfcCd, String polYdCd, String delYdCd, String podYdCd, String tsFlg, String mnlFlg, String repTrdCd, String repSubTrdCd, String trdCd, String subTrdCd, String iocCd, String slsRhqCd, String slsRgnOfcCd, String asgnTtlQty, String asgn20ftQty, String asgn40ftQty, String asgn40ftHcQty, String asgn45ftHcQty, String asgnRfQty, String asgnTtlWgt, String bkgAvalTtlQty, String bkgAval20ftQty, String bkgAval40ftQty, String bkgAval40ftHcQty, String bkgAval45ftHcQty, String bkgAvalRfQty, String bkgAvalTtlWgt, String mnlAlocRmk, String alocUsrId, String alocGdt, String slsAqCd, String fcastTtlQty, String fcast40ftHcQty, String fcast45ftHcQty, String fcastRfQty, String fcastTtlWgt, String usdBkgTtlQty, String usdBkg20ftQty, String usdBkg40ftQty, String usdBkg40ftHcQty, String usdBkg45ftHcQty, String usdBkgRfQty, String usdBkgTtlWgt, String spcCtrlAlocRmk, String spcCtrlAlocPolRmk, String spcCtrlAlocPodRmk, String creUsrId, String creDt, String updUsrId, String updDt, String modeRmk, String usdBkg53ftQty, String asgn53ftQty, String bkgAval53ftQty, String fcast53ftQty
			, String newVslVd, String newSkdVoyNo, String newSkdDirCd
			, String year, String week, String office, String lane, String bound, String fcast,
			String usMod, String accountCd, String asgnD2Qty, String asgnD4Qty,
			String asgnRdQty, String usdBkgD2Qty, String usdBkgD4Qty, String usdBkgRdQty, 
			String fcastD2Qty,String fcastD4Qty, String fcastRdQty, String bkgAvalD2Qty, String bkgAvalD4Qty, String bkgAvalRdQty, 
			String ctrtNo, String alocMdfy, String bsTeu, String bsWgt, String podCd, String ctrlLvl, String chkPort, String ctrlWt) {
		this.vslCd = vslCd;
		this.bkgAval40ftQty = bkgAval40ftQty;
		this.asgnTtlWgt = asgnTtlWgt;
		this.spcCtrlAlocPodRmk = spcCtrlAlocPodRmk;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.asgnRfQty = asgnRfQty;
		this.usdBkg40ftQty = usdBkg40ftQty;
		this.bkgAvalTtlWgt = bkgAvalTtlWgt;
		this.pagerows = pagerows;
		this.spcCtrlAlocRmk = spcCtrlAlocRmk;
		this.mnlAlocRmk = mnlAlocRmk;
		this.slsOfcCd = slsOfcCd;
		this.alocUsrId = alocUsrId;
		this.asgn40ftQty = asgn40ftQty;
		this.usdBkg40ftHcQty = usdBkg40ftHcQty;
		this.bkgAvalRfQty = bkgAvalRfQty;
		this.updUsrId = updUsrId;
		this.slsAqCd = slsAqCd;
		this.asgn20ftQty = asgn20ftQty;
		this.skdVoyNo = skdVoyNo;
		this.slsRhqCd = slsRhqCd;
		this.fcastRfQty = fcastRfQty;
		this.creUsrId = creUsrId;
		this.usdBkg45ftHcQty = usdBkg45ftHcQty;
		this.alocGdt = alocGdt;
		this.fcast40ftHcQty = fcast40ftHcQty;
		this.subTrdCd = subTrdCd;
		this.asgn45ftHcQty = asgn45ftHcQty;
		this.creDt = creDt;
		this.usdBkg20ftQty = usdBkg20ftQty;
		this.bkgAval40ftHcQty = bkgAval40ftHcQty;
		this.asgnTtlQty = asgnTtlQty;
		this.ibflag = ibflag;
		this.tsFlg = tsFlg.replace('1', 'Y').replace('0', 'N');
		this.fcastTtlQty = fcastTtlQty;
		this.usdBkgTtlQty = usdBkgTtlQty;
		this.usdBkgRfQty = usdBkgRfQty;
		this.dirCd = dirCd;
		this.fcastTtlWgt = fcastTtlWgt;
		this.spcCtrlAlocPolRmk = spcCtrlAlocPolRmk;
		this.podYdCd = podYdCd;
		this.updDt = updDt;
		this.iocCd = iocCd;
		this.asgn40ftHcQty = asgn40ftHcQty;
		this.skdDirCd = skdDirCd;
		this.bkgAvalTtlQty = bkgAvalTtlQty;
		this.bkgAval45ftHcQty = bkgAval45ftHcQty;
		this.bkgAval20ftQty = bkgAval20ftQty;
		this.fcast45ftHcQty = fcast45ftHcQty;
		this.polYdCd = polYdCd;
		this.delYdCd = delYdCd;
		this.usdBkgTtlWgt = usdBkgTtlWgt;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.repSubTrdCd = repSubTrdCd;
		this.mnlFlg = mnlFlg.replace('1', 'Y').replace('0', 'N');
		this.modeRmk = modeRmk;
		this.usdBkg53ftQty = usdBkg53ftQty;
		this.asgn53ftQty = asgn53ftQty;
		this.bkgAval53ftQty = bkgAval53ftQty;
		this.fcast53ftQty = fcast53ftQty;
		
		this.newVslVd = newVslVd;
		this.newSkdVoyNo = newSkdVoyNo;
		this.newSkdDirCd =newSkdDirCd;
		
		
		this.year= year; 
		this.week= week; 
		this.office= office; 
		this.lane= lane; 
		this.bound= bound;
		this.fcast= fcast;
		
		this.usMod = usMod;
		this.accountCd = accountCd;
		this.delYdCd = delYdCd;
		this.asgnD2Qty = asgnD2Qty; 
		this.asgnD4Qty = asgnD4Qty;
		this.asgnRdQty = asgnRdQty;
		this.usdBkgD2Qty = usdBkgD2Qty;
		this.usdBkgD4Qty = usdBkgD4Qty;
		this.usdBkgRdQty = usdBkgRdQty;
		this.fcastD2Qty = fcastD2Qty;
		this.fcastD4Qty = fcastD4Qty;
		this.fcastRdQty = fcastRdQty;
		
		this.bkgAvalD2Qty = bkgAvalD2Qty;
		this.bkgAvalD4Qty = bkgAvalD4Qty;
		this.bkgAvalRdQty = bkgAvalRdQty;
		this.ctrtNo = ctrtNo;
		
		this.bsTeu = bsTeu;	
		this.bsWgt = bsWgt;
		this.podCd = podCd;
		this.ctrlLvl = ctrlLvl;
		this.chkPort = chkPort;
		
		this.alocMdfy = alocMdfy;
		this.ctrlWt = ctrlWt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_aval_40ft_qty", getBkgAval40ftQty());
		this.hashColumns.put("asgn_ttl_wgt", getAsgnTtlWgt());
		this.hashColumns.put("spc_ctrl_aloc_pod_rmk", getSpcCtrlAlocPodRmk());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("asgn_rf_qty", getAsgnRfQty());
		this.hashColumns.put("usd_bkg_40ft_qty", getUsdBkg40ftQty());
		this.hashColumns.put("bkg_aval_ttl_wgt", getBkgAvalTtlWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spc_ctrl_aloc_rmk", getSpcCtrlAlocRmk());
		this.hashColumns.put("mnl_aloc_rmk", getMnlAlocRmk());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("aloc_usr_id", getAlocUsrId());
		this.hashColumns.put("asgn_40ft_qty", getAsgn40ftQty());
		this.hashColumns.put("usd_bkg_40ft_hc_qty", getUsdBkg40ftHcQty());
		this.hashColumns.put("bkg_aval_rf_qty", getBkgAvalRfQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sls_aq_cd", getSlsAqCd());
		this.hashColumns.put("asgn_20ft_qty", getAsgn20ftQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("fcast_rf_qty", getFcastRfQty());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usd_bkg_45ft_hc_qty", getUsdBkg45ftHcQty());
		this.hashColumns.put("aloc_gdt", getAlocGdt());
		this.hashColumns.put("fcast_40ft_hc_qty", getFcast40ftHcQty());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("asgn_45ft_hc_qty", getAsgn45ftHcQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("usd_bkg_20ft_qty", getUsdBkg20ftQty());
		this.hashColumns.put("bkg_aval_40ft_hc_qty", getBkgAval40ftHcQty());
		this.hashColumns.put("asgn_ttl_qty", getAsgnTtlQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("fcast_ttl_qty", getFcastTtlQty());
		this.hashColumns.put("usd_bkg_ttl_qty", getUsdBkgTtlQty());
		this.hashColumns.put("usd_bkg_rf_qty", getUsdBkgRfQty());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("fcast_ttl_wgt", getFcastTtlWgt());
		this.hashColumns.put("spc_ctrl_aloc_pol_rmk", getSpcCtrlAlocPolRmk());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("asgn_40ft_hc_qty", getAsgn40ftHcQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bkg_aval_ttl_qty", getBkgAvalTtlQty());
		this.hashColumns.put("bkg_aval_45ft_hc_qty", getBkgAval45ftHcQty());
		this.hashColumns.put("bkg_aval_20ft_qty", getBkgAval20ftQty());
		this.hashColumns.put("fcast_45ft_hc_qty", getFcast45ftHcQty());
		this.hashColumns.put("pol_cd", getPolYdCd());
		this.hashColumns.put("del_cd", getDelYdCd());
		this.hashColumns.put("usd_bkg_ttl_wgt", getUsdBkgTtlWgt());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		this.hashColumns.put("mode_rmk", getModeRmk());
		this.hashColumns.put("usd_bkg_53ft_qty", getUsdBkg53ftQty());
		this.hashColumns.put("asgn_53ft_qty", getAsgn53ftQty());
		this.hashColumns.put("bkg_aval_53ft_qty", getBkgAval53ftQty());
		this.hashColumns.put("fcast_53ft_qty", getFcast53ftQty());
		
		this.hashColumns.put("newVslVd", getNewVslVd() );
		this.hashColumns.put("newSkdVoyNo", getNewSkdVoyNo() );
		this.hashColumns.put("newSkdDirCd", getNewSkdDirCd() );
				
		this.hashColumns.put("year", getYear() );
		this.hashColumns.put("week", getWeek() );
		this.hashColumns.put("office", getOffice() );
		this.hashColumns.put("lane", getLane() );
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("fcast", getFcast() );
		
		this.hashColumns.put("us_mod", getUsMod() );
		this.hashColumns.put("account_cd", getAccountCd() );
		//this.hashColumns.put("del_cd", getDelYdCd() );
		this.hashColumns.put("asgn_d2_qty", getAsgnD2Qty() );
		this.hashColumns.put("asgn_d4_qty", getAsgnD4Qty() );
		this.hashColumns.put("asgn_rd_qty", getAsgnRdQty() );
		this.hashColumns.put("usd_bkg_d2_qty", getUsdBkgD2Qty() );
		this.hashColumns.put("usd_bkg_d4_qty", getUsdBkgD4Qty() );
		this.hashColumns.put("usd_bkg_rd_qty", getUsdBkgRdQty() );
		this.hashColumns.put("fcast_d2_qty", getFcastD2Qty() );
		this.hashColumns.put("fcast_d4_qty", getFcastD4Qty() );
		this.hashColumns.put("fcast_rd_qty", getFcastRdQty() );
		
		this.hashColumns.put("bkg_aval_d2_qty", getBkgAvalD2Qty() );
		this.hashColumns.put("bkg_aval_d4_qty", getBkgAvalD4Qty() );
		this.hashColumns.put("bkg_aval_rd_qty", getBkgAvalRdQty() );
		

		this.hashColumns.put("ctrt_no", getCtrtNo() );
		
		this.hashColumns.put("aloc_mdfy", getAlocMdfy() );
		this.hashColumns.put("bs_teu", getBsTeu() );
		this.hashColumns.put("bs_wgt", getBsWgt() );
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ctrl_lvl", getCtrlLvl());
		this.hashColumns.put("chk_port", getChkPort());
		this.hashColumns.put("ctrl_wt", getCtrlWt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_aval_40ft_qty", "bkgAval40ftQty");
		this.hashFields.put("asgn_ttl_wgt", "asgnTtlWgt");
		this.hashFields.put("spc_ctrl_aloc_pod_rmk", "spcCtrlAlocPodRmk");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("asgn_rf_qty", "asgnRfQty");
		this.hashFields.put("usd_bkg_40ft_qty", "usdBkg40ftQty");
		this.hashFields.put("bkg_aval_ttl_wgt", "bkgAvalTtlWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spc_ctrl_aloc_rmk", "spcCtrlAlocRmk");
		this.hashFields.put("mnl_aloc_rmk", "mnlAlocRmk");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("aloc_usr_id", "alocUsrId");
		this.hashFields.put("asgn_40ft_qty", "asgn40ftQty");
		this.hashFields.put("usd_bkg_40ft_hc_qty", "usdBkg40ftHcQty");
		this.hashFields.put("bkg_aval_rf_qty", "bkgAvalRfQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sls_aq_cd", "slsAqCd");
		this.hashFields.put("asgn_20ft_qty", "asgn20ftQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("fcast_rf_qty", "fcastRfQty");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usd_bkg_45ft_hc_qty", "usdBkg45ftHcQty");
		this.hashFields.put("aloc_gdt", "alocGdt");
		this.hashFields.put("fcast_40ft_hc_qty", "fcast40ftHcQty");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("asgn_45ft_hc_qty", "asgn45ftHcQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("usd_bkg_20ft_qty", "usdBkg20ftQty");
		this.hashFields.put("bkg_aval_40ft_hc_qty", "bkgAval40ftHcQty");
		this.hashFields.put("asgn_ttl_qty", "asgnTtlQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("fcast_ttl_qty", "fcastTtlQty");
		this.hashFields.put("usd_bkg_ttl_qty", "usdBkgTtlQty");
		this.hashFields.put("usd_bkg_rf_qty", "usdBkgRfQty");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("fcast_ttl_wgt", "fcastTtlWgt");
		this.hashFields.put("spc_ctrl_aloc_pol_rmk", "spcCtrlAlocPolRmk");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("asgn_40ft_hc_qty", "asgn40ftHcQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bkg_aval_ttl_qty", "bkgAvalTtlQty");
		this.hashFields.put("bkg_aval_45ft_hc_qty", "bkgAval45ftHcQty");
		this.hashFields.put("bkg_aval_20ft_qty", "bkgAval20ftQty");
		this.hashFields.put("fcast_45ft_hc_qty", "fcast45ftHcQty");
		this.hashFields.put("pol_cd", "polYdCd");
		this.hashFields.put("del_cd", "delYdCd");
		this.hashFields.put("usd_bkg_ttl_wgt", "usdBkgTtlWgt");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		this.hashFields.put("mnl_flg", "mnlFlg");
		this.hashFields.put("mode_rmk", "modeRmk");
		this.hashFields.put("usd_bkg_53ft_qty", "usdBkg53ftQty");
		this.hashFields.put("asgn_53ft_qty", "asgn53ftQty");
		this.hashFields.put("bkg_aval_53ft_qty", "bkgAval53ftQty");
		this.hashFields.put("fcast_53ft_qty", "fcast53ftQty");
		
		this.hashFields.put("newVslVd", "newVslVd");
		this.hashFields.put("newSkdVoyNo", "newSkdVoyNo");
		this.hashFields.put("newSkdDirCd", "newSkdDirCd");
		
		
		this.hashFields.put("year", "year");
		this.hashFields.put("week", "week");
		this.hashFields.put("office", "office");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("fcast", "fcast");
		
		
		this.hashFields.put("us_mod", "usMod");
		this.hashFields.put("account_cd", "accountCd");
		//this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("asgn_d2_qty", "asgnD2Qty");
		this.hashFields.put("asgn_d4_qty", "asgnD4Qty");
		this.hashFields.put("asgn_rd_qty", "asgnRdQty");
		this.hashFields.put("usd_bkg_d2_qty", "usdBkgD2Qty");
		this.hashFields.put("usd_bkg_d4_qty", "usdBkgD4Qty");
		this.hashFields.put("usd_bkg_rd_qty", "usdBkgRdQty");
		this.hashFields.put("fcast_d2_qty", "fcastD2Qty");
		this.hashFields.put("fcast_d4_qty", "fcastD4Qty");
		this.hashFields.put("fcast_rd_qty", "fcastRdQty");
		
		this.hashFields.put("bkg_aval_d2_qty", "bkgAvalD2Qty");
		this.hashFields.put("bkg_aval_d4_qty", "bkgAvalD4Qty");
		this.hashFields.put("bkg_aval_rd_qty", "bkgAvalRdQty");

		this.hashFields.put("ctrt_no", "ctrtNo");
		
		this.hashFields.put("aloc_mdfy", "alocMdfy");

		this.hashFields.put("bs_teu", "bsTeu");
		this.hashFields.put("bs_wgt", "bsWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ctrl_lvl", "ctrlLvl");
		this.hashFields.put("chk_port", "chkPort");
		this.hashFields.put("ctrl_wt", "ctrlWt");		
		return this.hashFields;
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
	 * @return bkgAval40ftQty
	 */
	public String getBkgAval40ftQty() {
		return this.bkgAval40ftQty;
	}
	
	/**
	 * Column Info
	 * @return asgnTtlWgt
	 */
	public String getAsgnTtlWgt() {
		return this.asgnTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return spcCtrlAlocPodRmk
	 */
	public String getSpcCtrlAlocPodRmk() {
		return this.spcCtrlAlocPodRmk;
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
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
	}
	
	/**
	 * Column Info
	 * @return asgnRfQty
	 */
	public String getAsgnRfQty() {
		return this.asgnRfQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkg40ftQty
	 */
	public String getUsdBkg40ftQty() {
		return this.usdBkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAvalTtlWgt
	 */
	public String getBkgAvalTtlWgt() {
		return this.bkgAvalTtlWgt;
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
	 * @return spcCtrlAlocRmk
	 */
	public String getSpcCtrlAlocRmk() {
		return this.spcCtrlAlocRmk;
	}
	
	/**
	 * Column Info
	 * @return mnlAlocRmk
	 */
	public String getMnlAlocRmk() {
		return this.mnlAlocRmk;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return alocUsrId
	 */
	public String getAlocUsrId() {
		return this.alocUsrId;
	}
	
	/**
	 * Column Info
	 * @return asgn40ftQty
	 */
	public String getAsgn40ftQty() {
		return this.asgn40ftQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkg40ftHcQty
	 */
	public String getUsdBkg40ftHcQty() {
		return this.usdBkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAvalRfQty
	 */
	public String getBkgAvalRfQty() {
		return this.bkgAvalRfQty;
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
	 * @return slsAqCd
	 */
	public String getSlsAqCd() {
		return this.slsAqCd;
	}
	
	/**
	 * Column Info
	 * @return asgn20ftQty
	 */
	public String getAsgn20ftQty() {
		return this.asgn20ftQty;
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
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @return fcastRfQty
	 */
	public String getFcastRfQty() {
		return this.fcastRfQty;
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
	 * @return usdBkg45ftHcQty
	 */
	public String getUsdBkg45ftHcQty() {
		return this.usdBkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return alocGdt
	 */
	public String getAlocGdt() {
		return this.alocGdt;
	}
	
	/**
	 * Column Info
	 * @return fcast40ftHcQty
	 */
	public String getFcast40ftHcQty() {
		return this.fcast40ftHcQty;
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
	 * @return asgn45ftHcQty
	 */
	public String getAsgn45ftHcQty() {
		return this.asgn45ftHcQty;
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
	 * @return usdBkg20ftQty
	 */
	public String getUsdBkg20ftQty() {
		return this.usdBkg20ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAval40ftHcQty
	 */
	public String getBkgAval40ftHcQty() {
		return this.bkgAval40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return asgnTtlQty
	 */
	public String getAsgnTtlQty() {
		return this.asgnTtlQty;
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
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
	}
	
	/**
	 * Column Info
	 * @return fcastTtlQty
	 */
	public String getFcastTtlQty() {
		return this.fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgTtlQty
	 */
	public String getUsdBkgTtlQty() {
		return this.usdBkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgRfQty
	 */
	public String getUsdBkgRfQty() {
		return this.usdBkgRfQty;
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
	 * @return fcastTtlWgt
	 */
	public String getFcastTtlWgt() {
		return this.fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return spcCtrlAlocPolRmk
	 */
	public String getSpcCtrlAlocPolRmk() {
		return this.spcCtrlAlocPolRmk;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return asgn40ftHcQty
	 */
	public String getAsgn40ftHcQty() {
		return this.asgn40ftHcQty;
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
	 * @return bkgAvalTtlQty
	 */
	public String getBkgAvalTtlQty() {
		return this.bkgAvalTtlQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAval45ftHcQty
	 */
	public String getBkgAval45ftHcQty() {
		return this.bkgAval45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAval20ftQty
	 */
	public String getBkgAval20ftQty() {
		return this.bkgAval20ftQty;
	}
	
	/**
	 * Column Info
	 * @return fcast45ftHcQty
	 */
	public String getFcast45ftHcQty() {
		return this.fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return delYdCd
	 */
	public String getDelYdCd() {
		return this.delYdCd;
	}
	
	/**
	 * Column Info
	 * @return usdBkgTtlWgt
	 */
	public String getUsdBkgTtlWgt() {
		return this.usdBkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
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
	 * @return mnlFlg
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
	}
	
	/**
	 * 
	 * @return modeRmk
	 */
	public String getModeRmk() {
		return this.modeRmk;
	}
	
	/**
	 * Column Info
	 * @return usdBkg53ftQty
	 */
	public String getUsdBkg53ftQty() {
		return this.usdBkg53ftQty;
	}
	
	/**
	 * Column Info
	 * @return asgn53ftQty
	 */
	public String getAsgn53ftQty() {
		return this.asgn53ftQty;
	}
	
	/**
	 * Column Info
	 * @return bkgAval53ftQty
	 */
	public String getBkgAval53ftQty() {
		return this.bkgAval53ftQty;
	}
	
	/**
	 * Column Info
	 * @return fcast53ftQty
	 */
	public String getFcast53ftQty() {
		return this.fcast53ftQty;
	}
	
	/**
	 * Column Info
	 * @return asgnD2Qty
	 */
	public String getAsgnD2Qty() {
		return this.asgnD2Qty;
	}
	
	/**
	 * Column Info
	 * @return asgnD4Qty
	 */
	public String getAsgnD4Qty() {
		return this.asgnD4Qty;
	}
	
	/**
	 * Column Info
	 * @return asgnRdQty
	 */
	public String getAsgnRdQty() {
		return this.asgnRdQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgD2Qty
	 */
	public String getUsdBkgD2Qty() {
		return this.usdBkgD2Qty;
	}
	/**
	 * Column Info
	 * @return usdBkgD4Qty
	 */
	public String getUsdBkgD4Qty() {
		return this.usdBkgD4Qty;
	}
	/**
	 * Column Info
	 * @return usdBkgRdQty
	 */
	public String getUsdBkgRdQty() {
		return this.usdBkgRdQty;
	}
	/**
	 * Column Info
	 * @return fcastD2Qty
	 */
	public String getFcastD2Qty() {
		return this.fcastD2Qty;
	}
	/**
	 * Column Info
	 * @return fcastD4Qty
	 */
	public String getFcastD4Qty() {
		return this.fcastD4Qty;
	}
	/**
	 * Column Info
	 * @return fcastRdQty
	 */
	
	public String getFcastRdQty() {
		return this.fcastRdQty;
	}
	/**
	 * Column Info
	 * @return usMod
	 */
	public String getUsMod() {
		return this.usMod;
	}
	/**
	 * Column Info
	 * @return accountCd
	 */
	public String getAccountCd() {
		return this.accountCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return bsTeu
	 */
	public String getBsTeu() {
		return this.bsTeu;
	}
	
	/**
	 * Column Info
	 * @return bsWgt
	 */
	public String getBsWgt() {
		return this.bsWgt;
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
	 * @return ctrlLvl
	 */
	public String getCtrlLvl() {
		return this.ctrlLvl;
	}
	
	/**
	 * Column Info
	 * @return ctrlLvl
	 */
	public String getChkPort() {
		return this.chkPort;
	}
	
	/**
	 * Column Info
	 * @return ctrlWt
	 */
	public String getCtrlWt() {
		return this.ctrlWt;
	}

	//	/**
//	 * Column Info
//	 * @return delCd
//	 */
//	public String getDelCd() {
//		return this.delCd;
//	}

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param bkgAval40ftQty
	 */
	public void setBkgAval40ftQty(String bkgAval40ftQty) {
		this.bkgAval40ftQty = bkgAval40ftQty;
	}
	
	/**
	 * Column Info
	 * @param asgnTtlWgt
	 */
	public void setAsgnTtlWgt(String asgnTtlWgt) {
		this.asgnTtlWgt = asgnTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param spcCtrlAlocPodRmk
	 */
	public void setSpcCtrlAlocPodRmk(String spcCtrlAlocPodRmk) {
		this.spcCtrlAlocPodRmk = spcCtrlAlocPodRmk;
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
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
	}
	
	/**
	 * Column Info
	 * @param asgnRfQty
	 */
	public void setAsgnRfQty(String asgnRfQty) {
		this.asgnRfQty = asgnRfQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkg40ftQty
	 */
	public void setUsdBkg40ftQty(String usdBkg40ftQty) {
		this.usdBkg40ftQty = usdBkg40ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAvalTtlWgt
	 */
	public void setBkgAvalTtlWgt(String bkgAvalTtlWgt) {
		this.bkgAvalTtlWgt = bkgAvalTtlWgt;
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
	 * @param spcCtrlAlocRmk
	 */
	public void setSpcCtrlAlocRmk(String spcCtrlAlocRmk) {
		this.spcCtrlAlocRmk = spcCtrlAlocRmk;
	}
	
	/**
	 * Column Info
	 * @param mnlAlocRmk
	 */
	public void setMnlAlocRmk(String mnlAlocRmk) {
		this.mnlAlocRmk = mnlAlocRmk;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param alocUsrId
	 */
	public void setAlocUsrId(String alocUsrId) {
		this.alocUsrId = alocUsrId;
	}
	
	/**
	 * Column Info
	 * @param asgn40ftQty
	 */
	public void setAsgn40ftQty(String asgn40ftQty) {
		this.asgn40ftQty = asgn40ftQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkg40ftHcQty
	 */
	public void setUsdBkg40ftHcQty(String usdBkg40ftHcQty) {
		this.usdBkg40ftHcQty = usdBkg40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAvalRfQty
	 */
	public void setBkgAvalRfQty(String bkgAvalRfQty) {
		this.bkgAvalRfQty = bkgAvalRfQty;
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
	 * @param slsAqCd
	 */
	public void setSlsAqCd(String slsAqCd) {
		this.slsAqCd = slsAqCd;
	}
	
	/**
	 * Column Info
	 * @param asgn20ftQty
	 */
	public void setAsgn20ftQty(String asgn20ftQty) {
		this.asgn20ftQty = asgn20ftQty;
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
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}
	
	/**
	 * Column Info
	 * @param fcastRfQty
	 */
	public void setFcastRfQty(String fcastRfQty) {
		this.fcastRfQty = fcastRfQty;
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
	 * @param usdBkg45ftHcQty
	 */
	public void setUsdBkg45ftHcQty(String usdBkg45ftHcQty) {
		this.usdBkg45ftHcQty = usdBkg45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param alocGdt
	 */
	public void setAlocGdt(String alocGdt) {
		this.alocGdt = alocGdt;
	}
	
	/**
	 * Column Info
	 * @param fcast40ftHcQty
	 */
	public void setFcast40ftHcQty(String fcast40ftHcQty) {
		this.fcast40ftHcQty = fcast40ftHcQty;
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
	 * @param asgn45ftHcQty
	 */
	public void setAsgn45ftHcQty(String asgn45ftHcQty) {
		this.asgn45ftHcQty = asgn45ftHcQty;
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
	 * @param usdBkg20ftQty
	 */
	public void setUsdBkg20ftQty(String usdBkg20ftQty) {
		this.usdBkg20ftQty = usdBkg20ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAval40ftHcQty
	 */
	public void setBkgAval40ftHcQty(String bkgAval40ftHcQty) {
		this.bkgAval40ftHcQty = bkgAval40ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param asgnTtlQty
	 */
	public void setAsgnTtlQty(String asgnTtlQty) {
		this.asgnTtlQty = asgnTtlQty;
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
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg.replace('1', 'Y').replace('0', 'N');;
	}
	
	/**
	 * Column Info
	 * @param fcastTtlQty
	 */
	public void setFcastTtlQty(String fcastTtlQty) {
		this.fcastTtlQty = fcastTtlQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkgTtlQty
	 */
	public void setUsdBkgTtlQty(String usdBkgTtlQty) {
		this.usdBkgTtlQty = usdBkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @param usdBkgRfQty
	 */
	public void setUsdBkgRfQty(String usdBkgRfQty) {
		this.usdBkgRfQty = usdBkgRfQty;
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
	 * @param fcastTtlWgt
	 */
	public void setFcastTtlWgt(String fcastTtlWgt) {
		this.fcastTtlWgt = fcastTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param spcCtrlAlocPolRmk
	 */
	public void setSpcCtrlAlocPolRmk(String spcCtrlAlocPolRmk) {
		this.spcCtrlAlocPolRmk = spcCtrlAlocPolRmk;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param asgn40ftHcQty
	 */
	public void setAsgn40ftHcQty(String asgn40ftHcQty) {
		this.asgn40ftHcQty = asgn40ftHcQty;
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
	 * @param bkgAvalTtlQty
	 */
	public void setBkgAvalTtlQty(String bkgAvalTtlQty) {
		this.bkgAvalTtlQty = bkgAvalTtlQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAval45ftHcQty
	 */
	public void setBkgAval45ftHcQty(String bkgAval45ftHcQty) {
		this.bkgAval45ftHcQty = bkgAval45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAval20ftQty
	 */
	public void setBkgAval20ftQty(String bkgAval20ftQty) {
		this.bkgAval20ftQty = bkgAval20ftQty;
	}
	
	/**
	 * Column Info
	 * @param fcast45ftHcQty
	 */
	public void setFcast45ftHcQty(String fcast45ftHcQty) {
		this.fcast45ftHcQty = fcast45ftHcQty;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param delYdCd
	 */
	public void setDelYdCd(String delYdCd) {
		this.delYdCd = delYdCd;
	}
	
	/**
	 * Column Info
	 * @param usdBkgTtlWgt
	 */
	public void setUsdBkgTtlWgt(String usdBkgTtlWgt) {
		this.usdBkgTtlWgt = usdBkgTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
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
	 * @param mnlFlg
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg.replace('1', 'Y').replace('0', 'N');;
	}
	
	/**
	 * 
	 * @param modeRmk
	 */
	public void setModeRmk(String modeRmk) {
		this.modeRmk = modeRmk;
	}
	
	/**
	 * Column Info
	 * @param usdBkg53ftQty
	 */
	public void setUsdBkg53ftQty(String usdBkg53ftQty) {
		this.usdBkg53ftQty = usdBkg53ftQty;
	}
	
	/**
	 * Column Info
	 * @param asgn53ftQty
	 */
	public void setAsgn53ftQty(String asgn53ftQty) {
		this.asgn53ftQty = asgn53ftQty;
	}
	
	/**
	 * Column Info
	 * @param bkgAval53ftQty
	 */
	public void setBkgAval53ftQty(String bkgAval53ftQty) {
		this.bkgAval53ftQty = bkgAval53ftQty;
	}
	
	/**
	 * Column Info
	 * @param fcast53ftQty
	 */
	public void setFcast53ftQty(String fcast53ftQty) {
		this.fcast53ftQty = fcast53ftQty;
	}
	

	/**
	 * Column Info
	 */
	public String getNewVslVd() {
		return newVslVd;
	}

	/**
	 * Column Info
	 * @param newVslVd
	 */
	public void setNewVslVd(String newVslVd) {
		this.newVslVd = newVslVd;
	}

	/**
	 * Column Info
	 */
	public String getNewSkdVoyNo() {
		return newSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setNewSkdVoyNo(String newSkdVoyNo) {
		this.newSkdVoyNo = newSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public String getWeek() {
		return week;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setWeek(String week) {
		this.week = week;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public String getLane() {
		return lane;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public String getBound() {
		return bound;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public String getFcast() {
		return fcast;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setFcast(String fcast) {
		this.fcast = fcast;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public String getNewSkdDirCd() {
		return newSkdDirCd;
	}

	/**
	 * Column Info
	 * @param newSkdVoyNo
	 */
	public void setNewSkdDirCd(String newSkdDirCd) {
		this.newSkdDirCd = newSkdDirCd;
	}
	
	
	
	/**
	 * Column Info
	 * @return asgnD2Qty
	 */
	public void setAsgnD2Qty(String asgnD2Qty) {
		this.asgnD2Qty = asgnD2Qty;
	}
	
	/**
	 * Column Info
	 * @return asgnD4Qty
	 */
	public void setAsgnD4Qty(String asgnD4Qty) {
		this.asgnD4Qty = asgnD4Qty;
	}
	
	/**
	 * Column Info
	 * @return asgnRdQty
	 */
	public void setAsgnRdQty(String asgnRdQty) {
		this.asgnRdQty = asgnRdQty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgD2Qty
	 */
	public void setUsdBkgD2Qty(String usdBkgD2Qty) {
		this.usdBkgD2Qty = usdBkgD2Qty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgD4Qty
	 */
	public void setUsdBkgD4Qty(String usdBkgD4Qty) {
		this.usdBkgD4Qty = usdBkgD4Qty;
	}
	
	/**
	 * Column Info
	 * @return usdBkgRdQty
	 */
	public void setUsdBkgRdQty(String usdBkgRdQty) {
		this.usdBkgRdQty = usdBkgRdQty;
	}
	
	/**
	 * Column Info
	 * @return fcastD2Qty
	 */
	public void setFcastD2Qty(String fcastD2Qty) {
		this.fcastD2Qty = fcastD2Qty;
	}
	
	/**
	 * Column Info
	 * @return fcastD4Qty
	 */
	public void setFcastD4Qty(String fcastD4Qty) {
		this.fcastD4Qty = fcastD4Qty;
	}
	
	/**
	 * Column Info
	 * @return fcastRdQty
	 */
	public void setFcastRdQty(String fcastRdQty) {
		this.fcastRdQty = fcastRdQty;
	}
	
	/**
	 * Column Info
	 * @return usMod
	 */
	public void setUsMod(String usMod) {
		this.usMod = usMod;
	}
	
	/**
	 * Column Info
	 * @return accountCd
	 */
	public void setAccountCd(String accountCd) {
		this.accountCd = accountCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
//	/**
//	 * Column Info
//	 * @return delCd
//	 */
//	public void setDelCd(String delCd) {
//		this.delCd = delCd;
//	}

	
	/**
	 * Column Info
	 * @param bkgAvalD2Qty
	 */
	public String getBkgAvalD2Qty() {
		return bkgAvalD2Qty;
	}

	/**
	 * Column Info
	 * @param bkgAvalD2Qty
	 */
	public void setBkgAvalD2Qty(String bkgAvalD2Qty) {
		this.bkgAvalD2Qty = bkgAvalD2Qty;
	}
	
	
	
	/**
	 * Column Info
	 * @param bkgAvalD4Qty
	 */
	public String getBkgAvalD4Qty() {
		return bkgAvalD4Qty;
	}

	/**
	 * Column Info
	 * @param bkgAvalD4Qty
	 */
	public void setBkgAvalD4Qty(String bkgAvalD4Qty) {
		this.bkgAvalD4Qty = bkgAvalD4Qty;
	}
	
	
	
	/**
	 * Column Info
	 * @param bkgAvalRdQty
	 */
	public String getBkgAvalRdQty() {
		return bkgAvalRdQty;
	}

	/**
	 * Column Info
	 * @param bkgAvalRdQty
	 */
	public void setBkgAvalRdQty(String bkgAvalRdQty) {
		this.bkgAvalRdQty = bkgAvalRdQty;
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
	 * @param bsTeu
	 */
	public void setBsTeu(String bsTeu) {
		this.bsTeu = bsTeu;
	}
	
	/**
	 * Column Info
	 * @param bsWgt
	 */
	public void setBsWgt(String bsWgt) {
		this.bsWgt = bsWgt;
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
	 * @param ctrlLvl
	 */
	public void setCtrlLvl(String ctrlLvl) {
		this.ctrlLvl = ctrlLvl;
	}
	
	/**
	 * Column Info
	 * @param chkPort
	 */
	public void setChkPort(String chkPort) {
		this.chkPort = chkPort;
	}
	
	/**
	 * Column Info
	 * @param chkPort
	 */
	public void setCtrlWt(String ctrlWt) {
		this.ctrlWt = ctrlWt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBkgAval40ftQty(JSPUtil.getParameter(request, "bkg_aval_40ft_qty", ""));
		setAsgnTtlWgt(JSPUtil.getParameter(request, "asgn_ttl_wgt", ""));
		setSpcCtrlAlocPodRmk(JSPUtil.getParameter(request, "spc_ctrl_aloc_pod_rmk", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, "rep_trd_cd", ""));
		setAsgnRfQty(JSPUtil.getParameter(request, "asgn_rf_qty", ""));
		setUsdBkg40ftQty(JSPUtil.getParameter(request, "usd_bkg_40ft_qty", ""));
		setBkgAvalTtlWgt(JSPUtil.getParameter(request, "bkg_aval_ttl_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSpcCtrlAlocRmk(JSPUtil.getParameter(request, "spc_ctrl_aloc_rmk", ""));
		setMnlAlocRmk(JSPUtil.getParameter(request, "mnl_aloc_rmk", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setAlocUsrId(JSPUtil.getParameter(request, "aloc_usr_id", ""));
		setAsgn40ftQty(JSPUtil.getParameter(request, "asgn_40ft_qty", ""));
		setUsdBkg40ftHcQty(JSPUtil.getParameter(request, "usd_bkg_40ft_hc_qty", ""));
		setBkgAvalRfQty(JSPUtil.getParameter(request, "bkg_aval_rf_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSlsAqCd(JSPUtil.getParameter(request, "sls_aq_cd", ""));
		setAsgn20ftQty(JSPUtil.getParameter(request, "asgn_20ft_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, "sls_rhq_cd", ""));
		setFcastRfQty(JSPUtil.getParameter(request, "fcast_rf_qty", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUsdBkg45ftHcQty(JSPUtil.getParameter(request, "usd_bkg_45ft_hc_qty", ""));
		setAlocGdt(JSPUtil.getParameter(request, "aloc_gdt", ""));
		setFcast40ftHcQty(JSPUtil.getParameter(request, "fcast_40ft_hc_qty", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setAsgn45ftHcQty(JSPUtil.getParameter(request, "asgn_45ft_hc_qty", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUsdBkg20ftQty(JSPUtil.getParameter(request, "usd_bkg_20ft_qty", ""));
		setBkgAval40ftHcQty(JSPUtil.getParameter(request, "bkg_aval_40ft_hc_qty", ""));
		setAsgnTtlQty(JSPUtil.getParameter(request, "asgn_ttl_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTsFlg(JSPUtil.getParameter(request, "ts_flg", ""));
		setFcastTtlQty(JSPUtil.getParameter(request, "fcast_ttl_qty", ""));
		setUsdBkgTtlQty(JSPUtil.getParameter(request, "usd_bkg_ttl_qty", ""));
		setUsdBkgRfQty(JSPUtil.getParameter(request, "usd_bkg_rf_qty", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setFcastTtlWgt(JSPUtil.getParameter(request, "fcast_ttl_wgt", ""));
		setSpcCtrlAlocPolRmk(JSPUtil.getParameter(request, "spc_ctrl_aloc_pol_rmk", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setAsgn40ftHcQty(JSPUtil.getParameter(request, "asgn_40ft_hc_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setBkgAvalTtlQty(JSPUtil.getParameter(request, "bkg_aval_ttl_qty", ""));
		setBkgAval45ftHcQty(JSPUtil.getParameter(request, "bkg_aval_45ft_hc_qty", ""));
		setBkgAval20ftQty(JSPUtil.getParameter(request, "bkg_aval_20ft_qty", ""));
		setFcast45ftHcQty(JSPUtil.getParameter(request, "fcast_45ft_hc_qty", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDelYdCd(JSPUtil.getParameter(request, "del_cd", ""));
		setUsdBkgTtlWgt(JSPUtil.getParameter(request, "usd_bkg_ttl_wgt", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, "sls_rgn_ofc_cd", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, "rep_sub_trd_cd", ""));
		setMnlFlg(JSPUtil.getParameter(request, "mnl_flg", ""));
		setModeRmk(JSPUtil.getParameter(request, "mode_rmk", ""));
		setUsdBkg53ftQty(JSPUtil.getParameter(request, "usd_bkg_53ft_qty", ""));
		setAsgn53ftQty(JSPUtil.getParameter(request, "asgn_53ft_qty", ""));
		setBkgAval53ftQty(JSPUtil.getParameter(request, "bkg_aval_53ft_qty", ""));
		setFcast53ftQty(JSPUtil.getParameter(request, "fcast_53ft_qty", ""));
		
		setNewVslVd(JSPUtil.getParameter(request, "newVslVd", ""));
		setNewSkdVoyNo(JSPUtil.getParameter(request, "newSkdVoyNo", ""));
		setNewSkdDirCd(JSPUtil.getParameter(request, "newSkdDirCd", ""));
		

		setYear(JSPUtil.getParameter(request, "year", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setFcast(JSPUtil.getParameter(request, "fcast", ""));
		
		
		setAsgnD2Qty(JSPUtil.getParameter(request, "asgn_d2_qty", ""));
		setAsgnD4Qty(JSPUtil.getParameter(request, "asgn_d4_qty", ""));
		setAsgnRdQty(JSPUtil.getParameter(request, "asgn_rd_qty", ""));
		setUsdBkgD2Qty(JSPUtil.getParameter(request, "usd_bkg_d2_qty", ""));
		setUsdBkgD4Qty(JSPUtil.getParameter(request, "usd_bkg_d4_qty", ""));
		setUsdBkgRdQty(JSPUtil.getParameter(request, "usd_bkg_rd_qty", ""));
		setFcastD2Qty(JSPUtil.getParameter(request, "fcast_d2_qty", ""));
		setFcastD4Qty(JSPUtil.getParameter(request, "fcast_d4_qty", ""));
		setFcastRdQty(JSPUtil.getParameter(request, "fcast_rd_qty", ""));
		setUsMod(JSPUtil.getParameter(request, "us_mod", ""));
		setAccountCd(JSPUtil.getParameter(request, "account_cd", ""));
//		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		
		setBkgAvalD2Qty(JSPUtil.getParameter(request, "bkg_aval_d2_qty", ""));
		setBkgAvalD4Qty(JSPUtil.getParameter(request, "bkg_aval_d4_qty", ""));
		setBkgAvalRdQty(JSPUtil.getParameter(request, "bkg_aval_rd_qty", ""));
		
		setCtrtNo(JSPUtil.getParameter(request, "ctrt_no", ""));
		
		setAlocMdfy(JSPUtil.getParameter(request, "aloc_mdfy", ""));

		setBsTeu(JSPUtil.getParameter(request, "bs_teu", ""));
		setBsWgt(JSPUtil.getParameter(request, "bs_wgt", ""));
		setPodCd(JSPUtil.getParameter(request,  "pod_cd", ""));
		setCtrlLvl(JSPUtil.getParameter(request,  "ctrl_lvl", ""));
		setChkPort(JSPUtil.getParameter(request,  "chk_port", ""));
		setCtrlWt(JSPUtil.getParameter(request,  "ctrl_wt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcAlocPolPodVO[]
	 */
	public SpcAlocPolPodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcAlocPolPodVO[]
	 */
	public SpcAlocPolPodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcAlocPolPodVO model = null;		
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
		
  		if(tmp == null)
   			return null;
	
  		int length = request.getParameterValues(prefix + "ibflag").length;
  	
		try {
			String[] vslCd             = (JSPUtil.getParameter(request, prefix	+ "vsl_cd"               , length));
			String[] bkgAval40ftQty    = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_40ft_qty"    , length));
			String[] asgnTtlWgt        = (JSPUtil.getParameter(request, prefix	+ "asgn_ttl_wgt"         , length));
			String[] spcCtrlAlocPodRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_pod_rmk", length));
			String[] trdCd             = (JSPUtil.getParameter(request, prefix	+ "trd_cd"               , length));
			String[] rlaneCd           = (JSPUtil.getParameter(request, prefix	+ "rlane_cd"             , length));
			String[] repTrdCd          = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd"           , length));
			String[] asgnRfQty         = (JSPUtil.getParameter(request, prefix	+ "asgn_rf_qty"          , length));
			String[] usdBkg40ftQty     = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_qty"     , length));
			String[] bkgAvalTtlWgt     = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_ttl_wgt"     , length));
			String[] pagerows          = (JSPUtil.getParameter(request, prefix	+ "pagerows"             , length));
			String[] spcCtrlAlocRmk    = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_rmk"    , length));
			String[] mnlAlocRmk        = (JSPUtil.getParameter(request, prefix	+ "mnl_aloc_rmk"         , length));
			String[] slsOfcCd          = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd"           , length));
			String[] alocUsrId         = (JSPUtil.getParameter(request, prefix	+ "aloc_usr_id"          , length));
			String[] asgn40ftQty       = (JSPUtil.getParameter(request, prefix	+ "asgn_40ft_qty"        , length));
			String[] usdBkg40ftHcQty   = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_40ft_hc_qty"  , length));
			String[] bkgAvalRfQty      = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_rf_qty"      , length));
			String[] updUsrId          = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id"           , length));
			String[] slsAqCd           = (JSPUtil.getParameter(request, prefix	+ "sls_aq_cd"            , length));
			String[] asgn20ftQty       = (JSPUtil.getParameter(request, prefix	+ "asgn_20ft_qty"        , length));
			String[] skdVoyNo          = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no"           , length));
			String[] slsRhqCd          = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd"           , length));
			String[] fcastRfQty        = (JSPUtil.getParameter(request, prefix	+ "fcast_rf_qty"         , length));
			String[] creUsrId          = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id"           , length));
			String[] usdBkg45ftHcQty   = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_45ft_hc_qty"  , length));
			String[] alocGdt           = (JSPUtil.getParameter(request, prefix	+ "aloc_gdt"             , length));
			String[] fcast40ftHcQty    = (JSPUtil.getParameter(request, prefix	+ "fcast_40ft_hc_qty"    , length));
			String[] subTrdCd          = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd"           , length));
			String[] asgn45ftHcQty     = (JSPUtil.getParameter(request, prefix	+ "asgn_45ft_hc_qty"     , length));
			String[] creDt             = (JSPUtil.getParameter(request, prefix	+ "cre_dt"               , length));
			String[] usdBkg20ftQty     = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_20ft_qty"     , length));
			String[] bkgAval40ftHcQty  = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_40ft_hc_qty" , length));
			String[] asgnTtlQty        = (JSPUtil.getParameter(request, prefix	+ "asgn_ttl_qty"         , length));
			String[] ibflag            = (JSPUtil.getParameter(request, prefix	+ "ibflag"               , length));
			String[] tsFlg             = (JSPUtil.getParameter(request, prefix	+ "ts_flg"               , length));
			String[] fcastTtlQty       = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_qty"        , length));
			String[] usdBkgTtlQty      = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_qty"      , length));
			String[] usdBkgRfQty       = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_rf_qty"       , length));
			String[] dirCd             = (JSPUtil.getParameter(request, prefix	+ "dir_cd"               , length));
			String[] fcastTtlWgt       = (JSPUtil.getParameter(request, prefix	+ "fcast_ttl_wgt"        , length));
			String[] spcCtrlAlocPolRmk = (JSPUtil.getParameter(request, prefix	+ "spc_ctrl_aloc_pol_rmk", length));
			String[] podYdCd           = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd"               , length));
			String[] updDt             = (JSPUtil.getParameter(request, prefix	+ "upd_dt"               , length));
			String[] iocCd             = (JSPUtil.getParameter(request, prefix	+ "ioc_cd"               , length));
			String[] asgn40ftHcQty     = (JSPUtil.getParameter(request, prefix	+ "asgn_40ft_hc_qty"     , length));
			String[] skdDirCd          = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd"           , length));
			String[] bkgAvalTtlQty     = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_ttl_qty"     , length));
			String[] bkgAval45ftHcQty  = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_45ft_hc_qty" , length));
			String[] bkgAval20ftQty    = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_20ft_qty"    , length));
			String[] fcast45ftHcQty    = (JSPUtil.getParameter(request, prefix	+ "fcast_45ft_hc_qty"    , length));
			String[] polYdCd           = (JSPUtil.getParameter(request, prefix	+ "pol_cd"               , length));
			String[] delYdCd           = (JSPUtil.getParameter(request, prefix	+ "del_cd"               , length));
			String[] usdBkgTtlWgt      = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_ttl_wgt"      , length));
			String[] slsRgnOfcCd       = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd"       , length));
			String[] repSubTrdCd       = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd"       , length));
			String[] mnlFlg            = (JSPUtil.getParameter(request, prefix	+ "mnl_flg"              , length));
			String[] modeRmk           = (JSPUtil.getParameter(request, prefix	+ "mode_rmk"             , length));
			String[] usdBkg53ftQty     = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_53ft_qty"     , length));
			String[] asgn53ftQty       = (JSPUtil.getParameter(request, prefix	+ "asgn_53ft_qty"        , length));
			String[] bkgAval53ftQty    = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_53ft_qty"    , length));
			String[] fcast53ftQty      = (JSPUtil.getParameter(request, prefix	+ "fcast_53ft_qty"    , length));
			
			String[] newVslVd    		= (JSPUtil.getParameter(request, prefix	+ "newVslVd"    , length));
			String[] newSkdVoyNo    	= (JSPUtil.getParameter(request, prefix	+ "newSkdVoyNo"    , length));
			String[] newSkdDirCd    	= (JSPUtil.getParameter(request, prefix	+ "newSkdDirCd"    , length));
					

			String[] year    		= (JSPUtil.getParameter(request, prefix	+ "year"    , length));
			String[] week    		= (JSPUtil.getParameter(request, prefix	+ "week"    , length));
			String[] office    		= (JSPUtil.getParameter(request, prefix	+ "office"    , length));
			String[] lane    		= (JSPUtil.getParameter(request, prefix	+ "lane"    , length));
			String[] bound    		= (JSPUtil.getParameter(request, prefix	+ "bound"    , length));
			String[] fcast    		= (JSPUtil.getParameter(request, prefix	+ "fcast"    , length));
			
			String[] asgnD2Qty     = (JSPUtil.getParameter(request, prefix	+ "asgn_d2_qty"    , length));
			String[] asgnD4Qty     = (JSPUtil.getParameter(request, prefix	+ "asgn_d4_qty"    , length));
			String[] asgnRdQty     = (JSPUtil.getParameter(request, prefix	+ "asgn_rd_qty"    , length));
			String[] usdBkgD2Qty   = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_d2_qty"    , length));
			String[] usdBkgD4Qty   = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_d4_qty"    , length));
			String[] usdBkgRdQty   = (JSPUtil.getParameter(request, prefix	+ "usd_bkg_rd_qty"    , length));
			String[] fcastD2Qty    = (JSPUtil.getParameter(request, prefix	+ "fcast_d2_qty"    , length));
			String[] fcastD4Qty    = (JSPUtil.getParameter(request, prefix	+ "fcast_d4_qty"    , length));
			String[] fcastRdQty    = (JSPUtil.getParameter(request, prefix	+ "fcast_rd_qty"    , length));
			String[] usMod    	   = (JSPUtil.getParameter(request, prefix	+ "us_mod"    , length));
			String[] accountCd     = (JSPUtil.getParameter(request, prefix	+ "account_cd"    , length));
			String[] delCd    	   = (JSPUtil.getParameter(request, prefix	+ "del_cd"    , length));
			
			String[] bkgAvalD2Qty  = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_d2_qty"    , length));
			String[] bkgAvalD4Qty  = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_d4_qty"    , length));
			String[] bkgAvalRdQty  = (JSPUtil.getParameter(request, prefix	+ "bkg_aval_rd_qty"    , length));

			String[] ctrtNo  = (JSPUtil.getParameter(request, prefix	+ "ctrt_no"    , length));
			
			String[] alocMdfy = (JSPUtil.getParameter(request, prefix	+ "aloc_mdfy"    , length));

			String[] bsTeu  = (JSPUtil.getParameter(request, prefix	+ "bs_teu"    , length));
			String[] bsWgt  = (JSPUtil.getParameter(request, prefix	+ "bs_wgt"    , length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ctrlLvl = (JSPUtil.getParameter(request, prefix	+ "ctrl_lvl", length));
			String[] chkPort = (JSPUtil.getParameter(request, prefix	+ "chk_port", length));
			String[] ctrlWt = (JSPUtil.getParameter(request, prefix	+ "ctrl_wt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcAlocPolPodVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgAval40ftQty[i] != null)
					model.setBkgAval40ftQty(bkgAval40ftQty[i]);
				if (asgnTtlWgt[i] != null)
					model.setAsgnTtlWgt(asgnTtlWgt[i]);
				if (spcCtrlAlocPodRmk[i] != null)
					model.setSpcCtrlAlocPodRmk(spcCtrlAlocPodRmk[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (asgnRfQty[i] != null)
					model.setAsgnRfQty(asgnRfQty[i]);
				if (usdBkg40ftQty[i] != null)
					model.setUsdBkg40ftQty(usdBkg40ftQty[i]);
				if (bkgAvalTtlWgt[i] != null)
					model.setBkgAvalTtlWgt(bkgAvalTtlWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spcCtrlAlocRmk[i] != null)
					model.setSpcCtrlAlocRmk(spcCtrlAlocRmk[i]);
				if (mnlAlocRmk[i] != null)
					model.setMnlAlocRmk(mnlAlocRmk[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (alocUsrId[i] != null)
					model.setAlocUsrId(alocUsrId[i]);
				if (asgn40ftQty[i] != null)
					model.setAsgn40ftQty(asgn40ftQty[i]);
				if (usdBkg40ftHcQty[i] != null)
					model.setUsdBkg40ftHcQty(usdBkg40ftHcQty[i]);
				if (bkgAvalRfQty[i] != null)
					model.setBkgAvalRfQty(bkgAvalRfQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (slsAqCd[i] != null)
					model.setSlsAqCd(slsAqCd[i]);
				if (asgn20ftQty[i] != null)
					model.setAsgn20ftQty(asgn20ftQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (fcastRfQty[i] != null)
					model.setFcastRfQty(fcastRfQty[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usdBkg45ftHcQty[i] != null)
					model.setUsdBkg45ftHcQty(usdBkg45ftHcQty[i]);
				if (alocGdt[i] != null)
					model.setAlocGdt(alocGdt[i]);
				if (fcast40ftHcQty[i] != null)
					model.setFcast40ftHcQty(fcast40ftHcQty[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (asgn45ftHcQty[i] != null)
					model.setAsgn45ftHcQty(asgn45ftHcQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (usdBkg20ftQty[i] != null)
					model.setUsdBkg20ftQty(usdBkg20ftQty[i]);
				if (bkgAval40ftHcQty[i] != null)
					model.setBkgAval40ftHcQty(bkgAval40ftHcQty[i]);
				if (asgnTtlQty[i] != null)
					model.setAsgnTtlQty(asgnTtlQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (fcastTtlQty[i] != null)
					model.setFcastTtlQty(fcastTtlQty[i]);
				if (usdBkgTtlQty[i] != null)
					model.setUsdBkgTtlQty(usdBkgTtlQty[i]);
				if (usdBkgRfQty[i] != null)
					model.setUsdBkgRfQty(usdBkgRfQty[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (fcastTtlWgt[i] != null)
					model.setFcastTtlWgt(fcastTtlWgt[i]);
				if (spcCtrlAlocPolRmk[i] != null)
					model.setSpcCtrlAlocPolRmk(spcCtrlAlocPolRmk[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (asgn40ftHcQty[i] != null)
					model.setAsgn40ftHcQty(asgn40ftHcQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bkgAvalTtlQty[i] != null)
					model.setBkgAvalTtlQty(bkgAvalTtlQty[i]);
				if (bkgAval45ftHcQty[i] != null)
					model.setBkgAval45ftHcQty(bkgAval45ftHcQty[i]);
				if (bkgAval20ftQty[i] != null)
					model.setBkgAval20ftQty(bkgAval20ftQty[i]);
				if (fcast45ftHcQty[i] != null)
					model.setFcast45ftHcQty(fcast45ftHcQty[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (delYdCd[i] != null)
					model.setDelYdCd(delYdCd[i]);
				if (usdBkgTtlWgt[i] != null)
					model.setUsdBkgTtlWgt(usdBkgTtlWgt[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (repSubTrdCd[i] != null)
					model.setRepSubTrdCd(repSubTrdCd[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				if (modeRmk[i] != null)
					model.setModeRmk(modeRmk[i]);
				if (usdBkg53ftQty[i] != null)
					model.setUsdBkg53ftQty(usdBkg53ftQty[i]);
				if (asgn53ftQty[i] != null)
					model.setAsgn53ftQty(asgn53ftQty[i]);
				if (bkgAval53ftQty[i] != null)
					model.setBkgAval53ftQty(bkgAval53ftQty[i]);
				if (fcast53ftQty[i] != null)
					model.setFcast53ftQty(fcast53ftQty[i]);
				
				if (newVslVd[i] != null)
					model.setNewVslVd(newVslVd[i]);
				if (newSkdVoyNo[i] != null)
					model.setNewSkdVoyNo(newSkdVoyNo[i]);
				if (newSkdDirCd[i] != null)
					model.setNewSkdDirCd(newSkdDirCd[i]);
				
				if (year[i] != null)
					model.setYear(year[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (fcast[i] != null)
					model.setFcast(fcast[i]);
				
				if (asgnD2Qty[i] != null)
					model.setAsgnD2Qty(asgnD2Qty[i]);
				if (asgnD4Qty[i] != null)
					model.setAsgnD4Qty(asgnD4Qty[i]);
				if (asgnRdQty[i] != null)
					model.setAsgnRdQty(asgnRdQty[i]);
				if (usdBkgD2Qty[i] != null)
					model.setUsdBkgD2Qty(usdBkgD2Qty[i]);
				if (usdBkgD4Qty[i] != null)
					model.setUsdBkgD4Qty(usdBkgD4Qty[i]);
				if (usdBkgRdQty[i] != null)
					model.setUsdBkgRdQty(usdBkgRdQty[i]);
				if (fcastD2Qty[i] != null)
					model.setFcastD2Qty(fcastD2Qty[i]);
				if (fcastD4Qty[i] != null)
					model.setFcastD4Qty(fcastD4Qty[i]);
				if (fcastRdQty[i] != null)
					model.setFcastRdQty(fcastRdQty[i]);
				if (usMod[i] != null)
					model.setUsMod(usMod[i]);
				if (accountCd[i] != null)
					model.setAccountCd(accountCd[i]);
				if (delYdCd[i] != null)
					model.setDelYdCd(delYdCd[i]);
				
				if (bkgAvalD2Qty[i] != null)
					model.setBkgAvalD2Qty(bkgAvalD2Qty[i]);
				if (bkgAvalD4Qty[i] != null)
					model.setBkgAvalD4Qty(bkgAvalD4Qty[i]);
				if (bkgAvalRdQty[i] != null)
					model.setBkgAvalRdQty(bkgAvalRdQty[i]);
				
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				
				if (alocMdfy[i] != null)
					model.setAlocMdfy(alocMdfy[i]);

				if (bsTeu[i] != null)
					model.setBsTeu(bsTeu[i]);
				if (bsWgt[i] != null)
					model.setBsWgt(bsWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ctrlLvl[i] != null)
					model.setCtrlLvl(ctrlLvl[i]);
				if (chkPort[i] != null)
					model.setChkPort(chkPort[i]);
				if (ctrlWt[i] != null)
					model.setCtrlWt(ctrlWt[i]);
				
				models.add(model);
			}
			

		} catch (Exception e) {
			return null;
		}
		return getSpcAlocPolPodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcAlocPolPodVO[]
	 */
	public SpcAlocPolPodVO[] getSpcAlocPolPodVOs(){
		SpcAlocPolPodVO[] vos = (SpcAlocPolPodVO[])models.toArray(new SpcAlocPolPodVO[models.size()]);
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
		this.vslCd             = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAval40ftQty    = this.bkgAval40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnTtlWgt        = this.asgnTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocPodRmk = this.spcCtrlAlocPodRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd             = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd           = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd          = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnRfQty         = this.asgnRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftQty     = this.usdBkg40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvalTtlWgt     = this.bkgAvalTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows          = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocRmk    = this.spcCtrlAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlAlocRmk        = this.mnlAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd          = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocUsrId         = this.alocUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn40ftQty       = this.asgn40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg40ftHcQty   = this.usdBkg40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvalRfQty      = this.bkgAvalRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId          = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsAqCd           = this.slsAqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn20ftQty       = this.asgn20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo          = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd          = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRfQty        = this.fcastRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId          = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg45ftHcQty   = this.usdBkg45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocGdt           = this.alocGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast40ftHcQty    = this.fcast40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd          = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn45ftHcQty     = this.asgn45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt             = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg20ftQty     = this.usdBkg20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAval40ftHcQty  = this.bkgAval40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnTtlQty        = this.asgnTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag            = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg             = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlQty       = this.fcastTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlQty      = this.usdBkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgRfQty       = this.usdBkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd             = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastTtlWgt       = this.fcastTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcCtrlAlocPolRmk = this.spcCtrlAlocPolRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd           = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt             = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd             = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn40ftHcQty     = this.asgn40ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd          = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvalTtlQty     = this.bkgAvalTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAval45ftHcQty  = this.bkgAval45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAval20ftQty    = this.bkgAval20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast45ftHcQty    = this.fcast45ftHcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd           = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCd           = this.delYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgTtlWgt      = this.usdBkgTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd       = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd       = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg            = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modeRmk           = this.modeRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkg53ftQty     = this.usdBkg53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgn53ftQty       = this.asgn53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAval53ftQty    = this.bkgAval53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast53ftQty      = this.fcast53ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.newVslVd       = this.newVslVd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSkdVoyNo    = this.newSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newSkdDirCd    = this.newSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.year    = this.year.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week    = this.week.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office    = this.office.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane    = this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound    = this.bound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcast    = this.fcast.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.asgnD2Qty    = this.asgnD2Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnD4Qty    = this.asgnD4Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asgnRdQty    = this.asgnRdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgD2Qty    = this.usdBkgD2Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgD4Qty    = this.usdBkgD4Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdBkgRdQty    = this.usdBkgRdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastD2Qty    = this.fcastD2Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastD4Qty    = this.fcastD4Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRdQty    = this.fcastRdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usMod    = this.usMod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountCd    = this.accountCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdCd    = this.delYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.bkgAvalD2Qty    = this.bkgAvalD2Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvalD4Qty    = this.bkgAvalD4Qty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAvalRdQty    = this.bkgAvalRdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo    = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocMdfy    = this.alocMdfy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsTeu    = this.bsTeu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsWgt    = this.bsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.ctrlLvl = this.ctrlLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.chkPort = this.chkPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.ctrlWt = this.ctrlWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
	

}
