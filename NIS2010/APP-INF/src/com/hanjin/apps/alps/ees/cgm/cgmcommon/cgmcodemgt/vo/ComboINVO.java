/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComboINVO.java
*@FileTitle : ComboINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.11.19 김창식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo;

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
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComboINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComboINVO> models = new ArrayList<ComboINVO>();
	
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String desc9 = null;
	/* Column Info */
	private String desc7 = null;
	/* Column Info */
	private String desc8 = null;
	/* Column Info */
	private String desc5 = null;
	/* Column Info */
	private String desc6 = null;
	/* Column Info */
	private String desc3 = null;
	/* Column Info */
	private String desc4 = null;
	/* Column Info */
	private String desc1 = null;
	/* Column Info */
	private String desc2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String intgCdId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String eqSpecNo = null;
	/* Column Info */
	private String chssMgstInvKndCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String code9 = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String code6 = null;
	/* Column Info */
	private String code5 = null;
	/* Column Info */
	private String code8 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String code7 = null;
	/* Column Info */
	private String code2 = null;
	/* Column Info */
	private String code1 = null;
	/* Column Info */
	private String code4 = null;
	/* Column Info */
	private String code3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComboINVO() {}

	public ComboINVO(String ibflag, String pagerows, String code1, String code2, String code3, String code4, String code5, String code6, String code7, String code8, String code9, String desc1, String desc2, String desc3, String desc4, String desc5, String desc6, String desc7, String desc8, String desc9, String vndrSeq, String intgCdId, String agmtOfcCtyCd, String agmtSeq, String agmtLstmCd, String chssPoolCd, String eqKndCd, String sccCd, String eqSpecNo, String ofcCd, String chssMgstInvKndCd, String costYrmon) {
		this.chssPoolCd = chssPoolCd;
		this.desc9 = desc9;
		this.desc7 = desc7;
		this.desc8 = desc8;
		this.desc5 = desc5;
		this.desc6 = desc6;
		this.desc3 = desc3;
		this.desc4 = desc4;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.pagerows = pagerows;
		this.intgCdId = intgCdId;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.eqSpecNo = eqSpecNo;
		this.chssMgstInvKndCd = chssMgstInvKndCd;
		this.agmtSeq = agmtSeq;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.ofcCd = ofcCd;
		this.code9 = code9;
		this.sccCd = sccCd;
		this.code6 = code6;
		this.code5 = code5;
		this.code8 = code8;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.code7 = code7;
		this.code2 = code2;
		this.code1 = code1;
		this.code4 = code4;
		this.code3 = code3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("desc9", getDesc9());
		this.hashColumns.put("desc7", getDesc7());
		this.hashColumns.put("desc8", getDesc8());
		this.hashColumns.put("desc5", getDesc5());
		this.hashColumns.put("desc6", getDesc6());
		this.hashColumns.put("desc3", getDesc3());
		this.hashColumns.put("desc4", getDesc4());
		this.hashColumns.put("desc1", getDesc1());
		this.hashColumns.put("desc2", getDesc2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("intg_cd_id", getIntgCdId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("eq_spec_no", getEqSpecNo());
		this.hashColumns.put("chss_mgst_inv_knd_cd", getChssMgstInvKndCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("code9", getCode9());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("code6", getCode6());
		this.hashColumns.put("code5", getCode5());
		this.hashColumns.put("code8", getCode8());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("code7", getCode7());
		this.hashColumns.put("code2", getCode2());
		this.hashColumns.put("code1", getCode1());
		this.hashColumns.put("code4", getCode4());
		this.hashColumns.put("code3", getCode3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("desc9", "desc9");
		this.hashFields.put("desc7", "desc7");
		this.hashFields.put("desc8", "desc8");
		this.hashFields.put("desc5", "desc5");
		this.hashFields.put("desc6", "desc6");
		this.hashFields.put("desc3", "desc3");
		this.hashFields.put("desc4", "desc4");
		this.hashFields.put("desc1", "desc1");
		this.hashFields.put("desc2", "desc2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("intg_cd_id", "intgCdId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("eq_spec_no", "eqSpecNo");
		this.hashFields.put("chss_mgst_inv_knd_cd", "chssMgstInvKndCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("code9", "code9");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("code6", "code6");
		this.hashFields.put("code5", "code5");
		this.hashFields.put("code8", "code8");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("code7", "code7");
		this.hashFields.put("code2", "code2");
		this.hashFields.put("code1", "code1");
		this.hashFields.put("code4", "code4");
		this.hashFields.put("code3", "code3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return desc9
	 */
	public String getDesc9() {
		return this.desc9;
	}
	
	/**
	 * Column Info
	 * @return desc7
	 */
	public String getDesc7() {
		return this.desc7;
	}
	
	/**
	 * Column Info
	 * @return desc8
	 */
	public String getDesc8() {
		return this.desc8;
	}
	
	/**
	 * Column Info
	 * @return desc5
	 */
	public String getDesc5() {
		return this.desc5;
	}
	
	/**
	 * Column Info
	 * @return desc6
	 */
	public String getDesc6() {
		return this.desc6;
	}
	
	/**
	 * Column Info
	 * @return desc3
	 */
	public String getDesc3() {
		return this.desc3;
	}
	
	/**
	 * Column Info
	 * @return desc4
	 */
	public String getDesc4() {
		return this.desc4;
	}
	
	/**
	 * Column Info
	 * @return desc1
	 */
	public String getDesc1() {
		return this.desc1;
	}
	
	/**
	 * Column Info
	 * @return desc2
	 */
	public String getDesc2() {
		return this.desc2;
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
	 * @return intgCdId
	 */
	public String getIntgCdId() {
		return this.intgCdId;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return eqSpecNo
	 */
	public String getEqSpecNo() {
		return this.eqSpecNo;
	}
	
	/**
	 * Column Info
	 * @return chssMgstInvKndCd
	 */
	public String getChssMgstInvKndCd() {
		return this.chssMgstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return code9
	 */
	public String getCode9() {
		return this.code9;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return code6
	 */
	public String getCode6() {
		return this.code6;
	}
	
	/**
	 * Column Info
	 * @return code5
	 */
	public String getCode5() {
		return this.code5;
	}
	
	/**
	 * Column Info
	 * @return code8
	 */
	public String getCode8() {
		return this.code8;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return code7
	 */
	public String getCode7() {
		return this.code7;
	}
	
	/**
	 * Column Info
	 * @return code2
	 */
	public String getCode2() {
		return this.code2;
	}
	
	/**
	 * Column Info
	 * @return code1
	 */
	public String getCode1() {
		return this.code1;
	}
	
	/**
	 * Column Info
	 * @return code4
	 */
	public String getCode4() {
		return this.code4;
	}
	
	/**
	 * Column Info
	 * @return code3
	 */
	public String getCode3() {
		return this.code3;
	}
	

	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param desc9
	 */
	public void setDesc9(String desc9) {
		this.desc9 = desc9;
	}
	
	/**
	 * Column Info
	 * @param desc7
	 */
	public void setDesc7(String desc7) {
		this.desc7 = desc7;
	}
	
	/**
	 * Column Info
	 * @param desc8
	 */
	public void setDesc8(String desc8) {
		this.desc8 = desc8;
	}
	
	/**
	 * Column Info
	 * @param desc5
	 */
	public void setDesc5(String desc5) {
		this.desc5 = desc5;
	}
	
	/**
	 * Column Info
	 * @param desc6
	 */
	public void setDesc6(String desc6) {
		this.desc6 = desc6;
	}
	
	/**
	 * Column Info
	 * @param desc3
	 */
	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}
	
	/**
	 * Column Info
	 * @param desc4
	 */
	public void setDesc4(String desc4) {
		this.desc4 = desc4;
	}
	
	/**
	 * Column Info
	 * @param desc1
	 */
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	
	/**
	 * Column Info
	 * @param desc2
	 */
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
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
	 * @param intgCdId
	 */
	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param eqSpecNo
	 */
	public void setEqSpecNo(String eqSpecNo) {
		this.eqSpecNo = eqSpecNo;
	}
	
	/**
	 * Column Info
	 * @param chssMgstInvKndCd
	 */
	public void setChssMgstInvKndCd(String chssMgstInvKndCd) {
		this.chssMgstInvKndCd = chssMgstInvKndCd;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param code9
	 */
	public void setCode9(String code9) {
		this.code9 = code9;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param code6
	 */
	public void setCode6(String code6) {
		this.code6 = code6;
	}
	
	/**
	 * Column Info
	 * @param code5
	 */
	public void setCode5(String code5) {
		this.code5 = code5;
	}
	
	/**
	 * Column Info
	 * @param code8
	 */
	public void setCode8(String code8) {
		this.code8 = code8;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param code7
	 */
	public void setCode7(String code7) {
		this.code7 = code7;
	}
	
	/**
	 * Column Info
	 * @param code2
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	/**
	 * Column Info
	 * @param code1
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	
	/**
	 * Column Info
	 * @param code4
	 */
	public void setCode4(String code4) {
		this.code4 = code4;
	}
	
	/**
	 * Column Info
	 * @param code3
	 */
	public void setCode3(String code3) {
		this.code3 = code3;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setDesc9(JSPUtil.getParameter(request, "desc9", ""));
		setDesc7(JSPUtil.getParameter(request, "desc7", ""));
		setDesc8(JSPUtil.getParameter(request, "desc8", ""));
		setDesc5(JSPUtil.getParameter(request, "desc5", ""));
		setDesc6(JSPUtil.getParameter(request, "desc6", ""));
		setDesc3(JSPUtil.getParameter(request, "desc3", ""));
		setDesc4(JSPUtil.getParameter(request, "desc4", ""));
		setDesc1(JSPUtil.getParameter(request, "desc1", ""));
		setDesc2(JSPUtil.getParameter(request, "desc2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIntgCdId(JSPUtil.getParameter(request, "intg_cd_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setEqSpecNo(JSPUtil.getParameter(request, "eq_spec_no", ""));
		setChssMgstInvKndCd(JSPUtil.getParameter(request, "chss_mgst_inv_knd_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCode9(JSPUtil.getParameter(request, "code9", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setCode6(JSPUtil.getParameter(request, "code6", ""));
		setCode5(JSPUtil.getParameter(request, "code5", ""));
		setCode8(JSPUtil.getParameter(request, "code8", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setCode7(JSPUtil.getParameter(request, "code7", ""));
		setCode2(JSPUtil.getParameter(request, "code2", ""));
		setCode1(JSPUtil.getParameter(request, "code1", ""));
		setCode4(JSPUtil.getParameter(request, "code4", ""));
		setCode3(JSPUtil.getParameter(request, "code3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComboINVO[]
	 */
	public ComboINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComboINVO[]
	 */
	public ComboINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComboINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] desc9 = (JSPUtil.getParameter(request, prefix	+ "desc9", length));
			String[] desc7 = (JSPUtil.getParameter(request, prefix	+ "desc7", length));
			String[] desc8 = (JSPUtil.getParameter(request, prefix	+ "desc8", length));
			String[] desc5 = (JSPUtil.getParameter(request, prefix	+ "desc5", length));
			String[] desc6 = (JSPUtil.getParameter(request, prefix	+ "desc6", length));
			String[] desc3 = (JSPUtil.getParameter(request, prefix	+ "desc3", length));
			String[] desc4 = (JSPUtil.getParameter(request, prefix	+ "desc4", length));
			String[] desc1 = (JSPUtil.getParameter(request, prefix	+ "desc1", length));
			String[] desc2 = (JSPUtil.getParameter(request, prefix	+ "desc2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] intgCdId = (JSPUtil.getParameter(request, prefix	+ "intg_cd_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] eqSpecNo = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no", length));
			String[] chssMgstInvKndCd = (JSPUtil.getParameter(request, prefix	+ "chss_mgst_inv_knd_cd", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] code9 = (JSPUtil.getParameter(request, prefix	+ "code9", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] code6 = (JSPUtil.getParameter(request, prefix	+ "code6", length));
			String[] code5 = (JSPUtil.getParameter(request, prefix	+ "code5", length));
			String[] code8 = (JSPUtil.getParameter(request, prefix	+ "code8", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] code7 = (JSPUtil.getParameter(request, prefix	+ "code7", length));
			String[] code2 = (JSPUtil.getParameter(request, prefix	+ "code2", length));
			String[] code1 = (JSPUtil.getParameter(request, prefix	+ "code1", length));
			String[] code4 = (JSPUtil.getParameter(request, prefix	+ "code4", length));
			String[] code3 = (JSPUtil.getParameter(request, prefix	+ "code3", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComboINVO();
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (desc9[i] != null)
					model.setDesc9(desc9[i]);
				if (desc7[i] != null)
					model.setDesc7(desc7[i]);
				if (desc8[i] != null)
					model.setDesc8(desc8[i]);
				if (desc5[i] != null)
					model.setDesc5(desc5[i]);
				if (desc6[i] != null)
					model.setDesc6(desc6[i]);
				if (desc3[i] != null)
					model.setDesc3(desc3[i]);
				if (desc4[i] != null)
					model.setDesc4(desc4[i]);
				if (desc1[i] != null)
					model.setDesc1(desc1[i]);
				if (desc2[i] != null)
					model.setDesc2(desc2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (intgCdId[i] != null)
					model.setIntgCdId(intgCdId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (eqSpecNo[i] != null)
					model.setEqSpecNo(eqSpecNo[i]);
				if (chssMgstInvKndCd[i] != null)
					model.setChssMgstInvKndCd(chssMgstInvKndCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (code9[i] != null)
					model.setCode9(code9[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (code6[i] != null)
					model.setCode6(code6[i]);
				if (code5[i] != null)
					model.setCode5(code5[i]);
				if (code8[i] != null)
					model.setCode8(code8[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (code7[i] != null)
					model.setCode7(code7[i]);
				if (code2[i] != null)
					model.setCode2(code2[i]);
				if (code1[i] != null)
					model.setCode1(code1[i]);
				if (code4[i] != null)
					model.setCode4(code4[i]);
				if (code3[i] != null)
					model.setCode3(code3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComboINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComboINVO[]
	 */
	public ComboINVO[] getComboINVOs(){
		ComboINVO[] vos = (ComboINVO[])models.toArray(new ComboINVO[models.size()]);
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
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc9 = this.desc9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc7 = this.desc7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc8 = this.desc8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc5 = this.desc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc6 = this.desc6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc3 = this.desc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc4 = this.desc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc1 = this.desc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.desc2 = this.desc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdId = this.intgCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNo = this.eqSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssMgstInvKndCd = this.chssMgstInvKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code9 = this.code9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code6 = this.code6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code5 = this.code5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code8 = this.code8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code7 = this.code7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code2 = this.code2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code1 = this.code1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code4 = this.code4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code3 = this.code3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
