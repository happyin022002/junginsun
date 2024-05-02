/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstGlMonXchRtVO.java
*@FileTitle : CstGlMonXchRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.24 김재연 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo;

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
 * @author 김재연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstGlMonXchRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstGlMonXchRtVO> models = new ArrayList<CstGlMonXchRtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String loclKrwXchRt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String toAcctXchRtYrmon = null;
	/* Column Info */
	private String acctXchRtYrmon = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String currNm = null;
	/* Column Info */
	private String usdKrwXchRt = null;
	/* Column Info */
	private String usdLoclXchRt = null;
	/* Column Info */
	private String fromAcctXchRtYrmon = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstGlMonXchRtVO() {}

	public CstGlMonXchRtVO(String ibflag, String pagerows, String acctXchRtYrmon, String currCd, String currNm, String usdLoclXchRt, String loclKrwXchRt, String usdKrwXchRt, String creDt, String updDt, String fromAcctXchRtYrmon, String toAcctXchRtYrmon) {
		this.updDt = updDt;
		this.loclKrwXchRt = loclKrwXchRt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.toAcctXchRtYrmon = toAcctXchRtYrmon;
		this.acctXchRtYrmon = acctXchRtYrmon;
		this.creDt = creDt;
		this.currNm = currNm;
		this.usdKrwXchRt = usdKrwXchRt;
		this.usdLoclXchRt = usdLoclXchRt;
		this.fromAcctXchRtYrmon = fromAcctXchRtYrmon;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("locl_krw_xch_rt", getLoclKrwXchRt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("to_acct_xch_rt_yrmon", getToAcctXchRtYrmon());
		this.hashColumns.put("acct_xch_rt_yrmon", getAcctXchRtYrmon());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("curr_nm", getCurrNm());
		this.hashColumns.put("usd_krw_xch_rt", getUsdKrwXchRt());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
		this.hashColumns.put("from_acct_xch_rt_yrmon", getFromAcctXchRtYrmon());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("locl_krw_xch_rt", "loclKrwXchRt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("to_acct_xch_rt_yrmon", "toAcctXchRtYrmon");
		this.hashFields.put("acct_xch_rt_yrmon", "acctXchRtYrmon");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("curr_nm", "currNm");
		this.hashFields.put("usd_krw_xch_rt", "usdKrwXchRt");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
		this.hashFields.put("from_acct_xch_rt_yrmon", "fromAcctXchRtYrmon");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return loclKrwXchRt
	 */
	public String getLoclKrwXchRt() {
		return this.loclKrwXchRt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return toAcctXchRtYrmon
	 */
	public String getToAcctXchRtYrmon() {
		return this.toAcctXchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @return acctXchRtYrmon
	 */
	public String getAcctXchRtYrmon() {
		return this.acctXchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return currNm
	 */
	public String getCurrNm() {
		return this.currNm;
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
	 * @return fromAcctXchRtYrmon
	 */
	public String getFromAcctXchRtYrmon() {
		return this.fromAcctXchRtYrmon;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param loclKrwXchRt
	 */
	public void setLoclKrwXchRt(String loclKrwXchRt) {
		this.loclKrwXchRt = loclKrwXchRt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param toAcctXchRtYrmon
	 */
	public void setToAcctXchRtYrmon(String toAcctXchRtYrmon) {
		this.toAcctXchRtYrmon = toAcctXchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @param acctXchRtYrmon
	 */
	public void setAcctXchRtYrmon(String acctXchRtYrmon) {
		this.acctXchRtYrmon = acctXchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param currNm
	 */
	public void setCurrNm(String currNm) {
		this.currNm = currNm;
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
	 * @param fromAcctXchRtYrmon
	 */
	public void setFromAcctXchRtYrmon(String fromAcctXchRtYrmon) {
		this.fromAcctXchRtYrmon = fromAcctXchRtYrmon;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLoclKrwXchRt(JSPUtil.getParameter(request, "locl_krw_xch_rt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setToAcctXchRtYrmon(JSPUtil.getParameter(request, "to_acct_xch_rt_yrmon", ""));
		setAcctXchRtYrmon(JSPUtil.getParameter(request, "acct_xch_rt_yrmon", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCurrNm(JSPUtil.getParameter(request, "curr_nm", ""));
		setUsdKrwXchRt(JSPUtil.getParameter(request, "usd_krw_xch_rt", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setFromAcctXchRtYrmon(JSPUtil.getParameter(request, "from_acct_xch_rt_yrmon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstGlMonXchRtVO[]
	 */
	public CstGlMonXchRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstGlMonXchRtVO[]
	 */
	public CstGlMonXchRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstGlMonXchRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] loclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_krw_xch_rt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] toAcctXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "to_acct_xch_rt_yrmon", length));
			String[] acctXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_yrmon", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] currNm = (JSPUtil.getParameter(request, prefix	+ "curr_nm", length));
			String[] usdKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_krw_xch_rt", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] fromAcctXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "from_acct_xch_rt_yrmon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstGlMonXchRtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (loclKrwXchRt[i] != null)
					model.setLoclKrwXchRt(loclKrwXchRt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (toAcctXchRtYrmon[i] != null)
					model.setToAcctXchRtYrmon(toAcctXchRtYrmon[i]);
				if (acctXchRtYrmon[i] != null)
					model.setAcctXchRtYrmon(acctXchRtYrmon[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (currNm[i] != null)
					model.setCurrNm(currNm[i]);
				if (usdKrwXchRt[i] != null)
					model.setUsdKrwXchRt(usdKrwXchRt[i]);
				if (usdLoclXchRt[i] != null)
					model.setUsdLoclXchRt(usdLoclXchRt[i]);
				if (fromAcctXchRtYrmon[i] != null)
					model.setFromAcctXchRtYrmon(fromAcctXchRtYrmon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstGlMonXchRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstGlMonXchRtVO[]
	 */
	public CstGlMonXchRtVO[] getCstGlMonXchRtVOs(){
		CstGlMonXchRtVO[] vos = (CstGlMonXchRtVO[])models.toArray(new CstGlMonXchRtVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclKrwXchRt = this.loclKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAcctXchRtYrmon = this.toAcctXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtYrmon = this.acctXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currNm = this.currNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdKrwXchRt = this.usdKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromAcctXchRtYrmon = this.fromAcctXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
