/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchNoShowAdjustmentListVO.java
*@FileTitle : SearchNoShowAdjustmentListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.01 한상훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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

public class SearchNoShowAdjustmentListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNoShowAdjustmentListVO> models = new ArrayList<SearchNoShowAdjustmentListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String alocDdctBseCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String alocLodQty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String orgFcastLodQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String fcastLodQty = null;
	/* Column Info */
	private String orgAlocLodQty = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String bkgLodQty = null;
	/* Column Info */
	private String aqCd = null;
	/* Column Info */
	private String shortfall = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNoShowAdjustmentListVO() {}

	public SearchNoShowAdjustmentListVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String costYr, String costWk, String vvd, String vslCd, String skdVoyNo, String skdDirCd, String alocDdctBseCd, String ofcKndCd, String aqCd, String ofcCd, String polYdCd, String orgFcastLodQty, String orgAlocLodQty, String fcastLodQty, String alocLodQty, String bkgLodQty, String shortfall, String ratio, String lvl) {
		this.vslCd = vslCd;
		this.ofcKndCd = ofcKndCd;
		this.alocDdctBseCd = alocDdctBseCd;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.alocLodQty = alocLodQty;
		this.skdDirCd = skdDirCd;
		this.orgFcastLodQty = orgFcastLodQty;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.lvl = lvl;
		this.ratio = ratio;
		this.costYr = costYr;
		this.fcastLodQty = fcastLodQty;
		this.orgAlocLodQty = orgAlocLodQty;
		this.polYdCd = polYdCd;
		this.costWk = costWk;
		this.bkgLodQty = bkgLodQty;
		this.aqCd = aqCd;
		this.shortfall = shortfall;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
		this.hashColumns.put("aloc_ddct_bse_cd", getAlocDdctBseCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("aloc_lod_qty", getAlocLodQty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("org_fcast_lod_qty", getOrgFcastLodQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("fcast_lod_qty", getFcastLodQty());
		this.hashColumns.put("org_aloc_lod_qty", getOrgAlocLodQty());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("bkg_lod_qty", getBkgLodQty());
		this.hashColumns.put("aq_cd", getAqCd());
		this.hashColumns.put("shortfall", getShortfall());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ofc_knd_cd", "ofcKndCd");
		this.hashFields.put("aloc_ddct_bse_cd", "alocDdctBseCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("aloc_lod_qty", "alocLodQty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("org_fcast_lod_qty", "orgFcastLodQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("fcast_lod_qty", "fcastLodQty");
		this.hashFields.put("org_aloc_lod_qty", "orgAlocLodQty");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("bkg_lod_qty", "bkgLodQty");
		this.hashFields.put("aq_cd", "aqCd");
		this.hashFields.put("shortfall", "shortfall");
		return this.hashFields;
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
	 * @return ofcKndCd
	 */
	public String getOfcKndCd() {
		return this.ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @return alocDdctBseCd
	 */
	public String getAlocDdctBseCd() {
		return this.alocDdctBseCd;
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
	 * @return alocLodQty
	 */
	public String getAlocLodQty() {
		return this.alocLodQty;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return orgFcastLodQty
	 */
	public String getOrgFcastLodQty() {
		return this.orgFcastLodQty;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return fcastLodQty
	 */
	public String getFcastLodQty() {
		return this.fcastLodQty;
	}
	
	/**
	 * Column Info
	 * @return orgAlocLodQty
	 */
	public String getOrgAlocLodQty() {
		return this.orgAlocLodQty;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return bkgLodQty
	 */
	public String getBkgLodQty() {
		return this.bkgLodQty;
	}
	
	/**
	 * Column Info
	 * @return aqCd
	 */
	public String getAqCd() {
		return this.aqCd;
	}
	
	/**
	 * Column Info
	 * @return shortfall
	 */
	public String getShortfall() {
		return this.shortfall;
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
	 * @param ofcKndCd
	 */
	public void setOfcKndCd(String ofcKndCd) {
		this.ofcKndCd = ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @param alocDdctBseCd
	 */
	public void setAlocDdctBseCd(String alocDdctBseCd) {
		this.alocDdctBseCd = alocDdctBseCd;
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
	 * @param alocLodQty
	 */
	public void setAlocLodQty(String alocLodQty) {
		this.alocLodQty = alocLodQty;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param orgFcastLodQty
	 */
	public void setOrgFcastLodQty(String orgFcastLodQty) {
		this.orgFcastLodQty = orgFcastLodQty;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param fcastLodQty
	 */
	public void setFcastLodQty(String fcastLodQty) {
		this.fcastLodQty = fcastLodQty;
	}
	
	/**
	 * Column Info
	 * @param orgAlocLodQty
	 */
	public void setOrgAlocLodQty(String orgAlocLodQty) {
		this.orgAlocLodQty = orgAlocLodQty;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param bkgLodQty
	 */
	public void setBkgLodQty(String bkgLodQty) {
		this.bkgLodQty = bkgLodQty;
	}
	
	/**
	 * Column Info
	 * @param aqCd
	 */
	public void setAqCd(String aqCd) {
		this.aqCd = aqCd;
	}
	
	/**
	 * Column Info
	 * @param shortfall
	 */
	public void setShortfall(String shortfall) {
		this.shortfall = shortfall;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setOfcKndCd(JSPUtil.getParameter(request, "ofc_knd_cd", ""));
		setAlocDdctBseCd(JSPUtil.getParameter(request, "aloc_ddct_bse_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setAlocLodQty(JSPUtil.getParameter(request, "aloc_lod_qty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setOrgFcastLodQty(JSPUtil.getParameter(request, "org_fcast_lod_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLvl(JSPUtil.getParameter(request, "lvl", ""));
		setRatio(JSPUtil.getParameter(request, "ratio", ""));
		setCostYr(JSPUtil.getParameter(request, "cost_yr", ""));
		setFcastLodQty(JSPUtil.getParameter(request, "fcast_lod_qty", ""));
		setOrgAlocLodQty(JSPUtil.getParameter(request, "org_aloc_lod_qty", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setBkgLodQty(JSPUtil.getParameter(request, "bkg_lod_qty", ""));
		setAqCd(JSPUtil.getParameter(request, "aq_cd", ""));
		setShortfall(JSPUtil.getParameter(request, "shortfall", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNoShowAdjustmentListVO[]
	 */
	public SearchNoShowAdjustmentListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNoShowAdjustmentListVO[]
	 */
	public SearchNoShowAdjustmentListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNoShowAdjustmentListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ofcKndCd = (JSPUtil.getParameter(request, prefix	+ "ofc_knd_cd", length));
			String[] alocDdctBseCd = (JSPUtil.getParameter(request, prefix	+ "aloc_ddct_bse_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] alocLodQty = (JSPUtil.getParameter(request, prefix	+ "aloc_lod_qty", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] orgFcastLodQty = (JSPUtil.getParameter(request, prefix	+ "org_fcast_lod_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] fcastLodQty = (JSPUtil.getParameter(request, prefix	+ "fcast_lod_qty", length));
			String[] orgAlocLodQty = (JSPUtil.getParameter(request, prefix	+ "org_aloc_lod_qty", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] bkgLodQty = (JSPUtil.getParameter(request, prefix	+ "bkg_lod_qty", length));
			String[] aqCd = (JSPUtil.getParameter(request, prefix	+ "aq_cd", length));
			String[] shortfall = (JSPUtil.getParameter(request, prefix	+ "shortfall", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNoShowAdjustmentListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ofcKndCd[i] != null)
					model.setOfcKndCd(ofcKndCd[i]);
				if (alocDdctBseCd[i] != null)
					model.setAlocDdctBseCd(alocDdctBseCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (alocLodQty[i] != null)
					model.setAlocLodQty(alocLodQty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (orgFcastLodQty[i] != null)
					model.setOrgFcastLodQty(orgFcastLodQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (fcastLodQty[i] != null)
					model.setFcastLodQty(fcastLodQty[i]);
				if (orgAlocLodQty[i] != null)
					model.setOrgAlocLodQty(orgAlocLodQty[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (bkgLodQty[i] != null)
					model.setBkgLodQty(bkgLodQty[i]);
				if (aqCd[i] != null)
					model.setAqCd(aqCd[i]);
				if (shortfall[i] != null)
					model.setShortfall(shortfall[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNoShowAdjustmentListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNoShowAdjustmentListVO[]
	 */
	public SearchNoShowAdjustmentListVO[] getSearchNoShowAdjustmentListVOs(){
		SearchNoShowAdjustmentListVO[] vos = (SearchNoShowAdjustmentListVO[])models.toArray(new SearchNoShowAdjustmentListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKndCd = this.ofcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocDdctBseCd = this.alocDdctBseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocLodQty = this.alocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFcastLodQty = this.orgFcastLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastLodQty = this.fcastLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgAlocLodQty = this.orgAlocLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLodQty = this.bkgLodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aqCd = this.aqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shortfall = this.shortfall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
