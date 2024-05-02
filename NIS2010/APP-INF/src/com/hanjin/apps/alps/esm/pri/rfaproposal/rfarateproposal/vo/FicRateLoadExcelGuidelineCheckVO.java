/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FicRateLoadExcelGuidelineCheckVO.java
*@FileTitle : FicRateLoadExcelGuidelineCheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.07.11 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FicRateLoadExcelGuidelineCheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FicRateLoadExcelGuidelineCheckVO> models = new ArrayList<FicRateLoadExcelGuidelineCheckVO>();
	
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgPrcTrspModNm = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hSeq = null;
	/* Column Info */
	private String cmdtDpSeq = null;
	/* Column Info */
	private String routDpSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String destPrcTrspModNm = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String orgRcvDeTermNm = null;
	/* Column Info */
	private String destRcvDeTermNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FicRateLoadExcelGuidelineCheckVO() {}

	public FicRateLoadExcelGuidelineCheckVO(String ibflag, String pagerows, String hSeq, String cmdtDpSeq, String routDpSeq, String destRoutPntLocDefCd, String destRoutViaPortDefCd, String destRcvDeTermNm, String destPrcTrspModNm, String orgRoutPntLocDefCd, String orgRoutViaPortDefCd, String orgRcvDeTermNm, String orgPrcTrspModNm, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String effDt) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.pagerows = pagerows;
		this.orgPrcTrspModNm = orgPrcTrspModNm;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.hSeq = hSeq;
		this.cmdtDpSeq = cmdtDpSeq;
		this.routDpSeq = routDpSeq;
		this.propNo = propNo;
		this.destPrcTrspModNm = destPrcTrspModNm;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.orgRcvDeTermNm = orgRcvDeTermNm;
		this.destRcvDeTermNm = destRcvDeTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_prc_trsp_mod_nm", getOrgPrcTrspModNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("h_seq", getHSeq());
		this.hashColumns.put("cmdt_dp_seq", getCmdtDpSeq());
		this.hashColumns.put("rout_dp_seq", getRoutDpSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("dest_prc_trsp_mod_nm", getDestPrcTrspModNm());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("org_rcv_de_term_nm", getOrgRcvDeTermNm());
		this.hashColumns.put("dest_rcv_de_term_nm", getDestRcvDeTermNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_prc_trsp_mod_nm", "orgPrcTrspModNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("h_seq", "hSeq");
		this.hashFields.put("cmdt_dp_seq", "cmdtDpSeq");
		this.hashFields.put("rout_dp_seq", "routDpSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("dest_prc_trsp_mod_nm", "destPrcTrspModNm");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("org_rcv_de_term_nm", "orgRcvDeTermNm");
		this.hashFields.put("dest_rcv_de_term_nm", "destRcvDeTermNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
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
	 * @return orgPrcTrspModNm
	 */
	public String getOrgPrcTrspModNm() {
		return this.orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return hSeq
	 */
	public String getHSeq() {
		return this.hSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtDpSeq
	 */
	public String getCmdtDpSeq() {
		return this.cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @return routDpSeq
	 */
	public String getRoutDpSeq() {
		return this.routDpSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return destPrcTrspModNm
	 */
	public String getDestPrcTrspModNm() {
		return this.destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return orgRcvDeTermNm
	 */
	public String getOrgRcvDeTermNm() {
		return this.orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return destRcvDeTermNm
	 */
	public String getDestRcvDeTermNm() {
		return this.destRcvDeTermNm;
	}
	

	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
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
	 * @param orgPrcTrspModNm
	 */
	public void setOrgPrcTrspModNm(String orgPrcTrspModNm) {
		this.orgPrcTrspModNm = orgPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param hSeq
	 */
	public void setHSeq(String hSeq) {
		this.hSeq = hSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtDpSeq
	 */
	public void setCmdtDpSeq(String cmdtDpSeq) {
		this.cmdtDpSeq = cmdtDpSeq;
	}
	
	/**
	 * Column Info
	 * @param routDpSeq
	 */
	public void setRoutDpSeq(String routDpSeq) {
		this.routDpSeq = routDpSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param destPrcTrspModNm
	 */
	public void setDestPrcTrspModNm(String destPrcTrspModNm) {
		this.destPrcTrspModNm = destPrcTrspModNm;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param orgRcvDeTermNm
	 */
	public void setOrgRcvDeTermNm(String orgRcvDeTermNm) {
		this.orgRcvDeTermNm = orgRcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param destRcvDeTermNm
	 */
	public void setDestRcvDeTermNm(String destRcvDeTermNm) {
		this.destRcvDeTermNm = destRcvDeTermNm;
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
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgPrcTrspModNm(JSPUtil.getParameter(request, prefix + "org_prc_trsp_mod_nm", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHSeq(JSPUtil.getParameter(request, prefix + "h_seq", ""));
		setCmdtDpSeq(JSPUtil.getParameter(request, prefix + "cmdt_dp_seq", ""));
		setRoutDpSeq(JSPUtil.getParameter(request, prefix + "rout_dp_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setDestPrcTrspModNm(JSPUtil.getParameter(request, prefix + "dest_prc_trsp_mod_nm", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setOrgRcvDeTermNm(JSPUtil.getParameter(request, prefix + "org_rcv_de_term_nm", ""));
		setDestRcvDeTermNm(JSPUtil.getParameter(request, prefix + "dest_rcv_de_term_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FicRateLoadExcelGuidelineCheckVO[]
	 */
	public FicRateLoadExcelGuidelineCheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FicRateLoadExcelGuidelineCheckVO[]
	 */
	public FicRateLoadExcelGuidelineCheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FicRateLoadExcelGuidelineCheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "org_prc_trsp_mod_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hSeq = (JSPUtil.getParameter(request, prefix	+ "h_seq", length));
			String[] cmdtDpSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_dp_seq", length));
			String[] routDpSeq = (JSPUtil.getParameter(request, prefix	+ "rout_dp_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] destPrcTrspModNm = (JSPUtil.getParameter(request, prefix	+ "dest_prc_trsp_mod_nm", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] orgRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "org_rcv_de_term_nm", length));
			String[] destRcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dest_rcv_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new FicRateLoadExcelGuidelineCheckVO();
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgPrcTrspModNm[i] != null)
					model.setOrgPrcTrspModNm(orgPrcTrspModNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hSeq[i] != null)
					model.setHSeq(hSeq[i]);
				if (cmdtDpSeq[i] != null)
					model.setCmdtDpSeq(cmdtDpSeq[i]);
				if (routDpSeq[i] != null)
					model.setRoutDpSeq(routDpSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (destPrcTrspModNm[i] != null)
					model.setDestPrcTrspModNm(destPrcTrspModNm[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (orgRcvDeTermNm[i] != null)
					model.setOrgRcvDeTermNm(orgRcvDeTermNm[i]);
				if (destRcvDeTermNm[i] != null)
					model.setDestRcvDeTermNm(destRcvDeTermNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFicRateLoadExcelGuidelineCheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FicRateLoadExcelGuidelineCheckVO[]
	 */
	public FicRateLoadExcelGuidelineCheckVO[] getFicRateLoadExcelGuidelineCheckVOs(){
		FicRateLoadExcelGuidelineCheckVO[] vos = (FicRateLoadExcelGuidelineCheckVO[])models.toArray(new FicRateLoadExcelGuidelineCheckVO[models.size()]);
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
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPrcTrspModNm = this.orgPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hSeq = this.hSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDpSeq = this.cmdtDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDpSeq = this.routDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPrcTrspModNm = this.destPrcTrspModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRcvDeTermNm = this.orgRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRcvDeTermNm = this.destRcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
