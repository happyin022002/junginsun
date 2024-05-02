/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OtsInquiryByDetialVO2.java
*@FileTitle : OtsInquiryByDetialVO2
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.09.24 문중철 
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

public class OtsInquiryByDetial2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsInquiryByDetial2VO> models = new ArrayList<OtsInquiryByDetial2VO>();
	
	/* Column Info */
	private String loccdd = null;
	/* Column Info */
	private String blnooo = null;
	/* Column Info */
	private String overdy = null;
	/* Column Info */
	private String cntrno = null;
	/* Column Info */
	private String ftcmpl = null;
	/* Column Info */
	private String stpdfr = null;
	/* Column Info */
	private String freedy = null;
	/* Column Info */
	private String invnoo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String currcy = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oveday = null;
	/* Column Info */
	private String issudt = null;
	/* Column Info */
	private String charge = null;
	/* Column Info */
	private String netamt = null;
	/* Column Info */
	private String scnooo = null;
	/* Column Info */
	private String taxamt = null;
	/* Column Info */
	private String stpdto = null;
	/* Column Info */
	private String tyszcd = null;
	/* Column Info */
	private String totamt = null;
	/* Column Info */
	private String vvdcdd = null;
	/* Column Info */
	private String ftcmnc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtsInquiryByDetial2VO() {}

	public OtsInquiryByDetial2VO(String ibflag, String pagerows, String invnoo, String charge, String vvdcdd, String scnooo, String blnooo, String loccdd, String cntrno, String tyszcd, String stpdfr, String stpdto, String ftcmnc, String ftcmpl, String freedy, String overdy, String currcy, String netamt, String taxamt, String totamt, String issudt, String oveday) {
		this.loccdd = loccdd;
		this.blnooo = blnooo;
		this.overdy = overdy;
		this.cntrno = cntrno;
		this.ftcmpl = ftcmpl;
		this.stpdfr = stpdfr;
		this.freedy = freedy;
		this.invnoo = invnoo;
		this.pagerows = pagerows;
		this.currcy = currcy;
		this.ibflag = ibflag;
		this.oveday = oveday;
		this.issudt = issudt;
		this.charge = charge;
		this.netamt = netamt;
		this.scnooo = scnooo;
		this.taxamt = taxamt;
		this.stpdto = stpdto;
		this.tyszcd = tyszcd;
		this.totamt = totamt;
		this.vvdcdd = vvdcdd;
		this.ftcmnc = ftcmnc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loccdd", getLoccdd());
		this.hashColumns.put("blnooo", getBlnooo());
		this.hashColumns.put("overdy", getOverdy());
		this.hashColumns.put("cntrno", getCntrno());
		this.hashColumns.put("ftcmpl", getFtcmpl());
		this.hashColumns.put("stpdfr", getStpdfr());
		this.hashColumns.put("freedy", getFreedy());
		this.hashColumns.put("invnoo", getInvnoo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("currcy", getCurrcy());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oveday", getOveday());
		this.hashColumns.put("issudt", getIssudt());
		this.hashColumns.put("charge", getCharge());
		this.hashColumns.put("netamt", getNetamt());
		this.hashColumns.put("scnooo", getScnooo());
		this.hashColumns.put("taxamt", getTaxamt());
		this.hashColumns.put("stpdto", getStpdto());
		this.hashColumns.put("tyszcd", getTyszcd());
		this.hashColumns.put("totamt", getTotamt());
		this.hashColumns.put("vvdcdd", getVvdcdd());
		this.hashColumns.put("ftcmnc", getFtcmnc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loccdd", "loccdd");
		this.hashFields.put("blnooo", "blnooo");
		this.hashFields.put("overdy", "overdy");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("ftcmpl", "ftcmpl");
		this.hashFields.put("stpdfr", "stpdfr");
		this.hashFields.put("freedy", "freedy");
		this.hashFields.put("invnoo", "invnoo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("currcy", "currcy");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oveday", "oveday");
		this.hashFields.put("issudt", "issudt");
		this.hashFields.put("charge", "charge");
		this.hashFields.put("netamt", "netamt");
		this.hashFields.put("scnooo", "scnooo");
		this.hashFields.put("taxamt", "taxamt");
		this.hashFields.put("stpdto", "stpdto");
		this.hashFields.put("tyszcd", "tyszcd");
		this.hashFields.put("totamt", "totamt");
		this.hashFields.put("vvdcdd", "vvdcdd");
		this.hashFields.put("ftcmnc", "ftcmnc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return loccdd
	 */
	public String getLoccdd() {
		return this.loccdd;
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
	 * @return overdy
	 */
	public String getOverdy() {
		return this.overdy;
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
	 * @return ftcmpl
	 */
	public String getFtcmpl() {
		return this.ftcmpl;
	}
	
	/**
	 * Column Info
	 * @return stpdfr
	 */
	public String getStpdfr() {
		return this.stpdfr;
	}
	
	/**
	 * Column Info
	 * @return freedy
	 */
	public String getFreedy() {
		return this.freedy;
	}
	
	/**
	 * Column Info
	 * @return invnoo
	 */
	public String getInvnoo() {
		return this.invnoo;
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
	 * @return oveday
	 */
	public String getOveday() {
		return this.oveday;
	}
	
	/**
	 * Column Info
	 * @return issudt
	 */
	public String getIssudt() {
		return this.issudt;
	}
	
	/**
	 * Column Info
	 * @return charge
	 */
	public String getCharge() {
		return this.charge;
	}
	
	/**
	 * Column Info
	 * @return netamt
	 */
	public String getNetamt() {
		return this.netamt;
	}
	
	/**
	 * Column Info
	 * @return scnooo
	 */
	public String getScnooo() {
		return this.scnooo;
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
	 * @return stpdto
	 */
	public String getStpdto() {
		return this.stpdto;
	}
	
	/**
	 * Column Info
	 * @return tyszcd
	 */
	public String getTyszcd() {
		return this.tyszcd;
	}
	
	/**
	 * Column Info
	 * @return totamt
	 */
	public String getTotamt() {
		return this.totamt;
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
	 * @return ftcmnc
	 */
	public String getFtcmnc() {
		return this.ftcmnc;
	}
	

	/**
	 * Column Info
	 * @param loccdd
	 */
	public void setLoccdd(String loccdd) {
		this.loccdd = loccdd;
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
	 * @param overdy
	 */
	public void setOverdy(String overdy) {
		this.overdy = overdy;
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
	 * @param ftcmpl
	 */
	public void setFtcmpl(String ftcmpl) {
		this.ftcmpl = ftcmpl;
	}
	
	/**
	 * Column Info
	 * @param stpdfr
	 */
	public void setStpdfr(String stpdfr) {
		this.stpdfr = stpdfr;
	}
	
	/**
	 * Column Info
	 * @param freedy
	 */
	public void setFreedy(String freedy) {
		this.freedy = freedy;
	}
	
	/**
	 * Column Info
	 * @param invnoo
	 */
	public void setInvnoo(String invnoo) {
		this.invnoo = invnoo;
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
	 * @param oveday
	 */
	public void setOveday(String oveday) {
		this.oveday = oveday;
	}
	
	/**
	 * Column Info
	 * @param issudt
	 */
	public void setIssudt(String issudt) {
		this.issudt = issudt;
	}
	
	/**
	 * Column Info
	 * @param charge
	 */
	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	/**
	 * Column Info
	 * @param netamt
	 */
	public void setNetamt(String netamt) {
		this.netamt = netamt;
	}
	
	/**
	 * Column Info
	 * @param scnooo
	 */
	public void setScnooo(String scnooo) {
		this.scnooo = scnooo;
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
	 * @param stpdto
	 */
	public void setStpdto(String stpdto) {
		this.stpdto = stpdto;
	}
	
	/**
	 * Column Info
	 * @param tyszcd
	 */
	public void setTyszcd(String tyszcd) {
		this.tyszcd = tyszcd;
	}
	
	/**
	 * Column Info
	 * @param totamt
	 */
	public void setTotamt(String totamt) {
		this.totamt = totamt;
	}
	
	/**
	 * Column Info
	 * @param vvdcdd
	 */
	public void setVvdcdd(String vvdcdd) {
		this.vvdcdd = vvdcdd;
	}
	
	/**
	 * Column Info
	 * @param ftcmnc
	 */
	public void setFtcmnc(String ftcmnc) {
		this.ftcmnc = ftcmnc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLoccdd(JSPUtil.getParameter(request, "loccdd", ""));
		setBlnooo(JSPUtil.getParameter(request, "blnooo", ""));
		setOverdy(JSPUtil.getParameter(request, "overdy", ""));
		setCntrno(JSPUtil.getParameter(request, "cntrno", ""));
		setFtcmpl(JSPUtil.getParameter(request, "ftcmpl", ""));
		setStpdfr(JSPUtil.getParameter(request, "stpdfr", ""));
		setFreedy(JSPUtil.getParameter(request, "freedy", ""));
		setInvnoo(JSPUtil.getParameter(request, "invnoo", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCurrcy(JSPUtil.getParameter(request, "currcy", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOveday(JSPUtil.getParameter(request, "oveday", ""));
		setIssudt(JSPUtil.getParameter(request, "issudt", ""));
		setCharge(JSPUtil.getParameter(request, "charge", ""));
		setNetamt(JSPUtil.getParameter(request, "netamt", ""));
		setScnooo(JSPUtil.getParameter(request, "scnooo", ""));
		setTaxamt(JSPUtil.getParameter(request, "taxamt", ""));
		setStpdto(JSPUtil.getParameter(request, "stpdto", ""));
		setTyszcd(JSPUtil.getParameter(request, "tyszcd", ""));
		setTotamt(JSPUtil.getParameter(request, "totamt", ""));
		setVvdcdd(JSPUtil.getParameter(request, "vvdcdd", ""));
		setFtcmnc(JSPUtil.getParameter(request, "ftcmnc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryByDetialVO2[]
	 */
	public OtsInquiryByDetial2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryByDetialVO2[]
	 */
	public OtsInquiryByDetial2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsInquiryByDetial2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] loccdd = (JSPUtil.getParameter(request, prefix	+ "loccdd", length));
			String[] blnooo = (JSPUtil.getParameter(request, prefix	+ "blnooo", length));
			String[] overdy = (JSPUtil.getParameter(request, prefix	+ "overdy", length));
			String[] cntrno = (JSPUtil.getParameter(request, prefix	+ "cntrno", length));
			String[] ftcmpl = (JSPUtil.getParameter(request, prefix	+ "ftcmpl", length));
			String[] stpdfr = (JSPUtil.getParameter(request, prefix	+ "stpdfr", length));
			String[] freedy = (JSPUtil.getParameter(request, prefix	+ "freedy", length));
			String[] invnoo = (JSPUtil.getParameter(request, prefix	+ "invnoo", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] currcy = (JSPUtil.getParameter(request, prefix	+ "currcy", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oveday = (JSPUtil.getParameter(request, prefix	+ "oveday", length));
			String[] issudt = (JSPUtil.getParameter(request, prefix	+ "issudt", length));
			String[] charge = (JSPUtil.getParameter(request, prefix	+ "charge", length));
			String[] netamt = (JSPUtil.getParameter(request, prefix	+ "netamt", length));
			String[] scnooo = (JSPUtil.getParameter(request, prefix	+ "scnooo", length));
			String[] taxamt = (JSPUtil.getParameter(request, prefix	+ "taxamt", length));
			String[] stpdto = (JSPUtil.getParameter(request, prefix	+ "stpdto", length));
			String[] tyszcd = (JSPUtil.getParameter(request, prefix	+ "tyszcd", length));
			String[] totamt = (JSPUtil.getParameter(request, prefix	+ "totamt", length));
			String[] vvdcdd = (JSPUtil.getParameter(request, prefix	+ "vvdcdd", length));
			String[] ftcmnc = (JSPUtil.getParameter(request, prefix	+ "ftcmnc", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsInquiryByDetial2VO();
				if (loccdd[i] != null)
					model.setLoccdd(loccdd[i]);
				if (blnooo[i] != null)
					model.setBlnooo(blnooo[i]);
				if (overdy[i] != null)
					model.setOverdy(overdy[i]);
				if (cntrno[i] != null)
					model.setCntrno(cntrno[i]);
				if (ftcmpl[i] != null)
					model.setFtcmpl(ftcmpl[i]);
				if (stpdfr[i] != null)
					model.setStpdfr(stpdfr[i]);
				if (freedy[i] != null)
					model.setFreedy(freedy[i]);
				if (invnoo[i] != null)
					model.setInvnoo(invnoo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (currcy[i] != null)
					model.setCurrcy(currcy[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oveday[i] != null)
					model.setOveday(oveday[i]);
				if (issudt[i] != null)
					model.setIssudt(issudt[i]);
				if (charge[i] != null)
					model.setCharge(charge[i]);
				if (netamt[i] != null)
					model.setNetamt(netamt[i]);
				if (scnooo[i] != null)
					model.setScnooo(scnooo[i]);
				if (taxamt[i] != null)
					model.setTaxamt(taxamt[i]);
				if (stpdto[i] != null)
					model.setStpdto(stpdto[i]);
				if (tyszcd[i] != null)
					model.setTyszcd(tyszcd[i]);
				if (totamt[i] != null)
					model.setTotamt(totamt[i]);
				if (vvdcdd[i] != null)
					model.setVvdcdd(vvdcdd[i]);
				if (ftcmnc[i] != null)
					model.setFtcmnc(ftcmnc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsInquiryByDetialVO2s();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsInquiryByDetialVO2[]
	 */
	public OtsInquiryByDetial2VO[] getOtsInquiryByDetialVO2s(){
		OtsInquiryByDetial2VO[] vos = (OtsInquiryByDetial2VO[])models.toArray(new OtsInquiryByDetial2VO[models.size()]);
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
		this.loccdd = this.loccdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnooo = this.blnooo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdy = this.overdy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno = this.cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftcmpl = this.ftcmpl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stpdfr = this.stpdfr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freedy = this.freedy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invnoo = this.invnoo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currcy = this.currcy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oveday = this.oveday .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issudt = this.issudt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.charge = this.charge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netamt = this.netamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnooo = this.scnooo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxamt = this.taxamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stpdto = this.stpdto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tyszcd = this.tyszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totamt = this.totamt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcdd = this.vvdcdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftcmnc = this.ftcmnc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
