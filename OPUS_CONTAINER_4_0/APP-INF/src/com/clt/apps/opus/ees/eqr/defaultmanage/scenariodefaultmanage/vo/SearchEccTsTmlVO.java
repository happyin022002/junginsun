/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEccTsTmlVO.java
*@FileTitle : SearchEccTsTmlVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.07.22		1.0 최초 생성
*
*@LastModifyDate : 2009.07.22
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

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

public class SearchEccTsTmlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEccTsTmlVO> models = new ArrayList<SearchEccTsTmlVO>();
	
	/* Column Info */
	private String eccCd1 = null;
	/* Column Info */
	private String ts45ftUcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toSlanCd = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String fmSlanCd = null;
	/* Column Info */
	private String ts20ftUcAmt = null;
	/* Column Info */
	private String ts40ftUcAmt = null;
	/* Column Info */
	private String laneDirCd = null;
	/* Column Info */
	private String toYdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEccTsTmlVO() {}

	public SearchEccTsTmlVO(String ibflag, String pagerows, String fmSlanCd, String laneDirCd, String toSlanCd, String fmYdCd, String toYdCd, String ts20ftUcAmt, String ts40ftUcAmt, String ts45ftUcAmt, String eccCd1) {
		this.eccCd1 = eccCd1;
		this.ts45ftUcAmt = ts45ftUcAmt;
		this.ibflag = ibflag;
		this.toSlanCd = toSlanCd;
		this.fmYdCd = fmYdCd;
		this.fmSlanCd = fmSlanCd;
		this.ts20ftUcAmt = ts20ftUcAmt;
		this.ts40ftUcAmt = ts40ftUcAmt;
		this.laneDirCd = laneDirCd;
		this.toYdCd = toYdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ecc_cd1", getEccCd1());
		this.hashColumns.put("ts_45ft_uc_amt", getTs45ftUcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_slan_cd", getToSlanCd());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("fm_slan_cd", getFmSlanCd());
		this.hashColumns.put("ts_20ft_uc_amt", getTs20ftUcAmt());
		this.hashColumns.put("ts_40ft_uc_amt", getTs40ftUcAmt());
		this.hashColumns.put("lane_dir_cd", getLaneDirCd());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ecc_cd1", "eccCd1");
		this.hashFields.put("ts_45ft_uc_amt", "ts45ftUcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_slan_cd", "toSlanCd");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("fm_slan_cd", "fmSlanCd");
		this.hashFields.put("ts_20ft_uc_amt", "ts20ftUcAmt");
		this.hashFields.put("ts_40ft_uc_amt", "ts40ftUcAmt");
		this.hashFields.put("lane_dir_cd", "laneDirCd");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eccCd1
	 */
	public String getEccCd1() {
		return this.eccCd1;
	}
	
	/**
	 * Column Info
	 * @return ts45ftUcAmt
	 */
	public String getTs45ftUcAmt() {
		return this.ts45ftUcAmt;
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
	 * @return toSlanCd
	 */
	public String getToSlanCd() {
		return this.toSlanCd;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
	}
	
	/**
	 * Column Info
	 * @return fmSlanCd
	 */
	public String getFmSlanCd() {
		return this.fmSlanCd;
	}
	
	/**
	 * Column Info
	 * @return ts20ftUcAmt
	 */
	public String getTs20ftUcAmt() {
		return this.ts20ftUcAmt;
	}
	
	/**
	 * Column Info
	 * @return ts40ftUcAmt
	 */
	public String getTs40ftUcAmt() {
		return this.ts40ftUcAmt;
	}
	
	/**
	 * Column Info
	 * @return laneDirCd
	 */
	public String getLaneDirCd() {
		return this.laneDirCd;
	}
	
	/**
	 * Column Info
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @param eccCd1
	 */
	public void setEccCd1(String eccCd1) {
		this.eccCd1 = eccCd1;
	}
	
	/**
	 * Column Info
	 * @param ts45ftUcAmt
	 */
	public void setTs45ftUcAmt(String ts45ftUcAmt) {
		this.ts45ftUcAmt = ts45ftUcAmt;
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
	 * @param toSlanCd
	 */
	public void setToSlanCd(String toSlanCd) {
		this.toSlanCd = toSlanCd;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * Column Info
	 * @param fmSlanCd
	 */
	public void setFmSlanCd(String fmSlanCd) {
		this.fmSlanCd = fmSlanCd;
	}
	
	/**
	 * Column Info
	 * @param ts20ftUcAmt
	 */
	public void setTs20ftUcAmt(String ts20ftUcAmt) {
		this.ts20ftUcAmt = ts20ftUcAmt;
	}
	
	/**
	 * Column Info
	 * @param ts40ftUcAmt
	 */
	public void setTs40ftUcAmt(String ts40ftUcAmt) {
		this.ts40ftUcAmt = ts40ftUcAmt;
	}
	
	/**
	 * Column Info
	 * @param laneDirCd
	 */
	public void setLaneDirCd(String laneDirCd) {
		this.laneDirCd = laneDirCd;
	}
	
	/**
	 * Column Info
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
		setEccCd1(JSPUtil.getParameter(request, "ecc_cd1", ""));
		setTs45ftUcAmt(JSPUtil.getParameter(request, "ts_45ft_uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToSlanCd(JSPUtil.getParameter(request, "to_slan_cd", ""));
		setFmYdCd(JSPUtil.getParameter(request, "fm_yd_cd", ""));
		setFmSlanCd(JSPUtil.getParameter(request, "fm_slan_cd", ""));
		setTs20ftUcAmt(JSPUtil.getParameter(request, "ts_20ft_uc_amt", ""));
		setTs40ftUcAmt(JSPUtil.getParameter(request, "ts_40ft_uc_amt", ""));
		setLaneDirCd(JSPUtil.getParameter(request, "lane_dir_cd", ""));
		setToYdCd(JSPUtil.getParameter(request, "to_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEccTsTmlVO[]
	 */
	public SearchEccTsTmlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEccTsTmlVO[]
	 */
	public SearchEccTsTmlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEccTsTmlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eccCd1 = (JSPUtil.getParameter(request, prefix	+ "ecc_cd1", length));
			String[] ts45ftUcAmt = (JSPUtil.getParameter(request, prefix	+ "ts_45ft_uc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toSlanCd = (JSPUtil.getParameter(request, prefix	+ "to_slan_cd", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] fmSlanCd = (JSPUtil.getParameter(request, prefix	+ "fm_slan_cd", length));
			String[] ts20ftUcAmt = (JSPUtil.getParameter(request, prefix	+ "ts_20ft_uc_amt", length));
			String[] ts40ftUcAmt = (JSPUtil.getParameter(request, prefix	+ "ts_40ft_uc_amt", length));
			String[] laneDirCd = (JSPUtil.getParameter(request, prefix	+ "lane_dir_cd", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEccTsTmlVO();
				if (eccCd1[i] != null)
					model.setEccCd1(eccCd1[i]);
				if (ts45ftUcAmt[i] != null)
					model.setTs45ftUcAmt(ts45ftUcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toSlanCd[i] != null)
					model.setToSlanCd(toSlanCd[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (fmSlanCd[i] != null)
					model.setFmSlanCd(fmSlanCd[i]);
				if (ts20ftUcAmt[i] != null)
					model.setTs20ftUcAmt(ts20ftUcAmt[i]);
				if (ts40ftUcAmt[i] != null)
					model.setTs40ftUcAmt(ts40ftUcAmt[i]);
				if (laneDirCd[i] != null)
					model.setLaneDirCd(laneDirCd[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEccTsTmlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEccTsTmlVO[]
	 */
	public SearchEccTsTmlVO[] getSearchEccTsTmlVOs(){
		SearchEccTsTmlVO[] vos = (SearchEccTsTmlVO[])models.toArray(new SearchEccTsTmlVO[models.size()]);
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
		this.eccCd1 = this.eccCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts45ftUcAmt = this.ts45ftUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSlanCd = this.toSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSlanCd = this.fmSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts20ftUcAmt = this.ts20ftUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts40ftUcAmt = this.ts40ftUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneDirCd = this.laneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
