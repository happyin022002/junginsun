/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RevenueStrcSetVO.java
*@FileTitle : RevenueStrcSetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.27
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2012.03.27 이정수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo;

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
 * @author 이정수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RevenueStrcSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevenueStrcSetVO> models = new ArrayList<RevenueStrcSetVO>();
	
	/* Column Info */
	private String rhqOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revFmDt = null;
	/* Column Info */
	private String revToDt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String revFmDtCd = null;
	/* Column Info */
	private String revChgSeq = null;
	/* Column Info */
	private String scpCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String revToDtCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RevenueStrcSetVO() {}

	public RevenueStrcSetVO(String ibflag, String pagerows, String revChgSeq, String chgCd, String rhqOfcCd, String scpCd, String revFmDtCd, String revFmDt, String revToDtCd, String revToDt, String usrId) {
		this.rhqOfcCd = rhqOfcCd;
		this.ibflag = ibflag;
		this.revFmDt = revFmDt;
		this.revToDt = revToDt;
		this.usrId = usrId;
		this.revFmDtCd = revFmDtCd;
		this.revChgSeq = revChgSeq;
		this.scpCd = scpCd;
		this.chgCd = chgCd;
		this.revToDtCd = revToDtCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_fm_dt", getRevFmDt());
		this.hashColumns.put("rev_to_dt", getRevToDt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rev_fm_dt_cd", getRevFmDtCd());
		this.hashColumns.put("rev_chg_seq", getRevChgSeq());
		this.hashColumns.put("scp_cd", getScpCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("rev_to_dt_cd", getRevToDtCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_fm_dt", "revFmDt");
		this.hashFields.put("rev_to_dt", "revToDt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rev_fm_dt_cd", "revFmDtCd");
		this.hashFields.put("rev_chg_seq", "revChgSeq");
		this.hashFields.put("scp_cd", "scpCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("rev_to_dt_cd", "revToDtCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
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
	 * @return revFmDt
	 */
	public String getRevFmDt() {
		return this.revFmDt;
	}
	
	/**
	 * Column Info
	 * @return revToDt
	 */
	public String getRevToDt() {
		return this.revToDt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return revFmDtCd
	 */
	public String getRevFmDtCd() {
		return this.revFmDtCd;
	}
	
	/**
	 * Column Info
	 * @return revChgSeq
	 */
	public String getRevChgSeq() {
		return this.revChgSeq;
	}
	
	/**
	 * Column Info
	 * @return scpCd
	 */
	public String getScpCd() {
		return this.scpCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return revToDtCd
	 */
	public String getRevToDtCd() {
		return this.revToDtCd;
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
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
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
	 * @param revFmDt
	 */
	public void setRevFmDt(String revFmDt) {
		this.revFmDt = revFmDt;
	}
	
	/**
	 * Column Info
	 * @param revToDt
	 */
	public void setRevToDt(String revToDt) {
		this.revToDt = revToDt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param revFmDtCd
	 */
	public void setRevFmDtCd(String revFmDtCd) {
		this.revFmDtCd = revFmDtCd;
	}
	
	/**
	 * Column Info
	 * @param revChgSeq
	 */
	public void setRevChgSeq(String revChgSeq) {
		this.revChgSeq = revChgSeq;
	}
	
	/**
	 * Column Info
	 * @param scpCd
	 */
	public void setScpCd(String scpCd) {
		this.scpCd = scpCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param revToDtCd
	 */
	public void setRevToDtCd(String revToDtCd) {
		this.revToDtCd = revToDtCd;
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
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRevFmDt(JSPUtil.getParameter(request, prefix + "rev_fm_dt", ""));
		setRevToDt(JSPUtil.getParameter(request, prefix + "rev_to_dt", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setRevFmDtCd(JSPUtil.getParameter(request, prefix + "rev_fm_dt_cd", ""));
		setRevChgSeq(JSPUtil.getParameter(request, prefix + "rev_chg_seq", ""));
		setScpCd(JSPUtil.getParameter(request, prefix + "scp_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setRevToDtCd(JSPUtil.getParameter(request, prefix + "rev_to_dt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevenueStrcSetVO[]
	 */
	public RevenueStrcSetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevenueStrcSetVO[]
	 */
	public RevenueStrcSetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevenueStrcSetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revFmDt = (JSPUtil.getParameter(request, prefix	+ "rev_fm_dt", length));
			String[] revToDt = (JSPUtil.getParameter(request, prefix	+ "rev_to_dt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] revFmDtCd = (JSPUtil.getParameter(request, prefix	+ "rev_fm_dt_cd", length));
			String[] revChgSeq = (JSPUtil.getParameter(request, prefix	+ "rev_chg_seq", length));
			String[] scpCd = (JSPUtil.getParameter(request, prefix	+ "scp_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] revToDtCd = (JSPUtil.getParameter(request, prefix	+ "rev_to_dt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevenueStrcSetVO();
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revFmDt[i] != null)
					model.setRevFmDt(revFmDt[i]);
				if (revToDt[i] != null)
					model.setRevToDt(revToDt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (revFmDtCd[i] != null)
					model.setRevFmDtCd(revFmDtCd[i]);
				if (revChgSeq[i] != null)
					model.setRevChgSeq(revChgSeq[i]);
				if (scpCd[i] != null)
					model.setScpCd(scpCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (revToDtCd[i] != null)
					model.setRevToDtCd(revToDtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevenueStrcSetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevenueStrcSetVO[]
	 */
	public RevenueStrcSetVO[] getRevenueStrcSetVOs(){
		RevenueStrcSetVO[] vos = (RevenueStrcSetVO[])models.toArray(new RevenueStrcSetVO[models.size()]);
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
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revFmDt = this.revFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revToDt = this.revToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revFmDtCd = this.revFmDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revChgSeq = this.revChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scpCd = this.scpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revToDtCd = this.revToDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
