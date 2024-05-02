/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OtherCodeListVO.java
*@FileTitle : OtherCodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo;

import java.lang.reflect.Field;
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

public class OtherCodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtherCodeListVO> models = new ArrayList<OtherCodeListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pptNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pptCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String pptSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String orgPptNm = null;
	/* Column Info */
	private String orgPptSeq = null;
	/* Page Number */
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OtherCodeListVO() {}

	public OtherCodeListVO(String ibflag, String pagerows, String pptNm, String pptSeq, String pptCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String orgPptNm, String orgPptSeq) {
		this.updDt = updDt;
		this.pptNm = pptNm;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.pptCtnt = pptCtnt;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.pptSeq = pptSeq;
		this.pagerows = pagerows;
		this.orgPptNm = orgPptNm;
		this.orgPptSeq = orgPptSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ppt_nm", getPptNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ppt_ctnt", getPptCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ppt_seq", getPptSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("org_ppt_seq", getOrgPptSeq());
		this.hashColumns.put("org_ppt_nm", getOrgPptNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ppt_nm", "pptNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ppt_ctnt", "pptCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ppt_seq", "pptSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("org_ppt_seq", "orgPptSeq");
		this.hashFields.put("org_ppt_nm", "orgPptNm");
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
	 * @return pptNm
	 */
	public String getPptNm() {
		return this.pptNm;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return pptCtnt
	 */
	public String getPptCtnt() {
		return this.pptCtnt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return pptSeq
	 */
	public String getPptSeq() {
		return this.pptSeq;
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
	 * @return getorgPptSeq
	 */
	public String getOrgPptSeq() {
		return this.orgPptSeq;
	}
	
	/**
	 * Column Info
	 * @return getorgPptNm
	 */
	public String getOrgPptNm() {
		return this.orgPptNm;
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
	 * @param pptNm
	 */
	public void setPptNm(String pptNm) {
		this.pptNm = pptNm;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param pptCtnt
	 */
	public void setPptCtnt(String pptCtnt) {
		this.pptCtnt = pptCtnt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param pptSeq
	 */
	public void setPptSeq(String pptSeq) {
		this.pptSeq = pptSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param pptSeq
	 */
	public void setOrgPptSeq(String orgPptSeq) {
		this.orgPptSeq = orgPptSeq;
	}
	
	/**
	 * Column Info
	 * @param pptSeq
	 */
	public void setOrgPptNm(String orgPptNm) {
		this.orgPptNm = orgPptNm;
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
		setPptNm(JSPUtil.getParameter(request, prefix + "ppt_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPptCtnt(JSPUtil.getParameter(request, prefix + "ppt_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPptSeq(JSPUtil.getParameter(request, prefix + "ppt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOrgPptSeq(JSPUtil.getParameter(request, prefix + "org_ppt_seq", ""));
		setOrgPptNm(JSPUtil.getParameter(request, prefix + "org_ppt_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtherCodeListVO[]
	 */
	public OtherCodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtherCodeListVO[]
	 */
	public OtherCodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtherCodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pptNm = (JSPUtil.getParameter(request, prefix	+ "ppt_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pptCtnt = (JSPUtil.getParameter(request, prefix	+ "ppt_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pptSeq = (JSPUtil.getParameter(request, prefix	+ "ppt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] orgPptSeq = (JSPUtil.getParameter(request, prefix	+ "org_ppt_seq", length));
			String[] orgPptNm = (JSPUtil.getParameter(request, prefix	+ "org_ppt_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtherCodeListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pptNm[i] != null)
					model.setPptNm(pptNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pptCtnt[i] != null)
					model.setPptCtnt(pptCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pptSeq[i] != null)
					model.setPptSeq(pptSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (orgPptSeq[i] != null)
					model.setOrgPptSeq(orgPptSeq[i]);
				if (orgPptNm[i] != null)
					model.setOrgPptNm(orgPptNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtherCodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtherCodeListVO[]
	 */
	public OtherCodeListVO[] getOtherCodeListVOs(){
		OtherCodeListVO[] vos = (OtherCodeListVO[])models.toArray(new OtherCodeListVO[models.size()]);
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
		this.pptNm = this.pptNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptCtnt = this.pptCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pptSeq = this.pptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPptSeq = this.orgPptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPptNm = this.orgPptNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
