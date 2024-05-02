/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OtsInquiryByDetialVO.java
*@FileTitle : OtsInquiryByDetialVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.06  
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

public class OtsInquiryByDetialVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsInquiryByDetialVO> models = new ArrayList<OtsInquiryByDetialVO>();
	
	/* Column Info */
	private String isseof = null;
	/* Column Info */
	private String blnooo = null;
	/* Column Info */
	private String bilamt = null;
	/* Column Info */
	private String payrcd = null;
	/* Column Info */
	private String tarftp = null;
	/* Column Info */
	private String comamt = null;
	/* Column Info */
	private String invnoo = null;
	/* Column Info */
	private String issedt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invamt = null;
	/* Column Info */
	private String currcy = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sheetp = null;
	/* Column Info */
	private String taxamt = null;
	/* Column Info */
	private String invovd = null;
	/* Column Info */
	private String bkgnoo = null;
	/* Column Info */
	private String vvdcdd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtsInquiryByDetialVO() {}

	public OtsInquiryByDetialVO(String ibflag, String pagerows, String isseof, String blnooo, String bilamt, String payrcd, String tarftp, String comamt, String invnoo, String issedt, String invamt, String currcy, String sheetp, String taxamt, String invovd, String bkgnoo, String vvdcdd) {
		this.isseof = isseof;
		this.blnooo = blnooo;
		this.bilamt = bilamt;
		this.payrcd = payrcd;
		this.tarftp = tarftp;
		this.comamt = comamt;
		this.invnoo = invnoo;
		this.issedt = issedt;
		this.pagerows = pagerows;
		this.invamt = invamt;
		this.currcy = currcy;
		this.ibflag = ibflag;
		this.sheetp = sheetp;
		this.taxamt = taxamt;
		this.invovd = invovd;
		this.bkgnoo = bkgnoo;
		this.vvdcdd = vvdcdd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("isseof", getIsseof());
		this.hashColumns.put("blnooo", getBlnooo());
		this.hashColumns.put("bilamt", getBilamt());
		this.hashColumns.put("payrcd", getPayrcd());
		this.hashColumns.put("tarftp", getTarftp());
		this.hashColumns.put("comamt", getComamt());
		this.hashColumns.put("invnoo", getInvnoo());
		this.hashColumns.put("issedt", getIssedt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("invamt", getInvamt());
		this.hashColumns.put("currcy", getCurrcy());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sheetp", getSheetp());
		this.hashColumns.put("taxamt", getTaxamt());
		this.hashColumns.put("invovd", getInvovd());
		this.hashColumns.put("bkgnoo", getBkgnoo());
		this.hashColumns.put("vvdcdd", getVvdcdd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("isseof", "isseof");
		this.hashFields.put("blnooo", "blnooo");
		this.hashFields.put("bilamt", "bilamt");
		this.hashFields.put("payrcd", "payrcd");
		this.hashFields.put("tarftp", "tarftp");
		this.hashFields.put("comamt", "comamt");
		this.hashFields.put("invnoo", "invnoo");
		this.hashFields.put("issedt", "issedt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("invamt", "invamt");
		this.hashFields.put("currcy", "currcy");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sheetp", "sheetp");
		this.hashFields.put("taxamt", "taxamt");
		this.hashFields.put("invovd", "invovd");
		this.hashFields.put("bkgnoo", "bkgnoo");
		this.hashFields.put("vvdcdd", "vvdcdd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return isseof
	 */
	public String getIsseof() {
		return this.isseof;
	}
	
	/**
	 * Column Info
	 * @return blnooo
	 */
	public String getBlnooo() {
		return this.blnooo;
	}
	
	/**
	 * Column Info
	 * @return bilamt
	 */
	public String getBilamt() {
		return this.bilamt;
	}
	
	/**
	 * Column Info
	 * @return payrcd
	 */
	public String getPayrcd() {
		return this.payrcd;
	}
	
	/**
	 * Column Info
	 * @return tarftp
	 */
	public String getTarftp() {
		return this.tarftp;
	}
	
	/**
	 * Column Info
	 * @return comamt
	 */
	public String getComamt() {
		return this.comamt;
	}
	
	/**
	 * Column Info
	 * @return invnoo
	 */
	public String getInvnoo() {
		return this.invnoo;
	}
	
	/**
	 * Column Info
	 * @return issedt
	 */
	public String getIssedt() {
		return this.issedt;
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
	 * @return invamt
	 */
	public String getInvamt() {
		return this.invamt;
	}
	
	/**
	 * Column Info
	 * @return currcy
	 */
	public String getCurrcy() {
		return this.currcy;
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
	 * @return sheetp
	 */
	public String getSheetp() {
		return this.sheetp;
	}
	
	/**
	 * Column Info
	 * @return taxamt
	 */
	public String getTaxamt() {
		return this.taxamt;
	}
	
	/**
	 * Column Info
	 * @return invovd
	 */
	public String getInvovd() {
		return this.invovd;
	}
	
	/**
	 * Column Info
	 * @return bkgnoo
	 */
	public String getBkgnoo() {
		return this.bkgnoo;
	}
	
	/**
	 * Column Info
	 * @return vvdcdd
	 */
	public String getVvdcdd() {
		return this.vvdcdd;
	}
	

	/**
	 * Column Info
	 * @param isseof
	 */
	public void setIsseof(String isseof) {
		this.isseof = isseof;
	}
	
	/**
	 * Column Info
	 * @param blnooo
	 */
	public void setBlnooo(String blnooo) {
		this.blnooo = blnooo;
	}
	
	/**
	 * Column Info
	 * @param bilamt
	 */
	public void setBilamt(String bilamt) {
		this.bilamt = bilamt;
	}
	
	/**
	 * Column Info
	 * @param payrcd
	 */
	public void setPayrcd(String payrcd) {
		this.payrcd = payrcd;
	}
	
	/**
	 * Column Info
	 * @param tarftp
	 */
	public void setTarftp(String tarftp) {
		this.tarftp = tarftp;
	}
	
	/**
	 * Column Info
	 * @param comamt
	 */
	public void setComamt(String comamt) {
		this.comamt = comamt;
	}
	
	/**
	 * Column Info
	 * @param invnoo
	 */
	public void setInvnoo(String invnoo) {
		this.invnoo = invnoo;
	}
	
	/**
	 * Column Info
	 * @param issedt
	 */
	public void setIssedt(String issedt) {
		this.issedt = issedt;
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
	 * @param invamt
	 */
	public void setInvamt(String invamt) {
		this.invamt = invamt;
	}
	
	/**
	 * Column Info
	 * @param currcy
	 */
	public void setCurrcy(String currcy) {
		this.currcy = currcy;
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
	 * @param sheetp
	 */
	public void setSheetp(String sheetp) {
		this.sheetp = sheetp;
	}
	
	/**
	 * Column Info
	 * @param taxamt
	 */
	public void setTaxamt(String taxamt) {
		this.taxamt = taxamt;
	}
	
	/**
	 * Column Info
	 * @param invovd
	 */
	public void setInvovd(String invovd) {
		this.invovd = invovd;
	}
	
	/**
	 * Column Info
	 * @param bkgnoo
	 */
	public void setBkgnoo(String bkgnoo) {
		this.bkgnoo = bkgnoo;
	}
	
	/**
	 * Column Info
	 * @param vvdcdd
	 */
	public void setVvdcdd(String vvdcdd) {
		this.vvdcdd = vvdcdd;
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
		setIsseof(JSPUtil.getParameter(request, prefix + "isseof", ""));
		setBlnooo(JSPUtil.getParameter(request, prefix + "blnooo", ""));
		setBilamt(JSPUtil.getParameter(request, prefix + "bilamt", ""));
		setPayrcd(JSPUtil.getParameter(request, prefix + "payrcd", ""));
		setTarftp(JSPUtil.getParameter(request, prefix + "tarftp", ""));
		setComamt(JSPUtil.getParameter(request, prefix + "comamt", ""));
		setInvnoo(JSPUtil.getParameter(request, prefix + "invnoo", ""));
		setIssedt(JSPUtil.getParameter(request, prefix + "issedt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvamt(JSPUtil.getParameter(request, prefix + "invamt", ""));
		setCurrcy(JSPUtil.getParameter(request, prefix + "currcy", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSheetp(JSPUtil.getParameter(request, prefix + "sheetp", ""));
		setTaxamt(JSPUtil.getParameter(request, prefix + "taxamt", ""));
		setInvovd(JSPUtil.getParameter(request, prefix + "invovd", ""));
		setBkgnoo(JSPUtil.getParameter(request, prefix + "bkgnoo", ""));
		setVvdcdd(JSPUtil.getParameter(request, prefix + "vvdcdd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryByDetialVO[]
	 */
	public OtsInquiryByDetialVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryByDetialVO[]
	 */
	public OtsInquiryByDetialVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsInquiryByDetialVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] isseof = (JSPUtil.getParameter(request, prefix	+ "isseof", length));
			String[] blnooo = (JSPUtil.getParameter(request, prefix	+ "blnooo", length));
			String[] bilamt = (JSPUtil.getParameter(request, prefix	+ "bilamt", length));
			String[] payrcd = (JSPUtil.getParameter(request, prefix	+ "payrcd", length));
			String[] tarftp = (JSPUtil.getParameter(request, prefix	+ "tarftp", length));
			String[] comamt = (JSPUtil.getParameter(request, prefix	+ "comamt", length));
			String[] invnoo = (JSPUtil.getParameter(request, prefix	+ "invnoo", length));
			String[] issedt = (JSPUtil.getParameter(request, prefix	+ "issedt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invamt = (JSPUtil.getParameter(request, prefix	+ "invamt", length));
			String[] currcy = (JSPUtil.getParameter(request, prefix	+ "currcy", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sheetp = (JSPUtil.getParameter(request, prefix	+ "sheetp", length));
			String[] taxamt = (JSPUtil.getParameter(request, prefix	+ "taxamt", length));
			String[] invovd = (JSPUtil.getParameter(request, prefix	+ "invovd", length));
			String[] bkgnoo = (JSPUtil.getParameter(request, prefix	+ "bkgnoo", length));
			String[] vvdcdd = (JSPUtil.getParameter(request, prefix	+ "vvdcdd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsInquiryByDetialVO();
				if (isseof[i] != null)
					model.setIsseof(isseof[i]);
				if (blnooo[i] != null)
					model.setBlnooo(blnooo[i]);
				if (bilamt[i] != null)
					model.setBilamt(bilamt[i]);
				if (payrcd[i] != null)
					model.setPayrcd(payrcd[i]);
				if (tarftp[i] != null)
					model.setTarftp(tarftp[i]);
				if (comamt[i] != null)
					model.setComamt(comamt[i]);
				if (invnoo[i] != null)
					model.setInvnoo(invnoo[i]);
				if (issedt[i] != null)
					model.setIssedt(issedt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invamt[i] != null)
					model.setInvamt(invamt[i]);
				if (currcy[i] != null)
					model.setCurrcy(currcy[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sheetp[i] != null)
					model.setSheetp(sheetp[i]);
				if (taxamt[i] != null)
					model.setTaxamt(taxamt[i]);
				if (invovd[i] != null)
					model.setInvovd(invovd[i]);
				if (bkgnoo[i] != null)
					model.setBkgnoo(bkgnoo[i]);
				if (vvdcdd[i] != null)
					model.setVvdcdd(vvdcdd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsInquiryByDetialVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsInquiryByDetialVO[]
	 */
	public OtsInquiryByDetialVO[] getOtsInquiryByDetialVOs(){
		OtsInquiryByDetialVO[] vos = (OtsInquiryByDetialVO[])models.toArray(new OtsInquiryByDetialVO[models.size()]);
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
		this.isseof = this.isseof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnooo = this.blnooo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilamt = this.bilamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrcd = this.payrcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tarftp = this.tarftp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comamt = this.comamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invnoo = this.invnoo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issedt = this.issedt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invamt = this.invamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currcy = this.currcy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetp = this.sheetp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxamt = this.taxamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invovd = this.invovd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnoo = this.bkgnoo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcdd = this.vvdcdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
