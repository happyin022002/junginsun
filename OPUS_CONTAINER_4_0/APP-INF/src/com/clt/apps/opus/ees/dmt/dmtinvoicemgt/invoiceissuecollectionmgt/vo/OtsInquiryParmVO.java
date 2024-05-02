/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OtsInquiryParmVO.java
*@FileTitle : OtsInquiryParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OtsInquiryParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsInquiryParmVO> models = new ArrayList<OtsInquiryParmVO>();
	
	/* Column Info */
	private String frdt = null;
	/* Column Info */
	private String cutp = null;
	/* Column Info */
	private String tinvno = null;
	/* Column Info */
	private String cuno = null;
	/* Column Info */
	private String rfan = null;
	/* Column Info */
	private String todt = null;
	/* Column Info */
	private String arif = null;
	/* Column Info */
	private String scno = null;
	/* Column Info */
	private String creof = null;
	/* Column Info */
	private String payc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrinvno = null;
	/* Column Info */
	private String tftp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payn = null;
	/* Column Info */
	private String tftp2 = null;
	/* Column Info */
	private String sheetp = null;
	/* Column Info */
	private String hRhqOff = null;
	/* Column Info */
	private String hUsrOff = null;
	/* Column Info */
	private String invno = null;
	/* Column Info */
	private String cude = null;
	/* Column Info */
	private String isof = null;
	/* Column Info */
	private String rmrk = null;
	/* Column Info */
	private String tjspno = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtsInquiryParmVO() {}

	public OtsInquiryParmVO(String ibflag, String pagerows, String frdt, String cutp, String tinvno, String cuno, String rfan, String todt, String arif, String scno, String payc, String cntrinvno, String tftp, String hRhqOff, String sheetp, String tftp2, String payn, String hUsrOff, String invno, String cude, String tjspno, String rmrk, String isof, String creof) {
		this.frdt = frdt;
		this.cutp = cutp;
		this.tinvno = tinvno;
		this.cuno = cuno;
		this.rfan = rfan;
		this.todt = todt;
		this.arif = arif;
		this.scno = scno;
		this.creof = creof;
		this.payc = payc;
		this.pagerows = pagerows;
		this.cntrinvno = cntrinvno;
		this.tftp = tftp;
		this.ibflag = ibflag;
		this.payn = payn;
		this.tftp2 = tftp2;
		this.sheetp = sheetp;
		this.hRhqOff = hRhqOff;
		this.hUsrOff = hUsrOff;
		this.invno = invno;
		this.cude = cude;
		this.isof = isof;
		this.rmrk = rmrk;
		this.tjspno = tjspno;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frdt", getFrdt());
		this.hashColumns.put("cutp", getCutp());
		this.hashColumns.put("tinvno", getTinvno());
		this.hashColumns.put("cuno", getCuno());
		this.hashColumns.put("rfan", getRfan());
		this.hashColumns.put("todt", getTodt());
		this.hashColumns.put("arif", getArif());
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("creof", getCreof());
		this.hashColumns.put("payc", getPayc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntrinvno", getCntrinvno());
		this.hashColumns.put("tftp", getTftp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("payn", getPayn());
		this.hashColumns.put("tftp2", getTftp2());
		this.hashColumns.put("sheetp", getSheetp());
		this.hashColumns.put("h_rhq_off", getHRhqOff());
		this.hashColumns.put("h_usr_off", getHUsrOff());
		this.hashColumns.put("invno", getInvno());
		this.hashColumns.put("cude", getCude());
		this.hashColumns.put("isof", getIsof());
		this.hashColumns.put("rmrk", getRmrk());
		this.hashColumns.put("tjspno", getTjspno());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frdt", "frdt");
		this.hashFields.put("cutp", "cutp");
		this.hashFields.put("tinvno", "tinvno");
		this.hashFields.put("cuno", "cuno");
		this.hashFields.put("rfan", "rfan");
		this.hashFields.put("todt", "todt");
		this.hashFields.put("arif", "arif");
		this.hashFields.put("scno", "scno");
		this.hashFields.put("creof", "creof");
		this.hashFields.put("payc", "payc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntrinvno", "cntrinvno");
		this.hashFields.put("tftp", "tftp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("payn", "payn");
		this.hashFields.put("tftp2", "tftp2");
		this.hashFields.put("sheetp", "sheetp");
		this.hashFields.put("h_rhq_off", "hRhqOff");
		this.hashFields.put("h_usr_off", "hUsrOff");
		this.hashFields.put("invno", "invno");
		this.hashFields.put("cude", "cude");
		this.hashFields.put("isof", "isof");
		this.hashFields.put("rmrk", "rmrk");
		this.hashFields.put("tjspno", "tjspno");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frdt
	 */
	public String getFrdt() {
		return this.frdt;
	}
	
	/**
	 * Column Info
	 * @return cutp
	 */
	public String getCutp() {
		return this.cutp;
	}
	
	/**
	 * Column Info
	 * @return tinvno
	 */
	public String getTinvno() {
		return this.tinvno;
	}
	
	/**
	 * Column Info
	 * @return cuno
	 */
	public String getCuno() {
		return this.cuno;
	}
	
	/**
	 * Column Info
	 * @return rfan
	 */
	public String getRfan() {
		return this.rfan;
	}
	
	/**
	 * Column Info
	 * @return todt
	 */
	public String getTodt() {
		return this.todt;
	}
	
	/**
	 * Column Info
	 * @return arif
	 */
	public String getArif() {
		return this.arif;
	}
	
	/**
	 * Column Info
	 * @return scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 * Column Info
	 * @return creof
	 */
	public String getCreof() {
		return this.creof;
	}
	
	/**
	 * Column Info
	 * @return payc
	 */
	public String getPayc() {
		return this.payc;
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
	 * @return cntrinvno
	 */
	public String getCntrinvno() {
		return this.cntrinvno;
	}
	
	/**
	 * Column Info
	 * @return tftp
	 */
	public String getTftp() {
		return this.tftp;
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
	 * @return payn
	 */
	public String getPayn() {
		return this.payn;
	}
	
	/**
	 * Column Info
	 * @return tftp2
	 */
	public String getTftp2() {
		return this.tftp2;
	}
	
	/**
	 * Column Info
	 * @return sheetp
	 */
	public String getSheetp() {
		return this.sheetp;
	}
	
	/**
	 * Column Info
	 * @return hRhqOff
	 */
	public String getHRhqOff() {
		return this.hRhqOff;
	}
	
	/**
	 * Column Info
	 * @return hUsrOff
	 */
	public String getHUsrOff() {
		return this.hUsrOff;
	}
	
	/**
	 * Column Info
	 * @return invno
	 */
	public String getInvno() {
		return this.invno;
	}
	
	/**
	 * Column Info
	 * @return cude
	 */
	public String getCude() {
		return this.cude;
	}
	
	/**
	 * Column Info
	 * @return isof
	 */
	public String getIsof() {
		return this.isof;
	}
	
	/**
	 * Column Info
	 * @return rmrk
	 */
	public String getRmrk() {
		return this.rmrk;
	}
	
	/**
	 * Column Info
	 * @return tjspno
	 */
	public String getTjspno() {
		return this.tjspno;
	}
	

	/**
	 * Column Info
	 * @param frdt
	 */
	public void setFrdt(String frdt) {
		this.frdt = frdt;
	}
	
	/**
	 * Column Info
	 * @param cutp
	 */
	public void setCutp(String cutp) {
		this.cutp = cutp;
	}
	
	/**
	 * Column Info
	 * @param tinvno
	 */
	public void setTinvno(String tinvno) {
		this.tinvno = tinvno;
	}
	
	/**
	 * Column Info
	 * @param cuno
	 */
	public void setCuno(String cuno) {
		this.cuno = cuno;
	}
	
	/**
	 * Column Info
	 * @param rfan
	 */
	public void setRfan(String rfan) {
		this.rfan = rfan;
	}
	
	/**
	 * Column Info
	 * @param todt
	 */
	public void setTodt(String todt) {
		this.todt = todt;
	}
	
	/**
	 * Column Info
	 * @param arif
	 */
	public void setArif(String arif) {
		this.arif = arif;
	}
	
	/**
	 * Column Info
	 * @param scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * Column Info
	 * @param creof
	 */
	public void setCreof(String creof) {
		this.creof = creof;
	}
	
	/**
	 * Column Info
	 * @param payc
	 */
	public void setPayc(String payc) {
		this.payc = payc;
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
	 * @param cntrinvno
	 */
	public void setCntrinvno(String cntrinvno) {
		this.cntrinvno = cntrinvno;
	}
	
	/**
	 * Column Info
	 * @param tftp
	 */
	public void setTftp(String tftp) {
		this.tftp = tftp;
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
	 * @param payn
	 */
	public void setPayn(String payn) {
		this.payn = payn;
	}
	
	/**
	 * Column Info
	 * @param tftp2
	 */
	public void setTftp2(String tftp2) {
		this.tftp2 = tftp2;
	}
	
	/**
	 * Column Info
	 * @param sheetp
	 */
	public void setSheetp(String sheetp) {
		this.sheetp = sheetp;
	}
	
	/**
	 * Column Info
	 * @param hRhqOff
	 */
	public void setHRhqOff(String hRhqOff) {
		this.hRhqOff = hRhqOff;
	}
	
	/**
	 * Column Info
	 * @param hUsrOff
	 */
	public void setHUsrOff(String hUsrOff) {
		this.hUsrOff = hUsrOff;
	}
	
	/**
	 * Column Info
	 * @param invno
	 */
	public void setInvno(String invno) {
		this.invno = invno;
	}
	
	/**
	 * Column Info
	 * @param cude
	 */
	public void setCude(String cude) {
		this.cude = cude;
	}
	
	/**
	 * Column Info
	 * @param isof
	 */
	public void setIsof(String isof) {
		this.isof = isof;
	}
	
	/**
	 * Column Info
	 * @param rmrk
	 */
	public void setRmrk(String rmrk) {
		this.rmrk = rmrk;
	}
	
	/**
	 * Column Info
	 * @param tjspno
	 */
	public void setTjspno(String tjspno) {
		this.tjspno = tjspno;
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
		setFrdt(JSPUtil.getParameter(request, prefix + "frdt", ""));
		setCutp(JSPUtil.getParameter(request, prefix + "cutp", ""));
		setTinvno(JSPUtil.getParameter(request, prefix + "tinvno", ""));
		setCuno(JSPUtil.getParameter(request, prefix + "cuno", ""));
		setRfan(JSPUtil.getParameter(request, prefix + "rfan", ""));
		setTodt(JSPUtil.getParameter(request, prefix + "todt", ""));
		setArif(JSPUtil.getParameter(request, prefix + "arif", ""));
		setScno(JSPUtil.getParameter(request, prefix + "scno", ""));
		setCreof(JSPUtil.getParameter(request, prefix + "creof", ""));
		setPayc(JSPUtil.getParameter(request, prefix + "payc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrinvno(JSPUtil.getParameter(request, prefix + "cntrinvno", ""));
		setTftp(JSPUtil.getParameter(request, prefix + "tftp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPayn(JSPUtil.getParameter(request, prefix + "payn", ""));
		setTftp2(JSPUtil.getParameter(request, prefix + "tftp2", ""));
		setSheetp(JSPUtil.getParameter(request, prefix + "sheetp", ""));
		setHRhqOff(JSPUtil.getParameter(request, prefix + "h_rhq_off", ""));
		setHUsrOff(JSPUtil.getParameter(request, prefix + "h_usr_off", ""));
		setInvno(JSPUtil.getParameter(request, prefix + "invno", ""));
		setCude(JSPUtil.getParameter(request, prefix + "cude", ""));
		setIsof(JSPUtil.getParameter(request, prefix + "isof", ""));
		setRmrk(JSPUtil.getParameter(request, prefix + "rmrk", ""));
		setTjspno(JSPUtil.getParameter(request, prefix + "tjspno", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryParmVO[]
	 */
	public OtsInquiryParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryParmVO[]
	 */
	public OtsInquiryParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsInquiryParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frdt = (JSPUtil.getParameter(request, prefix	+ "frdt", length));
			String[] cutp = (JSPUtil.getParameter(request, prefix	+ "cutp", length));
			String[] tinvno = (JSPUtil.getParameter(request, prefix	+ "tinvno", length));
			String[] cuno = (JSPUtil.getParameter(request, prefix	+ "cuno", length));
			String[] rfan = (JSPUtil.getParameter(request, prefix	+ "rfan", length));
			String[] todt = (JSPUtil.getParameter(request, prefix	+ "todt", length));
			String[] arif = (JSPUtil.getParameter(request, prefix	+ "arif", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] creof = (JSPUtil.getParameter(request, prefix	+ "creof", length));
			String[] payc = (JSPUtil.getParameter(request, prefix	+ "payc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrinvno = (JSPUtil.getParameter(request, prefix	+ "cntrinvno", length));
			String[] tftp = (JSPUtil.getParameter(request, prefix	+ "tftp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payn = (JSPUtil.getParameter(request, prefix	+ "payn", length));
			String[] tftp2 = (JSPUtil.getParameter(request, prefix	+ "tftp2", length));
			String[] sheetp = (JSPUtil.getParameter(request, prefix	+ "sheetp", length));
			String[] hRhqOff = (JSPUtil.getParameter(request, prefix	+ "h_rhq_off", length));
			String[] hUsrOff = (JSPUtil.getParameter(request, prefix	+ "h_usr_off", length));
			String[] invno = (JSPUtil.getParameter(request, prefix	+ "invno", length));
			String[] cude = (JSPUtil.getParameter(request, prefix	+ "cude", length));
			String[] isof = (JSPUtil.getParameter(request, prefix	+ "isof", length));
			String[] rmrk = (JSPUtil.getParameter(request, prefix	+ "rmrk", length));
			String[] tjspno = (JSPUtil.getParameter(request, prefix	+ "tjspno", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsInquiryParmVO();
				if (frdt[i] != null)
					model.setFrdt(frdt[i]);
				if (cutp[i] != null)
					model.setCutp(cutp[i]);
				if (tinvno[i] != null)
					model.setTinvno(tinvno[i]);
				if (cuno[i] != null)
					model.setCuno(cuno[i]);
				if (rfan[i] != null)
					model.setRfan(rfan[i]);
				if (todt[i] != null)
					model.setTodt(todt[i]);
				if (arif[i] != null)
					model.setArif(arif[i]);
				if (scno[i] != null)
					model.setScno(scno[i]);
				if (creof[i] != null)
					model.setCreof(creof[i]);
				if (payc[i] != null)
					model.setPayc(payc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrinvno[i] != null)
					model.setCntrinvno(cntrinvno[i]);
				if (tftp[i] != null)
					model.setTftp(tftp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payn[i] != null)
					model.setPayn(payn[i]);
				if (tftp2[i] != null)
					model.setTftp2(tftp2[i]);
				if (sheetp[i] != null)
					model.setSheetp(sheetp[i]);
				if (hRhqOff[i] != null)
					model.setHRhqOff(hRhqOff[i]);
				if (hUsrOff[i] != null)
					model.setHUsrOff(hUsrOff[i]);
				if (invno[i] != null)
					model.setInvno(invno[i]);
				if (cude[i] != null)
					model.setCude(cude[i]);
				if (isof[i] != null)
					model.setIsof(isof[i]);
				if (rmrk[i] != null)
					model.setRmrk(rmrk[i]);
				if (tjspno[i] != null)
					model.setTjspno(tjspno[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsInquiryParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsInquiryParmVO[]
	 */
	public OtsInquiryParmVO[] getOtsInquiryParmVOs(){
		OtsInquiryParmVO[] vos = (OtsInquiryParmVO[])models.toArray(new OtsInquiryParmVO[models.size()]);
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
		this.frdt = this.frdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cutp = this.cutp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tinvno = this.tinvno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cuno = this.cuno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfan = this.rfan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todt = this.todt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arif = this.arif .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creof = this.creof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payc = this.payc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrinvno = this.cntrinvno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tftp = this.tftp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payn = this.payn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tftp2 = this.tftp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetp = this.sheetp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hRhqOff = this.hRhqOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hUsrOff = this.hUsrOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invno = this.invno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cude = this.cude .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isof = this.isof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmrk = this.rmrk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjspno = this.tjspno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
