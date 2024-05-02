/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchBasicDataCreationListVO.java
*@FileTitle : SearchBasicDataCreationListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.11
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.06.11 최윤성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBasicDataCreationListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBasicDataCreationListVO> models = new ArrayList<SearchBasicDataCreationListVO>();
	
	/* Column Info */
	private String aplyFmYrwk = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ofcLvl = null;
	/* Column Info */
	private String ofcVwCd = null;
	/* Column Info */
	private String durWks = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String paCmCost = null;
	/* Column Info */
	private String volRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String paCm = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String raCmCost = null;
	/* Column Info */
	private String grsRev = null;
	/* Column Info */
	private String grsRto = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Column Info */
	private String lodVol = null;
	/* Column Info */
	private String aplyToYrwk = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String raCm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBasicDataCreationListVO() {}

	public SearchBasicDataCreationListVO(String ibflag, String pagerows, String bseYr, String bseQtrCd, String ofcLvl, String ofcVwCd, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String rhqCd, String ofcCd, String lodVol, String grsRev, String vvdCnt, String raCm, String paCm, String raCmCost, String paCmCost, String volRto, String grsRto, String aplyFmYrwk, String aplyToYrwk, String durWks) {
		this.aplyFmYrwk = aplyFmYrwk;
		this.rhqCd = rhqCd;
		this.ofcLvl = ofcLvl;
		this.ofcVwCd = ofcVwCd;
		this.durWks = durWks;
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.paCmCost = paCmCost;
		this.volRto = volRto;
		this.pagerows = pagerows;
		this.paCm = paCm;
		this.bseQtrCd = bseQtrCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.raCmCost = raCmCost;
		this.grsRev = grsRev;
		this.grsRto = grsRto;
		this.dirCd = dirCd;
		this.vvdCnt = vvdCnt;
		this.lodVol = lodVol;
		this.aplyToYrwk = aplyToYrwk;
		this.subTrdCd = subTrdCd;
		this.raCm = raCm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aply_fm_yrwk", getAplyFmYrwk());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ofc_lvl", getOfcLvl());
		this.hashColumns.put("ofc_vw_cd", getOfcVwCd());
		this.hashColumns.put("dur_wks", getDurWks());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pa_cm_cost", getPaCmCost());
		this.hashColumns.put("vol_rto", getVolRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pa_cm", getPaCm());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ra_cm_cost", getRaCmCost());
		this.hashColumns.put("grs_rev", getGrsRev());
		this.hashColumns.put("grs_rto", getGrsRto());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("lod_vol", getLodVol());
		this.hashColumns.put("aply_to_yrwk", getAplyToYrwk());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("ra_cm", getRaCm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aply_fm_yrwk", "aplyFmYrwk");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ofc_lvl", "ofcLvl");
		this.hashFields.put("ofc_vw_cd", "ofcVwCd");
		this.hashFields.put("dur_wks", "durWks");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pa_cm_cost", "paCmCost");
		this.hashFields.put("vol_rto", "volRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pa_cm", "paCm");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ra_cm_cost", "raCmCost");
		this.hashFields.put("grs_rev", "grsRev");
		this.hashFields.put("grs_rto", "grsRto");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("lod_vol", "lodVol");
		this.hashFields.put("aply_to_yrwk", "aplyToYrwk");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("ra_cm", "raCm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aplyFmYrwk
	 */
	public String getAplyFmYrwk() {
		return this.aplyFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return ofcLvl
	 */
	public String getOfcLvl() {
		return this.ofcLvl;
	}
	
	/**
	 * Column Info
	 * @return ofcVwCd
	 */
	public String getOfcVwCd() {
		return this.ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @return durWks
	 */
	public String getDurWks() {
		return this.durWks;
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
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
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
	 * @return paCmCost
	 */
	public String getPaCmCost() {
		return this.paCmCost;
	}
	
	/**
	 * Column Info
	 * @return volRto
	 */
	public String getVolRto() {
		return this.volRto;
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
	 * @return paCm
	 */
	public String getPaCm() {
		return this.paCm;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return raCmCost
	 */
	public String getRaCmCost() {
		return this.raCmCost;
	}
	
	/**
	 * Column Info
	 * @return grsRev
	 */
	public String getGrsRev() {
		return this.grsRev;
	}
	
	/**
	 * Column Info
	 * @return grsRto
	 */
	public String getGrsRto() {
		return this.grsRto;
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
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
	}
	
	/**
	 * Column Info
	 * @return lodVol
	 */
	public String getLodVol() {
		return this.lodVol;
	}
	
	/**
	 * Column Info
	 * @return aplyToYrwk
	 */
	public String getAplyToYrwk() {
		return this.aplyToYrwk;
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
	 * @return raCm
	 */
	public String getRaCm() {
		return this.raCm;
	}
	

	/**
	 * Column Info
	 * @param aplyFmYrwk
	 */
	public void setAplyFmYrwk(String aplyFmYrwk) {
		this.aplyFmYrwk = aplyFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param ofcLvl
	 */
	public void setOfcLvl(String ofcLvl) {
		this.ofcLvl = ofcLvl;
	}
	
	/**
	 * Column Info
	 * @param ofcVwCd
	 */
	public void setOfcVwCd(String ofcVwCd) {
		this.ofcVwCd = ofcVwCd;
	}
	
	/**
	 * Column Info
	 * @param durWks
	 */
	public void setDurWks(String durWks) {
		this.durWks = durWks;
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
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
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
	 * @param paCmCost
	 */
	public void setPaCmCost(String paCmCost) {
		this.paCmCost = paCmCost;
	}
	
	/**
	 * Column Info
	 * @param volRto
	 */
	public void setVolRto(String volRto) {
		this.volRto = volRto;
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
	 * @param paCm
	 */
	public void setPaCm(String paCm) {
		this.paCm = paCm;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param raCmCost
	 */
	public void setRaCmCost(String raCmCost) {
		this.raCmCost = raCmCost;
	}
	
	/**
	 * Column Info
	 * @param grsRev
	 */
	public void setGrsRev(String grsRev) {
		this.grsRev = grsRev;
	}
	
	/**
	 * Column Info
	 * @param grsRto
	 */
	public void setGrsRto(String grsRto) {
		this.grsRto = grsRto;
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
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
	}
	
	/**
	 * Column Info
	 * @param lodVol
	 */
	public void setLodVol(String lodVol) {
		this.lodVol = lodVol;
	}
	
	/**
	 * Column Info
	 * @param aplyToYrwk
	 */
	public void setAplyToYrwk(String aplyToYrwk) {
		this.aplyToYrwk = aplyToYrwk;
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
	 * @param raCm
	 */
	public void setRaCm(String raCm) {
		this.raCm = raCm;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setAplyFmYrwk(JSPUtil.getParameter(request, prefix + "aply_fm_yrwk", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setOfcLvl(JSPUtil.getParameter(request, prefix + "ofc_lvl", ""));
		setOfcVwCd(JSPUtil.getParameter(request, prefix + "ofc_vw_cd", ""));
		setDurWks(JSPUtil.getParameter(request, prefix + "dur_wks", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, prefix + "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPaCmCost(JSPUtil.getParameter(request, prefix + "pa_cm_cost", ""));
		setVolRto(JSPUtil.getParameter(request, prefix + "vol_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPaCm(JSPUtil.getParameter(request, prefix + "pa_cm", ""));
		setBseQtrCd(JSPUtil.getParameter(request, prefix + "bse_qtr_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRaCmCost(JSPUtil.getParameter(request, prefix + "ra_cm_cost", ""));
		setGrsRev(JSPUtil.getParameter(request, prefix + "grs_rev", ""));
		setGrsRto(JSPUtil.getParameter(request, prefix + "grs_rto", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setLodVol(JSPUtil.getParameter(request, prefix + "lod_vol", ""));
		setAplyToYrwk(JSPUtil.getParameter(request, prefix + "aply_to_yrwk", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setRaCm(JSPUtil.getParameter(request, prefix + "ra_cm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBasicDataCreationListVO[]
	 */
	public SearchBasicDataCreationListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBasicDataCreationListVO[]
	 */
	public SearchBasicDataCreationListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBasicDataCreationListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aplyFmYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_fm_yrwk", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ofcLvl = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl", length));
			String[] ofcVwCd = (JSPUtil.getParameter(request, prefix	+ "ofc_vw_cd", length));
			String[] durWks = (JSPUtil.getParameter(request, prefix	+ "dur_wks", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] paCmCost = (JSPUtil.getParameter(request, prefix	+ "pa_cm_cost", length));
			String[] volRto = (JSPUtil.getParameter(request, prefix	+ "vol_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] paCm = (JSPUtil.getParameter(request, prefix	+ "pa_cm", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] raCmCost = (JSPUtil.getParameter(request, prefix	+ "ra_cm_cost", length));
			String[] grsRev = (JSPUtil.getParameter(request, prefix	+ "grs_rev", length));
			String[] grsRto = (JSPUtil.getParameter(request, prefix	+ "grs_rto", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] lodVol = (JSPUtil.getParameter(request, prefix	+ "lod_vol", length));
			String[] aplyToYrwk = (JSPUtil.getParameter(request, prefix	+ "aply_to_yrwk", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] raCm = (JSPUtil.getParameter(request, prefix	+ "ra_cm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBasicDataCreationListVO();
				if (aplyFmYrwk[i] != null)
					model.setAplyFmYrwk(aplyFmYrwk[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ofcLvl[i] != null)
					model.setOfcLvl(ofcLvl[i]);
				if (ofcVwCd[i] != null)
					model.setOfcVwCd(ofcVwCd[i]);
				if (durWks[i] != null)
					model.setDurWks(durWks[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (paCmCost[i] != null)
					model.setPaCmCost(paCmCost[i]);
				if (volRto[i] != null)
					model.setVolRto(volRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (paCm[i] != null)
					model.setPaCm(paCm[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (raCmCost[i] != null)
					model.setRaCmCost(raCmCost[i]);
				if (grsRev[i] != null)
					model.setGrsRev(grsRev[i]);
				if (grsRto[i] != null)
					model.setGrsRto(grsRto[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (lodVol[i] != null)
					model.setLodVol(lodVol[i]);
				if (aplyToYrwk[i] != null)
					model.setAplyToYrwk(aplyToYrwk[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (raCm[i] != null)
					model.setRaCm(raCm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBasicDataCreationListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBasicDataCreationListVO[]
	 */
	public SearchBasicDataCreationListVO[] getSearchBasicDataCreationListVOs(){
		SearchBasicDataCreationListVO[] vos = (SearchBasicDataCreationListVO[])models.toArray(new SearchBasicDataCreationListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.aplyFmYrwk = this.aplyFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvl = this.ofcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcVwCd = this.ofcVwCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durWks = this.durWks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCmCost = this.paCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volRto = this.volRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paCm = this.paCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCmCost = this.raCmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRev = this.grsRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRto = this.grsRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodVol = this.lodVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyToYrwk = this.aplyToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raCm = this.raCm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
