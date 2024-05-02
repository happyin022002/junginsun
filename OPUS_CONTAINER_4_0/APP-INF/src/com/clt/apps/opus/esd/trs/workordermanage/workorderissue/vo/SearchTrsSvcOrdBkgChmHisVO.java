/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchTrsSvcOrdBkgChmHisVO.java
*@FileTitle : SearchTrsSvcOrdBkgChmHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class SearchTrsSvcOrdBkgChmHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTrsSvcOrdBkgChmHisVO> models = new ArrayList<SearchTrsSvcOrdBkgChmHisVO>();
	
	/* Column Info */
	private String bkgCngGroup = null;
	/* Column Info */
	private String cngCateSubCdDesc = null;
	/* Column Info */
	private String newColnm1 = null;
	/* Column Info */
	private String colNm = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String bkgTrspSoSeq = null;
	/* Column Info */
	private String cngCateCd = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgCntrTpszCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newValue = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String preVal1 = null;
	/* Column Info */
	private String trspCngSubSeq = null;
	/* Column Info */
	private String nowReadVal = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cngCateSubCd = null;
	/* Column Info */
	private String trspSoSubSeq = null;
	/* Column Info */
	private String preVal = null;
	/* Column Info */
	private String catCateSub = null;
	/* Column Info */
	private String bkgCngIndFlg = null;
	/* Column Info */
	private String newColnm = null;
	/* Column Info */
	private String bkgTrspSoOfcCtyCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String newVal1 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String previousVal = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cngCateCdDesc = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String trspSoOfcCtyCdSeq = null;
	/* Column Info */
	private String previousValue = null;
	/* Column Info */
	private String cngIndFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchTrsSvcOrdBkgChmHisVO() {}

	public SearchTrsSvcOrdBkgChmHisVO(String ibflag, String pagerows, String bkgCngGroup, String bkgNo, String eqNo, String cntrNo, String eqTpszCd, String bkgCntrTpszCd, String trspSoOfcCtyCdSeq, String trspSoOfcCtyCd, String trspSoSeq, String trspSoSubSeq, String trspCngSubSeq, String cngCateCd, String catCateSub, String cngCateSubCd, String bkgTrspSoOfcCtyCd, String bkgTrspSoSeq, String cngIndFlg, String bkgCngIndFlg, String colNm, String newValue, String previousValue, String usrNm, String ofcCd, String updUsrId, String loclUpdDt, String updDt, String newColnm1, String newVal1, String preVal1, String cngCateCdDesc, String cngCateSubCdDesc, String nowReadVal, String previousVal, String newColnm, String preVal) {
		this.bkgCngGroup = bkgCngGroup;
		this.cngCateSubCdDesc = cngCateSubCdDesc;
		this.newColnm1 = newColnm1;
		this.colNm = colNm;
		this.trspSoSeq = trspSoSeq;
		this.bkgTrspSoSeq = bkgTrspSoSeq;
		this.cngCateCd = cngCateCd;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
		this.bkgCntrTpszCd = bkgCntrTpszCd;
		this.ibflag = ibflag;
		this.newValue = newValue;
		this.eqNo = eqNo;
		this.usrNm = usrNm;
		this.preVal1 = preVal1;
		this.trspCngSubSeq = trspCngSubSeq;
		this.nowReadVal = nowReadVal;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.cngCateSubCd = cngCateSubCd;
		this.trspSoSubSeq = trspSoSubSeq;
		this.preVal = preVal;
		this.catCateSub = catCateSub;
		this.bkgCngIndFlg = bkgCngIndFlg;
		this.newColnm = newColnm;
		this.bkgTrspSoOfcCtyCd = bkgTrspSoOfcCtyCd;
		this.eqTpszCd = eqTpszCd;
		this.newVal1 = newVal1;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.previousVal = previousVal;
		this.cntrNo = cntrNo;
		this.cngCateCdDesc = cngCateCdDesc;
		this.loclUpdDt = loclUpdDt;
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
		this.previousValue = previousValue;
		this.cngIndFlg = cngIndFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cng_group", getBkgCngGroup());
		this.hashColumns.put("cng_cate_sub_cd_desc", getCngCateSubCdDesc());
		this.hashColumns.put("new_colnm1", getNewColnm1());
		this.hashColumns.put("col_nm", getColNm());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("bkg_trsp_so_seq", getBkgTrspSoSeq());
		this.hashColumns.put("cng_cate_cd", getCngCateCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_cntr_tpsz_cd", getBkgCntrTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_value", getNewValue());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("pre_val1", getPreVal1());
		this.hashColumns.put("trsp_cng_sub_seq", getTrspCngSubSeq());
		this.hashColumns.put("now_read_val", getNowReadVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cng_cate_sub_cd", getCngCateSubCd());
		this.hashColumns.put("trsp_so_sub_seq", getTrspSoSubSeq());
		this.hashColumns.put("pre_val", getPreVal());
		this.hashColumns.put("cat_cate_sub", getCatCateSub());
		this.hashColumns.put("bkg_cng_ind_flg", getBkgCngIndFlg());
		this.hashColumns.put("new_colnm", getNewColnm());
		this.hashColumns.put("bkg_trsp_so_ofc_cty_cd", getBkgTrspSoOfcCtyCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("new_val1", getNewVal1());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("previous_val", getPreviousVal());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cng_cate_cd_desc", getCngCateCdDesc());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("trsp_so_ofc_cty_cd_seq", getTrspSoOfcCtyCdSeq());
		this.hashColumns.put("previous_value", getPreviousValue());
		this.hashColumns.put("cng_ind_flg", getCngIndFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cng_group", "bkgCngGroup");
		this.hashFields.put("cng_cate_sub_cd_desc", "cngCateSubCdDesc");
		this.hashFields.put("new_colnm1", "newColnm1");
		this.hashFields.put("col_nm", "colNm");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("bkg_trsp_so_seq", "bkgTrspSoSeq");
		this.hashFields.put("cng_cate_cd", "cngCateCd");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_cntr_tpsz_cd", "bkgCntrTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_value", "newValue");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("pre_val1", "preVal1");
		this.hashFields.put("trsp_cng_sub_seq", "trspCngSubSeq");
		this.hashFields.put("now_read_val", "nowReadVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cng_cate_sub_cd", "cngCateSubCd");
		this.hashFields.put("trsp_so_sub_seq", "trspSoSubSeq");
		this.hashFields.put("pre_val", "preVal");
		this.hashFields.put("cat_cate_sub", "catCateSub");
		this.hashFields.put("bkg_cng_ind_flg", "bkgCngIndFlg");
		this.hashFields.put("new_colnm", "newColnm");
		this.hashFields.put("bkg_trsp_so_ofc_cty_cd", "bkgTrspSoOfcCtyCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("new_val1", "newVal1");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("previous_val", "previousVal");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cng_cate_cd_desc", "cngCateCdDesc");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("trsp_so_ofc_cty_cd_seq", "trspSoOfcCtyCdSeq");
		this.hashFields.put("previous_value", "previousValue");
		this.hashFields.put("cng_ind_flg", "cngIndFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgCngGroup
	 */
	public String getBkgCngGroup() {
		return this.bkgCngGroup;
	}
	
	/**
	 * Column Info
	 * @return cngCateSubCdDesc
	 */
	public String getCngCateSubCdDesc() {
		return this.cngCateSubCdDesc;
	}
	
	/**
	 * Column Info
	 * @return newColnm1
	 */
	public String getNewColnm1() {
		return this.newColnm1;
	}
	
	/**
	 * Column Info
	 * @return colNm
	 */
	public String getColNm() {
		return this.colNm;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgTrspSoSeq
	 */
	public String getBkgTrspSoSeq() {
		return this.bkgTrspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return cngCateCd
	 */
	public String getCngCateCd() {
		return this.cngCateCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
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
	 * @return bkgCntrTpszCd
	 */
	public String getBkgCntrTpszCd() {
		return this.bkgCntrTpszCd;
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
	 * @return newValue
	 */
	public String getNewValue() {
		return this.newValue;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return preVal1
	 */
	public String getPreVal1() {
		return this.preVal1;
	}
	
	/**
	 * Column Info
	 * @return trspCngSubSeq
	 */
	public String getTrspCngSubSeq() {
		return this.trspCngSubSeq;
	}
	
	/**
	 * Column Info
	 * @return nowReadVal
	 */
	public String getNowReadVal() {
		return this.nowReadVal;
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
	 * @return cngCateSubCd
	 */
	public String getCngCateSubCd() {
		return this.cngCateSubCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoSubSeq
	 */
	public String getTrspSoSubSeq() {
		return this.trspSoSubSeq;
	}
	
	/**
	 * Column Info
	 * @return preVal
	 */
	public String getPreVal() {
		return this.preVal;
	}
	
	/**
	 * Column Info
	 * @return catCateSub
	 */
	public String getCatCateSub() {
		return this.catCateSub;
	}
	
	/**
	 * Column Info
	 * @return bkgCngIndFlg
	 */
	public String getBkgCngIndFlg() {
		return this.bkgCngIndFlg;
	}
	
	/**
	 * Column Info
	 * @return newColnm
	 */
	public String getNewColnm() {
		return this.newColnm;
	}
	
	/**
	 * Column Info
	 * @return bkgTrspSoOfcCtyCd
	 */
	public String getBkgTrspSoOfcCtyCd() {
		return this.bkgTrspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return newVal1
	 */
	public String getNewVal1() {
		return this.newVal1;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return previousVal
	 */
	public String getPreviousVal() {
		return this.previousVal;
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
	 * @return cngCateCdDesc
	 */
	public String getCngCateCdDesc() {
		return this.cngCateCdDesc;
	}
	
	/**
	 * Column Info
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCdSeq
	 */
	public String getTrspSoOfcCtyCdSeq() {
		return this.trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @return previousValue
	 */
	public String getPreviousValue() {
		return this.previousValue;
	}
	
	/**
	 * Column Info
	 * @return cngIndFlg
	 */
	public String getCngIndFlg() {
		return this.cngIndFlg;
	}
	

	/**
	 * Column Info
	 * @param bkgCngGroup
	 */
	public void setBkgCngGroup(String bkgCngGroup) {
		this.bkgCngGroup = bkgCngGroup;
	}
	
	/**
	 * Column Info
	 * @param cngCateSubCdDesc
	 */
	public void setCngCateSubCdDesc(String cngCateSubCdDesc) {
		this.cngCateSubCdDesc = cngCateSubCdDesc;
	}
	
	/**
	 * Column Info
	 * @param newColnm1
	 */
	public void setNewColnm1(String newColnm1) {
		this.newColnm1 = newColnm1;
	}
	
	/**
	 * Column Info
	 * @param colNm
	 */
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgTrspSoSeq
	 */
	public void setBkgTrspSoSeq(String bkgTrspSoSeq) {
		this.bkgTrspSoSeq = bkgTrspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param cngCateCd
	 */
	public void setCngCateCd(String cngCateCd) {
		this.cngCateCd = cngCateCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
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
	 * @param bkgCntrTpszCd
	 */
	public void setBkgCntrTpszCd(String bkgCntrTpszCd) {
		this.bkgCntrTpszCd = bkgCntrTpszCd;
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
	 * @param newValue
	 */
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param preVal1
	 */
	public void setPreVal1(String preVal1) {
		this.preVal1 = preVal1;
	}
	
	/**
	 * Column Info
	 * @param trspCngSubSeq
	 */
	public void setTrspCngSubSeq(String trspCngSubSeq) {
		this.trspCngSubSeq = trspCngSubSeq;
	}
	
	/**
	 * Column Info
	 * @param nowReadVal
	 */
	public void setNowReadVal(String nowReadVal) {
		this.nowReadVal = nowReadVal;
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
	 * @param cngCateSubCd
	 */
	public void setCngCateSubCd(String cngCateSubCd) {
		this.cngCateSubCd = cngCateSubCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoSubSeq
	 */
	public void setTrspSoSubSeq(String trspSoSubSeq) {
		this.trspSoSubSeq = trspSoSubSeq;
	}
	
	/**
	 * Column Info
	 * @param preVal
	 */
	public void setPreVal(String preVal) {
		this.preVal = preVal;
	}
	
	/**
	 * Column Info
	 * @param catCateSub
	 */
	public void setCatCateSub(String catCateSub) {
		this.catCateSub = catCateSub;
	}
	
	/**
	 * Column Info
	 * @param bkgCngIndFlg
	 */
	public void setBkgCngIndFlg(String bkgCngIndFlg) {
		this.bkgCngIndFlg = bkgCngIndFlg;
	}
	
	/**
	 * Column Info
	 * @param newColnm
	 */
	public void setNewColnm(String newColnm) {
		this.newColnm = newColnm;
	}
	
	/**
	 * Column Info
	 * @param bkgTrspSoOfcCtyCd
	 */
	public void setBkgTrspSoOfcCtyCd(String bkgTrspSoOfcCtyCd) {
		this.bkgTrspSoOfcCtyCd = bkgTrspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param newVal1
	 */
	public void setNewVal1(String newVal1) {
		this.newVal1 = newVal1;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param previousVal
	 */
	public void setPreviousVal(String previousVal) {
		this.previousVal = previousVal;
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
	 * @param cngCateCdDesc
	 */
	public void setCngCateCdDesc(String cngCateCdDesc) {
		this.cngCateCdDesc = cngCateCdDesc;
	}
	
	/**
	 * Column Info
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCdSeq
	 */
	public void setTrspSoOfcCtyCdSeq(String trspSoOfcCtyCdSeq) {
		this.trspSoOfcCtyCdSeq = trspSoOfcCtyCdSeq;
	}
	
	/**
	 * Column Info
	 * @param previousValue
	 */
	public void setPreviousValue(String previousValue) {
		this.previousValue = previousValue;
	}
	
	/**
	 * Column Info
	 * @param cngIndFlg
	 */
	public void setCngIndFlg(String cngIndFlg) {
		this.cngIndFlg = cngIndFlg;
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
		setBkgCngGroup(JSPUtil.getParameter(request, prefix + "bkg_cng_group", ""));
		setCngCateSubCdDesc(JSPUtil.getParameter(request, prefix + "cng_cate_sub_cd_desc", ""));
		setNewColnm1(JSPUtil.getParameter(request, prefix + "new_colnm1", ""));
		setColNm(JSPUtil.getParameter(request, prefix + "col_nm", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setBkgTrspSoSeq(JSPUtil.getParameter(request, prefix + "bkg_trsp_so_seq", ""));
		setCngCateCd(JSPUtil.getParameter(request, prefix + "cng_cate_cd", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgCntrTpszCd(JSPUtil.getParameter(request, prefix + "bkg_cntr_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNewValue(JSPUtil.getParameter(request, prefix + "new_value", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setPreVal1(JSPUtil.getParameter(request, prefix + "pre_val1", ""));
		setTrspCngSubSeq(JSPUtil.getParameter(request, prefix + "trsp_cng_sub_seq", ""));
		setNowReadVal(JSPUtil.getParameter(request, prefix + "now_read_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCngCateSubCd(JSPUtil.getParameter(request, prefix + "cng_cate_sub_cd", ""));
		setTrspSoSubSeq(JSPUtil.getParameter(request, prefix + "trsp_so_sub_seq", ""));
		setPreVal(JSPUtil.getParameter(request, prefix + "pre_val", ""));
		setCatCateSub(JSPUtil.getParameter(request, prefix + "cat_cate_sub", ""));
		setBkgCngIndFlg(JSPUtil.getParameter(request, prefix + "bkg_cng_ind_flg", ""));
		setNewColnm(JSPUtil.getParameter(request, prefix + "new_colnm", ""));
		setBkgTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "bkg_trsp_so_ofc_cty_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setNewVal1(JSPUtil.getParameter(request, prefix + "new_val1", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPreviousVal(JSPUtil.getParameter(request, prefix + "previous_val", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCngCateCdDesc(JSPUtil.getParameter(request, prefix + "cng_cate_cd_desc", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, prefix + "locl_upd_dt", ""));
		setTrspSoOfcCtyCdSeq(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd_seq", ""));
		setPreviousValue(JSPUtil.getParameter(request, prefix + "previous_value", ""));
		setCngIndFlg(JSPUtil.getParameter(request, prefix + "cng_ind_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTrsSvcOrdBkgChmHisVO[]
	 */
	public SearchTrsSvcOrdBkgChmHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTrsSvcOrdBkgChmHisVO[]
	 */
	public SearchTrsSvcOrdBkgChmHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTrsSvcOrdBkgChmHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCngGroup = (JSPUtil.getParameter(request, prefix	+ "bkg_cng_group", length));
			String[] cngCateSubCdDesc = (JSPUtil.getParameter(request, prefix	+ "cng_cate_sub_cd_desc", length));
			String[] newColnm1 = (JSPUtil.getParameter(request, prefix	+ "new_colnm1", length));
			String[] colNm = (JSPUtil.getParameter(request, prefix	+ "col_nm", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] bkgTrspSoSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_trsp_so_seq", length));
			String[] cngCateCd = (JSPUtil.getParameter(request, prefix	+ "cng_cate_cd", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newValue = (JSPUtil.getParameter(request, prefix	+ "new_value", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] preVal1 = (JSPUtil.getParameter(request, prefix	+ "pre_val1", length));
			String[] trspCngSubSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_cng_sub_seq", length));
			String[] nowReadVal = (JSPUtil.getParameter(request, prefix	+ "now_read_val", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cngCateSubCd = (JSPUtil.getParameter(request, prefix	+ "cng_cate_sub_cd", length));
			String[] trspSoSubSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_sub_seq", length));
			String[] preVal = (JSPUtil.getParameter(request, prefix	+ "pre_val", length));
			String[] catCateSub = (JSPUtil.getParameter(request, prefix	+ "cat_cate_sub", length));
			String[] bkgCngIndFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_cng_ind_flg", length));
			String[] newColnm = (JSPUtil.getParameter(request, prefix	+ "new_colnm", length));
			String[] bkgTrspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "bkg_trsp_so_ofc_cty_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] newVal1 = (JSPUtil.getParameter(request, prefix	+ "new_val1", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] previousVal = (JSPUtil.getParameter(request, prefix	+ "previous_val", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cngCateCdDesc = (JSPUtil.getParameter(request, prefix	+ "cng_cate_cd_desc", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix	+ "locl_upd_dt", length));
			String[] trspSoOfcCtyCdSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd_seq", length));
			String[] previousValue = (JSPUtil.getParameter(request, prefix	+ "previous_value", length));
			String[] cngIndFlg = (JSPUtil.getParameter(request, prefix	+ "cng_ind_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTrsSvcOrdBkgChmHisVO();
				if (bkgCngGroup[i] != null)
					model.setBkgCngGroup(bkgCngGroup[i]);
				if (cngCateSubCdDesc[i] != null)
					model.setCngCateSubCdDesc(cngCateSubCdDesc[i]);
				if (newColnm1[i] != null)
					model.setNewColnm1(newColnm1[i]);
				if (colNm[i] != null)
					model.setColNm(colNm[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (bkgTrspSoSeq[i] != null)
					model.setBkgTrspSoSeq(bkgTrspSoSeq[i]);
				if (cngCateCd[i] != null)
					model.setCngCateCd(cngCateCd[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgCntrTpszCd[i] != null)
					model.setBkgCntrTpszCd(bkgCntrTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newValue[i] != null)
					model.setNewValue(newValue[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (preVal1[i] != null)
					model.setPreVal1(preVal1[i]);
				if (trspCngSubSeq[i] != null)
					model.setTrspCngSubSeq(trspCngSubSeq[i]);
				if (nowReadVal[i] != null)
					model.setNowReadVal(nowReadVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cngCateSubCd[i] != null)
					model.setCngCateSubCd(cngCateSubCd[i]);
				if (trspSoSubSeq[i] != null)
					model.setTrspSoSubSeq(trspSoSubSeq[i]);
				if (preVal[i] != null)
					model.setPreVal(preVal[i]);
				if (catCateSub[i] != null)
					model.setCatCateSub(catCateSub[i]);
				if (bkgCngIndFlg[i] != null)
					model.setBkgCngIndFlg(bkgCngIndFlg[i]);
				if (newColnm[i] != null)
					model.setNewColnm(newColnm[i]);
				if (bkgTrspSoOfcCtyCd[i] != null)
					model.setBkgTrspSoOfcCtyCd(bkgTrspSoOfcCtyCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (newVal1[i] != null)
					model.setNewVal1(newVal1[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (previousVal[i] != null)
					model.setPreviousVal(previousVal[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cngCateCdDesc[i] != null)
					model.setCngCateCdDesc(cngCateCdDesc[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (trspSoOfcCtyCdSeq[i] != null)
					model.setTrspSoOfcCtyCdSeq(trspSoOfcCtyCdSeq[i]);
				if (previousValue[i] != null)
					model.setPreviousValue(previousValue[i]);
				if (cngIndFlg[i] != null)
					model.setCngIndFlg(cngIndFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTrsSvcOrdBkgChmHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTrsSvcOrdBkgChmHisVO[]
	 */
	public SearchTrsSvcOrdBkgChmHisVO[] getSearchTrsSvcOrdBkgChmHisVOs(){
		SearchTrsSvcOrdBkgChmHisVO[] vos = (SearchTrsSvcOrdBkgChmHisVO[])models.toArray(new SearchTrsSvcOrdBkgChmHisVO[models.size()]);
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
		this.bkgCngGroup = this.bkgCngGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngCateSubCdDesc = this.cngCateSubCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newColnm1 = this.newColnm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colNm = this.colNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspSoSeq = this.bkgTrspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngCateCd = this.cngCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrTpszCd = this.bkgCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newValue = this.newValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVal1 = this.preVal1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCngSubSeq = this.trspCngSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nowReadVal = this.nowReadVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngCateSubCd = this.cngCateSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSubSeq = this.trspSoSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVal = this.preVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.catCateSub = this.catCateSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCngIndFlg = this.bkgCngIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newColnm = this.newColnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspSoOfcCtyCd = this.bkgTrspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVal1 = this.newVal1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.previousVal = this.previousVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngCateCdDesc = this.cngCateCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCdSeq = this.trspSoOfcCtyCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.previousValue = this.previousValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngIndFlg = this.cngIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
