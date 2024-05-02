/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315CurrInfoVO.java
*@FileTitle : Edi315CurrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.03.16 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315CurrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315CurrInfoVO> models = new ArrayList<Edi315CurrInfoVO>();
	
	/* Column Info */
	private String dtlUpdateSkipFlag = null;
	/* Column Info */
	private String pickUpNo = null;
	/* Column Info */
	private String currEventYard = null;
	/* Column Info */
	private String podAtaEventDtGmt = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String lloydCd = null;
	/* Column Info */
	private String isPodAtaReplace = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String currCopDtlSeq = null;
	/* Column Info */
	private String currBound = null;
	/* Column Info */
	private String currVvd = null;
	/* Column Info */
	private String podAtaYard = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currEventDt = null;
	/* Column Info */
	private String podAtaEventDt = null;
	/* Column Info */
	private String vslCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315CurrInfoVO() {}

	public Edi315CurrInfoVO(String ibflag, String pagerows, String currEventDt, String currEventYard, String vslNm, String vslCntCd, String lloydCd, String currVvd, String currCopDtlSeq, String currBound, String pickUpNo, String dtlUpdateSkipFlag, String isPodAtaReplace, String podAtaEventDt, String podAtaEventDtGmt, String podAtaYard) {
		this.dtlUpdateSkipFlag = dtlUpdateSkipFlag;
		this.pickUpNo = pickUpNo;
		this.currEventYard = currEventYard;
		this.podAtaEventDtGmt = podAtaEventDtGmt;
		this.vslNm = vslNm;
		this.lloydCd = lloydCd;
		this.isPodAtaReplace = isPodAtaReplace;
		this.pagerows = pagerows;
		this.currCopDtlSeq = currCopDtlSeq;
		this.currBound = currBound;
		this.currVvd = currVvd;
		this.podAtaYard = podAtaYard;
		this.ibflag = ibflag;
		this.currEventDt = currEventDt;
		this.podAtaEventDt = podAtaEventDt;
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dtl_update_skip_flag", getDtlUpdateSkipFlag());
		this.hashColumns.put("pick_up_no", getPickUpNo());
		this.hashColumns.put("curr_event_yard", getCurrEventYard());
		this.hashColumns.put("pod_ata_event_dt_gmt", getPodAtaEventDtGmt());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("lloyd_cd", getLloydCd());
		this.hashColumns.put("is_pod_ata_replace", getIsPodAtaReplace());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("curr_cop_dtl_seq", getCurrCopDtlSeq());
		this.hashColumns.put("curr_bound", getCurrBound());
		this.hashColumns.put("curr_vvd", getCurrVvd());
		this.hashColumns.put("pod_ata_yard", getPodAtaYard());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_event_dt", getCurrEventDt());
		this.hashColumns.put("pod_ata_event_dt", getPodAtaEventDt());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dtl_update_skip_flag", "dtlUpdateSkipFlag");
		this.hashFields.put("pick_up_no", "pickUpNo");
		this.hashFields.put("curr_event_yard", "currEventYard");
		this.hashFields.put("pod_ata_event_dt_gmt", "podAtaEventDtGmt");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("lloyd_cd", "lloydCd");
		this.hashFields.put("is_pod_ata_replace", "isPodAtaReplace");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("curr_cop_dtl_seq", "currCopDtlSeq");
		this.hashFields.put("curr_bound", "currBound");
		this.hashFields.put("curr_vvd", "currVvd");
		this.hashFields.put("pod_ata_yard", "podAtaYard");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_event_dt", "currEventDt");
		this.hashFields.put("pod_ata_event_dt", "podAtaEventDt");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dtlUpdateSkipFlag
	 */
	public String getDtlUpdateSkipFlag() {
		return this.dtlUpdateSkipFlag;
	}
	
	/**
	 * Column Info
	 * @return pickUpNo
	 */
	public String getPickUpNo() {
		return this.pickUpNo;
	}
	
	/**
	 * Column Info
	 * @return currEventYard
	 */
	public String getCurrEventYard() {
		return this.currEventYard;
	}
	
	/**
	 * Column Info
	 * @return podAtaEventDtGmt
	 */
	public String getPodAtaEventDtGmt() {
		return this.podAtaEventDtGmt;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return lloydCd
	 */
	public String getLloydCd() {
		return this.lloydCd;
	}
	
	/**
	 * Column Info
	 * @return isPodAtaReplace
	 */
	public String getIsPodAtaReplace() {
		return this.isPodAtaReplace;
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
	 * @return currCopDtlSeq
	 */
	public String getCurrCopDtlSeq() {
		return this.currCopDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return currBound
	 */
	public String getCurrBound() {
		return this.currBound;
	}
	
	/**
	 * Column Info
	 * @return currVvd
	 */
	public String getCurrVvd() {
		return this.currVvd;
	}
	
	/**
	 * Column Info
	 * @return podAtaYard
	 */
	public String getPodAtaYard() {
		return this.podAtaYard;
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
	 * @return currEventDt
	 */
	public String getCurrEventDt() {
		return this.currEventDt;
	}
	
	/**
	 * Column Info
	 * @return podAtaEventDt
	 */
	public String getPodAtaEventDt() {
		return this.podAtaEventDt;
	}
	
	/**
	 * Column Info
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	

	/**
	 * Column Info
	 * @param dtlUpdateSkipFlag
	 */
	public void setDtlUpdateSkipFlag(String dtlUpdateSkipFlag) {
		this.dtlUpdateSkipFlag = dtlUpdateSkipFlag;
	}
	
	/**
	 * Column Info
	 * @param pickUpNo
	 */
	public void setPickUpNo(String pickUpNo) {
		this.pickUpNo = pickUpNo;
	}
	
	/**
	 * Column Info
	 * @param currEventYard
	 */
	public void setCurrEventYard(String currEventYard) {
		this.currEventYard = currEventYard;
	}
	
	/**
	 * Column Info
	 * @param podAtaEventDtGmt
	 */
	public void setPodAtaEventDtGmt(String podAtaEventDtGmt) {
		this.podAtaEventDtGmt = podAtaEventDtGmt;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param lloydCd
	 */
	public void setLloydCd(String lloydCd) {
		this.lloydCd = lloydCd;
	}
	
	/**
	 * Column Info
	 * @param isPodAtaReplace
	 */
	public void setIsPodAtaReplace(String isPodAtaReplace) {
		this.isPodAtaReplace = isPodAtaReplace;
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
	 * @param currCopDtlSeq
	 */
	public void setCurrCopDtlSeq(String currCopDtlSeq) {
		this.currCopDtlSeq = currCopDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param currBound
	 */
	public void setCurrBound(String currBound) {
		this.currBound = currBound;
	}
	
	/**
	 * Column Info
	 * @param currVvd
	 */
	public void setCurrVvd(String currVvd) {
		this.currVvd = currVvd;
	}
	
	/**
	 * Column Info
	 * @param podAtaYard
	 */
	public void setPodAtaYard(String podAtaYard) {
		this.podAtaYard = podAtaYard;
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
	 * @param currEventDt
	 */
	public void setCurrEventDt(String currEventDt) {
		this.currEventDt = currEventDt;
	}
	
	/**
	 * Column Info
	 * @param podAtaEventDt
	 */
	public void setPodAtaEventDt(String podAtaEventDt) {
		this.podAtaEventDt = podAtaEventDt;
	}
	
	/**
	 * Column Info
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
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
		setDtlUpdateSkipFlag(JSPUtil.getParameter(request, prefix + "dtl_update_skip_flag", ""));
		setPickUpNo(JSPUtil.getParameter(request, prefix + "pick_up_no", ""));
		setCurrEventYard(JSPUtil.getParameter(request, prefix + "curr_event_yard", ""));
		setPodAtaEventDtGmt(JSPUtil.getParameter(request, prefix + "pod_ata_event_dt_gmt", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setLloydCd(JSPUtil.getParameter(request, prefix + "lloyd_cd", ""));
		setIsPodAtaReplace(JSPUtil.getParameter(request, prefix + "is_pod_ata_replace", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCurrCopDtlSeq(JSPUtil.getParameter(request, prefix + "curr_cop_dtl_seq", ""));
		setCurrBound(JSPUtil.getParameter(request, prefix + "curr_bound", ""));
		setCurrVvd(JSPUtil.getParameter(request, prefix + "curr_vvd", ""));
		setPodAtaYard(JSPUtil.getParameter(request, prefix + "pod_ata_yard", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrEventDt(JSPUtil.getParameter(request, prefix + "curr_event_dt", ""));
		setPodAtaEventDt(JSPUtil.getParameter(request, prefix + "pod_ata_event_dt", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315CurrInfoVO[]
	 */
	public Edi315CurrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315CurrInfoVO[]
	 */
	public Edi315CurrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315CurrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dtlUpdateSkipFlag = (JSPUtil.getParameter(request, prefix	+ "dtl_update_skip_flag", length));
			String[] pickUpNo = (JSPUtil.getParameter(request, prefix	+ "pick_up_no", length));
			String[] currEventYard = (JSPUtil.getParameter(request, prefix	+ "curr_event_yard", length));
			String[] podAtaEventDtGmt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_event_dt_gmt", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] lloydCd = (JSPUtil.getParameter(request, prefix	+ "lloyd_cd", length));
			String[] isPodAtaReplace = (JSPUtil.getParameter(request, prefix	+ "is_pod_ata_replace", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] currCopDtlSeq = (JSPUtil.getParameter(request, prefix	+ "curr_cop_dtl_seq", length));
			String[] currBound = (JSPUtil.getParameter(request, prefix	+ "curr_bound", length));
			String[] currVvd = (JSPUtil.getParameter(request, prefix	+ "curr_vvd", length));
			String[] podAtaYard = (JSPUtil.getParameter(request, prefix	+ "pod_ata_yard", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currEventDt = (JSPUtil.getParameter(request, prefix	+ "curr_event_dt", length));
			String[] podAtaEventDt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_event_dt", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315CurrInfoVO();
				if (dtlUpdateSkipFlag[i] != null)
					model.setDtlUpdateSkipFlag(dtlUpdateSkipFlag[i]);
				if (pickUpNo[i] != null)
					model.setPickUpNo(pickUpNo[i]);
				if (currEventYard[i] != null)
					model.setCurrEventYard(currEventYard[i]);
				if (podAtaEventDtGmt[i] != null)
					model.setPodAtaEventDtGmt(podAtaEventDtGmt[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (lloydCd[i] != null)
					model.setLloydCd(lloydCd[i]);
				if (isPodAtaReplace[i] != null)
					model.setIsPodAtaReplace(isPodAtaReplace[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (currCopDtlSeq[i] != null)
					model.setCurrCopDtlSeq(currCopDtlSeq[i]);
				if (currBound[i] != null)
					model.setCurrBound(currBound[i]);
				if (currVvd[i] != null)
					model.setCurrVvd(currVvd[i]);
				if (podAtaYard[i] != null)
					model.setPodAtaYard(podAtaYard[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currEventDt[i] != null)
					model.setCurrEventDt(currEventDt[i]);
				if (podAtaEventDt[i] != null)
					model.setPodAtaEventDt(podAtaEventDt[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315CurrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315CurrInfoVO[]
	 */
	public Edi315CurrInfoVO[] getEdi315CurrInfoVOs(){
		Edi315CurrInfoVO[] vos = (Edi315CurrInfoVO[])models.toArray(new Edi315CurrInfoVO[models.size()]);
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
		this.dtlUpdateSkipFlag = this.dtlUpdateSkipFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickUpNo = this.pickUpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currEventYard = this.currEventYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaEventDtGmt = this.podAtaEventDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydCd = this.lloydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isPodAtaReplace = this.isPodAtaReplace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCopDtlSeq = this.currCopDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currBound = this.currBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currVvd = this.currVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaYard = this.podAtaYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currEventDt = this.currEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaEventDt = this.podAtaEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
