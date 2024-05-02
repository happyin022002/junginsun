/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24BlForEmlVO.java
*@FileTitle : Eur24BlForEmlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

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
public class Eur24BlForEmlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlForEmlVO> models = new ArrayList<Eur24BlForEmlVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String eurEdiMsgTpId = null;

	/* Column Info */
	private String vslCd = null;

	/* Column Info */
	private String skdVoyNo = null;

	/* Column Info */
	private String skdDirCd = null;

	/* Column Info */
	private String vvd = null;

	/* Column Info */
	private String cstmsPortCd = null;

	/* Column Info */
	private String blNo = null;

	/* Column Info */
	private String ediRcvDt = null;

	/* Column Info */
	private String ediRcvSeq = null;

	/* Column Info */
	private String rvisN1stClptCd = null;

	/* Column Info */
	private String polCd = null;

	/* Column Info */
	private String podCd = null;

	/* Column Info */
	private String ofcEngNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public Eur24BlForEmlVO() {}

	public Eur24BlForEmlVO(String ibflag, String pagerows, String eurEdiMsgTpId, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String cstmsPortCd, String blNo, String ediRcvDt, String ediRcvSeq, String rvisN1stClptCd, String polCd, String podCd, String ofcEngNm) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.cstmsPortCd = cstmsPortCd;
		this.blNo = blNo;
		this.ediRcvDt = ediRcvDt;
		this.ediRcvSeq = ediRcvSeq;
		this.rvisN1stClptCd = rvisN1stClptCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("edi_rcv_dt", getEdiRcvDt());
		this.hashColumns.put("edi_rcv_seq", getEdiRcvSeq());
		this.hashColumns.put("rvis_n1st_clpt_cd", getRvisN1stClptCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("edi_rcv_dt", "ediRcvDt");
		this.hashFields.put("edi_rcv_seq", "ediRcvSeq");
		this.hashFields.put("rvis_n1st_clpt_cd", "rvisN1stClptCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String eurEdiMsgTpId
	 */
	public void setEurEdiMsgTpId(String eurEdiMsgTpId) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
	}
	
	/**
	 * 
	 * @return String eurEdiMsgTpId
	 */
	public String getEurEdiMsgTpId() {
		return this.eurEdiMsgTpId;
	}
	
	/**
	 *
	 * @param String vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * 
	 * @return String vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 *
	 * @param String skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * 
	 * @return String skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 *
	 * @param String skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * 
	 * @return String skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 *
	 * @param String vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * 
	 * @return String vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 *
	 * @param String cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * 
	 * @return String cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 *
	 * @param String blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * 
	 * @return String blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 *
	 * @param String ediRcvDt
	 */
	public void setEdiRcvDt(String ediRcvDt) {
		this.ediRcvDt = ediRcvDt;
	}
	
	/**
	 * 
	 * @return String ediRcvDt
	 */
	public String getEdiRcvDt() {
		return this.ediRcvDt;
	}
	
	/**
	 *
	 * @param String ediRcvSeq
	 */
	public void setEdiRcvSeq(String ediRcvSeq) {
		this.ediRcvSeq = ediRcvSeq;
	}
	
	/**
	 * 
	 * @return String ediRcvSeq
	 */
	public String getEdiRcvSeq() {
		return this.ediRcvSeq;
	}
	
	/**
	 *
	 * @param String rvisN1stClptCd
	 */
	public void setRvisN1stClptCd(String rvisN1stClptCd) {
		this.rvisN1stClptCd = rvisN1stClptCd;
	}
	
	/**
	 * 
	 * @return String rvisN1stClptCd
	 */
	public String getRvisN1stClptCd() {
		return this.rvisN1stClptCd;
	}
	
	/**
	 *
	 * @param String polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * 
	 * @return String polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 *
	 * @param String podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * 
	 * @return String podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 *
	 * @param String ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * 
	 * @return String ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEurEdiMsgTpId(JSPUtil.getParameter(request, prefix + "eur_edi_msg_tp_id", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEdiRcvDt(JSPUtil.getParameter(request, prefix + "edi_rcv_dt", ""));
		setEdiRcvSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_seq", ""));
		setRvisN1stClptCd(JSPUtil.getParameter(request, prefix + "rvis_n1st_clpt_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlForEmlVO[]
	 */
	public Eur24BlForEmlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlForEmlVO[]
	 */
	public Eur24BlForEmlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlForEmlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ediRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt", length));
			String[] ediRcvSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_seq", length));
			String[] rvisN1stClptCd = (JSPUtil.getParameter(request, prefix	+ "rvis_n1st_clpt_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlForEmlVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (eurEdiMsgTpId[i] != null) 
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (vslCd[i] != null) 
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null) 
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null) 
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null) 
					model.setVvd(vvd[i]);
				if (cstmsPortCd[i] != null) 
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (blNo[i] != null) 
					model.setBlNo(blNo[i]);
				if (ediRcvDt[i] != null) 
					model.setEdiRcvDt(ediRcvDt[i]);
				if (ediRcvSeq[i] != null) 
					model.setEdiRcvSeq(ediRcvSeq[i]);
				if (rvisN1stClptCd[i] != null) 
					model.setRvisN1stClptCd(rvisN1stClptCd[i]);
				if (polCd[i] != null) 
					model.setPolCd(polCd[i]);
				if (podCd[i] != null) 
					model.setPodCd(podCd[i]);
				if (ofcEngNm[i] != null) 
					model.setOfcEngNm(ofcEngNm[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlForEmlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlForEmlVO[]
	 */
	public Eur24BlForEmlVO[] getEur24BlForEmlVOs(){
		Eur24BlForEmlVO[] vos = (Eur24BlForEmlVO[])models.toArray(new Eur24BlForEmlVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurEdiMsgTpId = this.eurEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvDt = this.ediRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvSeq = this.ediRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisN1stClptCd = this.rvisN1stClptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}