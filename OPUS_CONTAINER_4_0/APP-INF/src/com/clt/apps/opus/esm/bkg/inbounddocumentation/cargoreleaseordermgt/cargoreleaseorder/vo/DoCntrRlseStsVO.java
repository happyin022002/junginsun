/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoCntrRlseStsVO.java
*@FileTitle : DoCntrRlseStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.04  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class DoCntrRlseStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoCntrRlseStsVO> models = new ArrayList<DoCntrRlseStsVO>();
	
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlseStsSeq = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rlseStsNm = null;
	/* Column Info */
	private String rlseSeq = null;
	/* Column Info */
	private String evntDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoCntrRlseStsVO() {}

	public DoCntrRlseStsVO(String ibflag, String pagerows, String bkgNo, String rlseSeq, String rlseStsSeq, String cntrNo, String rlseStsCd, String rlseStsNm, String doNo, String evntDt, String evntUsrId) {
		this.doNo = doNo;
		this.rlseStsCd = rlseStsCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.rlseStsSeq = rlseStsSeq;
		this.evntUsrId = evntUsrId;
		this.cntrNo = cntrNo;
		this.rlseStsNm = rlseStsNm;
		this.rlseSeq = rlseSeq;
		this.evntDt = evntDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rlse_sts_seq", getRlseStsSeq());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rlse_sts_nm", getRlseStsNm());
		this.hashColumns.put("rlse_seq", getRlseSeq());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rlse_sts_seq", "rlseStsSeq");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rlse_sts_nm", "rlseStsNm");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
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
	 * @return rlseStsSeq
	 */
	public String getRlseStsSeq() {
		return this.rlseStsSeq;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return rlseStsNm
	 */
	public String getRlseStsNm() {
		return this.rlseStsNm;
	}
	
	/**
	 * Column Info
	 * @return rlseSeq
	 */
	public String getRlseSeq() {
		return this.rlseSeq;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
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
	 * @param rlseStsSeq
	 */
	public void setRlseStsSeq(String rlseStsSeq) {
		this.rlseStsSeq = rlseStsSeq;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param rlseStsNm
	 */
	public void setRlseStsNm(String rlseStsNm) {
		this.rlseStsNm = rlseStsNm;
	}
	
	/**
	 * Column Info
	 * @param rlseSeq
	 */
	public void setRlseSeq(String rlseSeq) {
		this.rlseSeq = rlseSeq;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRlseStsSeq(JSPUtil.getParameter(request, "rlse_sts_seq", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRlseStsNm(JSPUtil.getParameter(request, "rlse_sts_nm", ""));
		setRlseSeq(JSPUtil.getParameter(request, "rlse_seq", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoCntrRlseStsVO[]
	 */
	public DoCntrRlseStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoCntrRlseStsVO[]
	 */
	public DoCntrRlseStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoCntrRlseStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlseStsSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_seq", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rlseStsNm = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_nm", length));
			String[] rlseSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_seq", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoCntrRlseStsVO();
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlseStsSeq[i] != null)
					model.setRlseStsSeq(rlseStsSeq[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rlseStsNm[i] != null)
					model.setRlseStsNm(rlseStsNm[i]);
				if (rlseSeq[i] != null)
					model.setRlseSeq(rlseSeq[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoCntrRlseStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoCntrRlseStsVO[]
	 */
	public DoCntrRlseStsVO[] getDoCntrRlseStsVOs(){
		DoCntrRlseStsVO[] vos = (DoCntrRlseStsVO[])models.toArray(new DoCntrRlseStsVO[models.size()]);
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
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsSeq = this.rlseStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsNm = this.rlseStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseSeq = this.rlseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
