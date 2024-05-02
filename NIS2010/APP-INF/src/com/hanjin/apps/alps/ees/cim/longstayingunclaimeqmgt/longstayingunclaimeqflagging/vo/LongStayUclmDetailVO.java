/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongStayUclmDetailVO.java
*@FileTitle : LongStayUclmDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.09.08 김종준 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.09.19 신자영 [CHM-201220003-01] L/S U/C CREATION - COR DRAFT 기능 개발
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

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

public class LongStayUclmDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LongStayUclmDetailVO> models = new ArrayList<LongStayUclmDetailVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String actDys = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String mkDesc = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvGmtDt = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgUcFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String orgLsFlg = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tempUclmRsn = null;
	/* Column Info */
	private String uclmDt = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String uclmFreeDys = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String uclmCntcPntNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String uclmEndDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String uclmLsDivCd = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String uclmRsn = null;
	/* Column Info */
	private String ucFlg = null;
	/* Column Info */
	private String lsFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String uclmPlnRmk = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String stayDays = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String contents = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String factFndActDesc = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String vndrSeq2 = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String vndrEml = null;
	/* Column Info */
	private String intgCdValCtnt = null;
	/* Column Info */
	private String intgCdValDpDesc = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LongStayUclmDetailVO() {}

	public LongStayUclmDetailVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String cnmvStsCd, String crntYdCd, String bkgNo, String blNo, String stayDays, String uclmLsDivCd, String lsFlg, String orgLsFlg, String ucFlg, String orgUcFlg, String uclmDt, String ftDys, String ftEndDt, String actDys, String uclmRsn, String uclmPlnRmk, String uclmCntcPntNm, String shpr, String cnee, String ntfy, String repCmdtNm, String mkDesc, String vslSlanCd, String vvd, String obSlsOfcCd, String dmgFlg, String dispFlg, String updUsrId, String updDt, String cnmvYr, String cnmvIdNo, String cnmvGmtDt, String cnmvDt, String uclmFreeDys, String uclmEndDt, String fullFlg, String creUsrId, String tempUclmRsn, String text, String contents, String lstmCd, 
			                    String porCd, String podCd, String polCd, String delCd, String rcvTermCd, String deTermCd, String ctrtNo, String custLglEngNm, String vndrSeq2, String vndrLglEngNm, String phnNo, String vndrEml, String intgCdValCtnt, String intgCdValDpDesc, String factFndActDesc) {
		this.ntfy = ntfy;
		this.actDys = actDys;
		this.crntYdCd = crntYdCd;
		this.dmgFlg = dmgFlg;
		this.vslSlanCd = vslSlanCd;
		this.mkDesc = mkDesc;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cnmvGmtDt = cnmvGmtDt;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.orgUcFlg = orgUcFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.obSlsOfcCd = obSlsOfcCd;
		this.orgLsFlg = orgLsFlg;
		this.ftEndDt = ftEndDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.tempUclmRsn = tempUclmRsn;
		this.uclmDt = uclmDt;
		this.repCmdtNm = repCmdtNm;
		this.uclmFreeDys = uclmFreeDys;
		this.cnmvDt = cnmvDt;
		this.cnmvIdNo = cnmvIdNo;
		this.uclmCntcPntNm = uclmCntcPntNm;
		this.vvd = vvd;
		this.dispFlg = dispFlg;
		this.creUsrId = creUsrId;
		this.uclmEndDt = uclmEndDt;
		this.bkgNo = bkgNo;
		this.uclmLsDivCd = uclmLsDivCd;
		this.ftDys = ftDys;
		this.uclmRsn = uclmRsn;
		this.ucFlg = ucFlg;
		this.lsFlg = lsFlg;
		this.cntrNo = cntrNo;
		this.uclmPlnRmk = uclmPlnRmk;
		this.cnee = cnee;
		this.fullFlg = fullFlg;
		this.cnmvYr = cnmvYr;
		this.stayDays = stayDays;
		this.shpr = shpr;
		this.title = title;
		this.contents = contents;
		this.lstmCd = lstmCd;
		this.porCd = porCd;
		this.podCd = podCd;
		this.polCd = polCd;
		this.delCd = delCd;
		this.rcvTermCd = rcvTermCd;
		this.deTermCd = deTermCd;
		this.ctrtNo = ctrtNo;
		this.custLglEngNm = custLglEngNm;
		this.vndrSeq2 = vndrSeq2;
		this.vndrLglEngNm = vndrLglEngNm;
		this.phnNo = phnNo;
		this.vndrEml = vndrEml;
		this.intgCdValCtnt = intgCdValCtnt;
		this.intgCdValDpDesc = intgCdValDpDesc;
		this.factFndActDesc = factFndActDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("act_dys", getActDys());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_gmt_dt", getCnmvGmtDt());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_uc_flg", getOrgUcFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("org_ls_flg", getOrgLsFlg());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("temp_uclm_rsn", getTempUclmRsn());
		this.hashColumns.put("uclm_dt", getUclmDt());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("uclm_free_dys", getUclmFreeDys());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("uclm_cntc_pnt_nm", getUclmCntcPntNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("uclm_end_dt", getUclmEndDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("uclm_rsn", getUclmRsn());
		this.hashColumns.put("uc_flg", getUcFlg());
		this.hashColumns.put("ls_flg", getLsFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("uclm_pln_rmk", getUclmPlnRmk());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("stay_days", getStayDays());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("contents", getContents());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("vndr_seq2", getVndrSeq2());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("intg_cd_val_ctnt", getIntgCdValCtnt());
		this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
		this.hashColumns.put("fact_fnd_act_desc", getFactFndActDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("act_dys", "actDys");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_gmt_dt", "cnmvGmtDt");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_uc_flg", "orgUcFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("org_ls_flg", "orgLsFlg");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("temp_uclm_rsn", "tempUclmRsn");
		this.hashFields.put("uclm_dt", "uclmDt");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("uclm_free_dys", "uclmFreeDys");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("uclm_cntc_pnt_nm", "uclmCntcPntNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("uclm_end_dt", "uclmEndDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("uclm_rsn", "uclmRsn");
		this.hashFields.put("uc_flg", "ucFlg");
		this.hashFields.put("ls_flg", "lsFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("uclm_pln_rmk", "uclmPlnRmk");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("title", "title");
		this.hashFields.put("contents", "contents");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("vndr_seq2", "vndrSeq2");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("intg_cd_val_ctnt", "intgCdValCtnt");
		this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
		this.hashFields.put("fact_fnd_act_desc", "factFndActDesc");
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
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return cnmvGmtDt
	 */
	public String getCnmvGmtDt() {
		return this.cnmvGmtDt;
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
	 * @return orgUcFlg
	 */
	public String getOrgUcFlg() {
		return this.orgUcFlg;
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
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return orgLsFlg
	 */
	public String getOrgLsFlg() {
		return this.orgLsFlg;
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
	 * @return tempUclmRsn
	 */
	public String getTempUclmRsn() {
		return this.tempUclmRsn;
	}
	
	/**
	 * Column Info
	 * @return uclmDt
	 */
	public String getUclmDt() {
		return this.uclmDt;
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
	 * @return uclmFreeDys
	 */
	public String getUclmFreeDys() {
		return this.uclmFreeDys;
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
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return uclmCntcPntNm
	 */
	public String getUclmCntcPntNm() {
		return this.uclmCntcPntNm;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return uclmEndDt
	 */
	public String getUclmEndDt() {
		return this.uclmEndDt;
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
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return uclmRsn
	 */
	public String getUclmRsn() {
		return this.uclmRsn;
	}
	
	/**
	 * Column Info
	 * @return ucFlg
	 */
	public String getUcFlg() {
		return this.ucFlg;
	}
	
	/**
	 * Column Info
	 * @return lsFlg
	 */
	public String getLsFlg() {
		return this.lsFlg;
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
	 * @return uclmPlnRmk
	 */
	public String getUclmPlnRmk() {
		return this.uclmPlnRmk;
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
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
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
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return contents
	 */
	public String getContents() {
		return this.contents;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq2
	 */
	public String getVndrSeq2() {
		return this.vndrSeq2;
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
	 * @return intgCdValCtnt
	 */
	public String getIntgCdValCtnt() {
		return this.intgCdValCtnt;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpDesc
	 */
	public String getIntgCdValDpDesc() {
		return this.intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @return vndrEml
	 */
	public String getVndrEml() {
		return this.vndrEml;
	}
	
	/**
	 * Column Info
	 * @return factFndActDesc
	 */
	public String getFactFndActDesc() {
		return this.factFndActDesc;
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
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param cnmvGmtDt
	 */
	public void setCnmvGmtDt(String cnmvGmtDt) {
		this.cnmvGmtDt = cnmvGmtDt;
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
	 * @param orgUcFlg
	 */
	public void setOrgUcFlg(String orgUcFlg) {
		this.orgUcFlg = orgUcFlg;
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
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param orgLsFlg
	 */
	public void setOrgLsFlg(String orgLsFlg) {
		this.orgLsFlg = orgLsFlg;
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
	 * @param tempUclmRsn
	 */
	public void setTempUclmRsn(String tempUclmRsn) {
		this.tempUclmRsn = tempUclmRsn;
	}
	
	/**
	 * Column Info
	 * @param uclmDt
	 */
	public void setUclmDt(String uclmDt) {
		this.uclmDt = uclmDt;
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
	 * @param uclmFreeDys
	 */
	public void setUclmFreeDys(String uclmFreeDys) {
		this.uclmFreeDys = uclmFreeDys;
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
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param uclmCntcPntNm
	 */
	public void setUclmCntcPntNm(String uclmCntcPntNm) {
		this.uclmCntcPntNm = uclmCntcPntNm;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param uclmEndDt
	 */
	public void setUclmEndDt(String uclmEndDt) {
		this.uclmEndDt = uclmEndDt;
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
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param uclmRsn
	 */
	public void setUclmRsn(String uclmRsn) {
		this.uclmRsn = uclmRsn;
	}
	
	/**
	 * Column Info
	 * @param ucFlg
	 */
	public void setUcFlg(String ucFlg) {
		this.ucFlg = ucFlg;
	}
	
	/**
	 * Column Info
	 * @param lsFlg
	 */
	public void setLsFlg(String lsFlg) {
		this.lsFlg = lsFlg;
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
	 * @param uclmPlnRmk
	 */
	public void setUclmPlnRmk(String uclmPlnRmk) {
		this.uclmPlnRmk = uclmPlnRmk;
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
	 * @param fullFlg
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param contents
	 */
	public void setContents(String contents) {
		this.contents = contents;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq2
	 */
	public void setVndrSeq2(String vndrSeq2) {
		this.vndrSeq2 = vndrSeq2;
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
	 * @param intgCdValCtnt
	 */
	public void setIntgCdValCtnt(String intgCdValCtnt) {
		this.intgCdValCtnt = intgCdValCtnt;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpDesc
	 */
	public void setIntgCdValDpDesc(String intgCdValDpDesc) {
		this.intgCdValDpDesc = intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @param factFndActDesc
	 */
	public void setFactFndActDesc(String factFndActDesc) {
		this.factFndActDesc = factFndActDesc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNtfy(JSPUtil.getParameter(request, "ntfy", ""));
		setActDys(JSPUtil.getParameter(request, "act_dys", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnmvGmtDt(JSPUtil.getParameter(request, "cnmv_gmt_dt", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrgUcFlg(JSPUtil.getParameter(request, "org_uc_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setOrgLsFlg(JSPUtil.getParameter(request, "org_ls_flg", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTempUclmRsn(JSPUtil.getParameter(request, "temp_uclm_rsn", ""));
		setUclmDt(JSPUtil.getParameter(request, "uclm_dt", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setUclmFreeDys(JSPUtil.getParameter(request, "uclm_free_dys", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, "cnmv_id_no", ""));
		setUclmCntcPntNm(JSPUtil.getParameter(request, "uclm_cntc_pnt_nm", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUclmEndDt(JSPUtil.getParameter(request, "uclm_end_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request, "uclm_ls_div_cd", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setUclmRsn(JSPUtil.getParameter(request, "uclm_rsn", ""));
		setUcFlg(JSPUtil.getParameter(request, "uc_flg", ""));
		setLsFlg(JSPUtil.getParameter(request, "ls_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setUclmPlnRmk(JSPUtil.getParameter(request, "uclm_pln_rmk", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setStayDays(JSPUtil.getParameter(request, "stay_days", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setContents(JSPUtil.getParameter(request, "contents", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setCtrtNo(JSPUtil.getParameter(request, "ctrt_no", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, "cust_lgl_eng_nm", ""));
		setVndrSeq2(JSPUtil.getParameter(request, "vndr_seq2", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setVndrEml(JSPUtil.getParameter(request, "vndr_eml", ""));
		setIntgCdValCtnt(JSPUtil.getParameter(request, "intg_cd_val_ctnt", ""));
		setIntgCdValDpDesc(JSPUtil.getParameter(request, "intg_cd_val_dp_desc", ""));
		setFactFndActDesc(JSPUtil.getParameter(request, "fact_fnd_act_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LongStayUclmDetailVO[]
	 */
	public LongStayUclmDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LongStayUclmDetailVO[]
	 */
	public LongStayUclmDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LongStayUclmDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] actDys = (JSPUtil.getParameter(request, prefix	+ "act_dys", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvGmtDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_gmt_dt", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgUcFlg = (JSPUtil.getParameter(request, prefix	+ "org_uc_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] orgLsFlg = (JSPUtil.getParameter(request, prefix	+ "org_ls_flg", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tempUclmRsn = (JSPUtil.getParameter(request, prefix	+ "temp_uclm_rsn", length));
			String[] uclmDt = (JSPUtil.getParameter(request, prefix	+ "uclm_dt", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] uclmFreeDys = (JSPUtil.getParameter(request, prefix	+ "uclm_free_dys", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] uclmCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "uclm_cntc_pnt_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] uclmEndDt = (JSPUtil.getParameter(request, prefix	+ "uclm_end_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] uclmLsDivCd = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_div_cd", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] uclmRsn = (JSPUtil.getParameter(request, prefix	+ "uclm_rsn", length));
			String[] ucFlg = (JSPUtil.getParameter(request, prefix	+ "uc_flg", length));
			String[] lsFlg = (JSPUtil.getParameter(request, prefix	+ "ls_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] uclmPlnRmk = (JSPUtil.getParameter(request, prefix	+ "uclm_pln_rmk", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] stayDays = (JSPUtil.getParameter(request, prefix	+ "stay_days", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] contents = (JSPUtil.getParameter(request, prefix	+ "contents", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] vndrSeq2 = (JSPUtil.getParameter(request, prefix	+ "vndr_seq2", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] intgCdValCtnt = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_ctnt", length));
			String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_desc", length));
			String[] factFndActDesc = (JSPUtil.getParameter(request, prefix	+ "fact_fnd_act_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new LongStayUclmDetailVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (actDys[i] != null)
					model.setActDys(actDys[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvGmtDt[i] != null)
					model.setCnmvGmtDt(cnmvGmtDt[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgUcFlg[i] != null)
					model.setOrgUcFlg(orgUcFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (orgLsFlg[i] != null)
					model.setOrgLsFlg(orgLsFlg[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tempUclmRsn[i] != null)
					model.setTempUclmRsn(tempUclmRsn[i]);
				if (uclmDt[i] != null)
					model.setUclmDt(uclmDt[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (uclmFreeDys[i] != null)
					model.setUclmFreeDys(uclmFreeDys[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (uclmCntcPntNm[i] != null)
					model.setUclmCntcPntNm(uclmCntcPntNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (uclmEndDt[i] != null)
					model.setUclmEndDt(uclmEndDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (uclmLsDivCd[i] != null)
					model.setUclmLsDivCd(uclmLsDivCd[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (uclmRsn[i] != null)
					model.setUclmRsn(uclmRsn[i]);
				if (ucFlg[i] != null)
					model.setUcFlg(ucFlg[i]);
				if (lsFlg[i] != null)
					model.setLsFlg(lsFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (uclmPlnRmk[i] != null)
					model.setUclmPlnRmk(uclmPlnRmk[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (stayDays[i] != null)
					model.setStayDays(stayDays[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (contents[i] != null)
					model.setContents(contents[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (vndrSeq2[i] != null)
					model.setVndrSeq2(vndrSeq2[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (vndrEml[i] != null)
					model.setVndrEml(vndrEml[i]);
				if (intgCdValCtnt[i] != null)
					model.setIntgCdValCtnt(intgCdValCtnt[i]);
				if (intgCdValDpDesc[i] != null)
					model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
				if (factFndActDesc[i] != null)
					model.setFactFndActDesc(factFndActDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLongStayUclmDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LongStayUclmDetailVO[]
	 */
	public LongStayUclmDetailVO[] getLongStayUclmDetailVOs(){
		LongStayUclmDetailVO[] vos = (LongStayUclmDetailVO[])models.toArray(new LongStayUclmDetailVO[models.size()]);
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
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvGmtDt = this.cnmvGmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgUcFlg = this.orgUcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLsFlg = this.orgLsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempUclmRsn = this.tempUclmRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmDt = this.uclmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmFreeDys = this.uclmFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmCntcPntNm = this.uclmCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmEndDt = this.uclmEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd = this.uclmLsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmRsn = this.uclmRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucFlg = this.ucFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsFlg = this.lsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmPlnRmk = this.uclmPlnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays = this.stayDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contents = this.contents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq2 = this.vndrSeq2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValCtnt = this.intgCdValCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpDesc = this.intgCdValDpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
