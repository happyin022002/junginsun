/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementVO.java
*@FileTitle : AgreementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 박영진
*@LastVersion : 1.0
* 2009.05.29 노정용
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgreementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AgreementVO> models = new ArrayList<AgreementVO>();

	/* Column Info */
	private String currCd = null;
	/* Column Info */ 
	private String lseVndrUrl = null;
	/* Column Info */
	private String dpcRto = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String agmtDt = null;
	/* Column Info */
	private String lseFreeDys = null;
	/* Column Info */  
	private String lsePayTermDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtLstVerSeq = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String agmtRmk = null;
	/* Column Info */
	private String agmtVerSeq = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String bldUpDt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String itchgFeeFlg = null;
	/* Column Info */
	private String cntrDpcLvlCd = null;
	/* Column Info */
	private String dirItchgFeeAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String lftOnfChgCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String maxDpcRto = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String dppTpCd = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String orgCntrTpszCd = null;
	/* Column Info */
	private String dpcValFlg = null;
	/* Column Info */
	private String lseCtrtNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private int iPage = 1;
	private String updDt = null;
	/* Column Info */
	private String agmtActFlg = null;
	/* Column Info */
	private String oldAgmtNo = null;	
	/* Column Info */
	private String slbFlg = null;	
	/* Column Info */
	private String lsePayTpCd = null;
	 /* Column Info */
    private String bldDwnEndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * Constructor
	 */
	public AgreementVO() {}

	/**
	 * Constructor
	 */
	public AgreementVO(String ibflag, String pagerows, String agmtNo, String agmtCtyCd, String agmtSeq, String agmtLstVerSeq, String vndrSeq
			         , String lstmCd, String ofcCd, String currCd, String refNo, String vndrLglEngNm, String effDt, String expDt, String agmtVerSeq
			         , String vndrNm, String lseVndrUrl, String dpcRto, String maxDpcRto, String cntrDpcLvlCd, String dppTpCd, String agmtDt
			         , String agmtRmk, String bldUpDt, String lftOnfChgCd, String lsePayTermDys, String lseFreeDys, String itchgFeeFlg
			         , String dirItchgFeeAmt, String creUsrId, String updUsrId, String vndrAbbrNm, String orgCntrTpszCd, String	dpcValFlg
			         , String lseCtrtNo, String creDt, String updDt, String agmtActFlg, String oldAgmtNo, String slbFlg, String lsePayTpCd, String bldDwnEndDt) {
		this.currCd = currCd;
		this.lseVndrUrl = lseVndrUrl;
		this.dpcRto = dpcRto;
		this.vndrLglEngNm = vndrLglEngNm;
		this.agmtDt = agmtDt;
		this.lseFreeDys = lseFreeDys;
		this.lsePayTermDys = lsePayTermDys;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.agmtLstVerSeq = agmtLstVerSeq;
		this.agmtCtyCd = agmtCtyCd;
		this.agmtRmk = agmtRmk;
		this.agmtVerSeq = agmtVerSeq;
		this.expDt = expDt;
		this.bldUpDt = bldUpDt;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.itchgFeeFlg = itchgFeeFlg;
		this.cntrDpcLvlCd = cntrDpcLvlCd;
		this.dirItchgFeeAmt = dirItchgFeeAmt;
		this.ofcCd = ofcCd;
		this.lftOnfChgCd = lftOnfChgCd;
		this.creUsrId = creUsrId;
		this.maxDpcRto = maxDpcRto;
		this.vndrSeq = vndrSeq;
		this.refNo = refNo;
		this.dppTpCd = dppTpCd;
		this.vndrAbbrNm = vndrAbbrNm;
		this.orgCntrTpszCd = orgCntrTpszCd;
		this.dpcValFlg = dpcValFlg;
		this.lseCtrtNo = lseCtrtNo;
		this.creDt = creDt;
		this.updDt = updDt;
		this.agmtActFlg = agmtActFlg;
		this.oldAgmtNo = oldAgmtNo;
		this.slbFlg = slbFlg;
		this.lsePayTpCd = lsePayTpCd;
		this.bldDwnEndDt = bldDwnEndDt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("lse_vndr_url", getLseVndrUrl());
		this.hashColumns.put("dpc_rto", getDpcRto());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("agmt_dt", getAgmtDt());
		this.hashColumns.put("lse_free_dys", getLseFreeDys());
		this.hashColumns.put("lse_pay_term_dys", getLsePayTermDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_lst_ver_seq", getAgmtLstVerSeq());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("agmt_rmk", getAgmtRmk());
		this.hashColumns.put("agmt_ver_seq", getAgmtVerSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("bld_up_dt", getBldUpDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("itchg_fee_flg", getItchgFeeFlg());
		this.hashColumns.put("cntr_dpc_lvl_cd", getCntrDpcLvlCd());
		this.hashColumns.put("dir_itchg_fee_amt", getDirItchgFeeAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("lft_onf_chg_cd", getLftOnfChgCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("max_dpc_rto", getMaxDpcRto());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("dpp_tp_cd", getDppTpCd());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("org_cntr_tpsz_cd", getOrgCntrTpszCd());
		this.hashColumns.put("dpc_val_flg", getDpcValFlg());
		this.hashColumns.put("lse_ctrt_no", getLseCtrtNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("agmt_act_flg", getAgmtActFlg());
		this.hashColumns.put("old_agmt_no", getOldAgtmNo());
		this.hashColumns.put("slb_flg", getSlbFlg());
		this.hashColumns.put("lse_pay_tp_cd", getLsePayTpCd());
		this.hashColumns.put("bld_dwn_end_dt", getBldDwnEndDt());
		
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("lse_vndr_url", "lseVndrUrl");
		this.hashFields.put("dpc_rto", "dpcRto");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("agmt_dt", "agmtDt");
		this.hashFields.put("lse_free_dys", "lseFreeDys");
		this.hashFields.put("lse_pay_term_dys", "lsePayTermDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_lst_ver_seq", "agmtLstVerSeq");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("agmt_rmk", "agmtRmk");
		this.hashFields.put("agmt_ver_seq", "agmtVerSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("bld_up_dt", "bldUpDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("itchg_fee_flg", "itchgFeeFlg");
		this.hashFields.put("cntr_dpc_lvl_cd", "cntrDpcLvlCd");
		this.hashFields.put("dir_itchg_fee_amt", "dirItchgFeeAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("lft_onf_chg_cd", "lftOnfChgCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("max_dpc_rto", "maxDpcRto");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("dpp_tp_cd", "dppTpCd");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("org_cntr_tpsz_cd", "orgCntrTpszCd");
		this.hashFields.put("dpc_val_flg", "dpcValFlg");
		this.hashFields.put("lse_ctrt_no", "lseCtrtNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("agmt_act_flg", "agmtActFlg");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("slb_flg", "slbFlg");
		this.hashFields.put("lse_pay_tp_cd", "lsePayTpCd");
		this.hashFields.put("bld_dwn_end_dt", "bldDwnEndDt");
		
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * @return lseVndrUrl
	 */
	public String getLseVndrUrl() {
		return this.lseVndrUrl;
	}

	/**
	 * Column Info
	 * @return dpcRto
	 */
	public String getDpcRto() {
		return this.dpcRto;
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
	 * @return agmtDt
	 */
	public String getAgmtDt() {
		return this.agmtDt;
	}

	/**
	 * Column Info
	 * @return lseFreeDys
	 */
	public String getLseFreeDys() {
		return this.lseFreeDys;
	}

	/**
	 * Column Info
	 * @return lsePayTermDys
	 */
	public String getLsePayTermDys() {
		return this.lsePayTermDys;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return agmtLstVerSeq
	 */
	public String getAgmtLstVerSeq() {
		return this.agmtLstVerSeq;
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
	 * @return agmtRmk
	 */
	public String getAgmtRmk() {
		return this.agmtRmk;
	}

	/**
	 * Column Info
	 * @return agmtVerSeq
	 */
	public String getAgmtVerSeq() {
		return this.agmtVerSeq;
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
	 * @return bldUpDt
	 */
	public String getBldUpDt() {
		return this.bldUpDt;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return itchgFeeFlg
	 */
	public String getItchgFeeFlg() {
		return this.itchgFeeFlg;
	}

	/**
	 * Column Info
	 * @return cntrDpcLvlCd
	 */
	public String getCntrDpcLvlCd() {
		return this.cntrDpcLvlCd;
	}

	/**
	 * Column Info
	 * @return dirItchgFeeAmt
	 */
	public String getDirItchgFeeAmt() {
		return this.dirItchgFeeAmt;
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
	 * @return lftOnfChgCd
	 */
	public String getLftOnfChgCd() {
		return this.lftOnfChgCd;
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
	 * @return maxDpcRto
	 */
	public String getMaxDpcRto() {
		return this.maxDpcRto;
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
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}

	/**
	 * Column Info
	 * @return dppTpCd
	 */
	public String getDppTpCd() {
		return this.dppTpCd;
	}
	
	/**
	 * Column Info
	 * @return oldAgmtNo
	 */
	public String getOldAgtmNo() {
		return this.oldAgmtNo;
	}

	/**
	 * Column Info
	 * @return slbFlg
	 */
	public String getSlbFlg() {
		return this.slbFlg;
	}

	/**
	 * Column Info
	 * @return lsePayTpCd
	 */
	public String getLsePayTpCd() {
		return this.lsePayTpCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * @param lseVndrUrl
	 */
	public void setLseVndrUrl(String lseVndrUrl) {
		this.lseVndrUrl = lseVndrUrl;
	}

	/**
	 * Column Info
	 * @param dpcRto
	 */
	public void setDpcRto(String dpcRto) {
		this.dpcRto = dpcRto;
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
	 * @param agmtDt
	 */
	public void setAgmtDt(String agmtDt) {
		this.agmtDt = agmtDt;
	}

	/**
	 * Column Info
	 * @param lseFreeDys
	 */
	public void setLseFreeDys(String lseFreeDys) {
		this.lseFreeDys = lseFreeDys;
	}

	/**
	 * Column Info
	 * @param lsePayTermDys
	 */
	public void setLsePayTermDys(String lsePayTermDys) {
		this.lsePayTermDys = lsePayTermDys;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}

	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param agmtLstVerSeq
	 */
	public void setAgmtLstVerSeq(String agmtLstVerSeq) {
		this.agmtLstVerSeq = agmtLstVerSeq;
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
	 * @param agmtRmk
	 */
	public void setAgmtRmk(String agmtRmk) {
		this.agmtRmk = agmtRmk;
	}

	/**
	 * Column Info
	 * @param agmtVerSeq
	 */
	public void setAgmtVerSeq(String agmtVerSeq) {
		this.agmtVerSeq = agmtVerSeq;
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
	 * @param bldUpDt
	 */
	public void setBldUpDt(String bldUpDt) {
		this.bldUpDt = bldUpDt;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param itchgFeeFlg
	 */
	public void setItchgFeeFlg(String itchgFeeFlg) {
		this.itchgFeeFlg = itchgFeeFlg;
	}

	/**
	 * Column Info
	 * @param cntrDpcLvlCd
	 */
	public void setCntrDpcLvlCd(String cntrDpcLvlCd) {
		this.cntrDpcLvlCd = cntrDpcLvlCd;
	}

	/**
	 * Column Info
	 * @param dirItchgFeeAmt
	 */
	public void setDirItchgFeeAmt(String dirItchgFeeAmt) {
		this.dirItchgFeeAmt = dirItchgFeeAmt;
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
	 * @param lftOnfChgCd
	 */
	public void setLftOnfChgCd(String lftOnfChgCd) {
		this.lftOnfChgCd = lftOnfChgCd;
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
	 * @param maxDpcRto
	 */
	public void setMaxDpcRto(String maxDpcRto) {
		this.maxDpcRto = maxDpcRto;
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
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Column Info
	 * @param dppTpCd
	 */
	public void setDppTpCd(String dppTpCd) {
		this.dppTpCd = dppTpCd;
	}

	/**
	 * @param iPage the iPage to set
	 */
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param vndrAbbrNm the vndrAbbrNm to set
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}

	/**
	 * @return the vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return vndrAbbrNm;
	}

	/**
	 * @param orgCntrTpszCd the orgCntrTpszCd to set
	 */
	public void setOrgCntrTpszCd(String orgCntrTpszCd) {
		this.orgCntrTpszCd = orgCntrTpszCd;
	}

	/**
	 * @return the orgCntrTpszCd
	 */
	public String getOrgCntrTpszCd() {
		return orgCntrTpszCd;
	}

	/**
	 * @param dpcValFlg the dpcValFlg to set
	 */
	public void setDpcValFlg(String dpcValFlg) {
		this.dpcValFlg = dpcValFlg;
	}

	/**
	 * @return the dpcValFlg
	 */
	public String getDpcValFlg() {
		return dpcValFlg;
	}

	/**
	 * @param lseCtrtNo the lseCtrtNo to set
	 */
	public void setLseCtrtNo(String lseCtrtNo) {
		this.lseCtrtNo = lseCtrtNo;
	}

	/**
	 * @return the lseCtrtNo
	 */
	public String getLseCtrtNo() {
		return lseCtrtNo;
	}
	
	/**
	 * @param oldAgmtNo the oldAgmtNo to set
	 */
	public void setOldAgtmNo(String oldAgmtNo) {
		this.oldAgmtNo = oldAgmtNo;
	}

	/**
	 * @param slbFlg the slbFlg to set
	 */
	public void setSlbFlg(String slbFlg) {
		this.slbFlg = slbFlg;
	}

	/**
	 * @param slbFlg the slbFlg to set
	 */
	public void setLsePayTpCd(String lsePayTpCd) {
		this.lsePayTpCd = lsePayTpCd;
	}	
	
	/**
	 * @param bldDwnEndDt the bldDwnEndDt to set
	 */
	public void setBldDwnEndDt(String bldDwnEndDt) {
        this.bldDwnEndDt = bldDwnEndDt;
    }

    public String getBldDwnEndDt() {
        return this.bldDwnEndDt;
    }
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setLseVndrUrl(JSPUtil.getParameter(request, "lse_vndr_url", ""));
		setDpcRto(JSPUtil.getParameter(request, "dpc_rto", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setAgmtDt(JSPUtil.getParameter(request, "agmt_dt", ""));
		setLseFreeDys(JSPUtil.getParameter(request, "lse_free_dys", ""));
		setLsePayTermDys(JSPUtil.getParameter(request, "lse_pay_term_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtLstVerSeq(JSPUtil.getParameter(request, "agmt_lst_ver_seq", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setAgmtRmk(JSPUtil.getParameter(request, "agmt_rmk", ""));
		setAgmtVerSeq(JSPUtil.getParameter(request, "agmt_ver_seq", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setBldUpDt(JSPUtil.getParameter(request, "bld_up_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setItchgFeeFlg(JSPUtil.getParameter(request, "itchg_fee_flg", ""));
		setCntrDpcLvlCd(JSPUtil.getParameter(request, "cntr_dpc_lvl_cd", ""));
		setDirItchgFeeAmt(JSPUtil.getParameter(request, "dir_itchg_fee_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setLftOnfChgCd(JSPUtil.getParameter(request, "lft_onf_chg_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMaxDpcRto(JSPUtil.getParameter(request, "max_dpc_rto", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setDppTpCd(JSPUtil.getParameter(request, "dpp_tp_cd", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setOrgCntrTpszCd(JSPUtil.getParameter(request, "org_cntr_tpsz_cd", ""));
		setDpcValFlg(JSPUtil.getParameter(request, "dpc_val_flg", ""));
		setLseCtrtNo(JSPUtil.getParameter(request, "lse_ctrt_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
		setAgmtActFlg(JSPUtil.getParameter(request, "agmt_act_flg", ""));
		setOldAgtmNo(JSPUtil.getParameter(request, "old_agmt_no", ""));
		setSlbFlg(JSPUtil.getParameter(request, "slb_flg", ""));
		setLsePayTpCd(JSPUtil.getParameter(request, "lse_pay_tp_cd", ""));
		setBldDwnEndDt(JSPUtil.getParameter(request, "bld_dwn_end_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgreementVO[]
	 */
	public AgreementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AgreementVO[]
	 */
	public AgreementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgreementVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] lseVndrUrl = (JSPUtil.getParameter(request, prefix	+ "lse_vndr_url".trim(), length));
			String[] dpcRto = (JSPUtil.getParameter(request, prefix	+ "dpc_rto".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] agmtDt = (JSPUtil.getParameter(request, prefix	+ "agmt_dt".trim(), length));
			String[] lseFreeDys = (JSPUtil.getParameter(request, prefix	+ "lse_free_dys".trim(), length));
			String[] lsePayTermDys = (JSPUtil.getParameter(request, prefix	+ "lse_pay_term_dys".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] agmtLstVerSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_lst_ver_seq".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] agmtRmk = (JSPUtil.getParameter(request, prefix	+ "agmt_rmk".trim(), length));
			String[] agmtVerSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_seq".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] bldUpDt = (JSPUtil.getParameter(request, prefix	+ "bld_up_dt".trim(), length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no".trim(), length));
			String[] itchgFeeFlg = (JSPUtil.getParameter(request, prefix	+ "itchg_fee_flg".trim(), length));
			String[] cntrDpcLvlCd = (JSPUtil.getParameter(request, prefix	+ "cntr_dpc_lvl_cd".trim(), length));
			String[] dirItchgFeeAmt = (JSPUtil.getParameter(request, prefix	+ "dir_itchg_fee_amt".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] lftOnfChgCd = (JSPUtil.getParameter(request, prefix	+ "lft_onf_chg_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] maxDpcRto = (JSPUtil.getParameter(request, prefix	+ "max_dpc_rto".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no".trim(), length));
			String[] dppTpCd = (JSPUtil.getParameter(request, prefix	+ "dpp_tp_cd".trim(), length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm".trim(), length));
			String[] orgCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "org_cntr_tpsz_cd".trim(), length));
			String[] dpcValFlg = (JSPUtil.getParameter(request, prefix	+ "dpc_val_flg".trim(), length));
			String[] lseCtrtNo = (JSPUtil.getParameter(request, prefix	+ "lse_ctrt_no".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] agmtActFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_act_flg".trim(), length));
			String[] oldAgmtNo = (JSPUtil.getParameter(request, prefix	+ "old_agmt_no".trim(), length));
			String[] slbFlg = (JSPUtil.getParameter(request, prefix	+ "slb_flg".trim(), length));
			String[] lsePayTpCd = (JSPUtil.getParameter(request, prefix	+ "lse_pay_tp_cd".trim(), length));
			String[] bldDwnEndDt = (JSPUtil.getParameter(request, prefix	+ "bld_dwn_end_dt".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new AgreementVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (lseVndrUrl[i] != null)
					model.setLseVndrUrl(lseVndrUrl[i]);
				if (dpcRto[i] != null)
					model.setDpcRto(dpcRto[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (agmtDt[i] != null)
					model.setAgmtDt(agmtDt[i]);
				if (lseFreeDys[i] != null)
					model.setLseFreeDys(lseFreeDys[i]);
				if (lsePayTermDys[i] != null)
					model.setLsePayTermDys(lsePayTermDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtLstVerSeq[i] != null)
					model.setAgmtLstVerSeq(agmtLstVerSeq[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (agmtRmk[i] != null)
					model.setAgmtRmk(agmtRmk[i]);
				if (agmtVerSeq[i] != null)
					model.setAgmtVerSeq(agmtVerSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (bldUpDt[i] != null)
					model.setBldUpDt(bldUpDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (itchgFeeFlg[i] != null)
					model.setItchgFeeFlg(itchgFeeFlg[i]);
				if (cntrDpcLvlCd[i] != null)
					model.setCntrDpcLvlCd(cntrDpcLvlCd[i]);
				if (dirItchgFeeAmt[i] != null)
					model.setDirItchgFeeAmt(dirItchgFeeAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (lftOnfChgCd[i] != null)
					model.setLftOnfChgCd(lftOnfChgCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (maxDpcRto[i] != null)
					model.setMaxDpcRto(maxDpcRto[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (dppTpCd[i] != null)
					model.setDppTpCd(dppTpCd[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (orgCntrTpszCd[i] != null)
					model.setOrgCntrTpszCd(orgCntrTpszCd[i]);
				if (dpcValFlg[i] != null)
					model.setDpcValFlg(dpcValFlg[i]);
				if (lseCtrtNo[i] != null)
					model.setLseCtrtNo(lseCtrtNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (agmtActFlg[i] != null)
					model.setAgmtActFlg(agmtActFlg[i]);
				if (oldAgmtNo[i] != null)
					model.setOldAgtmNo(oldAgmtNo[i]);
				if (slbFlg[i] != null)
					model.setSlbFlg(slbFlg[i]);
				if (lsePayTpCd[i] != null)
					model.setLsePayTpCd(lsePayTpCd[i]);
				if (bldDwnEndDt[i] != null)
					model.setBldDwnEndDt(bldDwnEndDt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgreementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgreementVO[]
	 */
	public AgreementVO[] getAgreementVOs(){
		AgreementVO[] vos = (AgreementVO[])models.toArray(new AgreementVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseVndrUrl = this.lseVndrUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcRto = this.dpcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDt = this.agmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseFreeDys = this.lseFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayTermDys = this.lsePayTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstVerSeq = this.agmtLstVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRmk = this.agmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerSeq = this.agmtVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldUpDt = this.bldUpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itchgFeeFlg = this.itchgFeeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDpcLvlCd = this.cntrDpcLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirItchgFeeAmt = this.dirItchgFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lftOnfChgCd = this.lftOnfChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDpcRto = this.maxDpcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppTpCd = this.dppTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntrTpszCd = this.orgCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcValFlg = this.dpcValFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lseCtrtNo = this.lseCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActFlg = this.agmtActFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo = this.oldAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slbFlg = this.slbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsePayTpCd = this.lsePayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldDwnEndDt = this.bldDwnEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setAgmtActFlg(String agmtActFlg) {
		this.agmtActFlg = agmtActFlg;
	}

	public String getAgmtActFlg() {
		return agmtActFlg;
	}
}