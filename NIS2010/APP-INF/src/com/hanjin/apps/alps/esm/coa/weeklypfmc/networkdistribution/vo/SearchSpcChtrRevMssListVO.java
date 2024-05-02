/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpcChtrRevMssListVO.java
*@FileTitle : SearchSpcChtrRevMssListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.15 김기대 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkdistribution.vo;

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
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpcChtrRevMssListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpcChtrRevMssListVO> models = new ArrayList<SearchSpcChtrRevMssListVO>();
	
	/* Column Info */
	private String incm = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hjsBsaRto = null;
	/* Column Info */
	private String coBsaCapa = null;
	/* Column Info */
	private String chtrBsaRto = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String expn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String slsYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String n2ndFnlHjsBsaCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpcChtrRevMssListVO() {}

	public SearchSpcChtrRevMssListVO(String ibflag, String pagerows, String slsYrmon, String costWk, String trdCd, String rlaneCd, String vslCd, String skdVoyNo, String dirCd, String n2ndFnlHjsBsaCapa, String coBsaCapa, String hjsBsaRto, String chtrBsaRto, String expn, String incm) {
		this.incm = incm;
		this.vslCd = vslCd;
		this.hjsBsaRto = hjsBsaRto;
		this.coBsaCapa = coBsaCapa;
		this.chtrBsaRto = chtrBsaRto;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.expn = expn;
		this.pagerows = pagerows;
		this.slsYrmon = slsYrmon;
		this.ibflag = ibflag;
		this.costWk = costWk;
		this.dirCd = dirCd;
		this.n2ndFnlHjsBsaCapa = n2ndFnlHjsBsaCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("incm", getIncm());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hjs_bsa_rto", getHjsBsaRto());
		this.hashColumns.put("co_bsa_capa", getCoBsaCapa());
		this.hashColumns.put("chtr_bsa_rto", getChtrBsaRto());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("expn", getExpn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("n2nd_fnl_hjs_bsa_capa", getN2ndFnlHjsBsaCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("incm", "incm");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hjs_bsa_rto", "hjsBsaRto");
		this.hashFields.put("co_bsa_capa", "coBsaCapa");
		this.hashFields.put("chtr_bsa_rto", "chtrBsaRto");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("expn", "expn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("n2nd_fnl_hjs_bsa_capa", "n2ndFnlHjsBsaCapa");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return incm
	 */
	public String getIncm() {
		return this.incm;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return hjsBsaRto
	 */
	public String getHjsBsaRto() {
		return this.hjsBsaRto;
	}
	
	/**
	 * Column Info
	 * @return coBsaCapa
	 */
	public String getCoBsaCapa() {
		return this.coBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return chtrBsaRto
	 */
	public String getChtrBsaRto() {
		return this.chtrBsaRto;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return expn
	 */
	public String getExpn() {
		return this.expn;
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
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
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
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
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
	 * @return n2ndFnlHjsBsaCapa
	 */
	public String getN2ndFnlHjsBsaCapa() {
		return this.n2ndFnlHjsBsaCapa;
	}
	

	/**
	 * Column Info
	 * @param incm
	 */
	public void setIncm(String incm) {
		this.incm = incm;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param hjsBsaRto
	 */
	public void setHjsBsaRto(String hjsBsaRto) {
		this.hjsBsaRto = hjsBsaRto;
	}
	
	/**
	 * Column Info
	 * @param coBsaCapa
	 */
	public void setCoBsaCapa(String coBsaCapa) {
		this.coBsaCapa = coBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param chtrBsaRto
	 */
	public void setChtrBsaRto(String chtrBsaRto) {
		this.chtrBsaRto = chtrBsaRto;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param expn
	 */
	public void setExpn(String expn) {
		this.expn = expn;
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
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
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
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
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
	 * @param n2ndFnlHjsBsaCapa
	 */
	public void setN2ndFnlHjsBsaCapa(String n2ndFnlHjsBsaCapa) {
		this.n2ndFnlHjsBsaCapa = n2ndFnlHjsBsaCapa;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIncm(JSPUtil.getParameter(request, "incm", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setHjsBsaRto(JSPUtil.getParameter(request, "hjs_bsa_rto", ""));
		setCoBsaCapa(JSPUtil.getParameter(request, "co_bsa_capa", ""));
		setChtrBsaRto(JSPUtil.getParameter(request, "chtr_bsa_rto", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setExpn(JSPUtil.getParameter(request, "expn", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSlsYrmon(JSPUtil.getParameter(request, "sls_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setN2ndFnlHjsBsaCapa(JSPUtil.getParameter(request, "n2nd_fnl_hjs_bsa_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpcChtrRevMssListVO[]
	 */
	public SearchSpcChtrRevMssListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpcChtrRevMssListVO[]
	 */
	public SearchSpcChtrRevMssListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpcChtrRevMssListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] incm = (JSPUtil.getParameter(request, prefix	+ "incm", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hjsBsaRto = (JSPUtil.getParameter(request, prefix	+ "hjs_bsa_rto", length));
			String[] coBsaCapa = (JSPUtil.getParameter(request, prefix	+ "co_bsa_capa", length));
			String[] chtrBsaRto = (JSPUtil.getParameter(request, prefix	+ "chtr_bsa_rto", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] expn = (JSPUtil.getParameter(request, prefix	+ "expn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] n2ndFnlHjsBsaCapa = (JSPUtil.getParameter(request, prefix	+ "n2nd_fnl_hjs_bsa_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpcChtrRevMssListVO();
				if (incm[i] != null)
					model.setIncm(incm[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hjsBsaRto[i] != null)
					model.setHjsBsaRto(hjsBsaRto[i]);
				if (coBsaCapa[i] != null)
					model.setCoBsaCapa(coBsaCapa[i]);
				if (chtrBsaRto[i] != null)
					model.setChtrBsaRto(chtrBsaRto[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (expn[i] != null)
					model.setExpn(expn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (n2ndFnlHjsBsaCapa[i] != null)
					model.setN2ndFnlHjsBsaCapa(n2ndFnlHjsBsaCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpcChtrRevMssListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpcChtrRevMssListVO[]
	 */
	public SearchSpcChtrRevMssListVO[] getSearchSpcChtrRevMssListVOs(){
		SearchSpcChtrRevMssListVO[] vos = (SearchSpcChtrRevMssListVO[])models.toArray(new SearchSpcChtrRevMssListVO[models.size()]);
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
		this.incm = this.incm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsBsaRto = this.hjsBsaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coBsaCapa = this.coBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrBsaRto = this.chtrBsaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expn = this.expn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndFnlHjsBsaCapa = this.n2ndFnlHjsBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
