/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BunkerTariffCostVO.java
*@FileTitle : BunkerTariffCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.14 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BunkerTariffCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BunkerTariffCostVO> models = new ArrayList<BunkerTariffCostVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String oldFoilUcAmt = null;
	/* Column Info */
	private String trdCdGp = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String wkAvgUcAmt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String foilUcAmt = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String wkEstmUcAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BunkerTariffCostVO() {}

	public BunkerTariffCostVO(String ibflag, String pagerows, String costYrmon, String costWk, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String hulBndCd, String vslCd, String vslClssCapa, String oldFoilUcAmt, String foilUcAmt, String wkAvgUcAmt, String wkEstmUcAmt, String trdCdGp, String lvl, String updUsrId) {
		this.vslCd = vslCd;
		this.oldFoilUcAmt = oldFoilUcAmt;
		this.trdCdGp = trdCdGp;
		this.hulBndCd = hulBndCd;
		this.wkAvgUcAmt = wkAvgUcAmt;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.lvl = lvl;
		this.costYrmon = costYrmon;
		this.foilUcAmt = foilUcAmt;
		this.costWk = costWk;
		this.dirCd = dirCd;
		this.vslClssCapa = vslClssCapa;
		this.wkEstmUcAmt = wkEstmUcAmt;
		this.updUsrId = updUsrId;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("old_foil_uc_amt", getOldFoilUcAmt());
		this.hashColumns.put("trd_cd_gp", getTrdCdGp());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("wk_avg_uc_amt", getWkAvgUcAmt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("foil_uc_amt", getFoilUcAmt());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("wk_estm_uc_amt", getWkEstmUcAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("old_foil_uc_amt", "oldFoilUcAmt");
		this.hashFields.put("trd_cd_gp", "trdCdGp");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("wk_avg_uc_amt", "wkAvgUcAmt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("foil_uc_amt", "foilUcAmt");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("wk_estm_uc_amt", "wkEstmUcAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
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
	 * @return oldFoilUcAmt
	 */
	public String getOldFoilUcAmt() {
		return this.oldFoilUcAmt;
	}
	
	/**
	 * Column Info
	 * @return trdCdGp
	 */
	public String getTrdCdGp() {
		return this.trdCdGp;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return wkAvgUcAmt
	 */
	public String getWkAvgUcAmt() {
		return this.wkAvgUcAmt;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return foilUcAmt
	 */
	public String getFoilUcAmt() {
		return this.foilUcAmt;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return wkEstmUcAmt
	 */
	public String getWkEstmUcAmt() {
		return this.wkEstmUcAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param oldFoilUcAmt
	 */
	public void setOldFoilUcAmt(String oldFoilUcAmt) {
		this.oldFoilUcAmt = oldFoilUcAmt;
	}
	
	/**
	 * Column Info
	 * @param trdCdGp
	 */
	public void setTrdCdGp(String trdCdGp) {
		this.trdCdGp = trdCdGp;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param wkAvgUcAmt
	 */
	public void setWkAvgUcAmt(String wkAvgUcAmt) {
		this.wkAvgUcAmt = wkAvgUcAmt;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param foilUcAmt
	 */
	public void setFoilUcAmt(String foilUcAmt) {
		this.foilUcAmt = foilUcAmt;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param wkEstmUcAmt
	 */
	public void setWkEstmUcAmt(String wkEstmUcAmt) {
		this.wkEstmUcAmt = wkEstmUcAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setOldFoilUcAmt(JSPUtil.getParameter(request, prefix + "old_foil_uc_amt", ""));
		setTrdCdGp(JSPUtil.getParameter(request, prefix + "trd_cd_gp", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setWkAvgUcAmt(JSPUtil.getParameter(request, prefix + "wk_avg_uc_amt", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFoilUcAmt(JSPUtil.getParameter(request, prefix + "foil_uc_amt", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setWkEstmUcAmt(JSPUtil.getParameter(request, prefix + "wk_estm_uc_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BunkerTariffCostVO[]
	 */
	public BunkerTariffCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BunkerTariffCostVO[]
	 */
	public BunkerTariffCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BunkerTariffCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] oldFoilUcAmt = (JSPUtil.getParameter(request, prefix	+ "old_foil_uc_amt", length));
			String[] trdCdGp = (JSPUtil.getParameter(request, prefix	+ "trd_cd_gp", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] wkAvgUcAmt = (JSPUtil.getParameter(request, prefix	+ "wk_avg_uc_amt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] foilUcAmt = (JSPUtil.getParameter(request, prefix	+ "foil_uc_amt", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] wkEstmUcAmt = (JSPUtil.getParameter(request, prefix	+ "wk_estm_uc_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BunkerTariffCostVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (oldFoilUcAmt[i] != null)
					model.setOldFoilUcAmt(oldFoilUcAmt[i]);
				if (trdCdGp[i] != null)
					model.setTrdCdGp(trdCdGp[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (wkAvgUcAmt[i] != null)
					model.setWkAvgUcAmt(wkAvgUcAmt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (foilUcAmt[i] != null)
					model.setFoilUcAmt(foilUcAmt[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (wkEstmUcAmt[i] != null)
					model.setWkEstmUcAmt(wkEstmUcAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBunkerTariffCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BunkerTariffCostVO[]
	 */
	public BunkerTariffCostVO[] getBunkerTariffCostVOs(){
		BunkerTariffCostVO[] vos = (BunkerTariffCostVO[])models.toArray(new BunkerTariffCostVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldFoilUcAmt = this.oldFoilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCdGp = this.trdCdGp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkAvgUcAmt = this.wkAvgUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilUcAmt = this.foilUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkEstmUcAmt = this.wkEstmUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
