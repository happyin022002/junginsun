/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdQtyInfoVO.java
*@FileTitle : PrdQtyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.12 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

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

public class PrdQtyInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdQtyInfoVO> models = new ArrayList<PrdQtyInfoVO>();
	
	/* Column Info */
	private String cQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cTpsz = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrdQtyInfoVO() {}

	public PrdQtyInfoVO(String ibflag, String pagerows, String cTpsz, String cQty) {
		this.cQty = cQty;
		this.ibflag = ibflag;
		this.cTpsz = cTpsz;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("c_qty", getCQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_tpsz", getCTpsz());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("c_qty", "cQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_tpsz", "cTpsz");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cQty
	 */
	public String getCQty() {
		return this.cQty;
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
	 * @return cTpsz
	 */
	public String getCTpsz() {
		return this.cTpsz;
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
	 * @param cQty
	 */
	public void setCQty(String cQty) {
		this.cQty = cQty;
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
	 * @param cTpsz
	 */
	public void setCTpsz(String cTpsz) {
		this.cTpsz = cTpsz;
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
		setCQty(JSPUtil.getParameter(request, "c_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCTpsz(JSPUtil.getParameter(request, "c_tpsz", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdQtyInfoVO[]
	 */
	public PrdQtyInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdQtyInfoVO[]
	 */
	public PrdQtyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdQtyInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cQty = (JSPUtil.getParameter(request, prefix	+ "c_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cTpsz = (JSPUtil.getParameter(request, prefix	+ "c_tpsz", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdQtyInfoVO();
				if (cQty[i] != null)
					model.setCQty(cQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cTpsz[i] != null)
					model.setCTpsz(cTpsz[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdQtyInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdQtyInfoVO[]
	 */
	public PrdQtyInfoVO[] getPrdQtyInfoVOs(){
		PrdQtyInfoVO[] vos = (PrdQtyInfoVO[])models.toArray(new PrdQtyInfoVO[models.size()]);
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
		this.cQty = this.cQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cTpsz = this.cTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
