/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvByIFVO.java
*@FileTitle : InvByIFVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.05.25 박정진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceIFDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceIFDateVO> models = new ArrayList<ARInvoiceIFDateVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String goodYn = null;
	/* Column Info */
	private String arOfcCd2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceIFDateVO() {}

	public ARInvoiceIFDateVO(String ibflag, String pagerows, String fmDt, String toDt, String issDt, String port, String arOfcCd2, String ioBndCd, String svcScpCd, String goodYn, String revTpCd) {
		this.port = port;
		this.toDt = toDt;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.fmDt = fmDt;
		this.svcScpCd = svcScpCd;
		this.ioBndCd = ioBndCd;
		this.revTpCd = revTpCd;
		this.goodYn = goodYn;
		this.arOfcCd2 = arOfcCd2;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("good_yn", getGoodYn());
		this.hashColumns.put("ar_ofc_cd2", getArOfcCd2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("good_yn", "goodYn");
		this.hashFields.put("ar_ofc_cd2", "arOfcCd2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return goodYn
	 */
	public String getGoodYn() {
		return this.goodYn;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd2
	 */
	public String getArOfcCd2() {
		return this.arOfcCd2;
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
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param goodYn
	 */
	public void setGoodYn(String goodYn) {
		this.goodYn = goodYn;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd2
	 */
	public void setArOfcCd2(String arOfcCd2) {
		this.arOfcCd2 = arOfcCd2;
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
		setPort(JSPUtil.getParameter(request, "port", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setGoodYn(JSPUtil.getParameter(request, "good_yn", ""));
		setArOfcCd2(JSPUtil.getParameter(request, "ar_ofc_cd2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvByIFVO[]
	 */
	public ARInvoiceIFDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvByIFVO[]
	 */
	public ARInvoiceIFDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceIFDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port".trim(), length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt".trim(), length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd".trim(), length));
			String[] goodYn = (JSPUtil.getParameter(request, prefix	+ "good_yn".trim(), length));
			String[] arOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd2".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceIFDateVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (goodYn[i] != null)
					model.setGoodYn(goodYn[i]);
				if (arOfcCd2[i] != null)
					model.setArOfcCd2(arOfcCd2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvByIFVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvByIFVO[]
	 */
	public ARInvoiceIFDateVO[] getInvByIFVOs(){
		ARInvoiceIFDateVO[] vos = (ARInvoiceIFDateVO[])models.toArray(new ARInvoiceIFDateVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodYn = this.goodYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd2 = this.arOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
