/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CstmsEmlNtfcVO.java
*@FileTitle : CstmsEmlNtfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstmsEmlNtfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsEmlNtfcVO> models = new ArrayList<CstmsEmlNtfcVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String ediMsg = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String orgEdiMsg = null;
	/* Column Info */
	private String orgEdiMsgTpId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String orgPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String orgPodCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String toEmlCtnt = null;
	/* Column Info */
	private String ediMsgTpId = null;
	/* Column Info */
	private String ccEmlCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CstmsEmlNtfcVO() {}

	public CstmsEmlNtfcVO(String ibflag, String pagerows, String cntCd, String cntNm, String ediMsg, String ediMsgTpId, String polCd, String polNm, String podCd, String podNm, String toEmlCtnt, String ccEmlCtnt, String usrId, String updDt, String orgEdiMsg, String orgEdiMsgTpId, String orgPolCd, String orgPodCd) {
		this.updDt = updDt;
		this.podNm = podNm;
		this.ediMsg = ediMsg;
		this.polNm = polNm;
		this.orgEdiMsg = orgEdiMsg;
		this.orgEdiMsgTpId = orgEdiMsgTpId;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.orgPolCd = orgPolCd;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.polCd = polCd;
		this.usrId = usrId;
		this.orgPodCd = orgPodCd;
		this.cntCd = cntCd;
		this.toEmlCtnt = toEmlCtnt;
		this.ediMsgTpId = ediMsgTpId;
		this.ccEmlCtnt = ccEmlCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("edi_msg", getEdiMsg());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("org_edi_msg", getOrgEdiMsg());
		this.hashColumns.put("org_edi_msg_tp_id", getOrgEdiMsgTpId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("org_pol_cd", getOrgPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("org_pod_cd", getOrgPodCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("to_eml_ctnt", getToEmlCtnt());
		this.hashColumns.put("edi_msg_tp_id", getEdiMsgTpId());
		this.hashColumns.put("cc_eml_ctnt", getCcEmlCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("edi_msg", "ediMsg");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("org_edi_msg", "orgEdiMsg");
		this.hashFields.put("org_edi_msg_tp_id", "orgEdiMsgTpId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("org_pol_cd", "orgPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("org_pod_cd", "orgPodCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("to_eml_ctnt", "toEmlCtnt");
		this.hashFields.put("edi_msg_tp_id", "ediMsgTpId");
		this.hashFields.put("cc_eml_ctnt", "ccEmlCtnt");
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
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return ediMsg
	 */
	public String getEdiMsg() {
		return this.ediMsg;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return orgEdiMsg
	 */
	public String getOrgEdiMsg() {
		return this.orgEdiMsg;
	}
	
	/**
	 * Column Info
	 * @return orgEdiMsgTpId
	 */
	public String getOrgEdiMsgTpId() {
		return this.orgEdiMsgTpId;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return orgPolCd
	 */
	public String getOrgPolCd() {
		return this.orgPolCd;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return orgPodCd
	 */
	public String getOrgPodCd() {
		return this.orgPodCd;
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
	 * @return toEmlCtnt
	 */
	public String getToEmlCtnt() {
		return this.toEmlCtnt;
	}
	
	/**
	 * Column Info
	 * @return ediMsgTpId
	 */
	public String getEdiMsgTpId() {
		return this.ediMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return ccEmlCtnt
	 */
	public String getCcEmlCtnt() {
		return this.ccEmlCtnt;
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
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param ediMsg
	 */
	public void setEdiMsg(String ediMsg) {
		this.ediMsg = ediMsg;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param orgEdiMsg
	 */
	public void setOrgEdiMsg(String orgEdiMsg) {
		this.orgEdiMsg = orgEdiMsg;
	}
	
	/**
	 * Column Info
	 * @param orgEdiMsgTpId
	 */
	public void setOrgEdiMsgTpId(String orgEdiMsgTpId) {
		this.orgEdiMsgTpId = orgEdiMsgTpId;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param orgPolCd
	 */
	public void setOrgPolCd(String orgPolCd) {
		this.orgPolCd = orgPolCd;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param orgPodCd
	 */
	public void setOrgPodCd(String orgPodCd) {
		this.orgPodCd = orgPodCd;
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
	 * @param toEmlCtnt
	 */
	public void setToEmlCtnt(String toEmlCtnt) {
		this.toEmlCtnt = toEmlCtnt;
	}
	
	/**
	 * Column Info
	 * @param ediMsgTpId
	 */
	public void setEdiMsgTpId(String ediMsgTpId) {
		this.ediMsgTpId = ediMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param ccEmlCtnt
	 */
	public void setCcEmlCtnt(String ccEmlCtnt) {
		this.ccEmlCtnt = ccEmlCtnt;
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
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setEdiMsg(JSPUtil.getParameter(request, prefix + "edi_msg", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setOrgEdiMsg(JSPUtil.getParameter(request, prefix + "org_edi_msg", ""));
		setOrgEdiMsgTpId(JSPUtil.getParameter(request, prefix + "org_edi_msg_tp_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOrgPolCd(JSPUtil.getParameter(request, prefix + "org_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setOrgPodCd(JSPUtil.getParameter(request, prefix + "org_pod_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setToEmlCtnt(JSPUtil.getParameter(request, prefix + "to_eml_ctnt", ""));
		setEdiMsgTpId(JSPUtil.getParameter(request, prefix + "edi_msg_tp_id", ""));
		setCcEmlCtnt(JSPUtil.getParameter(request, prefix + "cc_eml_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsEmlNtfcVO[]
	 */
	public CstmsEmlNtfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsEmlNtfcVO[]
	 */
	public CstmsEmlNtfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsEmlNtfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] ediMsg = (JSPUtil.getParameter(request, prefix	+ "edi_msg", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] orgEdiMsg = (JSPUtil.getParameter(request, prefix	+ "org_edi_msg", length));
			String[] orgEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "org_edi_msg_tp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] orgPolCd = (JSPUtil.getParameter(request, prefix	+ "org_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] orgPodCd = (JSPUtil.getParameter(request, prefix	+ "org_pod_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] toEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "to_eml_ctnt", length));
			String[] ediMsgTpId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_id", length));
			String[] ccEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "cc_eml_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsEmlNtfcVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (ediMsg[i] != null)
					model.setEdiMsg(ediMsg[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (orgEdiMsg[i] != null)
					model.setOrgEdiMsg(orgEdiMsg[i]);
				if (orgEdiMsgTpId[i] != null)
					model.setOrgEdiMsgTpId(orgEdiMsgTpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (orgPolCd[i] != null)
					model.setOrgPolCd(orgPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (orgPodCd[i] != null)
					model.setOrgPodCd(orgPodCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (toEmlCtnt[i] != null)
					model.setToEmlCtnt(toEmlCtnt[i]);
				if (ediMsgTpId[i] != null)
					model.setEdiMsgTpId(ediMsgTpId[i]);
				if (ccEmlCtnt[i] != null)
					model.setCcEmlCtnt(ccEmlCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsEmlNtfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsEmlNtfcVO[]
	 */
	public CstmsEmlNtfcVO[] getCstmsEmlNtfcVOs(){
		CstmsEmlNtfcVO[] vos = (CstmsEmlNtfcVO[])models.toArray(new CstmsEmlNtfcVO[models.size()]);
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
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsg = this.ediMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEdiMsg = this.orgEdiMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEdiMsgTpId = this.orgEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPolCd = this.orgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPodCd = this.orgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEmlCtnt = this.toEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpId = this.ediMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccEmlCtnt = this.ccEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
