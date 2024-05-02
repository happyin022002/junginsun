/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSpaceControlInquiryContractorVO.java
*@FileTitle : SearchSpaceControlInquiryContractorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.29
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.06.29 이상용 
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

public class SearchSpaceControlInquiryContractorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiryContractorVO> models = new ArrayList<SearchSpaceControlInquiryContractorVO>();
	
	/* Column Info */
	private String fctWgt = null;
	/* Column Info */
	private String fctHc = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String fct45 = null;
	/* Column Info */
	private String frmTeu = null;
	/* Column Info */
	private String ord = null;
	/* Column Info */
	private String frm53 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fctRf = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wat45 = null;
	/* Column Info */
	private String wat20 = null;
	/* Column Info */
	private String frm45 = null;
	/* Column Info */
	private String watWgt = null;
	/* Column Info */
	private String fcTtlTeu = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String frmHc = null;
	/* Column Info */
	private String wat40 = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String fctTeu = null;
	/* Column Info */
	private String frmWgt = null;
	/* Column Info */
	private String flg = null;
	/* Column Info */
	private String frm40 = null;
	/* Column Info */
	private String fct53 = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String frm20 = null;
	/* Column Info */
	private String wat53 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String watHc = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String watTeu = null;
	/* Column Info */
	private String watRf = null;
	/* Column Info */
	private String frmRf = null;
	/* Column Info */
	private String bkgVol = null;
	/* Column Info */
	private String bkg20  = null;
	/* Column Info */
	private String bkg40  = null;
	/* Column Info */
	private String bkgHc  = null;
	/* Column Info */
	private String bkg45  = null;
	/* Column Info */
	private String bkg53  = null;
	/* Column Info */
	private String bkgRf  = null;
	/* Column Info */
	private String bkgWgt = null;
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
	private String bkgWgtVgm;
	/* Column Info */
	private String bkgVolVgm = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiryContractorVO() {}

	public SearchSpaceControlInquiryContractorVO(String ibflag, String pagerows, String flg, String ord, String custCntCd, String custSeq, String custCd, String custNm, String portCd, String ofcCd, String fcTtlTeu, String fctTeu, String fctHc, String fct45, String fct53, String fctRf, String fctWgt, String frmTeu, String frm20, String frm40, String frmHc, String frm45, String frm53, String frmRf, String frmWgt, String watTeu, String wat20, String wat40, String watHc, String wat45, String wat53, String watRf, String watWgt, String bkgVol, String bkg20, String bkg40, String bkgHc, String bkg45, String bkg53, String bkgRf, String bkgWgt, String rvisCntrCustTpCd, String custCtrlCd, String smp, String cmb, String cmbWgt, String cmb1, String cmbWgt1, String cmb2, String cmbWgt2, String cmb3, String cmbWgt3, String cmb4, String cmbWgt4,String bkgWgtVgm,String bkgVolVgm) {
		this.fctWgt = fctWgt;
		this.fctHc = fctHc;
		this.custNm = custNm;
		this.fct45 = fct45;
		this.frmTeu = frmTeu;
		this.ord = ord;
		this.frm53 = frm53;
		this.pagerows = pagerows;
		this.fctRf = fctRf;
		this.ibflag = ibflag;
		this.wat45 = wat45;
		this.wat20 = wat20;
		this.frm45 = frm45;
		this.watWgt = watWgt;
		this.fcTtlTeu = fcTtlTeu;
		this.portCd = portCd;
		this.frmHc = frmHc;
		this.wat40 = wat40;
		this.custCntCd = custCntCd;
		this.fctTeu = fctTeu;
		this.frmWgt = frmWgt;
		this.flg = flg;
		this.frm40 = frm40;
		this.fct53 = fct53;
		this.custSeq = custSeq;
		this.frm20 = frm20;
		this.wat53 = wat53;
		this.ofcCd = ofcCd;
		this.watHc = watHc;
		this.custCd = custCd;
		this.watTeu = watTeu;
		this.watRf = watRf;
		this.frmRf = frmRf;
		this.bkgVol = bkgVol;
		this.bkg20  = bkg20 ;
		this.bkg40  = bkg40 ;
		this.bkgHc  = bkgHc ;
		this.bkg45  = bkg45 ;
		this.bkg53  = bkg53 ;
		this.bkgRf  = bkgRf ;
		this.bkgWgt = bkgWgt;
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
		this.hashColumns.put("frm_teu", getFrmTeu());
		this.hashColumns.put("ord", getOrd());
		this.hashColumns.put("frm_53", getFrm53());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fct_rf", getFctRf());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wat_45", getWat45());
		this.hashColumns.put("wat_20", getWat20());
		this.hashColumns.put("frm_45", getFrm45());
		this.hashColumns.put("wat_wgt", getWatWgt());
		this.hashColumns.put("fc_ttl_teu", getFcTtlTeu());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("frm_hc", getFrmHc());
		this.hashColumns.put("wat_40", getWat40());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("fct_teu", getFctTeu());
		this.hashColumns.put("frm_wgt", getFrmWgt());
		this.hashColumns.put("flg", getFlg());
		this.hashColumns.put("frm_40", getFrm40());
		this.hashColumns.put("fct_53", getFct53());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("frm_20", getFrm20());
		this.hashColumns.put("wat_53", getWat53());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("wat_hc", getWatHc());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("wat_teu", getWatTeu());
		this.hashColumns.put("wat_rf", getWatRf());
		this.hashColumns.put("frm_rf", getFrmRf());
		this.hashColumns.put("bkg_vol", getBkgVol());
		this.hashColumns.put("bkg_20", getBkg20());
		this.hashColumns.put("bkg_40", getBkg40());
		this.hashColumns.put("bkg_hc", getBkgHc());
		this.hashColumns.put("bkg_45", getBkg45());
		this.hashColumns.put("bkg_53", getBkg53());
		this.hashColumns.put("bkg_rf", getBkgRf());
		this.hashColumns.put("bkg_wgt", getBkgWgt());
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
		this.hashFields.put("frm_teu", "frmTeu");
		this.hashFields.put("ord", "ord");
		this.hashFields.put("frm_53", "frm53");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fct_rf", "fctRf");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wat_45", "wat45");
		this.hashFields.put("wat_20", "wat20");
		this.hashFields.put("frm_45", "frm45");
		this.hashFields.put("wat_wgt", "watWgt");
		this.hashFields.put("fc_ttl_teu", "fcTtlTeu");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("frm_hc", "frmHc");
		this.hashFields.put("wat_40", "wat40");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("fct_teu", "fctTeu");
		this.hashFields.put("frm_wgt", "frmWgt");
		this.hashFields.put("flg", "flg");
		this.hashFields.put("frm_40", "frm40");
		this.hashFields.put("fct_53", "fct53");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("frm_20", "frm20");
		this.hashFields.put("wat_53", "wat53");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("wat_hc", "watHc");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("wat_teu", "watTeu");
		this.hashFields.put("wat_rf", "watRf");
		this.hashFields.put("frm_rf", "frmRf");
		this.hashFields.put("bkg_vol","bkgVol");
		this.hashFields.put("bkg_20", "bkg20");
		this.hashFields.put("bkg_40", "bkg40");
		this.hashFields.put("bkg_hc", "bkgHc");
		this.hashFields.put("bkg_45", "bkg45");
		this.hashFields.put("bkg_53", "bkg53");
		this.hashFields.put("bkg_rf", "bkgRf");
		this.hashFields.put("bkg_wgt","bkgWgt");
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
	 * @return frmTeu
	 */
	public String getFrmTeu() {
		return this.frmTeu;
	}
	
	/**
	 * Column Info
	 * @return ord
	 */
	public String getOrd() {
		return this.ord;
	}
	
	/**
	 * Column Info
	 * @return frm53
	 */
	public String getFrm53() {
		return this.frm53;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return wat45
	 */
	public String getWat45() {
		return this.wat45;
	}
	
	/**
	 * Column Info
	 * @return wat20
	 */
	public String getWat20() {
		return this.wat20;
	}
	
	/**
	 * Column Info
	 * @return frm45
	 */
	public String getFrm45() {
		return this.frm45;
	}
	
	/**
	 * Column Info
	 * @return watWgt
	 */
	public String getWatWgt() {
		return this.watWgt;
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
	 * @return frmHc
	 */
	public String getFrmHc() {
		return this.frmHc;
	}
	
	/**
	 * Column Info
	 * @return wat40
	 */
	public String getWat40() {
		return this.wat40;
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
	 * @return frmWgt
	 */
	public String getFrmWgt() {
		return this.frmWgt;
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
	 * @return frm40
	 */
	public String getFrm40() {
		return this.frm40;
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
	 * @return frm20
	 */
	public String getFrm20() {
		return this.frm20;
	}
	
	/**
	 * Column Info
	 * @return wat53
	 */
	public String getWat53() {
		return this.wat53;
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
	 * @return watHc
	 */
	public String getWatHc() {
		return this.watHc;
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
	 * @return watTeu
	 */
	public String getWatTeu() {
		return this.watTeu;
	}
	
	/**
	 * Column Info
	 * @return watRf
	 */
	public String getWatRf() {
		return this.watRf;
	}
	
	/**
	 * Column Info
	 * @return frmRf
	 */
	public String getFrmRf() {
		return this.frmRf;
	}
	
	/**
	 * Column Info
	 * @return bkgVol
	 */
	public String getBkgVol() {
		return this.bkgVol;
	}
	
	/**
	 * Column Info
	 * @return bkg20
	 */
	public String getBkg20() {
		return this.bkg20;
	}
	
	/**
	 * Column Info
	 * @return bkg40
	 */
	public String getBkg40() {
		return this.bkg40;
	}
	
	/**
	 * Column Info
	 * @return bkgHc
	 */
	public String getBkgHc() {
		return this.bkgHc;
	}
	
	/**
	 * Column Info
	 * @return bkg45
	 */
	public String getBkg45() {
		return this.bkg45;
	}
	
	/**
	 * Column Info
	 * @return bkg53
	 */
	public String getBkg53() {
		return this.bkg53;
	}
	
	/**
	 * Column Info
	 * @return bkgRf
	 */
	public String getBkgRf() {
		return this.bkgRf;
	}
	
	/**
	 * Column Info
	 * @return bkgWgt
	 */
	public String getBkgWgt() {
		return this.bkgWgt;
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
	 * @param frmTeu
	 */
	public void setFrmTeu(String frmTeu) {
		this.frmTeu = frmTeu;
	}
	
	/**
	 * Column Info
	 * @param ord
	 */
	public void setOrd(String ord) {
		this.ord = ord;
	}
	
	/**
	 * Column Info
	 * @param frm53
	 */
	public void setFrm53(String frm53) {
		this.frm53 = frm53;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param wat45
	 */
	public void setWat45(String wat45) {
		this.wat45 = wat45;
	}
	
	/**
	 * Column Info
	 * @param wat20
	 */
	public void setWat20(String wat20) {
		this.wat20 = wat20;
	}
	
	/**
	 * Column Info
	 * @param frm45
	 */
	public void setFrm45(String frm45) {
		this.frm45 = frm45;
	}
	
	/**
	 * Column Info
	 * @param watWgt
	 */
	public void setWatWgt(String watWgt) {
		this.watWgt = watWgt;
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
	 * @param frmHc
	 */
	public void setFrmHc(String frmHc) {
		this.frmHc = frmHc;
	}
	
	/**
	 * Column Info
	 * @param wat40
	 */
	public void setWat40(String wat40) {
		this.wat40 = wat40;
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
	 * @param frmWgt
	 */
	public void setFrmWgt(String frmWgt) {
		this.frmWgt = frmWgt;
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
	 * @param frm40
	 */
	public void setFrm40(String frm40) {
		this.frm40 = frm40;
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
	 * @param frm20
	 */
	public void setFrm20(String frm20) {
		this.frm20 = frm20;
	}
	
	/**
	 * Column Info
	 * @param wat53
	 */
	public void setWat53(String wat53) {
		this.wat53 = wat53;
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
	 * @param watHc
	 */
	public void setWatHc(String watHc) {
		this.watHc = watHc;
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
	 * @param watTeu
	 */
	public void setWatTeu(String watTeu) {
		this.watTeu = watTeu;
	}
	
	/**
	 * Column Info
	 * @param watRf
	 */
	public void setWatRf(String watRf) {
		this.watRf = watRf;
	}
	
	/**
	 * Column Info
	 * @param frmRf
	 */
	public void setFrmRf(String frmRf) {
		this.frmRf = frmRf;
	}
	
	/**
	 * Column Info
	 * @param bkgVol
	 */
	public void setBkgVol(String bkgVol) {
		this.bkgVol = bkgVol;
	}
	
	/**
	 * Column Info
	 * @param bkg20
	 */
	public void setBkg20(String bkg20) {
		this.bkg20 = bkg20;
	}
	
	/**
	 * Column Info
	 * @param bkg40
	 */
	public void setBkg40(String bkg40) {
		this.bkg40 = bkg40;
	}
	
	/**
	 * Column Info
	 * @param bkgHc
	 */
	public void setBkgHc(String bkgHc) {
		this.bkgHc = bkgHc;
	}
	
	/**
	 * Column Info
	 * @param bkg45
	 */
	public void setBkg45(String bkg45) {
		this.bkg45 = bkg45;
	}
	
	/**
	 * Column Info
	 * @param bkg53
	 */
	public void setBkg53(String bkg53) {
		this.bkg53 = bkg53;
	}
	
	/**
	 * Column Info
	 * @param bkgRf
	 */
	public void setBkgRf(String bkgRf) {
		this.bkgRf = bkgRf;
	}
	
	/**
	 * Column Info
	 * @param bkgWgt
	 */
	public void setBkgWgt(String bkgWgt) {
		this.bkgWgt = bkgWgt;
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
		setFrmTeu(JSPUtil.getParameter(request, prefix + "frm_teu", ""));
		setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
		setFrm53(JSPUtil.getParameter(request, prefix + "frm_53", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFctRf(JSPUtil.getParameter(request, prefix + "fct_rf", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWat45(JSPUtil.getParameter(request, prefix + "wat_45", ""));
		setWat20(JSPUtil.getParameter(request, prefix + "wat_20", ""));
		setFrm45(JSPUtil.getParameter(request, prefix + "frm_45", ""));
		setWatWgt(JSPUtil.getParameter(request, prefix + "wat_wgt", ""));
		setFcTtlTeu(JSPUtil.getParameter(request, prefix + "fc_ttl_teu", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setFrmHc(JSPUtil.getParameter(request, prefix + "frm_hc", ""));
		setWat40(JSPUtil.getParameter(request, prefix + "wat_40", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setFctTeu(JSPUtil.getParameter(request, prefix + "fct_teu", ""));
		setFrmWgt(JSPUtil.getParameter(request, prefix + "frm_wgt", ""));
		setFlg(JSPUtil.getParameter(request, prefix + "flg", ""));
		setFrm40(JSPUtil.getParameter(request, prefix + "frm_40", ""));
		setFct53(JSPUtil.getParameter(request, prefix + "fct_53", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFrm20(JSPUtil.getParameter(request, prefix + "frm_20", ""));
		setWat53(JSPUtil.getParameter(request, prefix + "wat_53", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setWatHc(JSPUtil.getParameter(request, prefix + "wat_hc", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setWatTeu(JSPUtil.getParameter(request, prefix + "wat_teu", ""));
		setWatRf(JSPUtil.getParameter(request, prefix + "wat_rf", ""));
		setFrmRf(JSPUtil.getParameter(request, prefix + "frm_rf", ""));
		setBkgVol(JSPUtil.getParameter(request, prefix + "bkg_vol", ""));
		setBkg20 (JSPUtil.getParameter(request, prefix + "bkg_20", ""));
		setBkg40 (JSPUtil.getParameter(request, prefix + "bkg_40", ""));
		setBkgHc (JSPUtil.getParameter(request, prefix + "bkg_hc", ""));
		setBkg45 (JSPUtil.getParameter(request, prefix + "bkg_45", ""));
		setBkg53 (JSPUtil.getParameter(request, prefix + "bkg_53", ""));
		setBkgRf (JSPUtil.getParameter(request, prefix + "bkg_rf", ""));
		setBkgWgt(JSPUtil.getParameter(request, prefix + "bkg_wgt", ""));
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
	 * @return SearchSpaceControlInquiryContractorVO[]
	 */
	public SearchSpaceControlInquiryContractorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiryContractorVO[]
	 */
	public SearchSpaceControlInquiryContractorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiryContractorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fctWgt = (JSPUtil.getParameter(request, prefix	+ "fct_wgt", length));
			String[] fctHc = (JSPUtil.getParameter(request, prefix	+ "fct_hc", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] fct45 = (JSPUtil.getParameter(request, prefix	+ "fct_45", length));
			String[] frmTeu = (JSPUtil.getParameter(request, prefix	+ "frm_teu", length));
			String[] ord = (JSPUtil.getParameter(request, prefix	+ "ord", length));
			String[] frm53 = (JSPUtil.getParameter(request, prefix	+ "frm_53", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fctRf = (JSPUtil.getParameter(request, prefix	+ "fct_rf", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wat45 = (JSPUtil.getParameter(request, prefix	+ "wat_45", length));
			String[] wat20 = (JSPUtil.getParameter(request, prefix	+ "wat_20", length));
			String[] frm45 = (JSPUtil.getParameter(request, prefix	+ "frm_45", length));
			String[] watWgt = (JSPUtil.getParameter(request, prefix	+ "wat_wgt", length));
			String[] fcTtlTeu = (JSPUtil.getParameter(request, prefix	+ "fc_ttl_teu", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] frmHc = (JSPUtil.getParameter(request, prefix	+ "frm_hc", length));
			String[] wat40 = (JSPUtil.getParameter(request, prefix	+ "wat_40", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] fctTeu = (JSPUtil.getParameter(request, prefix	+ "fct_teu", length));
			String[] frmWgt = (JSPUtil.getParameter(request, prefix	+ "frm_wgt", length));
			String[] flg = (JSPUtil.getParameter(request, prefix	+ "flg", length));
			String[] frm40 = (JSPUtil.getParameter(request, prefix	+ "frm_40", length));
			String[] fct53 = (JSPUtil.getParameter(request, prefix	+ "fct_53", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] frm20 = (JSPUtil.getParameter(request, prefix	+ "frm_20", length));
			String[] wat53 = (JSPUtil.getParameter(request, prefix	+ "wat_53", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] watHc = (JSPUtil.getParameter(request, prefix	+ "wat_hc", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] watTeu = (JSPUtil.getParameter(request, prefix	+ "wat_teu", length));
			String[] watRf = (JSPUtil.getParameter(request, prefix	+ "wat_rf", length));
			String[] frmRf = (JSPUtil.getParameter(request, prefix	+ "frm_rf", length));
			String[] bkgVol = (JSPUtil.getParameter(request, prefix + "bkg_vol",length));
			String[] bkg20  = (JSPUtil.getParameter(request, prefix + "bkg_20", length));
			String[] bkg40  = (JSPUtil.getParameter(request, prefix + "bkg_40", length));
			String[] bkgHc  = (JSPUtil.getParameter(request, prefix + "bkg_hc", length));
			String[] bkg45  = (JSPUtil.getParameter(request, prefix + "bkg_45", length));
			String[] bkg53  = (JSPUtil.getParameter(request, prefix + "bkg_53", length));
			String[] bkgRf  = (JSPUtil.getParameter(request, prefix + "bkg_rf", length));
			String[] bkgWgt = (JSPUtil.getParameter(request, prefix + "bkg_wgt",length));
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
				model = new SearchSpaceControlInquiryContractorVO();
				if (fctWgt[i] != null)
					model.setFctWgt(fctWgt[i]);
				if (fctHc[i] != null)
					model.setFctHc(fctHc[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (fct45[i] != null)
					model.setFct45(fct45[i]);
				if (frmTeu[i] != null)
					model.setFrmTeu(frmTeu[i]);
				if (ord[i] != null)
					model.setOrd(ord[i]);
				if (frm53[i] != null)
					model.setFrm53(frm53[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fctRf[i] != null)
					model.setFctRf(fctRf[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wat45[i] != null)
					model.setWat45(wat45[i]);
				if (wat20[i] != null)
					model.setWat20(wat20[i]);
				if (frm45[i] != null)
					model.setFrm45(frm45[i]);
				if (watWgt[i] != null)
					model.setWatWgt(watWgt[i]);
				if (fcTtlTeu[i] != null)
					model.setFcTtlTeu(fcTtlTeu[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (frmHc[i] != null)
					model.setFrmHc(frmHc[i]);
				if (wat40[i] != null)
					model.setWat40(wat40[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (fctTeu[i] != null)
					model.setFctTeu(fctTeu[i]);
				if (frmWgt[i] != null)
					model.setFrmWgt(frmWgt[i]);
				if (flg[i] != null)
					model.setFlg(flg[i]);
				if (frm40[i] != null)
					model.setFrm40(frm40[i]);
				if (fct53[i] != null)
					model.setFct53(fct53[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (frm20[i] != null)
					model.setFrm20(frm20[i]);
				if (wat53[i] != null)
					model.setWat53(wat53[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (watHc[i] != null)
					model.setWatHc(watHc[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (watTeu[i] != null)
					model.setWatTeu(watTeu[i]);
				if (watRf[i] != null)
					model.setWatRf(watRf[i]);
				if (frmRf[i] != null)
					model.setFrmRf(frmRf[i]);
				if (bkgVol[i] != null)
					model.setBkgVol(bkgVol[i]);
				if (bkg20 [i] != null)
					model.setBkg20(bkg20[i]);
				if (bkg40 [i] != null)
					model.setBkg40(bkg40[i]);
				if (bkgHc [i] != null)
					model.setBkgHc(bkgHc[i]);
				if (bkg45 [i] != null)
					model.setBkg45(bkg45[i]);
				if (bkg53 [i] != null)
					model.setBkg53(bkg53[i]);
				if (bkgRf [i] != null)
					model.setBkgRf(bkgRf[i]);
				if (bkgWgt[i] != null)
					model.setBkgWgt(bkgWgt[i]);
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
		return getSearchSpaceControlInquiryContractorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiryContractorVO[]
	 */
	public SearchSpaceControlInquiryContractorVO[] getSearchSpaceControlInquiryContractorVOs(){
		SearchSpaceControlInquiryContractorVO[] vos = (SearchSpaceControlInquiryContractorVO[])models.toArray(new SearchSpaceControlInquiryContractorVO[models.size()]);
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
		this.frmTeu = this.frmTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ord = this.ord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frm53 = this.frm53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctRf = this.fctRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wat45 = this.wat45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wat20 = this.wat20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frm45 = this.frm45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.watWgt = this.watWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTtlTeu = this.fcTtlTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmHc = this.frmHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wat40 = this.wat40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctTeu = this.fctTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmWgt = this.frmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg = this.flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frm40 = this.frm40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct53 = this.fct53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frm20 = this.frm20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wat53 = this.wat53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.watHc = this.watHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.watTeu = this.watTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.watRf = this.watRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRf = this.frmRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVol = this.bkgVol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20  = this.bkg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40  = this.bkg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc  = this.bkgHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg45  = this.bkg45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg53  = this.bkg53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf  = this.bkgRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgt = this.bkgWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
