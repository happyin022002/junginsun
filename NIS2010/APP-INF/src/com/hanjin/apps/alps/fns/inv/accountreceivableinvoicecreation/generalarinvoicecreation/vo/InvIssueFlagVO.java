/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvIssueFlagVO.java
*@FileTitle : InvIssueFlagVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.10.20 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvIssueFlagVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvIssueFlagVO> models = new ArrayList<InvIssueFlagVO>();
	
	/* Column Info */
	private String issueFlag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String reissueFlag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvIssueFlagVO() {}

	public InvIssueFlagVO(String ibflag, String pagerows, String issueFlag, String reissueFlag) {
		this.issueFlag = issueFlag;
		this.ibflag = ibflag;
		this.reissueFlag = reissueFlag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("issue_flag", getIssueFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("reissue_flag", getReissueFlag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("issue_flag", "issueFlag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("reissue_flag", "reissueFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return issueFlag
	 */
	public String getIssueFlag() {
		return this.issueFlag;
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
	 * @return reissueFlag
	 */
	public String getReissueFlag() {
		return this.reissueFlag;
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
	 * @param issueFlag
	 */
	public void setIssueFlag(String issueFlag) {
		this.issueFlag = issueFlag;
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
	 * @param reissueFlag
	 */
	public void setReissueFlag(String reissueFlag) {
		this.reissueFlag = reissueFlag;
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
		setIssueFlag(JSPUtil.getParameter(request, "issue_flag", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setReissueFlag(JSPUtil.getParameter(request, "reissue_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvIssueFlagVO[]
	 */
	public InvIssueFlagVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvIssueFlagVO[]
	 */
	public InvIssueFlagVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvIssueFlagVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] issueFlag = (JSPUtil.getParameter(request, prefix	+ "issue_flag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] reissueFlag = (JSPUtil.getParameter(request, prefix	+ "reissue_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvIssueFlagVO();
				if (issueFlag[i] != null)
					model.setIssueFlag(issueFlag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (reissueFlag[i] != null)
					model.setReissueFlag(reissueFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvIssueFlagVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvIssueFlagVO[]
	 */
	public InvIssueFlagVO[] getInvIssueFlagVOs(){
		InvIssueFlagVO[] vos = (InvIssueFlagVO[])models.toArray(new InvIssueFlagVO[models.size()]);
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
		this.issueFlag = this.issueFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reissueFlag = this.reissueFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
