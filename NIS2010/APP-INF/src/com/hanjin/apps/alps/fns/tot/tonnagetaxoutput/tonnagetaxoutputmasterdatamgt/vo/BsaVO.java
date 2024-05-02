/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BsaVO.java
*@FileTitle : BsaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.11.10 장창수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo;

import java.lang.reflect.Field;
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
 * @author 장창수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaVO> models = new ArrayList<BsaVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String tongBsaCapa = null;
	/* Column Info */
	private String stlYrmon = null;
	/* Column Info */
	private String eStlYrmon = null;
	/* Column Info */
	private String modiFlg = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String tongCoaCapa = null;
	/* Column Info */
	private String prevLdbCapaQty = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nrtWgt = null;
	/* Column Info */
	private String fnlHjsCoaCapa = null;
	/* Column Info */
	private String ldbCapaQty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String crrCoaCapa = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tongStlBatJbSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String searchFlg = null;
	/* Column Info */
	private String crrBsaCapa = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String intlTongCertiFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String fnlHjsBsaCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaVO() {}

	public BsaVO(String ibflag, String pagerows, String updDt, String crrCoaCapa, String tongBsaCapa, String vslCd, String tongStlBatJbSeq, String stlYrmon, String modiFlg, String creDt, String tongCoaCapa, String trdCd, String skdVoyNo, String crrBsaCapa, String skdDirCd, String intlTongCertiFlg, String creUsrId, String nrtWgt, String slanCd, String fnlHjsCoaCapa, String ldbCapaQty, String prevLdbCapaQty, String fnlHjsBsaCapa, String updUsrId, String searchFlg, String netRgstTongWgt, String vvd, String eStlYrmon, String diff) {
		this.vslCd = vslCd;
		this.tongBsaCapa = tongBsaCapa;
		this.stlYrmon = stlYrmon;
		this.eStlYrmon = eStlYrmon;
		this.modiFlg = modiFlg;
		this.diff = diff;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.tongCoaCapa = tongCoaCapa;
		this.prevLdbCapaQty = prevLdbCapaQty;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.nrtWgt = nrtWgt;
		this.fnlHjsCoaCapa = fnlHjsCoaCapa;
		this.ldbCapaQty = ldbCapaQty;
		this.updUsrId = updUsrId;
		this.netRgstTongWgt = netRgstTongWgt;
		this.crrCoaCapa = crrCoaCapa;
		this.updDt = updDt;
		this.tongStlBatJbSeq = tongStlBatJbSeq;
		this.skdVoyNo = skdVoyNo;
		this.searchFlg = searchFlg;
		this.crrBsaCapa = crrBsaCapa;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.intlTongCertiFlg = intlTongCertiFlg;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("tong_bsa_capa", getTongBsaCapa());
		this.hashColumns.put("stl_yrmon", getStlYrmon());
		this.hashColumns.put("e_stl_yrmon", getEStlYrmon());
		this.hashColumns.put("modi_flg", getModiFlg());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("tong_coa_capa", getTongCoaCapa());
		this.hashColumns.put("prev_ldb_capa_qty", getPrevLdbCapaQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nrt_wgt", getNrtWgt());
		this.hashColumns.put("fnl_hjs_coa_capa", getFnlHjsCoaCapa());
		this.hashColumns.put("ldb_capa_qty", getLdbCapaQty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("crr_coa_capa", getCrrCoaCapa());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tong_stl_bat_jb_seq", getTongStlBatJbSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("search_flg", getSearchFlg());
		this.hashColumns.put("crr_bsa_capa", getCrrBsaCapa());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("intl_tong_certi_flg", getIntlTongCertiFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("fnl_hjs_bsa_capa", getFnlHjsBsaCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("tong_bsa_capa", "tongBsaCapa");
		this.hashFields.put("stl_yrmon", "stlYrmon");
		this.hashFields.put("e_stl_yrmon", "eStlYrmon");
		this.hashFields.put("modi_flg", "modiFlg");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("tong_coa_capa", "tongCoaCapa");
		this.hashFields.put("prev_ldb_capa_qty", "prevLdbCapaQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nrt_wgt", "nrtWgt");
		this.hashFields.put("fnl_hjs_coa_capa", "fnlHjsCoaCapa");
		this.hashFields.put("ldb_capa_qty", "ldbCapaQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("crr_coa_capa", "crrCoaCapa");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tong_stl_bat_jb_seq", "tongStlBatJbSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("search_flg", "searchFlg");
		this.hashFields.put("crr_bsa_capa", "crrBsaCapa");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("intl_tong_certi_flg", "intlTongCertiFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("fnl_hjs_bsa_capa", "fnlHjsBsaCapa");
		return this.hashFields;
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
	 * @return tongBsaCapa
	 */
	public String getTongBsaCapa() {
		return this.tongBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return stlYrmon
	 */
	public String getStlYrmon() {
		return this.stlYrmon;
	}
	
	/**
	 * Column Info
	 * @return eStlYrmon
	 */
	public String getEStlYrmon() {
		return this.eStlYrmon;
	}
	
	/**
	 * Column Info
	 * @return modiFlg
	 */
	public String getModiFlg() {
		return this.modiFlg;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return tongCoaCapa
	 */
	public String getTongCoaCapa() {
		return this.tongCoaCapa;
	}
	
	/**
	 * Column Info
	 * @return prevLdbCapaQty
	 */
	public String getPrevLdbCapaQty() {
		return this.prevLdbCapaQty;
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
	 * @return nrtWgt
	 */
	public String getNrtWgt() {
		return this.nrtWgt;
	}
	
	/**
	 * Column Info
	 * @return fnlHjsCoaCapa
	 */
	public String getFnlHjsCoaCapa() {
		return this.fnlHjsCoaCapa;
	}
	
	/**
	 * Column Info
	 * @return ldbCapaQty
	 */
	public String getLdbCapaQty() {
		return this.ldbCapaQty;
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
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return crrCoaCapa
	 */
	public String getCrrCoaCapa() {
		return this.crrCoaCapa;
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
	 * @return tongStlBatJbSeq
	 */
	public String getTongStlBatJbSeq() {
		return this.tongStlBatJbSeq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return searchFlg
	 */
	public String getSearchFlg() {
		return this.searchFlg;
	}
	
	/**
	 * Column Info
	 * @return crrBsaCapa
	 */
	public String getCrrBsaCapa() {
		return this.crrBsaCapa;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return intlTongCertiFlg
	 */
	public String getIntlTongCertiFlg() {
		return this.intlTongCertiFlg;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return fnlHjsBsaCapa
	 */
	public String getFnlHjsBsaCapa() {
		return this.fnlHjsBsaCapa;
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
	 * @param tongBsaCapa
	 */
	public void setTongBsaCapa(String tongBsaCapa) {
		this.tongBsaCapa = tongBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param stlYrmon
	 */
	public void setStlYrmon(String stlYrmon) {
		this.stlYrmon = stlYrmon;
	}
	
	/**
	 * Column Info
	 * @param eStlYrmon
	 */
	public void setEStlYrmon(String eStlYrmon) {
		this.eStlYrmon = eStlYrmon;
	}
	
	/**
	 * Column Info
	 * @param modiFlg
	 */
	public void setModiFlg(String modiFlg) {
		this.modiFlg = modiFlg;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param tongCoaCapa
	 */
	public void setTongCoaCapa(String tongCoaCapa) {
		this.tongCoaCapa = tongCoaCapa;
	}
	
	/**
	 * Column Info
	 * @param prevLdbCapaQty
	 */
	public void setPrevLdbCapaQty(String prevLdbCapaQty) {
		this.prevLdbCapaQty = prevLdbCapaQty;
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
	 * @param nrtWgt
	 */
	public void setNrtWgt(String nrtWgt) {
		this.nrtWgt = nrtWgt;
	}
	
	/**
	 * Column Info
	 * @param fnlHjsCoaCapa
	 */
	public void setFnlHjsCoaCapa(String fnlHjsCoaCapa) {
		this.fnlHjsCoaCapa = fnlHjsCoaCapa;
	}
	
	/**
	 * Column Info
	 * @param ldbCapaQty
	 */
	public void setLdbCapaQty(String ldbCapaQty) {
		this.ldbCapaQty = ldbCapaQty;
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
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param crrCoaCapa
	 */
	public void setCrrCoaCapa(String crrCoaCapa) {
		this.crrCoaCapa = crrCoaCapa;
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
	 * @param tongStlBatJbSeq
	 */
	public void setTongStlBatJbSeq(String tongStlBatJbSeq) {
		this.tongStlBatJbSeq = tongStlBatJbSeq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param searchFlg
	 */
	public void setSearchFlg(String searchFlg) {
		this.searchFlg = searchFlg;
	}
	
	/**
	 * Column Info
	 * @param crrBsaCapa
	 */
	public void setCrrBsaCapa(String crrBsaCapa) {
		this.crrBsaCapa = crrBsaCapa;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param intlTongCertiFlg
	 */
	public void setIntlTongCertiFlg(String intlTongCertiFlg) {
		this.intlTongCertiFlg = intlTongCertiFlg;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param fnlHjsBsaCapa
	 */
	public void setFnlHjsBsaCapa(String fnlHjsBsaCapa) {
		this.fnlHjsBsaCapa = fnlHjsBsaCapa;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTongBsaCapa(JSPUtil.getParameter(request, "tong_bsa_capa", ""));
		setStlYrmon(JSPUtil.getParameter(request, "stl_yrmon", ""));
		setEStlYrmon(JSPUtil.getParameter(request, "e_stl_yrmon", ""));
		setModiFlg(JSPUtil.getParameter(request, "modi_flg", ""));
		setDiff(JSPUtil.getParameter(request, "diff", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setTongCoaCapa(JSPUtil.getParameter(request, "tong_coa_capa", ""));
		setPrevLdbCapaQty(JSPUtil.getParameter(request, "prev_ldb_capa_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNrtWgt(JSPUtil.getParameter(request, "nrt_wgt", ""));
		setFnlHjsCoaCapa(JSPUtil.getParameter(request, "fnl_hjs_coa_capa", ""));
		setLdbCapaQty(JSPUtil.getParameter(request, "ldb_capa_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setNetRgstTongWgt(JSPUtil.getParameter(request, "net_rgst_tong_wgt", ""));
		setCrrCoaCapa(JSPUtil.getParameter(request, "crr_coa_capa", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTongStlBatJbSeq(JSPUtil.getParameter(request, "tong_stl_bat_jb_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSearchFlg(JSPUtil.getParameter(request, "search_flg", ""));
		setCrrBsaCapa(JSPUtil.getParameter(request, "crr_bsa_capa", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIntlTongCertiFlg(JSPUtil.getParameter(request, "intl_tong_certi_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setFnlHjsBsaCapa(JSPUtil.getParameter(request, "fnl_hjs_bsa_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaVO[]
	 */
	public BsaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaVO[]
	 */
	public BsaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] tongBsaCapa = (JSPUtil.getParameter(request, prefix	+ "tong_bsa_capa", length));
			String[] stlYrmon = (JSPUtil.getParameter(request, prefix	+ "stl_yrmon", length));
			String[] eStlYrmon = (JSPUtil.getParameter(request, prefix	+ "e_stl_yrmon", length));
			String[] modiFlg = (JSPUtil.getParameter(request, prefix	+ "modi_flg", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] tongCoaCapa = (JSPUtil.getParameter(request, prefix	+ "tong_coa_capa", length));
			String[] prevLdbCapaQty = (JSPUtil.getParameter(request, prefix	+ "prev_ldb_capa_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nrtWgt = (JSPUtil.getParameter(request, prefix	+ "nrt_wgt", length));
			String[] fnlHjsCoaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_coa_capa", length));
			String[] ldbCapaQty = (JSPUtil.getParameter(request, prefix	+ "ldb_capa_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] crrCoaCapa = (JSPUtil.getParameter(request, prefix	+ "crr_coa_capa", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tongStlBatJbSeq = (JSPUtil.getParameter(request, prefix	+ "tong_stl_bat_jb_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] searchFlg = (JSPUtil.getParameter(request, prefix	+ "search_flg", length));
			String[] crrBsaCapa = (JSPUtil.getParameter(request, prefix	+ "crr_bsa_capa", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] intlTongCertiFlg = (JSPUtil.getParameter(request, prefix	+ "intl_tong_certi_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] fnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "fnl_hjs_bsa_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new BsaVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (tongBsaCapa[i] != null)
					model.setTongBsaCapa(tongBsaCapa[i]);
				if (stlYrmon[i] != null)
					model.setStlYrmon(stlYrmon[i]);
				if (eStlYrmon[i] != null)
					model.setEStlYrmon(eStlYrmon[i]);
				if (modiFlg[i] != null)
					model.setModiFlg(modiFlg[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (tongCoaCapa[i] != null)
					model.setTongCoaCapa(tongCoaCapa[i]);
				if (prevLdbCapaQty[i] != null)
					model.setPrevLdbCapaQty(prevLdbCapaQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nrtWgt[i] != null)
					model.setNrtWgt(nrtWgt[i]);
				if (fnlHjsCoaCapa[i] != null)
					model.setFnlHjsCoaCapa(fnlHjsCoaCapa[i]);
				if (ldbCapaQty[i] != null)
					model.setLdbCapaQty(ldbCapaQty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (crrCoaCapa[i] != null)
					model.setCrrCoaCapa(crrCoaCapa[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tongStlBatJbSeq[i] != null)
					model.setTongStlBatJbSeq(tongStlBatJbSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (searchFlg[i] != null)
					model.setSearchFlg(searchFlg[i]);
				if (crrBsaCapa[i] != null)
					model.setCrrBsaCapa(crrBsaCapa[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (intlTongCertiFlg[i] != null)
					model.setIntlTongCertiFlg(intlTongCertiFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (fnlHjsBsaCapa[i] != null)
					model.setFnlHjsBsaCapa(fnlHjsBsaCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaVO[]
	 */
	public BsaVO[] getBsaVOs(){
		BsaVO[] vos = (BsaVO[])models.toArray(new BsaVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongBsaCapa = this.tongBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlYrmon = this.stlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlYrmon = this.eStlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiFlg = this.modiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongCoaCapa = this.tongCoaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevLdbCapaQty = this.prevLdbCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtWgt = this.nrtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsCoaCapa = this.fnlHjsCoaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldbCapaQty = this.ldbCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCoaCapa = this.crrCoaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongStlBatJbSeq = this.tongStlBatJbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFlg = this.searchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBsaCapa = this.crrBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlTongCertiFlg = this.intlTongCertiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlHjsBsaCapa = this.fnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
