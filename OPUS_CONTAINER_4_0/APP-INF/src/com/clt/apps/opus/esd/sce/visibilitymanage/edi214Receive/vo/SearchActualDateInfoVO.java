/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchActualDateInfoVO.java
*@FileTitle : SearchActualDateInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.12.01 이중환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.vo;

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

public class SearchActualDateInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActualDateInfoVO> models = new ArrayList<SearchActualDateInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rcvMnt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bndSeq = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String actRcvNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deCondCd = null;
	/* Column Info */
	private String copSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String rcvHr = null;
	/* Column Info */
	private String actRcvDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String apntStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActualDateInfoVO() {}

	public SearchActualDateInfoVO(String ibflag, String pagerows, String copSeq, String updDt, String trspWoSeq, String trspSoSeq, String creDt, String rcvMnt, String blNo, String bndSeq, String trspWoOfcCtyCd, String trspSoOfcCtyCd, String actRcvNo, String creUsrId, String bkgNo, String deCondCd, String rcvDt, String cntrNo, String rcvHr, String actRcvDt, String updUsrId, String apntStsCd) {
		this.updDt = updDt;
		this.trspWoSeq = trspWoSeq;
		this.trspSoSeq = trspSoSeq;
		this.creDt = creDt;
		this.rcvMnt = rcvMnt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.bndSeq = bndSeq;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.actRcvNo = actRcvNo;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.deCondCd = deCondCd;
		this.copSeq = copSeq;
		this.cntrNo = cntrNo;
		this.rcvDt = rcvDt;
		this.rcvHr = rcvHr;
		this.actRcvDt = actRcvDt;
		this.updUsrId = updUsrId;
		this.apntStsCd = apntStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rcv_mnt", getRcvMnt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bnd_seq", getBndSeq());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("act_rcv_no", getActRcvNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("de_cond_cd", getDeCondCd());
		this.hashColumns.put("cop_seq", getCopSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("rcv_hr", getRcvHr());
		this.hashColumns.put("act_rcv_dt", getActRcvDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("apnt_sts_cd", getApntStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rcv_mnt", "rcvMnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bnd_seq", "bndSeq");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("act_rcv_no", "actRcvNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("de_cond_cd", "deCondCd");
		this.hashFields.put("cop_seq", "copSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("rcv_hr", "rcvHr");
		this.hashFields.put("act_rcv_dt", "actRcvDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("apnt_sts_cd", "apntStsCd");
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
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
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
	 * @return rcvMnt
	 */
	public String getRcvMnt() {
		return this.rcvMnt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return bndSeq
	 */
	public String getBndSeq() {
		return this.bndSeq;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return actRcvNo
	 */
	public String getActRcvNo() {
		return this.actRcvNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return deCondCd
	 */
	public String getDeCondCd() {
		return this.deCondCd;
	}
	
	/**
	 * Column Info
	 * @return copSeq
	 */
	public String getCopSeq() {
		return this.copSeq;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return rcvHr
	 */
	public String getRcvHr() {
		return this.rcvHr;
	}
	
	/**
	 * Column Info
	 * @return actRcvDt
	 */
	public String getActRcvDt() {
		return this.actRcvDt;
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
	 * @return apntStsCd
	 */
	public String getApntStsCd() {
		return this.apntStsCd;
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
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
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
	 * @param rcvMnt
	 */
	public void setRcvMnt(String rcvMnt) {
		this.rcvMnt = rcvMnt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param bndSeq
	 */
	public void setBndSeq(String bndSeq) {
		this.bndSeq = bndSeq;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param actRcvNo
	 */
	public void setActRcvNo(String actRcvNo) {
		this.actRcvNo = actRcvNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param deCondCd
	 */
	public void setDeCondCd(String deCondCd) {
		this.deCondCd = deCondCd;
	}
	
	/**
	 * Column Info
	 * @param copSeq
	 */
	public void setCopSeq(String copSeq) {
		this.copSeq = copSeq;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param rcvHr
	 */
	public void setRcvHr(String rcvHr) {
		this.rcvHr = rcvHr;
	}
	
	/**
	 * Column Info
	 * @param actRcvDt
	 */
	public void setActRcvDt(String actRcvDt) {
		this.actRcvDt = actRcvDt;
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
	 * @param apntStsCd
	 */
	public void setApntStsCd(String apntStsCd) {
		this.apntStsCd = apntStsCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRcvMnt(JSPUtil.getParameter(request, "rcv_mnt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBndSeq(JSPUtil.getParameter(request, "bnd_seq", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setActRcvNo(JSPUtil.getParameter(request, "act_rcv_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDeCondCd(JSPUtil.getParameter(request, "de_cond_cd", ""));
		setCopSeq(JSPUtil.getParameter(request, "cop_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setRcvHr(JSPUtil.getParameter(request, "rcv_hr", ""));
		setActRcvDt(JSPUtil.getParameter(request, "act_rcv_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setApntStsCd(JSPUtil.getParameter(request, "apnt_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActualDateInfoVO[]
	 */
	public SearchActualDateInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActualDateInfoVO[]
	 */
	public SearchActualDateInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActualDateInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rcvMnt = (JSPUtil.getParameter(request, prefix	+ "rcv_mnt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bndSeq = (JSPUtil.getParameter(request, prefix	+ "bnd_seq", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] actRcvNo = (JSPUtil.getParameter(request, prefix	+ "act_rcv_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deCondCd = (JSPUtil.getParameter(request, prefix	+ "de_cond_cd", length));
			String[] copSeq = (JSPUtil.getParameter(request, prefix	+ "cop_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] rcvHr = (JSPUtil.getParameter(request, prefix	+ "rcv_hr", length));
			String[] actRcvDt = (JSPUtil.getParameter(request, prefix	+ "act_rcv_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] apntStsCd = (JSPUtil.getParameter(request, prefix	+ "apnt_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActualDateInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rcvMnt[i] != null)
					model.setRcvMnt(rcvMnt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bndSeq[i] != null)
					model.setBndSeq(bndSeq[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (actRcvNo[i] != null)
					model.setActRcvNo(actRcvNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deCondCd[i] != null)
					model.setDeCondCd(deCondCd[i]);
				if (copSeq[i] != null)
					model.setCopSeq(copSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (rcvHr[i] != null)
					model.setRcvHr(rcvHr[i]);
				if (actRcvDt[i] != null)
					model.setActRcvDt(actRcvDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (apntStsCd[i] != null)
					model.setApntStsCd(apntStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActualDateInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActualDateInfoVO[]
	 */
	public SearchActualDateInfoVO[] getSearchActualDateInfoVOs(){
		SearchActualDateInfoVO[] vos = (SearchActualDateInfoVO[])models.toArray(new SearchActualDateInfoVO[models.size()]);
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
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMnt = this.rcvMnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bndSeq = this.bndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvNo = this.actRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deCondCd = this.deCondCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSeq = this.copSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvHr = this.rcvHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvDt = this.actRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apntStsCd = this.apntStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
