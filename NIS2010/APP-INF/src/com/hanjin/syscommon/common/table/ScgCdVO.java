/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ScgCdVO.java
*@FileTitle : ScgCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.01.28 이도형 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table ;

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
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgCdVO> models = new ArrayList<ScgCdVO>();
	
	/* Column Info */
	private String attrDt2 = null;
	/* Column Info */
	private String attrDt1 = null;
	/* Column Info */
	private String attrDt4 = null;
	/* Column Info */
	private String attrVal8 = null;
	/* Column Info */
	private String attrDt3 = null;
	/* Column Info */
	private String attrVal9 = null;
	/* Column Info */
	private String attrCtnt10 = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String attrDt5 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String attrCtnt9 = null;
	/* Column Info */
	private String attrVal2 = null;
	/* Column Info */
	private String attrCtnt8 = null;
	/* Column Info */
	private String attrVal3 = null;
	/* Column Info */
	private String attrVal1 = null;
	/* Column Info */
	private String attrVal6 = null;
	/* Column Info */
	private String attrVal7 = null;
	/* Column Info */
	private String attrVal4 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String attrVal5 = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attrCtnt3 = null;
	/* Column Info */
	private String attrCtnt4 = null;
	/* Column Info */
	private String attrCtnt5 = null;
	/* Column Info */
	private String attrCtnt6 = null;
	/* Column Info */
	private String attrCtnt7 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String valCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cdNm = null;
	/* Column Info */
	private String attrVal10 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cdTblId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgCdVO() {}

	public ScgCdVO(String ibflag, String pagerows, String cdTblId, String valCd, String cdNm, String attrCtnt1, String attrCtnt2, String attrCtnt3, String attrCtnt4, String attrCtnt5, String attrCtnt6, String attrCtnt7, String attrCtnt8, String attrCtnt9, String attrCtnt10, String attrVal1, String attrVal2, String attrVal3, String attrVal4, String attrVal5, String attrVal6, String attrVal7, String attrVal8, String attrVal9, String attrVal10, String attrDt1, String attrDt2, String attrDt3, String attrDt4, String attrDt5, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.attrDt2 = attrDt2;
		this.attrDt1 = attrDt1;
		this.attrDt4 = attrDt4;
		this.attrVal8 = attrVal8;
		this.attrDt3 = attrDt3;
		this.attrVal9 = attrVal9;
		this.attrCtnt10 = attrCtnt10;
		this.deltFlg = deltFlg;
		this.attrDt5 = attrDt5;
		this.creDt = creDt;
		this.attrCtnt9 = attrCtnt9;
		this.attrVal2 = attrVal2;
		this.attrCtnt8 = attrCtnt8;
		this.attrVal3 = attrVal3;
		this.attrVal1 = attrVal1;
		this.attrVal6 = attrVal6;
		this.attrVal7 = attrVal7;
		this.attrVal4 = attrVal4;
		this.pagerows = pagerows;
		this.attrVal5 = attrVal5;
		this.attrCtnt1 = attrCtnt1;
		this.attrCtnt2 = attrCtnt2;
		this.ibflag = ibflag;
		this.attrCtnt3 = attrCtnt3;
		this.attrCtnt4 = attrCtnt4;
		this.attrCtnt5 = attrCtnt5;
		this.attrCtnt6 = attrCtnt6;
		this.attrCtnt7 = attrCtnt7;
		this.updUsrId = updUsrId;
		this.valCd = valCd;
		this.updDt = updDt;
		this.cdNm = cdNm;
		this.attrVal10 = attrVal10;
		this.creUsrId = creUsrId;
		this.cdTblId = cdTblId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("attr_dt2", getAttrDt2());
		this.hashColumns.put("attr_dt1", getAttrDt1());
		this.hashColumns.put("attr_dt4", getAttrDt4());
		this.hashColumns.put("attr_val8", getAttrVal8());
		this.hashColumns.put("attr_dt3", getAttrDt3());
		this.hashColumns.put("attr_val9", getAttrVal9());
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("attr_dt5", getAttrDt5());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());
		this.hashColumns.put("attr_val2", getAttrVal2());
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());
		this.hashColumns.put("attr_val3", getAttrVal3());
		this.hashColumns.put("attr_val1", getAttrVal1());
		this.hashColumns.put("attr_val6", getAttrVal6());
		this.hashColumns.put("attr_val7", getAttrVal7());
		this.hashColumns.put("attr_val4", getAttrVal4());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("attr_val5", getAttrVal5());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("val_cd", getValCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cd_nm", getCdNm());
		this.hashColumns.put("attr_val10", getAttrVal10());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cd_tbl_id", getCdTblId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("attr_dt2", "attrDt2");
		this.hashFields.put("attr_dt1", "attrDt1");
		this.hashFields.put("attr_dt4", "attrDt4");
		this.hashFields.put("attr_val8", "attrVal8");
		this.hashFields.put("attr_dt3", "attrDt3");
		this.hashFields.put("attr_val9", "attrVal9");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("attr_dt5", "attrDt5");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("attr_val2", "attrVal2");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("attr_val3", "attrVal3");
		this.hashFields.put("attr_val1", "attrVal1");
		this.hashFields.put("attr_val6", "attrVal6");
		this.hashFields.put("attr_val7", "attrVal7");
		this.hashFields.put("attr_val4", "attrVal4");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_val5", "attrVal5");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("val_cd", "valCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cd_nm", "cdNm");
		this.hashFields.put("attr_val10", "attrVal10");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cd_tbl_id", "cdTblId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return attrDt2
	 */
	public String getAttrDt2() {
		return this.attrDt2;
	}
	
	/**
	 * Column Info
	 * @return attrDt1
	 */
	public String getAttrDt1() {
		return this.attrDt1;
	}
	
	/**
	 * Column Info
	 * @return attrDt4
	 */
	public String getAttrDt4() {
		return this.attrDt4;
	}
	
	/**
	 * Column Info
	 * @return attrVal8
	 */
	public String getAttrVal8() {
		return this.attrVal8;
	}
	
	/**
	 * Column Info
	 * @return attrDt3
	 */
	public String getAttrDt3() {
		return this.attrDt3;
	}
	
	/**
	 * Column Info
	 * @return attrVal9
	 */
	public String getAttrVal9() {
		return this.attrVal9;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt10
	 */
	public String getAttrCtnt10() {
		return this.attrCtnt10;
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
	 * @return attrDt5
	 */
	public String getAttrDt5() {
		return this.attrDt5;
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
	 * @return attrCtnt9
	 */
	public String getAttrCtnt9() {
		return this.attrCtnt9;
	}
	
	/**
	 * Column Info
	 * @return attrVal2
	 */
	public String getAttrVal2() {
		return this.attrVal2;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt8
	 */
	public String getAttrCtnt8() {
		return this.attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @return attrVal3
	 */
	public String getAttrVal3() {
		return this.attrVal3;
	}
	
	/**
	 * Column Info
	 * @return attrVal1
	 */
	public String getAttrVal1() {
		return this.attrVal1;
	}
	
	/**
	 * Column Info
	 * @return attrVal6
	 */
	public String getAttrVal6() {
		return this.attrVal6;
	}
	
	/**
	 * Column Info
	 * @return attrVal7
	 */
	public String getAttrVal7() {
		return this.attrVal7;
	}
	
	/**
	 * Column Info
	 * @return attrVal4
	 */
	public String getAttrVal4() {
		return this.attrVal4;
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
	 * @return attrVal5
	 */
	public String getAttrVal5() {
		return this.attrVal5;
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
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
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
	 * @return attrCtnt5
	 */
	public String getAttrCtnt5() {
		return this.attrCtnt5;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return valCd
	 */
	public String getValCd() {
		return this.valCd;
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
	 * @return cdNm
	 */
	public String getCdNm() {
		return this.cdNm;
	}
	
	/**
	 * Column Info
	 * @return attrVal10
	 */
	public String getAttrVal10() {
		return this.attrVal10;
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
	 * @return cdTblId
	 */
	public String getCdTblId() {
		return this.cdTblId;
	}
	

	/**
	 * Column Info
	 * @param attrDt2
	 */
	public void setAttrDt2(String attrDt2) {
		this.attrDt2 = attrDt2;
	}
	
	/**
	 * Column Info
	 * @param attrDt1
	 */
	public void setAttrDt1(String attrDt1) {
		this.attrDt1 = attrDt1;
	}
	
	/**
	 * Column Info
	 * @param attrDt4
	 */
	public void setAttrDt4(String attrDt4) {
		this.attrDt4 = attrDt4;
	}
	
	/**
	 * Column Info
	 * @param attrVal8
	 */
	public void setAttrVal8(String attrVal8) {
		this.attrVal8 = attrVal8;
	}
	
	/**
	 * Column Info
	 * @param attrDt3
	 */
	public void setAttrDt3(String attrDt3) {
		this.attrDt3 = attrDt3;
	}
	
	/**
	 * Column Info
	 * @param attrVal9
	 */
	public void setAttrVal9(String attrVal9) {
		this.attrVal9 = attrVal9;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt10
	 */
	public void setAttrCtnt10(String attrCtnt10) {
		this.attrCtnt10 = attrCtnt10;
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
	 * @param attrDt5
	 */
	public void setAttrDt5(String attrDt5) {
		this.attrDt5 = attrDt5;
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
	 * @param attrCtnt9
	 */
	public void setAttrCtnt9(String attrCtnt9) {
		this.attrCtnt9 = attrCtnt9;
	}
	
	/**
	 * Column Info
	 * @param attrVal2
	 */
	public void setAttrVal2(String attrVal2) {
		this.attrVal2 = attrVal2;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt8
	 */
	public void setAttrCtnt8(String attrCtnt8) {
		this.attrCtnt8 = attrCtnt8;
	}
	
	/**
	 * Column Info
	 * @param attrVal3
	 */
	public void setAttrVal3(String attrVal3) {
		this.attrVal3 = attrVal3;
	}
	
	/**
	 * Column Info
	 * @param attrVal1
	 */
	public void setAttrVal1(String attrVal1) {
		this.attrVal1 = attrVal1;
	}
	
	/**
	 * Column Info
	 * @param attrVal6
	 */
	public void setAttrVal6(String attrVal6) {
		this.attrVal6 = attrVal6;
	}
	
	/**
	 * Column Info
	 * @param attrVal7
	 */
	public void setAttrVal7(String attrVal7) {
		this.attrVal7 = attrVal7;
	}
	
	/**
	 * Column Info
	 * @param attrVal4
	 */
	public void setAttrVal4(String attrVal4) {
		this.attrVal4 = attrVal4;
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
	 * @param attrVal5
	 */
	public void setAttrVal5(String attrVal5) {
		this.attrVal5 = attrVal5;
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
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
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
	 * @param attrCtnt5
	 */
	public void setAttrCtnt5(String attrCtnt5) {
		this.attrCtnt5 = attrCtnt5;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param valCd
	 */
	public void setValCd(String valCd) {
		this.valCd = valCd;
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
	 * @param cdNm
	 */
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	
	/**
	 * Column Info
	 * @param attrVal10
	 */
	public void setAttrVal10(String attrVal10) {
		this.attrVal10 = attrVal10;
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
	 * @param cdTblId
	 */
	public void setCdTblId(String cdTblId) {
		this.cdTblId = cdTblId;
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
		setAttrDt2(JSPUtil.getParameter(request, prefix + "attr_dt2", ""));
		setAttrDt1(JSPUtil.getParameter(request, prefix + "attr_dt1", ""));
		setAttrDt4(JSPUtil.getParameter(request, prefix + "attr_dt4", ""));
		setAttrVal8(JSPUtil.getParameter(request, prefix + "attr_val8", ""));
		setAttrDt3(JSPUtil.getParameter(request, prefix + "attr_dt3", ""));
		setAttrVal9(JSPUtil.getParameter(request, prefix + "attr_val9", ""));
		setAttrCtnt10(JSPUtil.getParameter(request, prefix + "attr_ctnt10", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setAttrDt5(JSPUtil.getParameter(request, prefix + "attr_dt5", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAttrCtnt9(JSPUtil.getParameter(request, prefix + "attr_ctnt9", ""));
		setAttrVal2(JSPUtil.getParameter(request, prefix + "attr_val2", ""));
		setAttrCtnt8(JSPUtil.getParameter(request, prefix + "attr_ctnt8", ""));
		setAttrVal3(JSPUtil.getParameter(request, prefix + "attr_val3", ""));
		setAttrVal1(JSPUtil.getParameter(request, prefix + "attr_val1", ""));
		setAttrVal6(JSPUtil.getParameter(request, prefix + "attr_val6", ""));
		setAttrVal7(JSPUtil.getParameter(request, prefix + "attr_val7", ""));
		setAttrVal4(JSPUtil.getParameter(request, prefix + "attr_val4", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAttrVal5(JSPUtil.getParameter(request, prefix + "attr_val5", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
		setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
		setAttrCtnt6(JSPUtil.getParameter(request, prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request, prefix + "attr_ctnt7", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setValCd(JSPUtil.getParameter(request, prefix + "val_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCdNm(JSPUtil.getParameter(request, prefix + "cd_nm", ""));
		setAttrVal10(JSPUtil.getParameter(request, prefix + "attr_val10", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCdTblId(JSPUtil.getParameter(request, prefix + "cd_tbl_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgCdVO[]
	 */
	public ScgCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgCdVO[]
	 */
	public ScgCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] attrDt2 = (JSPUtil.getParameter(request, prefix	+ "attr_dt2", length));
			String[] attrDt1 = (JSPUtil.getParameter(request, prefix	+ "attr_dt1", length));
			String[] attrDt4 = (JSPUtil.getParameter(request, prefix	+ "attr_dt4", length));
			String[] attrVal8 = (JSPUtil.getParameter(request, prefix	+ "attr_val8", length));
			String[] attrDt3 = (JSPUtil.getParameter(request, prefix	+ "attr_dt3", length));
			String[] attrVal9 = (JSPUtil.getParameter(request, prefix	+ "attr_val9", length));
			String[] attrCtnt10 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt10", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] attrDt5 = (JSPUtil.getParameter(request, prefix	+ "attr_dt5", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] attrCtnt9 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt9", length));
			String[] attrVal2 = (JSPUtil.getParameter(request, prefix	+ "attr_val2", length));
			String[] attrCtnt8 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt8", length));
			String[] attrVal3 = (JSPUtil.getParameter(request, prefix	+ "attr_val3", length));
			String[] attrVal1 = (JSPUtil.getParameter(request, prefix	+ "attr_val1", length));
			String[] attrVal6 = (JSPUtil.getParameter(request, prefix	+ "attr_val6", length));
			String[] attrVal7 = (JSPUtil.getParameter(request, prefix	+ "attr_val7", length));
			String[] attrVal4 = (JSPUtil.getParameter(request, prefix	+ "attr_val4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] attrVal5 = (JSPUtil.getParameter(request, prefix	+ "attr_val5", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt3", length));
			String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt4", length));
			String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt5", length));
			String[] attrCtnt6 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt6", length));
			String[] attrCtnt7 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt7", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] valCd = (JSPUtil.getParameter(request, prefix	+ "val_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cdNm = (JSPUtil.getParameter(request, prefix	+ "cd_nm", length));
			String[] attrVal10 = (JSPUtil.getParameter(request, prefix	+ "attr_val10", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cdTblId = (JSPUtil.getParameter(request, prefix	+ "cd_tbl_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgCdVO();
				if (attrDt2[i] != null)
					model.setAttrDt2(attrDt2[i]);
				if (attrDt1[i] != null)
					model.setAttrDt1(attrDt1[i]);
				if (attrDt4[i] != null)
					model.setAttrDt4(attrDt4[i]);
				if (attrVal8[i] != null)
					model.setAttrVal8(attrVal8[i]);
				if (attrDt3[i] != null)
					model.setAttrDt3(attrDt3[i]);
				if (attrVal9[i] != null)
					model.setAttrVal9(attrVal9[i]);
				if (attrCtnt10[i] != null)
					model.setAttrCtnt10(attrCtnt10[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (attrDt5[i] != null)
					model.setAttrDt5(attrDt5[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (attrCtnt9[i] != null)
					model.setAttrCtnt9(attrCtnt9[i]);
				if (attrVal2[i] != null)
					model.setAttrVal2(attrVal2[i]);
				if (attrCtnt8[i] != null)
					model.setAttrCtnt8(attrCtnt8[i]);
				if (attrVal3[i] != null)
					model.setAttrVal3(attrVal3[i]);
				if (attrVal1[i] != null)
					model.setAttrVal1(attrVal1[i]);
				if (attrVal6[i] != null)
					model.setAttrVal6(attrVal6[i]);
				if (attrVal7[i] != null)
					model.setAttrVal7(attrVal7[i]);
				if (attrVal4[i] != null)
					model.setAttrVal4(attrVal4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (attrVal5[i] != null)
					model.setAttrVal5(attrVal5[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attrCtnt3[i] != null)
					model.setAttrCtnt3(attrCtnt3[i]);
				if (attrCtnt4[i] != null)
					model.setAttrCtnt4(attrCtnt4[i]);
				if (attrCtnt5[i] != null)
					model.setAttrCtnt5(attrCtnt5[i]);
				if (attrCtnt6[i] != null)
					model.setAttrCtnt6(attrCtnt6[i]);
				if (attrCtnt7[i] != null)
					model.setAttrCtnt7(attrCtnt7[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (valCd[i] != null)
					model.setValCd(valCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cdNm[i] != null)
					model.setCdNm(cdNm[i]);
				if (attrVal10[i] != null)
					model.setAttrVal10(attrVal10[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cdTblId[i] != null)
					model.setCdTblId(cdTblId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgCdVO[]
	 */
	public ScgCdVO[] getScgCdVOs(){
		ScgCdVO[] vos = (ScgCdVO[])models.toArray(new ScgCdVO[models.size()]);
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
		this.attrDt2 = this.attrDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrDt1 = this.attrDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrDt4 = this.attrDt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal8 = this.attrVal8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrDt3 = this.attrDt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal9 = this.attrVal9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 = this.attrCtnt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrDt5 = this.attrDt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 = this.attrCtnt9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal2 = this.attrVal2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 = this.attrCtnt8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal3 = this.attrVal3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal1 = this.attrVal1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal6 = this.attrVal6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal7 = this.attrVal7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal4 = this.attrVal4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal5 = this.attrVal5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 = this.attrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 = this.attrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 = this.attrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 = this.attrCtnt6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 = this.attrCtnt7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCd = this.valCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdNm = this.cdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrVal10 = this.attrVal10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdTblId = this.cdTblId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
