/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltGlMonXchRtVO.java
*@FileTitle : RsltGlMonXchRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.25 김재연 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.primasterdata.exchangerate.vo;

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
 * @author 김재연
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltGlMonXchRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltGlMonXchRtVO> models = new ArrayList<RsltGlMonXchRtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String loclKrwXchRt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
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
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltGlMonXchRtVO() {}

	public RsltGlMonXchRtVO(String ibflag, String pagerows, String acctXchRtYrmon, String currCd, String currNm, String usdLoclXchRt, String loclKrwXchRt, String usdKrwXchRt, String creDt, String updDt) {
		this.updDt = updDt;
		this.loclKrwXchRt = loclKrwXchRt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.acctXchRtYrmon = acctXchRtYrmon;
		this.creDt = creDt;
		this.currNm = currNm;
		this.usdKrwXchRt = usdKrwXchRt;
		this.usdLoclXchRt = usdLoclXchRt;
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
		this.hashColumns.put("acct_xch_rt_yrmon", getAcctXchRtYrmon());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("curr_nm", getCurrNm());
		this.hashColumns.put("usd_krw_xch_rt", getUsdKrwXchRt());
		this.hashColumns.put("usd_locl_xch_rt", getUsdLoclXchRt());
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
		this.hashFields.put("acct_xch_rt_yrmon", "acctXchRtYrmon");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("curr_nm", "currNm");
		this.hashFields.put("usd_krw_xch_rt", "usdKrwXchRt");
		this.hashFields.put("usd_locl_xch_rt", "usdLoclXchRt");
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
		setAcctXchRtYrmon(JSPUtil.getParameter(request, "acct_xch_rt_yrmon", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCurrNm(JSPUtil.getParameter(request, "curr_nm", ""));
		setUsdKrwXchRt(JSPUtil.getParameter(request, "usd_krw_xch_rt", ""));
		setUsdLoclXchRt(JSPUtil.getParameter(request, "usd_locl_xch_rt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltGlMonXchRtVO[]
	 */
	public RsltGlMonXchRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltGlMonXchRtVO[]
	 */
	public RsltGlMonXchRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltGlMonXchRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] loclKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "locl_krw_xch_rt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] acctXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_yrmon", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] currNm = (JSPUtil.getParameter(request, prefix	+ "curr_nm", length));
			String[] usdKrwXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_krw_xch_rt", length));
			String[] usdLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_locl_xch_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltGlMonXchRtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (loclKrwXchRt[i] != null)
					model.setLoclKrwXchRt(loclKrwXchRt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
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
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltGlMonXchRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltGlMonXchRtVO[]
	 */
	public RsltGlMonXchRtVO[] getRsltGlMonXchRtVOs(){
		RsltGlMonXchRtVO[] vos = (RsltGlMonXchRtVO[])models.toArray(new RsltGlMonXchRtVO[models.size()]);
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
		this.acctXchRtYrmon = this.acctXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currNm = this.currNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdKrwXchRt = this.usdKrwXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdLoclXchRt = this.usdLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
