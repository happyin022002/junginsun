/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NewBkgSplitVO.java
*@FileTitle : NewBkgSplitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.16 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NewBkgSplitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NewBkgSplitVO> models = new ArrayList<NewBkgSplitVO>();
	
	/* Column Info */
	private String newBkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newBlNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NewBkgSplitVO() {}

	public NewBkgSplitVO(String ibflag, String pagerows, String newBkgNo, String newBlNo) {
		this.newBkgNo = newBkgNo;
		this.ibflag = ibflag;
		this.newBlNo = newBlNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_bkg_no", getNewBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_bl_no", getNewBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_bkg_no", "newBkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_bl_no", "newBlNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newBkgNo
	 */
	public String getNewBkgNo() {
		return this.newBkgNo;
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
	 * @return newBlNo
	 */
	public String getNewBlNo() {
		return this.newBlNo;
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
	 * @param newBkgNo
	 */
	public void setNewBkgNo(String newBkgNo) {
		this.newBkgNo = newBkgNo;
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
	 * @param newBlNo
	 */
	public void setNewBlNo(String newBlNo) {
		this.newBlNo = newBlNo;
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
		setNewBkgNo(JSPUtil.getParameter(request, "new_bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNewBlNo(JSPUtil.getParameter(request, "new_bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NewBkgSplitVO[]
	 */
	public NewBkgSplitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NewBkgSplitVO[]
	 */
	public NewBkgSplitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NewBkgSplitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newBkgNo = (JSPUtil.getParameter(request, prefix	+ "new_bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newBlNo = (JSPUtil.getParameter(request, prefix	+ "new_bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new NewBkgSplitVO();
				if (newBkgNo[i] != null)
					model.setNewBkgNo(newBkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newBlNo[i] != null)
					model.setNewBlNo(newBlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNewBkgSplitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NewBkgSplitVO[]
	 */
	public NewBkgSplitVO[] getNewBkgSplitVOs(){
		NewBkgSplitVO[] vos = (NewBkgSplitVO[])models.toArray(new NewBkgSplitVO[models.size()]);
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
		this.newBkgNo = this.newBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newBlNo = this.newBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
