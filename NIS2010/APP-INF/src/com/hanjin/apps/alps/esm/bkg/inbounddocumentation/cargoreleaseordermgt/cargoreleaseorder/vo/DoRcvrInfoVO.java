/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoRcvrInfoVO.java
*@FileTitle : DoRcvrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.08.17 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DoRcvrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoRcvrInfoVO> models = new ArrayList<DoRcvrInfoVO>();
	
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orderFlg = null;
	/* Column Info */
	private String rcvrCoNm = null;
	/* Column Info */
	private String pic = null;
	/* Column Info */
	private String custRefNm = null;
	/* Column Info */
	private String actCneeNm = null;
	/* Column Info */
	private String cntcPhnNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoRcvrInfoVO() {}

	public DoRcvrInfoVO(String ibflag, String pagerows, String bkgNo, String doNo, String rcvrCoNm, String cntcPhnNo, String pic, String actCneeNm, String custRefNm, String orderFlg) {
		this.doNo = doNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.orderFlg = orderFlg;
		this.rcvrCoNm = rcvrCoNm;
		this.pic = pic;
		this.custRefNm = custRefNm;
		this.actCneeNm = actCneeNm;
		this.cntcPhnNo = cntcPhnNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("order_flg", getOrderFlg());
		this.hashColumns.put("rcvr_co_nm", getRcvrCoNm());
		this.hashColumns.put("pic", getPic());
		this.hashColumns.put("cust_ref_nm", getCustRefNm());
		this.hashColumns.put("act_cnee_nm", getActCneeNm());
		this.hashColumns.put("cntc_phn_no", getCntcPhnNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("order_flg", "orderFlg");
		this.hashFields.put("rcvr_co_nm", "rcvrCoNm");
		this.hashFields.put("pic", "pic");
		this.hashFields.put("cust_ref_nm", "custRefNm");
		this.hashFields.put("act_cnee_nm", "actCneeNm");
		this.hashFields.put("cntc_phn_no", "cntcPhnNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return orderFlg
	 */
	public String getOrderFlg() {
		return this.orderFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvrCoNm
	 */
	public String getRcvrCoNm() {
		return this.rcvrCoNm;
	}
	
	/**
	 * Column Info
	 * @return pic
	 */
	public String getPic() {
		return this.pic;
	}
	
	/**
	 * Column Info
	 * @return custRefNm
	 */
	public String getCustRefNm() {
		return this.custRefNm;
	}
	
	/**
	 * Column Info
	 * @return actCneeNm
	 */
	public String getActCneeNm() {
		return this.actCneeNm;
	}
	
	/**
	 * Column Info
	 * @return cntcPhnNo
	 */
	public String getCntcPhnNo() {
		return this.cntcPhnNo;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param orderFlg
	 */
	public void setOrderFlg(String orderFlg) {
		this.orderFlg = orderFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvrCoNm
	 */
	public void setRcvrCoNm(String rcvrCoNm) {
		this.rcvrCoNm = rcvrCoNm;
	}
	
	/**
	 * Column Info
	 * @param pic
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	/**
	 * Column Info
	 * @param custRefNm
	 */
	public void setCustRefNm(String custRefNm) {
		this.custRefNm = custRefNm;
	}
	
	/**
	 * Column Info
	 * @param actCneeNm
	 */
	public void setActCneeNm(String actCneeNm) {
		this.actCneeNm = actCneeNm;
	}
	
	/**
	 * Column Info
	 * @param cntcPhnNo
	 */
	public void setCntcPhnNo(String cntcPhnNo) {
		this.cntcPhnNo = cntcPhnNo;
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
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrderFlg(JSPUtil.getParameter(request, "order_flg", ""));
		setRcvrCoNm(JSPUtil.getParameter(request, "rcvr_co_nm", ""));
		setPic(JSPUtil.getParameter(request, "pic", ""));
		setCustRefNm(JSPUtil.getParameter(request, "cust_ref_nm", ""));
		setActCneeNm(JSPUtil.getParameter(request, "act_cnee_nm", ""));
		setCntcPhnNo(JSPUtil.getParameter(request, "cntc_phn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoRcvrInfoVO[]
	 */
	public DoRcvrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoRcvrInfoVO[]
	 */
	public DoRcvrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoRcvrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orderFlg = (JSPUtil.getParameter(request, prefix	+ "order_flg", length));
			String[] rcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_co_nm", length));
			String[] pic = (JSPUtil.getParameter(request, prefix	+ "pic", length));
			String[] custRefNm = (JSPUtil.getParameter(request, prefix	+ "cust_ref_nm", length));
			String[] actCneeNm = (JSPUtil.getParameter(request, prefix	+ "act_cnee_nm", length));
			String[] cntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_phn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoRcvrInfoVO();
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orderFlg[i] != null)
					model.setOrderFlg(orderFlg[i]);
				if (rcvrCoNm[i] != null)
					model.setRcvrCoNm(rcvrCoNm[i]);
				if (pic[i] != null)
					model.setPic(pic[i]);
				if (custRefNm[i] != null)
					model.setCustRefNm(custRefNm[i]);
				if (actCneeNm[i] != null)
					model.setActCneeNm(actCneeNm[i]);
				if (cntcPhnNo[i] != null)
					model.setCntcPhnNo(cntcPhnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoRcvrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoRcvrInfoVO[]
	 */
	public DoRcvrInfoVO[] getDoRcvrInfoVOs(){
		DoRcvrInfoVO[] vos = (DoRcvrInfoVO[])models.toArray(new DoRcvrInfoVO[models.size()]);
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
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orderFlg = this.orderFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrCoNm = this.rcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pic = this.pic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNm = this.custRefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCneeNm = this.actCneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPhnNo = this.cntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
