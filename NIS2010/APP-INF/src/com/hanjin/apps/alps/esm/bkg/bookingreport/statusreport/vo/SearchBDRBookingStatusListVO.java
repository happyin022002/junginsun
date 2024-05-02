/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBDRBookingStatusListVO.java
*@FileTitle : SearchBDRBookingStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.06.01 김경섭 
* 1.0 Creation 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBDRBookingStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBDRBookingStatusListVO> models = new ArrayList<SearchBDRBookingStatusListVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String trnkBdrFlg = null;
	/* Column Info */
	private String fdrBdrDt = null;
	/* Column Info */
	private String runtime = null;
	/* Column Info */
	private String fdrBdrFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String trnkBdrDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String trnkBdrDys = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String periodType = null;
	/* Column Info */
	private String bdrDt = null;
	/* Column Info */
	private String slanDir = null;
	/* Column Info */
	private String fdrBdrDys = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBDRBookingStatusListVO() {}

	/**
	 * 생성자 메소드
	 * @return SearchBDRBookingStatusListVO
	 */
	public SearchBDRBookingStatusListVO(String ibflag, String pagerows, String slanCd, String skdDirCd, String vvdCd, String polCd, String vpsEtdDt, String podCd, String trnkBdrDys, String trnkBdrDt, String trnkBdrFlg, String fdrBdrDys, String fdrBdrDt, String fdrBdrFlg, String bdrDt, String runtime, String slanDir, String fromDt, String toDt, String periodType) {
		this.fromDt = fromDt;
		this.vpsEtdDt = vpsEtdDt;
		this.trnkBdrFlg = trnkBdrFlg;
		this.fdrBdrDt = fdrBdrDt;
		this.runtime = runtime;
		this.fdrBdrFlg = fdrBdrFlg;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.podCd = podCd;
		this.trnkBdrDt = trnkBdrDt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.slanCd = slanCd;
		this.trnkBdrDys = trnkBdrDys;
		this.vvdCd = vvdCd;
		this.periodType = periodType;
		this.bdrDt = bdrDt;
		this.slanDir = slanDir;
		this.fdrBdrDys = fdrBdrDys;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("trnk_bdr_flg", getTrnkBdrFlg());
		this.hashColumns.put("fdr_bdr_dt", getFdrBdrDt());
		this.hashColumns.put("runtime", getRuntime());
		this.hashColumns.put("fdr_bdr_flg", getFdrBdrFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trnk_bdr_dt", getTrnkBdrDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("trnk_bdr_dys", getTrnkBdrDys());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("period_type", getPeriodType());
		this.hashColumns.put("bdr_dt", getBdrDt());
		this.hashColumns.put("slan_dir", getSlanDir());
		this.hashColumns.put("fdr_bdr_dys", getFdrBdrDys());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("trnk_bdr_flg", "trnkBdrFlg");
		this.hashFields.put("fdr_bdr_dt", "fdrBdrDt");
		this.hashFields.put("runtime", "runtime");
		this.hashFields.put("fdr_bdr_flg", "fdrBdrFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trnk_bdr_dt", "trnkBdrDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("trnk_bdr_dys", "trnkBdrDys");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("period_type", "periodType");
		this.hashFields.put("bdr_dt", "bdrDt");
		this.hashFields.put("slan_dir", "slanDir");
		this.hashFields.put("fdr_bdr_dys", "fdrBdrDys");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return trnkBdrFlg
	 */
	public String getTrnkBdrFlg() {
		return this.trnkBdrFlg;
	}
	
	/**
	 * Column Info
	 * @return fdrBdrDt
	 */
	public String getFdrBdrDt() {
		return this.fdrBdrDt;
	}
	
	/**
	 * Column Info
	 * @return runtime
	 */
	public String getRuntime() {
		return this.runtime;
	}
	
	/**
	 * Column Info
	 * @return fdrBdrFlg
	 */
	public String getFdrBdrFlg() {
		return this.fdrBdrFlg;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return trnkBdrDt
	 */
	public String getTrnkBdrDt() {
		return this.trnkBdrDt;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return trnkBdrDys
	 */
	public String getTrnkBdrDys() {
		return this.trnkBdrDys;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return periodType
	 */
	public String getPeriodType() {
		return this.periodType;
	}
	
	/**
	 * Column Info
	 * @return bdrDt
	 */
	public String getBdrDt() {
		return this.bdrDt;
	}
	
	/**
	 * Column Info
	 * @return slanDir
	 */
	public String getSlanDir() {
		return this.slanDir;
	}
	
	/**
	 * Column Info
	 * @return fdrBdrDys
	 */
	public String getFdrBdrDys() {
		return this.fdrBdrDys;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param trnkBdrFlg
	 */
	public void setTrnkBdrFlg(String trnkBdrFlg) {
		this.trnkBdrFlg = trnkBdrFlg;
	}
	
	/**
	 * Column Info
	 * @param fdrBdrDt
	 */
	public void setFdrBdrDt(String fdrBdrDt) {
		this.fdrBdrDt = fdrBdrDt;
	}
	
	/**
	 * Column Info
	 * @param runtime
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	
	/**
	 * Column Info
	 * @param fdrBdrFlg
	 */
	public void setFdrBdrFlg(String fdrBdrFlg) {
		this.fdrBdrFlg = fdrBdrFlg;
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
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param trnkBdrDt
	 */
	public void setTrnkBdrDt(String trnkBdrDt) {
		this.trnkBdrDt = trnkBdrDt;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param trnkBdrDys
	 */
	public void setTrnkBdrDys(String trnkBdrDys) {
		this.trnkBdrDys = trnkBdrDys;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param periodType
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	
	/**
	 * Column Info
	 * @param bdrDt
	 */
	public void setBdrDt(String bdrDt) {
		this.bdrDt = bdrDt;
	}
	
	/**
	 * Column Info
	 * @param slanDir
	 */
	public void setSlanDir(String slanDir) {
		this.slanDir = slanDir;
	}
	
	/**
	 * Column Info
	 * @param fdrBdrDys
	 */
	public void setFdrBdrDys(String fdrBdrDys) {
		this.fdrBdrDys = fdrBdrDys;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setTrnkBdrFlg(JSPUtil.getParameter(request, "trnk_bdr_flg", ""));
		setFdrBdrDt(JSPUtil.getParameter(request, "fdr_bdr_dt", ""));
		setRuntime(JSPUtil.getParameter(request, "runtime", ""));
		setFdrBdrFlg(JSPUtil.getParameter(request, "fdr_bdr_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTrnkBdrDt(JSPUtil.getParameter(request, "trnk_bdr_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setTrnkBdrDys(JSPUtil.getParameter(request, "trnk_bdr_dys", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPeriodType(JSPUtil.getParameter(request, "period_type", ""));
		setBdrDt(JSPUtil.getParameter(request, "bdr_dt", ""));
		setSlanDir(JSPUtil.getParameter(request, "slan_dir", ""));
		setFdrBdrDys(JSPUtil.getParameter(request, "fdr_bdr_dys", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBDRBookingStatusListVO[]
	 */
	public SearchBDRBookingStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBDRBookingStatusListVO[]
	 */
	public SearchBDRBookingStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBDRBookingStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt".trim(), length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt".trim(), length));
			String[] trnkBdrFlg = (JSPUtil.getParameter(request, prefix	+ "trnk_bdr_flg".trim(), length));
			String[] fdrBdrDt = (JSPUtil.getParameter(request, prefix	+ "fdr_bdr_dt".trim(), length));
			String[] runtime = (JSPUtil.getParameter(request, prefix	+ "runtime".trim(), length));
			String[] fdrBdrFlg = (JSPUtil.getParameter(request, prefix	+ "fdr_bdr_flg".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] trnkBdrDt = (JSPUtil.getParameter(request, prefix	+ "trnk_bdr_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] trnkBdrDys = (JSPUtil.getParameter(request, prefix	+ "trnk_bdr_dys".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] periodType = (JSPUtil.getParameter(request, prefix	+ "period_type".trim(), length));
			String[] bdrDt = (JSPUtil.getParameter(request, prefix	+ "bdr_dt".trim(), length));
			String[] slanDir = (JSPUtil.getParameter(request, prefix	+ "slan_dir".trim(), length));
			String[] fdrBdrDys = (JSPUtil.getParameter(request, prefix	+ "fdr_bdr_dys".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBDRBookingStatusListVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (trnkBdrFlg[i] != null)
					model.setTrnkBdrFlg(trnkBdrFlg[i]);
				if (fdrBdrDt[i] != null)
					model.setFdrBdrDt(fdrBdrDt[i]);
				if (runtime[i] != null)
					model.setRuntime(runtime[i]);
				if (fdrBdrFlg[i] != null)
					model.setFdrBdrFlg(fdrBdrFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (trnkBdrDt[i] != null)
					model.setTrnkBdrDt(trnkBdrDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (trnkBdrDys[i] != null)
					model.setTrnkBdrDys(trnkBdrDys[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (periodType[i] != null)
					model.setPeriodType(periodType[i]);
				if (bdrDt[i] != null)
					model.setBdrDt(bdrDt[i]);
				if (slanDir[i] != null)
					model.setSlanDir(slanDir[i]);
				if (fdrBdrDys[i] != null)
					model.setFdrBdrDys(fdrBdrDys[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBDRBookingStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBDRBookingStatusListVO[]
	 */
	public SearchBDRBookingStatusListVO[] getSearchBDRBookingStatusListVOs(){
		SearchBDRBookingStatusListVO[] vos = (SearchBDRBookingStatusListVO[])models.toArray(new SearchBDRBookingStatusListVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkBdrFlg = this.trnkBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrBdrDt = this.fdrBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runtime = this.runtime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrBdrFlg = this.fdrBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkBdrDt = this.trnkBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkBdrDys = this.trnkBdrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodType = this.periodType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDt = this.bdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanDir = this.slanDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrBdrDys = this.fdrBdrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
