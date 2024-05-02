/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSpaceControlInquiryOfficeCustomerListVO.java
*@FileTitle : SearchSpaceControlInquiryOfficeCustomerListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.30
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.06.30 이상용 
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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
 * @author 이상용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiryOfficeCustomerListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiryOfficeCustomerListVO> models = new ArrayList<SearchSpaceControlInquiryOfficeCustomerListVO>();
	
	/* Column Info */
	private String fctWgt = null;
	/* Column Info */
	private String fctHc = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String fct45 = null;
	/* Column Info */
	private String firmWgt = null;
	/* Column Info */
	private String firmTeu = null;
	/* Column Info */
	private String ord = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fctRf = null;
	/* Column Info */
	private String firmRf = null;
	/* Column Info */
	private String wait20 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wait45 = null;
	/* Column Info */
	private String fcTtlTeu = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String waitRf = null;
	/* Column Info */
	private String firm53 = null;
	/* Column Info */
	private String wait40 = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String fctTeu = null;
	/* Column Info */
	private String firm20 = null;
	/* Column Info */
	private String flg = null;
	/* Column Info */
	private String waitTeu = null;
	/* Column Info */
	private String fct53 = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String firmHc = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String firm45 = null;
	/* Column Info */
	private String wait53 = null;
	/* Column Info */
	private String waitWgt = null;
	/* Column Info */
	private String firm40 = null;
	/* Column Info */
	private String waitHc = null;
	/* Column Info */
	private String rvisCntrCustTpCd = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String smp = null;
	/* Column Info */
	private String cmb = null;
	/* Column Info */
	private String cmbWgt = null;
	/* Column Info */
	private String cmb1 = null;
	/* Column Info */
	private String cmbWgt1 = null;
	/* Column Info */
	private String cmb2 = null;
	/* Column Info */
	private String cmbWgt2 = null;
	/* Column Info */
	private String cmb3 = null;
	/* Column Info */
	private String cmbWgt3 = null;
	/* Column Info */
	private String cmb4 = null;
	/* Column Info */
	private String cmbWgt4 = null;
	/* Column Info */
	private String bkgWgtVgm= null;
	/* Column Info */
	private String bkgVolVgm = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiryOfficeCustomerListVO() {}

	public SearchSpaceControlInquiryOfficeCustomerListVO(String ibflag, String pagerows, String flg, String ord, String custCntCd, String custSeq, String custCd, String custNm, String portCd, String ofcCd, String fcTtlTeu, String fctTeu, String fctHc, String fct45, String fct53, String fctRf, String fctWgt, String firmTeu, String firm20, String firm40, String firmHc, String firm45, String firm53, String firmRf, String firmWgt, String waitTeu, String wait20, String wait40, String waitHc, String wait45, String wait53, String waitRf, String waitWgt, String rvisCntrCustTpCd, String custCtrlCd, String smp, String cmb, String cmbWgt, String cmb1, String cmbWgt1, String cmb2, String cmbWgt2, String cmb3, String cmbWgt3, String cmb4, String cmbWgt4,String bkgWgtVgm,String bkgVolVgm) {
		this.fctWgt = fctWgt;
		this.fctHc = fctHc;
		this.custNm = custNm;
		this.fct45 = fct45;
		this.firmWgt = firmWgt;
		this.firmTeu = firmTeu;
		this.ord = ord;
		this.pagerows = pagerows;
		this.fctRf = fctRf;
		this.firmRf = firmRf;
		this.wait20 = wait20;
		this.ibflag = ibflag;
		this.wait45 = wait45;
		this.fcTtlTeu = fcTtlTeu;
		this.portCd = portCd;
		this.waitRf = waitRf;
		this.firm53 = firm53;
		this.wait40 = wait40;
		this.custCntCd = custCntCd;
		this.fctTeu = fctTeu;
		this.firm20 = firm20;
		this.flg = flg;
		this.waitTeu = waitTeu;
		this.fct53 = fct53;
		this.custSeq = custSeq;
		this.ofcCd = ofcCd;
		this.firmHc = firmHc;
		this.custCd = custCd;
		this.firm45 = firm45;
		this.wait53 = wait53;
		this.waitWgt = waitWgt;
		this.firm40 = firm40;
		this.waitHc = waitHc;
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
		this.custCtrlCd = custCtrlCd;
		this.smp = smp;
		this.cmb = cmb;
		this.cmbWgt = cmbWgt;
		this.cmb1 = cmb1;
		this.cmbWgt1 = cmbWgt1;
		this.cmb2 = cmb2;
		this.cmbWgt2 = cmbWgt2;
		this.cmb3 = cmb3;
		this.cmbWgt3 = cmbWgt3;
		this.cmb4 = cmb4;
		this.cmbWgt4 = cmbWgt4;
		this.bkgWgtVgm = bkgWgtVgm;
		this.bkgVolVgm = bkgVolVgm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fct_wgt", getFctWgt());
		this.hashColumns.put("fct_hc", getFctHc());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("fct_45", getFct45());
		this.hashColumns.put("firm_wgt", getFirmWgt());
		this.hashColumns.put("firm_teu", getFirmTeu());
		this.hashColumns.put("ord", getOrd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fct_rf", getFctRf());
		this.hashColumns.put("firm_rf", getFirmRf());
		this.hashColumns.put("wait_20", getWait20());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wait_45", getWait45());
		this.hashColumns.put("fc_ttl_teu", getFcTtlTeu());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("wait_rf", getWaitRf());
		this.hashColumns.put("firm_53", getFirm53());
		this.hashColumns.put("wait_40", getWait40());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("fct_teu", getFctTeu());
		this.hashColumns.put("firm_20", getFirm20());
		this.hashColumns.put("flg", getFlg());
		this.hashColumns.put("wait_teu", getWaitTeu());
		this.hashColumns.put("fct_53", getFct53());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("firm_hc", getFirmHc());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("firm_45", getFirm45());
		this.hashColumns.put("wait_53", getWait53());
		this.hashColumns.put("wait_wgt", getWaitWgt());
		this.hashColumns.put("firm_40", getFirm40());
		this.hashColumns.put("wait_hc", getWaitHc());
		this.hashColumns.put("rvis_cntr_cust_tp_cd", getRvisCntrCustTpCd());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("smp", getSmp());
		this.hashColumns.put("cmb", getCmb());
		this.hashColumns.put("cmb_wgt", getCmbWgt());
		this.hashColumns.put("cmb1", getCmb1());
		this.hashColumns.put("cmb_wgt1", getCmbWgt1());
		this.hashColumns.put("cmb2", getCmb2());
		this.hashColumns.put("cmb_wgt2", getCmbWgt2());
		this.hashColumns.put("cmb3", getCmb3());
		this.hashColumns.put("cmb_wgt3", getCmbWgt3());
		this.hashColumns.put("cmb4", getCmb4());
		this.hashColumns.put("cmb_wgt4", getCmbWgt4());
		this.hashColumns.put("bkg_wgt_vgm", getBkgWgtVgm());
		this.hashColumns.put("bkg_vol_vgm", getBkgVolVgm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fct_wgt", "fctWgt");
		this.hashFields.put("fct_hc", "fctHc");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("fct_45", "fct45");
		this.hashFields.put("firm_wgt", "firmWgt");
		this.hashFields.put("firm_teu", "firmTeu");
		this.hashFields.put("ord", "ord");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fct_rf", "fctRf");
		this.hashFields.put("firm_rf", "firmRf");
		this.hashFields.put("wait_20", "wait20");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wait_45", "wait45");
		this.hashFields.put("fc_ttl_teu", "fcTtlTeu");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("wait_rf", "waitRf");
		this.hashFields.put("firm_53", "firm53");
		this.hashFields.put("wait_40", "wait40");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("fct_teu", "fctTeu");
		this.hashFields.put("firm_20", "firm20");
		this.hashFields.put("flg", "flg");
		this.hashFields.put("wait_teu", "waitTeu");
		this.hashFields.put("fct_53", "fct53");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("firm_hc", "firmHc");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("firm_45", "firm45");
		this.hashFields.put("wait_53", "wait53");
		this.hashFields.put("wait_wgt", "waitWgt");
		this.hashFields.put("firm_40", "firm40");
		this.hashFields.put("wait_hc", "waitHc");
		this.hashFields.put("rvis_cntr_cust_tp_cd", "rvisCntrCustTpCd");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("smp", "smp");
		this.hashFields.put("cmb", "cmb");
		this.hashFields.put("cmb_wgt", "cmbWgt");
		this.hashFields.put("cmb1", "cmb1");
		this.hashFields.put("cmb_wgt1", "cmbWgt1");
		this.hashFields.put("cmb2", "cmb2");
		this.hashFields.put("cmb_wgt2", "cmbWgt2");
		this.hashFields.put("cmb3", "cmb3");
		this.hashFields.put("cmb_wgt3", "cmbWgt3");
		this.hashFields.put("cmb4", "cmb4");
		this.hashFields.put("cmb_wgt4", "cmbWgt4");
		this.hashFields.put("bkg_wgt_vgm", "bkgWgtVgm");
		this.hashFields.put("bkg_vol_vgm", "bkgVolVgm");
		return this.hashFields;
	}
	/**
	 * Column Info			
	 * @return bkgVolVgm			
	 */		
	public String getBkgVolVgm() {
		return bkgVolVgm;
	}
	/**			
	 * Column Info			
	 * @param bkgVolVgm			
	 */		
	public void setBkgVolVgm(String bkgVolVgm) {
		this.bkgVolVgm = bkgVolVgm;
	}
	/**			
	 * Column Info			
	 * @return bkgWgtVgm			
	 */			
	public String getBkgWgtVgm() {			
		return this.bkgWgtVgm;		
	}			
	/**			
	 * Column Info			
	 * @param bkgWgtVgm			
	 */			
	public void setBkgWgtVgm(String bkgWgtVgm) {			
		this.bkgWgtVgm = bkgWgtVgm;		
	}		
	/**
	 * Column Info
	 * @return fctWgt
	 */
	public String getFctWgt() {
		return this.fctWgt;
	}
	
	/**
	 * Column Info
	 * @return fctHc
	 */
	public String getFctHc() {
		return this.fctHc;
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
	 * @return fct45
	 */
	public String getFct45() {
		return this.fct45;
	}
	
	/**
	 * Column Info
	 * @return firmWgt
	 */
	public String getFirmWgt() {
		return this.firmWgt;
	}
	
	/**
	 * Column Info
	 * @return firmTeu
	 */
	public String getFirmTeu() {
		return this.firmTeu;
	}
	
	/**
	 * Column Info
	 * @return ord
	 */
	public String getOrd() {
		return this.ord;
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
	 * @return fctRf
	 */
	public String getFctRf() {
		return this.fctRf;
	}
	
	/**
	 * Column Info
	 * @return firmRf
	 */
	public String getFirmRf() {
		return this.firmRf;
	}
	
	/**
	 * Column Info
	 * @return wait20
	 */
	public String getWait20() {
		return this.wait20;
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
	 * @return wait45
	 */
	public String getWait45() {
		return this.wait45;
	}
	
	/**
	 * Column Info
	 * @return fcTtlTeu
	 */
	public String getFcTtlTeu() {
		return this.fcTtlTeu;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return waitRf
	 */
	public String getWaitRf() {
		return this.waitRf;
	}
	
	/**
	 * Column Info
	 * @return firm53
	 */
	public String getFirm53() {
		return this.firm53;
	}
	
	/**
	 * Column Info
	 * @return wait40
	 */
	public String getWait40() {
		return this.wait40;
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
	 * @return fctTeu
	 */
	public String getFctTeu() {
		return this.fctTeu;
	}
	
	/**
	 * Column Info
	 * @return firm20
	 */
	public String getFirm20() {
		return this.firm20;
	}
	
	/**
	 * Column Info
	 * @return flg
	 */
	public String getFlg() {
		return this.flg;
	}
	
	/**
	 * Column Info
	 * @return waitTeu
	 */
	public String getWaitTeu() {
		return this.waitTeu;
	}
	
	/**
	 * Column Info
	 * @return fct53
	 */
	public String getFct53() {
		return this.fct53;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return firmHc
	 */
	public String getFirmHc() {
		return this.firmHc;
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
	 * @return firm45
	 */
	public String getFirm45() {
		return this.firm45;
	}
	
	/**
	 * Column Info
	 * @return wait53
	 */
	public String getWait53() {
		return this.wait53;
	}
	
	/**
	 * Column Info
	 * @return waitWgt
	 */
	public String getWaitWgt() {
		return this.waitWgt;
	}
	
	/**
	 * Column Info
	 * @return firm40
	 */
	public String getFirm40() {
		return this.firm40;
	}
	
	/**
	 * Column Info
	 * @return waitHc
	 */
	public String getWaitHc() {
		return this.waitHc;
	}
	
	/**
	 * Column Info
	 * @return rvisCntrCustTpCd
	 */
	public String getRvisCntrCustTpCd() {
		return this.rvisCntrCustTpCd;
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
	 * @return smp
	 */
	public String getSmp() {
		return this.smp;
	}
	
	/**
	 * Column Info
	 * @return cmb
	 */
	public String getCmb() {
		return this.cmb;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt
	 */
	public String getCmbWgt() {
		return this.cmbWgt;
	}
	
	/**
	 * Column Info
	 * @return cmb1
	 */
	public String getCmb1() {
		return this.cmb1;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt1
	 */
	public String getCmbWgt1() {
		return this.cmbWgt1;
	}
	
	/**
	 * Column Info
	 * @return cmb2
	 */
	public String getCmb2() {
		return this.cmb2;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt2
	 */
	public String getCmbWgt2() {
		return this.cmbWgt2;
	}
	
	/**
	 * Column Info
	 * @return cmb3
	 */
	public String getCmb3() {
		return this.cmb3;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt3
	 */
	public String getCmbWgt3() {
		return this.cmbWgt3;
	}
	
	/**
	 * Column Info
	 * @return cmb4
	 */
	public String getCmb4() {
		return this.cmb4;
	}
	
	/**
	 * Column Info
	 * @return cmbWgt4
	 */
	public String getCmbWgt4() {
		return this.cmbWgt4;
	}
	

	/**
	 * Column Info
	 * @param fctWgt
	 */
	public void setFctWgt(String fctWgt) {
		this.fctWgt = fctWgt;
	}
	
	/**
	 * Column Info
	 * @param fctHc
	 */
	public void setFctHc(String fctHc) {
		this.fctHc = fctHc;
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
	 * @param fct45
	 */
	public void setFct45(String fct45) {
		this.fct45 = fct45;
	}
	
	/**
	 * Column Info
	 * @param firmWgt
	 */
	public void setFirmWgt(String firmWgt) {
		this.firmWgt = firmWgt;
	}
	
	/**
	 * Column Info
	 * @param firmTeu
	 */
	public void setFirmTeu(String firmTeu) {
		this.firmTeu = firmTeu;
	}
	
	/**
	 * Column Info
	 * @param ord
	 */
	public void setOrd(String ord) {
		this.ord = ord;
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
	 * @param fctRf
	 */
	public void setFctRf(String fctRf) {
		this.fctRf = fctRf;
	}
	
	/**
	 * Column Info
	 * @param firmRf
	 */
	public void setFirmRf(String firmRf) {
		this.firmRf = firmRf;
	}
	
	/**
	 * Column Info
	 * @param wait20
	 */
	public void setWait20(String wait20) {
		this.wait20 = wait20;
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
	 * @param wait45
	 */
	public void setWait45(String wait45) {
		this.wait45 = wait45;
	}
	
	/**
	 * Column Info
	 * @param fcTtlTeu
	 */
	public void setFcTtlTeu(String fcTtlTeu) {
		this.fcTtlTeu = fcTtlTeu;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param waitRf
	 */
	public void setWaitRf(String waitRf) {
		this.waitRf = waitRf;
	}
	
	/**
	 * Column Info
	 * @param firm53
	 */
	public void setFirm53(String firm53) {
		this.firm53 = firm53;
	}
	
	/**
	 * Column Info
	 * @param wait40
	 */
	public void setWait40(String wait40) {
		this.wait40 = wait40;
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
	 * @param fctTeu
	 */
	public void setFctTeu(String fctTeu) {
		this.fctTeu = fctTeu;
	}
	
	/**
	 * Column Info
	 * @param firm20
	 */
	public void setFirm20(String firm20) {
		this.firm20 = firm20;
	}
	
	/**
	 * Column Info
	 * @param flg
	 */
	public void setFlg(String flg) {
		this.flg = flg;
	}
	
	/**
	 * Column Info
	 * @param waitTeu
	 */
	public void setWaitTeu(String waitTeu) {
		this.waitTeu = waitTeu;
	}
	
	/**
	 * Column Info
	 * @param fct53
	 */
	public void setFct53(String fct53) {
		this.fct53 = fct53;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param firmHc
	 */
	public void setFirmHc(String firmHc) {
		this.firmHc = firmHc;
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
	 * @param firm45
	 */
	public void setFirm45(String firm45) {
		this.firm45 = firm45;
	}
	
	/**
	 * Column Info
	 * @param wait53
	 */
	public void setWait53(String wait53) {
		this.wait53 = wait53;
	}
	
	/**
	 * Column Info
	 * @param waitWgt
	 */
	public void setWaitWgt(String waitWgt) {
		this.waitWgt = waitWgt;
	}
	
	/**
	 * Column Info
	 * @param firm40
	 */
	public void setFirm40(String firm40) {
		this.firm40 = firm40;
	}
	
	/**
	 * Column Info
	 * @param waitHc
	 */
	public void setWaitHc(String waitHc) {
		this.waitHc = waitHc;
	}
	
	/**
	 * Column Info
	 * @param rvisCntrCustTpCd
	 */
	public void setRvisCntrCustTpCd(String rvisCntrCustTpCd) {
		this.rvisCntrCustTpCd = rvisCntrCustTpCd;
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
	 * @param smp
	 */
	public void setSmp(String smp) {
		this.smp = smp;
	}
	
	/**
	 * Column Info
	 * @param cmb
	 */
	public void setCmb(String cmb) {
		this.cmb = cmb;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt
	 */
	public void setCmbWgt(String cmbWgt) {
		this.cmbWgt = cmbWgt;
	}
	
	/**
	 * Column Info
	 * @param cmb1
	 */
	public void setCmb1(String cmb1) {
		this.cmb1 = cmb1;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt1
	 */
	public void setCmbWgt1(String cmbWgt1) {
		this.cmbWgt1 = cmbWgt1;
	}
	
	/**
	 * Column Info
	 * @param cmb2
	 */
	public void setCmb2(String cmb2) {
		this.cmb2 = cmb2;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt2
	 */
	public void setCmbWgt2(String cmbWgt2) {
		this.cmbWgt2 = cmbWgt2;
	}
	
	/**
	 * Column Info
	 * @param cmb3
	 */
	public void setCmb3(String cmb3) {
		this.cmb3 = cmb3;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt3
	 */
	public void setCmbWgt3(String cmbWgt3) {
		this.cmbWgt3 = cmbWgt3;
	}
	
	/**
	 * Column Info
	 * @param cmb4
	 */
	public void setCmb4(String cmb4) {
		this.cmb4 = cmb4;
	}
	
	/**
	 * Column Info
	 * @param cmbWgt4
	 */
	public void setCmbWgt4(String cmbWgt4) {
		this.cmbWgt4 = cmbWgt4;
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
		setFctWgt(JSPUtil.getParameter(request, prefix + "fct_wgt", ""));
		setFctHc(JSPUtil.getParameter(request, prefix + "fct_hc", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setFct45(JSPUtil.getParameter(request, prefix + "fct_45", ""));
		setFirmWgt(JSPUtil.getParameter(request, prefix + "firm_wgt", ""));
		setFirmTeu(JSPUtil.getParameter(request, prefix + "firm_teu", ""));
		setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFctRf(JSPUtil.getParameter(request, prefix + "fct_rf", ""));
		setFirmRf(JSPUtil.getParameter(request, prefix + "firm_rf", ""));
		setWait20(JSPUtil.getParameter(request, prefix + "wait_20", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWait45(JSPUtil.getParameter(request, prefix + "wait_45", ""));
		setFcTtlTeu(JSPUtil.getParameter(request, prefix + "fc_ttl_teu", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setWaitRf(JSPUtil.getParameter(request, prefix + "wait_rf", ""));
		setFirm53(JSPUtil.getParameter(request, prefix + "firm_53", ""));
		setWait40(JSPUtil.getParameter(request, prefix + "wait_40", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setFctTeu(JSPUtil.getParameter(request, prefix + "fct_teu", ""));
		setFirm20(JSPUtil.getParameter(request, prefix + "firm_20", ""));
		setFlg(JSPUtil.getParameter(request, prefix + "flg", ""));
		setWaitTeu(JSPUtil.getParameter(request, prefix + "wait_teu", ""));
		setFct53(JSPUtil.getParameter(request, prefix + "fct_53", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFirmHc(JSPUtil.getParameter(request, prefix + "firm_hc", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setFirm45(JSPUtil.getParameter(request, prefix + "firm_45", ""));
		setWait53(JSPUtil.getParameter(request, prefix + "wait_53", ""));
		setWaitWgt(JSPUtil.getParameter(request, prefix + "wait_wgt", ""));
		setFirm40(JSPUtil.getParameter(request, prefix + "firm_40", ""));
		setWaitHc(JSPUtil.getParameter(request, prefix + "wait_hc", ""));
		setRvisCntrCustTpCd(JSPUtil.getParameter(request, prefix + "rvis_cntr_cust_tp_cd", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setSmp(JSPUtil.getParameter(request, prefix + "smp", ""));
		setCmb(JSPUtil.getParameter(request, prefix + "cmb", ""));
		setCmbWgt(JSPUtil.getParameter(request, prefix + "cmb_wgt", ""));
		setCmb1(JSPUtil.getParameter(request, prefix + "cmb1", ""));
		setCmbWgt1(JSPUtil.getParameter(request, prefix + "cmb_wgt1", ""));
		setCmb2(JSPUtil.getParameter(request, prefix + "cmb2", ""));
		setCmbWgt2(JSPUtil.getParameter(request, prefix + "cmb_wgt2", ""));
		setCmb3(JSPUtil.getParameter(request, prefix + "cmb3", ""));
		setCmbWgt3(JSPUtil.getParameter(request, prefix + "cmb_wgt3", ""));
		setCmb4(JSPUtil.getParameter(request, prefix + "cmb4", ""));
		setCmbWgt4(JSPUtil.getParameter(request, prefix + "cmb_wgt4", ""));
		setBkgWgtVgm(JSPUtil.getParameter(request, prefix + "bkg_wgt_vgm", ""));
		setBkgVolVgm(JSPUtil.getParameter(request, prefix + "bkg_vol_vgm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiryOfficeCustomerListVO[]
	 */
	public SearchSpaceControlInquiryOfficeCustomerListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiryOfficeCustomerListVO[]
	 */
	public SearchSpaceControlInquiryOfficeCustomerListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiryOfficeCustomerListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fctWgt = (JSPUtil.getParameter(request, prefix	+ "fct_wgt", length));
			String[] fctHc = (JSPUtil.getParameter(request, prefix	+ "fct_hc", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] fct45 = (JSPUtil.getParameter(request, prefix	+ "fct_45", length));
			String[] firmWgt = (JSPUtil.getParameter(request, prefix	+ "firm_wgt", length));
			String[] firmTeu = (JSPUtil.getParameter(request, prefix	+ "firm_teu", length));
			String[] ord = (JSPUtil.getParameter(request, prefix	+ "ord", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fctRf = (JSPUtil.getParameter(request, prefix	+ "fct_rf", length));
			String[] firmRf = (JSPUtil.getParameter(request, prefix	+ "firm_rf", length));
			String[] wait20 = (JSPUtil.getParameter(request, prefix	+ "wait_20", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wait45 = (JSPUtil.getParameter(request, prefix	+ "wait_45", length));
			String[] fcTtlTeu = (JSPUtil.getParameter(request, prefix	+ "fc_ttl_teu", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] waitRf = (JSPUtil.getParameter(request, prefix	+ "wait_rf", length));
			String[] firm53 = (JSPUtil.getParameter(request, prefix	+ "firm_53", length));
			String[] wait40 = (JSPUtil.getParameter(request, prefix	+ "wait_40", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] fctTeu = (JSPUtil.getParameter(request, prefix	+ "fct_teu", length));
			String[] firm20 = (JSPUtil.getParameter(request, prefix	+ "firm_20", length));
			String[] flg = (JSPUtil.getParameter(request, prefix	+ "flg", length));
			String[] waitTeu = (JSPUtil.getParameter(request, prefix	+ "wait_teu", length));
			String[] fct53 = (JSPUtil.getParameter(request, prefix	+ "fct_53", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] firmHc = (JSPUtil.getParameter(request, prefix	+ "firm_hc", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] firm45 = (JSPUtil.getParameter(request, prefix	+ "firm_45", length));
			String[] wait53 = (JSPUtil.getParameter(request, prefix	+ "wait_53", length));
			String[] waitWgt = (JSPUtil.getParameter(request, prefix	+ "wait_wgt", length));
			String[] firm40 = (JSPUtil.getParameter(request, prefix	+ "firm_40", length));
			String[] waitHc = (JSPUtil.getParameter(request, prefix	+ "wait_hc", length));
			String[] rvisCntrCustTpCd = (JSPUtil.getParameter(request, prefix	+ "rvis_cntr_cust_tp_cd", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] smp = (JSPUtil.getParameter(request, prefix	+ "smp", length));
			String[] cmb = (JSPUtil.getParameter(request, prefix	+ "cmb", length));
			String[] cmbWgt = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt", length));
			String[] cmb1 = (JSPUtil.getParameter(request, prefix	+ "cmb1", length));
			String[] cmbWgt1 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt1", length));
			String[] cmb2 = (JSPUtil.getParameter(request, prefix	+ "cmb2", length));
			String[] cmbWgt2 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt2", length));
			String[] cmb3 = (JSPUtil.getParameter(request, prefix	+ "cmb3", length));
			String[] cmbWgt3 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt3", length));
			String[] cmb4 = (JSPUtil.getParameter(request, prefix	+ "cmb4", length));
			String[] cmbWgt4 = (JSPUtil.getParameter(request, prefix	+ "cmb_wgt4", length));
			String[] bkgWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_vgm", length));
			String[] bkgVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_vol_vgm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiryOfficeCustomerListVO();
				if (fctWgt[i] != null)
					model.setFctWgt(fctWgt[i]);
				if (fctHc[i] != null)
					model.setFctHc(fctHc[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (fct45[i] != null)
					model.setFct45(fct45[i]);
				if (firmWgt[i] != null)
					model.setFirmWgt(firmWgt[i]);
				if (firmTeu[i] != null)
					model.setFirmTeu(firmTeu[i]);
				if (ord[i] != null)
					model.setOrd(ord[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fctRf[i] != null)
					model.setFctRf(fctRf[i]);
				if (firmRf[i] != null)
					model.setFirmRf(firmRf[i]);
				if (wait20[i] != null)
					model.setWait20(wait20[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wait45[i] != null)
					model.setWait45(wait45[i]);
				if (fcTtlTeu[i] != null)
					model.setFcTtlTeu(fcTtlTeu[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (waitRf[i] != null)
					model.setWaitRf(waitRf[i]);
				if (firm53[i] != null)
					model.setFirm53(firm53[i]);
				if (wait40[i] != null)
					model.setWait40(wait40[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (fctTeu[i] != null)
					model.setFctTeu(fctTeu[i]);
				if (firm20[i] != null)
					model.setFirm20(firm20[i]);
				if (flg[i] != null)
					model.setFlg(flg[i]);
				if (waitTeu[i] != null)
					model.setWaitTeu(waitTeu[i]);
				if (fct53[i] != null)
					model.setFct53(fct53[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (firmHc[i] != null)
					model.setFirmHc(firmHc[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (firm45[i] != null)
					model.setFirm45(firm45[i]);
				if (wait53[i] != null)
					model.setWait53(wait53[i]);
				if (waitWgt[i] != null)
					model.setWaitWgt(waitWgt[i]);
				if (firm40[i] != null)
					model.setFirm40(firm40[i]);
				if (waitHc[i] != null)
					model.setWaitHc(waitHc[i]);
				if (rvisCntrCustTpCd[i] != null)
					model.setRvisCntrCustTpCd(rvisCntrCustTpCd[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (smp[i] != null)
					model.setSmp(smp[i]);
				if (cmb[i] != null)
					model.setCmb(cmb[i]);
				if (cmbWgt[i] != null)
					model.setCmbWgt(cmbWgt[i]);
				if (cmb1[i] != null)
					model.setCmb1(cmb1[i]);
				if (cmbWgt1[i] != null)
					model.setCmbWgt1(cmbWgt1[i]);
				if (cmb2[i] != null)
					model.setCmb2(cmb2[i]);
				if (cmbWgt2[i] != null)
					model.setCmbWgt2(cmbWgt2[i]);
				if (cmb3[i] != null)
					model.setCmb3(cmb3[i]);
				if (cmbWgt3[i] != null)
					model.setCmbWgt3(cmbWgt3[i]);
				if (cmb4[i] != null)
					model.setCmb4(cmb4[i]);
				if (cmbWgt4[i] != null)
					model.setCmbWgt4(cmbWgt4[i]);
				if (bkgWgtVgm[i] != null) model.setBkgWgtVgm(bkgWgtVgm[i]);
				if (bkgVolVgm[i] != null) model.setBkgVolVgm(bkgVolVgm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiryOfficeCustomerListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiryOfficeCustomerListVO[]
	 */
	public SearchSpaceControlInquiryOfficeCustomerListVO[] getSearchSpaceControlInquiryOfficeCustomerListVOs(){
		SearchSpaceControlInquiryOfficeCustomerListVO[] vos = (SearchSpaceControlInquiryOfficeCustomerListVO[])models.toArray(new SearchSpaceControlInquiryOfficeCustomerListVO[models.size()]);
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
		this.fctWgt = this.fctWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctHc = this.fctHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct45 = this.fct45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firmWgt = this.firmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firmTeu = this.firmTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ord = this.ord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctRf = this.fctRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firmRf = this.firmRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wait20 = this.wait20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wait45 = this.wait45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTtlTeu = this.fcTtlTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitRf = this.waitRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firm53 = this.firm53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wait40 = this.wait40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctTeu = this.fctTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firm20 = this.firm20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg = this.flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitTeu = this.waitTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct53 = this.fct53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firmHc = this.firmHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firm45 = this.firm45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wait53 = this.wait53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitWgt = this.waitWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firm40 = this.firm40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waitHc = this.waitHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisCntrCustTpCd = this.rvisCntrCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smp = this.smp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb = this.cmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt = this.cmbWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb1 = this.cmb1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt1 = this.cmbWgt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb2 = this.cmb2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt2 = this.cmbWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb3 = this.cmb3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt3 = this.cmbWgt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb4 = this.cmb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbWgt4 = this.cmbWgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtVgm = this.bkgWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
