/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtsInquiryByDetialVO3.java
*@FileTitle : OtsInquiryByDetialVO3
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.07 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OtsInquiryByDetial3VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsInquiryByDetial3VO> models = new ArrayList<OtsInquiryByDetial3VO>();
	
	/* Column Info */
	private String isseof = null;
	/* Column Info */
	private String blnooo = null;
	/* Column Info */
	private String bilamt = null;
	/* Column Info */
	private String payrcd = null;
	/* Column Info */
	private String tpszcd = null;
	/* Column Info */
	private String tarftp = null;
	/* Column Info */
	private String cntrno = null;
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
	
	public OtsInquiryByDetial3VO() {}

	public OtsInquiryByDetial3VO(String ibflag, String pagerows, String invnoo, String vvdcdd, String bkgnoo, String blnooo, String cntrno, String tpszcd, String currcy, String bilamt, String taxamt, String comamt, String invamt, String tarftp, String issedt, String isseof, String payrcd, String invovd) {
		this.isseof = isseof;
		this.blnooo = blnooo;
		this.bilamt = bilamt;
		this.payrcd = payrcd;
		this.tpszcd = tpszcd;
		this.tarftp = tarftp;
		this.cntrno = cntrno;
		this.comamt = comamt;
		this.invnoo = invnoo;
		this.issedt = issedt;
		this.pagerows = pagerows;
		this.invamt = invamt;
		this.currcy = currcy;
		this.ibflag = ibflag;
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
		this.hashColumns.put("tpszcd", getTpszcd());
		this.hashColumns.put("tarftp", getTarftp());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("comamt", getComamt());
		this.hashColumns.put("invnoo", getInvnoo());
		this.hashColumns.put("issedt", getIssedt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("invamt", getInvamt());
		this.hashColumns.put("currcy", getCurrcy());
		this.hashColumns.put("ibflag", getIbflag());
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
		this.hashFields.put("tpszcd", "tpszcd");
		this.hashFields.put("tarftp", "tarftp");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("comamt", "comamt");
		this.hashFields.put("invnoo", "invnoo");
		this.hashFields.put("issedt", "issedt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("invamt", "invamt");
		this.hashFields.put("currcy", "currcy");
		this.hashFields.put("ibflag", "ibflag");
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
	 * @return tpszcd
	 */
	public String getTpszcd() {
		return this.tpszcd;
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
	 * @return cntrno
	 */
	public String getCntrno() {
		return this.cntrno;
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
	 * @param tpszcd
	 */
	public void setTpszcd(String tpszcd) {
		this.tpszcd = tpszcd;
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
	 * @param cntrno
	 */
	public void setCntrno(String cntrno) {
		this.cntrno = cntrno;
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
		setIsseof(JSPUtil.getParameter(request, "isseof", ""));
		setBlnooo(JSPUtil.getParameter(request, "blnooo", ""));
		setBilamt(JSPUtil.getParameter(request, "bilamt", ""));
		setPayrcd(JSPUtil.getParameter(request, "payrcd", ""));
		setTpszcd(JSPUtil.getParameter(request, "tpszcd", ""));
		setTarftp(JSPUtil.getParameter(request, "tarftp", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setComamt(JSPUtil.getParameter(request, "comamt", ""));
		setInvnoo(JSPUtil.getParameter(request, "invnoo", ""));
		setIssedt(JSPUtil.getParameter(request, "issedt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvamt(JSPUtil.getParameter(request, "invamt", ""));
		setCurrcy(JSPUtil.getParameter(request, "currcy", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTaxamt(JSPUtil.getParameter(request, "taxamt", ""));
		setInvovd(JSPUtil.getParameter(request, "invovd", ""));
		setBkgnoo(JSPUtil.getParameter(request, "bkgnoo", ""));
		setVvdcdd(JSPUtil.getParameter(request, "vvdcdd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryByDetialVO3[]
	 */
	public OtsInquiryByDetial3VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryByDetialVO3[]
	 */
	public OtsInquiryByDetial3VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsInquiryByDetial3VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] isseof = (JSPUtil.getParameter(request, prefix	+ "isseof", length));
			String[] blnooo = (JSPUtil.getParameter(request, prefix	+ "blnooo", length));
			String[] bilamt = (JSPUtil.getParameter(request, prefix	+ "bilamt", length));
			String[] payrcd = (JSPUtil.getParameter(request, prefix	+ "payrcd", length));
			String[] tpszcd = (JSPUtil.getParameter(request, prefix	+ "tpszcd", length));
			String[] tarftp = (JSPUtil.getParameter(request, prefix	+ "tarftp", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] comamt = (JSPUtil.getParameter(request, prefix	+ "comamt", length));
			String[] invnoo = (JSPUtil.getParameter(request, prefix	+ "invnoo", length));
			String[] issedt = (JSPUtil.getParameter(request, prefix	+ "issedt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invamt = (JSPUtil.getParameter(request, prefix	+ "invamt", length));
			String[] currcy = (JSPUtil.getParameter(request, prefix	+ "currcy", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxamt = (JSPUtil.getParameter(request, prefix	+ "taxamt", length));
			String[] invovd = (JSPUtil.getParameter(request, prefix	+ "invovd", length));
			String[] bkgnoo = (JSPUtil.getParameter(request, prefix	+ "bkgnoo", length));
			String[] vvdcdd = (JSPUtil.getParameter(request, prefix	+ "vvdcdd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsInquiryByDetial3VO();
				if (isseof[i] != null)
					model.setIsseof(isseof[i]);
				if (blnooo[i] != null)
					model.setBlnooo(blnooo[i]);
				if (bilamt[i] != null)
					model.setBilamt(bilamt[i]);
				if (payrcd[i] != null)
					model.setPayrcd(payrcd[i]);
				if (tpszcd[i] != null)
					model.setTpszcd(tpszcd[i]);
				if (tarftp[i] != null)
					model.setTarftp(tarftp[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
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
		return getOtsInquiryByDetialVO3s();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsInquiryByDetialVO3[]
	 */
	public OtsInquiryByDetial3VO[] getOtsInquiryByDetialVO3s(){
		OtsInquiryByDetial3VO[] vos = (OtsInquiryByDetial3VO[])models.toArray(new OtsInquiryByDetial3VO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.isseof = this.isseof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnooo = this.blnooo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilamt = this.bilamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrcd = this.payrcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszcd = this.tpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tarftp = this.tarftp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comamt = this.comamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invnoo = this.invnoo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issedt = this.issedt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invamt = this.invamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currcy = this.currcy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxamt = this.taxamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invovd = this.invovd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnoo = this.bkgnoo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcdd = this.vvdcdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
