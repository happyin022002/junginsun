/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VosiUpdateMonitoringConditionVO.java
*@FileTitle : VosiUpdateMonitoringConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.10 김종옥 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VosiUpdateMonitoringConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VosiUpdateMonitoringConditionVO> models = new ArrayList<VosiUpdateMonitoringConditionVO>();
	
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String selDate = null;
	/* Column Info */
	private String rhq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VosiUpdateMonitoringConditionVO() {}

	public VosiUpdateMonitoringConditionVO(String ibflag, String pagerows, String locCd, String rhq, String selDate) {
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.selDate = selDate;
		this.rhq = rhq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sel_date", getSelDate());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sel_date", "selDate");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return selDate
	 */
	public String getSelDate() {
		return this.selDate;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param selDate
	 */
	public void setSelDate(String selDate) {
		this.selDate = selDate;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
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
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSelDate(JSPUtil.getParameter(request, "sel_date", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VosiUpdateMonitoringConditionVO[]
	 */
	public VosiUpdateMonitoringConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VosiUpdateMonitoringConditionVO[]
	 */
	public VosiUpdateMonitoringConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VosiUpdateMonitoringConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] selDate = (JSPUtil.getParameter(request, prefix	+ "sel_date", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VosiUpdateMonitoringConditionVO();
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (selDate[i] != null)
					model.setSelDate(selDate[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVosiUpdateMonitoringConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VosiUpdateMonitoringConditionVO[]
	 */
	public VosiUpdateMonitoringConditionVO[] getVosiUpdateMonitoringConditionVOs(){
		VosiUpdateMonitoringConditionVO[] vos = (VosiUpdateMonitoringConditionVO[])models.toArray(new VosiUpdateMonitoringConditionVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selDate = this.selDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
