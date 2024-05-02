/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchEGKpiTargetManageVO.java
*@FileTitle : SearchEGKpiTargetManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

@SuppressWarnings("unused")
public class SearchEGKpiTargetManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEGKpiTargetManageVO> models = new ArrayList<SearchEGKpiTargetManageVO>();
	
	/* Column Info */
	private String egCtyCd = null;
	/* Column Info */
	private String spKpiNm = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String spKpiCd = null;
	/* Column Info */
	private String egName = null;
	/* Column Info */
	private String kpiTgtRto = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String per = null;
	/* Column Info */
	private String target = null;
	/* Column Info */
	private String kpiWgtRto = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String kpiUtCd = null;
	/* Column Info */
	private String svcCateCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEGKpiTargetManageVO() {}

	public SearchEGKpiTargetManageVO(String ibflag, String pagerows, String egId, String egName, String spKpiCd, String spKpiNm, String per, String target, String kpiTgtRto, String kpiUtCd, String kpiWgtRto, String egRhqCd, String egCtyCd, String svcCateCd, String evYr) {
		this.egCtyCd = egCtyCd;
		this.spKpiNm = spKpiNm;
		this.egRhqCd = egRhqCd;
		this.spKpiCd = spKpiCd;
		this.egName = egName;
		this.kpiTgtRto = kpiTgtRto;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.per = per;
		this.target = target;
		this.kpiWgtRto = kpiWgtRto;
		this.evYr = evYr;
		this.egId = egId;
		this.kpiUtCd = kpiUtCd;
		this.svcCateCd = svcCateCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eg_cty_cd", getEgCtyCd());
		this.hashColumns.put("sp_kpi_nm", getSpKpiNm());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("sp_kpi_cd", getSpKpiCd());
		this.hashColumns.put("eg_name", getEgName());
		this.hashColumns.put("kpi_tgt_rto", getKpiTgtRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("per", getPer());
		this.hashColumns.put("target", getTarget());
		this.hashColumns.put("kpi_wgt_rto", getKpiWgtRto());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("kpi_ut_cd", getKpiUtCd());
		this.hashColumns.put("svc_cate_cd", getSvcCateCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eg_cty_cd", "egCtyCd");
		this.hashFields.put("sp_kpi_nm", "spKpiNm");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("sp_kpi_cd", "spKpiCd");
		this.hashFields.put("eg_name", "egName");
		this.hashFields.put("kpi_tgt_rto", "kpiTgtRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("per", "per");
		this.hashFields.put("target", "target");
		this.hashFields.put("kpi_wgt_rto", "kpiWgtRto");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("kpi_ut_cd", "kpiUtCd");
		this.hashFields.put("svc_cate_cd", "svcCateCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return egCtyCd
	 */
	public String getEgCtyCd() {
		return this.egCtyCd;
	}
	
	/**
	 * Column Info
	 * @return spKpiNm
	 */
	public String getSpKpiNm() {
		return this.spKpiNm;
	}
	
	/**
	 * Column Info
	 * @return egRhqCd
	 */
	public String getEgRhqCd() {
		return this.egRhqCd;
	}
	
	/**
	 * Column Info
	 * @return spKpiCd
	 */
	public String getSpKpiCd() {
		return this.spKpiCd;
	}
	
	/**
	 * Column Info
	 * @return egName
	 */
	public String getEgName() {
		return this.egName;
	}
	
	/**
	 * Column Info
	 * @return kpiTgtRto
	 */
	public String getKpiTgtRto() {
		return this.kpiTgtRto;
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
	 * @return per
	 */
	public String getPer() {
		return this.per;
	}
	
	/**
	 * Column Info
	 * @return target
	 */
	public String getTarget() {
		return this.target;
	}
	
	/**
	 * Column Info
	 * @return kpiWgtRto
	 */
	public String getKpiWgtRto() {
		return this.kpiWgtRto;
	}
	
	/**
	 * Column Info
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
	}
	
	/**
	 * Column Info
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
	}
	
	/**
	 * Column Info
	 * @return kpiUtCd
	 */
	public String getKpiUtCd() {
		return this.kpiUtCd;
	}
	
	/**
	 * Column Info
	 * @return svcCateCd
	 */
	public String getSvcCateCd() {
		return this.svcCateCd;
	}
	

	/**
	 * Column Info
	 * @param egCtyCd
	 */
	public void setEgCtyCd(String egCtyCd) {
		this.egCtyCd = egCtyCd;
	}
	
	/**
	 * Column Info
	 * @param spKpiNm
	 */
	public void setSpKpiNm(String spKpiNm) {
		this.spKpiNm = spKpiNm;
	}
	
	/**
	 * Column Info
	 * @param egRhqCd
	 */
	public void setEgRhqCd(String egRhqCd) {
		this.egRhqCd = egRhqCd;
	}
	
	/**
	 * Column Info
	 * @param spKpiCd
	 */
	public void setSpKpiCd(String spKpiCd) {
		this.spKpiCd = spKpiCd;
	}
	
	/**
	 * Column Info
	 * @param egName
	 */
	public void setEgName(String egName) {
		this.egName = egName;
	}
	
	/**
	 * Column Info
	 * @param kpiTgtRto
	 */
	public void setKpiTgtRto(String kpiTgtRto) {
		this.kpiTgtRto = kpiTgtRto;
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
	 * @param per
	 */
	public void setPer(String per) {
		this.per = per;
	}
	
	/**
	 * Column Info
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	
	/**
	 * Column Info
	 * @param kpiWgtRto
	 */
	public void setKpiWgtRto(String kpiWgtRto) {
		this.kpiWgtRto = kpiWgtRto;
	}
	
	/**
	 * Column Info
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
	}
	
	/**
	 * Column Info
	 * @param kpiUtCd
	 */
	public void setKpiUtCd(String kpiUtCd) {
		this.kpiUtCd = kpiUtCd;
	}
	
	/**
	 * Column Info
	 * @param svcCateCd
	 */
	public void setSvcCateCd(String svcCateCd) {
		this.svcCateCd = svcCateCd;
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
		setEgCtyCd(JSPUtil.getParameter(request, prefix + "eg_cty_cd", ""));
		setSpKpiNm(JSPUtil.getParameter(request, prefix + "sp_kpi_nm", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setSpKpiCd(JSPUtil.getParameter(request, prefix + "sp_kpi_cd", ""));
		setEgName(JSPUtil.getParameter(request, prefix + "eg_name", ""));
		setKpiTgtRto(JSPUtil.getParameter(request, prefix + "kpi_tgt_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPer(JSPUtil.getParameter(request, prefix + "per", ""));
		setTarget(JSPUtil.getParameter(request, prefix + "target", ""));
		setKpiWgtRto(JSPUtil.getParameter(request, prefix + "kpi_wgt_rto", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setKpiUtCd(JSPUtil.getParameter(request, prefix + "kpi_ut_cd", ""));
		setSvcCateCd(JSPUtil.getParameter(request, prefix + "svc_cate_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEGKpiTargetManageVO[]
	 */
	public SearchEGKpiTargetManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEGKpiTargetManageVO[]
	 */
	public SearchEGKpiTargetManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEGKpiTargetManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] egCtyCd = (JSPUtil.getParameter(request, prefix	+ "eg_cty_cd", length));
			String[] spKpiNm = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_nm", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] spKpiCd = (JSPUtil.getParameter(request, prefix	+ "sp_kpi_cd", length));
			String[] egName = (JSPUtil.getParameter(request, prefix	+ "eg_name", length));
			String[] kpiTgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_tgt_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] per = (JSPUtil.getParameter(request, prefix	+ "per", length));
			String[] target = (JSPUtil.getParameter(request, prefix	+ "target", length));
			String[] kpiWgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_wgt_rto", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] kpiUtCd = (JSPUtil.getParameter(request, prefix	+ "kpi_ut_cd", length));
			String[] svcCateCd = (JSPUtil.getParameter(request, prefix	+ "svc_cate_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEGKpiTargetManageVO();
				if (egCtyCd[i] != null)
					model.setEgCtyCd(egCtyCd[i]);
				if (spKpiNm[i] != null)
					model.setSpKpiNm(spKpiNm[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (spKpiCd[i] != null)
					model.setSpKpiCd(spKpiCd[i]);
				if (egName[i] != null)
					model.setEgName(egName[i]);
				if (kpiTgtRto[i] != null)
					model.setKpiTgtRto(kpiTgtRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (per[i] != null)
					model.setPer(per[i]);
				if (target[i] != null)
					model.setTarget(target[i]);
				if (kpiWgtRto[i] != null)
					model.setKpiWgtRto(kpiWgtRto[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (kpiUtCd[i] != null)
					model.setKpiUtCd(kpiUtCd[i]);
				if (svcCateCd[i] != null)
					model.setSvcCateCd(svcCateCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEGKpiTargetManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEGKpiTargetManageVO[]
	 */
	public SearchEGKpiTargetManageVO[] getSearchEGKpiTargetManageVOs(){
		SearchEGKpiTargetManageVO[] vos = (SearchEGKpiTargetManageVO[])models.toArray(new SearchEGKpiTargetManageVO[models.size()]);
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
		this.egCtyCd = this.egCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiNm = this.spKpiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spKpiCd = this.spKpiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egName = this.egName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiTgtRto = this.kpiTgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.per = this.per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.target = this.target .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiWgtRto = this.kpiWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiUtCd = this.kpiUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateCd = this.svcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
