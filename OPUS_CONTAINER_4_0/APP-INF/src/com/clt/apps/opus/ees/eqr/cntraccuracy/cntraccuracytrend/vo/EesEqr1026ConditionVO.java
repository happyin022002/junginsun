/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1026ConditionVO.java
*@FileTitle : EesEqr1026ConditionVO
*Open Issues :
*Change history :
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr1026ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1026ConditionVO> models = new ArrayList<EesEqr1026ConditionVO>();
	
	/* Column Info */
	private String subtrade = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String lclDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmWk = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String toWk = null;
	/* Column Info */
	private String locTpCd = null;

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1026ConditionVO() {}

	public EesEqr1026ConditionVO(String ibflag, String pagerows, String subtrade, String trade, String ofcTpCd, String rccCd, String lclDt, String lane, String ofcCd, String fmWk, String locCd, String vvdCd, String usrId, String cntrTpszCd, String tpsztype, String toWk, String locTpCd) {
		this.subtrade = subtrade;
		this.trade = trade;
		this.ofcTpCd = ofcTpCd;
		this.rccCd = rccCd;
		this.lclDt = lclDt;
		this.pagerows = pagerows;
		this.lane = lane;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.fmWk = fmWk;
		this.locCd = locCd;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.cntrTpszCd = cntrTpszCd;
		this.tpsztype = tpsztype;
		this.toWk = toWk;
		this.locTpCd = locTpCd;
	}
	
	/**
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("lcl_dt", getLclDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_wk", getFmWk());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("to_wk", getToWk());
		this.hashColumns.put("loc_tp_cd", getLocTpCd());
		return this.hashColumns;
	}
	
	/**
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("lcl_dt", "lclDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_wk", "fmWk");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("to_wk", "toWk");
		this.hashFields.put("loc_tp_cd", "locTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return subtrade
	 */
	public String getSubtrade() {
		return this.subtrade;
	}
	
	/**
	 * Column Info
	 * @return trade
	 */
	public String getTrade() {
		return this.trade;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return lclDt
	 */
	public String getLclDt() {
		return this.lclDt;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return fmWk
	 */
	public String getFmWk() {
		return this.fmWk;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	
	/**
	 * Column Info
	 * @return toWk
	 */
	public String getToWk() {
		return this.toWk;
	}
	
	/**
	 * Column Info
	 * @return locTpCd
	 */
	public String getLocTpCd() {
		return this.locTpCd;
	}
	

	/**
	 * Column Info
	 * @param subtrade
	 */
	public void setSubtrade(String subtrade) {
		this.subtrade = subtrade;
	}
	
	/**
	 * Column Info
	 * @param trade
	 */
	public void setTrade(String trade) {
		this.trade = trade;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param lclDt
	 */
	public void setLclDt(String lclDt) {
		this.lclDt = lclDt;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param fmWk
	 */
	public void setFmWk(String fmWk) {
		this.fmWk = fmWk;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Column Info
	 * @param toWk
	 */
	public void setToWk(String toWk) {
		this.toWk = toWk;
	}
	
	/**
	 * Column Info
	 * @param locTpCd
	 */
	public void setLocTpCd(String locTpCd) {
		this.locTpCd = locTpCd;
	}
	
/**
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setSubtrade(JSPUtil.getParameter(request, prefix + "subtrade", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setLclDt(JSPUtil.getParameter(request, prefix + "lcl_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmWk(JSPUtil.getParameter(request, prefix + "fm_wk", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setTpsztype(JSPUtil.getParameter(request, prefix + "tpsztype", ""));
		setToWk(JSPUtil.getParameter(request, prefix + "to_wk", ""));
		setLocTpCd(JSPUtil.getParameter(request, prefix + "loc_tp_cd", ""));
	}

	/**
	 * @param request
	 * @return EesEqr1026ConditionVO[]
	 */
	public EesEqr1026ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * @param request
	 * @param prefix
	 * @return EesEqr1026ConditionVO[]
	 */
	public EesEqr1026ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1026ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] lclDt = (JSPUtil.getParameter(request, prefix	+ "lcl_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmWk = (JSPUtil.getParameter(request, prefix	+ "fm_wk", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] toWk = (JSPUtil.getParameter(request, prefix	+ "to_wk", length));
			String[] locTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1026ConditionVO();
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (lclDt[i] != null)
					model.setLclDt(lclDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmWk[i] != null)
					model.setFmWk(fmWk[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (toWk[i] != null)
					model.setToWk(toWk[i]);
				if (locTpCd[i] != null)
					model.setLocTpCd(locTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1026ConditionVOs();
	}

	/**
	 * @return EesEqr1026ConditionVO[]
	 */
	public EesEqr1026ConditionVO[] getEesEqr1026ConditionVOs(){
		EesEqr1026ConditionVO[] vos = (EesEqr1026ConditionVO[])models.toArray(new EesEqr1026ConditionVO[models.size()]);
		return vos;
	}
	
	/**
	 * 
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 
	*/
	public void unDataFormat(){
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclDt = this.lclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWk = this.fmWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWk = this.toWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCd = this.locTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
