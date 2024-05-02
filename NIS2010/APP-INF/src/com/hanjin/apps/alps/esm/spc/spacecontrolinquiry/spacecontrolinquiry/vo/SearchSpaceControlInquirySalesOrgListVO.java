/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSpaceControlInquirySalesOrgListVO.java
*@FileTitle : SearchSpaceControlInquirySalesOrgListVO
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

public class SearchSpaceControlInquirySalesOrgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquirySalesOrgListVO> models = new ArrayList<SearchSpaceControlInquirySalesOrgListVO>();
	
	/* Column Info */
	private String fctWgt = null;
	/* Column Info */
	private String fctHc = null;
	/* Column Info */
	private String fct45 = null;
	/* Column Info */
	private String qtaVol = null;
	/* Column Info */
	private String alcVol = null;
	/* Column Info */
	private String bkg53 = null;
	/* Column Info */
	private String frm53 = null;
	/* Column Info */
	private String watVol = null;
	/* Column Info */
	private String frmVol = null;
	/* Column Info */
	private String fctRf = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wat45 = null;
	/* Column Info */
	private String alc53 = null;
	/* Column Info */
	private String wat20 = null;
	/* Column Info */
	private String alcWgt = null;
	/* Column Info */
	private String frm45 = null;
	/* Column Info */
	private String watWgt = null;
	/* Column Info */
	private String fcTtlTeu = null;
	/* Column Info */
	private String frmHc = null;
	/* Column Info */
	private String wat40 = null;
	/* Column Info */
	private String bkg20 = null;
	/* Column Info */
	private String bkgHc = null;
	/* Column Info */
	private String iocTsCd = null;
	/* Column Info */
	private String frmWgt = null;
	/* Column Info */
	private String fctVol = null;
	/* Column Info */
	private String bkg40 = null;
	/* Column Info */
	private String frm40 = null;
	/* Column Info */
	private String fct53 = null;
	/* Column Info */
	private String frm20 = null;
	/* Column Info */
	private String wat53 = null;
	/* Column Info */
	private String bkg45 = null;
	/* Column Info */
	private String bkgWgt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String watHc = null;
	/* Column Info */
	private String alcHc = null;
	/* Column Info */
	private String bkgRf = null;
	/* Column Info */
	private String alcRf = null;
	/* Column Info */
	private String watRf = null;
	/* Column Info */
	private String frmRf = null;
	/* Column Info */
	private String bkgVol = null;
	/* Column Info */
	private String alc45 = null;
	/* Column Info */
	private String ctrlFlg = null;
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
	private String usaBkgModCd = null;
	/* Column Info */
	private String custAcct = null;	
	/* Column Info */
	private String fctD2 = null;	
	/* Column Info */
	private String fctD4 = null;	
	/* Column Info */
	private String fctRd = null;	
	/* Column Info */
	private String alcD2 = null;	
	/* Column Info */
	private String alcD4 = null;	
	/* Column Info */
	private String alcRd = null;	
	/* Column Info */
	private String bkgD2 = null;	
	/* Column Info */
	private String bkgD4 = null;	
	/* Column Info */
	private String bkgRd = null;	
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String bkgWgtVgm;
	/* Column Info */
	private String bkgVolVgm = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquirySalesOrgListVO() {}

	public SearchSpaceControlInquirySalesOrgListVO(String ibflag, String pagerows, String iocTsCd, String ofcCd, String qtaVol, String fcTtlTeu, String fctVol, String fctHc, String fct45, String fct53, String fctRf, String fctWgt, String alcVol, String alcHc, String alc45, String alc53, String alcRf, String alcWgt, String frmVol, String frm20, String frm40, String frmHc, String frm45, String frm53, String frmRf, String frmWgt, String watVol, String wat20, String wat40, String watHc, String wat45, String wat53, String watRf, String watWgt, String bkgVol, String bkg20, String bkg40, String bkgHc, String bkg45, String bkg53, String bkgRf, String bkgWgt, String ctrlFlg, String custCtrlCd, String smp, String cmb, String cmbWgt, String cmb1, String cmbWgt1, String cmb2, String cmbWgt2, String cmb3, String cmbWgt3, String cmb4, String cmbWgt4, String usaBkgModCd, String custAcct, String fctD2, String fctD4, String fctRd, String alcD2, String alcD4, String alcRd, String bkgD2, String bkgD4, String bkgRd, String custLglEngNm,String bkgWgtVgm,String bkgVolVgm) {
		this.fctWgt = fctWgt;
		this.fctHc = fctHc;
		this.fct45 = fct45;
		this.qtaVol = qtaVol;
		this.alcVol = alcVol;
		this.bkg53 = bkg53;
		this.frm53 = frm53;
		this.watVol = watVol;
		this.frmVol = frmVol;
		this.fctRf = fctRf;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.wat45 = wat45;
		this.alc53 = alc53;
		this.wat20 = wat20;
		this.alcWgt = alcWgt;
		this.frm45 = frm45;
		this.watWgt = watWgt;
		this.fcTtlTeu = fcTtlTeu;
		this.frmHc = frmHc;
		this.wat40 = wat40;
		this.bkg20 = bkg20;
		this.bkgHc = bkgHc;
		this.iocTsCd = iocTsCd;
		this.frmWgt = frmWgt;
		this.fctVol = fctVol;
		this.bkg40 = bkg40;
		this.frm40 = frm40;
		this.fct53 = fct53;
		this.frm20 = frm20;
		this.wat53 = wat53;
		this.bkg45 = bkg45;
		this.bkgWgt = bkgWgt;
		this.ofcCd = ofcCd;
		this.watHc = watHc;
		this.alcHc = alcHc;
		this.bkgRf = bkgRf;
		this.alcRf = alcRf;
		this.watRf = watRf;
		this.frmRf = frmRf;
		this.bkgVol = bkgVol;
		this.alc45 = alc45;
		this.ctrlFlg = ctrlFlg;
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
		this.usaBkgModCd = usaBkgModCd;
		this.custAcct = custAcct;
		this.fctD2 = fctD2;
		this.fctD4 = fctD4;
		this.fctRd = fctRd;		
		this.alcD2 = alcD2;
		this.alcD4 = alcD4;
		this.alcRd = alcRd;
		this.bkgD2 = bkgD2;
		this.bkgD4 = bkgD4;
		this.bkgRd = bkgRd;		
		this.custLglEngNm = custLglEngNm;
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
		this.hashColumns.put("fct_45", getFct45());
		this.hashColumns.put("qta_vol", getQtaVol());
		this.hashColumns.put("alc_vol", getAlcVol());
		this.hashColumns.put("bkg_53", getBkg53());
		this.hashColumns.put("frm_53", getFrm53());
		this.hashColumns.put("wat_vol", getWatVol());
		this.hashColumns.put("frm_vol", getFrmVol());
		this.hashColumns.put("fct_rf", getFctRf());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wat_45", getWat45());
		this.hashColumns.put("alc_53", getAlc53());
		this.hashColumns.put("wat_20", getWat20());
		this.hashColumns.put("alc_wgt", getAlcWgt());
		this.hashColumns.put("frm_45", getFrm45());
		this.hashColumns.put("wat_wgt", getWatWgt());
		this.hashColumns.put("fc_ttl_teu", getFcTtlTeu());
		this.hashColumns.put("frm_hc", getFrmHc());
		this.hashColumns.put("wat_40", getWat40());
		this.hashColumns.put("bkg_20", getBkg20());
		this.hashColumns.put("bkg_hc", getBkgHc());
		this.hashColumns.put("ioc_ts_cd", getIocTsCd());
		this.hashColumns.put("frm_wgt", getFrmWgt());
		this.hashColumns.put("fct_vol", getFctVol());
		this.hashColumns.put("bkg_40", getBkg40());
		this.hashColumns.put("frm_40", getFrm40());
		this.hashColumns.put("fct_53", getFct53());
		this.hashColumns.put("frm_20", getFrm20());
		this.hashColumns.put("wat_53", getWat53());
		this.hashColumns.put("bkg_45", getBkg45());
		this.hashColumns.put("bkg_wgt", getBkgWgt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("wat_hc", getWatHc());
		this.hashColumns.put("alc_hc", getAlcHc());
		this.hashColumns.put("bkg_rf", getBkgRf());
		this.hashColumns.put("alc_rf", getAlcRf());
		this.hashColumns.put("wat_rf", getWatRf());
		this.hashColumns.put("frm_rf", getFrmRf());
		this.hashColumns.put("bkg_vol", getBkgVol());
		this.hashColumns.put("alc_45", getAlc45());
		this.hashColumns.put("ctrl_flg", getCtrlFlg());
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
		this.hashColumns.put("usa_bkg_mod_cd", getUsaBkgModCd());
		this.hashColumns.put("cust_acct", getCustAcct());
		this.hashColumns.put("fct_d2", getFctD2());
		this.hashColumns.put("fct_d4", getFctD4());
		this.hashColumns.put("fct_rd", getFctRd());		
		this.hashColumns.put("alc_d2", getAlcD2());
		this.hashColumns.put("alc_d4", getAlcD4());
		this.hashColumns.put("alc_rd", getAlcRd());
		this.hashColumns.put("bkg_d2", getBkgD2());
		this.hashColumns.put("bkg_d4", getBkgD4());
		this.hashColumns.put("bkg_rd", getBkgRd());		
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());		
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
		this.hashFields.put("fct_45", "fct45");
		this.hashFields.put("qta_vol", "qtaVol");
		this.hashFields.put("alc_vol", "alcVol");
		this.hashFields.put("bkg_53", "bkg53");
		this.hashFields.put("frm_53", "frm53");
		this.hashFields.put("wat_vol", "watVol");
		this.hashFields.put("frm_vol", "frmVol");
		this.hashFields.put("fct_rf", "fctRf");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wat_45", "wat45");
		this.hashFields.put("alc_53", "alc53");
		this.hashFields.put("wat_20", "wat20");
		this.hashFields.put("alc_wgt", "alcWgt");
		this.hashFields.put("frm_45", "frm45");
		this.hashFields.put("wat_wgt", "watWgt");
		this.hashFields.put("fc_ttl_teu", "fcTtlTeu");
		this.hashFields.put("frm_hc", "frmHc");
		this.hashFields.put("wat_40", "wat40");
		this.hashFields.put("bkg_20", "bkg20");
		this.hashFields.put("bkg_hc", "bkgHc");
		this.hashFields.put("ioc_ts_cd", "iocTsCd");
		this.hashFields.put("frm_wgt", "frmWgt");
		this.hashFields.put("fct_vol", "fctVol");
		this.hashFields.put("bkg_40", "bkg40");
		this.hashFields.put("frm_40", "frm40");
		this.hashFields.put("fct_53", "fct53");
		this.hashFields.put("frm_20", "frm20");
		this.hashFields.put("wat_53", "wat53");
		this.hashFields.put("bkg_45", "bkg45");
		this.hashFields.put("bkg_wgt", "bkgWgt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("wat_hc", "watHc");
		this.hashFields.put("alc_hc", "alcHc");
		this.hashFields.put("bkg_rf", "bkgRf");
		this.hashFields.put("alc_rf", "alcRf");
		this.hashFields.put("wat_rf", "watRf");
		this.hashFields.put("frm_rf", "frmRf");
		this.hashFields.put("bkg_vol", "bkgVol");
		this.hashFields.put("alc_45", "alc45");
		this.hashFields.put("ctrl_flg", "ctrlFlg");
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
		this.hashFields.put("usa_bkg_mod_cd", "usaBkgModCd");
		this.hashFields.put("cust_acct", "custAcct");
		this.hashFields.put("fct_d2", "fctD2");
		this.hashFields.put("fct_d4", "fctD4");
		this.hashFields.put("fct_rd", "fctRd");		
		this.hashFields.put("alc_d2", "alcD2");
		this.hashFields.put("alc_d4", "alcD4");
		this.hashFields.put("alc_rd", "alcRd");
		this.hashFields.put("bkg_d2", "bkgD2");
		this.hashFields.put("bkg_d4", "bkgD4");
		this.hashFields.put("bkg_rd", "bkgRd");		
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");	
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
	 * @return fct45
	 */
	public String getFct45() {
		return this.fct45;
	}
	
	/**
	 * Column Info
	 * @return qtaVol
	 */
	public String getQtaVol() {
		return this.qtaVol;
	}
	
	/**
	 * Column Info
	 * @return alcVol
	 */
	public String getAlcVol() {
		return this.alcVol;
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
	 * @return frm53
	 */
	public String getFrm53() {
		return this.frm53;
	}
	
	/**
	 * Column Info
	 * @return watVol
	 */
	public String getWatVol() {
		return this.watVol;
	}
	
	/**
	 * Column Info
	 * @return frmVol
	 */
	public String getFrmVol() {
		return this.frmVol;
	}
	
	/**
	 * Column Info
	 * @return fctRf
	 */
	public String getFctRf() {
		return this.fctRf;
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
	 * @return wat45
	 */
	public String getWat45() {
		return this.wat45;
	}
	
	/**
	 * Column Info
	 * @return alc53
	 */
	public String getAlc53() {
		return this.alc53;
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
	 * @return alcWgt
	 */
	public String getAlcWgt() {
		return this.alcWgt;
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
	 * @return bkg20
	 */
	public String getBkg20() {
		return this.bkg20;
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
	 * @return iocTsCd
	 */
	public String getIocTsCd() {
		return this.iocTsCd;
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
	 * @return fctVol
	 */
	public String getFctVol() {
		return this.fctVol;
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
	 * @return bkg45
	 */
	public String getBkg45() {
		return this.bkg45;
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
	 * @return alcHc
	 */
	public String getAlcHc() {
		return this.alcHc;
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
	 * @return alcRf
	 */
	public String getAlcRf() {
		return this.alcRf;
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
	 * @return alc45
	 */
	public String getAlc45() {
		return this.alc45;
	}
	
	/**
	 * Column Info
	 * @return ctrlFlg
	 */
	public String getCtrlFlg() {
		return this.ctrlFlg;
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
	 * @return usaBkgModCd
	 */
	public String getUsaBkgModCd() {
		return this.usaBkgModCd;
	}
		
	/**
	 * Column Info
	 * @return custAcct
	 */
	public String getCustAcct() {
		return this.custAcct;
	}

	/**
	 * Column Info
	 * @return fctD2
	 */
	public String getFctD2() {
		return this.fctD2;
	}

	/**
	 * Column Info
	 * @return fctD4
	 */
	public String getFctD4() {
		return this.fctD4;
	}

	/**
	 * Column Info
	 * @return fctRd
	 */
	public String getFctRd() {
		return this.fctRd;
	}
	
	/**
	 * Column Info
	 * @return alcD2
	 */
	public String getAlcD2() {
		return this.alcD2;
	}

	/**
	 * Column Info
	 * @return alcD4
	 */
	public String getAlcD4() {
		return this.alcD4;
	}

	/**
	 * Column Info
	 * @return alcRd
	 */
	public String getAlcRd() {
		return this.alcRd;
	}

	/**
	 * Column Info
	 * @return bkgD2
	 */
	public String getBkgD2() {
		return this.bkgD2;
	}

	/**
	 * Column Info
	 * @return bkgD4
	 */
	public String getBkgD4() {
		return this.bkgD4;
	}

	/**
	 * Column Info
	 * @return bkgRd
	 */
	public String getBkgRd() {
		return this.bkgRd;
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
	 * @param fct45
	 */
	public void setFct45(String fct45) {
		this.fct45 = fct45;
	}
	
	/**
	 * Column Info
	 * @param qtaVol
	 */
	public void setQtaVol(String qtaVol) {
		this.qtaVol = qtaVol;
	}
	
	/**
	 * Column Info
	 * @param alcVol
	 */
	public void setAlcVol(String alcVol) {
		this.alcVol = alcVol;
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
	 * @param frm53
	 */
	public void setFrm53(String frm53) {
		this.frm53 = frm53;
	}
	
	/**
	 * Column Info
	 * @param watVol
	 */
	public void setWatVol(String watVol) {
		this.watVol = watVol;
	}
	
	/**
	 * Column Info
	 * @param frmVol
	 */
	public void setFrmVol(String frmVol) {
		this.frmVol = frmVol;
	}
	
	/**
	 * Column Info
	 * @param fctRf
	 */
	public void setFctRf(String fctRf) {
		this.fctRf = fctRf;
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
	 * @param wat45
	 */
	public void setWat45(String wat45) {
		this.wat45 = wat45;
	}
	
	/**
	 * Column Info
	 * @param alc53
	 */
	public void setAlc53(String alc53) {
		this.alc53 = alc53;
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
	 * @param alcWgt
	 */
	public void setAlcWgt(String alcWgt) {
		this.alcWgt = alcWgt;
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
	 * @param bkg20
	 */
	public void setBkg20(String bkg20) {
		this.bkg20 = bkg20;
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
	 * @param iocTsCd
	 */
	public void setIocTsCd(String iocTsCd) {
		this.iocTsCd = iocTsCd;
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
	 * @param fctVol
	 */
	public void setFctVol(String fctVol) {
		this.fctVol = fctVol;
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
	 * @param bkg45
	 */
	public void setBkg45(String bkg45) {
		this.bkg45 = bkg45;
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
	 * @param alcHc
	 */
	public void setAlcHc(String alcHc) {
		this.alcHc = alcHc;
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
	 * @param alcRf
	 */
	public void setAlcRf(String alcRf) {
		this.alcRf = alcRf;
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
	 * @param alc45
	 */
	public void setAlc45(String alc45) {
		this.alc45 = alc45;
	}
	
	/**
	 * Column Info
	 * @param ctrlFlg
	 */
	public void setCtrlFlg(String ctrlFlg) {
		this.ctrlFlg = ctrlFlg;
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
	 * Column Info
	 * @param usaBkgModCd
	 */
	public void setUsaBkgModCd(String usaBkgModCd) {
		this.usaBkgModCd = usaBkgModCd;
	}
		
	/**
	 * Column Info
	 * @param custAcct
	 */
	public void setCustAcct(String custAcct) {
		this.custAcct = custAcct;
	}

	/**
	 * Column Info
	 * @param fctD2
	 */
	public void setFctD2(String fctD2) {
		this.fctD2 = fctD2;
	}

	/**
	 * Column Info
	 * @param fctD4
	 */
	public void setFctD4(String fctD4) {
		this.fctD4 = fctD4;
	}

	/**
	 * Column Info
	 * @param fctRd
	 */
	public void setFctRd(String fctRd) {
		this.fctRd = fctRd;
	}
	
	/**
	 * Column Info
	 * @param alcD2
	 */
	public void setAlcD2(String alcD2) {
		this.alcD2 = alcD2;
	}

	/**
	 * Column Info
	 * @param alcD4
	 */
	public void setAlcD4(String alcD4) {
		this.alcD4 = alcD4;
	}

	/**
	 * Column Info
	 * @param alcRd
	 */
	public void setAlcRd(String alcRd) {
		this.alcRd = alcRd;
	}

	/**
	 * Column Info
	 * @param bkgD2
	 */
	public void setBkgD2(String bkgD2) {
		this.bkgD2 = bkgD2;
	}

	/**
	 * Column Info
	 * @param bkgD4
	 */
	public void setBkgD4(String bkgD4) {
		this.bkgD4 = bkgD4;
	}

	public String getCustLglEngNm() {
		return custLglEngNm;
	}

	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}

	/**
	 * Column Info
	 * @param bkgRd
	 */
	public void setBkgRd(String bkgRd) {
		this.bkgRd = bkgRd;
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
		setFct45(JSPUtil.getParameter(request, prefix + "fct_45", ""));
		setQtaVol(JSPUtil.getParameter(request, prefix + "qta_vol", ""));
		setAlcVol(JSPUtil.getParameter(request, prefix + "alc_vol", ""));
		setBkg53(JSPUtil.getParameter(request, prefix + "bkg_53", ""));
		setFrm53(JSPUtil.getParameter(request, prefix + "frm_53", ""));
		setWatVol(JSPUtil.getParameter(request, prefix + "wat_vol", ""));
		setFrmVol(JSPUtil.getParameter(request, prefix + "frm_vol", ""));
		setFctRf(JSPUtil.getParameter(request, prefix + "fct_rf", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWat45(JSPUtil.getParameter(request, prefix + "wat_45", ""));
		setAlc53(JSPUtil.getParameter(request, prefix + "alc_53", ""));
		setWat20(JSPUtil.getParameter(request, prefix + "wat_20", ""));
		setAlcWgt(JSPUtil.getParameter(request, prefix + "alc_wgt", ""));
		setFrm45(JSPUtil.getParameter(request, prefix + "frm_45", ""));
		setWatWgt(JSPUtil.getParameter(request, prefix + "wat_wgt", ""));
		setFcTtlTeu(JSPUtil.getParameter(request, prefix + "fc_ttl_teu", ""));
		setFrmHc(JSPUtil.getParameter(request, prefix + "frm_hc", ""));
		setWat40(JSPUtil.getParameter(request, prefix + "wat_40", ""));
		setBkg20(JSPUtil.getParameter(request, prefix + "bkg_20", ""));
		setBkgHc(JSPUtil.getParameter(request, prefix + "bkg_hc", ""));
		setIocTsCd(JSPUtil.getParameter(request, prefix + "ioc_ts_cd", ""));
		setFrmWgt(JSPUtil.getParameter(request, prefix + "frm_wgt", ""));
		setFctVol(JSPUtil.getParameter(request, prefix + "fct_vol", ""));
		setBkg40(JSPUtil.getParameter(request, prefix + "bkg_40", ""));
		setFrm40(JSPUtil.getParameter(request, prefix + "frm_40", ""));
		setFct53(JSPUtil.getParameter(request, prefix + "fct_53", ""));
		setFrm20(JSPUtil.getParameter(request, prefix + "frm_20", ""));
		setWat53(JSPUtil.getParameter(request, prefix + "wat_53", ""));
		setBkg45(JSPUtil.getParameter(request, prefix + "bkg_45", ""));
		setBkgWgt(JSPUtil.getParameter(request, prefix + "bkg_wgt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setWatHc(JSPUtil.getParameter(request, prefix + "wat_hc", ""));
		setAlcHc(JSPUtil.getParameter(request, prefix + "alc_hc", ""));
		setBkgRf(JSPUtil.getParameter(request, prefix + "bkg_rf", ""));
		setAlcRf(JSPUtil.getParameter(request, prefix + "alc_rf", ""));
		setWatRf(JSPUtil.getParameter(request, prefix + "wat_rf", ""));
		setFrmRf(JSPUtil.getParameter(request, prefix + "frm_rf", ""));
		setBkgVol(JSPUtil.getParameter(request, prefix + "bkg_vol", ""));
		setAlc45(JSPUtil.getParameter(request, prefix + "alc_45", ""));
		setCtrlFlg(JSPUtil.getParameter(request, prefix + "ctrl_flg", ""));
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
		setUsaBkgModCd(JSPUtil.getParameter(request, prefix + "usa_bkg_mod_cd", ""));
		setCustAcct(JSPUtil.getParameter(request, prefix + "cust_acct", ""));
		setFctD2(JSPUtil.getParameter(request, prefix + "fct_d2", ""));
		setFctD4(JSPUtil.getParameter(request, prefix + "fct_d4", ""));
		setFctRd(JSPUtil.getParameter(request, prefix + "fct_rd", ""));		
		setAlcD2(JSPUtil.getParameter(request, prefix + "alc_d2", ""));
		setAlcD4(JSPUtil.getParameter(request, prefix + "alc_d4", ""));
		setAlcRd(JSPUtil.getParameter(request, prefix + "alc_rd", ""));
		setBkgD2(JSPUtil.getParameter(request, prefix + "bkg_d2", ""));
		setBkgD4(JSPUtil.getParameter(request, prefix + "bkg_d4", ""));
		setBkgRd(JSPUtil.getParameter(request, prefix + "bkg_rd", ""));		
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));	
		setBkgWgtVgm(JSPUtil.getParameter(request, prefix + "bkg_wgt_vgm", ""));
		setBkgVolVgm(JSPUtil.getParameter(request, prefix + "bkg_vol_vgm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquirySalesOrgListVO[]
	 */
	public SearchSpaceControlInquirySalesOrgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquirySalesOrgListVO[]
	 */
	public SearchSpaceControlInquirySalesOrgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquirySalesOrgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fctWgt = (JSPUtil.getParameter(request, prefix	+ "fct_wgt", length));
			String[] fctHc = (JSPUtil.getParameter(request, prefix	+ "fct_hc", length));
			String[] fct45 = (JSPUtil.getParameter(request, prefix	+ "fct_45", length));
			String[] qtaVol = (JSPUtil.getParameter(request, prefix	+ "qta_vol", length));
			String[] alcVol = (JSPUtil.getParameter(request, prefix	+ "alc_vol", length));
			String[] bkg53 = (JSPUtil.getParameter(request, prefix	+ "bkg_53", length));
			String[] frm53 = (JSPUtil.getParameter(request, prefix	+ "frm_53", length));
			String[] watVol = (JSPUtil.getParameter(request, prefix	+ "wat_vol", length));
			String[] frmVol = (JSPUtil.getParameter(request, prefix	+ "frm_vol", length));
			String[] fctRf = (JSPUtil.getParameter(request, prefix	+ "fct_rf", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wat45 = (JSPUtil.getParameter(request, prefix	+ "wat_45", length));
			String[] alc53 = (JSPUtil.getParameter(request, prefix	+ "alc_53", length));
			String[] wat20 = (JSPUtil.getParameter(request, prefix	+ "wat_20", length));
			String[] alcWgt = (JSPUtil.getParameter(request, prefix	+ "alc_wgt", length));
			String[] frm45 = (JSPUtil.getParameter(request, prefix	+ "frm_45", length));
			String[] watWgt = (JSPUtil.getParameter(request, prefix	+ "wat_wgt", length));
			String[] fcTtlTeu = (JSPUtil.getParameter(request, prefix	+ "fc_ttl_teu", length));
			String[] frmHc = (JSPUtil.getParameter(request, prefix	+ "frm_hc", length));
			String[] wat40 = (JSPUtil.getParameter(request, prefix	+ "wat_40", length));
			String[] bkg20 = (JSPUtil.getParameter(request, prefix	+ "bkg_20", length));
			String[] bkgHc = (JSPUtil.getParameter(request, prefix	+ "bkg_hc", length));
			String[] iocTsCd = (JSPUtil.getParameter(request, prefix	+ "ioc_ts_cd", length));
			String[] frmWgt = (JSPUtil.getParameter(request, prefix	+ "frm_wgt", length));
			String[] fctVol = (JSPUtil.getParameter(request, prefix	+ "fct_vol", length));
			String[] bkg40 = (JSPUtil.getParameter(request, prefix	+ "bkg_40", length));
			String[] frm40 = (JSPUtil.getParameter(request, prefix	+ "frm_40", length));
			String[] fct53 = (JSPUtil.getParameter(request, prefix	+ "fct_53", length));
			String[] frm20 = (JSPUtil.getParameter(request, prefix	+ "frm_20", length));
			String[] wat53 = (JSPUtil.getParameter(request, prefix	+ "wat_53", length));
			String[] bkg45 = (JSPUtil.getParameter(request, prefix	+ "bkg_45", length));
			String[] bkgWgt = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] watHc = (JSPUtil.getParameter(request, prefix	+ "wat_hc", length));
			String[] alcHc = (JSPUtil.getParameter(request, prefix	+ "alc_hc", length));
			String[] bkgRf = (JSPUtil.getParameter(request, prefix	+ "bkg_rf", length));
			String[] alcRf = (JSPUtil.getParameter(request, prefix	+ "alc_rf", length));
			String[] watRf = (JSPUtil.getParameter(request, prefix	+ "wat_rf", length));
			String[] frmRf = (JSPUtil.getParameter(request, prefix	+ "frm_rf", length));
			String[] bkgVol = (JSPUtil.getParameter(request, prefix	+ "bkg_vol", length));
			String[] alc45 = (JSPUtil.getParameter(request, prefix	+ "alc_45", length));
			String[] ctrlFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_flg", length));
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
			String[] usaBkgModCd = (JSPUtil.getParameter(request, prefix	+ "usa_bkg_mod_cd", length));
			String[] custAcct = (JSPUtil.getParameter(request, prefix	+ "cust_acct", length));
			String[] fctD2 = (JSPUtil.getParameter(request, prefix	+ "fct_d2", length));
			String[] fctD4 = (JSPUtil.getParameter(request, prefix	+ "fct_d4", length));
			String[] fctRd = (JSPUtil.getParameter(request, prefix	+ "fct_rd", length));			
			String[] alcD2 = (JSPUtil.getParameter(request, prefix	+ "alc_d2", length));
			String[] alcD4 = (JSPUtil.getParameter(request, prefix	+ "alc_d4", length));
			String[] alcRd = (JSPUtil.getParameter(request, prefix	+ "alc_rd", length));
			String[] bkgD2 = (JSPUtil.getParameter(request, prefix	+ "bkg_d2", length));
			String[] bkgD4 = (JSPUtil.getParameter(request, prefix	+ "bkg_d4", length));
			String[] bkgRd = (JSPUtil.getParameter(request, prefix	+ "bkg_rd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] bkgWgtVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_vgm", length));
			String[] bkgVolVgm = (JSPUtil.getParameter(request, prefix	+ "bkg_vol_vgm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquirySalesOrgListVO();
				if (fctWgt[i] != null)
					model.setFctWgt(fctWgt[i]);
				if (fctHc[i] != null)
					model.setFctHc(fctHc[i]);
				if (fct45[i] != null)
					model.setFct45(fct45[i]);
				if (qtaVol[i] != null)
					model.setQtaVol(qtaVol[i]);
				if (alcVol[i] != null)
					model.setAlcVol(alcVol[i]);
				if (bkg53[i] != null)
					model.setBkg53(bkg53[i]);
				if (frm53[i] != null)
					model.setFrm53(frm53[i]);
				if (watVol[i] != null)
					model.setWatVol(watVol[i]);
				if (frmVol[i] != null)
					model.setFrmVol(frmVol[i]);
				if (fctRf[i] != null)
					model.setFctRf(fctRf[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wat45[i] != null)
					model.setWat45(wat45[i]);
				if (alc53[i] != null)
					model.setAlc53(alc53[i]);
				if (wat20[i] != null)
					model.setWat20(wat20[i]);
				if (alcWgt[i] != null)
					model.setAlcWgt(alcWgt[i]);
				if (frm45[i] != null)
					model.setFrm45(frm45[i]);
				if (watWgt[i] != null)
					model.setWatWgt(watWgt[i]);
				if (fcTtlTeu[i] != null)
					model.setFcTtlTeu(fcTtlTeu[i]);
				if (frmHc[i] != null)
					model.setFrmHc(frmHc[i]);
				if (wat40[i] != null)
					model.setWat40(wat40[i]);
				if (bkg20[i] != null)
					model.setBkg20(bkg20[i]);
				if (bkgHc[i] != null)
					model.setBkgHc(bkgHc[i]);
				if (iocTsCd[i] != null)
					model.setIocTsCd(iocTsCd[i]);
				if (frmWgt[i] != null)
					model.setFrmWgt(frmWgt[i]);
				if (fctVol[i] != null)
					model.setFctVol(fctVol[i]);
				if (bkg40[i] != null)
					model.setBkg40(bkg40[i]);
				if (frm40[i] != null)
					model.setFrm40(frm40[i]);
				if (fct53[i] != null)
					model.setFct53(fct53[i]);
				if (frm20[i] != null)
					model.setFrm20(frm20[i]);
				if (wat53[i] != null)
					model.setWat53(wat53[i]);
				if (bkg45[i] != null)
					model.setBkg45(bkg45[i]);
				if (bkgWgt[i] != null)
					model.setBkgWgt(bkgWgt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (watHc[i] != null)
					model.setWatHc(watHc[i]);
				if (alcHc[i] != null)
					model.setAlcHc(alcHc[i]);
				if (bkgRf[i] != null)
					model.setBkgRf(bkgRf[i]);
				if (alcRf[i] != null)
					model.setAlcRf(alcRf[i]);
				if (watRf[i] != null)
					model.setWatRf(watRf[i]);
				if (frmRf[i] != null)
					model.setFrmRf(frmRf[i]);
				if (bkgVol[i] != null)
					model.setBkgVol(bkgVol[i]);
				if (alc45[i] != null)
					model.setAlc45(alc45[i]);
				if (ctrlFlg[i] != null)
					model.setCtrlFlg(ctrlFlg[i]);
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
				if (usaBkgModCd[i] != null)
					model.setUsaBkgModCd(usaBkgModCd[i]);
				if (custAcct[i] != null)
					model.setCustAcct(custAcct[i]);	
				if (fctD2[i] != null)
					model.setFctD2(fctD2[i]);
				if (fctD4[i] != null)
					model.setFctD4(fctD4[i]);	
				if (fctRd[i] != null)
					model.setFctRd(fctRd[i]);			
				if (alcD2[i] != null)
					model.setAlcD2(alcD2[i]);
				if (alcD4[i] != null)
					model.setAlcD4(alcD4[i]);	
				if (alcRd[i] != null)
					model.setAlcRd(alcRd[i]);
				if (bkgD2[i] != null)
					model.setBkgD2(bkgD2[i]);	
				if (bkgD4[i] != null)
					model.setBkgD4(bkgD4[i]);
				if (bkgRd[i] != null)
					model.setBkgRd(bkgRd[i]);		
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);	
				if (bkgWgtVgm[i] != null) model.setBkgWgtVgm(bkgWgtVgm[i]);
				if (bkgVolVgm[i] != null) model.setBkgVolVgm(bkgVolVgm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquirySalesOrgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquirySalesOrgListVO[]
	 */
	public SearchSpaceControlInquirySalesOrgListVO[] getSearchSpaceControlInquirySalesOrgListVOs(){
		SearchSpaceControlInquirySalesOrgListVO[] vos = (SearchSpaceControlInquirySalesOrgListVO[])models.toArray(new SearchSpaceControlInquirySalesOrgListVO[models.size()]);
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
		this.fct45 = this.fct45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtaVol = this.qtaVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcVol = this.alcVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg53 = this.bkg53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frm53 = this.frm53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.watVol = this.watVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmVol = this.frmVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctRf = this.fctRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wat45 = this.wat45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alc53 = this.alc53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wat20 = this.wat20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcWgt = this.alcWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frm45 = this.frm45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.watWgt = this.watWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcTtlTeu = this.fcTtlTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmHc = this.frmHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wat40 = this.wat40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg20 = this.bkg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgHc = this.bkgHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocTsCd = this.iocTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmWgt = this.frmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctVol = this.fctVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg40 = this.bkg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frm40 = this.frm40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fct53 = this.fct53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frm20 = this.frm20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wat53 = this.wat53 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg45 = this.bkg45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgt = this.bkgWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.watHc = this.watHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcHc = this.alcHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRf = this.bkgRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcRf = this.alcRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.watRf = this.watRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRf = this.frmRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVol = this.bkgVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alc45 = this.alc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlFlg = this.ctrlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.usaBkgModCd = this.usaBkgModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAcct = this.custAcct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctD2 = this.fctD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctD4 = this.fctD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctRd = this.fctRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.alcD2 = this.alcD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcD4 = this.alcD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alcRd = this.alcRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD2 = this.bkgD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgD4 = this.bkgD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRd = this.bkgRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.bkgWgtVgm = this.bkgWgtVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
