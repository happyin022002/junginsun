/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchChaterInvoiceSdmsListVO.java
*@FileTitle : SearchChaterInvoiceSdmsListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.09.11 정윤태 
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchChaterInvoiceSdmsListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchChaterInvoiceSdmsListVO> models = new ArrayList<SearchChaterInvoiceSdmsListVO>();
	
	/* Column Info */
	private String stvDmgRmk = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String stvDmgPrtCateCd = null;
	/* Column Info */
	private String direction = null;
	/* Column Info */
	private String bilInvNo = null;
	/* Column Info */
	private String stvDmgStlProcStsCd = null;
	/* Column Info */
	private String lastUpdateStatus = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String payCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String imsiPayDt = null;
	/* Column Info */
	private String payLoclAmt = null;
	/* Column Info */
	private String invStatus = null;
	/* Column Info */
	private String stvDmgNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchChaterInvoiceSdmsListVO() {}

	public SearchChaterInvoiceSdmsListVO(String ibflag, String pagerows, String stvDmgNo, String vslCd, String direction, String revDirCd, String vpsPortCd, String stvDmgPrtCateCd, String lastUpdateStatus, String payCurrCd, String payLoclAmt, String bilInvNo, String payDt, String invStatus, String stvDmgRmk, String stvDmgStlProcStsCd, String imsiPayDt) {
		this.stvDmgRmk = stvDmgRmk;
		this.vslCd = vslCd;
		this.payDt = payDt;
		this.stvDmgPrtCateCd = stvDmgPrtCateCd;
		this.direction = direction;
		this.bilInvNo = bilInvNo;
		this.stvDmgStlProcStsCd = stvDmgStlProcStsCd;
		this.lastUpdateStatus = lastUpdateStatus;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.vpsPortCd = vpsPortCd;
		this.payCurrCd = payCurrCd;
		this.ibflag = ibflag;
		this.imsiPayDt = imsiPayDt;
		this.payLoclAmt = payLoclAmt;
		this.invStatus = invStatus;
		this.stvDmgNo = stvDmgNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stv_dmg_rmk", getStvDmgRmk());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("stv_dmg_prt_cate_cd", getStvDmgPrtCateCd());
		this.hashColumns.put("direction", getDirection());
		this.hashColumns.put("bil_inv_no", getBilInvNo());
		this.hashColumns.put("stv_dmg_stl_proc_sts_cd", getStvDmgStlProcStsCd());
		this.hashColumns.put("last_update_status", getLastUpdateStatus());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("pay_curr_cd", getPayCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("imsi_pay_dt", getImsiPayDt());
		this.hashColumns.put("pay_locl_amt", getPayLoclAmt());
		this.hashColumns.put("inv_status", getInvStatus());
		this.hashColumns.put("stv_dmg_no", getStvDmgNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stv_dmg_rmk", "stvDmgRmk");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("stv_dmg_prt_cate_cd", "stvDmgPrtCateCd");
		this.hashFields.put("direction", "direction");
		this.hashFields.put("bil_inv_no", "bilInvNo");
		this.hashFields.put("stv_dmg_stl_proc_sts_cd", "stvDmgStlProcStsCd");
		this.hashFields.put("last_update_status", "lastUpdateStatus");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("pay_curr_cd", "payCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imsi_pay_dt", "imsiPayDt");
		this.hashFields.put("pay_locl_amt", "payLoclAmt");
		this.hashFields.put("inv_status", "invStatus");
		this.hashFields.put("stv_dmg_no", "stvDmgNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stvDmgRmk
	 */
	public String getStvDmgRmk() {
		return this.stvDmgRmk;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return stvDmgPrtCateCd
	 */
	public String getStvDmgPrtCateCd() {
		return this.stvDmgPrtCateCd;
	}
	
	/**
	 * Column Info
	 * @return direction
	 */
	public String getDirection() {
		return this.direction;
	}
	
	/**
	 * Column Info
	 * @return bilInvNo
	 */
	public String getBilInvNo() {
		return this.bilInvNo;
	}
	
	/**
	 * Column Info
	 * @return stvDmgStlProcStsCd
	 */
	public String getStvDmgStlProcStsCd() {
		return this.stvDmgStlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return lastUpdateStatus
	 */
	public String getLastUpdateStatus() {
		return this.lastUpdateStatus;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return payCurrCd
	 */
	public String getPayCurrCd() {
		return this.payCurrCd;
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
	 * @return imsiPayDt
	 */
	public String getImsiPayDt() {
		return this.imsiPayDt;
	}
	
	/**
	 * Column Info
	 * @return payLoclAmt
	 */
	public String getPayLoclAmt() {
		return this.payLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return invStatus
	 */
	public String getInvStatus() {
		return this.invStatus;
	}
	
	/**
	 * Column Info
	 * @return stvDmgNo
	 */
	public String getStvDmgNo() {
		return this.stvDmgNo;
	}
	

	/**
	 * Column Info
	 * @param stvDmgRmk
	 */
	public void setStvDmgRmk(String stvDmgRmk) {
		this.stvDmgRmk = stvDmgRmk;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param stvDmgPrtCateCd
	 */
	public void setStvDmgPrtCateCd(String stvDmgPrtCateCd) {
		this.stvDmgPrtCateCd = stvDmgPrtCateCd;
	}
	
	/**
	 * Column Info
	 * @param direction
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	/**
	 * Column Info
	 * @param bilInvNo
	 */
	public void setBilInvNo(String bilInvNo) {
		this.bilInvNo = bilInvNo;
	}
	
	/**
	 * Column Info
	 * @param stvDmgStlProcStsCd
	 */
	public void setStvDmgStlProcStsCd(String stvDmgStlProcStsCd) {
		this.stvDmgStlProcStsCd = stvDmgStlProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param lastUpdateStatus
	 */
	public void setLastUpdateStatus(String lastUpdateStatus) {
		this.lastUpdateStatus = lastUpdateStatus;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param payCurrCd
	 */
	public void setPayCurrCd(String payCurrCd) {
		this.payCurrCd = payCurrCd;
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
	 * @param imsiPayDt
	 */
	public void setImsiPayDt(String imsiPayDt) {
		this.imsiPayDt = imsiPayDt;
	}
	
	/**
	 * Column Info
	 * @param payLoclAmt
	 */
	public void setPayLoclAmt(String payLoclAmt) {
		this.payLoclAmt = payLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param invStatus
	 */
	public void setInvStatus(String invStatus) {
		this.invStatus = invStatus;
	}
	
	/**
	 * Column Info
	 * @param stvDmgNo
	 */
	public void setStvDmgNo(String stvDmgNo) {
		this.stvDmgNo = stvDmgNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setStvDmgRmk(JSPUtil.getParameter(request, "stv_dmg_rmk", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPayDt(JSPUtil.getParameter(request, "pay_dt", ""));
		setStvDmgPrtCateCd(JSPUtil.getParameter(request, "stv_dmg_prt_cate_cd", ""));
		setDirection(JSPUtil.getParameter(request, "direction", ""));
		setBilInvNo(JSPUtil.getParameter(request, "bil_inv_no", ""));
		setStvDmgStlProcStsCd(JSPUtil.getParameter(request, "stv_dmg_stl_proc_sts_cd", ""));
		setLastUpdateStatus(JSPUtil.getParameter(request, "last_update_status", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setPayCurrCd(JSPUtil.getParameter(request, "pay_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setImsiPayDt(JSPUtil.getParameter(request, "imsi_pay_dt", ""));
		setPayLoclAmt(JSPUtil.getParameter(request, "pay_locl_amt", ""));
		setInvStatus(JSPUtil.getParameter(request, "inv_status", ""));
		setStvDmgNo(JSPUtil.getParameter(request, "stv_dmg_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchChaterInvoiceSdmsListVO[]
	 */
	public SearchChaterInvoiceSdmsListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchChaterInvoiceSdmsListVO[]
	 */
	public SearchChaterInvoiceSdmsListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchChaterInvoiceSdmsListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stvDmgRmk = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_rmk", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] stvDmgPrtCateCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_prt_cate_cd", length));
			String[] direction = (JSPUtil.getParameter(request, prefix	+ "direction", length));
			String[] bilInvNo = (JSPUtil.getParameter(request, prefix	+ "bil_inv_no", length));
			String[] stvDmgStlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_stl_proc_sts_cd", length));
			String[] lastUpdateStatus = (JSPUtil.getParameter(request, prefix	+ "last_update_status", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] payCurrCd = (JSPUtil.getParameter(request, prefix	+ "pay_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] imsiPayDt = (JSPUtil.getParameter(request, prefix	+ "imsi_pay_dt", length));
			String[] payLoclAmt = (JSPUtil.getParameter(request, prefix	+ "pay_locl_amt", length));
			String[] invStatus = (JSPUtil.getParameter(request, prefix	+ "inv_status", length));
			String[] stvDmgNo = (JSPUtil.getParameter(request, prefix	+ "stv_dmg_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchChaterInvoiceSdmsListVO();
				if (stvDmgRmk[i] != null)
					model.setStvDmgRmk(stvDmgRmk[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (stvDmgPrtCateCd[i] != null)
					model.setStvDmgPrtCateCd(stvDmgPrtCateCd[i]);
				if (direction[i] != null)
					model.setDirection(direction[i]);
				if (bilInvNo[i] != null)
					model.setBilInvNo(bilInvNo[i]);
				if (stvDmgStlProcStsCd[i] != null)
					model.setStvDmgStlProcStsCd(stvDmgStlProcStsCd[i]);
				if (lastUpdateStatus[i] != null)
					model.setLastUpdateStatus(lastUpdateStatus[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (payCurrCd[i] != null)
					model.setPayCurrCd(payCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (imsiPayDt[i] != null)
					model.setImsiPayDt(imsiPayDt[i]);
				if (payLoclAmt[i] != null)
					model.setPayLoclAmt(payLoclAmt[i]);
				if (invStatus[i] != null)
					model.setInvStatus(invStatus[i]);
				if (stvDmgNo[i] != null)
					model.setStvDmgNo(stvDmgNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchChaterInvoiceSdmsListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchChaterInvoiceSdmsListVO[]
	 */
	public SearchChaterInvoiceSdmsListVO[] getSearchChaterInvoiceSdmsListVOs(){
		SearchChaterInvoiceSdmsListVO[] vos = (SearchChaterInvoiceSdmsListVO[])models.toArray(new SearchChaterInvoiceSdmsListVO[models.size()]);
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
		this.stvDmgRmk = this.stvDmgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgPrtCateCd = this.stvDmgPrtCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.direction = this.direction .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilInvNo = this.bilInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgStlProcStsCd = this.stvDmgStlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdateStatus = this.lastUpdateStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payCurrCd = this.payCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imsiPayDt = this.imsiPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLoclAmt = this.payLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStatus = this.invStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stvDmgNo = this.stvDmgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
