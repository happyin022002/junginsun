/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TemplateItemVO.java
*@FileTitle : TemplateItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.10.14 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TemplateItemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TemplateItemVO> models = new ArrayList<TemplateItemVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String itmSeq = null;
	/* Column Info */
	private String usrDefNm = null;
	/* Column Info */
	private String rptTmpltNm = null;
	/* Column Info */
	private String rptItmId = null;
	/* Column Info */
	private String rptAuthId = null;
	/* Column Info */
	private String rptItmNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TemplateItemVO() {}

	public TemplateItemVO(String ibflag, String pagerows, String rptItmNm, String rptTmpltNm, String rptItmId, String usrDefNm, String itmSeq, String rptAuthId) {
		this.ibflag = ibflag;
		this.itmSeq = itmSeq;
		this.usrDefNm = usrDefNm;
		this.rptTmpltNm = rptTmpltNm;
		this.rptItmId = rptItmId;
		this.rptAuthId = rptAuthId;
		this.rptItmNm = rptItmNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("itm_seq", getItmSeq());
		this.hashColumns.put("usr_def_nm", getUsrDefNm());
		this.hashColumns.put("rpt_tmplt_nm", getRptTmpltNm());
		this.hashColumns.put("rpt_itm_id", getRptItmId());
		this.hashColumns.put("rpt_auth_id", getRptAuthId());
		this.hashColumns.put("rpt_itm_nm", getRptItmNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("itm_seq", "itmSeq");
		this.hashFields.put("usr_def_nm", "usrDefNm");
		this.hashFields.put("rpt_tmplt_nm", "rptTmpltNm");
		this.hashFields.put("rpt_itm_id", "rptItmId");
		this.hashFields.put("rpt_auth_id", "rptAuthId");
		this.hashFields.put("rpt_itm_nm", "rptItmNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return itmSeq
	 */
	public String getItmSeq() {
		return this.itmSeq;
	}
	
	/**
	 * Column Info
	 * @return usrDefNm
	 */
	public String getUsrDefNm() {
		return this.usrDefNm;
	}
	
	/**
	 * Column Info
	 * @return rptTmpltNm
	 */
	public String getRptTmpltNm() {
		return this.rptTmpltNm;
	}
	
	/**
	 * Column Info
	 * @return rptItmId
	 */
	public String getRptItmId() {
		return this.rptItmId;
	}
	
	/**
	 * Column Info
	 * @return rptAuthId
	 */
	public String getRptAuthId() {
		return this.rptAuthId;
	}
	
	/**
	 * Column Info
	 * @return rptItmNm
	 */
	public String getRptItmNm() {
		return this.rptItmNm;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param itmSeq
	 */
	public void setItmSeq(String itmSeq) {
		this.itmSeq = itmSeq;
	}
	
	/**
	 * Column Info
	 * @param usrDefNm
	 */
	public void setUsrDefNm(String usrDefNm) {
		this.usrDefNm = usrDefNm;
	}
	
	/**
	 * Column Info
	 * @param rptTmpltNm
	 */
	public void setRptTmpltNm(String rptTmpltNm) {
		this.rptTmpltNm = rptTmpltNm;
	}
	
	/**
	 * Column Info
	 * @param rptItmId
	 */
	public void setRptItmId(String rptItmId) {
		this.rptItmId = rptItmId;
	}
	
	/**
	 * Column Info
	 * @param rptAuthId
	 */
	public void setRptAuthId(String rptAuthId) {
		this.rptAuthId = rptAuthId;
	}
	
	/**
	 * Column Info
	 * @param rptItmNm
	 */
	public void setRptItmNm(String rptItmNm) {
		this.rptItmNm = rptItmNm;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setItmSeq(JSPUtil.getParameter(request, "itm_seq", ""));
		setUsrDefNm(JSPUtil.getParameter(request, "usr_def_nm", ""));
		setRptTmpltNm(JSPUtil.getParameter(request, "rpt_tmplt_nm", ""));
		setRptItmId(JSPUtil.getParameter(request, "rpt_itm_id", ""));
		setRptAuthId(JSPUtil.getParameter(request, "rpt_auth_id", ""));
		setRptItmNm(JSPUtil.getParameter(request, "rpt_itm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TemplateItemVO[]
	 */
	public TemplateItemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TemplateItemVO[]
	 */
	public TemplateItemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TemplateItemVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] itmSeq = (JSPUtil.getParameter(request, prefix	+ "itm_seq", length));
			String[] usrDefNm = (JSPUtil.getParameter(request, prefix	+ "usr_def_nm", length));
			String[] rptTmpltNm = (JSPUtil.getParameter(request, prefix	+ "rpt_tmplt_nm", length));
			String[] rptItmId = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_id", length));
			String[] rptAuthId = (JSPUtil.getParameter(request, prefix	+ "rpt_auth_id", length));
			String[] rptItmNm = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TemplateItemVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (itmSeq[i] != null)
					model.setItmSeq(itmSeq[i]);
				if (usrDefNm[i] != null)
					model.setUsrDefNm(usrDefNm[i]);
				if (rptTmpltNm[i] != null)
					model.setRptTmpltNm(rptTmpltNm[i]);
				if (rptItmId[i] != null)
					model.setRptItmId(rptItmId[i]);
				if (rptAuthId[i] != null)
					model.setRptAuthId(rptAuthId[i]);
				if (rptItmNm[i] != null)
					model.setRptItmNm(rptItmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTemplateItemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TemplateItemVO[]
	 */
	public TemplateItemVO[] getTemplateItemVOs(){
		TemplateItemVO[] vos = (TemplateItemVO[])models.toArray(new TemplateItemVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmSeq = this.itmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrDefNm = this.usrDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptTmpltNm = this.rptTmpltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmId = this.rptItmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptAuthId = this.rptAuthId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmNm = this.rptItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
