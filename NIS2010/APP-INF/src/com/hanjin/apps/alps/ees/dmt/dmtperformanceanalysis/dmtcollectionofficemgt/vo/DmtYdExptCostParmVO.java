/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DmtYdExptCostParmVO.java
*@FileTitle : DmtYdExptCostParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.08.16 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.vo;

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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtYdExptCostParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtYdExptCostParmVO> models = new ArrayList<DmtYdExptCostParmVO>();
	
	/* Column Info */
	private String ydType = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydDeltFlg = null;
	/* Column Info */
	private String demObCltFlg = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String chkCurrent = null;
	/* Column Info */
	private String chkTobe = null;
	/* Column Info */
	private String chkExpired = null;
	/* Column Info */
	private String demIbCltFlg = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtYdExptCostParmVO() {}

	public DmtYdExptCostParmVO(String ibflag, String pagerows, String ofcCd, String demIbCltFlg, String demObCltFlg, String period, String cntCd, String ydCd, String ydDeltFlg, String ydType, String chkCurrent, String chkTobe, String chkExpired, String cfmFlg) {
		this.ydType = ydType;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.ydDeltFlg = ydDeltFlg;
		this.demObCltFlg = demObCltFlg;
		this.ydCd = ydCd;
		this.cntCd = cntCd;
		this.period = period;
		this.demIbCltFlg = demIbCltFlg;
		this.chkCurrent = chkCurrent;
		this.chkTobe = chkTobe;
		this.chkExpired = chkExpired;
		this.cfmFlg = cfmFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yd_type", getYdType());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_delt_flg", getYdDeltFlg());
		this.hashColumns.put("dem_ob_clt_flg", getDemObCltFlg());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("dem_ib_clt_flg", getDemIbCltFlg());
		this.hashColumns.put("chk_current", getChkCurrent());
		this.hashColumns.put("chk_tobe", getChkTobe());
		this.hashColumns.put("chk_expired", getChkExpired());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yd_type", "ydType");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_delt_flg", "ydDeltFlg");
		this.hashFields.put("dem_ob_clt_flg", "demObCltFlg");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("period", "period");
		this.hashFields.put("dem_ib_clt_flg", "demIbCltFlg");
		this.hashFields.put("chk_current", "chkCurrent");
		this.hashFields.put("chk_tobe", "chkTobe");
		this.hashFields.put("chk_expired", "chkExpired");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ydType
	 */
	public String getYdType() {
		return this.ydType;
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
	 * @return ydDeltFlg
	 */
	public String getYdDeltFlg() {
		return this.ydDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return demObCltFlg
	 */
	public String getDemObCltFlg() {
		return this.demObCltFlg;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return demIbCltFlg
	 */
	public String getDemIbCltFlg() {
		return this.demIbCltFlg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	public String getChkCurrent() {
		return chkCurrent;
	}

	public String getChkTobe() {
		return chkTobe;
	}

	public String getChkExpired() {
		return chkExpired;
	}

	
	public String getCfmFlg() {
		return cfmFlg;
	}

	/**
	 * Column Info
	 * @param ydType
	 */
	public void setYdType(String ydType) {
		this.ydType = ydType;
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
	 * @param ydDeltFlg
	 */
	public void setYdDeltFlg(String ydDeltFlg) {
		this.ydDeltFlg = ydDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param demObCltFlg
	 */
	public void setDemObCltFlg(String demObCltFlg) {
		this.demObCltFlg = demObCltFlg;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param demIbCltFlg
	 */
	public void setDemIbCltFlg(String demIbCltFlg) {
		this.demIbCltFlg = demIbCltFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
    public void setChkCurrent(String chkCurrent) {
		this.chkCurrent = chkCurrent;
	}

	public void setChkTobe(String chkTobe) {
		this.chkTobe = chkTobe;
	}

	public void setChkExpired(String chkExpired) {
		this.chkExpired = chkExpired;
	}
	
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
		setYdType(JSPUtil.getParameter(request, prefix + "yd_type", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setYdDeltFlg(JSPUtil.getParameter(request, prefix + "yd_delt_flg", ""));
		setDemObCltFlg(JSPUtil.getParameter(request, prefix + "dem_ob_clt_flg", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setPeriod(JSPUtil.getParameter(request, prefix + "period", ""));
		setDemIbCltFlg(JSPUtil.getParameter(request, prefix + "dem_ib_clt_flg", ""));
		setChkCurrent(JSPUtil.getParameter(request, prefix + "chk_current", ""));
		setChkTobe(JSPUtil.getParameter(request, prefix + "chk_tobe", ""));
		setChkExpired(JSPUtil.getParameter(request, prefix + "chk_expired", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtYdExptCostParmVO[]
	 */
	public DmtYdExptCostParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtYdExptCostParmVO[]
	 */
	public DmtYdExptCostParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtYdExptCostParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ydType = (JSPUtil.getParameter(request, prefix	+ "yd_type", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydDeltFlg = (JSPUtil.getParameter(request, prefix	+ "yd_delt_flg", length));
			String[] demObCltFlg = (JSPUtil.getParameter(request, prefix	+ "dem_ob_clt_flg", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] demIbCltFlg = (JSPUtil.getParameter(request, prefix	+ "dem_ib_clt_flg", length));
			String[] chkCurrent = (JSPUtil.getParameter(request, prefix	+ "chk_current", length));
			String[] chkTobe = (JSPUtil.getParameter(request, prefix	+ "chk_tobe", length));
			String[] chkExpired = (JSPUtil.getParameter(request, prefix	+ "chk_expired", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtYdExptCostParmVO();
				if (ydType[i] != null)
					model.setYdType(ydType[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydDeltFlg[i] != null)
					model.setYdDeltFlg(ydDeltFlg[i]);
				if (demObCltFlg[i] != null)
					model.setDemObCltFlg(demObCltFlg[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (demIbCltFlg[i] != null)
					model.setDemIbCltFlg(demIbCltFlg[i]);
				if (chkCurrent[i] != null)
					model.setChkCurrent(chkCurrent[i]);
			    if (chkTobe[i] != null)
					model.setChkTobe(chkTobe[i]);
				if (chkExpired[i] != null)
					model.setChkExpired(chkExpired[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtYdExptCostParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtYdExptCostParmVO[]
	 */
	public DmtYdExptCostParmVO[] getDmtYdExptCostParmVOs(){
		DmtYdExptCostParmVO[] vos = (DmtYdExptCostParmVO[])models.toArray(new DmtYdExptCostParmVO[models.size()]);
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
		this.ydType = this.ydType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydDeltFlg = this.ydDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demObCltFlg = this.demObCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demIbCltFlg = this.demIbCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCurrent = this.chkCurrent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTobe = this.chkTobe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkExpired = this.chkExpired .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
