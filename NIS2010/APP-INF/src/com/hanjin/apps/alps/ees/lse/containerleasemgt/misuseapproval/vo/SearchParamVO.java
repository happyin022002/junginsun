/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.20 장준우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Search Param Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchParamVO> models = new ArrayList<SearchParamVO>();
	
	/* Column Info */
	private String mssRqstIoModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String endRqstDt = null;
	/* Column Info */
	private String strRqstDt = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String mssUsdAproFlag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchParamVO() {}

	public SearchParamVO(String ibflag, String pagerows, String rqstOfcCd, String mssRqstIoModCd, String strRqstDt, String endRqstDt, String mssUsdAproFlag) {
		this.mssRqstIoModCd = mssRqstIoModCd;
		this.ibflag = ibflag;
		this.endRqstDt = endRqstDt;
		this.strRqstDt = strRqstDt;
		this.rqstOfcCd = rqstOfcCd;
		this.mssUsdAproFlag = mssUsdAproFlag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mss_rqst_io_mod_cd", getMssRqstIoModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("end_rqst_dt", getEndRqstDt());
		this.hashColumns.put("str_rqst_dt", getStrRqstDt());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("mss_usd_apro_flag", getMssUsdAproFlag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mss_rqst_io_mod_cd", "mssRqstIoModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("end_rqst_dt", "endRqstDt");
		this.hashFields.put("str_rqst_dt", "strRqstDt");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("mss_usd_apro_flag", "mssUsdAproFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mssRqstIoModCd
	 */
	public String getMssRqstIoModCd() {
		return this.mssRqstIoModCd;
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
	 * @return endRqstDt
	 */
	public String getEndRqstDt() {
		return this.endRqstDt;
	}
	
	/**
	 * Column Info
	 * @return strRqstDt
	 */
	public String getStrRqstDt() {
		return this.strRqstDt;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mssUsdAproFlag
	 */
	public String getMssUsdAproFlag() {
		return this.mssUsdAproFlag;
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
	 * @param mssRqstIoModCd
	 */
	public void setMssRqstIoModCd(String mssRqstIoModCd) {
		this.mssRqstIoModCd = mssRqstIoModCd;
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
	 * @param endRqstDt
	 */
	public void setEndRqstDt(String endRqstDt) {
		this.endRqstDt = endRqstDt;
	}
	
	/**
	 * Column Info
	 * @param strRqstDt
	 */
	public void setStrRqstDt(String strRqstDt) {
		this.strRqstDt = strRqstDt;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mssUsdAproFlag
	 */
	public void setMssUsdAproFlag(String mssUsdAproFlag) {
		this.mssUsdAproFlag = mssUsdAproFlag;
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
		setMssRqstIoModCd(JSPUtil.getParameter(request, "mss_rqst_io_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEndRqstDt(JSPUtil.getParameter(request, "end_rqst_dt", "").replaceAll("-", ""));
		setStrRqstDt(JSPUtil.getParameter(request, "str_rqst_dt", "").replaceAll("-", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setMssUsdAproFlag(JSPUtil.getParameter(request, "mss_usd_apro_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mssRqstIoModCd = (JSPUtil.getParameter(request, prefix	+ "mss_rqst_io_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] endRqstDt = (JSPUtil.getParameter(request, prefix	+ "end_rqst_dt", length));
			String[] strRqstDt = (JSPUtil.getParameter(request, prefix	+ "str_rqst_dt", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] mssUsdAproFlag = (JSPUtil.getParameter(request, prefix	+ "mss_usd_apro_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchParamVO();
				if (mssRqstIoModCd[i] != null)
					model.setMssRqstIoModCd(mssRqstIoModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (endRqstDt[i] != null)
					model.setEndRqstDt(endRqstDt[i]);
				if (strRqstDt[i] != null)
					model.setStrRqstDt(strRqstDt[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (mssUsdAproFlag[i] != null)
					model.setMssUsdAproFlag(mssUsdAproFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[] getSearchParamVOs(){
		SearchParamVO[] vos = (SearchParamVO[])models.toArray(new SearchParamVO[models.size()]);
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
		this.mssRqstIoModCd = this.mssRqstIoModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endRqstDt = this.endRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strRqstDt = this.strRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssUsdAproFlag = this.mssUsdAproFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
