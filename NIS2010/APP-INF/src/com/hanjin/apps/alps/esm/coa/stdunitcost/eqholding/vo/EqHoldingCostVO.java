/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EqHoldingCostVO.java
*@FileTitle : EqHoldingCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.26 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.vo;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqHoldingCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqHoldingCostVO> models = new ArrayList<EqHoldingCostVO>();
	
	/* Column Info */
	private String coaCostSrcCdNm = null;
	/* Column Info */
	private String costAssBseCd = null;
	/* Column Info */
	private String eqBxKnt = null;
	/* Column Info */
	private String ttlHldAmt = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String chssUsaQty = null;
	/* Column Info */
	private String costAssBseNm = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String cntrChssDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String eqHldDys = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String chssHldUcAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EqHoldingCostVO() {}

	public EqHoldingCostVO(String ibflag, String pagerows, String eqTpszCd, String stndCostCd, String stndCostNm, String coaCostSrcCd, String coaCostSrcCdNm, String chssHldUcAmt, String ttlHldAmt, String eqBxKnt, String eqHldDys, String chssUsaQty, String costAssBseCd, String costAssBseNm, String costYrmon, String cntrChssDivCd, String creUsrId, String updUsrId) {
		this.coaCostSrcCdNm = coaCostSrcCdNm;
		this.costAssBseCd = costAssBseCd;
		this.eqBxKnt = eqBxKnt;
		this.ttlHldAmt = ttlHldAmt;
		this.coaCostSrcCd = coaCostSrcCd;
		this.chssUsaQty = chssUsaQty;
		this.costAssBseNm = costAssBseNm;
		this.stndCostNm = stndCostNm;
		this.cntrChssDivCd = cntrChssDivCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.eqHldDys = eqHldDys;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.chssHldUcAmt = chssHldUcAmt;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("coa_cost_src_cd_nm", getCoaCostSrcCdNm());
		this.hashColumns.put("cost_ass_bse_cd", getCostAssBseCd());
		this.hashColumns.put("eq_bx_knt", getEqBxKnt());
		this.hashColumns.put("ttl_hld_amt", getTtlHldAmt());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("chss_usa_qty", getChssUsaQty());
		this.hashColumns.put("cost_ass_bse_nm", getCostAssBseNm());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("cntr_chss_div_cd", getCntrChssDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("eq_hld_dys", getEqHldDys());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("chss_hld_uc_amt", getChssHldUcAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("coa_cost_src_cd_nm", "coaCostSrcCdNm");
		this.hashFields.put("cost_ass_bse_cd", "costAssBseCd");
		this.hashFields.put("eq_bx_knt", "eqBxKnt");
		this.hashFields.put("ttl_hld_amt", "ttlHldAmt");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("chss_usa_qty", "chssUsaQty");
		this.hashFields.put("cost_ass_bse_nm", "costAssBseNm");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("cntr_chss_div_cd", "cntrChssDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("eq_hld_dys", "eqHldDys");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("chss_hld_uc_amt", "chssHldUcAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCdNm
	 */
	public String getCoaCostSrcCdNm() {
		return this.coaCostSrcCdNm;
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
	 * @return eqBxKnt
	 */
	public String getEqBxKnt() {
		return this.eqBxKnt;
	}
	
	/**
	 * Column Info
	 * @return ttlHldAmt
	 */
	public String getTtlHldAmt() {
		return this.ttlHldAmt;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return chssUsaQty
	 */
	public String getChssUsaQty() {
		return this.chssUsaQty;
	}
	
	/**
	 * Column Info
	 * @return costAssBseNm
	 */
	public String getCostAssBseNm() {
		return this.costAssBseNm;
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
	 * @return cntrChssDivCd
	 */
	public String getCntrChssDivCd() {
		return this.cntrChssDivCd;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return eqHldDys
	 */
	public String getEqHldDys() {
		return this.eqHldDys;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return chssHldUcAmt
	 */
	public String getChssHldUcAmt() {
		return this.chssHldUcAmt;
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
	 * @param coaCostSrcCdNm
	 */
	public void setCoaCostSrcCdNm(String coaCostSrcCdNm) {
		this.coaCostSrcCdNm = coaCostSrcCdNm;
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
	 * @param eqBxKnt
	 */
	public void setEqBxKnt(String eqBxKnt) {
		this.eqBxKnt = eqBxKnt;
	}
	
	/**
	 * Column Info
	 * @param ttlHldAmt
	 */
	public void setTtlHldAmt(String ttlHldAmt) {
		this.ttlHldAmt = ttlHldAmt;
	}
	
	/**
	 * Column Info
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param chssUsaQty
	 */
	public void setChssUsaQty(String chssUsaQty) {
		this.chssUsaQty = chssUsaQty;
	}
	
	/**
	 * Column Info
	 * @param costAssBseNm
	 */
	public void setCostAssBseNm(String costAssBseNm) {
		this.costAssBseNm = costAssBseNm;
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
	 * @param cntrChssDivCd
	 */
	public void setCntrChssDivCd(String cntrChssDivCd) {
		this.cntrChssDivCd = cntrChssDivCd;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param eqHldDys
	 */
	public void setEqHldDys(String eqHldDys) {
		this.eqHldDys = eqHldDys;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param chssHldUcAmt
	 */
	public void setChssHldUcAmt(String chssHldUcAmt) {
		this.chssHldUcAmt = chssHldUcAmt;
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
		setCoaCostSrcCdNm(JSPUtil.getParameter(request, "coa_cost_src_cd_nm", ""));
		setCostAssBseCd(JSPUtil.getParameter(request, "cost_ass_bse_cd", ""));
		setEqBxKnt(JSPUtil.getParameter(request, "eq_bx_knt", ""));
		setTtlHldAmt(JSPUtil.getParameter(request, "ttl_hld_amt", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, "coa_cost_src_cd", ""));
		setChssUsaQty(JSPUtil.getParameter(request, "chss_usa_qty", ""));
		setCostAssBseNm(JSPUtil.getParameter(request, "cost_ass_bse_nm", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setCntrChssDivCd(JSPUtil.getParameter(request, "cntr_chss_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setEqHldDys(JSPUtil.getParameter(request, "eq_hld_dys", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setChssHldUcAmt(JSPUtil.getParameter(request, "chss_hld_uc_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqHoldingCostVO[]
	 */
	public EqHoldingCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqHoldingCostVO[]
	 */
	public EqHoldingCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqHoldingCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coaCostSrcCdNm = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd_nm", length));
			String[] costAssBseCd = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_cd", length));
			String[] eqBxKnt = (JSPUtil.getParameter(request, prefix	+ "eq_bx_knt", length));
			String[] ttlHldAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_hld_amt", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] chssUsaQty = (JSPUtil.getParameter(request, prefix	+ "chss_usa_qty", length));
			String[] costAssBseNm = (JSPUtil.getParameter(request, prefix	+ "cost_ass_bse_nm", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] cntrChssDivCd = (JSPUtil.getParameter(request, prefix	+ "cntr_chss_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] eqHldDys = (JSPUtil.getParameter(request, prefix	+ "eq_hld_dys", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] chssHldUcAmt = (JSPUtil.getParameter(request, prefix	+ "chss_hld_uc_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqHoldingCostVO();
				if (coaCostSrcCdNm[i] != null)
					model.setCoaCostSrcCdNm(coaCostSrcCdNm[i]);
				if (costAssBseCd[i] != null)
					model.setCostAssBseCd(costAssBseCd[i]);
				if (eqBxKnt[i] != null)
					model.setEqBxKnt(eqBxKnt[i]);
				if (ttlHldAmt[i] != null)
					model.setTtlHldAmt(ttlHldAmt[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (chssUsaQty[i] != null)
					model.setChssUsaQty(chssUsaQty[i]);
				if (costAssBseNm[i] != null)
					model.setCostAssBseNm(costAssBseNm[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (cntrChssDivCd[i] != null)
					model.setCntrChssDivCd(cntrChssDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (eqHldDys[i] != null)
					model.setEqHldDys(eqHldDys[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (chssHldUcAmt[i] != null)
					model.setChssHldUcAmt(chssHldUcAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqHoldingCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqHoldingCostVO[]
	 */
	public EqHoldingCostVO[] getEqHoldingCostVOs(){
		EqHoldingCostVO[] vos = (EqHoldingCostVO[])models.toArray(new EqHoldingCostVO[models.size()]);
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
		this.coaCostSrcCdNm = this.coaCostSrcCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAssBseCd = this.costAssBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqBxKnt = this.eqBxKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlHldAmt = this.ttlHldAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssUsaQty = this.chssUsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAssBseNm = this.costAssBseNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChssDivCd = this.cntrChssDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqHldDys = this.eqHldDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssHldUcAmt = this.chssHldUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
