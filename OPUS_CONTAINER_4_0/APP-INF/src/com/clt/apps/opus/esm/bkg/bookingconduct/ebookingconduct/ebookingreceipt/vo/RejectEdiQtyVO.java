/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RejectEdiQtyVO.java
*@FileTitle : RejectEdiQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.03 전용진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RejectEdiQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RejectEdiQtyVO> models = new ArrayList<RejectEdiQtyVO>();
	
	/* Column Info */
	private String aQtyCntrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aQtyBqtyQty = null;
	/* Column Info */
	private String aQtyItyp = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RejectEdiQtyVO() {}

	public RejectEdiQtyVO(String ibflag, String pagerows, String aQtyCntrCd, String aQtyItyp, String aQtyBqtyQty) {
		this.aQtyCntrCd = aQtyCntrCd;
		this.ibflag = ibflag;
		this.aQtyBqtyQty = aQtyBqtyQty;
		this.aQtyItyp = aQtyItyp;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("a_qty_cntr_cd", getAQtyCntrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("a_qty_bqty_qty", getAQtyBqtyQty());
		this.hashColumns.put("a_qty_ityp", getAQtyItyp());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("a_qty_cntr_cd", "aQtyCntrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("a_qty_bqty_qty", "aQtyBqtyQty");
		this.hashFields.put("a_qty_ityp", "aQtyItyp");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aQtyCntrCd
	 */
	public String getAQtyCntrCd() {
		return this.aQtyCntrCd;
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
	 * @return aQtyBqtyQty
	 */
	public String getAQtyBqtyQty() {
		return this.aQtyBqtyQty;
	}
	
	/**
	 * Column Info
	 * @return aQtyItyp
	 */
	public String getAQtyItyp() {
		return this.aQtyItyp;
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
	 * @param aQtyCntrCd
	 */
	public void setAQtyCntrCd(String aQtyCntrCd) {
		this.aQtyCntrCd = aQtyCntrCd;
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
	 * @param aQtyBqtyQty
	 */
	public void setAQtyBqtyQty(String aQtyBqtyQty) {
		this.aQtyBqtyQty = aQtyBqtyQty;
	}
	
	/**
	 * Column Info
	 * @param aQtyItyp
	 */
	public void setAQtyItyp(String aQtyItyp) {
		this.aQtyItyp = aQtyItyp;
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
		setAQtyCntrCd(JSPUtil.getParameter(request, "a_qty_cntr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAQtyBqtyQty(JSPUtil.getParameter(request, "a_qty_bqty_qty", ""));
		setAQtyItyp(JSPUtil.getParameter(request, "a_qty_ityp", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RejectEdiQtyVO[]
	 */
	public RejectEdiQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RejectEdiQtyVO[]
	 */
	public RejectEdiQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RejectEdiQtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aQtyCntrCd = (JSPUtil.getParameter(request, prefix	+ "a_qty_cntr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aQtyBqtyQty = (JSPUtil.getParameter(request, prefix	+ "a_qty_bqty_qty", length));
			String[] aQtyItyp = (JSPUtil.getParameter(request, prefix	+ "a_qty_ityp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RejectEdiQtyVO();
				if (aQtyCntrCd[i] != null)
					model.setAQtyCntrCd(aQtyCntrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aQtyBqtyQty[i] != null)
					model.setAQtyBqtyQty(aQtyBqtyQty[i]);
				if (aQtyItyp[i] != null)
					model.setAQtyItyp(aQtyItyp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRejectEdiQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RejectEdiQtyVO[]
	 */
	public RejectEdiQtyVO[] getRejectEdiQtyVOs(){
		RejectEdiQtyVO[] vos = (RejectEdiQtyVO[])models.toArray(new RejectEdiQtyVO[models.size()]);
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
		this.aQtyCntrCd = this.aQtyCntrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aQtyBqtyQty = this.aQtyBqtyQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aQtyItyp = this.aQtyItyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
