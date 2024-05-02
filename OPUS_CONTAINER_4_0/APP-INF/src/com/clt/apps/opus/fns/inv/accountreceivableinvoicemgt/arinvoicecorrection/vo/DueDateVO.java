/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DueDateVO.java
*@FileTitle : DueDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.06.18 김세일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 김세일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DueDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DueDateVO> models = new ArrayList<DueDateVO>();
	
	/* Column Info */
	private String crTermDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crFlg = null;
	/* Column Info */
	private String dueDate = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DueDateVO() {}

	public DueDateVO(String ibflag, String pagerows, String crFlg, String dueDate, String crTermDys) {
		this.crTermDys = crTermDys;
		this.ibflag = ibflag;
		this.crFlg = crFlg;
		this.dueDate = dueDate;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cr_term_dys", getCrTermDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cr_flg", getCrFlg());
		this.hashColumns.put("due_date", getDueDate());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("due_date", "dueDate");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crTermDys
	 */
	public String getCrTermDys() {
		return this.crTermDys;
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
	 * @return crFlg
	 */
	public String getCrFlg() {
		return this.crFlg;
	}
	
	/**
	 * Column Info
	 * @return dueDate
	 */
	public String getDueDate() {
		return this.dueDate;
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
	 * @param crTermDys
	 */
	public void setCrTermDys(String crTermDys) {
		this.crTermDys = crTermDys;
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
	 * @param crFlg
	 */
	public void setCrFlg(String crFlg) {
		this.crFlg = crFlg;
	}
	
	/**
	 * Column Info
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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
		setCrTermDys(JSPUtil.getParameter(request, "cr_term_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrFlg(JSPUtil.getParameter(request, "cr_flg", ""));
		setDueDate(JSPUtil.getParameter(request, "due_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DueDateVO[]
	 */
	public DueDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DueDateVO[]
	 */
	public DueDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DueDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crTermDys = (JSPUtil.getParameter(request, prefix	+ "cr_term_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crFlg = (JSPUtil.getParameter(request, prefix	+ "cr_flg", length));
			String[] dueDate = (JSPUtil.getParameter(request, prefix	+ "due_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DueDateVO();
				if (crTermDys[i] != null)
					model.setCrTermDys(crTermDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crFlg[i] != null)
					model.setCrFlg(crFlg[i]);
				if (dueDate[i] != null)
					model.setDueDate(dueDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDueDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DueDateVO[]
	 */
	public DueDateVO[] getDueDateVOs(){
		DueDateVO[] vos = (DueDateVO[])models.toArray(new DueDateVO[models.size()]);
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
		this.crTermDys = this.crTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg = this.crFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDate = this.dueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
