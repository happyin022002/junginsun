/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgBlIssRqstMailSndVO.java
*@FileTitle : BkgBlIssRqstMailSndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.28
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.28 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgBlIssRqstMailSndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgBlIssRqstMailSndVO> models = new ArrayList<BkgBlIssRqstMailSndVO>();
	
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String usr_nm = null; //발신자이름
	/* Column Info */
	private String emlTitNm= null;
	/* Column Info */
	private String rcvrNm= null; //수신자이름
	/* Column Info */
	private String rcvrEml= null; //수신자메일주소
	/* Column Info */
	private String ccRcvrEml= null;
	/* Column Info */
	private String sndDt= null;

	/* Page Number */
	private String pagerows = null;

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgBlIssRqstMailSndVO() {}

	public BkgBlIssRqstMailSndVO(String ibflag, String pagerows, String blNo, String usr_nm, String emlTitNm, String rcvrNm, String rcvrEml, String ccRcvrEml, String sndDt) {

		this.blNo = blNo;
		this.usr_nm = usr_nm;
		this.emlTitNm = emlTitNm;
		this.rcvrNm = rcvrNm;
		this.rcvrEml = rcvrEml;
		this.ccRcvrEml = ccRcvrEml;
		this.sndDt = sndDt;
		
		this.pagerows = pagerows;
		this.ibflag = ibflag;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("usr_nm", getUsr_nm());
		this.hashColumns.put("eml_tit_nm", getEmlTitNm());
		this.hashColumns.put("rcvr_nm", getRcvrNm());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("cc_rcvr_eml", getCcRcvrEml());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("usr_nm", "usr_nm");
		this.hashFields.put("eml_tit_nm", "emlTitNm");
		this.hashFields.put("rcvr_nm", "rcvrNm");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("cc_rcvr_eml", "ccRcvrEml");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}

	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	

	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * @return the usr_nm
	 */
	public String getUsr_nm() {
		return usr_nm;
	}

	/**
	 * @param usr_nm the usr_nm to set
	 */
	public void setUsr_nm(String usr_nm) {
		this.usr_nm = usr_nm;
	}

	/**
	 * @return the emlTitNm
	 */
	public String getEmlTitNm() {
		return emlTitNm;
	}

	/**
	 * @param emlTitNm the emlTitNm to set
	 */
	public void setEmlTitNm(String emlTitNm) {
		this.emlTitNm = emlTitNm;
	}

	/**
	 * @return the rcvrNm
	 */
	public String getRcvrNm() {
		return rcvrNm;
	}

	/**
	 * @param rcvrNm the rcvrNm to set
	 */
	public void setRcvrNm(String rcvrNm) {
		this.rcvrNm = rcvrNm;
	}

	/**
	 * @return the rcvrEml
	 */
	public String getRcvrEml() {
		return rcvrEml;
	}

	/**
	 * @param rcvrEml the rcvrEml to set
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
	}

	/**
	 * @return the ccRcvrEml
	 */
	public String getCcRcvrEml() {
		return ccRcvrEml;
	}

	/**
	 * @param ccRcvrEml the ccRcvrEml to set
	 */
	public void setCcRcvrEml(String ccRcvrEml) {
		this.ccRcvrEml = ccRcvrEml;
	}

	/**
	 * @return the sndDt
	 */
	public String getSndDt() {
		return sndDt;
	}

	/**
	 * @param sndDt the sndDt to set
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setUsr_nm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setEmlTitNm(JSPUtil.getParameter(request, prefix + "eml_tit_nm", ""));
		setRcvrNm(JSPUtil.getParameter(request, prefix + "rcvr_nm", ""));
		setRcvrEml(JSPUtil.getParameter(request, prefix + "rcvr_eml", ""));
		setCcRcvrEml(JSPUtil.getParameter(request, prefix + "cc_rcvr_eml", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgBlIssRqstMailSndVO[]
	 */
	public BkgBlIssRqstMailSndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgBlIssRqstMailSndVO[]
	 */
	public BkgBlIssRqstMailSndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgBlIssRqstMailSndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] usr_nm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] emlTitNm = (JSPUtil.getParameter(request, prefix	+ "eml_tit_nm", length));
			String[] rcvrNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_nm", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] ccRcvrEml = (JSPUtil.getParameter(request, prefix	+ "cc_rcvr_eml", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgBlIssRqstMailSndVO();

				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (usr_nm[i] != null)
					model.setUsr_nm(usr_nm[i]);
				if (emlTitNm[i] != null)
					model.setEmlTitNm(emlTitNm[i]);
				if (rcvrNm[i] != null)
					model.setRcvrNm(rcvrNm[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (ccRcvrEml[i] != null)
					model.setCcRcvrEml(ccRcvrEml[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgBlIssRqstMailSndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgBlIssRqstMailSndVO[]
	 */
	public BkgBlIssRqstMailSndVO[] getBkgBlIssRqstMailSndVOs(){
		BkgBlIssRqstMailSndVO[] vos = (BkgBlIssRqstMailSndVO[])models.toArray(new BkgBlIssRqstMailSndVO[models.size()]);
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
		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usr_nm = this.usr_nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlTitNm = this.emlTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrNm = this.rcvrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccRcvrEml = this.ccRcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
