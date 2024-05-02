/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EuDoNtcSendVO.java
*@FileTitle : EuDoNtcSendVO
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

public class EuDoNtcSendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EuDoNtcSendVO> models = new ArrayList<EuDoNtcSendVO>();
	
	/* Column Info */
	private String doNoSplit = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String ntcViaCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sndId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String lclFlg = null;
	/* Column Info */
	private String ntcFaxNo = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String mrdId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EuDoNtcSendVO() {}

	public EuDoNtcSendVO(String ibflag, String pagerows, String doNo, String doNoSplit, String mrdId, String ntcEml, String ntcFaxNo, String usrEml, String usrNm, String usrId, String lclFlg, String bkgNo, String ofcCd, String ntcViaCd, String creUsrId, String updUsrId, String sndId, String blNo, String custNm) {
		this.doNoSplit = doNoSplit;
		this.pagerows = pagerows;
		this.doNo = doNo;
		this.ntcViaCd = ntcViaCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ntcEml = ntcEml;
		this.bkgNo = bkgNo;
		this.blNo = blNo;
		this.sndId = sndId;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.lclFlg = lclFlg;
		this.ntcFaxNo = ntcFaxNo;
		this.usrEml = usrEml;
		this.mrdId = mrdId;
		this.updUsrId = updUsrId;
		this.custNm = custNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no_split", getDoNoSplit());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("ntc_via_cd", getNtcViaCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("snd_id", getSndId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("lcl_flg", getLclFlg());
		this.hashColumns.put("ntc_fax_no", getNtcFaxNo());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("mrd_id", getMrdId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_nm", getCustNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_no_split", "doNoSplit");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("ntc_via_cd", "ntcViaCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("snd_id", "sndId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("lcl_flg", "lclFlg");
		this.hashFields.put("ntc_fax_no", "ntcFaxNo");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("mrd_id", "mrdId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_nm", "custNm");
		return this.hashFields;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return sndId
	 */
	public String getSndId() {
		return this.sndId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return lclFlg
	 */
	public String getLclFlg() {
		return this.lclFlg;
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
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return mrdId
	 */
	public String getMrdId() {
		return this.mrdId;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param sndId
	 */
	public void setSndId(String sndId) {
		this.sndId = sndId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param lclFlg
	 */
	public void setLclFlg(String lclFlg) {
		this.lclFlg = lclFlg;
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
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	/**
	 * Column Info
	 * @param mrdId
	 */
	public void setMrdId(String mrdId) {
		this.mrdId = mrdId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDoNoSplit(JSPUtil.getParameter(request, "do_no_split", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setNtcViaCd(JSPUtil.getParameter(request, "ntc_via_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNtcEml(JSPUtil.getParameter(request, "ntc_eml", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSndId(JSPUtil.getParameter(request, "snd_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setLclFlg(JSPUtil.getParameter(request, "lcl_flg", ""));
		setNtcFaxNo(JSPUtil.getParameter(request, "ntc_fax_no", ""));
		setUsrEml(JSPUtil.getParameter(request, "usr_eml", ""));
		setMrdId(JSPUtil.getParameter(request, "mrd_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EuDoNtcSendVO[]
	 */
	public EuDoNtcSendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EuDoNtcSendVO[]
	 */
	public EuDoNtcSendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EuDoNtcSendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doNoSplit = (JSPUtil.getParameter(request, prefix	+ "do_no_split", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] ntcViaCd = (JSPUtil.getParameter(request, prefix	+ "ntc_via_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sndId = (JSPUtil.getParameter(request, prefix	+ "snd_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] lclFlg = (JSPUtil.getParameter(request, prefix	+ "lcl_flg", length));
			String[] ntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_no", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] mrdId = (JSPUtil.getParameter(request, prefix	+ "mrd_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new EuDoNtcSendVO();
				if (doNoSplit[i] != null)
					model.setDoNoSplit(doNoSplit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (ntcViaCd[i] != null)
					model.setNtcViaCd(ntcViaCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sndId[i] != null)
					model.setSndId(sndId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (lclFlg[i] != null)
					model.setLclFlg(lclFlg[i]);
				if (ntcFaxNo[i] != null)
					model.setNtcFaxNo(ntcFaxNo[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (mrdId[i] != null)
					model.setMrdId(mrdId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEuDoNtcSendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EuDoNtcSendVO[]
	 */
	public EuDoNtcSendVO[] getEuDoNtcSendVOs(){
		EuDoNtcSendVO[] vos = (EuDoNtcSendVO[])models.toArray(new EuDoNtcSendVO[models.size()]);
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
		this.doNoSplit = this.doNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcViaCd = this.ntcViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndId = this.sndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclFlg = this.lclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNo = this.ntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrdId = this.mrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
