/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrStatusCreationVO.java
*@FileTitle : CntrStatusCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.04.14 이호선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrStatusCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrStatusCreationVO> models = new ArrayList<CntrStatusCreationVO>();
	
	/* Column Info */
	private String onhYdCd = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String ieflg = null;
	/* Column Info */
	private String hidCntrNo = null;
	/* Column Info */
	private String stsEvntYdCd = null;
	/* Column Info */
	private String ceflg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ueflg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String deflg = null;
	/* Column Info */
	private String cntrDrffAmt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String hireDate = null;
	/* Column Info */
	private String feflg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String eeflg = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String beflg = null;
	/* Column Info */
	private String lseCoRtnYdCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String onhDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrDrffCrAmt = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String aeflg = null;
	/* Column Info */
	private String cntrLftChgAmt = null;
	/* Column Info */
	private String cntrPkupChgAmt = null;
	/* Column Info */
	private String cntrLftChgCur = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrPkupCrChgAmt = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String stCd = null;
	/* Column Info */
	private String rntlChgFreeDys = null;
	/* Column Info */
	private String cntrStsEvntDt = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String offhDueDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String offhStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrOldVanFlg = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String cntrRmk = null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 expDt   =  null;
	/*	Column Info	*/
	private  String	 approvalNo   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrStatusCreationVO() {}

	public CntrStatusCreationVO(String ibflag, String pagerows, String onhYdCd, String cntrStsCd, String ieflg, String hidCntrNo, String stsEvntYdCd, String ceflg, String ueflg, String cntrTpszCd, String lstmCd, String updUsrId, String deflg, String cntrDrffAmt, String cnmvDt, String agmtSeq, String hireDate, String agmtNo, String feflg, String creUsrId, String eeflg, String vndrSeq, String fullFlg, String beflg, String vndrLglEngNm, String crntYdCd, String onhDt, String cntrDrffCrAmt, String cnmvStsCd, String aeflg, String cntrLftChgAmt, String cntrPkupChgAmt, String cntrLftChgCur, String agmtCtyCd, String cntrPkupCrChgAmt, String hisSeq, String stCd, String rntlChgFreeDys, String cntrStsEvntDt, String eccCd, String rccCd, String offhDueDt, String ofcCd, String lccCd, String sccCd, String offhStsCd, String cntrNo, String cntrOldVanFlg, String refNo, String cntrRmk, String lseCoRtnYdCd,String effDt,String expDt,String approvalNo) {
		this.onhYdCd = onhYdCd;
		this.cntrStsCd = cntrStsCd;
		this.ieflg = ieflg;
		this.hidCntrNo = hidCntrNo;
		this.stsEvntYdCd = stsEvntYdCd;
		this.ceflg = ceflg;
		this.pagerows = pagerows;
		this.ueflg = ueflg;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.deflg = deflg;
		this.cntrDrffAmt = cntrDrffAmt;
		this.agmtSeq = agmtSeq;
		this.cnmvDt = cnmvDt;
		this.agmtNo = agmtNo;
		this.hireDate = hireDate;
		this.feflg = feflg;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.eeflg = eeflg;
		this.fullFlg = fullFlg;
		this.beflg = beflg;
		this.lseCoRtnYdCd = lseCoRtnYdCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.crntYdCd = crntYdCd;
		this.onhDt = onhDt;
		this.ibflag = ibflag;
		this.cntrDrffCrAmt = cntrDrffCrAmt;
		this.cnmvStsCd = cnmvStsCd;
		this.aeflg = aeflg;
		this.cntrLftChgAmt = cntrLftChgAmt;
		this.cntrPkupChgAmt = cntrPkupChgAmt;
		this.cntrLftChgCur = cntrLftChgCur;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrPkupCrChgAmt = cntrPkupCrChgAmt;
		this.hisSeq = hisSeq;
		this.stCd = stCd;
		this.rntlChgFreeDys = rntlChgFreeDys;
		this.cntrStsEvntDt = cntrStsEvntDt;
		this.eccCd = eccCd;
		this.rccCd = rccCd;
		this.offhDueDt = offhDueDt;
		this.ofcCd = ofcCd;
		this.lccCd = lccCd;
		this.sccCd = sccCd;
		this.offhStsCd = offhStsCd;
		this.cntrNo = cntrNo;
		this.cntrOldVanFlg = cntrOldVanFlg;
		this.refNo = refNo;
		this.cntrRmk = cntrRmk;
		this.effDt  = effDt ;
		this.expDt  = expDt ;
		this.approvalNo  = approvalNo ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("ieflg", getIeflg());
		this.hashColumns.put("hid_cntr_no", getHidCntrNo());
		this.hashColumns.put("sts_evnt_yd_cd", getStsEvntYdCd());
		this.hashColumns.put("ceflg", getCeflg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ueflg", getUeflg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("deflg", getDeflg());
		this.hashColumns.put("cntr_drff_amt", getCntrDrffAmt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("hire_date", getHireDate());
		this.hashColumns.put("feflg", getFeflg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eeflg", getEeflg());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("beflg", getBeflg());
		this.hashColumns.put("lse_co_rtn_yd_cd", getLseCoRtnYdCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_drff_cr_amt", getCntrDrffCrAmt());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("aeflg", getAeflg());
		this.hashColumns.put("cntr_lft_chg_amt", getCntrLftChgAmt());
		this.hashColumns.put("cntr_pkup_chg_amt", getCntrPkupChgAmt());
		this.hashColumns.put("cntr_lft_chg_cur", getCntrLftChgCur());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_pkup_cr_chg_amt", getCntrPkupCrChgAmt());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("st_cd", getStCd());
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());
		this.hashColumns.put("cntr_sts_evnt_dt", getCntrStsEvntDt());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("offh_due_dt", getOffhDueDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("offh_sts_cd", getOffhStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_old_van_flg", getCntrOldVanFlg());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("cntr_rmk", getCntrRmk());
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("approval_no", getApprovalNo());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("ieflg", "ieflg");
		this.hashFields.put("hid_cntr_no", "hidCntrNo");
		this.hashFields.put("sts_evnt_yd_cd", "stsEvntYdCd");
		this.hashFields.put("ceflg", "ceflg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ueflg", "ueflg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("deflg", "deflg");
		this.hashFields.put("cntr_drff_amt", "cntrDrffAmt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("hire_date", "hireDate");
		this.hashFields.put("feflg", "feflg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eeflg", "eeflg");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("beflg", "beflg");
		this.hashFields.put("lse_co_rtn_yd_cd", "lseCoRtnYdCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_drff_cr_amt", "cntrDrffCrAmt");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("aeflg", "aeflg");
		this.hashFields.put("cntr_lft_chg_amt", "cntrLftChgAmt");
		this.hashFields.put("cntr_pkup_chg_amt", "cntrPkupChgAmt");
		this.hashFields.put("cntr_lft_chg_cur", "cntrLftChgCur");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_pkup_cr_chg_amt", "cntrPkupCrChgAmt");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("st_cd", "stCd");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("cntr_sts_evnt_dt", "cntrStsEvntDt");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("offh_due_dt", "offhDueDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("offh_sts_cd", "offhStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_old_van_flg", "cntrOldVanFlg");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cntr_rmk", "cntrRmk");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("approval_no", "approvalNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return onhYdCd
	 */
	public String getOnhYdCd() {
		return this.onhYdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return ieflg
	 */
	public String getIeflg() {
		return this.ieflg;
	}
	
	/**
	 * Column Info
	 * @return hidCntrNo
	 */
	public String getHidCntrNo() {
		return this.hidCntrNo;
	}
	
	/**
	 * Column Info
	 * @return stsEvntYdCd
	 */
	public String getStsEvntYdCd() {
		return this.stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @return ceflg
	 */
	public String getCeflg() {
		return this.ceflg;
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
	 * @return ueflg
	 */
	public String getUeflg() {
		return this.ueflg;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return deflg
	 */
	public String getDeflg() {
		return this.deflg;
	}
	
	/**
	 * Column Info
	 * @return cntrDrffAmt
	 */
	public String getCntrDrffAmt() {
		return this.cntrDrffAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return hireDate
	 */
	public String getHireDate() {
		return this.hireDate;
	}
	
	/**
	 * Column Info
	 * @return feflg
	 */
	public String getFeflg() {
		return this.feflg;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return eeflg
	 */
	public String getEeflg() {
		return this.eeflg;
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
	 * @return beflg
	 */
	public String getBeflg() {
		return this.beflg;
	}
	
	/**
	 * Column Info
	 * @return lseCoRtnYdCd
	 */
	public String getLseCoRtnYdCd() {
		return this.lseCoRtnYdCd;
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
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return cntrDrffCrAmt
	 */
	public String getCntrDrffCrAmt() {
		return this.cntrDrffCrAmt;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return aeflg
	 */
	public String getAeflg() {
		return this.aeflg;
	}
	
	/**
	 * Column Info
	 * @return cntrLftChgAmt
	 */
	public String getCntrLftChgAmt() {
		return this.cntrLftChgAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupChgAmt
	 */
	public String getCntrPkupChgAmt() {
		return this.cntrPkupChgAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrLftChgCur
	 */
	public String getCntrLftChgCur() {
		return this.cntrLftChgCur;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupCrChgAmt
	 */
	public String getCntrPkupCrChgAmt() {
		return this.cntrPkupCrChgAmt;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return stCd
	 */
	public String getStCd() {
		return this.stCd;
	}
	
	/**
	 * Column Info
	 * @return rntlChgFreeDys
	 */
	public String getRntlChgFreeDys() {
		return this.rntlChgFreeDys;
	}
	
	/**
	 * Column Info
	 * @return cntrStsEvntDt
	 */
	public String getCntrStsEvntDt() {
		return this.cntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
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
	 * @return offhDueDt
	 */
	public String getOffhDueDt() {
		return this.offhDueDt;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return offhStsCd
	 */
	public String getOffhStsCd() {
		return this.offhStsCd;
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
	 * @return cntrOldVanFlg
	 */
	public String getCntrOldVanFlg() {
		return this.cntrOldVanFlg;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return cntrRmk
	 */
	public String getCntrRmk() {
		return this.cntrRmk;
	}
	

	/**
	 * Column Info
	 * @param onhYdCd
	 */
	public void setOnhYdCd(String onhYdCd) {
		this.onhYdCd = onhYdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param ieflg
	 */
	public void setIeflg(String ieflg) {
		this.ieflg = ieflg;
	}
	
	/**
	 * Column Info
	 * @param hidCntrNo
	 */
	public void setHidCntrNo(String hidCntrNo) {
		this.hidCntrNo = hidCntrNo;
	}
	
	/**
	 * Column Info
	 * @param stsEvntYdCd
	 */
	public void setStsEvntYdCd(String stsEvntYdCd) {
		this.stsEvntYdCd = stsEvntYdCd;
	}
	
	/**
	 * Column Info
	 * @param ceflg
	 */
	public void setCeflg(String ceflg) {
		this.ceflg = ceflg;
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
	 * @param ueflg
	 */
	public void setUeflg(String ueflg) {
		this.ueflg = ueflg;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param deflg
	 */
	public void setDeflg(String deflg) {
		this.deflg = deflg;
	}
	
	/**
	 * Column Info
	 * @param cntrDrffAmt
	 */
	public void setCntrDrffAmt(String cntrDrffAmt) {
		this.cntrDrffAmt = cntrDrffAmt;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param hireDate
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	/**
	 * Column Info
	 * @param feflg
	 */
	public void setFeflg(String feflg) {
		this.feflg = feflg;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param eeflg
	 */
	public void setEeflg(String eeflg) {
		this.eeflg = eeflg;
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
	 * @param beflg
	 */
	public void setBeflg(String beflg) {
		this.beflg = beflg;
	}
	
	/**
	 * Column Info
	 * @param lseCoRtnYdCd
	 */
	public void setLseCoRtnYdCd(String lseCoRtnYdCd) {
		this.lseCoRtnYdCd = lseCoRtnYdCd;
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
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param cntrDrffCrAmt
	 */
	public void setCntrDrffCrAmt(String cntrDrffCrAmt) {
		this.cntrDrffCrAmt = cntrDrffCrAmt;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param aeflg
	 */
	public void setAeflg(String aeflg) {
		this.aeflg = aeflg;
	}
	
	/**
	 * Column Info
	 * @param cntrLftChgAmt
	 */
	public void setCntrLftChgAmt(String cntrLftChgAmt) {
		this.cntrLftChgAmt = cntrLftChgAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupChgAmt
	 */
	public void setCntrPkupChgAmt(String cntrPkupChgAmt) {
		this.cntrPkupChgAmt = cntrPkupChgAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrLftChgCur
	 */
	public void setCntrLftChgCur(String cntrLftChgCur) {
		this.cntrLftChgCur = cntrLftChgCur;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupCrChgAmt
	 */
	public void setCntrPkupCrChgAmt(String cntrPkupCrChgAmt) {
		this.cntrPkupCrChgAmt = cntrPkupCrChgAmt;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param stCd
	 */
	public void setStCd(String stCd) {
		this.stCd = stCd;
	}
	
	/**
	 * Column Info
	 * @param rntlChgFreeDys
	 */
	public void setRntlChgFreeDys(String rntlChgFreeDys) {
		this.rntlChgFreeDys = rntlChgFreeDys;
	}
	
	/**
	 * Column Info
	 * @param cntrStsEvntDt
	 */
	public void setCntrStsEvntDt(String cntrStsEvntDt) {
		this.cntrStsEvntDt = cntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
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
	 * @param offhDueDt
	 */
	public void setOffhDueDt(String offhDueDt) {
		this.offhDueDt = offhDueDt;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param offhStsCd
	 */
	public void setOffhStsCd(String offhStsCd) {
		this.offhStsCd = offhStsCd;
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
	 * @param cntrOldVanFlg
	 */
	public void setCntrOldVanFlg(String cntrOldVanFlg) {
		this.cntrOldVanFlg = cntrOldVanFlg;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param cntrRmk
	 */
	public void setCntrRmk(String cntrRmk) {
		this.cntrRmk = cntrRmk;
	}
	
	/**
	* Column Info
	* @param  effDt
	*/
	public void	setEffDt( String	effDt ) {
		this.effDt =	effDt;
	}
 
	/**
	 * Column Info
	 * @return	effDt
	 */
	 public	 String	getEffDt() {
		 return	this.effDt;
	 } 
 	/**
	* Column Info
	* @param  expDt
	*/
	public void	setExpDt( String	expDt ) {
		this.expDt =	expDt;
	}
	
	/**
	 * Column Info
	 * @return	approvalNo
	 */
	 public	 String	getApprovalNo() {
		 return	this.approvalNo;
	 } 
 	/**
	* Column Info
	* @param  approvalNo
	*/
	public void	setApprovalNo( String	approvalNo ) {
		this.approvalNo =	approvalNo;
	}
 
	/**
	 * Column Info
	 * @return	expDt
	 */
	 public	 String	getExpDt() {
		 return	this.expDt;
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
		setOnhYdCd(JSPUtil.getParameter(request, prefix + "onh_yd_cd", ""));
		setCntrStsCd(JSPUtil.getParameter(request, prefix + "cntr_sts_cd", ""));
		setIeflg(JSPUtil.getParameter(request, prefix + "ieflg", ""));
		setHidCntrNo(JSPUtil.getParameter(request, prefix + "hid_cntr_no", ""));
		setStsEvntYdCd(JSPUtil.getParameter(request, prefix + "sts_evnt_yd_cd", ""));
		setCeflg(JSPUtil.getParameter(request, prefix + "ceflg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUeflg(JSPUtil.getParameter(request, prefix + "ueflg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDeflg(JSPUtil.getParameter(request, prefix + "deflg", ""));
		setCntrDrffAmt(JSPUtil.getParameter(request, prefix + "cntr_drff_amt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setCnmvDt(JSPUtil.getParameter(request, prefix + "cnmv_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setHireDate(JSPUtil.getParameter(request, prefix + "hire_date", ""));
		setFeflg(JSPUtil.getParameter(request, prefix + "feflg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setEeflg(JSPUtil.getParameter(request, prefix + "eeflg", ""));
		setFullFlg(JSPUtil.getParameter(request, prefix + "full_flg", ""));
		setBeflg(JSPUtil.getParameter(request, prefix + "beflg", ""));
		setLseCoRtnYdCd(JSPUtil.getParameter(request, prefix + "lse_co_rtn_yd_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrDrffCrAmt(JSPUtil.getParameter(request, prefix + "cntr_drff_cr_amt", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setAeflg(JSPUtil.getParameter(request, prefix + "aeflg", ""));
		setCntrLftChgAmt(JSPUtil.getParameter(request, prefix + "cntr_lft_chg_amt", ""));
		setCntrPkupChgAmt(JSPUtil.getParameter(request, prefix + "cntr_pkup_chg_amt", ""));
		setCntrLftChgCur(JSPUtil.getParameter(request, prefix + "cntr_lft_chg_cur", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setCntrPkupCrChgAmt(JSPUtil.getParameter(request, prefix + "cntr_pkup_cr_chg_amt", ""));
		setHisSeq(JSPUtil.getParameter(request, prefix + "his_seq", ""));
		setStCd(JSPUtil.getParameter(request, prefix + "st_cd", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request, prefix + "rntl_chg_free_dys", ""));
		setCntrStsEvntDt(JSPUtil.getParameter(request, prefix + "cntr_sts_evnt_dt", ""));
		setEccCd(JSPUtil.getParameter(request, prefix + "ecc_cd", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setOffhDueDt(JSPUtil.getParameter(request, prefix + "offh_due_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setOffhStsCd(JSPUtil.getParameter(request, prefix + "offh_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrOldVanFlg(JSPUtil.getParameter(request, prefix + "cntr_old_van_flg", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setCntrRmk(JSPUtil.getParameter(request, prefix + "cntr_rmk", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setApprovalNo(JSPUtil.getParameter(request,	prefix + "approval_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrStatusCreationVO[]
	 */
	public CntrStatusCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrStatusCreationVO[]
	 */
	public CntrStatusCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrStatusCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] onhYdCd = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] ieflg = (JSPUtil.getParameter(request, prefix	+ "ieflg", length));
			String[] hidCntrNo = (JSPUtil.getParameter(request, prefix	+ "hid_cntr_no", length));
			String[] stsEvntYdCd = (JSPUtil.getParameter(request, prefix	+ "sts_evnt_yd_cd", length));
			String[] ceflg = (JSPUtil.getParameter(request, prefix	+ "ceflg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ueflg = (JSPUtil.getParameter(request, prefix	+ "ueflg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] deflg = (JSPUtil.getParameter(request, prefix	+ "deflg", length));
			String[] cntrDrffAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_drff_amt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] hireDate = (JSPUtil.getParameter(request, prefix	+ "hire_date", length));
			String[] feflg = (JSPUtil.getParameter(request, prefix	+ "feflg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] eeflg = (JSPUtil.getParameter(request, prefix	+ "eeflg", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] beflg = (JSPUtil.getParameter(request, prefix	+ "beflg", length));
			String[] lseCoRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "lse_co_rtn_yd_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrDrffCrAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_drff_cr_amt", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] aeflg = (JSPUtil.getParameter(request, prefix	+ "aeflg", length));
			String[] cntrLftChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_lft_chg_amt", length));
			String[] cntrPkupChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_chg_amt", length));
			String[] cntrLftChgCur = (JSPUtil.getParameter(request, prefix	+ "cntr_lft_chg_cur", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] cntrPkupCrChgAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_cr_chg_amt", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] stCd = (JSPUtil.getParameter(request, prefix	+ "st_cd", length));
			String[] rntlChgFreeDys = (JSPUtil.getParameter(request, prefix	+ "rntl_chg_free_dys", length));
			String[] cntrStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_evnt_dt", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] offhDueDt = (JSPUtil.getParameter(request, prefix	+ "offh_due_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] offhStsCd = (JSPUtil.getParameter(request, prefix	+ "offh_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrOldVanFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_old_van_flg", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] cntrRmk = (JSPUtil.getParameter(request, prefix	+ "cntr_rmk", length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt".trim(),	length));
			String[] approvalNo =	(JSPUtil.getParameter(request, prefix +	"approval_no".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrStatusCreationVO();
				if (onhYdCd[i] != null)
					model.setOnhYdCd(onhYdCd[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (ieflg[i] != null)
					model.setIeflg(ieflg[i]);
				if (hidCntrNo[i] != null)
					model.setHidCntrNo(hidCntrNo[i]);
				if (stsEvntYdCd[i] != null)
					model.setStsEvntYdCd(stsEvntYdCd[i]);
				if (ceflg[i] != null)
					model.setCeflg(ceflg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ueflg[i] != null)
					model.setUeflg(ueflg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (deflg[i] != null)
					model.setDeflg(deflg[i]);
				if (cntrDrffAmt[i] != null)
					model.setCntrDrffAmt(cntrDrffAmt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (hireDate[i] != null)
					model.setHireDate(hireDate[i]);
				if (feflg[i] != null)
					model.setFeflg(feflg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (eeflg[i] != null)
					model.setEeflg(eeflg[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (beflg[i] != null)
					model.setBeflg(beflg[i]);
				if (lseCoRtnYdCd[i] != null)
					model.setLseCoRtnYdCd(lseCoRtnYdCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrDrffCrAmt[i] != null)
					model.setCntrDrffCrAmt(cntrDrffCrAmt[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (aeflg[i] != null)
					model.setAeflg(aeflg[i]);
				if (cntrLftChgAmt[i] != null)
					model.setCntrLftChgAmt(cntrLftChgAmt[i]);
				if (cntrPkupChgAmt[i] != null)
					model.setCntrPkupChgAmt(cntrPkupChgAmt[i]);
				if (cntrLftChgCur[i] != null)
					model.setCntrLftChgCur(cntrLftChgCur[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntrPkupCrChgAmt[i] != null)
					model.setCntrPkupCrChgAmt(cntrPkupCrChgAmt[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (stCd[i] != null)
					model.setStCd(stCd[i]);
				if (rntlChgFreeDys[i] != null)
					model.setRntlChgFreeDys(rntlChgFreeDys[i]);
				if (cntrStsEvntDt[i] != null)
					model.setCntrStsEvntDt(cntrStsEvntDt[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (offhDueDt[i] != null)
					model.setOffhDueDt(offhDueDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (offhStsCd[i] != null)
					model.setOffhStsCd(offhStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrOldVanFlg[i] != null)
					model.setCntrOldVanFlg(cntrOldVanFlg[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (cntrRmk[i] != null)
					model.setCntrRmk(cntrRmk[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( approvalNo[i] !=	null)
					model.setApprovalNo( approvalNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrStatusCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrStatusCreationVO[]
	 */
	public CntrStatusCreationVO[] getCntrStatusCreationVOs(){
		CntrStatusCreationVO[] vos = (CntrStatusCreationVO[])models.toArray(new CntrStatusCreationVO[models.size()]);
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
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieflg = this.ieflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidCntrNo = this.hidCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsEvntYdCd = this.stsEvntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceflg = this.ceflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ueflg = this.ueflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deflg = this.deflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDrffAmt = this.cntrDrffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hireDate = this.hireDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feflg = this.feflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeflg = this.eeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beflg = this.beflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCoRtnYdCd = this.lseCoRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDrffCrAmt = this.cntrDrffCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aeflg = this.aeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLftChgAmt = this.cntrLftChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupChgAmt = this.cntrPkupChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLftChgCur = this.cntrLftChgCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupCrChgAmt = this.cntrPkupCrChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stCd = this.stCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys = this.rntlChgFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDt = this.cntrStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDueDt = this.offhDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhStsCd = this.offhStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOldVanFlg = this.cntrOldVanFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRmk = this.cntrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalNo =	this.approvalNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
