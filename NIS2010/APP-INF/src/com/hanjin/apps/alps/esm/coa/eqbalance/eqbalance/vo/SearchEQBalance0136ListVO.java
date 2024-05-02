/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEQBalance0136ListVO.java
*@FileTitle : SearchEQBalance0136ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.09 박수훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.vo;

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
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEQBalance0136ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEQBalance0136ListVO> models = new ArrayList<SearchEQBalance0136ListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String porRepoFlg = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String slevel = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String ecc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEQBalance0136ListVO() {}

	public SearchEQBalance0136ListVO(String ibflag, String pagerows, String costYrmon, String rccCd, String ecc, String eccCd, String porRepoFlg, String slevel) {
		this.ibflag = ibflag;
		this.porRepoFlg = porRepoFlg;
		this.costYrmon = costYrmon;
		this.slevel = slevel;
		this.eccCd = eccCd;
		this.rccCd = rccCd;
		this.ecc = ecc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("por_repo_flg", getPorRepoFlg());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("slevel", getSlevel());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("ecc", getEcc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("por_repo_flg", "porRepoFlg");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("slevel", "slevel");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("ecc", "ecc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return porRepoFlg
	 */
	public String getPorRepoFlg() {
		return this.porRepoFlg;
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
	 * @return slevel
	 */
	public String getSlevel() {
		return this.slevel;
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
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return ecc
	 */
	public String getEcc() {
		return this.ecc;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param porRepoFlg
	 */
	public void setPorRepoFlg(String porRepoFlg) {
		this.porRepoFlg = porRepoFlg;
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
	 * @param slevel
	 */
	public void setSlevel(String slevel) {
		this.slevel = slevel;
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
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param ecc
	 */
	public void setEcc(String ecc) {
		this.ecc = ecc;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPorRepoFlg(JSPUtil.getParameter(request, "por_repo_flg", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setSlevel(JSPUtil.getParameter(request, "slevel", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setEcc(JSPUtil.getParameter(request, "ecc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEQBalance0136ListVO[]
	 */
	public SearchEQBalance0136ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEQBalance0136ListVO[]
	 */
	public SearchEQBalance0136ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEQBalance0136ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] porRepoFlg = (JSPUtil.getParameter(request, prefix	+ "por_repo_flg", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] slevel = (JSPUtil.getParameter(request, prefix	+ "slevel", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] ecc = (JSPUtil.getParameter(request, prefix	+ "ecc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEQBalance0136ListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (porRepoFlg[i] != null)
					model.setPorRepoFlg(porRepoFlg[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (slevel[i] != null)
					model.setSlevel(slevel[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (ecc[i] != null)
					model.setEcc(ecc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEQBalance0136ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEQBalance0136ListVO[]
	 */
	public SearchEQBalance0136ListVO[] getSearchEQBalance0136ListVOs(){
		SearchEQBalance0136ListVO[] vos = (SearchEQBalance0136ListVO[])models.toArray(new SearchEQBalance0136ListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRepoFlg = this.porRepoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slevel = this.slevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecc = this.ecc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
