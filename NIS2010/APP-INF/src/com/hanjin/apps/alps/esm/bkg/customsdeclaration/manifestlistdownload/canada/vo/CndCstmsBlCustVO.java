/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsBlCustVO.java
*@FileTitle : CndCstmsBlCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.11 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsBlCustVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsBlCustVO> models = new ArrayList<CndCstmsBlCustVO>();
	
	/* Column Info */
	private String custSeq2 = null;
	/* Column Info */
	private String custSeq3 = null;
	/* Column Info */
	private String custSeq1 = null;
	/* Column Info */
	private String custSteCd1 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCntCd3 = null;
	/* Column Info */
	private String cstmsDeclCntCd3 = null;
	/* Column Info */
	private String cstmsDeclCntCd2 = null;
	/* Column Info */
	private String cstmsDeclCntCd1 = null;
	/* Column Info */
	private String custNm1 = null;
	/* Column Info */
	private String custCntCd1 = null;
	/* Column Info */
	private String custCntCd2 = null;
	/* Column Info */
	private String custAddr1 = null;
	/* Column Info */
	private String custAddr3 = null;
	/* Column Info */
	private String custAddr2 = null;
	/* Column Info */
	private String custCtyNm1 = null;
	/* Column Info */
	private String custCtyNm2 = null;
	/* Column Info */
	private String custCtyNm3 = null;
	/* Column Info */
	private String custSteCd3 = null;
	/* Column Info */
	private String custSteCd2 = null;
	/* Column Info */
	private String custZipId3 = null;
	/* Column Info */
	private String custZipId2 = null;
	/* Column Info */
	private String custZipId1 = null;
	/* Column Info */
	private String toOrdFlg = null;
	/* Column Info */
	private String custNm3 = null;
	/* Column Info */
	private String custNm2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsBlCustVO() {}

	public CndCstmsBlCustVO(String ibflag, String pagerows, String custCntCd1, String custSeq1, String custZipId1, String custCtyNm1, String custSteCd1, String cstmsDeclCntCd1, String custNm1, String custAddr1, String custCntCd2, String custSeq2, String custZipId2, String custCtyNm2, String custSteCd2, String cstmsDeclCntCd2, String custNm2, String custAddr2, String toOrdFlg, String custCntCd3, String custSeq3, String custZipId3, String custCtyNm3, String custSteCd3, String cstmsDeclCntCd3, String custNm3, String custAddr3) {
		this.custSeq2 = custSeq2;
		this.custSeq3 = custSeq3;
		this.custSeq1 = custSeq1;
		this.custSteCd1 = custSteCd1;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.custCntCd3 = custCntCd3;
		this.cstmsDeclCntCd3 = cstmsDeclCntCd3;
		this.cstmsDeclCntCd2 = cstmsDeclCntCd2;
		this.cstmsDeclCntCd1 = cstmsDeclCntCd1;
		this.custNm1 = custNm1;
		this.custCntCd1 = custCntCd1;
		this.custCntCd2 = custCntCd2;
		this.custAddr1 = custAddr1;
		this.custAddr3 = custAddr3;
		this.custAddr2 = custAddr2;
		this.custCtyNm1 = custCtyNm1;
		this.custCtyNm2 = custCtyNm2;
		this.custCtyNm3 = custCtyNm3;
		this.custSteCd3 = custSteCd3;
		this.custSteCd2 = custSteCd2;
		this.custZipId3 = custZipId3;
		this.custZipId2 = custZipId2;
		this.custZipId1 = custZipId1;
		this.toOrdFlg = toOrdFlg;
		this.custNm3 = custNm3;
		this.custNm2 = custNm2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_seq2", getCustSeq2());
		this.hashColumns.put("cust_seq3", getCustSeq3());
		this.hashColumns.put("cust_seq1", getCustSeq1());
		this.hashColumns.put("cust_ste_cd1", getCustSteCd1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_cnt_cd3", getCustCntCd3());
		this.hashColumns.put("cstms_decl_cnt_cd3", getCstmsDeclCntCd3());
		this.hashColumns.put("cstms_decl_cnt_cd2", getCstmsDeclCntCd2());
		this.hashColumns.put("cstms_decl_cnt_cd1", getCstmsDeclCntCd1());
		this.hashColumns.put("cust_nm1", getCustNm1());
		this.hashColumns.put("cust_cnt_cd1", getCustCntCd1());
		this.hashColumns.put("cust_cnt_cd2", getCustCntCd2());
		this.hashColumns.put("cust_addr1", getCustAddr1());
		this.hashColumns.put("cust_addr3", getCustAddr3());
		this.hashColumns.put("cust_addr2", getCustAddr2());
		this.hashColumns.put("cust_cty_nm1", getCustCtyNm1());
		this.hashColumns.put("cust_cty_nm2", getCustCtyNm2());
		this.hashColumns.put("cust_cty_nm3", getCustCtyNm3());
		this.hashColumns.put("cust_ste_cd3", getCustSteCd3());
		this.hashColumns.put("cust_ste_cd2", getCustSteCd2());
		this.hashColumns.put("cust_zip_id3", getCustZipId3());
		this.hashColumns.put("cust_zip_id2", getCustZipId2());
		this.hashColumns.put("cust_zip_id1", getCustZipId1());
		this.hashColumns.put("to_ord_flg", getToOrdFlg());
		this.hashColumns.put("cust_nm3", getCustNm3());
		this.hashColumns.put("cust_nm2", getCustNm2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_seq2", "custSeq2");
		this.hashFields.put("cust_seq3", "custSeq3");
		this.hashFields.put("cust_seq1", "custSeq1");
		this.hashFields.put("cust_ste_cd1", "custSteCd1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cnt_cd3", "custCntCd3");
		this.hashFields.put("cstms_decl_cnt_cd3", "cstmsDeclCntCd3");
		this.hashFields.put("cstms_decl_cnt_cd2", "cstmsDeclCntCd2");
		this.hashFields.put("cstms_decl_cnt_cd1", "cstmsDeclCntCd1");
		this.hashFields.put("cust_nm1", "custNm1");
		this.hashFields.put("cust_cnt_cd1", "custCntCd1");
		this.hashFields.put("cust_cnt_cd2", "custCntCd2");
		this.hashFields.put("cust_addr1", "custAddr1");
		this.hashFields.put("cust_addr3", "custAddr3");
		this.hashFields.put("cust_addr2", "custAddr2");
		this.hashFields.put("cust_cty_nm1", "custCtyNm1");
		this.hashFields.put("cust_cty_nm2", "custCtyNm2");
		this.hashFields.put("cust_cty_nm3", "custCtyNm3");
		this.hashFields.put("cust_ste_cd3", "custSteCd3");
		this.hashFields.put("cust_ste_cd2", "custSteCd2");
		this.hashFields.put("cust_zip_id3", "custZipId3");
		this.hashFields.put("cust_zip_id2", "custZipId2");
		this.hashFields.put("cust_zip_id1", "custZipId1");
		this.hashFields.put("to_ord_flg", "toOrdFlg");
		this.hashFields.put("cust_nm3", "custNm3");
		this.hashFields.put("cust_nm2", "custNm2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custSeq2
	 */
	public String getCustSeq2() {
		return this.custSeq2;
	}
	
	/**
	 * Column Info
	 * @return custSeq3
	 */
	public String getCustSeq3() {
		return this.custSeq3;
	}
	
	/**
	 * Column Info
	 * @return custSeq1
	 */
	public String getCustSeq1() {
		return this.custSeq1;
	}
	
	/**
	 * Column Info
	 * @return custSteCd1
	 */
	public String getCustSteCd1() {
		return this.custSteCd1;
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
	 * @return custCntCd3
	 */
	public String getCustCntCd3() {
		return this.custCntCd3;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclCntCd3
	 */
	public String getCstmsDeclCntCd3() {
		return this.cstmsDeclCntCd3;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclCntCd2
	 */
	public String getCstmsDeclCntCd2() {
		return this.cstmsDeclCntCd2;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclCntCd1
	 */
	public String getCstmsDeclCntCd1() {
		return this.cstmsDeclCntCd1;
	}
	
	/**
	 * Column Info
	 * @return custNm1
	 */
	public String getCustNm1() {
		return this.custNm1;
	}
	
	/**
	 * Column Info
	 * @return custCntCd1
	 */
	public String getCustCntCd1() {
		return this.custCntCd1;
	}
	
	/**
	 * Column Info
	 * @return custCntCd2
	 */
	public String getCustCntCd2() {
		return this.custCntCd2;
	}
	
	/**
	 * Column Info
	 * @return custAddr1
	 */
	public String getCustAddr1() {
		return this.custAddr1;
	}
	
	/**
	 * Column Info
	 * @return custAddr3
	 */
	public String getCustAddr3() {
		return this.custAddr3;
	}
	
	/**
	 * Column Info
	 * @return custAddr2
	 */
	public String getCustAddr2() {
		return this.custAddr2;
	}
	
	/**
	 * Column Info
	 * @return custCtyNm1
	 */
	public String getCustCtyNm1() {
		return this.custCtyNm1;
	}
	
	/**
	 * Column Info
	 * @return custCtyNm2
	 */
	public String getCustCtyNm2() {
		return this.custCtyNm2;
	}
	
	/**
	 * Column Info
	 * @return custCtyNm3
	 */
	public String getCustCtyNm3() {
		return this.custCtyNm3;
	}
	
	/**
	 * Column Info
	 * @return custSteCd3
	 */
	public String getCustSteCd3() {
		return this.custSteCd3;
	}
	
	/**
	 * Column Info
	 * @return custSteCd2
	 */
	public String getCustSteCd2() {
		return this.custSteCd2;
	}
	
	/**
	 * Column Info
	 * @return custZipId3
	 */
	public String getCustZipId3() {
		return this.custZipId3;
	}
	
	/**
	 * Column Info
	 * @return custZipId2
	 */
	public String getCustZipId2() {
		return this.custZipId2;
	}
	
	/**
	 * Column Info
	 * @return custZipId1
	 */
	public String getCustZipId1() {
		return this.custZipId1;
	}
	
	/**
	 * Column Info
	 * @return toOrdFlg
	 */
	public String getToOrdFlg() {
		return this.toOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return custNm3
	 */
	public String getCustNm3() {
		return this.custNm3;
	}
	
	/**
	 * Column Info
	 * @return custNm2
	 */
	public String getCustNm2() {
		return this.custNm2;
	}
	

	/**
	 * Column Info
	 * @param custSeq2
	 */
	public void setCustSeq2(String custSeq2) {
		this.custSeq2 = custSeq2;
	}
	
	/**
	 * Column Info
	 * @param custSeq3
	 */
	public void setCustSeq3(String custSeq3) {
		this.custSeq3 = custSeq3;
	}
	
	/**
	 * Column Info
	 * @param custSeq1
	 */
	public void setCustSeq1(String custSeq1) {
		this.custSeq1 = custSeq1;
	}
	
	/**
	 * Column Info
	 * @param custSteCd1
	 */
	public void setCustSteCd1(String custSteCd1) {
		this.custSteCd1 = custSteCd1;
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
	 * @param custCntCd3
	 */
	public void setCustCntCd3(String custCntCd3) {
		this.custCntCd3 = custCntCd3;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCd3
	 */
	public void setCstmsDeclCntCd3(String cstmsDeclCntCd3) {
		this.cstmsDeclCntCd3 = cstmsDeclCntCd3;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCd2
	 */
	public void setCstmsDeclCntCd2(String cstmsDeclCntCd2) {
		this.cstmsDeclCntCd2 = cstmsDeclCntCd2;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclCntCd1
	 */
	public void setCstmsDeclCntCd1(String cstmsDeclCntCd1) {
		this.cstmsDeclCntCd1 = cstmsDeclCntCd1;
	}
	
	/**
	 * Column Info
	 * @param custNm1
	 */
	public void setCustNm1(String custNm1) {
		this.custNm1 = custNm1;
	}
	
	/**
	 * Column Info
	 * @param custCntCd1
	 */
	public void setCustCntCd1(String custCntCd1) {
		this.custCntCd1 = custCntCd1;
	}
	
	/**
	 * Column Info
	 * @param custCntCd2
	 */
	public void setCustCntCd2(String custCntCd2) {
		this.custCntCd2 = custCntCd2;
	}
	
	/**
	 * Column Info
	 * @param custAddr1
	 */
	public void setCustAddr1(String custAddr1) {
		this.custAddr1 = custAddr1;
	}
	
	/**
	 * Column Info
	 * @param custAddr3
	 */
	public void setCustAddr3(String custAddr3) {
		this.custAddr3 = custAddr3;
	}
	
	/**
	 * Column Info
	 * @param custAddr2
	 */
	public void setCustAddr2(String custAddr2) {
		this.custAddr2 = custAddr2;
	}
	
	/**
	 * Column Info
	 * @param custCtyNm1
	 */
	public void setCustCtyNm1(String custCtyNm1) {
		this.custCtyNm1 = custCtyNm1;
	}
	
	/**
	 * Column Info
	 * @param custCtyNm2
	 */
	public void setCustCtyNm2(String custCtyNm2) {
		this.custCtyNm2 = custCtyNm2;
	}
	
	/**
	 * Column Info
	 * @param custCtyNm3
	 */
	public void setCustCtyNm3(String custCtyNm3) {
		this.custCtyNm3 = custCtyNm3;
	}
	
	/**
	 * Column Info
	 * @param custSteCd3
	 */
	public void setCustSteCd3(String custSteCd3) {
		this.custSteCd3 = custSteCd3;
	}
	
	/**
	 * Column Info
	 * @param custSteCd2
	 */
	public void setCustSteCd2(String custSteCd2) {
		this.custSteCd2 = custSteCd2;
	}
	
	/**
	 * Column Info
	 * @param custZipId3
	 */
	public void setCustZipId3(String custZipId3) {
		this.custZipId3 = custZipId3;
	}
	
	/**
	 * Column Info
	 * @param custZipId2
	 */
	public void setCustZipId2(String custZipId2) {
		this.custZipId2 = custZipId2;
	}
	
	/**
	 * Column Info
	 * @param custZipId1
	 */
	public void setCustZipId1(String custZipId1) {
		this.custZipId1 = custZipId1;
	}
	
	/**
	 * Column Info
	 * @param toOrdFlg
	 */
	public void setToOrdFlg(String toOrdFlg) {
		this.toOrdFlg = toOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param custNm3
	 */
	public void setCustNm3(String custNm3) {
		this.custNm3 = custNm3;
	}
	
	/**
	 * Column Info
	 * @param custNm2
	 */
	public void setCustNm2(String custNm2) {
		this.custNm2 = custNm2;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustSeq2(JSPUtil.getParameter(request, "cust_seq2", ""));
		setCustSeq3(JSPUtil.getParameter(request, "cust_seq3", ""));
		setCustSeq1(JSPUtil.getParameter(request, "cust_seq1", ""));
		setCustSteCd1(JSPUtil.getParameter(request, "cust_ste_cd1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustCntCd3(JSPUtil.getParameter(request, "cust_cnt_cd3", ""));
		setCstmsDeclCntCd3(JSPUtil.getParameter(request, "cstms_decl_cnt_cd3", ""));
		setCstmsDeclCntCd2(JSPUtil.getParameter(request, "cstms_decl_cnt_cd2", ""));
		setCstmsDeclCntCd1(JSPUtil.getParameter(request, "cstms_decl_cnt_cd1", ""));
		setCustNm1(JSPUtil.getParameter(request, "cust_nm1", ""));
		setCustCntCd1(JSPUtil.getParameter(request, "cust_cnt_cd1", ""));
		setCustCntCd2(JSPUtil.getParameter(request, "cust_cnt_cd2", ""));
		setCustAddr1(JSPUtil.getParameter(request, "cust_addr1", ""));
		setCustAddr3(JSPUtil.getParameter(request, "cust_addr3", ""));
		setCustAddr2(JSPUtil.getParameter(request, "cust_addr2", ""));
		setCustCtyNm1(JSPUtil.getParameter(request, "cust_cty_nm1", ""));
		setCustCtyNm2(JSPUtil.getParameter(request, "cust_cty_nm2", ""));
		setCustCtyNm3(JSPUtil.getParameter(request, "cust_cty_nm3", ""));
		setCustSteCd3(JSPUtil.getParameter(request, "cust_ste_cd3", ""));
		setCustSteCd2(JSPUtil.getParameter(request, "cust_ste_cd2", ""));
		setCustZipId3(JSPUtil.getParameter(request, "cust_zip_id3", ""));
		setCustZipId2(JSPUtil.getParameter(request, "cust_zip_id2", ""));
		setCustZipId1(JSPUtil.getParameter(request, "cust_zip_id1", ""));
		setToOrdFlg(JSPUtil.getParameter(request, "to_ord_flg", ""));
		setCustNm3(JSPUtil.getParameter(request, "cust_nm3", ""));
		setCustNm2(JSPUtil.getParameter(request, "cust_nm2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsBlCustVO[]
	 */
	public CndCstmsBlCustVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsBlCustVO[]
	 */
	public CndCstmsBlCustVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsBlCustVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custSeq2 = (JSPUtil.getParameter(request, prefix	+ "cust_seq2", length));
			String[] custSeq3 = (JSPUtil.getParameter(request, prefix	+ "cust_seq3", length));
			String[] custSeq1 = (JSPUtil.getParameter(request, prefix	+ "cust_seq1", length));
			String[] custSteCd1 = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custCntCd3 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd3", length));
			String[] cstmsDeclCntCd3 = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd3", length));
			String[] cstmsDeclCntCd2 = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd2", length));
			String[] cstmsDeclCntCd1 = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_cnt_cd1", length));
			String[] custNm1 = (JSPUtil.getParameter(request, prefix	+ "cust_nm1", length));
			String[] custCntCd1 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd1", length));
			String[] custCntCd2 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd2", length));
			String[] custAddr1 = (JSPUtil.getParameter(request, prefix	+ "cust_addr1", length));
			String[] custAddr3 = (JSPUtil.getParameter(request, prefix	+ "cust_addr3", length));
			String[] custAddr2 = (JSPUtil.getParameter(request, prefix	+ "cust_addr2", length));
			String[] custCtyNm1 = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm1", length));
			String[] custCtyNm2 = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm2", length));
			String[] custCtyNm3 = (JSPUtil.getParameter(request, prefix	+ "cust_cty_nm3", length));
			String[] custSteCd3 = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd3", length));
			String[] custSteCd2 = (JSPUtil.getParameter(request, prefix	+ "cust_ste_cd2", length));
			String[] custZipId3 = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id3", length));
			String[] custZipId2 = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id2", length));
			String[] custZipId1 = (JSPUtil.getParameter(request, prefix	+ "cust_zip_id1", length));
			String[] toOrdFlg = (JSPUtil.getParameter(request, prefix	+ "to_ord_flg", length));
			String[] custNm3 = (JSPUtil.getParameter(request, prefix	+ "cust_nm3", length));
			String[] custNm2 = (JSPUtil.getParameter(request, prefix	+ "cust_nm2", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsBlCustVO();
				if (custSeq2[i] != null)
					model.setCustSeq2(custSeq2[i]);
				if (custSeq3[i] != null)
					model.setCustSeq3(custSeq3[i]);
				if (custSeq1[i] != null)
					model.setCustSeq1(custSeq1[i]);
				if (custSteCd1[i] != null)
					model.setCustSteCd1(custSteCd1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCntCd3[i] != null)
					model.setCustCntCd3(custCntCd3[i]);
				if (cstmsDeclCntCd3[i] != null)
					model.setCstmsDeclCntCd3(cstmsDeclCntCd3[i]);
				if (cstmsDeclCntCd2[i] != null)
					model.setCstmsDeclCntCd2(cstmsDeclCntCd2[i]);
				if (cstmsDeclCntCd1[i] != null)
					model.setCstmsDeclCntCd1(cstmsDeclCntCd1[i]);
				if (custNm1[i] != null)
					model.setCustNm1(custNm1[i]);
				if (custCntCd1[i] != null)
					model.setCustCntCd1(custCntCd1[i]);
				if (custCntCd2[i] != null)
					model.setCustCntCd2(custCntCd2[i]);
				if (custAddr1[i] != null)
					model.setCustAddr1(custAddr1[i]);
				if (custAddr3[i] != null)
					model.setCustAddr3(custAddr3[i]);
				if (custAddr2[i] != null)
					model.setCustAddr2(custAddr2[i]);
				if (custCtyNm1[i] != null)
					model.setCustCtyNm1(custCtyNm1[i]);
				if (custCtyNm2[i] != null)
					model.setCustCtyNm2(custCtyNm2[i]);
				if (custCtyNm3[i] != null)
					model.setCustCtyNm3(custCtyNm3[i]);
				if (custSteCd3[i] != null)
					model.setCustSteCd3(custSteCd3[i]);
				if (custSteCd2[i] != null)
					model.setCustSteCd2(custSteCd2[i]);
				if (custZipId3[i] != null)
					model.setCustZipId3(custZipId3[i]);
				if (custZipId2[i] != null)
					model.setCustZipId2(custZipId2[i]);
				if (custZipId1[i] != null)
					model.setCustZipId1(custZipId1[i]);
				if (toOrdFlg[i] != null)
					model.setToOrdFlg(toOrdFlg[i]);
				if (custNm3[i] != null)
					model.setCustNm3(custNm3[i]);
				if (custNm2[i] != null)
					model.setCustNm2(custNm2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsBlCustVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsBlCustVO[]
	 */
	public CndCstmsBlCustVO[] getCndCstmsBlCustVOs(){
		CndCstmsBlCustVO[] vos = (CndCstmsBlCustVO[])models.toArray(new CndCstmsBlCustVO[models.size()]);
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
		this.custSeq2 = this.custSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq3 = this.custSeq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq1 = this.custSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCd1 = this.custSteCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd3 = this.custCntCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCd3 = this.cstmsDeclCntCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCd2 = this.cstmsDeclCntCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclCntCd1 = this.cstmsDeclCntCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm1 = this.custNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd1 = this.custCntCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd2 = this.custCntCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr1 = this.custAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr3 = this.custAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr2 = this.custAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm1 = this.custCtyNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm2 = this.custCtyNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtyNm3 = this.custCtyNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCd3 = this.custSteCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSteCd2 = this.custSteCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipId3 = this.custZipId3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipId2 = this.custZipId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custZipId1 = this.custZipId1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOrdFlg = this.toOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm3 = this.custNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm2 = this.custNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
