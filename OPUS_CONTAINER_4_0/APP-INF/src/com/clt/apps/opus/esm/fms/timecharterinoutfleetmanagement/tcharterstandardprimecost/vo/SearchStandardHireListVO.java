/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchStandardHireListVO.java
*@FileTitle : SearchStandardHireListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.23 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tcharterstandardprimecost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchStandardHireListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchStandardHireListVO> models = new ArrayList<SearchStandardHireListVO>();
	
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
	private String stndMaxHirAmt1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String maxTeuRtAmt = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String mktRtAplyFlg = null;
	/* Column Info */
	private String vslKrnNm = null;
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
	private String stnd14tonHirAmt1 = null;
	/* Column Info */
	private String bse14tonVslCapa = null;
	/* Column Info */
	private String diffStnd14tonHirAmt = null;
	/* Column Info */
	private String diffStndMaxHirAmt1 = null;
	/* Column Info */
	private String diffStnd14tonHirAmt1 = null;
	/* Column Info */
	private String mktRtAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchStandardHireListVO() {}

	public SearchStandardHireListVO(String ibflag, String pagerows, String stndMaxHirAmt1, String mktRtAmt, String stnd14tonHirAmt, String hirRtN1stAmt, String stnd14tonHirAmt1, String teu14tonRtAmt, String stndMaxHirAmt, String hirRtN2ndAmt, String diffStnd14tonHirAmt, String maxTeuRtAmt, String bse14tonVslCapa, String vslCntCd, String hbYrmon, String diffStndMaxHirAmt, String vslDzndCapa, String fletCtrtTpCd, String vslCd, String mktRtAplyFlg, String fletCtrtNo, String vslEngNm, String vslKrnNm, String diffStndMaxHirAmt1, String diffStnd14tonHirAmt1) {
		this.vslDzndCapa = vslDzndCapa;
		this.vslCd = vslCd;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.hbYrmon = hbYrmon;
		this.stnd14tonHirAmt = stnd14tonHirAmt;
		this.stndMaxHirAmt1 = stndMaxHirAmt1;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.maxTeuRtAmt = maxTeuRtAmt;
		this.vslCntCd = vslCntCd;
		this.mktRtAplyFlg = mktRtAplyFlg;
		this.vslKrnNm = vslKrnNm;
		this.hirRtN2ndAmt = hirRtN2ndAmt;
		this.stndMaxHirAmt = stndMaxHirAmt;
		this.teu14tonRtAmt = teu14tonRtAmt;
		this.diffStndMaxHirAmt = diffStndMaxHirAmt;
		this.hirRtN1stAmt = hirRtN1stAmt;
		this.stnd14tonHirAmt1 = stnd14tonHirAmt1;
		this.bse14tonVslCapa = bse14tonVslCapa;
		this.diffStnd14tonHirAmt = diffStnd14tonHirAmt;
		this.diffStndMaxHirAmt1 = diffStndMaxHirAmt1;
		this.diffStnd14tonHirAmt1 = diffStnd14tonHirAmt1;
		this.mktRtAmt = mktRtAmt;
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
		this.hashColumns.put("stnd_max_hir_amt1", getStndMaxHirAmt1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("max_teu_rt_amt", getMaxTeuRtAmt());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("mkt_rt_aply_flg", getMktRtAplyFlg());
		this.hashColumns.put("vsl_krn_nm", getVslKrnNm());
		this.hashColumns.put("hir_rt_n2nd_amt", getHirRtN2ndAmt());
		this.hashColumns.put("stnd_max_hir_amt", getStndMaxHirAmt());
		this.hashColumns.put("teu_14ton_rt_amt", getTeu14tonRtAmt());
		this.hashColumns.put("diff_stnd_max_hir_amt", getDiffStndMaxHirAmt());
		this.hashColumns.put("hir_rt_n1st_amt", getHirRtN1stAmt());
		this.hashColumns.put("stnd_14ton_hir_amt1", getStnd14tonHirAmt1());
		this.hashColumns.put("bse_14ton_vsl_capa", getBse14tonVslCapa());
		this.hashColumns.put("diff_stnd_14ton_hir_amt", getDiffStnd14tonHirAmt());
		this.hashColumns.put("diff_stnd_max_hir_amt1", getDiffStndMaxHirAmt1());
		this.hashColumns.put("diff_stnd_14ton_hir_amt1", getDiffStnd14tonHirAmt1());
		this.hashColumns.put("mkt_rt_amt", getMktRtAmt());
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
		this.hashFields.put("stnd_max_hir_amt1", "stndMaxHirAmt1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("max_teu_rt_amt", "maxTeuRtAmt");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("mkt_rt_aply_flg", "mktRtAplyFlg");
		this.hashFields.put("vsl_krn_nm", "vslKrnNm");
		this.hashFields.put("hir_rt_n2nd_amt", "hirRtN2ndAmt");
		this.hashFields.put("stnd_max_hir_amt", "stndMaxHirAmt");
		this.hashFields.put("teu_14ton_rt_amt", "teu14tonRtAmt");
		this.hashFields.put("diff_stnd_max_hir_amt", "diffStndMaxHirAmt");
		this.hashFields.put("hir_rt_n1st_amt", "hirRtN1stAmt");
		this.hashFields.put("stnd_14ton_hir_amt1", "stnd14tonHirAmt1");
		this.hashFields.put("bse_14ton_vsl_capa", "bse14tonVslCapa");
		this.hashFields.put("diff_stnd_14ton_hir_amt", "diffStnd14tonHirAmt");
		this.hashFields.put("diff_stnd_max_hir_amt1", "diffStndMaxHirAmt1");
		this.hashFields.put("diff_stnd_14ton_hir_amt1", "diffStnd14tonHirAmt1");
		this.hashFields.put("mkt_rt_amt", "mktRtAmt");
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
	 * @return stndMaxHirAmt1
	 */
	public String getStndMaxHirAmt1() {
		return this.stndMaxHirAmt1;
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
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
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
	 * @return stnd14tonHirAmt1
	 */
	public String getStnd14tonHirAmt1() {
		return this.stnd14tonHirAmt1;
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
	 * @return diffStnd14tonHirAmt
	 */
	public String getDiffStnd14tonHirAmt() {
		return this.diffStnd14tonHirAmt;
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
	 * @param stndMaxHirAmt1
	 */
	public void setStndMaxHirAmt1(String stndMaxHirAmt1) {
		this.stndMaxHirAmt1 = stndMaxHirAmt1;
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
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
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
	 * @param stnd14tonHirAmt1
	 */
	public void setStnd14tonHirAmt1(String stnd14tonHirAmt1) {
		this.stnd14tonHirAmt1 = stnd14tonHirAmt1;
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
	 * @param diffStnd14tonHirAmt
	 */
	public void setDiffStnd14tonHirAmt(String diffStnd14tonHirAmt) {
		this.diffStnd14tonHirAmt = diffStnd14tonHirAmt;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setHbYrmon(JSPUtil.getParameter(request, "hb_yrmon", ""));
		setStnd14tonHirAmt(JSPUtil.getParameter(request, "stnd_14ton_hir_amt", ""));
		setStndMaxHirAmt1(JSPUtil.getParameter(request, "stnd_max_hir_amt1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setMaxTeuRtAmt(JSPUtil.getParameter(request, "max_teu_rt_amt", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setMktRtAplyFlg(JSPUtil.getParameter(request, "mkt_rt_aply_flg", ""));
		setVslKrnNm(JSPUtil.getParameter(request, "vsl_krn_nm", ""));
		setHirRtN2ndAmt(JSPUtil.getParameter(request, "hir_rt_n2nd_amt", ""));
		setStndMaxHirAmt(JSPUtil.getParameter(request, "stnd_max_hir_amt", ""));
		setTeu14tonRtAmt(JSPUtil.getParameter(request, "teu_14ton_rt_amt", ""));
		setDiffStndMaxHirAmt(JSPUtil.getParameter(request, "diff_stnd_max_hir_amt", ""));
		setHirRtN1stAmt(JSPUtil.getParameter(request, "hir_rt_n1st_amt", ""));
		setStnd14tonHirAmt1(JSPUtil.getParameter(request, "stnd_14ton_hir_amt1", ""));
		setBse14tonVslCapa(JSPUtil.getParameter(request, "bse_14ton_vsl_capa", ""));
		setDiffStnd14tonHirAmt(JSPUtil.getParameter(request, "diff_stnd_14ton_hir_amt", ""));
		setDiffStndMaxHirAmt1(JSPUtil.getParameter(request, "diff_stnd_max_hir_amt1", ""));
		setDiffStnd14tonHirAmt1(JSPUtil.getParameter(request, "diff_stnd_14ton_hir_amt1", ""));
		setMktRtAmt(JSPUtil.getParameter(request, "mkt_rt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStandardHireListVO[]
	 */
	public SearchStandardHireListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStandardHireListVO[]
	 */
	public SearchStandardHireListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchStandardHireListVO model = null;
		
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
			String[] stndMaxHirAmt1 = (JSPUtil.getParameter(request, prefix	+ "stnd_max_hir_amt1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] maxTeuRtAmt = (JSPUtil.getParameter(request, prefix	+ "max_teu_rt_amt", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] mktRtAplyFlg = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_aply_flg", length));
			String[] vslKrnNm = (JSPUtil.getParameter(request, prefix	+ "vsl_krn_nm", length));
			String[] hirRtN2ndAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n2nd_amt", length));
			String[] stndMaxHirAmt = (JSPUtil.getParameter(request, prefix	+ "stnd_max_hir_amt", length));
			String[] teu14tonRtAmt = (JSPUtil.getParameter(request, prefix	+ "teu_14ton_rt_amt", length));
			String[] diffStndMaxHirAmt = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_max_hir_amt", length));
			String[] hirRtN1stAmt = (JSPUtil.getParameter(request, prefix	+ "hir_rt_n1st_amt", length));
			String[] stnd14tonHirAmt1 = (JSPUtil.getParameter(request, prefix	+ "stnd_14ton_hir_amt1", length));
			String[] bse14tonVslCapa = (JSPUtil.getParameter(request, prefix	+ "bse_14ton_vsl_capa", length));
			String[] diffStnd14tonHirAmt = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_14ton_hir_amt", length));
			String[] diffStndMaxHirAmt1 = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_max_hir_amt1", length));
			String[] diffStnd14tonHirAmt1 = (JSPUtil.getParameter(request, prefix	+ "diff_stnd_14ton_hir_amt1", length));
			String[] mktRtAmt = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchStandardHireListVO();
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
				if (stndMaxHirAmt1[i] != null)
					model.setStndMaxHirAmt1(stndMaxHirAmt1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (maxTeuRtAmt[i] != null)
					model.setMaxTeuRtAmt(maxTeuRtAmt[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (mktRtAplyFlg[i] != null)
					model.setMktRtAplyFlg(mktRtAplyFlg[i]);
				if (vslKrnNm[i] != null)
					model.setVslKrnNm(vslKrnNm[i]);
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
				if (stnd14tonHirAmt1[i] != null)
					model.setStnd14tonHirAmt1(stnd14tonHirAmt1[i]);
				if (bse14tonVslCapa[i] != null)
					model.setBse14tonVslCapa(bse14tonVslCapa[i]);
				if (diffStnd14tonHirAmt[i] != null)
					model.setDiffStnd14tonHirAmt(diffStnd14tonHirAmt[i]);
				if (diffStndMaxHirAmt1[i] != null)
					model.setDiffStndMaxHirAmt1(diffStndMaxHirAmt1[i]);
				if (diffStnd14tonHirAmt1[i] != null)
					model.setDiffStnd14tonHirAmt1(diffStnd14tonHirAmt1[i]);
				if (mktRtAmt[i] != null)
					model.setMktRtAmt(mktRtAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchStandardHireListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchStandardHireListVO[]
	 */
	public SearchStandardHireListVO[] getSearchStandardHireListVOs(){
		SearchStandardHireListVO[] vos = (SearchStandardHireListVO[])models.toArray(new SearchStandardHireListVO[models.size()]);
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
		this.stndMaxHirAmt1 = this.stndMaxHirAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTeuRtAmt = this.maxTeuRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtAplyFlg = this.mktRtAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKrnNm = this.vslKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN2ndAmt = this.hirRtN2ndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndMaxHirAmt = this.stndMaxHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu14tonRtAmt = this.teu14tonRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStndMaxHirAmt = this.diffStndMaxHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hirRtN1stAmt = this.hirRtN1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stnd14tonHirAmt1 = this.stnd14tonHirAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse14tonVslCapa = this.bse14tonVslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStnd14tonHirAmt = this.diffStnd14tonHirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStndMaxHirAmt1 = this.diffStndMaxHirAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffStnd14tonHirAmt1 = this.diffStnd14tonHirAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtAmt = this.mktRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
