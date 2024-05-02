/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EuDoRcvrInfoVO.java
*@FileTitle : EuDoRcvrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EuDoRcvrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EuDoRcvrInfoVO> models = new ArrayList<EuDoRcvrInfoVO>();
	
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String ntcViaCd = null;
	/* Column Info */
	private String ntcEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrOfcCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rcvrPhnNo = null;
	/* Column Info */
	private String ntcFaxNo = null;
	/* Column Info */
	private String rcvrNm = null;
	/* Column Info */
	private String doNoSplit = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EuDoRcvrInfoVO() {}

	public EuDoRcvrInfoVO(String ibflag, String pagerows, String doNo, String doNoSplit, String ntcViaCd, String rcvrNm, String rcvrPhnNo, String ntcFaxNo, String ntcEml, String usrId, String usrOfcCd) {
		this.doNo = doNo;
		this.ntcViaCd = ntcViaCd;
		this.ntcEml = ntcEml;
		this.ibflag = ibflag;
		this.usrOfcCd = usrOfcCd;
		this.usrId = usrId;
		this.rcvrPhnNo = rcvrPhnNo;
		this.ntcFaxNo = ntcFaxNo;
		this.rcvrNm = rcvrNm;
		this.doNoSplit = doNoSplit;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("ntc_via_cd", getNtcViaCd());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_ofc_cd", getUsrOfcCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rcvr_phn_no", getRcvrPhnNo());
		this.hashColumns.put("ntc_fax_no", getNtcFaxNo());
		this.hashColumns.put("rcvr_nm", getRcvrNm());
		this.hashColumns.put("do_no_split", getDoNoSplit());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("ntc_via_cd", "ntcViaCd");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_ofc_cd", "usrOfcCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rcvr_phn_no", "rcvrPhnNo");
		this.hashFields.put("ntc_fax_no", "ntcFaxNo");
		this.hashFields.put("rcvr_nm", "rcvrNm");
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return ntcViaCd
	 */
	public String getNtcViaCd() {
		return this.ntcViaCd;
	}
	
	/**
	 * Column Info
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
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
	 * @return usrOfcCd
	 */
	public String getUsrOfcCd() {
		return this.usrOfcCd;
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
	 * @return rcvrPhnNo
	 */
	public String getRcvrPhnNo() {
		return this.rcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return ntcFaxNo
	 */
	public String getNtcFaxNo() {
		return this.ntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return rcvrNm
	 */
	public String getRcvrNm() {
		return this.rcvrNm;
	}
	
	/**
	 * Column Info
	 * @return doNoSplit
	 */
	public String getDoNoSplit() {
		return this.doNoSplit;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param ntcViaCd
	 */
	public void setNtcViaCd(String ntcViaCd) {
		this.ntcViaCd = ntcViaCd;
	}
	
	/**
	 * Column Info
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
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
	 * @param usrOfcCd
	 */
	public void setUsrOfcCd(String usrOfcCd) {
		this.usrOfcCd = usrOfcCd;
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
	 * @param rcvrPhnNo
	 */
	public void setRcvrPhnNo(String rcvrPhnNo) {
		this.rcvrPhnNo = rcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param ntcFaxNo
	 */
	public void setNtcFaxNo(String ntcFaxNo) {
		this.ntcFaxNo = ntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param rcvrNm
	 */
	public void setRcvrNm(String rcvrNm) {
		this.rcvrNm = rcvrNm;
	}
	
	/**
	 * Column Info
	 * @param doNoSplit
	 */
	public void setDoNoSplit(String doNoSplit) {
		this.doNoSplit = doNoSplit;
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
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setNtcViaCd(JSPUtil.getParameter(request, "ntc_via_cd", ""));
		setNtcEml(JSPUtil.getParameter(request, "ntc_eml", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrOfcCd(JSPUtil.getParameter(request, "usr_ofc_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setRcvrPhnNo(JSPUtil.getParameter(request, "rcvr_phn_no", ""));
		setNtcFaxNo(JSPUtil.getParameter(request, "ntc_fax_no", ""));
		setRcvrNm(JSPUtil.getParameter(request, "rcvr_nm", ""));
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EuDoRcvrInfoVO[]
	 */
	public EuDoRcvrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EuDoRcvrInfoVO[]
	 */
	public EuDoRcvrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EuDoRcvrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] ntcViaCd = (JSPUtil.getParameter(request, prefix	+ "ntc_via_cd", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrOfcCd = (JSPUtil.getParameter(request, prefix	+ "usr_ofc_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rcvrPhnNo = (JSPUtil.getParameter(request, prefix	+ "rcvr_phn_no", length));
			String[] ntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_no", length));
			String[] rcvrNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_nm", length));
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EuDoRcvrInfoVO();
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (ntcViaCd[i] != null)
					model.setNtcViaCd(ntcViaCd[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrOfcCd[i] != null)
					model.setUsrOfcCd(usrOfcCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rcvrPhnNo[i] != null)
					model.setRcvrPhnNo(rcvrPhnNo[i]);
				if (ntcFaxNo[i] != null)
					model.setNtcFaxNo(ntcFaxNo[i]);
				if (rcvrNm[i] != null)
					model.setRcvrNm(rcvrNm[i]);
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEuDoRcvrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EuDoRcvrInfoVO[]
	 */
	public EuDoRcvrInfoVO[] getEuDoRcvrInfoVOs(){
		EuDoRcvrInfoVO[] vos = (EuDoRcvrInfoVO[])models.toArray(new EuDoRcvrInfoVO[models.size()]);
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
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcViaCd = this.ntcViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfcCd = this.usrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrPhnNo = this.rcvrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNo = this.ntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrNm = this.rcvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNoSplit = this.doNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
