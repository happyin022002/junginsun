/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchQueueDetailReturnReasonCdListVO.java
*@FileTitle : SearchQueueDetailReturnReasonCdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.03.28 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchQueueDetailReturnReasonCdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchQueueDetailReturnReasonCdListVO> models = new ArrayList<SearchQueueDetailReturnReasonCdListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String reasonType = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String code = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String srHisSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String srRtnRsnCd = null;
	/* Column Info */
	private String sel = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchQueueDetailReturnReasonCdListVO() {}

	public SearchQueueDetailReturnReasonCdListVO(String ibflag, String pagerows, String code, String name, String srKndCd, String srNo, String bkgNo, String srHisSeq, String srRtnRsnCd, String creUsrId, String creDt, String updUsrId, String updDt, String reasonType, String srcCd, String sel) {
		this.updDt = updDt;
		this.srcCd = srcCd;
		this.reasonType = reasonType;
		this.creDt = creDt;
		this.code = code;
		this.pagerows = pagerows;
		this.srHisSeq = srHisSeq;
		this.ibflag = ibflag;
		this.srKndCd = srKndCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.name = name;
		this.srRtnRsnCd = srRtnRsnCd;
		this.sel = sel;
		this.srNo = srNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("reason_type", getReasonType());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sr_his_seq", getSrHisSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("sr_rtn_rsn_cd", getSrRtnRsnCd());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("reason_type", "reasonType");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("code", "code");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sr_his_seq", "srHisSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("name", "name");
		this.hashFields.put("sr_rtn_rsn_cd", "srRtnRsnCd");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("sr_no", "srNo");
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
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
	}
	
	/**
	 * Column Info
	 * @return reasonType
	 */
	public String getReasonType() {
		return this.reasonType;
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
	 * @return code
	 */
	public String getCode() {
		return this.code;
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
	 * @return srHisSeq
	 */
	public String getSrHisSeq() {
		return this.srHisSeq;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return srRtnRsnCd
	 */
	public String getSrRtnRsnCd() {
		return this.srRtnRsnCd;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
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
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
	}
	
	/**
	 * Column Info
	 * @param reasonType
	 */
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
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
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @param srHisSeq
	 */
	public void setSrHisSeq(String srHisSeq) {
		this.srHisSeq = srHisSeq;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param srRtnRsnCd
	 */
	public void setSrRtnRsnCd(String srRtnRsnCd) {
		this.srRtnRsnCd = srRtnRsnCd;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
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
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setReasonType(JSPUtil.getParameter(request, prefix + "reason_type", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSrHisSeq(JSPUtil.getParameter(request, prefix + "sr_his_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setSrRtnRsnCd(JSPUtil.getParameter(request, prefix + "sr_rtn_rsn_cd", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchQueueDetailReturnReasonCdListVO[]
	 */
	public SearchQueueDetailReturnReasonCdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchQueueDetailReturnReasonCdListVO[]
	 */
	public SearchQueueDetailReturnReasonCdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchQueueDetailReturnReasonCdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] reasonType = (JSPUtil.getParameter(request, prefix	+ "reason_type", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] srHisSeq = (JSPUtil.getParameter(request, prefix	+ "sr_his_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] srRtnRsnCd = (JSPUtil.getParameter(request, prefix	+ "sr_rtn_rsn_cd", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchQueueDetailReturnReasonCdListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (reasonType[i] != null)
					model.setReasonType(reasonType[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (srHisSeq[i] != null)
					model.setSrHisSeq(srHisSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (srRtnRsnCd[i] != null)
					model.setSrRtnRsnCd(srRtnRsnCd[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchQueueDetailReturnReasonCdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchQueueDetailReturnReasonCdListVO[]
	 */
	public SearchQueueDetailReturnReasonCdListVO[] getSearchQueueDetailReturnReasonCdListVOs(){
		SearchQueueDetailReturnReasonCdListVO[] vos = (SearchQueueDetailReturnReasonCdListVO[])models.toArray(new SearchQueueDetailReturnReasonCdListVO[models.size()]);
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
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reasonType = this.reasonType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srHisSeq = this.srHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRtnRsnCd = this.srRtnRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
