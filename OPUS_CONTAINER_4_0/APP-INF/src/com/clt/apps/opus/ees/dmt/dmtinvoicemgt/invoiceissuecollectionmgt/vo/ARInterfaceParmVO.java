/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInterfaceParmVO.java
*@FileTitle : ARInterfaceParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.10.16 최성환 
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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInterfaceParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInterfaceParmVO> models = new ArrayList<ARInterfaceParmVO>();
	
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String fmDtT2 = null;
	/* Column Info */
	private String toDtT2 = null;
	/* Column Info */
	private String ofcTp = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String actCustCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String sessionOfcCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String custType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInterfaceParmVO() {}

	public ARInterfaceParmVO(String ibflag, String pagerows, String ofcTp, String ofcCd, String dmdtTrfCd, String fmDt, String toDt, String fmDtT2, String toDtT2, String custType, String custCd, String sessionOfcCd, String chgCd, String ioBndCd, String type, String actCustCd) {
		this.fmDt = fmDt;
		this.fmDtT2 = fmDtT2;
		this.toDtT2 = toDtT2;
		this.ofcTp = ofcTp;
		this.type = type;
		this.ioBndCd = ioBndCd;
		this.actCustCd = actCustCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.custCd = custCd;
		this.sessionOfcCd = sessionOfcCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.custType = custType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("fm_dt_t2", getFmDtT2());
		this.hashColumns.put("to_dt_t2", getToDtT2());
		this.hashColumns.put("ofc_tp", getOfcTp());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("session_ofc_cd", getSessionOfcCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("cust_type", getCustType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("fm_dt_t2", "fmDtT2");
		this.hashFields.put("to_dt_t2", "toDtT2");
		this.hashFields.put("ofc_tp", "ofcTp");
		this.hashFields.put("type", "type");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("session_ofc_cd", "sessionOfcCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("cust_type", "custType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return fmDtT2
	 */
	public String getFmDtT2() {
		return this.fmDtT2;
	}
	
	/**
	 * Column Info
	 * @return toDtT2
	 */
	public String getToDtT2() {
		return this.toDtT2;
	}
	
	/**
	 * Column Info
	 * @return ofcTp
	 */
	public String getOfcTp() {
		return this.ofcTp;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return actCustCd
	 */
	public String getActCustCd() {
		return this.actCustCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return sessionOfcCd
	 */
	public String getSessionOfcCd() {
		return this.sessionOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return custType
	 */
	public String getCustType() {
		return this.custType;
	}
	

	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param fmDtT2
	 */
	public void setFmDtT2(String fmDtT2) {
		this.fmDtT2 = fmDtT2;
	}
	
	/**
	 * Column Info
	 * @param toDtT2
	 */
	public void setToDtT2(String toDtT2) {
		this.toDtT2 = toDtT2;
	}
	
	/**
	 * Column Info
	 * @param ofcTp
	 */
	public void setOfcTp(String ofcTp) {
		this.ofcTp = ofcTp;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param actCustCd
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param sessionOfcCd
	 */
	public void setSessionOfcCd(String sessionOfcCd) {
		this.sessionOfcCd = sessionOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setFmDtT2(JSPUtil.getParameter(request, "fm_dt_t2", ""));
		setToDtT2(JSPUtil.getParameter(request, "to_dt_t2", ""));
		setOfcTp(JSPUtil.getParameter(request, "ofc_tp", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setActCustCd(JSPUtil.getParameter(request, "act_cust_cd", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setSessionOfcCd(JSPUtil.getParameter(request, "session_ofc_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCustType(JSPUtil.getParameter(request, "cust_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInterfaceParmVO[]
	 */
	public ARInterfaceParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInterfaceParmVO[]
	 */
	public ARInterfaceParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInterfaceParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] fmDtT2 = (JSPUtil.getParameter(request, prefix	+ "fm_dt_t2", length));
			String[] toDtT2 = (JSPUtil.getParameter(request, prefix	+ "to_dt_t2", length));
			String[] ofcTp = (JSPUtil.getParameter(request, prefix	+ "ofc_tp", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] sessionOfcCd = (JSPUtil.getParameter(request, prefix	+ "session_ofc_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] custType = (JSPUtil.getParameter(request, prefix	+ "cust_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInterfaceParmVO();
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (fmDtT2[i] != null)
					model.setFmDtT2(fmDtT2[i]);
				if (toDtT2[i] != null)
					model.setToDtT2(toDtT2[i]);
				if (ofcTp[i] != null)
					model.setOfcTp(ofcTp[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (sessionOfcCd[i] != null)
					model.setSessionOfcCd(sessionOfcCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (custType[i] != null)
					model.setCustType(custType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInterfaceParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInterfaceParmVO[]
	 */
	public ARInterfaceParmVO[] getARInterfaceParmVOs(){
		ARInterfaceParmVO[] vos = (ARInterfaceParmVO[])models.toArray(new ARInterfaceParmVO[models.size()]);
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
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDtT2 = this.fmDtT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDtT2 = this.toDtT2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTp = this.ofcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sessionOfcCd = this.sessionOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custType = this.custType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
