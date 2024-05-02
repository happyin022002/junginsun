/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRMvmtINVO.java
*@FileTitle : CNTRMvmtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.22 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSCNTRMvmtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSCNTRMvmtINVO> models = new ArrayList<MGSCNTRMvmtINVO>();
	
	/* Column Info */
	private String pCntrno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String checkDigit = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSCNTRMvmtINVO() {}

	public MGSCNTRMvmtINVO(String ibflag, String pagerows, String checkDigit, String pCntrno) {
		this.pCntrno = pCntrno;
		this.ibflag = ibflag;
		this.checkDigit = checkDigit;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
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
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
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
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
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
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
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
		setPCntrno(JSPUtil.getParameter(request, "p_cntrno", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCheckDigit(JSPUtil.getParameter(request, "check_digit", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CNTRMvmtINVO[]
	 */
	public MGSCNTRMvmtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CNTRMvmtINVO[]
	 */
	public MGSCNTRMvmtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSCNTRMvmtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSCNTRMvmtINVO();
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCNTRMvmtINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CNTRMvmtINVO[]
	 */
	public MGSCNTRMvmtINVO[] getCNTRMvmtINVOs(){
		MGSCNTRMvmtINVO[] vos = (MGSCNTRMvmtINVO[])models.toArray(new MGSCNTRMvmtINVO[models.size()]);
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
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
