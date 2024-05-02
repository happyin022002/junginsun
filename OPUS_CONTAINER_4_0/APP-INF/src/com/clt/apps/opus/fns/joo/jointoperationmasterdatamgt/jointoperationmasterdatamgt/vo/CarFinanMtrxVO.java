/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarFinanMtrxVO.java
*@FileTitle : CarFinanMtrxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.06 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

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
 * @author 박희동
 * @since J2EE 1.5
 */

public class CarFinanMtrxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CarFinanMtrxVO> models = new ArrayList<CarFinanMtrxVO>();
	
	/* Column Info */
	private String loclCurrCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String drAcctCd = null;
	/* Column Info */
	private String crAcctCd = null;
	/* Column Info */
	private String crCtrCd = null;
	/* Column Info */
	private String drLocCd = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String crLocCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Column Info */
	private String joStlItmNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String drCtrCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CarFinanMtrxVO() {}

	public CarFinanMtrxVO(String ibflag, String pagerows, String joCrrCd, String rlaneCd, String reDivrCd, String joStlItmCd, String custSeq, String drAcctCd, String drCtrCd, String drLocCd, String crAcctCd, String crCtrCd, String crLocCd, String joStlItmNm, String loclCurrCd, String usrId) {
		this.loclCurrCd = loclCurrCd;
		this.ibflag = ibflag;
		this.custSeq = custSeq;
		this.usrId = usrId;
		this.reDivrCd = reDivrCd;
		this.drAcctCd = drAcctCd;
		this.crAcctCd = crAcctCd;
		this.crCtrCd = crCtrCd;
		this.drLocCd = drLocCd;
		this.joCrrCd = joCrrCd;
		this.crLocCd = crLocCd;
		this.rlaneCd = rlaneCd;
		this.joStlItmCd = joStlItmCd;
		this.joStlItmNm = joStlItmNm;
		this.pagerows = pagerows;
		this.drCtrCd = drCtrCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("dr_acct_cd", getDrAcctCd());
		this.hashColumns.put("cr_acct_cd", getCrAcctCd());
		this.hashColumns.put("cr_ctr_cd", getCrCtrCd());
		this.hashColumns.put("dr_loc_cd", getDrLocCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("cr_loc_cd", getCrLocCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("jo_stl_itm_nm", getJoStlItmNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dr_ctr_cd", getDrCtrCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("dr_acct_cd", "drAcctCd");
		this.hashFields.put("cr_acct_cd", "crAcctCd");
		this.hashFields.put("cr_ctr_cd", "crCtrCd");
		this.hashFields.put("dr_loc_cd", "drLocCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("cr_loc_cd", "crLocCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("jo_stl_itm_nm", "joStlItmNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dr_ctr_cd", "drCtrCd");
		return this.hashFields;
	}
	
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCustSeq() {
		return this.custSeq;
	}
	public String getUsrId() {
		return this.usrId;
	}
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	public String getDrAcctCd() {
		return this.drAcctCd;
	}
	public String getCrAcctCd() {
		return this.crAcctCd;
	}
	public String getCrCtrCd() {
		return this.crCtrCd;
	}
	public String getDrLocCd() {
		return this.drLocCd;
	}
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	public String getCrLocCd() {
		return this.crLocCd;
	}
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	public String getJoStlItmCd() {
		return this.joStlItmCd;
	}
	public String getJoStlItmNm() {
		return this.joStlItmNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getDrCtrCd() {
		return this.drCtrCd;
	}

	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
		//this.loclCurrCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
		//this.custSeq=true;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
		//this.usrId=true;
	}
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
		//this.reDivrCd=true;
	}
	public void setDrAcctCd(String drAcctCd) {
		this.drAcctCd = drAcctCd;
		//this.drAcctCd=true;
	}
	public void setCrAcctCd(String crAcctCd) {
		this.crAcctCd = crAcctCd;
		//this.crAcctCd=true;
	}
	public void setCrCtrCd(String crCtrCd) {
		this.crCtrCd = crCtrCd;
		//this.crCtrCd=true;
	}
	public void setDrLocCd(String drLocCd) {
		this.drLocCd = drLocCd;
		//this.drLocCd=true;
	}
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
		//this.joCrrCd=true;
	}
	public void setCrLocCd(String crLocCd) {
		this.crLocCd = crLocCd;
		//this.crLocCd=true;
	}
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
		//this.rlaneCd=true;
	}
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
		//this.joStlItmCd=true;
	}
	public void setJoStlItmNm(String joStlItmNm) {
		this.joStlItmNm = joStlItmNm;
		//this.joStlItmNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setDrCtrCd(String drCtrCd) {
		this.drCtrCd = drCtrCd;
		//this.drCtrCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setDrAcctCd(JSPUtil.getParameter(request, "dr_acct_cd", ""));
		setCrAcctCd(JSPUtil.getParameter(request, "cr_acct_cd", ""));
		setCrCtrCd(JSPUtil.getParameter(request, "cr_ctr_cd", ""));
		setDrLocCd(JSPUtil.getParameter(request, "dr_loc_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setCrLocCd(JSPUtil.getParameter(request, "cr_loc_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
		setJoStlItmNm(JSPUtil.getParameter(request, "jo_stl_itm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDrCtrCd(JSPUtil.getParameter(request, "dr_ctr_cd", ""));
	}

	public CarFinanMtrxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CarFinanMtrxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CarFinanMtrxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id".trim(), length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd".trim(), length));
			String[] drAcctCd = (JSPUtil.getParameter(request, prefix	+ "dr_acct_cd".trim(), length));
			String[] crAcctCd = (JSPUtil.getParameter(request, prefix	+ "cr_acct_cd".trim(), length));
			String[] crCtrCd = (JSPUtil.getParameter(request, prefix	+ "cr_ctr_cd".trim(), length));
			String[] drLocCd = (JSPUtil.getParameter(request, prefix	+ "dr_loc_cd".trim(), length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd".trim(), length));
			String[] crLocCd = (JSPUtil.getParameter(request, prefix	+ "cr_loc_cd".trim(), length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd".trim(), length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd".trim(), length));
			String[] joStlItmNm = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] drCtrCd = (JSPUtil.getParameter(request, prefix	+ "dr_ctr_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CarFinanMtrxVO();
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (drAcctCd[i] != null)
					model.setDrAcctCd(drAcctCd[i]);
				if (crAcctCd[i] != null)
					model.setCrAcctCd(crAcctCd[i]);
				if (crCtrCd[i] != null)
					model.setCrCtrCd(crCtrCd[i]);
				if (drLocCd[i] != null)
					model.setDrLocCd(drLocCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (crLocCd[i] != null)
					model.setCrLocCd(crLocCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (joStlItmNm[i] != null)
					model.setJoStlItmNm(joStlItmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (drCtrCd[i] != null)
					model.setDrCtrCd(drCtrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCarFinanMtrxVOs();
	}

	public CarFinanMtrxVO[] getCarFinanMtrxVOs(){
		CarFinanMtrxVO[] vos = (CarFinanMtrxVO[])models.toArray(new CarFinanMtrxVO[models.size()]);
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
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drAcctCd = this.drAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAcctCd = this.crAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCtrCd = this.crCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drLocCd = this.drLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crLocCd = this.crLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmNm = this.joStlItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drCtrCd = this.drCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
