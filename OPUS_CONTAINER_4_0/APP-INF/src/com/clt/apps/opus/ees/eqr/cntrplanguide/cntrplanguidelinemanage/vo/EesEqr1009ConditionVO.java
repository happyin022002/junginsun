/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1009ConditionVO.java
*@FileTitle : EesEqr1009ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.06.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo;

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
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class EesEqr1009ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1009ConditionVO> models = new ArrayList<EesEqr1009ConditionVO>();
	
	/* Column Info */
	private String sEtaDt = null;
	/* Column Info */
	private String subtrade = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sEffStDt = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String sVvdCd = null;
	/* Column Info */
	private String comboPolCd = null;
	/* Column Info */
	private String sPolCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String hEtaDt = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1009ConditionVO() {}

	public EesEqr1009ConditionVO(String ibflag, String pagerows, String subtrade, String sEtaDt, String cntrTpszCd, String sEffStDt, String sVvdCd, String trade, String comboPolCd, String sPolCd, String hEtaDt, String lane) {
		this.sEtaDt = sEtaDt;
		this.subtrade = subtrade;
		this.ibflag = ibflag;
		this.sEffStDt = sEffStDt;
		this.trade = trade;
		this.sVvdCd = sVvdCd;
		this.comboPolCd = comboPolCd;
		this.sPolCd = sPolCd;
		this.cntrTpszCd = cntrTpszCd;
		this.hEtaDt = hEtaDt;
		this.lane = lane;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_eta_dt", getSEtaDt());
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_eff_st_dt", getSEffStDt());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("s_vvd_cd", getSVvdCd());
		this.hashColumns.put("combo_pol_cd", getComboPolCd());
		this.hashColumns.put("s_pol_cd", getSPolCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("h_eta_dt", getHEtaDt());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_eta_dt", "sEtaDt");
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_eff_st_dt", "sEffStDt");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("s_vvd_cd", "sVvdCd");
		this.hashFields.put("combo_pol_cd", "comboPolCd");
		this.hashFields.put("s_pol_cd", "sPolCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("h_eta_dt", "hEtaDt");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sEtaDt
	 */
	public String getSEtaDt() {
		return this.sEtaDt;
	}
	
	/**
	 * Column Info
	 * @return subtrade
	 */
	public String getSubtrade() {
		return this.subtrade;
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
	 * @return sEffStDt
	 */
	public String getSEffStDt() {
		return this.sEffStDt;
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
	 * @return sVvdCd
	 */
	public String getSVvdCd() {
		return this.sVvdCd;
	}
	
	/**
	 * Column Info
	 * @return comboPolCd
	 */
	public String getComboPolCd() {
		return this.comboPolCd;
	}
	
	/**
	 * Column Info
	 * @return sPolCd
	 */
	public String getSPolCd() {
		return this.sPolCd;
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
	 * @return hEtaDt
	 */
	public String getHEtaDt() {
		return this.hEtaDt;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @param sEtaDt
	 */
	public void setSEtaDt(String sEtaDt) {
		this.sEtaDt = sEtaDt;
	}
	
	/**
	 * Column Info
	 * @param subtrade
	 */
	public void setSubtrade(String subtrade) {
		this.subtrade = subtrade;
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
	 * @param sEffStDt
	 */
	public void setSEffStDt(String sEffStDt) {
		this.sEffStDt = sEffStDt;
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
	 * @param sVvdCd
	 */
	public void setSVvdCd(String sVvdCd) {
		this.sVvdCd = sVvdCd;
	}
	
	/**
	 * Column Info
	 * @param comboPolCd
	 */
	public void setComboPolCd(String comboPolCd) {
		this.comboPolCd = comboPolCd;
	}
	
	/**
	 * Column Info
	 * @param sPolCd
	 */
	public void setSPolCd(String sPolCd) {
		this.sPolCd = sPolCd;
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
	 * @param hEtaDt
	 */
	public void setHEtaDt(String hEtaDt) {
		this.hEtaDt = hEtaDt;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setSEtaDt(JSPUtil.getParameter(request, prefix + "s_eta_dt", ""));
		setSubtrade(JSPUtil.getParameter(request, prefix + "subtrade", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSEffStDt(JSPUtil.getParameter(request, prefix + "s_eff_st_dt", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setSVvdCd(JSPUtil.getParameter(request, prefix + "s_vvd_cd", ""));
		setComboPolCd(JSPUtil.getParameter(request, prefix + "combo_pol_cd", ""));
		setSPolCd(JSPUtil.getParameter(request, prefix + "s_pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setHEtaDt(JSPUtil.getParameter(request, prefix + "h_eta_dt", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1009ConditionVO[]
	 */
	public EesEqr1009ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1009ConditionVO[]
	 */
	public EesEqr1009ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1009ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sEtaDt = (JSPUtil.getParameter(request, prefix	+ "s_eta_dt", length));
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sEffStDt = (JSPUtil.getParameter(request, prefix	+ "s_eff_st_dt", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] sVvdCd = (JSPUtil.getParameter(request, prefix	+ "s_vvd_cd", length));
			String[] comboPolCd = (JSPUtil.getParameter(request, prefix	+ "combo_pol_cd", length));
			String[] sPolCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] hEtaDt = (JSPUtil.getParameter(request, prefix	+ "h_eta_dt", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1009ConditionVO();
				if (sEtaDt[i] != null)
					model.setSEtaDt(sEtaDt[i]);
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sEffStDt[i] != null)
					model.setSEffStDt(sEffStDt[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (sVvdCd[i] != null)
					model.setSVvdCd(sVvdCd[i]);
				if (comboPolCd[i] != null)
					model.setComboPolCd(comboPolCd[i]);
				if (sPolCd[i] != null)
					model.setSPolCd(sPolCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (hEtaDt[i] != null)
					model.setHEtaDt(hEtaDt[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1009ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1009ConditionVO[]
	 */
	public EesEqr1009ConditionVO[] getEesEqr1009ConditionVOs(){
		EesEqr1009ConditionVO[] vos = (EesEqr1009ConditionVO[])models.toArray(new EesEqr1009ConditionVO[models.size()]);
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
		this.sEtaDt = this.sEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEffStDt = this.sEffStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvdCd = this.sVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboPolCd = this.comboPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolCd = this.sPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hEtaDt = this.hEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
