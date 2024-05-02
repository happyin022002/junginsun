/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CstmsHoldNtcSendVO.java
*@FileTitle : CstmsHoldNtcSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15  
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

public class CstmsHoldNtcSendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsHoldNtcSendVO> models = new ArrayList<CstmsHoldNtcSendVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podLocName = null;
	/* Column Info */
	private String sndUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndEml = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String irDate = null;
	/* Column Info */
	private String polLocName = null;
	/* Column Info */
	private String consigneeNm = null;
	/* Column Info */
	private String sndUsrNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CstmsHoldNtcSendVO() {}

	public CstmsHoldNtcSendVO(String ibflag, String pagerows, String sndUsrNm, String sndUsrId, String sndEml, String irDate, String polLocName, String podLocName, String shipperNm, String consigneeNm, String polCd, String podCd) {
		this.podCd = podCd;
		this.polCd = polCd;
		this.podLocName = podLocName;
		this.sndUsrId = sndUsrId;
		this.ibflag = ibflag;
		this.sndEml = sndEml;
		this.shipperNm = shipperNm;
		this.irDate = irDate;
		this.polLocName = polLocName;
		this.consigneeNm = consigneeNm;
		this.sndUsrNm = sndUsrNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_loc_name", getPodLocName());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_eml", getSndEml());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("ir_date", getIrDate());
		this.hashColumns.put("pol_loc_name", getPolLocName());
		this.hashColumns.put("consignee_nm", getConsigneeNm());
		this.hashColumns.put("snd_usr_nm", getSndUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_loc_name", "podLocName");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_eml", "sndEml");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("ir_date", "irDate");
		this.hashFields.put("pol_loc_name", "polLocName");
		this.hashFields.put("consignee_nm", "consigneeNm");
		this.hashFields.put("snd_usr_nm", "sndUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return sndEml
	 */
	public String getSndEml() {
		return this.sndEml;
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
	 * @return polLocName
	 */
	public String getPolLocName() {
		return this.polLocName;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param podLocName
	 */
	public void setPodLocName(String podLocName) {
		this.podLocName = podLocName;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param sndEml
	 */
	public void setSndEml(String sndEml) {
		this.sndEml = sndEml;
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
	 * @param polLocName
	 */
	public void setPolLocName(String polLocName) {
		this.polLocName = polLocName;
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
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodLocName(JSPUtil.getParameter(request, prefix + "pod_loc_name", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSndEml(JSPUtil.getParameter(request, prefix + "snd_eml", ""));
		setShipperNm(JSPUtil.getParameter(request, prefix + "shipper_nm", ""));
		setIrDate(JSPUtil.getParameter(request, prefix + "ir_date", ""));
		setPolLocName(JSPUtil.getParameter(request, prefix + "pol_loc_name", ""));
		setConsigneeNm(JSPUtil.getParameter(request, prefix + "consignee_nm", ""));
		setSndUsrNm(JSPUtil.getParameter(request, prefix + "snd_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsHoldNtcSendVO[]
	 */
	public CstmsHoldNtcSendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsHoldNtcSendVO[]
	 */
	public CstmsHoldNtcSendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsHoldNtcSendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podLocName = (JSPUtil.getParameter(request, prefix	+ "pod_loc_name", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndEml = (JSPUtil.getParameter(request, prefix	+ "snd_eml", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] irDate = (JSPUtil.getParameter(request, prefix	+ "ir_date", length));
			String[] polLocName = (JSPUtil.getParameter(request, prefix	+ "pol_loc_name", length));
			String[] consigneeNm = (JSPUtil.getParameter(request, prefix	+ "consignee_nm", length));
			String[] sndUsrNm = (JSPUtil.getParameter(request, prefix	+ "snd_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsHoldNtcSendVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podLocName[i] != null)
					model.setPodLocName(podLocName[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndEml[i] != null)
					model.setSndEml(sndEml[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (irDate[i] != null)
					model.setIrDate(irDate[i]);
				if (polLocName[i] != null)
					model.setPolLocName(polLocName[i]);
				if (consigneeNm[i] != null)
					model.setConsigneeNm(consigneeNm[i]);
				if (sndUsrNm[i] != null)
					model.setSndUsrNm(sndUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsHoldNtcSendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsHoldNtcSendVO[]
	 */
	public CstmsHoldNtcSendVO[] getCstmsHoldNtcSendVOs(){
		CstmsHoldNtcSendVO[] vos = (CstmsHoldNtcSendVO[])models.toArray(new CstmsHoldNtcSendVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLocName = this.podLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndEml = this.sndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDate = this.irDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocName = this.polLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consigneeNm = this.consigneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrNm = this.sndUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
