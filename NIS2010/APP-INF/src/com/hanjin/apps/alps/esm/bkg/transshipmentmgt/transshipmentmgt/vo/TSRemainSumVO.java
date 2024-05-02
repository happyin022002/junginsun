/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TSRemainSumVO.java
*@FileTitle : TSRemainSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.01 최영희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TSRemainSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TSRemainSumVO> models = new ArrayList<TSRemainSumVO>();
	
	/* Column Info */
	private String rf40 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ak40 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String dg40 = null;
	/* Column Info */
	private String ak20 = null;
	/* Column Info */
	private String sDay = null;
	/* Column Info */
	private String dg20 = null;
	/* Column Info */
	private String ft40 = null;
	/* Column Info */
	private String rf20 = null;
	/* Column Info */
	private String ft20 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TSRemainSumVO() {}

	public TSRemainSumVO(String ibflag, String pagerows, String ydCd, String sDay, String ft40, String ft20, String ak40, String ak20, String dg40, String dg20, String rf40, String rf20) {
		this.rf40 = rf40;
		this.ibflag = ibflag;
		this.ak40 = ak40;
		this.ydCd = ydCd;
		this.dg40 = dg40;
		this.ak20 = ak20;
		this.sDay = sDay;
		this.dg20 = dg20;
		this.ft40 = ft40;
		this.rf20 = rf20;
		this.ft20 = ft20;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf40", getRf40());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ak40", getAk40());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("dg40", getDg40());
		this.hashColumns.put("ak20", getAk20());
		this.hashColumns.put("s_day", getSDay());
		this.hashColumns.put("dg20", getDg20());
		this.hashColumns.put("ft40", getFt40());
		this.hashColumns.put("rf20", getRf20());
		this.hashColumns.put("ft20", getFt20());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf40", "rf40");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ak40", "ak40");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("dg40", "dg40");
		this.hashFields.put("ak20", "ak20");
		this.hashFields.put("s_day", "sDay");
		this.hashFields.put("dg20", "dg20");
		this.hashFields.put("ft40", "ft40");
		this.hashFields.put("rf20", "rf20");
		this.hashFields.put("ft20", "ft20");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rf40
	 */
	public String getRf40() {
		return this.rf40;
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
	 * @return ak40
	 */
	public String getAk40() {
		return this.ak40;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return dg40
	 */
	public String getDg40() {
		return this.dg40;
	}
	
	/**
	 * Column Info
	 * @return ak20
	 */
	public String getAk20() {
		return this.ak20;
	}
	
	/**
	 * Column Info
	 * @return sDay
	 */
	public String getSDay() {
		return this.sDay;
	}
	
	/**
	 * Column Info
	 * @return dg20
	 */
	public String getDg20() {
		return this.dg20;
	}
	
	/**
	 * Column Info
	 * @return ft40
	 */
	public String getFt40() {
		return this.ft40;
	}
	
	/**
	 * Column Info
	 * @return rf20
	 */
	public String getRf20() {
		return this.rf20;
	}
	
	/**
	 * Column Info
	 * @return ft20
	 */
	public String getFt20() {
		return this.ft20;
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
	 * @param rf40
	 */
	public void setRf40(String rf40) {
		this.rf40 = rf40;
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
	 * @param ak40
	 */
	public void setAk40(String ak40) {
		this.ak40 = ak40;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param dg40
	 */
	public void setDg40(String dg40) {
		this.dg40 = dg40;
	}
	
	/**
	 * Column Info
	 * @param ak20
	 */
	public void setAk20(String ak20) {
		this.ak20 = ak20;
	}
	
	/**
	 * Column Info
	 * @param sDay
	 */
	public void setSDay(String sDay) {
		this.sDay = sDay;
	}
	
	/**
	 * Column Info
	 * @param dg20
	 */
	public void setDg20(String dg20) {
		this.dg20 = dg20;
	}
	
	/**
	 * Column Info
	 * @param ft40
	 */
	public void setFt40(String ft40) {
		this.ft40 = ft40;
	}
	
	/**
	 * Column Info
	 * @param rf20
	 */
	public void setRf20(String rf20) {
		this.rf20 = rf20;
	}
	
	/**
	 * Column Info
	 * @param ft20
	 */
	public void setFt20(String ft20) {
		this.ft20 = ft20;
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
		setRf40(JSPUtil.getParameter(request, "rf40", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAk40(JSPUtil.getParameter(request, "ak40", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setDg40(JSPUtil.getParameter(request, "dg40", ""));
		setAk20(JSPUtil.getParameter(request, "ak20", ""));
		setSDay(JSPUtil.getParameter(request, "s_day", ""));
		setDg20(JSPUtil.getParameter(request, "dg20", ""));
		setFt40(JSPUtil.getParameter(request, "ft40", ""));
		setRf20(JSPUtil.getParameter(request, "rf20", ""));
		setFt20(JSPUtil.getParameter(request, "ft20", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSRemainSumVO[]
	 */
	public TSRemainSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TSRemainSumVO[]
	 */
	public TSRemainSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TSRemainSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rf40 = (JSPUtil.getParameter(request, prefix	+ "rf40".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ak40 = (JSPUtil.getParameter(request, prefix	+ "ak40".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] dg40 = (JSPUtil.getParameter(request, prefix	+ "dg40".trim(), length));
			String[] ak20 = (JSPUtil.getParameter(request, prefix	+ "ak20".trim(), length));
			String[] sDay = (JSPUtil.getParameter(request, prefix	+ "s_day".trim(), length));
			String[] dg20 = (JSPUtil.getParameter(request, prefix	+ "dg20".trim(), length));
			String[] ft40 = (JSPUtil.getParameter(request, prefix	+ "ft40".trim(), length));
			String[] rf20 = (JSPUtil.getParameter(request, prefix	+ "rf20".trim(), length));
			String[] ft20 = (JSPUtil.getParameter(request, prefix	+ "ft20".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TSRemainSumVO();
				if (rf40[i] != null)
					model.setRf40(rf40[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ak40[i] != null)
					model.setAk40(ak40[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (dg40[i] != null)
					model.setDg40(dg40[i]);
				if (ak20[i] != null)
					model.setAk20(ak20[i]);
				if (sDay[i] != null)
					model.setSDay(sDay[i]);
				if (dg20[i] != null)
					model.setDg20(dg20[i]);
				if (ft40[i] != null)
					model.setFt40(ft40[i]);
				if (rf20[i] != null)
					model.setRf20(rf20[i]);
				if (ft20[i] != null)
					model.setFt20(ft20[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTSRemainSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TSRemainSumVO[]
	 */
	public TSRemainSumVO[] getTSRemainSumVOs(){
		TSRemainSumVO[] vos = (TSRemainSumVO[])models.toArray(new TSRemainSumVO[models.size()]);
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
		this.rf40 = this.rf40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40 = this.ak40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40 = this.dg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20 = this.ak20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDay = this.sDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20 = this.dg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft40 = this.ft40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20 = this.rf20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft20 = this.ft20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
