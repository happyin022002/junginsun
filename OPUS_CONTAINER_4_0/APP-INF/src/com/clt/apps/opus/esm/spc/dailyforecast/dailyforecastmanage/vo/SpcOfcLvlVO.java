/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpcOfcLvlVO.java
*@FileTitle : SpcOfcLvlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.04.25 이은섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo;

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
 * @author 이은섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcOfcLvlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcOfcLvlVO> models = new ArrayList<SpcOfcLvlVO>();
	
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String n7thPrntOfcCd = null;
	/* Column Info */
	private String intgCdValDpDesc = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String ofcLvl = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String n1stPrntOfcCd = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String n6thPrntOfcCd = null;
	/* Column Info */
	private String saqRgnOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String spcSlsOfcCd = null;
	/* Column Info */
	private String n4thPrntOfcCd = null;
	/* Column Info */
	private String n3rdPrntOfcCd = null;
	/* Column Info */
	private String n2ndPrntOfcCd = null;
	/* Column Info */
	private String n5thPrntOfcCd = null;
	/* Column Info */
	private String ofcSlsDeltFlg = null;
	/* Column Info */
	private String ofcAplyFmYrwk = null;
	/* Column Info */
	private String ofcLoclNm = null;
	/* Column Info */
	private String ofcAplyToYrwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcOfcLvlVO() {}

	public SpcOfcLvlVO(String ibflag, String pagerows, String ofcCd, String ofcAplyFmYrwk, String ofcAplyToYrwk, String ofcTpCd, String ofcEngNm, String ofcLoclNm, String prntOfcCd, String ofcKndCd, String deltFlg, String ofcSlsDeltFlg, String ofcLvl, String n1stPrntOfcCd, String n2ndPrntOfcCd, String n3rdPrntOfcCd, String n4thPrntOfcCd, String n5thPrntOfcCd, String n6thPrntOfcCd, String n7thPrntOfcCd, String saqRgnOfcCd, String spcSlsOfcCd, String intgCdValDpDesc) {
		this.ofcKndCd = ofcKndCd;
		this.n7thPrntOfcCd = n7thPrntOfcCd;
		this.intgCdValDpDesc = intgCdValDpDesc;
		this.deltFlg = deltFlg;
		this.ofcLvl = ofcLvl;
		this.ofcEngNm = ofcEngNm;
		this.n1stPrntOfcCd = n1stPrntOfcCd;
		this.ofcTpCd = ofcTpCd;
		this.n6thPrntOfcCd = n6thPrntOfcCd;
		this.saqRgnOfcCd = saqRgnOfcCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.prntOfcCd = prntOfcCd;
		this.spcSlsOfcCd = spcSlsOfcCd;
		this.n4thPrntOfcCd = n4thPrntOfcCd;
		this.n3rdPrntOfcCd = n3rdPrntOfcCd;
		this.n2ndPrntOfcCd = n2ndPrntOfcCd;
		this.n5thPrntOfcCd = n5thPrntOfcCd;
		this.ofcSlsDeltFlg = ofcSlsDeltFlg;
		this.ofcAplyFmYrwk = ofcAplyFmYrwk;
		this.ofcLoclNm = ofcLoclNm;
		this.ofcAplyToYrwk = ofcAplyToYrwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
		this.hashColumns.put("n7th_prnt_ofc_cd", getN7thPrntOfcCd());
		this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ofc_lvl", getOfcLvl());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("n1st_prnt_ofc_cd", getN1stPrntOfcCd());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("n6th_prnt_ofc_cd", getN6thPrntOfcCd());
		this.hashColumns.put("saq_rgn_ofc_cd", getSaqRgnOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("spc_sls_ofc_cd", getSpcSlsOfcCd());
		this.hashColumns.put("n4th_prnt_ofc_cd", getN4thPrntOfcCd());
		this.hashColumns.put("n3rd_prnt_ofc_cd", getN3rdPrntOfcCd());
		this.hashColumns.put("n2nd_prnt_ofc_cd", getN2ndPrntOfcCd());
		this.hashColumns.put("n5th_prnt_ofc_cd", getN5thPrntOfcCd());
		this.hashColumns.put("ofc_sls_delt_flg", getOfcSlsDeltFlg());
		this.hashColumns.put("ofc_aply_fm_yrwk", getOfcAplyFmYrwk());
		this.hashColumns.put("ofc_locl_nm", getOfcLoclNm());
		this.hashColumns.put("ofc_aply_to_yrwk", getOfcAplyToYrwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_knd_cd", "ofcKndCd");
		this.hashFields.put("n7th_prnt_ofc_cd", "n7thPrntOfcCd");
		this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ofc_lvl", "ofcLvl");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("n1st_prnt_ofc_cd", "n1stPrntOfcCd");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("n6th_prnt_ofc_cd", "n6thPrntOfcCd");
		this.hashFields.put("saq_rgn_ofc_cd", "saqRgnOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("spc_sls_ofc_cd", "spcSlsOfcCd");
		this.hashFields.put("n4th_prnt_ofc_cd", "n4thPrntOfcCd");
		this.hashFields.put("n3rd_prnt_ofc_cd", "n3rdPrntOfcCd");
		this.hashFields.put("n2nd_prnt_ofc_cd", "n2ndPrntOfcCd");
		this.hashFields.put("n5th_prnt_ofc_cd", "n5thPrntOfcCd");
		this.hashFields.put("ofc_sls_delt_flg", "ofcSlsDeltFlg");
		this.hashFields.put("ofc_aply_fm_yrwk", "ofcAplyFmYrwk");
		this.hashFields.put("ofc_locl_nm", "ofcLoclNm");
		this.hashFields.put("ofc_aply_to_yrwk", "ofcAplyToYrwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcKndCd
	 */
	public String getOfcKndCd() {
		return this.ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @return n7thPrntOfcCd
	 */
	public String getN7thPrntOfcCd() {
		return this.n7thPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpDesc
	 */
	public String getIntgCdValDpDesc() {
		return this.intgCdValDpDesc;
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
	 * @return ofcLvl
	 */
	public String getOfcLvl() {
		return this.ofcLvl;
	}
	
	/**
	 * Column Info
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return n1stPrntOfcCd
	 */
	public String getN1stPrntOfcCd() {
		return this.n1stPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return n6thPrntOfcCd
	 */
	public String getN6thPrntOfcCd() {
		return this.n6thPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return saqRgnOfcCd
	 */
	public String getSaqRgnOfcCd() {
		return this.saqRgnOfcCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spcSlsOfcCd
	 */
	public String getSpcSlsOfcCd() {
		return this.spcSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPrntOfcCd
	 */
	public String getN4thPrntOfcCd() {
		return this.n4thPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPrntOfcCd
	 */
	public String getN3rdPrntOfcCd() {
		return this.n3rdPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPrntOfcCd
	 */
	public String getN2ndPrntOfcCd() {
		return this.n2ndPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n5thPrntOfcCd
	 */
	public String getN5thPrntOfcCd() {
		return this.n5thPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcSlsDeltFlg
	 */
	public String getOfcSlsDeltFlg() {
		return this.ofcSlsDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcAplyFmYrwk
	 */
	public String getOfcAplyFmYrwk() {
		return this.ofcAplyFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return ofcLoclNm
	 */
	public String getOfcLoclNm() {
		return this.ofcLoclNm;
	}
	
	/**
	 * Column Info
	 * @return ofcAplyToYrwk
	 */
	public String getOfcAplyToYrwk() {
		return this.ofcAplyToYrwk;
	}
	

	/**
	 * Column Info
	 * @param ofcKndCd
	 */
	public void setOfcKndCd(String ofcKndCd) {
		this.ofcKndCd = ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @param n7thPrntOfcCd
	 */
	public void setN7thPrntOfcCd(String n7thPrntOfcCd) {
		this.n7thPrntOfcCd = n7thPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpDesc
	 */
	public void setIntgCdValDpDesc(String intgCdValDpDesc) {
		this.intgCdValDpDesc = intgCdValDpDesc;
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
	 * @param ofcLvl
	 */
	public void setOfcLvl(String ofcLvl) {
		this.ofcLvl = ofcLvl;
	}
	
	/**
	 * Column Info
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param n1stPrntOfcCd
	 */
	public void setN1stPrntOfcCd(String n1stPrntOfcCd) {
		this.n1stPrntOfcCd = n1stPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param n6thPrntOfcCd
	 */
	public void setN6thPrntOfcCd(String n6thPrntOfcCd) {
		this.n6thPrntOfcCd = n6thPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param saqRgnOfcCd
	 */
	public void setSaqRgnOfcCd(String saqRgnOfcCd) {
		this.saqRgnOfcCd = saqRgnOfcCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spcSlsOfcCd
	 */
	public void setSpcSlsOfcCd(String spcSlsOfcCd) {
		this.spcSlsOfcCd = spcSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPrntOfcCd
	 */
	public void setN4thPrntOfcCd(String n4thPrntOfcCd) {
		this.n4thPrntOfcCd = n4thPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPrntOfcCd
	 */
	public void setN3rdPrntOfcCd(String n3rdPrntOfcCd) {
		this.n3rdPrntOfcCd = n3rdPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPrntOfcCd
	 */
	public void setN2ndPrntOfcCd(String n2ndPrntOfcCd) {
		this.n2ndPrntOfcCd = n2ndPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n5thPrntOfcCd
	 */
	public void setN5thPrntOfcCd(String n5thPrntOfcCd) {
		this.n5thPrntOfcCd = n5thPrntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcSlsDeltFlg
	 */
	public void setOfcSlsDeltFlg(String ofcSlsDeltFlg) {
		this.ofcSlsDeltFlg = ofcSlsDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcAplyFmYrwk
	 */
	public void setOfcAplyFmYrwk(String ofcAplyFmYrwk) {
		this.ofcAplyFmYrwk = ofcAplyFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param ofcLoclNm
	 */
	public void setOfcLoclNm(String ofcLoclNm) {
		this.ofcLoclNm = ofcLoclNm;
	}
	
	/**
	 * Column Info
	 * @param ofcAplyToYrwk
	 */
	public void setOfcAplyToYrwk(String ofcAplyToYrwk) {
		this.ofcAplyToYrwk = ofcAplyToYrwk;
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
		setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
		setN7thPrntOfcCd(JSPUtil.getParameter(request, prefix + "n7th_prnt_ofc_cd", ""));
		setIntgCdValDpDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setOfcLvl(JSPUtil.getParameter(request, prefix + "ofc_lvl", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setN1stPrntOfcCd(JSPUtil.getParameter(request, prefix + "n1st_prnt_ofc_cd", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setN6thPrntOfcCd(JSPUtil.getParameter(request, prefix + "n6th_prnt_ofc_cd", ""));
		setSaqRgnOfcCd(JSPUtil.getParameter(request, prefix + "saq_rgn_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
		setSpcSlsOfcCd(JSPUtil.getParameter(request, prefix + "spc_sls_ofc_cd", ""));
		setN4thPrntOfcCd(JSPUtil.getParameter(request, prefix + "n4th_prnt_ofc_cd", ""));
		setN3rdPrntOfcCd(JSPUtil.getParameter(request, prefix + "n3rd_prnt_ofc_cd", ""));
		setN2ndPrntOfcCd(JSPUtil.getParameter(request, prefix + "n2nd_prnt_ofc_cd", ""));
		setN5thPrntOfcCd(JSPUtil.getParameter(request, prefix + "n5th_prnt_ofc_cd", ""));
		setOfcSlsDeltFlg(JSPUtil.getParameter(request, prefix + "ofc_sls_delt_flg", ""));
		setOfcAplyFmYrwk(JSPUtil.getParameter(request, prefix + "ofc_aply_fm_yrwk", ""));
		setOfcLoclNm(JSPUtil.getParameter(request, prefix + "ofc_locl_nm", ""));
		setOfcAplyToYrwk(JSPUtil.getParameter(request, prefix + "ofc_aply_to_yrwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcOfcLvlVO[]
	 */
	public SpcOfcLvlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcOfcLvlVO[]
	 */
	public SpcOfcLvlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcOfcLvlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcKndCd = (JSPUtil.getParameter(request, prefix	+ "ofc_knd_cd", length));
			String[] n7thPrntOfcCd = (JSPUtil.getParameter(request, prefix	+ "n7th_prnt_ofc_cd", length));
			String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_desc", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] ofcLvl = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] n1stPrntOfcCd = (JSPUtil.getParameter(request, prefix	+ "n1st_prnt_ofc_cd", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] n6thPrntOfcCd = (JSPUtil.getParameter(request, prefix	+ "n6th_prnt_ofc_cd", length));
			String[] saqRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "saq_rgn_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd", length));
			String[] spcSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "spc_sls_ofc_cd", length));
			String[] n4thPrntOfcCd = (JSPUtil.getParameter(request, prefix	+ "n4th_prnt_ofc_cd", length));
			String[] n3rdPrntOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_prnt_ofc_cd", length));
			String[] n2ndPrntOfcCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_prnt_ofc_cd", length));
			String[] n5thPrntOfcCd = (JSPUtil.getParameter(request, prefix	+ "n5th_prnt_ofc_cd", length));
			String[] ofcSlsDeltFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_sls_delt_flg", length));
			String[] ofcAplyFmYrwk = (JSPUtil.getParameter(request, prefix	+ "ofc_aply_fm_yrwk", length));
			String[] ofcLoclNm = (JSPUtil.getParameter(request, prefix	+ "ofc_locl_nm", length));
			String[] ofcAplyToYrwk = (JSPUtil.getParameter(request, prefix	+ "ofc_aply_to_yrwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcOfcLvlVO();
				if (ofcKndCd[i] != null)
					model.setOfcKndCd(ofcKndCd[i]);
				if (n7thPrntOfcCd[i] != null)
					model.setN7thPrntOfcCd(n7thPrntOfcCd[i]);
				if (intgCdValDpDesc[i] != null)
					model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (ofcLvl[i] != null)
					model.setOfcLvl(ofcLvl[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (n1stPrntOfcCd[i] != null)
					model.setN1stPrntOfcCd(n1stPrntOfcCd[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (n6thPrntOfcCd[i] != null)
					model.setN6thPrntOfcCd(n6thPrntOfcCd[i]);
				if (saqRgnOfcCd[i] != null)
					model.setSaqRgnOfcCd(saqRgnOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (spcSlsOfcCd[i] != null)
					model.setSpcSlsOfcCd(spcSlsOfcCd[i]);
				if (n4thPrntOfcCd[i] != null)
					model.setN4thPrntOfcCd(n4thPrntOfcCd[i]);
				if (n3rdPrntOfcCd[i] != null)
					model.setN3rdPrntOfcCd(n3rdPrntOfcCd[i]);
				if (n2ndPrntOfcCd[i] != null)
					model.setN2ndPrntOfcCd(n2ndPrntOfcCd[i]);
				if (n5thPrntOfcCd[i] != null)
					model.setN5thPrntOfcCd(n5thPrntOfcCd[i]);
				if (ofcSlsDeltFlg[i] != null)
					model.setOfcSlsDeltFlg(ofcSlsDeltFlg[i]);
				if (ofcAplyFmYrwk[i] != null)
					model.setOfcAplyFmYrwk(ofcAplyFmYrwk[i]);
				if (ofcLoclNm[i] != null)
					model.setOfcLoclNm(ofcLoclNm[i]);
				if (ofcAplyToYrwk[i] != null)
					model.setOfcAplyToYrwk(ofcAplyToYrwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcOfcLvlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpcOfcLvlVO[]
	 */
	public SpcOfcLvlVO[] getSpcOfcLvlVOs(){
		SpcOfcLvlVO[] vos = (SpcOfcLvlVO[])models.toArray(new SpcOfcLvlVO[models.size()]);
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
		this.ofcKndCd = this.ofcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n7thPrntOfcCd = this.n7thPrntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpDesc = this.intgCdValDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl = this.ofcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPrntOfcCd = this.n1stPrntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thPrntOfcCd = this.n6thPrntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saqRgnOfcCd = this.saqRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spcSlsOfcCd = this.spcSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPrntOfcCd = this.n4thPrntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPrntOfcCd = this.n3rdPrntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPrntOfcCd = this.n2ndPrntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thPrntOfcCd = this.n5thPrntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcSlsDeltFlg = this.ofcSlsDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAplyFmYrwk = this.ofcAplyFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLoclNm = this.ofcLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAplyToYrwk = this.ofcAplyToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
