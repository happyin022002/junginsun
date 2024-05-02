/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomInvoiceVO.java
*@FileTitle : CustomInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.16 정윤태
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0016HTMLAction
 */

public class CustomInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomInvoiceVO> models = new ArrayList<CustomInvoiceVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String vslCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String creUsrId = null;
	/* 而щ읆 �ㅻ챸 */
	private String updUsrId = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtNo = null;
	/* Column Info */
	private String chtrPayRcvCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CustomInvoiceVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String vslCd, String creUsrId, String updUsrId
	 * @return 
	 */
	public CustomInvoiceVO(String ibflag, String pagerows, String fletCtrtNo, String vslCd, String creUsrId, String updUsrId, String chtrPayRcvCd) {
		this.vslCd = vslCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.ibflag = ibflag;
		this.fletCtrtNo = fletCtrtNo;
		this.chtrPayRcvCd = chtrPayRcvCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("chtr_pay_rcv_cd", getChtrPayRcvCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("chtr_pay_rcv_cd", "chtrPayRcvCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getVslCd() {
		return this.vslCd;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getChtrPayRcvCd() {
		return this.chtrPayRcvCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setChtrPayRcvCd(String chtrPayRcvCd) {
		this.chtrPayRcvCd = chtrPayRcvCd;
		//this.chtrPayRcvCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setChtrPayRcvCd(JSPUtil.getParameter(request, "chtr_pay_rcv_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] chtrPayRcvCd = (JSPUtil.getParameter(request, prefix	+ "chtr_pay_rcv_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomInvoiceVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (chtrPayRcvCd[i] != null)
					model.setChtrPayRcvCd(chtrPayRcvCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomInvoiceVOs();
	}

	public CustomInvoiceVO[] getCustomInvoiceVOs(){
		CustomInvoiceVO[] vos = (CustomInvoiceVO[])models.toArray(new CustomInvoiceVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrPayRcvCd = this.chtrPayRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
