/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DemandNotePreviewMstVO.java
*@FileTitle : DemandNotePreviewMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.17
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.17 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemandNotePreviewMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemandNotePreviewMstVO> models = new ArrayList<DemandNotePreviewMstVO>();
	
	/* Column Info */
	private String address01 = null;
	/* Column Info */
	private String ofcAdd03 = null;
	/* Column Info */
	private String shNum = null;
	/* Column Info */
	private String taxAmtPrnFlg = null;
	/* Column Info */
	private String sheetRemark09 = null;
	/* Column Info */
	private String sheetRemark08 = null;
	/* Column Info */
	private String sheetRemark07 = null;
	/* Column Info */
	private String sheetRemark06 = null;
	/* Column Info */
	private String dmdtTrfNm = null;
	/* Column Info */
	private String header02 = null;
	/* Column Info */
	private String sheetRemark05 = null;
	/* Column Info */
	private String header01 = null;
	/* Column Info */
	private String sheetRemark04 = null;
	/* Column Info */
	private String sheetRemark03 = null;
	/* Column Info */
	private String phnFaxPrnFlg = null;
	/* Column Info */
	private String sheetRemark02 = null;
	/* Column Info */
	private String ofcAdd01 = null;
	/* Column Info */
	private String sheetRemark01 = null;
	/* Column Info */
	private String ofcAdd02 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sheetRemark10 = null;
	/* Column Info */
	private String header07 = null;
	/* Column Info */
	private String custVatPrnFlg = null;
	/* Column Info */
	private String sheetRemark11 = null;
	/* Column Info */
	private String header08 = null;
	/* Column Info */
	private String title = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String header09 = null;
	/* Column Info */
	private String header03 = null;
	/* Column Info */
	private String header04 = null;
	/* Column Info */
	private String taxNm = null;
	/* Column Info */
	private String header05 = null;
	/* Column Info */
	private String header06 = null;
	/* Column Info */
	private String comRef = null;
	/* Column Info */
	private String custVat = null;
	/* Column Info */
	private String printDate = null;
	/* Column Info */
	private String header10 = null;
	/* Column Info */
	private String sheetRemark13 = null;
	/* Column Info */
	private String sheetRemark12 = null;
	/* Column Info */
	private String bilToLocDivCd = null;
	/* Column Info */
	private String sheetRemark14 = null;
	/* Column Info */
	private String custRefPrnFlg = null;
	/* Column Info */
	private String dfltTaxRto = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DemandNotePreviewMstVO() {}

	public DemandNotePreviewMstVO(String ibflag, String pagerows, String custVat, String ofcAdd01, String ofcAdd02, String ofcAdd03, String address01, String header01, String header02, String header03, String header04, String header05, String header06, String header07, String header08, String header09, String header10, String shNum, String bilToLocDivCd, String custRefPrnFlg, String phnFaxPrnFlg, String custVatPrnFlg, String dfltTaxRto, String taxAmtPrnFlg, String comRef, String printDate, String dmdtTrfNm, String sheetRemark01, String sheetRemark02, String sheetRemark03, String sheetRemark04, String sheetRemark05, String sheetRemark06, String sheetRemark07, String sheetRemark08, String sheetRemark09, String sheetRemark10, String sheetRemark11, String sheetRemark12, String sheetRemark13, String sheetRemark14, String title, String taxNm) {
		this.address01 = address01;
		this.ofcAdd03 = ofcAdd03;
		this.shNum = shNum;
		this.taxAmtPrnFlg = taxAmtPrnFlg;
		this.sheetRemark09 = sheetRemark09;
		this.sheetRemark08 = sheetRemark08;
		this.sheetRemark07 = sheetRemark07;
		this.sheetRemark06 = sheetRemark06;
		this.dmdtTrfNm = dmdtTrfNm;
		this.header02 = header02;
		this.sheetRemark05 = sheetRemark05;
		this.header01 = header01;
		this.sheetRemark04 = sheetRemark04;
		this.sheetRemark03 = sheetRemark03;
		this.phnFaxPrnFlg = phnFaxPrnFlg;
		this.sheetRemark02 = sheetRemark02;
		this.ofcAdd01 = ofcAdd01;
		this.sheetRemark01 = sheetRemark01;
		this.ofcAdd02 = ofcAdd02;
		this.pagerows = pagerows;
		this.sheetRemark10 = sheetRemark10;
		this.header07 = header07;
		this.custVatPrnFlg = custVatPrnFlg;
		this.sheetRemark11 = sheetRemark11;
		this.header08 = header08;
		this.title = title;
		this.ibflag = ibflag;
		this.header09 = header09;
		this.header03 = header03;
		this.header04 = header04;
		this.taxNm = taxNm;
		this.header05 = header05;
		this.header06 = header06;
		this.comRef = comRef;
		this.custVat = custVat;
		this.printDate = printDate;
		this.header10 = header10;
		this.sheetRemark13 = sheetRemark13;
		this.sheetRemark12 = sheetRemark12;
		this.bilToLocDivCd = bilToLocDivCd;
		this.sheetRemark14 = sheetRemark14;
		this.custRefPrnFlg = custRefPrnFlg;
		this.dfltTaxRto = dfltTaxRto;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("address01", getAddress01());
		this.hashColumns.put("ofc_add03", getOfcAdd03());
		this.hashColumns.put("sh_num", getShNum());
		this.hashColumns.put("tax_amt_prn_flg", getTaxAmtPrnFlg());
		this.hashColumns.put("sheet_remark09", getSheetRemark09());
		this.hashColumns.put("sheet_remark08", getSheetRemark08());
		this.hashColumns.put("sheet_remark07", getSheetRemark07());
		this.hashColumns.put("sheet_remark06", getSheetRemark06());
		this.hashColumns.put("dmdt_trf_nm", getDmdtTrfNm());
		this.hashColumns.put("header02", getHeader02());
		this.hashColumns.put("sheet_remark05", getSheetRemark05());
		this.hashColumns.put("header01", getHeader01());
		this.hashColumns.put("sheet_remark04", getSheetRemark04());
		this.hashColumns.put("sheet_remark03", getSheetRemark03());
		this.hashColumns.put("phn_fax_prn_flg", getPhnFaxPrnFlg());
		this.hashColumns.put("sheet_remark02", getSheetRemark02());
		this.hashColumns.put("ofc_add01", getOfcAdd01());
		this.hashColumns.put("sheet_remark01", getSheetRemark01());
		this.hashColumns.put("ofc_add02", getOfcAdd02());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sheet_remark10", getSheetRemark10());
		this.hashColumns.put("header07", getHeader07());
		this.hashColumns.put("cust_vat_prn_flg", getCustVatPrnFlg());
		this.hashColumns.put("sheet_remark11", getSheetRemark11());
		this.hashColumns.put("header08", getHeader08());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("header09", getHeader09());
		this.hashColumns.put("header03", getHeader03());
		this.hashColumns.put("header04", getHeader04());
		this.hashColumns.put("tax_nm", getTaxNm());
		this.hashColumns.put("header05", getHeader05());
		this.hashColumns.put("header06", getHeader06());
		this.hashColumns.put("com_ref", getComRef());
		this.hashColumns.put("cust_vat", getCustVat());
		this.hashColumns.put("print_date", getPrintDate());
		this.hashColumns.put("header10", getHeader10());
		this.hashColumns.put("sheet_remark13", getSheetRemark13());
		this.hashColumns.put("sheet_remark12", getSheetRemark12());
		this.hashColumns.put("bil_to_loc_div_cd", getBilToLocDivCd());
		this.hashColumns.put("sheet_remark14", getSheetRemark14());
		this.hashColumns.put("cust_ref_prn_flg", getCustRefPrnFlg());
		this.hashColumns.put("dflt_tax_rto", getDfltTaxRto());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("address01", "address01");
		this.hashFields.put("ofc_add03", "ofcAdd03");
		this.hashFields.put("sh_num", "shNum");
		this.hashFields.put("tax_amt_prn_flg", "taxAmtPrnFlg");
		this.hashFields.put("sheet_remark09", "sheetRemark09");
		this.hashFields.put("sheet_remark08", "sheetRemark08");
		this.hashFields.put("sheet_remark07", "sheetRemark07");
		this.hashFields.put("sheet_remark06", "sheetRemark06");
		this.hashFields.put("dmdt_trf_nm", "dmdtTrfNm");
		this.hashFields.put("header02", "header02");
		this.hashFields.put("sheet_remark05", "sheetRemark05");
		this.hashFields.put("header01", "header01");
		this.hashFields.put("sheet_remark04", "sheetRemark04");
		this.hashFields.put("sheet_remark03", "sheetRemark03");
		this.hashFields.put("phn_fax_prn_flg", "phnFaxPrnFlg");
		this.hashFields.put("sheet_remark02", "sheetRemark02");
		this.hashFields.put("ofc_add01", "ofcAdd01");
		this.hashFields.put("sheet_remark01", "sheetRemark01");
		this.hashFields.put("ofc_add02", "ofcAdd02");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sheet_remark10", "sheetRemark10");
		this.hashFields.put("header07", "header07");
		this.hashFields.put("cust_vat_prn_flg", "custVatPrnFlg");
		this.hashFields.put("sheet_remark11", "sheetRemark11");
		this.hashFields.put("header08", "header08");
		this.hashFields.put("title", "title");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("header09", "header09");
		this.hashFields.put("header03", "header03");
		this.hashFields.put("header04", "header04");
		this.hashFields.put("tax_nm", "taxNm");
		this.hashFields.put("header05", "header05");
		this.hashFields.put("header06", "header06");
		this.hashFields.put("com_ref", "comRef");
		this.hashFields.put("cust_vat", "custVat");
		this.hashFields.put("print_date", "printDate");
		this.hashFields.put("header10", "header10");
		this.hashFields.put("sheet_remark13", "sheetRemark13");
		this.hashFields.put("sheet_remark12", "sheetRemark12");
		this.hashFields.put("bil_to_loc_div_cd", "bilToLocDivCd");
		this.hashFields.put("sheet_remark14", "sheetRemark14");
		this.hashFields.put("cust_ref_prn_flg", "custRefPrnFlg");
		this.hashFields.put("dflt_tax_rto", "dfltTaxRto");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return address01
	 */
	public String getAddress01() {
		return this.address01;
	}
	
	/**
	 * Column Info
	 * @return ofcAdd03
	 */
	public String getOfcAdd03() {
		return this.ofcAdd03;
	}
	
	/**
	 * Column Info
	 * @return shNum
	 */
	public String getShNum() {
		return this.shNum;
	}
	
	/**
	 * Column Info
	 * @return taxAmtPrnFlg
	 */
	public String getTaxAmtPrnFlg() {
		return this.taxAmtPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark09
	 */
	public String getSheetRemark09() {
		return this.sheetRemark09;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark08
	 */
	public String getSheetRemark08() {
		return this.sheetRemark08;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark07
	 */
	public String getSheetRemark07() {
		return this.sheetRemark07;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark06
	 */
	public String getSheetRemark06() {
		return this.sheetRemark06;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfNm
	 */
	public String getDmdtTrfNm() {
		return this.dmdtTrfNm;
	}
	
	/**
	 * Column Info
	 * @return header02
	 */
	public String getHeader02() {
		return this.header02;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark05
	 */
	public String getSheetRemark05() {
		return this.sheetRemark05;
	}
	
	/**
	 * Column Info
	 * @return header01
	 */
	public String getHeader01() {
		return this.header01;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark04
	 */
	public String getSheetRemark04() {
		return this.sheetRemark04;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark03
	 */
	public String getSheetRemark03() {
		return this.sheetRemark03;
	}
	
	/**
	 * Column Info
	 * @return phnFaxPrnFlg
	 */
	public String getPhnFaxPrnFlg() {
		return this.phnFaxPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark02
	 */
	public String getSheetRemark02() {
		return this.sheetRemark02;
	}
	
	/**
	 * Column Info
	 * @return ofcAdd01
	 */
	public String getOfcAdd01() {
		return this.ofcAdd01;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark01
	 */
	public String getSheetRemark01() {
		return this.sheetRemark01;
	}
	
	/**
	 * Column Info
	 * @return ofcAdd02
	 */
	public String getOfcAdd02() {
		return this.ofcAdd02;
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
	 * @return sheetRemark10
	 */
	public String getSheetRemark10() {
		return this.sheetRemark10;
	}
	
	/**
	 * Column Info
	 * @return header07
	 */
	public String getHeader07() {
		return this.header07;
	}
	
	/**
	 * Column Info
	 * @return custVatPrnFlg
	 */
	public String getCustVatPrnFlg() {
		return this.custVatPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark11
	 */
	public String getSheetRemark11() {
		return this.sheetRemark11;
	}
	
	/**
	 * Column Info
	 * @return header08
	 */
	public String getHeader08() {
		return this.header08;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return header09
	 */
	public String getHeader09() {
		return this.header09;
	}
	
	/**
	 * Column Info
	 * @return header03
	 */
	public String getHeader03() {
		return this.header03;
	}
	
	/**
	 * Column Info
	 * @return header04
	 */
	public String getHeader04() {
		return this.header04;
	}
	
	/**
	 * Column Info
	 * @return taxNm
	 */
	public String getTaxNm() {
		return this.taxNm;
	}
	
	/**
	 * Column Info
	 * @return header05
	 */
	public String getHeader05() {
		return this.header05;
	}
	
	/**
	 * Column Info
	 * @return header06
	 */
	public String getHeader06() {
		return this.header06;
	}
	
	/**
	 * Column Info
	 * @return comRef
	 */
	public String getComRef() {
		return this.comRef;
	}
	
	/**
	 * Column Info
	 * @return custVat
	 */
	public String getCustVat() {
		return this.custVat;
	}
	
	/**
	 * Column Info
	 * @return printDate
	 */
	public String getPrintDate() {
		return this.printDate;
	}
	
	/**
	 * Column Info
	 * @return header10
	 */
	public String getHeader10() {
		return this.header10;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark13
	 */
	public String getSheetRemark13() {
		return this.sheetRemark13;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark12
	 */
	public String getSheetRemark12() {
		return this.sheetRemark12;
	}
	
	/**
	 * Column Info
	 * @return bilToLocDivCd
	 */
	public String getBilToLocDivCd() {
		return this.bilToLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return sheetRemark14
	 */
	public String getSheetRemark14() {
		return this.sheetRemark14;
	}
	
	/**
	 * Column Info
	 * @return custRefPrnFlg
	 */
	public String getCustRefPrnFlg() {
		return this.custRefPrnFlg;
	}
	
	/**
	 * Column Info
	 * @return dfltTaxRto
	 */
	public String getDfltTaxRto() {
		return this.dfltTaxRto;
	}
	

	/**
	 * Column Info
	 * @param address01
	 */
	public void setAddress01(String address01) {
		this.address01 = address01;
	}
	
	/**
	 * Column Info
	 * @param ofcAdd03
	 */
	public void setOfcAdd03(String ofcAdd03) {
		this.ofcAdd03 = ofcAdd03;
	}
	
	/**
	 * Column Info
	 * @param shNum
	 */
	public void setShNum(String shNum) {
		this.shNum = shNum;
	}
	
	/**
	 * Column Info
	 * @param taxAmtPrnFlg
	 */
	public void setTaxAmtPrnFlg(String taxAmtPrnFlg) {
		this.taxAmtPrnFlg = taxAmtPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark09
	 */
	public void setSheetRemark09(String sheetRemark09) {
		this.sheetRemark09 = sheetRemark09;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark08
	 */
	public void setSheetRemark08(String sheetRemark08) {
		this.sheetRemark08 = sheetRemark08;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark07
	 */
	public void setSheetRemark07(String sheetRemark07) {
		this.sheetRemark07 = sheetRemark07;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark06
	 */
	public void setSheetRemark06(String sheetRemark06) {
		this.sheetRemark06 = sheetRemark06;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfNm
	 */
	public void setDmdtTrfNm(String dmdtTrfNm) {
		this.dmdtTrfNm = dmdtTrfNm;
	}
	
	/**
	 * Column Info
	 * @param header02
	 */
	public void setHeader02(String header02) {
		this.header02 = header02;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark05
	 */
	public void setSheetRemark05(String sheetRemark05) {
		this.sheetRemark05 = sheetRemark05;
	}
	
	/**
	 * Column Info
	 * @param header01
	 */
	public void setHeader01(String header01) {
		this.header01 = header01;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark04
	 */
	public void setSheetRemark04(String sheetRemark04) {
		this.sheetRemark04 = sheetRemark04;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark03
	 */
	public void setSheetRemark03(String sheetRemark03) {
		this.sheetRemark03 = sheetRemark03;
	}
	
	/**
	 * Column Info
	 * @param phnFaxPrnFlg
	 */
	public void setPhnFaxPrnFlg(String phnFaxPrnFlg) {
		this.phnFaxPrnFlg = phnFaxPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark02
	 */
	public void setSheetRemark02(String sheetRemark02) {
		this.sheetRemark02 = sheetRemark02;
	}
	
	/**
	 * Column Info
	 * @param ofcAdd01
	 */
	public void setOfcAdd01(String ofcAdd01) {
		this.ofcAdd01 = ofcAdd01;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark01
	 */
	public void setSheetRemark01(String sheetRemark01) {
		this.sheetRemark01 = sheetRemark01;
	}
	
	/**
	 * Column Info
	 * @param ofcAdd02
	 */
	public void setOfcAdd02(String ofcAdd02) {
		this.ofcAdd02 = ofcAdd02;
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
	 * @param sheetRemark10
	 */
	public void setSheetRemark10(String sheetRemark10) {
		this.sheetRemark10 = sheetRemark10;
	}
	
	/**
	 * Column Info
	 * @param header07
	 */
	public void setHeader07(String header07) {
		this.header07 = header07;
	}
	
	/**
	 * Column Info
	 * @param custVatPrnFlg
	 */
	public void setCustVatPrnFlg(String custVatPrnFlg) {
		this.custVatPrnFlg = custVatPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark11
	 */
	public void setSheetRemark11(String sheetRemark11) {
		this.sheetRemark11 = sheetRemark11;
	}
	
	/**
	 * Column Info
	 * @param header08
	 */
	public void setHeader08(String header08) {
		this.header08 = header08;
	}
	
	/**
	 * Column Info
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param header09
	 */
	public void setHeader09(String header09) {
		this.header09 = header09;
	}
	
	/**
	 * Column Info
	 * @param header03
	 */
	public void setHeader03(String header03) {
		this.header03 = header03;
	}
	
	/**
	 * Column Info
	 * @param header04
	 */
	public void setHeader04(String header04) {
		this.header04 = header04;
	}
	
	/**
	 * Column Info
	 * @param taxNm
	 */
	public void setTaxNm(String taxNm) {
		this.taxNm = taxNm;
	}
	
	/**
	 * Column Info
	 * @param header05
	 */
	public void setHeader05(String header05) {
		this.header05 = header05;
	}
	
	/**
	 * Column Info
	 * @param header06
	 */
	public void setHeader06(String header06) {
		this.header06 = header06;
	}
	
	/**
	 * Column Info
	 * @param comRef
	 */
	public void setComRef(String comRef) {
		this.comRef = comRef;
	}
	
	/**
	 * Column Info
	 * @param custVat
	 */
	public void setCustVat(String custVat) {
		this.custVat = custVat;
	}
	
	/**
	 * Column Info
	 * @param printDate
	 */
	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}
	
	/**
	 * Column Info
	 * @param header10
	 */
	public void setHeader10(String header10) {
		this.header10 = header10;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark13
	 */
	public void setSheetRemark13(String sheetRemark13) {
		this.sheetRemark13 = sheetRemark13;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark12
	 */
	public void setSheetRemark12(String sheetRemark12) {
		this.sheetRemark12 = sheetRemark12;
	}
	
	/**
	 * Column Info
	 * @param bilToLocDivCd
	 */
	public void setBilToLocDivCd(String bilToLocDivCd) {
		this.bilToLocDivCd = bilToLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param sheetRemark14
	 */
	public void setSheetRemark14(String sheetRemark14) {
		this.sheetRemark14 = sheetRemark14;
	}
	
	/**
	 * Column Info
	 * @param custRefPrnFlg
	 */
	public void setCustRefPrnFlg(String custRefPrnFlg) {
		this.custRefPrnFlg = custRefPrnFlg;
	}
	
	/**
	 * Column Info
	 * @param dfltTaxRto
	 */
	public void setDfltTaxRto(String dfltTaxRto) {
		this.dfltTaxRto = dfltTaxRto;
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
		setAddress01(JSPUtil.getParameter(request, prefix + "address01", ""));
		setOfcAdd03(JSPUtil.getParameter(request, prefix + "ofc_add03", ""));
		setShNum(JSPUtil.getParameter(request, prefix + "sh_num", ""));
		setTaxAmtPrnFlg(JSPUtil.getParameter(request, prefix + "tax_amt_prn_flg", ""));
		setSheetRemark09(JSPUtil.getParameter(request, prefix + "sheet_remark09", ""));
		setSheetRemark08(JSPUtil.getParameter(request, prefix + "sheet_remark08", ""));
		setSheetRemark07(JSPUtil.getParameter(request, prefix + "sheet_remark07", ""));
		setSheetRemark06(JSPUtil.getParameter(request, prefix + "sheet_remark06", ""));
		setDmdtTrfNm(JSPUtil.getParameter(request, prefix + "dmdt_trf_nm", ""));
		setHeader02(JSPUtil.getParameter(request, prefix + "header02", ""));
		setSheetRemark05(JSPUtil.getParameter(request, prefix + "sheet_remark05", ""));
		setHeader01(JSPUtil.getParameter(request, prefix + "header01", ""));
		setSheetRemark04(JSPUtil.getParameter(request, prefix + "sheet_remark04", ""));
		setSheetRemark03(JSPUtil.getParameter(request, prefix + "sheet_remark03", ""));
		setPhnFaxPrnFlg(JSPUtil.getParameter(request, prefix + "phn_fax_prn_flg", ""));
		setSheetRemark02(JSPUtil.getParameter(request, prefix + "sheet_remark02", ""));
		setOfcAdd01(JSPUtil.getParameter(request, prefix + "ofc_add01", ""));
		setSheetRemark01(JSPUtil.getParameter(request, prefix + "sheet_remark01", ""));
		setOfcAdd02(JSPUtil.getParameter(request, prefix + "ofc_add02", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSheetRemark10(JSPUtil.getParameter(request, prefix + "sheet_remark10", ""));
		setHeader07(JSPUtil.getParameter(request, prefix + "header07", ""));
		setCustVatPrnFlg(JSPUtil.getParameter(request, prefix + "cust_vat_prn_flg", ""));
		setSheetRemark11(JSPUtil.getParameter(request, prefix + "sheet_remark11", ""));
		setHeader08(JSPUtil.getParameter(request, prefix + "header08", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHeader09(JSPUtil.getParameter(request, prefix + "header09", ""));
		setHeader03(JSPUtil.getParameter(request, prefix + "header03", ""));
		setHeader04(JSPUtil.getParameter(request, prefix + "header04", ""));
		setTaxNm(JSPUtil.getParameter(request, prefix + "tax_nm", ""));
		setHeader05(JSPUtil.getParameter(request, prefix + "header05", ""));
		setHeader06(JSPUtil.getParameter(request, prefix + "header06", ""));
		setComRef(JSPUtil.getParameter(request, prefix + "com_ref", ""));
		setCustVat(JSPUtil.getParameter(request, prefix + "cust_vat", ""));
		setPrintDate(JSPUtil.getParameter(request, prefix + "print_date", ""));
		setHeader10(JSPUtil.getParameter(request, prefix + "header10", ""));
		setSheetRemark13(JSPUtil.getParameter(request, prefix + "sheet_remark13", ""));
		setSheetRemark12(JSPUtil.getParameter(request, prefix + "sheet_remark12", ""));
		setBilToLocDivCd(JSPUtil.getParameter(request, prefix + "bil_to_loc_div_cd", ""));
		setSheetRemark14(JSPUtil.getParameter(request, prefix + "sheet_remark14", ""));
		setCustRefPrnFlg(JSPUtil.getParameter(request, prefix + "cust_ref_prn_flg", ""));
		setDfltTaxRto(JSPUtil.getParameter(request, prefix + "dflt_tax_rto", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemandNotePreviewMstVO[]
	 */
	public DemandNotePreviewMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemandNotePreviewMstVO[]
	 */
	public DemandNotePreviewMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemandNotePreviewMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] address01 = (JSPUtil.getParameter(request, prefix	+ "address01", length));
			String[] ofcAdd03 = (JSPUtil.getParameter(request, prefix	+ "ofc_add03", length));
			String[] shNum = (JSPUtil.getParameter(request, prefix	+ "sh_num", length));
			String[] taxAmtPrnFlg = (JSPUtil.getParameter(request, prefix	+ "tax_amt_prn_flg", length));
			String[] sheetRemark09 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark09", length));
			String[] sheetRemark08 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark08", length));
			String[] sheetRemark07 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark07", length));
			String[] sheetRemark06 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark06", length));
			String[] dmdtTrfNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_nm", length));
			String[] header02 = (JSPUtil.getParameter(request, prefix	+ "header02", length));
			String[] sheetRemark05 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark05", length));
			String[] header01 = (JSPUtil.getParameter(request, prefix	+ "header01", length));
			String[] sheetRemark04 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark04", length));
			String[] sheetRemark03 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark03", length));
			String[] phnFaxPrnFlg = (JSPUtil.getParameter(request, prefix	+ "phn_fax_prn_flg", length));
			String[] sheetRemark02 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark02", length));
			String[] ofcAdd01 = (JSPUtil.getParameter(request, prefix	+ "ofc_add01", length));
			String[] sheetRemark01 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark01", length));
			String[] ofcAdd02 = (JSPUtil.getParameter(request, prefix	+ "ofc_add02", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sheetRemark10 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark10", length));
			String[] header07 = (JSPUtil.getParameter(request, prefix	+ "header07", length));
			String[] custVatPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cust_vat_prn_flg", length));
			String[] sheetRemark11 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark11", length));
			String[] header08 = (JSPUtil.getParameter(request, prefix	+ "header08", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] header09 = (JSPUtil.getParameter(request, prefix	+ "header09", length));
			String[] header03 = (JSPUtil.getParameter(request, prefix	+ "header03", length));
			String[] header04 = (JSPUtil.getParameter(request, prefix	+ "header04", length));
			String[] taxNm = (JSPUtil.getParameter(request, prefix	+ "tax_nm", length));
			String[] header05 = (JSPUtil.getParameter(request, prefix	+ "header05", length));
			String[] header06 = (JSPUtil.getParameter(request, prefix	+ "header06", length));
			String[] comRef = (JSPUtil.getParameter(request, prefix	+ "com_ref", length));
			String[] custVat = (JSPUtil.getParameter(request, prefix	+ "cust_vat", length));
			String[] printDate = (JSPUtil.getParameter(request, prefix	+ "print_date", length));
			String[] header10 = (JSPUtil.getParameter(request, prefix	+ "header10", length));
			String[] sheetRemark13 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark13", length));
			String[] sheetRemark12 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark12", length));
			String[] bilToLocDivCd = (JSPUtil.getParameter(request, prefix	+ "bil_to_loc_div_cd", length));
			String[] sheetRemark14 = (JSPUtil.getParameter(request, prefix	+ "sheet_remark14", length));
			String[] custRefPrnFlg = (JSPUtil.getParameter(request, prefix	+ "cust_ref_prn_flg", length));
			String[] dfltTaxRto = (JSPUtil.getParameter(request, prefix	+ "dflt_tax_rto", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemandNotePreviewMstVO();
				if (address01[i] != null)
					model.setAddress01(address01[i]);
				if (ofcAdd03[i] != null)
					model.setOfcAdd03(ofcAdd03[i]);
				if (shNum[i] != null)
					model.setShNum(shNum[i]);
				if (taxAmtPrnFlg[i] != null)
					model.setTaxAmtPrnFlg(taxAmtPrnFlg[i]);
				if (sheetRemark09[i] != null)
					model.setSheetRemark09(sheetRemark09[i]);
				if (sheetRemark08[i] != null)
					model.setSheetRemark08(sheetRemark08[i]);
				if (sheetRemark07[i] != null)
					model.setSheetRemark07(sheetRemark07[i]);
				if (sheetRemark06[i] != null)
					model.setSheetRemark06(sheetRemark06[i]);
				if (dmdtTrfNm[i] != null)
					model.setDmdtTrfNm(dmdtTrfNm[i]);
				if (header02[i] != null)
					model.setHeader02(header02[i]);
				if (sheetRemark05[i] != null)
					model.setSheetRemark05(sheetRemark05[i]);
				if (header01[i] != null)
					model.setHeader01(header01[i]);
				if (sheetRemark04[i] != null)
					model.setSheetRemark04(sheetRemark04[i]);
				if (sheetRemark03[i] != null)
					model.setSheetRemark03(sheetRemark03[i]);
				if (phnFaxPrnFlg[i] != null)
					model.setPhnFaxPrnFlg(phnFaxPrnFlg[i]);
				if (sheetRemark02[i] != null)
					model.setSheetRemark02(sheetRemark02[i]);
				if (ofcAdd01[i] != null)
					model.setOfcAdd01(ofcAdd01[i]);
				if (sheetRemark01[i] != null)
					model.setSheetRemark01(sheetRemark01[i]);
				if (ofcAdd02[i] != null)
					model.setOfcAdd02(ofcAdd02[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sheetRemark10[i] != null)
					model.setSheetRemark10(sheetRemark10[i]);
				if (header07[i] != null)
					model.setHeader07(header07[i]);
				if (custVatPrnFlg[i] != null)
					model.setCustVatPrnFlg(custVatPrnFlg[i]);
				if (sheetRemark11[i] != null)
					model.setSheetRemark11(sheetRemark11[i]);
				if (header08[i] != null)
					model.setHeader08(header08[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (header09[i] != null)
					model.setHeader09(header09[i]);
				if (header03[i] != null)
					model.setHeader03(header03[i]);
				if (header04[i] != null)
					model.setHeader04(header04[i]);
				if (taxNm[i] != null)
					model.setTaxNm(taxNm[i]);
				if (header05[i] != null)
					model.setHeader05(header05[i]);
				if (header06[i] != null)
					model.setHeader06(header06[i]);
				if (comRef[i] != null)
					model.setComRef(comRef[i]);
				if (custVat[i] != null)
					model.setCustVat(custVat[i]);
				if (printDate[i] != null)
					model.setPrintDate(printDate[i]);
				if (header10[i] != null)
					model.setHeader10(header10[i]);
				if (sheetRemark13[i] != null)
					model.setSheetRemark13(sheetRemark13[i]);
				if (sheetRemark12[i] != null)
					model.setSheetRemark12(sheetRemark12[i]);
				if (bilToLocDivCd[i] != null)
					model.setBilToLocDivCd(bilToLocDivCd[i]);
				if (sheetRemark14[i] != null)
					model.setSheetRemark14(sheetRemark14[i]);
				if (custRefPrnFlg[i] != null)
					model.setCustRefPrnFlg(custRefPrnFlg[i]);
				if (dfltTaxRto[i] != null)
					model.setDfltTaxRto(dfltTaxRto[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemandNotePreviewMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemandNotePreviewMstVO[]
	 */
	public DemandNotePreviewMstVO[] getDemandNotePreviewMstVOs(){
		DemandNotePreviewMstVO[] vos = (DemandNotePreviewMstVO[])models.toArray(new DemandNotePreviewMstVO[models.size()]);
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
		this.address01 = this.address01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAdd03 = this.ofcAdd03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNum = this.shNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmtPrnFlg = this.taxAmtPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark09 = this.sheetRemark09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark08 = this.sheetRemark08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark07 = this.sheetRemark07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark06 = this.sheetRemark06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfNm = this.dmdtTrfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header02 = this.header02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark05 = this.sheetRemark05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header01 = this.header01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark04 = this.sheetRemark04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark03 = this.sheetRemark03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnFaxPrnFlg = this.phnFaxPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark02 = this.sheetRemark02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAdd01 = this.ofcAdd01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark01 = this.sheetRemark01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAdd02 = this.ofcAdd02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark10 = this.sheetRemark10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header07 = this.header07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVatPrnFlg = this.custVatPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark11 = this.sheetRemark11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header08 = this.header08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header09 = this.header09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header03 = this.header03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header04 = this.header04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxNm = this.taxNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header05 = this.header05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header06 = this.header06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comRef = this.comRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custVat = this.custVat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.printDate = this.printDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header10 = this.header10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark13 = this.sheetRemark13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark12 = this.sheetRemark12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToLocDivCd = this.bilToLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetRemark14 = this.sheetRemark14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefPrnFlg = this.custRefPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltTaxRto = this.dfltTaxRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
