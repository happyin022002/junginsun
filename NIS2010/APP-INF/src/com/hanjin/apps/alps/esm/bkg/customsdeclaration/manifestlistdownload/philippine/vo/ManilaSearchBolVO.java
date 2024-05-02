/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ManilaSearchBolVO.java
*@FileTitle : ManilaSearchBolVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

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
public class ManilaSearchBolVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManilaSearchBolVO> models = new ArrayList<ManilaSearchBolVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String seq = null;

	/* Column Info */
	private String ofcCd = null;

	/* Column Info */
	private String regNo = null;

	/* Column Info */
	private String blNo = null;

	/* Column Info */
	private String blLineNo = null;

	/* Column Info */
	private String blSubLineNo = null;

	/* Column Info */
	private String blSts = null;

	/* Column Info */
	private String preDoc = null;

	/* Column Info */
	private String blTp = null;

	/* Column Info */
	private String blNtCd = null;

	/* Column Info */
	private String uqRefNo = null;

	/* Column Info */
	private String shprNm = null;

	/* Column Info */
	private String shprAddr1 = null;

	/* Column Info */
	private String shprAddr2 = null;

	/* Column Info */
	private String shprAddr3 = null;

	/* Column Info */
	private String shprAddr4 = null;

	/* Column Info */
	private String cneeCd = null;

	/* Column Info */
	private String cneeNm = null;

	/* Column Info */
	private String cneeAddr1 = null;

	/* Column Info */
	private String cneeAddr2 = null;

	/* Column Info */
	private String cneeAddr3 = null;

	/* Column Info */
	private String cneeAddr4 = null;

	/* Column Info */
	private String ntfyCd = null;

	/* Column Info */
	private String ntfyNm = null;

	/* Column Info */
	private String ntfyAddr1 = null;

	/* Column Info */
	private String ntfyAddr2 = null;

	/* Column Info */
	private String ntfyAddr3 = null;

	/* Column Info */
	private String ntfyAddr4 = null;

	/* Column Info */
	private String porCd = null;

	/* Column Info */
	private String delCd = null;

	/* Column Info */
	private String totCntr = null;

	/* Column Info */
	private String pckTp = null;

	/* Column Info */
	private String pckQty = null;

	/* Column Info */
	private String wgt = null;

	/* Column Info */
	private String vol = null;

	/* Column Info */
	private String mkDesc1 = null;

	/* Column Info */
	private String mkDesc2 = null;

	/* Column Info */
	private String mkDesc3 = null;

	/* Column Info */
	private String mkDesc4 = null;

	/* Column Info */
	private String mkDesc5 = null;

	/* Column Info */
	private String mkDesc6 = null;

	/* Column Info */
	private String mkDesc7 = null;

	/* Column Info */
	private String mkDesc8 = null;

	/* Column Info */
	private String mkDesc9 = null;

	/* Column Info */
	private String mkDesc10 = null;

	/* Column Info */
	private String gdsDesc1 = null;

	/* Column Info */
	private String gdsDesc2 = null;

	/* Column Info */
	private String gdsDesc3 = null;

	/* Column Info */
	private String gdsDesc4 = null;

	/* Column Info */
	private String gdsDesc5 = null;

	/* Column Info */
	private String freInd = null;

	/* Column Info */
	private String freVal = null;

	/* Column Info */
	private String freCur = null;

	/* Column Info */
	private String cstmsVal = null;

	/* Column Info */
	private String cstmsCur = null;

	/* Column Info */
	private String trspVal = null;

	/* Column Info */
	private String trspCur = null;

	/* Column Info */
	private String insurVal = null;

	/* Column Info */
	private String insurCur = null;

	/* Column Info */
	private String totSubBl = null;

	/* Column Info */
	private String totSeal = null;

	/* Column Info */
	private String delMod = null;

	/* Column Info */
	private String info1 = null;

	/* Column Info */
	private String info2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ManilaSearchBolVO() {}

	public ManilaSearchBolVO(String ibflag, String pagerows, String seq, String ofcCd, String regNo, String blNo, String blLineNo, String blSubLineNo, String blSts, String preDoc, String blTp, String blNtCd, String uqRefNo, String shprNm, String shprAddr1, String shprAddr2, String shprAddr3, String shprAddr4, String cneeCd, String cneeNm, String cneeAddr1, String cneeAddr2, String cneeAddr3, String cneeAddr4, String ntfyCd, String ntfyNm, String ntfyAddr1, String ntfyAddr2, String ntfyAddr3, String ntfyAddr4, String porCd, String delCd, String totCntr, String pckTp, String pckQty, String wgt, String vol, String mkDesc1, String mkDesc2, String mkDesc3, String mkDesc4, String mkDesc5, String mkDesc6, String mkDesc7, String mkDesc8, String mkDesc9, String mkDesc10, String gdsDesc1, String gdsDesc2, String gdsDesc3, String gdsDesc4, String gdsDesc5, String freInd, String freVal, String freCur, String cstmsVal, String cstmsCur, String trspVal, String trspCur, String insurVal, String insurCur, String totSubBl, String totSeal, String delMod, String info1, String info2) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.seq = seq;
		this.ofcCd = ofcCd;
		this.regNo = regNo;
		this.blNo = blNo;
		this.blLineNo = blLineNo;
		this.blSubLineNo = blSubLineNo;
		this.blSts = blSts;
		this.preDoc = preDoc;
		this.blTp = blTp;
		this.blNtCd = blNtCd;
		this.uqRefNo = uqRefNo;
		this.shprNm = shprNm;
		this.shprAddr1 = shprAddr1;
		this.shprAddr2 = shprAddr2;
		this.shprAddr3 = shprAddr3;
		this.shprAddr4 = shprAddr4;
		this.cneeCd = cneeCd;
		this.cneeNm = cneeNm;
		this.cneeAddr1 = cneeAddr1;
		this.cneeAddr2 = cneeAddr2;
		this.cneeAddr3 = cneeAddr3;
		this.cneeAddr4 = cneeAddr4;
		this.ntfyCd = ntfyCd;
		this.ntfyNm = ntfyNm;
		this.ntfyAddr1 = ntfyAddr1;
		this.ntfyAddr2 = ntfyAddr2;
		this.ntfyAddr3 = ntfyAddr3;
		this.ntfyAddr4 = ntfyAddr4;
		this.porCd = porCd;
		this.delCd = delCd;
		this.totCntr = totCntr;
		this.pckTp = pckTp;
		this.pckQty = pckQty;
		this.wgt = wgt;
		this.vol = vol;
		this.mkDesc1 = mkDesc1;
		this.mkDesc2 = mkDesc2;
		this.mkDesc3 = mkDesc3;
		this.mkDesc4 = mkDesc4;
		this.mkDesc5 = mkDesc5;
		this.mkDesc6 = mkDesc6;
		this.mkDesc7 = mkDesc7;
		this.mkDesc8 = mkDesc8;
		this.mkDesc9 = mkDesc9;
		this.mkDesc10 = mkDesc10;
		this.gdsDesc1 = gdsDesc1;
		this.gdsDesc2 = gdsDesc2;
		this.gdsDesc3 = gdsDesc3;
		this.gdsDesc4 = gdsDesc4;
		this.gdsDesc5 = gdsDesc5;
		this.freInd = freInd;
		this.freVal = freVal;
		this.freCur = freCur;
		this.cstmsVal = cstmsVal;
		this.cstmsCur = cstmsCur;
		this.trspVal = trspVal;
		this.trspCur = trspCur;
		this.insurVal = insurVal;
		this.insurCur = insurCur;
		this.totSubBl = totSubBl;
		this.totSeal = totSeal;
		this.delMod = delMod;
		this.info1 = info1;
		this.info2 = info2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("reg_no", getRegNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_line_no", getBlLineNo());
		this.hashColumns.put("bl_sub_line_no", getBlSubLineNo());
		this.hashColumns.put("bl_sts", getBlSts());
		this.hashColumns.put("pre_doc", getPreDoc());
		this.hashColumns.put("bl_tp", getBlTp());
		this.hashColumns.put("bl_nt_cd", getBlNtCd());
		this.hashColumns.put("uq_ref_no", getUqRefNo());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("shpr_addr1", getShprAddr1());
		this.hashColumns.put("shpr_addr2", getShprAddr2());
		this.hashColumns.put("shpr_addr3", getShprAddr3());
		this.hashColumns.put("shpr_addr4", getShprAddr4());
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("cnee_addr1", getCneeAddr1());
		this.hashColumns.put("cnee_addr2", getCneeAddr2());
		this.hashColumns.put("cnee_addr3", getCneeAddr3());
		this.hashColumns.put("cnee_addr4", getCneeAddr4());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("ntfy_addr1", getNtfyAddr1());
		this.hashColumns.put("ntfy_addr2", getNtfyAddr2());
		this.hashColumns.put("ntfy_addr3", getNtfyAddr3());
		this.hashColumns.put("ntfy_addr4", getNtfyAddr4());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("tot_cntr", getTotCntr());
		this.hashColumns.put("pck_tp", getPckTp());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("mk_desc1", getMkDesc1());
		this.hashColumns.put("mk_desc2", getMkDesc2());
		this.hashColumns.put("mk_desc3", getMkDesc3());
		this.hashColumns.put("mk_desc4", getMkDesc4());
		this.hashColumns.put("mk_desc5", getMkDesc5());
		this.hashColumns.put("mk_desc6", getMkDesc6());
		this.hashColumns.put("mk_desc7", getMkDesc7());
		this.hashColumns.put("mk_desc8", getMkDesc8());
		this.hashColumns.put("mk_desc9", getMkDesc9());
		this.hashColumns.put("mk_desc10", getMkDesc10());
		this.hashColumns.put("gds_desc1", getGdsDesc1());
		this.hashColumns.put("gds_desc2", getGdsDesc2());
		this.hashColumns.put("gds_desc3", getGdsDesc3());
		this.hashColumns.put("gds_desc4", getGdsDesc4());
		this.hashColumns.put("gds_desc5", getGdsDesc5());
		this.hashColumns.put("fre_ind", getFreInd());
		this.hashColumns.put("fre_val", getFreVal());
		this.hashColumns.put("fre_cur", getFreCur());
		this.hashColumns.put("cstms_val", getCstmsVal());
		this.hashColumns.put("cstms_cur", getCstmsCur());
		this.hashColumns.put("trsp_val", getTrspVal());
		this.hashColumns.put("trsp_cur", getTrspCur());
		this.hashColumns.put("insur_val", getInsurVal());
		this.hashColumns.put("insur_cur", getInsurCur());
		this.hashColumns.put("tot_sub_bl", getTotSubBl());
		this.hashColumns.put("tot_seal", getTotSeal());
		this.hashColumns.put("del_mod", getDelMod());
		this.hashColumns.put("info1", getInfo1());
		this.hashColumns.put("info2", getInfo2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("reg_no", "regNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_line_no", "blLineNo");
		this.hashFields.put("bl_sub_line_no", "blSubLineNo");
		this.hashFields.put("bl_sts", "blSts");
		this.hashFields.put("pre_doc", "preDoc");
		this.hashFields.put("bl_tp", "blTp");
		this.hashFields.put("bl_nt_cd", "blNtCd");
		this.hashFields.put("uq_ref_no", "uqRefNo");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("shpr_addr1", "shprAddr1");
		this.hashFields.put("shpr_addr2", "shprAddr2");
		this.hashFields.put("shpr_addr3", "shprAddr3");
		this.hashFields.put("shpr_addr4", "shprAddr4");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("cnee_addr1", "cneeAddr1");
		this.hashFields.put("cnee_addr2", "cneeAddr2");
		this.hashFields.put("cnee_addr3", "cneeAddr3");
		this.hashFields.put("cnee_addr4", "cneeAddr4");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("ntfy_addr1", "ntfyAddr1");
		this.hashFields.put("ntfy_addr2", "ntfyAddr2");
		this.hashFields.put("ntfy_addr3", "ntfyAddr3");
		this.hashFields.put("ntfy_addr4", "ntfyAddr4");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("tot_cntr", "totCntr");
		this.hashFields.put("pck_tp", "pckTp");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("mk_desc1", "mkDesc1");
		this.hashFields.put("mk_desc2", "mkDesc2");
		this.hashFields.put("mk_desc3", "mkDesc3");
		this.hashFields.put("mk_desc4", "mkDesc4");
		this.hashFields.put("mk_desc5", "mkDesc5");
		this.hashFields.put("mk_desc6", "mkDesc6");
		this.hashFields.put("mk_desc7", "mkDesc7");
		this.hashFields.put("mk_desc8", "mkDesc8");
		this.hashFields.put("mk_desc9", "mkDesc9");
		this.hashFields.put("mk_desc10", "mkDesc10");
		this.hashFields.put("gds_desc1", "gdsDesc1");
		this.hashFields.put("gds_desc2", "gdsDesc2");
		this.hashFields.put("gds_desc3", "gdsDesc3");
		this.hashFields.put("gds_desc4", "gdsDesc4");
		this.hashFields.put("gds_desc5", "gdsDesc5");
		this.hashFields.put("fre_ind", "freInd");
		this.hashFields.put("fre_val", "freVal");
		this.hashFields.put("fre_cur", "freCur");
		this.hashFields.put("cstms_val", "cstmsVal");
		this.hashFields.put("cstms_cur", "cstmsCur");
		this.hashFields.put("trsp_val", "trspVal");
		this.hashFields.put("trsp_cur", "trspCur");
		this.hashFields.put("insur_val", "insurVal");
		this.hashFields.put("insur_cur", "insurCur");
		this.hashFields.put("tot_sub_bl", "totSubBl");
		this.hashFields.put("tot_seal", "totSeal");
		this.hashFields.put("del_mod", "delMod");
		this.hashFields.put("info1", "info1");
		this.hashFields.put("info2", "info2");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * 
	 * @return String seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 *
	 * @param String ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 
	 * @return String ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 *
	 * @param String regNo
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	/**
	 * 
	 * @return String regNo
	 */
	public String getRegNo() {
		return this.regNo;
	}
	
	/**
	 *
	 * @param String blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * 
	 * @return String blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 *
	 * @param String blLineNo
	 */
	public void setBlLineNo(String blLineNo) {
		this.blLineNo = blLineNo;
	}
	
	/**
	 * 
	 * @return String blLineNo
	 */
	public String getBlLineNo() {
		return this.blLineNo;
	}
	
	/**
	 *
	 * @param String blSubLineNo
	 */
	public void setBlSubLineNo(String blSubLineNo) {
		this.blSubLineNo = blSubLineNo;
	}
	
	/**
	 * 
	 * @return String blSubLineNo
	 */
	public String getBlSubLineNo() {
		return this.blSubLineNo;
	}
	
	/**
	 *
	 * @param String blSts
	 */
	public void setBlSts(String blSts) {
		this.blSts = blSts;
	}
	
	/**
	 * 
	 * @return String blSts
	 */
	public String getBlSts() {
		return this.blSts;
	}
	
	/**
	 *
	 * @param String preDoc
	 */
	public void setPreDoc(String preDoc) {
		this.preDoc = preDoc;
	}
	
	/**
	 * 
	 * @return String preDoc
	 */
	public String getPreDoc() {
		return this.preDoc;
	}
	
	/**
	 *
	 * @param String blTp
	 */
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}
	
	/**
	 * 
	 * @return String blTp
	 */
	public String getBlTp() {
		return this.blTp;
	}
	
	/**
	 *
	 * @param String blNtCd
	 */
	public void setBlNtCd(String blNtCd) {
		this.blNtCd = blNtCd;
	}
	
	/**
	 * 
	 * @return String blNtCd
	 */
	public String getBlNtCd() {
		return this.blNtCd;
	}
	
	/**
	 *
	 * @param String uqRefNo
	 */
	public void setUqRefNo(String uqRefNo) {
		this.uqRefNo = uqRefNo;
	}
	
	/**
	 * 
	 * @return String uqRefNo
	 */
	public String getUqRefNo() {
		return this.uqRefNo;
	}
	
	/**
	 *
	 * @param String shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * 
	 * @return String shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 *
	 * @param String shprAddr1
	 */
	public void setShprAddr1(String shprAddr1) {
		this.shprAddr1 = shprAddr1;
	}
	
	/**
	 * 
	 * @return String shprAddr1
	 */
	public String getShprAddr1() {
		return this.shprAddr1;
	}
	
	/**
	 *
	 * @param String shprAddr2
	 */
	public void setShprAddr2(String shprAddr2) {
		this.shprAddr2 = shprAddr2;
	}
	
	/**
	 * 
	 * @return String shprAddr2
	 */
	public String getShprAddr2() {
		return this.shprAddr2;
	}
	
	/**
	 *
	 * @param String shprAddr3
	 */
	public void setShprAddr3(String shprAddr3) {
		this.shprAddr3 = shprAddr3;
	}
	
	/**
	 * 
	 * @return String shprAddr3
	 */
	public String getShprAddr3() {
		return this.shprAddr3;
	}
	
	/**
	 *
	 * @param String shprAddr4
	 */
	public void setShprAddr4(String shprAddr4) {
		this.shprAddr4 = shprAddr4;
	}
	
	/**
	 * 
	 * @return String shprAddr4
	 */
	public String getShprAddr4() {
		return this.shprAddr4;
	}
	
	/**
	 *
	 * @param String cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * 
	 * @return String cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 *
	 * @param String cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * 
	 * @return String cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 *
	 * @param String cneeAddr1
	 */
	public void setCneeAddr1(String cneeAddr1) {
		this.cneeAddr1 = cneeAddr1;
	}
	
	/**
	 * 
	 * @return String cneeAddr1
	 */
	public String getCneeAddr1() {
		return this.cneeAddr1;
	}
	
	/**
	 *
	 * @param String cneeAddr2
	 */
	public void setCneeAddr2(String cneeAddr2) {
		this.cneeAddr2 = cneeAddr2;
	}
	
	/**
	 * 
	 * @return String cneeAddr2
	 */
	public String getCneeAddr2() {
		return this.cneeAddr2;
	}
	
	/**
	 *
	 * @param String cneeAddr3
	 */
	public void setCneeAddr3(String cneeAddr3) {
		this.cneeAddr3 = cneeAddr3;
	}
	
	/**
	 * 
	 * @return String cneeAddr3
	 */
	public String getCneeAddr3() {
		return this.cneeAddr3;
	}
	
	/**
	 *
	 * @param String cneeAddr4
	 */
	public void setCneeAddr4(String cneeAddr4) {
		this.cneeAddr4 = cneeAddr4;
	}
	
	/**
	 * 
	 * @return String cneeAddr4
	 */
	public String getCneeAddr4() {
		return this.cneeAddr4;
	}
	
	/**
	 *
	 * @param String ntfyCd
	 */
	public void setNtfyCd(String ntfyCd) {
		this.ntfyCd = ntfyCd;
	}
	
	/**
	 * 
	 * @return String ntfyCd
	 */
	public String getNtfyCd() {
		return this.ntfyCd;
	}
	
	/**
	 *
	 * @param String ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * 
	 * @return String ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 *
	 * @param String ntfyAddr1
	 */
	public void setNtfyAddr1(String ntfyAddr1) {
		this.ntfyAddr1 = ntfyAddr1;
	}
	
	/**
	 * 
	 * @return String ntfyAddr1
	 */
	public String getNtfyAddr1() {
		return this.ntfyAddr1;
	}
	
	/**
	 *
	 * @param String ntfyAddr2
	 */
	public void setNtfyAddr2(String ntfyAddr2) {
		this.ntfyAddr2 = ntfyAddr2;
	}
	
	/**
	 * 
	 * @return String ntfyAddr2
	 */
	public String getNtfyAddr2() {
		return this.ntfyAddr2;
	}
	
	/**
	 *
	 * @param String ntfyAddr3
	 */
	public void setNtfyAddr3(String ntfyAddr3) {
		this.ntfyAddr3 = ntfyAddr3;
	}
	
	/**
	 * 
	 * @return String ntfyAddr3
	 */
	public String getNtfyAddr3() {
		return this.ntfyAddr3;
	}
	
	/**
	 *
	 * @param String ntfyAddr4
	 */
	public void setNtfyAddr4(String ntfyAddr4) {
		this.ntfyAddr4 = ntfyAddr4;
	}
	
	/**
	 * 
	 * @return String ntfyAddr4
	 */
	public String getNtfyAddr4() {
		return this.ntfyAddr4;
	}
	
	/**
	 *
	 * @param String porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * 
	 * @return String porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 *
	 * @param String delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * 
	 * @return String delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 *
	 * @param String totCntr
	 */
	public void setTotCntr(String totCntr) {
		this.totCntr = totCntr;
	}
	
	/**
	 * 
	 * @return String totCntr
	 */
	public String getTotCntr() {
		return this.totCntr;
	}
	
	/**
	 *
	 * @param String pckTp
	 */
	public void setPckTp(String pckTp) {
		this.pckTp = pckTp;
	}
	
	/**
	 * 
	 * @return String pckTp
	 */
	public String getPckTp() {
		return this.pckTp;
	}
	
	/**
	 *
	 * @param String pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * 
	 * @return String pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 *
	 * @param String wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * 
	 * @return String wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 *
	 * @param String vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	/**
	 * 
	 * @return String vol
	 */
	public String getVol() {
		return this.vol;
	}
	
	/**
	 *
	 * @param String mkDesc1
	 */
	public void setMkDesc1(String mkDesc1) {
		this.mkDesc1 = mkDesc1;
	}
	
	/**
	 * 
	 * @return String mkDesc1
	 */
	public String getMkDesc1() {
		return this.mkDesc1;
	}
	
	/**
	 *
	 * @param String mkDesc2
	 */
	public void setMkDesc2(String mkDesc2) {
		this.mkDesc2 = mkDesc2;
	}
	
	/**
	 * 
	 * @return String mkDesc2
	 */
	public String getMkDesc2() {
		return this.mkDesc2;
	}
	
	/**
	 *
	 * @param String mkDesc3
	 */
	public void setMkDesc3(String mkDesc3) {
		this.mkDesc3 = mkDesc3;
	}
	
	/**
	 * 
	 * @return String mkDesc3
	 */
	public String getMkDesc3() {
		return this.mkDesc3;
	}
	
	/**
	 *
	 * @param String mkDesc4
	 */
	public void setMkDesc4(String mkDesc4) {
		this.mkDesc4 = mkDesc4;
	}
	
	/**
	 * 
	 * @return String mkDesc4
	 */
	public String getMkDesc4() {
		return this.mkDesc4;
	}
	
	/**
	 *
	 * @param String mkDesc5
	 */
	public void setMkDesc5(String mkDesc5) {
		this.mkDesc5 = mkDesc5;
	}
	
	/**
	 * 
	 * @return String mkDesc5
	 */
	public String getMkDesc5() {
		return this.mkDesc5;
	}
	
	/**
	 *
	 * @param String mkDesc6
	 */
	public void setMkDesc6(String mkDesc6) {
		this.mkDesc6 = mkDesc6;
	}
	
	/**
	 * 
	 * @return String mkDesc6
	 */
	public String getMkDesc6() {
		return this.mkDesc6;
	}
	
	/**
	 *
	 * @param String mkDesc7
	 */
	public void setMkDesc7(String mkDesc7) {
		this.mkDesc7 = mkDesc7;
	}
	
	/**
	 * 
	 * @return String mkDesc7
	 */
	public String getMkDesc7() {
		return this.mkDesc7;
	}
	
	/**
	 *
	 * @param String mkDesc8
	 */
	public void setMkDesc8(String mkDesc8) {
		this.mkDesc8 = mkDesc8;
	}
	
	/**
	 * 
	 * @return String mkDesc8
	 */
	public String getMkDesc8() {
		return this.mkDesc8;
	}
	
	/**
	 *
	 * @param String mkDesc9
	 */
	public void setMkDesc9(String mkDesc9) {
		this.mkDesc9 = mkDesc9;
	}
	
	/**
	 * 
	 * @return String mkDesc9
	 */
	public String getMkDesc9() {
		return this.mkDesc9;
	}
	
	/**
	 *
	 * @param String mkDesc10
	 */
	public void setMkDesc10(String mkDesc10) {
		this.mkDesc10 = mkDesc10;
	}
	
	/**
	 * 
	 * @return String mkDesc10
	 */
	public String getMkDesc10() {
		return this.mkDesc10;
	}
	
	/**
	 *
	 * @param String gdsDesc1
	 */
	public void setGdsDesc1(String gdsDesc1) {
		this.gdsDesc1 = gdsDesc1;
	}
	
	/**
	 * 
	 * @return String gdsDesc1
	 */
	public String getGdsDesc1() {
		return this.gdsDesc1;
	}
	
	/**
	 *
	 * @param String gdsDesc2
	 */
	public void setGdsDesc2(String gdsDesc2) {
		this.gdsDesc2 = gdsDesc2;
	}
	
	/**
	 * 
	 * @return String gdsDesc2
	 */
	public String getGdsDesc2() {
		return this.gdsDesc2;
	}
	
	/**
	 *
	 * @param String gdsDesc3
	 */
	public void setGdsDesc3(String gdsDesc3) {
		this.gdsDesc3 = gdsDesc3;
	}
	
	/**
	 * 
	 * @return String gdsDesc3
	 */
	public String getGdsDesc3() {
		return this.gdsDesc3;
	}
	
	/**
	 *
	 * @param String gdsDesc4
	 */
	public void setGdsDesc4(String gdsDesc4) {
		this.gdsDesc4 = gdsDesc4;
	}
	
	/**
	 * 
	 * @return String gdsDesc4
	 */
	public String getGdsDesc4() {
		return this.gdsDesc4;
	}
	
	/**
	 *
	 * @param String gdsDesc5
	 */
	public void setGdsDesc5(String gdsDesc5) {
		this.gdsDesc5 = gdsDesc5;
	}
	
	/**
	 * 
	 * @return String gdsDesc5
	 */
	public String getGdsDesc5() {
		return this.gdsDesc5;
	}
	
	/**
	 *
	 * @param String freInd
	 */
	public void setFreInd(String freInd) {
		this.freInd = freInd;
	}
	
	/**
	 * 
	 * @return String freInd
	 */
	public String getFreInd() {
		return this.freInd;
	}
	
	/**
	 *
	 * @param String freVal
	 */
	public void setFreVal(String freVal) {
		this.freVal = freVal;
	}
	
	/**
	 * 
	 * @return String freVal
	 */
	public String getFreVal() {
		return this.freVal;
	}
	
	/**
	 *
	 * @param String freCur
	 */
	public void setFreCur(String freCur) {
		this.freCur = freCur;
	}
	
	/**
	 * 
	 * @return String freCur
	 */
	public String getFreCur() {
		return this.freCur;
	}
	
	/**
	 *
	 * @param String cstmsVal
	 */
	public void setCstmsVal(String cstmsVal) {
		this.cstmsVal = cstmsVal;
	}
	
	/**
	 * 
	 * @return String cstmsVal
	 */
	public String getCstmsVal() {
		return this.cstmsVal;
	}
	
	/**
	 *
	 * @param String cstmsCur
	 */
	public void setCstmsCur(String cstmsCur) {
		this.cstmsCur = cstmsCur;
	}
	
	/**
	 * 
	 * @return String cstmsCur
	 */
	public String getCstmsCur() {
		return this.cstmsCur;
	}
	
	/**
	 *
	 * @param String trspVal
	 */
	public void setTrspVal(String trspVal) {
		this.trspVal = trspVal;
	}
	
	/**
	 * 
	 * @return String trspVal
	 */
	public String getTrspVal() {
		return this.trspVal;
	}
	
	/**
	 *
	 * @param String trspCur
	 */
	public void setTrspCur(String trspCur) {
		this.trspCur = trspCur;
	}
	
	/**
	 * 
	 * @return String trspCur
	 */
	public String getTrspCur() {
		return this.trspCur;
	}
	
	/**
	 *
	 * @param String insurVal
	 */
	public void setInsurVal(String insurVal) {
		this.insurVal = insurVal;
	}
	
	/**
	 * 
	 * @return String insurVal
	 */
	public String getInsurVal() {
		return this.insurVal;
	}
	
	/**
	 *
	 * @param String insurCur
	 */
	public void setInsurCur(String insurCur) {
		this.insurCur = insurCur;
	}
	
	/**
	 * 
	 * @return String insurCur
	 */
	public String getInsurCur() {
		return this.insurCur;
	}
	
	/**
	 *
	 * @param String totSubBl
	 */
	public void setTotSubBl(String totSubBl) {
		this.totSubBl = totSubBl;
	}
	
	/**
	 * 
	 * @return String totSubBl
	 */
	public String getTotSubBl() {
		return this.totSubBl;
	}
	
	/**
	 *
	 * @param String totSeal
	 */
	public void setTotSeal(String totSeal) {
		this.totSeal = totSeal;
	}
	
	/**
	 * 
	 * @return String totSeal
	 */
	public String getTotSeal() {
		return this.totSeal;
	}
	
	/**
	 *
	 * @param String delMod
	 */
	public void setDelMod(String delMod) {
		this.delMod = delMod;
	}
	
	/**
	 * 
	 * @return String delMod
	 */
	public String getDelMod() {
		return this.delMod;
	}
	
	/**
	 *
	 * @param String info1
	 */
	public void setInfo1(String info1) {
		this.info1 = info1;
	}
	
	/**
	 * 
	 * @return String info1
	 */
	public String getInfo1() {
		return this.info1;
	}
	
	/**
	 *
	 * @param String info2
	 */
	public void setInfo2(String info2) {
		this.info2 = info2;
	}
	
	/**
	 * 
	 * @return String info2
	 */
	public String getInfo2() {
		return this.info2;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setRegNo(JSPUtil.getParameter(request, prefix + "reg_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBlLineNo(JSPUtil.getParameter(request, prefix + "bl_line_no", ""));
		setBlSubLineNo(JSPUtil.getParameter(request, prefix + "bl_sub_line_no", ""));
		setBlSts(JSPUtil.getParameter(request, prefix + "bl_sts", ""));
		setPreDoc(JSPUtil.getParameter(request, prefix + "pre_doc", ""));
		setBlTp(JSPUtil.getParameter(request, prefix + "bl_tp", ""));
		setBlNtCd(JSPUtil.getParameter(request, prefix + "bl_nt_cd", ""));
		setUqRefNo(JSPUtil.getParameter(request, prefix + "uq_ref_no", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setShprAddr1(JSPUtil.getParameter(request, prefix + "shpr_addr1", ""));
		setShprAddr2(JSPUtil.getParameter(request, prefix + "shpr_addr2", ""));
		setShprAddr3(JSPUtil.getParameter(request, prefix + "shpr_addr3", ""));
		setShprAddr4(JSPUtil.getParameter(request, prefix + "shpr_addr4", ""));
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setCneeAddr1(JSPUtil.getParameter(request, prefix + "cnee_addr1", ""));
		setCneeAddr2(JSPUtil.getParameter(request, prefix + "cnee_addr2", ""));
		setCneeAddr3(JSPUtil.getParameter(request, prefix + "cnee_addr3", ""));
		setCneeAddr4(JSPUtil.getParameter(request, prefix + "cnee_addr4", ""));
		setNtfyCd(JSPUtil.getParameter(request, prefix + "ntfy_cd", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setNtfyAddr1(JSPUtil.getParameter(request, prefix + "ntfy_addr1", ""));
		setNtfyAddr2(JSPUtil.getParameter(request, prefix + "ntfy_addr2", ""));
		setNtfyAddr3(JSPUtil.getParameter(request, prefix + "ntfy_addr3", ""));
		setNtfyAddr4(JSPUtil.getParameter(request, prefix + "ntfy_addr4", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTotCntr(JSPUtil.getParameter(request, prefix + "tot_cntr", ""));
		setPckTp(JSPUtil.getParameter(request, prefix + "pck_tp", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setVol(JSPUtil.getParameter(request, prefix + "vol", ""));
		setMkDesc1(JSPUtil.getParameter(request, prefix + "mk_desc1", ""));
		setMkDesc2(JSPUtil.getParameter(request, prefix + "mk_desc2", ""));
		setMkDesc3(JSPUtil.getParameter(request, prefix + "mk_desc3", ""));
		setMkDesc4(JSPUtil.getParameter(request, prefix + "mk_desc4", ""));
		setMkDesc5(JSPUtil.getParameter(request, prefix + "mk_desc5", ""));
		setMkDesc6(JSPUtil.getParameter(request, prefix + "mk_desc6", ""));
		setMkDesc7(JSPUtil.getParameter(request, prefix + "mk_desc7", ""));
		setMkDesc8(JSPUtil.getParameter(request, prefix + "mk_desc8", ""));
		setMkDesc9(JSPUtil.getParameter(request, prefix + "mk_desc9", ""));
		setMkDesc10(JSPUtil.getParameter(request, prefix + "mk_desc10", ""));
		setGdsDesc1(JSPUtil.getParameter(request, prefix + "gds_desc1", ""));
		setGdsDesc2(JSPUtil.getParameter(request, prefix + "gds_desc2", ""));
		setGdsDesc3(JSPUtil.getParameter(request, prefix + "gds_desc3", ""));
		setGdsDesc4(JSPUtil.getParameter(request, prefix + "gds_desc4", ""));
		setGdsDesc5(JSPUtil.getParameter(request, prefix + "gds_desc5", ""));
		setFreInd(JSPUtil.getParameter(request, prefix + "fre_ind", ""));
		setFreVal(JSPUtil.getParameter(request, prefix + "fre_val", ""));
		setFreCur(JSPUtil.getParameter(request, prefix + "fre_cur", ""));
		setCstmsVal(JSPUtil.getParameter(request, prefix + "cstms_val", ""));
		setCstmsCur(JSPUtil.getParameter(request, prefix + "cstms_cur", ""));
		setTrspVal(JSPUtil.getParameter(request, prefix + "trsp_val", ""));
		setTrspCur(JSPUtil.getParameter(request, prefix + "trsp_cur", ""));
		setInsurVal(JSPUtil.getParameter(request, prefix + "insur_val", ""));
		setInsurCur(JSPUtil.getParameter(request, prefix + "insur_cur", ""));
		setTotSubBl(JSPUtil.getParameter(request, prefix + "tot_sub_bl", ""));
		setTotSeal(JSPUtil.getParameter(request, prefix + "tot_seal", ""));
		setDelMod(JSPUtil.getParameter(request, prefix + "del_mod", ""));
		setInfo1(JSPUtil.getParameter(request, prefix + "info1", ""));
		setInfo2(JSPUtil.getParameter(request, prefix + "info2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaSearchBolVO[]
	 */
	public ManilaSearchBolVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaSearchBolVO[]
	 */
	public ManilaSearchBolVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManilaSearchBolVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] regNo = (JSPUtil.getParameter(request, prefix	+ "reg_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blLineNo = (JSPUtil.getParameter(request, prefix	+ "bl_line_no", length));
			String[] blSubLineNo = (JSPUtil.getParameter(request, prefix	+ "bl_sub_line_no", length));
			String[] blSts = (JSPUtil.getParameter(request, prefix	+ "bl_sts", length));
			String[] preDoc = (JSPUtil.getParameter(request, prefix	+ "pre_doc", length));
			String[] blTp = (JSPUtil.getParameter(request, prefix	+ "bl_tp", length));
			String[] blNtCd = (JSPUtil.getParameter(request, prefix	+ "bl_nt_cd", length));
			String[] uqRefNo = (JSPUtil.getParameter(request, prefix	+ "uq_ref_no", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] shprAddr1 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr1", length));
			String[] shprAddr2 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr2", length));
			String[] shprAddr3 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr3", length));
			String[] shprAddr4 = (JSPUtil.getParameter(request, prefix	+ "shpr_addr4", length));
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] cneeAddr1 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr1", length));
			String[] cneeAddr2 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr2", length));
			String[] cneeAddr3 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr3", length));
			String[] cneeAddr4 = (JSPUtil.getParameter(request, prefix	+ "cnee_addr4", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] ntfyAddr1 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr1", length));
			String[] ntfyAddr2 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr2", length));
			String[] ntfyAddr3 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr3", length));
			String[] ntfyAddr4 = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr4", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] totCntr = (JSPUtil.getParameter(request, prefix	+ "tot_cntr", length));
			String[] pckTp = (JSPUtil.getParameter(request, prefix	+ "pck_tp", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] mkDesc1 = (JSPUtil.getParameter(request, prefix	+ "mk_desc1", length));
			String[] mkDesc2 = (JSPUtil.getParameter(request, prefix	+ "mk_desc2", length));
			String[] mkDesc3 = (JSPUtil.getParameter(request, prefix	+ "mk_desc3", length));
			String[] mkDesc4 = (JSPUtil.getParameter(request, prefix	+ "mk_desc4", length));
			String[] mkDesc5 = (JSPUtil.getParameter(request, prefix	+ "mk_desc5", length));
			String[] mkDesc6 = (JSPUtil.getParameter(request, prefix	+ "mk_desc6", length));
			String[] mkDesc7 = (JSPUtil.getParameter(request, prefix	+ "mk_desc7", length));
			String[] mkDesc8 = (JSPUtil.getParameter(request, prefix	+ "mk_desc8", length));
			String[] mkDesc9 = (JSPUtil.getParameter(request, prefix	+ "mk_desc9", length));
			String[] mkDesc10 = (JSPUtil.getParameter(request, prefix	+ "mk_desc10", length));
			String[] gdsDesc1 = (JSPUtil.getParameter(request, prefix	+ "gds_desc1", length));
			String[] gdsDesc2 = (JSPUtil.getParameter(request, prefix	+ "gds_desc2", length));
			String[] gdsDesc3 = (JSPUtil.getParameter(request, prefix	+ "gds_desc3", length));
			String[] gdsDesc4 = (JSPUtil.getParameter(request, prefix	+ "gds_desc4", length));
			String[] gdsDesc5 = (JSPUtil.getParameter(request, prefix	+ "gds_desc5", length));
			String[] freInd = (JSPUtil.getParameter(request, prefix	+ "fre_ind", length));
			String[] freVal = (JSPUtil.getParameter(request, prefix	+ "fre_val", length));
			String[] freCur = (JSPUtil.getParameter(request, prefix	+ "fre_cur", length));
			String[] cstmsVal = (JSPUtil.getParameter(request, prefix	+ "cstms_val", length));
			String[] cstmsCur = (JSPUtil.getParameter(request, prefix	+ "cstms_cur", length));
			String[] trspVal = (JSPUtil.getParameter(request, prefix	+ "trsp_val", length));
			String[] trspCur = (JSPUtil.getParameter(request, prefix	+ "trsp_cur", length));
			String[] insurVal = (JSPUtil.getParameter(request, prefix	+ "insur_val", length));
			String[] insurCur = (JSPUtil.getParameter(request, prefix	+ "insur_cur", length));
			String[] totSubBl = (JSPUtil.getParameter(request, prefix	+ "tot_sub_bl", length));
			String[] totSeal = (JSPUtil.getParameter(request, prefix	+ "tot_seal", length));
			String[] delMod = (JSPUtil.getParameter(request, prefix	+ "del_mod", length));
			String[] info1 = (JSPUtil.getParameter(request, prefix	+ "info1", length));
			String[] info2 = (JSPUtil.getParameter(request, prefix	+ "info2", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new ManilaSearchBolVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (seq[i] != null) 
					model.setSeq(seq[i]);
				if (ofcCd[i] != null) 
					model.setOfcCd(ofcCd[i]);
				if (regNo[i] != null) 
					model.setRegNo(regNo[i]);
				if (blNo[i] != null) 
					model.setBlNo(blNo[i]);
				if (blLineNo[i] != null) 
					model.setBlLineNo(blLineNo[i]);
				if (blSubLineNo[i] != null) 
					model.setBlSubLineNo(blSubLineNo[i]);
				if (blSts[i] != null) 
					model.setBlSts(blSts[i]);
				if (preDoc[i] != null) 
					model.setPreDoc(preDoc[i]);
				if (blTp[i] != null) 
					model.setBlTp(blTp[i]);
				if (blNtCd[i] != null) 
					model.setBlNtCd(blNtCd[i]);
				if (uqRefNo[i] != null) 
					model.setUqRefNo(uqRefNo[i]);
				if (shprNm[i] != null) 
					model.setShprNm(shprNm[i]);
				if (shprAddr1[i] != null) 
					model.setShprAddr1(shprAddr1[i]);
				if (shprAddr2[i] != null) 
					model.setShprAddr2(shprAddr2[i]);
				if (shprAddr3[i] != null) 
					model.setShprAddr3(shprAddr3[i]);
				if (shprAddr4[i] != null) 
					model.setShprAddr4(shprAddr4[i]);
				if (cneeCd[i] != null) 
					model.setCneeCd(cneeCd[i]);
				if (cneeNm[i] != null) 
					model.setCneeNm(cneeNm[i]);
				if (cneeAddr1[i] != null) 
					model.setCneeAddr1(cneeAddr1[i]);
				if (cneeAddr2[i] != null) 
					model.setCneeAddr2(cneeAddr2[i]);
				if (cneeAddr3[i] != null) 
					model.setCneeAddr3(cneeAddr3[i]);
				if (cneeAddr4[i] != null) 
					model.setCneeAddr4(cneeAddr4[i]);
				if (ntfyCd[i] != null) 
					model.setNtfyCd(ntfyCd[i]);
				if (ntfyNm[i] != null) 
					model.setNtfyNm(ntfyNm[i]);
				if (ntfyAddr1[i] != null) 
					model.setNtfyAddr1(ntfyAddr1[i]);
				if (ntfyAddr2[i] != null) 
					model.setNtfyAddr2(ntfyAddr2[i]);
				if (ntfyAddr3[i] != null) 
					model.setNtfyAddr3(ntfyAddr3[i]);
				if (ntfyAddr4[i] != null) 
					model.setNtfyAddr4(ntfyAddr4[i]);
				if (porCd[i] != null) 
					model.setPorCd(porCd[i]);
				if (delCd[i] != null) 
					model.setDelCd(delCd[i]);
				if (totCntr[i] != null) 
					model.setTotCntr(totCntr[i]);
				if (pckTp[i] != null) 
					model.setPckTp(pckTp[i]);
				if (pckQty[i] != null) 
					model.setPckQty(pckQty[i]);
				if (wgt[i] != null) 
					model.setWgt(wgt[i]);
				if (vol[i] != null) 
					model.setVol(vol[i]);
				if (mkDesc1[i] != null) 
					model.setMkDesc1(mkDesc1[i]);
				if (mkDesc2[i] != null) 
					model.setMkDesc2(mkDesc2[i]);
				if (mkDesc3[i] != null) 
					model.setMkDesc3(mkDesc3[i]);
				if (mkDesc4[i] != null) 
					model.setMkDesc4(mkDesc4[i]);
				if (mkDesc5[i] != null) 
					model.setMkDesc5(mkDesc5[i]);
				if (mkDesc6[i] != null) 
					model.setMkDesc6(mkDesc6[i]);
				if (mkDesc7[i] != null) 
					model.setMkDesc7(mkDesc7[i]);
				if (mkDesc8[i] != null) 
					model.setMkDesc8(mkDesc8[i]);
				if (mkDesc9[i] != null) 
					model.setMkDesc9(mkDesc9[i]);
				if (mkDesc10[i] != null) 
					model.setMkDesc10(mkDesc10[i]);
				if (gdsDesc1[i] != null) 
					model.setGdsDesc1(gdsDesc1[i]);
				if (gdsDesc2[i] != null) 
					model.setGdsDesc2(gdsDesc2[i]);
				if (gdsDesc3[i] != null) 
					model.setGdsDesc3(gdsDesc3[i]);
				if (gdsDesc4[i] != null) 
					model.setGdsDesc4(gdsDesc4[i]);
				if (gdsDesc5[i] != null) 
					model.setGdsDesc5(gdsDesc5[i]);
				if (freInd[i] != null) 
					model.setFreInd(freInd[i]);
				if (freVal[i] != null) 
					model.setFreVal(freVal[i]);
				if (freCur[i] != null) 
					model.setFreCur(freCur[i]);
				if (cstmsVal[i] != null) 
					model.setCstmsVal(cstmsVal[i]);
				if (cstmsCur[i] != null) 
					model.setCstmsCur(cstmsCur[i]);
				if (trspVal[i] != null) 
					model.setTrspVal(trspVal[i]);
				if (trspCur[i] != null) 
					model.setTrspCur(trspCur[i]);
				if (insurVal[i] != null) 
					model.setInsurVal(insurVal[i]);
				if (insurCur[i] != null) 
					model.setInsurCur(insurCur[i]);
				if (totSubBl[i] != null) 
					model.setTotSubBl(totSubBl[i]);
				if (totSeal[i] != null) 
					model.setTotSeal(totSeal[i]);
				if (delMod[i] != null) 
					model.setDelMod(delMod[i]);
				if (info1[i] != null) 
					model.setInfo1(info1[i]);
				if (info2[i] != null) 
					model.setInfo2(info2[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManilaSearchBolVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManilaSearchBolVO[]
	 */
	public ManilaSearchBolVO[] getManilaSearchBolVOs(){
		ManilaSearchBolVO[] vos = (ManilaSearchBolVO[])models.toArray(new ManilaSearchBolVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regNo = this.regNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLineNo = this.blLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSubLineNo = this.blSubLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSts = this.blSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preDoc = this.preDoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTp = this.blTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNtCd = this.blNtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uqRefNo = this.uqRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr1 = this.shprAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr2 = this.shprAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr3 = this.shprAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr4 = this.shprAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr1 = this.cneeAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr2 = this.cneeAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr3 = this.cneeAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr4 = this.cneeAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr1 = this.ntfyAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr2 = this.ntfyAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr3 = this.ntfyAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr4 = this.ntfyAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCntr = this.totCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTp = this.pckTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc1 = this.mkDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc2 = this.mkDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc3 = this.mkDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc4 = this.mkDesc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc5 = this.mkDesc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc6 = this.mkDesc6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc7 = this.mkDesc7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc8 = this.mkDesc8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc9 = this.mkDesc9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc10 = this.mkDesc10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gdsDesc1 = this.gdsDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gdsDesc2 = this.gdsDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gdsDesc3 = this.gdsDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gdsDesc4 = this.gdsDesc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gdsDesc5 = this.gdsDesc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freInd = this.freInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freVal = this.freVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freCur = this.freCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsVal = this.cstmsVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCur = this.cstmsCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspVal = this.trspVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCur = this.trspCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVal = this.insurVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurCur = this.insurCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSubBl = this.totSubBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSeal = this.totSeal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delMod = this.delMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.info1 = this.info1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.info2 = this.info2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}