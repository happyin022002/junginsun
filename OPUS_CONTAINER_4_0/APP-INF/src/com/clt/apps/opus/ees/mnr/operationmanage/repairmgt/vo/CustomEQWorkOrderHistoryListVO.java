/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomEQWorkOrderHistoryListVO.java
*@FileTitle : CustomEQWorkOrderHistoryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.04 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomEQWorkOrderHistoryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomEQWorkOrderHistoryListVO> models = new ArrayList<CustomEQWorkOrderHistoryListVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rpr = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rprStsCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String estNo = null;
	/* Column Info */
	private String rprRsltDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	/**
	 * CustomEQWorkOrderHistoryListVO 을 생성함 
	 */ 
	public CustomEQWorkOrderHistoryListVO() {}
	/**
	 * CustomEQWorkOrderHistoryListVO 을 생성함 
	 */ 
	public CustomEQWorkOrderHistoryListVO(String ibflag, String pagerows, String rqstDt, String rpr, String costOfcCd, String currCd, String rprStsCd, String woNo, String vndrLglEngNm, String ydCd, String costAmt, String estNo, String rprRsltDt) {
		this.rqstDt = rqstDt;
		this.rpr = rpr;
		this.costOfcCd = costOfcCd;
		this.currCd = currCd;
		this.rprStsCd = rprStsCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.costAmt = costAmt;
		this.woNo = woNo;
		this.estNo = estNo;
		this.rprRsltDt = rprRsltDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rpr", getRpr());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rpr_sts_cd", getRprStsCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("est_no", getEstNo());
		this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rpr", "rpr");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rpr_sts_cd", "rprStsCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("est_no", "estNo");
		this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
		return this.hashFields;
	}
	 
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return rpr
	 */
	public String getRpr() {
		return this.rpr;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return rprStsCd
	 */
	public String getRprStsCd() {
		return this.rprStsCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
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
	 * @return estNo
	 */
	public String getEstNo() {
		return this.estNo;
	}
	
	/**
	 * Column Info
	 * @return rprRsltDt
	 */
	public String getRprRsltDt() {
		return this.rprRsltDt;
	}
	

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param rpr
	 */
	public void setRpr(String rpr) {
		this.rpr = rpr;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param rprStsCd
	 */
	public void setRprStsCd(String rprStsCd) {
		this.rprStsCd = rprStsCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
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
	 * @param estNo
	 */
	public void setEstNo(String estNo) {
		this.estNo = estNo;
	}
	
	/**
	 * Column Info
	 * @param rprRsltDt
	 */
	public void setRprRsltDt(String rprRsltDt) {
		this.rprRsltDt = rprRsltDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setRpr(JSPUtil.getParameter(request, "rpr", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setRprStsCd(JSPUtil.getParameter(request, "rpr_sts_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCostAmt(JSPUtil.getParameter(request, "cost_amt", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setEstNo(JSPUtil.getParameter(request, "est_no", ""));
		setRprRsltDt(JSPUtil.getParameter(request, "rpr_rslt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomEQWorkOrderHistoryListVO[]
	 */
	public CustomEQWorkOrderHistoryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomEQWorkOrderHistoryListVO[]
	 */
	public CustomEQWorkOrderHistoryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomEQWorkOrderHistoryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt".trim(), length));
			String[] rpr = (JSPUtil.getParameter(request, prefix	+ "rpr".trim(), length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] rprStsCd = (JSPUtil.getParameter(request, prefix	+ "rpr_sts_cd".trim(), length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt".trim(), length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no".trim(), length));
			String[] estNo = (JSPUtil.getParameter(request, prefix	+ "est_no".trim(), length));
			String[] rprRsltDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rslt_dt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomEQWorkOrderHistoryListVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rpr[i] != null)
					model.setRpr(rpr[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rprStsCd[i] != null)
					model.setRprStsCd(rprStsCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (estNo[i] != null)
					model.setEstNo(estNo[i]);
				if (rprRsltDt[i] != null)
					model.setRprRsltDt(rprRsltDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomEQWorkOrderHistoryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomEQWorkOrderHistoryListVO[]
	 */
	public CustomEQWorkOrderHistoryListVO[] getCustomEQWorkOrderHistoryListVOs(){
		CustomEQWorkOrderHistoryListVO[] vos = (CustomEQWorkOrderHistoryListVO[])models.toArray(new CustomEQWorkOrderHistoryListVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpr = this.rpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprStsCd = this.rprStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estNo = this.estNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltDt = this.rprRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
