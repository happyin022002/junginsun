/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : XptLicNoVO.java
*@FileTitle : XptLicNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.20 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XptLicNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XptLicNoVO> models = new ArrayList<XptLicNoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String idXptNoIssDt = null;
	/* Column Info */
	private String xptLicNo = null;
	/* Column Info */
	private String idOfcId = null;
	/* Column Info */
	private String idDeclCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XptLicNoVO() {}

	public XptLicNoVO(String ibflag, String pagerows, String xptLicNo, String idXptNoIssDt, String idOfcId, String idDeclCd) {
		this.ibflag = ibflag;
		this.idXptNoIssDt = idXptNoIssDt;
		this.xptLicNo = xptLicNo;
		this.idOfcId = idOfcId;
		this.idDeclCd = idDeclCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("id_xpt_no_iss_dt", getIdXptNoIssDt());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("id_ofc_id", getIdOfcId());
		this.hashColumns.put("id_decl_cd", getIdDeclCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("id_xpt_no_iss_dt", "idXptNoIssDt");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("id_ofc_id", "idOfcId");
		this.hashFields.put("id_decl_cd", "idDeclCd");
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
	 * @return idXptNoIssDt
	 */
	public String getIdXptNoIssDt() {
		return this.idXptNoIssDt;
	}
	
	/**
	 * Column Info
	 * @return xptLicNo
	 */
	public String getXptLicNo() {
		return this.xptLicNo;
	}
	
	/**
	 * Column Info
	 * @return idOfcId
	 */
	public String getIdOfcId() {
		return this.idOfcId;
	}
	
	/**
	 * Column Info
	 * @return idDeclCd
	 */
	public String getIdDeclCd() {
		return this.idDeclCd;
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
	 * @param idXptNoIssDt
	 */
	public void setIdXptNoIssDt(String idXptNoIssDt) {
		this.idXptNoIssDt = idXptNoIssDt;
	}
	
	/**
	 * Column Info
	 * @param xptLicNo
	 */
	public void setXptLicNo(String xptLicNo) {
		this.xptLicNo = xptLicNo;
	}
	
	/**
	 * Column Info
	 * @param idOfcId
	 */
	public void setIdOfcId(String idOfcId) {
		this.idOfcId = idOfcId;
	}
	
	/**
	 * Column Info
	 * @param idDeclCd
	 */
	public void setIdDeclCd(String idDeclCd) {
		this.idDeclCd = idDeclCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIdXptNoIssDt(JSPUtil.getParameter(request, prefix + "id_xpt_no_iss_dt", ""));
		setXptLicNo(JSPUtil.getParameter(request, prefix + "xpt_lic_no", ""));
		setIdOfcId(JSPUtil.getParameter(request, prefix + "id_ofc_id", ""));
		setIdDeclCd(JSPUtil.getParameter(request, prefix + "id_decl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XptLicNoVO[]
	 */
	public XptLicNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XptLicNoVO[]
	 */
	public XptLicNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XptLicNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] idXptNoIssDt = (JSPUtil.getParameter(request, prefix	+ "id_xpt_no_iss_dt", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] idOfcId = (JSPUtil.getParameter(request, prefix	+ "id_ofc_id", length));
			String[] idDeclCd = (JSPUtil.getParameter(request, prefix	+ "id_decl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new XptLicNoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (idXptNoIssDt[i] != null)
					model.setIdXptNoIssDt(idXptNoIssDt[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
				if (idOfcId[i] != null)
					model.setIdOfcId(idOfcId[i]);
				if (idDeclCd[i] != null)
					model.setIdDeclCd(idDeclCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXptLicNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XptLicNoVO[]
	 */
	public XptLicNoVO[] getXptLicNoVOs(){
		XptLicNoVO[] vos = (XptLicNoVO[])models.toArray(new XptLicNoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idXptNoIssDt = this.idXptNoIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idOfcId = this.idOfcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idDeclCd = this.idDeclCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
