/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RlstSearchSelfAuditListVO.java
*@FileTitle : RlstSearchSelfAuditListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.20
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

public class RlstSearchSelfAuditListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RlstSearchSelfAuditListVO> models = new ArrayList<RlstSearchSelfAuditListVO>();

	private List<UnmatchBLVO> unmatchBlVoList = null;
	private String auditResultNm = null;
	private String result = null;
	private String ibflag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RlstSearchSelfAuditListVO() {}

	public RlstSearchSelfAuditListVO(List<UnmatchBLVO> unmatchBlVoList, String auditResultNm, String result, String ibflag) {
		this.unmatchBlVoList = unmatchBlVoList;
		this.auditResultNm = auditResultNm;
		this.result = result;
		this.ibflag = ibflag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("unmatchBlVoList", unmatchBlVoList.toString());
		this.hashColumns.put("auditResultNm", getAuditResultNm());
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("ibflag", getIbflag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("unmatchBlVoList", "unmatchBlVoList");
		this.hashFields.put("auditResultNm", "auditResultNm");
		this.hashFields.put("result", "result");
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return unmatchBlVoList
	 */
	public List<UnmatchBLVO> getUnmatchBlVoList() {
		return unmatchBlVoList;
	}

	/**
	 * Column Info
	 * @return auditResultNm
	 */
	public String getAuditResultNm() {
		return auditResultNm;
	}

	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * Column Info
	 * @param unmatchBlVoList
	 */
	public void setUnmatchBlVoList(List<UnmatchBLVO> unmatchBlVoList) {
		this.unmatchBlVoList = unmatchBlVoList;
	}

	/**
	 * Column Info
	 * @param auditResultNm
	 */
	public void setAuditResultNm(String auditResultNm) {
		this.auditResultNm = auditResultNm;
	}

	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setResult(JSPUtil.getParameter(request, "unmatchBlVoList", ""));
		setResult(JSPUtil.getParameter(request, "auditResultNm", ""));
		setResult(JSPUtil.getParameter(request, "result", ""));
		setResult(JSPUtil.getParameter(request, "ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnmatchBLVO[]
	 */
	public RlstSearchSelfAuditListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnmatchBLVO[]
	 */
	public RlstSearchSelfAuditListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RlstSearchSelfAuditListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] unmatchBlVoList = (JSPUtil.getParameter(request, prefix	+ "unmatchBlVoList", length));
			String[] auditResultNm = (JSPUtil.getParameter(request, prefix	+ "auditResultNm", length));
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			
			for (int i = 0; i < length; i++) {
				model = new RlstSearchSelfAuditListVO();
				if (unmatchBlVoList[i] != null)
					model.setResult(unmatchBlVoList[i]);
				if (auditResultNm[i] != null)
					model.setResult(auditResultNm[i]);
				if (result[i] != null)
					model.setResult(result[i]);
				if (ibflag[i] != null)
					model.setResult(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnmatchBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnmatchBLVO[]
	 */
	public RlstSearchSelfAuditListVO[] getUnmatchBLVOs(){
		RlstSearchSelfAuditListVO[] vos = (RlstSearchSelfAuditListVO[])models.toArray(new RlstSearchSelfAuditListVO[models.size()]);
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
		this.auditResultNm = this.auditResultNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
