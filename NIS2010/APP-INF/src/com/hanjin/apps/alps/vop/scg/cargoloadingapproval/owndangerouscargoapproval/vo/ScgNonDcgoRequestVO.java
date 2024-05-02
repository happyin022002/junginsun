/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScgNonDcgoRequestVO.java
*@FileTitle : ScgNonDcgoRequestVO
*Open Issues :
*Change history : 김도현
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 김도현  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class ScgNonDcgoRequestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgNonDcgoRequestVO> models = new ArrayList<ScgNonDcgoRequestVO>();
	
	/* Column Info */
	private String nonDcgoCateGrpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String nonDcgoKwSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String emlCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rqstGdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoAproCd = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String nonDcgoKwNm = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String nonDcgoRqstSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String odekFlg = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String nonDgCgoStatus = null;
	/* Column Info */
	private String scgFlg = null;
	/* Column Info */
	private String slanCd1 = null;
	/* Column Info */
	private String slanCd2 = null;
	/* Column Info */
	private String slanCd3 = null;
	/* Column Info */
	private String slanCd4 = null;
	/* Column Info */
	private String slanCd5 = null;
	/* Column Info */
	private String slanCd6 = null;
	/* Column Info */
	private String slanCd7 = null;
	/* Column Info */
	private String slanCd8 = null;
	/* Column Info */
	private String slanCd9 = null;
	/* Column Info */
	private String slanCd10 = null;
	/* Column Info */
	private String slanCd11 = null;
	/* Column Info */
	private String slanCd12 = null;
	/* Column Info */
	private String slanCd13 = null;
	/* Column Info */
	private String slanCd14 = null;
	/* Column Info */
	private String slanCd15 = null;
	/* Column Info */
	private String slanCd16 = null;
	/* Column Info */
	private String slanCd17 = null;
	/* Column Info */
	private String slanCd18 = null;
	/* Column Info */
	private String slanCd19 = null;
	/* Column Info */
	private String slanCd20 = null;
	/* Column Info */
	private String slanCd21 = null;
	/* Column Info */
	private String slanCd22 = null;
	/* Column Info */
	private String slanCd23 = null;
	/* Column Info */
	private String slanCd24 = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String fromPsn = null;
	/* Column Info */
	private String toPsn = null;
	/* Column Info */
	private String ccPsn = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String attachFile = null;
	/* Column Info */
	private String bodyHeader = null;
	/* Column Info */
	private String bodyFooter = null;
	/* Column Info */
	private String bodyConts = null;
	/* Column Info */
	private String emlSndNoPop = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String rqstFrDt = null;
	/* Column Info */
	private String rqstToDt = null;
	/* Column Info */
	private String polEtaDt = null;
	/* Column Info */
	private String chgFlg = null;
	/* Column Info */
	private String dgFlg = null;
	/* Column Info */
	private String bkgDcgoFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String bkgNoPop = null;
	/* Column Info */
	private String newCustAproCmdtNm = null;
	/* Column Info */
	private String newCustAproRmk = null;
	/* Column Info */
	private String nonDgChemFlg = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String cmtCtnt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScgNonDcgoRequestVO() {}

	public ScgNonDcgoRequestVO(String ibflag, String pagerows, String bkgNo, String nonDcgoRqstSeq, String cntrNo, String vslCd, String skdVoyNo, String skdDirCd, String slanCd, String cstmsDesc, String cntrMfGdsDesc, String cmdtDesc, String xterRmk, String interRmk, String spclCgoAproCd, String odekFlg, String emlSndNo, String rqstUsrId, String rqstOfcCd, String rqstDt, String rqstGdt, String emlCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String nonDcgoKwSeq, String nonDcgoKwNm, String nonDcgoCateGrpCd, String deltFlg, String deltUsrId, String deltDt, String vvd, String rgnShpOprCd, String nonDgCgoStatus, String scgFlg, String slanCd1, String slanCd2, String slanCd3, String slanCd4, String slanCd5, String slanCd6, String slanCd7, String slanCd8, String slanCd9, String slanCd10, String slanCd11, String slanCd12, String slanCd13, String slanCd14, String slanCd15, String slanCd16, String slanCd17, String slanCd18, String slanCd19, String slanCd20, String slanCd21, String slanCd22, String slanCd23, String slanCd24, String usrEml, String fromPsn, String toPsn, String ccPsn, String subject, String attachFile, String bodyHeader, String bodyFooter, String bodyConts, String emlSndNoPop, String stwgCd, String rqstFrDt, String rqstToDt, String polEtaDt, String chgFlg, String dgFlg, String bkgDcgoFlg, String imdgUnNo, String bkgNoPop, String newCustAproCmdtNm, String newCustAproRmk, String nonDgChemFlg, String cmdtNm, String cmtCtnt) {
		this.nonDcgoCateGrpCd = nonDcgoCateGrpCd;
		this.vslCd = vslCd;
		this.rqstUsrId = rqstUsrId;
		this.nonDcgoKwSeq = nonDcgoKwSeq;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.emlCtnt = emlCtnt;
		this.pagerows = pagerows;
		this.rqstGdt = rqstGdt;
		this.ibflag = ibflag;
		this.spclCgoAproCd = spclCgoAproCd;
		this.interRmk = interRmk;
		this.nonDcgoKwNm = nonDcgoKwNm;
		this.cstmsDesc = cstmsDesc;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.nonDcgoRqstSeq = nonDcgoRqstSeq;
		this.skdVoyNo = skdVoyNo;
		this.emlSndNo = emlSndNo;
		this.deltDt = deltDt;
		this.skdDirCd = skdDirCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.odekFlg = odekFlg;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.xterRmk = xterRmk;
		this.rqstOfcCd = rqstOfcCd;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.deltUsrId = deltUsrId;
		this.vvd = vvd;
		this.rgnShpOprCd = rgnShpOprCd;
		this.nonDgCgoStatus = nonDgCgoStatus;
		this.scgFlg = scgFlg;
		this.slanCd1 = slanCd1;
		this.slanCd2 = slanCd2;
		this.slanCd3 = slanCd3;
		this.slanCd4 = slanCd4;
		this.slanCd5 = slanCd5;
		this.slanCd6 = slanCd6;
		this.slanCd7 = slanCd7;
		this.slanCd8 = slanCd8;
		this.slanCd9 = slanCd9;
		this.slanCd10 = slanCd10;
		this.slanCd11 = slanCd11;
		this.slanCd12 = slanCd12;
		this.slanCd13 = slanCd13;
		this.slanCd14 = slanCd14;
		this.slanCd15 = slanCd15;
		this.slanCd16 = slanCd16;
		this.slanCd17 = slanCd17;
		this.slanCd18 = slanCd18;
		this.slanCd19 = slanCd19;
		this.slanCd20 = slanCd20;
		this.slanCd21 = slanCd21;
		this.slanCd22 = slanCd22;
		this.slanCd23 = slanCd23;
		this.slanCd24 = slanCd24;
		this.usrEml = usrEml;
		this.fromPsn = fromPsn;
		this.toPsn = toPsn;
		this.ccPsn = ccPsn;
		this.subject = subject;
		this.attachFile = attachFile;
		this.bodyHeader = bodyHeader;
		this.bodyFooter = bodyFooter;
		this.bodyConts = bodyConts;
		this.emlSndNoPop = emlSndNoPop;
		this.stwgCd = stwgCd;
		this.rqstFrDt = rqstFrDt;
		this.rqstToDt = rqstToDt;
		this.polEtaDt = polEtaDt;
		this.chgFlg = chgFlg;
		this.dgFlg  = dgFlg;
		this.bkgDcgoFlg = bkgDcgoFlg;
		this.imdgUnNo = imdgUnNo;
		this.bkgNoPop = bkgNoPop;
		this.newCustAproCmdtNm = newCustAproCmdtNm;
		this.newCustAproRmk = newCustAproRmk;
		this.nonDgChemFlg = nonDgChemFlg;
		this.cmdtNm = cmdtNm;
		this.cmtCtnt = cmtCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("non_dcgo_cate_grp_cd", getNonDcgoCateGrpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("non_dcgo_kw_seq", getNonDcgoKwSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eml_ctnt", getEmlCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rqst_gdt", getRqstGdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("non_dcgo_kw_nm", getNonDcgoKwNm());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("non_dcgo_rqst_seq", getNonDcgoRqstSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("odek_flg", getOdekFlg());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("non_dg_cgo_status", getNonDgCgoStatus());
		this.hashColumns.put("scg_flg", getScgFlg());
		this.hashColumns.put("slan_cd1", getSlanCd1());
		this.hashColumns.put("slan_cd2", getSlanCd2());
		this.hashColumns.put("slan_cd3", getSlanCd3());
		this.hashColumns.put("slan_cd4", getSlanCd4());
		this.hashColumns.put("slan_cd5", getSlanCd5());
		this.hashColumns.put("slan_cd6", getSlanCd6());
		this.hashColumns.put("slan_cd7", getSlanCd7());
		this.hashColumns.put("slan_cd8", getSlanCd8());
		this.hashColumns.put("slan_cd9", getSlanCd9());
		this.hashColumns.put("slan_cd10", getSlanCd10());
		this.hashColumns.put("slan_cd11", getSlanCd11());
		this.hashColumns.put("slan_cd12", getSlanCd12());
		this.hashColumns.put("slan_cd13", getSlanCd13());
		this.hashColumns.put("slan_cd14", getSlanCd14());
		this.hashColumns.put("slan_cd15", getSlanCd15());
		this.hashColumns.put("slan_cd16", getSlanCd16());
		this.hashColumns.put("slan_cd17", getSlanCd17());
		this.hashColumns.put("slan_cd18", getSlanCd18());
		this.hashColumns.put("slan_cd19", getSlanCd19());
		this.hashColumns.put("slan_cd20", getSlanCd20());
		this.hashColumns.put("slan_cd21", getSlanCd21());
		this.hashColumns.put("slan_cd22", getSlanCd22());
		this.hashColumns.put("slan_cd23", getSlanCd23());
		this.hashColumns.put("slan_cd24", getSlanCd24());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("from_psn", getFromPsn());
		this.hashColumns.put("to_psn", getToPsn());
		this.hashColumns.put("cc_psn", getCcPsn());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("attach_file", getAttachFile());
		this.hashColumns.put("body_header", getBodyHeader());
		this.hashColumns.put("body_footer", getBodyFooter());
		this.hashColumns.put("body_conts", getBodyConts());
		this.hashColumns.put("eml_snd_no_pop", getEmlSndNoPop());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("rqst_fr_dt", getRqstFrDt());
		this.hashColumns.put("rqst_to_dt", getRqstToDt());
		this.hashColumns.put("pol_eta_dt", getPolEtaDt());
		this.hashColumns.put("chg_flg", getChgFlg());
		this.hashColumns.put("dg_flg", getDgFlg());
		this.hashColumns.put("bkg_dcgo_flg", getBkgDcgoFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("bkg_no_pop", getBkgNoPop());
		this.hashColumns.put("new_cust_apro_cmdt_nm", getNewCustAproCmdtNm());
		this.hashColumns.put("new_cust_apro_rmk", getNewCustAproRmk());
		this.hashColumns.put("non_dg_chem_flg", getNonDgChemFlg());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("cmt_ctnt", getCmtCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("non_dcgo_cate_grp_cd", "nonDcgoCateGrpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("non_dcgo_kw_seq", "nonDcgoKwSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eml_ctnt", "emlCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rqst_gdt", "rqstGdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("non_dcgo_kw_nm", "nonDcgoKwNm");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("non_dcgo_rqst_seq", "nonDcgoRqstSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("odek_flg", "odekFlg");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("non_dg_cgo_status", "nonDgCgoStatus");
		this.hashFields.put("scg_flg", "scgFlg");
		this.hashFields.put("slan_cd1", "slanCd1");
		this.hashFields.put("slan_cd2", "slanCd2");
		this.hashFields.put("slan_cd3", "slanCd3");
		this.hashFields.put("slan_cd4", "slanCd4");
		this.hashFields.put("slan_cd5", "slanCd5");
		this.hashFields.put("slan_cd6", "slanCd6");
		this.hashFields.put("slan_cd7", "slanCd7");
		this.hashFields.put("slan_cd8", "slanCd8");
		this.hashFields.put("slan_cd9", "slanCd9");
		this.hashFields.put("slan_cd10", "slanCd10");
		this.hashFields.put("slan_cd11", "slanCd11");
		this.hashFields.put("slan_cd12", "slanCd12");
		this.hashFields.put("slan_cd13", "slanCd13");
		this.hashFields.put("slan_cd14", "slanCd14");
		this.hashFields.put("slan_cd15", "slanCd15");
		this.hashFields.put("slan_cd16", "slanCd16");
		this.hashFields.put("slan_cd17", "slanCd17");
		this.hashFields.put("slan_cd18", "slanCd18");
		this.hashFields.put("slan_cd19", "slanCd19");
		this.hashFields.put("slan_cd20", "slanCd20");
		this.hashFields.put("slan_cd21", "slanCd21");
		this.hashFields.put("slan_cd22", "slanCd22");
		this.hashFields.put("slan_cd23", "slanCd23");
		this.hashFields.put("slan_cd24", "slanCd24");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("from_psn", "fromPsn");
		this.hashFields.put("to_psn", "toPsn");
		this.hashFields.put("cc_psn", "ccPsn");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("attach_file", "attachFile");
		this.hashFields.put("body_header", "bodyHeader");
		this.hashFields.put("body_footer", "bodyFooter");
		this.hashFields.put("body_conts", "bodyConts");
		this.hashFields.put("eml_snd_no_pop", "emlSndNoPop");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("rqst_fr_dt", "rqstFrDt");
		this.hashFields.put("rqst_to_dt", "rqstToDt");
		this.hashFields.put("pol_eta_dt", "polEtaDt");
		this.hashFields.put("chg_flg", "chgFlg");
		this.hashFields.put("dg_flg", "dgFlg");
		this.hashFields.put("bkg_dcgo_flg", "bkgDcgoFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("bkg_no_pop", "bkgNoPop");
		this.hashFields.put("new_cust_apro_cmdt_nm", "newCustAproCmdtNm");
		this.hashFields.put("new_cust_apro_rmk", "newCustAproRmk");
		this.hashFields.put("non_dg_chem_flg", "nonDgChemFlg");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("cmt_ctnt", "cmtCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return bkgDcgoFlg
	 */
	public String getBkgDcgoFlg() {
		return this.bkgDcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return nonDcgoCateGrpCd
	 */
	public String getNonDcgoCateGrpCd() {
		return this.nonDcgoCateGrpCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return nonDcgoKwSeq
	 */
	public String getNonDcgoKwSeq() {
		return this.nonDcgoKwSeq;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return emlCtnt
	 */
	public String getEmlCtnt() {
		return this.emlCtnt;
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
	 * @return rqstGdt
	 */
	public String getRqstGdt() {
		return this.rqstGdt;
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
	 * @return spclCgoAproCd
	 */
	public String getSpclCgoAproCd() {
		return this.spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return nonDcgoKwNm
	 */
	public String getNonDcgoKwNm() {
		return this.nonDcgoKwNm;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return nonDcgoRqstSeq
	 */
	public String getNonDcgoRqstSeq() {
		return this.nonDcgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
	}
	
	/**
	 * Column Info
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return odekFlg
	 */
	public String getOdekFlg() {
		return this.odekFlg;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
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
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
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
	 * @return cmtCtnt
	 */
	public String getCmtCtnt() {
		return this.cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param bkgDcgoFlg
	 */
	public void setBkgDcgoFlg(String bkgDcgoFlg) {
		this.bkgDcgoFlg = bkgDcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param nonDcgoCateGrpCd
	 */
	public void setNonDcgoCateGrpCd(String nonDcgoCateGrpCd) {
		this.nonDcgoCateGrpCd = nonDcgoCateGrpCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param nonDcgoKwSeq
	 */
	public void setNonDcgoKwSeq(String nonDcgoKwSeq) {
		this.nonDcgoKwSeq = nonDcgoKwSeq;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param cmtCtnt
	 */
	public void setCmtCtnt(String cmtCtnt) {
		this.cmtCtnt = cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param emlCtnt
	 */
	public void setEmlCtnt(String emlCtnt) {
		this.emlCtnt = emlCtnt;
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
	 * @param rqstGdt
	 */
	public void setRqstGdt(String rqstGdt) {
		this.rqstGdt = rqstGdt;
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
	 * @param spclCgoAproCd
	 */
	public void setSpclCgoAproCd(String spclCgoAproCd) {
		this.spclCgoAproCd = spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param nonDcgoKwNm
	 */
	public void setNonDcgoKwNm(String nonDcgoKwNm) {
		this.nonDcgoKwNm = nonDcgoKwNm;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param nonDcgoRqstSeq
	 */
	public void setNonDcgoRqstSeq(String nonDcgoRqstSeq) {
		this.nonDcgoRqstSeq = nonDcgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
	}
	
	/**
	 * Column Info
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param odekFlg
	 */
	public void setOdekFlg(String odekFlg) {
		this.odekFlg = odekFlg;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
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
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
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
	 * @param vvd
	 */
	public String getVvd() {
		return vvd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	public String getRgnShpOprCd() {
		return rgnShpOprCd;
	}

	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
	}

	public String getNonDgCgoStatus() {
		return nonDgCgoStatus;
	}

	public void setNonDgCgoStatus(String nonDgCgoStatus) {
		this.nonDgCgoStatus = nonDgCgoStatus;
	}

	public String getScgFlg() {
		return scgFlg;
	}

	public void setScgFlg(String scgFlg) {
		this.scgFlg = scgFlg;
	}

	public String getSlanCd1() {
		return slanCd1;
	}

	public void setSlanCd1(String slanCd1) {
		this.slanCd1 = slanCd1;
	}

	public String getSlanCd2() {
		return slanCd2;
	}

	public void setSlanCd2(String slanCd2) {
		this.slanCd2 = slanCd2;
	}

	public String getSlanCd3() {
		return slanCd3;
	}

	public void setSlanCd3(String slanCd3) {
		this.slanCd3 = slanCd3;
	}

	public String getSlanCd4() {
		return slanCd4;
	}

	public void setSlanCd4(String slanCd4) {
		this.slanCd4 = slanCd4;
	}

	public String getSlanCd5() {
		return slanCd5;
	}

	public void setSlanCd5(String slanCd5) {
		this.slanCd5 = slanCd5;
	}

	public String getSlanCd6() {
		return slanCd6;
	}

	public void setSlanCd6(String slanCd6) {
		this.slanCd6 = slanCd6;
	}

	public String getSlanCd7() {
		return slanCd7;
	}

	public void setSlanCd7(String slanCd7) {
		this.slanCd7 = slanCd7;
	}

	public String getSlanCd8() {
		return slanCd8;
	}

	public void setSlanCd8(String slanCd8) {
		this.slanCd8 = slanCd8;
	}

	public String getSlanCd9() {
		return slanCd9;
	}

	public void setSlanCd9(String slanCd9) {
		this.slanCd9 = slanCd9;
	}

	public String getSlanCd10() {
		return slanCd10;
	}

	public void setSlanCd10(String slanCd10) {
		this.slanCd10 = slanCd10;
	}

	public String getSlanCd11() {
		return slanCd11;
	}

	public void setSlanCd11(String slanCd11) {
		this.slanCd11 = slanCd11;
	}

	public String getSlanCd12() {
		return slanCd12;
	}

	public void setSlanCd12(String slanCd12) {
		this.slanCd12 = slanCd12;
	}

	public String getSlanCd13() {
		return slanCd13;
	}

	public void setSlanCd13(String slanCd13) {
		this.slanCd13 = slanCd13;
	}

	public String getSlanCd14() {
		return slanCd14;
	}

	public void setSlanCd14(String slanCd14) {
		this.slanCd14 = slanCd14;
	}

	public String getSlanCd15() {
		return slanCd15;
	}

	public void setSlanCd15(String slanCd15) {
		this.slanCd15 = slanCd15;
	}

	public String getSlanCd16() {
		return slanCd16;
	}

	public void setSlanCd16(String slanCd16) {
		this.slanCd16 = slanCd16;
	}

	public String getSlanCd17() {
		return slanCd17;
	}

	public void setSlanCd17(String slanCd17) {
		this.slanCd17 = slanCd17;
	}

	public String getSlanCd18() {
		return slanCd18;
	}

	public void setSlanCd18(String slanCd18) {
		this.slanCd18 = slanCd18;
	}

	public String getSlanCd19() {
		return slanCd19;
	}

	public void setSlanCd19(String slanCd19) {
		this.slanCd19 = slanCd19;
	}

	public String getSlanCd20() {
		return slanCd20;
	}

	public void setSlanCd20(String slanCd20) {
		this.slanCd20 = slanCd20;
	}

	public String getSlanCd21() {
		return slanCd21;
	}

	public void setSlanCd21(String slanCd21) {
		this.slanCd21 = slanCd21;
	}

	public String getSlanCd22() {
		return slanCd22;
	}

	public void setSlanCd22(String slanCd22) {
		this.slanCd22 = slanCd22;
	}

	public String getSlanCd23() {
		return slanCd23;
	}

	public void setSlanCd23(String slanCd23) {
		this.slanCd23 = slanCd23;
	}

	public String getSlanCd24() {
		return slanCd24;
	}

	public void setSlanCd24(String slanCd24) {
		this.slanCd24 = slanCd24;
	}

	public String getUsrEml() {
		return usrEml;
	}

	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}

	public String getFromPsn() {
		return fromPsn;
	}

	public void setFromPsn(String fromPsn) {
		this.fromPsn = fromPsn;
	}

	public String getToPsn() {
		return toPsn;
	}

	public void setToPsn(String toPsn) {
		this.toPsn = toPsn;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getBodyHeader() {
		return bodyHeader;
	}

	public void setBodyHeader(String bodyHeader) {
		this.bodyHeader = bodyHeader;
	}

	public String getBodyFooter() {
		return bodyFooter;
	}

	public void setBodyFooter(String bodyFooter) {
		this.bodyFooter = bodyFooter;
	}

	public String getBodyConts() {
		return bodyConts;
	}

	public void setBodyConts(String bodyConts) {
		this.bodyConts = bodyConts;
	}

	public String getCcPsn() {
		return ccPsn;
	}

	public void setCcPsn(String ccPsn) {
		this.ccPsn = ccPsn;
	}
	
	public String getEmlSndNoPop() {
		return emlSndNoPop;
	}

	public void setEmlSndNoPop(String emlSndNoPop) {
		this.emlSndNoPop = emlSndNoPop;
	}
	
	public String getStwgCd() {
		return stwgCd;
	}

	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
	public String getRqstFrDt() {
		return rqstFrDt;
	}

	public void setRqstFrDt(String rqstFrDt) {
		this.rqstFrDt = rqstFrDt;
	}

	public String getRqstToDt() {
		return rqstToDt;
	}

	public void setRqstToDt(String rqstToDt) {
		this.rqstToDt = rqstToDt;
	}
	
	public String getPolEtaDt() {
		return polEtaDt;
	}

	public void setPolEtaDt(String polEtaDt) {
		this.polEtaDt = polEtaDt;
	}
	
	public String getChgFlg() {
		return chgFlg;
	}

	public void setChgFlg(String chgFlg) {
		this.chgFlg = chgFlg;
	}

	public String getBkgNoPop() {
		return bkgNoPop;
	}

	public void setBkgNoPop(String bkgNoPop) {
		this.bkgNoPop = bkgNoPop;
	}
	
	public String getNewCustAproCmdtNm() {
		return newCustAproCmdtNm;
	}

	public void setNewCustAproCmdtNm(String newCustAproCmdtNm) {
		this.newCustAproCmdtNm = newCustAproCmdtNm;
	}

	public String getNewCustAproRmk() {
		return newCustAproRmk;
	}

	public void setNewCustAproRmk(String newCustAproRmk) {
		this.newCustAproRmk = newCustAproRmk;
	}

	public String getNonDgChemFlg() {
		return nonDgChemFlg;
	}

	public void setNonDgChemFlg(String nonDgChemFlg) {
		this.nonDgChemFlg = nonDgChemFlg;
	}

	public String getCmdtNm() {
		return cmdtNm;
	}

	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
		setNonDcgoCateGrpCd(JSPUtil.getParameter(request, prefix + "non_dcgo_cate_grp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setNonDcgoKwSeq(JSPUtil.getParameter(request, prefix + "non_dcgo_kw_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRqstGdt(JSPUtil.getParameter(request, prefix + "rqst_gdt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpclCgoAproCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setNonDcgoKwNm(JSPUtil.getParameter(request, prefix + "non_dcgo_kw_nm", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setNonDcgoRqstSeq(JSPUtil.getParameter(request, prefix + "non_dcgo_rqst_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setOdekFlg(JSPUtil.getParameter(request, prefix + "odek_flg", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
		setNonDgCgoStatus(JSPUtil.getParameter(request, prefix + "non_dg_cgo_status", ""));
		setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
		setSlanCd1(JSPUtil.getParameter(request, prefix + "slan_cd1", ""));
		setSlanCd2(JSPUtil.getParameter(request, prefix + "slan_cd2", ""));
		setSlanCd3(JSPUtil.getParameter(request, prefix + "slan_cd3", ""));
		setSlanCd4(JSPUtil.getParameter(request, prefix + "slan_cd4", ""));
		setSlanCd5(JSPUtil.getParameter(request, prefix + "slan_cd5", ""));
		setSlanCd6(JSPUtil.getParameter(request, prefix + "slan_cd6", ""));
		setSlanCd7(JSPUtil.getParameter(request, prefix + "slan_cd7", ""));
		setSlanCd8(JSPUtil.getParameter(request, prefix + "slan_cd8", ""));
		setSlanCd9(JSPUtil.getParameter(request, prefix + "slan_cd9", ""));
		setSlanCd10(JSPUtil.getParameter(request, prefix + "slan_cd10", ""));
		setSlanCd11(JSPUtil.getParameter(request, prefix + "slan_cd11", ""));
		setSlanCd12(JSPUtil.getParameter(request, prefix + "slan_cd12", ""));
		setSlanCd13(JSPUtil.getParameter(request, prefix + "slan_cd13", ""));
		setSlanCd14(JSPUtil.getParameter(request, prefix + "slan_cd14", ""));
		setSlanCd15(JSPUtil.getParameter(request, prefix + "slan_cd15", ""));
		setSlanCd16(JSPUtil.getParameter(request, prefix + "slan_cd16", ""));
		setSlanCd17(JSPUtil.getParameter(request, prefix + "slan_cd17", ""));
		setSlanCd18(JSPUtil.getParameter(request, prefix + "slan_cd18", ""));
		setSlanCd19(JSPUtil.getParameter(request, prefix + "slan_cd19", ""));
		setSlanCd20(JSPUtil.getParameter(request, prefix + "slan_cd20", ""));
		setSlanCd21(JSPUtil.getParameter(request, prefix + "slan_cd21", ""));
		setSlanCd22(JSPUtil.getParameter(request, prefix + "slan_cd22", ""));
		setSlanCd23(JSPUtil.getParameter(request, prefix + "slan_cd23", ""));
		setSlanCd24(JSPUtil.getParameter(request, prefix + "slan_cd24", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setFromPsn(JSPUtil.getParameter(request, prefix + "from_psn", ""));
		setToPsn(JSPUtil.getParameter(request, prefix + "to_psn", ""));
		setCcPsn(JSPUtil.getParameter(request, prefix + "cc_psn", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setAttachFile(JSPUtil.getParameter(request, prefix + "attach_file", ""));
		setBodyHeader(JSPUtil.getParameter(request, prefix + "body_header", ""));
		setBodyFooter(JSPUtil.getParameter(request, prefix + "body_footer", ""));
		setBodyConts(JSPUtil.getParameter(request, prefix + "body_conts", ""));
		setEmlSndNoPop(JSPUtil.getParameter(request, prefix + "eml_snd_no_pop", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setRqstFrDt(JSPUtil.getParameter(request, prefix + "rqst_fr_dt", ""));
		setRqstToDt(JSPUtil.getParameter(request, prefix + "rqst_to_dt", ""));
		setPolEtaDt(JSPUtil.getParameter(request, prefix + "pol_eta_dt", ""));
		setChgFlg(JSPUtil.getParameter(request, prefix + "chg_flg", ""));
		setDgFlg(JSPUtil.getParameter(request, prefix + "dg_flg", ""));
		setBkgDcgoFlg(JSPUtil.getParameter(request, prefix + "bkg_dcgo_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setBkgNoPop(JSPUtil.getParameter(request, prefix + "bkg_no_pop", ""));
		setNewCustAproCmdtNm(JSPUtil.getParameter(request, prefix + "new_cust_apro_cmdt_nm", ""));
		setNewCustAproRmk(JSPUtil.getParameter(request, prefix + "new_cust_apro_rmk", ""));
		setNonDgChemFlg(JSPUtil.getParameter(request, prefix + "non_dg_chem_flg", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setCmtCtnt(JSPUtil.getParameter(request, prefix + "cmt_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgNonDcgoRequestVO[]
	 */
	public ScgNonDcgoRequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgNonDcgoRequestVO[]
	 */
	public ScgNonDcgoRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgNonDcgoRequestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nonDcgoCateGrpCd = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_cate_grp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] nonDcgoKwSeq = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_kw_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] emlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rqstGdt = (JSPUtil.getParameter(request, prefix	+ "rqst_gdt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_cd", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] nonDcgoKwNm = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_kw_nm", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] nonDcgoRqstSeq = (JSPUtil.getParameter(request, prefix	+ "non_dcgo_rqst_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] odekFlg = (JSPUtil.getParameter(request, prefix	+ "odek_flg", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] nonDgCgoStatus = (JSPUtil.getParameter(request, prefix	+ "non_dg_cgo_status", length));
			String[] scgFlg = (JSPUtil.getParameter(request, prefix	+ "scg_flg", length));
			String[] slanCd1 = (JSPUtil.getParameter(request, prefix	+ "slan_cd1", length));
			String[] slanCd2 = (JSPUtil.getParameter(request, prefix	+ "slan_cd2", length));
			String[] slanCd3 = (JSPUtil.getParameter(request, prefix	+ "slan_cd3", length));
			String[] slanCd4 = (JSPUtil.getParameter(request, prefix	+ "slan_cd4", length));
			String[] slanCd5 = (JSPUtil.getParameter(request, prefix	+ "slan_cd5", length));
			String[] slanCd6 = (JSPUtil.getParameter(request, prefix	+ "slan_cd6", length));
			String[] slanCd7 = (JSPUtil.getParameter(request, prefix	+ "slan_cd7", length));
			String[] slanCd8 = (JSPUtil.getParameter(request, prefix	+ "slan_cd8", length));
			String[] slanCd9 = (JSPUtil.getParameter(request, prefix	+ "slan_cd9", length));
			String[] slanCd10 = (JSPUtil.getParameter(request, prefix	+ "slan_cd10", length));
			String[] slanCd11 = (JSPUtil.getParameter(request, prefix	+ "slan_cd11", length));
			String[] slanCd12 = (JSPUtil.getParameter(request, prefix	+ "slan_cd12", length));
			String[] slanCd13 = (JSPUtil.getParameter(request, prefix	+ "slan_cd13", length));
			String[] slanCd14 = (JSPUtil.getParameter(request, prefix	+ "slan_cd14", length));
			String[] slanCd15 = (JSPUtil.getParameter(request, prefix	+ "slan_cd15", length));
			String[] slanCd16 = (JSPUtil.getParameter(request, prefix	+ "slan_cd16", length));
			String[] slanCd17 = (JSPUtil.getParameter(request, prefix	+ "slan_cd17", length));
			String[] slanCd18 = (JSPUtil.getParameter(request, prefix	+ "slan_cd18", length));
			String[] slanCd19 = (JSPUtil.getParameter(request, prefix	+ "slan_cd19", length));
			String[] slanCd20 = (JSPUtil.getParameter(request, prefix	+ "slan_cd20", length));
			String[] slanCd21 = (JSPUtil.getParameter(request, prefix	+ "slan_cd21", length));
			String[] slanCd22 = (JSPUtil.getParameter(request, prefix	+ "slan_cd22", length));
			String[] slanCd23 = (JSPUtil.getParameter(request, prefix	+ "slan_cd23", length));
			String[] slanCd24 = (JSPUtil.getParameter(request, prefix	+ "slan_cd24", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] fromPsn = (JSPUtil.getParameter(request, prefix	+ "from_psn", length));
			String[] toPsn = (JSPUtil.getParameter(request, prefix	+ "to_psn", length));
			String[] ccPsn = (JSPUtil.getParameter(request, prefix	+ "cc_psn", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] attachFile = (JSPUtil.getParameter(request, prefix	+ "attach_file", length));
			String[] bodyHeader = (JSPUtil.getParameter(request, prefix	+ "body_header", length));
			String[] bodyFooter = (JSPUtil.getParameter(request, prefix	+ "body_footer", length));
			String[] bodyConts = (JSPUtil.getParameter(request, prefix	+ "body_conts", length));
			String[] emlSndNoPop = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no_pop", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] rqstFrDt = (JSPUtil.getParameter(request, prefix	+ "rqst_fr_dt", length));
			String[] rqstToDt = (JSPUtil.getParameter(request, prefix	+ "rqst_to_dt", length));
			String[] polEtaDt = (JSPUtil.getParameter(request, prefix	+ "pol_eta_dt", length));
			String[] chgFlg = (JSPUtil.getParameter(request, prefix	+ "chg_flg", length));
			String[] dgFlg = (JSPUtil.getParameter(request, prefix	+ "dg_flg", length));
			String[] bkgDcgoFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_dcgo_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] bkgNoPop = (JSPUtil.getParameter(request, prefix	+ "bkg_no_pop", length));
			String[] newCustAproCmdtNm = (JSPUtil.getParameter(request, prefix	+ "new_cust_apro_cmdt_nm", length));
			String[] newCustAproRmk = (JSPUtil.getParameter(request, prefix	+ "new_cust_apro_rmk", length));
			String[] nonDgChemFlg = (JSPUtil.getParameter(request, prefix	+ "non_dg_chem_flg", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] cmtCtnt = (JSPUtil.getParameter(request, prefix	+ "cmt_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgNonDcgoRequestVO();
				if (nonDcgoCateGrpCd[i] != null)
					model.setNonDcgoCateGrpCd(nonDcgoCateGrpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (nonDcgoKwSeq[i] != null)
					model.setNonDcgoKwSeq(nonDcgoKwSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (emlCtnt[i] != null)
					model.setEmlCtnt(emlCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rqstGdt[i] != null)
					model.setRqstGdt(rqstGdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoAproCd[i] != null)
					model.setSpclCgoAproCd(spclCgoAproCd[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (nonDcgoKwNm[i] != null)
					model.setNonDcgoKwNm(nonDcgoKwNm[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (nonDcgoRqstSeq[i] != null)
					model.setNonDcgoRqstSeq(nonDcgoRqstSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (odekFlg[i] != null)
					model.setOdekFlg(odekFlg[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (nonDgCgoStatus[i] != null)
					model.setNonDgCgoStatus(nonDgCgoStatus[i]);
				if (scgFlg[i] != null)
					model.setScgFlg(scgFlg[i]);
				if (slanCd1[i] != null)
					model.setSlanCd1(slanCd1[i]);
				if (slanCd2[i] != null)
					model.setSlanCd2(slanCd2[i]);
				if (slanCd3[i] != null)
					model.setSlanCd3(slanCd3[i]);
				if (slanCd4[i] != null)
					model.setSlanCd4(slanCd4[i]);
				if (slanCd5[i] != null)
					model.setSlanCd5(slanCd5[i]);
				if (slanCd6[i] != null)
					model.setSlanCd6(slanCd6[i]);
				if (slanCd7[i] != null)
					model.setSlanCd7(slanCd7[i]);
				if (slanCd8[i] != null)
					model.setSlanCd8(slanCd8[i]);
				if (slanCd9[i] != null)
					model.setSlanCd9(slanCd9[i]);
				if (slanCd10[i] != null)
					model.setSlanCd10(slanCd10[i]);
				if (slanCd11[i] != null)
					model.setSlanCd11(slanCd11[i]);
				if (slanCd12[i] != null)
					model.setSlanCd12(slanCd12[i]);
				if (slanCd13[i] != null)
					model.setSlanCd13(slanCd13[i]);
				if (slanCd14[i] != null)
					model.setSlanCd14(slanCd14[i]);
				if (slanCd15[i] != null)
					model.setSlanCd15(slanCd15[i]);
				if (slanCd16[i] != null)
					model.setSlanCd16(slanCd16[i]);
				if (slanCd17[i] != null)
					model.setSlanCd17(slanCd17[i]);
				if (slanCd18[i] != null)
					model.setSlanCd18(slanCd18[i]);
				if (slanCd19[i] != null)
					model.setSlanCd19(slanCd19[i]);
				if (slanCd20[i] != null)
					model.setSlanCd20(slanCd20[i]);
				if (slanCd21[i] != null)
					model.setSlanCd21(slanCd21[i]);
				if (slanCd22[i] != null)
					model.setSlanCd22(slanCd22[i]);
				if (slanCd23[i] != null)
					model.setSlanCd23(slanCd23[i]);
				if (slanCd24[i] != null)
					model.setSlanCd24(slanCd24[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (fromPsn[i] != null)
					model.setFromPsn(fromPsn[i]);
				if (toPsn[i] != null)
					model.setToPsn(toPsn[i]);
				if (ccPsn[i] != null)
					model.setCcPsn(ccPsn[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (attachFile[i] != null)
					model.setAttachFile(attachFile[i]);
				if (bodyHeader[i] != null)
					model.setBodyHeader(bodyHeader[i]);
				if (bodyFooter[i] != null)
					model.setBodyFooter(bodyFooter[i]);
				if (bodyConts[i] != null)
					model.setBodyConts(bodyConts[i]);
				if (emlSndNoPop[i] != null)
					model.setEmlSndNoPop(emlSndNoPop[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (rqstFrDt[i] != null)
					model.setRqstFrDt(rqstFrDt[i]);
				if (rqstToDt[i] != null)
					model.setRqstToDt(rqstToDt[i]);
				if (polEtaDt[i] != null)
					model.setPolEtaDt(polEtaDt[i]);
				if (chgFlg[i] != null)
					model.setChgFlg(chgFlg[i]);
				if (dgFlg[i] != null)
					model.setDgFlg(dgFlg[i]);
				if (bkgDcgoFlg[i] != null)
					model.setBkgDcgoFlg(bkgDcgoFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (bkgNoPop[i] != null)
					model.setBkgNoPop(bkgNoPop[i]);
				if (newCustAproCmdtNm[i] != null)
					model.setNewCustAproCmdtNm(newCustAproCmdtNm[i]);
				if (newCustAproRmk[i] != null)
					model.setNewCustAproRmk(newCustAproRmk[i]);
				if (nonDgChemFlg[i] != null)
					model.setNonDgChemFlg(nonDgChemFlg[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (cmtCtnt[i] != null)
					model.setCmtCtnt(cmtCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgNonDcgoRequestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgNonDcgoRequestVO[]
	 */
	public ScgNonDcgoRequestVO[] getScgNonDcgoRequestVOs(){
		ScgNonDcgoRequestVO[] vos = (ScgNonDcgoRequestVO[])models.toArray(new ScgNonDcgoRequestVO[models.size()]);
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
		this.nonDcgoCateGrpCd = this.nonDcgoCateGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDcgoKwSeq = this.nonDcgoKwSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCtnt = this.emlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstGdt = this.rqstGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproCd = this.spclCgoAproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDcgoKwNm = this.nonDcgoKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDcgoRqstSeq = this.nonDcgoRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.odekFlg = this.odekFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDgCgoStatus = this.nonDgCgoStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgFlg = this.scgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd1 = this.slanCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd2 = this.slanCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd3 = this.slanCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd4 = this.slanCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd5 = this.slanCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd6 = this.slanCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd7 = this.slanCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd8 = this.slanCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd9 = this.slanCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd10 = this.slanCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd11 = this.slanCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd12 = this.slanCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd13 = this.slanCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd14 = this.slanCd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd15 = this.slanCd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd16 = this.slanCd16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd17 = this.slanCd17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd18 = this.slanCd18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd19 = this.slanCd19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd20 = this.slanCd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd21 = this.slanCd21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd22 = this.slanCd22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd23 = this.slanCd23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd24 = this.slanCd24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromPsn = this.fromPsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPsn = this.toPsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccPsn = this.ccPsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachFile = this.attachFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bodyHeader = this.bodyHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bodyFooter = this.bodyFooter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bodyConts = this.bodyConts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNoPop = this.emlSndNoPop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFrDt = this.rqstFrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstToDt = this.rqstToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtaDt = this.polEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFlg = this.chgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlg = this.dgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDcgoFlg = this.bkgDcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoPop = this.bkgNoPop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCustAproCmdtNm = this.newCustAproCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCustAproRmk = this.newCustAproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonDgChemFlg = this.nonDgChemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmtCtnt = this.cmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
