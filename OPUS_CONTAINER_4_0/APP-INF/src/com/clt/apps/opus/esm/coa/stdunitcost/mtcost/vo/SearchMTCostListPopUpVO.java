/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMTCostListPopUpVO.java
*@FileTitle : SearchMTCostListPopUpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.10.14 장영석 
* 1.0 Creation
* 2010.02.05 임옥영 품질검토 결과 반영 - 생성자 주석 추가
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo;

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
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMTCostListPopUpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCostListPopUpVO> models = new ArrayList<SearchMTCostListPopUpVO>();
	
	/* Column Info */
	private String trspTtlAmt = null;
	/* Column Info */
	private String frmYard = null;
	/* Column Info */
	private String frmToEcc = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String steveUnitCost = null;
	/* Column Info */
	private String trspUnitCost = null;
	/* Column Info */
	private String totalAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frmToSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String oriDest = null;
	/* Column Info */
	private String steveTtlAmt = null;
	/* Column Info */
	private String mcntrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * SearchMTCostListPopUpVO 생성자
	 */
	public SearchMTCostListPopUpVO() {}
	/**
	 * SearchMTCostListPopUpVO 생성자
	 * @param ibflag
	 * @param pagerows
	 */
	public SearchMTCostListPopUpVO(String ibflag, String pagerows, String eccCd, String oriDest, String frmToEcc, String frmToSeq, String frmYard, String cntrTpszCd, String mcntrQty, String steveTtlAmt, String trspTtlAmt, String totalAmt, String steveUnitCost, String trspUnitCost) {
		this.trspTtlAmt = trspTtlAmt;
		this.frmYard = frmYard;
		this.frmToEcc = frmToEcc;
		this.eccCd = eccCd;
		this.steveUnitCost = steveUnitCost;
		this.trspUnitCost = trspUnitCost;
		this.totalAmt = totalAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.frmToSeq = frmToSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.oriDest = oriDest;
		this.steveTtlAmt = steveTtlAmt;
		this.mcntrQty = mcntrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_ttl_amt", getTrspTtlAmt());
		this.hashColumns.put("frm_yard", getFrmYard());
		this.hashColumns.put("frm_to_ecc", getFrmToEcc());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("steve_unit_cost", getSteveUnitCost());
		this.hashColumns.put("trsp_unit_cost", getTrspUnitCost());
		this.hashColumns.put("total_amt", getTotalAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_to_seq", getFrmToSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("ori_dest", getOriDest());
		this.hashColumns.put("steve_ttl_amt", getSteveTtlAmt());
		this.hashColumns.put("mcntr_qty", getMcntrQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_ttl_amt", "trspTtlAmt");
		this.hashFields.put("frm_yard", "frmYard");
		this.hashFields.put("frm_to_ecc", "frmToEcc");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("steve_unit_cost", "steveUnitCost");
		this.hashFields.put("trsp_unit_cost", "trspUnitCost");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_to_seq", "frmToSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ori_dest", "oriDest");
		this.hashFields.put("steve_ttl_amt", "steveTtlAmt");
		this.hashFields.put("mcntr_qty", "mcntrQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trspTtlAmt
	 */
	public String getTrspTtlAmt() {
		return this.trspTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return frmYard
	 */
	public String getFrmYard() {
		return this.frmYard;
	}
	
	/**
	 * Column Info
	 * @return frmToEcc
	 */
	public String getFrmToEcc() {
		return this.frmToEcc;
	}
	
	/**
	 * Column Info
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
	}
	
	/**
	 * Column Info
	 * @return steveUnitCost
	 */
	public String getSteveUnitCost() {
		return this.steveUnitCost;
	}
	
	/**
	 * Column Info
	 * @return trspUnitCost
	 */
	public String getTrspUnitCost() {
		return this.trspUnitCost;
	}
	
	/**
	 * Column Info
	 * @return totalAmt
	 */
	public String getTotalAmt() {
		return this.totalAmt;
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
	 * @return frmToSeq
	 */
	public String getFrmToSeq() {
		return this.frmToSeq;
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
	 * @return oriDest
	 */
	public String getOriDest() {
		return this.oriDest;
	}
	
	/**
	 * Column Info
	 * @return steveTtlAmt
	 */
	public String getSteveTtlAmt() {
		return this.steveTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return mcntrQty
	 */
	public String getMcntrQty() {
		return this.mcntrQty;
	}
	

	/**
	 * Column Info
	 * @param trspTtlAmt
	 */
	public void setTrspTtlAmt(String trspTtlAmt) {
		this.trspTtlAmt = trspTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param frmYard
	 */
	public void setFrmYard(String frmYard) {
		this.frmYard = frmYard;
	}
	
	/**
	 * Column Info
	 * @param frmToEcc
	 */
	public void setFrmToEcc(String frmToEcc) {
		this.frmToEcc = frmToEcc;
	}
	
	/**
	 * Column Info
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
	}
	
	/**
	 * Column Info
	 * @param steveUnitCost
	 */
	public void setSteveUnitCost(String steveUnitCost) {
		this.steveUnitCost = steveUnitCost;
	}
	
	/**
	 * Column Info
	 * @param trspUnitCost
	 */
	public void setTrspUnitCost(String trspUnitCost) {
		this.trspUnitCost = trspUnitCost;
	}
	
	/**
	 * Column Info
	 * @param totalAmt
	 */
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
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
	 * @param frmToSeq
	 */
	public void setFrmToSeq(String frmToSeq) {
		this.frmToSeq = frmToSeq;
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
	 * @param oriDest
	 */
	public void setOriDest(String oriDest) {
		this.oriDest = oriDest;
	}
	
	/**
	 * Column Info
	 * @param steveTtlAmt
	 */
	public void setSteveTtlAmt(String steveTtlAmt) {
		this.steveTtlAmt = steveTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param mcntrQty
	 */
	public void setMcntrQty(String mcntrQty) {
		this.mcntrQty = mcntrQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTrspTtlAmt(JSPUtil.getParameter(request, "trsp_ttl_amt", ""));
		setFrmYard(JSPUtil.getParameter(request, "frm_yard", ""));
		setFrmToEcc(JSPUtil.getParameter(request, "frm_to_ecc", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setSteveUnitCost(JSPUtil.getParameter(request, "steve_unit_cost", ""));
		setTrspUnitCost(JSPUtil.getParameter(request, "trsp_unit_cost", ""));
		setTotalAmt(JSPUtil.getParameter(request, "total_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrmToSeq(JSPUtil.getParameter(request, "frm_to_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOriDest(JSPUtil.getParameter(request, "ori_dest", ""));
		setSteveTtlAmt(JSPUtil.getParameter(request, "steve_ttl_amt", ""));
		setMcntrQty(JSPUtil.getParameter(request, "mcntr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCostListPopUpVO[]
	 */
	public SearchMTCostListPopUpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCostListPopUpVO[]
	 */
	public SearchMTCostListPopUpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCostListPopUpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trspTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_ttl_amt", length));
			String[] frmYard = (JSPUtil.getParameter(request, prefix	+ "frm_yard", length));
			String[] frmToEcc = (JSPUtil.getParameter(request, prefix	+ "frm_to_ecc", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] steveUnitCost = (JSPUtil.getParameter(request, prefix	+ "steve_unit_cost", length));
			String[] trspUnitCost = (JSPUtil.getParameter(request, prefix	+ "trsp_unit_cost", length));
			String[] totalAmt = (JSPUtil.getParameter(request, prefix	+ "total_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frmToSeq = (JSPUtil.getParameter(request, prefix	+ "frm_to_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] oriDest = (JSPUtil.getParameter(request, prefix	+ "ori_dest", length));
			String[] steveTtlAmt = (JSPUtil.getParameter(request, prefix	+ "steve_ttl_amt", length));
			String[] mcntrQty = (JSPUtil.getParameter(request, prefix	+ "mcntr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCostListPopUpVO();
				if (trspTtlAmt[i] != null)
					model.setTrspTtlAmt(trspTtlAmt[i]);
				if (frmYard[i] != null)
					model.setFrmYard(frmYard[i]);
				if (frmToEcc[i] != null)
					model.setFrmToEcc(frmToEcc[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (steveUnitCost[i] != null)
					model.setSteveUnitCost(steveUnitCost[i]);
				if (trspUnitCost[i] != null)
					model.setTrspUnitCost(trspUnitCost[i]);
				if (totalAmt[i] != null)
					model.setTotalAmt(totalAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmToSeq[i] != null)
					model.setFrmToSeq(frmToSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (oriDest[i] != null)
					model.setOriDest(oriDest[i]);
				if (steveTtlAmt[i] != null)
					model.setSteveTtlAmt(steveTtlAmt[i]);
				if (mcntrQty[i] != null)
					model.setMcntrQty(mcntrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMTCostListPopUpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCostListPopUpVO[]
	 */
	public SearchMTCostListPopUpVO[] getSearchMTCostListPopUpVOs(){
		SearchMTCostListPopUpVO[] vos = (SearchMTCostListPopUpVO[])models.toArray(new SearchMTCostListPopUpVO[models.size()]);
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
		this.trspTtlAmt = this.trspTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmYard = this.frmYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmToEcc = this.frmToEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steveUnitCost = this.steveUnitCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspUnitCost = this.trspUnitCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt = this.totalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmToSeq = this.frmToSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriDest = this.oriDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steveTtlAmt = this.steveTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mcntrQty = this.mcntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
