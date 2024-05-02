/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurInlandCostTariffInfoVO.java
*@FileTitle : EurInlandCostTariffInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.26  
* 1.0 Creation
* 
* History
* 2015.02.03 CHM-201533794 전지예 [AOC] 45' Cost 추가
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurInlandCostTariffInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurInlandCostTariffInfoVO> models = new ArrayList<EurInlandCostTariffInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntr45ftCrteWgt = null;
	/* Column Info */
	private String costTrfStsNm = null;
	/* Column Info */
	private String currcd = null;
	/* Column Info */
	private String avgCnt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String nextTrfFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntr40ftCrteWgt = null;
	/* Column Info */
	private String costTrfStsCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String ioBndNm = null;
	/* Column Info */
	private String costTrfBatSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntr20ftCrteWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EurInlandCostTariffInfoVO() {}

	public EurInlandCostTariffInfoVO(String ibflag, String pagerows, String ioBndCd, String ioBndNm, String costTrfStsCd, String costTrfStsNm, String effFmDt, String updDt, String updUsrId, String nextTrfFlg, String costTrfBatSeq, String avgCnt, String cntr40ftCrteWgt, String cntr20ftCrteWgt, String cntr45ftCrteWgt, String currcd) {
		this.updDt = updDt;
		this.cntr45ftCrteWgt = cntr45ftCrteWgt;
		this.costTrfStsNm = costTrfStsNm;
		this.currcd = currcd;
		this.avgCnt = avgCnt;
		this.ioBndCd = ioBndCd;
		this.nextTrfFlg = nextTrfFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntr40ftCrteWgt = cntr40ftCrteWgt;
		this.costTrfStsCd = costTrfStsCd;
		this.effFmDt = effFmDt;
		this.ioBndNm = ioBndNm;
		this.costTrfBatSeq = costTrfBatSeq;
		this.updUsrId = updUsrId;
		this.cntr20ftCrteWgt = cntr20ftCrteWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntr_45ft_crte_wgt", getCntr45ftCrteWgt());
		this.hashColumns.put("cost_trf_sts_nm", getCostTrfStsNm());
		this.hashColumns.put("currcd", getCurrcd());
		this.hashColumns.put("avg_cnt", getAvgCnt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("next_trf_flg", getNextTrfFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_40ft_crte_wgt", getCntr40ftCrteWgt());
		this.hashColumns.put("cost_trf_sts_cd", getCostTrfStsCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("io_bnd_nm", getIoBndNm());
		this.hashColumns.put("cost_trf_bat_seq", getCostTrfBatSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_20ft_crte_wgt", getCntr20ftCrteWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntr_45ft_crte_wgt", "cntr45ftCrteWgt");
		this.hashFields.put("cost_trf_sts_nm", "costTrfStsNm");
		this.hashFields.put("currcd", "currcd");
		this.hashFields.put("avg_cnt", "avgCnt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("next_trf_flg", "nextTrfFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_40ft_crte_wgt", "cntr40ftCrteWgt");
		this.hashFields.put("cost_trf_sts_cd", "costTrfStsCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("io_bnd_nm", "ioBndNm");
		this.hashFields.put("cost_trf_bat_seq", "costTrfBatSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_20ft_crte_wgt", "cntr20ftCrteWgt");
		return this.hashFields;
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
	 * @return cntr45ftCrteWgt
	 */
	public String getCntr45ftCrteWgt() {
		return this.cntr45ftCrteWgt;
	}
	
	/**
	 * Column Info
	 * @return costTrfStsNm
	 */
	public String getCostTrfStsNm() {
		return this.costTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @return currcd
	 */
	public String getCurrcd() {
		return this.currcd;
	}
	
	/**
	 * Column Info
	 * @return avgCnt
	 */
	public String getAvgCnt() {
		return this.avgCnt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return nextTrfFlg
	 */
	public String getNextTrfFlg() {
		return this.nextTrfFlg;
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
	 * @return cntr40ftCrteWgt
	 */
	public String getCntr40ftCrteWgt() {
		return this.cntr40ftCrteWgt;
	}
	
	/**
	 * Column Info
	 * @return costTrfStsCd
	 */
	public String getCostTrfStsCd() {
		return this.costTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return ioBndNm
	 */
	public String getIoBndNm() {
		return this.ioBndNm;
	}
	
	/**
	 * Column Info
	 * @return costTrfBatSeq
	 */
	public String getCostTrfBatSeq() {
		return this.costTrfBatSeq;
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
	 * @return cntr20ftCrteWgt
	 */
	public String getCntr20ftCrteWgt() {
		return this.cntr20ftCrteWgt;
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
	 * @param cntr45ftCrteWgt
	 */
	public void setCntr45ftCrteWgt(String cntr45ftCrteWgt) {
		this.cntr45ftCrteWgt = cntr45ftCrteWgt;
	}
	
	/**
	 * Column Info
	 * @param costTrfStsNm
	 */
	public void setCostTrfStsNm(String costTrfStsNm) {
		this.costTrfStsNm = costTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @param currcd
	 */
	public void setCurrcd(String currcd) {
		this.currcd = currcd;
	}
	
	/**
	 * Column Info
	 * @param avgCnt
	 */
	public void setAvgCnt(String avgCnt) {
		this.avgCnt = avgCnt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param nextTrfFlg
	 */
	public void setNextTrfFlg(String nextTrfFlg) {
		this.nextTrfFlg = nextTrfFlg;
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
	 * @param cntr40ftCrteWgt
	 */
	public void setCntr40ftCrteWgt(String cntr40ftCrteWgt) {
		this.cntr40ftCrteWgt = cntr40ftCrteWgt;
	}
	
	/**
	 * Column Info
	 * @param costTrfStsCd
	 */
	public void setCostTrfStsCd(String costTrfStsCd) {
		this.costTrfStsCd = costTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param ioBndNm
	 */
	public void setIoBndNm(String ioBndNm) {
		this.ioBndNm = ioBndNm;
	}
	
	/**
	 * Column Info
	 * @param costTrfBatSeq
	 */
	public void setCostTrfBatSeq(String costTrfBatSeq) {
		this.costTrfBatSeq = costTrfBatSeq;
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
	 * @param cntr20ftCrteWgt
	 */
	public void setCntr20ftCrteWgt(String cntr20ftCrteWgt) {
		this.cntr20ftCrteWgt = cntr20ftCrteWgt;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCntr45ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_45ft_crte_wgt", ""));
		setCostTrfStsNm(JSPUtil.getParameter(request, prefix + "cost_trf_sts_nm", ""));
		setCurrcd(JSPUtil.getParameter(request, prefix + "currcd", ""));
		setAvgCnt(JSPUtil.getParameter(request, prefix + "avg_cnt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setNextTrfFlg(JSPUtil.getParameter(request, prefix + "next_trf_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntr40ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_40ft_crte_wgt", ""));
		setCostTrfStsCd(JSPUtil.getParameter(request, prefix + "cost_trf_sts_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setIoBndNm(JSPUtil.getParameter(request, prefix + "io_bnd_nm", ""));
		setCostTrfBatSeq(JSPUtil.getParameter(request, prefix + "cost_trf_bat_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntr20ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_20ft_crte_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurInlandCostTariffInfoVO[]
	 */
	public EurInlandCostTariffInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurInlandCostTariffInfoVO[]
	 */
	public EurInlandCostTariffInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurInlandCostTariffInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntr45ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_crte_wgt", length));
			String[] costTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_nm", length));
			String[] currcd = (JSPUtil.getParameter(request, prefix	+ "currcd", length));
			String[] avgCnt = (JSPUtil.getParameter(request, prefix	+ "avg_cnt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] nextTrfFlg = (JSPUtil.getParameter(request, prefix	+ "next_trf_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntr40ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_crte_wgt", length));
			String[] costTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] ioBndNm = (JSPUtil.getParameter(request, prefix	+ "io_bnd_nm", length));
			String[] costTrfBatSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_bat_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntr20ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_crte_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurInlandCostTariffInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntr45ftCrteWgt[i] != null)
					model.setCntr45ftCrteWgt(cntr45ftCrteWgt[i]);
				if (costTrfStsNm[i] != null)
					model.setCostTrfStsNm(costTrfStsNm[i]);
				if (currcd[i] != null)
					model.setCurrcd(currcd[i]);
				if (avgCnt[i] != null)
					model.setAvgCnt(avgCnt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (nextTrfFlg[i] != null)
					model.setNextTrfFlg(nextTrfFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntr40ftCrteWgt[i] != null)
					model.setCntr40ftCrteWgt(cntr40ftCrteWgt[i]);
				if (costTrfStsCd[i] != null)
					model.setCostTrfStsCd(costTrfStsCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (ioBndNm[i] != null)
					model.setIoBndNm(ioBndNm[i]);
				if (costTrfBatSeq[i] != null)
					model.setCostTrfBatSeq(costTrfBatSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntr20ftCrteWgt[i] != null)
					model.setCntr20ftCrteWgt(cntr20ftCrteWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurInlandCostTariffInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurInlandCostTariffInfoVO[]
	 */
	public EurInlandCostTariffInfoVO[] getEurInlandCostTariffInfoVOs(){
		EurInlandCostTariffInfoVO[] vos = (EurInlandCostTariffInfoVO[])models.toArray(new EurInlandCostTariffInfoVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftCrteWgt = this.cntr45ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsNm = this.costTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currcd = this.currcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgCnt = this.avgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextTrfFlg = this.nextTrfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftCrteWgt = this.cntr40ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsCd = this.costTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndNm = this.ioBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfBatSeq = this.costTrfBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftCrteWgt = this.cntr20ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
