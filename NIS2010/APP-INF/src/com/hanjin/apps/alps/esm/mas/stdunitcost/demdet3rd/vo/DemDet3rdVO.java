/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDet3rdVO.java
*@FileTitle : DemDet3rdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.18
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.06.18 유제량 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.demdet3rd.vo;

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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemDet3rdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemDet3rdVO> models = new ArrayList<DemDet3rdVO>();
	
	/* Column Info */
	private String costAssBseCd = null;
	/* Column Info */
	private String masCostSrcCd = null;
	/* Column Info */
	private String masCostSrcCdNm = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String costAssBseNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlDmdtAmt = null;
	/* Column Info */
	private String ucAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String bkgVolQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DemDet3rdVO() {}

	public DemDet3rdVO(String ibflag, String pagerows, String masCostSrcCdNm, String costAssBseCd, String masCostSrcCd, String stndCostNm, String costAssBseNm, String ttlDmdtAmt, String ucAmt, String creUsrId, String costYrmon, String bkgVolQty, String cntrTpszCd, String updUsrId, String stndCostCd, String trdCd) {
		this.costAssBseCd = costAssBseCd;
		this.masCostSrcCd = masCostSrcCd;
		this.masCostSrcCdNm = masCostSrcCdNm;
		this.trdCd = trdCd;
		this.stndCostNm = stndCostNm;
		this.costAssBseNm = costAssBseNm;
		this.pagerows = pagerows;
		this.ttlDmdtAmt = ttlDmdtAmt;
		this.ucAmt = ucAmt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costYrmon = costYrmon;
		this.bkgVolQty = bkgVolQty;
		this.cntrTpszCd = cntrTpszCd;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_ass_bse_cd", getCostAssBseCd());
		this.hashColumns.put("mas_cost_src_cd", getMasCostSrcCd());
		this.hashColumns.put("mas_cost_src_cd_nm", getMasCostSrcCdNm());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("cost_ass_bse_nm", getCostAssBseNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_dmdt_amt", getTtlDmdtAmt());
		this.hashColumns.put("uc_amt", getUcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("bkg_vol_qty", getBkgVolQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_ass_bse_cd", "costAssBseCd");
		this.hashFields.put("mas_cost_src_cd", "masCostSrcCd");
		this.hashFields.put("mas_cost_src_cd_nm", "masCostSrcCdNm");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("cost_ass_bse_nm", "costAssBseNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_dmdt_amt", "ttlDmdtAmt");
		this.hashFields.put("uc_amt", "ucAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("bkg_vol_qty", "bkgVolQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costAssBseCd
	 */
	public String getCostAssBseCd() {
		return this.costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @return masCostSrcCd
	 */
	public String getMasCostSrcCd() {
		return this.masCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return masCostSrcCdNm
	 */
	public String getMasCostSrcCdNm() {
		return this.masCostSrcCdNm;
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
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return costAssBseNm
	 */
	public String getCostAssBseNm() {
		return this.costAssBseNm;
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
	 * @return ttlDmdtAmt
	 */
	public String getTtlDmdtAmt() {
		return this.ttlDmdtAmt;
	}
	
	/**
	 * Column Info
	 * @return ucAmt
	 */
	public String getUcAmt() {
		return this.ucAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return bkgVolQty
	 */
	public String getBkgVolQty() {
		return this.bkgVolQty;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	

	/**
	 * Column Info
	 * @param costAssBseCd
	 */
	public void setCostAssBseCd(String costAssBseCd) {
		this.costAssBseCd = costAssBseCd;
	}
	
	/**
	 * Column Info
	 * @param masCostSrcCd
	 */
	public void setMasCostSrcCd(String masCostSrcCd) {
		this.masCostSrcCd = masCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param masCostSrcCdNm
	 */
	public void setMasCostSrcCdNm(String masCostSrcCdNm) {
		this.masCostSrcCdNm = masCostSrcCdNm;
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
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param costAssBseNm
	 */
	public void setCostAssBseNm(String costAssBseNm) {
		this.costAssBseNm = costAssBseNm;
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
	 * @param ttlDmdtAmt
	 */
	public void setTtlDmdtAmt(String ttlDmdtAmt) {
		this.ttlDmdtAmt = ttlDmdtAmt;
	}
	
	/**
	 * Column Info
	 * @param ucAmt
	 */
	public void setUcAmt(String ucAmt) {
		this.ucAmt = ucAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param bkgVolQty
	 */
	public void setBkgVolQty(String bkgVolQty) {
		this.bkgVolQty = bkgVolQty;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
		setCostAssBseCd(JSPUtil.getParameter(request, prefix + "cost_ass_bse_cd", ""));
		setMasCostSrcCd(JSPUtil.getParameter(request, prefix + "mas_cost_src_cd", ""));
		setMasCostSrcCdNm(JSPUtil.getParameter(request, prefix + "mas_cost_src_cd_nm", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setCostAssBseNm(JSPUtil.getParameter(request, prefix + "cost_ass_bse_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlDmdtAmt(JSPUtil.getParameter(request, prefix + "ttl_dmdt_amt", ""));
		setUcAmt(JSPUtil.getParameter(request, prefix + "uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setBkgVolQty(JSPUtil.getParameter(request, prefix + "bkg_vol_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemDet3rdVO[]
	 */
	public DemDet3rdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemDet3rdVO[]
	 */
	public DemDet3rdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemDet3rdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costAssBseCd = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_cd", length));
			String[] masCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd", length));
			String[] masCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd_nm", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] costAssBseNm = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlDmdtAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_dmdt_amt", length));
			String[] ucAmt = (JSPUtil.getParameter(request, prefix	+ "uc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] bkgVolQty = (JSPUtil.getParameter(request, prefix	+ "bkg_vol_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemDet3rdVO();
				if (costAssBseCd[i] != null)
					model.setCostAssBseCd(costAssBseCd[i]);
				if (masCostSrcCd[i] != null)
					model.setMasCostSrcCd(masCostSrcCd[i]);
				if (masCostSrcCdNm[i] != null)
					model.setMasCostSrcCdNm(masCostSrcCdNm[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (costAssBseNm[i] != null)
					model.setCostAssBseNm(costAssBseNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlDmdtAmt[i] != null)
					model.setTtlDmdtAmt(ttlDmdtAmt[i]);
				if (ucAmt[i] != null)
					model.setUcAmt(ucAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (bkgVolQty[i] != null)
					model.setBkgVolQty(bkgVolQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemDet3rdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemDet3rdVO[]
	 */
	public DemDet3rdVO[] getDemDet3rdVOs(){
		DemDet3rdVO[] vos = (DemDet3rdVO[])models.toArray(new DemDet3rdVO[models.size()]);
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
		this.costAssBseCd = this.costAssBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcCd = this.masCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcCdNm = this.masCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAssBseNm = this.costAssBseNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDmdtAmt = this.ttlDmdtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucAmt = this.ucAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVolQty = this.bkgVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
