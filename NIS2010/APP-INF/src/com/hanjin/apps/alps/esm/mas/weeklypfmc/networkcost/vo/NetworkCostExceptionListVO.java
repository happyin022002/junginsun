/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostExceptionListVO.java
*@FileTitle : NetworkCostExceptionListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 유제량
*@LastVersion : 1.0
* 2015.05.06 유제량 
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
 * @author 유제량
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NetworkCostExceptionListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NetworkCostExceptionListVO> models = new ArrayList<NetworkCostExceptionListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String effToYrwk = null;
	/* Column Info */
	private String fYearweek = null;
	/* Column Info */
	private String select1 = null;
	/* Column Info */
	private String effFmYrwk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String fStndCostCd = null;
	/* Column Info */
	private String updUsrIdOrg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String stndCostCdOrg = null;
	/* Column Info */
	private String fStndCostNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effToYrwkOrg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vslCdOrg = null;
	/* Column Info */
	private String fSelcost = null;
	/* Column Info */
	private String effFmYrwkOrg = null;
	/* Column Info */
	private String creUsrIdOrg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public NetworkCostExceptionListVO() {}

	public NetworkCostExceptionListVO(String ibflag, String pagerows, String stndCostCd, String stndCostNm, String vslCd, String effFmYrwk, String effToYrwk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String fYearweek, String fSelcost, String select1, String stndCostCdOrg, String effFmYrwkOrg, String effToYrwkOrg, String vslCdOrg, String creUsrIdOrg, String updUsrIdOrg, String fStndCostCd, String fStndCostNm) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.effToYrwk = effToYrwk;
		this.fYearweek = fYearweek;
		this.select1 = select1;
		this.effFmYrwk = effFmYrwk;
		this.deltFlg = deltFlg;
		this.fStndCostCd = fStndCostCd;
		this.updUsrIdOrg = updUsrIdOrg;
		this.creDt = creDt;
		this.stndCostNm = stndCostNm;
		this.stndCostCdOrg = stndCostCdOrg;
		this.fStndCostNm = fStndCostNm;
		this.pagerows = pagerows;
		this.effToYrwkOrg = effToYrwkOrg;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.vslCdOrg = vslCdOrg;
		this.fSelcost = fSelcost;
		this.effFmYrwkOrg = effFmYrwkOrg;
		this.creUsrIdOrg = creUsrIdOrg;
		this.updUsrId = updUsrId;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eff_to_yrwk", getEffToYrwk());
		this.hashColumns.put("f_yearweek", getFYearweek());
		this.hashColumns.put("select1", getSelect1());
		this.hashColumns.put("eff_fm_yrwk", getEffFmYrwk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("f_stnd_cost_cd", getFStndCostCd());
		this.hashColumns.put("upd_usr_id_org", getUpdUsrIdOrg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("stnd_cost_cd_org", getStndCostCdOrg());
		this.hashColumns.put("f_stnd_cost_nm", getFStndCostNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_to_yrwk_org", getEffToYrwkOrg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vsl_cd_org", getVslCdOrg());
		this.hashColumns.put("f_selcost", getFSelcost());
		this.hashColumns.put("eff_fm_yrwk_org", getEffFmYrwkOrg());
		this.hashColumns.put("cre_usr_id_org", getCreUsrIdOrg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eff_to_yrwk", "effToYrwk");
		this.hashFields.put("f_yearweek", "fYearweek");
		this.hashFields.put("select1", "select1");
		this.hashFields.put("eff_fm_yrwk", "effFmYrwk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("f_stnd_cost_cd", "fStndCostCd");
		this.hashFields.put("upd_usr_id_org", "updUsrIdOrg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("stnd_cost_cd_org", "stndCostCdOrg");
		this.hashFields.put("f_stnd_cost_nm", "fStndCostNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_to_yrwk_org", "effToYrwkOrg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vsl_cd_org", "vslCdOrg");
		this.hashFields.put("f_selcost", "fSelcost");
		this.hashFields.put("eff_fm_yrwk_org", "effFmYrwkOrg");
		this.hashFields.put("cre_usr_id_org", "creUsrIdOrg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return effToYrwk
	 */
	public String getEffToYrwk() {
		return this.effToYrwk;
	}
	
	/**
	 * Column Info
	 * @return fYearweek
	 */
	public String getFYearweek() {
		return this.fYearweek;
	}
	
	/**
	 * Column Info
	 * @return select1
	 */
	public String getSelect1() {
		return this.select1;
	}
	
	/**
	 * Column Info
	 * @return effFmYrwk
	 */
	public String getEffFmYrwk() {
		return this.effFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return fStndCostCd
	 */
	public String getFStndCostCd() {
		return this.fStndCostCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrIdOrg
	 */
	public String getUpdUsrIdOrg() {
		return this.updUsrIdOrg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return stndCostCdOrg
	 */
	public String getStndCostCdOrg() {
		return this.stndCostCdOrg;
	}
	
	/**
	 * Column Info
	 * @return fStndCostNm
	 */
	public String getFStndCostNm() {
		return this.fStndCostNm;
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
	 * @return effToYrwkOrg
	 */
	public String getEffToYrwkOrg() {
		return this.effToYrwkOrg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return vslCdOrg
	 */
	public String getVslCdOrg() {
		return this.vslCdOrg;
	}
	
	/**
	 * Column Info
	 * @return fSelcost
	 */
	public String getFSelcost() {
		return this.fSelcost;
	}
	
	/**
	 * Column Info
	 * @return effFmYrwkOrg
	 */
	public String getEffFmYrwkOrg() {
		return this.effFmYrwkOrg;
	}
	
	/**
	 * Column Info
	 * @return creUsrIdOrg
	 */
	public String getCreUsrIdOrg() {
		return this.creUsrIdOrg;
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
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param effToYrwk
	 */
	public void setEffToYrwk(String effToYrwk) {
		this.effToYrwk = effToYrwk;
	}
	
	/**
	 * Column Info
	 * @param fYearweek
	 */
	public void setFYearweek(String fYearweek) {
		this.fYearweek = fYearweek;
	}
	
	/**
	 * Column Info
	 * @param select1
	 */
	public void setSelect1(String select1) {
		this.select1 = select1;
	}
	
	/**
	 * Column Info
	 * @param effFmYrwk
	 */
	public void setEffFmYrwk(String effFmYrwk) {
		this.effFmYrwk = effFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param fStndCostCd
	 */
	public void setFStndCostCd(String fStndCostCd) {
		this.fStndCostCd = fStndCostCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrIdOrg
	 */
	public void setUpdUsrIdOrg(String updUsrIdOrg) {
		this.updUsrIdOrg = updUsrIdOrg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param stndCostCdOrg
	 */
	public void setStndCostCdOrg(String stndCostCdOrg) {
		this.stndCostCdOrg = stndCostCdOrg;
	}
	
	/**
	 * Column Info
	 * @param fStndCostNm
	 */
	public void setFStndCostNm(String fStndCostNm) {
		this.fStndCostNm = fStndCostNm;
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
	 * @param effToYrwkOrg
	 */
	public void setEffToYrwkOrg(String effToYrwkOrg) {
		this.effToYrwkOrg = effToYrwkOrg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param vslCdOrg
	 */
	public void setVslCdOrg(String vslCdOrg) {
		this.vslCdOrg = vslCdOrg;
	}
	
	/**
	 * Column Info
	 * @param fSelcost
	 */
	public void setFSelcost(String fSelcost) {
		this.fSelcost = fSelcost;
	}
	
	/**
	 * Column Info
	 * @param effFmYrwkOrg
	 */
	public void setEffFmYrwkOrg(String effFmYrwkOrg) {
		this.effFmYrwkOrg = effFmYrwkOrg;
	}
	
	/**
	 * Column Info
	 * @param creUsrIdOrg
	 */
	public void setCreUsrIdOrg(String creUsrIdOrg) {
		this.creUsrIdOrg = creUsrIdOrg;
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
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEffToYrwk(JSPUtil.getParameter(request, prefix + "eff_to_yrwk", ""));
		setFYearweek(JSPUtil.getParameter(request, prefix + "f_yearweek", ""));
		setSelect1(JSPUtil.getParameter(request, prefix + "select1", ""));
		setEffFmYrwk(JSPUtil.getParameter(request, prefix + "eff_fm_yrwk", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setFStndCostCd(JSPUtil.getParameter(request, prefix + "f_stnd_cost_cd", ""));
		setUpdUsrIdOrg(JSPUtil.getParameter(request, prefix + "upd_usr_id_org", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setStndCostCdOrg(JSPUtil.getParameter(request, prefix + "stnd_cost_cd_org", ""));
		setFStndCostNm(JSPUtil.getParameter(request, prefix + "f_stnd_cost_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffToYrwkOrg(JSPUtil.getParameter(request, prefix + "eff_to_yrwk_org", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVslCdOrg(JSPUtil.getParameter(request, prefix + "vsl_cd_org", ""));
		setFSelcost(JSPUtil.getParameter(request, prefix + "f_selcost", ""));
		setEffFmYrwkOrg(JSPUtil.getParameter(request, prefix + "eff_fm_yrwk_org", ""));
		setCreUsrIdOrg(JSPUtil.getParameter(request, prefix + "cre_usr_id_org", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NetworkCostExceptionListVO[]
	 */
	public NetworkCostExceptionListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NetworkCostExceptionListVO[]
	 */
	public NetworkCostExceptionListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NetworkCostExceptionListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] effToYrwk = (JSPUtil.getParameter(request, prefix	+ "eff_to_yrwk", length));
			String[] fYearweek = (JSPUtil.getParameter(request, prefix	+ "f_yearweek", length));
			String[] select1 = (JSPUtil.getParameter(request, prefix	+ "select1", length));
			String[] effFmYrwk = (JSPUtil.getParameter(request, prefix	+ "eff_fm_yrwk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] fStndCostCd = (JSPUtil.getParameter(request, prefix	+ "f_stnd_cost_cd", length));
			String[] updUsrIdOrg = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id_org", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] stndCostCdOrg = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd_org", length));
			String[] fStndCostNm = (JSPUtil.getParameter(request, prefix	+ "f_stnd_cost_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effToYrwkOrg = (JSPUtil.getParameter(request, prefix	+ "eff_to_yrwk_org", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vslCdOrg = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_org", length));
			String[] fSelcost = (JSPUtil.getParameter(request, prefix	+ "f_selcost", length));
			String[] effFmYrwkOrg = (JSPUtil.getParameter(request, prefix	+ "eff_fm_yrwk_org", length));
			String[] creUsrIdOrg = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id_org", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NetworkCostExceptionListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (effToYrwk[i] != null)
					model.setEffToYrwk(effToYrwk[i]);
				if (fYearweek[i] != null)
					model.setFYearweek(fYearweek[i]);
				if (select1[i] != null)
					model.setSelect1(select1[i]);
				if (effFmYrwk[i] != null)
					model.setEffFmYrwk(effFmYrwk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (fStndCostCd[i] != null)
					model.setFStndCostCd(fStndCostCd[i]);
				if (updUsrIdOrg[i] != null)
					model.setUpdUsrIdOrg(updUsrIdOrg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (stndCostCdOrg[i] != null)
					model.setStndCostCdOrg(stndCostCdOrg[i]);
				if (fStndCostNm[i] != null)
					model.setFStndCostNm(fStndCostNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effToYrwkOrg[i] != null)
					model.setEffToYrwkOrg(effToYrwkOrg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vslCdOrg[i] != null)
					model.setVslCdOrg(vslCdOrg[i]);
				if (fSelcost[i] != null)
					model.setFSelcost(fSelcost[i]);
				if (effFmYrwkOrg[i] != null)
					model.setEffFmYrwkOrg(effFmYrwkOrg[i]);
				if (creUsrIdOrg[i] != null)
					model.setCreUsrIdOrg(creUsrIdOrg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNetworkCostExceptionListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NetworkCostExceptionListVO[]
	 */
	public NetworkCostExceptionListVO[] getNetworkCostExceptionListVOs(){
		NetworkCostExceptionListVO[] vos = (NetworkCostExceptionListVO[])models.toArray(new NetworkCostExceptionListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToYrwk = this.effToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fYearweek = this.fYearweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.select1 = this.select1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmYrwk = this.effFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStndCostCd = this.fStndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrIdOrg = this.updUsrIdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCdOrg = this.stndCostCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStndCostNm = this.fStndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToYrwkOrg = this.effToYrwkOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdOrg = this.vslCdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSelcost = this.fSelcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmYrwkOrg = this.effFmYrwkOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrIdOrg = this.creUsrIdOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
