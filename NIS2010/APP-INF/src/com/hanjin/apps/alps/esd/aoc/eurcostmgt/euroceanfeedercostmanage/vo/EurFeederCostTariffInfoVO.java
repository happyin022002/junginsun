/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurFeederCostTariffInfoVO.java
*@FileTitle : EurFeederCostTariffInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.04  
* 1.0 Creation
*
* History
* 2015.02.03 전지예 [CHM-201533794] [AOC] 45' Cost 추가
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo;

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

public class EurFeederCostTariffInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurFeederCostTariffInfoVO> models = new ArrayList<EurFeederCostTariffInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String costTrfStsNm = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String cntr45ftCrteWgt = null;
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
	private String updUsrId = null;
	/* Column Info */
	private String cntr20ftCrteWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EurFeederCostTariffInfoVO() {}

	public EurFeederCostTariffInfoVO(String ibflag, String pagerows, String costTrfStsCd, String costTrfStsNm, String currCd, String effFmDt, String updDt, String updUsrId, String nextTrfFlg, String rhqCd, String cntr45ftCrteWgt, String cntr40ftCrteWgt, String cntr20ftCrteWgt) {
		this.updDt = updDt;
		this.currCd = currCd;
		this.costTrfStsNm = costTrfStsNm;
		this.rhqCd = rhqCd;
		this.cntr45ftCrteWgt = cntr45ftCrteWgt;
		this.nextTrfFlg = nextTrfFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntr40ftCrteWgt = cntr40ftCrteWgt;
		this.costTrfStsCd = costTrfStsCd;
		this.effFmDt = effFmDt;
		this.updUsrId = updUsrId;
		this.cntr20ftCrteWgt = cntr20ftCrteWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cost_trf_sts_nm", getCostTrfStsNm());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cntr_45ft_crte_wgt", getCntr45ftCrteWgt());
		this.hashColumns.put("next_trf_flg", getNextTrfFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_40ft_crte_wgt", getCntr40ftCrteWgt());
		this.hashColumns.put("cost_trf_sts_cd", getCostTrfStsCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
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
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cost_trf_sts_nm", "costTrfStsNm");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cntr_45ft_crte_wgt", "cntr45ftCrteWgt");
		this.hashFields.put("next_trf_flg", "nextTrfFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_40ft_crte_wgt", "cntr40ftCrteWgt");
		this.hashFields.put("cost_trf_sts_cd", "costTrfStsCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCostTrfStsNm(JSPUtil.getParameter(request, prefix + "cost_trf_sts_nm", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCntr45ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_45ft_crte_wgt", ""));
		setNextTrfFlg(JSPUtil.getParameter(request, prefix + "next_trf_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntr40ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_40ft_crte_wgt", ""));
		setCostTrfStsCd(JSPUtil.getParameter(request, prefix + "cost_trf_sts_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntr20ftCrteWgt(JSPUtil.getParameter(request, prefix + "cntr_20ft_crte_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurFeederCostTariffInfoVO[]
	 */
	public EurFeederCostTariffInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurFeederCostTariffInfoVO[]
	 */
	public EurFeederCostTariffInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurFeederCostTariffInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] costTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_nm", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] cntr45ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_crte_wgt", length));
			String[] nextTrfFlg = (JSPUtil.getParameter(request, prefix	+ "next_trf_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntr40ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_crte_wgt", length));
			String[] costTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntr20ftCrteWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_crte_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurFeederCostTariffInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (costTrfStsNm[i] != null)
					model.setCostTrfStsNm(costTrfStsNm[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (cntr45ftCrteWgt[i] != null)
					model.setCntr45ftCrteWgt(cntr45ftCrteWgt[i]);
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
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntr20ftCrteWgt[i] != null)
					model.setCntr20ftCrteWgt(cntr20ftCrteWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurFeederCostTariffInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurFeederCostTariffInfoVO[]
	 */
	public EurFeederCostTariffInfoVO[] getEurFeederCostTariffInfoVOs(){
		EurFeederCostTariffInfoVO[] vos = (EurFeederCostTariffInfoVO[])models.toArray(new EurFeederCostTariffInfoVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsNm = this.costTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftCrteWgt = this.cntr45ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextTrfFlg = this.nextTrfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftCrteWgt = this.cntr40ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsCd = this.costTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftCrteWgt = this.cntr20ftCrteWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
