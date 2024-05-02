/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SamKeyManInfoVO.java
*@FileTitle : SamKeyManInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.22
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.22 이창원 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.vo;

import java.lang.reflect.Field;
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
 * @author 이창원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamKeyManInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamKeyManInfoVO> models = new ArrayList<SamKeyManInfoVO>();
	
	/* Column Info */
	private String kmanHmAddr = null;
	/* Column Info */
	private String kmanEduCateCd = null;
	/* Column Info */
	private String kmanSgnfIndCd = null;
	/* Column Info */
	private String kmanMarrFlg = null;
	/* Column Info */
	private String jbTitRmk = null;
	/* Column Info */
	private String kmanOfcFaxNo = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String kmanOfcAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String kmanSpsNm = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String kmanGndCd = null;
	/* Column Info */
	private String kmanRmkDesc = null;
	/* Column Info */
	private String kmanN1stNm = null;
	/* Column Info */
	private String custKmanSeq = null;
	/* Column Info */
	private String kmanEml = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String kmanNknmNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String kmanLstNm = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String kmanSpsBrdyDt = null;
	/* Column Info */
	private String kmanDeptDesc = null;
	/* Column Info */
	private String kmanHbyDesc = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String chgDesc = null;
	/* Column Info */
	private String kmanBrdyDt = null;
	/* Column Info */
	private String kmanMjrDesc = null;
	/* Column Info */
	private String bizIssDesc = null;
	/* Column Info */
	private String intlPhnNo = null;
	/* Column Info */
	private String kmanWeddAnvDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamKeyManInfoVO() {}

	public SamKeyManInfoVO(String ibflag, String pagerows, String kmanN1stNm, String kmanLstNm, String kmanGndCd, String jbTitRmk, String kmanDeptDesc, String kmanBrdyDt, String kmanHbyDesc, String kmanSpsNm, String kmanOfcAddr, String kmanHmAddr, String bizIssDesc, String kmanRmkDesc, String custCntCd, String custSeq, String custCd, String custLglEngNm, String srepCd, String kmanEml, String chgDesc, String kmanSgnfIndCd, String kmanNknmNm, String kmanEduCateCd, String kmanMjrDesc, String kmanMarrFlg, String kmanSpsBrdyDt, String customerCode, String kmanWeddAnvDt, String custKmanSeq, String usrId, String kmanOfcFaxNo, String intlPhnNo) {
		this.kmanHmAddr = kmanHmAddr;
		this.kmanEduCateCd = kmanEduCateCd;
		this.kmanSgnfIndCd = kmanSgnfIndCd;
		this.kmanMarrFlg = kmanMarrFlg;
		this.jbTitRmk = jbTitRmk;
		this.kmanOfcFaxNo = kmanOfcFaxNo;
		this.srepCd = srepCd;
		this.kmanOfcAddr = kmanOfcAddr;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.kmanSpsNm = kmanSpsNm;
		this.customerCode = customerCode;
		this.kmanGndCd = kmanGndCd;
		this.kmanRmkDesc = kmanRmkDesc;
		this.kmanN1stNm = kmanN1stNm;
		this.custKmanSeq = custKmanSeq;
		this.kmanEml = kmanEml;
		this.custCntCd = custCntCd;
		this.kmanNknmNm = kmanNknmNm;
		this.custSeq = custSeq;
		this.kmanLstNm = kmanLstNm;
		this.custLglEngNm = custLglEngNm;
		this.kmanSpsBrdyDt = kmanSpsBrdyDt;
		this.kmanDeptDesc = kmanDeptDesc;
		this.kmanHbyDesc = kmanHbyDesc;
		this.custCd = custCd;
		this.chgDesc = chgDesc;
		this.kmanBrdyDt = kmanBrdyDt;
		this.kmanMjrDesc = kmanMjrDesc;
		this.bizIssDesc = bizIssDesc;
		this.intlPhnNo = intlPhnNo;
		this.kmanWeddAnvDt = kmanWeddAnvDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("kman_hm_addr", getKmanHmAddr());
		this.hashColumns.put("kman_edu_cate_cd", getKmanEduCateCd());
		this.hashColumns.put("kman_sgnf_ind_cd", getKmanSgnfIndCd());
		this.hashColumns.put("kman_marr_flg", getKmanMarrFlg());
		this.hashColumns.put("jb_tit_rmk", getJbTitRmk());
		this.hashColumns.put("kman_ofc_fax_no", getKmanOfcFaxNo());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("kman_ofc_addr", getKmanOfcAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("kman_sps_nm", getKmanSpsNm());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("kman_gnd_cd", getKmanGndCd());
		this.hashColumns.put("kman_rmk_desc", getKmanRmkDesc());
		this.hashColumns.put("kman_n1st_nm", getKmanN1stNm());
		this.hashColumns.put("cust_kman_seq", getCustKmanSeq());
		this.hashColumns.put("kman_eml", getKmanEml());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("kman_nknm_nm", getKmanNknmNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("kman_lst_nm", getKmanLstNm());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("kman_sps_brdy_dt", getKmanSpsBrdyDt());
		this.hashColumns.put("kman_dept_desc", getKmanDeptDesc());
		this.hashColumns.put("kman_hby_desc", getKmanHbyDesc());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("chg_desc", getChgDesc());
		this.hashColumns.put("kman_brdy_dt", getKmanBrdyDt());
		this.hashColumns.put("kman_mjr_desc", getKmanMjrDesc());
		this.hashColumns.put("biz_iss_desc", getBizIssDesc());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("kman_wedd_anv_dt", getKmanWeddAnvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("kman_hm_addr", "kmanHmAddr");
		this.hashFields.put("kman_edu_cate_cd", "kmanEduCateCd");
		this.hashFields.put("kman_sgnf_ind_cd", "kmanSgnfIndCd");
		this.hashFields.put("kman_marr_flg", "kmanMarrFlg");
		this.hashFields.put("jb_tit_rmk", "jbTitRmk");
		this.hashFields.put("kman_ofc_fax_no", "kmanOfcFaxNo");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("kman_ofc_addr", "kmanOfcAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("kman_sps_nm", "kmanSpsNm");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("kman_gnd_cd", "kmanGndCd");
		this.hashFields.put("kman_rmk_desc", "kmanRmkDesc");
		this.hashFields.put("kman_n1st_nm", "kmanN1stNm");
		this.hashFields.put("cust_kman_seq", "custKmanSeq");
		this.hashFields.put("kman_eml", "kmanEml");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("kman_nknm_nm", "kmanNknmNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("kman_lst_nm", "kmanLstNm");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("kman_sps_brdy_dt", "kmanSpsBrdyDt");
		this.hashFields.put("kman_dept_desc", "kmanDeptDesc");
		this.hashFields.put("kman_hby_desc", "kmanHbyDesc");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("chg_desc", "chgDesc");
		this.hashFields.put("kman_brdy_dt", "kmanBrdyDt");
		this.hashFields.put("kman_mjr_desc", "kmanMjrDesc");
		this.hashFields.put("biz_iss_desc", "bizIssDesc");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("kman_wedd_anv_dt", "kmanWeddAnvDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return kmanHmAddr
	 */
	public String getKmanHmAddr() {
		return this.kmanHmAddr;
	}
	
	/**
	 * Column Info
	 * @return kmanEduCateCd
	 */
	public String getKmanEduCateCd() {
		return this.kmanEduCateCd;
	}
	
	/**
	 * Column Info
	 * @return kmanSgnfIndCd
	 */
	public String getKmanSgnfIndCd() {
		return this.kmanSgnfIndCd;
	}
	
	/**
	 * Column Info
	 * @return kmanMarrFlg
	 */
	public String getKmanMarrFlg() {
		return this.kmanMarrFlg;
	}
	
	/**
	 * Column Info
	 * @return jbTitRmk
	 */
	public String getJbTitRmk() {
		return this.jbTitRmk;
	}
	
	/**
	 * Column Info
	 * @return kmanOfcFaxNo
	 */
	public String getKmanOfcFaxNo() {
		return this.kmanOfcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return kmanOfcAddr
	 */
	public String getKmanOfcAddr() {
		return this.kmanOfcAddr;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return kmanSpsNm
	 */
	public String getKmanSpsNm() {
		return this.kmanSpsNm;
	}
	
	/**
	 * Column Info
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return this.customerCode;
	}
	
	/**
	 * Column Info
	 * @return kmanGndCd
	 */
	public String getKmanGndCd() {
		return this.kmanGndCd;
	}
	
	/**
	 * Column Info
	 * @return kmanRmkDesc
	 */
	public String getKmanRmkDesc() {
		return this.kmanRmkDesc;
	}
	
	/**
	 * Column Info
	 * @return kmanN1stNm
	 */
	public String getKmanN1stNm() {
		return this.kmanN1stNm;
	}
	
	/**
	 * Column Info
	 * @return custKmanSeq
	 */
	public String getCustKmanSeq() {
		return this.custKmanSeq;
	}
	
	/**
	 * Column Info
	 * @return kmanEml
	 */
	public String getKmanEml() {
		return this.kmanEml;
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
	 * @return kmanNknmNm
	 */
	public String getKmanNknmNm() {
		return this.kmanNknmNm;
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
	 * @return kmanLstNm
	 */
	public String getKmanLstNm() {
		return this.kmanLstNm;
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
	 * @return kmanSpsBrdyDt
	 */
	public String getKmanSpsBrdyDt() {
		return this.kmanSpsBrdyDt;
	}
	
	/**
	 * Column Info
	 * @return kmanDeptDesc
	 */
	public String getKmanDeptDesc() {
		return this.kmanDeptDesc;
	}
	
	/**
	 * Column Info
	 * @return kmanHbyDesc
	 */
	public String getKmanHbyDesc() {
		return this.kmanHbyDesc;
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
	 * @return chgDesc
	 */
	public String getChgDesc() {
		return this.chgDesc;
	}
	
	/**
	 * Column Info
	 * @return kmanBrdyDt
	 */
	public String getKmanBrdyDt() {
		return this.kmanBrdyDt;
	}
	
	/**
	 * Column Info
	 * @return kmanMjrDesc
	 */
	public String getKmanMjrDesc() {
		return this.kmanMjrDesc;
	}
	
	/**
	 * Column Info
	 * @return bizIssDesc
	 */
	public String getBizIssDesc() {
		return this.bizIssDesc;
	}
	
	/**
	 * Column Info
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	
	/**
	 * Column Info
	 * @return kmanWeddAnvDt
	 */
	public String getKmanWeddAnvDt() {
		return this.kmanWeddAnvDt;
	}
	

	/**
	 * Column Info
	 * @param kmanHmAddr
	 */
	public void setKmanHmAddr(String kmanHmAddr) {
		this.kmanHmAddr = kmanHmAddr;
	}
	
	/**
	 * Column Info
	 * @param kmanEduCateCd
	 */
	public void setKmanEduCateCd(String kmanEduCateCd) {
		this.kmanEduCateCd = kmanEduCateCd;
	}
	
	/**
	 * Column Info
	 * @param kmanSgnfIndCd
	 */
	public void setKmanSgnfIndCd(String kmanSgnfIndCd) {
		this.kmanSgnfIndCd = kmanSgnfIndCd;
	}
	
	/**
	 * Column Info
	 * @param kmanMarrFlg
	 */
	public void setKmanMarrFlg(String kmanMarrFlg) {
		this.kmanMarrFlg = kmanMarrFlg;
	}
	
	/**
	 * Column Info
	 * @param jbTitRmk
	 */
	public void setJbTitRmk(String jbTitRmk) {
		this.jbTitRmk = jbTitRmk;
	}
	
	/**
	 * Column Info
	 * @param kmanOfcFaxNo
	 */
	public void setKmanOfcFaxNo(String kmanOfcFaxNo) {
		this.kmanOfcFaxNo = kmanOfcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param kmanOfcAddr
	 */
	public void setKmanOfcAddr(String kmanOfcAddr) {
		this.kmanOfcAddr = kmanOfcAddr;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param kmanSpsNm
	 */
	public void setKmanSpsNm(String kmanSpsNm) {
		this.kmanSpsNm = kmanSpsNm;
	}
	
	/**
	 * Column Info
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	/**
	 * Column Info
	 * @param kmanGndCd
	 */
	public void setKmanGndCd(String kmanGndCd) {
		this.kmanGndCd = kmanGndCd;
	}
	
	/**
	 * Column Info
	 * @param kmanRmkDesc
	 */
	public void setKmanRmkDesc(String kmanRmkDesc) {
		this.kmanRmkDesc = kmanRmkDesc;
	}
	
	/**
	 * Column Info
	 * @param kmanN1stNm
	 */
	public void setKmanN1stNm(String kmanN1stNm) {
		this.kmanN1stNm = kmanN1stNm;
	}
	
	/**
	 * Column Info
	 * @param custKmanSeq
	 */
	public void setCustKmanSeq(String custKmanSeq) {
		this.custKmanSeq = custKmanSeq;
	}
	
	/**
	 * Column Info
	 * @param kmanEml
	 */
	public void setKmanEml(String kmanEml) {
		this.kmanEml = kmanEml;
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
	 * @param kmanNknmNm
	 */
	public void setKmanNknmNm(String kmanNknmNm) {
		this.kmanNknmNm = kmanNknmNm;
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
	 * @param kmanLstNm
	 */
	public void setKmanLstNm(String kmanLstNm) {
		this.kmanLstNm = kmanLstNm;
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
	 * @param kmanSpsBrdyDt
	 */
	public void setKmanSpsBrdyDt(String kmanSpsBrdyDt) {
		this.kmanSpsBrdyDt = kmanSpsBrdyDt;
	}
	
	/**
	 * Column Info
	 * @param kmanDeptDesc
	 */
	public void setKmanDeptDesc(String kmanDeptDesc) {
		this.kmanDeptDesc = kmanDeptDesc;
	}
	
	/**
	 * Column Info
	 * @param kmanHbyDesc
	 */
	public void setKmanHbyDesc(String kmanHbyDesc) {
		this.kmanHbyDesc = kmanHbyDesc;
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
	 * @param chgDesc
	 */
	public void setChgDesc(String chgDesc) {
		this.chgDesc = chgDesc;
	}
	
	/**
	 * Column Info
	 * @param kmanBrdyDt
	 */
	public void setKmanBrdyDt(String kmanBrdyDt) {
		this.kmanBrdyDt = kmanBrdyDt;
	}
	
	/**
	 * Column Info
	 * @param kmanMjrDesc
	 */
	public void setKmanMjrDesc(String kmanMjrDesc) {
		this.kmanMjrDesc = kmanMjrDesc;
	}
	
	/**
	 * Column Info
	 * @param bizIssDesc
	 */
	public void setBizIssDesc(String bizIssDesc) {
		this.bizIssDesc = bizIssDesc;
	}
	
	/**
	 * Column Info
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * Column Info
	 * @param kmanWeddAnvDt
	 */
	public void setKmanWeddAnvDt(String kmanWeddAnvDt) {
		this.kmanWeddAnvDt = kmanWeddAnvDt;
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
		setKmanHmAddr(JSPUtil.getParameter(request, prefix + "kman_hm_addr", ""));
		setKmanEduCateCd(JSPUtil.getParameter(request, prefix + "kman_edu_cate_cd", ""));
		setKmanSgnfIndCd(JSPUtil.getParameter(request, prefix + "kman_sgnf_ind_cd", ""));
		setKmanMarrFlg(JSPUtil.getParameter(request, prefix + "kman_marr_flg", ""));
		setJbTitRmk(JSPUtil.getParameter(request, prefix + "jb_tit_rmk", ""));
		setKmanOfcFaxNo(JSPUtil.getParameter(request, prefix + "kman_ofc_fax_no", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setKmanOfcAddr(JSPUtil.getParameter(request, prefix + "kman_ofc_addr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setKmanSpsNm(JSPUtil.getParameter(request, prefix + "kman_sps_nm", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setKmanGndCd(JSPUtil.getParameter(request, prefix + "kman_gnd_cd", ""));
		setKmanRmkDesc(JSPUtil.getParameter(request, prefix + "kman_rmk_desc", ""));
		setKmanN1stNm(JSPUtil.getParameter(request, prefix + "kman_n1st_nm", ""));
		setCustKmanSeq(JSPUtil.getParameter(request, prefix + "cust_kman_seq", ""));
		setKmanEml(JSPUtil.getParameter(request, prefix + "kman_eml", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setKmanNknmNm(JSPUtil.getParameter(request, prefix + "kman_nknm_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setKmanLstNm(JSPUtil.getParameter(request, prefix + "kman_lst_nm", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setKmanSpsBrdyDt(JSPUtil.getParameter(request, prefix + "kman_sps_brdy_dt", ""));
		setKmanDeptDesc(JSPUtil.getParameter(request, prefix + "kman_dept_desc", ""));
		setKmanHbyDesc(JSPUtil.getParameter(request, prefix + "kman_hby_desc", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setChgDesc(JSPUtil.getParameter(request, prefix + "chg_desc", ""));
		setKmanBrdyDt(JSPUtil.getParameter(request, prefix + "kman_brdy_dt", ""));
		setKmanMjrDesc(JSPUtil.getParameter(request, prefix + "kman_mjr_desc", ""));
		setBizIssDesc(JSPUtil.getParameter(request, prefix + "biz_iss_desc", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setKmanWeddAnvDt(JSPUtil.getParameter(request, prefix + "kman_wedd_anv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamKeyManInfoVO[]
	 */
	public SamKeyManInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamKeyManInfoVO[]
	 */
	public SamKeyManInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamKeyManInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] kmanHmAddr = (JSPUtil.getParameter(request, prefix	+ "kman_hm_addr", length));
			String[] kmanEduCateCd = (JSPUtil.getParameter(request, prefix	+ "kman_edu_cate_cd", length));
			String[] kmanSgnfIndCd = (JSPUtil.getParameter(request, prefix	+ "kman_sgnf_ind_cd", length));
			String[] kmanMarrFlg = (JSPUtil.getParameter(request, prefix	+ "kman_marr_flg", length));
			String[] jbTitRmk = (JSPUtil.getParameter(request, prefix	+ "jb_tit_rmk", length));
			String[] kmanOfcFaxNo = (JSPUtil.getParameter(request, prefix	+ "kman_ofc_fax_no", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] kmanOfcAddr = (JSPUtil.getParameter(request, prefix	+ "kman_ofc_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] kmanSpsNm = (JSPUtil.getParameter(request, prefix	+ "kman_sps_nm", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] kmanGndCd = (JSPUtil.getParameter(request, prefix	+ "kman_gnd_cd", length));
			String[] kmanRmkDesc = (JSPUtil.getParameter(request, prefix	+ "kman_rmk_desc", length));
			String[] kmanN1stNm = (JSPUtil.getParameter(request, prefix	+ "kman_n1st_nm", length));
			String[] custKmanSeq = (JSPUtil.getParameter(request, prefix	+ "cust_kman_seq", length));
			String[] kmanEml = (JSPUtil.getParameter(request, prefix	+ "kman_eml", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] kmanNknmNm = (JSPUtil.getParameter(request, prefix	+ "kman_nknm_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] kmanLstNm = (JSPUtil.getParameter(request, prefix	+ "kman_lst_nm", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] kmanSpsBrdyDt = (JSPUtil.getParameter(request, prefix	+ "kman_sps_brdy_dt", length));
			String[] kmanDeptDesc = (JSPUtil.getParameter(request, prefix	+ "kman_dept_desc", length));
			String[] kmanHbyDesc = (JSPUtil.getParameter(request, prefix	+ "kman_hby_desc", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] chgDesc = (JSPUtil.getParameter(request, prefix	+ "chg_desc", length));
			String[] kmanBrdyDt = (JSPUtil.getParameter(request, prefix	+ "kman_brdy_dt", length));
			String[] kmanMjrDesc = (JSPUtil.getParameter(request, prefix	+ "kman_mjr_desc", length));
			String[] bizIssDesc = (JSPUtil.getParameter(request, prefix	+ "biz_iss_desc", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] kmanWeddAnvDt = (JSPUtil.getParameter(request, prefix	+ "kman_wedd_anv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamKeyManInfoVO();
				if (kmanHmAddr[i] != null)
					model.setKmanHmAddr(kmanHmAddr[i]);
				if (kmanEduCateCd[i] != null)
					model.setKmanEduCateCd(kmanEduCateCd[i]);
				if (kmanSgnfIndCd[i] != null)
					model.setKmanSgnfIndCd(kmanSgnfIndCd[i]);
				if (kmanMarrFlg[i] != null)
					model.setKmanMarrFlg(kmanMarrFlg[i]);
				if (jbTitRmk[i] != null)
					model.setJbTitRmk(jbTitRmk[i]);
				if (kmanOfcFaxNo[i] != null)
					model.setKmanOfcFaxNo(kmanOfcFaxNo[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (kmanOfcAddr[i] != null)
					model.setKmanOfcAddr(kmanOfcAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (kmanSpsNm[i] != null)
					model.setKmanSpsNm(kmanSpsNm[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (kmanGndCd[i] != null)
					model.setKmanGndCd(kmanGndCd[i]);
				if (kmanRmkDesc[i] != null)
					model.setKmanRmkDesc(kmanRmkDesc[i]);
				if (kmanN1stNm[i] != null)
					model.setKmanN1stNm(kmanN1stNm[i]);
				if (custKmanSeq[i] != null)
					model.setCustKmanSeq(custKmanSeq[i]);
				if (kmanEml[i] != null)
					model.setKmanEml(kmanEml[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (kmanNknmNm[i] != null)
					model.setKmanNknmNm(kmanNknmNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (kmanLstNm[i] != null)
					model.setKmanLstNm(kmanLstNm[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (kmanSpsBrdyDt[i] != null)
					model.setKmanSpsBrdyDt(kmanSpsBrdyDt[i]);
				if (kmanDeptDesc[i] != null)
					model.setKmanDeptDesc(kmanDeptDesc[i]);
				if (kmanHbyDesc[i] != null)
					model.setKmanHbyDesc(kmanHbyDesc[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (chgDesc[i] != null)
					model.setChgDesc(chgDesc[i]);
				if (kmanBrdyDt[i] != null)
					model.setKmanBrdyDt(kmanBrdyDt[i]);
				if (kmanMjrDesc[i] != null)
					model.setKmanMjrDesc(kmanMjrDesc[i]);
				if (bizIssDesc[i] != null)
					model.setBizIssDesc(bizIssDesc[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				if (kmanWeddAnvDt[i] != null)
					model.setKmanWeddAnvDt(kmanWeddAnvDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamKeyManInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamKeyManInfoVO[]
	 */
	public SamKeyManInfoVO[] getSamKeyManInfoVOs(){
		SamKeyManInfoVO[] vos = (SamKeyManInfoVO[])models.toArray(new SamKeyManInfoVO[models.size()]);
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
		this.kmanHmAddr = this.kmanHmAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanEduCateCd = this.kmanEduCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanSgnfIndCd = this.kmanSgnfIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanMarrFlg = this.kmanMarrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbTitRmk = this.jbTitRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanOfcFaxNo = this.kmanOfcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanOfcAddr = this.kmanOfcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanSpsNm = this.kmanSpsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanGndCd = this.kmanGndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanRmkDesc = this.kmanRmkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanN1stNm = this.kmanN1stNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custKmanSeq = this.custKmanSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanEml = this.kmanEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanNknmNm = this.kmanNknmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanLstNm = this.kmanLstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanSpsBrdyDt = this.kmanSpsBrdyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanDeptDesc = this.kmanDeptDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanHbyDesc = this.kmanHbyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDesc = this.chgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanBrdyDt = this.kmanBrdyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanMjrDesc = this.kmanMjrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizIssDesc = this.bizIssDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kmanWeddAnvDt = this.kmanWeddAnvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
