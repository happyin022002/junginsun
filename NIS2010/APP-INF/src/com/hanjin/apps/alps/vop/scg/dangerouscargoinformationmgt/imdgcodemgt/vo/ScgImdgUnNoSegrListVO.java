/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgImdgUnNoSegrListVO.java
*@FileTitle : ScgImdgUnNoSegrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.25 이도형 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgImdgUnNoSegrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgImdgUnNoSegrListVO> models = new ArrayList<ScgImdgUnNoSegrListVO>();
	
	/* Column Info */
	private String clssCd11 = null;
	/* Column Info */
	private String clssCd12 = null;
	/* Column Info */
	private String clssCd15 = null;
	/* Column Info */
	private String clssCd52 = null;
	/* Column Info */
	private String clssCd16 = null;
	/* Column Info */
	private String clssCd51 = null;
	/* Column Info */
	private String clssCd13 = null;
	/* Column Info */
	private String clssCd14 = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgSegrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String clssCd3 = null;
	/* Column Info */
	private String clssCd7 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String clssCd8 = null;
	/* Column Info */
	private String clssCd9 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String clssCd41 = null;
	/* Column Info */
	private String clssCd43 = null;
	/* Column Info */
	private String clssCd42 = null;
	/* Column Info */
	private String clssCd21 = null;
	/* Column Info */
	private String clssCd23 = null;
	/* Column Info */
	private String clssCd22 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String clssCd62 = null;
	/* Column Info */
	private String clssCd61 = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgImdgUnNoSegrListVO() {}

	public ScgImdgUnNoSegrListVO(String ibflag, String pagerows, String imdgUnNo, String imdgUnNoSeq, String clssCd11, String clssCd12, String clssCd15, String clssCd13, String clssCd16, String clssCd14, String clssCd21, String clssCd22, String clssCd23, String clssCd3, String clssCd41, String clssCd42, String clssCd43, String clssCd51, String clssCd52, String clssCd61, String clssCd62, String clssCd7, String clssCd8, String clssCd9, String creUsrId, String creDt, String updUsrId, String updDt, String imdgClssCd, String imdgSegrCd) {
		this.clssCd11 = clssCd11;
		this.clssCd12 = clssCd12;
		this.clssCd15 = clssCd15;
		this.clssCd52 = clssCd52;
		this.clssCd16 = clssCd16;
		this.clssCd51 = clssCd51;
		this.clssCd13 = clssCd13;
		this.clssCd14 = clssCd14;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.imdgSegrCd = imdgSegrCd;
		this.ibflag = ibflag;
		this.clssCd3 = clssCd3;
		this.clssCd7 = clssCd7;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.clssCd8 = clssCd8;
		this.clssCd9 = clssCd9;
		this.updDt = updDt;
		this.clssCd41 = clssCd41;
		this.clssCd43 = clssCd43;
		this.clssCd42 = clssCd42;
		this.clssCd21 = clssCd21;
		this.clssCd23 = clssCd23;
		this.clssCd22 = clssCd22;
		this.creUsrId = creUsrId;
		this.clssCd62 = clssCd62;
		this.clssCd61 = clssCd61;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("clss_cd_11", getClssCd11());
		this.hashColumns.put("clss_cd_12", getClssCd12());
		this.hashColumns.put("clss_cd_15", getClssCd15());
		this.hashColumns.put("clss_cd_52", getClssCd52());
		this.hashColumns.put("clss_cd_16", getClssCd16());
		this.hashColumns.put("clss_cd_51", getClssCd51());
		this.hashColumns.put("clss_cd_13", getClssCd13());
		this.hashColumns.put("clss_cd_14", getClssCd14());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_segr_cd", getImdgSegrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clss_cd_3", getClssCd3());
		this.hashColumns.put("clss_cd_7", getClssCd7());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("clss_cd_8", getClssCd8());
		this.hashColumns.put("clss_cd_9", getClssCd9());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("clss_cd_41", getClssCd41());
		this.hashColumns.put("clss_cd_43", getClssCd43());
		this.hashColumns.put("clss_cd_42", getClssCd42());
		this.hashColumns.put("clss_cd_21", getClssCd21());
		this.hashColumns.put("clss_cd_23", getClssCd23());
		this.hashColumns.put("clss_cd_22", getClssCd22());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("clss_cd_62", getClssCd62());
		this.hashColumns.put("clss_cd_61", getClssCd61());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("clss_cd_11", "clssCd11");
		this.hashFields.put("clss_cd_12", "clssCd12");
		this.hashFields.put("clss_cd_15", "clssCd15");
		this.hashFields.put("clss_cd_52", "clssCd52");
		this.hashFields.put("clss_cd_16", "clssCd16");
		this.hashFields.put("clss_cd_51", "clssCd51");
		this.hashFields.put("clss_cd_13", "clssCd13");
		this.hashFields.put("clss_cd_14", "clssCd14");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_segr_cd", "imdgSegrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clss_cd_3", "clssCd3");
		this.hashFields.put("clss_cd_7", "clssCd7");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("clss_cd_8", "clssCd8");
		this.hashFields.put("clss_cd_9", "clssCd9");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("clss_cd_41", "clssCd41");
		this.hashFields.put("clss_cd_43", "clssCd43");
		this.hashFields.put("clss_cd_42", "clssCd42");
		this.hashFields.put("clss_cd_21", "clssCd21");
		this.hashFields.put("clss_cd_23", "clssCd23");
		this.hashFields.put("clss_cd_22", "clssCd22");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("clss_cd_62", "clssCd62");
		this.hashFields.put("clss_cd_61", "clssCd61");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return clssCd11
	 */
	public String getClssCd11() {
		return this.clssCd11;
	}
	
	/**
	 * Column Info
	 * @return clssCd12
	 */
	public String getClssCd12() {
		return this.clssCd12;
	}
	
	/**
	 * Column Info
	 * @return clssCd15
	 */
	public String getClssCd15() {
		return this.clssCd15;
	}
	
	/**
	 * Column Info
	 * @return clssCd52
	 */
	public String getClssCd52() {
		return this.clssCd52;
	}
	
	/**
	 * Column Info
	 * @return clssCd16
	 */
	public String getClssCd16() {
		return this.clssCd16;
	}
	
	/**
	 * Column Info
	 * @return clssCd51
	 */
	public String getClssCd51() {
		return this.clssCd51;
	}
	
	/**
	 * Column Info
	 * @return clssCd13
	 */
	public String getClssCd13() {
		return this.clssCd13;
	}
	
	/**
	 * Column Info
	 * @return clssCd14
	 */
	public String getClssCd14() {
		return this.clssCd14;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return imdgSegrCd
	 */
	public String getImdgSegrCd() {
		return this.imdgSegrCd;
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
	 * @return clssCd3
	 */
	public String getClssCd3() {
		return this.clssCd3;
	}
	
	/**
	 * Column Info
	 * @return clssCd7
	 */
	public String getClssCd7() {
		return this.clssCd7;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return clssCd8
	 */
	public String getClssCd8() {
		return this.clssCd8;
	}
	
	/**
	 * Column Info
	 * @return clssCd9
	 */
	public String getClssCd9() {
		return this.clssCd9;
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
	 * @return clssCd41
	 */
	public String getClssCd41() {
		return this.clssCd41;
	}
	
	/**
	 * Column Info
	 * @return clssCd43
	 */
	public String getClssCd43() {
		return this.clssCd43;
	}
	
	/**
	 * Column Info
	 * @return clssCd42
	 */
	public String getClssCd42() {
		return this.clssCd42;
	}
	
	/**
	 * Column Info
	 * @return clssCd21
	 */
	public String getClssCd21() {
		return this.clssCd21;
	}
	
	/**
	 * Column Info
	 * @return clssCd23
	 */
	public String getClssCd23() {
		return this.clssCd23;
	}
	
	/**
	 * Column Info
	 * @return clssCd22
	 */
	public String getClssCd22() {
		return this.clssCd22;
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
	 * @return clssCd62
	 */
	public String getClssCd62() {
		return this.clssCd62;
	}
	
	/**
	 * Column Info
	 * @return clssCd61
	 */
	public String getClssCd61() {
		return this.clssCd61;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	

	/**
	 * Column Info
	 * @param clssCd11
	 */
	public void setClssCd11(String clssCd11) {
		this.clssCd11 = clssCd11;
	}
	
	/**
	 * Column Info
	 * @param clssCd12
	 */
	public void setClssCd12(String clssCd12) {
		this.clssCd12 = clssCd12;
	}
	
	/**
	 * Column Info
	 * @param clssCd15
	 */
	public void setClssCd15(String clssCd15) {
		this.clssCd15 = clssCd15;
	}
	
	/**
	 * Column Info
	 * @param clssCd52
	 */
	public void setClssCd52(String clssCd52) {
		this.clssCd52 = clssCd52;
	}
	
	/**
	 * Column Info
	 * @param clssCd16
	 */
	public void setClssCd16(String clssCd16) {
		this.clssCd16 = clssCd16;
	}
	
	/**
	 * Column Info
	 * @param clssCd51
	 */
	public void setClssCd51(String clssCd51) {
		this.clssCd51 = clssCd51;
	}
	
	/**
	 * Column Info
	 * @param clssCd13
	 */
	public void setClssCd13(String clssCd13) {
		this.clssCd13 = clssCd13;
	}
	
	/**
	 * Column Info
	 * @param clssCd14
	 */
	public void setClssCd14(String clssCd14) {
		this.clssCd14 = clssCd14;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param imdgSegrCd
	 */
	public void setImdgSegrCd(String imdgSegrCd) {
		this.imdgSegrCd = imdgSegrCd;
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
	 * @param clssCd3
	 */
	public void setClssCd3(String clssCd3) {
		this.clssCd3 = clssCd3;
	}
	
	/**
	 * Column Info
	 * @param clssCd7
	 */
	public void setClssCd7(String clssCd7) {
		this.clssCd7 = clssCd7;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param clssCd8
	 */
	public void setClssCd8(String clssCd8) {
		this.clssCd8 = clssCd8;
	}
	
	/**
	 * Column Info
	 * @param clssCd9
	 */
	public void setClssCd9(String clssCd9) {
		this.clssCd9 = clssCd9;
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
	 * @param clssCd41
	 */
	public void setClssCd41(String clssCd41) {
		this.clssCd41 = clssCd41;
	}
	
	/**
	 * Column Info
	 * @param clssCd43
	 */
	public void setClssCd43(String clssCd43) {
		this.clssCd43 = clssCd43;
	}
	
	/**
	 * Column Info
	 * @param clssCd42
	 */
	public void setClssCd42(String clssCd42) {
		this.clssCd42 = clssCd42;
	}
	
	/**
	 * Column Info
	 * @param clssCd21
	 */
	public void setClssCd21(String clssCd21) {
		this.clssCd21 = clssCd21;
	}
	
	/**
	 * Column Info
	 * @param clssCd23
	 */
	public void setClssCd23(String clssCd23) {
		this.clssCd23 = clssCd23;
	}
	
	/**
	 * Column Info
	 * @param clssCd22
	 */
	public void setClssCd22(String clssCd22) {
		this.clssCd22 = clssCd22;
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
	 * @param clssCd62
	 */
	public void setClssCd62(String clssCd62) {
		this.clssCd62 = clssCd62;
	}
	
	/**
	 * Column Info
	 * @param clssCd61
	 */
	public void setClssCd61(String clssCd61) {
		this.clssCd61 = clssCd61;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setClssCd11(JSPUtil.getParameter(request, "clss_cd_11", ""));
		setClssCd12(JSPUtil.getParameter(request, "clss_cd_12", ""));
		setClssCd15(JSPUtil.getParameter(request, "clss_cd_15", ""));
		setClssCd52(JSPUtil.getParameter(request, "clss_cd_52", ""));
		setClssCd16(JSPUtil.getParameter(request, "clss_cd_16", ""));
		setClssCd51(JSPUtil.getParameter(request, "clss_cd_51", ""));
		setClssCd13(JSPUtil.getParameter(request, "clss_cd_13", ""));
		setClssCd14(JSPUtil.getParameter(request, "clss_cd_14", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setImdgSegrCd(JSPUtil.getParameter(request, "imdg_segr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setClssCd3(JSPUtil.getParameter(request, "clss_cd_3", ""));
		setClssCd7(JSPUtil.getParameter(request, "clss_cd_7", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setClssCd8(JSPUtil.getParameter(request, "clss_cd_8", ""));
		setClssCd9(JSPUtil.getParameter(request, "clss_cd_9", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setClssCd41(JSPUtil.getParameter(request, "clss_cd_41", ""));
		setClssCd43(JSPUtil.getParameter(request, "clss_cd_43", ""));
		setClssCd42(JSPUtil.getParameter(request, "clss_cd_42", ""));
		setClssCd21(JSPUtil.getParameter(request, "clss_cd_21", ""));
		setClssCd23(JSPUtil.getParameter(request, "clss_cd_23", ""));
		setClssCd22(JSPUtil.getParameter(request, "clss_cd_22", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setClssCd62(JSPUtil.getParameter(request, "clss_cd_62", ""));
		setClssCd61(JSPUtil.getParameter(request, "clss_cd_61", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgImdgUnNoSegrListVO[]
	 */
	public ScgImdgUnNoSegrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgImdgUnNoSegrListVO[]
	 */
	public ScgImdgUnNoSegrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgImdgUnNoSegrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] clssCd11 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_11".trim(), length));
			String[] clssCd12 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_12".trim(), length));
			String[] clssCd15 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_15".trim(), length));
			String[] clssCd52 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_52".trim(), length));
			String[] clssCd16 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_16".trim(), length));
			String[] clssCd51 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_51".trim(), length));
			String[] clssCd13 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_13".trim(), length));
			String[] clssCd14 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_14".trim(), length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] imdgSegrCd = (JSPUtil.getParameter(request, prefix	+ "imdg_segr_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] clssCd3 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_3".trim(), length));
			String[] clssCd7 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_7".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no".trim(), length));
			String[] clssCd8 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_8".trim(), length));
			String[] clssCd9 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_9".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] clssCd41 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_41".trim(), length));
			String[] clssCd43 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_43".trim(), length));
			String[] clssCd42 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_42".trim(), length));
			String[] clssCd21 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_21".trim(), length));
			String[] clssCd23 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_23".trim(), length));
			String[] clssCd22 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_22".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] clssCd62 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_62".trim(), length));
			String[] clssCd61 = (JSPUtil.getParameter(request, prefix	+ "clss_cd_61".trim(), length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgImdgUnNoSegrListVO();
				if (clssCd11[i] != null)
					model.setClssCd11(clssCd11[i]);
				if (clssCd12[i] != null)
					model.setClssCd12(clssCd12[i]);
				if (clssCd15[i] != null)
					model.setClssCd15(clssCd15[i]);
				if (clssCd52[i] != null)
					model.setClssCd52(clssCd52[i]);
				if (clssCd16[i] != null)
					model.setClssCd16(clssCd16[i]);
				if (clssCd51[i] != null)
					model.setClssCd51(clssCd51[i]);
				if (clssCd13[i] != null)
					model.setClssCd13(clssCd13[i]);
				if (clssCd14[i] != null)
					model.setClssCd14(clssCd14[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgSegrCd[i] != null)
					model.setImdgSegrCd(imdgSegrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clssCd3[i] != null)
					model.setClssCd3(clssCd3[i]);
				if (clssCd7[i] != null)
					model.setClssCd7(clssCd7[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (clssCd8[i] != null)
					model.setClssCd8(clssCd8[i]);
				if (clssCd9[i] != null)
					model.setClssCd9(clssCd9[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (clssCd41[i] != null)
					model.setClssCd41(clssCd41[i]);
				if (clssCd43[i] != null)
					model.setClssCd43(clssCd43[i]);
				if (clssCd42[i] != null)
					model.setClssCd42(clssCd42[i]);
				if (clssCd21[i] != null)
					model.setClssCd21(clssCd21[i]);
				if (clssCd23[i] != null)
					model.setClssCd23(clssCd23[i]);
				if (clssCd22[i] != null)
					model.setClssCd22(clssCd22[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (clssCd62[i] != null)
					model.setClssCd62(clssCd62[i]);
				if (clssCd61[i] != null)
					model.setClssCd61(clssCd61[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgImdgUnNoSegrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgImdgUnNoSegrListVO[]
	 */
	public ScgImdgUnNoSegrListVO[] getScgImdgUnNoSegrListVOs(){
		ScgImdgUnNoSegrListVO[] vos = (ScgImdgUnNoSegrListVO[])models.toArray(new ScgImdgUnNoSegrListVO[models.size()]);
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
		this.clssCd11 = this.clssCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd12 = this.clssCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd15 = this.clssCd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd52 = this.clssCd52 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd16 = this.clssCd16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd51 = this.clssCd51 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd13 = this.clssCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd14 = this.clssCd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSegrCd = this.imdgSegrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd3 = this.clssCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd7 = this.clssCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd8 = this.clssCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd9 = this.clssCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd41 = this.clssCd41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd43 = this.clssCd43 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd42 = this.clssCd42 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd21 = this.clssCd21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd23 = this.clssCd23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd22 = this.clssCd22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd62 = this.clssCd62 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd61 = this.clssCd61 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
