/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchCompulsoryFirmVO.java
*@FileTitle : SearchCompulsoryFirmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.01.06 최성민 
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

public class SearchCompulsoryFirmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCompulsoryFirmVO> models = new ArrayList<SearchCompulsoryFirmVO>();
	
	/* Column Info */
	private String rfaCtrtTpCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String aCustNm = null;
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
	private String slsRhqCd = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String trnkSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podLocCd = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String aCust = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Column Info */
	private String bkgVvdCd = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String standbyType = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String yrMonWk = null;
	/* Column Info */
	private String standbyReason = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String fwdr = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String custTp = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String cfmRqstFlg = null;
	/* Column Info */
	private String week = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String cCust = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String alocStsCd = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String fLevel = null;
	/* Column Info */
	private String ton = null;
	/* Column Info */
	private String polEtb4 = null;
	/* Column Info */
	private String cgoRcvDt = null;
	/* Column Info */
	private String dgrd = null;
	/* Column Info */
	private String masCmpb = null;
	/* Column Info */
	private String polEtb2 = null;
	/* Column Info */
	private String polEtb3 = null;
	/* Column Info */
	private String polEtb1 = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String porSccCd = null;
	/* Column Info */
	private String shrpNm = null;
	/* Column Info */
	private String delSccCd = null;
	/* Column Info */
	private String tsPolCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String usaBkgModCd = null;
	/* Column Info */
	private String sName = null;
	/* Column Info */
	private String trnkDirCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String lstSbRmk = null;
	/* Column Info */
	private String tsPodCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String porLocCd = null;
	/* Column Info */
	private String tsDirCd = null;
	/* Column Info */
	private String polLocCd = null;
	/* Column Info */
	private String cmpb = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String initCmpb = null;
	/* Column Info */
	private String fwdrNm = null;
	/* Column Info */
	private String lstSbOtrRsn = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String ctrtOfcCd = null;

	   /* Column Info */
    private String stwgCd = null;
    
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchCompulsoryFirmVO() {}

	public SearchCompulsoryFirmVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String fLevel, String blNo, String alocStsCd, String usrOfcCd, String scNo, String cntrTpszCd, String tsDirCd, String cfmUsrId, String delNodCd, String obSlsOfcCd, String year, String podLocCd, String trnkPol, String feu, String delLocCd, String cfmDt, String trnkDirCd, String cCust, String slsRhqCd, String standbyReason, String delSccCd, String bkgNo, String podNodCd, String cmdtDesc, String porSccCd, String trnkPod, String teu, String tsPodCd, String subTrdCd, String bkgStsCd, String aCust, String rfaNo, String cmdtCd, String trnkSlanCd, String ton, String dirCd, String bkgAlocTpCd, String tsPolCd, String porNodCd, String alocSvcCd, String polNodCd, String tsSlanCd, String standbyType, String fwdr, String cfmRqstFlg, String porLocCd, String cnddtCfmFlg, String polLocCd, String duration, String yrMonWk, String cnee, String dgrd, String sName, String bkgVvdCd, String week, String cmpb, String vvd, String initCmpb, String masCmpb, String bkgCreDt, String lstSbOtrRsn, String cCustNm, String aCustNm, String shrpNm, String cneeNm, String fwdrNm, String custTp, String custCtrlCd, String acctCd, String pol1, String pol2, String pol3, String pol4, String polEtb1, String polEtb2, String polEtb3, String polEtb4, String vvd1, String vvd2, String vvd3, String vvd4, String lstSbRmk, String usaBkgModCd, String blObrdDt, String cgoRcvDt, String rfaCtrtTpCd) {
		this.rfaCtrtTpCd = rfaCtrtTpCd;
		this.rlaneCd = rlaneCd;
		this.scNo = scNo;
		this.aCustNm = aCustNm;
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
		this.slsRhqCd = slsRhqCd;
		this.alocSvcCd = alocSvcCd;
		this.trnkSlanCd = trnkSlanCd;
		this.pagerows = pagerows;
		this.podLocCd = podLocCd;
		this.blObrdDt = blObrdDt;
		this.aCust = aCust;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.bkgVvdCd = bkgVvdCd;
		this.teu = teu;
		this.vvd = vvd;
		this.vvd4 = vvd4;
		this.standbyType = standbyType;
		this.delNodCd = delNodCd;
		this.yrMonWk = yrMonWk;
		this.standbyReason = standbyReason;
		this.porNodCd = porNodCd;
		this.fwdr = fwdr;
		this.trdCd = trdCd;
		this.pol1 = pol1;
		this.cCustNm = cCustNm;
		this.pol2 = pol2;
		this.pol3 = pol3;
		this.pol4 = pol4;
		this.obSlsOfcCd = obSlsOfcCd;
		this.cfmUsrId = cfmUsrId;
		this.subTrdCd = subTrdCd;
		this.rfaNo = rfaNo;
		this.vvd3 = vvd3;
		this.cntrTpszCd = cntrTpszCd;
		this.cfmDt = cfmDt;
		this.custTp = custTp;
		this.vvd2 = vvd2;
		this.vvd1 = vvd1;
		this.cfmRqstFlg = cfmRqstFlg;
		this.week = week;
		this.ibflag = ibflag;
		this.podNodCd = podNodCd;
		this.cCust = cCust;
		this.cneeNm = cneeNm;
		this.custCtrlCd = custCtrlCd;
		this.alocStsCd = alocStsCd;
		this.duration = duration;
		this.fLevel = fLevel;
		this.ton = ton;
		this.polEtb4 = polEtb4;
		this.cgoRcvDt = cgoRcvDt;
		this.dgrd = dgrd;
		this.masCmpb = masCmpb;
		this.polEtb2 = polEtb2;
		this.polEtb3 = polEtb3;
		this.polEtb1 = polEtb1;
		this.usrOfcCd = usrOfcCd;
		this.porSccCd = porSccCd;
		this.shrpNm = shrpNm;
		this.delSccCd = delSccCd;
		this.tsPolCd = tsPolCd;
		this.cmdtCd = cmdtCd;
		this.cnee = cnee;
		this.usaBkgModCd = usaBkgModCd;
		this.sName = sName;
		this.trnkDirCd = trnkDirCd;
		this.cmdtDesc = cmdtDesc;
		this.lstSbRmk = lstSbRmk;
		this.tsPodCd = tsPodCd;
		this.bkgStsCd = bkgStsCd;
		this.porLocCd = porLocCd;
		this.tsDirCd = tsDirCd;
		this.polLocCd = polLocCd;
		this.cmpb = cmpb;
		this.acctCd = acctCd;
		this.initCmpb = initCmpb;
		this.fwdrNm = fwdrNm;
		this.lstSbOtrRsn = lstSbOtrRsn;
		this.dirCd = dirCd;
		this.bkgCreDt = bkgCreDt;
		this.ctrtOfcCd = ctrtOfcCd;
	    this.stwgCd = stwgCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rfa_ctrt_tp_cd", getRfaCtrtTpCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("a_cust_nm", getACustNm());
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
		this.hashColumns.put("sls_rhq_cd", getSlsRhqCd());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("trnk_slan_cd", getTrnkSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_loc_cd", getPodLocCd());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("a_cust", getACust());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("standby_type", getStandbyType());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("yr_mon_wk", getYrMonWk());
		this.hashColumns.put("standby_reason", getStandbyReason());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("fwdr", getFwdr());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("cfm_rqst_flg", getCfmRqstFlg());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("c_cust", getCCust());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("aloc_sts_cd", getAlocStsCd());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("f_level", getFLevel());
		this.hashColumns.put("ton", getTon());
		this.hashColumns.put("pol_etb4", getPolEtb4());
		this.hashColumns.put("cgo_rcv_dt", getCgoRcvDt());
		this.hashColumns.put("dgrd", getDgrd());
		this.hashColumns.put("mas_cmpb", getMasCmpb());
		this.hashColumns.put("pol_etb2", getPolEtb2());
		this.hashColumns.put("pol_etb3", getPolEtb3());
		this.hashColumns.put("pol_etb1", getPolEtb1());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("por_scc_cd", getPorSccCd());
		this.hashColumns.put("shrp_nm", getShrpNm());
		this.hashColumns.put("del_scc_cd", getDelSccCd());
		this.hashColumns.put("ts_pol_cd", getTsPolCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("s_name", getSName());
		this.hashColumns.put("trnk_dir_cd", getTrnkDirCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("lst_sb_rmk", getLstSbRmk());
		this.hashColumns.put("ts_pod_cd", getTsPodCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("por_loc_cd", getPorLocCd());
		this.hashColumns.put("ts_dir_cd", getTsDirCd());
		this.hashColumns.put("pol_loc_cd", getPolLocCd());
		this.hashColumns.put("cmpb", getCmpb());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("init_cmpb", getInitCmpb());
		this.hashColumns.put("fwdr_nm", getFwdrNm());
		this.hashColumns.put("lst_sb_otr_rsn", getLstSbOtrRsn());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
	    this.hashColumns.put("stwg_cd", getStwgCd());

		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rfa_ctrt_tp_cd", "rfaCtrtTpCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("a_cust_nm", "aCustNm");
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
		this.hashFields.put("sls_rhq_cd", "slsRhqCd");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("trnk_slan_cd", "trnkSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_loc_cd", "podLocCd");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("a_cust", "aCust");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("standby_type", "standbyType");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("yr_mon_wk", "yrMonWk");
		this.hashFields.put("standby_reason", "standbyReason");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("fwdr", "fwdr");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("cfm_rqst_flg", "cfmRqstFlg");
		this.hashFields.put("week", "week");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("c_cust", "cCust");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("aloc_sts_cd", "alocStsCd");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("f_level", "fLevel");
		this.hashFields.put("ton", "ton");
		this.hashFields.put("pol_etb4", "polEtb4");
		this.hashFields.put("cgo_rcv_dt", "cgoRcvDt");
		this.hashFields.put("dgrd", "dgrd");
		this.hashFields.put("mas_cmpb", "masCmpb");
		this.hashFields.put("pol_etb2", "polEtb2");
		this.hashFields.put("pol_etb3", "polEtb3");
		this.hashFields.put("pol_etb1", "polEtb1");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("por_scc_cd", "porSccCd");
		this.hashFields.put("shrp_nm", "shrpNm");
		this.hashFields.put("del_scc_cd", "delSccCd");
		this.hashFields.put("ts_pol_cd", "tsPolCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("s_name", "sName");
		this.hashFields.put("trnk_dir_cd", "trnkDirCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("lst_sb_rmk", "lstSbRmk");
		this.hashFields.put("ts_pod_cd", "tsPodCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("por_loc_cd", "porLocCd");
		this.hashFields.put("ts_dir_cd", "tsDirCd");
		this.hashFields.put("pol_loc_cd", "polLocCd");
		this.hashFields.put("cmpb", "cmpb");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("init_cmpb", "initCmpb");
		this.hashFields.put("fwdr_nm", "fwdrNm");
		this.hashFields.put("lst_sb_otr_rsn", "lstSbOtrRsn");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
	      this.hashFields.put("stwg_cd", "stwgCd");

		return this.hashFields;
	}
	   /**
     * Column Info
     * @return stwgCd
     */
    public String getStwgCd() {
        return stwgCd;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return ctrtOfcCd;
	}
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}

	/**
	 * Column Info
	 * @return rfaCtrtTpCd
	 */
	public String getRfaCtrtTpCd() {
		return this.rfaCtrtTpCd;
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
	 * @return aCustNm
	 */
	public String getACustNm() {
		return this.aCustNm;
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
	 * @return slsRhqCd
	 */
	public String getSlsRhqCd() {
		return this.slsRhqCd;
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
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
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
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return pol1
	 */
	public String getPol1() {
		return this.pol1;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return pol2
	 */
	public String getPol2() {
		return this.pol2;
	}
	
	/**
	 * Column Info
	 * @return pol3
	 */
	public String getPol3() {
		return this.pol3;
	}
	
	/**
	 * Column Info
	 * @return pol4
	 */
	public String getPol4() {
		return this.pol4;
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
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
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
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
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
	 * @return polEtb4
	 */
	public String getPolEtb4() {
		return this.polEtb4;
	}
	
	/**
	 * Column Info
	 * @return cgoRcvDt
	 */
	public String getCgoRcvDt() {
		return this.cgoRcvDt;
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
	 * @return masCmpb
	 */
	public String getMasCmpb() {
		return this.masCmpb;
	}
	
	/**
	 * Column Info
	 * @return polEtb2
	 */
	public String getPolEtb2() {
		return this.polEtb2;
	}
	
	/**
	 * Column Info
	 * @return polEtb3
	 */
	public String getPolEtb3() {
		return this.polEtb3;
	}
	
	/**
	 * Column Info
	 * @return polEtb1
	 */
	public String getPolEtb1() {
		return this.polEtb1;
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
	 * @return porSccCd
	 */
	public String getPorSccCd() {
		return this.porSccCd;
	}
	
	/**
	 * Column Info
	 * @return shrpNm
	 */
	public String getShrpNm() {
		return this.shrpNm;
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
	 * @return usaBkgModCd
	 */
	public String getUsaBkgModCd() {
		return this.usaBkgModCd;
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
	 * @return trnkDirCd
	 */
	public String getTrnkDirCd() {
		return this.trnkDirCd;
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
	 * @return lstSbRmk
	 */
	public String getLstSbRmk() {
		return this.lstSbRmk;
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
	 * @return cmpb
	 */
	public String getCmpb() {
		return this.cmpb;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return initCmpb
	 */
	public String getInitCmpb() {
		return this.initCmpb;
	}
	
	/**
	 * Column Info
	 * @return fwdrNm
	 */
	public String getFwdrNm() {
		return this.fwdrNm;
	}
	
	/**
	 * Column Info
	 * @return lstSbOtrRsn
	 */
	public String getLstSbOtrRsn() {
		return this.lstSbOtrRsn;
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
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	

	/**
	 * Column Info
	 * @param rfaCtrtTpCd
	 */
	public void setRfaCtrtTpCd(String rfaCtrtTpCd) {
		this.rfaCtrtTpCd = rfaCtrtTpCd;
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
	 * @param aCustNm
	 */
	public void setACustNm(String aCustNm) {
		this.aCustNm = aCustNm;
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
	 * @param slsRhqCd
	 */
	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
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
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
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
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param pol1
	 */
	public void setPol1(String pol1) {
		this.pol1 = pol1;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param pol2
	 */
	public void setPol2(String pol2) {
		this.pol2 = pol2;
	}
	
	/**
	 * Column Info
	 * @param pol3
	 */
	public void setPol3(String pol3) {
		this.pol3 = pol3;
	}
	
	/**
	 * Column Info
	 * @param pol4
	 */
	public void setPol4(String pol4) {
		this.pol4 = pol4;
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
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
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
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
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
	 * @param polEtb4
	 */
	public void setPolEtb4(String polEtb4) {
		this.polEtb4 = polEtb4;
	}
	
	/**
	 * Column Info
	 * @param cgoRcvDt
	 */
	public void setCgoRcvDt(String cgoRcvDt) {
		this.cgoRcvDt = cgoRcvDt;
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
	 * @param masCmpb
	 */
	public void setMasCmpb(String masCmpb) {
		this.masCmpb = masCmpb;
	}
	
	/**
	 * Column Info
	 * @param polEtb2
	 */
	public void setPolEtb2(String polEtb2) {
		this.polEtb2 = polEtb2;
	}
	
	/**
	 * Column Info
	 * @param polEtb3
	 */
	public void setPolEtb3(String polEtb3) {
		this.polEtb3 = polEtb3;
	}
	
	/**
	 * Column Info
	 * @param polEtb1
	 */
	public void setPolEtb1(String polEtb1) {
		this.polEtb1 = polEtb1;
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
	 * @param porSccCd
	 */
	public void setPorSccCd(String porSccCd) {
		this.porSccCd = porSccCd;
	}
	
	/**
	 * Column Info
	 * @param shrpNm
	 */
	public void setShrpNm(String shrpNm) {
		this.shrpNm = shrpNm;
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
	 * @param usaBkgModCd
	 */
	public void setUsaBkgModCd(String usaBkgModCd) {
		this.usaBkgModCd = usaBkgModCd;
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
	 * @param trnkDirCd
	 */
	public void setTrnkDirCd(String trnkDirCd) {
		this.trnkDirCd = trnkDirCd;
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
	 * @param lstSbRmk
	 */
	public void setLstSbRmk(String lstSbRmk) {
		this.lstSbRmk = lstSbRmk;
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
	 * @param cmpb
	 */
	public void setCmpb(String cmpb) {
		this.cmpb = cmpb;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param initCmpb
	 */
	public void setInitCmpb(String initCmpb) {
		this.initCmpb = initCmpb;
	}
	
	/**
	 * Column Info
	 * @param fwdrNm
	 */
	public void setFwdrNm(String fwdrNm) {
		this.fwdrNm = fwdrNm;
	}
	
	/**
	 * Column Info
	 * @param lstSbOtrRsn
	 */
	public void setLstSbOtrRsn(String lstSbOtrRsn) {
		this.lstSbOtrRsn = lstSbOtrRsn;
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
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
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
		setRfaCtrtTpCd(JSPUtil.getParameter(request, prefix + "rfa_ctrt_tp_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setACustNm(JSPUtil.getParameter(request, prefix + "a_cust_nm", ""));
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
		setSlsRhqCd(JSPUtil.getParameter(request, prefix + "sls_rhq_cd", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setTrnkSlanCd(JSPUtil.getParameter(request, prefix + "trnk_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodLocCd(JSPUtil.getParameter(request, prefix + "pod_loc_cd", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setACust(JSPUtil.getParameter(request, prefix + "a_cust", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setBkgVvdCd(JSPUtil.getParameter(request, prefix + "bkg_vvd_cd", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setStandbyType(JSPUtil.getParameter(request, prefix + "standby_type", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setYrMonWk(JSPUtil.getParameter(request, prefix + "yr_mon_wk", ""));
		setStandbyReason(JSPUtil.getParameter(request, prefix + "standby_reason", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setFwdr(JSPUtil.getParameter(request, prefix + "fwdr", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setPol1(JSPUtil.getParameter(request, prefix + "pol1", ""));
		setCCustNm(JSPUtil.getParameter(request, prefix + "c_cust_nm", ""));
		setPol2(JSPUtil.getParameter(request, prefix + "pol2", ""));
		setPol3(JSPUtil.getParameter(request, prefix + "pol3", ""));
		setPol4(JSPUtil.getParameter(request, prefix + "pol4", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setCustTp(JSPUtil.getParameter(request, prefix + "cust_tp", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setCfmRqstFlg(JSPUtil.getParameter(request, prefix + "cfm_rqst_flg", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setCCust(JSPUtil.getParameter(request, prefix + "c_cust", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setAlocStsCd(JSPUtil.getParameter(request, prefix + "aloc_sts_cd", ""));
		setDuration(JSPUtil.getParameter(request, prefix + "duration", ""));
		setFLevel(JSPUtil.getParameter(request, prefix + "f_level", ""));
		setTon(JSPUtil.getParameter(request, prefix + "ton", ""));
		setPolEtb4(JSPUtil.getParameter(request, prefix + "pol_etb4", ""));
		setCgoRcvDt(JSPUtil.getParameter(request, prefix + "cgo_rcv_dt", ""));
		setDgrd(JSPUtil.getParameter(request, prefix + "dgrd", ""));
		setMasCmpb(JSPUtil.getParameter(request, prefix + "mas_cmpb", ""));
		setPolEtb2(JSPUtil.getParameter(request, prefix + "pol_etb2", ""));
		setPolEtb3(JSPUtil.getParameter(request, prefix + "pol_etb3", ""));
		setPolEtb1(JSPUtil.getParameter(request, prefix + "pol_etb1", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, prefix + "usr_ofc_cd", ""));
		setPorSccCd(JSPUtil.getParameter(request, prefix + "por_scc_cd", ""));
		setShrpNm(JSPUtil.getParameter(request, prefix + "shrp_nm", ""));
		setDelSccCd(JSPUtil.getParameter(request, prefix + "del_scc_cd", ""));
		setTsPolCd(JSPUtil.getParameter(request, prefix + "ts_pol_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCnee(JSPUtil.getParameter(request, prefix + "cnee", ""));
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setSName(JSPUtil.getParameter(request, prefix + "s_name", ""));
		setTrnkDirCd(JSPUtil.getParameter(request, prefix + "trnk_dir_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setLstSbRmk(JSPUtil.getParameter(request, prefix + "lst_sb_rmk", ""));
		setTsPodCd(JSPUtil.getParameter(request, prefix + "ts_pod_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setPorLocCd(JSPUtil.getParameter(request, prefix + "por_loc_cd", ""));
		setTsDirCd(JSPUtil.getParameter(request, prefix + "ts_dir_cd", ""));
		setPolLocCd(JSPUtil.getParameter(request, prefix + "pol_loc_cd", ""));
		setCmpb(JSPUtil.getParameter(request, prefix + "cmpb", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setInitCmpb(JSPUtil.getParameter(request, prefix + "init_cmpb", ""));
		setFwdrNm(JSPUtil.getParameter(request, prefix + "fwdr_nm", ""));
		setLstSbOtrRsn(JSPUtil.getParameter(request, prefix + "lst_sb_otr_rsn", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
	      setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCompulsoryFirmVO[]
	 */
	public SearchCompulsoryFirmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCompulsoryFirmVO[]
	 */
	public SearchCompulsoryFirmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCompulsoryFirmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfaCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "rfa_ctrt_tp_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] aCustNm = (JSPUtil.getParameter(request, prefix	+ "a_cust_nm", length));
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
			String[] slsRhqCd = (JSPUtil.getParameter(request, prefix	+ "sls_rhq_cd", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] trnkSlanCd = (JSPUtil.getParameter(request, prefix	+ "trnk_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podLocCd = (JSPUtil.getParameter(request, prefix	+ "pod_loc_cd", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] aCust = (JSPUtil.getParameter(request, prefix	+ "a_cust", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd_cd", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] standbyType = (JSPUtil.getParameter(request, prefix	+ "standby_type", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] yrMonWk = (JSPUtil.getParameter(request, prefix	+ "yr_mon_wk", length));
			String[] standbyReason = (JSPUtil.getParameter(request, prefix	+ "standby_reason", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] fwdr = (JSPUtil.getParameter(request, prefix	+ "fwdr", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix	+ "pol1", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix	+ "pol2", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix	+ "pol3", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix	+ "pol4", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] cfmRqstFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_rqst_flg", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] cCust = (JSPUtil.getParameter(request, prefix	+ "c_cust", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] alocStsCd = (JSPUtil.getParameter(request, prefix	+ "aloc_sts_cd", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] fLevel = (JSPUtil.getParameter(request, prefix	+ "f_level", length));
			String[] ton = (JSPUtil.getParameter(request, prefix	+ "ton", length));
			String[] polEtb4 = (JSPUtil.getParameter(request, prefix	+ "pol_etb4", length));
			String[] cgoRcvDt = (JSPUtil.getParameter(request, prefix	+ "cgo_rcv_dt", length));
			String[] dgrd = (JSPUtil.getParameter(request, prefix	+ "dgrd", length));
			String[] masCmpb = (JSPUtil.getParameter(request, prefix	+ "mas_cmpb", length));
			String[] polEtb2 = (JSPUtil.getParameter(request, prefix	+ "pol_etb2", length));
			String[] polEtb3 = (JSPUtil.getParameter(request, prefix	+ "pol_etb3", length));
			String[] polEtb1 = (JSPUtil.getParameter(request, prefix	+ "pol_etb1", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] porSccCd = (JSPUtil.getParameter(request, prefix	+ "por_scc_cd", length));
			String[] shrpNm = (JSPUtil.getParameter(request, prefix	+ "shrp_nm", length));
			String[] delSccCd = (JSPUtil.getParameter(request, prefix	+ "del_scc_cd", length));
			String[] tsPolCd = (JSPUtil.getParameter(request, prefix	+ "ts_pol_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] sName = (JSPUtil.getParameter(request, prefix	+ "s_name", length));
			String[] trnkDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_dir_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] lstSbRmk = (JSPUtil.getParameter(request, prefix	+ "lst_sb_rmk", length));
			String[] tsPodCd = (JSPUtil.getParameter(request, prefix	+ "ts_pod_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] porLocCd = (JSPUtil.getParameter(request, prefix	+ "por_loc_cd", length));
			String[] tsDirCd = (JSPUtil.getParameter(request, prefix	+ "ts_dir_cd", length));
			String[] polLocCd = (JSPUtil.getParameter(request, prefix	+ "pol_loc_cd", length));
			String[] cmpb = (JSPUtil.getParameter(request, prefix	+ "cmpb", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] initCmpb = (JSPUtil.getParameter(request, prefix	+ "init_cmpb", length));
			String[] fwdrNm = (JSPUtil.getParameter(request, prefix	+ "fwdr_nm", length));
			String[] lstSbOtrRsn = (JSPUtil.getParameter(request, prefix	+ "lst_sb_otr_rsn", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
            String[] stwgCd = (JSPUtil.getParameter(request, prefix  + "stwg_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCompulsoryFirmVO();
				if (rfaCtrtTpCd[i] != null)
					model.setRfaCtrtTpCd(rfaCtrtTpCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (aCustNm[i] != null)
					model.setACustNm(aCustNm[i]);
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
				if (slsRhqCd[i] != null)
					model.setSlsRhqCd(slsRhqCd[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (trnkSlanCd[i] != null)
					model.setTrnkSlanCd(trnkSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podLocCd[i] != null)
					model.setPodLocCd(podLocCd[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (aCust[i] != null)
					model.setACust(aCust[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (bkgVvdCd[i] != null)
					model.setBkgVvdCd(bkgVvdCd[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (standbyType[i] != null)
					model.setStandbyType(standbyType[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (yrMonWk[i] != null)
					model.setYrMonWk(yrMonWk[i]);
				if (standbyReason[i] != null)
					model.setStandbyReason(standbyReason[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (fwdr[i] != null)
					model.setFwdr(fwdr[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (cfmRqstFlg[i] != null)
					model.setCfmRqstFlg(cfmRqstFlg[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (cCust[i] != null)
					model.setCCust(cCust[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (alocStsCd[i] != null)
					model.setAlocStsCd(alocStsCd[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (fLevel[i] != null)
					model.setFLevel(fLevel[i]);
				if (ton[i] != null)
					model.setTon(ton[i]);
				if (polEtb4[i] != null)
					model.setPolEtb4(polEtb4[i]);
				if (cgoRcvDt[i] != null)
					model.setCgoRcvDt(cgoRcvDt[i]);
				if (dgrd[i] != null)
					model.setDgrd(dgrd[i]);
				if (masCmpb[i] != null)
					model.setMasCmpb(masCmpb[i]);
				if (polEtb2[i] != null)
					model.setPolEtb2(polEtb2[i]);
				if (polEtb3[i] != null)
					model.setPolEtb3(polEtb3[i]);
				if (polEtb1[i] != null)
					model.setPolEtb1(polEtb1[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (porSccCd[i] != null)
					model.setPorSccCd(porSccCd[i]);
				if (shrpNm[i] != null)
					model.setShrpNm(shrpNm[i]);
				if (delSccCd[i] != null)
					model.setDelSccCd(delSccCd[i]);
				if (tsPolCd[i] != null)
					model.setTsPolCd(tsPolCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (sName[i] != null)
					model.setSName(sName[i]);
				if (trnkDirCd[i] != null)
					model.setTrnkDirCd(trnkDirCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (lstSbRmk[i] != null)
					model.setLstSbRmk(lstSbRmk[i]);
				if (tsPodCd[i] != null)
					model.setTsPodCd(tsPodCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (porLocCd[i] != null)
					model.setPorLocCd(porLocCd[i]);
				if (tsDirCd[i] != null)
					model.setTsDirCd(tsDirCd[i]);
				if (polLocCd[i] != null)
					model.setPolLocCd(polLocCd[i]);
				if (cmpb[i] != null)
					model.setCmpb(cmpb[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (initCmpb[i] != null)
					model.setInitCmpb(initCmpb[i]);
				if (fwdrNm[i] != null)
					model.setFwdrNm(fwdrNm[i]);
				if (lstSbOtrRsn[i] != null)
					model.setLstSbOtrRsn(lstSbOtrRsn[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
                if (stwgCd[i] != null)
                    model.setStwgCd(stwgCd[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCompulsoryFirmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCompulsoryFirmVO[]
	 */
	public SearchCompulsoryFirmVO[] getSearchCompulsoryFirmVOs(){
		SearchCompulsoryFirmVO[] vos = (SearchCompulsoryFirmVO[])models.toArray(new SearchCompulsoryFirmVO[models.size()]);
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
		this.rfaCtrtTpCd = this.rfaCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCustNm = this.aCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.slsRhqCd = this.slsRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSlanCd = this.trnkSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocCd = this.podLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCust = this.aCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvdCd = this.bkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standbyType = this.standbyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrMonWk = this.yrMonWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standbyReason = this.standbyReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdr = this.fwdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRqstFlg = this.cfmRqstFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCust = this.cCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocStsCd = this.alocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLevel = this.fLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ton = this.ton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtb4 = this.polEtb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRcvDt = this.cgoRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgrd = this.dgrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCmpb = this.masCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtb2 = this.polEtb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtb3 = this.polEtb3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtb1 = this.polEtb1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porSccCd = this.porSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shrpNm = this.shrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delSccCd = this.delSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPolCd = this.tsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sName = this.sName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkDirCd = this.trnkDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSbRmk = this.lstSbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsPodCd = this.tsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porLocCd = this.porLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsDirCd = this.tsDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocCd = this.polLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpb = this.cmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initCmpb = this.initCmpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrNm = this.fwdrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSbOtrRsn = this.lstSbOtrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
