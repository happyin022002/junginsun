/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpcSlotInfoByVvdOnVesselListVO.java
*@FileTitle : SearchSpcSlotInfoByVvdOnVesselListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.09 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpcSlotInfoByVvdOnVesselListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpcSlotInfoByVvdOnVesselListVO> models = new ArrayList<SearchSpcSlotInfoByVvdOnVesselListVO>();
	
	/* Column Info */
	private String vslLaneTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String weightTtl = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String rf = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String weightTeu = null;
	/* Column Info */
	private String d2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String d3 = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String costYrwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpcSlotInfoByVvdOnVesselListVO() {}

	public SearchSpcSlotInfoByVvdOnVesselListVO(String ibflag, String pagerows, String costYrwk, String trdCd, String subTrdCd, String slanCd, String rlaneCd, String vslLaneTpCd, String vslCd, String skdVoyNo, String skdDirCd, String vopCd, String bsaCapa, String crrCd, String bsa, String weightTeu, String weightTtl, String rf, String d2, String d3, String d4, String d5, String d7) {
		this.vslLaneTpCd = vslLaneTpCd;
		this.vslCd = vslCd;
		this.vopCd = vopCd;
		this.weightTtl = weightTtl;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.rf = rf;
		this.d5 = d5;
		this.d4 = d4;
		this.d7 = d7;
		this.crrCd = crrCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.bsaCapa = bsaCapa;
		this.weightTeu = weightTeu;
		this.d2 = d2;
		this.ibflag = ibflag;
		this.d3 = d3;
		this.slanCd = slanCd;
		this.bsa = bsa;
		this.subTrdCd = subTrdCd;
		this.costYrwk = costYrwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_lane_tp_cd", getVslLaneTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("weight_ttl", getWeightTtl());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rf", getRf());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("weight_teu", getWeightTeu());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d3", getD3());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_lane_tp_cd", "vslLaneTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("weight_ttl", "weightTtl");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rf", "rf");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("weight_teu", "weightTeu");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d3", "d3");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslLaneTpCd
	 */
	public String getVslLaneTpCd() {
		return this.vslLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
	}
	
	/**
	 * Column Info
	 * @return weightTtl
	 */
	public String getWeightTtl() {
		return this.weightTtl;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return rf
	 */
	public String getRf() {
		return this.rf;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
	}
	
	/**
	 * Column Info
	 * @return weightTeu
	 */
	public String getWeightTeu() {
		return this.weightTeu;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return d3
	 */
	public String getD3() {
		return this.d3;
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
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
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
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
	}
	

	/**
	 * Column Info
	 * @param vslLaneTpCd
	 */
	public void setVslLaneTpCd(String vslLaneTpCd) {
		this.vslLaneTpCd = vslLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
	}
	
	/**
	 * Column Info
	 * @param weightTtl
	 */
	public void setWeightTtl(String weightTtl) {
		this.weightTtl = weightTtl;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param rf
	 */
	public void setRf(String rf) {
		this.rf = rf;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
	}
	
	/**
	 * Column Info
	 * @param weightTeu
	 */
	public void setWeightTeu(String weightTeu) {
		this.weightTeu = weightTeu;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param d3
	 */
	public void setD3(String d3) {
		this.d3 = d3;
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
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
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
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslLaneTpCd(JSPUtil.getParameter(request, "vsl_lane_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setWeightTtl(JSPUtil.getParameter(request, "weight_ttl", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRf(JSPUtil.getParameter(request, "rf", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setD7(JSPUtil.getParameter(request, "d7", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBsaCapa(JSPUtil.getParameter(request, "bsa_capa", ""));
		setWeightTeu(JSPUtil.getParameter(request, "weight_teu", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setD3(JSPUtil.getParameter(request, "d3", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setBsa(JSPUtil.getParameter(request, "bsa", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, "cost_yrwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpcSlotInfoByVvdOnVesselListVO[]
	 */
	public SearchSpcSlotInfoByVvdOnVesselListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpcSlotInfoByVvdOnVesselListVO[]
	 */
	public SearchSpcSlotInfoByVvdOnVesselListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpcSlotInfoByVvdOnVesselListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] weightTtl = (JSPUtil.getParameter(request, prefix	+ "weight_ttl", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] rf = (JSPUtil.getParameter(request, prefix	+ "rf", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] weightTeu = (JSPUtil.getParameter(request, prefix	+ "weight_teu", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] d3 = (JSPUtil.getParameter(request, prefix	+ "d3", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpcSlotInfoByVvdOnVesselListVO();
				if (vslLaneTpCd[i] != null)
					model.setVslLaneTpCd(vslLaneTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (weightTtl[i] != null)
					model.setWeightTtl(weightTtl[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (rf[i] != null)
					model.setRf(rf[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (weightTeu[i] != null)
					model.setWeightTeu(weightTeu[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (d3[i] != null)
					model.setD3(d3[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpcSlotInfoByVvdOnVesselListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpcSlotInfoByVvdOnVesselListVO[]
	 */
	public SearchSpcSlotInfoByVvdOnVesselListVO[] getSearchSpcSlotInfoByVvdOnVesselListVOs(){
		SearchSpcSlotInfoByVvdOnVesselListVO[] vos = (SearchSpcSlotInfoByVvdOnVesselListVO[])models.toArray(new SearchSpcSlotInfoByVvdOnVesselListVO[models.size()]);
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
		this.vslLaneTpCd = this.vslLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weightTtl = this.weightTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf = this.rf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weightTeu = this.weightTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d3 = this.d3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
