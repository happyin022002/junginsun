/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExptSubReqListVO.java
*@FileTitle : SearchExptSubReqListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.28 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo;

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
 * @author 이중환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchExptSubReqListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExptSubReqListVO> models = new ArrayList<SearchExptSubReqListVO>();
	
	/* Column Info */
	private String rName = null;
	/* Column Info */
	private String rSubscGrpCd = null;
	/* Column Info */
	private String rNtfdOfcCd = null;
	/* Column Info */
	private String copExptSubscCsSeq = null;
	/* Column Info */
	private String subscGrpNtfdPtyCd = null;
	/* Column Info */
	private String rGlobalId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rAct = null;
	/* Column Info */
	private String rEmail = null;
	/* Column Info */
	private String rUsrId = null;
	/* Column Info */
	private String rCntOfc = null;
	/* Column Info */
	private String rUpdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExptSubReqListVO() {}

	public SearchExptSubReqListVO(String ibflag, String pagerows, String copExptSubscCsSeq, String rNtfdOfcCd, String rGlobalId, String rName, String rEmail, String rAct, String rUsrId, String rUpdDt, String rSubscGrpCd, String subscGrpNtfdPtyCd, String rCntOfc) {
		this.rName = rName;
		this.rSubscGrpCd = rSubscGrpCd;
		this.rNtfdOfcCd = rNtfdOfcCd;
		this.copExptSubscCsSeq = copExptSubscCsSeq;
		this.subscGrpNtfdPtyCd = subscGrpNtfdPtyCd;
		this.rGlobalId = rGlobalId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rAct = rAct;
		this.rEmail = rEmail;
		this.rUsrId = rUsrId;
		this.rCntOfc = rCntOfc;
		this.rUpdDt = rUpdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r_name", getRName());
		this.hashColumns.put("r_subsc_grp_cd", getRSubscGrpCd());
		this.hashColumns.put("r_ntfd_ofc_cd", getRNtfdOfcCd());
		this.hashColumns.put("cop_expt_subsc_cs_seq", getCopExptSubscCsSeq());
		this.hashColumns.put("subsc_grp_ntfd_pty_cd", getSubscGrpNtfdPtyCd());
		this.hashColumns.put("r_global_id", getRGlobalId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r_act", getRAct());
		this.hashColumns.put("r_email", getREmail());
		this.hashColumns.put("r_usr_id", getRUsrId());
		this.hashColumns.put("r_cnt_ofc", getRCntOfc());
		this.hashColumns.put("r_upd_dt", getRUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r_name", "rName");
		this.hashFields.put("r_subsc_grp_cd", "rSubscGrpCd");
		this.hashFields.put("r_ntfd_ofc_cd", "rNtfdOfcCd");
		this.hashFields.put("cop_expt_subsc_cs_seq", "copExptSubscCsSeq");
		this.hashFields.put("subsc_grp_ntfd_pty_cd", "subscGrpNtfdPtyCd");
		this.hashFields.put("r_global_id", "rGlobalId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r_act", "rAct");
		this.hashFields.put("r_email", "rEmail");
		this.hashFields.put("r_usr_id", "rUsrId");
		this.hashFields.put("r_cnt_ofc", "rCntOfc");
		this.hashFields.put("r_upd_dt", "rUpdDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rName
	 */
	public String getRName() {
		return this.rName;
	}
	
	/**
	 * Column Info
	 * @return rSubscGrpCd
	 */
	public String getRSubscGrpCd() {
		return this.rSubscGrpCd;
	}
	
	/**
	 * Column Info
	 * @return rNtfdOfcCd
	 */
	public String getRNtfdOfcCd() {
		return this.rNtfdOfcCd;
	}
	
	/**
	 * Column Info
	 * @return copExptSubscCsSeq
	 */
	public String getCopExptSubscCsSeq() {
		return this.copExptSubscCsSeq;
	}
	
	/**
	 * Column Info
	 * @return subscGrpNtfdPtyCd
	 */
	public String getSubscGrpNtfdPtyCd() {
		return this.subscGrpNtfdPtyCd;
	}
	
	/**
	 * Column Info
	 * @return rGlobalId
	 */
	public String getRGlobalId() {
		return this.rGlobalId;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return rAct
	 */
	public String getRAct() {
		return this.rAct;
	}
	
	/**
	 * Column Info
	 * @return rEmail
	 */
	public String getREmail() {
		return this.rEmail;
	}
	
	/**
	 * Column Info
	 * @return rUsrId
	 */
	public String getRUsrId() {
		return this.rUsrId;
	}
	
	/**
	 * Column Info
	 * @return rCntOfc
	 */
	public String getRCntOfc() {
		return this.rCntOfc;
	}
	
	/**
	 * Column Info
	 * @return rUpdDt
	 */
	public String getRUpdDt() {
		return this.rUpdDt;
	}
	

	/**
	 * Column Info
	 * @param rName
	 */
	public void setRName(String rName) {
		this.rName = rName;
	}
	
	/**
	 * Column Info
	 * @param rSubscGrpCd
	 */
	public void setRSubscGrpCd(String rSubscGrpCd) {
		this.rSubscGrpCd = rSubscGrpCd;
	}
	
	/**
	 * Column Info
	 * @param rNtfdOfcCd
	 */
	public void setRNtfdOfcCd(String rNtfdOfcCd) {
		this.rNtfdOfcCd = rNtfdOfcCd;
	}
	
	/**
	 * Column Info
	 * @param copExptSubscCsSeq
	 */
	public void setCopExptSubscCsSeq(String copExptSubscCsSeq) {
		this.copExptSubscCsSeq = copExptSubscCsSeq;
	}
	
	/**
	 * Column Info
	 * @param subscGrpNtfdPtyCd
	 */
	public void setSubscGrpNtfdPtyCd(String subscGrpNtfdPtyCd) {
		this.subscGrpNtfdPtyCd = subscGrpNtfdPtyCd;
	}
	
	/**
	 * Column Info
	 * @param rGlobalId
	 */
	public void setRGlobalId(String rGlobalId) {
		this.rGlobalId = rGlobalId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param rAct
	 */
	public void setRAct(String rAct) {
		this.rAct = rAct;
	}
	
	/**
	 * Column Info
	 * @param rEmail
	 */
	public void setREmail(String rEmail) {
		this.rEmail = rEmail;
	}
	
	/**
	 * Column Info
	 * @param rUsrId
	 */
	public void setRUsrId(String rUsrId) {
		this.rUsrId = rUsrId;
	}
	
	/**
	 * Column Info
	 * @param rCntOfc
	 */
	public void setRCntOfc(String rCntOfc) {
		this.rCntOfc = rCntOfc;
	}
	
	/**
	 * Column Info
	 * @param rUpdDt
	 */
	public void setRUpdDt(String rUpdDt) {
		this.rUpdDt = rUpdDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRName(JSPUtil.getParameter(request, "r_name", ""));
		setRSubscGrpCd(JSPUtil.getParameter(request, "r_subsc_grp_cd", ""));
		setRNtfdOfcCd(JSPUtil.getParameter(request, "r_ntfd_ofc_cd", ""));
		setCopExptSubscCsSeq(JSPUtil.getParameter(request, "cop_expt_subsc_cs_seq", ""));
		setSubscGrpNtfdPtyCd(JSPUtil.getParameter(request, "subsc_grp_ntfd_pty_cd", ""));
		setRGlobalId(JSPUtil.getParameter(request, "r_global_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRAct(JSPUtil.getParameter(request, "r_act", ""));
		setREmail(JSPUtil.getParameter(request, "r_email", ""));
		setRUsrId(JSPUtil.getParameter(request, "r_usr_id", ""));
		setRCntOfc(JSPUtil.getParameter(request, "r_cnt_ofc", ""));
		setRUpdDt(JSPUtil.getParameter(request, "r_upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExptSubReqListVO[]
	 */
	public SearchExptSubReqListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExptSubReqListVO[]
	 */
	public SearchExptSubReqListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExptSubReqListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rName = (JSPUtil.getParameter(request, prefix	+ "r_name", length));
			String[] rSubscGrpCd = (JSPUtil.getParameter(request, prefix	+ "r_subsc_grp_cd", length));
			String[] rNtfdOfcCd = (JSPUtil.getParameter(request, prefix	+ "r_ntfd_ofc_cd", length));
			String[] copExptSubscCsSeq = (JSPUtil.getParameter(request, prefix	+ "cop_expt_subsc_cs_seq", length));
			String[] subscGrpNtfdPtyCd = (JSPUtil.getParameter(request, prefix	+ "subsc_grp_ntfd_pty_cd", length));
			String[] rGlobalId = (JSPUtil.getParameter(request, prefix	+ "r_global_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rAct = (JSPUtil.getParameter(request, prefix	+ "r_act", length));
			String[] rEmail = (JSPUtil.getParameter(request, prefix	+ "r_email", length));
			String[] rUsrId = (JSPUtil.getParameter(request, prefix	+ "r_usr_id", length));
			String[] rCntOfc = (JSPUtil.getParameter(request, prefix	+ "r_cnt_ofc", length));
			String[] rUpdDt = (JSPUtil.getParameter(request, prefix	+ "r_upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExptSubReqListVO();
				if (rName[i] != null)
					model.setRName(rName[i]);
				if (rSubscGrpCd[i] != null)
					model.setRSubscGrpCd(rSubscGrpCd[i]);
				if (rNtfdOfcCd[i] != null)
					model.setRNtfdOfcCd(rNtfdOfcCd[i]);
				if (copExptSubscCsSeq[i] != null)
					model.setCopExptSubscCsSeq(copExptSubscCsSeq[i]);
				if (subscGrpNtfdPtyCd[i] != null)
					model.setSubscGrpNtfdPtyCd(subscGrpNtfdPtyCd[i]);
				if (rGlobalId[i] != null)
					model.setRGlobalId(rGlobalId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rAct[i] != null)
					model.setRAct(rAct[i]);
				if (rEmail[i] != null)
					model.setREmail(rEmail[i]);
				if (rUsrId[i] != null)
					model.setRUsrId(rUsrId[i]);
				if (rCntOfc[i] != null)
					model.setRCntOfc(rCntOfc[i]);
				if (rUpdDt[i] != null)
					model.setRUpdDt(rUpdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExptSubReqListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExptSubReqListVO[]
	 */
	public SearchExptSubReqListVO[] getSearchExptSubReqListVOs(){
		SearchExptSubReqListVO[] vos = (SearchExptSubReqListVO[])models.toArray(new SearchExptSubReqListVO[models.size()]);
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
		this.rName = this.rName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rSubscGrpCd = this.rSubscGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rNtfdOfcCd = this.rNtfdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptSubscCsSeq = this.copExptSubscCsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subscGrpNtfdPtyCd = this.subscGrpNtfdPtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rGlobalId = this.rGlobalId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rAct = this.rAct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rEmail = this.rEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rUsrId = this.rUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rCntOfc = this.rCntOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rUpdDt = this.rUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
