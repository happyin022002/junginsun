/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomAgreementInfoListDataVO.java
*@FileTitle : CustomAgreementInfoListDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.08 함형석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomAgreementInfoListDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomAgreementInfoListDataVO> models = new ArrayList<CustomAgreementInfoListDataVO>();
	
	/* Column Info */
	private String hgChk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String svChk = null;
	/* Column Info */
	private String otChk = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Column Info */
	private String adChk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tpChk = null;
	/* Column Info */
	private String rpChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String prChk = null;
	/* Column Info */
	private String mnrCdDpDesc = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ptChk = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String clChk = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String pmChk = null;
	/* Column Info */
	private String rhqOfc = null;
	/* Column Info */
	private String chk1 = null;
	/* Column Info */
	private String chk2 = null;
	/* Column Info */
	private String chk3 = null;
	/* Column Info */
	private String chk4 = null;
	/* Column Info */
	private String chk5 = null;
	/* Column Info */
	private String chk6 = null;
	/* Column Info */
	private String chk7 = null;
	/* Column Info */
	private String chk8 = null;
	/* Column Info */
	private String chk9 = null;
	/* Column Info */
	private String chk10 = null;
	/* Column Info */
	private String chk11 = null;
	/* Column Info */
	private String chk12 = null;
	/* Column Info */
	private String chk13 = null;
	/* Column Info */
	private String chk14 = null;
	/* Column Info */
	private String chk15 = null;
	/* Column Info */
	private String chk16 = null;
	/* Column Info */
	private String chk17 = null;
	/* Column Info */
	private String chk18 = null;
	/* Column Info */
	private String chk19 = null;
	/* Column Info */
	private String chk20 = null;
	/* Column Info */
	private String chk21 = null;
	/* Column Info */
	private String chk22 = null;
	/* Column Info */
	private String chk23 = null;
	/* Column Info */
	private String chk24 = null;
	/* Column Info */
	private String chk25 = null;
	/* Column Info */
	private String chk26 = null;
	/* Column Info */
	private String chk27 = null;
	/* Column Info */
	private String chk28 = null;
	/* Column Info */
	private String chk29 = null;
	/* Column Info */
	private String chk30 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomAgreementInfoListDataVO() {}

	public CustomAgreementInfoListDataVO(String ibflag, String pagerows, String hgChk, String svChk, String otChk, String agmtNo, String deltFlg, String vndrLglEngNm, String agmtOfcCd, String adChk, String tpChk, String rpChk, String effDt, String prChk, String mnrCdDpDesc, String ptChk, String vndrSeq, String trfNo, String refNo, String clChk, String pmChk, String agmtVerNo, String rhqOfc, String chk1, String chk2, String chk3, String chk4, String chk5, String chk6, String chk7, String chk8, String chk9, String chk10, String chk11, String chk12, String chk13, String chk14, String chk15, String chk16, String chk17, String chk18, String chk19, String chk20, String chk21, String chk22, String chk23, String chk24, String chk25, String chk26, String chk27, String chk28, String chk29, String chk30, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.hgChk = hgChk;
		this.deltFlg = deltFlg;
		this.svChk = svChk;
		this.otChk = otChk;
		this.agmtNo = agmtNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.agmtOfcCd = agmtOfcCd;
		this.adChk = adChk;
		this.pagerows = pagerows;
		this.tpChk = tpChk;
		this.rpChk = rpChk;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.prChk = prChk;
		this.mnrCdDpDesc = mnrCdDpDesc;
		this.trfNo = trfNo;
		this.vndrSeq = vndrSeq;
		this.ptChk = ptChk;
		this.refNo = refNo;
		this.clChk = clChk;
		this.agmtVerNo = agmtVerNo;
		this.pmChk = pmChk;
		this.rhqOfc = rhqOfc;
		this.chk1 = chk1;
		this.chk2 = chk2;
		this.chk3 = chk3;
		this.chk4 = chk4;
		this.chk5 = chk5;
		this.chk6 = chk6;
		this.chk7 = chk7;
		this.chk8 = chk8;
		this.chk9 = chk9;
		this.chk10 = chk10;
		this.chk11 = chk11;
		this.chk12 = chk12;
		this.chk13 = chk13;
		this.chk14 = chk14;
		this.chk15 = chk15;
		this.chk16 = chk16;
		this.chk17 = chk17;
		this.chk18 = chk18;
		this.chk19 = chk19;
		this.chk20 = chk20;
		this.chk21 = chk21;
		this.chk22 = chk22;
		this.chk23 = chk23;
		this.chk24 = chk24;
		this.chk25 = chk25;
		this.chk26 = chk26;
		this.chk27 = chk27;
		this.chk28 = chk28;
		this.chk29 = chk29;
		this.chk30 = chk30;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hg_chk", getHgChk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("sv_chk", getSvChk());
		this.hashColumns.put("ot_chk", getOtChk());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("ad_chk", getAdChk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tp_chk", getTpChk());
		this.hashColumns.put("rp_chk", getRpChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("pr_chk", getPrChk());
		this.hashColumns.put("mnr_cd_dp_desc", getMnrCdDpDesc());
		this.hashColumns.put("pt_chk", getPtChk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("cl_chk", getClChk());
		this.hashColumns.put("pm_chk", getPmChk());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("rhq_ofc", getRhqOfc());
		this.hashColumns.put("chk1", getChk1());
		this.hashColumns.put("chk2", getChk2());
		this.hashColumns.put("chk3", getChk3());
		this.hashColumns.put("chk4", getChk4());
		this.hashColumns.put("chk5", getChk5());
		this.hashColumns.put("chk6", getChk6());
		this.hashColumns.put("chk7", getChk7());
		this.hashColumns.put("chk8", getChk8());
		this.hashColumns.put("chk9", getChk9());
		this.hashColumns.put("chk10", getChk10());
		this.hashColumns.put("chk11", getChk11());
		this.hashColumns.put("chk12", getChk12());
		this.hashColumns.put("chk13", getChk13());
		this.hashColumns.put("chk14", getChk14());
		this.hashColumns.put("chk15", getChk15());
		this.hashColumns.put("chk16", getChk16());
		this.hashColumns.put("chk17", getChk17());
		this.hashColumns.put("chk18", getChk18());
		this.hashColumns.put("chk19", getChk19());
		this.hashColumns.put("chk20", getChk20());
		this.hashColumns.put("chk21", getChk21());
		this.hashColumns.put("chk22", getChk22());
		this.hashColumns.put("chk23", getChk23());
		this.hashColumns.put("chk24", getChk24());
		this.hashColumns.put("chk25", getChk25());
		this.hashColumns.put("chk26", getChk26());
		this.hashColumns.put("chk27", getChk27());
		this.hashColumns.put("chk28", getChk28());
		this.hashColumns.put("chk29", getChk29());
		this.hashColumns.put("chk30", getChk30());
		this.hashColumns.put("chk30", getChk30());
		this.hashColumns.put("chk30", getChk30());
		this.hashColumns.put("chk30", getChk30());
		this.hashColumns.put("chk30", getChk30());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hg_chk", "hgChk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("sv_chk", "svChk");
		this.hashFields.put("ot_chk", "otChk");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("ad_chk", "adChk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tp_chk", "tpChk");
		this.hashFields.put("rp_chk", "rpChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("pr_chk", "prChk");
		this.hashFields.put("mnr_cd_dp_desc", "mnrCdDpDesc");
		this.hashFields.put("pt_chk", "ptChk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cl_chk", "clChk");
		this.hashFields.put("pm_chk", "pmChk");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("rhq_ofc", "rhqOfc");
		this.hashFields.put("chk1", "chk1");
		this.hashFields.put("chk2", "chk2");
		this.hashFields.put("chk3", "chk3");
		this.hashFields.put("chk4", "chk4");
		this.hashFields.put("chk5", "chk5");
		this.hashFields.put("chk6", "chk6");
		this.hashFields.put("chk7", "chk7");
		this.hashFields.put("chk8", "chk8");
		this.hashFields.put("chk9", "chk9");
		this.hashFields.put("chk10", "chk10");
		this.hashFields.put("chk11", "chk11");
		this.hashFields.put("chk12", "chk12");
		this.hashFields.put("chk13", "chk13");
		this.hashFields.put("chk14", "chk14");
		this.hashFields.put("chk15", "chk15");
		this.hashFields.put("chk16", "chk16");
		this.hashFields.put("chk17", "chk17");
		this.hashFields.put("chk18", "chk18");
		this.hashFields.put("chk19", "chk19");
		this.hashFields.put("chk20", "chk20");
		this.hashFields.put("chk21", "chk21");
		this.hashFields.put("chk22", "chk22");
		this.hashFields.put("chk23", "chk23");
		this.hashFields.put("chk24", "chk24");
		this.hashFields.put("chk25", "chk25");
		this.hashFields.put("chk26", "chk26");
		this.hashFields.put("chk27", "chk27");
		this.hashFields.put("chk28", "chk28");
		this.hashFields.put("chk29", "chk29");
		this.hashFields.put("chk30", "chk30");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hgChk
	 */
	public String getHgChk() {
		return this.hgChk;
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
	 * @return svChk
	 */
	public String getSvChk() {
		return this.svChk;
	}
	
	/**
	 * Column Info
	 * @return otChk
	 */
	public String getOtChk() {
		return this.otChk;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCd
	 */
	public String getAgmtOfcCd() {
		return this.agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return adChk
	 */
	public String getAdChk() {
		return this.adChk;
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
	 * @return tpChk
	 */
	public String getTpChk() {
		return this.tpChk;
	}
	
	/**
	 * Column Info
	 * @return rpChk
	 */
	public String getRpChk() {
		return this.rpChk;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return prChk
	 */
	public String getPrChk() {
		return this.prChk;
	}
	
	/**
	 * Column Info
	 * @return mnrCdDpDesc
	 */
	public String getMnrCdDpDesc() {
		return this.mnrCdDpDesc;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
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
	 * @return ptChk
	 */
	public String getPtChk() {
		return this.ptChk;
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
	 * @return clChk
	 */
	public String getClChk() {
		return this.clChk;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return pmChk
	 */
	public String getPmChk() {
		return this.pmChk;
	}
	
	/**
	 * Column Info
	 * @return rhqOfc
	 */
	public String getRhqOfc() {
		return this.rhqOfc;
	}
	

	/**
	 * Column Info
	 * @param hgChk
	 */
	public void setHgChk(String hgChk) {
		this.hgChk = hgChk;
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
	 * @param svChk
	 */
	public void setSvChk(String svChk) {
		this.svChk = svChk;
	}
	
	/**
	 * Column Info
	 * @param otChk
	 */
	public void setOtChk(String otChk) {
		this.otChk = otChk;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCd
	 */
	public void setAgmtOfcCd(String agmtOfcCd) {
		this.agmtOfcCd = agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param adChk
	 */
	public void setAdChk(String adChk) {
		this.adChk = adChk;
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
	 * @param tpChk
	 */
	public void setTpChk(String tpChk) {
		this.tpChk = tpChk;
	}
	
	/**
	 * Column Info
	 * @param rpChk
	 */
	public void setRpChk(String rpChk) {
		this.rpChk = rpChk;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param prChk
	 */
	public void setPrChk(String prChk) {
		this.prChk = prChk;
	}
	
	/**
	 * Column Info
	 * @param mnrCdDpDesc
	 */
	public void setMnrCdDpDesc(String mnrCdDpDesc) {
		this.mnrCdDpDesc = mnrCdDpDesc;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
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
	 * @param ptChk
	 */
	public void setPtChk(String ptChk) {
		this.ptChk = ptChk;
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
	 * @param clChk
	 */
	public void setClChk(String clChk) {
		this.clChk = clChk;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param pmChk
	 */
	public void setPmChk(String pmChk) {
		this.pmChk = pmChk;
	}
	
	/**
	 * Column Info
	 * @param rhqOfc
	 */
	public void setRhqOfc(String rhqOfc) {
		this.rhqOfc = rhqOfc;
	}
	
	public String getChk1() {
		return chk1;
	}

	public void setChk1(String chk1) {
		this.chk1 = chk1;
	}

	public String getChk2() {
		return chk2;
	}

	public void setChk2(String chk2) {
		this.chk2 = chk2;
	}

	public String getChk3() {
		return chk3;
	}

	public void setChk3(String chk3) {
		this.chk3 = chk3;
	}

	public String getChk4() {
		return chk4;
	}

	public void setChk4(String chk4) {
		this.chk4 = chk4;
	}

	public String getChk5() {
		return chk5;
	}

	public void setChk5(String chk5) {
		this.chk5 = chk5;
	}

	public String getChk6() {
		return chk6;
	}

	public void setChk6(String chk6) {
		this.chk6 = chk6;
	}

	public String getChk7() {
		return chk7;
	}

	public void setChk7(String chk7) {
		this.chk7 = chk7;
	}

	public String getChk8() {
		return chk8;
	}

	public void setChk8(String chk8) {
		this.chk8 = chk8;
	}

	public String getChk9() {
		return chk9;
	}

	public void setChk9(String chk9) {
		this.chk9 = chk9;
	}

	public String getChk10() {
		return chk10;
	}

	public void setChk10(String chk10) {
		this.chk10 = chk10;
	}

	public String getChk11() {
		return chk11;
	}

	public void setChk11(String chk11) {
		this.chk11 = chk11;
	}

	public String getChk12() {
		return chk12;
	}

	public void setChk12(String chk12) {
		this.chk12 = chk12;
	}

	public String getChk13() {
		return chk13;
	}

	public void setChk13(String chk13) {
		this.chk13 = chk13;
	}

	public String getChk14() {
		return chk14;
	}

	public void setChk14(String chk14) {
		this.chk14 = chk14;
	}

	public String getChk15() {
		return chk15;
	}

	public void setChk15(String chk15) {
		this.chk15 = chk15;
	}

	public String getChk16() {
		return chk16;
	}

	public void setChk16(String chk16) {
		this.chk16 = chk16;
	}

	public String getChk17() {
		return chk17;
	}

	public void setChk17(String chk17) {
		this.chk17 = chk17;
	}

	public String getChk18() {
		return chk18;
	}

	public void setChk18(String chk18) {
		this.chk18 = chk18;
	}

	public String getChk19() {
		return chk19;
	}

	public void setChk19(String chk19) {
		this.chk19 = chk19;
	}

	public String getChk20() {
		return chk20;
	}

	public void setChk20(String chk20) {
		this.chk20 = chk20;
	}

	public String getChk21() {
		return chk21;
	}

	public void setChk21(String chk21) {
		this.chk21 = chk21;
	}

	public String getChk22() {
		return chk22;
	}

	public void setChk22(String chk22) {
		this.chk22 = chk22;
	}

	public String getChk23() {
		return chk23;
	}

	public void setChk23(String chk23) {
		this.chk23 = chk23;
	}

	public String getChk24() {
		return chk24;
	}

	public void setChk24(String chk24) {
		this.chk24 = chk24;
	}

	public String getChk25() {
		return chk25;
	}

	public void setChk25(String chk25) {
		this.chk25 = chk25;
	}

	public String getChk26() {
		return chk26;
	}

	public void setChk26(String chk26) {
		this.chk26 = chk26;
	}

	public String getChk27() {
		return chk27;
	}

	public void setChk27(String chk27) {
		this.chk27 = chk27;
	}

	public String getChk28() {
		return chk28;
	}

	public void setChk28(String chk28) {
		this.chk28 = chk28;
	}

	public String getChk29() {
		return chk29;
	}

	public void setChk29(String chk29) {
		this.chk29 = chk29;
	}

	public String getChk30() {
		return chk30;
	}

	public void setChk30(String chk30) {
		this.chk30 = chk30;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHgChk(JSPUtil.getParameter(request, "hg_chk", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSvChk(JSPUtil.getParameter(request, "sv_chk", ""));
		setOtChk(JSPUtil.getParameter(request, "ot_chk", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, "agmt_ofc_cd", ""));
		setAdChk(JSPUtil.getParameter(request, "ad_chk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTpChk(JSPUtil.getParameter(request, "tp_chk", ""));
		setRpChk(JSPUtil.getParameter(request, "rp_chk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setPrChk(JSPUtil.getParameter(request, "pr_chk", ""));
		setMnrCdDpDesc(JSPUtil.getParameter(request, "mnr_cd_dp_desc", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setPtChk(JSPUtil.getParameter(request, "pt_chk", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setClChk(JSPUtil.getParameter(request, "cl_chk", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setPmChk(JSPUtil.getParameter(request, "pm_chk", ""));
		setRhqOfc(JSPUtil.getParameter(request, "rhq_ofc", ""));
		setChk1(JSPUtil.getParameter(request, "chk1", ""));
		setChk2(JSPUtil.getParameter(request, "chk2", ""));
		setChk3(JSPUtil.getParameter(request, "chk3", ""));
		setChk4(JSPUtil.getParameter(request, "chk4", ""));
		setChk5(JSPUtil.getParameter(request, "chk5", ""));
		setChk6(JSPUtil.getParameter(request, "chk6", ""));
		setChk7(JSPUtil.getParameter(request, "chk7", ""));
		setChk8(JSPUtil.getParameter(request, "chk8", ""));
		setChk9(JSPUtil.getParameter(request, "chk9", ""));
		setChk10(JSPUtil.getParameter(request, "chk10", ""));
		setChk11(JSPUtil.getParameter(request, "chk11", ""));
		setChk12(JSPUtil.getParameter(request, "chk12", ""));
		setChk13(JSPUtil.getParameter(request, "chk13", ""));
		setChk14(JSPUtil.getParameter(request, "chk14", ""));
		setChk15(JSPUtil.getParameter(request, "chk15", ""));
		setChk16(JSPUtil.getParameter(request, "chk16", ""));
		setChk17(JSPUtil.getParameter(request, "chk17", ""));
		setChk18(JSPUtil.getParameter(request, "chk18", ""));
		setChk19(JSPUtil.getParameter(request, "chk19", ""));
		setChk20(JSPUtil.getParameter(request, "chk20", ""));
		setChk21(JSPUtil.getParameter(request, "chk21", ""));
		setChk22(JSPUtil.getParameter(request, "chk22", ""));
		setChk23(JSPUtil.getParameter(request, "chk23", ""));
		setChk24(JSPUtil.getParameter(request, "chk24", ""));
		setChk25(JSPUtil.getParameter(request, "chk25", ""));
		setChk26(JSPUtil.getParameter(request, "chk26", ""));
		setChk27(JSPUtil.getParameter(request, "chk27", ""));
		setChk28(JSPUtil.getParameter(request, "chk28", ""));
		setChk29(JSPUtil.getParameter(request, "chk29", ""));
		setChk30(JSPUtil.getParameter(request, "chk30", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomAgreementInfoListDataVO[]
	 */
	public CustomAgreementInfoListDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomAgreementInfoListDataVO[]
	 */
	public CustomAgreementInfoListDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomAgreementInfoListDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hgChk = (JSPUtil.getParameter(request, prefix	+ "hg_chk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] svChk = (JSPUtil.getParameter(request, prefix	+ "sv_chk", length));
			String[] otChk = (JSPUtil.getParameter(request, prefix	+ "ot_chk", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] adChk = (JSPUtil.getParameter(request, prefix	+ "ad_chk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tpChk = (JSPUtil.getParameter(request, prefix	+ "tp_chk", length));
			String[] rpChk = (JSPUtil.getParameter(request, prefix	+ "rp_chk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] prChk = (JSPUtil.getParameter(request, prefix	+ "pr_chk", length));
			String[] mnrCdDpDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_cd_dp_desc", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ptChk = (JSPUtil.getParameter(request, prefix	+ "pt_chk", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] clChk = (JSPUtil.getParameter(request, prefix	+ "cl_chk", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] pmChk = (JSPUtil.getParameter(request, prefix	+ "pm_chk", length));
			String[] rhqOfc = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc", length));
			String[] chk1 = (JSPUtil.getParameter(request, prefix	+ "chk1", length));
			String[] chk2 = (JSPUtil.getParameter(request, prefix	+ "chk2", length));
			String[] chk3 = (JSPUtil.getParameter(request, prefix	+ "chk3", length));
			String[] chk4 = (JSPUtil.getParameter(request, prefix	+ "chk4", length));
			String[] chk5 = (JSPUtil.getParameter(request, prefix	+ "chk5", length));
			String[] chk6 = (JSPUtil.getParameter(request, prefix	+ "chk6", length));
			String[] chk7 = (JSPUtil.getParameter(request, prefix	+ "chk7", length));
			String[] chk8 = (JSPUtil.getParameter(request, prefix	+ "chk8", length));
			String[] chk9 = (JSPUtil.getParameter(request, prefix	+ "chk9", length));
			String[] chk10 = (JSPUtil.getParameter(request, prefix	+ "chk10", length));
			String[] chk11 = (JSPUtil.getParameter(request, prefix	+ "chk11", length));
			String[] chk12 = (JSPUtil.getParameter(request, prefix	+ "chk12", length));
			String[] chk13 = (JSPUtil.getParameter(request, prefix	+ "chk13", length));
			String[] chk14 = (JSPUtil.getParameter(request, prefix	+ "chk14", length));
			String[] chk15 = (JSPUtil.getParameter(request, prefix	+ "chk15", length));
			String[] chk16 = (JSPUtil.getParameter(request, prefix	+ "chk16", length));
			String[] chk17 = (JSPUtil.getParameter(request, prefix	+ "chk17", length));
			String[] chk18 = (JSPUtil.getParameter(request, prefix	+ "chk18", length));
			String[] chk19 = (JSPUtil.getParameter(request, prefix	+ "chk19", length));
			String[] chk20 = (JSPUtil.getParameter(request, prefix	+ "chk20", length));
			String[] chk21 = (JSPUtil.getParameter(request, prefix	+ "chk21", length));
			String[] chk22 = (JSPUtil.getParameter(request, prefix	+ "chk22", length));
			String[] chk23 = (JSPUtil.getParameter(request, prefix	+ "chk23", length));
			String[] chk24 = (JSPUtil.getParameter(request, prefix	+ "chk24", length));
			String[] chk25 = (JSPUtil.getParameter(request, prefix	+ "chk25", length));
			String[] chk26 = (JSPUtil.getParameter(request, prefix	+ "chk26", length));
			String[] chk27 = (JSPUtil.getParameter(request, prefix	+ "chk27", length));
			String[] chk28 = (JSPUtil.getParameter(request, prefix	+ "chk28", length));
			String[] chk29 = (JSPUtil.getParameter(request, prefix	+ "chk29", length));
			String[] chk30 = (JSPUtil.getParameter(request, prefix	+ "chk30", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomAgreementInfoListDataVO();
				if (hgChk[i] != null)
					model.setHgChk(hgChk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (svChk[i] != null)
					model.setSvChk(svChk[i]);
				if (otChk[i] != null)
					model.setOtChk(otChk[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (adChk[i] != null)
					model.setAdChk(adChk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tpChk[i] != null)
					model.setTpChk(tpChk[i]);
				if (rpChk[i] != null)
					model.setRpChk(rpChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (prChk[i] != null)
					model.setPrChk(prChk[i]);
				if (mnrCdDpDesc[i] != null)
					model.setMnrCdDpDesc(mnrCdDpDesc[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ptChk[i] != null)
					model.setPtChk(ptChk[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (clChk[i] != null)
					model.setClChk(clChk[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (pmChk[i] != null)
					model.setPmChk(pmChk[i]);
				if (rhqOfc[i] != null)
					model.setRhqOfc(rhqOfc[i]);
				if (chk1[i] != null)
					model.setChk1(chk1[i]);
				if (chk2[i] != null)
					model.setChk2(chk2[i]);
				if (chk3[i] != null)
					model.setChk3(chk3[i]);
				if (chk4[i] != null)
					model.setChk4(chk4[i]);
				if (chk5[i] != null)
					model.setChk5(chk5[i]);
				if (chk6[i] != null)
					model.setChk6(chk6[i]);
				if (chk7[i] != null)
					model.setChk7(chk7[i]);
				if (chk8[i] != null)
					model.setChk8(chk8[i]);
				if (chk9[i] != null)
					model.setChk9(chk9[i]);
				if (chk10[i] != null)
					model.setChk10(chk10[i]);
				if (chk11[i] != null)
					model.setChk11(chk11[i]);
				if (chk12[i] != null)
					model.setChk12(chk12[i]);
				if (chk13[i] != null)
					model.setChk13(chk13[i]);
				if (chk14[i] != null)
					model.setChk14(chk14[i]);
				if (chk15[i] != null)
					model.setChk15(chk15[i]);
				if (chk16[i] != null)
					model.setChk16(chk16[i]);
				if (chk17[i] != null)
					model.setChk17(chk17[i]);
				if (chk18[i] != null)
					model.setChk18(chk18[i]);
				if (chk19[i] != null)
					model.setChk19(chk19[i]);
				if (chk20[i] != null)
					model.setChk20(chk20[i]);
				if (chk21[i] != null)
					model.setChk21(chk21[i]);
				if (chk22[i] != null)
					model.setChk22(chk22[i]);
				if (chk23[i] != null)
					model.setChk23(chk23[i]);
				if (chk24[i] != null)
					model.setChk24(chk24[i]);
				if (chk25[i] != null)
					model.setChk25(chk25[i]);
				if (chk26[i] != null)
					model.setChk26(chk26[i]);
				if (chk27[i] != null)
					model.setChk27(chk27[i]);
				if (chk28[i] != null)
					model.setChk28(chk28[i]);
				if (chk29[i] != null)
					model.setChk29(chk29[i]);
				if (chk30[i] != null)
					model.setChk30(chk30[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomAgreementInfoListDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomAgreementInfoListDataVO[]
	 */
	public CustomAgreementInfoListDataVO[] getCustomAgreementInfoListDataVOs(){
		CustomAgreementInfoListDataVO[] vos = (CustomAgreementInfoListDataVO[])models.toArray(new CustomAgreementInfoListDataVO[models.size()]);
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
		this.hgChk = this.hgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svChk = this.svChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otChk = this.otChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adChk = this.adChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpChk = this.tpChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpChk = this.rpChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prChk = this.prChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCdDpDesc = this.mnrCdDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptChk = this.ptChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clChk = this.clChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmChk = this.pmChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfc = this.rhqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk1 = this.chk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk2 = this.chk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk3 = this.chk3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk4 = this.chk4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk5 = this.chk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk6 = this.chk6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk7 = this.chk7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk8 = this.chk8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk9 = this.chk9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk10 = this.chk10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk11 = this.chk11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk12 = this.chk12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk13 = this.chk13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk14 = this.chk14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk15 = this.chk15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk16 = this.chk16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk17 = this.chk17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk18 = this.chk18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk19 = this.chk19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk20 = this.chk20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk21 = this.chk21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk22 = this.chk22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk23 = this.chk23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk24 = this.chk24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk25 = this.chk25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk26 = this.chk26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk27 = this.chk27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk28 = this.chk28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk29 = this.chk29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk30 = this.chk30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
