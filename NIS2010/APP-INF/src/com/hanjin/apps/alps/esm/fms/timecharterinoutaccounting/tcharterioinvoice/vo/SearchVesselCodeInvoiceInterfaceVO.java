/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVesselCodeInvoiceInterfaceVO.java
*@FileTitle : SearchVesselCodeInvoiceInterfaceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.13 최우석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVesselCodeInvoiceInterfaceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVesselCodeInvoiceInterfaceVO> models = new ArrayList<SearchVesselCodeInvoiceInterfaceVO>();
	
	/* Column Info */
	private String hAcctCd = null;
	/* Column Info */
	private String lifid = null;
	/* Column Info */
	private String hCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalCount = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String hAcctNm = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String hInvEnddd = null;
	/* Column Info */
	private String hInvdAmt = null;
	/* Column Info */
	private String hInvStdd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVesselCodeInvoiceInterfaceVO() {}

	public SearchVesselCodeInvoiceInterfaceVO(String ibflag, String pagerows, String lifid, String seq, String totalCount, String rowCount, String hInvStdd, String hInvEnddd, String hAcctCd, String hAcctNm, String hCurrCd, String hInvdAmt) {
		this.hAcctCd = hAcctCd;
		this.lifid = lifid;
		this.hCurrCd = hCurrCd;
		this.ibflag = ibflag;
		this.totalCount = totalCount;
		this.seq = seq;
		this.hAcctNm = hAcctNm;
		this.rowCount = rowCount;
		this.hInvEnddd = hInvEnddd;
		this.hInvdAmt = hInvdAmt;
		this.hInvStdd = hInvStdd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("h_acct_cd", getHAcctCd());
		this.hashColumns.put("lifid", getLifid());
		this.hashColumns.put("h_curr_cd", getHCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_count", getTotalCount());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("h_acct_nm", getHAcctNm());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("h_inv_enddd", getHInvEnddd());
		this.hashColumns.put("h_invd_amt", getHInvdAmt());
		this.hashColumns.put("h_inv_stdd", getHInvStdd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("h_acct_cd", "hAcctCd");
		this.hashFields.put("lifid", "lifid");
		this.hashFields.put("h_curr_cd", "hCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_count", "totalCount");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("h_acct_nm", "hAcctNm");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("h_inv_enddd", "hInvEnddd");
		this.hashFields.put("h_invd_amt", "hInvdAmt");
		this.hashFields.put("h_inv_stdd", "hInvStdd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hAcctCd
	 */
	public String getHAcctCd() {
		return this.hAcctCd;
	}
	
	/**
	 * Column Info
	 * @return lifid
	 */
	public String getLifid() {
		return this.lifid;
	}
	
	/**
	 * Column Info
	 * @return hCurrCd
	 */
	public String getHCurrCd() {
		return this.hCurrCd;
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
	 * @return totalCount
	 */
	public String getTotalCount() {
		return this.totalCount;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return hAcctNm
	 */
	public String getHAcctNm() {
		return this.hAcctNm;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return hInvEnddd
	 */
	public String getHInvEnddd() {
		return this.hInvEnddd;
	}
	
	/**
	 * Column Info
	 * @return hInvdAmt
	 */
	public String getHInvdAmt() {
		return this.hInvdAmt;
	}
	
	/**
	 * Column Info
	 * @return hInvStdd
	 */
	public String getHInvStdd() {
		return this.hInvStdd;
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
	 * @param hAcctCd
	 */
	public void setHAcctCd(String hAcctCd) {
		this.hAcctCd = hAcctCd;
	}
	
	/**
	 * Column Info
	 * @param lifid
	 */
	public void setLifid(String lifid) {
		this.lifid = lifid;
	}
	
	/**
	 * Column Info
	 * @param hCurrCd
	 */
	public void setHCurrCd(String hCurrCd) {
		this.hCurrCd = hCurrCd;
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
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param hAcctNm
	 */
	public void setHAcctNm(String hAcctNm) {
		this.hAcctNm = hAcctNm;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param hInvEnddd
	 */
	public void setHInvEnddd(String hInvEnddd) {
		this.hInvEnddd = hInvEnddd;
	}
	
	/**
	 * Column Info
	 * @param hInvdAmt
	 */
	public void setHInvdAmt(String hInvdAmt) {
		this.hInvdAmt = hInvdAmt;
	}
	
	/**
	 * Column Info
	 * @param hInvStdd
	 */
	public void setHInvStdd(String hInvStdd) {
		this.hInvStdd = hInvStdd;
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
		setHAcctCd(JSPUtil.getParameter(request, "h_acct_cd", ""));
		setLifid(JSPUtil.getParameter(request, "lifid", ""));
		setHCurrCd(JSPUtil.getParameter(request, "h_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTotalCount(JSPUtil.getParameter(request, "total_count", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setHAcctNm(JSPUtil.getParameter(request, "h_acct_nm", ""));
		setRowCount(JSPUtil.getParameter(request, "row_count", ""));
		setHInvEnddd(JSPUtil.getParameter(request, "h_inv_enddd", ""));
		setHInvdAmt(JSPUtil.getParameter(request, "h_invd_amt", ""));
		setHInvStdd(JSPUtil.getParameter(request, "h_inv_stdd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVesselCodeInvoiceInterfaceVO[]
	 */
	public SearchVesselCodeInvoiceInterfaceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVesselCodeInvoiceInterfaceVO[]
	 */
	public SearchVesselCodeInvoiceInterfaceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVesselCodeInvoiceInterfaceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hAcctCd = (JSPUtil.getParameter(request, prefix	+ "h_acct_cd", length));
			String[] lifid = (JSPUtil.getParameter(request, prefix	+ "lifid", length));
			String[] hCurrCd = (JSPUtil.getParameter(request, prefix	+ "h_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalCount = (JSPUtil.getParameter(request, prefix	+ "total_count", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] hAcctNm = (JSPUtil.getParameter(request, prefix	+ "h_acct_nm", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] hInvEnddd = (JSPUtil.getParameter(request, prefix	+ "h_inv_enddd", length));
			String[] hInvdAmt = (JSPUtil.getParameter(request, prefix	+ "h_invd_amt", length));
			String[] hInvStdd = (JSPUtil.getParameter(request, prefix	+ "h_inv_stdd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVesselCodeInvoiceInterfaceVO();
				if (hAcctCd[i] != null)
					model.setHAcctCd(hAcctCd[i]);
				if (lifid[i] != null)
					model.setLifid(lifid[i]);
				if (hCurrCd[i] != null)
					model.setHCurrCd(hCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalCount[i] != null)
					model.setTotalCount(totalCount[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (hAcctNm[i] != null)
					model.setHAcctNm(hAcctNm[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (hInvEnddd[i] != null)
					model.setHInvEnddd(hInvEnddd[i]);
				if (hInvdAmt[i] != null)
					model.setHInvdAmt(hInvdAmt[i]);
				if (hInvStdd[i] != null)
					model.setHInvStdd(hInvStdd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVesselCodeInvoiceInterfaceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVesselCodeInvoiceInterfaceVO[]
	 */
	public SearchVesselCodeInvoiceInterfaceVO[] getSearchVesselCodeInvoiceInterfaceVOs(){
		SearchVesselCodeInvoiceInterfaceVO[] vos = (SearchVesselCodeInvoiceInterfaceVO[])models.toArray(new SearchVesselCodeInvoiceInterfaceVO[models.size()]);
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
		this.hAcctCd = this.hAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lifid = this.lifid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCurrCd = this.hCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCount = this.totalCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hAcctNm = this.hAcctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hInvEnddd = this.hInvEnddd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hInvdAmt = this.hInvdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hInvStdd = this.hInvStdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
