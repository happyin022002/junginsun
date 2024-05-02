/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaDeliveryOrderManageVO.java
*@FileTitle : UsaDeliveryOrderManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaDeliveryOrderManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaDeliveryOrderManageVO> models = new ArrayList<UsaDeliveryOrderManageVO>();
	
	/* Column Info */
	private String formUsrOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bookingNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String billNo = null;
	/* Column Info */
	private String formCreUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaDeliveryOrderManageVO() {}

	public UsaDeliveryOrderManageVO(String ibflag, String pagerows, String billNo, String bookingNo, String creUsrId, String usrOfcCd, String formCreUsrId, String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
		this.creUsrId = creUsrId;
		this.bookingNo = bookingNo;
		this.ibflag = ibflag;
		this.usrOfcCd = usrOfcCd;
		this.billNo = billNo;
		this.formCreUsrId = formCreUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("form_usr_ofc_cd", getFormUsrOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("booking_no", getBookingNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("bill_no", getBillNo());
		this.hashColumns.put("form_cre_usr_id", getFormCreUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("form_usr_ofc_cd", "formUsrOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("booking_no", "bookingNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("bill_no", "billNo");
		this.hashFields.put("form_cre_usr_id", "formCreUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return formUsrOfcCd
	 */
	public String getFormUsrOfcCd() {
		return this.formUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return bookingNo
	 */
	public String getBookingNo() {
		return this.bookingNo;
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
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return billNo
	 */
	public String getBillNo() {
		return this.billNo;
	}
	
	/**
	 * Column Info
	 * @return formCreUsrId
	 */
	public String getFormCreUsrId() {
		return this.formCreUsrId;
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
	 * @param formUsrOfcCd
	 */
	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param bookingNo
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
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
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param billNo
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	/**
	 * Column Info
	 * @param formCreUsrId
	 */
	public void setFormCreUsrId(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
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
		setFormUsrOfcCd(JSPUtil.getParameter(request, "form_usr_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBookingNo(JSPUtil.getParameter(request, "booking_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, "usr_ofc_cd", ""));
		setBillNo(JSPUtil.getParameter(request, "bill_no", ""));
		setFormCreUsrId(JSPUtil.getParameter(request, "form_cre_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaDeliveryOrderManageVO[]
	 */
	public UsaDeliveryOrderManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaDeliveryOrderManageVO[]
	 */
	public UsaDeliveryOrderManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaDeliveryOrderManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] formUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "form_usr_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bookingNo = (JSPUtil.getParameter(request, prefix	+ "booking_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] billNo = (JSPUtil.getParameter(request, prefix	+ "bill_no", length));
			String[] formCreUsrId = (JSPUtil.getParameter(request, prefix	+ "form_cre_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaDeliveryOrderManageVO();
				if (formUsrOfcCd[i] != null)
					model.setFormUsrOfcCd(formUsrOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bookingNo[i] != null)
					model.setBookingNo(bookingNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (billNo[i] != null)
					model.setBillNo(billNo[i]);
				if (formCreUsrId[i] != null)
					model.setFormCreUsrId(formCreUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaDeliveryOrderManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaDeliveryOrderManageVO[]
	 */
	public UsaDeliveryOrderManageVO[] getUsaDeliveryOrderManageVOs(){
		UsaDeliveryOrderManageVO[] vos = (UsaDeliveryOrderManageVO[])models.toArray(new UsaDeliveryOrderManageVO[models.size()]);
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
		this.formUsrOfcCd = this.formUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingNo = this.bookingNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billNo = this.billNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formCreUsrId = this.formCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
