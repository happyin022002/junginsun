/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OFMBlLineInfoVO.java
*@FileTitle : OFMBlLineInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.07 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OFMBlLineInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OFMBlLineInfoVO> models = new ArrayList<OFMBlLineInfoVO>();
	
	/* Column Info */
	private String itIttype = null;
	/* Column Info */
	private String itItno = null;
	/* Column Info */
	private String itIpiLocal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String buf1 = null;
	/* Column Info */
	private String itPkgAms = null;
	/* Column Info */
	private String itDel = null;
	/* Column Info */
	private String itLstUsa = null;
	/* Column Info */
	private String wgtVal = null;
	/* Column Info */
	private String itPkgQty = null;
	/* Column Info */
	private String itHub = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OFMBlLineInfoVO() {}

	public OFMBlLineInfoVO(String ibflag, String pagerows, String buf1, String itItno, String itIttype, String itHub, String itLstUsa, String itDel, String wgtVal, String itPkgQty, String itPkgAms, String itIpiLocal) {
		this.itIttype = itIttype;
		this.itItno = itItno;
		this.itIpiLocal = itIpiLocal;
		this.ibflag = ibflag;
		this.buf1 = buf1;
		this.itPkgAms = itPkgAms;
		this.itDel = itDel;
		this.itLstUsa = itLstUsa;
		this.wgtVal = wgtVal;
		this.itPkgQty = itPkgQty;
		this.itHub = itHub;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("it_ittype", getItIttype());
		this.hashColumns.put("it_itno", getItItno());
		this.hashColumns.put("it_ipi_local", getItIpiLocal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("buf1", getBuf1());
		this.hashColumns.put("it_pkg_ams", getItPkgAms());
		this.hashColumns.put("it_del", getItDel());
		this.hashColumns.put("it_lst_usa", getItLstUsa());
		this.hashColumns.put("wgt_val", getWgtVal());
		this.hashColumns.put("it_pkg_qty", getItPkgQty());
		this.hashColumns.put("it_hub", getItHub());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("it_ittype", "itIttype");
		this.hashFields.put("it_itno", "itItno");
		this.hashFields.put("it_ipi_local", "itIpiLocal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("buf1", "buf1");
		this.hashFields.put("it_pkg_ams", "itPkgAms");
		this.hashFields.put("it_del", "itDel");
		this.hashFields.put("it_lst_usa", "itLstUsa");
		this.hashFields.put("wgt_val", "wgtVal");
		this.hashFields.put("it_pkg_qty", "itPkgQty");
		this.hashFields.put("it_hub", "itHub");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return itIttype
	 */
	public String getItIttype() {
		return this.itIttype;
	}
	
	/**
	 * Column Info
	 * @return itItno
	 */
	public String getItItno() {
		return this.itItno;
	}
	
	/**
	 * Column Info
	 * @return itIpiLocal
	 */
	public String getItIpiLocal() {
		return this.itIpiLocal;
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
	 * @return buf1
	 */
	public String getBuf1() {
		return this.buf1;
	}
	
	/**
	 * Column Info
	 * @return itPkgAms
	 */
	public String getItPkgAms() {
		return this.itPkgAms;
	}
	
	/**
	 * Column Info
	 * @return itDel
	 */
	public String getItDel() {
		return this.itDel;
	}
	
	/**
	 * Column Info
	 * @return itLstUsa
	 */
	public String getItLstUsa() {
		return this.itLstUsa;
	}
	
	/**
	 * Column Info
	 * @return wgtVal
	 */
	public String getWgtVal() {
		return this.wgtVal;
	}
	
	/**
	 * Column Info
	 * @return itPkgQty
	 */
	public String getItPkgQty() {
		return this.itPkgQty;
	}
	
	/**
	 * Column Info
	 * @return itHub
	 */
	public String getItHub() {
		return this.itHub;
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
	 * @param itIttype
	 */
	public void setItIttype(String itIttype) {
		this.itIttype = itIttype;
	}
	
	/**
	 * Column Info
	 * @param itItno
	 */
	public void setItItno(String itItno) {
		this.itItno = itItno;
	}
	
	/**
	 * Column Info
	 * @param itIpiLocal
	 */
	public void setItIpiLocal(String itIpiLocal) {
		this.itIpiLocal = itIpiLocal;
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
	 * @param buf1
	 */
	public void setBuf1(String buf1) {
		this.buf1 = buf1;
	}
	
	/**
	 * Column Info
	 * @param itPkgAms
	 */
	public void setItPkgAms(String itPkgAms) {
		this.itPkgAms = itPkgAms;
	}
	
	/**
	 * Column Info
	 * @param itDel
	 */
	public void setItDel(String itDel) {
		this.itDel = itDel;
	}
	
	/**
	 * Column Info
	 * @param itLstUsa
	 */
	public void setItLstUsa(String itLstUsa) {
		this.itLstUsa = itLstUsa;
	}
	
	/**
	 * Column Info
	 * @param wgtVal
	 */
	public void setWgtVal(String wgtVal) {
		this.wgtVal = wgtVal;
	}
	
	/**
	 * Column Info
	 * @param itPkgQty
	 */
	public void setItPkgQty(String itPkgQty) {
		this.itPkgQty = itPkgQty;
	}
	
	/**
	 * Column Info
	 * @param itHub
	 */
	public void setItHub(String itHub) {
		this.itHub = itHub;
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
		setItIttype(JSPUtil.getParameter(request, "it_ittype", ""));
		setItItno(JSPUtil.getParameter(request, "it_itno", ""));
		setItIpiLocal(JSPUtil.getParameter(request, "it_ipi_local", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBuf1(JSPUtil.getParameter(request, "buf1", ""));
		setItPkgAms(JSPUtil.getParameter(request, "it_pkg_ams", ""));
		setItDel(JSPUtil.getParameter(request, "it_del", ""));
		setItLstUsa(JSPUtil.getParameter(request, "it_lst_usa", ""));
		setWgtVal(JSPUtil.getParameter(request, "wgt_val", ""));
		setItPkgQty(JSPUtil.getParameter(request, "it_pkg_qty", ""));
		setItHub(JSPUtil.getParameter(request, "it_hub", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OFMBlLineInfoVO[]
	 */
	public OFMBlLineInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OFMBlLineInfoVO[]
	 */
	public OFMBlLineInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OFMBlLineInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] itIttype = (JSPUtil.getParameter(request, prefix	+ "it_ittype", length));
			String[] itItno = (JSPUtil.getParameter(request, prefix	+ "it_itno", length));
			String[] itIpiLocal = (JSPUtil.getParameter(request, prefix	+ "it_ipi_local", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] buf1 = (JSPUtil.getParameter(request, prefix	+ "buf1", length));
			String[] itPkgAms = (JSPUtil.getParameter(request, prefix	+ "it_pkg_ams", length));
			String[] itDel = (JSPUtil.getParameter(request, prefix	+ "it_del", length));
			String[] itLstUsa = (JSPUtil.getParameter(request, prefix	+ "it_lst_usa", length));
			String[] wgtVal = (JSPUtil.getParameter(request, prefix	+ "wgt_val", length));
			String[] itPkgQty = (JSPUtil.getParameter(request, prefix	+ "it_pkg_qty", length));
			String[] itHub = (JSPUtil.getParameter(request, prefix	+ "it_hub", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OFMBlLineInfoVO();
				if (itIttype[i] != null)
					model.setItIttype(itIttype[i]);
				if (itItno[i] != null)
					model.setItItno(itItno[i]);
				if (itIpiLocal[i] != null)
					model.setItIpiLocal(itIpiLocal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (buf1[i] != null)
					model.setBuf1(buf1[i]);
				if (itPkgAms[i] != null)
					model.setItPkgAms(itPkgAms[i]);
				if (itDel[i] != null)
					model.setItDel(itDel[i]);
				if (itLstUsa[i] != null)
					model.setItLstUsa(itLstUsa[i]);
				if (wgtVal[i] != null)
					model.setWgtVal(wgtVal[i]);
				if (itPkgQty[i] != null)
					model.setItPkgQty(itPkgQty[i]);
				if (itHub[i] != null)
					model.setItHub(itHub[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOFMBlLineInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OFMBlLineInfoVO[]
	 */
	public OFMBlLineInfoVO[] getOFMBlLineInfoVOs(){
		OFMBlLineInfoVO[] vos = (OFMBlLineInfoVO[])models.toArray(new OFMBlLineInfoVO[models.size()]);
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
		this.itIttype = this.itIttype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itItno = this.itItno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itIpiLocal = this.itIpiLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.buf1 = this.buf1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itPkgAms = this.itPkgAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itDel = this.itDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itLstUsa = this.itLstUsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtVal = this.wgtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itPkgQty = this.itPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itHub = this.itHub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
