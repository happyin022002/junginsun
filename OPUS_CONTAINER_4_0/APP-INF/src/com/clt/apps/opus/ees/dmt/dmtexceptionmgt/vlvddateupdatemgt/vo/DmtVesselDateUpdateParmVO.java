/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtVesselDateUpdateParmVO.java
*@FileTitle : DmtVesselDateUpdateParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : Kim Jae Jin
*@LastVersion : 1.0
* 2009.08.25 Kim Jae Jin 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo;

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
 * @author Kim Jae Jin
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtVesselDateUpdateParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtVesselDateUpdateParmVO> models = new ArrayList<DmtVesselDateUpdateParmVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String frdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmt = null;
	/* Column Info */
	private String todt = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String vvdc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtVesselDateUpdateParmVO() {}

	public DmtVesselDateUpdateParmVO(String ibflag, String pagerows, String mvmt, String type, String port, String frdt, String todt, String vvdc) {
		this.port = port;
		this.frdt = frdt;
		this.ibflag = ibflag;
		this.mvmt = mvmt;
		this.todt = todt;
		this.type = type;
		this.vvdc = vvdc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("frdt", getFrdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt", getMvmt());
		this.hashColumns.put("todt", getTodt());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("vvdc", getVvdc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("frdt", "frdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt", "mvmt");
		this.hashFields.put("todt", "todt");
		this.hashFields.put("type", "type");
		this.hashFields.put("vvdc", "vvdc");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return frdt
	 */
	public String getFrdt() {
		return this.frdt;
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
	 * @return mvmt
	 */
	public String getMvmt() {
		return this.mvmt;
	}
	
	/**
	 * Column Info
	 * @return todt
	 */
	public String getTodt() {
		return this.todt;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return vvdc
	 */
	public String getVvdc() {
		return this.vvdc;
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
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param frdt
	 */
	public void setFrdt(String frdt) {
		this.frdt = frdt;
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
	 * @param mvmt
	 */
	public void setMvmt(String mvmt) {
		this.mvmt = mvmt;
	}
	
	/**
	 * Column Info
	 * @param todt
	 */
	public void setTodt(String todt) {
		this.todt = todt;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param vvdc
	 */
	public void setVvdc(String vvdc) {
		this.vvdc = vvdc;
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
		setPort(JSPUtil.getParameter(request, "port", ""));
		setFrdt(JSPUtil.getParameter(request, "frdt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMvmt(JSPUtil.getParameter(request, "mvmt", ""));
		setTodt(JSPUtil.getParameter(request, "todt", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setVvdc(JSPUtil.getParameter(request, "vvdc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtVesselDateUpdateParmVO[]
	 */
	public DmtVesselDateUpdateParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtVesselDateUpdateParmVO[]
	 */
	public DmtVesselDateUpdateParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtVesselDateUpdateParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] frdt = (JSPUtil.getParameter(request, prefix	+ "frdt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmt = (JSPUtil.getParameter(request, prefix	+ "mvmt", length));
			String[] todt = (JSPUtil.getParameter(request, prefix	+ "todt", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] vvdc = (JSPUtil.getParameter(request, prefix	+ "vvdc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtVesselDateUpdateParmVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (frdt[i] != null)
					model.setFrdt(frdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmt[i] != null)
					model.setMvmt(mvmt[i]);
				if (todt[i] != null)
					model.setTodt(todt[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (vvdc[i] != null)
					model.setVvdc(vvdc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtVesselDateUpdateParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtVesselDateUpdateParmVO[]
	 */
	public DmtVesselDateUpdateParmVO[] getDmtVesselDateUpdateParmVOs(){
		DmtVesselDateUpdateParmVO[] vos = (DmtVesselDateUpdateParmVO[])models.toArray(new DmtVesselDateUpdateParmVO[models.size()]);
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
		this.frdt = this.frdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmt = this.mvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todt = this.todt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdc = this.vvdc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
