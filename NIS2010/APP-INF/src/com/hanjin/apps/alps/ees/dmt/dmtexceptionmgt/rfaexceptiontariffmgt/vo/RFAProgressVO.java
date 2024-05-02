/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAProgressVO.java
*@FileTitle : RFAProgressVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class RFAProgressVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RFAProgressVO> models = new ArrayList<RFAProgressVO>();
	
	/* Column Info */
	private String progUsrId = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String dmdtExptRqstStsDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String progDt = null;
	/* Column Info */
	private String cvrgSteCd = null;
	/* Column Info */
	private String progOfcCd = null;
	/* Column Info */
	private String rfaExptDarNo = null;
	/* Column Info */
	private String progRmk = null;
	/* Column Info */
	private String orgDestRgnCd = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String rfaExptPrevVerSeq = null;
	/* Column Info */
	private String msgDt = null;
	/* Column Info */
	private String progSeq = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Column Info */
	private String orgDestLocCd = null;
	/* Column Info */
	private String orgDestSteCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String progUsrNm = null;
	/* Column Info */
	private String coverageList = null;
	/* Column Info */
	private String code2 = null;
	/* Column Info */
	private String code1 = null;
	/* Column Info */
	private String orgDestCntCd = null;
	/* Column Info */
	private String cvrgLocCd = null;
	/* Column Info */
	private String rfaExptHistVerSeq = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String rfaExptAproNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pgmNo = null;
	/* Column Info */
	private String fnlDestRgnCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String cvrgRgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtExptRqstStsCd = null;
	/* Column Info */
	private String rfaExptMapgSeq = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String popupFlag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String rfaExptVerSeq = null;
	/* Column Info */
	private String rfaRqstDtlSeq = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String rfaExptHistMapgSeq = null;
	/* Column Info */
	private String dmdtCgoTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String isTemp = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String rfaExptHistDarNo = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String fnlDestCntCd = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String fnlDestLocCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String fnlDestSteCd = null;
	/* Column Info */
	private String ftUseFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RFAProgressVO() {}

	public RFAProgressVO(String ibflag, String pagerows, String rfaExptDarNo, String rfaExptHistDarNo, String rfaExptMapgSeq, String rfaExptHistMapgSeq, String rfaExptVerSeq, String rfaExptHistVerSeq, String rfaExptPrevVerSeq, String rfaRqstDtlSeq, String propNo, String amdtSeq, String rfaNo, String dmdtExptRqstStsCd, String progSeq, String dmdtExptRqstStsDesc, String progRmk, String progDt, String progUsrId, String progUsrNm, String progOfcCd, String bkgCustTpCd, String custCntCd, String custSeq, String custCd, String custNm, String rqstUsrId, String rqstOfcCd, String rqstDt, String rfaExptAproNo, String aproUsrId, String aproDt, String aproOfcCd, String msgDt, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String isTemp, String rhqOfcCd, String usrRoleCd, String pgmNo, String usrId, String code1, String code2, String fnlDestCntCd, String fnlDestRgnCd, String fnlDestSteCd, String fnlDestLocCd, String cvrgCntCd, String cvrgRgnCd, String cvrgSteCd, String cvrgLocCd, String orgDestCntCd, String orgDestRgnCd, String orgDestSteCd, String orgDestLocCd, String actCustCntCd, String actCustSeq, String coverageList, String effDt, String expDt, String dmdtCntrTpCd, String dmdtCgoTpCd, String dmdtTrfCd, String popupFlag, String ftUseFlg) {
		this.progUsrId = progUsrId;
		this.amdtSeq = amdtSeq;
		this.aproOfcCd = aproOfcCd;
		this.dmdtExptRqstStsDesc = dmdtExptRqstStsDesc;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.progDt = progDt;
		this.cvrgSteCd = cvrgSteCd;
		this.progOfcCd = progOfcCd;
		this.rfaExptDarNo = rfaExptDarNo;
		this.progRmk = progRmk;
		this.orgDestRgnCd = orgDestRgnCd;
		this.cvrgCntCd = cvrgCntCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.rfaExptPrevVerSeq = rfaExptPrevVerSeq;
		this.msgDt = msgDt;
		this.progSeq = progSeq;
		this.usrRoleCd = usrRoleCd;
		this.orgDestLocCd = orgDestLocCd;
		this.orgDestSteCd = orgDestSteCd;
		this.aproDt = aproDt;
		this.rhqOfcCd = rhqOfcCd;
		this.creUsrId = creUsrId;
		this.custCd = custCd;
		this.progUsrNm = progUsrNm;
		this.coverageList = coverageList;
		this.code2 = code2;
		this.code1 = code1;
		this.orgDestCntCd = orgDestCntCd;
		this.cvrgLocCd = cvrgLocCd;
		this.rfaExptHistVerSeq = rfaExptHistVerSeq;
		this.rqstUsrId = rqstUsrId;
		this.custNm = custNm;
		this.rfaExptAproNo = rfaExptAproNo;
		this.creDt = creDt;
		this.pgmNo = pgmNo;
		this.fnlDestRgnCd = fnlDestRgnCd;
		this.rfaNo = rfaNo;
		this.cvrgRgnCd = cvrgRgnCd;
		this.ibflag = ibflag;
		this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
		this.rfaExptMapgSeq = rfaExptMapgSeq;
		this.usrId = usrId;
		this.popupFlag = popupFlag;
		this.creOfcCd = creOfcCd;
		this.actCustCntCd = actCustCntCd;
		this.rfaExptVerSeq = rfaExptVerSeq;
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
		this.expDt = expDt;
		this.rfaExptHistMapgSeq = rfaExptHistMapgSeq;
		this.dmdtCgoTpCd = dmdtCgoTpCd;
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.isTemp = isTemp;
		this.actCustSeq = actCustSeq;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.rfaExptHistDarNo = rfaExptHistDarNo;
		this.custSeq = custSeq;
		this.fnlDestCntCd = fnlDestCntCd;
		this.aproUsrId = aproUsrId;
		this.fnlDestLocCd = fnlDestLocCd;
		this.propNo = propNo;
		this.rqstOfcCd = rqstOfcCd;
		this.fnlDestSteCd = fnlDestSteCd;
		this.ftUseFlg = ftUseFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prog_usr_id", getProgUsrId());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("dmdt_expt_rqst_sts_desc", getDmdtExptRqstStsDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prog_dt", getProgDt());
		this.hashColumns.put("cvrg_ste_cd", getCvrgSteCd());
		this.hashColumns.put("prog_ofc_cd", getProgOfcCd());
		this.hashColumns.put("rfa_expt_dar_no", getRfaExptDarNo());
		this.hashColumns.put("prog_rmk", getProgRmk());
		this.hashColumns.put("org_dest_rgn_cd", getOrgDestRgnCd());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("rfa_expt_prev_ver_seq", getRfaExptPrevVerSeq());
		this.hashColumns.put("msg_dt", getMsgDt());
		this.hashColumns.put("prog_seq", getProgSeq());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("org_dest_loc_cd", getOrgDestLocCd());
		this.hashColumns.put("org_dest_ste_cd", getOrgDestSteCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("prog_usr_nm", getProgUsrNm());
		this.hashColumns.put("coverage_list", getCoverageList());
		this.hashColumns.put("code2", getCode2());
		this.hashColumns.put("code1", getCode1());
		this.hashColumns.put("org_dest_cnt_cd", getOrgDestCntCd());
		this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
		this.hashColumns.put("rfa_expt_hist_ver_seq", getRfaExptHistVerSeq());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("rfa_expt_apro_no", getRfaExptAproNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("fnl_dest_rgn_cd", getFnlDestRgnCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_expt_rqst_sts_cd", getDmdtExptRqstStsCd());
		this.hashColumns.put("rfa_expt_mapg_seq", getRfaExptMapgSeq());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("popup_flag", getPopupFlag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("rfa_expt_ver_seq", getRfaExptVerSeq());
		this.hashColumns.put("rfa_rqst_dtl_seq", getRfaRqstDtlSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("rfa_expt_hist_mapg_seq", getRfaExptHistMapgSeq());
		this.hashColumns.put("dmdt_cgo_tp_cd", getDmdtCgoTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("is_temp", getIsTemp());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("rfa_expt_hist_dar_no", getRfaExptHistDarNo());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("fnl_dest_cnt_cd", getFnlDestCntCd());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("fnl_dest_loc_cd", getFnlDestLocCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("fnl_dest_ste_cd", getFnlDestSteCd());
		this.hashColumns.put("ft_use_flg", getFtUseFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prog_usr_id", "progUsrId");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("dmdt_expt_rqst_sts_desc", "dmdtExptRqstStsDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prog_dt", "progDt");
		this.hashFields.put("cvrg_ste_cd", "cvrgSteCd");
		this.hashFields.put("prog_ofc_cd", "progOfcCd");
		this.hashFields.put("rfa_expt_dar_no", "rfaExptDarNo");
		this.hashFields.put("prog_rmk", "progRmk");
		this.hashFields.put("org_dest_rgn_cd", "orgDestRgnCd");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("rfa_expt_prev_ver_seq", "rfaExptPrevVerSeq");
		this.hashFields.put("msg_dt", "msgDt");
		this.hashFields.put("prog_seq", "progSeq");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("org_dest_loc_cd", "orgDestLocCd");
		this.hashFields.put("org_dest_ste_cd", "orgDestSteCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("prog_usr_nm", "progUsrNm");
		this.hashFields.put("coverage_list", "coverageList");
		this.hashFields.put("code2", "code2");
		this.hashFields.put("code1", "code1");
		this.hashFields.put("org_dest_cnt_cd", "orgDestCntCd");
		this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
		this.hashFields.put("rfa_expt_hist_ver_seq", "rfaExptHistVerSeq");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("rfa_expt_apro_no", "rfaExptAproNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("fnl_dest_rgn_cd", "fnlDestRgnCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_expt_rqst_sts_cd", "dmdtExptRqstStsCd");
		this.hashFields.put("rfa_expt_mapg_seq", "rfaExptMapgSeq");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("popup_flag", "popupFlag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("rfa_expt_ver_seq", "rfaExptVerSeq");
		this.hashFields.put("rfa_rqst_dtl_seq", "rfaRqstDtlSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("rfa_expt_hist_mapg_seq", "rfaExptHistMapgSeq");
		this.hashFields.put("dmdt_cgo_tp_cd", "dmdtCgoTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("is_temp", "isTemp");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("rfa_expt_hist_dar_no", "rfaExptHistDarNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("fnl_dest_cnt_cd", "fnlDestCntCd");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("fnl_dest_loc_cd", "fnlDestLocCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("fnl_dest_ste_cd", "fnlDestSteCd");
		this.hashFields.put("ft_use_flg", "ftUseFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return progUsrId
	 */
	public String getProgUsrId() {
		return this.progUsrId;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptRqstStsDesc
	 */
	public String getDmdtExptRqstStsDesc() {
		return this.dmdtExptRqstStsDesc;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return progDt
	 */
	public String getProgDt() {
		return this.progDt;
	}
	
	/**
	 * Column Info
	 * @return cvrgSteCd
	 */
	public String getCvrgSteCd() {
		return this.cvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @return progOfcCd
	 */
	public String getProgOfcCd() {
		return this.progOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rfaExptDarNo
	 */
	public String getRfaExptDarNo() {
		return this.rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return progRmk
	 */
	public String getProgRmk() {
		return this.progRmk;
	}
	
	/**
	 * Column Info
	 * @return orgDestRgnCd
	 */
	public String getOrgDestRgnCd() {
		return this.orgDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgCntCd
	 */
	public String getCvrgCntCd() {
		return this.cvrgCntCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rfaExptPrevVerSeq
	 */
	public String getRfaExptPrevVerSeq() {
		return this.rfaExptPrevVerSeq;
	}
	
	/**
	 * Column Info
	 * @return msgDt
	 */
	public String getMsgDt() {
		return this.msgDt;
	}
	
	/**
	 * Column Info
	 * @return progSeq
	 */
	public String getProgSeq() {
		return this.progSeq;
	}
	
	/**
	 * Column Info
	 * @return usrRoleCd
	 */
	public String getUsrRoleCd() {
		return this.usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestLocCd
	 */
	public String getOrgDestLocCd() {
		return this.orgDestLocCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestSteCd
	 */
	public String getOrgDestSteCd() {
		return this.orgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return progUsrNm
	 */
	public String getProgUsrNm() {
		return this.progUsrNm;
	}
	
	/**
	 * Column Info
	 * @return coverageList
	 */
	public String getCoverageList() {
		return this.coverageList;
	}
	
	/**
	 * Column Info
	 * @return code2
	 */
	public String getCode2() {
		return this.code2;
	}
	
	/**
	 * Column Info
	 * @return code1
	 */
	public String getCode1() {
		return this.code1;
	}
	
	/**
	 * Column Info
	 * @return orgDestCntCd
	 */
	public String getOrgDestCntCd() {
		return this.orgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgLocCd
	 */
	public String getCvrgLocCd() {
		return this.cvrgLocCd;
	}
	
	/**
	 * Column Info
	 * @return rfaExptHistVerSeq
	 */
	public String getRfaExptHistVerSeq() {
		return this.rfaExptHistVerSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return rfaExptAproNo
	 */
	public String getRfaExptAproNo() {
		return this.rfaExptAproNo;
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
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
	}
	
	/**
	 * Column Info
	 * @return fnlDestRgnCd
	 */
	public String getFnlDestRgnCd() {
		return this.fnlDestRgnCd;
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
	 * @return cvrgRgnCd
	 */
	public String getCvrgRgnCd() {
		return this.cvrgRgnCd;
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
	 * @return dmdtExptRqstStsCd
	 */
	public String getDmdtExptRqstStsCd() {
		return this.dmdtExptRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @return rfaExptMapgSeq
	 */
	public String getRfaExptMapgSeq() {
		return this.rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return popupFlag
	 */
	public String getPopupFlag() {
		return this.popupFlag;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return rfaExptVerSeq
	 */
	public String getRfaExptVerSeq() {
		return this.rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaRqstDtlSeq
	 */
	public String getRfaRqstDtlSeq() {
		return this.rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return rfaExptHistMapgSeq
	 */
	public String getRfaExptHistMapgSeq() {
		return this.rfaExptHistMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtCgoTpCd
	 */
	public String getDmdtCgoTpCd() {
		return this.dmdtCgoTpCd;
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return isTemp
	 */
	public String getIsTemp() {
		return this.isTemp;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return rfaExptHistDarNo
	 */
	public String getRfaExptHistDarNo() {
		return this.rfaExptHistDarNo;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlDestCntCd
	 */
	public String getFnlDestCntCd() {
		return this.fnlDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return fnlDestLocCd
	 */
	public String getFnlDestLocCd() {
		return this.fnlDestLocCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fnlDestSteCd
	 */
	public String getFnlDestSteCd() {
		return this.fnlDestSteCd;
	}

	/**
	 * Column Info
	 * @return ftUseFlg
	 */	
	public String getFtUseFlg() {
		return ftUseFlg;
	}
	
	/**
	 * Column Info
	 * @param progUsrId
	 */
	public void setProgUsrId(String progUsrId) {
		this.progUsrId = progUsrId;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptRqstStsDesc
	 */
	public void setDmdtExptRqstStsDesc(String dmdtExptRqstStsDesc) {
		this.dmdtExptRqstStsDesc = dmdtExptRqstStsDesc;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param progDt
	 */
	public void setProgDt(String progDt) {
		this.progDt = progDt;
	}
	
	/**
	 * Column Info
	 * @param cvrgSteCd
	 */
	public void setCvrgSteCd(String cvrgSteCd) {
		this.cvrgSteCd = cvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @param progOfcCd
	 */
	public void setProgOfcCd(String progOfcCd) {
		this.progOfcCd = progOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rfaExptDarNo
	 */
	public void setRfaExptDarNo(String rfaExptDarNo) {
		this.rfaExptDarNo = rfaExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param progRmk
	 */
	public void setProgRmk(String progRmk) {
		this.progRmk = progRmk;
	}
	
	/**
	 * Column Info
	 * @param orgDestRgnCd
	 */
	public void setOrgDestRgnCd(String orgDestRgnCd) {
		this.orgDestRgnCd = orgDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgCntCd
	 */
	public void setCvrgCntCd(String cvrgCntCd) {
		this.cvrgCntCd = cvrgCntCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rfaExptPrevVerSeq
	 */
	public void setRfaExptPrevVerSeq(String rfaExptPrevVerSeq) {
		this.rfaExptPrevVerSeq = rfaExptPrevVerSeq;
	}
	
	/**
	 * Column Info
	 * @param msgDt
	 */
	public void setMsgDt(String msgDt) {
		this.msgDt = msgDt;
	}
	
	/**
	 * Column Info
	 * @param progSeq
	 */
	public void setProgSeq(String progSeq) {
		this.progSeq = progSeq;
	}
	
	/**
	 * Column Info
	 * @param usrRoleCd
	 */
	public void setUsrRoleCd(String usrRoleCd) {
		this.usrRoleCd = usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestLocCd
	 */
	public void setOrgDestLocCd(String orgDestLocCd) {
		this.orgDestLocCd = orgDestLocCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestSteCd
	 */
	public void setOrgDestSteCd(String orgDestSteCd) {
		this.orgDestSteCd = orgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param progUsrNm
	 */
	public void setProgUsrNm(String progUsrNm) {
		this.progUsrNm = progUsrNm;
	}
	
	/**
	 * Column Info
	 * @param coverageList
	 */
	public void setCoverageList(String coverageList) {
		this.coverageList = coverageList;
	}
	
	/**
	 * Column Info
	 * @param code2
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	/**
	 * Column Info
	 * @param code1
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	
	/**
	 * Column Info
	 * @param orgDestCntCd
	 */
	public void setOrgDestCntCd(String orgDestCntCd) {
		this.orgDestCntCd = orgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgLocCd
	 */
	public void setCvrgLocCd(String cvrgLocCd) {
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * Column Info
	 * @param rfaExptHistVerSeq
	 */
	public void setRfaExptHistVerSeq(String rfaExptHistVerSeq) {
		this.rfaExptHistVerSeq = rfaExptHistVerSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param rfaExptAproNo
	 */
	public void setRfaExptAproNo(String rfaExptAproNo) {
		this.rfaExptAproNo = rfaExptAproNo;
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
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	
	/**
	 * Column Info
	 * @param fnlDestRgnCd
	 */
	public void setFnlDestRgnCd(String fnlDestRgnCd) {
		this.fnlDestRgnCd = fnlDestRgnCd;
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
	 * @param cvrgRgnCd
	 */
	public void setCvrgRgnCd(String cvrgRgnCd) {
		this.cvrgRgnCd = cvrgRgnCd;
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
	 * @param dmdtExptRqstStsCd
	 */
	public void setDmdtExptRqstStsCd(String dmdtExptRqstStsCd) {
		this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @param rfaExptMapgSeq
	 */
	public void setRfaExptMapgSeq(String rfaExptMapgSeq) {
		this.rfaExptMapgSeq = rfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param popupFlag
	 */
	public void setPopupFlag(String popupFlag) {
		this.popupFlag = popupFlag;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param rfaExptVerSeq
	 */
	public void setRfaExptVerSeq(String rfaExptVerSeq) {
		this.rfaExptVerSeq = rfaExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaRqstDtlSeq
	 */
	public void setRfaRqstDtlSeq(String rfaRqstDtlSeq) {
		this.rfaRqstDtlSeq = rfaRqstDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param rfaExptHistMapgSeq
	 */
	public void setRfaExptHistMapgSeq(String rfaExptHistMapgSeq) {
		this.rfaExptHistMapgSeq = rfaExptHistMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtCgoTpCd
	 */
	public void setDmdtCgoTpCd(String dmdtCgoTpCd) {
		this.dmdtCgoTpCd = dmdtCgoTpCd;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param isTemp
	 */
	public void setIsTemp(String isTemp) {
		this.isTemp = isTemp;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param rfaExptHistDarNo
	 */
	public void setRfaExptHistDarNo(String rfaExptHistDarNo) {
		this.rfaExptHistDarNo = rfaExptHistDarNo;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlDestCntCd
	 */
	public void setFnlDestCntCd(String fnlDestCntCd) {
		this.fnlDestCntCd = fnlDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param fnlDestLocCd
	 */
	public void setFnlDestLocCd(String fnlDestLocCd) {
		this.fnlDestLocCd = fnlDestLocCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fnlDestSteCd
	 */
	public void setFnlDestSteCd(String fnlDestSteCd) {
		this.fnlDestSteCd = fnlDestSteCd;
	}
	/**
	 * Column Info
	 * @return ftUseFlg
	 */	
	public void setFtUseFlg(String ftUseFlg) {
		this.ftUseFlg = ftUseFlg;
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
		setProgUsrId(JSPUtil.getParameter(request, prefix + "prog_usr_id", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setDmdtExptRqstStsDesc(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setProgDt(JSPUtil.getParameter(request, prefix + "prog_dt", ""));
		setCvrgSteCd(JSPUtil.getParameter(request, prefix + "cvrg_ste_cd", ""));
		setProgOfcCd(JSPUtil.getParameter(request, prefix + "prog_ofc_cd", ""));
		setRfaExptDarNo(JSPUtil.getParameter(request, prefix + "rfa_expt_dar_no", ""));
		setProgRmk(JSPUtil.getParameter(request, prefix + "prog_rmk", ""));
		setOrgDestRgnCd(JSPUtil.getParameter(request, prefix + "org_dest_rgn_cd", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, prefix + "cvrg_cnt_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setRfaExptPrevVerSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_prev_ver_seq", ""));
		setMsgDt(JSPUtil.getParameter(request, prefix + "msg_dt", ""));
		setProgSeq(JSPUtil.getParameter(request, prefix + "prog_seq", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, prefix + "usr_role_cd", ""));
		setOrgDestLocCd(JSPUtil.getParameter(request, prefix + "org_dest_loc_cd", ""));
		setOrgDestSteCd(JSPUtil.getParameter(request, prefix + "org_dest_ste_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setProgUsrNm(JSPUtil.getParameter(request, prefix + "prog_usr_nm", ""));
		setCoverageList(JSPUtil.getParameter(request, prefix + "coverage_list", ""));
		setCode2(JSPUtil.getParameter(request, prefix + "code2", ""));
		setCode1(JSPUtil.getParameter(request, prefix + "code1", ""));
		setOrgDestCntCd(JSPUtil.getParameter(request, prefix + "org_dest_cnt_cd", ""));
		setCvrgLocCd(JSPUtil.getParameter(request, prefix + "cvrg_loc_cd", ""));
		setRfaExptHistVerSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_hist_ver_seq", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setRfaExptAproNo(JSPUtil.getParameter(request, prefix + "rfa_expt_apro_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setFnlDestRgnCd(JSPUtil.getParameter(request, prefix + "fnl_dest_rgn_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCvrgRgnCd(JSPUtil.getParameter(request, prefix + "cvrg_rgn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDmdtExptRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd", ""));
		setRfaExptMapgSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_mapg_seq", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPopupFlag(JSPUtil.getParameter(request, prefix + "popup_flag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setRfaExptVerSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_ver_seq", ""));
		setRfaRqstDtlSeq(JSPUtil.getParameter(request, prefix + "rfa_rqst_dtl_seq", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setRfaExptHistMapgSeq(JSPUtil.getParameter(request, prefix + "rfa_expt_hist_mapg_seq", ""));
		setDmdtCgoTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cgo_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setIsTemp(JSPUtil.getParameter(request, prefix + "is_temp", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, prefix + "dmdt_cntr_tp_cd", ""));
		setRfaExptHistDarNo(JSPUtil.getParameter(request, prefix + "rfa_expt_hist_dar_no", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFnlDestCntCd(JSPUtil.getParameter(request, prefix + "fnl_dest_cnt_cd", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setFnlDestLocCd(JSPUtil.getParameter(request, prefix + "fnl_dest_loc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setFnlDestSteCd(JSPUtil.getParameter(request, prefix + "fnl_dest_ste_cd", ""));
		setFtUseFlg(JSPUtil.getParameter(request, prefix + "ft_use_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFAProgressVO[]
	 */
	public RFAProgressVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFAProgressVO[]
	 */
	public RFAProgressVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RFAProgressVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] progUsrId = (JSPUtil.getParameter(request, prefix	+ "prog_usr_id", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] dmdtExptRqstStsDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_sts_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] progDt = (JSPUtil.getParameter(request, prefix	+ "prog_dt", length));
			String[] cvrgSteCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_ste_cd", length));
			String[] progOfcCd = (JSPUtil.getParameter(request, prefix	+ "prog_ofc_cd", length));
			String[] rfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_dar_no", length));
			String[] progRmk = (JSPUtil.getParameter(request, prefix	+ "prog_rmk", length));
			String[] orgDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_rgn_cd", length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] rfaExptPrevVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_prev_ver_seq", length));
			String[] msgDt = (JSPUtil.getParameter(request, prefix	+ "msg_dt", length));
			String[] progSeq = (JSPUtil.getParameter(request, prefix	+ "prog_seq", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] orgDestLocCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_loc_cd", length));
			String[] orgDestSteCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_ste_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] progUsrNm = (JSPUtil.getParameter(request, prefix	+ "prog_usr_nm", length));
			String[] coverageList = (JSPUtil.getParameter(request, prefix	+ "coverage_list", length));
			String[] code2 = (JSPUtil.getParameter(request, prefix	+ "code2", length));
			String[] code1 = (JSPUtil.getParameter(request, prefix	+ "code1", length));
			String[] orgDestCntCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cnt_cd", length));
			String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_loc_cd", length));
			String[] rfaExptHistVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_hist_ver_seq", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] rfaExptAproNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_apro_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] fnlDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_rgn_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtExptRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_sts_cd", length));
			String[] rfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_mapg_seq", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] popupFlag = (JSPUtil.getParameter(request, prefix	+ "popup_flag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] rfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_ver_seq", length));
			String[] rfaRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_rqst_dtl_seq", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] rfaExptHistMapgSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_hist_mapg_seq", length));
			String[] dmdtCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cgo_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] isTemp = (JSPUtil.getParameter(request, prefix	+ "is_temp", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] rfaExptHistDarNo = (JSPUtil.getParameter(request, prefix	+ "rfa_expt_hist_dar_no", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] fnlDestCntCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_cnt_cd", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] fnlDestLocCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_loc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] fnlDestSteCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_ste_cd", length));
			String[] ftUseFlg = (JSPUtil.getParameter(request, prefix	+ "ft_use_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RFAProgressVO();
				if (progUsrId[i] != null)
					model.setProgUsrId(progUsrId[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (dmdtExptRqstStsDesc[i] != null)
					model.setDmdtExptRqstStsDesc(dmdtExptRqstStsDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (progDt[i] != null)
					model.setProgDt(progDt[i]);
				if (cvrgSteCd[i] != null)
					model.setCvrgSteCd(cvrgSteCd[i]);
				if (progOfcCd[i] != null)
					model.setProgOfcCd(progOfcCd[i]);
				if (rfaExptDarNo[i] != null)
					model.setRfaExptDarNo(rfaExptDarNo[i]);
				if (progRmk[i] != null)
					model.setProgRmk(progRmk[i]);
				if (orgDestRgnCd[i] != null)
					model.setOrgDestRgnCd(orgDestRgnCd[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (rfaExptPrevVerSeq[i] != null)
					model.setRfaExptPrevVerSeq(rfaExptPrevVerSeq[i]);
				if (msgDt[i] != null)
					model.setMsgDt(msgDt[i]);
				if (progSeq[i] != null)
					model.setProgSeq(progSeq[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (orgDestLocCd[i] != null)
					model.setOrgDestLocCd(orgDestLocCd[i]);
				if (orgDestSteCd[i] != null)
					model.setOrgDestSteCd(orgDestSteCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (progUsrNm[i] != null)
					model.setProgUsrNm(progUsrNm[i]);
				if (coverageList[i] != null)
					model.setCoverageList(coverageList[i]);
				if (code2[i] != null)
					model.setCode2(code2[i]);
				if (code1[i] != null)
					model.setCode1(code1[i]);
				if (orgDestCntCd[i] != null)
					model.setOrgDestCntCd(orgDestCntCd[i]);
				if (cvrgLocCd[i] != null)
					model.setCvrgLocCd(cvrgLocCd[i]);
				if (rfaExptHistVerSeq[i] != null)
					model.setRfaExptHistVerSeq(rfaExptHistVerSeq[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (rfaExptAproNo[i] != null)
					model.setRfaExptAproNo(rfaExptAproNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (fnlDestRgnCd[i] != null)
					model.setFnlDestRgnCd(fnlDestRgnCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (cvrgRgnCd[i] != null)
					model.setCvrgRgnCd(cvrgRgnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtExptRqstStsCd[i] != null)
					model.setDmdtExptRqstStsCd(dmdtExptRqstStsCd[i]);
				if (rfaExptMapgSeq[i] != null)
					model.setRfaExptMapgSeq(rfaExptMapgSeq[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (popupFlag[i] != null)
					model.setPopupFlag(popupFlag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (rfaExptVerSeq[i] != null)
					model.setRfaExptVerSeq(rfaExptVerSeq[i]);
				if (rfaRqstDtlSeq[i] != null)
					model.setRfaRqstDtlSeq(rfaRqstDtlSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (rfaExptHistMapgSeq[i] != null)
					model.setRfaExptHistMapgSeq(rfaExptHistMapgSeq[i]);
				if (dmdtCgoTpCd[i] != null)
					model.setDmdtCgoTpCd(dmdtCgoTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (isTemp[i] != null)
					model.setIsTemp(isTemp[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (rfaExptHistDarNo[i] != null)
					model.setRfaExptHistDarNo(rfaExptHistDarNo[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (fnlDestCntCd[i] != null)
					model.setFnlDestCntCd(fnlDestCntCd[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (fnlDestLocCd[i] != null)
					model.setFnlDestLocCd(fnlDestLocCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (fnlDestSteCd[i] != null)
					model.setFnlDestSteCd(fnlDestSteCd[i]);
				if (ftUseFlg[i] != null)
					model.setFtUseFlg(ftUseFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRFAProgressVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RFAProgressVO[]
	 */
	public RFAProgressVO[] getRFAProgressVOs(){
		RFAProgressVO[] vos = (RFAProgressVO[])models.toArray(new RFAProgressVO[models.size()]);
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
		this.progUsrId = this.progUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstStsDesc = this.dmdtExptRqstStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progDt = this.progDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgSteCd = this.cvrgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progOfcCd = this.progOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptDarNo = this.rfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progRmk = this.progRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestRgnCd = this.orgDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptPrevVerSeq = this.rfaExptPrevVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDt = this.msgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progSeq = this.progSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestLocCd = this.orgDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestSteCd = this.orgDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.progUsrNm = this.progUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coverageList = this.coverageList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code2 = this.code2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code1 = this.code1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCntCd = this.orgDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgLocCd = this.cvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptHistVerSeq = this.rfaExptHistVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptAproNo = this.rfaExptAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestRgnCd = this.fnlDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnCd = this.cvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstStsCd = this.dmdtExptRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptMapgSeq = this.rfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popupFlag = this.popupFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptVerSeq = this.rfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaRqstDtlSeq = this.rfaRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptHistMapgSeq = this.rfaExptHistMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCgoTpCd = this.dmdtCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isTemp = this.isTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaExptHistDarNo = this.rfaExptHistDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestCntCd = this.fnlDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestLocCd = this.fnlDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestSteCd = this.fnlDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftUseFlg = this.ftUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
