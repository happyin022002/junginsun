/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MGSInventoryGeneralINVO.java
*@FileTitle : MGSInventoryGeneralINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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

public class MGSInventoryGeneralINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSInventoryGeneralINVO> models = new ArrayList<MGSInventoryGeneralINVO>();
	
	/* Column Info */
	private String atchBare = null;
	/* Column Info */
	private String eqTpszCdUmg = null;
	/* Column Info */
	private String location = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String dispCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmgSnd = null;
	/* Column Info */
	private String eqTpszCdClg = null;
	/* Column Info */
	private String eqTpszCdTotal = null;
	/* Column Info */
	private String agmtCd = null;
	/* Column Info */
	private String crntLocCd = null;
	/* Column Info */
	private String group1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSInventoryGeneralINVO() {}

	public MGSInventoryGeneralINVO(String ibflag, String pagerows, String atchBare, String eqTpszCdUmg, String location, String crntYdCd, String agmtLstmCd, String eqKndCd, String aciacDivCd, String eqTpszCd, String dmgSnd, String eqTpszCdClg, String eqTpszCdTotal, String agmtCd, String crntLocCd, String group1, String dispCd) {
		this.atchBare = atchBare;
		this.eqTpszCdUmg = eqTpszCdUmg;
		this.location = location;
		this.crntYdCd = crntYdCd;
		this.agmtLstmCd = agmtLstmCd;
		this.dispCd = dispCd;
		this.eqKndCd = eqKndCd;
		this.aciacDivCd = aciacDivCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.ibflag = ibflag;
		this.dmgSnd = dmgSnd;
		this.eqTpszCdClg = eqTpszCdClg;
		this.eqTpszCdTotal = eqTpszCdTotal;
		this.agmtCd = agmtCd;
		this.crntLocCd = crntLocCd;
		this.group1 = group1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("atch_bare", getAtchBare());
		this.hashColumns.put("eq_tpsz_cd_umg", getEqTpszCdUmg());
		this.hashColumns.put("location", getLocation());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("disp_cd", getDispCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmg_snd", getDmgSnd());
		this.hashColumns.put("eq_tpsz_cd_clg", getEqTpszCdClg());
		this.hashColumns.put("eq_tpsz_cd_total", getEqTpszCdTotal());
		this.hashColumns.put("agmt_cd", getAgmtCd());
		this.hashColumns.put("crnt_loc_cd", getCrntLocCd());
		this.hashColumns.put("group1", getGroup1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("atch_bare", "atchBare");
		this.hashFields.put("eq_tpsz_cd_umg", "eqTpszCdUmg");
		this.hashFields.put("location", "location");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("disp_cd", "dispCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmg_snd", "dmgSnd");
		this.hashFields.put("eq_tpsz_cd_clg", "eqTpszCdClg");
		this.hashFields.put("eq_tpsz_cd_total", "eqTpszCdTotal");
		this.hashFields.put("agmt_cd", "agmtCd");
		this.hashFields.put("crnt_loc_cd", "crntLocCd");
		this.hashFields.put("group1", "group1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return atchBare
	 */
	public String getAtchBare() {
		return this.atchBare;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdUmg
	 */
	public String getEqTpszCdUmg() {
		return this.eqTpszCdUmg;
	}
	
	/**
	 * Column Info
	 * @return location
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return dispCd
	 */
	public String getDispCd() {
		return this.dispCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @return dmgSnd
	 */
	public String getDmgSnd() {
		return this.dmgSnd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdClg
	 */
	public String getEqTpszCdClg() {
		return this.eqTpszCdClg;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdTotal
	 */
	public String getEqTpszCdTotal() {
		return this.eqTpszCdTotal;
	}
	
	/**
	 * Column Info
	 * @return agmtCd
	 */
	public String getAgmtCd() {
		return this.agmtCd;
	}
	
	/**
	 * Column Info
	 * @return crntLocCd
	 */
	public String getCrntLocCd() {
		return this.crntLocCd;
	}
	
	/**
	 * Column Info
	 * @return group1
	 */
	public String getGroup1() {
		return this.group1;
	}
	

	/**
	 * Column Info
	 * @param atchBare
	 */
	public void setAtchBare(String atchBare) {
		this.atchBare = atchBare;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdUmg
	 */
	public void setEqTpszCdUmg(String eqTpszCdUmg) {
		this.eqTpszCdUmg = eqTpszCdUmg;
	}
	
	/**
	 * Column Info
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param dispCd
	 */
	public void setDispCd(String dispCd) {
		this.dispCd = dispCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
	 * @param dmgSnd
	 */
	public void setDmgSnd(String dmgSnd) {
		this.dmgSnd = dmgSnd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdClg
	 */
	public void setEqTpszCdClg(String eqTpszCdClg) {
		this.eqTpszCdClg = eqTpszCdClg;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdTotal
	 */
	public void setEqTpszCdTotal(String eqTpszCdTotal) {
		this.eqTpszCdTotal = eqTpszCdTotal;
	}
	
	/**
	 * Column Info
	 * @param agmtCd
	 */
	public void setAgmtCd(String agmtCd) {
		this.agmtCd = agmtCd;
	}
	
	/**
	 * Column Info
	 * @param crntLocCd
	 */
	public void setCrntLocCd(String crntLocCd) {
		this.crntLocCd = crntLocCd;
	}
	
	/**
	 * Column Info
	 * @param group1
	 */
	public void setGroup1(String group1) {
		this.group1 = group1;
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
		setAtchBare(JSPUtil.getParameter(request, prefix + "atch_bare", ""));
		setEqTpszCdUmg(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd_umg", ""));
		setLocation(JSPUtil.getParameter(request, prefix + "location", ""));
		setCrntYdCd(JSPUtil.getParameter(request, prefix + "crnt_yd_cd", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, prefix + "agmt_lstm_cd", ""));
		setDispCd(JSPUtil.getParameter(request, prefix + "disp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, prefix + "aciac_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDmgSnd(JSPUtil.getParameter(request, prefix + "dmg_snd", ""));
		setEqTpszCdClg(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd_clg", ""));
		setEqTpszCdTotal(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd_total", ""));
		setAgmtCd(JSPUtil.getParameter(request, prefix + "agmt_cd", ""));
		setCrntLocCd(JSPUtil.getParameter(request, prefix + "crnt_loc_cd", ""));
		setGroup1(JSPUtil.getParameter(request, prefix + "group1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSInventoryGeneralINVO[]
	 */
	public MGSInventoryGeneralINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSInventoryGeneralINVO[]
	 */
	public MGSInventoryGeneralINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSInventoryGeneralINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] atchBare = (JSPUtil.getParameter(request, prefix	+ "atch_bare", length));
			String[] eqTpszCdUmg = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_umg", length));
			String[] location = (JSPUtil.getParameter(request, prefix	+ "location", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] dispCd = (JSPUtil.getParameter(request, prefix	+ "disp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmgSnd = (JSPUtil.getParameter(request, prefix	+ "dmg_snd", length));
			String[] eqTpszCdClg = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_clg", length));
			String[] eqTpszCdTotal = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_total", length));
			String[] agmtCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cd", length));
			String[] crntLocCd = (JSPUtil.getParameter(request, prefix	+ "crnt_loc_cd", length));
			String[] group1 = (JSPUtil.getParameter(request, prefix	+ "group1", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSInventoryGeneralINVO();
				if (atchBare[i] != null)
					model.setAtchBare(atchBare[i]);
				if (eqTpszCdUmg[i] != null)
					model.setEqTpszCdUmg(eqTpszCdUmg[i]);
				if (location[i] != null)
					model.setLocation(location[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (dispCd[i] != null)
					model.setDispCd(dispCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmgSnd[i] != null)
					model.setDmgSnd(dmgSnd[i]);
				if (eqTpszCdClg[i] != null)
					model.setEqTpszCdClg(eqTpszCdClg[i]);
				if (eqTpszCdTotal[i] != null)
					model.setEqTpszCdTotal(eqTpszCdTotal[i]);
				if (agmtCd[i] != null)
					model.setAgmtCd(agmtCd[i]);
				if (crntLocCd[i] != null)
					model.setCrntLocCd(crntLocCd[i]);
				if (group1[i] != null)
					model.setGroup1(group1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSInventoryGeneralINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSInventoryGeneralINVO[]
	 */
	public MGSInventoryGeneralINVO[] getMGSInventoryGeneralINVOs(){
		MGSInventoryGeneralINVO[] vos = (MGSInventoryGeneralINVO[])models.toArray(new MGSInventoryGeneralINVO[models.size()]);
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
		this.atchBare = this.atchBare .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdUmg = this.eqTpszCdUmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.location = this.location .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispCd = this.dispCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgSnd = this.dmgSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdClg = this.eqTpszCdClg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdTotal = this.eqTpszCdTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCd = this.agmtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntLocCd = this.crntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.group1 = this.group1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
