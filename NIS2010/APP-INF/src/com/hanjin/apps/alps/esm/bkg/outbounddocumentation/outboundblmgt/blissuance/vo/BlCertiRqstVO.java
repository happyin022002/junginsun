/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlCertiRqstVO.java
*@FileTitle : BlCertiRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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

public class BlCertiRqstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCertiRqstVO> models = new ArrayList<BlCertiRqstVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String clptNm5 = null;
	/* Column Info */
	private String clptNm4 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String clptNm3 = null;
	/* Column Info */
	private String clptNm2 = null;
	/* Column Info */
	private String clptNm1 = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* Column Info */
	private String attrCtnt3 = null;
	/* Column Info */
	private String attrCtnt4 = null;
	/* Column Info */
	private String blCertiRmk = null;
	/* Column Info */
	private String attrCtnt5 = null;
	/* Column Info */
	private String blCertiStsCd = null;
	/* Column Info */
	private String attrCtnt6 = null;
	/* Column Info */
	private String attrCtnt7 = null;
	/* Column Info */
	private String onBrdDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rjctRsnRmk = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String itmCdCtnt = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String issRqstDt = null;
	/* Column Info */
	private String tmpltFlg = null;
	/* Column Info */
	private String cmplDt = null;
	/* Column Info */
	private String hdTitCtnt = null;
	/* Column Info */
	private String rjctDt = null;
	
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String blCertiSts = null;
	/* Column Info */
	private String rqstFromDt = null;
	/* Column Info */
	private String rqstToDt = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String blCertiSeq = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String blCertiPrnFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlCertiRqstVO() {}

	public BlCertiRqstVO(String ibflag, String pagerows, String fileNm,String blNo, String hdTitCtnt, String issDt, String vslCd, String polCd, String podCd, String onBrdDt, String itmCdCtnt, String blCertiRmk, String clptNm1, String clptNm2, String clptNm3, String clptNm4, String clptNm5, String attrCtnt1, String attrCtnt2, String attrCtnt3, String attrCtnt4, String attrCtnt5, String attrCtnt6, String attrCtnt7, String blCertiStsCd, String tmpltFlg, String rqstDt, String aproDt, String rjctDt, String issRqstDt, String cmplDt, String rjctRsnRmk, String coNm, String creDt, String creUsrId, String updDt, String updUsrId,String actDt,String obSrepCd,String vslEngNm,String blCertiSts,String rqstFromDt,String rqstToDt, String blCertiSeq, String blCertiPrnFlg) {
		this.vslCd = vslCd;
		this.clptNm5 = clptNm5;
		this.clptNm4 = clptNm4;
		this.creDt = creDt;
		this.clptNm3 = clptNm3;
		this.clptNm2 = clptNm2;
		this.clptNm1 = clptNm1;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.issDt = issDt;
		this.attrCtnt1 = attrCtnt1;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.attrCtnt2 = attrCtnt2;
		this.attrCtnt3 = attrCtnt3;
		this.attrCtnt4 = attrCtnt4;
		this.blCertiRmk = blCertiRmk;
		this.attrCtnt5 = attrCtnt5;
		this.blCertiStsCd = blCertiStsCd;
		this.attrCtnt6 = attrCtnt6;
		this.attrCtnt7 = attrCtnt7;
		this.onBrdDt = onBrdDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rjctRsnRmk = rjctRsnRmk;
		this.rqstDt = rqstDt;
		this.itmCdCtnt = itmCdCtnt;
		this.coNm = coNm;
		this.aproDt = aproDt;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.issRqstDt = issRqstDt;
		this.tmpltFlg = tmpltFlg;
		this.cmplDt = cmplDt;
		this.hdTitCtnt = hdTitCtnt;
		this.rjctDt = rjctDt;
		this.blCertiSeq = blCertiSeq;
		
		
		this.obSrepCd = obSrepCd;
		this.actDt = actDt;
		this.vslEngNm = vslEngNm;
		this.blCertiSts = blCertiSts;
		this.rqstFromDt = rqstFromDt;
		this.rqstToDt = rqstToDt;
		this.fileNm = fileNm;
		this.blCertiPrnFlg = blCertiPrnFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("clpt_nm5", getClptNm5());
		this.hashColumns.put("clpt_nm4", getClptNm4());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clpt_nm3", getClptNm3());
		this.hashColumns.put("clpt_nm2", getClptNm2());
		this.hashColumns.put("clpt_nm1", getClptNm1());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("bl_certi_rmk", getBlCertiRmk());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("bl_certi_sts_cd", getBlCertiStsCd());
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("on_brd_dt", getOnBrdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("itm_cd_ctnt", getItmCdCtnt());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("iss_rqst_dt", getIssRqstDt());
		this.hashColumns.put("tmplt_flg", getTmpltFlg());
		this.hashColumns.put("cmpl_dt", getCmplDt());
		this.hashColumns.put("hd_tit_ctnt", getHdTitCtnt());
		this.hashColumns.put("rjct_dt", getRjctDt());
		
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("bl_certi_sts", getBlCertiSts());
		this.hashColumns.put("rqst_from_dt", getRqstFromDt());
		this.hashColumns.put("rqst_to_dt", getRqstToDt());
		this.hashColumns.put("bl_certi_seq", getBlCertiSeq());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("bl_certi_prn_flg", getBlCertiPrnFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("clpt_nm5", "clptNm5");
		this.hashFields.put("clpt_nm4", "clptNm4");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clpt_nm3", "clptNm3");
		this.hashFields.put("clpt_nm2", "clptNm2");
		this.hashFields.put("clpt_nm1", "clptNm1");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("bl_certi_rmk", "blCertiRmk");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("bl_certi_sts_cd", "blCertiStsCd");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("on_brd_dt", "onBrdDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("itm_cd_ctnt", "itmCdCtnt");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("iss_rqst_dt", "issRqstDt");
		this.hashFields.put("tmplt_flg", "tmpltFlg");
		this.hashFields.put("cmpl_dt", "cmplDt");
		this.hashFields.put("hd_tit_ctnt", "hdTitCtnt");
		this.hashFields.put("rjct_dt", "rjctDt");
		
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("bl_certi_sts", "blCertiSts");
		this.hashFields.put("rqst_from_dt", "rqstFromDt");
		this.hashFields.put("rqst_to_dt", "rqstToDt");
		this.hashFields.put("bl_certi_seq", "blCertiSeq");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("bl_certi_prn_flg", "blCertiPrnFlg");
		
		return this.hashFields;
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
	 * @return clptNm5
	 */
	public String getClptNm5() {
		return this.clptNm5;
	}
	
	/**
	 * Column Info
	 * @return clptNm4
	 */
	public String getClptNm4() {
		return this.clptNm4;
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
	 * @return clptNm3
	 */
	public String getClptNm3() {
		return this.clptNm3;
	}
	
	/**
	 * Column Info
	 * @return clptNm2
	 */
	public String getClptNm2() {
		return this.clptNm2;
	}
	
	/**
	 * Column Info
	 * @return clptNm1
	 */
	public String getClptNm1() {
		return this.clptNm1;
	}
	
	/**
	 * Column Info
	 * @return blCertiSeq
	 */
	public String getBlCertiSeq() {
		return this.blCertiSeq;
	}
	
	/**
	 * Column Info
	 * @return blCertiPrnFlg
	 */
	public String getBlCertiPrnFlg() {
		return this.blCertiPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return this.attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt4
	 */
	public String getAttrCtnt4() {
		return this.attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return blCertiRmk
	 */
	public String getBlCertiRmk() {
		return this.blCertiRmk;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt5
	 */
	public String getAttrCtnt5() {
		return this.attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @return blCertiStsCd
	 */
	public String getBlCertiStsCd() {
		return this.blCertiStsCd;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt6
	 */
	public String getAttrCtnt6() {
		return this.attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt7
	 */
	public String getAttrCtnt7() {
		return this.attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @return onBrdDt
	 */
	public String getOnBrdDt() {
		return this.onBrdDt;
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
	 * @return rjctRsnRmk
	 */
	public String getRjctRsnRmk() {
		return this.rjctRsnRmk;
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
	 * @return itmCdCtnt
	 */
	public String getItmCdCtnt() {
		return this.itmCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return coNm
	 */
	public String getCoNm() {
		return this.coNm;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return issRqstDt
	 */
	public String getIssRqstDt() {
		return this.issRqstDt;
	}
	
	/**
	 * Column Info
	 * @return tmpltFlg
	 */
	public String getTmpltFlg() {
		return this.tmpltFlg;
	}
	
	/**
	 * Column Info
	 * @return cmplDt
	 */
	public String getCmplDt() {
		return this.cmplDt;
	}
	
	/**
	 * Column Info
	 * @return hdTitCtnt
	 */
	public String getHdTitCtnt() {
		return this.hdTitCtnt;
	}
	
	/**
	 * Column Info
	 * @return rjctDt
	 */
	public String getRjctDt() {
		return this.rjctDt;
	}
	
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	/**
	 * Column Info
	 * @return blCertiSts
	 */
	public String getBlCertiSts() {
		return this.blCertiSts;
	}
	/**
	 * Column Info
	 * @return rqstFromDt
	 */
	public String getRqstFromDt() {
		return this.rqstFromDt;
	}
	/**
	 * Column Info
	 * @return rqstToDt
	 */
	public String getRqstToDt() {
		return this.rqstToDt;
	}
	
	/**
	 * Column Info
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
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
	 * @param clptNm5
	 */
	public void setClptNm5(String clptNm5) {
		this.clptNm5 = clptNm5;
	}
	
	/**
	 * Column Info
	 * @param clptNm4
	 */
	public void setClptNm4(String clptNm4) {
		this.clptNm4 = clptNm4;
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
	 * @param clptNm3
	 */
	public void setClptNm3(String clptNm3) {
		this.clptNm3 = clptNm3;
	}
	
	/**
	 * Column Info
	 * @param clptNm2
	 */
	public void setClptNm2(String clptNm2) {
		this.clptNm2 = clptNm2;
	}
	
	/**
	 * Column Info
	 * @param clptNm1
	 */
	public void setClptNm1(String clptNm1) {
		this.clptNm1 = clptNm1;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param blCertiPrnFlg
	 */
	public void setBlCertiPrnFlg(String blCertiPrnFlg) {
		this.blCertiPrnFlg = blCertiPrnFlg;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt3
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt4
	 */
	public void setAttrCtnt4(String attrCtnt4) {
		this.attrCtnt4 = attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param blCertiRmk
	 */
	public void setBlCertiRmk(String blCertiRmk) {
		this.blCertiRmk = blCertiRmk;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt5
	 */
	public void setAttrCtnt5(String attrCtnt5) {
		this.attrCtnt5 = attrCtnt5;
	}
	
	/**
	 * Column Info
	 * @param blCertiStsCd
	 */
	public void setBlCertiStsCd(String blCertiStsCd) {
		this.blCertiStsCd = blCertiStsCd;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt6
	 */
	public void setAttrCtnt6(String attrCtnt6) {
		this.attrCtnt6 = attrCtnt6;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt7
	 */
	public void setAttrCtnt7(String attrCtnt7) {
		this.attrCtnt7 = attrCtnt7;
	}
	
	/**
	 * Column Info
	 * @param onBrdDt
	 */
	public void setOnBrdDt(String onBrdDt) {
		this.onBrdDt = onBrdDt;
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
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	
	/**
	 * Column Info
	 * @param rjctRsnRmk
	 */
	public void setRjctRsnRmk(String rjctRsnRmk) {
		this.rjctRsnRmk = rjctRsnRmk;
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
	 * @param itmCdCtnt
	 */
	public void setItmCdCtnt(String itmCdCtnt) {
		this.itmCdCtnt = itmCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param coNm
	 */
	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param issRqstDt
	 */
	public void setIssRqstDt(String issRqstDt) {
		this.issRqstDt = issRqstDt;
	}
	
	/**
	 * Column Info
	 * @param tmpltFlg
	 */
	public void setTmpltFlg(String tmpltFlg) {
		this.tmpltFlg = tmpltFlg;
	}
	
	/**
	 * Column Info
	 * @param cmplDt
	 */
	public void setCmplDt(String cmplDt) {
		this.cmplDt = cmplDt;
	}
	
	/**
	 * Column Info
	 * @param hdTitCtnt
	 */
	public void setHdTitCtnt(String hdTitCtnt) {
		this.hdTitCtnt = hdTitCtnt;
	}
	
	/**
	 * Column Info
	 * @param rjctDt
	 */
	public void setRjctDt(String rjctDt) {
		this.rjctDt = rjctDt;
	}
	
	
	/**
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	/**
	 * Column Info
	 * @param blCertiSts
	 */
	public void setBlCertiSts(String blCertiSts) {
		this.blCertiSts = blCertiSts;
	}
	/**
	 * Column Info
	 * @param rqstFromDt
	 */
	public void setRqstFromDt(String rqstFromDt) {
		this.rqstFromDt = rqstFromDt;
	}
	/**
	 * Column Info
	 * @param rqstToDt
	 */
	public void setRqstToDt(String rqstToDt) {
		this.rqstToDt = rqstToDt;
	}
	
	/**
	 * Column Info
	 * @param blCertiSeq
	 */
	public void setBlCertiSeq(String blCertiSeq) {
		this.blCertiSeq = blCertiSeq;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setClptNm5(JSPUtil.getParameter(request, prefix + "clpt_nm5", ""));
		setClptNm4(JSPUtil.getParameter(request, prefix + "clpt_nm4", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setClptNm3(JSPUtil.getParameter(request, prefix + "clpt_nm3", ""));
		setClptNm2(JSPUtil.getParameter(request, prefix + "clpt_nm2", ""));
		setClptNm1(JSPUtil.getParameter(request, prefix + "clpt_nm1", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
		setBlCertiRmk(JSPUtil.getParameter(request, prefix + "bl_certi_rmk", ""));
		setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
		setBlCertiStsCd(JSPUtil.getParameter(request, prefix + "bl_certi_sts_cd", ""));
		setAttrCtnt6(JSPUtil.getParameter(request, prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
		setOnBrdDt(JSPUtil.getParameter(request, prefix + "on_brd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRjctRsnRmk(JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setItmCdCtnt(JSPUtil.getParameter(request, prefix + "itm_cd_ctnt", ""));
		setCoNm(JSPUtil.getParameter(request, prefix + "co_nm", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIssRqstDt(JSPUtil.getParameter(request, prefix + "iss_rqst_dt", ""));
		setTmpltFlg(JSPUtil.getParameter(request, prefix + "tmplt_flg", ""));
		setCmplDt(JSPUtil.getParameter(request, prefix + "cmpl_dt", ""));
		setHdTitCtnt(JSPUtil.getParameter(request, prefix + "hd_tit_ctnt", ""));
		setRjctDt(JSPUtil.getParameter(request, prefix + "rjct_dt", ""));
		
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setBlCertiSts(JSPUtil.getParameter(request, prefix + "bl_certi_sts", ""));
		setRqstFromDt(JSPUtil.getParameter(request, prefix + "rqst_from_dt", ""));
		setRqstToDt(JSPUtil.getParameter(request, prefix + "rqst_to_dt", ""));
		setBlCertiSeq(JSPUtil.getParameter(request, prefix + "bl_certi_seq", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setBlCertiPrnFlg(JSPUtil.getParameter(request, prefix + "bl_certi_prn_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCertiRqstVO[]
	 */
	public BlCertiRqstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCertiRqstVO[]
	 */
	public BlCertiRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCertiRqstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] clptNm5 = (JSPUtil.getParameter(request, prefix	+ "clpt_nm5", length));
			String[] clptNm4 = (JSPUtil.getParameter(request, prefix	+ "clpt_nm4", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] clptNm3 = (JSPUtil.getParameter(request, prefix	+ "clpt_nm3", length));
			String[] clptNm2 = (JSPUtil.getParameter(request, prefix	+ "clpt_nm2", length));
			String[] clptNm1 = (JSPUtil.getParameter(request, prefix	+ "clpt_nm1", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt3", length));
			String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt4", length));
			String[] blCertiRmk = (JSPUtil.getParameter(request, prefix	+ "bl_certi_rmk", length));
			String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt5", length));
			String[] blCertiStsCd = (JSPUtil.getParameter(request, prefix	+ "bl_certi_sts_cd", length));
			String[] attrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt6", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			String[] onBrdDt = (JSPUtil.getParameter(request, prefix	+ "on_brd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rjctRsnRmk = (JSPUtil.getParameter(request, prefix	+ "rjct_rsn_rmk", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] itmCdCtnt = (JSPUtil.getParameter(request, prefix	+ "itm_cd_ctnt", length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] issRqstDt = (JSPUtil.getParameter(request, prefix	+ "iss_rqst_dt", length));
			String[] tmpltFlg = (JSPUtil.getParameter(request, prefix	+ "tmplt_flg", length));
			String[] cmplDt = (JSPUtil.getParameter(request, prefix	+ "cmpl_dt", length));
			String[] hdTitCtnt = (JSPUtil.getParameter(request, prefix	+ "hd_tit_ctnt", length));
			String[] rjctDt = (JSPUtil.getParameter(request, prefix	+ "rjct_dt", length));
			
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] blCertiSts = (JSPUtil.getParameter(request, prefix	+ "bl_certi_sts", length));
			String[] rqstFromDt = (JSPUtil.getParameter(request, prefix	+ "rqst_from_dt", length));
			String[] rqstToDt = (JSPUtil.getParameter(request, prefix	+ "rqst_to_dt", length));
			String[] blCertiSeq = (JSPUtil.getParameter(request, prefix	+ "bl_certi_seq", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] blCertiPrnFlg = (JSPUtil.getParameter(request, prefix	+ "bl_certi_prn_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCertiRqstVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (clptNm5[i] != null)
					model.setClptNm5(clptNm5[i]);
				if (clptNm4[i] != null)
					model.setClptNm4(clptNm4[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (clptNm3[i] != null)
					model.setClptNm3(clptNm3[i]);
				if (clptNm2[i] != null)
					model.setClptNm2(clptNm2[i]);
				if (clptNm1[i] != null)
					model.setClptNm1(clptNm1[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (attrCtnt3[i] != null)
					model.setAttrCtnt3(attrCtnt3[i]);
				if (attrCtnt4[i] != null)
					model.setAttrCtnt4(attrCtnt4[i]);
				if (blCertiRmk[i] != null)
					model.setBlCertiRmk(blCertiRmk[i]);
				if (attrCtnt5[i] != null)
					model.setAttrCtnt5(attrCtnt5[i]);
				if (blCertiStsCd[i] != null)
					model.setBlCertiStsCd(blCertiStsCd[i]);
				if (attrCtnt6[i] != null)
					model.setAttrCtnt6(attrCtnt6[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				if (onBrdDt[i] != null)
					model.setOnBrdDt(onBrdDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rjctRsnRmk[i] != null)
					model.setRjctRsnRmk(rjctRsnRmk[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (itmCdCtnt[i] != null)
					model.setItmCdCtnt(itmCdCtnt[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (issRqstDt[i] != null)
					model.setIssRqstDt(issRqstDt[i]);
				if (tmpltFlg[i] != null)
					model.setTmpltFlg(tmpltFlg[i]);
				if (cmplDt[i] != null)
					model.setCmplDt(cmplDt[i]);
				if (hdTitCtnt[i] != null)
					model.setHdTitCtnt(hdTitCtnt[i]);
				if (rjctDt[i] != null)
					model.setRjctDt(rjctDt[i]);
				if (blCertiSeq[i] != null)
					model.setBlCertiSeq(blCertiSeq[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				
				
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (blCertiSts[i] != null)
					model.setBlCertiSts(blCertiSts[i]);
				if (rqstFromDt[i] != null)
					model.setRqstFromDt(rqstFromDt[i]);
				if (rqstToDt[i] != null)
					model.setRqstToDt(rqstToDt[i]);
				if (blCertiPrnFlg[i] != null)
					model.setBlCertiPrnFlg(blCertiPrnFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCertiRqstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCertiRqstVO[]
	 */
	public BlCertiRqstVO[] getBlCertiRqstVOs(){
		BlCertiRqstVO[] vos = (BlCertiRqstVO[])models.toArray(new BlCertiRqstVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptNm5 = this.clptNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptNm4 = this.clptNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptNm3 = this.clptNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptNm2 = this.clptNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptNm1 = this.clptNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 = this.attrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 = this.attrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCertiRmk = this.blCertiRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 = this.attrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCertiStsCd = this.blCertiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 = this.attrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onBrdDt = this.onBrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctRsnRmk = this.rjctRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCdCtnt = this.itmCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issRqstDt = this.issRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpltFlg = this.tmpltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmplDt = this.cmplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdTitCtnt = this.hdTitCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctDt = this.rjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCertiSts = this.blCertiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFromDt = this.rqstFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstToDt = this.rqstToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCertiSeq = this.blCertiSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCertiPrnFlg = this.blCertiPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
