/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EdiMqSendVO.java
*@FileTitle : EdiMqSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copdetailreceive.vo;

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

public class EdiMqSendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdiMqSendVO> models = new ArrayList<EdiMqSendVO>();
	
	/* Column Info */
	private String outDtlSeq = null;
	/* Column Info */
	private String outCallFrom = null;
	/* Column Info */
	private String outCopStsCd = null;
	/* Column Info */
	private String outNod = null;
	/* Column Info */
	private String outEventDt = null;
	/* Column Info */
	private String outBkgNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String outSkdDirCd = null;
	/* Column Info */
	private String outBlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String outCntrNo = null;
	/* Column Info */
	private String outCnmvDtTm = null;
	/* Column Info */
	private String outSkdVoyageNo = null;
	/* Column Info */
	private String outVslCd = null;
	/* Column Info */
	private String outOrgYdCd = null;
	/* Column Info */
	private String outEdiSts = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdiMqSendVO() {}

	public EdiMqSendVO(String ibflag, String pagerows, String outCallFrom, String outCnmvDtTm, String outCntrNo, String outEdiSts, String outBlNo, String outBkgNo, String outCopStsCd, String outDtlSeq, String outVslCd, String outSkdVoyageNo, String outSkdDirCd, String outOrgYdCd, String outEventDt, String outNod) {
		this.outDtlSeq = outDtlSeq;
		this.outCallFrom = outCallFrom;
		this.outCopStsCd = outCopStsCd;
		this.outNod = outNod;
		this.outEventDt = outEventDt;
		this.outBkgNo = outBkgNo;
		this.pagerows = pagerows;
		this.outSkdDirCd = outSkdDirCd;
		this.outBlNo = outBlNo;
		this.ibflag = ibflag;
		this.outCntrNo = outCntrNo;
		this.outCnmvDtTm = outCnmvDtTm;
		this.outSkdVoyageNo = outSkdVoyageNo;
		this.outVslCd = outVslCd;
		this.outOrgYdCd = outOrgYdCd;
		this.outEdiSts = outEdiSts;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("out_dtl_seq", getOutDtlSeq());
		this.hashColumns.put("out_call_from", getOutCallFrom());
		this.hashColumns.put("out_cop_sts_cd", getOutCopStsCd());
		this.hashColumns.put("out_nod", getOutNod());
		this.hashColumns.put("out_event_dt", getOutEventDt());
		this.hashColumns.put("out_bkg_no", getOutBkgNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("out_skd_dir_cd", getOutSkdDirCd());
		this.hashColumns.put("out_bl_no", getOutBlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("out_cntr_no", getOutCntrNo());
		this.hashColumns.put("out_cnmv_dt_tm", getOutCnmvDtTm());
		this.hashColumns.put("out_skd_voyage_no", getOutSkdVoyageNo());
		this.hashColumns.put("out_vsl_cd", getOutVslCd());
		this.hashColumns.put("out_org_yd_cd", getOutOrgYdCd());
		this.hashColumns.put("out_edi_sts", getOutEdiSts());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("out_dtl_seq", "outDtlSeq");
		this.hashFields.put("out_call_from", "outCallFrom");
		this.hashFields.put("out_cop_sts_cd", "outCopStsCd");
		this.hashFields.put("out_nod", "outNod");
		this.hashFields.put("out_event_dt", "outEventDt");
		this.hashFields.put("out_bkg_no", "outBkgNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("out_skd_dir_cd", "outSkdDirCd");
		this.hashFields.put("out_bl_no", "outBlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("out_cntr_no", "outCntrNo");
		this.hashFields.put("out_cnmv_dt_tm", "outCnmvDtTm");
		this.hashFields.put("out_skd_voyage_no", "outSkdVoyageNo");
		this.hashFields.put("out_vsl_cd", "outVslCd");
		this.hashFields.put("out_org_yd_cd", "outOrgYdCd");
		this.hashFields.put("out_edi_sts", "outEdiSts");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return outDtlSeq
	 */
	public String getOutDtlSeq() {
		return this.outDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return outCallFrom
	 */
	public String getOutCallFrom() {
		return this.outCallFrom;
	}
	
	/**
	 * Column Info
	 * @return outCopStsCd
	 */
	public String getOutCopStsCd() {
		return this.outCopStsCd;
	}
	
	/**
	 * Column Info
	 * @return outNod
	 */
	public String getOutNod() {
		return this.outNod;
	}
	
	/**
	 * Column Info
	 * @return outEventDt
	 */
	public String getOutEventDt() {
		return this.outEventDt;
	}
	
	/**
	 * Column Info
	 * @return outBkgNo
	 */
	public String getOutBkgNo() {
		return this.outBkgNo;
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
	 * @return outSkdDirCd
	 */
	public String getOutSkdDirCd() {
		return this.outSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return outBlNo
	 */
	public String getOutBlNo() {
		return this.outBlNo;
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
	 * @return outCntrNo
	 */
	public String getOutCntrNo() {
		return this.outCntrNo;
	}
	
	/**
	 * Column Info
	 * @return outCnmvDtTm
	 */
	public String getOutCnmvDtTm() {
		return this.outCnmvDtTm;
	}
	
	/**
	 * Column Info
	 * @return outSkdVoyageNo
	 */
	public String getOutSkdVoyageNo() {
		return this.outSkdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @return outVslCd
	 */
	public String getOutVslCd() {
		return this.outVslCd;
	}
	
	/**
	 * Column Info
	 * @return outOrgYdCd
	 */
	public String getOutOrgYdCd() {
		return this.outOrgYdCd;
	}
	
	/**
	 * Column Info
	 * @return outEdiSts
	 */
	public String getOutEdiSts() {
		return this.outEdiSts;
	}
	

	/**
	 * Column Info
	 * @param outDtlSeq
	 */
	public void setOutDtlSeq(String outDtlSeq) {
		this.outDtlSeq = outDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param outCallFrom
	 */
	public void setOutCallFrom(String outCallFrom) {
		this.outCallFrom = outCallFrom;
	}
	
	/**
	 * Column Info
	 * @param outCopStsCd
	 */
	public void setOutCopStsCd(String outCopStsCd) {
		this.outCopStsCd = outCopStsCd;
	}
	
	/**
	 * Column Info
	 * @param outNod
	 */
	public void setOutNod(String outNod) {
		this.outNod = outNod;
	}
	
	/**
	 * Column Info
	 * @param outEventDt
	 */
	public void setOutEventDt(String outEventDt) {
		this.outEventDt = outEventDt;
	}
	
	/**
	 * Column Info
	 * @param outBkgNo
	 */
	public void setOutBkgNo(String outBkgNo) {
		this.outBkgNo = outBkgNo;
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
	 * @param outSkdDirCd
	 */
	public void setOutSkdDirCd(String outSkdDirCd) {
		this.outSkdDirCd = outSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param outBlNo
	 */
	public void setOutBlNo(String outBlNo) {
		this.outBlNo = outBlNo;
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
	 * @param outCntrNo
	 */
	public void setOutCntrNo(String outCntrNo) {
		this.outCntrNo = outCntrNo;
	}
	
	/**
	 * Column Info
	 * @param outCnmvDtTm
	 */
	public void setOutCnmvDtTm(String outCnmvDtTm) {
		this.outCnmvDtTm = outCnmvDtTm;
	}
	
	/**
	 * Column Info
	 * @param outSkdVoyageNo
	 */
	public void setOutSkdVoyageNo(String outSkdVoyageNo) {
		this.outSkdVoyageNo = outSkdVoyageNo;
	}
	
	/**
	 * Column Info
	 * @param outVslCd
	 */
	public void setOutVslCd(String outVslCd) {
		this.outVslCd = outVslCd;
	}
	
	/**
	 * Column Info
	 * @param outOrgYdCd
	 */
	public void setOutOrgYdCd(String outOrgYdCd) {
		this.outOrgYdCd = outOrgYdCd;
	}
	
	/**
	 * Column Info
	 * @param outEdiSts
	 */
	public void setOutEdiSts(String outEdiSts) {
		this.outEdiSts = outEdiSts;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOutDtlSeq(JSPUtil.getParameter(request, "out_dtl_seq", ""));
		setOutCallFrom(JSPUtil.getParameter(request, "out_call_from", ""));
		setOutCopStsCd(JSPUtil.getParameter(request, "out_cop_sts_cd", ""));
		setOutNod(JSPUtil.getParameter(request, "out_nod", ""));
		setOutEventDt(JSPUtil.getParameter(request, "out_event_dt", ""));
		setOutBkgNo(JSPUtil.getParameter(request, "out_bkg_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOutSkdDirCd(JSPUtil.getParameter(request, "out_skd_dir_cd", ""));
		setOutBlNo(JSPUtil.getParameter(request, "out_bl_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOutCntrNo(JSPUtil.getParameter(request, "out_cntr_no", ""));
		setOutCnmvDtTm(JSPUtil.getParameter(request, "out_cnmv_dt_tm", ""));
		setOutSkdVoyageNo(JSPUtil.getParameter(request, "out_skd_voyage_no", ""));
		setOutVslCd(JSPUtil.getParameter(request, "out_vsl_cd", ""));
		setOutOrgYdCd(JSPUtil.getParameter(request, "out_org_yd_cd", ""));
		setOutEdiSts(JSPUtil.getParameter(request, "out_edi_sts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiMqSendVO[]
	 */
	public EdiMqSendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdiMqSendVO[]
	 */
	public EdiMqSendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdiMqSendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] outDtlSeq = (JSPUtil.getParameter(request, prefix	+ "out_dtl_seq", length));
			String[] outCallFrom = (JSPUtil.getParameter(request, prefix	+ "out_call_from", length));
			String[] outCopStsCd = (JSPUtil.getParameter(request, prefix	+ "out_cop_sts_cd", length));
			String[] outNod = (JSPUtil.getParameter(request, prefix	+ "out_nod", length));
			String[] outEventDt = (JSPUtil.getParameter(request, prefix	+ "out_event_dt", length));
			String[] outBkgNo = (JSPUtil.getParameter(request, prefix	+ "out_bkg_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] outSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "out_skd_dir_cd", length));
			String[] outBlNo = (JSPUtil.getParameter(request, prefix	+ "out_bl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] outCntrNo = (JSPUtil.getParameter(request, prefix	+ "out_cntr_no", length));
			String[] outCnmvDtTm = (JSPUtil.getParameter(request, prefix	+ "out_cnmv_dt_tm", length));
			String[] outSkdVoyageNo = (JSPUtil.getParameter(request, prefix	+ "out_skd_voyage_no", length));
			String[] outVslCd = (JSPUtil.getParameter(request, prefix	+ "out_vsl_cd", length));
			String[] outOrgYdCd = (JSPUtil.getParameter(request, prefix	+ "out_org_yd_cd", length));
			String[] outEdiSts = (JSPUtil.getParameter(request, prefix	+ "out_edi_sts", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdiMqSendVO();
				if (outDtlSeq[i] != null)
					model.setOutDtlSeq(outDtlSeq[i]);
				if (outCallFrom[i] != null)
					model.setOutCallFrom(outCallFrom[i]);
				if (outCopStsCd[i] != null)
					model.setOutCopStsCd(outCopStsCd[i]);
				if (outNod[i] != null)
					model.setOutNod(outNod[i]);
				if (outEventDt[i] != null)
					model.setOutEventDt(outEventDt[i]);
				if (outBkgNo[i] != null)
					model.setOutBkgNo(outBkgNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (outSkdDirCd[i] != null)
					model.setOutSkdDirCd(outSkdDirCd[i]);
				if (outBlNo[i] != null)
					model.setOutBlNo(outBlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (outCntrNo[i] != null)
					model.setOutCntrNo(outCntrNo[i]);
				if (outCnmvDtTm[i] != null)
					model.setOutCnmvDtTm(outCnmvDtTm[i]);
				if (outSkdVoyageNo[i] != null)
					model.setOutSkdVoyageNo(outSkdVoyageNo[i]);
				if (outVslCd[i] != null)
					model.setOutVslCd(outVslCd[i]);
				if (outOrgYdCd[i] != null)
					model.setOutOrgYdCd(outOrgYdCd[i]);
				if (outEdiSts[i] != null)
					model.setOutEdiSts(outEdiSts[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdiMqSendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdiMqSendVO[]
	 */
	public EdiMqSendVO[] getEdiMqSendVOs(){
		EdiMqSendVO[] vos = (EdiMqSendVO[])models.toArray(new EdiMqSendVO[models.size()]);
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
		this.outDtlSeq = this.outDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outCallFrom = this.outCallFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outCopStsCd = this.outCopStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outNod = this.outNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outEventDt = this.outEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outBkgNo = this.outBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outSkdDirCd = this.outSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outBlNo = this.outBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outCntrNo = this.outCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outCnmvDtTm = this.outCnmvDtTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outSkdVoyageNo = this.outSkdVoyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outVslCd = this.outVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outOrgYdCd = this.outOrgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outEdiSts = this.outEdiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
