/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgListForCompFirmBySPCVO.java
*@FileTitle : BkgListForCompFirmBySPCVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.07.12 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForCompFirmBySPCVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForCompFirmBySPCVO> models = new ArrayList<BkgListForCompFirmBySPCVO>();
	
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cnddtCfmFlg = null;
	/* Column Info */
	private String trnkPol = null;
	/* Column Info */
	private String delLocCd = null;
	/* Column Info */
	private String tsSlanCd = null;
	/* Column Info */
	private String trnkPod = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String feu = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String slsRhqCd = null;
	/* Column Info */
	private String trnkSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podLocCd = null;
	/* Column Info */
	private String aCust = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Column Info */
	private String bkgVvdCd = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String standbyType = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String yrMonWk = null;
	/* Column Info */
	private String standbyReason = null;
	/* Column Info */
	private String fwdr = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cfmRqstFlg = null;
	/* Column Info */
	private String week = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lstSbRsnTpCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String cCust = null;
	/* Column Info */
	private String alocStsCd = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String fLevel = null;
	/* Column Info */
	private String ton = null;
	/* Column Info */
	private String dgrd = null;
	/* Column Info */
	private String porSccCd = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String delSccCd = null;
	/* Column Info */
	private String tsPolCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String sName = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String trnkDirCd = null;
	/* Column Info */
	private String lstSbRmk = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String porLocCd = null;
	/* Column Info */
	private String tsPodCd = null;
	/* Column Info */
	private String tsDirCd = null;
	/* Column Info */
	private String polLocCd = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgListForCompFirmBySPCVO() {}

	public BkgListForCompFirmBySPCVO(String ibflag, String pagerows, String aCust, String alocStsCd, String alocSvcCd, String bkgAlocTpCd, String bkgNo, String bkgStsCd, String bkgVvdCd, String blNo, String cCust, String cfmDt, String cfmRqstFlg, String cfmUsrId, String cmdtCd, String cmdtDesc, String cnddtCfmFlg, String cnee, String cntrTpszCd, String delLocCd, String delNodCd, String delSccCd, String dgrd, String dirCd, String duration, String fLevel, String feu, String fwdr, String lstSbRmk, String lstSbRsnTpCd, String obSlsOfcCd, String podLocCd, String podNodCd, String polLocCd, String polNodCd, String porLocCd, String porNodCd, String porSccCd, String rfaNo, String rlaneCd, String sName, String scNo, String slsRhqCd, String standbyReason, String standbyType, String subTrdCd, String teu, String ton, String tpSz, String trdCd, String trnkDirCd, String trnkPod, String trnkPol, String trnkSlanCd, String tsDirCd, String tsPodCd, String tsPolCd, String tsSlanCd, String usrOfcCd, String week, String year, String yrMonWk, String cfmFlg) {
		this.rlaneCd = rlaneCd;
		this.scNo = scNo;
		this.blNo = blNo;
		this.year = year;
		this.bkgNo = bkgNo;
		this.cnddtCfmFlg = cnddtCfmFlg;
		this.trnkPol = trnkPol;
		this.delLocCd = delLocCd;
		this.tsSlanCd = tsSlanCd;
		this.trnkPod = trnkPod;
		this.polNodCd = polNodCd;
		this.feu = feu;
		this.alocSvcCd = alocSvcCd;
		this.slsRhqCd = slsRhqCd;
		this.trnkSlanCd = trnkSlanCd;
		this.pagerows = pagerows;
		this.podLocCd = podLocCd;
		this.aCust = aCust;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.bkgVvdCd = bkgVvdCd;
		this.teu = teu;
		this.cfmFlg = cfmFlg;
		this.standbyType = standbyType;
		this.delNodCd = delNodCd;
		this.yrMonWk = yrMonWk;
		this.standbyReason = standbyReason;
		this.fwdr = fwdr;
		this.porNodCd = porNodCd;
		this.trdCd = trdCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.tpSz = tpSz;
		this.cfmUsrId = cfmUsrId;
		this.subTrdCd = subTrdCd;
		this.rfaNo = rfaNo;
		this.cfmDt = cfmDt;
		this.cntrTpszCd = cntrTpszCd;
		this.cfmRqstFlg = cfmRqstFlg;
		this.week = week;
		this.ibflag = ibflag;
		this.lstSbRsnTpCd = lstSbRsnTpCd;
		this.podNodCd = podNodCd;
		this.cCust = cCust;
		this.alocStsCd = alocStsCd;
		this.duration = duration;
		this.fLevel = fLevel;
		this.ton = ton;
		this.dgrd = dgrd;
		this.porSccCd = porSccCd;
		this.usrOfcCd = usrOfcCd;
		this.delSccCd = delSccCd;
		this.tsPolCd = tsPolCd;
		this.cmdtCd = cmdtCd;
		this.cnee = cnee;
		this.sName = sName;
		this.cmdtDesc = cmdtDesc;
		this.trnkDirCd = trnkDirCd;
		this.lstSbRmk = lstSbRmk;
		this.bkgStsCd = bkgStsCd;
		this.porLocCd = porLocCd;
		this.tsPodCd = tsPodCd;
		this.tsDirCd = tsDirCd;
		this.polLocCd = polLocCd;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnddt_cfm_flg", getCnddtCfmFlg());
		this.hashColumns.put("trnk_pol", getTrnkPol());
		this.hashColumns.put("del_loc_cd", getDelLocCd());
		this.hashColumns.put("ts_slan_cd", getTsSlanCd());
		this.hashColumns.put("trnk_pod", getTrnkPod());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("trnk_slan_cd", getTrnkSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_loc_cd", getPodLocCd());
		this.hashColumns.put("a_cust", getACust());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("standby_type", getStandbyType());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("yr_mon_wk", getYrMonWk());
		this.hashColumns.put("standby_reason", getStandbyReason());
		this.hashColumns.put("fwdr", getFwdr());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cfm_rqst_flg", getCfmRqstFlg());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lst_sb_rsn_tp_cd", getLstSbRsnTpCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("c_cust", getCCust());
		this.hashColumns.put("aloc_sts_cd", getAlocStsCd());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("f_level", getFLevel());
		this.hashColumns.put("ton", getTon());
		this.hashColumns.put("dgrd", getDgrd());
		this.hashColumns.put("por_scc_cd", getPorSccCd());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("del_scc_cd", getDelSccCd());
		this.hashColumns.put("ts_pol_cd", getTsPolCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("s_name", getSName());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("trnk_dir_cd", getTrnkDirCd());
		this.hashColumns.put("lst_sb_rmk", getLstSbRmk());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("por_loc_cd", getPorLocCd());
		this.hashColumns.put("ts_pod_cd", getTsPodCd());
		this.hashColumns.put("ts_dir_cd", getTsDirCd());
		this.hashColumns.put("pol_loc_cd", getPolLocCd());
		this.hashColumns.put("dir_cd", getDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("year", "year");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnddt_cfm_flg", "cnddtCfmFlg");
		this.hashFields.put("trnk_pol", "trnkPol");
		this.hashFields.put("del_loc_cd", "delLocCd");
		this.hashFields.put("ts_slan_cd", "tsSlanCd");
		this.hashFields.put("trnk_pod", "trnkPod");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("feu", "feu");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("trnk_slan_cd", "trnkSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_loc_cd", "podLocCd");
		this.hashFields.put("a_cust", "aCust");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("standby_type", "standbyType");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("yr_mon_wk", "yrMonWk");
		this.hashFields.put("standby_reason", "standbyReason");
		this.hashFields.put("fwdr", "fwdr");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cfm_rqst_flg", "cfmRqstFlg");
		this.hashFields.put("week", "week");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lst_sb_rsn_tp_cd", "lstSbRsnTpCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("c_cust", "cCust");
		this.hashFields.put("aloc_sts_cd", "alocStsCd");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("f_level", "fLevel");
		this.hashFields.put("ton", "ton");
		this.hashFields.put("dgrd", "dgrd");
		this.hashFields.put("por_scc_cd", "porSccCd");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("del_scc_cd", "delSccCd");
		this.hashFields.put("ts_pol_cd", "tsPolCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("s_name", "sName");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("trnk_dir_cd", "trnkDirCd");
		this.hashFields.put("lst_sb_rmk", "lstSbRmk");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("por_loc_cd", "porLocCd");
		this.hashFields.put("ts_pod_cd", "tsPodCd");
		this.hashFields.put("ts_dir_cd", "tsDirCd");
		this.hashFields.put("pol_loc_cd", "polLocCd");
		this.hashFields.put("dir_cd", "dirCd");
		return this.hashFields;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
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
	 * @return year
	 */
	public String getYear() {
		return this.year;
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
	 * @return cnddtCfmFlg
	 */
	public String getCnddtCfmFlg() {
		return this.cnddtCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return trnkPol
	 */
	public String getTrnkPol() {
		return this.trnkPol;
	}
	
	/**
	 * Column Info
	 * @return delLocCd
	 */
	public String getDelLocCd() {
		return this.delLocCd;
	}
	
	/**
	 * Column Info
	 * @return tsSlanCd
	 */
	public String getTsSlanCd() {
		return this.tsSlanCd;
	}
	
	/**
	 * Column Info
	 * @return trnkPod
	 */
	public String getTrnkPod() {
		return this.trnkPod;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
	}
	
	/**
	 * Column Info
	 * @return alocSvcCd
	 */
	public String getAlocSvcCd() {
		return this.alocSvcCd;
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
	 * @return trnkSlanCd
	 */
	public String getTrnkSlanCd() {
		return this.trnkSlanCd;
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
	 * @return podLocCd
	 */
	public String getPodLocCd() {
		return this.podLocCd;
	}
	
	/**
	 * Column Info
	 * @return aCust
	 */
	public String getACust() {
		return this.aCust;
	}
	
	/**
	 * Column Info
	 * @return bkgAlocTpCd
	 */
	public String getBkgAlocTpCd() {
		return this.bkgAlocTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgVvdCd
	 */
	public String getBkgVvdCd() {
		return this.bkgVvdCd;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return standbyType
	 */
	public String getStandbyType() {
		return this.standbyType;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return yrMonWk
	 */
	public String getYrMonWk() {
		return this.yrMonWk;
	}
	
	/**
	 * Column Info
	 * @return standbyReason
	 */
	public String getStandbyReason() {
		return this.standbyReason;
	}
	
	/**
	 * Column Info
	 * @return fwdr
	 */
	public String getFwdr() {
		return this.fwdr;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
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
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
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
	 * @return cfmRqstFlg
	 */
	public String getCfmRqstFlg() {
		return this.cfmRqstFlg;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
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
	 * @return lstSbRsnTpCd
	 */
	public String getLstSbRsnTpCd() {
		return this.lstSbRsnTpCd;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return cCust
	 */
	public String getCCust() {
		return this.cCust;
	}
	
	/**
	 * Column Info
	 * @return alocStsCd
	 */
	public String getAlocStsCd() {
		return this.alocStsCd;
	}
	
	/**
	 * Column Info
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
	}
	
	/**
	 * Column Info
	 * @return fLevel
	 */
	public String getFLevel() {
		return this.fLevel;
	}
	
	/**
	 * Column Info
	 * @return ton
	 */
	public String getTon() {
		return this.ton;
	}
	
	/**
	 * Column Info
	 * @return dgrd
	 */
	public String getDgrd() {
		return this.dgrd;
	}
	
	/**
	 * Column Info
	 * @return porSccCd
	 */
	public String getPorSccCd() {
		return this.porSccCd;
	}
	
	/**
	 * Column Info
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return delSccCd
	 */
	public String getDelSccCd() {
		return this.delSccCd;
	}
	
	/**
	 * Column Info
	 * @return tsPolCd
	 */
	public String getTsPolCd() {
		return this.tsPolCd;
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
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return sName
	 */
	public String getSName() {
		return this.sName;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return trnkDirCd
	 */
	public String getTrnkDirCd() {
		return this.trnkDirCd;
	}
	
	/**
	 * Column Info
	 * @return lstSbRmk
	 */
	public String getLstSbRmk() {
		return this.lstSbRmk;
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
	 * @return porLocCd
	 */
	public String getPorLocCd() {
		return this.porLocCd;
	}
	
	/**
	 * Column Info
	 * @return tsPodCd
	 */
	public String getTsPodCd() {
		return this.tsPodCd;
	}
	
	/**
	 * Column Info
	 * @return tsDirCd
	 */
	public String getTsDirCd() {
		return this.tsDirCd;
	}
	
	/**
	 * Column Info
	 * @return polLocCd
	 */
	public String getPolLocCd() {
		return this.polLocCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
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
	 * @param cnddtCfmFlg
	 */
	public void setCnddtCfmFlg(String cnddtCfmFlg) {
		this.cnddtCfmFlg = cnddtCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param trnkPol
	 */
	public void setTrnkPol(String trnkPol) {
		this.trnkPol = trnkPol;
	}
	
	/**
	 * Column Info
	 * @param delLocCd
	 */
	public void setDelLocCd(String delLocCd) {
		this.delLocCd = delLocCd;
	}
	
	/**
	 * Column Info
	 * @param tsSlanCd
	 */
	public void setTsSlanCd(String tsSlanCd) {
		this.tsSlanCd = tsSlanCd;
	}
	
	/**
	 * Column Info
	 * @param trnkPod
	 */
	public void setTrnkPod(String trnkPod) {
		this.trnkPod = trnkPod;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
	}
	
	/**
	 * Column Info
	 * @param alocSvcCd
	 */
	public void setAlocSvcCd(String alocSvcCd) {
		this.alocSvcCd = alocSvcCd;
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
	 * @param trnkSlanCd
	 */
	public void setTrnkSlanCd(String trnkSlanCd) {
		this.trnkSlanCd = trnkSlanCd;
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
	 * @param podLocCd
	 */
	public void setPodLocCd(String podLocCd) {
		this.podLocCd = podLocCd;
	}
	
	/**
	 * Column Info
	 * @param aCust
	 */
	public void setACust(String aCust) {
		this.aCust = aCust;
	}
	
	/**
	 * Column Info
	 * @param bkgAlocTpCd
	 */
	public void setBkgAlocTpCd(String bkgAlocTpCd) {
		this.bkgAlocTpCd = bkgAlocTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgVvdCd
	 */
	public void setBkgVvdCd(String bkgVvdCd) {
		this.bkgVvdCd = bkgVvdCd;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param standbyType
	 */
	public void setStandbyType(String standbyType) {
		this.standbyType = standbyType;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param yrMonWk
	 */
	public void setYrMonWk(String yrMonWk) {
		this.yrMonWk = yrMonWk;
	}
	
	/**
	 * Column Info
	 * @param standbyReason
	 */
	public void setStandbyReason(String standbyReason) {
		this.standbyReason = standbyReason;
	}
	
	/**
	 * Column Info
	 * @param fwdr
	 */
	public void setFwdr(String fwdr) {
		this.fwdr = fwdr;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
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
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
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
	 * @param cfmRqstFlg
	 */
	public void setCfmRqstFlg(String cfmRqstFlg) {
		this.cfmRqstFlg = cfmRqstFlg;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
	 * @param lstSbRsnTpCd
	 */
	public void setLstSbRsnTpCd(String lstSbRsnTpCd) {
		this.lstSbRsnTpCd = lstSbRsnTpCd;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param cCust
	 */
	public void setCCust(String cCust) {
		this.cCust = cCust;
	}
	
	/**
	 * Column Info
	 * @param alocStsCd
	 */
	public void setAlocStsCd(String alocStsCd) {
		this.alocStsCd = alocStsCd;
	}
	
	/**
	 * Column Info
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	/**
	 * Column Info
	 * @param fLevel
	 */
	public void setFLevel(String fLevel) {
		this.fLevel = fLevel;
	}
	
	/**
	 * Column Info
	 * @param ton
	 */
	public void setTon(String ton) {
		this.ton = ton;
	}
	
	/**
	 * Column Info
	 * @param dgrd
	 */
	public void setDgrd(String dgrd) {
		this.dgrd = dgrd;
	}
	
	/**
	 * Column Info
	 * @param porSccCd
	 */
	public void setPorSccCd(String porSccCd) {
		this.porSccCd = porSccCd;
	}
	
	/**
	 * Column Info
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param delSccCd
	 */
	public void setDelSccCd(String delSccCd) {
		this.delSccCd = delSccCd;
	}
	
	/**
	 * Column Info
	 * @param tsPolCd
	 */
	public void setTsPolCd(String tsPolCd) {
		this.tsPolCd = tsPolCd;
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
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param sName
	 */
	public void setSName(String sName) {
		this.sName = sName;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param trnkDirCd
	 */
	public void setTrnkDirCd(String trnkDirCd) {
		this.trnkDirCd = trnkDirCd;
	}
	
	/**
	 * Column Info
	 * @param lstSbRmk
	 */
	public void setLstSbRmk(String lstSbRmk) {
		this.lstSbRmk = lstSbRmk;
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
	 * @param porLocCd
	 */
	public void setPorLocCd(String porLocCd) {
		this.porLocCd = porLocCd;
	}
	
	/**
	 * Column Info
	 * @param tsPodCd
	 */
	public void setTsPodCd(String tsPodCd) {
		this.tsPodCd = tsPodCd;
	}
	
	/**
	 * Column Info
	 * @param tsDirCd
	 */
	public void setTsDirCd(String tsDirCd) {
		this.tsDirCd = tsDirCd;
	}
	
	/**
	 * Column Info
	 * @param polLocCd
	 */
	public void setPolLocCd(String polLocCd) {
		this.polLocCd = polLocCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setYear(JSPUtil.getParameter(request, prefix + "year", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCnddtCfmFlg(JSPUtil.getParameter(request, prefix + "cnddt_cfm_flg", ""));
		setTrnkPol(JSPUtil.getParameter(request, prefix + "trnk_pol", ""));
		setDelLocCd(JSPUtil.getParameter(request, prefix + "del_loc_cd", ""));
		setTsSlanCd(JSPUtil.getParameter(request, prefix + "ts_slan_cd", ""));
		setTrnkPod(JSPUtil.getParameter(request, prefix + "trnk_pod", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setTrnkSlanCd(JSPUtil.getParameter(request, prefix + "trnk_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodLocCd(JSPUtil.getParameter(request, prefix + "pod_loc_cd", ""));
		setACust(JSPUtil.getParameter(request, prefix + "a_cust", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setBkgVvdCd(JSPUtil.getParameter(request, prefix + "bkg_vvd_cd", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setStandbyType(JSPUtil.getParameter(request, prefix + "standby_type", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setYrMonWk(JSPUtil.getParameter(request, prefix + "yr_mon_wk", ""));
		setStandbyReason(JSPUtil.getParameter(request, prefix + "standby_reason", ""));
		setFwdr(JSPUtil.getParameter(request, prefix + "fwdr", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setTpSz(JSPUtil.getParameter(request, prefix + "tp_sz", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCfmRqstFlg(JSPUtil.getParameter(request, prefix + "cfm_rqst_flg", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLstSbRsnTpCd(JSPUtil.getParameter(request, prefix + "lst_sb_rsn_tp_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setCCust(JSPUtil.getParameter(request, prefix + "c_cust", ""));
		setAlocStsCd(JSPUtil.getParameter(request, prefix + "aloc_sts_cd", ""));
		setDuration(JSPUtil.getParameter(request, prefix + "duration", ""));
		setFLevel(JSPUtil.getParameter(request, prefix + "f_level", ""));
		setTon(JSPUtil.getParameter(request, prefix + "ton", ""));
		setDgrd(JSPUtil.getParameter(request, prefix + "dgrd", ""));
		setPorSccCd(JSPUtil.getParameter(request, prefix + "por_scc_cd", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setDelSccCd(JSPUtil.getParameter(request, prefix + "del_scc_cd", ""));
		setTsPolCd(JSPUtil.getParameter(request, prefix + "ts_pol_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setSName(JSPUtil.getParameter(request, prefix + "s_name", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setTrnkDirCd(JSPUtil.getParameter(request, prefix + "trnk_dir_cd", ""));
		setLstSbRmk(JSPUtil.getParameter(request, prefix + "lst_sb_rmk", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setPorLocCd(JSPUtil.getParameter(request, prefix + "por_loc_cd", ""));
		setTsPodCd(JSPUtil.getParameter(request, prefix + "ts_pod_cd", ""));
		setTsDirCd(JSPUtil.getParameter(request, prefix + "ts_dir_cd", ""));
		setPolLocCd(JSPUtil.getParameter(request, prefix + "pol_loc_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForCompFirmBySPCVO[]
	 */
	public BkgListForCompFirmBySPCVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForCompFirmBySPCVO[]
	 */
	public BkgListForCompFirmBySPCVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForCompFirmBySPCVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cnddtCfmFlg = (JSPUtil.getParameter(request, prefix	+ "cnddt_cfm_flg", length));
			String[] trnkPol = (JSPUtil.getParameter(request, prefix	+ "trnk_pol", length));
			String[] delLocCd = (JSPUtil.getParameter(request, prefix	+ "del_loc_cd", length));
			String[] tsSlanCd = (JSPUtil.getParameter(request, prefix	+ "ts_slan_cd", length));
			String[] trnkPod = (JSPUtil.getParameter(request, prefix	+ "trnk_pod", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] trnkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podLocCd = (JSPUtil.getParameter(request, prefix	+ "pod_loc_cd", length));
			String[] aCust = (JSPUtil.getParameter(request, prefix	+ "a_cust", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd_cd", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] standbyType = (JSPUtil.getParameter(request, prefix	+ "standby_type", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] yrMonWk = (JSPUtil.getParameter(request, prefix	+ "yr_mon_wk", length));
			String[] standbyReason = (JSPUtil.getParameter(request, prefix	+ "standby_reason", length));
			String[] fwdr = (JSPUtil.getParameter(request, prefix	+ "fwdr", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cfmRqstFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_rqst_flg", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lstSbRsnTpCd = (JSPUtil.getParameter(request, prefix	+ "lst_sb_rsn_tp_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] cCust = (JSPUtil.getParameter(request, prefix	+ "c_cust", length));
			String[] alocStsCd = (JSPUtil.getParameter(request, prefix	+ "aloc_sts_cd", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] fLevel = (JSPUtil.getParameter(request, prefix	+ "f_level", length));
			String[] ton = (JSPUtil.getParameter(request, prefix	+ "ton", length));
			String[] dgrd = (JSPUtil.getParameter(request, prefix	+ "dgrd", length));
			String[] porSccCd = (JSPUtil.getParameter(request, prefix	+ "por_scc_cd", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] delSccCd = (JSPUtil.getParameter(request, prefix	+ "del_scc_cd", length));
			String[] tsPolCd = (JSPUtil.getParameter(request, prefix	+ "ts_pol_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] sName = (JSPUtil.getParameter(request, prefix	+ "s_name", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] trnkDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_dir_cd", length));
			String[] lstSbRmk = (JSPUtil.getParameter(request, prefix	+ "lst_sb_rmk", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] porLocCd = (JSPUtil.getParameter(request, prefix	+ "por_loc_cd", length));
			String[] tsPodCd = (JSPUtil.getParameter(request, prefix	+ "ts_pod_cd", length));
			String[] tsDirCd = (JSPUtil.getParameter(request, prefix	+ "ts_dir_cd", length));
			String[] polLocCd = (JSPUtil.getParameter(request, prefix	+ "pol_loc_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForCompFirmBySPCVO();
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cnddtCfmFlg[i] != null)
					model.setCnddtCfmFlg(cnddtCfmFlg[i]);
				if (trnkPol[i] != null)
					model.setTrnkPol(trnkPol[i]);
				if (delLocCd[i] != null)
					model.setDelLocCd(delLocCd[i]);
				if (tsSlanCd[i] != null)
					model.setTsSlanCd(tsSlanCd[i]);
				if (trnkPod[i] != null)
					model.setTrnkPod(trnkPod[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (trnkSlanCd[i] != null)
					model.setTrnkSlanCd(trnkSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podLocCd[i] != null)
					model.setPodLocCd(podLocCd[i]);
				if (aCust[i] != null)
					model.setACust(aCust[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (bkgVvdCd[i] != null)
					model.setBkgVvdCd(bkgVvdCd[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (standbyType[i] != null)
					model.setStandbyType(standbyType[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (yrMonWk[i] != null)
					model.setYrMonWk(yrMonWk[i]);
				if (standbyReason[i] != null)
					model.setStandbyReason(standbyReason[i]);
				if (fwdr[i] != null)
					model.setFwdr(fwdr[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cfmRqstFlg[i] != null)
					model.setCfmRqstFlg(cfmRqstFlg[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lstSbRsnTpCd[i] != null)
					model.setLstSbRsnTpCd(lstSbRsnTpCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (cCust[i] != null)
					model.setCCust(cCust[i]);
				if (alocStsCd[i] != null)
					model.setAlocStsCd(alocStsCd[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (fLevel[i] != null)
					model.setFLevel(fLevel[i]);
				if (ton[i] != null)
					model.setTon(ton[i]);
				if (dgrd[i] != null)
					model.setDgrd(dgrd[i]);
				if (porSccCd[i] != null)
					model.setPorSccCd(porSccCd[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (delSccCd[i] != null)
					model.setDelSccCd(delSccCd[i]);
				if (tsPolCd[i] != null)
					model.setTsPolCd(tsPolCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (sName[i] != null)
					model.setSName(sName[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (trnkDirCd[i] != null)
					model.setTrnkDirCd(trnkDirCd[i]);
				if (lstSbRmk[i] != null)
					model.setLstSbRmk(lstSbRmk[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (porLocCd[i] != null)
					model.setPorLocCd(porLocCd[i]);
				if (tsPodCd[i] != null)
					model.setTsPodCd(tsPodCd[i]);
				if (tsDirCd[i] != null)
					model.setTsDirCd(tsDirCd[i]);
				if (polLocCd[i] != null)
					model.setPolLocCd(polLocCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForCompFirmBySPCVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForCompFirmBySPCVO[]
	 */
	public BkgListForCompFirmBySPCVO[] getBkgListForCompFirmBySPCVOs(){
		BkgListForCompFirmBySPCVO[] vos = (BkgListForCompFirmBySPCVO[])models.toArray(new BkgListForCompFirmBySPCVO[models.size()]);
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
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnddtCfmFlg = this.cnddtCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkPol = this.trnkPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delLocCd = this.delLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsSlanCd = this.tsSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkPod = this.trnkPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanCd = this.trnkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocCd = this.podLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCust = this.aCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvdCd = this.bkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standbyType = this.standbyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrMonWk = this.yrMonWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standbyReason = this.standbyReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdr = this.fwdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRqstFlg = this.cfmRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSbRsnTpCd = this.lstSbRsnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCust = this.cCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocStsCd = this.alocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLevel = this.fLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ton = this.ton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgrd = this.dgrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porSccCd = this.porSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSccCd = this.delSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPolCd = this.tsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sName = this.sName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkDirCd = this.trnkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSbRmk = this.lstSbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porLocCd = this.porLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPodCd = this.tsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsDirCd = this.tsDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocCd = this.polLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
