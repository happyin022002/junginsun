/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongSearchQtyVO.java
*@FileTitle : HongKongSearchQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.20 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HongKongSearchQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HongKongSearchQtyVO> models = new ArrayList<HongKongSearchQtyVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String hantype = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HongKongSearchQtyVO() {}

	public HongKongSearchQtyVO(String ibflag, String pagerows, String hantype, String opCntrQty) {
		this.ibflag = ibflag;
		this.opCntrQty = opCntrQty;
		this.hantype = hantype;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("hantype", getHantype());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("hantype", "hantype");
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
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return hantype
	 */
	public String getHantype() {
		return this.hantype;
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
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param hantype
	 */
	public void setHantype(String hantype) {
		this.hantype = hantype;
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
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setHantype(JSPUtil.getParameter(request, "hantype", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HongKongSearchQtyVO[]
	 */
	public HongKongSearchQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HongKongSearchQtyVO[]
	 */
	public HongKongSearchQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HongKongSearchQtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] hantype = (JSPUtil.getParameter(request, prefix	+ "hantype", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new HongKongSearchQtyVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (hantype[i] != null)
					model.setHantype(hantype[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHongKongSearchQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HongKongSearchQtyVO[]
	 */
	public HongKongSearchQtyVO[] getHongKongSearchQtyVOs(){
		HongKongSearchQtyVO[] vos = (HongKongSearchQtyVO[])models.toArray(new HongKongSearchQtyVO[models.size()]);
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
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hantype = this.hantype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
