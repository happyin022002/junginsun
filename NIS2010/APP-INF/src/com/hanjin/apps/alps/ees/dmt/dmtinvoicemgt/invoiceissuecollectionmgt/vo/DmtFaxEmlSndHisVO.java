/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtFaxEmlSndHisVO.java
*@FileTitle : DmtFaxEmlSndHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.14 문중철 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtFaxEmlSndHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtFaxEmlSndHisVO> models = new ArrayList<DmtFaxEmlSndHisVO>();
	
	/* Column Info */
	private String faxeml = null;
	/* Column Info */
	private String sndrid = null;
	/* Column Info */
	private String snddat = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndrnm = null;
	/* Column Info */
	private String shtype = null;
	/* Column Info */
	private String payerr = null;
	/* Column Info */
	private String rstmsg = null;
	/* Column Info */
	private String invnoo = null;
	/* Column Info */
	private String sndoff = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtFaxEmlSndHisVO() {}

	public DmtFaxEmlSndHisVO(String ibflag, String pagerows, String invnoo, String payerr, String shtype, String faxeml, String rstmsg, String snddat, String sndoff, String sndrid, String sndrnm) {
		this.faxeml = faxeml;
		this.sndrid = sndrid;
		this.snddat = snddat;
		this.ibflag = ibflag;
		this.sndrnm = sndrnm;
		this.shtype = shtype;
		this.payerr = payerr;
		this.rstmsg = rstmsg;
		this.invnoo = invnoo;
		this.sndoff = sndoff;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("faxeml", getFaxeml());
		this.hashColumns.put("sndrid", getSndrid());
		this.hashColumns.put("snddat", getSnddat());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sndrnm", getSndrnm());
		this.hashColumns.put("shtype", getShtype());
		this.hashColumns.put("payerr", getPayerr());
		this.hashColumns.put("rstmsg", getRstmsg());
		this.hashColumns.put("invnoo", getInvnoo());
		this.hashColumns.put("sndoff", getSndoff());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("faxeml", "faxeml");
		this.hashFields.put("sndrid", "sndrid");
		this.hashFields.put("snddat", "snddat");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sndrnm", "sndrnm");
		this.hashFields.put("shtype", "shtype");
		this.hashFields.put("payerr", "payerr");
		this.hashFields.put("rstmsg", "rstmsg");
		this.hashFields.put("invnoo", "invnoo");
		this.hashFields.put("sndoff", "sndoff");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return faxeml
	 */
	public String getFaxeml() {
		return this.faxeml;
	}
	
	/**
	 * Column Info
	 * @return sndrid
	 */
	public String getSndrid() {
		return this.sndrid;
	}
	
	/**
	 * Column Info
	 * @return snddat
	 */
	public String getSnddat() {
		return this.snddat;
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
	 * @return sndrnm
	 */
	public String getSndrnm() {
		return this.sndrnm;
	}
	
	/**
	 * Column Info
	 * @return shtype
	 */
	public String getShtype() {
		return this.shtype;
	}
	
	/**
	 * Column Info
	 * @return payerr
	 */
	public String getPayerr() {
		return this.payerr;
	}
	
	/**
	 * Column Info
	 * @return rstmsg
	 */
	public String getRstmsg() {
		return this.rstmsg;
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
	 * @return sndoff
	 */
	public String getSndoff() {
		return this.sndoff;
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
	 * @param faxeml
	 */
	public void setFaxeml(String faxeml) {
		this.faxeml = faxeml;
	}
	
	/**
	 * Column Info
	 * @param sndrid
	 */
	public void setSndrid(String sndrid) {
		this.sndrid = sndrid;
	}
	
	/**
	 * Column Info
	 * @param snddat
	 */
	public void setSnddat(String snddat) {
		this.snddat = snddat;
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
	 * @param sndrnm
	 */
	public void setSndrnm(String sndrnm) {
		this.sndrnm = sndrnm;
	}
	
	/**
	 * Column Info
	 * @param shtype
	 */
	public void setShtype(String shtype) {
		this.shtype = shtype;
	}
	
	/**
	 * Column Info
	 * @param payerr
	 */
	public void setPayerr(String payerr) {
		this.payerr = payerr;
	}
	
	/**
	 * Column Info
	 * @param rstmsg
	 */
	public void setRstmsg(String rstmsg) {
		this.rstmsg = rstmsg;
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
	 * @param sndoff
	 */
	public void setSndoff(String sndoff) {
		this.sndoff = sndoff;
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
		setFaxeml(JSPUtil.getParameter(request, "faxeml", ""));
		setSndrid(JSPUtil.getParameter(request, "sndrid", ""));
		setSnddat(JSPUtil.getParameter(request, "snddat", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndrnm(JSPUtil.getParameter(request, "sndrnm", ""));
		setShtype(JSPUtil.getParameter(request, "shtype", ""));
		setPayerr(JSPUtil.getParameter(request, "payerr", ""));
		setRstmsg(JSPUtil.getParameter(request, "rstmsg", ""));
		setInvnoo(JSPUtil.getParameter(request, "invnoo", ""));
		setSndoff(JSPUtil.getParameter(request, "sndoff", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtFaxEmlSndHisVO[]
	 */
	public DmtFaxEmlSndHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtFaxEmlSndHisVO[]
	 */
	public DmtFaxEmlSndHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtFaxEmlSndHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] faxeml = (JSPUtil.getParameter(request, prefix	+ "faxeml", length));
			String[] sndrid = (JSPUtil.getParameter(request, prefix	+ "sndrid", length));
			String[] snddat = (JSPUtil.getParameter(request, prefix	+ "snddat", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sndrnm = (JSPUtil.getParameter(request, prefix	+ "sndrnm", length));
			String[] shtype = (JSPUtil.getParameter(request, prefix	+ "shtype", length));
			String[] payerr = (JSPUtil.getParameter(request, prefix	+ "payerr", length));
			String[] rstmsg = (JSPUtil.getParameter(request, prefix	+ "rstmsg", length));
			String[] invnoo = (JSPUtil.getParameter(request, prefix	+ "invnoo", length));
			String[] sndoff = (JSPUtil.getParameter(request, prefix	+ "sndoff", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtFaxEmlSndHisVO();
				if (faxeml[i] != null)
					model.setFaxeml(faxeml[i]);
				if (sndrid[i] != null)
					model.setSndrid(sndrid[i]);
				if (snddat[i] != null)
					model.setSnddat(snddat[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndrnm[i] != null)
					model.setSndrnm(sndrnm[i]);
				if (shtype[i] != null)
					model.setShtype(shtype[i]);
				if (payerr[i] != null)
					model.setPayerr(payerr[i]);
				if (rstmsg[i] != null)
					model.setRstmsg(rstmsg[i]);
				if (invnoo[i] != null)
					model.setInvnoo(invnoo[i]);
				if (sndoff[i] != null)
					model.setSndoff(sndoff[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtFaxEmlSndHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtFaxEmlSndHisVO[]
	 */
	public DmtFaxEmlSndHisVO[] getDmtFaxEmlSndHisVOs(){
		DmtFaxEmlSndHisVO[] vos = (DmtFaxEmlSndHisVO[])models.toArray(new DmtFaxEmlSndHisVO[models.size()]);
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
		this.faxeml = this.faxeml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrid = this.sndrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.snddat = this.snddat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrnm = this.sndrnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shtype = this.shtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerr = this.payerr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstmsg = this.rstmsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invnoo = this.invnoo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndoff = this.sndoff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
