/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchEGTerminalKpiManageVO.java
*@FileTitle : SearchEGTerminalKpiManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo;

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
public class SearchEGTerminalKpiManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEGTerminalKpiManageVO> models = new ArrayList<SearchEGTerminalKpiManageVO>();
	
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String kpiTgtRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String regGroup = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String engVndrRmk = null;
	/* Column Info */
	private String egIdSeq = null;
	/* Column Info */
	private String per = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String target = null;
	/* Column Info */
	private String kpiWgtRto = null;
	/* Column Info */
	private String kpiUtCd = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String egId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEGTerminalKpiManageVO() {}

	public SearchEGTerminalKpiManageVO(String ibflag, String pagerows, String evYr, String egId, String egIdSeq, String regGroup, String ofcCd, String ydCd, String ydNm, String vndrSeq, String vndrLglEngNm, String per, String target, String kpiTgtRto, String kpiUtCd, String kpiWgtRto, String engVndrRmk) {
		this.vndrLglEngNm = vndrLglEngNm;
		this.kpiTgtRto = kpiTgtRto;
		this.pagerows = pagerows;
		this.regGroup = regGroup;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.engVndrRmk = engVndrRmk;
		this.egIdSeq = egIdSeq;
		this.per = per;
		this.ydCd = ydCd;
		this.vndrSeq = vndrSeq;
		this.ydNm = ydNm;
		this.target = target;
		this.kpiWgtRto = kpiWgtRto;
		this.kpiUtCd = kpiUtCd;
		this.evYr = evYr;
		this.egId = egId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("kpi_tgt_rto", getKpiTgtRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("reg_group", getRegGroup());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eng_vndr_rmk", getEngVndrRmk());
		this.hashColumns.put("eg_id_seq", getEgIdSeq());
		this.hashColumns.put("per", getPer());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("target", getTarget());
		this.hashColumns.put("kpi_wgt_rto", getKpiWgtRto());
		this.hashColumns.put("kpi_ut_cd", getKpiUtCd());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("eg_id", getEgId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("kpi_tgt_rto", "kpiTgtRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("reg_group", "regGroup");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eng_vndr_rmk", "engVndrRmk");
		this.hashFields.put("eg_id_seq", "egIdSeq");
		this.hashFields.put("per", "per");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("target", "target");
		this.hashFields.put("kpi_wgt_rto", "kpiWgtRto");
		this.hashFields.put("kpi_ut_cd", "kpiUtCd");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("eg_id", "egId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * Column Info
	 * @return regGroup
	 */
	public String getRegGroup() {
		return this.regGroup;
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
	 * @return engVndrRmk
	 */
	public String getEngVndrRmk() {
		return this.engVndrRmk;
	}
	
	/**
	 * Column Info
	 * @return egIdSeq
	 */
	public String getEgIdSeq() {
		return this.egIdSeq;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
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
	 * @return kpiUtCd
	 */
	public String getKpiUtCd() {
		return this.kpiUtCd;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * Column Info
	 * @param regGroup
	 */
	public void setRegGroup(String regGroup) {
		this.regGroup = regGroup;
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
	 * @param engVndrRmk
	 */
	public void setEngVndrRmk(String engVndrRmk) {
		this.engVndrRmk = engVndrRmk;
	}
	
	/**
	 * Column Info
	 * @param egIdSeq
	 */
	public void setEgIdSeq(String egIdSeq) {
		this.egIdSeq = egIdSeq;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
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
	 * @param kpiUtCd
	 */
	public void setKpiUtCd(String kpiUtCd) {
		this.kpiUtCd = kpiUtCd;
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
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setKpiTgtRto(JSPUtil.getParameter(request, prefix + "kpi_tgt_rto", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRegGroup(JSPUtil.getParameter(request, prefix + "reg_group", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEngVndrRmk(JSPUtil.getParameter(request, prefix + "eng_vndr_rmk", ""));
		setEgIdSeq(JSPUtil.getParameter(request, prefix + "eg_id_seq", ""));
		setPer(JSPUtil.getParameter(request, prefix + "per", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setTarget(JSPUtil.getParameter(request, prefix + "target", ""));
		setKpiWgtRto(JSPUtil.getParameter(request, prefix + "kpi_wgt_rto", ""));
		setKpiUtCd(JSPUtil.getParameter(request, prefix + "kpi_ut_cd", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEGTerminalKpiManageVO[]
	 */
	public SearchEGTerminalKpiManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEGTerminalKpiManageVO[]
	 */
	public SearchEGTerminalKpiManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEGTerminalKpiManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] kpiTgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_tgt_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] regGroup = (JSPUtil.getParameter(request, prefix	+ "reg_group", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] engVndrRmk = (JSPUtil.getParameter(request, prefix	+ "eng_vndr_rmk", length));
			String[] egIdSeq = (JSPUtil.getParameter(request, prefix	+ "eg_id_seq", length));
			String[] per = (JSPUtil.getParameter(request, prefix	+ "per", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] target = (JSPUtil.getParameter(request, prefix	+ "target", length));
			String[] kpiWgtRto = (JSPUtil.getParameter(request, prefix	+ "kpi_wgt_rto", length));
			String[] kpiUtCd = (JSPUtil.getParameter(request, prefix	+ "kpi_ut_cd", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEGTerminalKpiManageVO();
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (kpiTgtRto[i] != null)
					model.setKpiTgtRto(kpiTgtRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (regGroup[i] != null)
					model.setRegGroup(regGroup[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (engVndrRmk[i] != null)
					model.setEngVndrRmk(engVndrRmk[i]);
				if (egIdSeq[i] != null)
					model.setEgIdSeq(egIdSeq[i]);
				if (per[i] != null)
					model.setPer(per[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (target[i] != null)
					model.setTarget(target[i]);
				if (kpiWgtRto[i] != null)
					model.setKpiWgtRto(kpiWgtRto[i]);
				if (kpiUtCd[i] != null)
					model.setKpiUtCd(kpiUtCd[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEGTerminalKpiManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEGTerminalKpiManageVO[]
	 */
	public SearchEGTerminalKpiManageVO[] getSearchEGTerminalKpiManageVOs(){
		SearchEGTerminalKpiManageVO[] vos = (SearchEGTerminalKpiManageVO[])models.toArray(new SearchEGTerminalKpiManageVO[models.size()]);
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
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiTgtRto = this.kpiTgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regGroup = this.regGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engVndrRmk = this.engVndrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egIdSeq = this.egIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.per = this.per .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.target = this.target .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiWgtRto = this.kpiWgtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiUtCd = this.kpiUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
