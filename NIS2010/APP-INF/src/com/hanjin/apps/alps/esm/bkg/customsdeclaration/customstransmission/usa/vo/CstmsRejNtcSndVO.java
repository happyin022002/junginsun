/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CstmsRejNtcSndVO.java
*@FileTitle : CstmsRejNtcSndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.lang.reflect.Field;
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

public class CstmsRejNtcSndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsRejNtcSndVO> models = new ArrayList<CstmsRejNtcSndVO>();
	
	/* Column Info */
	private String staffId = null;
	/* Column Info */
	private String polLocName = null;
	/* Column Info */
	private String sndUsrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String podLocName = null;
	/* Column Info */
	private String sndEml = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String irDate = null;
	/* Column Info */
	private String consigneeNm = null;
	/* Column Info */
	private String staffSndEml = null;
	/* Column Info */
	private String staffUsrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CstmsRejNtcSndVO() {}

	public CstmsRejNtcSndVO(String ibflag, String pagerows, String sndUsrId, String sndEml, String sndUsrNm, String staffId, String staffSndEml, String staffUsrNm, String podCd, String irDate, String trsmMsgTpId, String polLocName, String podLocName, String shipperNm, String consigneeNm) {
		this.staffId = staffId;
		this.polLocName = polLocName;
		this.sndUsrNm = sndUsrNm;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.sndUsrId = sndUsrId;
		this.podLocName = podLocName;
		this.sndEml = sndEml;
		this.trsmMsgTpId = trsmMsgTpId;
		this.shipperNm = shipperNm;
		this.irDate = irDate;
		this.consigneeNm = consigneeNm;
		this.staffSndEml = staffSndEml;
		this.staffUsrNm = staffUsrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("staff_id", getStaffId());
		this.hashColumns.put("pol_loc_name", getPolLocName());
		this.hashColumns.put("snd_usr_nm", getSndUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("pod_loc_name", getPodLocName());
		this.hashColumns.put("snd_eml", getSndEml());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("ir_date", getIrDate());
		this.hashColumns.put("consignee_nm", getConsigneeNm());
		this.hashColumns.put("staff_snd_eml", getStaffSndEml());
		this.hashColumns.put("staff_usr_nm", getStaffUsrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("staff_id", "staffId");
		this.hashFields.put("pol_loc_name", "polLocName");
		this.hashFields.put("snd_usr_nm", "sndUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("pod_loc_name", "podLocName");
		this.hashFields.put("snd_eml", "sndEml");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("ir_date", "irDate");
		this.hashFields.put("consignee_nm", "consigneeNm");
		this.hashFields.put("staff_snd_eml", "staffSndEml");
		this.hashFields.put("staff_usr_nm", "staffUsrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return staffId
	 */
	public String getStaffId() {
		return this.staffId;
	}
	
	/**
	 * Column Info
	 * @return polLocName
	 */
	public String getPolLocName() {
		return this.polLocName;
	}
	
	/**
	 * Column Info
	 * @return sndUsrNm
	 */
	public String getSndUsrNm() {
		return this.sndUsrNm;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return podLocName
	 */
	public String getPodLocName() {
		return this.podLocName;
	}
	
	/**
	 * Column Info
	 * @return sndEml
	 */
	public String getSndEml() {
		return this.sndEml;
	}
	
	/**
	 * Column Info
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
	}
	
	/**
	 * Column Info
	 * @return irDate
	 */
	public String getIrDate() {
		return this.irDate;
	}
	
	/**
	 * Column Info
	 * @return consigneeNm
	 */
	public String getConsigneeNm() {
		return this.consigneeNm;
	}
	
	/**
	 * Column Info
	 * @return staffSndEml
	 */
	public String getStaffSndEml() {
		return this.staffSndEml;
	}
	
	/**
	 * Column Info
	 * @return staffUsrNm
	 */
	public String getStaffUsrNm() {
		return this.staffUsrNm;
	}
	

	/**
	 * Column Info
	 * @param staffId
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	/**
	 * Column Info
	 * @param polLocName
	 */
	public void setPolLocName(String polLocName) {
		this.polLocName = polLocName;
	}
	
	/**
	 * Column Info
	 * @param sndUsrNm
	 */
	public void setSndUsrNm(String sndUsrNm) {
		this.sndUsrNm = sndUsrNm;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param podLocName
	 */
	public void setPodLocName(String podLocName) {
		this.podLocName = podLocName;
	}
	
	/**
	 * Column Info
	 * @param sndEml
	 */
	public void setSndEml(String sndEml) {
		this.sndEml = sndEml;
	}
	
	/**
	 * Column Info
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
	}
	
	/**
	 * Column Info
	 * @param irDate
	 */
	public void setIrDate(String irDate) {
		this.irDate = irDate;
	}
	
	/**
	 * Column Info
	 * @param consigneeNm
	 */
	public void setConsigneeNm(String consigneeNm) {
		this.consigneeNm = consigneeNm;
	}
	
	/**
	 * Column Info
	 * @param staffSndEml
	 */
	public void setStaffSndEml(String staffSndEml) {
		this.staffSndEml = staffSndEml;
	}
	
	/**
	 * Column Info
	 * @param staffUsrNm
	 */
	public void setStaffUsrNm(String staffUsrNm) {
		this.staffUsrNm = staffUsrNm;
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
		setStaffId(JSPUtil.getParameter(request, prefix + "staff_id", ""));
		setPolLocName(JSPUtil.getParameter(request, prefix + "pol_loc_name", ""));
		setSndUsrNm(JSPUtil.getParameter(request, prefix + "snd_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setPodLocName(JSPUtil.getParameter(request, prefix + "pod_loc_name", ""));
		setSndEml(JSPUtil.getParameter(request, prefix + "snd_eml", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, prefix + "trsm_msg_tp_id", ""));
		setShipperNm(JSPUtil.getParameter(request, prefix + "shipper_nm", ""));
		setIrDate(JSPUtil.getParameter(request, prefix + "ir_date", ""));
		setConsigneeNm(JSPUtil.getParameter(request, prefix + "consignee_nm", ""));
		setStaffSndEml(JSPUtil.getParameter(request, prefix + "staff_snd_eml", ""));
		setStaffUsrNm(JSPUtil.getParameter(request, prefix + "staff_usr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsRejNtcSndVO[]
	 */
	public CstmsRejNtcSndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsRejNtcSndVO[]
	 */
	public CstmsRejNtcSndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsRejNtcSndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] staffId = (JSPUtil.getParameter(request, prefix	+ "staff_id", length));
			String[] polLocName = (JSPUtil.getParameter(request, prefix	+ "pol_loc_name", length));
			String[] sndUsrNm = (JSPUtil.getParameter(request, prefix	+ "snd_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] podLocName = (JSPUtil.getParameter(request, prefix	+ "pod_loc_name", length));
			String[] sndEml = (JSPUtil.getParameter(request, prefix	+ "snd_eml", length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] irDate = (JSPUtil.getParameter(request, prefix	+ "ir_date", length));
			String[] consigneeNm = (JSPUtil.getParameter(request, prefix	+ "consignee_nm", length));
			String[] staffSndEml = (JSPUtil.getParameter(request, prefix	+ "staff_snd_eml", length));
			String[] staffUsrNm = (JSPUtil.getParameter(request, prefix	+ "staff_usr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsRejNtcSndVO();
				if (staffId[i] != null)
					model.setStaffId(staffId[i]);
				if (polLocName[i] != null)
					model.setPolLocName(polLocName[i]);
				if (sndUsrNm[i] != null)
					model.setSndUsrNm(sndUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (podLocName[i] != null)
					model.setPodLocName(podLocName[i]);
				if (sndEml[i] != null)
					model.setSndEml(sndEml[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (irDate[i] != null)
					model.setIrDate(irDate[i]);
				if (consigneeNm[i] != null)
					model.setConsigneeNm(consigneeNm[i]);
				if (staffSndEml[i] != null)
					model.setStaffSndEml(staffSndEml[i]);
				if (staffUsrNm[i] != null)
					model.setStaffUsrNm(staffUsrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsRejNtcSndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsRejNtcSndVO[]
	 */
	public CstmsRejNtcSndVO[] getCstmsRejNtcSndVOs(){
		CstmsRejNtcSndVO[] vos = (CstmsRejNtcSndVO[])models.toArray(new CstmsRejNtcSndVO[models.size()]);
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
		this.staffId = this.staffId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocName = this.polLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrNm = this.sndUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocName = this.podLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndEml = this.sndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDate = this.irDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeNm = this.consigneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.staffSndEml = this.staffSndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.staffUsrNm = this.staffUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
