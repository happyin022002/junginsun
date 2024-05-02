/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVesselSkdOptionsVO.java
*@FileTitle : SearchVesselSkdOptionsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.09.22 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVesselSkdOptionsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVesselSkdOptionsVO> models = new ArrayList<SearchVesselSkdOptionsVO>();
	
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String sdateHidden = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String edate = null;
	/* Column Info */
	private String edateHidden = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String sdate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVesselSkdOptionsVO() {}

	public SearchVesselSkdOptionsVO(String ibflag, String pagerows, String sdate, String edate, String sdateHidden, String edateHidden, String laneCd, String polCd, String locCd, String fCmd) {
		this.laneCd = laneCd;
		this.locCd = locCd;
		this.polCd = polCd;
		this.sdateHidden = sdateHidden;
		this.ibflag = ibflag;
		this.edate = edate;
		this.edateHidden = edateHidden;
		this.fCmd = fCmd;
		this.sdate = sdate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sdate_hidden", getSdateHidden());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("edate_hidden", getEdateHidden());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sdate_hidden", "sdateHidden");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("edate_hidden", "edateHidden");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return sdateHidden
	 */
	public String getSdateHidden() {
		return this.sdateHidden;
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
	 * @return edate
	 */
	public String getEdate() {
		return this.edate;
	}
	
	/**
	 * Column Info
	 * @return edateHidden
	 */
	public String getEdateHidden() {
		return this.edateHidden;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return sdate
	 */
	public String getSdate() {
		return this.sdate;
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
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param sdateHidden
	 */
	public void setSdateHidden(String sdateHidden) {
		this.sdateHidden = sdateHidden;
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
	 * @param edate
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * Column Info
	 * @param edateHidden
	 */
	public void setEdateHidden(String edateHidden) {
		this.edateHidden = edateHidden;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param sdate
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
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
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSdateHidden(JSPUtil.getParameter(request, "sdate_hidden", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdate(JSPUtil.getParameter(request, "edate", ""));
		setEdateHidden(JSPUtil.getParameter(request, "edate_hidden", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setSdate(JSPUtil.getParameter(request, "sdate", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVesselSkdOptionsVO[]
	 */
	public SearchVesselSkdOptionsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVesselSkdOptionsVO[]
	 */
	public SearchVesselSkdOptionsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVesselSkdOptionsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] sdateHidden = (JSPUtil.getParameter(request, prefix	+ "sdate_hidden", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "edate", length));
			String[] edateHidden = (JSPUtil.getParameter(request, prefix	+ "edate_hidden", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sdate", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVesselSkdOptionsVO();
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (sdateHidden[i] != null)
					model.setSdateHidden(sdateHidden[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (edate[i] != null)
					model.setEdate(edate[i]);
				if (edateHidden[i] != null)
					model.setEdateHidden(edateHidden[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVesselSkdOptionsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVesselSkdOptionsVO[]
	 */
	public SearchVesselSkdOptionsVO[] getSearchVesselSkdOptionsVOs(){
		SearchVesselSkdOptionsVO[] vos = (SearchVesselSkdOptionsVO[])models.toArray(new SearchVesselSkdOptionsVO[models.size()]);
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
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdateHidden = this.sdateHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edateHidden = this.edateHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
