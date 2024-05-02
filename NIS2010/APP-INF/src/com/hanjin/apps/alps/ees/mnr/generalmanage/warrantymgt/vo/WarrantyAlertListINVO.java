/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyAlertListINVO.java
*@FileTitle : WarrantyAlertListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.05 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo;

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

public class WarrantyAlertListINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WarrantyAlertListINVO> models = new ArrayList<WarrantyAlertListINVO>();
	
	/* Column Info */
	private String toLotPlnYr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmLotPlnYr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public WarrantyAlertListINVO() {}

	/**
	 * WarrantyAlertListINVO을 생성함 
	 */    
	public WarrantyAlertListINVO(String ibflag, String pagerows, String fmLotPlnYr, String toLotPlnYr) {
		this.toLotPlnYr = toLotPlnYr;
		this.ibflag = ibflag;
		this.fmLotPlnYr = fmLotPlnYr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_lot_pln_yr", getToLotPlnYr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_lot_pln_yr", getFmLotPlnYr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_lot_pln_yr", "toLotPlnYr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_lot_pln_yr", "fmLotPlnYr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toLotPlnYr
	 */
	public String getToLotPlnYr() {
		return this.toLotPlnYr;
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
	 * @return fmLotPlnYr
	 */
	public String getFmLotPlnYr() {
		return this.fmLotPlnYr;
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
	 * @param toLotPlnYr
	 */
	public void setToLotPlnYr(String toLotPlnYr) {
		this.toLotPlnYr = toLotPlnYr;
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
	 * @param fmLotPlnYr
	 */
	public void setFmLotPlnYr(String fmLotPlnYr) {
		this.fmLotPlnYr = fmLotPlnYr;
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
		setToLotPlnYr(JSPUtil.getParameter(request, "to_lot_pln_yr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmLotPlnYr(JSPUtil.getParameter(request, "fm_lot_pln_yr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WarrantyAlertListINVO[]
	 */
	public WarrantyAlertListINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WarrantyAlertListINVO[]
	 */
	public WarrantyAlertListINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WarrantyAlertListINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toLotPlnYr = (JSPUtil.getParameter(request, prefix	+ "to_lot_pln_yr".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fmLotPlnYr = (JSPUtil.getParameter(request, prefix	+ "fm_lot_pln_yr".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new WarrantyAlertListINVO();
				if (toLotPlnYr[i] != null)
					model.setToLotPlnYr(toLotPlnYr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmLotPlnYr[i] != null)
					model.setFmLotPlnYr(fmLotPlnYr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWarrantyAlertListINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WarrantyAlertListINVO[]
	 */
	public WarrantyAlertListINVO[] getWarrantyAlertListINVOs(){
		WarrantyAlertListINVO[] vos = (WarrantyAlertListINVO[])models.toArray(new WarrantyAlertListINVO[models.size()]);
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
		this.toLotPlnYr = this.toLotPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLotPlnYr = this.fmLotPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
