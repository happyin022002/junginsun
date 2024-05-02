/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TireReplacementHistoryVO.java
*@FileTitle : TireReplacementHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.01 민정호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TireReplacementHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TireReplacementHistoryVO> models = new ArrayList<TireReplacementHistoryVO>();
	
	/* Column Info */
	private String rpDt = null;
	/* Column Info */
	private String rpQty = null;
	/* Column Info */
	private String pQty = null;
	/* Column Info */
	private String uQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String pAmt = null;
	/* Column Info */
	private String rpAmt = null;
	/* Column Info */
	private String dfQty = null;
	/* Column Info */
	private String curr = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TireReplacementHistoryVO() {}

	public TireReplacementHistoryVO(String ibflag, String pagerows, String rhq, String ofcCd, String vndrNm, String pQty, String uQty, String dfQty, String pAmt, String eqNo, String curr, String rpQty, String rpAmt, String rpDt) {
		this.rpDt = rpDt;
		this.rpQty = rpQty;
		this.pQty = pQty;
		this.uQty = uQty;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.pAmt = pAmt;
		this.rpAmt = rpAmt;
		this.dfQty = dfQty;
		this.curr = curr;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rp_dt", getRpDt());
		this.hashColumns.put("rp_qty", getRpQty());
		this.hashColumns.put("p_qty", getPQty());
		this.hashColumns.put("u_qty", getUQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("p_amt", getPAmt());
		this.hashColumns.put("rp_amt", getRpAmt());
		this.hashColumns.put("df_qty", getDfQty());
		this.hashColumns.put("curr", getCurr());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rp_dt", "rpDt");
		this.hashFields.put("rp_qty", "rpQty");
		this.hashFields.put("p_qty", "pQty");
		this.hashFields.put("u_qty", "uQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("p_amt", "pAmt");
		this.hashFields.put("rp_amt", "rpAmt");
		this.hashFields.put("df_qty", "dfQty");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rpDt
	 */
	public String getRpDt() {
		return this.rpDt;
	}
	
	/**
	 * Column Info
	 * @return rpQty
	 */
	public String getRpQty() {
		return this.rpQty;
	}
	
	/**
	 * Column Info
	 * @return pQty
	 */
	public String getPQty() {
		return this.pQty;
	}
	
	/**
	 * Column Info
	 * @return uQty
	 */
	public String getUQty() {
		return this.uQty;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return pAmt
	 */
	public String getPAmt() {
		return this.pAmt;
	}
	
	/**
	 * Column Info
	 * @return rpAmt
	 */
	public String getRpAmt() {
		return this.rpAmt;
	}
	
	/**
	 * Column Info
	 * @return dfQty
	 */
	public String getDfQty() {
		return this.dfQty;
	}
	
	/**
	 * Column Info
	 * @return curr
	 */
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param rpDt
	 */
	public void setRpDt(String rpDt) {
		this.rpDt = rpDt;
	}
	
	/**
	 * Column Info
	 * @param rpQty
	 */
	public void setRpQty(String rpQty) {
		this.rpQty = rpQty;
	}
	
	/**
	 * Column Info
	 * @param pQty
	 */
	public void setPQty(String pQty) {
		this.pQty = pQty;
	}
	
	/**
	 * Column Info
	 * @param uQty
	 */
	public void setUQty(String uQty) {
		this.uQty = uQty;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param pAmt
	 */
	public void setPAmt(String pAmt) {
		this.pAmt = pAmt;
	}
	
	/**
	 * Column Info
	 * @param rpAmt
	 */
	public void setRpAmt(String rpAmt) {
		this.rpAmt = rpAmt;
	}
	
	/**
	 * Column Info
	 * @param dfQty
	 */
	public void setDfQty(String dfQty) {
		this.dfQty = dfQty;
	}
	
	/**
	 * Column Info
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRpDt(JSPUtil.getParameter(request, "rp_dt", ""));
		setRpQty(JSPUtil.getParameter(request, "rp_qty", ""));
		setPQty(JSPUtil.getParameter(request, "p_qty", ""));
		setUQty(JSPUtil.getParameter(request, "u_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setPAmt(JSPUtil.getParameter(request, "p_amt", ""));
		setRpAmt(JSPUtil.getParameter(request, "rp_amt", ""));
		setDfQty(JSPUtil.getParameter(request, "df_qty", ""));
		setCurr(JSPUtil.getParameter(request, "curr", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TireReplacementHistoryVO[]
	 */
	public TireReplacementHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TireReplacementHistoryVO[]
	 */
	public TireReplacementHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TireReplacementHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rpDt = (JSPUtil.getParameter(request, prefix	+ "rp_dt", length));
			String[] rpQty = (JSPUtil.getParameter(request, prefix	+ "rp_qty", length));
			String[] pQty = (JSPUtil.getParameter(request, prefix	+ "p_qty", length));
			String[] uQty = (JSPUtil.getParameter(request, prefix	+ "u_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] pAmt = (JSPUtil.getParameter(request, prefix	+ "p_amt", length));
			String[] rpAmt = (JSPUtil.getParameter(request, prefix	+ "rp_amt", length));
			String[] dfQty = (JSPUtil.getParameter(request, prefix	+ "df_qty", length));
			String[] curr = (JSPUtil.getParameter(request, prefix	+ "curr", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new TireReplacementHistoryVO();
				if (rpDt[i] != null)
					model.setRpDt(rpDt[i]);
				if (rpQty[i] != null)
					model.setRpQty(rpQty[i]);
				if (pQty[i] != null)
					model.setPQty(pQty[i]);
				if (uQty[i] != null)
					model.setUQty(uQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (pAmt[i] != null)
					model.setPAmt(pAmt[i]);
				if (rpAmt[i] != null)
					model.setRpAmt(rpAmt[i]);
				if (dfQty[i] != null)
					model.setDfQty(dfQty[i]);
				if (curr[i] != null)
					model.setCurr(curr[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTireReplacementHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TireReplacementHistoryVO[]
	 */
	public TireReplacementHistoryVO[] getTireReplacementHistoryVOs(){
		TireReplacementHistoryVO[] vos = (TireReplacementHistoryVO[])models.toArray(new TireReplacementHistoryVO[models.size()]);
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
		this.rpDt = this.rpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpQty = this.rpQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pQty = this.pQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uQty = this.uQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pAmt = this.pAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpAmt = this.rpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfQty = this.dfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr = this.curr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
