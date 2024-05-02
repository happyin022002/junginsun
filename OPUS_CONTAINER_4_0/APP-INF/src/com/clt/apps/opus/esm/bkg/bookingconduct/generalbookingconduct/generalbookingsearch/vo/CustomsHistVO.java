/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomsHistVO.java
*@FileTitle : CustomsHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.03.09 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomsHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomsHistVO> models = new ArrayList<CustomsHistVO>();
	
	/* Column Info */
	private String ofcNm = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String custStatusNm = null;
	/* Column Info */
	private String portNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gmtDt = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String custStatus = null;
	/* Column Info */
	private String bySeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomsHistVO() {}

	public CustomsHistVO(String ibflag, String pagerows, String port, String portNm, String bySeq, String custStatus, String custStatusNm, String mfSndDt, String gmtDt, String creUsrId, String ofcNm) {
		this.ofcNm = ofcNm;
		this.port = port;
		this.creUsrId = creUsrId;
		this.custStatusNm = custStatusNm;
		this.portNm = portNm;
		this.ibflag = ibflag;
		this.gmtDt = gmtDt;
		this.mfSndDt = mfSndDt;
		this.custStatus = custStatus;
		this.bySeq = bySeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_nm", getOfcNm());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cust_status_nm", getCustStatusNm());
		this.hashColumns.put("port_nm", getPortNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gmt_dt", getGmtDt());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("cust_status", getCustStatus());
		this.hashColumns.put("by_seq", getBySeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_nm", "ofcNm");
		this.hashFields.put("port", "port");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cust_status_nm", "custStatusNm");
		this.hashFields.put("port_nm", "portNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gmt_dt", "gmtDt");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("cust_status", "custStatus");
		this.hashFields.put("by_seq", "bySeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcNm
	 */
	public String getOfcNm() {
		return this.ofcNm;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return custStatusNm
	 */
	public String getCustStatusNm() {
		return this.custStatusNm;
	}
	
	/**
	 * Column Info
	 * @return portNm
	 */
	public String getPortNm() {
		return this.portNm;
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
	 * @return gmtDt
	 */
	public String getGmtDt() {
		return this.gmtDt;
	}
	
	/**
	 * Column Info
	 * @return mfSndDt
	 */
	public String getMfSndDt() {
		return this.mfSndDt;
	}
	
	/**
	 * Column Info
	 * @return custStatus
	 */
	public String getCustStatus() {
		return this.custStatus;
	}
	
	/**
	 * Column Info
	 * @return bySeq
	 */
	public String getBySeq() {
		return this.bySeq;
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
	 * @param ofcNm
	 */
	public void setOfcNm(String ofcNm) {
		this.ofcNm = ofcNm;
	}
	
	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param custStatusNm
	 */
	public void setCustStatusNm(String custStatusNm) {
		this.custStatusNm = custStatusNm;
	}
	
	/**
	 * Column Info
	 * @param portNm
	 */
	public void setPortNm(String portNm) {
		this.portNm = portNm;
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
	 * @param gmtDt
	 */
	public void setGmtDt(String gmtDt) {
		this.gmtDt = gmtDt;
	}
	
	/**
	 * Column Info
	 * @param mfSndDt
	 */
	public void setMfSndDt(String mfSndDt) {
		this.mfSndDt = mfSndDt;
	}
	
	/**
	 * Column Info
	 * @param custStatus
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	
	/**
	 * Column Info
	 * @param bySeq
	 */
	public void setBySeq(String bySeq) {
		this.bySeq = bySeq;
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
		setOfcNm(JSPUtil.getParameter(request, prefix + "ofc_nm", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCustStatusNm(JSPUtil.getParameter(request, prefix + "cust_status_nm", ""));
		setPortNm(JSPUtil.getParameter(request, prefix + "port_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGmtDt(JSPUtil.getParameter(request, prefix + "gmt_dt", ""));
		setMfSndDt(JSPUtil.getParameter(request, prefix + "mf_snd_dt", ""));
		setCustStatus(JSPUtil.getParameter(request, prefix + "cust_status", ""));
		setBySeq(JSPUtil.getParameter(request, prefix + "by_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomsHistVO[]
	 */
	public CustomsHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomsHistVO[]
	 */
	public CustomsHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomsHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcNm = (JSPUtil.getParameter(request, prefix	+ "ofc_nm", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] custStatusNm = (JSPUtil.getParameter(request, prefix	+ "cust_status_nm", length));
			String[] portNm = (JSPUtil.getParameter(request, prefix	+ "port_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gmtDt = (JSPUtil.getParameter(request, prefix	+ "gmt_dt", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] custStatus = (JSPUtil.getParameter(request, prefix	+ "cust_status", length));
			String[] bySeq = (JSPUtil.getParameter(request, prefix	+ "by_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomsHistVO();
				if (ofcNm[i] != null)
					model.setOfcNm(ofcNm[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (custStatusNm[i] != null)
					model.setCustStatusNm(custStatusNm[i]);
				if (portNm[i] != null)
					model.setPortNm(portNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gmtDt[i] != null)
					model.setGmtDt(gmtDt[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (custStatus[i] != null)
					model.setCustStatus(custStatus[i]);
				if (bySeq[i] != null)
					model.setBySeq(bySeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomsHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomsHistVO[]
	 */
	public CustomsHistVO[] getCustomsHistVOs(){
		CustomsHistVO[] vos = (CustomsHistVO[])models.toArray(new CustomsHistVO[models.size()]);
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
		this.ofcNm = this.ofcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStatusNm = this.custStatusNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNm = this.portNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gmtDt = this.gmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStatus = this.custStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bySeq = this.bySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
