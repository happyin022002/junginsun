/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBunkerPriceInterfaceListVO.java
*@FileTitle : SearchBunkerPriceInterfaceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.07 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBunkerPriceInterfaceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBunkerPriceInterfaceListVO> models = new ArrayList<SearchBunkerPriceInterfaceListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String foilActPrc = null;
	/* Column Info */
	private String doilActPrc = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String evntDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBunkerPriceInterfaceListVO() {}

	public SearchBunkerPriceInterfaceListVO(String ibflag, String pagerows, String evntDt, String portCd, String foilActPrc, String doilActPrc) {
		this.ibflag = ibflag;
		this.foilActPrc = foilActPrc;
		this.doilActPrc = doilActPrc;
		this.portCd = portCd;
		this.evntDt = evntDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("foil_act_prc", getFoilActPrc());
		this.hashColumns.put("doil_act_prc", getDoilActPrc());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("foil_act_prc", "foilActPrc");
		this.hashFields.put("doil_act_prc", "doilActPrc");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("evnt_dt", "evntDt");
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
	 * @return foilActPrc
	 */
	public String getFoilActPrc() {
		return this.foilActPrc;
	}
	
	/**
	 * Column Info
	 * @return doilActPrc
	 */
	public String getDoilActPrc() {
		return this.doilActPrc;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @param foilActPrc
	 */
	public void setFoilActPrc(String foilActPrc) {
		this.foilActPrc = foilActPrc;
	}
	
	/**
	 * Column Info
	 * @param doilActPrc
	 */
	public void setDoilActPrc(String doilActPrc) {
		this.doilActPrc = doilActPrc;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
		setFoilActPrc(JSPUtil.getParameter(request, "foil_act_prc", ""));
		setDoilActPrc(JSPUtil.getParameter(request, "doil_act_prc", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBunkerPriceInterfaceListVO[]
	 */
	public SearchBunkerPriceInterfaceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBunkerPriceInterfaceListVO[]
	 */
	public SearchBunkerPriceInterfaceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBunkerPriceInterfaceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] foilActPrc = (JSPUtil.getParameter(request, prefix	+ "foil_act_prc", length));
			String[] doilActPrc = (JSPUtil.getParameter(request, prefix	+ "doil_act_prc", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBunkerPriceInterfaceListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (foilActPrc[i] != null)
					model.setFoilActPrc(foilActPrc[i]);
				if (doilActPrc[i] != null)
					model.setDoilActPrc(doilActPrc[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBunkerPriceInterfaceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBunkerPriceInterfaceListVO[]
	 */
	public SearchBunkerPriceInterfaceListVO[] getSearchBunkerPriceInterfaceListVOs(){
		SearchBunkerPriceInterfaceListVO[] vos = (SearchBunkerPriceInterfaceListVO[])models.toArray(new SearchBunkerPriceInterfaceListVO[models.size()]);
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
		this.foilActPrc = this.foilActPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilActPrc = this.doilActPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
