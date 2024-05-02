/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHNIssuedInvoiceListVO.java
*@FileTitle : CHNIssuedInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.10.08 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHNIssuedInvoiceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHNIssuedInvoiceListVO> models = new ArrayList<CHNIssuedInvoiceListVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String totUsd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String frtUsd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String eqvUsd = null;
	/* Column Info */
	private String chgUsd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHNIssuedInvoiceListVO() {}

	public CHNIssuedInvoiceListVO(String ibflag, String pagerows, String invNo, String bkgNo, String frtUsd, String exRate, String eqvUsd, String chgUsd, String totUsd, String arIfNo, String blSrcNo, String ioBndCd, String currCd) {
		this.blSrcNo = blSrcNo;
		this.totUsd = totUsd;
		this.currCd = currCd;
		this.ioBndCd = ioBndCd;
		this.frtUsd = frtUsd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.arIfNo = arIfNo;
		this.exRate = exRate;
		this.eqvUsd = eqvUsd;
		this.chgUsd = chgUsd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("tot_usd", getTotUsd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("frt_usd", getFrtUsd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("eqv_usd", getEqvUsd());
		this.hashColumns.put("chg_usd", getChgUsd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("tot_usd", "totUsd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("frt_usd", "frtUsd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("eqv_usd", "eqvUsd");
		this.hashFields.put("chg_usd", "chgUsd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return totUsd
	 */
	public String getTotUsd() {
		return this.totUsd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return frtUsd
	 */
	public String getFrtUsd() {
		return this.frtUsd;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return exRate
	 */
	public String getExRate() {
		return this.exRate;
	}
	
	/**
	 * Column Info
	 * @return eqvUsd
	 */
	public String getEqvUsd() {
		return this.eqvUsd;
	}
	
	/**
	 * Column Info
	 * @return chgUsd
	 */
	public String getChgUsd() {
		return this.chgUsd;
	}
	

	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param totUsd
	 */
	public void setTotUsd(String totUsd) {
		this.totUsd = totUsd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param frtUsd
	 */
	public void setFrtUsd(String frtUsd) {
		this.frtUsd = frtUsd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param exRate
	 */
	public void setExRate(String exRate) {
		this.exRate = exRate;
	}
	
	/**
	 * Column Info
	 * @param eqvUsd
	 */
	public void setEqvUsd(String eqvUsd) {
		this.eqvUsd = eqvUsd;
	}
	
	/**
	 * Column Info
	 * @param chgUsd
	 */
	public void setChgUsd(String chgUsd) {
		this.chgUsd = chgUsd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setTotUsd(JSPUtil.getParameter(request, "tot_usd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setFrtUsd(JSPUtil.getParameter(request, "frt_usd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setExRate(JSPUtil.getParameter(request, "ex_rate", ""));
		setEqvUsd(JSPUtil.getParameter(request, "eqv_usd", ""));
		setChgUsd(JSPUtil.getParameter(request, "chg_usd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHNIssuedInvoiceListVO[]
	 */
	public CHNIssuedInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHNIssuedInvoiceListVO[]
	 */
	public CHNIssuedInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHNIssuedInvoiceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] totUsd = (JSPUtil.getParameter(request, prefix	+ "tot_usd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] frtUsd = (JSPUtil.getParameter(request, prefix	+ "frt_usd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate", length));
			String[] eqvUsd = (JSPUtil.getParameter(request, prefix	+ "eqv_usd", length));
			String[] chgUsd = (JSPUtil.getParameter(request, prefix	+ "chg_usd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHNIssuedInvoiceListVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (totUsd[i] != null)
					model.setTotUsd(totUsd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (frtUsd[i] != null)
					model.setFrtUsd(frtUsd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (eqvUsd[i] != null)
					model.setEqvUsd(eqvUsd[i]);
				if (chgUsd[i] != null)
					model.setChgUsd(chgUsd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHNIssuedInvoiceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHNIssuedInvoiceListVO[]
	 */
	public CHNIssuedInvoiceListVO[] getCHNIssuedInvoiceListVOs(){
		CHNIssuedInvoiceListVO[] vos = (CHNIssuedInvoiceListVO[])models.toArray(new CHNIssuedInvoiceListVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totUsd = this.totUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtUsd = this.frtUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqvUsd = this.eqvUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUsd = this.chgUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
