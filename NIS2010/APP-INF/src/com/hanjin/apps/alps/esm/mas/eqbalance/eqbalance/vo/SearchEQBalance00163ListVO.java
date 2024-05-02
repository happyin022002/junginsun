/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEQBalance00163ListVO.java
*@FileTitle : SearchEQBalance00163ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.10.14 장영석 
* 1.0 Creation
* 2012.03.20 김종준 [CHM-201217091-01] cntrOrgDestCd 추가
=========================================================*/

package com.hanjin.apps.alps.esm.mas.eqbalance.eqbalance.vo;

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
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEQBalance00163ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEQBalance00163ListVO> models = new ArrayList<SearchEQBalance00163ListVO>();
	
	/* Column Info */
	private String lvlGrp = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String mbAmt = null;
	/* Column Info */
	private String imbalAmt = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String code = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqRepoCrRto = null;
	/* Column Info */
	private String lccCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String opbAmt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrOrgDestCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEQBalance00163ListVO() {}

	public SearchEQBalance00163ListVO(String ibflag, String pagerows, String costYrmon, String cntrTpszCd, String eccCd, String lccCd, String rccCd, String lvlGrp, String imbalAmt, String opbAmt, String mbAmt, String eqRepoCrRto, String code, String cntrOrgDestCd) {
		this.lvlGrp = lvlGrp;
		this.eccCd = eccCd;
		this.mbAmt = mbAmt;
		this.imbalAmt = imbalAmt;
		this.rccCd = rccCd;
		this.code = code;
		this.pagerows = pagerows;
		this.eqRepoCrRto = eqRepoCrRto;
		this.lccCd = lccCd;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.opbAmt = opbAmt;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrOrgDestCd = cntrOrgDestCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lvl_grp", getLvlGrp());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("mb_amt", getMbAmt());
		this.hashColumns.put("imbal_amt", getImbalAmt());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_repo_cr_rto", getEqRepoCrRto());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("opb_amt", getOpbAmt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_org_dest_cd", getCntrOrgDestCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lvl_grp", "lvlGrp");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("mb_amt", "mbAmt");
		this.hashFields.put("imbal_amt", "imbalAmt");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("code", "code");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_repo_cr_rto", "eqRepoCrRto");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("opb_amt", "opbAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_org_dest_cd", "cntrOrgDestCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lvlGrp
	 */
	public String getLvlGrp() {
		return this.lvlGrp;
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
	 * @return mbAmt
	 */
	public String getMbAmt() {
		return this.mbAmt;
	}
	
	/**
	 * Column Info
	 * @return imbalAmt
	 */
	public String getImbalAmt() {
		return this.imbalAmt;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
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
	 * @return eqRepoCrRto
	 */
	public String getEqRepoCrRto() {
		return this.eqRepoCrRto;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return opbAmt
	 */
	public String getOpbAmt() {
		return this.opbAmt;
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
	 * @return cntrOrgDestCd
	 */
	public String getCntrOrgDestCd() {
		return this.cntrOrgDestCd;
	}
	
	/**
	 * Column Info
	 * @param lvlGrp
	 */
	public void setLvlGrp(String lvlGrp) {
		this.lvlGrp = lvlGrp;
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
	 * @param mbAmt
	 */
	public void setMbAmt(String mbAmt) {
		this.mbAmt = mbAmt;
	}
	
	/**
	 * Column Info
	 * @param imbalAmt
	 */
	public void setImbalAmt(String imbalAmt) {
		this.imbalAmt = imbalAmt;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @param eqRepoCrRto
	 */
	public void setEqRepoCrRto(String eqRepoCrRto) {
		this.eqRepoCrRto = eqRepoCrRto;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param opbAmt
	 */
	public void setOpbAmt(String opbAmt) {
		this.opbAmt = opbAmt;
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
	 * @param cntrOrgDestCd
	 */
	public void setCntrOrgDestCd(String cntrOrgDestCd) {
		this.cntrOrgDestCd = cntrOrgDestCd;
	}

	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLvlGrp(JSPUtil.getParameter(request, "lvl_grp", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setMbAmt(JSPUtil.getParameter(request, "mb_amt", ""));
		setImbalAmt(JSPUtil.getParameter(request, "imbal_amt", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqRepoCrRto(JSPUtil.getParameter(request, "eq_repo_cr_rto", ""));
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setOpbAmt(JSPUtil.getParameter(request, "opb_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrOrgDestCd(JSPUtil.getParameter(request, "cntr_org_dest_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEQBalance00163ListVO[]
	 */
	public SearchEQBalance00163ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEQBalance00163ListVO[]
	 */
	public SearchEQBalance00163ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEQBalance00163ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lvlGrp = (JSPUtil.getParameter(request, prefix	+ "lvl_grp", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] mbAmt = (JSPUtil.getParameter(request, prefix	+ "mb_amt", length));
			String[] imbalAmt = (JSPUtil.getParameter(request, prefix	+ "imbal_amt", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqRepoCrRto = (JSPUtil.getParameter(request, prefix	+ "eq_repo_cr_rto", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] opbAmt = (JSPUtil.getParameter(request, prefix	+ "opb_amt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrOrgDestCd = (JSPUtil.getParameter(request, prefix	+ "cntr_org_dest_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEQBalance00163ListVO();
				if (lvlGrp[i] != null)
					model.setLvlGrp(lvlGrp[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (mbAmt[i] != null)
					model.setMbAmt(mbAmt[i]);
				if (imbalAmt[i] != null)
					model.setImbalAmt(imbalAmt[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqRepoCrRto[i] != null)
					model.setEqRepoCrRto(eqRepoCrRto[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (opbAmt[i] != null)
					model.setOpbAmt(opbAmt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrOrgDestCd[i] != null)
					model.setCntrOrgDestCd(cntrOrgDestCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEQBalance00163ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEQBalance00163ListVO[]
	 */
	public SearchEQBalance00163ListVO[] getSearchEQBalance00163ListVOs(){
		SearchEQBalance00163ListVO[] vos = (SearchEQBalance00163ListVO[])models.toArray(new SearchEQBalance00163ListVO[models.size()]);
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
		this.lvlGrp = this.lvlGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbAmt = this.mbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imbalAmt = this.imbalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoCrRto = this.eqRepoCrRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opbAmt = this.opbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOrgDestCd = this.cntrOrgDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
