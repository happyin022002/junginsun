/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcBlCopyMailInfoVO.java
*@FileTitle : ArrNtcBlCopyMailInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcBlCopyMailInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcBlCopyMailInfoVO> models = new ArrayList<ArrNtcBlCopyMailInfoVO>();
	
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String emlSndFlg5 = null;
	/* Column Info */
	private String emlSndFlg4 = null;
	/* Column Info */
	private String emlSndGdt = null;
	/* Column Info */
	private String emlSndFlg1 = null;
	/* Column Info */
	private String emlSndFlg3 = null;
	/* Column Info */
	private String emlSndFlg2 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String emlNtcSndRsltCd1 = null;
	/* Column Info */
	private String emlNtcSndRsltCd2 = null;
	/* Column Info */
	private String emlNtcSndRsltCd3 = null;
	/* Column Info */
	private String emlNtcSndRsltCd4 = null;
	/* Column Info */
	private String emlNtcSndRsltCd5 = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String ntcTp = null;
	/* Column Info */
	private String ntcEml1 = null;
	/* Column Info */
	private String ntcEml2 = null;
	/* Column Info */
	private String ntcEml3 = null;
	/* Column Info */
	private String ntcEml4 = null;
	/* Column Info */
	private String ntcEml5 = null;
	/* Column Info */
	private String emlNtcSndRsltNm4 = null;
	/* Column Info */
	private String emlNtcSndRsltNm5 = null;
	/* Column Info */
	private String emlNtcSndRsltNm1 = null;
	/* Column Info */
	private String emlNtcSndRsltNm2 = null;
	/* Column Info */
	private String emlNtcSndRsltNm3 = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String isEval = null;
	/* Column Info */
	private String chgDpFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcBlCopyMailInfoVO() {}

	public ArrNtcBlCopyMailInfoVO(String ibflag, String pagerows, String ntcTp, String chgDpFlg, String bkgCustTpCd, String ntcEml1, String ntcEml2, String ntcEml3, String ntcEml4, String ntcEml5, String emlSndFlg1, String emlSndFlg2, String emlSndFlg3, String emlSndFlg4, String emlSndFlg5, String emlNtcSndRsltCd1, String emlNtcSndRsltNm1, String emlNtcSndRsltCd2, String emlNtcSndRsltNm2, String emlNtcSndRsltCd3, String emlNtcSndRsltNm3, String emlNtcSndRsltCd4, String emlNtcSndRsltNm4, String emlNtcSndRsltCd5, String emlNtcSndRsltNm5, String emlSndDt, String emlSndGdt, String diffRmk, String isEval) {
		this.emlSndDt = emlSndDt;
		this.emlSndFlg5 = emlSndFlg5;
		this.emlSndFlg4 = emlSndFlg4;
		this.emlSndGdt = emlSndGdt;
		this.emlSndFlg1 = emlSndFlg1;
		this.emlSndFlg3 = emlSndFlg3;
		this.emlSndFlg2 = emlSndFlg2;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.emlNtcSndRsltCd1 = emlNtcSndRsltCd1;
		this.emlNtcSndRsltCd2 = emlNtcSndRsltCd2;
		this.emlNtcSndRsltCd3 = emlNtcSndRsltCd3;
		this.emlNtcSndRsltCd4 = emlNtcSndRsltCd4;
		this.emlNtcSndRsltCd5 = emlNtcSndRsltCd5;
		this.bkgCustTpCd = bkgCustTpCd;
		this.ntcTp = ntcTp;
		this.ntcEml1 = ntcEml1;
		this.ntcEml2 = ntcEml2;
		this.ntcEml3 = ntcEml3;
		this.ntcEml4 = ntcEml4;
		this.ntcEml5 = ntcEml5;
		this.emlNtcSndRsltNm4 = emlNtcSndRsltNm4;
		this.emlNtcSndRsltNm5 = emlNtcSndRsltNm5;
		this.emlNtcSndRsltNm1 = emlNtcSndRsltNm1;
		this.emlNtcSndRsltNm2 = emlNtcSndRsltNm2;
		this.emlNtcSndRsltNm3 = emlNtcSndRsltNm3;
		this.diffRmk = diffRmk;
		this.isEval = isEval;
		this.chgDpFlg = chgDpFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("eml_snd_flg5", getEmlSndFlg5());
		this.hashColumns.put("eml_snd_flg4", getEmlSndFlg4());
		this.hashColumns.put("eml_snd_gdt", getEmlSndGdt());
		this.hashColumns.put("eml_snd_flg1", getEmlSndFlg1());
		this.hashColumns.put("eml_snd_flg3", getEmlSndFlg3());
		this.hashColumns.put("eml_snd_flg2", getEmlSndFlg2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eml_ntc_snd_rslt_cd1", getEmlNtcSndRsltCd1());
		this.hashColumns.put("eml_ntc_snd_rslt_cd2", getEmlNtcSndRsltCd2());
		this.hashColumns.put("eml_ntc_snd_rslt_cd3", getEmlNtcSndRsltCd3());
		this.hashColumns.put("eml_ntc_snd_rslt_cd4", getEmlNtcSndRsltCd4());
		this.hashColumns.put("eml_ntc_snd_rslt_cd5", getEmlNtcSndRsltCd5());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("ntc_tp", getNtcTp());
		this.hashColumns.put("ntc_eml1", getNtcEml1());
		this.hashColumns.put("ntc_eml2", getNtcEml2());
		this.hashColumns.put("ntc_eml3", getNtcEml3());
		this.hashColumns.put("ntc_eml4", getNtcEml4());
		this.hashColumns.put("ntc_eml5", getNtcEml5());
		this.hashColumns.put("eml_ntc_snd_rslt_nm4", getEmlNtcSndRsltNm4());
		this.hashColumns.put("eml_ntc_snd_rslt_nm5", getEmlNtcSndRsltNm5());
		this.hashColumns.put("eml_ntc_snd_rslt_nm1", getEmlNtcSndRsltNm1());
		this.hashColumns.put("eml_ntc_snd_rslt_nm2", getEmlNtcSndRsltNm2());
		this.hashColumns.put("eml_ntc_snd_rslt_nm3", getEmlNtcSndRsltNm3());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("is_eval", getIsEval());
		this.hashColumns.put("chg_dp_flg", getChgDpFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("eml_snd_flg5", "emlSndFlg5");
		this.hashFields.put("eml_snd_flg4", "emlSndFlg4");
		this.hashFields.put("eml_snd_gdt", "emlSndGdt");
		this.hashFields.put("eml_snd_flg1", "emlSndFlg1");
		this.hashFields.put("eml_snd_flg3", "emlSndFlg3");
		this.hashFields.put("eml_snd_flg2", "emlSndFlg2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eml_ntc_snd_rslt_cd1", "emlNtcSndRsltCd1");
		this.hashFields.put("eml_ntc_snd_rslt_cd2", "emlNtcSndRsltCd2");
		this.hashFields.put("eml_ntc_snd_rslt_cd3", "emlNtcSndRsltCd3");
		this.hashFields.put("eml_ntc_snd_rslt_cd4", "emlNtcSndRsltCd4");
		this.hashFields.put("eml_ntc_snd_rslt_cd5", "emlNtcSndRsltCd5");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("ntc_tp", "ntcTp");
		this.hashFields.put("ntc_eml1", "ntcEml1");
		this.hashFields.put("ntc_eml2", "ntcEml2");
		this.hashFields.put("ntc_eml3", "ntcEml3");
		this.hashFields.put("ntc_eml4", "ntcEml4");
		this.hashFields.put("ntc_eml5", "ntcEml5");
		this.hashFields.put("eml_ntc_snd_rslt_nm4", "emlNtcSndRsltNm4");
		this.hashFields.put("eml_ntc_snd_rslt_nm5", "emlNtcSndRsltNm5");
		this.hashFields.put("eml_ntc_snd_rslt_nm1", "emlNtcSndRsltNm1");
		this.hashFields.put("eml_ntc_snd_rslt_nm2", "emlNtcSndRsltNm2");
		this.hashFields.put("eml_ntc_snd_rslt_nm3", "emlNtcSndRsltNm3");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("is_eval", "isEval");
		this.hashFields.put("chg_dp_flg", "chgDpFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg5
	 */
	public String getEmlSndFlg5() {
		return this.emlSndFlg5;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg4
	 */
	public String getEmlSndFlg4() {
		return this.emlSndFlg4;
	}
	
	/**
	 * Column Info
	 * @return emlSndGdt
	 */
	public String getEmlSndGdt() {
		return this.emlSndGdt;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg1
	 */
	public String getEmlSndFlg1() {
		return this.emlSndFlg1;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg3
	 */
	public String getEmlSndFlg3() {
		return this.emlSndFlg3;
	}
	
	/**
	 * Column Info
	 * @return emlSndFlg2
	 */
	public String getEmlSndFlg2() {
		return this.emlSndFlg2;
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
	 * @return emlNtcSndRsltCd1
	 */
	public String getEmlNtcSndRsltCd1() {
		return this.emlNtcSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd2
	 */
	public String getEmlNtcSndRsltCd2() {
		return this.emlNtcSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd3
	 */
	public String getEmlNtcSndRsltCd3() {
		return this.emlNtcSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd4
	 */
	public String getEmlNtcSndRsltCd4() {
		return this.emlNtcSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltCd5
	 */
	public String getEmlNtcSndRsltCd5() {
		return this.emlNtcSndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntcTp
	 */
	public String getNtcTp() {
		return this.ntcTp;
	}
	
	/**
	 * Column Info
	 * @return ntcEml1
	 */
	public String getNtcEml1() {
		return this.ntcEml1;
	}
	
	/**
	 * Column Info
	 * @return ntcEml2
	 */
	public String getNtcEml2() {
		return this.ntcEml2;
	}
	
	/**
	 * Column Info
	 * @return ntcEml3
	 */
	public String getNtcEml3() {
		return this.ntcEml3;
	}
	
	/**
	 * Column Info
	 * @return ntcEml4
	 */
	public String getNtcEml4() {
		return this.ntcEml4;
	}
	
	/**
	 * Column Info
	 * @return ntcEml5
	 */
	public String getNtcEml5() {
		return this.ntcEml5;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm4
	 */
	public String getEmlNtcSndRsltNm4() {
		return this.emlNtcSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm5
	 */
	public String getEmlNtcSndRsltNm5() {
		return this.emlNtcSndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm1
	 */
	public String getEmlNtcSndRsltNm1() {
		return this.emlNtcSndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm2
	 */
	public String getEmlNtcSndRsltNm2() {
		return this.emlNtcSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @return emlNtcSndRsltNm3
	 */
	public String getEmlNtcSndRsltNm3() {
		return this.emlNtcSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return isEval
	 */
	public String getIsEval() {
		return this.isEval;
	}
	
	/**
	 * Column Info
	 * @return chgDpFlg
	 */
	public String getChgDpFlg() {
		return this.chgDpFlg;
	}
	

	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg5
	 */
	public void setEmlSndFlg5(String emlSndFlg5) {
		this.emlSndFlg5 = emlSndFlg5;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg4
	 */
	public void setEmlSndFlg4(String emlSndFlg4) {
		this.emlSndFlg4 = emlSndFlg4;
	}
	
	/**
	 * Column Info
	 * @param emlSndGdt
	 */
	public void setEmlSndGdt(String emlSndGdt) {
		this.emlSndGdt = emlSndGdt;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg1
	 */
	public void setEmlSndFlg1(String emlSndFlg1) {
		this.emlSndFlg1 = emlSndFlg1;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg3
	 */
	public void setEmlSndFlg3(String emlSndFlg3) {
		this.emlSndFlg3 = emlSndFlg3;
	}
	
	/**
	 * Column Info
	 * @param emlSndFlg2
	 */
	public void setEmlSndFlg2(String emlSndFlg2) {
		this.emlSndFlg2 = emlSndFlg2;
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
	 * @param emlNtcSndRsltCd1
	 */
	public void setEmlNtcSndRsltCd1(String emlNtcSndRsltCd1) {
		this.emlNtcSndRsltCd1 = emlNtcSndRsltCd1;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd2
	 */
	public void setEmlNtcSndRsltCd2(String emlNtcSndRsltCd2) {
		this.emlNtcSndRsltCd2 = emlNtcSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd3
	 */
	public void setEmlNtcSndRsltCd3(String emlNtcSndRsltCd3) {
		this.emlNtcSndRsltCd3 = emlNtcSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd4
	 */
	public void setEmlNtcSndRsltCd4(String emlNtcSndRsltCd4) {
		this.emlNtcSndRsltCd4 = emlNtcSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltCd5
	 */
	public void setEmlNtcSndRsltCd5(String emlNtcSndRsltCd5) {
		this.emlNtcSndRsltCd5 = emlNtcSndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntcTp
	 */
	public void setNtcTp(String ntcTp) {
		this.ntcTp = ntcTp;
	}
	
	/**
	 * Column Info
	 * @param ntcEml1
	 */
	public void setNtcEml1(String ntcEml1) {
		this.ntcEml1 = ntcEml1;
	}
	
	/**
	 * Column Info
	 * @param ntcEml2
	 */
	public void setNtcEml2(String ntcEml2) {
		this.ntcEml2 = ntcEml2;
	}
	
	/**
	 * Column Info
	 * @param ntcEml3
	 */
	public void setNtcEml3(String ntcEml3) {
		this.ntcEml3 = ntcEml3;
	}
	
	/**
	 * Column Info
	 * @param ntcEml4
	 */
	public void setNtcEml4(String ntcEml4) {
		this.ntcEml4 = ntcEml4;
	}
	
	/**
	 * Column Info
	 * @param ntcEml5
	 */
	public void setNtcEml5(String ntcEml5) {
		this.ntcEml5 = ntcEml5;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm4
	 */
	public void setEmlNtcSndRsltNm4(String emlNtcSndRsltNm4) {
		this.emlNtcSndRsltNm4 = emlNtcSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm5
	 */
	public void setEmlNtcSndRsltNm5(String emlNtcSndRsltNm5) {
		this.emlNtcSndRsltNm5 = emlNtcSndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm1
	 */
	public void setEmlNtcSndRsltNm1(String emlNtcSndRsltNm1) {
		this.emlNtcSndRsltNm1 = emlNtcSndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm2
	 */
	public void setEmlNtcSndRsltNm2(String emlNtcSndRsltNm2) {
		this.emlNtcSndRsltNm2 = emlNtcSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @param emlNtcSndRsltNm3
	 */
	public void setEmlNtcSndRsltNm3(String emlNtcSndRsltNm3) {
		this.emlNtcSndRsltNm3 = emlNtcSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param isEval
	 */
	public void setIsEval(String isEval) {
		this.isEval = isEval;
	}
	
	/**
	 * Column Info
	 * @param chgDpFlg
	 */
	public void setChgDpFlg(String chgDpFlg) {
		this.chgDpFlg = chgDpFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEmlSndDt(JSPUtil.getParameter(request, "eml_snd_dt", ""));
		setEmlSndFlg5(JSPUtil.getParameter(request, "eml_snd_flg5", ""));
		setEmlSndFlg4(JSPUtil.getParameter(request, "eml_snd_flg4", ""));
		setEmlSndGdt(JSPUtil.getParameter(request, "eml_snd_gdt", ""));
		setEmlSndFlg1(JSPUtil.getParameter(request, "eml_snd_flg1", ""));
		setEmlSndFlg3(JSPUtil.getParameter(request, "eml_snd_flg3", ""));
		setEmlSndFlg2(JSPUtil.getParameter(request, "eml_snd_flg2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEmlNtcSndRsltCd1(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_cd1", ""));
		setEmlNtcSndRsltCd2(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_cd2", ""));
		setEmlNtcSndRsltCd3(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_cd3", ""));
		setEmlNtcSndRsltCd4(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_cd4", ""));
		setEmlNtcSndRsltCd5(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_cd5", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setNtcTp(JSPUtil.getParameter(request, "ntc_tp", ""));
		setNtcEml1(JSPUtil.getParameter(request, "ntc_eml1", ""));
		setNtcEml2(JSPUtil.getParameter(request, "ntc_eml2", ""));
		setNtcEml3(JSPUtil.getParameter(request, "ntc_eml3", ""));
		setNtcEml4(JSPUtil.getParameter(request, "ntc_eml4", ""));
		setNtcEml5(JSPUtil.getParameter(request, "ntc_eml5", ""));
		setEmlNtcSndRsltNm4(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_nm4", ""));
		setEmlNtcSndRsltNm5(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_nm5", ""));
		setEmlNtcSndRsltNm1(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_nm1", ""));
		setEmlNtcSndRsltNm2(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_nm2", ""));
		setEmlNtcSndRsltNm3(JSPUtil.getParameter(request, "eml_ntc_snd_rslt_nm3", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setIsEval(JSPUtil.getParameter(request, "is_eval", ""));
		setChgDpFlg(JSPUtil.getParameter(request, "chg_dp_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcBlCopyMailInfoVO[]
	 */
	public ArrNtcBlCopyMailInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcBlCopyMailInfoVO[]
	 */
	public ArrNtcBlCopyMailInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcBlCopyMailInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] emlSndFlg5 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg5", length));
			String[] emlSndFlg4 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg4", length));
			String[] emlSndGdt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_gdt", length));
			String[] emlSndFlg1 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg1", length));
			String[] emlSndFlg3 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg3", length));
			String[] emlSndFlg2 = (JSPUtil.getParameter(request, prefix	+ "eml_snd_flg2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] emlNtcSndRsltCd1 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd1", length));
			String[] emlNtcSndRsltCd2 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd2", length));
			String[] emlNtcSndRsltCd3 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd3", length));
			String[] emlNtcSndRsltCd4 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd4", length));
			String[] emlNtcSndRsltCd5 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_cd5", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] ntcTp = (JSPUtil.getParameter(request, prefix	+ "ntc_tp", length));
			String[] ntcEml1 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml1", length));
			String[] ntcEml2 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml2", length));
			String[] ntcEml3 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml3", length));
			String[] ntcEml4 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml4", length));
			String[] ntcEml5 = (JSPUtil.getParameter(request, prefix	+ "ntc_eml5", length));
			String[] emlNtcSndRsltNm4 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm4", length));
			String[] emlNtcSndRsltNm5 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm5", length));
			String[] emlNtcSndRsltNm1 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm1", length));
			String[] emlNtcSndRsltNm2 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm2", length));
			String[] emlNtcSndRsltNm3 = (JSPUtil.getParameter(request, prefix	+ "eml_ntc_snd_rslt_nm3", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] isEval = (JSPUtil.getParameter(request, prefix	+ "is_eval", length));
			String[] chgDpFlg = (JSPUtil.getParameter(request, prefix	+ "chg_dp_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcBlCopyMailInfoVO();
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (emlSndFlg5[i] != null)
					model.setEmlSndFlg5(emlSndFlg5[i]);
				if (emlSndFlg4[i] != null)
					model.setEmlSndFlg4(emlSndFlg4[i]);
				if (emlSndGdt[i] != null)
					model.setEmlSndGdt(emlSndGdt[i]);
				if (emlSndFlg1[i] != null)
					model.setEmlSndFlg1(emlSndFlg1[i]);
				if (emlSndFlg3[i] != null)
					model.setEmlSndFlg3(emlSndFlg3[i]);
				if (emlSndFlg2[i] != null)
					model.setEmlSndFlg2(emlSndFlg2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (emlNtcSndRsltCd1[i] != null)
					model.setEmlNtcSndRsltCd1(emlNtcSndRsltCd1[i]);
				if (emlNtcSndRsltCd2[i] != null)
					model.setEmlNtcSndRsltCd2(emlNtcSndRsltCd2[i]);
				if (emlNtcSndRsltCd3[i] != null)
					model.setEmlNtcSndRsltCd3(emlNtcSndRsltCd3[i]);
				if (emlNtcSndRsltCd4[i] != null)
					model.setEmlNtcSndRsltCd4(emlNtcSndRsltCd4[i]);
				if (emlNtcSndRsltCd5[i] != null)
					model.setEmlNtcSndRsltCd5(emlNtcSndRsltCd5[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (ntcTp[i] != null)
					model.setNtcTp(ntcTp[i]);
				if (ntcEml1[i] != null)
					model.setNtcEml1(ntcEml1[i]);
				if (ntcEml2[i] != null)
					model.setNtcEml2(ntcEml2[i]);
				if (ntcEml3[i] != null)
					model.setNtcEml3(ntcEml3[i]);
				if (ntcEml4[i] != null)
					model.setNtcEml4(ntcEml4[i]);
				if (ntcEml5[i] != null)
					model.setNtcEml5(ntcEml5[i]);
				if (emlNtcSndRsltNm4[i] != null)
					model.setEmlNtcSndRsltNm4(emlNtcSndRsltNm4[i]);
				if (emlNtcSndRsltNm5[i] != null)
					model.setEmlNtcSndRsltNm5(emlNtcSndRsltNm5[i]);
				if (emlNtcSndRsltNm1[i] != null)
					model.setEmlNtcSndRsltNm1(emlNtcSndRsltNm1[i]);
				if (emlNtcSndRsltNm2[i] != null)
					model.setEmlNtcSndRsltNm2(emlNtcSndRsltNm2[i]);
				if (emlNtcSndRsltNm3[i] != null)
					model.setEmlNtcSndRsltNm3(emlNtcSndRsltNm3[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (isEval[i] != null)
					model.setIsEval(isEval[i]);
				if (chgDpFlg[i] != null)
					model.setChgDpFlg(chgDpFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcBlCopyMailInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcBlCopyMailInfoVO[]
	 */
	public ArrNtcBlCopyMailInfoVO[] getArrNtcBlCopyMailInfoVOs(){
		ArrNtcBlCopyMailInfoVO[] vos = (ArrNtcBlCopyMailInfoVO[])models.toArray(new ArrNtcBlCopyMailInfoVO[models.size()]);
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
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg5 = this.emlSndFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg4 = this.emlSndFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndGdt = this.emlSndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg1 = this.emlSndFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg3 = this.emlSndFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndFlg2 = this.emlSndFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd1 = this.emlNtcSndRsltCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd2 = this.emlNtcSndRsltCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd3 = this.emlNtcSndRsltCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd4 = this.emlNtcSndRsltCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltCd5 = this.emlNtcSndRsltCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcTp = this.ntcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml1 = this.ntcEml1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml2 = this.ntcEml2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml3 = this.ntcEml3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml4 = this.ntcEml4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml5 = this.ntcEml5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm4 = this.emlNtcSndRsltNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm5 = this.emlNtcSndRsltNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm1 = this.emlNtcSndRsltNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm2 = this.emlNtcSndRsltNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNtcSndRsltNm3 = this.emlNtcSndRsltNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isEval = this.isEval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDpFlg = this.chgDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
