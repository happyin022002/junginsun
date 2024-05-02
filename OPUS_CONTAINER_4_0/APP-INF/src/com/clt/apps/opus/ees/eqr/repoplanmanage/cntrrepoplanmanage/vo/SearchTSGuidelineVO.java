/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTSGuidelineVO.java
*@FileTitle : TS Guideline Popup
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.09.03		1.0 최초 생성
*
*@LastModifyDate : 2009.09.03
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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

public class SearchTSGuidelineVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTSGuidelineVO> models = new ArrayList<SearchTSGuidelineVO>();
	
	/* Column Info */
	private String vol = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String tsport = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String lane2 = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String lane1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTSGuidelineVO() {}

	public SearchTSGuidelineVO(String ibflag, String pagerows, String lane1, String vvd1, String tsport, String lane2, String vvd2, String ts, String vol) {
		this.vol = vol;
		this.ibflag = ibflag;
		this.ts = ts;
		this.tsport = tsport;
		this.vvd2 = vvd2;
		this.lane2 = lane2;
		this.vvd1 = vvd1;
		this.lane1 = lane1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vol", getVol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("tsport", getTsport());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vol", "vol");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("tsport", "tsport");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vol
	 */
	public String getVol() {
		return this.vol;
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
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return tsport
	 */
	public String getTsport() {
		return this.tsport;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
	}
	
	/**
	 * Column Info
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
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
	 * @param vol
	 */
	public void setVol(String vol) {
		this.vol = vol;
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
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param tsport
	 */
	public void setTsport(String tsport) {
		this.tsport = tsport;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
	}
	
	/**
	 * Column Info
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
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
		setVol(JSPUtil.getParameter(request, "vol", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTs(JSPUtil.getParameter(request, "ts", ""));
		setTsport(JSPUtil.getParameter(request, "tsport", ""));
		setVvd2(JSPUtil.getParameter(request, "vvd2", ""));
		setLane2(JSPUtil.getParameter(request, "lane2", ""));
		setVvd1(JSPUtil.getParameter(request, "vvd1", ""));
		setLane1(JSPUtil.getParameter(request, "lane1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTSGuidelineVO[]
	 */
	public SearchTSGuidelineVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTSGuidelineVO[]
	 */
	public SearchTSGuidelineVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTSGuidelineVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vol = (JSPUtil.getParameter(request, prefix	+ "vol", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] tsport = (JSPUtil.getParameter(request, prefix	+ "tsport", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix	+ "lane2", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix	+ "lane1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTSGuidelineVO();
				if (vol[i] != null)
					model.setVol(vol[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (tsport[i] != null)
					model.setTsport(tsport[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTSGuidelineVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTSGuidelineVO[]
	 */
	public SearchTSGuidelineVO[] getSearchTSGuidelineVOs(){
		SearchTSGuidelineVO[] vos = (SearchTSGuidelineVO[])models.toArray(new SearchTSGuidelineVO[models.size()]);
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
		this.vol = this.vol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsport = this.tsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
