/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PhaseInOutReasonVO.java
*@FileTitle : PhaseInOutReasonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.02 유혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

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
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PhaseInOutReasonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PhaseInOutReasonVO> models = new ArrayList<PhaseInOutReasonVO>();
	
	/* Column Info */
	private String rsnCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rsnName = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PhaseInOutReasonVO() {}

	public PhaseInOutReasonVO(String ibflag, String pagerows, String rsnCode, String rsnName) {
		this.rsnCode = rsnCode;
		this.ibflag = ibflag;
		this.rsnName = rsnName;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rsn_code", getRsnCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rsn_name", getRsnName());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rsn_code", "rsnCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rsn_name", "rsnName");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rsnCode
	 */
	public String getRsnCode() {
		return this.rsnCode;
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
	 * @return rsnName
	 */
	public String getRsnName() {
		return this.rsnName;
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
	 * @param rsnCode
	 */
	public void setRsnCode(String rsnCode) {
		this.rsnCode = rsnCode;
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
	 * @param rsnName
	 */
	public void setRsnName(String rsnName) {
		this.rsnName = rsnName;
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
		setRsnCode(JSPUtil.getParameter(request, "rsn_code", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRsnName(JSPUtil.getParameter(request, "rsn_name", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PhaseInOutReasonVO[]
	 */
	public PhaseInOutReasonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PhaseInOutReasonVO[]
	 */
	public PhaseInOutReasonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PhaseInOutReasonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rsnCode = (JSPUtil.getParameter(request, prefix	+ "rsn_code".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rsnName = (JSPUtil.getParameter(request, prefix	+ "rsn_name".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PhaseInOutReasonVO();
				if (rsnCode[i] != null)
					model.setRsnCode(rsnCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rsnName[i] != null)
					model.setRsnName(rsnName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPhaseInOutReasonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PhaseInOutReasonVO[]
	 */
	public PhaseInOutReasonVO[] getPhaseInOutReasonVOs(){
		PhaseInOutReasonVO[] vos = (PhaseInOutReasonVO[])models.toArray(new PhaseInOutReasonVO[models.size()]);
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
		this.rsnCode = this.rsnCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnName = this.rsnName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
