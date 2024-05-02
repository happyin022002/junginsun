/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DualTypeCustomerVO.java
*@FileTitle : DualTypeCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DualTypeCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DualTypeCustomerVO> models = new ArrayList<DualTypeCustomerVO>();
	
	/* Column Info */
	private String dulExptEffToDt = null;
	/* Column Info */
	private String dulExptExpDt = null;
	/* Column Info */
	private String cvrgRgnSteAllNm = null;
	/* Column Info */
	private String custExptSeq = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String expOfcCd = null;
	/* Column Info */
	private String cvrgRgnSteAllCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cvrgRgnSteCd = null;
	/* Column Info */
	private String intgCdId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cvrgRgnCd = null;
	/* Column Info */
	private String dmdtCntrCgoTpAllCd = null;
	/* Column Info */
	private String cvrgSteCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String dulExptDeltDesc = null;
	/* Column Info */
	private String dmdtCntrCgoTpAllNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String delDt = null;
	/* Column Info */
	private String cvrgCntCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String delUsrNm = null;
	/* Column Info */
	private String dmdtCntrCgoTpCd = null;
	/* Column Info */
	private String dulExptEffDt = null;
	/* Column Info */
	private String dulExptRmk = null;
	/* Column Info */
	private String expUsrNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String ioBndDesc = null;
	/* Column Info */
	private String expUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dulExptDeltFlg = null;
	/* Column Info */
	private String dmdtCtrtExptTpCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String code2 = null;
	/* Column Info */
	private String code1 = null;
	/* Column Info */
	private String delOfcCd = null;
	/* Column Info */
	private String expFlg = null;
	/* Column Info */
	private String dulExptEffFromDt = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String cvrgLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DualTypeCustomerVO() {}

	public DualTypeCustomerVO(String ibflag, String pagerows, String dulExptDeltFlg, String dulExptDeltDesc, String custCd, String custNm, String custCntCd, String custSeq, String custExptSeq, String dulExptEffDt, String dulExptExpDt, String dulExptEffFromDt, String dulExptEffToDt, String ioBndCd, String ioBndDesc, String dmdtCtrtExptTpCd, String cvrgCntCd, String cvrgRgnSteCd, String cvrgRgnSteAllCd, String cvrgRgnSteAllNm, String cvrgRgnCd, String cvrgSteCd, String cvrgLocCd, String dmdtCntrCgoTpCd, String dmdtCntrCgoTpAllCd, String dmdtCntrCgoTpAllNm, String dulExptRmk, String creUsrId, String creOfcCd, String expFlg, String updUsrId, String updUsrNm, String updDt, String updOfcCd, String expUsrId, String expOfcCd, String expUsrNm, String expDt, String delOfcCd, String delUsrNm, String delDt, String code1, String code2, String intgCdId) {
		this.dulExptEffToDt = dulExptEffToDt;
		this.dulExptExpDt = dulExptExpDt;
		this.cvrgRgnSteAllNm = cvrgRgnSteAllNm;
		this.custExptSeq = custExptSeq;
		this.custNm = custNm;
		this.expOfcCd = expOfcCd;
		this.cvrgRgnSteAllCd = cvrgRgnSteAllCd;
		this.pagerows = pagerows;
		this.cvrgRgnSteCd = cvrgRgnSteCd;
		this.intgCdId = intgCdId;
		this.ibflag = ibflag;
		this.cvrgRgnCd = cvrgRgnCd;
		this.dmdtCntrCgoTpAllCd = dmdtCntrCgoTpAllCd;
		this.cvrgSteCd = cvrgSteCd;
		this.creOfcCd = creOfcCd;
		this.dulExptDeltDesc = dulExptDeltDesc;
		this.dmdtCntrCgoTpAllNm = dmdtCntrCgoTpAllNm;
		this.expDt = expDt;
		this.delDt = delDt;
		this.cvrgCntCd = cvrgCntCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.updDt = updDt;
		this.delUsrNm = delUsrNm;
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
		this.dulExptEffDt = dulExptEffDt;
		this.dulExptRmk = dulExptRmk;
		this.expUsrNm = expUsrNm;
		this.custSeq = custSeq;
		this.ioBndCd = ioBndCd;
		this.ioBndDesc = ioBndDesc;
		this.expUsrId = expUsrId;
		this.creUsrId = creUsrId;
		this.dulExptDeltFlg = dulExptDeltFlg;
		this.dmdtCtrtExptTpCd = dmdtCtrtExptTpCd;
		this.custCd = custCd;
		this.code2 = code2;
		this.code1 = code1;
		this.delOfcCd = delOfcCd;
		this.expFlg = expFlg;
		this.dulExptEffFromDt = dulExptEffFromDt;
		this.updUsrNm = updUsrNm;
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dul_expt_eff_to_dt", getDulExptEffToDt());
		this.hashColumns.put("dul_expt_exp_dt", getDulExptExpDt());
		this.hashColumns.put("cvrg_rgn_ste_all_nm", getCvrgRgnSteAllNm());
		this.hashColumns.put("cust_expt_seq", getCustExptSeq());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("exp_ofc_cd", getExpOfcCd());
		this.hashColumns.put("cvrg_rgn_ste_all_cd", getCvrgRgnSteAllCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cvrg_rgn_ste_cd", getCvrgRgnSteCd());
		this.hashColumns.put("intg_cd_id", getIntgCdId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cvrg_rgn_cd", getCvrgRgnCd());
		this.hashColumns.put("dmdt_cntr_cgo_tp_all_cd", getDmdtCntrCgoTpAllCd());
		this.hashColumns.put("cvrg_ste_cd", getCvrgSteCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dul_expt_delt_desc", getDulExptDeltDesc());
		this.hashColumns.put("dmdt_cntr_cgo_tp_all_nm", getDmdtCntrCgoTpAllNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("del_dt", getDelDt());
		this.hashColumns.put("cvrg_cnt_cd", getCvrgCntCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("del_usr_nm", getDelUsrNm());
		this.hashColumns.put("dmdt_cntr_cgo_tp_cd", getDmdtCntrCgoTpCd());
		this.hashColumns.put("dul_expt_eff_dt", getDulExptEffDt());
		this.hashColumns.put("dul_expt_rmk", getDulExptRmk());
		this.hashColumns.put("exp_usr_nm", getExpUsrNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("io_bnd_desc", getIoBndDesc());
		this.hashColumns.put("exp_usr_id", getExpUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dul_expt_delt_flg", getDulExptDeltFlg());
		this.hashColumns.put("dmdt_ctrt_expt_tp_cd", getDmdtCtrtExptTpCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("code2", getCode2());
		this.hashColumns.put("code1", getCode1());
		this.hashColumns.put("del_ofc_cd", getDelOfcCd());
		this.hashColumns.put("exp_flg", getExpFlg());
		this.hashColumns.put("dul_expt_eff_from_dt", getDulExptEffFromDt());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("cvrg_loc_cd", getCvrgLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dul_expt_eff_to_dt", "dulExptEffToDt");
		this.hashFields.put("dul_expt_exp_dt", "dulExptExpDt");
		this.hashFields.put("cvrg_rgn_ste_all_nm", "cvrgRgnSteAllNm");
		this.hashFields.put("cust_expt_seq", "custExptSeq");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("exp_ofc_cd", "expOfcCd");
		this.hashFields.put("cvrg_rgn_ste_all_cd", "cvrgRgnSteAllCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cvrg_rgn_ste_cd", "cvrgRgnSteCd");
		this.hashFields.put("intg_cd_id", "intgCdId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cvrg_rgn_cd", "cvrgRgnCd");
		this.hashFields.put("dmdt_cntr_cgo_tp_all_cd", "dmdtCntrCgoTpAllCd");
		this.hashFields.put("cvrg_ste_cd", "cvrgSteCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dul_expt_delt_desc", "dulExptDeltDesc");
		this.hashFields.put("dmdt_cntr_cgo_tp_all_nm", "dmdtCntrCgoTpAllNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("del_dt", "delDt");
		this.hashFields.put("cvrg_cnt_cd", "cvrgCntCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("del_usr_nm", "delUsrNm");
		this.hashFields.put("dmdt_cntr_cgo_tp_cd", "dmdtCntrCgoTpCd");
		this.hashFields.put("dul_expt_eff_dt", "dulExptEffDt");
		this.hashFields.put("dul_expt_rmk", "dulExptRmk");
		this.hashFields.put("exp_usr_nm", "expUsrNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("io_bnd_desc", "ioBndDesc");
		this.hashFields.put("exp_usr_id", "expUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dul_expt_delt_flg", "dulExptDeltFlg");
		this.hashFields.put("dmdt_ctrt_expt_tp_cd", "dmdtCtrtExptTpCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("code2", "code2");
		this.hashFields.put("code1", "code1");
		this.hashFields.put("del_ofc_cd", "delOfcCd");
		this.hashFields.put("exp_flg", "expFlg");
		this.hashFields.put("dul_expt_eff_from_dt", "dulExptEffFromDt");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("cvrg_loc_cd", "cvrgLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dulExptEffToDt
	 */
	public String getDulExptEffToDt() {
		return this.dulExptEffToDt;
	}
	
	/**
	 * Column Info
	 * @return dulExptExpDt
	 */
	public String getDulExptExpDt() {
		return this.dulExptExpDt;
	}
	
	/**
	 * Column Info
	 * @return cvrgRgnSteAllNm
	 */
	public String getCvrgRgnSteAllNm() {
		return this.cvrgRgnSteAllNm;
	}
	
	/**
	 * Column Info
	 * @return custExptSeq
	 */
	public String getCustExptSeq() {
		return this.custExptSeq;
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
	 * @return expOfcCd
	 */
	public String getExpOfcCd() {
		return this.expOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgRgnSteAllCd
	 */
	public String getCvrgRgnSteAllCd() {
		return this.cvrgRgnSteAllCd;
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
	 * @return cvrgRgnSteCd
	 */
	public String getCvrgRgnSteCd() {
		return this.cvrgRgnSteCd;
	}
	
	/**
	 * Column Info
	 * @return intgCdId
	 */
	public String getIntgCdId() {
		return this.intgCdId;
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
	 * @return cvrgRgnCd
	 */
	public String getCvrgRgnCd() {
		return this.cvrgRgnCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrCgoTpAllCd
	 */
	public String getDmdtCntrCgoTpAllCd() {
		return this.dmdtCntrCgoTpAllCd;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dulExptDeltDesc
	 */
	public String getDulExptDeltDesc() {
		return this.dulExptDeltDesc;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrCgoTpAllNm
	 */
	public String getDmdtCntrCgoTpAllNm() {
		return this.dmdtCntrCgoTpAllNm;
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
	 * @return delDt
	 */
	public String getDelDt() {
		return this.delDt;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return delUsrNm
	 */
	public String getDelUsrNm() {
		return this.delUsrNm;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrCgoTpCd
	 */
	public String getDmdtCntrCgoTpCd() {
		return this.dmdtCntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return dulExptEffDt
	 */
	public String getDulExptEffDt() {
		return this.dulExptEffDt;
	}
	
	/**
	 * Column Info
	 * @return dulExptRmk
	 */
	public String getDulExptRmk() {
		return this.dulExptRmk;
	}
	
	/**
	 * Column Info
	 * @return expUsrNm
	 */
	public String getExpUsrNm() {
		return this.expUsrNm;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndDesc
	 */
	public String getIoBndDesc() {
		return this.ioBndDesc;
	}
	
	/**
	 * Column Info
	 * @return expUsrId
	 */
	public String getExpUsrId() {
		return this.expUsrId;
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
	 * @return dulExptDeltFlg
	 */
	public String getDulExptDeltFlg() {
		return this.dulExptDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtCtrtExptTpCd
	 */
	public String getDmdtCtrtExptTpCd() {
		return this.dmdtCtrtExptTpCd;
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
	 * @return delOfcCd
	 */
	public String getDelOfcCd() {
		return this.delOfcCd;
	}
	
	/**
	 * Column Info
	 * @return expFlg
	 */
	public String getExpFlg() {
		return this.expFlg;
	}
	
	/**
	 * Column Info
	 * @return dulExptEffFromDt
	 */
	public String getDulExptEffFromDt() {
		return this.dulExptEffFromDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
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
	 * @param dulExptEffToDt
	 */
	public void setDulExptEffToDt(String dulExptEffToDt) {
		this.dulExptEffToDt = dulExptEffToDt;
	}
	
	/**
	 * Column Info
	 * @param dulExptExpDt
	 */
	public void setDulExptExpDt(String dulExptExpDt) {
		this.dulExptExpDt = dulExptExpDt;
	}
	
	/**
	 * Column Info
	 * @param cvrgRgnSteAllNm
	 */
	public void setCvrgRgnSteAllNm(String cvrgRgnSteAllNm) {
		this.cvrgRgnSteAllNm = cvrgRgnSteAllNm;
	}
	
	/**
	 * Column Info
	 * @param custExptSeq
	 */
	public void setCustExptSeq(String custExptSeq) {
		this.custExptSeq = custExptSeq;
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
	 * @param expOfcCd
	 */
	public void setExpOfcCd(String expOfcCd) {
		this.expOfcCd = expOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgRgnSteAllCd
	 */
	public void setCvrgRgnSteAllCd(String cvrgRgnSteAllCd) {
		this.cvrgRgnSteAllCd = cvrgRgnSteAllCd;
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
	 * @param cvrgRgnSteCd
	 */
	public void setCvrgRgnSteCd(String cvrgRgnSteCd) {
		this.cvrgRgnSteCd = cvrgRgnSteCd;
	}
	
	/**
	 * Column Info
	 * @param intgCdId
	 */
	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
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
	 * @param cvrgRgnCd
	 */
	public void setCvrgRgnCd(String cvrgRgnCd) {
		this.cvrgRgnCd = cvrgRgnCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrCgoTpAllCd
	 */
	public void setDmdtCntrCgoTpAllCd(String dmdtCntrCgoTpAllCd) {
		this.dmdtCntrCgoTpAllCd = dmdtCntrCgoTpAllCd;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dulExptDeltDesc
	 */
	public void setDulExptDeltDesc(String dulExptDeltDesc) {
		this.dulExptDeltDesc = dulExptDeltDesc;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrCgoTpAllNm
	 */
	public void setDmdtCntrCgoTpAllNm(String dmdtCntrCgoTpAllNm) {
		this.dmdtCntrCgoTpAllNm = dmdtCntrCgoTpAllNm;
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
	 * @param delDt
	 */
	public void setDelDt(String delDt) {
		this.delDt = delDt;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param delUsrNm
	 */
	public void setDelUsrNm(String delUsrNm) {
		this.delUsrNm = delUsrNm;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrCgoTpCd
	 */
	public void setDmdtCntrCgoTpCd(String dmdtCntrCgoTpCd) {
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param dulExptEffDt
	 */
	public void setDulExptEffDt(String dulExptEffDt) {
		this.dulExptEffDt = dulExptEffDt;
	}
	
	/**
	 * Column Info
	 * @param dulExptRmk
	 */
	public void setDulExptRmk(String dulExptRmk) {
		this.dulExptRmk = dulExptRmk;
	}
	
	/**
	 * Column Info
	 * @param expUsrNm
	 */
	public void setExpUsrNm(String expUsrNm) {
		this.expUsrNm = expUsrNm;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndDesc
	 */
	public void setIoBndDesc(String ioBndDesc) {
		this.ioBndDesc = ioBndDesc;
	}
	
	/**
	 * Column Info
	 * @param expUsrId
	 */
	public void setExpUsrId(String expUsrId) {
		this.expUsrId = expUsrId;
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
	 * @param dulExptDeltFlg
	 */
	public void setDulExptDeltFlg(String dulExptDeltFlg) {
		this.dulExptDeltFlg = dulExptDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtCtrtExptTpCd
	 */
	public void setDmdtCtrtExptTpCd(String dmdtCtrtExptTpCd) {
		this.dmdtCtrtExptTpCd = dmdtCtrtExptTpCd;
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
	 * @param delOfcCd
	 */
	public void setDelOfcCd(String delOfcCd) {
		this.delOfcCd = delOfcCd;
	}
	
	/**
	 * Column Info
	 * @param expFlg
	 */
	public void setExpFlg(String expFlg) {
		this.expFlg = expFlg;
	}
	
	/**
	 * Column Info
	 * @param dulExptEffFromDt
	 */
	public void setDulExptEffFromDt(String dulExptEffFromDt) {
		this.dulExptEffFromDt = dulExptEffFromDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param cvrgLocCd
	 */
	public void setCvrgLocCd(String cvrgLocCd) {
		this.cvrgLocCd = cvrgLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDulExptEffToDt(JSPUtil.getParameter(request, "dul_expt_eff_to_dt", ""));
		setDulExptExpDt(JSPUtil.getParameter(request, "dul_expt_exp_dt", ""));
		setCvrgRgnSteAllNm(JSPUtil.getParameter(request, "cvrg_rgn_ste_all_nm", ""));
		setCustExptSeq(JSPUtil.getParameter(request, "cust_expt_seq", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setExpOfcCd(JSPUtil.getParameter(request, "exp_ofc_cd", ""));
		setCvrgRgnSteAllCd(JSPUtil.getParameter(request, "cvrg_rgn_ste_all_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCvrgRgnSteCd(JSPUtil.getParameter(request, "cvrg_rgn_ste_cd", ""));
		setIntgCdId(JSPUtil.getParameter(request, "intg_cd_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCvrgRgnCd(JSPUtil.getParameter(request, "cvrg_rgn_cd", ""));
		setDmdtCntrCgoTpAllCd(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_all_cd", ""));
		setCvrgSteCd(JSPUtil.getParameter(request, "cvrg_ste_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setDulExptDeltDesc(JSPUtil.getParameter(request, "dul_expt_delt_desc", ""));
		setDmdtCntrCgoTpAllNm(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_all_nm", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setDelDt(JSPUtil.getParameter(request, "del_dt", ""));
		setCvrgCntCd(JSPUtil.getParameter(request, "cvrg_cnt_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDelUsrNm(JSPUtil.getParameter(request, "del_usr_nm", ""));
		setDmdtCntrCgoTpCd(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_cd", ""));
		setDulExptEffDt(JSPUtil.getParameter(request, "dul_expt_eff_dt", ""));
		setDulExptRmk(JSPUtil.getParameter(request, "dul_expt_rmk", ""));
		setExpUsrNm(JSPUtil.getParameter(request, "exp_usr_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setIoBndDesc(JSPUtil.getParameter(request, "io_bnd_desc", ""));
		setExpUsrId(JSPUtil.getParameter(request, "exp_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDulExptDeltFlg(JSPUtil.getParameter(request, "dul_expt_delt_flg", ""));
		setDmdtCtrtExptTpCd(JSPUtil.getParameter(request, "dmdt_ctrt_expt_tp_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCode2(JSPUtil.getParameter(request, "code2", ""));
		setCode1(JSPUtil.getParameter(request, "code1", ""));
		setDelOfcCd(JSPUtil.getParameter(request, "del_ofc_cd", ""));
		setExpFlg(JSPUtil.getParameter(request, "exp_flg", ""));
		setDulExptEffFromDt(JSPUtil.getParameter(request, "dul_expt_eff_from_dt", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, "upd_usr_nm", ""));
		setCvrgLocCd(JSPUtil.getParameter(request, "cvrg_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DualTypeCustomerVO[]
	 */
	public DualTypeCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DualTypeCustomerVO[]
	 */
	public DualTypeCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DualTypeCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dulExptEffToDt = (JSPUtil.getParameter(request, prefix	+ "dul_expt_eff_to_dt", length));
			String[] dulExptExpDt = (JSPUtil.getParameter(request, prefix	+ "dul_expt_exp_dt", length));
			String[] cvrgRgnSteAllNm = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_ste_all_nm", length));
			String[] custExptSeq = (JSPUtil.getParameter(request, prefix	+ "cust_expt_seq", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] expOfcCd = (JSPUtil.getParameter(request, prefix	+ "exp_ofc_cd", length));
			String[] cvrgRgnSteAllCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_ste_all_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cvrgRgnSteCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_ste_cd", length));
			String[] intgCdId = (JSPUtil.getParameter(request, prefix	+ "intg_cd_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_rgn_cd", length));
			String[] dmdtCntrCgoTpAllCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_all_cd", length));
			String[] cvrgSteCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_ste_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] dulExptDeltDesc = (JSPUtil.getParameter(request, prefix	+ "dul_expt_delt_desc", length));
			String[] dmdtCntrCgoTpAllNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_all_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] delDt = (JSPUtil.getParameter(request, prefix	+ "del_dt", length));
			String[] cvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_cnt_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] delUsrNm = (JSPUtil.getParameter(request, prefix	+ "del_usr_nm", length));
			String[] dmdtCntrCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_cd", length));
			String[] dulExptEffDt = (JSPUtil.getParameter(request, prefix	+ "dul_expt_eff_dt", length));
			String[] dulExptRmk = (JSPUtil.getParameter(request, prefix	+ "dul_expt_rmk", length));
			String[] expUsrNm = (JSPUtil.getParameter(request, prefix	+ "exp_usr_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] ioBndDesc = (JSPUtil.getParameter(request, prefix	+ "io_bnd_desc", length));
			String[] expUsrId = (JSPUtil.getParameter(request, prefix	+ "exp_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dulExptDeltFlg = (JSPUtil.getParameter(request, prefix	+ "dul_expt_delt_flg", length));
			String[] dmdtCtrtExptTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ctrt_expt_tp_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] code2 = (JSPUtil.getParameter(request, prefix	+ "code2", length));
			String[] code1 = (JSPUtil.getParameter(request, prefix	+ "code1", length));
			String[] delOfcCd = (JSPUtil.getParameter(request, prefix	+ "del_ofc_cd", length));
			String[] expFlg = (JSPUtil.getParameter(request, prefix	+ "exp_flg", length));
			String[] dulExptEffFromDt = (JSPUtil.getParameter(request, prefix	+ "dul_expt_eff_from_dt", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] cvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "cvrg_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DualTypeCustomerVO();
				if (dulExptEffToDt[i] != null)
					model.setDulExptEffToDt(dulExptEffToDt[i]);
				if (dulExptExpDt[i] != null)
					model.setDulExptExpDt(dulExptExpDt[i]);
				if (cvrgRgnSteAllNm[i] != null)
					model.setCvrgRgnSteAllNm(cvrgRgnSteAllNm[i]);
				if (custExptSeq[i] != null)
					model.setCustExptSeq(custExptSeq[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (expOfcCd[i] != null)
					model.setExpOfcCd(expOfcCd[i]);
				if (cvrgRgnSteAllCd[i] != null)
					model.setCvrgRgnSteAllCd(cvrgRgnSteAllCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cvrgRgnSteCd[i] != null)
					model.setCvrgRgnSteCd(cvrgRgnSteCd[i]);
				if (intgCdId[i] != null)
					model.setIntgCdId(intgCdId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cvrgRgnCd[i] != null)
					model.setCvrgRgnCd(cvrgRgnCd[i]);
				if (dmdtCntrCgoTpAllCd[i] != null)
					model.setDmdtCntrCgoTpAllCd(dmdtCntrCgoTpAllCd[i]);
				if (cvrgSteCd[i] != null)
					model.setCvrgSteCd(cvrgSteCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (dulExptDeltDesc[i] != null)
					model.setDulExptDeltDesc(dulExptDeltDesc[i]);
				if (dmdtCntrCgoTpAllNm[i] != null)
					model.setDmdtCntrCgoTpAllNm(dmdtCntrCgoTpAllNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (delDt[i] != null)
					model.setDelDt(delDt[i]);
				if (cvrgCntCd[i] != null)
					model.setCvrgCntCd(cvrgCntCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (delUsrNm[i] != null)
					model.setDelUsrNm(delUsrNm[i]);
				if (dmdtCntrCgoTpCd[i] != null)
					model.setDmdtCntrCgoTpCd(dmdtCntrCgoTpCd[i]);
				if (dulExptEffDt[i] != null)
					model.setDulExptEffDt(dulExptEffDt[i]);
				if (dulExptRmk[i] != null)
					model.setDulExptRmk(dulExptRmk[i]);
				if (expUsrNm[i] != null)
					model.setExpUsrNm(expUsrNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (ioBndDesc[i] != null)
					model.setIoBndDesc(ioBndDesc[i]);
				if (expUsrId[i] != null)
					model.setExpUsrId(expUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dulExptDeltFlg[i] != null)
					model.setDulExptDeltFlg(dulExptDeltFlg[i]);
				if (dmdtCtrtExptTpCd[i] != null)
					model.setDmdtCtrtExptTpCd(dmdtCtrtExptTpCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (code2[i] != null)
					model.setCode2(code2[i]);
				if (code1[i] != null)
					model.setCode1(code1[i]);
				if (delOfcCd[i] != null)
					model.setDelOfcCd(delOfcCd[i]);
				if (expFlg[i] != null)
					model.setExpFlg(expFlg[i]);
				if (dulExptEffFromDt[i] != null)
					model.setDulExptEffFromDt(dulExptEffFromDt[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (cvrgLocCd[i] != null)
					model.setCvrgLocCd(cvrgLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDualTypeCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DualTypeCustomerVO[]
	 */
	public DualTypeCustomerVO[] getDualTypeCustomerVOs(){
		DualTypeCustomerVO[] vos = (DualTypeCustomerVO[])models.toArray(new DualTypeCustomerVO[models.size()]);
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
		this.dulExptEffToDt = this.dulExptEffToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulExptExpDt = this.dulExptExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnSteAllNm = this.cvrgRgnSteAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custExptSeq = this.custExptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expOfcCd = this.expOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnSteAllCd = this.cvrgRgnSteAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnSteCd = this.cvrgRgnSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdId = this.intgCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgRgnCd = this.cvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpAllCd = this.dmdtCntrCgoTpAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgSteCd = this.cvrgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulExptDeltDesc = this.dulExptDeltDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpAllNm = this.dmdtCntrCgoTpAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDt = this.delDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgCntCd = this.cvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delUsrNm = this.delUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpCd = this.dmdtCntrCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulExptEffDt = this.dulExptEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulExptRmk = this.dulExptRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expUsrNm = this.expUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndDesc = this.ioBndDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expUsrId = this.expUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulExptDeltFlg = this.dulExptDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCtrtExptTpCd = this.dmdtCtrtExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code2 = this.code2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code1 = this.code1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delOfcCd = this.delOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expFlg = this.expFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dulExptEffFromDt = this.dulExptEffFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgLocCd = this.cvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
