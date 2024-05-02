/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBkgRmk0170ListVO.java
*@FileTitle : SearchBkgRmk0170ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBkgRmk0170ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBkgRmk0170ListVO> models = new ArrayList<SearchBkgRmk0170ListVO>();
	
	/* Column Info */
	private String coaCostSrcNm = null;
	/* Column Info */
	private String amt = null;
	/* Column Info */
	private String grp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String ctrtRtnFlg = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String costCalcRmk = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Page Number */
	private String pagerows = null;
	//SJH.20141029.ADD
	/* Column Info */
	private String cntrTpszCd = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBkgRmk0170ListVO() {}

	public SearchBkgRmk0170ListVO(String ibflag, String pagerows, String nodCd, String grp, String stndCostCd, String stndCostNm, String coaCostSrcCd, String coaCostSrcNm, String amt, String ctrtRtnFlg, String costCalcRmk, String cntrTpszCd) {
		this.coaCostSrcNm = coaCostSrcNm;
		this.amt = amt;
		this.grp = grp;
		this.ibflag = ibflag;
		this.coaCostSrcCd = coaCostSrcCd;
		this.ctrtRtnFlg = ctrtRtnFlg;
		this.nodCd = nodCd;
		this.stndCostNm = stndCostNm;
		this.costCalcRmk = costCalcRmk;
		this.stndCostCd = stndCostCd;
		this.pagerows = pagerows;
		this.cntrTpszCd = cntrTpszCd;	//SJH.20141029.ADD
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("coa_cost_src_nm", getCoaCostSrcNm());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("ctrt_rtn_flg", getCtrtRtnFlg());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("cost_calc_rmk", getCostCalcRmk());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());	//SJH.20141029.ADD
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("coa_cost_src_nm", "coaCostSrcNm");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("ctrt_rtn_flg", "ctrtRtnFlg");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("cost_calc_rmk", "costCalcRmk");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");		//SJH.20141029.ADD
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coaCostSrcNm
	 */
	public String getCoaCostSrcNm() {
		return this.coaCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
	}
	
	/**
	 * Column Info
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
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
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtRtnFlg
	 */
	public String getCtrtRtnFlg() {
		return this.ctrtRtnFlg;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
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
	 * @return costCalcRmk
	 */
	public String getCostCalcRmk() {
		return this.costCalcRmk;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
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
	 * @return cntrTpszCd
	 * @author SJH.20141029.ADD
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}	
	

	/**
	 * Column Info
	 * @param coaCostSrcNm
	 */
	public void setCoaCostSrcNm(String coaCostSrcNm) {
		this.coaCostSrcNm = coaCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}
	
	/**
	 * Column Info
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
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
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtRtnFlg
	 */
	public void setCtrtRtnFlg(String ctrtRtnFlg) {
		this.ctrtRtnFlg = ctrtRtnFlg;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
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
	 * @param costCalcRmk
	 */
	public void setCostCalcRmk(String costCalcRmk) {
		this.costCalcRmk = costCalcRmk;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
	 * @param cntrTpszCd
	 * @author SJH.20141029.ADD
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCoaCostSrcNm(JSPUtil.getParameter(request, "coa_cost_src_nm", ""));
		setAmt(JSPUtil.getParameter(request, "amt", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, "coa_cost_src_cd", ""));
		setCtrtRtnFlg(JSPUtil.getParameter(request, "ctrt_rtn_flg", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setStndCostNm(JSPUtil.getParameter(request, "stnd_cost_nm", ""));
		setCostCalcRmk(JSPUtil.getParameter(request, "cost_calc_rmk", ""));
		setStndCostCd(JSPUtil.getParameter(request, "stnd_cost_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));	//SJH.20141029.ADD
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBkgRmk0170ListVO[]
	 */
	public SearchBkgRmk0170ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBkgRmk0170ListVO[]
	 */
	public SearchBkgRmk0170ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBkgRmk0170ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coaCostSrcNm = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_nm", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] ctrtRtnFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_rtn_flg", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] costCalcRmk = (JSPUtil.getParameter(request, prefix	+ "cost_calc_rmk", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));	//SJH.20141029.ADD
			
			for (int i = 0; i < length; i++) {
				model = new SearchBkgRmk0170ListVO();
				if (coaCostSrcNm[i] != null)
					model.setCoaCostSrcNm(coaCostSrcNm[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (ctrtRtnFlg[i] != null)
					model.setCtrtRtnFlg(ctrtRtnFlg[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (costCalcRmk[i] != null)
					model.setCostCalcRmk(costCalcRmk[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				//SJH.20141029.ADD
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBkgRmk0170ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBkgRmk0170ListVO[]
	 */
	public SearchBkgRmk0170ListVO[] getSearchBkgRmk0170ListVOs(){
		SearchBkgRmk0170ListVO[] vos = (SearchBkgRmk0170ListVO[])models.toArray(new SearchBkgRmk0170ListVO[models.size()]);
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
		this.coaCostSrcNm = this.coaCostSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRtnFlg = this.ctrtRtnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCalcRmk = this.costCalcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		//SJH.20141029.ADD
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
