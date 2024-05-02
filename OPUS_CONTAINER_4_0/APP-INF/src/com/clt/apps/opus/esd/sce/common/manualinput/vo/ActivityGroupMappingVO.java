/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ActivityGroupMappingVO.java
*@FileTitle : ActivityGroupMappingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.manualinput.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class ActivityGroupMappingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActivityGroupMappingVO> models = new ArrayList<ActivityGroupMappingVO>();
	
	/* Column Info */
	private String actGrpSeq = null;
	/* Column Info */
	private String actCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chkActCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String chkActGrpSeq = null;
	/* Column Info */
	private String copDtlGrpCd = null;
	/* Column Info */
	private String frmCopDtlGrpCd = null;
	/* Column Info */
	private String chkCopDtlGrpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActivityGroupMappingVO() {}

	public ActivityGroupMappingVO(String ibflag, String pagerows, String actCd, String copDtlGrpCd, String actGrpSeq, String frmCopDtlGrpCd, String chkActCd, String chkCopDtlGrpCd, String chkActGrpSeq, String userId) {
		this.actGrpSeq = actGrpSeq;
		this.actCd = actCd;
		this.ibflag = ibflag;
		this.chkActCd = chkActCd;
		this.userId = userId;
		this.chkActGrpSeq = chkActGrpSeq;
		this.copDtlGrpCd = copDtlGrpCd;
		this.frmCopDtlGrpCd = frmCopDtlGrpCd;
		this.chkCopDtlGrpCd = chkCopDtlGrpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_grp_seq", getActGrpSeq());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk_act_cd", getChkActCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("chk_act_grp_seq", getChkActGrpSeq());
		this.hashColumns.put("cop_dtl_grp_cd", getCopDtlGrpCd());
		this.hashColumns.put("frm_cop_dtl_grp_cd", getFrmCopDtlGrpCd());
		this.hashColumns.put("chk_cop_dtl_grp_cd", getChkCopDtlGrpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_grp_seq", "actGrpSeq");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk_act_cd", "chkActCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("chk_act_grp_seq", "chkActGrpSeq");
		this.hashFields.put("cop_dtl_grp_cd", "copDtlGrpCd");
		this.hashFields.put("frm_cop_dtl_grp_cd", "frmCopDtlGrpCd");
		this.hashFields.put("chk_cop_dtl_grp_cd", "chkCopDtlGrpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return actGrpSeq
	 */
	public String getActGrpSeq() {
		return this.actGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
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
	 * @return chkActCd
	 */
	public String getChkActCd() {
		return this.chkActCd;
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
	 * @return chkActGrpSeq
	 */
	public String getChkActGrpSeq() {
		return this.chkActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return copDtlGrpCd
	 */
	public String getCopDtlGrpCd() {
		return this.copDtlGrpCd;
	}
	
	/**
	 * Column Info
	 * @return frmCopDtlGrpCd
	 */
	public String getFrmCopDtlGrpCd() {
		return this.frmCopDtlGrpCd;
	}
	
	/**
	 * Column Info
	 * @return chkCopDtlGrpCd
	 */
	public String getChkCopDtlGrpCd() {
		return this.chkCopDtlGrpCd;
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
	 * @param actGrpSeq
	 */
	public void setActGrpSeq(String actGrpSeq) {
		this.actGrpSeq = actGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
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
	 * @param chkActCd
	 */
	public void setChkActCd(String chkActCd) {
		this.chkActCd = chkActCd;
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
	 * @param chkActGrpSeq
	 */
	public void setChkActGrpSeq(String chkActGrpSeq) {
		this.chkActGrpSeq = chkActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param copDtlGrpCd
	 */
	public void setCopDtlGrpCd(String copDtlGrpCd) {
		this.copDtlGrpCd = copDtlGrpCd;
	}
	
	/**
	 * Column Info
	 * @param frmCopDtlGrpCd
	 */
	public void setFrmCopDtlGrpCd(String frmCopDtlGrpCd) {
		this.frmCopDtlGrpCd = frmCopDtlGrpCd;
	}
	
	/**
	 * Column Info
	 * @param chkCopDtlGrpCd
	 */
	public void setChkCopDtlGrpCd(String chkCopDtlGrpCd) {
		this.chkCopDtlGrpCd = chkCopDtlGrpCd;
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
		setActGrpSeq(JSPUtil.getParameter(request, prefix + "act_grp_seq", ""));
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChkActCd(JSPUtil.getParameter(request, prefix + "chk_act_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setChkActGrpSeq(JSPUtil.getParameter(request, prefix + "chk_act_grp_seq", ""));
		setCopDtlGrpCd(JSPUtil.getParameter(request, prefix + "cop_dtl_grp_cd", ""));
		setFrmCopDtlGrpCd(JSPUtil.getParameter(request, prefix + "frm_cop_dtl_grp_cd", ""));
		setChkCopDtlGrpCd(JSPUtil.getParameter(request, prefix + "chk_cop_dtl_grp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActivityGroupMappingVO[]
	 */
	public ActivityGroupMappingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActivityGroupMappingVO[]
	 */
	public ActivityGroupMappingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActivityGroupMappingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] actGrpSeq = (JSPUtil.getParameter(request, prefix	+ "act_grp_seq", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chkActCd = (JSPUtil.getParameter(request, prefix	+ "chk_act_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] chkActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "chk_act_grp_seq", length));
			String[] copDtlGrpCd = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_grp_cd", length));
			String[] frmCopDtlGrpCd = (JSPUtil.getParameter(request, prefix	+ "frm_cop_dtl_grp_cd", length));
			String[] chkCopDtlGrpCd = (JSPUtil.getParameter(request, prefix	+ "chk_cop_dtl_grp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActivityGroupMappingVO();
				if (actGrpSeq[i] != null)
					model.setActGrpSeq(actGrpSeq[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chkActCd[i] != null)
					model.setChkActCd(chkActCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (chkActGrpSeq[i] != null)
					model.setChkActGrpSeq(chkActGrpSeq[i]);
				if (copDtlGrpCd[i] != null)
					model.setCopDtlGrpCd(copDtlGrpCd[i]);
				if (frmCopDtlGrpCd[i] != null)
					model.setFrmCopDtlGrpCd(frmCopDtlGrpCd[i]);
				if (chkCopDtlGrpCd[i] != null)
					model.setChkCopDtlGrpCd(chkCopDtlGrpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActivityGroupMappingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActivityGroupMappingVO[]
	 */
	public ActivityGroupMappingVO[] getActivityGroupMappingVOs(){
		ActivityGroupMappingVO[] vos = (ActivityGroupMappingVO[])models.toArray(new ActivityGroupMappingVO[models.size()]);
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
		this.actGrpSeq = this.actGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkActCd = this.chkActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkActGrpSeq = this.chkActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlGrpCd = this.copDtlGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCopDtlGrpCd = this.frmCopDtlGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCopDtlGrpCd = this.chkCopDtlGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
