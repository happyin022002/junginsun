/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaResultVO.java
*@FileTitle : UsaResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.11.09 김도완 
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

public class UsaResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaResultVO> models = new ArrayList<UsaResultVO>();
	
	/* Column Info */
	private String itItno = null;
	/* Column Info */
	private String itCusjTqty = null;
	/* Column Info */
	private String yRlsQty = null;
	/* Column Info */
	private String yEntQty = null;
	/* Column Info */
	private String itQty = null;
	/* Column Info */
	private String itCusrTqty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String itIttype = null;
	/* Column Info */
	private String itIpiLocal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String itCgoCind = null;
	/* Column Info */
	private String remvQty = null;
	/* Column Info */
	private String itCstmcind = null;
	/* Column Info */
	private String itCuswTqty = null;
	/* Column Info */
	private String holdQty = null;
	/* Column Info */
	private String cusLoc = null;
	/* Column Info */
	private String wQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaResultVO() {}

	public UsaResultVO(String ibflag, String pagerows, String cusLoc, String itItno, String itIttype, String itIpiLocal, String itQty, String itCusrTqty, String itCstmcind, String itCgoCind, String itCusjTqty, String itCuswTqty, String holdQty, String remvQty, String yEntQty, String yRlsQty, String wQty) {
		this.itItno = itItno;
		this.itCusjTqty = itCusjTqty;
		this.yRlsQty = yRlsQty;
		this.yEntQty = yEntQty;
		this.itQty = itQty;
		this.itCusrTqty = itCusrTqty;
		this.pagerows = pagerows;
		this.itIttype = itIttype;
		this.itIpiLocal = itIpiLocal;
		this.ibflag = ibflag;
		this.itCgoCind = itCgoCind;
		this.remvQty = remvQty;
		this.itCstmcind = itCstmcind;
		this.itCuswTqty = itCuswTqty;
		this.holdQty = holdQty;
		this.cusLoc = cusLoc;
		this.wQty = wQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("it_itno", getItItno());
		this.hashColumns.put("it_cusj_tqty", getItCusjTqty());
		this.hashColumns.put("y_rls_qty", getYRlsQty());
		this.hashColumns.put("y_ent_qty", getYEntQty());
		this.hashColumns.put("it_qty", getItQty());
		this.hashColumns.put("it_cusr_tqty", getItCusrTqty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("it_ittype", getItIttype());
		this.hashColumns.put("it_ipi_local", getItIpiLocal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("it_cgo_cind", getItCgoCind());
		this.hashColumns.put("remv_qty", getRemvQty());
		this.hashColumns.put("it_cstmcind", getItCstmcind());
		this.hashColumns.put("it_cusw_tqty", getItCuswTqty());
		this.hashColumns.put("hold_qty", getHoldQty());
		this.hashColumns.put("cus_loc", getCusLoc());
		this.hashColumns.put("w_qty", getWQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("it_itno", "itItno");
		this.hashFields.put("it_cusj_tqty", "itCusjTqty");
		this.hashFields.put("y_rls_qty", "yRlsQty");
		this.hashFields.put("y_ent_qty", "yEntQty");
		this.hashFields.put("it_qty", "itQty");
		this.hashFields.put("it_cusr_tqty", "itCusrTqty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("it_ittype", "itIttype");
		this.hashFields.put("it_ipi_local", "itIpiLocal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("it_cgo_cind", "itCgoCind");
		this.hashFields.put("remv_qty", "remvQty");
		this.hashFields.put("it_cstmcind", "itCstmcind");
		this.hashFields.put("it_cusw_tqty", "itCuswTqty");
		this.hashFields.put("hold_qty", "holdQty");
		this.hashFields.put("cus_loc", "cusLoc");
		this.hashFields.put("w_qty", "wQty");
		return this.hashFields;
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
	 * @return itCusjTqty
	 */
	public String getItCusjTqty() {
		return this.itCusjTqty;
	}
	
	/**
	 * Column Info
	 * @return yRlsQty
	 */
	public String getYRlsQty() {
		return this.yRlsQty;
	}
	
	/**
	 * Column Info
	 * @return yEntQty
	 */
	public String getYEntQty() {
		return this.yEntQty;
	}
	
	/**
	 * Column Info
	 * @return itQty
	 */
	public String getItQty() {
		return this.itQty;
	}
	
	/**
	 * Column Info
	 * @return itCusrTqty
	 */
	public String getItCusrTqty() {
		return this.itCusrTqty;
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
	 * @return itIttype
	 */
	public String getItIttype() {
		return this.itIttype;
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
	 * @return itCgoCind
	 */
	public String getItCgoCind() {
		return this.itCgoCind;
	}
	
	/**
	 * Column Info
	 * @return remvQty
	 */
	public String getRemvQty() {
		return this.remvQty;
	}
	
	/**
	 * Column Info
	 * @return itCstmcind
	 */
	public String getItCstmcind() {
		return this.itCstmcind;
	}
	
	/**
	 * Column Info
	 * @return itCuswTqty
	 */
	public String getItCuswTqty() {
		return this.itCuswTqty;
	}
	
	/**
	 * Column Info
	 * @return holdQty
	 */
	public String getHoldQty() {
		return this.holdQty;
	}
	
	/**
	 * Column Info
	 * @return cusLoc
	 */
	public String getCusLoc() {
		return this.cusLoc;
	}
	
	/**
	 * Column Info
	 * @return wQty
	 */
	public String getWQty() {
		return this.wQty;
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
	 * @param itCusjTqty
	 */
	public void setItCusjTqty(String itCusjTqty) {
		this.itCusjTqty = itCusjTqty;
	}
	
	/**
	 * Column Info
	 * @param yRlsQty
	 */
	public void setYRlsQty(String yRlsQty) {
		this.yRlsQty = yRlsQty;
	}
	
	/**
	 * Column Info
	 * @param yEntQty
	 */
	public void setYEntQty(String yEntQty) {
		this.yEntQty = yEntQty;
	}
	
	/**
	 * Column Info
	 * @param itQty
	 */
	public void setItQty(String itQty) {
		this.itQty = itQty;
	}
	
	/**
	 * Column Info
	 * @param itCusrTqty
	 */
	public void setItCusrTqty(String itCusrTqty) {
		this.itCusrTqty = itCusrTqty;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param itCgoCind
	 */
	public void setItCgoCind(String itCgoCind) {
		this.itCgoCind = itCgoCind;
	}
	
	/**
	 * Column Info
	 * @param remvQty
	 */
	public void setRemvQty(String remvQty) {
		this.remvQty = remvQty;
	}
	
	/**
	 * Column Info
	 * @param itCstmcind
	 */
	public void setItCstmcind(String itCstmcind) {
		this.itCstmcind = itCstmcind;
	}
	
	/**
	 * Column Info
	 * @param itCuswTqty
	 */
	public void setItCuswTqty(String itCuswTqty) {
		this.itCuswTqty = itCuswTqty;
	}
	
	/**
	 * Column Info
	 * @param holdQty
	 */
	public void setHoldQty(String holdQty) {
		this.holdQty = holdQty;
	}
	
	/**
	 * Column Info
	 * @param cusLoc
	 */
	public void setCusLoc(String cusLoc) {
		this.cusLoc = cusLoc;
	}
	
	/**
	 * Column Info
	 * @param wQty
	 */
	public void setWQty(String wQty) {
		this.wQty = wQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setItItno(JSPUtil.getParameter(request, "it_itno", ""));
		setItCusjTqty(JSPUtil.getParameter(request, "it_cusj_tqty", ""));
		setYRlsQty(JSPUtil.getParameter(request, "y_rls_qty", ""));
		setYEntQty(JSPUtil.getParameter(request, "y_ent_qty", ""));
		setItQty(JSPUtil.getParameter(request, "it_qty", ""));
		setItCusrTqty(JSPUtil.getParameter(request, "it_cusr_tqty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setItIttype(JSPUtil.getParameter(request, "it_ittype", ""));
		setItIpiLocal(JSPUtil.getParameter(request, "it_ipi_local", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setItCgoCind(JSPUtil.getParameter(request, "it_cgo_cind", ""));
		setRemvQty(JSPUtil.getParameter(request, "remv_qty", ""));
		setItCstmcind(JSPUtil.getParameter(request, "it_cstmcind", ""));
		setItCuswTqty(JSPUtil.getParameter(request, "it_cusw_tqty", ""));
		setHoldQty(JSPUtil.getParameter(request, "hold_qty", ""));
		setCusLoc(JSPUtil.getParameter(request, "cus_loc", ""));
		setWQty(JSPUtil.getParameter(request, "w_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaResultVO[]
	 */
	public UsaResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaResultVO[]
	 */
	public UsaResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] itItno = (JSPUtil.getParameter(request, prefix	+ "it_itno", length));
			String[] itCusjTqty = (JSPUtil.getParameter(request, prefix	+ "it_cusj_tqty", length));
			String[] yRlsQty = (JSPUtil.getParameter(request, prefix	+ "y_rls_qty", length));
			String[] yEntQty = (JSPUtil.getParameter(request, prefix	+ "y_ent_qty", length));
			String[] itQty = (JSPUtil.getParameter(request, prefix	+ "it_qty", length));
			String[] itCusrTqty = (JSPUtil.getParameter(request, prefix	+ "it_cusr_tqty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] itIttype = (JSPUtil.getParameter(request, prefix	+ "it_ittype", length));
			String[] itIpiLocal = (JSPUtil.getParameter(request, prefix	+ "it_ipi_local", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] itCgoCind = (JSPUtil.getParameter(request, prefix	+ "it_cgo_cind", length));
			String[] remvQty = (JSPUtil.getParameter(request, prefix	+ "remv_qty", length));
			String[] itCstmcind = (JSPUtil.getParameter(request, prefix	+ "it_cstmcind", length));
			String[] itCuswTqty = (JSPUtil.getParameter(request, prefix	+ "it_cusw_tqty", length));
			String[] holdQty = (JSPUtil.getParameter(request, prefix	+ "hold_qty", length));
			String[] cusLoc = (JSPUtil.getParameter(request, prefix	+ "cus_loc", length));
			String[] wQty = (JSPUtil.getParameter(request, prefix	+ "w_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaResultVO();
				if (itItno[i] != null)
					model.setItItno(itItno[i]);
				if (itCusjTqty[i] != null)
					model.setItCusjTqty(itCusjTqty[i]);
				if (yRlsQty[i] != null)
					model.setYRlsQty(yRlsQty[i]);
				if (yEntQty[i] != null)
					model.setYEntQty(yEntQty[i]);
				if (itQty[i] != null)
					model.setItQty(itQty[i]);
				if (itCusrTqty[i] != null)
					model.setItCusrTqty(itCusrTqty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (itIttype[i] != null)
					model.setItIttype(itIttype[i]);
				if (itIpiLocal[i] != null)
					model.setItIpiLocal(itIpiLocal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (itCgoCind[i] != null)
					model.setItCgoCind(itCgoCind[i]);
				if (remvQty[i] != null)
					model.setRemvQty(remvQty[i]);
				if (itCstmcind[i] != null)
					model.setItCstmcind(itCstmcind[i]);
				if (itCuswTqty[i] != null)
					model.setItCuswTqty(itCuswTqty[i]);
				if (holdQty[i] != null)
					model.setHoldQty(holdQty[i]);
				if (cusLoc[i] != null)
					model.setCusLoc(cusLoc[i]);
				if (wQty[i] != null)
					model.setWQty(wQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaResultVO[]
	 */
	public UsaResultVO[] getUsaResultVOs(){
		UsaResultVO[] vos = (UsaResultVO[])models.toArray(new UsaResultVO[models.size()]);
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
		this.itItno = this.itItno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCusjTqty = this.itCusjTqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yRlsQty = this.yRlsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yEntQty = this.yEntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itQty = this.itQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCusrTqty = this.itCusrTqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itIttype = this.itIttype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itIpiLocal = this.itIpiLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCgoCind = this.itCgoCind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remvQty = this.remvQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCstmcind = this.itCstmcind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itCuswTqty = this.itCuswTqty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holdQty = this.holdQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusLoc = this.cusLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wQty = this.wQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
