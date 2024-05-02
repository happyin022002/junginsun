/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchRepoPlanRLAThresholdVO.java
*@FileTitle : SearchRepoPlanRLAThresholdVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.07.17		1.0 최초 생성
*
*@LastModifyDate : 2009.07.17
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.defaultmanage.repothresholdmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRepoPlanRLAThresholdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRepoPlanRLAThresholdVO> models = new ArrayList<SearchRepoPlanRLAThresholdVO>();
	
	/* Column Info */
	private String adherence = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lsRto = null;
	/* Column Info */
	private String trspCapaRto = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String perfDurWks = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRepoPlanRLAThresholdVO() {}

	public SearchRepoPlanRLAThresholdVO(String ibflag, String pagerows, String rccCd, String perfDurWks, String trspCapaRto, String lsRto, String adherence) {
		this.adherence = adherence;
		this.ibflag = ibflag;
		this.lsRto = lsRto;
		this.trspCapaRto = trspCapaRto;
		this.rccCd = rccCd;
		this.perfDurWks = perfDurWks;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("adherence", getAdherence());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ls_rto", getLsRto());
		this.hashColumns.put("trsp_capa_rto", getTrspCapaRto());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("perf_dur_wks", getPerfDurWks());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("adherence", "adherence");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ls_rto", "lsRto");
		this.hashFields.put("trsp_capa_rto", "trspCapaRto");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("perf_dur_wks", "perfDurWks");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return adherence
	 */
	public String getAdherence() {
		return this.adherence;
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
	 * @return lsRto
	 */
	public String getLsRto() {
		return this.lsRto;
	}
	
	/**
	 * Column Info
	 * @return trspCapaRto
	 */
	public String getTrspCapaRto() {
		return this.trspCapaRto;
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
	 * @return perfDurWks
	 */
	public String getPerfDurWks() {
		return this.perfDurWks;
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
	 * @param adherence
	 */
	public void setAdherence(String adherence) {
		this.adherence = adherence;
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
	 * @param lsRto
	 */
	public void setLsRto(String lsRto) {
		this.lsRto = lsRto;
	}
	
	/**
	 * Column Info
	 * @param trspCapaRto
	 */
	public void setTrspCapaRto(String trspCapaRto) {
		this.trspCapaRto = trspCapaRto;
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
	 * @param perfDurWks
	 */
	public void setPerfDurWks(String perfDurWks) {
		this.perfDurWks = perfDurWks;
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
		setAdherence(JSPUtil.getParameter(request, "adherence", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLsRto(JSPUtil.getParameter(request, "ls_rto", ""));
		setTrspCapaRto(JSPUtil.getParameter(request, "trsp_capa_rto", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setPerfDurWks(JSPUtil.getParameter(request, "perf_dur_wks", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRepoPlanRLAThresholdVO[]
	 */
	public SearchRepoPlanRLAThresholdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRepoPlanRLAThresholdVO[]
	 */
	public SearchRepoPlanRLAThresholdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRepoPlanRLAThresholdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] adherence = (JSPUtil.getParameter(request, prefix	+ "adherence", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lsRto = (JSPUtil.getParameter(request, prefix	+ "ls_rto", length));
			String[] trspCapaRto = (JSPUtil.getParameter(request, prefix	+ "trsp_capa_rto", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] perfDurWks = (JSPUtil.getParameter(request, prefix	+ "perf_dur_wks", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRepoPlanRLAThresholdVO();
				if (adherence[i] != null)
					model.setAdherence(adherence[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lsRto[i] != null)
					model.setLsRto(lsRto[i]);
				if (trspCapaRto[i] != null)
					model.setTrspCapaRto(trspCapaRto[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (perfDurWks[i] != null)
					model.setPerfDurWks(perfDurWks[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRepoPlanRLAThresholdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRepoPlanRLAThresholdVO[]
	 */
	public SearchRepoPlanRLAThresholdVO[] getSearchRepoPlanRLAThresholdVOs(){
		SearchRepoPlanRLAThresholdVO[] vos = (SearchRepoPlanRLAThresholdVO[])models.toArray(new SearchRepoPlanRLAThresholdVO[models.size()]);
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
		this.adherence = this.adherence .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsRto = this.lsRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCapaRto = this.trspCapaRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfDurWks = this.perfDurWks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
