/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TdrRatioVO.java
*@FileTitle : TdrRatioVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.25
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.10.25 김영오 
* 1.0 Creation
* 1. Ticket No  : CHM-201322276 (2012.01.07)
*    개발자 : 이수진
*    Ticket Title : [ALPS JOO] 모델링 표준에 맞게 처리 되도록 테이블 칼럼 변경 작업 및 기능 변경
*    Description  :  JO_REP_CRR_CD_FLG => JO_REP_CRR_FLG으로 컬럼명 변경 작업 
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TdrRatioVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TdrRatioVO> models = new ArrayList<TdrRatioVO>();
	
	/* Column Info */
	private String jo20ftSubTeuQty = null;
	/* Column Info */
	private String slaneCd = null;
	/* Column Info */
	private String jo45ftSubTeuQty = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String jo45ftN1stRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String preFr = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String preTo = null;
	/* Column Info */
	private String jo45ftN2ndRto = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String jo20ftN1stRto = null;
	/* Column Info */
	private String jo40ftSubTeuQty = null;
	/* Column Info */
	private String jo40ftN1stRto = null;
	/* Column Info */
	private String joRepCrrFlg = null;
	/* Column Info */
	private String joRndRuleLvl = null;
	/* Allocation TEU */
	private String joBsaTeuQty = null;
	/*Allocation Weight */
	private String cgoTonWgt = null;
	/* TEU/TON */
	private String joTonTeuQty = null;
	/* Column Info */
	private String orgRlaneCd = null;
	/* Column Info */
	private String orgSkdDirCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TdrRatioVO() {}

	public TdrRatioVO(String ibflag, String pagerows, String jo20ftSubTeuQty, String jo45ftN2ndRto, String jo20ftN1stRto, String jo45ftSubTeuQty, String joCrrCd, String rlaneCd, String jo40ftSubTeuQty, String jo40ftN1stRto, String jo45ftN1stRto, String joRndRuleLvl, String vvd, String slaneCd, String skdDirCd, String preFr, String preTo, String oprCd, String usrId, String creUsrId, String joRepCrrFlg, String joBsaTeuQty, String cgoTonWgt, String joTonTeuQty, String orgRlaneCd, String orgSkdDirCd) {
		this.jo20ftSubTeuQty = jo20ftSubTeuQty;
		this.slaneCd = slaneCd;
		this.jo45ftSubTeuQty = jo45ftSubTeuQty;
		this.joCrrCd = joCrrCd;
		this.rlaneCd = rlaneCd;
		this.skdDirCd = skdDirCd;
		this.jo45ftN1stRto = jo45ftN1stRto;
		this.pagerows = pagerows;
		this.preFr = preFr;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.preTo = preTo;
		this.jo45ftN2ndRto = jo45ftN2ndRto;
		this.usrId = usrId;
		this.oprCd = oprCd;
		this.jo20ftN1stRto = jo20ftN1stRto;
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
		this.jo40ftN1stRto = jo40ftN1stRto;
		this.joRepCrrFlg = joRepCrrFlg;
		this.joRndRuleLvl = joRndRuleLvl;
		this.joBsaTeuQty = joBsaTeuQty;
		this.cgoTonWgt = cgoTonWgt;
		this.joTonTeuQty = joTonTeuQty;		
		this.orgRlaneCd = orgRlaneCd;
		this.orgSkdDirCd = orgSkdDirCd;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("jo_20ft_sub_teu_qty", getJo20ftSubTeuQty());
		this.hashColumns.put("slane_cd", getSlaneCd());
		this.hashColumns.put("jo_45ft_sub_teu_qty", getJo45ftSubTeuQty());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("jo_45ft_n1st_rto", getJo45ftN1stRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_fr", getPreFr());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pre_to", getPreTo());
		this.hashColumns.put("jo_45ft_n2nd_rto", getJo45ftN2ndRto());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("jo_20ft_n1st_rto", getJo20ftN1stRto());
		this.hashColumns.put("jo_40ft_sub_teu_qty", getJo40ftSubTeuQty());
		this.hashColumns.put("jo_40ft_n1st_rto", getJo40ftN1stRto());
		this.hashColumns.put("jo_rep_crr_flg", getJoRepCrrFlg());
		this.hashColumns.put("jo_rnd_rule_lvl", getJoRndRuleLvl());		
		this.hashColumns.put("jo_bsa_teu_qty", getJoBsaTeuQty());
		this.hashColumns.put("cgo_ton_wgt", getCgoTonWgt());
		this.hashColumns.put("jo_ton_teu_qty", getJoTonTeuQty());		
		this.hashColumns.put("org_rlane_cd", getOrgRlaneCd());
		this.hashColumns.put("org_skd_dir_cd", getOrgSkdDirCd());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("jo_20ft_sub_teu_qty", "jo20ftSubTeuQty");
		this.hashFields.put("slane_cd", "slaneCd");
		this.hashFields.put("jo_45ft_sub_teu_qty", "jo45ftSubTeuQty");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("jo_45ft_n1st_rto", "jo45ftN1stRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_fr", "preFr");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pre_to", "preTo");
		this.hashFields.put("jo_45ft_n2nd_rto", "jo45ftN2ndRto");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("jo_20ft_n1st_rto", "jo20ftN1stRto");
		this.hashFields.put("jo_40ft_sub_teu_qty", "jo40ftSubTeuQty");
		this.hashFields.put("jo_40ft_n1st_rto", "jo40ftN1stRto");
		this.hashFields.put("jo_rep_crr_flg", "joRepCrrFlg");
		this.hashFields.put("jo_rnd_rule_lvl", "joRndRuleLvl");
		this.hashFields.put("jo_bsa_teu_qty", "joBsaTeuQty");
		this.hashFields.put("cgo_ton_wgt", "cgoTonWgt");
		this.hashFields.put("jo_ton_teu_qty", "joTonTeuQty");		
		this.hashFields.put("org_rlane_cd", "orgRlaneCd");
		this.hashFields.put("org_skd_dir_cd", "orgSkdDirCd");		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return jo20ftSubTeuQty
	 */
	public String getJo20ftSubTeuQty() {
		return this.jo20ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @return slaneCd
	 */
	public String getSlaneCd() {
		return this.slaneCd;
	}
	
	/**
	 * Column Info
	 * @return jo45ftSubTeuQty
	 */
	public String getJo45ftSubTeuQty() {
		return this.jo45ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return jo45ftN1stRto
	 */
	public String getJo45ftN1stRto() {
		return this.jo45ftN1stRto;
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
	 * @return preFr
	 */
	public String getPreFr() {
		return this.preFr;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return preTo
	 */
	public String getPreTo() {
		return this.preTo;
	}
	
	/**
	 * Column Info
	 * @return jo45ftN2ndRto
	 */
	public String getJo45ftN2ndRto() {
		return this.jo45ftN2ndRto;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return jo20ftN1stRto
	 */
	public String getJo20ftN1stRto() {
		return this.jo20ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @return jo40ftSubTeuQty
	 */
	public String getJo40ftSubTeuQty() {
		return this.jo40ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @return jo40ftN1stRto
	 */
	public String getJo40ftN1stRto() {
		return this.jo40ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @return joRepCrrFlg
	 */
	public String getJoRepCrrFlg() {
		return this.joRepCrrFlg;
	}
	
	/**
	 * Column Info
	 * @return joRndRuleLvl
	 */
	public String getJoRndRuleLvl() {
		return this.joRndRuleLvl;
	}
	
	/**
	 * Column Info
	 * @return joBsaTeuQty
	 */
	public String getJoBsaTeuQty() {
		return this.joBsaTeuQty;
	}

	/**
	 * Column Info
	 * @return cgoTonWgt
	 */
	public String getCgoTonWgt() {
		return this.cgoTonWgt;
	}

	/**
	 * Column Info
	 * @return joTonTeuQty
	 */
	public String getJoTonTeuQty() {
		return this.joTonTeuQty;
	}

	/**
	 * Column Info
	 * @return orgRlaneCd
	 */
	public String getOrgRlaneCd() {
		return this.orgRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return orgSkdDirCd
	 */
	public String getOrgSkdDirCd() {
		return this.orgSkdDirCd;
	}	
	
	/**
	 * Column Info
	 * @param jo20ftSubTeuQty
	 */
	public void setJo20ftSubTeuQty(String jo20ftSubTeuQty) {
		this.jo20ftSubTeuQty = jo20ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @param slaneCd
	 */
	public void setSlaneCd(String slaneCd) {
		this.slaneCd = slaneCd;
	}
	
	/**
	 * Column Info
	 * @param jo45ftSubTeuQty
	 */
	public void setJo45ftSubTeuQty(String jo45ftSubTeuQty) {
		this.jo45ftSubTeuQty = jo45ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param jo45ftN1stRto
	 */
	public void setJo45ftN1stRto(String jo45ftN1stRto) {
		this.jo45ftN1stRto = jo45ftN1stRto;
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
	 * @param preFr
	 */
	public void setPreFr(String preFr) {
		this.preFr = preFr;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param preTo
	 */
	public void setPreTo(String preTo) {
		this.preTo = preTo;
	}
	
	/**
	 * Column Info
	 * @param jo45ftN2ndRto
	 */
	public void setJo45ftN2ndRto(String jo45ftN2ndRto) {
		this.jo45ftN2ndRto = jo45ftN2ndRto;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param jo20ftN1stRto
	 */
	public void setJo20ftN1stRto(String jo20ftN1stRto) {
		this.jo20ftN1stRto = jo20ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @param jo40ftSubTeuQty
	 */
	public void setJo40ftSubTeuQty(String jo40ftSubTeuQty) {
		this.jo40ftSubTeuQty = jo40ftSubTeuQty;
	}
	
	/**
	 * Column Info
	 * @param jo40ftN1stRto
	 */
	public void setJo40ftN1stRto(String jo40ftN1stRto) {
		this.jo40ftN1stRto = jo40ftN1stRto;
	}
	
	/**
	 * Column Info
	 * @param joRepCrrFlg
	 */
	public void setJoRepCrrFlg(String joRepCrrFlg) {
		this.joRepCrrFlg = joRepCrrFlg;
	}
	
	/**
	 * Column Info
	 * @param joRndRuleLvl
	 */
	public void setJoRndRuleLvl(String joRndRuleLvl) {
		this.joRndRuleLvl = joRndRuleLvl;
	}
	
	/**
	 * Column Info
	 * @param joBsaTeuQty
	 */
	public void setJoBsaTeuQty(String joBsaTeuQty) {
		this.joBsaTeuQty = joBsaTeuQty;
	}

	/**
	 * Column Info
	 * @param cgoTonWgt
	 */
	public void setCgoTonWgt(String cgoTonWgt) {
		this.cgoTonWgt = cgoTonWgt;
	}

	/**
	 * Column Info
	 * @param joTonTeuQty
	 */
	public void setJoTonTeuQty(String joTonTeuQty) {
		this.joTonTeuQty = joTonTeuQty;
	}
	
	/**
	 * Column Info
	 * @param orgRlaneCd
	 */
	public void setOrgRlaneCd(String orgRlaneCd) {
		this.orgRlaneCd = orgRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param orgSkdDirCd
	 */
	public void setOrgSkdDirCd(String orgSkdDirCd) {
		this.orgSkdDirCd = orgSkdDirCd;
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
		setJo20ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_20ft_sub_teu_qty", ""));
		setSlaneCd(JSPUtil.getParameter(request, prefix + "slane_cd", ""));
		setJo45ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_45ft_sub_teu_qty", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setJo45ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_45ft_n1st_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPreFr(JSPUtil.getParameter(request, prefix + "pre_fr", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPreTo(JSPUtil.getParameter(request, prefix + "pre_to", ""));
		setJo45ftN2ndRto(JSPUtil.getParameter(request, prefix + "jo_45ft_n2nd_rto", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setJo20ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_20ft_n1st_rto", ""));
		setJo40ftSubTeuQty(JSPUtil.getParameter(request, prefix + "jo_40ft_sub_teu_qty", ""));
		setJo40ftN1stRto(JSPUtil.getParameter(request, prefix + "jo_40ft_n1st_rto", ""));
		setJoRepCrrFlg(JSPUtil.getParameter(request, prefix + "jo_rep_crr_flg", ""));
		setJoRndRuleLvl(JSPUtil.getParameter(request, prefix + "jo_rnd_rule_lvl", ""));
		setJoBsaTeuQty(JSPUtil.getParameter(request, prefix + "jo_bsa_teu_qty", ""));
		setCgoTonWgt(JSPUtil.getParameter(request, prefix + "cgo_ton_wgt", ""));		
		setJoTonTeuQty(JSPUtil.getParameter(request, prefix + "jo_ton_teu_qty", ""));
		setOrgRlaneCd(JSPUtil.getParameter(request, prefix + "org_rlane_cd", ""));
		setOrgSkdDirCd(JSPUtil.getParameter(request, prefix + "org_skd_dir_cd", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrRatioVO[]
	 */
	public TdrRatioVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrRatioVO[]
	 */
	public TdrRatioVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TdrRatioVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] jo20ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_sub_teu_qty", length));
			String[] slaneCd = (JSPUtil.getParameter(request, prefix	+ "slane_cd", length));
			String[] jo45ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_sub_teu_qty", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] jo45ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_n1st_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preFr = (JSPUtil.getParameter(request, prefix	+ "pre_fr", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] preTo = (JSPUtil.getParameter(request, prefix	+ "pre_to", length));
			String[] jo45ftN2ndRto = (JSPUtil.getParameter(request, prefix	+ "jo_45ft_n2nd_rto", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] jo20ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_20ft_n1st_rto", length));
			String[] jo40ftSubTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_sub_teu_qty", length));
			String[] jo40ftN1stRto = (JSPUtil.getParameter(request, prefix	+ "jo_40ft_n1st_rto", length));
			String[] joRepCrrFlg = (JSPUtil.getParameter(request, prefix	+ "jo_rep_crr_flg", length));
			String[] joRndRuleLvl = (JSPUtil.getParameter(request, prefix	+ "jo_rnd_rule_lvl", length));
			String[] joBsaTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_bsa_teu_qty", length));
			String[] cgoTonWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_ton_wgt", length));
			String[] joTonTeuQty = (JSPUtil.getParameter(request, prefix	+ "jo_ton_teu_qty", length));		
			String[] orgRlaneCd = (JSPUtil.getParameter(request, prefix	+ "org_rlane_cd", length));
			String[] orgSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "org_skd_dir_cd", length));			
			
			for (int i = 0; i < length; i++) {
				model = new TdrRatioVO();
				if (jo20ftSubTeuQty[i] != null)
					model.setJo20ftSubTeuQty(jo20ftSubTeuQty[i]);
				if (slaneCd[i] != null)
					model.setSlaneCd(slaneCd[i]);
				if (jo45ftSubTeuQty[i] != null)
					model.setJo45ftSubTeuQty(jo45ftSubTeuQty[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (jo45ftN1stRto[i] != null)
					model.setJo45ftN1stRto(jo45ftN1stRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preFr[i] != null)
					model.setPreFr(preFr[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (preTo[i] != null)
					model.setPreTo(preTo[i]);
				if (jo45ftN2ndRto[i] != null)
					model.setJo45ftN2ndRto(jo45ftN2ndRto[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (jo20ftN1stRto[i] != null)
					model.setJo20ftN1stRto(jo20ftN1stRto[i]);
				if (jo40ftSubTeuQty[i] != null)
					model.setJo40ftSubTeuQty(jo40ftSubTeuQty[i]);
				if (jo40ftN1stRto[i] != null)
					model.setJo40ftN1stRto(jo40ftN1stRto[i]);
				if (joRepCrrFlg[i] != null)
					model.setJoRepCrrFlg(joRepCrrFlg[i]);
				if (joRndRuleLvl[i] != null)
					model.setJoRndRuleLvl(joRndRuleLvl[i]);
				if (joBsaTeuQty[i] != null)
					model.setJoBsaTeuQty(joBsaTeuQty[i]);
				if (cgoTonWgt[i] != null)
					model.setCgoTonWgt(cgoTonWgt[i]);
				if (joTonTeuQty[i] != null)
					model.setJoTonTeuQty(joTonTeuQty[i]);
				if (orgRlaneCd[i] != null)
					model.setOrgRlaneCd(orgRlaneCd[i]);
				if (orgSkdDirCd[i] != null)
					model.setOrgSkdDirCd(orgSkdDirCd[i]);				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTdrRatioVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TdrRatioVO[]
	 */
	public TdrRatioVO[] getTdrRatioVOs(){
		TdrRatioVO[] vos = (TdrRatioVO[])models.toArray(new TdrRatioVO[models.size()]);
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
		this.jo20ftSubTeuQty = this.jo20ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slaneCd = this.slaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftSubTeuQty = this.jo45ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftN1stRto = this.jo45ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preFr = this.preFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTo = this.preTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo45ftN2ndRto = this.jo45ftN2ndRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo20ftN1stRto = this.jo20ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftSubTeuQty = this.jo40ftSubTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jo40ftN1stRto = this.jo40ftN1stRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRepCrrFlg = this.joRepCrrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRndRuleLvl = this.joRndRuleLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsaTeuQty = this.joBsaTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTonWgt = this.cgoTonWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joTonTeuQty = this.joTonTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.orgRlaneCd = this.orgRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSkdDirCd = this.orgSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
