/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeLevelVO.java
*@FileTitle : OfficeLevelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.19 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 진윤오
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class OfficeLevelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeLevelVO> models = new ArrayList<OfficeLevelVO>();
	
	/* Column Info */
	private String authFlg = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfficeLevelVO() {}

	public OfficeLevelVO(String ibflag, String pagerows, String rqstUtVal, String loclCurrCd, String usdLoclXchRt, String authFlg) {
		this.authFlg = authFlg;
		this.ibflag = ibflag;
		this.loclCurrCd = loclCurrCd;
		this.usdLoclXchRt = usdLoclXchRt;
		this.rqstUtVal = rqstUtVal;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authFlg
	 */
	public String getAuthFlg() {
		return this.authFlg;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return usdLoclXchRt
	 */
	public String getUsdLoclXchRt() {
		return this.usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
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
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param usdLoclXchRt
	 */
	public void setUsdLoclXchRt(String usdLoclXchRt) {
		this.usdLoclXchRt = usdLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAuthFlg(JSPUtil.getParameter(request, "auth_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return OfficeLevelVO[]
	 */
	public OfficeLevelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeLevelVO[]
	 */
	public OfficeLevelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeLevelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd".trim(), length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt".trim(), length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeLevelVO();
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeLevelVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return OfficeLevelVO[]
	 */
	public OfficeLevelVO[] getOfficeLevelVOs(){
		OfficeLevelVO[] vos = (OfficeLevelVO[])models.toArray(new OfficeLevelVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
