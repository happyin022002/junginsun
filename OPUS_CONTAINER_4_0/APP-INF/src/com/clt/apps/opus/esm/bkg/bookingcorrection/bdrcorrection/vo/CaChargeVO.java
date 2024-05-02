/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaChargeVO.java
*@FileTitle : CaChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.09.29 이남경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaChargeVO> models = new ArrayList<CaChargeVO>();
	
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String prepaid = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String corrName = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String third = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String collect = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaChargeVO() {}

	public CaChargeVO(String ibflag, String pagerows, String corrName, String chgCd, String ratUtCd, String ratAsQty, String currCd, String chgUtAmt, String chgAmt, String frtTermCd, String prepaid, String collect, String third) {
		this.chgUtAmt = chgUtAmt;
		this.prepaid = prepaid;
		this.currCd = currCd;
		this.frtTermCd = frtTermCd;
		this.corrName = corrName;
		this.ratUtCd = ratUtCd;
		this.third = third;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.chgAmt = chgAmt;
		this.ratAsQty = ratAsQty;
		this.collect = collect;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("prepaid", getPrepaid());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("corr_name", getCorrName());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("third", getThird());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("collect", getCollect());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("prepaid", "prepaid");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("corr_name", "corrName");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("third", "third");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("collect", "collect");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return prepaid
	 */
	public String getPrepaid() {
		return this.prepaid;
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
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return corrName
	 */
	public String getCorrName() {
		return this.corrName;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return third
	 */
	public String getThird() {
		return this.third;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return collect
	 */
	public String getCollect() {
		return this.collect;
	}
	

	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param prepaid
	 */
	public void setPrepaid(String prepaid) {
		this.prepaid = prepaid;
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
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param corrName
	 */
	public void setCorrName(String corrName) {
		this.corrName = corrName;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param third
	 */
	public void setThird(String third) {
		this.third = third;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param collect
	 */
	public void setCollect(String collect) {
		this.collect = collect;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChgUtAmt(JSPUtil.getParameter(request, "chg_ut_amt", ""));
		setPrepaid(JSPUtil.getParameter(request, "prepaid", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
		setCorrName(JSPUtil.getParameter(request, "corr_name", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setThird(JSPUtil.getParameter(request, "third", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setRatAsQty(JSPUtil.getParameter(request, "rat_as_qty", ""));
		setCollect(JSPUtil.getParameter(request, "collect", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaChargeVO[]
	 */
	public CaChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaChargeVO[]
	 */
	public CaChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] prepaid = (JSPUtil.getParameter(request, prefix	+ "prepaid", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] corrName = (JSPUtil.getParameter(request, prefix	+ "corr_name", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] third = (JSPUtil.getParameter(request, prefix	+ "third", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] collect = (JSPUtil.getParameter(request, prefix	+ "collect", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaChargeVO();
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (prepaid[i] != null)
					model.setPrepaid(prepaid[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (corrName[i] != null)
					model.setCorrName(corrName[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (third[i] != null)
					model.setThird(third[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (collect[i] != null)
					model.setCollect(collect[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaChargeVO[]
	 */
	public CaChargeVO[] getCaChargeVOs(){
		CaChargeVO[] vos = (CaChargeVO[])models.toArray(new CaChargeVO[models.size()]);
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
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepaid = this.prepaid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrName = this.corrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.third = this.third .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.collect = this.collect .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
