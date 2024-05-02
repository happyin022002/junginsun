/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchBkgSrProcHisListVO.java
*@FileTitle : SearchBkgSrProcHisListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.26  
* 1.0 Creation
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBkgSrProcHisListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBkgSrProcHisListVO> models = new ArrayList<SearchBkgSrProcHisListVO>();
	
	/* Column Info */
	private String evntGdt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String srProcTpCd = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String srProcSeq = null;
	/* Column Info */
	private String hisCateNm = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String faxLogRefNo = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String srNo = null;
	/* Column Info */
	private String evntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchBkgSrProcHisListVO() {}

	public SearchBkgSrProcHisListVO(String ibflag, String pagerows, String srNo, String faxLogRefNo, String srProcSeq, String srProcTpCd, String evntDt, String evntGdt, String evntUsrId, String hisCateNm, String preCtnt, String crntCtnt, String creUsrId, String creDt) {
		this.evntGdt = evntGdt;
		this.creDt = creDt;
		this.srProcTpCd = srProcTpCd;
		this.crntCtnt = crntCtnt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.srProcSeq = srProcSeq;
		this.hisCateNm = hisCateNm;
		this.evntUsrId = evntUsrId;
		this.faxLogRefNo = faxLogRefNo;
		this.preCtnt = preCtnt;
		this.srNo = srNo;
		this.evntDt = evntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("evnt_gdt", getEvntGdt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sr_proc_tp_cd", getSrProcTpCd());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sr_proc_seq", getSrProcSeq());
		this.hashColumns.put("his_cate_nm", getHisCateNm());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("sr_no", getSrNo());
		this.hashColumns.put("evnt_dt", getEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("evnt_gdt", "evntGdt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sr_proc_tp_cd", "srProcTpCd");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sr_proc_seq", "srProcSeq");
		this.hashFields.put("his_cate_nm", "hisCateNm");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("sr_no", "srNo");
		this.hashFields.put("evnt_dt", "evntDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return evntGdt
	 */
	public String getEvntGdt() {
		return this.evntGdt;
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
	 * @return srProcTpCd
	 */
	public String getSrProcTpCd() {
		return this.srProcTpCd;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
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
	 * @return srProcSeq
	 */
	public String getSrProcSeq() {
		return this.srProcSeq;
	}
	
	/**
	 * Column Info
	 * @return hisCateNm
	 */
	public String getHisCateNm() {
		return this.hisCateNm;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return faxLogRefNo
	 */
	public String getFaxLogRefNo() {
		return this.faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @return preCtnt
	 */
	public String getPreCtnt() {
		return this.preCtnt;
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
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	

	/**
	 * Column Info
	 * @param evntGdt
	 */
	public void setEvntGdt(String evntGdt) {
		this.evntGdt = evntGdt;
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
	 * @param srProcTpCd
	 */
	public void setSrProcTpCd(String srProcTpCd) {
		this.srProcTpCd = srProcTpCd;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
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
	 * @param srProcSeq
	 */
	public void setSrProcSeq(String srProcSeq) {
		this.srProcSeq = srProcSeq;
	}
	
	/**
	 * Column Info
	 * @param hisCateNm
	 */
	public void setHisCateNm(String hisCateNm) {
		this.hisCateNm = hisCateNm;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param faxLogRefNo
	 */
	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
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
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
		setEvntGdt(JSPUtil.getParameter(request, prefix + "evnt_gdt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSrProcTpCd(JSPUtil.getParameter(request, prefix + "sr_proc_tp_cd", ""));
		setCrntCtnt(JSPUtil.getParameter(request, prefix + "crnt_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSrProcSeq(JSPUtil.getParameter(request, prefix + "sr_proc_seq", ""));
		setHisCateNm(JSPUtil.getParameter(request, prefix + "his_cate_nm", ""));
		setEvntUsrId(JSPUtil.getParameter(request, prefix + "evnt_usr_id", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
		setPreCtnt(JSPUtil.getParameter(request, prefix + "pre_ctnt", ""));
		setSrNo(JSPUtil.getParameter(request, prefix + "sr_no", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBkgSrProcHisListVO[]
	 */
	public SearchBkgSrProcHisListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBkgSrProcHisListVO[]
	 */
	public SearchBkgSrProcHisListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBkgSrProcHisListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] evntGdt = (JSPUtil.getParameter(request, prefix	+ "evnt_gdt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] srProcTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_proc_tp_cd", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] srProcSeq = (JSPUtil.getParameter(request, prefix	+ "sr_proc_seq", length));
			String[] hisCateNm = (JSPUtil.getParameter(request, prefix	+ "his_cate_nm", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBkgSrProcHisListVO();
				if (evntGdt[i] != null)
					model.setEvntGdt(evntGdt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (srProcTpCd[i] != null)
					model.setSrProcTpCd(srProcTpCd[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (srProcSeq[i] != null)
					model.setSrProcSeq(srProcSeq[i]);
				if (hisCateNm[i] != null)
					model.setHisCateNm(hisCateNm[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBkgSrProcHisListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBkgSrProcHisListVO[]
	 */
	public SearchBkgSrProcHisListVO[] getSearchBkgSrProcHisListVOs(){
		SearchBkgSrProcHisListVO[] vos = (SearchBkgSrProcHisListVO[])models.toArray(new SearchBkgSrProcHisListVO[models.size()]);
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
		this.evntGdt = this.evntGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srProcTpCd = this.srProcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srProcSeq = this.srProcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCateNm = this.hisCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
