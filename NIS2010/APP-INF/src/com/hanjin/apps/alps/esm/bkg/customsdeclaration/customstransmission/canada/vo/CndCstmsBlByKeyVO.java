/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CndCstmsBlByKeyVO.java
*@FileTitle : CndCstmsBlByKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class CndCstmsBlByKeyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsBlByKeyVO> models = new ArrayList<CndCstmsBlByKeyVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String blNo = null;

	/* Column Info */
	private String vslCd = null;

	/* Column Info */
	private String skdVoyNo = null;

	/* Column Info */
	private String skdDirCd = null;

	/* Column Info */
	private String cstmsPolCd = null;

	/* Column Info */
	private String cstmsPodCd = null;

	/* Column Info */
	private String ofcEngNm = null;

	/* Column Info */
	private String shipper = null;

	/* Column Info */
	private String consignee = null;

	/* Column Info */
	private String cstmsAckProcRsltCd = null;

	/* Column Info */
	private String reason = null;

	/* Column Info */
	private String cntrNo = null;

	/* Column Info */
	private String vvd = null;
	
	/* Column Info */
	private String lastAck = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CndCstmsBlByKeyVO() {}

	public CndCstmsBlByKeyVO(String ibflag, String pagerows, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String cstmsPolCd, String cstmsPodCd, String ofcEngNm, String shipper, String consignee, String cstmsAckProcRsltCd, String reason, String cntrNo, String vvd, String lastAck) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.blNo = blNo;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.cstmsPolCd = cstmsPolCd;
		this.cstmsPodCd = cstmsPodCd;
		this.ofcEngNm = ofcEngNm;
		this.shipper = shipper;
		this.consignee = consignee;
		this.cstmsAckProcRsltCd = cstmsAckProcRsltCd;
		this.reason = reason;
		this.cntrNo = cntrNo;
		this.vvd = vvd;
		this.lastAck = lastAck;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cstms_pol_cd", getCstmsPolCd());
		this.hashColumns.put("cstms_pod_cd", getCstmsPodCd());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("cstms_ack_proc_rslt_cd", getCstmsAckProcRsltCd());
		this.hashColumns.put("reason", getReason());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("last_ack", getLastAck());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cstms_pol_cd", "cstmsPolCd");
		this.hashFields.put("cstms_pod_cd", "cstmsPodCd");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("cstms_ack_proc_rslt_cd", "cstmsAckProcRsltCd");
		this.hashFields.put("reason", "reason");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("last_ack", "lastAck");
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
	 * @param String cstmsPolCd
	 */
	public void setCstmsPolCd(String cstmsPolCd) {
		this.cstmsPolCd = cstmsPolCd;
	}
	
	/**
	 * 
	 * @return String cstmsPolCd
	 */
	public String getCstmsPolCd() {
		return this.cstmsPolCd;
	}
	
	/**
	 *
	 * @param String cstmsPodCd
	 */
	public void setCstmsPodCd(String cstmsPodCd) {
		this.cstmsPodCd = cstmsPodCd;
	}
	
	/**
	 * 
	 * @return String cstmsPodCd
	 */
	public String getCstmsPodCd() {
		return this.cstmsPodCd;
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
	 *
	 * @param String shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	
	/**
	 * 
	 * @return String shipper
	 */
	public String getShipper() {
		return this.shipper;
	}
	
	/**
	 *
	 * @param String consignee
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	/**
	 * 
	 * @return String consignee
	 */
	public String getConsignee() {
		return this.consignee;
	}
	
	/**
	 *
	 * @param String cstmsAckProcRsltCd
	 */
	public void setCstmsAckProcRsltCd(String cstmsAckProcRsltCd) {
		this.cstmsAckProcRsltCd = cstmsAckProcRsltCd;
	}
	
	/**
	 * 
	 * @return String cstmsAckProcRsltCd
	 */
	public String getCstmsAckProcRsltCd() {
		return this.cstmsAckProcRsltCd;
	}
	
	/**
	 *
	 * @param String reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * 
	 * @return String reason
	 */
	public String getReason() {
		return this.reason;
	}
	
	/**
	 *
	 * @param String cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 
	 * @return String cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @param String lastAck
	 */
	public void setLastAck(String lastAck) {
		this.lastAck = lastAck;
	}
	
	/**
	 * 
	 * @return String lastAck
	 */
	public String getLastAck() {
		return this.lastAck;
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
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCstmsPolCd(JSPUtil.getParameter(request, prefix + "cstms_pol_cd", ""));
		setCstmsPodCd(JSPUtil.getParameter(request, prefix + "cstms_pod_cd", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
		setCstmsAckProcRsltCd(JSPUtil.getParameter(request, prefix + "cstms_ack_proc_rslt_cd", ""));
		setReason(JSPUtil.getParameter(request, prefix + "reason", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setLastAck(JSPUtil.getParameter(request, prefix + "last_ack", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsBlByKeyVO[]
	 */
	public CndCstmsBlByKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsBlByKeyVO[]
	 */
	public CndCstmsBlByKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsBlByKeyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cstmsPolCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pol_cd", length));
			String[] cstmsPodCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pod_cd", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] cstmsAckProcRsltCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_proc_rslt_cd", length));
			String[] reason = (JSPUtil.getParameter(request, prefix	+ "reason", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] lastAck = (JSPUtil.getParameter(request, prefix	+ "last_ack", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsBlByKeyVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (blNo[i] != null) 
					model.setBlNo(blNo[i]);
				if (vslCd[i] != null) 
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null) 
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null) 
					model.setSkdDirCd(skdDirCd[i]);
				if (cstmsPolCd[i] != null) 
					model.setCstmsPolCd(cstmsPolCd[i]);
				if (cstmsPodCd[i] != null) 
					model.setCstmsPodCd(cstmsPodCd[i]);
				if (ofcEngNm[i] != null) 
					model.setOfcEngNm(ofcEngNm[i]);
				if (shipper[i] != null) 
					model.setShipper(shipper[i]);
				if (consignee[i] != null) 
					model.setConsignee(consignee[i]);
				if (cstmsAckProcRsltCd[i] != null) 
					model.setCstmsAckProcRsltCd(cstmsAckProcRsltCd[i]);
				if (reason[i] != null) 
					model.setReason(reason[i]);
				if (cntrNo[i] != null) 
					model.setCntrNo(cntrNo[i]);
				if (vvd[i] != null) 
					model.setVvd(vvd[i]);
				if (lastAck[i] != null) 
					model.setLastAck(lastAck[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsBlByKeyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsBlByKeyVO[]
	 */
	public CndCstmsBlByKeyVO[] getCndCstmsBlByKeyVOs(){
		CndCstmsBlByKeyVO[] vos = (CndCstmsBlByKeyVO[])models.toArray(new CndCstmsBlByKeyVO[models.size()]);
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
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPolCd = this.cstmsPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPodCd = this.cstmsPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckProcRsltCd = this.cstmsAckProcRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reason = this.reason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastAck = this.lastAck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}