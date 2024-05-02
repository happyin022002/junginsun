/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SearchAgrdNtwkCostRtoInquiryVO.java
*@FileTitle : SearchAgrdNtwkCostRtoInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.26 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAgrdNtwkCostRtoInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAgrdNtwkCostRtoInquiryVO> models = new ArrayList<SearchAgrdNtwkCostRtoInquiryVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovrUsdAlocChgFlg = null;
	/* Column Info */
	private String costYrmonSeq = null;
	/* Column Info */
	private String fmIocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grpSeq = null;
	/* Column Info */
	private String fmDirCd = null;
	/* Column Info */
	private String fmLaneCd = null;
	/* Column Info */
	private String fmTrdCd = null;
	/* Column Info */
	private String loclTsStsCd = null;
	/* Column Info */
	private String bzcAlocTpCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String fmHulBndCd = null;
	/* Column Info */
	private String bzcAlocFxAmt = null;
	/* Column Info */
	private String toIocCd = null;
	/* Column Info */
	private String toHulBndCd = null;
	/* Column Info */
	private String bzcAlocRto = null;
	/* Column Info */
	private String toTrdCd = null;
	/* Column Info */
	private String ovrUsdAlocChgRto = null;
	/* Column Info */
	private String toLaneCd = null;
	/* Column Info */
	private String toDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAgrdNtwkCostRtoInquiryVO() {}

	public SearchAgrdNtwkCostRtoInquiryVO(String ibflag, String pagerows, String costYrmon, String grpSeq, String costYrmonSeq, String fmTrdCd, String fmLaneCd, String fmIocCd, String fmHulBndCd, String fmDirCd, String toTrdCd, String toLaneCd, String toIocCd, String toHulBndCd, String toDirCd, String loclTsStsCd, String bzcAlocTpCd, String bzcAlocRto, String bzcAlocFxAmt, String ovrUsdAlocChgFlg, String ovrUsdAlocChgRto) {
		this.pagerows = pagerows;
		this.ovrUsdAlocChgFlg = ovrUsdAlocChgFlg;
		this.costYrmonSeq = costYrmonSeq;
		this.fmIocCd = fmIocCd;
		this.ibflag = ibflag;
		this.grpSeq = grpSeq;
		this.fmDirCd = fmDirCd;
		this.fmLaneCd = fmLaneCd;
		this.fmTrdCd = fmTrdCd;
		this.loclTsStsCd = loclTsStsCd;
		this.bzcAlocTpCd = bzcAlocTpCd;
		this.costYrmon = costYrmon;
		this.fmHulBndCd = fmHulBndCd;
		this.bzcAlocFxAmt = bzcAlocFxAmt;
		this.toIocCd = toIocCd;
		this.toHulBndCd = toHulBndCd;
		this.bzcAlocRto = bzcAlocRto;
		this.toTrdCd = toTrdCd;
		this.ovrUsdAlocChgRto = ovrUsdAlocChgRto;
		this.toLaneCd = toLaneCd;
		this.toDirCd = toDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovr_usd_aloc_chg_flg", getOvrUsdAlocChgFlg());
		this.hashColumns.put("cost_yrmon_seq", getCostYrmonSeq());
		this.hashColumns.put("fm_ioc_cd", getFmIocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp_seq", getGrpSeq());
		this.hashColumns.put("fm_dir_cd", getFmDirCd());
		this.hashColumns.put("fm_lane_cd", getFmLaneCd());
		this.hashColumns.put("fm_trd_cd", getFmTrdCd());
		this.hashColumns.put("locl_ts_sts_cd", getLoclTsStsCd());
		this.hashColumns.put("bzc_aloc_tp_cd", getBzcAlocTpCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("fm_hul_bnd_cd", getFmHulBndCd());
		this.hashColumns.put("bzc_aloc_fx_amt", getBzcAlocFxAmt());
		this.hashColumns.put("to_ioc_cd", getToIocCd());
		this.hashColumns.put("to_hul_bnd_cd", getToHulBndCd());
		this.hashColumns.put("bzc_aloc_rto", getBzcAlocRto());
		this.hashColumns.put("to_trd_cd", getToTrdCd());
		this.hashColumns.put("ovr_usd_aloc_chg_rto", getOvrUsdAlocChgRto());
		this.hashColumns.put("to_lane_cd", getToLaneCd());
		this.hashColumns.put("to_dir_cd", getToDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovr_usd_aloc_chg_flg", "ovrUsdAlocChgFlg");
		this.hashFields.put("cost_yrmon_seq", "costYrmonSeq");
		this.hashFields.put("fm_ioc_cd", "fmIocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp_seq", "grpSeq");
		this.hashFields.put("fm_dir_cd", "fmDirCd");
		this.hashFields.put("fm_lane_cd", "fmLaneCd");
		this.hashFields.put("fm_trd_cd", "fmTrdCd");
		this.hashFields.put("locl_ts_sts_cd", "loclTsStsCd");
		this.hashFields.put("bzc_aloc_tp_cd", "bzcAlocTpCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("fm_hul_bnd_cd", "fmHulBndCd");
		this.hashFields.put("bzc_aloc_fx_amt", "bzcAlocFxAmt");
		this.hashFields.put("to_ioc_cd", "toIocCd");
		this.hashFields.put("to_hul_bnd_cd", "toHulBndCd");
		this.hashFields.put("bzc_aloc_rto", "bzcAlocRto");
		this.hashFields.put("to_trd_cd", "toTrdCd");
		this.hashFields.put("ovr_usd_aloc_chg_rto", "ovrUsdAlocChgRto");
		this.hashFields.put("to_lane_cd", "toLaneCd");
		this.hashFields.put("to_dir_cd", "toDirCd");
		return this.hashFields;
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
	 * @return ovrUsdAlocChgFlg
	 */
	public String getOvrUsdAlocChgFlg() {
		return this.ovrUsdAlocChgFlg;
	}
	
	/**
	 * Column Info
	 * @return costYrmonSeq
	 */
	public String getCostYrmonSeq() {
		return this.costYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @return fmIocCd
	 */
	public String getFmIocCd() {
		return this.fmIocCd;
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
	 * @return grpSeq
	 */
	public String getGrpSeq() {
		return this.grpSeq;
	}
	
	/**
	 * Column Info
	 * @return fmDirCd
	 */
	public String getFmDirCd() {
		return this.fmDirCd;
	}
	
	/**
	 * Column Info
	 * @return fmLaneCd
	 */
	public String getFmLaneCd() {
		return this.fmLaneCd;
	}
	
	/**
	 * Column Info
	 * @return fmTrdCd
	 */
	public String getFmTrdCd() {
		return this.fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @return loclTsStsCd
	 */
	public String getLoclTsStsCd() {
		return this.loclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @return bzcAlocTpCd
	 */
	public String getBzcAlocTpCd() {
		return this.bzcAlocTpCd;
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
	 * @return fmHulBndCd
	 */
	public String getFmHulBndCd() {
		return this.fmHulBndCd;
	}
	
	/**
	 * Column Info
	 * @return bzcAlocFxAmt
	 */
	public String getBzcAlocFxAmt() {
		return this.bzcAlocFxAmt;
	}
	
	/**
	 * Column Info
	 * @return toIocCd
	 */
	public String getToIocCd() {
		return this.toIocCd;
	}
	
	/**
	 * Column Info
	 * @return toHulBndCd
	 */
	public String getToHulBndCd() {
		return this.toHulBndCd;
	}
	
	/**
	 * Column Info
	 * @return bzcAlocRto
	 */
	public String getBzcAlocRto() {
		return this.bzcAlocRto;
	}
	
	/**
	 * Column Info
	 * @return toTrdCd
	 */
	public String getToTrdCd() {
		return this.toTrdCd;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdAlocChgRto
	 */
	public String getOvrUsdAlocChgRto() {
		return this.ovrUsdAlocChgRto;
	}
	
	/**
	 * Column Info
	 * @return toLaneCd
	 */
	public String getToLaneCd() {
		return this.toLaneCd;
	}
	
	/**
	 * Column Info
	 * @return toDirCd
	 */
	public String getToDirCd() {
		return this.toDirCd;
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
	 * @param ovrUsdAlocChgFlg
	 */
	public void setOvrUsdAlocChgFlg(String ovrUsdAlocChgFlg) {
		this.ovrUsdAlocChgFlg = ovrUsdAlocChgFlg;
	}
	
	/**
	 * Column Info
	 * @param costYrmonSeq
	 */
	public void setCostYrmonSeq(String costYrmonSeq) {
		this.costYrmonSeq = costYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @param fmIocCd
	 */
	public void setFmIocCd(String fmIocCd) {
		this.fmIocCd = fmIocCd;
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
	 * @param grpSeq
	 */
	public void setGrpSeq(String grpSeq) {
		this.grpSeq = grpSeq;
	}
	
	/**
	 * Column Info
	 * @param fmDirCd
	 */
	public void setFmDirCd(String fmDirCd) {
		this.fmDirCd = fmDirCd;
	}
	
	/**
	 * Column Info
	 * @param fmLaneCd
	 */
	public void setFmLaneCd(String fmLaneCd) {
		this.fmLaneCd = fmLaneCd;
	}
	
	/**
	 * Column Info
	 * @param fmTrdCd
	 */
	public void setFmTrdCd(String fmTrdCd) {
		this.fmTrdCd = fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @param loclTsStsCd
	 */
	public void setLoclTsStsCd(String loclTsStsCd) {
		this.loclTsStsCd = loclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @param bzcAlocTpCd
	 */
	public void setBzcAlocTpCd(String bzcAlocTpCd) {
		this.bzcAlocTpCd = bzcAlocTpCd;
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
	 * @param fmHulBndCd
	 */
	public void setFmHulBndCd(String fmHulBndCd) {
		this.fmHulBndCd = fmHulBndCd;
	}
	
	/**
	 * Column Info
	 * @param bzcAlocFxAmt
	 */
	public void setBzcAlocFxAmt(String bzcAlocFxAmt) {
		this.bzcAlocFxAmt = bzcAlocFxAmt;
	}
	
	/**
	 * Column Info
	 * @param toIocCd
	 */
	public void setToIocCd(String toIocCd) {
		this.toIocCd = toIocCd;
	}
	
	/**
	 * Column Info
	 * @param toHulBndCd
	 */
	public void setToHulBndCd(String toHulBndCd) {
		this.toHulBndCd = toHulBndCd;
	}
	
	/**
	 * Column Info
	 * @param bzcAlocRto
	 */
	public void setBzcAlocRto(String bzcAlocRto) {
		this.bzcAlocRto = bzcAlocRto;
	}
	
	/**
	 * Column Info
	 * @param toTrdCd
	 */
	public void setToTrdCd(String toTrdCd) {
		this.toTrdCd = toTrdCd;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdAlocChgRto
	 */
	public void setOvrUsdAlocChgRto(String ovrUsdAlocChgRto) {
		this.ovrUsdAlocChgRto = ovrUsdAlocChgRto;
	}
	
	/**
	 * Column Info
	 * @param toLaneCd
	 */
	public void setToLaneCd(String toLaneCd) {
		this.toLaneCd = toLaneCd;
	}
	
	/**
	 * Column Info
	 * @param toDirCd
	 */
	public void setToDirCd(String toDirCd) {
		this.toDirCd = toDirCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOvrUsdAlocChgFlg(JSPUtil.getParameter(request, prefix + "ovr_usd_aloc_chg_flg", ""));
		setCostYrmonSeq(JSPUtil.getParameter(request, prefix + "cost_yrmon_seq", ""));
		setFmIocCd(JSPUtil.getParameter(request, prefix + "fm_ioc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGrpSeq(JSPUtil.getParameter(request, prefix + "grp_seq", ""));
		setFmDirCd(JSPUtil.getParameter(request, prefix + "fm_dir_cd", ""));
		setFmLaneCd(JSPUtil.getParameter(request, prefix + "fm_lane_cd", ""));
		setFmTrdCd(JSPUtil.getParameter(request, prefix + "fm_trd_cd", ""));
		setLoclTsStsCd(JSPUtil.getParameter(request, prefix + "locl_ts_sts_cd", ""));
		setBzcAlocTpCd(JSPUtil.getParameter(request, prefix + "bzc_aloc_tp_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFmHulBndCd(JSPUtil.getParameter(request, prefix + "fm_hul_bnd_cd", ""));
		setBzcAlocFxAmt(JSPUtil.getParameter(request, prefix + "bzc_aloc_fx_amt", ""));
		setToIocCd(JSPUtil.getParameter(request, prefix + "to_ioc_cd", ""));
		setToHulBndCd(JSPUtil.getParameter(request, prefix + "to_hul_bnd_cd", ""));
		setBzcAlocRto(JSPUtil.getParameter(request, prefix + "bzc_aloc_rto", ""));
		setToTrdCd(JSPUtil.getParameter(request, prefix + "to_trd_cd", ""));
		setOvrUsdAlocChgRto(JSPUtil.getParameter(request, prefix + "ovr_usd_aloc_chg_rto", ""));
		setToLaneCd(JSPUtil.getParameter(request, prefix + "to_lane_cd", ""));
		setToDirCd(JSPUtil.getParameter(request, prefix + "to_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAgrdNtwkCostRtoInquiryVO[]
	 */
	public SearchAgrdNtwkCostRtoInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAgrdNtwkCostRtoInquiryVO[]
	 */
	public SearchAgrdNtwkCostRtoInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAgrdNtwkCostRtoInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovrUsdAlocChgFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_aloc_chg_flg", length));
			String[] costYrmonSeq = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon_seq", length));
			String[] fmIocCd = (JSPUtil.getParameter(request, prefix	+ "fm_ioc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grpSeq = (JSPUtil.getParameter(request, prefix	+ "grp_seq", length));
			String[] fmDirCd = (JSPUtil.getParameter(request, prefix	+ "fm_dir_cd", length));
			String[] fmLaneCd = (JSPUtil.getParameter(request, prefix	+ "fm_lane_cd", length));
			String[] fmTrdCd = (JSPUtil.getParameter(request, prefix	+ "fm_trd_cd", length));
			String[] loclTsStsCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_sts_cd", length));
			String[] bzcAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bzc_aloc_tp_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] fmHulBndCd = (JSPUtil.getParameter(request, prefix	+ "fm_hul_bnd_cd", length));
			String[] bzcAlocFxAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_aloc_fx_amt", length));
			String[] toIocCd = (JSPUtil.getParameter(request, prefix	+ "to_ioc_cd", length));
			String[] toHulBndCd = (JSPUtil.getParameter(request, prefix	+ "to_hul_bnd_cd", length));
			String[] bzcAlocRto = (JSPUtil.getParameter(request, prefix	+ "bzc_aloc_rto", length));
			String[] toTrdCd = (JSPUtil.getParameter(request, prefix	+ "to_trd_cd", length));
			String[] ovrUsdAlocChgRto = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_aloc_chg_rto", length));
			String[] toLaneCd = (JSPUtil.getParameter(request, prefix	+ "to_lane_cd", length));
			String[] toDirCd = (JSPUtil.getParameter(request, prefix	+ "to_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAgrdNtwkCostRtoInquiryVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovrUsdAlocChgFlg[i] != null)
					model.setOvrUsdAlocChgFlg(ovrUsdAlocChgFlg[i]);
				if (costYrmonSeq[i] != null)
					model.setCostYrmonSeq(costYrmonSeq[i]);
				if (fmIocCd[i] != null)
					model.setFmIocCd(fmIocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grpSeq[i] != null)
					model.setGrpSeq(grpSeq[i]);
				if (fmDirCd[i] != null)
					model.setFmDirCd(fmDirCd[i]);
				if (fmLaneCd[i] != null)
					model.setFmLaneCd(fmLaneCd[i]);
				if (fmTrdCd[i] != null)
					model.setFmTrdCd(fmTrdCd[i]);
				if (loclTsStsCd[i] != null)
					model.setLoclTsStsCd(loclTsStsCd[i]);
				if (bzcAlocTpCd[i] != null)
					model.setBzcAlocTpCd(bzcAlocTpCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (fmHulBndCd[i] != null)
					model.setFmHulBndCd(fmHulBndCd[i]);
				if (bzcAlocFxAmt[i] != null)
					model.setBzcAlocFxAmt(bzcAlocFxAmt[i]);
				if (toIocCd[i] != null)
					model.setToIocCd(toIocCd[i]);
				if (toHulBndCd[i] != null)
					model.setToHulBndCd(toHulBndCd[i]);
				if (bzcAlocRto[i] != null)
					model.setBzcAlocRto(bzcAlocRto[i]);
				if (toTrdCd[i] != null)
					model.setToTrdCd(toTrdCd[i]);
				if (ovrUsdAlocChgRto[i] != null)
					model.setOvrUsdAlocChgRto(ovrUsdAlocChgRto[i]);
				if (toLaneCd[i] != null)
					model.setToLaneCd(toLaneCd[i]);
				if (toDirCd[i] != null)
					model.setToDirCd(toDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAgrdNtwkCostRtoInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAgrdNtwkCostRtoInquiryVO[]
	 */
	public SearchAgrdNtwkCostRtoInquiryVO[] getSearchAgrdNtwkCostRtoInquiryVOs(){
		SearchAgrdNtwkCostRtoInquiryVO[] vos = (SearchAgrdNtwkCostRtoInquiryVO[])models.toArray(new SearchAgrdNtwkCostRtoInquiryVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdAlocChgFlg = this.ovrUsdAlocChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmonSeq = this.costYrmonSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIocCd = this.fmIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq = this.grpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDirCd = this.fmDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLaneCd = this.fmLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTrdCd = this.fmTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsStsCd = this.loclTsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAlocTpCd = this.bzcAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmHulBndCd = this.fmHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAlocFxAmt = this.bzcAlocFxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toIocCd = this.toIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toHulBndCd = this.toHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAlocRto = this.bzcAlocRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrdCd = this.toTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdAlocChgRto = this.ovrUsdAlocChgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLaneCd = this.toLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDirCd = this.toDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
