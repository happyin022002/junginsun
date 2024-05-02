/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ScopeLimitVO.java
*@FileTitle : ScopeLimitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.bcm.ccd.commoncode.service.vo;

import java.lang.reflect.Field;
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

public class ScopeLimitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScopeLimitVO> models = new ArrayList<ScopeLimitVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String orgDestCd = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String svcScpIndFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScopeLimitVO() {}

	public ScopeLimitVO(String ibflag, String pagerows, String rgnCd, String orgDestCd, String svcScpIndFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String userId, String rqstNo, String svcScpCd) {
		this.updDt = updDt;
		this.rgnCd = rgnCd;
		this.orgDestCd = orgDestCd;
		this.rqstNo = rqstNo;
		this.deltFlg = deltFlg;
		this.svcScpCd = svcScpCd;
		this.svcScpIndFlg = svcScpIndFlg;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.userId = userId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("org_dest_cd", getOrgDestCd());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("svc_scp_ind_flg", getSvcScpIndFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("org_dest_cd", "orgDestCd");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("svc_scp_ind_flg", "svcScpIndFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return orgDestCd
	 */
	public String getOrgDestCd() {
		return this.orgDestCd;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpIndFlg
	 */
	public String getSvcScpIndFlg() {
		return this.svcScpIndFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param orgDestCd
	 */
	public void setOrgDestCd(String orgDestCd) {
		this.orgDestCd = orgDestCd;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpIndFlg
	 */
	public void setSvcScpIndFlg(String svcScpIndFlg) {
		this.svcScpIndFlg = svcScpIndFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRgnCd(JSPUtil.getParameter(request, prefix + "rgn_cd", ""));
		setOrgDestCd(JSPUtil.getParameter(request, prefix + "org_dest_cd", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setSvcScpIndFlg(JSPUtil.getParameter(request, prefix + "svc_scp_ind_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScopeLimitVO[]
	 */
	public ScopeLimitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScopeLimitVO[]
	 */
	public ScopeLimitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScopeLimitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] orgDestCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_cd", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] svcScpIndFlg = (JSPUtil.getParameter(request, prefix	+ "svc_scp_ind_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScopeLimitVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (orgDestCd[i] != null)
					model.setOrgDestCd(orgDestCd[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (svcScpIndFlg[i] != null)
					model.setSvcScpIndFlg(svcScpIndFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScopeLimitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScopeLimitVO[]
	 */
	public ScopeLimitVO[] getScopeLimitVOs(){
		ScopeLimitVO[] vos = (ScopeLimitVO[])models.toArray(new ScopeLimitVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCd = this.orgDestCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpIndFlg = this.svcScpIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
