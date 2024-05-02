/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchSpaceAllocation0033LaneRgstVO.java
*@FileTitle : SearchSpaceAllocation0033LaneRgstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocation0033LaneRgstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocation0033LaneRgstVO> models = new ArrayList<SearchSpaceAllocation0033LaneRgstVO>();
	
	/* Column Info */
	private String alocHcOvrCalcQty = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fSubTrade = null;
	/* Column Info */
	private String aloc45ftBzcBxQty = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String aloc45ftOvrCalcQty = null;
	/* Column Info */
	private String alocHcCalcQty = null;
	/* Column Info */
	private String fBound = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String aloc45ftCalcQty = null;
	/* Column Info */
	private String aloc45ftAplyFlg = null;
	/* Column Info */
	private String alocHcAplyFlg = null;
	/* Column Info */
	private String fLane = null;
	/* Column Info */
	private String fTrade = null;
	/* Column Info */
	private String alocHcBzcBxQty = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceAllocation0033LaneRgstVO() {}

	public SearchSpaceAllocation0033LaneRgstVO(String ibflag, String pagerows, String repTrdCd, String subTrdCd, String rlaneCd, String dirCd, String vvd, String effFmDt, String effToDt, String bsaCapa, String polCd, String alocHcCalcQty, String alocHcBzcBxQty, String alocHcAplyFlg, String alocHcOvrCalcQty, String aloc45ftCalcQty, String aloc45ftBzcBxQty, String aloc45ftAplyFlg, String aloc45ftOvrCalcQty, String fTrade, String fSubTrade, String fLane, String fBound, String usrId, String code, String name) {
		this.alocHcOvrCalcQty = alocHcOvrCalcQty;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.fSubTrade = fSubTrade;
		this.aloc45ftBzcBxQty = aloc45ftBzcBxQty;
		this.usrId = usrId;
		this.name = name;
		this.effFmDt = effFmDt;
		this.dirCd = dirCd;
		this.aloc45ftOvrCalcQty = aloc45ftOvrCalcQty;
		this.alocHcCalcQty = alocHcCalcQty;
		this.fBound = fBound;
		this.code = code;
		this.bsaCapa = bsaCapa;
		this.vvd = vvd;
		this.aloc45ftCalcQty = aloc45ftCalcQty;
		this.aloc45ftAplyFlg = aloc45ftAplyFlg;
		this.alocHcAplyFlg = alocHcAplyFlg;
		this.fLane = fLane;
		this.fTrade = fTrade;
		this.alocHcBzcBxQty = alocHcBzcBxQty;
		this.effToDt = effToDt;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aloc_hc_ovr_calc_qty", getAlocHcOvrCalcQty());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_sub_trade", getFSubTrade());
		this.hashColumns.put("aloc_45ft_bzc_bx_qty", getAloc45ftBzcBxQty());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("aloc_45ft_ovr_calc_qty", getAloc45ftOvrCalcQty());
		this.hashColumns.put("aloc_hc_calc_qty", getAlocHcCalcQty());
		this.hashColumns.put("f_bound", getFBound());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("aloc_45ft_calc_qty", getAloc45ftCalcQty());
		this.hashColumns.put("aloc_45ft_aply_flg", getAloc45ftAplyFlg());
		this.hashColumns.put("aloc_hc_aply_flg", getAlocHcAplyFlg());
		this.hashColumns.put("f_lane", getFLane());
		this.hashColumns.put("f_trade", getFTrade());
		this.hashColumns.put("aloc_hc_bzc_bx_qty", getAlocHcBzcBxQty());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aloc_hc_ovr_calc_qty", "alocHcOvrCalcQty");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_sub_trade", "fSubTrade");
		this.hashFields.put("aloc_45ft_bzc_bx_qty", "aloc45ftBzcBxQty");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("name", "name");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("aloc_45ft_ovr_calc_qty", "aloc45ftOvrCalcQty");
		this.hashFields.put("aloc_hc_calc_qty", "alocHcCalcQty");
		this.hashFields.put("f_bound", "fBound");
		this.hashFields.put("code", "code");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("aloc_45ft_calc_qty", "aloc45ftCalcQty");
		this.hashFields.put("aloc_45ft_aply_flg", "aloc45ftAplyFlg");
		this.hashFields.put("aloc_hc_aply_flg", "alocHcAplyFlg");
		this.hashFields.put("f_lane", "fLane");
		this.hashFields.put("f_trade", "fTrade");
		this.hashFields.put("aloc_hc_bzc_bx_qty", "alocHcBzcBxQty");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return alocHcOvrCalcQty
	 */
	public String getAlocHcOvrCalcQty() {
		return this.alocHcOvrCalcQty;
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
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return fSubTrade
	 */
	public String getFSubTrade() {
		return this.fSubTrade;
	}
	
	/**
	 * Column Info
	 * @return aloc45ftBzcBxQty
	 */
	public String getAloc45ftBzcBxQty() {
		return this.aloc45ftBzcBxQty;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
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
	 * @return aloc45ftOvrCalcQty
	 */
	public String getAloc45ftOvrCalcQty() {
		return this.aloc45ftOvrCalcQty;
	}
	
	/**
	 * Column Info
	 * @return alocHcCalcQty
	 */
	public String getAlocHcCalcQty() {
		return this.alocHcCalcQty;
	}
	
	/**
	 * Column Info
	 * @return fBound
	 */
	public String getFBound() {
		return this.fBound;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return aloc45ftCalcQty
	 */
	public String getAloc45ftCalcQty() {
		return this.aloc45ftCalcQty;
	}
	
	/**
	 * Column Info
	 * @return aloc45ftAplyFlg
	 */
	public String getAloc45ftAplyFlg() {
		return this.aloc45ftAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return alocHcAplyFlg
	 */
	public String getAlocHcAplyFlg() {
		return this.alocHcAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return fLane
	 */
	public String getFLane() {
		return this.fLane;
	}
	
	/**
	 * Column Info
	 * @return fTrade
	 */
	public String getFTrade() {
		return this.fTrade;
	}
	
	/**
	 * Column Info
	 * @return alocHcBzcBxQty
	 */
	public String getAlocHcBzcBxQty() {
		return this.alocHcBzcBxQty;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
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
	 * @param alocHcOvrCalcQty
	 */
	public void setAlocHcOvrCalcQty(String alocHcOvrCalcQty) {
		this.alocHcOvrCalcQty = alocHcOvrCalcQty;
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
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param fSubTrade
	 */
	public void setFSubTrade(String fSubTrade) {
		this.fSubTrade = fSubTrade;
	}
	
	/**
	 * Column Info
	 * @param aloc45ftBzcBxQty
	 */
	public void setAloc45ftBzcBxQty(String aloc45ftBzcBxQty) {
		this.aloc45ftBzcBxQty = aloc45ftBzcBxQty;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
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
	 * @param aloc45ftOvrCalcQty
	 */
	public void setAloc45ftOvrCalcQty(String aloc45ftOvrCalcQty) {
		this.aloc45ftOvrCalcQty = aloc45ftOvrCalcQty;
	}
	
	/**
	 * Column Info
	 * @param alocHcCalcQty
	 */
	public void setAlocHcCalcQty(String alocHcCalcQty) {
		this.alocHcCalcQty = alocHcCalcQty;
	}
	
	/**
	 * Column Info
	 * @param fBound
	 */
	public void setFBound(String fBound) {
		this.fBound = fBound;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param aloc45ftCalcQty
	 */
	public void setAloc45ftCalcQty(String aloc45ftCalcQty) {
		this.aloc45ftCalcQty = aloc45ftCalcQty;
	}
	
	/**
	 * Column Info
	 * @param aloc45ftAplyFlg
	 */
	public void setAloc45ftAplyFlg(String aloc45ftAplyFlg) {
		this.aloc45ftAplyFlg = aloc45ftAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param alocHcAplyFlg
	 */
	public void setAlocHcAplyFlg(String alocHcAplyFlg) {
		this.alocHcAplyFlg = alocHcAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param fLane
	 */
	public void setFLane(String fLane) {
		this.fLane = fLane;
	}
	
	/**
	 * Column Info
	 * @param fTrade
	 */
	public void setFTrade(String fTrade) {
		this.fTrade = fTrade;
	}
	
	/**
	 * Column Info
	 * @param alocHcBzcBxQty
	 */
	public void setAlocHcBzcBxQty(String alocHcBzcBxQty) {
		this.alocHcBzcBxQty = alocHcBzcBxQty;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setAlocHcOvrCalcQty(JSPUtil.getParameter(request, prefix + "aloc_hc_ovr_calc_qty", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, prefix + "rep_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFSubTrade(JSPUtil.getParameter(request, prefix + "f_sub_trade", ""));
		setAloc45ftBzcBxQty(JSPUtil.getParameter(request, prefix + "aloc_45ft_bzc_bx_qty", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setAloc45ftOvrCalcQty(JSPUtil.getParameter(request, prefix + "aloc_45ft_ovr_calc_qty", ""));
		setAlocHcCalcQty(JSPUtil.getParameter(request, prefix + "aloc_hc_calc_qty", ""));
		setFBound(JSPUtil.getParameter(request, prefix + "f_bound", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setBsaCapa(JSPUtil.getParameter(request, prefix + "bsa_capa", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setAloc45ftCalcQty(JSPUtil.getParameter(request, prefix + "aloc_45ft_calc_qty", ""));
		setAloc45ftAplyFlg(JSPUtil.getParameter(request, prefix + "aloc_45ft_aply_flg", ""));
		setAlocHcAplyFlg(JSPUtil.getParameter(request, prefix + "aloc_hc_aply_flg", ""));
		setFLane(JSPUtil.getParameter(request, prefix + "f_lane", ""));
		setFTrade(JSPUtil.getParameter(request, prefix + "f_trade", ""));
		setAlocHcBzcBxQty(JSPUtil.getParameter(request, prefix + "aloc_hc_bzc_bx_qty", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocation0033LaneRgstVO[]
	 */
	public SearchSpaceAllocation0033LaneRgstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocation0033LaneRgstVO[]
	 */
	public SearchSpaceAllocation0033LaneRgstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocation0033LaneRgstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] alocHcOvrCalcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_hc_ovr_calc_qty", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fSubTrade = (JSPUtil.getParameter(request, prefix	+ "f_sub_trade", length));
			String[] aloc45ftBzcBxQty = (JSPUtil.getParameter(request, prefix	+ "aloc_45ft_bzc_bx_qty", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] aloc45ftOvrCalcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_45ft_ovr_calc_qty", length));
			String[] alocHcCalcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_hc_calc_qty", length));
			String[] fBound = (JSPUtil.getParameter(request, prefix	+ "f_bound", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] aloc45ftCalcQty = (JSPUtil.getParameter(request, prefix	+ "aloc_45ft_calc_qty", length));
			String[] aloc45ftAplyFlg = (JSPUtil.getParameter(request, prefix	+ "aloc_45ft_aply_flg", length));
			String[] alocHcAplyFlg = (JSPUtil.getParameter(request, prefix	+ "aloc_hc_aply_flg", length));
			String[] fLane = (JSPUtil.getParameter(request, prefix	+ "f_lane", length));
			String[] fTrade = (JSPUtil.getParameter(request, prefix	+ "f_trade", length));
			String[] alocHcBzcBxQty = (JSPUtil.getParameter(request, prefix	+ "aloc_hc_bzc_bx_qty", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocation0033LaneRgstVO();
				if (alocHcOvrCalcQty[i] != null)
					model.setAlocHcOvrCalcQty(alocHcOvrCalcQty[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fSubTrade[i] != null)
					model.setFSubTrade(fSubTrade[i]);
				if (aloc45ftBzcBxQty[i] != null)
					model.setAloc45ftBzcBxQty(aloc45ftBzcBxQty[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (aloc45ftOvrCalcQty[i] != null)
					model.setAloc45ftOvrCalcQty(aloc45ftOvrCalcQty[i]);
				if (alocHcCalcQty[i] != null)
					model.setAlocHcCalcQty(alocHcCalcQty[i]);
				if (fBound[i] != null)
					model.setFBound(fBound[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (aloc45ftCalcQty[i] != null)
					model.setAloc45ftCalcQty(aloc45ftCalcQty[i]);
				if (aloc45ftAplyFlg[i] != null)
					model.setAloc45ftAplyFlg(aloc45ftAplyFlg[i]);
				if (alocHcAplyFlg[i] != null)
					model.setAlocHcAplyFlg(alocHcAplyFlg[i]);
				if (fLane[i] != null)
					model.setFLane(fLane[i]);
				if (fTrade[i] != null)
					model.setFTrade(fTrade[i]);
				if (alocHcBzcBxQty[i] != null)
					model.setAlocHcBzcBxQty(alocHcBzcBxQty[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocation0033LaneRgstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocation0033LaneRgstVO[]
	 */
	public SearchSpaceAllocation0033LaneRgstVO[] getSearchSpaceAllocation0033LaneRgstVOs(){
		SearchSpaceAllocation0033LaneRgstVO[] vos = (SearchSpaceAllocation0033LaneRgstVO[])models.toArray(new SearchSpaceAllocation0033LaneRgstVO[models.size()]);
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
		this.alocHcOvrCalcQty = this.alocHcOvrCalcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSubTrade = this.fSubTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc45ftBzcBxQty = this.aloc45ftBzcBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc45ftOvrCalcQty = this.aloc45ftOvrCalcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocHcCalcQty = this.alocHcCalcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBound = this.fBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc45ftCalcQty = this.aloc45ftCalcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aloc45ftAplyFlg = this.aloc45ftAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocHcAplyFlg = this.alocHcAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLane = this.fLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrade = this.fTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocHcBzcBxQty = this.alocHcBzcBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
