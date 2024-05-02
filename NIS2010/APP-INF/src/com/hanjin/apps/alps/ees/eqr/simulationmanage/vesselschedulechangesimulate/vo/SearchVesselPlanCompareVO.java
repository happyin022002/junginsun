/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVesselPlanCompareVO.java
*@FileTitle : SearchVesselPlanCompareVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.04 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.simulationmanage.vesselschedulechangesimulate.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVesselPlanCompareVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVesselPlanCompareVO> models = new ArrayList<SearchVesselPlanCompareVO>();
	
	/* Column Info */
	private String mtyVol3 = null;
	/* Column Info */
	private String mtyVol1 = null;
	/* Column Info */
	private String mtyCost2 = null;
	/* Column Info */
	private String mtyCost1 = null;
	/* Column Info */
	private String mtyVol2 = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String mtyCost3 = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmEccCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVesselPlanCompareVO() {}

	public SearchVesselPlanCompareVO(String ibflag, String pagerows, String plnYrwk, String fmEccCd, String toEccCd, String vslLaneCd, String vvd, String mtyVol1, String mtyCost1, String mtyVol2, String mtyCost2, String mtyVol3, String mtyCost3) {
		this.mtyVol3 = mtyVol3;
		this.mtyVol1 = mtyVol1;
		this.mtyCost2 = mtyCost2;
		this.mtyCost1 = mtyCost1;
		this.mtyVol2 = mtyVol2;
		this.toEccCd = toEccCd;
		this.mtyCost3 = mtyCost3;
		this.plnYrwk = plnYrwk;
		this.pagerows = pagerows;
		this.vslLaneCd = vslLaneCd;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mty_vol3", getMtyVol3());
		this.hashColumns.put("mty_vol1", getMtyVol1());
		this.hashColumns.put("mty_cost2", getMtyCost2());
		this.hashColumns.put("mty_cost1", getMtyCost1());
		this.hashColumns.put("mty_vol2", getMtyVol2());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("mty_cost3", getMtyCost3());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mty_vol3", "mtyVol3");
		this.hashFields.put("mty_vol1", "mtyVol1");
		this.hashFields.put("mty_cost2", "mtyCost2");
		this.hashFields.put("mty_cost1", "mtyCost1");
		this.hashFields.put("mty_vol2", "mtyVol2");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("mty_cost3", "mtyCost3");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mtyVol3
	 */
	public String getMtyVol3() {
		return this.mtyVol3;
	}
	
	/**
	 * Column Info
	 * @return mtyVol1
	 */
	public String getMtyVol1() {
		return this.mtyVol1;
	}
	
	/**
	 * Column Info
	 * @return mtyCost2
	 */
	public String getMtyCost2() {
		return this.mtyCost2;
	}
	
	/**
	 * Column Info
	 * @return mtyCost1
	 */
	public String getMtyCost1() {
		return this.mtyCost1;
	}
	
	/**
	 * Column Info
	 * @return mtyVol2
	 */
	public String getMtyVol2() {
		return this.mtyVol2;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return mtyCost3
	 */
	public String getMtyCost3() {
		return this.mtyCost3;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
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
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
	}
	

	/**
	 * Column Info
	 * @param mtyVol3
	 */
	public void setMtyVol3(String mtyVol3) {
		this.mtyVol3 = mtyVol3;
	}
	
	/**
	 * Column Info
	 * @param mtyVol1
	 */
	public void setMtyVol1(String mtyVol1) {
		this.mtyVol1 = mtyVol1;
	}
	
	/**
	 * Column Info
	 * @param mtyCost2
	 */
	public void setMtyCost2(String mtyCost2) {
		this.mtyCost2 = mtyCost2;
	}
	
	/**
	 * Column Info
	 * @param mtyCost1
	 */
	public void setMtyCost1(String mtyCost1) {
		this.mtyCost1 = mtyCost1;
	}
	
	/**
	 * Column Info
	 * @param mtyVol2
	 */
	public void setMtyVol2(String mtyVol2) {
		this.mtyVol2 = mtyVol2;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param mtyCost3
	 */
	public void setMtyCost3(String mtyCost3) {
		this.mtyCost3 = mtyCost3;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
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
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMtyVol3(JSPUtil.getParameter(request, "mty_vol3", ""));
		setMtyVol1(JSPUtil.getParameter(request, "mty_vol1", ""));
		setMtyCost2(JSPUtil.getParameter(request, "mty_cost2", ""));
		setMtyCost1(JSPUtil.getParameter(request, "mty_cost1", ""));
		setMtyVol2(JSPUtil.getParameter(request, "mty_vol2", ""));
		setToEccCd(JSPUtil.getParameter(request, "to_ecc_cd", ""));
		setMtyCost3(JSPUtil.getParameter(request, "mty_cost3", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmEccCd(JSPUtil.getParameter(request, "fm_ecc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVesselPlanCompareVO[]
	 */
	public SearchVesselPlanCompareVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVesselPlanCompareVO[]
	 */
	public SearchVesselPlanCompareVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVesselPlanCompareVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mtyVol3 = (JSPUtil.getParameter(request, prefix	+ "mty_vol3", length));
			String[] mtyVol1 = (JSPUtil.getParameter(request, prefix	+ "mty_vol1", length));
			String[] mtyCost2 = (JSPUtil.getParameter(request, prefix	+ "mty_cost2", length));
			String[] mtyCost1 = (JSPUtil.getParameter(request, prefix	+ "mty_cost1", length));
			String[] mtyVol2 = (JSPUtil.getParameter(request, prefix	+ "mty_vol2", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] mtyCost3 = (JSPUtil.getParameter(request, prefix	+ "mty_cost3", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVesselPlanCompareVO();
				if (mtyVol3[i] != null)
					model.setMtyVol3(mtyVol3[i]);
				if (mtyVol1[i] != null)
					model.setMtyVol1(mtyVol1[i]);
				if (mtyCost2[i] != null)
					model.setMtyCost2(mtyCost2[i]);
				if (mtyCost1[i] != null)
					model.setMtyCost1(mtyCost1[i]);
				if (mtyVol2[i] != null)
					model.setMtyVol2(mtyVol2[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (mtyCost3[i] != null)
					model.setMtyCost3(mtyCost3[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVesselPlanCompareVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVesselPlanCompareVO[]
	 */
	public SearchVesselPlanCompareVO[] getSearchVesselPlanCompareVOs(){
		SearchVesselPlanCompareVO[] vos = (SearchVesselPlanCompareVO[])models.toArray(new SearchVesselPlanCompareVO[models.size()]);
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
		this.mtyVol3 = this.mtyVol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyVol1 = this.mtyVol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCost2 = this.mtyCost2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCost1 = this.mtyCost1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyVol2 = this.mtyVol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyCost3 = this.mtyCost3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
