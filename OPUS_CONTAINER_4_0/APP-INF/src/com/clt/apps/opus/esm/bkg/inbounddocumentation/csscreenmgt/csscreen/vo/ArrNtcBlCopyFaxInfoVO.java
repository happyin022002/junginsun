/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ArrNtcBlCopyFaxInfoVO.java
*@FileTitle : ArrNtcBlCopyFaxInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.06  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArrNtcBlCopyFaxInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArrNtcBlCopyFaxInfoVO> models = new ArrayList<ArrNtcBlCopyFaxInfoVO>();
	
	/* Column Info */
	private String faxNo1 = null;
	/* Column Info */
	private String faxNtcSndRsltNm2 = null;
	/* Column Info */
	private String faxNtcSndRsltNm1 = null;
	/* Column Info */
	private String faxNtcSndRsltNm3 = null;
	/* Column Info */
	private String faxSndGdt = null;
	/* Column Info */
	private String faxNo5 = null;
	/* Column Info */
	private String faxNo4 = null;
	/* Column Info */
	private String faxNtcSndRsltNm5 = null;
	/* Column Info */
	private String faxNo3 = null;
	/* Column Info */
	private String faxNo2 = null;
	/* Column Info */
	private String faxSndFlg3 = null;
	/* Column Info */
	private String fxNtcSndRsltNm4 = null;
	/* Column Info */
	private String faxSndFlg4 = null;
	/* Column Info */
	private String faxSndFlg1 = null;
	/* Column Info */
	private String faxSndFlg2 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String ntcTp = null;
	/* Column Info */
	private String faxNtcSndRsltCd3 = null;
	/* Column Info */
	private String faxNtcSndRsltCd4 = null;
	/* Column Info */
	private String faxNtcSndRsltCd5 = null;
	/* Column Info */
	private String faxNtcSndRsltCd2 = null;
	/* Column Info */
	private String faxNtcSndRsltCd1 = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String faxSndFlg5 = null;
	/* Column Info */
	private String isEval = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String chgDpFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArrNtcBlCopyFaxInfoVO() {}

	public ArrNtcBlCopyFaxInfoVO(String ibflag, String pagerows, String ntcTp, String chgDpFlg, String bkgCustTpCd, String faxNo1, String faxNo2, String faxNo3, String faxNo4, String faxNo5, String faxSndFlg1, String faxSndFlg2, String faxSndFlg3, String faxSndFlg4, String faxSndFlg5, String faxNtcSndRsltCd1, String faxNtcSndRsltNm1, String faxNtcSndRsltCd2, String faxNtcSndRsltNm2, String faxNtcSndRsltCd3, String faxNtcSndRsltNm3, String faxNtcSndRsltCd4, String fxNtcSndRsltNm4, String faxNtcSndRsltCd5, String faxNtcSndRsltNm5, String faxSndDt, String faxSndGdt, String diffRmk, String isEval) {
		this.faxNo1 = faxNo1;
		this.faxNtcSndRsltNm2 = faxNtcSndRsltNm2;
		this.faxNtcSndRsltNm1 = faxNtcSndRsltNm1;
		this.faxNtcSndRsltNm3 = faxNtcSndRsltNm3;
		this.faxSndGdt = faxSndGdt;
		this.faxNo5 = faxNo5;
		this.faxNo4 = faxNo4;
		this.faxNtcSndRsltNm5 = faxNtcSndRsltNm5;
		this.faxNo3 = faxNo3;
		this.faxNo2 = faxNo2;
		this.faxSndFlg3 = faxSndFlg3;
		this.fxNtcSndRsltNm4 = fxNtcSndRsltNm4;
		this.faxSndFlg4 = faxSndFlg4;
		this.faxSndFlg1 = faxSndFlg1;
		this.faxSndFlg2 = faxSndFlg2;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgCustTpCd = bkgCustTpCd;
		this.ntcTp = ntcTp;
		this.faxNtcSndRsltCd3 = faxNtcSndRsltCd3;
		this.faxNtcSndRsltCd4 = faxNtcSndRsltCd4;
		this.faxNtcSndRsltCd5 = faxNtcSndRsltCd5;
		this.faxNtcSndRsltCd2 = faxNtcSndRsltCd2;
		this.faxNtcSndRsltCd1 = faxNtcSndRsltCd1;
		this.diffRmk = diffRmk;
		this.faxSndFlg5 = faxSndFlg5;
		this.isEval = isEval;
		this.faxSndDt = faxSndDt;
		this.chgDpFlg = chgDpFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fax_no1", getFaxNo1());
		this.hashColumns.put("fax_ntc_snd_rslt_nm2", getFaxNtcSndRsltNm2());
		this.hashColumns.put("fax_ntc_snd_rslt_nm1", getFaxNtcSndRsltNm1());
		this.hashColumns.put("fax_ntc_snd_rslt_nm3", getFaxNtcSndRsltNm3());
		this.hashColumns.put("fax_snd_gdt", getFaxSndGdt());
		this.hashColumns.put("fax_no5", getFaxNo5());
		this.hashColumns.put("fax_no4", getFaxNo4());
		this.hashColumns.put("fax_ntc_snd_rslt_nm5", getFaxNtcSndRsltNm5());
		this.hashColumns.put("fax_no3", getFaxNo3());
		this.hashColumns.put("fax_no2", getFaxNo2());
		this.hashColumns.put("fax_snd_flg3", getFaxSndFlg3());
		this.hashColumns.put("fx_ntc_snd_rslt_nm4", getFxNtcSndRsltNm4());
		this.hashColumns.put("fax_snd_flg4", getFaxSndFlg4());
		this.hashColumns.put("fax_snd_flg1", getFaxSndFlg1());
		this.hashColumns.put("fax_snd_flg2", getFaxSndFlg2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("ntc_tp", getNtcTp());
		this.hashColumns.put("fax_ntc_snd_rslt_cd3", getFaxNtcSndRsltCd3());
		this.hashColumns.put("fax_ntc_snd_rslt_cd4", getFaxNtcSndRsltCd4());
		this.hashColumns.put("fax_ntc_snd_rslt_cd5", getFaxNtcSndRsltCd5());
		this.hashColumns.put("fax_ntc_snd_rslt_cd2", getFaxNtcSndRsltCd2());
		this.hashColumns.put("fax_ntc_snd_rslt_cd1", getFaxNtcSndRsltCd1());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("fax_snd_flg5", getFaxSndFlg5());
		this.hashColumns.put("is_eval", getIsEval());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("chg_dp_flg", getChgDpFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fax_no1", "faxNo1");
		this.hashFields.put("fax_ntc_snd_rslt_nm2", "faxNtcSndRsltNm2");
		this.hashFields.put("fax_ntc_snd_rslt_nm1", "faxNtcSndRsltNm1");
		this.hashFields.put("fax_ntc_snd_rslt_nm3", "faxNtcSndRsltNm3");
		this.hashFields.put("fax_snd_gdt", "faxSndGdt");
		this.hashFields.put("fax_no5", "faxNo5");
		this.hashFields.put("fax_no4", "faxNo4");
		this.hashFields.put("fax_ntc_snd_rslt_nm5", "faxNtcSndRsltNm5");
		this.hashFields.put("fax_no3", "faxNo3");
		this.hashFields.put("fax_no2", "faxNo2");
		this.hashFields.put("fax_snd_flg3", "faxSndFlg3");
		this.hashFields.put("fx_ntc_snd_rslt_nm4", "fxNtcSndRsltNm4");
		this.hashFields.put("fax_snd_flg4", "faxSndFlg4");
		this.hashFields.put("fax_snd_flg1", "faxSndFlg1");
		this.hashFields.put("fax_snd_flg2", "faxSndFlg2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("ntc_tp", "ntcTp");
		this.hashFields.put("fax_ntc_snd_rslt_cd3", "faxNtcSndRsltCd3");
		this.hashFields.put("fax_ntc_snd_rslt_cd4", "faxNtcSndRsltCd4");
		this.hashFields.put("fax_ntc_snd_rslt_cd5", "faxNtcSndRsltCd5");
		this.hashFields.put("fax_ntc_snd_rslt_cd2", "faxNtcSndRsltCd2");
		this.hashFields.put("fax_ntc_snd_rslt_cd1", "faxNtcSndRsltCd1");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("fax_snd_flg5", "faxSndFlg5");
		this.hashFields.put("is_eval", "isEval");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("chg_dp_flg", "chgDpFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return faxNo1
	 */
	public String getFaxNo1() {
		return this.faxNo1;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltNm2
	 */
	public String getFaxNtcSndRsltNm2() {
		return this.faxNtcSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltNm1
	 */
	public String getFaxNtcSndRsltNm1() {
		return this.faxNtcSndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltNm3
	 */
	public String getFaxNtcSndRsltNm3() {
		return this.faxNtcSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @return faxSndGdt
	 */
	public String getFaxSndGdt() {
		return this.faxSndGdt;
	}
	
	/**
	 * Column Info
	 * @return faxNo5
	 */
	public String getFaxNo5() {
		return this.faxNo5;
	}
	
	/**
	 * Column Info
	 * @return faxNo4
	 */
	public String getFaxNo4() {
		return this.faxNo4;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltNm5
	 */
	public String getFaxNtcSndRsltNm5() {
		return this.faxNtcSndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @return faxNo3
	 */
	public String getFaxNo3() {
		return this.faxNo3;
	}
	
	/**
	 * Column Info
	 * @return faxNo2
	 */
	public String getFaxNo2() {
		return this.faxNo2;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg3
	 */
	public String getFaxSndFlg3() {
		return this.faxSndFlg3;
	}
	
	/**
	 * Column Info
	 * @return fxNtcSndRsltNm4
	 */
	public String getFxNtcSndRsltNm4() {
		return this.fxNtcSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg4
	 */
	public String getFaxSndFlg4() {
		return this.faxSndFlg4;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg1
	 */
	public String getFaxSndFlg1() {
		return this.faxSndFlg1;
	}
	
	/**
	 * Column Info
	 * @return faxSndFlg2
	 */
	public String getFaxSndFlg2() {
		return this.faxSndFlg2;
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
	 * @return faxNtcSndRsltCd3
	 */
	public String getFaxNtcSndRsltCd3() {
		return this.faxNtcSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd4
	 */
	public String getFaxNtcSndRsltCd4() {
		return this.faxNtcSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd5
	 */
	public String getFaxNtcSndRsltCd5() {
		return this.faxNtcSndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd2
	 */
	public String getFaxNtcSndRsltCd2() {
		return this.faxNtcSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @return faxNtcSndRsltCd1
	 */
	public String getFaxNtcSndRsltCd1() {
		return this.faxNtcSndRsltCd1;
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
	 * @return faxSndFlg5
	 */
	public String getFaxSndFlg5() {
		return this.faxSndFlg5;
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
	 * @return faxSndDt
	 */
	public String getFaxSndDt() {
		return this.faxSndDt;
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
	 * @param faxNo1
	 */
	public void setFaxNo1(String faxNo1) {
		this.faxNo1 = faxNo1;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltNm2
	 */
	public void setFaxNtcSndRsltNm2(String faxNtcSndRsltNm2) {
		this.faxNtcSndRsltNm2 = faxNtcSndRsltNm2;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltNm1
	 */
	public void setFaxNtcSndRsltNm1(String faxNtcSndRsltNm1) {
		this.faxNtcSndRsltNm1 = faxNtcSndRsltNm1;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltNm3
	 */
	public void setFaxNtcSndRsltNm3(String faxNtcSndRsltNm3) {
		this.faxNtcSndRsltNm3 = faxNtcSndRsltNm3;
	}
	
	/**
	 * Column Info
	 * @param faxSndGdt
	 */
	public void setFaxSndGdt(String faxSndGdt) {
		this.faxSndGdt = faxSndGdt;
	}
	
	/**
	 * Column Info
	 * @param faxNo5
	 */
	public void setFaxNo5(String faxNo5) {
		this.faxNo5 = faxNo5;
	}
	
	/**
	 * Column Info
	 * @param faxNo4
	 */
	public void setFaxNo4(String faxNo4) {
		this.faxNo4 = faxNo4;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltNm5
	 */
	public void setFaxNtcSndRsltNm5(String faxNtcSndRsltNm5) {
		this.faxNtcSndRsltNm5 = faxNtcSndRsltNm5;
	}
	
	/**
	 * Column Info
	 * @param faxNo3
	 */
	public void setFaxNo3(String faxNo3) {
		this.faxNo3 = faxNo3;
	}
	
	/**
	 * Column Info
	 * @param faxNo2
	 */
	public void setFaxNo2(String faxNo2) {
		this.faxNo2 = faxNo2;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg3
	 */
	public void setFaxSndFlg3(String faxSndFlg3) {
		this.faxSndFlg3 = faxSndFlg3;
	}
	
	/**
	 * Column Info
	 * @param fxNtcSndRsltNm4
	 */
	public void setFxNtcSndRsltNm4(String fxNtcSndRsltNm4) {
		this.fxNtcSndRsltNm4 = fxNtcSndRsltNm4;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg4
	 */
	public void setFaxSndFlg4(String faxSndFlg4) {
		this.faxSndFlg4 = faxSndFlg4;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg1
	 */
	public void setFaxSndFlg1(String faxSndFlg1) {
		this.faxSndFlg1 = faxSndFlg1;
	}
	
	/**
	 * Column Info
	 * @param faxSndFlg2
	 */
	public void setFaxSndFlg2(String faxSndFlg2) {
		this.faxSndFlg2 = faxSndFlg2;
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
	 * @param faxNtcSndRsltCd3
	 */
	public void setFaxNtcSndRsltCd3(String faxNtcSndRsltCd3) {
		this.faxNtcSndRsltCd3 = faxNtcSndRsltCd3;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd4
	 */
	public void setFaxNtcSndRsltCd4(String faxNtcSndRsltCd4) {
		this.faxNtcSndRsltCd4 = faxNtcSndRsltCd4;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd5
	 */
	public void setFaxNtcSndRsltCd5(String faxNtcSndRsltCd5) {
		this.faxNtcSndRsltCd5 = faxNtcSndRsltCd5;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd2
	 */
	public void setFaxNtcSndRsltCd2(String faxNtcSndRsltCd2) {
		this.faxNtcSndRsltCd2 = faxNtcSndRsltCd2;
	}
	
	/**
	 * Column Info
	 * @param faxNtcSndRsltCd1
	 */
	public void setFaxNtcSndRsltCd1(String faxNtcSndRsltCd1) {
		this.faxNtcSndRsltCd1 = faxNtcSndRsltCd1;
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
	 * @param faxSndFlg5
	 */
	public void setFaxSndFlg5(String faxSndFlg5) {
		this.faxSndFlg5 = faxSndFlg5;
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
	 * @param faxSndDt
	 */
	public void setFaxSndDt(String faxSndDt) {
		this.faxSndDt = faxSndDt;
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
		setFaxNo1(JSPUtil.getParameter(request, "fax_no1", ""));
		setFaxNtcSndRsltNm2(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_nm2", ""));
		setFaxNtcSndRsltNm1(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_nm1", ""));
		setFaxNtcSndRsltNm3(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_nm3", ""));
		setFaxSndGdt(JSPUtil.getParameter(request, "fax_snd_gdt", ""));
		setFaxNo5(JSPUtil.getParameter(request, "fax_no5", ""));
		setFaxNo4(JSPUtil.getParameter(request, "fax_no4", ""));
		setFaxNtcSndRsltNm5(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_nm5", ""));
		setFaxNo3(JSPUtil.getParameter(request, "fax_no3", ""));
		setFaxNo2(JSPUtil.getParameter(request, "fax_no2", ""));
		setFaxSndFlg3(JSPUtil.getParameter(request, "fax_snd_flg3", ""));
		setFxNtcSndRsltNm4(JSPUtil.getParameter(request, "fx_ntc_snd_rslt_nm4", ""));
		setFaxSndFlg4(JSPUtil.getParameter(request, "fax_snd_flg4", ""));
		setFaxSndFlg1(JSPUtil.getParameter(request, "fax_snd_flg1", ""));
		setFaxSndFlg2(JSPUtil.getParameter(request, "fax_snd_flg2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setNtcTp(JSPUtil.getParameter(request, "ntc_tp", ""));
		setFaxNtcSndRsltCd3(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_cd3", ""));
		setFaxNtcSndRsltCd4(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_cd4", ""));
		setFaxNtcSndRsltCd5(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_cd5", ""));
		setFaxNtcSndRsltCd2(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_cd2", ""));
		setFaxNtcSndRsltCd1(JSPUtil.getParameter(request, "fax_ntc_snd_rslt_cd1", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setFaxSndFlg5(JSPUtil.getParameter(request, "fax_snd_flg5", ""));
		setIsEval(JSPUtil.getParameter(request, "is_eval", ""));
		setFaxSndDt(JSPUtil.getParameter(request, "fax_snd_dt", ""));
		setChgDpFlg(JSPUtil.getParameter(request, "chg_dp_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArrNtcBlCopyFaxInfoVO[]
	 */
	public ArrNtcBlCopyFaxInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArrNtcBlCopyFaxInfoVO[]
	 */
	public ArrNtcBlCopyFaxInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArrNtcBlCopyFaxInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] faxNo1 = (JSPUtil.getParameter(request, prefix	+ "fax_no1", length));
			String[] faxNtcSndRsltNm2 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm2", length));
			String[] faxNtcSndRsltNm1 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm1", length));
			String[] faxNtcSndRsltNm3 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm3", length));
			String[] faxSndGdt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_gdt", length));
			String[] faxNo5 = (JSPUtil.getParameter(request, prefix	+ "fax_no5", length));
			String[] faxNo4 = (JSPUtil.getParameter(request, prefix	+ "fax_no4", length));
			String[] faxNtcSndRsltNm5 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_nm5", length));
			String[] faxNo3 = (JSPUtil.getParameter(request, prefix	+ "fax_no3", length));
			String[] faxNo2 = (JSPUtil.getParameter(request, prefix	+ "fax_no2", length));
			String[] faxSndFlg3 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg3", length));
			String[] fxNtcSndRsltNm4 = (JSPUtil.getParameter(request, prefix	+ "fx_ntc_snd_rslt_nm4", length));
			String[] faxSndFlg4 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg4", length));
			String[] faxSndFlg1 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg1", length));
			String[] faxSndFlg2 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] ntcTp = (JSPUtil.getParameter(request, prefix	+ "ntc_tp", length));
			String[] faxNtcSndRsltCd3 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd3", length));
			String[] faxNtcSndRsltCd4 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd4", length));
			String[] faxNtcSndRsltCd5 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd5", length));
			String[] faxNtcSndRsltCd2 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd2", length));
			String[] faxNtcSndRsltCd1 = (JSPUtil.getParameter(request, prefix	+ "fax_ntc_snd_rslt_cd1", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] faxSndFlg5 = (JSPUtil.getParameter(request, prefix	+ "fax_snd_flg5", length));
			String[] isEval = (JSPUtil.getParameter(request, prefix	+ "is_eval", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] chgDpFlg = (JSPUtil.getParameter(request, prefix	+ "chg_dp_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArrNtcBlCopyFaxInfoVO();
				if (faxNo1[i] != null)
					model.setFaxNo1(faxNo1[i]);
				if (faxNtcSndRsltNm2[i] != null)
					model.setFaxNtcSndRsltNm2(faxNtcSndRsltNm2[i]);
				if (faxNtcSndRsltNm1[i] != null)
					model.setFaxNtcSndRsltNm1(faxNtcSndRsltNm1[i]);
				if (faxNtcSndRsltNm3[i] != null)
					model.setFaxNtcSndRsltNm3(faxNtcSndRsltNm3[i]);
				if (faxSndGdt[i] != null)
					model.setFaxSndGdt(faxSndGdt[i]);
				if (faxNo5[i] != null)
					model.setFaxNo5(faxNo5[i]);
				if (faxNo4[i] != null)
					model.setFaxNo4(faxNo4[i]);
				if (faxNtcSndRsltNm5[i] != null)
					model.setFaxNtcSndRsltNm5(faxNtcSndRsltNm5[i]);
				if (faxNo3[i] != null)
					model.setFaxNo3(faxNo3[i]);
				if (faxNo2[i] != null)
					model.setFaxNo2(faxNo2[i]);
				if (faxSndFlg3[i] != null)
					model.setFaxSndFlg3(faxSndFlg3[i]);
				if (fxNtcSndRsltNm4[i] != null)
					model.setFxNtcSndRsltNm4(fxNtcSndRsltNm4[i]);
				if (faxSndFlg4[i] != null)
					model.setFaxSndFlg4(faxSndFlg4[i]);
				if (faxSndFlg1[i] != null)
					model.setFaxSndFlg1(faxSndFlg1[i]);
				if (faxSndFlg2[i] != null)
					model.setFaxSndFlg2(faxSndFlg2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (ntcTp[i] != null)
					model.setNtcTp(ntcTp[i]);
				if (faxNtcSndRsltCd3[i] != null)
					model.setFaxNtcSndRsltCd3(faxNtcSndRsltCd3[i]);
				if (faxNtcSndRsltCd4[i] != null)
					model.setFaxNtcSndRsltCd4(faxNtcSndRsltCd4[i]);
				if (faxNtcSndRsltCd5[i] != null)
					model.setFaxNtcSndRsltCd5(faxNtcSndRsltCd5[i]);
				if (faxNtcSndRsltCd2[i] != null)
					model.setFaxNtcSndRsltCd2(faxNtcSndRsltCd2[i]);
				if (faxNtcSndRsltCd1[i] != null)
					model.setFaxNtcSndRsltCd1(faxNtcSndRsltCd1[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (faxSndFlg5[i] != null)
					model.setFaxSndFlg5(faxSndFlg5[i]);
				if (isEval[i] != null)
					model.setIsEval(isEval[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (chgDpFlg[i] != null)
					model.setChgDpFlg(chgDpFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArrNtcBlCopyFaxInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArrNtcBlCopyFaxInfoVO[]
	 */
	public ArrNtcBlCopyFaxInfoVO[] getArrNtcBlCopyFaxInfoVOs(){
		ArrNtcBlCopyFaxInfoVO[] vos = (ArrNtcBlCopyFaxInfoVO[])models.toArray(new ArrNtcBlCopyFaxInfoVO[models.size()]);
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
		this.faxNo1 = this.faxNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm2 = this.faxNtcSndRsltNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm1 = this.faxNtcSndRsltNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm3 = this.faxNtcSndRsltNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndGdt = this.faxSndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo5 = this.faxNo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo4 = this.faxNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltNm5 = this.faxNtcSndRsltNm5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo3 = this.faxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo2 = this.faxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg3 = this.faxSndFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxNtcSndRsltNm4 = this.fxNtcSndRsltNm4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg4 = this.faxSndFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg1 = this.faxSndFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg2 = this.faxSndFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcTp = this.ntcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd3 = this.faxNtcSndRsltCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd4 = this.faxNtcSndRsltCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd5 = this.faxNtcSndRsltCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd2 = this.faxNtcSndRsltCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNtcSndRsltCd1 = this.faxNtcSndRsltCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndFlg5 = this.faxSndFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isEval = this.isEval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDpFlg = this.chgDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
