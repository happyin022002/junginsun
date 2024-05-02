/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchRgstLaneListVO.java
*@FileTitle : SearchRgstLaneListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.23  
* 1.0 Creation
* 
* 2012.09.17 이석준[CHM-201220161] 실시간 영업현황 관련 UI- Create Lane Table 기능 추가
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.vo;

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

public class SearchRgstLaneListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRgstLaneListVO> models = new ArrayList<SearchRgstLaneListVO>();
	
	/* Column Info */
	private String eurFlg = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslLaneTpCd = null;
	/* Column Info */
	private String trnsPcfFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String subTrdDesc = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String trnkIptFlg = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lodSplCngFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String pctlLaneChkFlg = null;
	/* Column Info */
	private String opLaneTpCd = null;
	/* Column Info */
	private String stupFlg = null;
	/* Column Info */
	private String intrAsiaFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String sctrPrcFlg = null;
	/* Column Info */
	private String laneTpHisFlg = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String trnsAtlanFlg = null;
	/* Column Info */
	private String rvsBndFlg = null;
	/* Column Info */
	private String mktRtFlg = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String iasRgnCd = null;

	/*	테이블 컬럼의 값을 저장하는  Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRgstLaneListVO() {}

	public SearchRgstLaneListVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String slanCd, String rlaneCd, String dirCd, String iocCd, String vslLaneTpCd, String opLaneTpCd, String pctlLaneChkFlg, String stupFlg, String sctrPrcFlg, String trnsPcfFlg, String eurFlg, String trnsAtlanFlg, String intrAsiaFlg, String trnkIptFlg, String subTrdDesc, String deltFlg, String lodSplCngFlg, String laneTpHisFlg, String rvsBndFlg, String mktRtFlg, String iasRgnCd, String hulBndCd) {
		this.eurFlg = eurFlg;
		this.iocCd = iocCd;
		this.vslLaneTpCd = vslLaneTpCd;
		this.trnsPcfFlg = trnsPcfFlg;
		this.deltFlg = deltFlg;
		this.subTrdDesc = subTrdDesc;
		this.trdCd = trdCd;
		this.trnkIptFlg = trnkIptFlg;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.lodSplCngFlg = lodSplCngFlg;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.pctlLaneChkFlg = pctlLaneChkFlg;
		this.opLaneTpCd = opLaneTpCd;
		this.stupFlg = stupFlg;
		this.intrAsiaFlg = intrAsiaFlg;
		this.dirCd = dirCd;
		this.sctrPrcFlg = sctrPrcFlg;
		this.laneTpHisFlg = laneTpHisFlg;
		this.subTrdCd = subTrdCd;
		this.trnsAtlanFlg = trnsAtlanFlg;
		this.rvsBndFlg = rvsBndFlg;
		this.mktRtFlg = mktRtFlg;
		this.hulBndCd = hulBndCd;
		this.iasRgnCd = iasRgnCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eur_flg", getEurFlg());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_lane_tp_cd", getVslLaneTpCd());
		this.hashColumns.put("trns_pcf_flg", getTrnsPcfFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("sub_trd_desc", getSubTrdDesc());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("trnk_ipt_flg", getTrnkIptFlg());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lod_spl_cng_flg", getLodSplCngFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pctl_lane_chk_flg", getPctlLaneChkFlg());
		this.hashColumns.put("op_lane_tp_cd", getOpLaneTpCd());
		this.hashColumns.put("stup_flg", getStupFlg());
		this.hashColumns.put("intr_asia_flg", getIntrAsiaFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sctr_prc_flg", getSctrPrcFlg());
		this.hashColumns.put("lane_tp_his_flg", getLaneTpHisFlg());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("trns_atlan_flg", getTrnsAtlanFlg());
		this.hashColumns.put("rvs_bnd_flg", getRvsBndFlg());
		this.hashColumns.put("mkt_rt_flg", getMktRtFlg());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("ias_rgn_cd", getIasRgnCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eur_flg", "eurFlg");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_lane_tp_cd", "vslLaneTpCd");
		this.hashFields.put("trns_pcf_flg", "trnsPcfFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("sub_trd_desc", "subTrdDesc");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("trnk_ipt_flg", "trnkIptFlg");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lod_spl_cng_flg", "lodSplCngFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pctl_lane_chk_flg", "pctlLaneChkFlg");
		this.hashFields.put("op_lane_tp_cd", "opLaneTpCd");
		this.hashFields.put("stup_flg", "stupFlg");
		this.hashFields.put("intr_asia_flg", "intrAsiaFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sctr_prc_flg", "sctrPrcFlg");
		this.hashFields.put("lane_tp_his_flg", "laneTpHisFlg");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("trns_atlan_flg", "trnsAtlanFlg");
		this.hashFields.put("rvs_bnd_flg", "rvsBndFlg");
		this.hashFields.put("mkt_rt_flg", "mktRtFlg");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("ias_rgn_cd", "iasRgnCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eurFlg
	 */
	public String getEurFlg() {
		return this.eurFlg;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return vslLaneTpCd
	 */
	public String getVslLaneTpCd() {
		return this.vslLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @return trnsPcfFlg
	 */
	public String getTrnsPcfFlg() {
		return this.trnsPcfFlg;
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
	 * @return subTrdDesc
	 */
	public String getSubTrdDesc() {
		return this.subTrdDesc;
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
	 * @return trnkIptFlg
	 */
	public String getTrnkIptFlg() {
		return this.trnkIptFlg;
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
	 * @return lodSplCngFlg
	 */
	public String getLodSplCngFlg() {
		return this.lodSplCngFlg;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return pctlLaneChkFlg
	 */
	public String getPctlLaneChkFlg() {
		return this.pctlLaneChkFlg;
	}
	
	/**
	 * Column Info
	 * @return opLaneTpCd
	 */
	public String getOpLaneTpCd() {
		return this.opLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @return stupFlg
	 */
	public String getStupFlg() {
		return this.stupFlg;
	}
	
	/**
	 * Column Info
	 * @return intrAsiaFlg
	 */
	public String getIntrAsiaFlg() {
		return this.intrAsiaFlg;
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
	 * @return sctrPrcFlg
	 */
	public String getSctrPrcFlg() {
		return this.sctrPrcFlg;
	}
	
	/**
	 * Column Info
	 * @return laneTpHisFlg
	 */
	public String getLaneTpHisFlg() {
		return this.laneTpHisFlg;
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
	 * @return trnsAtlanFlg
	 */
	public String getTrnsAtlanFlg() {
		return this.trnsAtlanFlg;
	}
	
	/**
	 * Column Info
	 * @return rvsBndFlg
	 */
	public String getRvsBndFlg() {
		return this.rvsBndFlg;
	}
	
	/**
	 * Column Info
	 * @return mktRtFlg
	 */
	public String getMktRtFlg() {
		return this.mktRtFlg;
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
	 * @return iasRgnCd
	 */
	public String getIasRgnCd() {
		return this.iasRgnCd;
	}

	/**
	 * Column Info
	 * @param eurFlg
	 */
	public void setEurFlg(String eurFlg) {
		this.eurFlg = eurFlg;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param vslLaneTpCd
	 */
	public void setVslLaneTpCd(String vslLaneTpCd) {
		this.vslLaneTpCd = vslLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @param trnsPcfFlg
	 */
	public void setTrnsPcfFlg(String trnsPcfFlg) {
		this.trnsPcfFlg = trnsPcfFlg;
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
	 * @param subTrdDesc
	 */
	public void setSubTrdDesc(String subTrdDesc) {
		this.subTrdDesc = subTrdDesc;
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
	 * @param trnkIptFlg
	 */
	public void setTrnkIptFlg(String trnkIptFlg) {
		this.trnkIptFlg = trnkIptFlg;
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
	 * @param lodSplCngFlg
	 */
	public void setLodSplCngFlg(String lodSplCngFlg) {
		this.lodSplCngFlg = lodSplCngFlg;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param pctlLaneChkFlg
	 */
	public void setPctlLaneChkFlg(String pctlLaneChkFlg) {
		this.pctlLaneChkFlg = pctlLaneChkFlg;
	}
	
	/**
	 * Column Info
	 * @param opLaneTpCd
	 */
	public void setOpLaneTpCd(String opLaneTpCd) {
		this.opLaneTpCd = opLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @param stupFlg
	 */
	public void setStupFlg(String stupFlg) {
		this.stupFlg = stupFlg;
	}
	
	/**
	 * Column Info
	 * @param intrAsiaFlg
	 */
	public void setIntrAsiaFlg(String intrAsiaFlg) {
		this.intrAsiaFlg = intrAsiaFlg;
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
	 * @param sctrPrcFlg
	 */
	public void setSctrPrcFlg(String sctrPrcFlg) {
		this.sctrPrcFlg = sctrPrcFlg;
	}
	
	/**
	 * Column Info
	 * @param laneTpHisFlg
	 */
	public void setLaneTpHisFlg(String laneTpHisFlg) {
		this.laneTpHisFlg = laneTpHisFlg;
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
	 * @param trnsAtlanFlg
	 */
	public void setTrnsAtlanFlg(String trnsAtlanFlg) {
		this.trnsAtlanFlg = trnsAtlanFlg;
	}
	
	/**
	 * Column Info
	 * @param rvsBndFlg
	 */
	public void setRvsBndFlg(String rvsBndFlg) {
		this.rvsBndFlg = rvsBndFlg;
	}
	
	/**
	 * Column Info
	 * @param mktRtFlg
	 */
	public void setMktRtFlg(String mktRtFlg) {
		this.mktRtFlg = mktRtFlg;
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
	 * @param iasRgnCd
	 */
	public void setIasRgnCd(String iasRgnCd) {
		this.iasRgnCd = iasRgnCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEurFlg(JSPUtil.getParameter(request, "eur_flg", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setVslLaneTpCd(JSPUtil.getParameter(request, "vsl_lane_tp_cd", ""));
		setTrnsPcfFlg(JSPUtil.getParameter(request, "trns_pcf_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSubTrdDesc(JSPUtil.getParameter(request, "sub_trd_desc", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setTrnkIptFlg(JSPUtil.getParameter(request, "trnk_ipt_flg", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLodSplCngFlg(JSPUtil.getParameter(request, "lod_spl_cng_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setPctlLaneChkFlg(JSPUtil.getParameter(request, "pctl_lane_chk_flg", ""));
		setOpLaneTpCd(JSPUtil.getParameter(request, "op_lane_tp_cd", ""));
		setStupFlg(JSPUtil.getParameter(request, "stup_flg", ""));
		setIntrAsiaFlg(JSPUtil.getParameter(request, "intr_asia_flg", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setSctrPrcFlg(JSPUtil.getParameter(request, "sctr_prc_flg", ""));
		setLaneTpHisFlg(JSPUtil.getParameter(request, "lane_tp_his_flg", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setTrnsAtlanFlg(JSPUtil.getParameter(request, "trns_atlan_flg", ""));
		setRvsBndFlg(JSPUtil.getParameter(request, "rvs_bnd_flg", ""));
		setMktRtFlg(JSPUtil.getParameter(request, "mkt_rt_flg", ""));
		setHulBndCd(JSPUtil.getParameter(request, "hul_bnd_cd", ""));
		setIasRgnCd(JSPUtil.getParameter(request, "ias_rgn_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRgstLaneListVO[]
	 */
	public SearchRgstLaneListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRgstLaneListVO[]
	 */
	public SearchRgstLaneListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRgstLaneListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eurFlg = (JSPUtil.getParameter(request, prefix	+ "eur_flg", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] vslLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_tp_cd", length));
			String[] trnsPcfFlg = (JSPUtil.getParameter(request, prefix	+ "trns_pcf_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] subTrdDesc = (JSPUtil.getParameter(request, prefix	+ "sub_trd_desc", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] trnkIptFlg = (JSPUtil.getParameter(request, prefix	+ "trnk_ipt_flg", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lodSplCngFlg = (JSPUtil.getParameter(request, prefix	+ "lod_spl_cng_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] pctlLaneChkFlg = (JSPUtil.getParameter(request, prefix	+ "pctl_lane_chk_flg", length));
			String[] opLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "op_lane_tp_cd", length));
			String[] stupFlg = (JSPUtil.getParameter(request, prefix	+ "stup_flg", length));
			String[] intrAsiaFlg = (JSPUtil.getParameter(request, prefix	+ "intr_asia_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] sctrPrcFlg = (JSPUtil.getParameter(request, prefix	+ "sctr_prc_flg", length));
			String[] laneTpHisFlg = (JSPUtil.getParameter(request, prefix	+ "lane_tp_his_flg", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] trnsAtlanFlg = (JSPUtil.getParameter(request, prefix	+ "trns_atlan_flg", length));
			String[] rvsBndFlg = (JSPUtil.getParameter(request, prefix	+ "rvs_bnd_flg", length));
			String[] mktRtFlg = (JSPUtil.getParameter(request, prefix	+ "mkt_rt_flg", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] iasRgnCd = (JSPUtil.getParameter(request, prefix	+ "ias_rgn_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRgstLaneListVO();
				if (eurFlg[i] != null)
					model.setEurFlg(eurFlg[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (vslLaneTpCd[i] != null)
					model.setVslLaneTpCd(vslLaneTpCd[i]);
				if (trnsPcfFlg[i] != null)
					model.setTrnsPcfFlg(trnsPcfFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (subTrdDesc[i] != null)
					model.setSubTrdDesc(subTrdDesc[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (trnkIptFlg[i] != null)
					model.setTrnkIptFlg(trnkIptFlg[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lodSplCngFlg[i] != null)
					model.setLodSplCngFlg(lodSplCngFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (pctlLaneChkFlg[i] != null)
					model.setPctlLaneChkFlg(pctlLaneChkFlg[i]);
				if (opLaneTpCd[i] != null)
					model.setOpLaneTpCd(opLaneTpCd[i]);
				if (stupFlg[i] != null)
					model.setStupFlg(stupFlg[i]);
				if (intrAsiaFlg[i] != null)
					model.setIntrAsiaFlg(intrAsiaFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (sctrPrcFlg[i] != null)
					model.setSctrPrcFlg(sctrPrcFlg[i]);
				if (laneTpHisFlg[i] != null)
					model.setLaneTpHisFlg(laneTpHisFlg[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (trnsAtlanFlg[i] != null)
					model.setTrnsAtlanFlg(trnsAtlanFlg[i]);
				if (rvsBndFlg[i] != null) 
					model.setRvsBndFlg(rvsBndFlg[i]);
				if (mktRtFlg[i] != null)
					model.setMktRtFlg(mktRtFlg[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (iasRgnCd[i] != null)
					model.setIasRgnCd(iasRgnCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRgstLaneListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRgstLaneListVO[]
	 */
	public SearchRgstLaneListVO[] getSearchRgstLaneListVOs(){
		SearchRgstLaneListVO[] vos = (SearchRgstLaneListVO[])models.toArray(new SearchRgstLaneListVO[models.size()]);
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
		this.eurFlg = this.eurFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneTpCd = this.vslLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsPcfFlg = this.trnsPcfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdDesc = this.subTrdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkIptFlg = this.trnkIptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodSplCngFlg = this.lodSplCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlLaneChkFlg = this.pctlLaneChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opLaneTpCd = this.opLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stupFlg = this.stupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intrAsiaFlg = this.intrAsiaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctrPrcFlg = this.sctrPrcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneTpHisFlg = this.laneTpHisFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsAtlanFlg = this.trnsAtlanFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsBndFlg = this.rvsBndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mktRtFlg = this.mktRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasRgnCd = this.iasRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
