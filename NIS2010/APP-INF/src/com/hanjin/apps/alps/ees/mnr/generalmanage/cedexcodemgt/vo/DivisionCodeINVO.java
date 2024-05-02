/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DivisionCodeINVO.java
*@FileTitle : DivisionCodeINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.10.14 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DivisionCodeINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DivisionCodeINVO> models = new ArrayList<DivisionCodeINVO>();
	
	/* Column Info */
	private String inCostGrpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inEqCmpoCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DivisionCodeINVO() {}

	public DivisionCodeINVO(String ibflag, String pagerows, String inCostGrpCd, String inEqCmpoCd) {
		this.inCostGrpCd = inCostGrpCd;
		this.ibflag = ibflag;
		this.inEqCmpoCd = inEqCmpoCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_cost_grp_cd", getInCostGrpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_eq_cmpo_cd", getInEqCmpoCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_cost_grp_cd", "inCostGrpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_eq_cmpo_cd", "inEqCmpoCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inCostGrpCd
	 */
	public String getInCostGrpCd() {
		return this.inCostGrpCd;
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
	 * @return inEqCmpoCd
	 */
	public String getInEqCmpoCd() {
		return this.inEqCmpoCd;
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
	 * @param inCostGrpCd
	 */
	public void setInCostGrpCd(String inCostGrpCd) {
		this.inCostGrpCd = inCostGrpCd;
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
	 * @param inEqCmpoCd
	 */
	public void setInEqCmpoCd(String inEqCmpoCd) {
		this.inEqCmpoCd = inEqCmpoCd;
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
		setInCostGrpCd(JSPUtil.getParameter(request, "in_cost_grp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInEqCmpoCd(JSPUtil.getParameter(request, "in_eq_cmpo_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DivisionCodeINVO[]
	 */
	public DivisionCodeINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DivisionCodeINVO[]
	 */
	public DivisionCodeINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DivisionCodeINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "in_cost_grp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inEqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "in_eq_cmpo_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DivisionCodeINVO();
				if (inCostGrpCd[i] != null)
					model.setInCostGrpCd(inCostGrpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inEqCmpoCd[i] != null)
					model.setInEqCmpoCd(inEqCmpoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDivisionCodeINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DivisionCodeINVO[]
	 */
	public DivisionCodeINVO[] getDivisionCodeINVOs(){
		DivisionCodeINVO[] vos = (DivisionCodeINVO[])models.toArray(new DivisionCodeINVO[models.size()]);
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
		this.inCostGrpCd = this.inCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEqCmpoCd = this.inEqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
