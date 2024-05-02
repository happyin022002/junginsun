/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchStandardHireBaseListVO.java
*@FileTitle : SearchStandardHireBaseListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.23 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchStandardHireBaseListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchStandardHireBaseListVO> models = new ArrayList<SearchStandardHireBaseListVO>();
	
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String hbYrmon = null;
	/* Column Info */
	private String stnd14tonHirAmt = null;
	/* Column Info */
	private String bse14tonVslTtlQty = null;
	/* Column Info */
	private String stndMaxHirAmt1 = null;
	/* Column Info */
	private String saveType = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hirRtTtlAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String maxTeuRtAmt = null;
	/* Column Info */
	private String mktRtAplyFlg = null;
	/* Column Info */
	private String vslKrnNm = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String hirRtN2ndAmt = null;
	/* Column Info */
	private String stndMaxHirAmt = null;
	/* Column Info */
	private String teu14tonRtAmt = null;
	/* Column Info */
	private String diffStndMaxHirAmt = null;
	/* Column Info */
	private String hirRtN1stAmt = null;
	/* Column Info */
	private String mktRtAplyFlg1 = null;
	/* Column Info */
	private String stnd14tonHirAmt1 = null;
	/* Column Info */
	private String diffStndMaxHirAmt1 = null;
	/* Column Info */
	private String diffStnd14tonHirAmt = null;
	/* Column Info */
	private String bse14tonVslCapa = null;
	/* Column Info */
	private String diffStnd14tonHirAmt1 = null;
	/* Column Info */
	private String mktRtAmt = null;
	/* Column Info */
	private String vslDzndTtlQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchStandardHireBaseListVO() {}

	public SearchStandardHireBaseListVO(String ibflag, String pagerows, String mktRtAmt, String bse14tonVslTtlQty, String mktRtAplyFlg1, String teu14tonRtAmt, String hirRtN2ndAmt, String maxTeuRtAmt, String vslCntCd, String diffStndMaxHirAmt, String fletCtrtTpCd, String vslCd, String vslKrnNm, String hirRtTtlAmt, String saveType, String stndMaxHirAmt1, String stnd14tonHirAmt, String vslDzndTtlQty, String hirRtN1stAmt, String stnd14tonHirAmt1, String stndMaxHirAmt, String diffStnd14tonHirAmt, String bse14tonVslCapa, String hbYrmon, String vslDzndCapa, String mktRtAplyFlg, String fletCtrtNo, String vslEngNm, String diffStndMaxHirAmt1, String diffStnd14tonHirAmt1) {
		this.vslDzndCapa = vslDzndCapa;
		this.vslCd = vslCd;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.hbYrmon = hbYrmon;
		this.stnd14tonHirAmt = stnd14tonHirAmt;
		this.bse14tonVslTtlQty = bse14tonVslTtlQty;
		this.stndMaxHirAmt1 = stndMaxHirAmt1;
		this.saveType = saveType;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
		this.hirRtTtlAmt = hirRtTtlAmt;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.maxTeuRtAmt = maxTeuRtAmt;
		this.mktRtAplyFlg = mktRtAplyFlg;
		this.vslKrnNm = vslKrnNm;
		this.vslCntCd = vslCntCd;
		this.hirRtN2ndAmt = hirRtN2ndAmt;
		this.stndMaxHirAmt = stndMaxHirAmt;
		this.teu14tonRtAmt = teu14tonRtAmt;
		this.diffStndMaxHirAmt = diffStndMaxHirAmt;
		this.hirRtN1stAmt = hirRtN1stAmt;
		this.mktRtAplyFlg1 = mktRtAplyFlg1;
		this.stnd14tonHirAmt1 = stnd14tonHirAmt1;
		this.diffStndMaxHirAmt1 = diffStndMaxHirAmt1;
		this.diffStnd14tonHirAmt = diffStnd14tonHirAmt;
		this.bse14tonVslCapa = bse14tonVslCapa;
		this.diffStnd14tonHirAmt1 = diffStnd14tonHirAmt1;
		this.mktRtAmt = mktRtAmt;
		this.vslDzndTtlQty = vslDzndTtlQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("hb_yrmon", getHbYrmon());
		this.hashColumns.put("stnd_14ton_hir_amt", getStnd14tonHirAmt());
		this.hashColumns.put("bse_14ton_vsl_ttl_qty", getBse14tonVslTtlQty());
		this.hashColumns.put("stnd_max_hir_amt1", getStndMaxHirAmt1());
		this.hashColumns.put("save_type", getSaveType());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hir_rt_ttl_amt", getHirRtTtlAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("max_teu_rt_amt", getMaxTeuRtAmt());
		this.hashColumns.put("mkt_rt_aply_flg", getMktRtAplyFlg());
		this.hashColumns.put("vsl_krn_nm", getVslKrnNm());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("hir_rt_n2nd_amt", getHirRtN2ndAmt());
		this.hashColumns.put("stnd_max_hir_amt", getStndMaxHirAmt());
		this.hashColumns.put("teu_14ton_rt_amt", getTeu14tonRtAmt());
		this.hashColumns.put("diff_stnd_max_hir_amt", getDiffStndMaxHirAmt());
		this.hashColumns.put("hir_rt_n1st_amt", getHirRtN1stAmt());
		this.hashColumns.put("mkt_rt_aply_flg1", getMktRtAplyFlg1());
		this.hashColumns.put("stnd_14ton_hir_amt1", getStnd14tonHirAmt1());
		this.hashColumns.put("diff_stnd_max_hir_amt1", getDiffStndMaxHirAmt1());
		this.hashColumns.put("diff_stnd_14ton_hir_amt", getDiffStnd14tonHirAmt());
		this.hashColumns.put("bse_14ton_vsl_capa", getBse14tonVslCapa());
		this.hashColumns.put("diff_stnd_14ton_hir_amt1", getDiffStnd14tonHirAmt1());
		this.hashColumns.put("mkt_rt_amt", getMktRtAmt());
		this.hashColumns.put("vsl_dznd_ttl_qty", getVslDzndTtlQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("hb_yrmon", "hbYrmon");
		this.hashFields.put("stnd_14ton_hir_amt", "stnd14tonHirAmt");
		this.hashFields.put("bse_14ton_vsl_ttl_qty", "bse14tonVslTtlQty");
		this.hashFields.put("stnd_max_hir_amt1", "stndMaxHirAmt1");
		this.hashFields.put("save_type", "saveType");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hir_rt_ttl_amt", "hirRtTtlAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("max_teu_rt_amt", "maxTeuRtAmt");
		this.hashFields.put("mkt_rt_aply_flg", "mktRtAplyFlg");
		this.hashFields.put("vsl_krn_nm", "vslKrnNm");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("hir_rt_n2nd_amt", "hirRtN2ndAmt");
		this.hashFields.put("stnd_max_hir_amt", "stndMaxHirAmt");
		this.hashFields.put("teu_14ton_rt_amt", "teu14tonRtAmt");
		this.hashFields.put("diff_stnd_max_hir_amt", "diffStndMaxHirAmt");
		this.hashFields.put("hir_rt_n1st_amt", "hirRtN1stAmt");
		this.hashFields.put("mkt_rt_aply_flg1", "mktRtAplyFlg1");
		this.hashFields.put("stnd_14ton_hir_amt1", "stnd14tonHirAmt1");
		this.hashFields.put("diff_stnd_max_hir_amt1", "diffStndMaxHirAmt1");
		this.hashFields.put("diff_stnd_14ton_hir_amt", "diffStnd14tonHirAmt");
		this.hashFields.put("bse_14ton_vsl_capa", "bse14tonVslCapa");
		this.hashFields.put("diff_stnd_14ton_hir_amt1", "diffStnd14tonHirAmt1");
		this.hashFields.put("mkt_rt_amt", "mktRtAmt");
		this.hashFields.put("vsl_dznd_ttl_qty", "vslDzndTtlQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDzndCapa
	 */
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtTpCd
	 */
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return hbYrmon
	 */
	public String getHbYrmon() {
		return this.hbYrmon;
	}
	
	/**
	 * Column Info
	 * @return stnd14tonHirAmt
	 */
	public String getStnd14tonHirAmt() {
		return this.stnd14tonHirAmt;
	}
	
	/**
	 * Column Info
	 * @return bse14tonVslTtlQty
	 */
	public String getBse14tonVslTtlQty() {
		return this.bse14tonVslTtlQty;
	}
	
	/**
	 * Column Info
	 * @return stndMaxHirAmt1
	 */
	public String getStndMaxHirAmt1() {
		return this.stndMaxHirAmt1;
	}
	
	/**
	 * Column Info
	 * @return saveType
	 */
	public String getSaveType() {
		return this.saveType;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return hirRtTtlAmt
	 */
	public String getHirRtTtlAmt() {
		return this.hirRtTtlAmt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return maxTeuRtAmt
	 */
	public String getMaxTeuRtAmt() {
		return this.maxTeuRtAmt;
	}
	
	/**
	 * Column Info
	 * @return mktRtAplyFlg
	 */
	public String getMktRtAplyFlg() {
		return this.mktRtAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return vslKrnNm
	 */
	public String getVslKrnNm() {
		return this.vslKrnNm;
	}
	
	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return hirRtN2ndAmt
	 */
	public String getHirRtN2ndAmt() {
		return this.hirRtN2ndAmt;
	}
	
	/**
	 * Column Info
	 * @return stndMaxHirAmt
	 */
	public String getStndMaxHirAmt() {
		return this.stndMaxHirAmt;
	}
	
	/**
	 * Column Info
	 * @return teu14tonRtAmt
	 */
	public String getTeu14tonRtAmt() {
		return this.teu14tonRtAmt;
	}
	
	/**
	 * Column Info
	 * @return diffStndMaxHirAmt
	 */
	public String getDiffStndMaxHirAmt() {
		return this.diffStndMaxHirAmt;
	}
	
	/**
	 * Column Info
	 * @return hirRtN1stAmt
	 */
	public String getHirRtN1stAmt() {
		return this.hirRtN1stAmt;
	}
	
	/**
	 * Column Info
	 * @return mktRtAplyFlg1
	 */
	public String getMktRtAplyFlg1() {
		return this.mktRtAplyFlg1;
	}
	
	/**
	 * Column Info
	 * @return stnd14tonHirAmt1
	 */
	public String getStnd14tonHirAmt1() {
		return this.stnd14tonHirAmt1;
	}
	
	/**
	 * Column Info
	 * @return diffStndMaxHirAmt1
	 */
	public String getDiffStndMaxHirAmt1() {
		return this.diffStndMaxHirAmt1;
	}
	
	/**
	 * Column Info
	 * @return diffStnd14tonHirAmt
	 */
	public String getDiffStnd14tonHirAmt() {
		return this.diffStnd14tonHirAmt;
	}
	
	/**
	 * Column Info
	 * @return bse14tonVslCapa
	 */
	public String getBse14tonVslCapa() {
		return this.bse14tonVslCapa;
	}
	
	/**
	 * Column Info
	 * @return diffStnd14tonHirAmt1
	 */
	public String getDiffStnd14tonHirAmt1() {
		return this.diffStnd14tonHirAmt1;
	}
	
	/**
	 * Column Info
	 * @return mktRtAmt
	 */
	public String getMktRtAmt() {
		return this.mktRtAmt;
	}
	
	/**
	 * Column Info
	 * @return vslDzndTtlQty
	 */
	public String getVslDzndTtlQty() {
		return this.vslDzndTtlQty;
	}
	

	/**
	 * Column Info
	 * @param vslDzndCapa
	 */
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtTpCd
	 */
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param hbYrmon
	 */
	public void setHbYrmon(String hbYrmon) {
		this.hbYrmon = hbYrmon;
	}
	
	/**
	 * Column Info
	 * @param stnd14tonHirAmt
	 */
	public void setStnd14tonHirAmt(String stnd14tonHirAmt) {
		this.stnd14tonHirAmt = stnd14tonHirAmt;
	}
	
	/**
	 * Column Info
	 * @param bse14tonVslTtlQty
	 */
	public void setBse14tonVslTtlQty(String bse14tonVslTtlQty) {
		this.bse14tonVslTtlQty = bse14tonVslTtlQty;
	}
	
	/**
	 * Column Info
	 * @param stndMaxHirAmt1
	 */
	public void setStndMaxHirAmt1(String stndMaxHirAmt1) {
		this.stndMaxHirAmt1 = stndMaxHirAmt1;
	}
	
	/**
	 * Column Info
	 * @param saveType
	 */
	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param hirRtTtlAmt
	 */
	public void setHirRtTtlAmt(String hirRtTtlAmt) {
		this.hirRtTtlAmt = hirRtTtlAmt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param maxTeuRtAmt
	 */
	public void setMaxTeuRtAmt(String maxTeuRtAmt) {
		this.maxTeuRtAmt = maxTeuRtAmt;
	}
	
	/**
	 * Column Info
	 * @param mktRtAplyFlg
	 */
	public void setMktRtAplyFlg(String mktRtAplyFlg) {
		this.mktRtAplyFlg = mktRtAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param vslKrnNm
	 */
	public void setVslKrnNm(String vslKrnNm) {
		this.vslKrnNm = vslKrnNm;
	}
	
	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param hirRtN2ndAmt
	 */
	public void setHirRtN2ndAmt(String hirRtN2ndAmt) {
		this.hirRtN2ndAmt = hirRtN2ndAmt;
	}
	
	/**
	 * Column Info
	 * @param stndMaxHirAmt
	 */
	public void setStndMaxHirAmt(String stndMaxHirAmt) {
		this.stndMaxHirAmt = stndMaxHirAmt;
	}
	
	/**
	 * Column Info
	 * @param teu14tonRtAmt
	 */
	public void setTeu14tonRtAmt(String teu14tonRtAmt) {
		this.teu14tonRtAmt = teu14tonRtAmt;
	}
	
	/**
	 * Column Info
	 * @param diffStndMaxHirAmt
	 */
	public void setDiffStndMaxHirAmt(String diffStndMaxHirAmt) {
		this.diffStndMaxHirAmt = diffStndMaxHirAmt;
	}
	
	/**
	 * Column Info
	 * @param hirRtN1stAmt
	 */
	public void setHirRtN1stAmt(String hirRtN1stAmt) {
		this.hirRtN1stAmt = hirRtN1stAmt;
	}
	
	/**
	 * Column Info
	 * @param mktRtAplyFlg1
	 */
	public void setMktRtAplyFlg1(String mktRtAplyFlg1) {
		this.mktRtAplyFlg1 = mktRtAplyFlg1;
	}
	
	/**
	 * Column Info
	 * @param stnd14tonHirAmt1
	 */
	public void setStnd14tonHirAmt1(String stnd14tonHirAmt1) {
		this.stnd14tonHirAmt1 = stnd14tonHirAmt1;
	}
	
	/**
	 * Column Info
	 * @param diffStndMaxHirAmt1
	 */
	public void setDiffStndMaxHirAmt1(String diffStndMaxHirAmt1) {
		this.diffStndMaxHirAmt1 = diffStndMaxHirAmt1;
	}
	
	/**
	 * Column Info
	 * @param diffStnd14tonHirAmt
	 */
	public void setDiffStnd14tonHirAmt(String diffStnd14tonHirAmt) {
		this.diffStnd14tonHirAmt = diffStnd14tonHirAmt;
	}
	
	/**
	 * Column Info
	 * @param bse14tonVslCapa
	 */
	public void setBse14tonVslCapa(String bse14tonVslCapa) {
		this.bse14tonVslCapa = bse14tonVslCapa;
	}
	
	/**
	 * Column Info
	 * @param diffStnd14tonHirAmt1
	 */
	public void setDiffStnd14tonHirAmt1(String diffStnd14tonHirAmt1) {
		this.diffStnd14tonHirAmt1 = diffStnd14tonHirAmt1;
	}
	
	/**
	 * Column Info
	 * @param mktRtAmt
	 */
	public void setMktRtAmt(String mktRtAmt) {
		this.mktRtAmt = mktRtAmt;
	}
	
	/**
	 * Column Info
	 * @param vslDzndTtlQty
	 */
	public void setVslDzndTtlQty(String vslDzndTtlQty) {
		this.vslDzndTtlQty = vslDzndTtlQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setHbYrmon(JSPUtil.getParameter(request, "hb_yrmon", ""));
		setStnd14tonHirAmt(JSPUtil.getParameter(request, "stnd_14ton_hir_amt", ""));
		setBse14tonVslTtlQty(JSPUtil.getParameter(request, "bse_14ton_vsl_ttl_qty", ""));
		setStndMaxHirAmt1(JSPUtil.getParameter(request, "stnd_max_hir_amt1", ""));
		setSaveType(JSPUtil.getParameter(request, "save_type", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHirRtTtlAmt(JSPUtil.getParameter(request, "hir_rt_ttl_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setMaxTeuRtAmt(JSPUtil.getParameter(request, "max_teu_rt_amt", ""));
		setMktRtAplyFlg(JSPUtil.getParameter(request, "mkt_rt_aply_flg", ""));
		setVslKrnNm(JSPUtil.getParameter(request, "vsl_krn_nm", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setHirRtN2ndAmt(JSPUtil.getParameter(request, "hir_rt_n2nd_amt", ""));
		setStndMaxHirAmt(JSPUtil.getParameter(request, "stnd_max_hir_amt", ""));
		setTeu14tonRtAmt(JSPUtil.getParameter(request, "teu_14ton_rt_amt", ""));
		setDiffStndMaxHirAmt(JSPUtil.getParameter(request, "diff_stnd_max_hir_amt", ""));
		setHirRtN1stAmt(JSPUtil.getParameter(request, "hir_rt_n1st_amt", ""));
		setMktRtAplyFlg1(JSPUtil.getParameter(request, "mkt_rt_aply_flg1", ""));
		setStnd14tonHirAmt1(JSPUtil.getParameter(request, "stnd_14ton_hir_amt1", ""));
		setDiffStndMaxHirAmt1(JSPUtil.getParameter(request, "diff_stnd_max_hir_amt1", ""));
		setDiffStnd14tonHirAmt(JSPUtil.getParameter(request, "diff_stnd_14ton_hir_amt", ""));
		setBse14tonVslCapa(JSPUtil.getParameter(request, "bse_14ton_vsl_capa", ""));
		setDiffStnd14tonHirAmt1(JSPUtil.getParameter(request, "diff_stnd_14ton_hir_amt1", ""));
		setMktRtAmt(JSPUtil.getParameter(request, "mkt_rt_amt", ""));
		setVslDzndTtlQty(JSPUtil.getParameter(request, "vsl_dznd_ttl_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStandardHireBaseListVO[]
	 */
	public SearchStandardHireBaseListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStandardHireBaseListVO[]
	 */
	public SearchStandardHireBaseListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchStandardHireBaseListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd", length));
			String[] hbYrmon = (JSPUtil.getParameter(request, prefix	+ "hb_yrmon", length));
			String[] stnd14tonHirAmt = (JSPUtil.getParameter(request, prefix	+ "stnd_14ton_hir_amt", length));
			String[] bse14tonVslTtlQty = (JSPUtil.getParameter(request, prefix	+ "bse_14ton_vsl_ttl_qty", length));
			String[] stndMaxHirAmt1 = (JSPUtil.getParameter(request, prefix	+ "stnd_max_hir_amt1", length));
			String[] saveType = (JSPUtil.getParameter(request, prefix	+ "save_type", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hirRtTtlAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_ttl_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] maxTeuRtAmt = (JSPUtil.getParameter(request, prefix	+ "max_teu_rt_amt", length));
			String[] mktRtAplyFlg = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_aply_flg", length));
			String[] vslKrnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_krn_nm", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] hirRtN2ndAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n2nd_amt", length));
			String[] stndMaxHirAmt = (JSPUtil.getParameter(request, prefix	+ "stnd_max_hir_amt", length));
			String[] teu14tonRtAmt = (JSPUtil.getParameter(request, prefix	+ "teu_14ton_rt_amt", length));
			String[] diffStndMaxHirAmt = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_max_hir_amt", length));
			String[] hirRtN1stAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n1st_amt", length));
			String[] mktRtAplyFlg1 = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_aply_flg1", length));
			String[] stnd14tonHirAmt1 = (JSPUtil.getParameter(request, prefix	+ "stnd_14ton_hir_amt1", length));
			String[] diffStndMaxHirAmt1 = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_max_hir_amt1", length));
			String[] diffStnd14tonHirAmt = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_14ton_hir_amt", length));
			String[] bse14tonVslCapa = (JSPUtil.getParameter(request, prefix	+ "bse_14ton_vsl_capa", length));
			String[] diffStnd14tonHirAmt1 = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_14ton_hir_amt1", length));
			String[] mktRtAmt = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_amt", length));
			String[] vslDzndTtlQty = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_ttl_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchStandardHireBaseListVO();
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (hbYrmon[i] != null)
					model.setHbYrmon(hbYrmon[i]);
				if (stnd14tonHirAmt[i] != null)
					model.setStnd14tonHirAmt(stnd14tonHirAmt[i]);
				if (bse14tonVslTtlQty[i] != null)
					model.setBse14tonVslTtlQty(bse14tonVslTtlQty[i]);
				if (stndMaxHirAmt1[i] != null)
					model.setStndMaxHirAmt1(stndMaxHirAmt1[i]);
				if (saveType[i] != null)
					model.setSaveType(saveType[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hirRtTtlAmt[i] != null)
					model.setHirRtTtlAmt(hirRtTtlAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (maxTeuRtAmt[i] != null)
					model.setMaxTeuRtAmt(maxTeuRtAmt[i]);
				if (mktRtAplyFlg[i] != null)
					model.setMktRtAplyFlg(mktRtAplyFlg[i]);
				if (vslKrnNm[i] != null)
					model.setVslKrnNm(vslKrnNm[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (hirRtN2ndAmt[i] != null)
					model.setHirRtN2ndAmt(hirRtN2ndAmt[i]);
				if (stndMaxHirAmt[i] != null)
					model.setStndMaxHirAmt(stndMaxHirAmt[i]);
				if (teu14tonRtAmt[i] != null)
					model.setTeu14tonRtAmt(teu14tonRtAmt[i]);
				if (diffStndMaxHirAmt[i] != null)
					model.setDiffStndMaxHirAmt(diffStndMaxHirAmt[i]);
				if (hirRtN1stAmt[i] != null)
					model.setHirRtN1stAmt(hirRtN1stAmt[i]);
				if (mktRtAplyFlg1[i] != null)
					model.setMktRtAplyFlg1(mktRtAplyFlg1[i]);
				if (stnd14tonHirAmt1[i] != null)
					model.setStnd14tonHirAmt1(stnd14tonHirAmt1[i]);
				if (diffStndMaxHirAmt1[i] != null)
					model.setDiffStndMaxHirAmt1(diffStndMaxHirAmt1[i]);
				if (diffStnd14tonHirAmt[i] != null)
					model.setDiffStnd14tonHirAmt(diffStnd14tonHirAmt[i]);
				if (bse14tonVslCapa[i] != null)
					model.setBse14tonVslCapa(bse14tonVslCapa[i]);
				if (diffStnd14tonHirAmt1[i] != null)
					model.setDiffStnd14tonHirAmt1(diffStnd14tonHirAmt1[i]);
				if (mktRtAmt[i] != null)
					model.setMktRtAmt(mktRtAmt[i]);
				if (vslDzndTtlQty[i] != null)
					model.setVslDzndTtlQty(vslDzndTtlQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchStandardHireBaseListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchStandardHireBaseListVO[]
	 */
	public SearchStandardHireBaseListVO[] getSearchStandardHireBaseListVOs(){
		SearchStandardHireBaseListVO[] vos = (SearchStandardHireBaseListVO[])models.toArray(new SearchStandardHireBaseListVO[models.size()]);
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
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbYrmon = this.hbYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stnd14tonHirAmt = this.stnd14tonHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse14tonVslTtlQty = this.bse14tonVslTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndMaxHirAmt1 = this.stndMaxHirAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveType = this.saveType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtTtlAmt = this.hirRtTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTeuRtAmt = this.maxTeuRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtAplyFlg = this.mktRtAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKrnNm = this.vslKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN2ndAmt = this.hirRtN2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndMaxHirAmt = this.stndMaxHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu14tonRtAmt = this.teu14tonRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStndMaxHirAmt = this.diffStndMaxHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN1stAmt = this.hirRtN1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtAplyFlg1 = this.mktRtAplyFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stnd14tonHirAmt1 = this.stnd14tonHirAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStndMaxHirAmt1 = this.diffStndMaxHirAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStnd14tonHirAmt = this.diffStnd14tonHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse14tonVslCapa = this.bse14tonVslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStnd14tonHirAmt1 = this.diffStnd14tonHirAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtAmt = this.mktRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDzndTtlQty = this.vslDzndTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
