/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SriLankaSearchCaptainNameVO.java
*@FileTitle : SriLankaSearchCaptainNameVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SriLankaSearchCaptainNameVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaSearchCaptainNameVO> models = new ArrayList<SriLankaSearchCaptainNameVO>();
	
	/* Column Info */
	private String msgRefNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsVvdCd = null;
	/* Column Info */
	private String capNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SriLankaSearchCaptainNameVO() {}

	public SriLankaSearchCaptainNameVO(String ibflag, String pagerows, String capNm, String cstmsVvdCd, String msgRefNo) {
		this.msgRefNo = msgRefNo;
		this.ibflag = ibflag;
		this.cstmsVvdCd = cstmsVvdCd;
		this.capNm = capNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_ref_no", getMsgRefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_vvd_cd", getCstmsVvdCd());
		this.hashColumns.put("cap_nm", getCapNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_ref_no", "msgRefNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_vvd_cd", "cstmsVvdCd");
		this.hashFields.put("cap_nm", "capNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgRefNo
	 */
	public String getMsgRefNo() {
		return this.msgRefNo;
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
	 * @return cstmsVvdCd
	 */
	public String getCstmsVvdCd() {
		return this.cstmsVvdCd;
	}
	
	/**
	 * Column Info
	 * @return capNm
	 */
	public String getCapNm() {
		return this.capNm;
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
	 * @param msgRefNo
	 */
	public void setMsgRefNo(String msgRefNo) {
		this.msgRefNo = msgRefNo;
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
	 * @param cstmsVvdCd
	 */
	public void setCstmsVvdCd(String cstmsVvdCd) {
		this.cstmsVvdCd = cstmsVvdCd;
	}
	
	/**
	 * Column Info
	 * @param capNm
	 */
	public void setCapNm(String capNm) {
		this.capNm = capNm;
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
		setMsgRefNo(JSPUtil.getParameter(request, prefix + "msg_ref_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCstmsVvdCd(JSPUtil.getParameter(request, prefix + "cstms_vvd_cd", ""));
		setCapNm(JSPUtil.getParameter(request, prefix + "cap_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaSearchCaptainNameVO[]
	 */
	public SriLankaSearchCaptainNameVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaSearchCaptainNameVO[]
	 */
	public SriLankaSearchCaptainNameVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaSearchCaptainNameVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_ref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsVvdCd = (JSPUtil.getParameter(request, prefix	+ "cstms_vvd_cd", length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaSearchCaptainNameVO();
				if (msgRefNo[i] != null)
					model.setMsgRefNo(msgRefNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsVvdCd[i] != null)
					model.setCstmsVvdCd(cstmsVvdCd[i]);
				if (capNm[i] != null)
					model.setCapNm(capNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaSearchCaptainNameVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaSearchCaptainNameVO[]
	 */
	public SriLankaSearchCaptainNameVO[] getSriLankaSearchCaptainNameVOs(){
		SriLankaSearchCaptainNameVO[] vos = (SriLankaSearchCaptainNameVO[])models.toArray(new SriLankaSearchCaptainNameVO[models.size()]);
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
		this.msgRefNo = this.msgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsVvdCd = this.cstmsVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
