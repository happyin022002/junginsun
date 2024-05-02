/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CalculationTypeParmVO.java
*@FileTitle : CalculationTypeParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2010.03.26 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CalculationTypeParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CalculationTypeParmVO> models = new ArrayList<CalculationTypeParmVO>();
	
	/* Column Info */
	private String locRhqCd = null;
	/* Column Info */
	private String delLoc = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String porLoc = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String ioBnd = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String bcntrDlvTerm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String podEtaYn = null;
	/* Column Info */
	private String podEtaFlg = null;
	/* Column Info */
	private String stateCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CalculationTypeParmVO() {}

	public CalculationTypeParmVO(String ibflag, String pagerows, String rgnCd, String ioBnd, String porLoc, String polLoc, String podLoc, String delLoc, String bcntrDlvTerm, String locCd, String effDt, String cntCd, String podEtaFlg, String stateCd, String podEtaYn, String locRhqCd) {
		this.locRhqCd = locRhqCd;
		this.delLoc = delLoc;
		this.rgnCd = rgnCd;
		this.porLoc = porLoc;
		this.polLoc = polLoc;
		this.ioBnd = ioBnd;
		this.podLoc = podLoc;
		this.bcntrDlvTerm = bcntrDlvTerm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.effDt = effDt;
		this.cntCd = cntCd;
		this.podEtaYn = podEtaYn;
		this.podEtaFlg = podEtaFlg;
		this.stateCd = stateCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_rhq_cd", getLocRhqCd());
		this.hashColumns.put("del_loc", getDelLoc());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("por_loc", getPorLoc());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("io_bnd", getIoBnd());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("bcntr_dlv_term", getBcntrDlvTerm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("pod_eta_yn", getPodEtaYn());
		this.hashColumns.put("pod_eta_flg", getPodEtaFlg());
		this.hashColumns.put("state_cd", getStateCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_rhq_cd", "locRhqCd");
		this.hashFields.put("del_loc", "delLoc");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("por_loc", "porLoc");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("io_bnd", "ioBnd");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("bcntr_dlv_term", "bcntrDlvTerm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("pod_eta_yn", "podEtaYn");
		this.hashFields.put("pod_eta_flg", "podEtaFlg");
		this.hashFields.put("state_cd", "stateCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return locRhqCd
	 */
	public String getLocRhqCd() {
		return this.locRhqCd;
	}
	
	/**
	 * Column Info
	 * @return delLoc
	 */
	public String getDelLoc() {
		return this.delLoc;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return porLoc
	 */
	public String getPorLoc() {
		return this.porLoc;
	}
	
	/**
	 * Column Info
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}
	
	/**
	 * Column Info
	 * @return ioBnd
	 */
	public String getIoBnd() {
		return this.ioBnd;
	}
	
	/**
	 * Column Info
	 * @return podLoc
	 */
	public String getPodLoc() {
		return this.podLoc;
	}
	
	/**
	 * Column Info
	 * @return bcntrDlvTerm
	 */
	public String getBcntrDlvTerm() {
		return this.bcntrDlvTerm;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return podEtaYn
	 */
	public String getPodEtaYn() {
		return this.podEtaYn;
	}
	
	/**
	 * Column Info
	 * @return podEtaFlg
	 */
	public String getPodEtaFlg() {
		return this.podEtaFlg;
	}
	
	/**
	 * Column Info
	 * @return stateCd
	 */
	public String getStateCd() {
		return this.stateCd;
	}
	

	/**
	 * Column Info
	 * @param locRhqCd
	 */
	public void setLocRhqCd(String locRhqCd) {
		this.locRhqCd = locRhqCd;
	}
	
	/**
	 * Column Info
	 * @param delLoc
	 */
	public void setDelLoc(String delLoc) {
		this.delLoc = delLoc;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param porLoc
	 */
	public void setPorLoc(String porLoc) {
		this.porLoc = porLoc;
	}
	
	/**
	 * Column Info
	 * @param polLoc
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}
	
	/**
	 * Column Info
	 * @param ioBnd
	 */
	public void setIoBnd(String ioBnd) {
		this.ioBnd = ioBnd;
	}
	
	/**
	 * Column Info
	 * @param podLoc
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}
	
	/**
	 * Column Info
	 * @param bcntrDlvTerm
	 */
	public void setBcntrDlvTerm(String bcntrDlvTerm) {
		this.bcntrDlvTerm = bcntrDlvTerm;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param podEtaYn
	 */
	public void setPodEtaYn(String podEtaYn) {
		this.podEtaYn = podEtaYn;
	}
	
	/**
	 * Column Info
	 * @param podEtaFlg
	 */
	public void setPodEtaFlg(String podEtaFlg) {
		this.podEtaFlg = podEtaFlg;
	}
	
	/**
	 * Column Info
	 * @param stateCd
	 */
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
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
		setLocRhqCd(JSPUtil.getParameter(request, prefix + "loc_rhq_cd", ""));
		setDelLoc(JSPUtil.getParameter(request, prefix + "del_loc", ""));
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setPorLoc(JSPUtil.getParameter(request, prefix + "por_loc", ""));
		setPolLoc(JSPUtil.getParameter(request, prefix + "pol_loc", ""));
		setIoBnd(JSPUtil.getParameter(request, prefix + "io_bnd", ""));
		setPodLoc(JSPUtil.getParameter(request, prefix + "pod_loc", ""));
		setBcntrDlvTerm(JSPUtil.getParameter(request, prefix + "bcntr_dlv_term", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setPodEtaYn(JSPUtil.getParameter(request, prefix + "pod_eta_yn", ""));
		setPodEtaFlg(JSPUtil.getParameter(request, prefix + "pod_eta_flg", ""));
		setStateCd(JSPUtil.getParameter(request, prefix + "state_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CalculationTypeParmVO[]
	 */
	public CalculationTypeParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CalculationTypeParmVO[]
	 */
	public CalculationTypeParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CalculationTypeParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locRhqCd = (JSPUtil.getParameter(request, prefix	+ "loc_rhq_cd", length));
			String[] delLoc = (JSPUtil.getParameter(request, prefix	+ "del_loc", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] porLoc = (JSPUtil.getParameter(request, prefix	+ "por_loc", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] ioBnd = (JSPUtil.getParameter(request, prefix	+ "io_bnd", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] bcntrDlvTerm = (JSPUtil.getParameter(request, prefix	+ "bcntr_dlv_term", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] podEtaYn = (JSPUtil.getParameter(request, prefix	+ "pod_eta_yn", length));
			String[] podEtaFlg = (JSPUtil.getParameter(request, prefix	+ "pod_eta_flg", length));
			String[] stateCd = (JSPUtil.getParameter(request, prefix	+ "state_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CalculationTypeParmVO();
				if (locRhqCd[i] != null)
					model.setLocRhqCd(locRhqCd[i]);
				if (delLoc[i] != null)
					model.setDelLoc(delLoc[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (porLoc[i] != null)
					model.setPorLoc(porLoc[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (ioBnd[i] != null)
					model.setIoBnd(ioBnd[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (bcntrDlvTerm[i] != null)
					model.setBcntrDlvTerm(bcntrDlvTerm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (podEtaYn[i] != null)
					model.setPodEtaYn(podEtaYn[i]);
				if (podEtaFlg[i] != null)
					model.setPodEtaFlg(podEtaFlg[i]);
				if (stateCd[i] != null)
					model.setStateCd(stateCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCalculationTypeParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CalculationTypeParmVO[]
	 */
	public CalculationTypeParmVO[] getCalculationTypeParmVOs(){
		CalculationTypeParmVO[] vos = (CalculationTypeParmVO[])models.toArray(new CalculationTypeParmVO[models.size()]);
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
		this.locRhqCd = this.locRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delLoc = this.delLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porLoc = this.porLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBnd = this.ioBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bcntrDlvTerm = this.bcntrDlvTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaYn = this.podEtaYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaFlg = this.podEtaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stateCd = this.stateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
