/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMTCostListVO10.java
*@FileTitle : SearchMTCostListVO10
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.08.24 박수훈 
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
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMTCostListVO10 extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMTCostListVO10> models = new ArrayList<SearchMTCostListVO10>();
	
	/* Column Info */
	private String toEcc = null;
	/* Column Info */
	private String mvmtDays = null;
	/* Column Info */
	private String contiSteve = null;
	/* Column Info */
	private String mvmtTrans = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String contiDays = null;
	/* Column Info */
	private String fromEcc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vol = null;
	/* Column Info */
	private String mvmtSteve = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String contiTrans = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * SearchMTCostListVO10 생성자
	 */
	public SearchMTCostListVO10() {}

	/**
	 * SearchMTCostListVO10 생성자
	 * @param String ibflag
	 * @param String pagerows
	 * @param String costYrmon
	 * @param String fromEcc
	 * @param String toEcc
	 * @param String cntrTpszCd
	 * @param String vol
	 * @param String contiSteve
	 * @param String contiTrans
	 * @param String contiDays
	 * @param String mvmtSteve
	 * @param String mvmtTrans
	 * @param String mvmtDays
	 */
	public SearchMTCostListVO10(String ibflag, String pagerows, String costYrmon, String fromEcc, String toEcc, String cntrTpszCd, String vol, String contiSteve, String contiTrans, String contiDays, String mvmtSteve, String mvmtTrans, String mvmtDays) {
		this.toEcc = toEcc;
		this.mvmtDays = mvmtDays;
		this.contiSteve = contiSteve;
		this.mvmtTrans = mvmtTrans;
		this.pagerows = pagerows;
		this.contiDays = contiDays;
		this.fromEcc = fromEcc;
		this.ibflag = ibflag;
		this.vol = vol;
		this.mvmtSteve = mvmtSteve;
		this.costYrmon = costYrmon;
		this.cntrTpszCd = cntrTpszCd;
		this.contiTrans = contiTrans;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_ecc", getToEcc());
		this.hashColumns.put("mvmt_days", getMvmtDays());
		this.hashColumns.put("conti_steve", getContiSteve());
		this.hashColumns.put("mvmt_trans", getMvmtTrans());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("conti_days", getContiDays());
		this.hashColumns.put("from_ecc", getFromEcc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("mvmt_steve", getMvmtSteve());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("conti_trans", getContiTrans());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_ecc", "toEcc");
		this.hashFields.put("mvmt_days", "mvmtDays");
		this.hashFields.put("conti_steve", "contiSteve");
		this.hashFields.put("mvmt_trans", "mvmtTrans");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("conti_days", "contiDays");
		this.hashFields.put("from_ecc", "fromEcc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vol", "vol");
		this.hashFields.put("mvmt_steve", "mvmtSteve");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("conti_trans", "contiTrans");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toEcc
	 */
	public String getToEcc() {
		return this.toEcc;
	}
	
	/**
	 * Column Info
	 * @return mvmtDays
	 */
	public String getMvmtDays() {
		return this.mvmtDays;
	}
	
	/**
	 * Column Info
	 * @return contiSteve
	 */
	public String getContiSteve() {
		return this.contiSteve;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrans
	 */
	public String getMvmtTrans() {
		return this.mvmtTrans;
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
	 * @return contiDays
	 */
	public String getContiDays() {
		return this.contiDays;
	}
	
	/**
	 * Column Info
	 * @return fromEcc
	 */
	public String getFromEcc() {
		return this.fromEcc;
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
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
	}
	
	/**
	 * Column Info
	 * @return mvmtSteve
	 */
	public String getMvmtSteve() {
		return this.mvmtSteve;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return contiTrans
	 */
	public String getContiTrans() {
		return this.contiTrans;
	}
	

	/**
	 * Column Info
	 * @param toEcc
	 */
	public void setToEcc(String toEcc) {
		this.toEcc = toEcc;
	}
	
	/**
	 * Column Info
	 * @param mvmtDays
	 */
	public void setMvmtDays(String mvmtDays) {
		this.mvmtDays = mvmtDays;
	}
	
	/**
	 * Column Info
	 * @param contiSteve
	 */
	public void setContiSteve(String contiSteve) {
		this.contiSteve = contiSteve;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrans
	 */
	public void setMvmtTrans(String mvmtTrans) {
		this.mvmtTrans = mvmtTrans;
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
	 * @param contiDays
	 */
	public void setContiDays(String contiDays) {
		this.contiDays = contiDays;
	}
	
	/**
	 * Column Info
	 * @param fromEcc
	 */
	public void setFromEcc(String fromEcc) {
		this.fromEcc = fromEcc;
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
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	/**
	 * Column Info
	 * @param mvmtSteve
	 */
	public void setMvmtSteve(String mvmtSteve) {
		this.mvmtSteve = mvmtSteve;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param contiTrans
	 */
	public void setContiTrans(String contiTrans) {
		this.contiTrans = contiTrans;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToEcc(JSPUtil.getParameter(request, "to_ecc", ""));
		setMvmtDays(JSPUtil.getParameter(request, "mvmt_days", ""));
		setContiSteve(JSPUtil.getParameter(request, "conti_steve", ""));
		setMvmtTrans(JSPUtil.getParameter(request, "mvmt_trans", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setContiDays(JSPUtil.getParameter(request, "conti_days", ""));
		setFromEcc(JSPUtil.getParameter(request, "from_ecc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVol(JSPUtil.getParameter(request, "vol", ""));
		setMvmtSteve(JSPUtil.getParameter(request, "mvmt_steve", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setContiTrans(JSPUtil.getParameter(request, "conti_trans", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMTCostListVO10[]
	 */
	public SearchMTCostListVO10[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMTCostListVO10[]
	 */
	public SearchMTCostListVO10[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMTCostListVO10 model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] s_toEcc = (JSPUtil.getParameter(request, prefix	+ "to_ecc", length));
			String[] s_mvmtDays = (JSPUtil.getParameter(request, prefix	+ "mvmt_days", length));
			String[] s_contiSteve = (JSPUtil.getParameter(request, prefix	+ "conti_steve", length));
			String[] s_mvmtTrans = (JSPUtil.getParameter(request, prefix	+ "mvmt_trans", length));
			String[] s_pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] s_contiDays = (JSPUtil.getParameter(request, prefix	+ "conti_days", length));
			String[] s_fromEcc = (JSPUtil.getParameter(request, prefix	+ "from_ecc", length));
			String[] s_ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] s_vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] s_mvmtSteve = (JSPUtil.getParameter(request, prefix	+ "mvmt_steve", length));
			String[] s_costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] s_cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] s_contiTrans = (JSPUtil.getParameter(request, prefix	+ "conti_trans", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMTCostListVO10();
				if (s_toEcc[i] != null)
					model.setToEcc(s_toEcc[i]);
				if (s_mvmtDays[i] != null)
					model.setMvmtDays(s_mvmtDays[i]);
				if (s_contiSteve[i] != null)
					model.setContiSteve(s_contiSteve[i]);
				if (s_mvmtTrans[i] != null)
					model.setMvmtTrans(s_mvmtTrans[i]);
				if (s_pagerows[i] != null)
					model.setPagerows(s_pagerows[i]);
				if (s_contiDays[i] != null)
					model.setContiDays(s_contiDays[i]);
				if (s_fromEcc[i] != null)
					model.setFromEcc(s_fromEcc[i]);
				if (s_ibflag[i] != null)
					model.setIbflag(s_ibflag[i]);
				if (s_vol[i] != null)
					model.setVol(s_vol[i]);
				if (s_mvmtSteve[i] != null)
					model.setMvmtSteve(s_mvmtSteve[i]);
				if (s_costYrmon[i] != null)
					model.setCostYrmon(s_costYrmon[i]);
				if (s_cntrTpszCd[i] != null)
					model.setCntrTpszCd(s_cntrTpszCd[i]);
				if (s_contiTrans[i] != null)
					model.setContiTrans(s_contiTrans[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMTCostListVO10s();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMTCostListVO10[]
	 */
	public SearchMTCostListVO10[] getSearchMTCostListVO10s(){
		SearchMTCostListVO10[] vos = (SearchMTCostListVO10[])models.toArray(new SearchMTCostListVO10[models.size()]);
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
		this.toEcc = this.toEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtDays = this.mvmtDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiSteve = this.contiSteve .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrans = this.mvmtTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiDays = this.contiDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromEcc = this.fromEcc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtSteve = this.mvmtSteve .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiTrans = this.contiTrans .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
