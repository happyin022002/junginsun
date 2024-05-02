/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GwCargoInfoVO.java
*@FileTitle : GwCargoInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.02.05 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GwCargoInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GwCargoInfoVO> models = new ArrayList<GwCargoInfoVO>();
	
	/* Column Info */
	private String reqId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xmlData = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String sysTp = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String userTp = null;
	/* Column Info */
	private String docId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GwCargoInfoVO() {}

	public GwCargoInfoVO(String ibflag, String pagerows, String userId, String docId, String reqId, String xmlData, String userTp, String sysTp, String cgoClmNo) {
		this.reqId = reqId;
		this.ibflag = ibflag;
		this.xmlData = xmlData;
		this.userId = userId;
		this.sysTp = sysTp;
		this.cgoClmNo = cgoClmNo;
		this.userTp = userTp;
		this.docId = docId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("req_id", getReqId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xml_data", getXmlData());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("sys_tp", getSysTp());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("user_tp", getUserTp());
		this.hashColumns.put("doc_id", getDocId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("req_id", "reqId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xml_data", "xmlData");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("sys_tp", "sysTp");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("user_tp", "userTp");
		this.hashFields.put("doc_id", "docId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return reqId
	 */
	public String getReqId() {
		return this.reqId;
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
	 * @return xmlData
	 */
	public String getXmlData() {
		return this.xmlData;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return sysTp
	 */
	public String getSysTp() {
		return this.sysTp;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return userTp
	 */
	public String getUserTp() {
		return this.userTp;
	}
	
	/**
	 * Column Info
	 * @return docId
	 */
	public String getDocId() {
		return this.docId;
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
	 * @param reqId
	 */
	public void setReqId(String reqId) {
		this.reqId = reqId;
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
	 * @param xmlData
	 */
	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param sysTp
	 */
	public void setSysTp(String sysTp) {
		this.sysTp = sysTp;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param userTp
	 */
	public void setUserTp(String userTp) {
		this.userTp = userTp;
	}
	
	/**
	 * Column Info
	 * @param docId
	 */
	public void setDocId(String docId) {
		this.docId = docId;
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
		setReqId(JSPUtil.getParameter(request, prefix + "req_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setXmlData(JSPUtil.getParameter(request, prefix + "xml_data", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setSysTp(JSPUtil.getParameter(request, prefix + "sys_tp", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setUserTp(JSPUtil.getParameter(request, prefix + "user_tp", ""));
		setDocId(JSPUtil.getParameter(request, prefix + "doc_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GwCargoInfoVO[]
	 */
	public GwCargoInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GwCargoInfoVO[]
	 */
	public GwCargoInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GwCargoInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] reqId = (JSPUtil.getParameter(request, prefix	+ "req_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xmlData = (JSPUtil.getParameter(request, prefix	+ "xml_data", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] sysTp = (JSPUtil.getParameter(request, prefix	+ "sys_tp", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] userTp = (JSPUtil.getParameter(request, prefix	+ "user_tp", length));
			String[] docId = (JSPUtil.getParameter(request, prefix	+ "doc_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GwCargoInfoVO();
				if (reqId[i] != null)
					model.setReqId(reqId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xmlData[i] != null)
					model.setXmlData(xmlData[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (sysTp[i] != null)
					model.setSysTp(sysTp[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (userTp[i] != null)
					model.setUserTp(userTp[i]);
				if (docId[i] != null)
					model.setDocId(docId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGwCargoInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GwCargoInfoVO[]
	 */
	public GwCargoInfoVO[] getGwCargoInfoVOs(){
		GwCargoInfoVO[] vos = (GwCargoInfoVO[])models.toArray(new GwCargoInfoVO[models.size()]);
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
		this.reqId = this.reqId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xmlData = this.xmlData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysTp = this.sysTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userTp = this.userTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docId = this.docId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
