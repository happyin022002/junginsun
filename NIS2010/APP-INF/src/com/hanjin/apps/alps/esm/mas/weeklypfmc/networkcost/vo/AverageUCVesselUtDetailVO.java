/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AverageUCVesselUtDetailVO.java
*@FileTitle : AverageUCVesselUtDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.03.10 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AverageUCVesselUtDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AverageUCVesselUtDetailVO> models = new ArrayList<AverageUCVesselUtDetailVO>();
	
	/* Column Info */
	private String freqNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String teuUcAmt = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dhirAmt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String maxRnk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String ttlDays = null;
	/* Column Info */
	private String cycleFlg = null;
	/* Column Info */
	private String vslOshpCd = null;
	/* Column Info */
	private String vvdBsaCapa = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String effYrmon = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Column Info */
	private String misTtl = null;
	/*	Column Info	*/
	private String costWk = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AverageUCVesselUtDetailVO() {}

	public AverageUCVesselUtDetailVO(String ibflag, String pagerows, String costYrmon, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String hulBndCd, String vslOshpCd, String vslClssCapa, String vvd, String vslCd, String skdVoyNo, String ttlAmt, String ttlDays, String effYrmon, String dhirAmt, String vvdBsaCapa, String teuUcAmt, String stndCostCd, String updUsrId, String freqNo, String maxRnk, String cycleFlg, String misTtl, String costWk) {
		this.freqNo = freqNo;
		this.vslCd = vslCd;
		this.hulBndCd = hulBndCd;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.teuUcAmt = teuUcAmt;
		this.ttlAmt = ttlAmt;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.dhirAmt = dhirAmt;
		this.vvd = vvd;
		this.maxRnk = maxRnk;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.ttlDays = ttlDays;
		this.cycleFlg = cycleFlg;
		this.vslOshpCd = vslOshpCd;
		this.vvdBsaCapa = vvdBsaCapa;
		this.dirCd = dirCd;
		this.vslClssCapa = vslClssCapa;
		this.updUsrId = updUsrId;
		this.effYrmon = effYrmon;
		this.subTrdCd = subTrdCd;
		this.stndCostCd = stndCostCd;
		this.misTtl = misTtl;
		this.costWk = costWk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("freq_no", getFreqNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("teu_uc_amt", getTeuUcAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dhir_amt", getDhirAmt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("max_rnk", getMaxRnk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("ttl_days", getTtlDays());
		this.hashColumns.put("cycle_flg", getCycleFlg());
		this.hashColumns.put("vsl_oshp_cd", getVslOshpCd());
		this.hashColumns.put("vvd_bsa_capa", getVvdBsaCapa());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eff_yrmon", getEffYrmon());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("mis_ttl", getMisTtl());
		this.hashColumns.put("cost_wk", getCostWk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("freq_no", "freqNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("teu_uc_amt", "teuUcAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dhir_amt", "dhirAmt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("max_rnk", "maxRnk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("ttl_days", "ttlDays");
		this.hashFields.put("cycle_flg", "cycleFlg");
		this.hashFields.put("vsl_oshp_cd", "vslOshpCd");
		this.hashFields.put("vvd_bsa_capa", "vvdBsaCapa");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("mis_ttl", "misTtl");
		this.hashFields.put("cost_wk", "costWk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return freqNo
	 */
	public String getFreqNo() {
		return this.freqNo;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return teuUcAmt
	 */
	public String getTeuUcAmt() {
		return this.teuUcAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return dhirAmt
	 */
	public String getDhirAmt() {
		return this.dhirAmt;
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
	 * @return maxRnk
	 */
	public String getMaxRnk() {
		return this.maxRnk;
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
	 * @return ttlDays
	 */
	public String getTtlDays() {
		return this.ttlDays;
	}
	
	/**
	 * Column Info
	 * @return cycleFlg
	 */
	public String getCycleFlg() {
		return this.cycleFlg;
	}
	
	/**
	 * Column Info
	 * @return vslOshpCd
	 */
	public String getVslOshpCd() {
		return this.vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @return vvdBsaCapa
	 */
	public String getVvdBsaCapa() {
		return this.vvdBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
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
	 * @return effYrmon
	 */
	public String getEffYrmon() {
		return this.effYrmon;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	
	/**
	 * Column Info
	 * @return misTtl
	 */
	public String getMisTtl() {
		return this.misTtl;
	}
	
	/**
	* Column Info
	* @return costWk
	*/
	public String getCostWk() {
	return this.costWk;
	}
	
	/**
	 * Column Info
	 * @param freqNo
	 */
	public void setFreqNo(String freqNo) {
		this.freqNo = freqNo;
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
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param teuUcAmt
	 */
	public void setTeuUcAmt(String teuUcAmt) {
		this.teuUcAmt = teuUcAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param dhirAmt
	 */
	public void setDhirAmt(String dhirAmt) {
		this.dhirAmt = dhirAmt;
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
	 * @param maxRnk
	 */
	public void setMaxRnk(String maxRnk) {
		this.maxRnk = maxRnk;
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
	 * @param ttlDays
	 */
	public void setTtlDays(String ttlDays) {
		this.ttlDays = ttlDays;
	}
	
	/**
	 * Column Info
	 * @param cycleFlg
	 */
	public void setCycleFlg(String cycleFlg) {
		this.cycleFlg = cycleFlg;
	}
	
	/**
	 * Column Info
	 * @param vslOshpCd
	 */
	public void setVslOshpCd(String vslOshpCd) {
		this.vslOshpCd = vslOshpCd;
	}
	
	/**
	 * Column Info
	 * @param vvdBsaCapa
	 */
	public void setVvdBsaCapa(String vvdBsaCapa) {
		this.vvdBsaCapa = vvdBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
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
	 * @param effYrmon
	 */
	public void setEffYrmon(String effYrmon) {
		this.effYrmon = effYrmon;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * Column Info
	 * @param misTtl
	 */
	public void setMisTtl(String misTtl) {
		this.misTtl = misTtl;
	}
	
	/**
	* Column Info
	* @return costWk
	*/
	public void setCostWk(String costWk) {
	this.costWk = costWk;
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
		setFreqNo(JSPUtil.getParameter(request, prefix + "freq_no", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTeuUcAmt(JSPUtil.getParameter(request, prefix + "teu_uc_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDhirAmt(JSPUtil.getParameter(request, prefix + "dhir_amt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setMaxRnk(JSPUtil.getParameter(request, prefix + "max_rnk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setTtlDays(JSPUtil.getParameter(request, prefix + "ttl_days", ""));
		setCycleFlg(JSPUtil.getParameter(request, prefix + "cycle_flg", ""));
		setVslOshpCd(JSPUtil.getParameter(request, prefix + "vsl_oshp_cd", ""));
		setVvdBsaCapa(JSPUtil.getParameter(request, prefix + "vvd_bsa_capa", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEffYrmon(JSPUtil.getParameter(request, prefix + "eff_yrmon", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
		setMisTtl(JSPUtil.getParameter(request, prefix + "mis_ttl", ""));
		setCostWk(JSPUtil.getParameter(request,	prefix + "cost_wk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AverageUCVesselUtDetailVO[]
	 */
	public AverageUCVesselUtDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AverageUCVesselUtDetailVO[]
	 */
	public AverageUCVesselUtDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AverageUCVesselUtDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] freqNo = (JSPUtil.getParameter(request, prefix	+ "freq_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] teuUcAmt = (JSPUtil.getParameter(request, prefix	+ "teu_uc_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dhirAmt = (JSPUtil.getParameter(request, prefix	+ "dhir_amt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] maxRnk = (JSPUtil.getParameter(request, prefix	+ "max_rnk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] ttlDays = (JSPUtil.getParameter(request, prefix	+ "ttl_days", length));
			String[] cycleFlg = (JSPUtil.getParameter(request, prefix	+ "cycle_flg", length));
			String[] vslOshpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_oshp_cd", length));
			String[] vvdBsaCapa = (JSPUtil.getParameter(request, prefix	+ "vvd_bsa_capa", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] effYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_yrmon", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] misTtl = (JSPUtil.getParameter(request, prefix	+ "mis_ttl", length));
			String[] costWk =	(JSPUtil.getParameter(request, prefix +	"cost_wk".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new AverageUCVesselUtDetailVO();
				if (freqNo[i] != null)
					model.setFreqNo(freqNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (teuUcAmt[i] != null)
					model.setTeuUcAmt(teuUcAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dhirAmt[i] != null)
					model.setDhirAmt(dhirAmt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (maxRnk[i] != null)
					model.setMaxRnk(maxRnk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (ttlDays[i] != null)
					model.setTtlDays(ttlDays[i]);
				if (cycleFlg[i] != null)
					model.setCycleFlg(cycleFlg[i]);
				if (vslOshpCd[i] != null)
					model.setVslOshpCd(vslOshpCd[i]);
				if (vvdBsaCapa[i] != null)
					model.setVvdBsaCapa(vvdBsaCapa[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (effYrmon[i] != null)
					model.setEffYrmon(effYrmon[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (misTtl[i] != null)
					model.setMisTtl(misTtl[i]);
				if ( costWk[i] !=	null)
					model.setCostWk( costWk[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAverageUCVesselUtDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AverageUCVesselUtDetailVO[]
	 */
	public AverageUCVesselUtDetailVO[] getAverageUCVesselUtDetailVOs(){
		AverageUCVesselUtDetailVO[] vos = (AverageUCVesselUtDetailVO[])models.toArray(new AverageUCVesselUtDetailVO[models.size()]);
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
		this.freqNo = this.freqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuUcAmt = this.teuUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dhirAmt = this.dhirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxRnk = this.maxRnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDays = this.ttlDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cycleFlg = this.cycleFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOshpCd = this.vslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdBsaCapa = this.vvdBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon = this.effYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misTtl = this.misTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk =	this.costWk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
