/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DepartureTimeVO.java
*@FileTitle : DepartureTimeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.03  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo;

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

public class DepartureTimeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DepartureTimeVO> models = new ArrayList<DepartureTimeVO>();
	
	/* Column Info */
	private String rlxDiv = null;
	/* Column Info */
	private String ibCssmVoyNo = null;
	/* Column Info */
	private String polSplitNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String etdDate = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String sendDiv = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String etdTime = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DepartureTimeVO() {}

	public DepartureTimeVO(String ibflag, String pagerows, String sendDiv, String vvd, String polCd, String polSplitNo, String etdDate, String etdTime, String ibCssmVoyNo, String rlxDiv, String cntCd, String ofcCd, String usrEml, String usrId) {
		this.rlxDiv = rlxDiv;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.polSplitNo = polSplitNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.etdDate = etdDate;
		this.usrId = usrId;
		this.cntCd = cntCd;
		this.sendDiv = sendDiv;
		this.usrEml = usrEml;
		this.etdTime = etdTime;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlx_div", getRlxDiv());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("pol_split_no", getPolSplitNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("etd_date", getEtdDate());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("send_div", getSendDiv());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("etd_time", getEtdTime());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlx_div", "rlxDiv");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("pol_split_no", "polSplitNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("etd_date", "etdDate");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("send_div", "sendDiv");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("etd_time", "etdTime");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rlxDiv
	 */
	public String getRlxDiv() {
		return this.rlxDiv;
	}
	
	/**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
	public String getIbCssmVoyNo() {
		return this.ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return polSplitNo
	 */
	public String getPolSplitNo() {
		return this.polSplitNo;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return etdDate
	 */
	public String getEtdDate() {
		return this.etdDate;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return sendDiv
	 */
	public String getSendDiv() {
		return this.sendDiv;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return etdTime
	 */
	public String getEtdTime() {
		return this.etdTime;
	}
	

	/**
	 * Column Info
	 * @param rlxDiv
	 */
	public void setRlxDiv(String rlxDiv) {
		this.rlxDiv = rlxDiv;
	}
	
	/**
	 * Column Info
	 * @param ibCssmVoyNo
	 */
	public void setIbCssmVoyNo(String ibCssmVoyNo) {
		this.ibCssmVoyNo = ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param polSplitNo
	 */
	public void setPolSplitNo(String polSplitNo) {
		this.polSplitNo = polSplitNo;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param etdDate
	 */
	public void setEtdDate(String etdDate) {
		this.etdDate = etdDate;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param sendDiv
	 */
	public void setSendDiv(String sendDiv) {
		this.sendDiv = sendDiv;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param etdTime
	 */
	public void setEtdTime(String etdTime) {
		this.etdTime = etdTime;
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
		setRlxDiv(JSPUtil.getParameter(request, prefix + "rlx_div", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
		setPolSplitNo(JSPUtil.getParameter(request, prefix + "pol_split_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setEtdDate(JSPUtil.getParameter(request, prefix + "etd_date", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setSendDiv(JSPUtil.getParameter(request, prefix + "send_div", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setEtdTime(JSPUtil.getParameter(request, prefix + "etd_time", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DepartureTimeVO[]
	 */
	public DepartureTimeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DepartureTimeVO[]
	 */
	public DepartureTimeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DepartureTimeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlxDiv = (JSPUtil.getParameter(request, prefix	+ "rlx_div", length));
			String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no", length));
			String[] polSplitNo = (JSPUtil.getParameter(request, prefix	+ "pol_split_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] etdDate = (JSPUtil.getParameter(request, prefix	+ "etd_date", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] sendDiv = (JSPUtil.getParameter(request, prefix	+ "send_div", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] etdTime = (JSPUtil.getParameter(request, prefix	+ "etd_time", length));
			
			for (int i = 0; i < length; i++) {
				model = new DepartureTimeVO();
				if (rlxDiv[i] != null)
					model.setRlxDiv(rlxDiv[i]);
				if (ibCssmVoyNo[i] != null)
					model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (polSplitNo[i] != null)
					model.setPolSplitNo(polSplitNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (etdDate[i] != null)
					model.setEtdDate(etdDate[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (sendDiv[i] != null)
					model.setSendDiv(sendDiv[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (etdTime[i] != null)
					model.setEtdTime(etdTime[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDepartureTimeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DepartureTimeVO[]
	 */
	public DepartureTimeVO[] getDepartureTimeVOs(){
		DepartureTimeVO[] vos = (DepartureTimeVO[])models.toArray(new DepartureTimeVO[models.size()]);
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
		this.rlxDiv = this.rlxDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo = this.ibCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSplitNo = this.polSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDate = this.etdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDiv = this.sendDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdTime = this.etdTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
