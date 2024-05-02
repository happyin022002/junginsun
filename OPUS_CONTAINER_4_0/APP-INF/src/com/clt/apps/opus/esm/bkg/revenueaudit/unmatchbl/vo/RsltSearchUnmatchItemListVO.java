/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchUnmatchItemListVO.java
*@FileTitle : RsltSearchUnmatchItemListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.11 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchUnmatchItemListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchUnmatchItemListVO> models = new ArrayList<RsltSearchUnmatchItemListVO>();
	
	/* Column Info */
	private String umchTpNm = null;
	/* Column Info */
	private String umchBkgSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mtchUmchTpDesc = null;
	/* Column Info */
	private String mtchUmchTpCd = null;
	/* Column Info */
	private String umchTpCd = null;
	/* Column Info */
	private String bkgItmLog = null;
	/* Column Info */
	private String ctrtItmLog = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchUnmatchItemListVO() {}

	public RsltSearchUnmatchItemListVO(String ibflag, String pagerows, String bkgNo, String umchBkgSeq, String umchTpCd, String umchTpNm, String bkgItmLog, String ctrtItmLog, String mtchUmchTpCd, String mtchUmchTpDesc) {
		this.umchTpNm = umchTpNm;
		this.umchBkgSeq = umchBkgSeq;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.mtchUmchTpDesc = mtchUmchTpDesc;
		this.mtchUmchTpCd = mtchUmchTpCd;
		this.umchTpCd = umchTpCd;
		this.bkgItmLog = bkgItmLog;
		this.ctrtItmLog = ctrtItmLog;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("umch_tp_nm", getUmchTpNm());
		this.hashColumns.put("umch_bkg_seq", getUmchBkgSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mtch_umch_tp_desc", getMtchUmchTpDesc());
		this.hashColumns.put("mtch_umch_tp_cd", getMtchUmchTpCd());
		this.hashColumns.put("umch_tp_cd", getUmchTpCd());
		this.hashColumns.put("bkg_itm_log", getBkgItmLog());
		this.hashColumns.put("ctrt_itm_log", getCtrtItmLog());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("umch_tp_nm", "umchTpNm");
		this.hashFields.put("umch_bkg_seq", "umchBkgSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mtch_umch_tp_desc", "mtchUmchTpDesc");
		this.hashFields.put("mtch_umch_tp_cd", "mtchUmchTpCd");
		this.hashFields.put("umch_tp_cd", "umchTpCd");
		this.hashFields.put("bkg_itm_log", "bkgItmLog");
		this.hashFields.put("ctrt_itm_log", "ctrtItmLog");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return umchTpNm
	 */
	public String getUmchTpNm() {
		return this.umchTpNm;
	}
	
	/**
	 * Column Info
	 * @return umchBkgSeq
	 */
	public String getUmchBkgSeq() {
		return this.umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return mtchUmchTpDesc
	 */
	public String getMtchUmchTpDesc() {
		return this.mtchUmchTpDesc;
	}
	
	/**
	 * Column Info
	 * @return mtchUmchTpCd
	 */
	public String getMtchUmchTpCd() {
		return this.mtchUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @return umchTpCd
	 */
	public String getUmchTpCd() {
		return this.umchTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgItmLog
	 */
	public String getBkgItmLog() {
		return this.bkgItmLog;
	}
	
	/**
	 * Column Info
	 * @return ctrtItmLog
	 */
	public String getCtrtItmLog() {
		return this.ctrtItmLog;
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
	 * @param umchTpNm
	 */
	public void setUmchTpNm(String umchTpNm) {
		this.umchTpNm = umchTpNm;
	}
	
	/**
	 * Column Info
	 * @param umchBkgSeq
	 */
	public void setUmchBkgSeq(String umchBkgSeq) {
		this.umchBkgSeq = umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param mtchUmchTpDesc
	 */
	public void setMtchUmchTpDesc(String mtchUmchTpDesc) {
		this.mtchUmchTpDesc = mtchUmchTpDesc;
	}
	
	/**
	 * Column Info
	 * @param mtchUmchTpCd
	 */
	public void setMtchUmchTpCd(String mtchUmchTpCd) {
		this.mtchUmchTpCd = mtchUmchTpCd;
	}
	
	/**
	 * Column Info
	 * @param umchTpCd
	 */
	public void setUmchTpCd(String umchTpCd) {
		this.umchTpCd = umchTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgItmLog
	 */
	public void setBkgItmLog(String bkgItmLog) {
		this.bkgItmLog = bkgItmLog;
	}
	
	/**
	 * Column Info
	 * @param ctrtItmLog
	 */
	public void setCtrtItmLog(String ctrtItmLog) {
		this.ctrtItmLog = ctrtItmLog;
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
		setUmchTpNm(JSPUtil.getParameter(request, prefix + "umch_tp_nm", ""));
		setUmchBkgSeq(JSPUtil.getParameter(request, prefix + "umch_bkg_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMtchUmchTpDesc(JSPUtil.getParameter(request, prefix + "mtch_umch_tp_desc", ""));
		setMtchUmchTpCd(JSPUtil.getParameter(request, prefix + "mtch_umch_tp_cd", ""));
		setUmchTpCd(JSPUtil.getParameter(request, prefix + "umch_tp_cd", ""));
		setBkgItmLog(JSPUtil.getParameter(request, prefix + "bkg_itm_log", ""));
		setCtrtItmLog(JSPUtil.getParameter(request, prefix + "ctrt_itm_log", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchUnmatchItemListVO[]
	 */
	public RsltSearchUnmatchItemListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchUnmatchItemListVO[]
	 */
	public RsltSearchUnmatchItemListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchUnmatchItemListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] umchTpNm = (JSPUtil.getParameter(request, prefix	+ "umch_tp_nm", length));
			String[] umchBkgSeq = (JSPUtil.getParameter(request, prefix	+ "umch_bkg_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mtchUmchTpDesc = (JSPUtil.getParameter(request, prefix	+ "mtch_umch_tp_desc", length));
			String[] mtchUmchTpCd = (JSPUtil.getParameter(request, prefix	+ "mtch_umch_tp_cd", length));
			String[] umchTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_tp_cd", length));
			String[] bkgItmLog = (JSPUtil.getParameter(request, prefix	+ "bkg_itm_log", length));
			String[] ctrtItmLog = (JSPUtil.getParameter(request, prefix	+ "ctrt_itm_log", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchUnmatchItemListVO();
				if (umchTpNm[i] != null)
					model.setUmchTpNm(umchTpNm[i]);
				if (umchBkgSeq[i] != null)
					model.setUmchBkgSeq(umchBkgSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mtchUmchTpDesc[i] != null)
					model.setMtchUmchTpDesc(mtchUmchTpDesc[i]);
				if (mtchUmchTpCd[i] != null)
					model.setMtchUmchTpCd(mtchUmchTpCd[i]);
				if (umchTpCd[i] != null)
					model.setUmchTpCd(umchTpCd[i]);
				if (bkgItmLog[i] != null)
					model.setBkgItmLog(bkgItmLog[i]);
				if (ctrtItmLog[i] != null)
					model.setCtrtItmLog(ctrtItmLog[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchUnmatchItemListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchUnmatchItemListVO[]
	 */
	public RsltSearchUnmatchItemListVO[] getRsltSearchUnmatchItemListVOs(){
		RsltSearchUnmatchItemListVO[] vos = (RsltSearchUnmatchItemListVO[])models.toArray(new RsltSearchUnmatchItemListVO[models.size()]);
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
		this.umchTpNm = this.umchTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchBkgSeq = this.umchBkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUmchTpDesc = this.mtchUmchTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchUmchTpCd = this.mtchUmchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpCd = this.umchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgItmLog = this.bkgItmLog .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtItmLog = this.ctrtItmLog .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
