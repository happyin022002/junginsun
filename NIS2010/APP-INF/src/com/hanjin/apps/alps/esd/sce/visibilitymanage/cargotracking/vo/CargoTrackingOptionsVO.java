/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoTrackingOptionsVO.java
*@FileTitle : CargoTrackingOptionsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.13 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CargoTrackingOptionsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CargoTrackingOptionsVO> models = new ArrayList<CargoTrackingOptionsVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String dateKind = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String custValue1 = null;
	/* Column Info */
	private String custValue2 = null;
	/* Column Info */
	private String soCreDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custCntSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String iPage = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CargoTrackingOptionsVO() {}

	public CargoTrackingOptionsVO(String ibflag, String pagerows, String scNo, String soCreDt, String porCd, String polCd, String podCd, String delCd, String fmDt, String toDt, String dateKind, String custCntSeq, String custValue1, String custValue2, String iPage) {
		this.porCd = porCd;
		this.dateKind = dateKind;
		this.fmDt = fmDt;
		this.delCd = delCd;
		this.custValue1 = custValue1;
		this.custValue2 = custValue2;
		this.soCreDt = soCreDt;
		this.pagerows = pagerows;
		this.custCntSeq = custCntSeq;
		this.podCd = podCd;
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.scNo = scNo;
		this.iPage = iPage;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("date_kind", getDateKind());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cust_value1", getCustValue1());
		this.hashColumns.put("cust_value2", getCustValue2());
		this.hashColumns.put("so_cre_dt", getSoCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_cnt_seq", getCustCntSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("i_page", getIPage());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("date_kind", "dateKind");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_value1", "custValue1");
		this.hashFields.put("cust_value2", "custValue2");
		this.hashFields.put("so_cre_dt", "soCreDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_cnt_seq", "custCntSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("i_page", "iPage");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return dateKind
	 */
	public String getDateKind() {
		return this.dateKind;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return custValue1
	 */
	public String getCustValue1() {
		return this.custValue1;
	}
	
	/**
	 * Column Info
	 * @return custValue2
	 */
	public String getCustValue2() {
		return this.custValue2;
	}
	
	/**
	 * Column Info
	 * @return soCreDt
	 */
	public String getSoCreDt() {
		return this.soCreDt;
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
	 * @return custCntSeq
	 */
	public String getCustCntSeq() {
		return this.custCntSeq;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param dateKind
	 */
	public void setDateKind(String dateKind) {
		this.dateKind = dateKind;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param custValue1
	 */
	public void setCustValue1(String custValue1) {
		this.custValue1 = custValue1;
	}
	
	/**
	 * Column Info
	 * @param custValue2
	 */
	public void setCustValue2(String custValue2) {
		this.custValue2 = custValue2;
	}
	
	/**
	 * Column Info
	 * @param soCreDt
	 */
	public void setSoCreDt(String soCreDt) {
		this.soCreDt = soCreDt;
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
	 * @param custCntSeq
	 */
	public void setCustCntSeq(String custCntSeq) {
		this.custCntSeq = custCntSeq;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setDateKind(JSPUtil.getParameter(request, "date_kind", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCustValue1(JSPUtil.getParameter(request, "cust_value1", ""));
		setCustValue2(JSPUtil.getParameter(request, "cust_value2", ""));
		setSoCreDt(JSPUtil.getParameter(request, "so_cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCustCntSeq(JSPUtil.getParameter(request, "cust_cnt_seq", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setIPage(JSPUtil.getParameter(request, "i_page", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CargoTrackingOptionsVO[]
	 */
	public CargoTrackingOptionsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CargoTrackingOptionsVO[]
	 */
	public CargoTrackingOptionsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CargoTrackingOptionsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] dateKind = (JSPUtil.getParameter(request, prefix	+ "date_kind", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] custValue1 = (JSPUtil.getParameter(request, prefix	+ "cust_value1", length));
			String[] custValue2 = (JSPUtil.getParameter(request, prefix	+ "cust_value2", length));
			String[] soCreDt = (JSPUtil.getParameter(request, prefix	+ "so_cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custCntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			
			for (int i = 0; i < length; i++) {
				model = new CargoTrackingOptionsVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (dateKind[i] != null)
					model.setDateKind(dateKind[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (custValue1[i] != null)
					model.setCustValue1(custValue1[i]);
				if (custValue2[i] != null)
					model.setCustValue2(custValue2[i]);
				if (soCreDt[i] != null)
					model.setSoCreDt(soCreDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custCntSeq[i] != null)
					model.setCustCntSeq(custCntSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCargoTrackingOptionsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CargoTrackingOptionsVO[]
	 */
	public CargoTrackingOptionsVO[] getCargoTrackingOptionsVOs(){
		CargoTrackingOptionsVO[] vos = (CargoTrackingOptionsVO[])models.toArray(new CargoTrackingOptionsVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateKind = this.dateKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custValue1 = this.custValue1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custValue2 = this.custValue2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreDt = this.soCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntSeq = this.custCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
