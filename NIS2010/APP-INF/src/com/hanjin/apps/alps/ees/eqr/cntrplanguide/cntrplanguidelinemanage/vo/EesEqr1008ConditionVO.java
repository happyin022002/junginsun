/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1008ConditionVO.java
*@FileTitle : EesEqr1008ConditionVO
*Open Issues :
*Change history : 
* 1. 2014.01.02 신용찬 수석, lane direct 조건 추가  (CSR ID : CHM-201328003) 
*@LastModifyDate : 2013.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo;

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
public class EesEqr1008ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1008ConditionVO> models = new ArrayList<EesEqr1008ConditionVO>();
	
	/* Column Info */
	private String eqGlineSeq = null;
	/* Column Info */
	private String sEtaDt = null;
	/* Column Info */
	private String subtrade = null;
	/* Column Info */
	private String sLocCd = null;
	/* Column Info */
	private String trade = null;
	/* Column Info */
	private String mainPage = null;
	/* Column Info */
	private String sSubLocCd = null;
	/* Column Info */
	private String lclDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String laneDirect = null;	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String sEffStDt = null;
	/* Column Info */
	private String sDtTpCd = null;
	/* Column Info */
	private String sVvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String sPolCd = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String sEffEndDt = null;
	/* Column Info */
	private String sCfmFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1008ConditionVO() {}

	public EesEqr1008ConditionVO(String ibflag, String pagerows, String eqGlineSeq, String sEtaDt, String subtrade, String sLocCd, String trade, String sSubLocCd, String lclDt, String lane, String laneDirect, String ofcCd, String tpsz, String sEffStDt, String usrId, String sVvdCd, String sDtTpCd, String sPolCd, String cntrTpszCd, String tpsztype, String sEffEndDt, String sCfmFlg, String podCd, String mainPage) {
		this.eqGlineSeq = eqGlineSeq;
		this.sEtaDt = sEtaDt;
		this.subtrade = subtrade;
		this.sLocCd = sLocCd;
		this.trade = trade;
		this.mainPage = mainPage;
		this.sSubLocCd = sSubLocCd;
		this.lclDt = lclDt;
		this.pagerows = pagerows;
		this.lane = lane;
		this.laneDirect = laneDirect;		
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.sEffStDt = sEffStDt;
		this.sDtTpCd = sDtTpCd;
		this.sVvdCd = sVvdCd;
		this.usrId = usrId;
		this.cntrTpszCd = cntrTpszCd;
		this.sPolCd = sPolCd;
		this.tpsztype = tpsztype;
		this.sEffEndDt = sEffEndDt;
		this.sCfmFlg = sCfmFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_gline_seq", getEqGlineSeq());
		this.hashColumns.put("s_eta_dt", getSEtaDt());
		this.hashColumns.put("subtrade", getSubtrade());
		this.hashColumns.put("s_loc_cd", getSLocCd());
		this.hashColumns.put("trade", getTrade());
		this.hashColumns.put("main_page", getMainPage());
		this.hashColumns.put("s_sub_loc_cd", getSSubLocCd());
		this.hashColumns.put("lcl_dt", getLclDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("lane_direct", getLaneDirect());		
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("s_eff_st_dt", getSEffStDt());
		this.hashColumns.put("s_dt_tp_cd", getSDtTpCd());
		this.hashColumns.put("s_vvd_cd", getSVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("s_pol_cd", getSPolCd());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("s_eff_end_dt", getSEffEndDt());
		this.hashColumns.put("s_cfm_flg", getSCfmFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_gline_seq", "eqGlineSeq");
		this.hashFields.put("s_eta_dt", "sEtaDt");
		this.hashFields.put("subtrade", "subtrade");
		this.hashFields.put("s_loc_cd", "sLocCd");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("main_page", "mainPage");
		this.hashFields.put("s_sub_loc_cd", "sSubLocCd");
		this.hashFields.put("lcl_dt", "lclDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("lane_direct", "laneDirect");		
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("s_eff_st_dt", "sEffStDt");
		this.hashFields.put("s_dt_tp_cd", "sDtTpCd");
		this.hashFields.put("s_vvd_cd", "sVvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("s_pol_cd", "sPolCd");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("s_eff_end_dt", "sEffEndDt");
		this.hashFields.put("s_cfm_flg", "sCfmFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqGlineSeq
	 */
	public String getEqGlineSeq() {
		return this.eqGlineSeq;
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
	 * Column Info
	 * @return sLocCd
	 */
	public String getSLocCd() {
		return this.sLocCd;
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
	 * @return mainPage
	 */
	public String getMainPage() {
		return this.mainPage;
	}
	
	/**
	 * Column Info
	 * @return sSubLocCd
	 */
	public String getSSubLocCd() {
		return this.sSubLocCd;
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
	 * @return lane_direct
	 */
	public String getLaneDirect() {
		return this.laneDirect;
	}	
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
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
	 * @return sDtTpCd
	 */
	public String getSDtTpCd() {
		return this.sDtTpCd;
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
	 * @return sPolCd
	 */
	public String getSPolCd() {
		return this.sPolCd;
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
	 * @return sEffEndDt
	 */
	public String getSEffEndDt() {
		return this.sEffEndDt;
	}
	
	/**
	 * Column Info
	 * @return sCfmFlg
	 */
	public String getSCfmFlg() {
		return this.sCfmFlg;
	}
	

	/**
	 * Column Info
	 * @param eqGlineSeq
	 */
	public void setEqGlineSeq(String eqGlineSeq) {
		this.eqGlineSeq = eqGlineSeq;
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
	 * Column Info
	 * @param sLocCd
	 */
	public void setSLocCd(String sLocCd) {
		this.sLocCd = sLocCd;
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
	 * @param mainPage
	 */
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	
	/**
	 * Column Info
	 * @param sSubLocCd
	 */
	public void setSSubLocCd(String sSubLocCd) {
		this.sSubLocCd = sSubLocCd;
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
	 * @param laneDirect
	 */
	public void setLaneDirect(String laneDirect) {
		this.laneDirect = laneDirect;
	}	
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
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
	 * @param sDtTpCd
	 */
	public void setSDtTpCd(String sDtTpCd) {
		this.sDtTpCd = sDtTpCd;
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
	 * @param sPolCd
	 */
	public void setSPolCd(String sPolCd) {
		this.sPolCd = sPolCd;
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
	 * @param sEffEndDt
	 */
	public void setSEffEndDt(String sEffEndDt) {
		this.sEffEndDt = sEffEndDt;
	}
	
	/**
	 * Column Info
	 * @param sCfmFlg
	 */
	public void setSCfmFlg(String sCfmFlg) {
		this.sCfmFlg = sCfmFlg;
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
		setEqGlineSeq(JSPUtil.getParameter(request, prefix + "eq_gline_seq", ""));
		setSEtaDt(JSPUtil.getParameter(request, prefix + "s_eta_dt", ""));
		setSubtrade(JSPUtil.getParameter(request, prefix + "subtrade", ""));
		setSLocCd(JSPUtil.getParameter(request, prefix + "s_loc_cd", ""));
		setTrade(JSPUtil.getParameter(request, prefix + "trade", ""));
		setMainPage(JSPUtil.getParameter(request, prefix + "main_page", ""));
		setSSubLocCd(JSPUtil.getParameter(request, prefix + "s_sub_loc_cd", ""));
		setLclDt(JSPUtil.getParameter(request, prefix + "lcl_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request, prefix + "lane", ""));
		setLaneDirect(JSPUtil.getParameter(request, prefix + "lane_direct", ""));		
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, prefix + "tpsz", ""));
		setSEffStDt(JSPUtil.getParameter(request, prefix + "s_eff_st_dt", ""));
		setSDtTpCd(JSPUtil.getParameter(request, prefix + "s_dt_tp_cd", ""));
		setSVvdCd(JSPUtil.getParameter(request, prefix + "s_vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSPolCd(JSPUtil.getParameter(request, prefix + "s_pol_cd", ""));
		setTpsztype(JSPUtil.getParameter(request, prefix + "tpsztype", ""));
		setSEffEndDt(JSPUtil.getParameter(request, prefix + "s_eff_end_dt", ""));
		setSCfmFlg(JSPUtil.getParameter(request, prefix + "s_cfm_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1008ConditionVO[]
	 */
	public EesEqr1008ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1008ConditionVO[]
	 */
	public EesEqr1008ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1008ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqGlineSeq = (JSPUtil.getParameter(request, prefix	+ "eq_gline_seq", length));
			String[] sEtaDt = (JSPUtil.getParameter(request, prefix	+ "s_eta_dt", length));
			String[] subtrade = (JSPUtil.getParameter(request, prefix	+ "subtrade", length));
			String[] sLocCd = (JSPUtil.getParameter(request, prefix	+ "s_loc_cd", length));
			String[] trade = (JSPUtil.getParameter(request, prefix	+ "trade", length));
			String[] mainPage = (JSPUtil.getParameter(request, prefix	+ "main_page", length));
			String[] sSubLocCd = (JSPUtil.getParameter(request, prefix	+ "s_sub_loc_cd", length));
			String[] lclDt = (JSPUtil.getParameter(request, prefix	+ "lcl_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] laneDirect = (JSPUtil.getParameter(request, prefix	+ "lane_direct", length));			
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "tpsz", length));
			String[] sEffStDt = (JSPUtil.getParameter(request, prefix	+ "s_eff_st_dt", length));
			String[] sDtTpCd = (JSPUtil.getParameter(request, prefix	+ "s_dt_tp_cd", length));
			String[] sVvdCd = (JSPUtil.getParameter(request, prefix	+ "s_vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] sPolCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_cd", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));
			String[] sEffEndDt = (JSPUtil.getParameter(request, prefix	+ "s_eff_end_dt", length));
			String[] sCfmFlg = (JSPUtil.getParameter(request, prefix	+ "s_cfm_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1008ConditionVO();
				if (eqGlineSeq[i] != null)
					model.setEqGlineSeq(eqGlineSeq[i]);
				if (sEtaDt[i] != null)
					model.setSEtaDt(sEtaDt[i]);
				if (subtrade[i] != null)
					model.setSubtrade(subtrade[i]);
				if (sLocCd[i] != null)
					model.setSLocCd(sLocCd[i]);
				if (trade[i] != null)
					model.setTrade(trade[i]);
				if (mainPage[i] != null)
					model.setMainPage(mainPage[i]);
				if (sSubLocCd[i] != null)
					model.setSSubLocCd(sSubLocCd[i]);
				if (lclDt[i] != null)
					model.setLclDt(lclDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (laneDirect[i] != null)
					model.setLaneDirect(laneDirect[i]);				
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (sEffStDt[i] != null)
					model.setSEffStDt(sEffStDt[i]);
				if (sDtTpCd[i] != null)
					model.setSDtTpCd(sDtTpCd[i]);
				if (sVvdCd[i] != null)
					model.setSVvdCd(sVvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (sPolCd[i] != null)
					model.setSPolCd(sPolCd[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (sEffEndDt[i] != null)
					model.setSEffEndDt(sEffEndDt[i]);
				if (sCfmFlg[i] != null)
					model.setSCfmFlg(sCfmFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1008ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1008ConditionVO[]
	 */
	public EesEqr1008ConditionVO[] getEesEqr1008ConditionVOs(){
		EesEqr1008ConditionVO[] vos = (EesEqr1008ConditionVO[])models.toArray(new EesEqr1008ConditionVO[models.size()]);
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
		this.eqGlineSeq = this.eqGlineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEtaDt = this.sEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subtrade = this.subtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLocCd = this.sLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade = this.trade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mainPage = this.mainPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSubLocCd = this.sSubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclDt = this.lclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneDirect = this.laneDirect .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEffStDt = this.sEffStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDtTpCd = this.sDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvdCd = this.sVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolCd = this.sPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEffEndDt = this.sEffEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCfmFlg = this.sCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
