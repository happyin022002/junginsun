/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RqstPlanInfoVO.java
*@FileTitle : RqstPlanInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.26 박창준 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 박창준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RqstPlanInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RqstPlanInfoVO> models = new ArrayList<RqstPlanInfoVO>();
	
	/* Column Info */
	private String fieldOne4 = null;
	/* Column Info */
	private String fmGenExpnItmDesc = null;
	/* Column Info */
	private String toGenExpnCd = null;
	/* Column Info */
	private String fmOfcCd = null;
	/* Column Info */
	private String fieldOne2 = null;
	/* Column Info */
	private String fieldOne3 = null;
	/* Column Info */
	private String fieldTwo4 = null;
	/* Column Info */
	private String fieldTwo3 = null;
	/* Column Info */
	private String fieldTwo2 = null;
	/* Column Info */
	private String fieldOne1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fieldTree = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String fmGenExpnItmNo = null;
	/* Column Info */
	private String fieldTree2 = null;
	/* Column Info */
	private String toGenExpnItmNo = null;
	/* Column Info */
	private String toGenExpnItmNo1 = null;
	/* Column Info */
	private String fieldTree3 = null;
	/* Column Info */
	private String fieldTree1 = null;
	/* Column Info */
	private String fmRqAmt1 = null;
	/* Column Info */
	private String fieldOne = null;
	/* Column Info */
	private String fieldTree4 = null;
	/* Column Info */
	private String genExpnRqstNo1 = null;
	/* Column Info */
	private String genExpnRqstNo4 = null;
	/* Column Info */
	private String genExpnRqstNo2 = null;
	/* Column Info */
	private String genExpnRqstNo3 = null;
	/* Column Info */
	private String toOfcCd = null;
	/* Column Info */
	private String toRqAmt = null;
	/* Column Info */
	private String toLoclCurrCd = null;
	/* Column Info */
	private String fmGenExpnItmNo1 = null;
	/* Column Info */
	private String toGenExpnItmDesc1 = null;
	/* Column Info */
	private String fmLoclCurrCd = null;
	/* Column Info */
	private String toRqstUtVal = null;
	/* Column Info */
	private String fieldFour1 = null;
	/* Column Info */
	private String toGenExpnItmDesc = null;
	/* Column Info */
	private String fieldFour2 = null;
	/* Column Info */
	private String fieldFour3 = null;
	/* Column Info */
	private String fieldFour4 = null;
	/* Column Info */
	private String fmGenExpnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String fieldTwo = null;
	/* Column Info */
	private String fmGenExpnItmDesc1 = null;
	/* Column Info */
	private String fieldFour = null;
	/* Column Info */
	private String fmRqstUtVal = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String fieldTwo1 = null;
	/* Column Info */
	private String fmRqAmt = null;
	/* Column Info */
	private String toRqAmt1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RqstPlanInfoVO() {}

	public RqstPlanInfoVO(String ibflag, String pagerows, String genExpnRqstNo, String genExpnRqstNo1, String genExpnRqstNo2, String genExpnRqstNo3, String genExpnRqstNo4, String genExpnCd, String genExpnRqstSeq, String fieldOne, String fieldTwo, String fieldTree, String fieldFour, String fieldOne1, String fieldTwo1, String fieldTree1, String fieldFour1, String fieldOne2, String fieldTwo2, String fieldTree2, String fieldFour2, String fieldOne3, String fieldTwo3, String fieldTree3, String fieldFour3, String fieldOne4, String fieldTwo4, String fieldTree4, String fieldFour4, String fmGenExpnCd, String toGenExpnCd, String fmOfcCd, String toOfcCd, String fmLoclCurrCd, String toLoclCurrCd, String fmRqstUtVal, String toRqstUtVal, String fmGenExpnItmNo, String fmGenExpnItmNo1, String toGenExpnItmNo, String toGenExpnItmNo1, String fmGenExpnItmDesc, String fmGenExpnItmDesc1, String toGenExpnItmDesc, String toGenExpnItmDesc1, String plnYrmon, String fmRqAmt, String fmRqAmt1, String toRqAmt, String toRqAmt1) {
		this.fieldOne4 = fieldOne4;
		this.fmGenExpnItmDesc = fmGenExpnItmDesc;
		this.toGenExpnCd = toGenExpnCd;
		this.fmOfcCd = fmOfcCd;
		this.fieldOne2 = fieldOne2;
		this.fieldOne3 = fieldOne3;
		this.fieldTwo4 = fieldTwo4;
		this.fieldTwo3 = fieldTwo3;
		this.fieldTwo2 = fieldTwo2;
		this.fieldOne1 = fieldOne1;
		this.pagerows = pagerows;
		this.fieldTree = fieldTree;
		this.genExpnRqstNo = genExpnRqstNo;
		this.fmGenExpnItmNo = fmGenExpnItmNo;
		this.fieldTree2 = fieldTree2;
		this.toGenExpnItmNo = toGenExpnItmNo;
		this.toGenExpnItmNo1 = toGenExpnItmNo1;
		this.fieldTree3 = fieldTree3;
		this.fieldTree1 = fieldTree1;
		this.fmRqAmt1 = fmRqAmt1;
		this.fieldOne = fieldOne;
		this.fieldTree4 = fieldTree4;
		this.genExpnRqstNo1 = genExpnRqstNo1;
		this.genExpnRqstNo4 = genExpnRqstNo4;
		this.genExpnRqstNo2 = genExpnRqstNo2;
		this.genExpnRqstNo3 = genExpnRqstNo3;
		this.toOfcCd = toOfcCd;
		this.toRqAmt = toRqAmt;
		this.toLoclCurrCd = toLoclCurrCd;
		this.fmGenExpnItmNo1 = fmGenExpnItmNo1;
		this.toGenExpnItmDesc1 = toGenExpnItmDesc1;
		this.fmLoclCurrCd = fmLoclCurrCd;
		this.toRqstUtVal = toRqstUtVal;
		this.fieldFour1 = fieldFour1;
		this.toGenExpnItmDesc = toGenExpnItmDesc;
		this.fieldFour2 = fieldFour2;
		this.fieldFour3 = fieldFour3;
		this.fieldFour4 = fieldFour4;
		this.fmGenExpnCd = fmGenExpnCd;
		this.ibflag = ibflag;
		this.plnYrmon = plnYrmon;
		this.genExpnCd = genExpnCd;
		this.fieldTwo = fieldTwo;
		this.fmGenExpnItmDesc1 = fmGenExpnItmDesc1;
		this.fieldFour = fieldFour;
		this.fmRqstUtVal = fmRqstUtVal;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.fieldTwo1 = fieldTwo1;
		this.fmRqAmt = fmRqAmt;
		this.toRqAmt1 = toRqAmt1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("field_one4", getFieldOne4());
		this.hashColumns.put("fm_gen_expn_itm_desc", getFmGenExpnItmDesc());
		this.hashColumns.put("to_gen_expn_cd", getToGenExpnCd());
		this.hashColumns.put("fm_ofc_cd", getFmOfcCd());
		this.hashColumns.put("field_one2", getFieldOne2());
		this.hashColumns.put("field_one3", getFieldOne3());
		this.hashColumns.put("field_two4", getFieldTwo4());
		this.hashColumns.put("field_two3", getFieldTwo3());
		this.hashColumns.put("field_two2", getFieldTwo2());
		this.hashColumns.put("field_one1", getFieldOne1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("field_tree", getFieldTree());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("fm_gen_expn_itm_no", getFmGenExpnItmNo());
		this.hashColumns.put("field_tree2", getFieldTree2());
		this.hashColumns.put("to_gen_expn_itm_no", getToGenExpnItmNo());
		this.hashColumns.put("to_gen_expn_itm_no1", getToGenExpnItmNo1());
		this.hashColumns.put("field_tree3", getFieldTree3());
		this.hashColumns.put("field_tree1", getFieldTree1());
		this.hashColumns.put("fm_rq_amt1", getFmRqAmt1());
		this.hashColumns.put("field_one", getFieldOne());
		this.hashColumns.put("field_tree4", getFieldTree4());
		this.hashColumns.put("gen_expn_rqst_no1", getGenExpnRqstNo1());
		this.hashColumns.put("gen_expn_rqst_no4", getGenExpnRqstNo4());
		this.hashColumns.put("gen_expn_rqst_no2", getGenExpnRqstNo2());
		this.hashColumns.put("gen_expn_rqst_no3", getGenExpnRqstNo3());
		this.hashColumns.put("to_ofc_cd", getToOfcCd());
		this.hashColumns.put("to_rq_amt", getToRqAmt());
		this.hashColumns.put("to_locl_curr_cd", getToLoclCurrCd());
		this.hashColumns.put("fm_gen_expn_itm_no1", getFmGenExpnItmNo1());
		this.hashColumns.put("to_gen_expn_itm_desc1", getToGenExpnItmDesc1());
		this.hashColumns.put("fm_locl_curr_cd", getFmLoclCurrCd());
		this.hashColumns.put("to_rqst_ut_val", getToRqstUtVal());
		this.hashColumns.put("field_four1", getFieldFour1());
		this.hashColumns.put("to_gen_expn_itm_desc", getToGenExpnItmDesc());
		this.hashColumns.put("field_four2", getFieldFour2());
		this.hashColumns.put("field_four3", getFieldFour3());
		this.hashColumns.put("field_four4", getFieldFour4());
		this.hashColumns.put("fm_gen_expn_cd", getFmGenExpnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("field_two", getFieldTwo());
		this.hashColumns.put("fm_gen_expn_itm_desc1", getFmGenExpnItmDesc1());
		this.hashColumns.put("field_four", getFieldFour());
		this.hashColumns.put("fm_rqst_ut_val", getFmRqstUtVal());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("field_two1", getFieldTwo1());
		this.hashColumns.put("fm_rq_amt", getFmRqAmt());
		this.hashColumns.put("to_rq_amt1", getToRqAmt1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("field_one4", "fieldOne4");
		this.hashFields.put("fm_gen_expn_itm_desc", "fmGenExpnItmDesc");
		this.hashFields.put("to_gen_expn_cd", "toGenExpnCd");
		this.hashFields.put("fm_ofc_cd", "fmOfcCd");
		this.hashFields.put("field_one2", "fieldOne2");
		this.hashFields.put("field_one3", "fieldOne3");
		this.hashFields.put("field_two4", "fieldTwo4");
		this.hashFields.put("field_two3", "fieldTwo3");
		this.hashFields.put("field_two2", "fieldTwo2");
		this.hashFields.put("field_one1", "fieldOne1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("field_tree", "fieldTree");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("fm_gen_expn_itm_no", "fmGenExpnItmNo");
		this.hashFields.put("field_tree2", "fieldTree2");
		this.hashFields.put("to_gen_expn_itm_no", "toGenExpnItmNo");
		this.hashFields.put("to_gen_expn_itm_no1", "toGenExpnItmNo1");
		this.hashFields.put("field_tree3", "fieldTree3");
		this.hashFields.put("field_tree1", "fieldTree1");
		this.hashFields.put("fm_rq_amt1", "fmRqAmt1");
		this.hashFields.put("field_one", "fieldOne");
		this.hashFields.put("field_tree4", "fieldTree4");
		this.hashFields.put("gen_expn_rqst_no1", "genExpnRqstNo1");
		this.hashFields.put("gen_expn_rqst_no4", "genExpnRqstNo4");
		this.hashFields.put("gen_expn_rqst_no2", "genExpnRqstNo2");
		this.hashFields.put("gen_expn_rqst_no3", "genExpnRqstNo3");
		this.hashFields.put("to_ofc_cd", "toOfcCd");
		this.hashFields.put("to_rq_amt", "toRqAmt");
		this.hashFields.put("to_locl_curr_cd", "toLoclCurrCd");
		this.hashFields.put("fm_gen_expn_itm_no1", "fmGenExpnItmNo1");
		this.hashFields.put("to_gen_expn_itm_desc1", "toGenExpnItmDesc1");
		this.hashFields.put("fm_locl_curr_cd", "fmLoclCurrCd");
		this.hashFields.put("to_rqst_ut_val", "toRqstUtVal");
		this.hashFields.put("field_four1", "fieldFour1");
		this.hashFields.put("to_gen_expn_itm_desc", "toGenExpnItmDesc");
		this.hashFields.put("field_four2", "fieldFour2");
		this.hashFields.put("field_four3", "fieldFour3");
		this.hashFields.put("field_four4", "fieldFour4");
		this.hashFields.put("fm_gen_expn_cd", "fmGenExpnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("field_two", "fieldTwo");
		this.hashFields.put("fm_gen_expn_itm_desc1", "fmGenExpnItmDesc1");
		this.hashFields.put("field_four", "fieldFour");
		this.hashFields.put("fm_rqst_ut_val", "fmRqstUtVal");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("field_two1", "fieldTwo1");
		this.hashFields.put("fm_rq_amt", "fmRqAmt");
		this.hashFields.put("to_rq_amt1", "toRqAmt1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fieldOne4
	 */
	public String getFieldOne4() {
		return this.fieldOne4;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnItmDesc
	 */
	public String getFmGenExpnItmDesc() {
		return this.fmGenExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnCd
	 */
	public String getToGenExpnCd() {
		return this.toGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return fmOfcCd
	 */
	public String getFmOfcCd() {
		return this.fmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fieldOne2
	 */
	public String getFieldOne2() {
		return this.fieldOne2;
	}
	
	/**
	 * Column Info
	 * @return fieldOne3
	 */
	public String getFieldOne3() {
		return this.fieldOne3;
	}
	
	/**
	 * Column Info
	 * @return fieldTwo4
	 */
	public String getFieldTwo4() {
		return this.fieldTwo4;
	}
	
	/**
	 * Column Info
	 * @return fieldTwo3
	 */
	public String getFieldTwo3() {
		return this.fieldTwo3;
	}
	
	/**
	 * Column Info
	 * @return fieldTwo2
	 */
	public String getFieldTwo2() {
		return this.fieldTwo2;
	}
	
	/**
	 * Column Info
	 * @return fieldOne1
	 */
	public String getFieldOne1() {
		return this.fieldOne1;
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
	 * @return fieldTree
	 */
	public String getFieldTree() {
		return this.fieldTree;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnItmNo
	 */
	public String getFmGenExpnItmNo() {
		return this.fmGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return fieldTree2
	 */
	public String getFieldTree2() {
		return this.fieldTree2;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnItmNo
	 */
	public String getToGenExpnItmNo() {
		return this.toGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnItmNo1
	 */
	public String getToGenExpnItmNo1() {
		return this.toGenExpnItmNo1;
	}
	
	/**
	 * Column Info
	 * @return fieldTree3
	 */
	public String getFieldTree3() {
		return this.fieldTree3;
	}
	
	/**
	 * Column Info
	 * @return fieldTree1
	 */
	public String getFieldTree1() {
		return this.fieldTree1;
	}
	
	/**
	 * Column Info
	 * @return fmRqAmt1
	 */
	public String getFmRqAmt1() {
		return this.fmRqAmt1;
	}
	
	/**
	 * Column Info
	 * @return fieldOne
	 */
	public String getFieldOne() {
		return this.fieldOne;
	}
	
	/**
	 * Column Info
	 * @return fieldTree4
	 */
	public String getFieldTree4() {
		return this.fieldTree4;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo1
	 */
	public String getGenExpnRqstNo1() {
		return this.genExpnRqstNo1;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo4
	 */
	public String getGenExpnRqstNo4() {
		return this.genExpnRqstNo4;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo2
	 */
	public String getGenExpnRqstNo2() {
		return this.genExpnRqstNo2;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo3
	 */
	public String getGenExpnRqstNo3() {
		return this.genExpnRqstNo3;
	}
	
	/**
	 * Column Info
	 * @return toOfcCd
	 */
	public String getToOfcCd() {
		return this.toOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toRqAmt
	 */
	public String getToRqAmt() {
		return this.toRqAmt;
	}
	
	/**
	 * Column Info
	 * @return toLoclCurrCd
	 */
	public String getToLoclCurrCd() {
		return this.toLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnItmNo1
	 */
	public String getFmGenExpnItmNo1() {
		return this.fmGenExpnItmNo1;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnItmDesc1
	 */
	public String getToGenExpnItmDesc1() {
		return this.toGenExpnItmDesc1;
	}
	
	/**
	 * Column Info
	 * @return fmLoclCurrCd
	 */
	public String getFmLoclCurrCd() {
		return this.fmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return toRqstUtVal
	 */
	public String getToRqstUtVal() {
		return this.toRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return fieldFour1
	 */
	public String getFieldFour1() {
		return this.fieldFour1;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnItmDesc
	 */
	public String getToGenExpnItmDesc() {
		return this.toGenExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @return fieldFour2
	 */
	public String getFieldFour2() {
		return this.fieldFour2;
	}
	
	/**
	 * Column Info
	 * @return fieldFour3
	 */
	public String getFieldFour3() {
		return this.fieldFour3;
	}
	
	/**
	 * Column Info
	 * @return fieldFour4
	 */
	public String getFieldFour4() {
		return this.fieldFour4;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnCd
	 */
	public String getFmGenExpnCd() {
		return this.fmGenExpnCd;
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
	 * @return plnYrmon
	 */
	public String getPlnYrmon() {
		return this.plnYrmon;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return fieldTwo
	 */
	public String getFieldTwo() {
		return this.fieldTwo;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnItmDesc1
	 */
	public String getFmGenExpnItmDesc1() {
		return this.fmGenExpnItmDesc1;
	}
	
	/**
	 * Column Info
	 * @return fieldFour
	 */
	public String getFieldFour() {
		return this.fieldFour;
	}
	
	/**
	 * Column Info
	 * @return fmRqstUtVal
	 */
	public String getFmRqstUtVal() {
		return this.fmRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstSeq
	 */
	public String getGenExpnRqstSeq() {
		return this.genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return fieldTwo1
	 */
	public String getFieldTwo1() {
		return this.fieldTwo1;
	}
	
	/**
	 * Column Info
	 * @return fmRqAmt
	 */
	public String getFmRqAmt() {
		return this.fmRqAmt;
	}
	
	/**
	 * Column Info
	 * @return toRqAmt1
	 */
	public String getToRqAmt1() {
		return this.toRqAmt1;
	}
	

	/**
	 * Column Info
	 * @param fieldOne4
	 */
	public void setFieldOne4(String fieldOne4) {
		this.fieldOne4 = fieldOne4;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnItmDesc
	 */
	public void setFmGenExpnItmDesc(String fmGenExpnItmDesc) {
		this.fmGenExpnItmDesc = fmGenExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnCd
	 */
	public void setToGenExpnCd(String toGenExpnCd) {
		this.toGenExpnCd = toGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param fmOfcCd
	 */
	public void setFmOfcCd(String fmOfcCd) {
		this.fmOfcCd = fmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fieldOne2
	 */
	public void setFieldOne2(String fieldOne2) {
		this.fieldOne2 = fieldOne2;
	}
	
	/**
	 * Column Info
	 * @param fieldOne3
	 */
	public void setFieldOne3(String fieldOne3) {
		this.fieldOne3 = fieldOne3;
	}
	
	/**
	 * Column Info
	 * @param fieldTwo4
	 */
	public void setFieldTwo4(String fieldTwo4) {
		this.fieldTwo4 = fieldTwo4;
	}
	
	/**
	 * Column Info
	 * @param fieldTwo3
	 */
	public void setFieldTwo3(String fieldTwo3) {
		this.fieldTwo3 = fieldTwo3;
	}
	
	/**
	 * Column Info
	 * @param fieldTwo2
	 */
	public void setFieldTwo2(String fieldTwo2) {
		this.fieldTwo2 = fieldTwo2;
	}
	
	/**
	 * Column Info
	 * @param fieldOne1
	 */
	public void setFieldOne1(String fieldOne1) {
		this.fieldOne1 = fieldOne1;
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
	 * @param fieldTree
	 */
	public void setFieldTree(String fieldTree) {
		this.fieldTree = fieldTree;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnItmNo
	 */
	public void setFmGenExpnItmNo(String fmGenExpnItmNo) {
		this.fmGenExpnItmNo = fmGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param fieldTree2
	 */
	public void setFieldTree2(String fieldTree2) {
		this.fieldTree2 = fieldTree2;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnItmNo
	 */
	public void setToGenExpnItmNo(String toGenExpnItmNo) {
		this.toGenExpnItmNo = toGenExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnItmNo1
	 */
	public void setToGenExpnItmNo1(String toGenExpnItmNo1) {
		this.toGenExpnItmNo1 = toGenExpnItmNo1;
	}
	
	/**
	 * Column Info
	 * @param fieldTree3
	 */
	public void setFieldTree3(String fieldTree3) {
		this.fieldTree3 = fieldTree3;
	}
	
	/**
	 * Column Info
	 * @param fieldTree1
	 */
	public void setFieldTree1(String fieldTree1) {
		this.fieldTree1 = fieldTree1;
	}
	
	/**
	 * Column Info
	 * @param fmRqAmt1
	 */
	public void setFmRqAmt1(String fmRqAmt1) {
		this.fmRqAmt1 = fmRqAmt1;
	}
	
	/**
	 * Column Info
	 * @param fieldOne
	 */
	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}
	
	/**
	 * Column Info
	 * @param fieldTree4
	 */
	public void setFieldTree4(String fieldTree4) {
		this.fieldTree4 = fieldTree4;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo1
	 */
	public void setGenExpnRqstNo1(String genExpnRqstNo1) {
		this.genExpnRqstNo1 = genExpnRqstNo1;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo4
	 */
	public void setGenExpnRqstNo4(String genExpnRqstNo4) {
		this.genExpnRqstNo4 = genExpnRqstNo4;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo2
	 */
	public void setGenExpnRqstNo2(String genExpnRqstNo2) {
		this.genExpnRqstNo2 = genExpnRqstNo2;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo3
	 */
	public void setGenExpnRqstNo3(String genExpnRqstNo3) {
		this.genExpnRqstNo3 = genExpnRqstNo3;
	}
	
	/**
	 * Column Info
	 * @param toOfcCd
	 */
	public void setToOfcCd(String toOfcCd) {
		this.toOfcCd = toOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toRqAmt
	 */
	public void setToRqAmt(String toRqAmt) {
		this.toRqAmt = toRqAmt;
	}
	
	/**
	 * Column Info
	 * @param toLoclCurrCd
	 */
	public void setToLoclCurrCd(String toLoclCurrCd) {
		this.toLoclCurrCd = toLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnItmNo1
	 */
	public void setFmGenExpnItmNo1(String fmGenExpnItmNo1) {
		this.fmGenExpnItmNo1 = fmGenExpnItmNo1;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnItmDesc1
	 */
	public void setToGenExpnItmDesc1(String toGenExpnItmDesc1) {
		this.toGenExpnItmDesc1 = toGenExpnItmDesc1;
	}
	
	/**
	 * Column Info
	 * @param fmLoclCurrCd
	 */
	public void setFmLoclCurrCd(String fmLoclCurrCd) {
		this.fmLoclCurrCd = fmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param toRqstUtVal
	 */
	public void setToRqstUtVal(String toRqstUtVal) {
		this.toRqstUtVal = toRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param fieldFour1
	 */
	public void setFieldFour1(String fieldFour1) {
		this.fieldFour1 = fieldFour1;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnItmDesc
	 */
	public void setToGenExpnItmDesc(String toGenExpnItmDesc) {
		this.toGenExpnItmDesc = toGenExpnItmDesc;
	}
	
	/**
	 * Column Info
	 * @param fieldFour2
	 */
	public void setFieldFour2(String fieldFour2) {
		this.fieldFour2 = fieldFour2;
	}
	
	/**
	 * Column Info
	 * @param fieldFour3
	 */
	public void setFieldFour3(String fieldFour3) {
		this.fieldFour3 = fieldFour3;
	}
	
	/**
	 * Column Info
	 * @param fieldFour4
	 */
	public void setFieldFour4(String fieldFour4) {
		this.fieldFour4 = fieldFour4;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnCd
	 */
	public void setFmGenExpnCd(String fmGenExpnCd) {
		this.fmGenExpnCd = fmGenExpnCd;
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
	 * @param plnYrmon
	 */
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param fieldTwo
	 */
	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnItmDesc1
	 */
	public void setFmGenExpnItmDesc1(String fmGenExpnItmDesc1) {
		this.fmGenExpnItmDesc1 = fmGenExpnItmDesc1;
	}
	
	/**
	 * Column Info
	 * @param fieldFour
	 */
	public void setFieldFour(String fieldFour) {
		this.fieldFour = fieldFour;
	}
	
	/**
	 * Column Info
	 * @param fmRqstUtVal
	 */
	public void setFmRqstUtVal(String fmRqstUtVal) {
		this.fmRqstUtVal = fmRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstSeq
	 */
	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param fieldTwo1
	 */
	public void setFieldTwo1(String fieldTwo1) {
		this.fieldTwo1 = fieldTwo1;
	}
	
	/**
	 * Column Info
	 * @param fmRqAmt
	 */
	public void setFmRqAmt(String fmRqAmt) {
		this.fmRqAmt = fmRqAmt;
	}
	
	/**
	 * Column Info
	 * @param toRqAmt1
	 */
	public void setToRqAmt1(String toRqAmt1) {
		this.toRqAmt1 = toRqAmt1;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFieldOne4(JSPUtil.getParameter(request, "field_one4", ""));
		setFmGenExpnItmDesc(JSPUtil.getParameter(request, "fm_gen_expn_itm_desc", ""));
		setToGenExpnCd(JSPUtil.getParameter(request, "to_gen_expn_cd", ""));
		setFmOfcCd(JSPUtil.getParameter(request, "fm_ofc_cd", ""));
		setFieldOne2(JSPUtil.getParameter(request, "field_one2", ""));
		setFieldOne3(JSPUtil.getParameter(request, "field_one3", ""));
		setFieldTwo4(JSPUtil.getParameter(request, "field_two4", ""));
		setFieldTwo3(JSPUtil.getParameter(request, "field_two3", ""));
		setFieldTwo2(JSPUtil.getParameter(request, "field_two2", ""));
		setFieldOne1(JSPUtil.getParameter(request, "field_one1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFieldTree(JSPUtil.getParameter(request, "field_tree", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setFmGenExpnItmNo(JSPUtil.getParameter(request, "fm_gen_expn_itm_no", ""));
		setFieldTree2(JSPUtil.getParameter(request, "field_tree2", ""));
		setToGenExpnItmNo(JSPUtil.getParameter(request, "to_gen_expn_itm_no", ""));
		setToGenExpnItmNo1(JSPUtil.getParameter(request, "to_gen_expn_itm_no1", ""));
		setFieldTree3(JSPUtil.getParameter(request, "field_tree3", ""));
		setFieldTree1(JSPUtil.getParameter(request, "field_tree1", ""));
		setFmRqAmt1(JSPUtil.getParameter(request, "fm_rq_amt1", ""));
		setFieldOne(JSPUtil.getParameter(request, "field_one", ""));
		setFieldTree4(JSPUtil.getParameter(request, "field_tree4", ""));
		setGenExpnRqstNo1(JSPUtil.getParameter(request, "gen_expn_rqst_no1", ""));
		setGenExpnRqstNo4(JSPUtil.getParameter(request, "gen_expn_rqst_no4", ""));
		setGenExpnRqstNo2(JSPUtil.getParameter(request, "gen_expn_rqst_no2", ""));
		setGenExpnRqstNo3(JSPUtil.getParameter(request, "gen_expn_rqst_no3", ""));
		setToOfcCd(JSPUtil.getParameter(request, "to_ofc_cd", ""));
		setToRqAmt(JSPUtil.getParameter(request, "to_rq_amt", ""));
		setToLoclCurrCd(JSPUtil.getParameter(request, "to_locl_curr_cd", ""));
		setFmGenExpnItmNo1(JSPUtil.getParameter(request, "fm_gen_expn_itm_no1", ""));
		setToGenExpnItmDesc1(JSPUtil.getParameter(request, "to_gen_expn_itm_desc1", ""));
		setFmLoclCurrCd(JSPUtil.getParameter(request, "fm_locl_curr_cd", ""));
		setToRqstUtVal(JSPUtil.getParameter(request, "to_rqst_ut_val", ""));
		setFieldFour1(JSPUtil.getParameter(request, "field_four1", ""));
		setToGenExpnItmDesc(JSPUtil.getParameter(request, "to_gen_expn_itm_desc", ""));
		setFieldFour2(JSPUtil.getParameter(request, "field_four2", ""));
		setFieldFour3(JSPUtil.getParameter(request, "field_four3", ""));
		setFieldFour4(JSPUtil.getParameter(request, "field_four4", ""));
		setFmGenExpnCd(JSPUtil.getParameter(request, "fm_gen_expn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPlnYrmon(JSPUtil.getParameter(request, "pln_yrmon", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setFieldTwo(JSPUtil.getParameter(request, "field_two", ""));
		setFmGenExpnItmDesc1(JSPUtil.getParameter(request, "fm_gen_expn_itm_desc1", ""));
		setFieldFour(JSPUtil.getParameter(request, "field_four", ""));
		setFmRqstUtVal(JSPUtil.getParameter(request, "fm_rqst_ut_val", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setFieldTwo1(JSPUtil.getParameter(request, "field_two1", ""));
		setFmRqAmt(JSPUtil.getParameter(request, "fm_rq_amt", ""));
		setToRqAmt1(JSPUtil.getParameter(request, "to_rq_amt1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RqstPlanInfoVO[]
	 */
	public RqstPlanInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RqstPlanInfoVO[]
	 */
	public RqstPlanInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RqstPlanInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fieldOne4 = (JSPUtil.getParameter(request, prefix	+ "field_one4", length));
			String[] fmGenExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_desc", length));
			String[] toGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_cd", length));
			String[] fmOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_cd", length));
			String[] fieldOne2 = (JSPUtil.getParameter(request, prefix	+ "field_one2", length));
			String[] fieldOne3 = (JSPUtil.getParameter(request, prefix	+ "field_one3", length));
			String[] fieldTwo4 = (JSPUtil.getParameter(request, prefix	+ "field_two4", length));
			String[] fieldTwo3 = (JSPUtil.getParameter(request, prefix	+ "field_two3", length));
			String[] fieldTwo2 = (JSPUtil.getParameter(request, prefix	+ "field_two2", length));
			String[] fieldOne1 = (JSPUtil.getParameter(request, prefix	+ "field_one1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fieldTree = (JSPUtil.getParameter(request, prefix	+ "field_tree", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] fmGenExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_no", length));
			String[] fieldTree2 = (JSPUtil.getParameter(request, prefix	+ "field_tree2", length));
			String[] toGenExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_no", length));
			String[] toGenExpnItmNo1 = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_no1", length));
			String[] fieldTree3 = (JSPUtil.getParameter(request, prefix	+ "field_tree3", length));
			String[] fieldTree1 = (JSPUtil.getParameter(request, prefix	+ "field_tree1", length));
			String[] fmRqAmt1 = (JSPUtil.getParameter(request, prefix	+ "fm_rq_amt1", length));
			String[] fieldOne = (JSPUtil.getParameter(request, prefix	+ "field_one", length));
			String[] fieldTree4 = (JSPUtil.getParameter(request, prefix	+ "field_tree4", length));
			String[] genExpnRqstNo1 = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no1", length));
			String[] genExpnRqstNo4 = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no4", length));
			String[] genExpnRqstNo2 = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no2", length));
			String[] genExpnRqstNo3 = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no3", length));
			String[] toOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_ofc_cd", length));
			String[] toRqAmt = (JSPUtil.getParameter(request, prefix	+ "to_rq_amt", length));
			String[] toLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_locl_curr_cd", length));
			String[] fmGenExpnItmNo1 = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_no1", length));
			String[] toGenExpnItmDesc1 = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_desc1", length));
			String[] fmLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "fm_locl_curr_cd", length));
			String[] toRqstUtVal = (JSPUtil.getParameter(request, prefix	+ "to_rqst_ut_val", length));
			String[] fieldFour1 = (JSPUtil.getParameter(request, prefix	+ "field_four1", length));
			String[] toGenExpnItmDesc = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_itm_desc", length));
			String[] fieldFour2 = (JSPUtil.getParameter(request, prefix	+ "field_four2", length));
			String[] fieldFour3 = (JSPUtil.getParameter(request, prefix	+ "field_four3", length));
			String[] fieldFour4 = (JSPUtil.getParameter(request, prefix	+ "field_four4", length));
			String[] fmGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] fieldTwo = (JSPUtil.getParameter(request, prefix	+ "field_two", length));
			String[] fmGenExpnItmDesc1 = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_itm_desc1", length));
			String[] fieldFour = (JSPUtil.getParameter(request, prefix	+ "field_four", length));
			String[] fmRqstUtVal = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_ut_val", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] fieldTwo1 = (JSPUtil.getParameter(request, prefix	+ "field_two1", length));
			String[] fmRqAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rq_amt", length));
			String[] toRqAmt1 = (JSPUtil.getParameter(request, prefix	+ "to_rq_amt1", length));
			
			for (int i = 0; i < length; i++) {
				model = new RqstPlanInfoVO();
				if (fieldOne4[i] != null)
					model.setFieldOne4(fieldOne4[i]);
				if (fmGenExpnItmDesc[i] != null)
					model.setFmGenExpnItmDesc(fmGenExpnItmDesc[i]);
				if (toGenExpnCd[i] != null)
					model.setToGenExpnCd(toGenExpnCd[i]);
				if (fmOfcCd[i] != null)
					model.setFmOfcCd(fmOfcCd[i]);
				if (fieldOne2[i] != null)
					model.setFieldOne2(fieldOne2[i]);
				if (fieldOne3[i] != null)
					model.setFieldOne3(fieldOne3[i]);
				if (fieldTwo4[i] != null)
					model.setFieldTwo4(fieldTwo4[i]);
				if (fieldTwo3[i] != null)
					model.setFieldTwo3(fieldTwo3[i]);
				if (fieldTwo2[i] != null)
					model.setFieldTwo2(fieldTwo2[i]);
				if (fieldOne1[i] != null)
					model.setFieldOne1(fieldOne1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fieldTree[i] != null)
					model.setFieldTree(fieldTree[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (fmGenExpnItmNo[i] != null)
					model.setFmGenExpnItmNo(fmGenExpnItmNo[i]);
				if (fieldTree2[i] != null)
					model.setFieldTree2(fieldTree2[i]);
				if (toGenExpnItmNo[i] != null)
					model.setToGenExpnItmNo(toGenExpnItmNo[i]);
				if (toGenExpnItmNo1[i] != null)
					model.setToGenExpnItmNo1(toGenExpnItmNo1[i]);
				if (fieldTree3[i] != null)
					model.setFieldTree3(fieldTree3[i]);
				if (fieldTree1[i] != null)
					model.setFieldTree1(fieldTree1[i]);
				if (fmRqAmt1[i] != null)
					model.setFmRqAmt1(fmRqAmt1[i]);
				if (fieldOne[i] != null)
					model.setFieldOne(fieldOne[i]);
				if (fieldTree4[i] != null)
					model.setFieldTree4(fieldTree4[i]);
				if (genExpnRqstNo1[i] != null)
					model.setGenExpnRqstNo1(genExpnRqstNo1[i]);
				if (genExpnRqstNo4[i] != null)
					model.setGenExpnRqstNo4(genExpnRqstNo4[i]);
				if (genExpnRqstNo2[i] != null)
					model.setGenExpnRqstNo2(genExpnRqstNo2[i]);
				if (genExpnRqstNo3[i] != null)
					model.setGenExpnRqstNo3(genExpnRqstNo3[i]);
				if (toOfcCd[i] != null)
					model.setToOfcCd(toOfcCd[i]);
				if (toRqAmt[i] != null)
					model.setToRqAmt(toRqAmt[i]);
				if (toLoclCurrCd[i] != null)
					model.setToLoclCurrCd(toLoclCurrCd[i]);
				if (fmGenExpnItmNo1[i] != null)
					model.setFmGenExpnItmNo1(fmGenExpnItmNo1[i]);
				if (toGenExpnItmDesc1[i] != null)
					model.setToGenExpnItmDesc1(toGenExpnItmDesc1[i]);
				if (fmLoclCurrCd[i] != null)
					model.setFmLoclCurrCd(fmLoclCurrCd[i]);
				if (toRqstUtVal[i] != null)
					model.setToRqstUtVal(toRqstUtVal[i]);
				if (fieldFour1[i] != null)
					model.setFieldFour1(fieldFour1[i]);
				if (toGenExpnItmDesc[i] != null)
					model.setToGenExpnItmDesc(toGenExpnItmDesc[i]);
				if (fieldFour2[i] != null)
					model.setFieldFour2(fieldFour2[i]);
				if (fieldFour3[i] != null)
					model.setFieldFour3(fieldFour3[i]);
				if (fieldFour4[i] != null)
					model.setFieldFour4(fieldFour4[i]);
				if (fmGenExpnCd[i] != null)
					model.setFmGenExpnCd(fmGenExpnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (fieldTwo[i] != null)
					model.setFieldTwo(fieldTwo[i]);
				if (fmGenExpnItmDesc1[i] != null)
					model.setFmGenExpnItmDesc1(fmGenExpnItmDesc1[i]);
				if (fieldFour[i] != null)
					model.setFieldFour(fieldFour[i]);
				if (fmRqstUtVal[i] != null)
					model.setFmRqstUtVal(fmRqstUtVal[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (fieldTwo1[i] != null)
					model.setFieldTwo1(fieldTwo1[i]);
				if (fmRqAmt[i] != null)
					model.setFmRqAmt(fmRqAmt[i]);
				if (toRqAmt1[i] != null)
					model.setToRqAmt1(toRqAmt1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRqstPlanInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RqstPlanInfoVO[]
	 */
	public RqstPlanInfoVO[] getRqstPlanInfoVOs(){
		RqstPlanInfoVO[] vos = (RqstPlanInfoVO[])models.toArray(new RqstPlanInfoVO[models.size()]);
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
		this.fieldOne4 = this.fieldOne4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmDesc = this.fmGenExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCd = this.toGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcCd = this.fmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldOne2 = this.fieldOne2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldOne3 = this.fieldOne3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTwo4 = this.fieldTwo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTwo3 = this.fieldTwo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTwo2 = this.fieldTwo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldOne1 = this.fieldOne1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTree = this.fieldTree .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmNo = this.fmGenExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTree2 = this.fieldTree2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmNo = this.toGenExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmNo1 = this.toGenExpnItmNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTree3 = this.fieldTree3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTree1 = this.fieldTree1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqAmt1 = this.fmRqAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldOne = this.fieldOne .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTree4 = this.fieldTree4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo1 = this.genExpnRqstNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo4 = this.genExpnRqstNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo2 = this.genExpnRqstNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo3 = this.genExpnRqstNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcCd = this.toOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqAmt = this.toRqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLoclCurrCd = this.toLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmNo1 = this.fmGenExpnItmNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmDesc1 = this.toGenExpnItmDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoclCurrCd = this.fmLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstUtVal = this.toRqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldFour1 = this.fieldFour1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnItmDesc = this.toGenExpnItmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldFour2 = this.fieldFour2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldFour3 = this.fieldFour3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldFour4 = this.fieldFour4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCd = this.fmGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTwo = this.fieldTwo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnItmDesc1 = this.fmGenExpnItmDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldFour = this.fieldFour .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstUtVal = this.fmRqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fieldTwo1 = this.fieldTwo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqAmt = this.fmRqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqAmt1 = this.toRqAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
