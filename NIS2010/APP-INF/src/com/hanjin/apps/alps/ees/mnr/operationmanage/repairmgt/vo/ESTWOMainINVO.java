/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESTWOMainINVO.java
*@FileTitle : ESTWOMainINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.14 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ESTWOMainINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ESTWOMainINVO> models = new ArrayList<ESTWOMainINVO>();
	
	/* Column Info */
	private String selectedVndrSeq = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String aproDtTo = null;
	/* Column Info */
	private String aproDtFr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ESTWOMainINVO() {}

	public ESTWOMainINVO(String ibflag, String pagerows, String selectedVndrSeq, String mnrOrdOfcCtyCd, String rqstEqNo, String mnrOrdSeq, String status, String vndrSeq, String woNo, String aproDtTo, String eqKndCd, String aproDtFr, String costOfcCd) {
		this.selectedVndrSeq = selectedVndrSeq;
		this.costOfcCd = costOfcCd;
		this.status = status;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.ibflag = ibflag;
		this.rqstEqNo = rqstEqNo;
		this.mnrOrdSeq = mnrOrdSeq;
		this.vndrSeq = vndrSeq;
		this.woNo = woNo;
		this.aproDtTo = aproDtTo;
		this.aproDtFr = aproDtFr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("selected_vndr_seq", getSelectedVndrSeq());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("apro_dt_to", getAproDtTo());
		this.hashColumns.put("apro_dt_fr", getAproDtFr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("selected_vndr_seq", "selectedVndrSeq");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("status", "status");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("apro_dt_to", "aproDtTo");
		this.hashFields.put("apro_dt_fr", "aproDtFr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return selectedVndrSeq
	 */
	public String getSelectedVndrSeq() {
		return this.selectedVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return mnrOrdOfcCtyCd
	 */
	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
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
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return aproDtTo
	 */
	public String getAproDtTo() {
		return this.aproDtTo;
	}
	
	/**
	 * Column Info
	 * @return aproDtFr
	 */
	public String getAproDtFr() {
		return this.aproDtFr;
	}
	

	/**
	 * Column Info
	 * @param selectedVndrSeq
	 */
	public void setSelectedVndrSeq(String selectedVndrSeq) {
		this.selectedVndrSeq = selectedVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param mnrOrdOfcCtyCd
	 */
	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
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
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param aproDtTo
	 */
	public void setAproDtTo(String aproDtTo) {
		this.aproDtTo = aproDtTo;
	}
	
	/**
	 * Column Info
	 * @param aproDtFr
	 */
	public void setAproDtFr(String aproDtFr) {
		this.aproDtFr = aproDtFr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSelectedVndrSeq(JSPUtil.getParameter(request, "selected_vndr_seq", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, "mnr_ord_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRqstEqNo(JSPUtil.getParameter(request, "rqst_eq_no", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, "mnr_ord_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setAproDtTo(JSPUtil.getParameter(request, "apro_dt_to", ""));
		setAproDtFr(JSPUtil.getParameter(request, "apro_dt_fr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ESTWOMainINVO[]
	 */
	public ESTWOMainINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ESTWOMainINVO[]
	 */
	public ESTWOMainINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ESTWOMainINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] selectedVndrSeq = (JSPUtil.getParameter(request, prefix	+ "selected_vndr_seq", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] aproDtTo = (JSPUtil.getParameter(request, prefix	+ "apro_dt_to", length));
			String[] aproDtFr = (JSPUtil.getParameter(request, prefix	+ "apro_dt_fr", length));
			
			for (int i = 0; i < length; i++) {
				model = new ESTWOMainINVO();
				if (selectedVndrSeq[i] != null)
					model.setSelectedVndrSeq(selectedVndrSeq[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (aproDtTo[i] != null)
					model.setAproDtTo(aproDtTo[i]);
				if (aproDtFr[i] != null)
					model.setAproDtFr(aproDtFr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getESTWOMainINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ESTWOMainINVO[]
	 */
	public ESTWOMainINVO[] getESTWOMainINVOs(){
		ESTWOMainINVO[] vos = (ESTWOMainINVO[])models.toArray(new ESTWOMainINVO[models.size()]);
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
		this.selectedVndrSeq = this.selectedVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDtTo = this.aproDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDtFr = this.aproDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
