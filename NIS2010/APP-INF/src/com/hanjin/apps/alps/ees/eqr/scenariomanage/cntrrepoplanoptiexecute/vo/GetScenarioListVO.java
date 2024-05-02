/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetScenarioListVO.java
*@FileTitle : GetScenarioListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.28 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetScenarioListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetScenarioListVO> models = new ArrayList<GetScenarioListVO>();
	
	/* Column Info */
	private String scnrRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scnrWk = null;
	/* Column Info */
	private String scnrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetScenarioListVO() {}

	public GetScenarioListVO(String ibflag, String pagerows, String scnrId, String scnrRmk, String scnrWk) {
		this.scnrRmk = scnrRmk;
		this.ibflag = ibflag;
		this.scnrWk = scnrWk;
		this.scnrId = scnrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scnr_rmk", getScnrRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scnr_wk", getScnrWk());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scnr_rmk", "scnrRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scnr_wk", "scnrWk");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scnrRmk
	 */
	public String getScnrRmk() {
		return this.scnrRmk;
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
	 * @return scnrWk
	 */
	public String getScnrWk() {
		return this.scnrWk;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
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
	 * @param scnrRmk
	 */
	public void setScnrRmk(String scnrRmk) {
		this.scnrRmk = scnrRmk;
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
	 * @param scnrWk
	 */
	public void setScnrWk(String scnrWk) {
		this.scnrWk = scnrWk;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
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
		setScnrRmk(JSPUtil.getParameter(request, "scnr_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScnrWk(JSPUtil.getParameter(request, "scnr_wk", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetScenarioListVO[]
	 */
	public GetScenarioListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetScenarioListVO[]
	 */
	public GetScenarioListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetScenarioListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scnrRmk = (JSPUtil.getParameter(request, prefix	+ "scnr_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scnrWk = (JSPUtil.getParameter(request, prefix	+ "scnr_wk", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetScenarioListVO();
				if (scnrRmk[i] != null)
					model.setScnrRmk(scnrRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scnrWk[i] != null)
					model.setScnrWk(scnrWk[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetScenarioListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetScenarioListVO[]
	 */
	public GetScenarioListVO[] getGetScenarioListVOs(){
		GetScenarioListVO[] vos = (GetScenarioListVO[])models.toArray(new GetScenarioListVO[models.size()]);
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
		this.scnrRmk = this.scnrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrWk = this.scnrWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
