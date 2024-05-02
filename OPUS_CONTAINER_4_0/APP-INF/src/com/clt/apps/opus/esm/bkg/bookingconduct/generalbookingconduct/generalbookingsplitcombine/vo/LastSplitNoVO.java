/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LastSplitNoVO.java
*@FileTitle : LastSplitNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.08 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class LastSplitNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LastSplitNoVO> models = new ArrayList<LastSplitNoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgsplitno = null;
	/* Column Info */
	private String custsplitno = null;
	/* Column Info */
	private String memosplitno = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public LastSplitNoVO() {}

	public LastSplitNoVO(String ibflag, String pagerows, String custsplitno, String memosplitno, String bkgsplitno) {
		this.ibflag = ibflag;
		this.bkgsplitno = bkgsplitno;
		this.custsplitno = custsplitno;
		this.memosplitno = memosplitno;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkgsplitno", getBkgsplitno());
		this.hashColumns.put("custsplitno", getCustsplitno());
		this.hashColumns.put("memosplitno", getMemosplitno());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkgsplitno", "bkgsplitno");
		this.hashFields.put("custsplitno", "custsplitno");
		this.hashFields.put("memosplitno", "memosplitno");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return bkgsplitno
	 */
	public String getBkgsplitno() {
		return this.bkgsplitno;
	}
	
	/**
	 * Column Info
	 * @return custsplitno
	 */
	public String getCustsplitno() {
		return this.custsplitno;
	}
	
	/**
	 * Column Info
	 * @return memosplitno
	 */
	public String getMemosplitno() {
		return this.memosplitno;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param bkgsplitno
	 */
	public void setBkgsplitno(String bkgsplitno) {
		this.bkgsplitno = bkgsplitno;
	}
	
	/**
	 * Column Info
	 * @param custsplitno
	 */
	public void setCustsplitno(String custsplitno) {
		this.custsplitno = custsplitno;
	}
	
	/**
	 * Column Info
	 * @param memosplitno
	 */
	public void setMemosplitno(String memosplitno) {
		this.memosplitno = memosplitno;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgsplitno(JSPUtil.getParameter(request, "bkgsplitno", ""));
		setCustsplitno(JSPUtil.getParameter(request, "custsplitno", ""));
		setMemosplitno(JSPUtil.getParameter(request, "memosplitno", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LastSplitNoVO[]
	 */
	public LastSplitNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LastSplitNoVO[]
	 */
	public LastSplitNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LastSplitNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgsplitno = (JSPUtil.getParameter(request, prefix	+ "bkgsplitno", length));
			String[] custsplitno = (JSPUtil.getParameter(request, prefix	+ "custsplitno", length));
			String[] memosplitno = (JSPUtil.getParameter(request, prefix	+ "memosplitno", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new LastSplitNoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgsplitno[i] != null)
					model.setBkgsplitno(bkgsplitno[i]);
				if (custsplitno[i] != null)
					model.setCustsplitno(custsplitno[i]);
				if (memosplitno[i] != null)
					model.setMemosplitno(memosplitno[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLastSplitNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LastSplitNoVO[]
	 */
	public LastSplitNoVO[] getLastSplitNoVOs(){
		LastSplitNoVO[] vos = (LastSplitNoVO[])models.toArray(new LastSplitNoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgsplitno = this.bkgsplitno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custsplitno = this.custsplitno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.memosplitno = this.memosplitno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
