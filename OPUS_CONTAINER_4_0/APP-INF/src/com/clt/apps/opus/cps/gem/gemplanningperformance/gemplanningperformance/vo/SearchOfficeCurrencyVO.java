/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOfficeCurrencyVO.java
*@FileTitle : SearchOfficeCurrencyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.08.14 진윤오 
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOfficeCurrencyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficeCurrencyVO> models = new ArrayList<SearchOfficeCurrencyVO>();
	
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String loclKrwXchRt = null;
	/* Column Info */
	private String rgnOfcFlg = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String level4 = null;
	/* Column Info */
	private String level2 = null;
	/* Column Info */
	private String level3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String level1 = null;
	/* Column Info */
	private String usdKrwXchRt = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String rqstUtVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOfficeCurrencyVO() {}

	public SearchOfficeCurrencyVO(String ibflag, String pagerows, String level1, String level2, String level3, String level4, String rgnOfcFlg, String loclCurrCd, String rqstUtVal, String authFlg, String usdLoclXchRt, String loclKrwXchRt, String usdKrwXchRt) {
		this.authFlg = authFlg;
		this.loclKrwXchRt = loclKrwXchRt;
		this.rgnOfcFlg = rgnOfcFlg;
		this.loclCurrCd = loclCurrCd;
		this.pagerows = pagerows;
		this.level4 = level4;
		this.level2 = level2;
		this.level3 = level3;
		this.ibflag = ibflag;
		this.level1 = level1;
		this.usdKrwXchRt = usdKrwXchRt;
		this.usdLoclXchRt = usdLoclXchRt;
		this.rqstUtVal = rqstUtVal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("locl_krw_xch_rt", getLoclKrwXchRt());
		this.hashColumns.put("rgn_ofc_flg", getRgnOfcFlg());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("level4", getLevel4());
		this.hashColumns.put("level2", getLevel2());
		this.hashColumns.put("level3", getLevel3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("level1", getLevel1());
		this.hashColumns.put("usd_krw_xch_rt", getUsdKrwXchRt());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("locl_krw_xch_rt", "loclKrwXchRt");
		this.hashFields.put("rgn_ofc_flg", "rgnOfcFlg");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("level4", "level4");
		this.hashFields.put("level2", "level2");
		this.hashFields.put("level3", "level3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("level1", "level1");
		this.hashFields.put("usd_krw_xch_rt", "usdKrwXchRt");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
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
	 * Column Info
	 * @return loclKrwXchRt
	 */
	public String getLoclKrwXchRt() {
		return this.loclKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcFlg
	 */
	public String getRgnOfcFlg() {
		return this.rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
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
	 * @return level4
	 */
	public String getLevel4() {
		return this.level4;
	}
	
	/**
	 * Column Info
	 * @return level2
	 */
	public String getLevel2() {
		return this.level2;
	}
	
	/**
	 * Column Info
	 * @return level3
	 */
	public String getLevel3() {
		return this.level3;
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
	 * @return level1
	 */
	public String getLevel1() {
		return this.level1;
	}
	
	/**
	 * Column Info
	 * @return usdKrwXchRt
	 */
	public String getUsdKrwXchRt() {
		return this.usdKrwXchRt;
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
	 * Column Info
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Column Info
	 * @param loclKrwXchRt
	 */
	public void setLoclKrwXchRt(String loclKrwXchRt) {
		this.loclKrwXchRt = loclKrwXchRt;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcFlg
	 */
	public void setRgnOfcFlg(String rgnOfcFlg) {
		this.rgnOfcFlg = rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
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
	 * @param level4
	 */
	public void setLevel4(String level4) {
		this.level4 = level4;
	}
	
	/**
	 * Column Info
	 * @param level2
	 */
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	
	/**
	 * Column Info
	 * @param level3
	 */
	public void setLevel3(String level3) {
		this.level3 = level3;
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
	 * @param level1
	 */
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	
	/**
	 * Column Info
	 * @param usdKrwXchRt
	 */
	public void setUsdKrwXchRt(String usdKrwXchRt) {
		this.usdKrwXchRt = usdKrwXchRt;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAuthFlg(JSPUtil.getParameter(request, "auth_flg", ""));
		setLoclKrwXchRt(JSPUtil.getParameter(request, "locl_krw_xch_rt", ""));
		setRgnOfcFlg(JSPUtil.getParameter(request, "rgn_ofc_flg", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLevel4(JSPUtil.getParameter(request, "level4", ""));
		setLevel2(JSPUtil.getParameter(request, "level2", ""));
		setLevel3(JSPUtil.getParameter(request, "level3", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLevel1(JSPUtil.getParameter(request, "level1", ""));
		setUsdKrwXchRt(JSPUtil.getParameter(request, "usd_krw_xch_rt", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOfficeCurrencyVO[]
	 */
	public SearchOfficeCurrencyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOfficeCurrencyVO[]
	 */
	public SearchOfficeCurrencyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOfficeCurrencyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] loclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_krw_xch_rt", length));
			String[] rgnOfcFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_flg", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] level4 = (JSPUtil.getParameter(request, prefix	+ "level4", length));
			String[] level2 = (JSPUtil.getParameter(request, prefix	+ "level2", length));
			String[] level3 = (JSPUtil.getParameter(request, prefix	+ "level3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] level1 = (JSPUtil.getParameter(request, prefix	+ "level1", length));
			String[] usdKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_krw_xch_rt", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficeCurrencyVO();
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (loclKrwXchRt[i] != null)
					model.setLoclKrwXchRt(loclKrwXchRt[i]);
				if (rgnOfcFlg[i] != null)
					model.setRgnOfcFlg(rgnOfcFlg[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (level4[i] != null)
					model.setLevel4(level4[i]);
				if (level2[i] != null)
					model.setLevel2(level2[i]);
				if (level3[i] != null)
					model.setLevel3(level3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (level1[i] != null)
					model.setLevel1(level1[i]);
				if (usdKrwXchRt[i] != null)
					model.setUsdKrwXchRt(usdKrwXchRt[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOfficeCurrencyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOfficeCurrencyVO[]
	 */
	public SearchOfficeCurrencyVO[] getSearchOfficeCurrencyVOs(){
		SearchOfficeCurrencyVO[] vos = (SearchOfficeCurrencyVO[])models.toArray(new SearchOfficeCurrencyVO[models.size()]);
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
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclKrwXchRt = this.loclKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcFlg = this.rgnOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level4 = this.level4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level2 = this.level2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level3 = this.level3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level1 = this.level1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdKrwXchRt = this.usdKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
