/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JapanManifestListEtcVO.java
*@FileTitle : JapanManifestListEtcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapanManifestListEtcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListEtcVO> models = new ArrayList<JapanManifestListEtcVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cyOprId = null;
	/* Column Info */
	private String cstmsMfId = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ibCssmVoyNo = null;
	/* Column Info */
	private String downloadYn = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JapanManifestListEtcVO() {}

	public JapanManifestListEtcVO(String ibflag, String pagerows, String cstmsMfId, String cyOprId, String callSgnNo, String etaDt, String ibCssmVoyNo, String downloadYn) {
		this.ibflag = ibflag;
		this.cyOprId = cyOprId;
		this.cstmsMfId = cstmsMfId;
		this.etaDt = etaDt;
		this.callSgnNo = callSgnNo;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.downloadYn = downloadYn;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cy_opr_id", getCyOprId());
		this.hashColumns.put("cstms_mf_id", getCstmsMfId());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("download_yn", getDownloadYn());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cy_opr_id", "cyOprId");
		this.hashFields.put("cstms_mf_id", "cstmsMfId");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("download_yn", "downloadYn");
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
	 * @return cyOprId
	 */
	public String getCyOprId() {
		return this.cyOprId;
	}
	
	/**
	 * Column Info
	 * @return cstmsMfId
	 */
	public String getCstmsMfId() {
		return this.cstmsMfId;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
	public String getIbCssmVoyNo() {
		return this.ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return downloadYn
	 */
	public String getDownloadYn() {
		return this.downloadYn;
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
	 * @param cyOprId
	 */
	public void setCyOprId(String cyOprId) {
		this.cyOprId = cyOprId;
	}
	
	/**
	 * Column Info
	 * @param cstmsMfId
	 */
	public void setCstmsMfId(String cstmsMfId) {
		this.cstmsMfId = cstmsMfId;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param ibCssmVoyNo
	 */
	public void setIbCssmVoyNo(String ibCssmVoyNo) {
		this.ibCssmVoyNo = ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param downloadYn
	 */
	public void setDownloadYn(String downloadYn) {
		this.downloadYn = downloadYn;
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
		setCyOprId(JSPUtil.getParameter(request, prefix + "cy_opr_id", ""));
		setCstmsMfId(JSPUtil.getParameter(request, prefix + "cstms_mf_id", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
		setDownloadYn(JSPUtil.getParameter(request, prefix + "download_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListEtcVO[]
	 */
	public JapanManifestListEtcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListEtcVO[]
	 */
	public JapanManifestListEtcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListEtcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cyOprId = (JSPUtil.getParameter(request, prefix	+ "cy_opr_id", length));
			String[] cstmsMfId = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_id", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no", length));
			String[] downloadYn = (JSPUtil.getParameter(request, prefix	+ "download_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListEtcVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cyOprId[i] != null)
					model.setCyOprId(cyOprId[i]);
				if (cstmsMfId[i] != null)
					model.setCstmsMfId(cstmsMfId[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ibCssmVoyNo[i] != null)
					model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (downloadYn[i] != null)
					model.setDownloadYn(downloadYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListEtcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListEtcVO[]
	 */
	public JapanManifestListEtcVO[] getJapanManifestListEtcVOs(){
		JapanManifestListEtcVO[] vos = (JapanManifestListEtcVO[])models.toArray(new JapanManifestListEtcVO[models.size()]);
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
		this.cyOprId = this.cyOprId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsMfId = this.cstmsMfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo = this.ibCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.downloadYn = this.downloadYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
