/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DblWblCntVO.java
*@FileTitle : DblWblCntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.09.24 이일민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DblWblCntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DblWblCntVO> models = new ArrayList<DblWblCntVO>();
	
	/* Column Info */
	private String faxFailed = null;
	/* Column Info */
	private String emlSuccess = null;
	/* Column Info */
	private String emlFailed = null;
	/* Column Info */
	private String emlNoSend = null;
	/* Column Info */
	private String faxNoSend = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String faxBlTotal = null;
	/* Column Info */
	private String emlTotal = null;
	/* Column Info */
	private String faxTotal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String faxSending = null;
	/* Column Info */
	private String emlSending = null;
	/* Column Info */
	private String emlBlTotal = null;
	/* Column Info */
	private String faxSuccess = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DblWblCntVO() {}

	public DblWblCntVO(String ibflag, String pagerows, String faxBlTotal, String faxTotal, String faxSuccess, String faxSending, String faxNoSend, String faxFailed, String emlBlTotal, String emlTotal, String emlSuccess, String emlSending, String emlNoSend, String emlFailed) {
		this.faxFailed = faxFailed;
		this.emlSuccess = emlSuccess;
		this.emlFailed = emlFailed;
		this.emlNoSend = emlNoSend;
		this.faxNoSend = faxNoSend;
		this.pagerows = pagerows;
		this.faxBlTotal = faxBlTotal;
		this.emlTotal = emlTotal;
		this.faxTotal = faxTotal;
		this.ibflag = ibflag;
		this.faxSending = faxSending;
		this.emlSending = emlSending;
		this.emlBlTotal = emlBlTotal;
		this.faxSuccess = faxSuccess;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fax_failed", getFaxFailed());
		this.hashColumns.put("eml_success", getEmlSuccess());
		this.hashColumns.put("eml_failed", getEmlFailed());
		this.hashColumns.put("eml_no_send", getEmlNoSend());
		this.hashColumns.put("fax_no_send", getFaxNoSend());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fax_bl_total", getFaxBlTotal());
		this.hashColumns.put("eml_total", getEmlTotal());
		this.hashColumns.put("fax_total", getFaxTotal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fax_sending", getFaxSending());
		this.hashColumns.put("eml_sending", getEmlSending());
		this.hashColumns.put("eml_bl_total", getEmlBlTotal());
		this.hashColumns.put("fax_success", getFaxSuccess());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fax_failed", "faxFailed");
		this.hashFields.put("eml_success", "emlSuccess");
		this.hashFields.put("eml_failed", "emlFailed");
		this.hashFields.put("eml_no_send", "emlNoSend");
		this.hashFields.put("fax_no_send", "faxNoSend");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fax_bl_total", "faxBlTotal");
		this.hashFields.put("eml_total", "emlTotal");
		this.hashFields.put("fax_total", "faxTotal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fax_sending", "faxSending");
		this.hashFields.put("eml_sending", "emlSending");
		this.hashFields.put("eml_bl_total", "emlBlTotal");
		this.hashFields.put("fax_success", "faxSuccess");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return faxFailed
	 */
	public String getFaxFailed() {
		return this.faxFailed;
	}
	
	/**
	 * Column Info
	 * @return emlSuccess
	 */
	public String getEmlSuccess() {
		return this.emlSuccess;
	}
	
	/**
	 * Column Info
	 * @return emlFailed
	 */
	public String getEmlFailed() {
		return this.emlFailed;
	}
	
	/**
	 * Column Info
	 * @return emlNoSend
	 */
	public String getEmlNoSend() {
		return this.emlNoSend;
	}
	
	/**
	 * Column Info
	 * @return faxNoSend
	 */
	public String getFaxNoSend() {
		return this.faxNoSend;
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
	 * @return faxBlTotal
	 */
	public String getFaxBlTotal() {
		return this.faxBlTotal;
	}
	
	/**
	 * Column Info
	 * @return emlTotal
	 */
	public String getEmlTotal() {
		return this.emlTotal;
	}
	
	/**
	 * Column Info
	 * @return faxTotal
	 */
	public String getFaxTotal() {
		return this.faxTotal;
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
	 * @return faxSending
	 */
	public String getFaxSending() {
		return this.faxSending;
	}
	
	/**
	 * Column Info
	 * @return emlSending
	 */
	public String getEmlSending() {
		return this.emlSending;
	}
	
	/**
	 * Column Info
	 * @return emlBlTotal
	 */
	public String getEmlBlTotal() {
		return this.emlBlTotal;
	}
	
	/**
	 * Column Info
	 * @return faxSuccess
	 */
	public String getFaxSuccess() {
		return this.faxSuccess;
	}
	

	/**
	 * Column Info
	 * @param faxFailed
	 */
	public void setFaxFailed(String faxFailed) {
		this.faxFailed = faxFailed;
	}
	
	/**
	 * Column Info
	 * @param emlSuccess
	 */
	public void setEmlSuccess(String emlSuccess) {
		this.emlSuccess = emlSuccess;
	}
	
	/**
	 * Column Info
	 * @param emlFailed
	 */
	public void setEmlFailed(String emlFailed) {
		this.emlFailed = emlFailed;
	}
	
	/**
	 * Column Info
	 * @param emlNoSend
	 */
	public void setEmlNoSend(String emlNoSend) {
		this.emlNoSend = emlNoSend;
	}
	
	/**
	 * Column Info
	 * @param faxNoSend
	 */
	public void setFaxNoSend(String faxNoSend) {
		this.faxNoSend = faxNoSend;
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
	 * @param faxBlTotal
	 */
	public void setFaxBlTotal(String faxBlTotal) {
		this.faxBlTotal = faxBlTotal;
	}
	
	/**
	 * Column Info
	 * @param emlTotal
	 */
	public void setEmlTotal(String emlTotal) {
		this.emlTotal = emlTotal;
	}
	
	/**
	 * Column Info
	 * @param faxTotal
	 */
	public void setFaxTotal(String faxTotal) {
		this.faxTotal = faxTotal;
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
	 * @param faxSending
	 */
	public void setFaxSending(String faxSending) {
		this.faxSending = faxSending;
	}
	
	/**
	 * Column Info
	 * @param emlSending
	 */
	public void setEmlSending(String emlSending) {
		this.emlSending = emlSending;
	}
	
	/**
	 * Column Info
	 * @param emlBlTotal
	 */
	public void setEmlBlTotal(String emlBlTotal) {
		this.emlBlTotal = emlBlTotal;
	}
	
	/**
	 * Column Info
	 * @param faxSuccess
	 */
	public void setFaxSuccess(String faxSuccess) {
		this.faxSuccess = faxSuccess;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFaxFailed(JSPUtil.getParameter(request, "fax_failed", ""));
		setEmlSuccess(JSPUtil.getParameter(request, "eml_success", ""));
		setEmlFailed(JSPUtil.getParameter(request, "eml_failed", ""));
		setEmlNoSend(JSPUtil.getParameter(request, "eml_no_send", ""));
		setFaxNoSend(JSPUtil.getParameter(request, "fax_no_send", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFaxBlTotal(JSPUtil.getParameter(request, "fax_bl_total", ""));
		setEmlTotal(JSPUtil.getParameter(request, "eml_total", ""));
		setFaxTotal(JSPUtil.getParameter(request, "fax_total", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFaxSending(JSPUtil.getParameter(request, "fax_sending", ""));
		setEmlSending(JSPUtil.getParameter(request, "eml_sending", ""));
		setEmlBlTotal(JSPUtil.getParameter(request, "eml_bl_total", ""));
		setFaxSuccess(JSPUtil.getParameter(request, "fax_success", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DblWblCntVO[]
	 */
	public DblWblCntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DblWblCntVO[]
	 */
	public DblWblCntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DblWblCntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] faxFailed = (JSPUtil.getParameter(request, prefix	+ "fax_failed", length));
			String[] emlSuccess = (JSPUtil.getParameter(request, prefix	+ "eml_success", length));
			String[] emlFailed = (JSPUtil.getParameter(request, prefix	+ "eml_failed", length));
			String[] emlNoSend = (JSPUtil.getParameter(request, prefix	+ "eml_no_send", length));
			String[] faxNoSend = (JSPUtil.getParameter(request, prefix	+ "fax_no_send", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] faxBlTotal = (JSPUtil.getParameter(request, prefix	+ "fax_bl_total", length));
			String[] emlTotal = (JSPUtil.getParameter(request, prefix	+ "eml_total", length));
			String[] faxTotal = (JSPUtil.getParameter(request, prefix	+ "fax_total", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] faxSending = (JSPUtil.getParameter(request, prefix	+ "fax_sending", length));
			String[] emlSending = (JSPUtil.getParameter(request, prefix	+ "eml_sending", length));
			String[] emlBlTotal = (JSPUtil.getParameter(request, prefix	+ "eml_bl_total", length));
			String[] faxSuccess = (JSPUtil.getParameter(request, prefix	+ "fax_success", length));
			
			for (int i = 0; i < length; i++) {
				model = new DblWblCntVO();
				if (faxFailed[i] != null)
					model.setFaxFailed(faxFailed[i]);
				if (emlSuccess[i] != null)
					model.setEmlSuccess(emlSuccess[i]);
				if (emlFailed[i] != null)
					model.setEmlFailed(emlFailed[i]);
				if (emlNoSend[i] != null)
					model.setEmlNoSend(emlNoSend[i]);
				if (faxNoSend[i] != null)
					model.setFaxNoSend(faxNoSend[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (faxBlTotal[i] != null)
					model.setFaxBlTotal(faxBlTotal[i]);
				if (emlTotal[i] != null)
					model.setEmlTotal(emlTotal[i]);
				if (faxTotal[i] != null)
					model.setFaxTotal(faxTotal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (faxSending[i] != null)
					model.setFaxSending(faxSending[i]);
				if (emlSending[i] != null)
					model.setEmlSending(emlSending[i]);
				if (emlBlTotal[i] != null)
					model.setEmlBlTotal(emlBlTotal[i]);
				if (faxSuccess[i] != null)
					model.setFaxSuccess(faxSuccess[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDblWblCntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DblWblCntVO[]
	 */
	public DblWblCntVO[] getDblWblCntVOs(){
		DblWblCntVO[] vos = (DblWblCntVO[])models.toArray(new DblWblCntVO[models.size()]);
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
		this.faxFailed = this.faxFailed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSuccess = this.emlSuccess .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFailed = this.emlFailed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlNoSend = this.emlNoSend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNoSend = this.faxNoSend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxBlTotal = this.faxBlTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlTotal = this.emlTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxTotal = this.faxTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSending = this.faxSending .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSending = this.emlSending .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlBlTotal = this.emlBlTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSuccess = this.faxSuccess .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
