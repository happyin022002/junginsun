/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExchangeRateParmVO.java
*@FileTitle : ExchangeRateParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.12 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExchangeRateParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExchangeRateParmVO> models = new ArrayList<ExchangeRateParmVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String fmCurCd = null;
	/* Column Info */
	private String skdVoyageNo = null;
	/* Column Info */
	private String ioBnd = null;
	/* Column Info */
	private String toCurCd = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExchangeRateParmVO() {}

	public ExchangeRateParmVO(String ibflag, String pagerows, String polLoc, String podLoc, String ioBnd, String vslCd, String skdVoyageNo, String skdDirCd, String fmCurCd, String toCurCd, String ofcCd) {
		this.ofcCd = ofcCd;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.polLoc = polLoc;
		this.fmCurCd = fmCurCd;
		this.skdVoyageNo = skdVoyageNo;
		this.ioBnd = ioBnd;
		this.toCurCd = toCurCd;
		this.podLoc = podLoc;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("fm_cur_cd", getFmCurCd());
		this.hashColumns.put("skd_voyage_no", getSkdVoyageNo());
		this.hashColumns.put("io_bnd", getIoBnd());
		this.hashColumns.put("to_cur_cd", getToCurCd());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("fm_cur_cd", "fmCurCd");
		this.hashFields.put("skd_voyage_no", "skdVoyageNo");
		this.hashFields.put("io_bnd", "ioBnd");
		this.hashFields.put("to_cur_cd", "toCurCd");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}
	
	/**
	 * Column Info
	 * @return fmCurCd
	 */
	public String getFmCurCd() {
		return this.fmCurCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyageNo
	 */
	public String getSkdVoyageNo() {
		return this.skdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @return ioBnd
	 */
	public String getIoBnd() {
		return this.ioBnd;
	}
	
	/**
	 * Column Info
	 * @return toCurCd
	 */
	public String getToCurCd() {
		return this.toCurCd;
	}
	
	/**
	 * Column Info
	 * @return podLoc
	 */
	public String getPodLoc() {
		return this.podLoc;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param polLoc
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}
	
	/**
	 * Column Info
	 * @param fmCurCd
	 */
	public void setFmCurCd(String fmCurCd) {
		this.fmCurCd = fmCurCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyageNo
	 */
	public void setSkdVoyageNo(String skdVoyageNo) {
		this.skdVoyageNo = skdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @param ioBnd
	 */
	public void setIoBnd(String ioBnd) {
		this.ioBnd = ioBnd;
	}
	
	/**
	 * Column Info
	 * @param toCurCd
	 */
	public void setToCurCd(String toCurCd) {
		this.toCurCd = toCurCd;
	}
	
	/**
	 * Column Info
	 * @param podLoc
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
		setFmCurCd(JSPUtil.getParameter(request, "fm_cur_cd", ""));
		setSkdVoyageNo(JSPUtil.getParameter(request, "skd_voyage_no", ""));
		setIoBnd(JSPUtil.getParameter(request, "io_bnd", ""));
		setToCurCd(JSPUtil.getParameter(request, "to_cur_cd", ""));
		setPodLoc(JSPUtil.getParameter(request, "pod_loc", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExchangeRateParmVO[]
	 */
	public ExchangeRateParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExchangeRateParmVO[]
	 */
	public ExchangeRateParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExchangeRateParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] fmCurCd = (JSPUtil.getParameter(request, prefix	+ "fm_cur_cd", length));
			String[] skdVoyageNo = (JSPUtil.getParameter(request, prefix	+ "skd_voyage_no", length));
			String[] ioBnd = (JSPUtil.getParameter(request, prefix	+ "io_bnd", length));
			String[] toCurCd = (JSPUtil.getParameter(request, prefix	+ "to_cur_cd", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExchangeRateParmVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (fmCurCd[i] != null)
					model.setFmCurCd(fmCurCd[i]);
				if (skdVoyageNo[i] != null)
					model.setSkdVoyageNo(skdVoyageNo[i]);
				if (ioBnd[i] != null)
					model.setIoBnd(ioBnd[i]);
				if (toCurCd[i] != null)
					model.setToCurCd(toCurCd[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExchangeRateParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExchangeRateParmVO[]
	 */
	public ExchangeRateParmVO[] getExchangeRateParmVOs(){
		ExchangeRateParmVO[] vos = (ExchangeRateParmVO[])models.toArray(new ExchangeRateParmVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCurCd = this.fmCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyageNo = this.skdVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBnd = this.ioBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCurCd = this.toCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
