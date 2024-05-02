/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDailyForecastSrepAccountManageListVO.java
*@FileTitle : SearchDailyForecastSrepAccountManageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.26 한상훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDailyForecastSrepAccountManageListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDailyForecastSrepAccountManageListVO> models = new ArrayList<SearchDailyForecastSrepAccountManageListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String iocTsCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String fcastCustTpCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String ctrtCustCntCd = null;
	/* Column Info */
	private String ctrtCustSeq = null;
	/* Column Info */
	private String ctrtCustNm = null;
	/* Column Info */
	private String fcastSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDailyForecastSrepAccountManageListVO() {}

	public SearchDailyForecastSrepAccountManageListVO(String ibflag, String pagerows, String srepCd, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String iocTsCd, String custCntCd, String custSeq, String custNm, String fcastCustTpCd, String ctrtCustCntCd, String ctrtCustSeq, String ctrtCustNm, String fcastSeq) {
		this.ibflag = ibflag;
		this.iocTsCd = iocTsCd;
		this.custNm = custNm;
		this.fcastCustTpCd = fcastCustTpCd;
		this.trdCd = trdCd;
		this.dirCd = dirCd;
		this.rlaneCd = rlaneCd;
		this.custSeq = custSeq;
		this.srepCd = srepCd;
		this.custCntCd = custCntCd;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.ctrtCustSeq = ctrtCustSeq;
		this.ctrtCustNm = ctrtCustNm;
		this.fcastSeq = fcastSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ioc_ts_cd", getIocTsCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("fcast_cust_tp_cd", getFcastCustTpCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("ctrt_cust_nm", getCtrtCustNm());
		this.hashColumns.put("fcast_seq", getFcastSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ioc_ts_cd", "iocTsCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("fcast_cust_tp_cd", "fcastCustTpCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("ctrt_cust_nm", "ctrtCustNm");
		this.hashFields.put("fcast_seq", "fcastSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return iocTsCd
	 */
	public String getIocTsCd() {
		return this.iocTsCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return fcastCustTpCd
	 */
	public String getFcastCustTpCd() {
		return this.fcastCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public String getCtrtCustCntCd() {
		return this.ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public String getCtrtCustSeq() {
		return this.ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustNm
	 */
	public String getCtrtCustNm() {
		return this.ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @return fcastSeq
	 */
	public String getFcastSeq() {
		return this.fcastSeq;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param iocTsCd
	 */
	public void setIocTsCd(String iocTsCd) {
		this.iocTsCd = iocTsCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param fcastCustTpCd
	 */
	public void setFcastCustTpCd(String fcastCustTpCd) {
		this.fcastCustTpCd = fcastCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustCntCd
	 */
	public void setCtrtCustCntCd(String ctrtCustCntCd) {
		this.ctrtCustCntCd = ctrtCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSeq
	 */
	public void setCtrtCustSeq(String ctrtCustSeq) {
		this.ctrtCustSeq = ctrtCustSeq;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustNm
	 */
	public void setCtrtCustNm(String ctrtCustNm) {
		this.ctrtCustNm = ctrtCustNm;
	}
	
	/**
	 * Column Info
	 * @param fcastSeq
	 */
	public void setFcastSeq(String fcastSeq) {
		this.fcastSeq = fcastSeq;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIocTsCd(JSPUtil.getParameter(request, "ioc_ts_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setFcastCustTpCd(JSPUtil.getParameter(request, "fcast_cust_tp_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request, "ctrt_cust_cnt_cd", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request, "ctrt_cust_seq", ""));
		setCtrtCustNm(JSPUtil.getParameter(request, "ctrt_cust_nm", ""));
		setFcastSeq(JSPUtil.getParameter(request, "fcast_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDailyForecastSrepAccountManageListVO[]
	 */
	public SearchDailyForecastSrepAccountManageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDailyForecastSrepAccountManageListVO[]
	 */
	public SearchDailyForecastSrepAccountManageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDailyForecastSrepAccountManageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] iocTsCd = (JSPUtil.getParameter(request, prefix	+ "ioc_ts_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] fcastCustTpCd = (JSPUtil.getParameter(request, prefix	+ "fcast_cust_tp_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] ctrtCustCntCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_cnt_cd", length));
			String[] ctrtCustSeq = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_seq", length));
			String[] ctrtCustNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_nm", length));
			String[] fcastSeq = (JSPUtil.getParameter(request, prefix	+ "fcast_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDailyForecastSrepAccountManageListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (iocTsCd[i] != null)
					model.setIocTsCd(iocTsCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (fcastCustTpCd[i] != null)
					model.setFcastCustTpCd(fcastCustTpCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (ctrtCustCntCd[i] != null)
					model.setCtrtCustCntCd(ctrtCustCntCd[i]);
				if (ctrtCustSeq[i] != null)
					model.setCtrtCustSeq(ctrtCustSeq[i]);
				if (ctrtCustNm[i] != null)
					model.setCtrtCustNm(ctrtCustNm[i]);
				if (fcastSeq[i] != null)
					model.setFcastSeq(fcastSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDailyForecastSrepAccountManageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDailyForecastSrepAccountManageListVO[]
	 */
	public SearchDailyForecastSrepAccountManageListVO[] getSearchDailyForecastSrepAccountManageListVOs(){
		SearchDailyForecastSrepAccountManageListVO[] vos = (SearchDailyForecastSrepAccountManageListVO[])models.toArray(new SearchDailyForecastSrepAccountManageListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocTsCd = this.iocTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastCustTpCd = this.fcastCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd = this.ctrtCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq = this.ctrtCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustNm = this.ctrtCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastSeq = this.fcastSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
