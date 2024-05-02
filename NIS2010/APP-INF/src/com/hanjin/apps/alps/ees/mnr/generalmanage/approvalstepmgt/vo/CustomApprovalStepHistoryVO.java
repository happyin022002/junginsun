/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomApprovalStepHistoryVO.java
*@FileTitle : CustomApprovalStepHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.18  
* 1.0 Creation
* 2014-02-26 Jonghee HAN Live malfunction fixed
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo;

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

public class CustomApprovalStepHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomApprovalStepHistoryVO> models = new ArrayList<CustomApprovalStepHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String aproStepSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrAproJbCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rowSeq = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String aproStsNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String wrtfNo = null;
	/* Column Info */
	private String apstsCd = null;
	/* Column Info */
	private String preAproUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomApprovalStepHistoryVO() {}

	public CustomApprovalStepHistoryVO(String ibflag, String pagerows, String wrtfNo, String aproStepSeq, String ofcCd, String mnrAproJbCd, String apstsCd, String aproDt, String aproUsrId, String aproRmk, String creUsrId, String creDt, String updUsrId, String updDt, String usrNm, String rowSeq, String aproStsNm, String preAproUsrId) {
		this.updDt = updDt;
		this.aproRmk = aproRmk;
		this.aproStepSeq = aproStepSeq;
		this.creDt = creDt;
		this.mnrAproJbCd = mnrAproJbCd;
		this.aproDt = aproDt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.rowSeq = rowSeq;
		this.aproUsrId = aproUsrId;
		this.usrNm = usrNm;
		this.aproStsNm = aproStsNm;
		this.updUsrId = updUsrId;
		this.wrtfNo = wrtfNo;
		this.apstsCd = apstsCd;
		this.preAproUsrId = preAproUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("apro_step_seq", getAproStepSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_apro_jb_cd", getMnrAproJbCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("row_seq", getRowSeq());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("apro_sts_nm", getAproStsNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("wrtf_no", getWrtfNo());
		this.hashColumns.put("apsts_cd", getApstsCd());
		this.hashColumns.put("pre_apro_usr_id", getPreAproUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("apro_step_seq", "aproStepSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_apro_jb_cd", "mnrAproJbCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("apro_sts_nm", "aproStsNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("wrtf_no", "wrtfNo");
		this.hashFields.put("apsts_cd", "apstsCd");
		this.hashFields.put("pre_apro_usr_id", "preAproUsrId");
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
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @return aproStepSeq
	 */
	public String getAproStepSeq() {
		return this.aproStepSeq;
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
	 * @return mnrAproJbCd
	 */
	public String getMnrAproJbCd() {
		return this.mnrAproJbCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return rowSeq
	 */
	public String getRowSeq() {
		return this.rowSeq;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return aproStsNm
	 */
	public String getAproStsNm() {
		return this.aproStsNm;
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
	 * @return wrtfNo
	 */
	public String getWrtfNo() {
		return this.wrtfNo;
	}
	
	/**
	 * Column Info
	 * @return aproStsCd
	 */
	public String getApstsCd() {
		return this.apstsCd;
	}
	
	/**
	 * Column Info
	 * @return preAproUsrId
	 */
	public String getPreAproUsrId() {
		return this.preAproUsrId;
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
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}
	
	/**
	 * Column Info
	 * @param aproStepSeq
	 */
	public void setAproStepSeq(String aproStepSeq) {
		this.aproStepSeq = aproStepSeq;
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
	 * @param mnrAproJbCd
	 */
	public void setMnrAproJbCd(String mnrAproJbCd) {
		this.mnrAproJbCd = mnrAproJbCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param rowSeq
	 */
	public void setRowSeq(String rowSeq) {
		this.rowSeq = rowSeq;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param aproStsNm
	 */
	public void setAproStsNm(String aproStsNm) {
		this.aproStsNm = aproStsNm;
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
	 * @param wrtfNo
	 */
	public void setWrtfNo(String wrtfNo) {
		this.wrtfNo = wrtfNo;
	}
	
	/**
	 * Column Info
	 * @param aproStsCd
	 */
	public void setApstsCd(String apstsCd) {
		this.apstsCd = apstsCd;
	}
	
	/**
	 * Column Info
	 * @param preAproUsrId
	 */
	public void setPreAproUsrId(String preAproUsrId) {
		this.preAproUsrId = preAproUsrId;
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
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
		setAproStepSeq(JSPUtil.getParameter(request, prefix + "apro_step_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMnrAproJbCd(JSPUtil.getParameter(request, prefix + "mnr_apro_jb_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRowSeq(JSPUtil.getParameter(request, prefix + "row_seq", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setAproStsNm(JSPUtil.getParameter(request, prefix + "apro_sts_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setWrtfNo(JSPUtil.getParameter(request, prefix + "wrtf_no", ""));
		setApstsCd(JSPUtil.getParameter(request, prefix + "apsts_cd", ""));
		setPreAproUsrId(JSPUtil.getParameter(request, prefix + "pre_apro_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomApprovalStepHistoryVO[]
	 */
	public CustomApprovalStepHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomApprovalStepHistoryVO[]
	 */
	public CustomApprovalStepHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomApprovalStepHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] aproStepSeq = (JSPUtil.getParameter(request, prefix	+ "apro_step_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrAproJbCd = (JSPUtil.getParameter(request, prefix	+ "mnr_apro_jb_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rowSeq = (JSPUtil.getParameter(request, prefix	+ "row_seq", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] aproStsNm = (JSPUtil.getParameter(request, prefix	+ "apro_sts_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] wrtfNo = (JSPUtil.getParameter(request, prefix	+ "wrtf_no", length));
			String[] apstsCd = (JSPUtil.getParameter(request, prefix	+ "apsts_cd", length));
			String[] preAproUsrId = (JSPUtil.getParameter(request, prefix	+ "pre_apro_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomApprovalStepHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (aproStepSeq[i] != null)
					model.setAproStepSeq(aproStepSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrAproJbCd[i] != null)
					model.setMnrAproJbCd(mnrAproJbCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rowSeq[i] != null)
					model.setRowSeq(rowSeq[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (aproStsNm[i] != null)
					model.setAproStsNm(aproStsNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (wrtfNo[i] != null)
					model.setWrtfNo(wrtfNo[i]);
				if (apstsCd[i] != null)
					model.setApstsCd(apstsCd[i]);
				if (preAproUsrId[i] != null)
					model.setPreAproUsrId(preAproUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomApprovalStepHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomApprovalStepHistoryVO[]
	 */
	public CustomApprovalStepHistoryVO[] getCustomApprovalStepHistoryVOs(){
		CustomApprovalStepHistoryVO[] vos = (CustomApprovalStepHistoryVO[])models.toArray(new CustomApprovalStepHistoryVO[models.size()]);
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
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStepSeq = this.aproStepSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrAproJbCd = this.mnrAproJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq = this.rowSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproStsNm = this.aproStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfNo = this.wrtfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsCd = this.apstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preAproUsrId = this.preAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
