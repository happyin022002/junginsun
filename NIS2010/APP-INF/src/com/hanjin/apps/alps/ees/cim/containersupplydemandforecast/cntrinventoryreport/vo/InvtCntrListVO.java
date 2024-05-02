/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvtCntrListVO.java
*@FileTitle : InvtCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.03.25 김종준 
* 1.0 Creation
* =========================================================
* History
* 2012.01.05 신자영 [CHM-201215469-01] [CIM] sea-inventory / cntr list 기능 보완
* =========================================================*/

package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo;

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
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvtCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvtCntrListVO> models = new ArrayList<InvtCntrListVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String actDys = null;
	/* Column Info */
	private String gwgt = null;
	/* Column Info */
	private String rccDate = null;
	/* Column Info */
	private String twgt = null;
	/* Column Info */
	private String bwgt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String mnrHngrBarTpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String uclmLsFlg = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String lessor = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podEta = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String uclmLsDivCd = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String stayDays = null;
	/* Column Info */
	private String cntrHngrRckCd = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String dtyFreeDt = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String polEtd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String subLocCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String plstFlrFlg = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pwgt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String rfTpCd = null;
	/* Column Info */
	private String cstmsClrFlg = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String dgFlg = null;
	/* Column Info */
	private String lane1 = null;
	/* Column Info */
	private String lane2 = null;
	
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String vndrEml = null;
	/* Column Info */
	private String offHire = null;
	/* Column Info */
	private String psaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvtCntrListVO() {}

	public InvtCntrListVO(String ibflag, String pagerows, String vvd, String polCd, String podCd, String podEta, String delCd, String stayDays, String cntrNo, String cntrTpszCd, String fullFlg, String lstmCd, String cnmvDt, String bkgNo, String blNo, String dmgFlg, String cntrHngrRckCd, String cntrHngrBarAtchKnt, String mnrHngrBarTpCd, String dispFlg, String imdtExtFlg, String seq, String crntYdCd, String cnmvStsCd, String porCd, String nextVvd, String polEtd, String shpr, String cnee, String ntfy, String scNo, String rfaNo, String scRfaNo, String uclmLsDivCd, String uclmLsFlg, String plstFlrFlg, String deTermCd, String rfTpCd, String cmdtNm, String mkDesc, String obSlsOfcCd, String lessor, String mftDt, String pkupNo, String frtCltFlg, String oblRdemFlg, String cstmsClrFlg, String dtyFreeDt, String gwgt, String pwgt, String twgt, String bwgt, String subLocCd, String repCmdtNm, String rccCd, String rccDate, String ftDys, String ftEndDt, String actDys, String agmtNo, String ydNm, String dgFlg, String lane1, String lane2, String vndrSeq, String vndrLglEngNm, String phnNo, String vndrEml, String offHire, String psaNo) {
		this.ntfy = ntfy;
		this.actDys = actDys;
		this.gwgt = gwgt;
		this.rccDate = rccDate;
		this.twgt = twgt;
		this.bwgt = bwgt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.frtCltFlg = frtCltFlg;
		this.scNo = scNo;
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.obSlsOfcCd = obSlsOfcCd;
		this.lstmCd = lstmCd;
		this.uclmLsFlg = uclmLsFlg;
		this.repCmdtNm = repCmdtNm;
		this.lessor = lessor;
		this.cnmvDt = cnmvDt;
		this.delCd = delCd;
		this.oblRdemFlg = oblRdemFlg;
		this.vvd = vvd;
		this.podCd = podCd;
		this.podEta = podEta;
		this.dispFlg = dispFlg;
		this.bkgNo = bkgNo;
		this.uclmLsDivCd = uclmLsDivCd;
		this.nextVvd = nextVvd;
		this.fullFlg = fullFlg;
		this.stayDays = stayDays;
		this.cntrHngrRckCd = cntrHngrRckCd;
		this.pkupNo = pkupNo;
		this.porCd = porCd;
		this.crntYdCd = crntYdCd;
		this.dtyFreeDt = dtyFreeDt;
		this.dmgFlg = dmgFlg;
		this.mkDesc = mkDesc;
		this.polEtd = polEtd;
		this.rfaNo = rfaNo;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.ftEndDt = ftEndDt;
		this.subLocCd = subLocCd;
		this.rccCd = rccCd;
		this.plstFlrFlg = plstFlrFlg;
		this.cmdtNm = cmdtNm;
		this.mftDt = mftDt;
		this.deTermCd = deTermCd;
		this.ftDys = ftDys;
		this.scRfaNo = scRfaNo;
		this.cntrNo = cntrNo;
		this.pwgt = pwgt;
		this.seq = seq;
		this.cnee = cnee;
		this.imdtExtFlg = imdtExtFlg;
		this.shpr = shpr;
		this.rfTpCd = rfTpCd;
		this.cstmsClrFlg = cstmsClrFlg;
		this.agmtNo = agmtNo;
		this.ydNm = ydNm;
		this.dgFlg = dgFlg;
		this.lane1 = lane1;
		this.lane2 = lane2;
		this.vndrSeq = vndrSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.phnNo = phnNo;
		this.vndrEml = vndrEml;
		this.offHire = offHire;
		this.psaNo = psaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("act_dys", getActDys());
		this.hashColumns.put("gwgt", getGwgt());
		this.hashColumns.put("rcc_date", getRccDate());
		this.hashColumns.put("twgt", getTwgt());
		this.hashColumns.put("bwgt", getBwgt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("uclm_ls_flg", getUclmLsFlg());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("lessor", getLessor());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_eta", getPodEta());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("stay_days", getStayDays());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("dty_free_dt", getDtyFreeDt());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("sub_loc_cd", getSubLocCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pwgt", getPwgt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("rf_tp_cd", getRfTpCd());
		this.hashColumns.put("cstms_clr_flg", getCstmsClrFlg());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("dg_flg", getDgFlg());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("off_hire", getOffHire());
		this.hashColumns.put("psa_no", getPsaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("act_dys", "actDys");
		this.hashFields.put("gwgt", "gwgt");
		this.hashFields.put("rcc_date", "rccDate");
		this.hashFields.put("twgt", "twgt");
		this.hashFields.put("bwgt", "bwgt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("uclm_ls_flg", "uclmLsFlg");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_eta", "podEta");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dty_free_dt", "dtyFreeDt");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("sub_loc_cd", "subLocCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pwgt", "pwgt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("cstms_clr_flg", "cstmsClrFlg");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("dg_flg", "dgFlg");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("off_hire", "offHire");
		this.hashFields.put("psa_no", "psaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
	}
	
	/**
	 * Column Info
	 * @return actDys
	 */
	public String getActDys() {
		return this.actDys;
	}
	
	/**
	 * Column Info
	 * @return gwgt
	 */
	public String getGwgt() {
		return this.gwgt;
	}
	
	/**
	 * Column Info
	 * @return rccDate
	 */
	public String getRccDate() {
		return this.rccDate;
	}
	
	/**
	 * Column Info
	 * @return twgt
	 */
	public String getTwgt() {
		return this.twgt;
	}
	
	/**
	 * Column Info
	 * @return bwgt
	 */
	public String getBwgt() {
		return this.bwgt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
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
	 * @return mnrHngrBarTpCd
	 */
	public String getMnrHngrBarTpCd() {
		return this.mnrHngrBarTpCd;
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
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return uclmLsFlg
	 */
	public String getUclmLsFlg() {
		return this.uclmLsFlg;
	}
	
	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return lessor
	 */
	public String getLessor() {
		return this.lessor;
	}
	
	/**
	 * Column Info
	 * @return cnmvDt
	 */
	public String getCnmvDt() {
		return this.cnmvDt;
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
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	
	/**
	 * Column Info
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return uclmLsDivCd
	 */
	public String getUclmLsDivCd() {
		return this.uclmLsDivCd;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
	}
	
	/**
	 * Column Info
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
	}
	
	/**
	 * Column Info
	 * @return stayDays
	 */
	public String getStayDays() {
		return this.stayDays;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
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
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return dtyFreeDt
	 */
	public String getDtyFreeDt() {
		return this.dtyFreeDt;
	}
	
	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return this.ftEndDt;
	}
	
	/**
	 * Column Info
	 * @return subLocCd
	 */
	public String getSubLocCd() {
		return this.subLocCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return plstFlrFlg
	 */
	public String getPlstFlrFlg() {
		return this.plstFlrFlg;
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
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
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
	 * @return pwgt
	 */
	public String getPwgt() {
		return this.pwgt;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return rfTpCd
	 */
	public String getRfTpCd() {
		return this.rfTpCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrFlg
	 */
	public String getCstmsClrFlg() {
		return this.cstmsClrFlg;
	}
	
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return dgFlg
	 */
	public String getDgFlg() {
		return this.dgFlg;
	}
	
	
	/**
	 * Column Info
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
	}
	
	/**
	 * Column Info
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}

	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return vndrEm
	 */
	public String getVndrEml() {
		return this.vndrEml;
	}	
	
	/**
	 * Column Info
	 * @return offHire
	 */
	public String getOffHire() {
		return this.offHire;
	}	
	
	/**
	 * Column Info
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}		
	
	/**
	 * Column Info
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
	}
	
	/**
	 * Column Info
	 * @param actDys
	 */
	public void setActDys(String actDys) {
		this.actDys = actDys;
	}
	
	/**
	 * Column Info
	 * @param gwgt
	 */
	public void setGwgt(String gwgt) {
		this.gwgt = gwgt;
	}
	
	/**
	 * Column Info
	 * @param rccDate
	 */
	public void setRccDate(String rccDate) {
		this.rccDate = rccDate;
	}
	
	/**
	 * Column Info
	 * @param twgt
	 */
	public void setTwgt(String twgt) {
		this.twgt = twgt;
	}

	/**
	 * Column Info
	 * @param bwgt
	 */
	public void setBwgt(String bwgt) {
		this.bwgt = bwgt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
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
	 * @param mnrHngrBarTpCd
	 */
	public void setMnrHngrBarTpCd(String mnrHngrBarTpCd) {
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
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
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param uclmLsFlg
	 */
	public void setUclmLsFlg(String uclmLsFlg) {
		this.uclmLsFlg = uclmLsFlg;
	}
	
	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param lessor
	 */
	public void setLessor(String lessor) {
		this.lessor = lessor;
	}
	
	/**
	 * Column Info
	 * @param cnmvDt
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
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
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
	}
	
	/**
	 * Column Info
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param uclmLsDivCd
	 */
	public void setUclmLsDivCd(String uclmLsDivCd) {
		this.uclmLsDivCd = uclmLsDivCd;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	
	/**
	 * Column Info
	 * @param fullFlg
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}
	
	/**
	 * Column Info
	 * @param stayDays
	 */
	public void setStayDays(String stayDays) {
		this.stayDays = stayDays;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
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
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param dtyFreeDt
	 */
	public void setDtyFreeDt(String dtyFreeDt) {
		this.dtyFreeDt = dtyFreeDt;
	}
	
	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
	}
	
	/**
	 * Column Info
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Column Info
	 * @param subLocCd
	 */
	public void setSubLocCd(String subLocCd) {
		this.subLocCd = subLocCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param plstFlrFlg
	 */
	public void setPlstFlrFlg(String plstFlrFlg) {
		this.plstFlrFlg = plstFlrFlg;
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
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
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
	 * @param pwgt
	 */
	public void setPwgt(String pwgt) {
		this.pwgt = pwgt;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param rfTpCd
	 */
	public void setRfTpCd(String rfTpCd) {
		this.rfTpCd = rfTpCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrFlg
	 */
	public void setCstmsClrFlg(String cstmsClrFlg) {
		this.cstmsClrFlg = cstmsClrFlg;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param dgFlg
	 */
	public void setDgFlg(String dgFlg) {
		this.dgFlg = dgFlg;
	}
	
	/**
	 * Column Info
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	
	/**
	 * Column Info
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}

	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param vndrEml
	 */
	public void setVndrEml(String vndrEml) {
		this.vndrEml = vndrEml;
	}
	
	/**
	 * Column Info
	 * @param offHire
	 */
	public void setOffHire(String offHire) {
		this.offHire = offHire;
	}
	
	/**
	 * Column Info
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.offHire = psaNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNtfy(JSPUtil.getParameter(request, "ntfy", ""));
		setActDys(JSPUtil.getParameter(request, "act_dys", ""));
		setGwgt(JSPUtil.getParameter(request, "gwgt", ""));
		setRccDate(JSPUtil.getParameter(request, "rcc_date", ""));
		setTwgt(JSPUtil.getParameter(request, "twgt", ""));
		setBwgt(JSPUtil.getParameter(request, "bwgt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, "frt_clt_flg", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request, "mnr_hngr_bar_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, "cntr_hngr_bar_atch_knt", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUclmLsFlg(JSPUtil.getParameter(request, "uclm_ls_flg", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setLessor(JSPUtil.getParameter(request, "lessor", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPodEta(JSPUtil.getParameter(request, "pod_eta", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request, "uclm_ls_div_cd", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setStayDays(JSPUtil.getParameter(request, "stay_days", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, "cntr_hngr_rck_cd", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setDtyFreeDt(JSPUtil.getParameter(request, "dty_free_dt", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
		setPolEtd(JSPUtil.getParameter(request, "pol_etd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
		setSubLocCd(JSPUtil.getParameter(request, "sub_loc_cd", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request, "plst_flr_flg", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPwgt(JSPUtil.getParameter(request, "pwgt", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setRfTpCd(JSPUtil.getParameter(request, "rf_tp_cd", ""));
		setCstmsClrFlg(JSPUtil.getParameter(request, "cstms_clr_flg", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setDgFlg(JSPUtil.getParameter(request, "dg_flg", ""));
		setLane1(JSPUtil.getParameter(request, "lane1", ""));
		setLane2(JSPUtil.getParameter(request, "lane2", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,  "vndr_lgl_eng_nm", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setVndrEml(JSPUtil.getParameter(request, "vndr_eml", ""));
		setOffHire(JSPUtil.getParameter(request, "off_hire", ""));
		setPsaNo(JSPUtil.getParameter(request, "psa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvtCntrListVO[]
	 */
	public InvtCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvtCntrListVO[]
	 */
	public InvtCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvtCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] actDys = (JSPUtil.getParameter(request, prefix	+ "act_dys", length));
			String[] gwgt = (JSPUtil.getParameter(request, prefix	+ "gwgt", length));
			String[] rccDate = (JSPUtil.getParameter(request, prefix	+ "rcc_date", length));
			String[] twgt = (JSPUtil.getParameter(request, prefix	+ "twgt", length));
			String[] bwgt = (JSPUtil.getParameter(request, prefix	+ "bwgt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] mnrHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_bar_tp_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] uclmLsFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_flg", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] lessor = (JSPUtil.getParameter(request, prefix	+ "lessor", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] uclmLsDivCd = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_div_cd", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] stayDays = (JSPUtil.getParameter(request, prefix	+ "stay_days", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] dtyFreeDt = (JSPUtil.getParameter(request, prefix	+ "dty_free_dt", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] subLocCd = (JSPUtil.getParameter(request, prefix	+ "sub_loc_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] plstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "plst_flr_flg", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pwgt = (JSPUtil.getParameter(request, prefix	+ "pwgt", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] rfTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd", length));
			String[] cstmsClrFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_flg", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] dgFlg = (JSPUtil.getParameter(request, prefix	+ "dg_flg", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix	+ "lane1", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix	+ "lane2", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] offHire = (JSPUtil.getParameter(request, prefix	+ "off_hire", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvtCntrListVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (actDys[i] != null)
					model.setActDys(actDys[i]);
				if (gwgt[i] != null)
					model.setGwgt(gwgt[i]);
				if (rccDate[i] != null)
					model.setRccDate(rccDate[i]);
				if (twgt[i] != null)
					model.setTwgt(twgt[i]);
				if (bwgt[i] != null)
					model.setBwgt(bwgt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (mnrHngrBarTpCd[i] != null)
					model.setMnrHngrBarTpCd(mnrHngrBarTpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (uclmLsFlg[i] != null)
					model.setUclmLsFlg(uclmLsFlg[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (lessor[i] != null)
					model.setLessor(lessor[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (uclmLsDivCd[i] != null)
					model.setUclmLsDivCd(uclmLsDivCd[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (stayDays[i] != null)
					model.setStayDays(stayDays[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (dtyFreeDt[i] != null)
					model.setDtyFreeDt(dtyFreeDt[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (subLocCd[i] != null)
					model.setSubLocCd(subLocCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (plstFlrFlg[i] != null)
					model.setPlstFlrFlg(plstFlrFlg[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pwgt[i] != null)
					model.setPwgt(pwgt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (rfTpCd[i] != null)
					model.setRfTpCd(rfTpCd[i]);
				if (cstmsClrFlg[i] != null)
					model.setCstmsClrFlg(cstmsClrFlg[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (dgFlg[i] != null)
					model.setDgFlg(dgFlg[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (vndrEml[i] != null)
					model.setVndrEml(vndrEml[i]);
				if (offHire[i] != null)
					model.setOffHire(offHire[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvtCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvtCntrListVO[]
	 */
	public InvtCntrListVO[] getInvtCntrListVOs(){
		InvtCntrListVO[] vos = (InvtCntrListVO[])models.toArray(new InvtCntrListVO[models.size()]);
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
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDys = this.actDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwgt = this.gwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccDate = this.rccDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twgt = this.twgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd = this.mnrHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsFlg = this.uclmLsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor = this.lessor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd = this.uclmLsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays = this.stayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtyFreeDt = this.dtyFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLocCd = this.subLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg = this.plstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pwgt = this.pwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd = this.rfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrFlg = this.cstmsClrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg = this.dgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml = this.vndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHire = this.offHire .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
