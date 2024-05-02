/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetForecastedSeaInventoryVO.java
*@FileTitle : GetForecastedSeaInventoryVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.09.23		1.0 최초 생성
*
*@LastModifyDate : 2009.09.23
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo;

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

public class GetForecastedSeaInventoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetForecastedSeaInventoryVO> models = new ArrayList<GetForecastedSeaInventoryVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String ration = null;
	/* Column Info */
	private String unusedspc = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String land = null;
	/* Column Info */
	private String lastport = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rediualspc = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String usedspc = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetForecastedSeaInventoryVO() {}

	public GetForecastedSeaInventoryVO(String ibflag, String pagerows, String week, String port, String lastport, String etd, String land, String vvd, String bsa, String rediualspc, String usedspc, String unusedspc, String ration) {
		this.port = port;
		this.ration = ration;
		this.unusedspc = unusedspc;
		this.etd = etd;
		this.land = land;
		this.lastport = lastport;
		this.pagerows = pagerows;
		this.rediualspc = rediualspc;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.bsa = bsa;
		this.usedspc = usedspc;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("ration", getRation());
		this.hashColumns.put("unusedspc", getUnusedspc());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("land", getLand());
		this.hashColumns.put("lastport", getLastport());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rediualspc", getRediualspc());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("usedspc", getUsedspc());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("ration", "ration");
		this.hashFields.put("unusedspc", "unusedspc");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("land", "land");
		this.hashFields.put("lastport", "lastport");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rediualspc", "rediualspc");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("usedspc", "usedspc");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return ration
	 */
	public String getRation() {
		return this.ration;
	}
	
	/**
	 * Column Info
	 * @return unusedspc
	 */
	public String getUnusedspc() {
		return this.unusedspc;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return land
	 */
	public String getLand() {
		return this.land;
	}
	
	/**
	 * Column Info
	 * @return lastport
	 */
	public String getLastport() {
		return this.lastport;
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
	 * @return rediualspc
	 */
	public String getRediualspc() {
		return this.rediualspc;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return usedspc
	 */
	public String getUsedspc() {
		return this.usedspc;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param ration
	 */
	public void setRation(String ration) {
		this.ration = ration;
	}
	
	/**
	 * Column Info
	 * @param unusedspc
	 */
	public void setUnusedspc(String unusedspc) {
		this.unusedspc = unusedspc;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param land
	 */
	public void setLand(String land) {
		this.land = land;
	}
	
	/**
	 * Column Info
	 * @param lastport
	 */
	public void setLastport(String lastport) {
		this.lastport = lastport;
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
	 * @param rediualspc
	 */
	public void setRediualspc(String rediualspc) {
		this.rediualspc = rediualspc;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param usedspc
	 */
	public void setUsedspc(String usedspc) {
		this.usedspc = usedspc;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setRation(JSPUtil.getParameter(request, "ration", ""));
		setUnusedspc(JSPUtil.getParameter(request, "unusedspc", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setLand(JSPUtil.getParameter(request, "land", ""));
		setLastport(JSPUtil.getParameter(request, "lastport", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRediualspc(JSPUtil.getParameter(request, "rediualspc", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBsa(JSPUtil.getParameter(request, "bsa", ""));
		setUsedspc(JSPUtil.getParameter(request, "usedspc", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetForecastedSeaInventoryVO[]
	 */
	public GetForecastedSeaInventoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetForecastedSeaInventoryVO[]
	 */
	public GetForecastedSeaInventoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetForecastedSeaInventoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] ration = (JSPUtil.getParameter(request, prefix	+ "ration", length));
			String[] unusedspc = (JSPUtil.getParameter(request, prefix	+ "unusedspc", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] land = (JSPUtil.getParameter(request, prefix	+ "land", length));
			String[] lastport = (JSPUtil.getParameter(request, prefix	+ "lastport", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rediualspc = (JSPUtil.getParameter(request, prefix	+ "rediualspc", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] usedspc = (JSPUtil.getParameter(request, prefix	+ "usedspc", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetForecastedSeaInventoryVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (ration[i] != null)
					model.setRation(ration[i]);
				if (unusedspc[i] != null)
					model.setUnusedspc(unusedspc[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (land[i] != null)
					model.setLand(land[i]);
				if (lastport[i] != null)
					model.setLastport(lastport[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rediualspc[i] != null)
					model.setRediualspc(rediualspc[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (usedspc[i] != null)
					model.setUsedspc(usedspc[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetForecastedSeaInventoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetForecastedSeaInventoryVO[]
	 */
	public GetForecastedSeaInventoryVO[] getGetForecastedSeaInventoryVOs(){
		GetForecastedSeaInventoryVO[] vos = (GetForecastedSeaInventoryVO[])models.toArray(new GetForecastedSeaInventoryVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ration = this.ration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unusedspc = this.unusedspc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.land = this.land .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastport = this.lastport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rediualspc = this.rediualspc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedspc = this.usedspc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
