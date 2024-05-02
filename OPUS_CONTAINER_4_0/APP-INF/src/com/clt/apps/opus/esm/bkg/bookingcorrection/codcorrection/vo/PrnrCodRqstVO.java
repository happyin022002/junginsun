/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrnrCodRqstVO.java
*@FileTitle : PrnrCodRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.26 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrnrCodRqstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrnrCodRqstVO> models = new ArrayList<PrnrCodRqstVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rhndVvd = null;
	/* Column Info */
	private String oldPolNm = null;
	/* Column Info */
	private String codStsCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String oldPod = null;
	/* Column Info */
	private String codIssDt = null;
	/* Column Info */
	private String newPodNm = null;
	/* Column Info */
	private String header = null;
	/* Column Info */
	private String carrierCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oldPol = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newPod = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String oldPodNm = null;
	/* Column Info */
	private String operationTeam = null;
	/* Column Info */
	private String voyageNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrnrCodRqstVO() {}

	public PrnrCodRqstVO(String ibflag, String pagerows, String header, String rqstDt, String carrierCd, String operationTeam, String refNo, String vslNm, String voyageNo, String oldPol, String oldPod, String newPod, String codIssDt, String rhndVvd, String oldPolNm, String oldPodNm, String newPodNm, String codStsCd) {
		this.rqstDt = rqstDt;
		this.rhndVvd = rhndVvd;
		this.oldPolNm = oldPolNm;
		this.codStsCd = codStsCd;
		this.vslNm = vslNm;
		this.oldPod = oldPod;
		this.codIssDt = codIssDt;
		this.newPodNm = newPodNm;
		this.header = header;
		this.carrierCd = carrierCd;
		this.pagerows = pagerows;
		this.oldPol = oldPol;
		this.ibflag = ibflag;
		this.newPod = newPod;
		this.refNo = refNo;
		this.oldPodNm = oldPodNm;
		this.operationTeam = operationTeam;
		this.voyageNo = voyageNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rhnd_vvd", getRhndVvd());
		this.hashColumns.put("old_pol_nm", getOldPolNm());
		this.hashColumns.put("cod_sts_cd", getCodStsCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("old_pod", getOldPod());
		this.hashColumns.put("cod_iss_dt", getCodIssDt());
		this.hashColumns.put("new_pod_nm", getNewPodNm());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("carrier_cd", getCarrierCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("old_pol", getOldPol());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_pod", getNewPod());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("old_pod_nm", getOldPodNm());
		this.hashColumns.put("operation_team", getOperationTeam());
		this.hashColumns.put("voyage_no", getVoyageNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rhnd_vvd", "rhndVvd");
		this.hashFields.put("old_pol_nm", "oldPolNm");
		this.hashFields.put("cod_sts_cd", "codStsCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("old_pod", "oldPod");
		this.hashFields.put("cod_iss_dt", "codIssDt");
		this.hashFields.put("new_pod_nm", "newPodNm");
		this.hashFields.put("header", "header");
		this.hashFields.put("carrier_cd", "carrierCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("old_pol", "oldPol");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_pod", "newPod");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("old_pod_nm", "oldPodNm");
		this.hashFields.put("operation_team", "operationTeam");
		this.hashFields.put("voyage_no", "voyageNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return rhndVvd
	 */
	public String getRhndVvd() {
		return this.rhndVvd;
	}
	
	/**
	 * Column Info
	 * @return oldPolNm
	 */
	public String getOldPolNm() {
		return this.oldPolNm;
	}
	
	/**
	 * Column Info
	 * @return codStsCd
	 */
	public String getCodStsCd() {
		return this.codStsCd;
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
	 * @return oldPod
	 */
	public String getOldPod() {
		return this.oldPod;
	}
	
	/**
	 * Column Info
	 * @return codIssDt
	 */
	public String getCodIssDt() {
		return this.codIssDt;
	}
	
	/**
	 * Column Info
	 * @return newPodNm
	 */
	public String getNewPodNm() {
		return this.newPodNm;
	}
	
	/**
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}
	
	/**
	 * Column Info
	 * @return carrierCd
	 */
	public String getCarrierCd() {
		return this.carrierCd;
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
	 * @return oldPol
	 */
	public String getOldPol() {
		return this.oldPol;
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
	 * @return newPod
	 */
	public String getNewPod() {
		return this.newPod;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return oldPodNm
	 */
	public String getOldPodNm() {
		return this.oldPodNm;
	}
	
	/**
	 * Column Info
	 * @return operationTeam
	 */
	public String getOperationTeam() {
		return this.operationTeam;
	}
	
	/**
	 * Column Info
	 * @return voyageNo
	 */
	public String getVoyageNo() {
		return this.voyageNo;
	}
	

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param rhndVvd
	 */
	public void setRhndVvd(String rhndVvd) {
		this.rhndVvd = rhndVvd;
	}
	
	/**
	 * Column Info
	 * @param oldPolNm
	 */
	public void setOldPolNm(String oldPolNm) {
		this.oldPolNm = oldPolNm;
	}
	
	/**
	 * Column Info
	 * @param codStsCd
	 */
	public void setCodStsCd(String codStsCd) {
		this.codStsCd = codStsCd;
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
	 * @param oldPod
	 */
	public void setOldPod(String oldPod) {
		this.oldPod = oldPod;
	}
	
	/**
	 * Column Info
	 * @param codIssDt
	 */
	public void setCodIssDt(String codIssDt) {
		this.codIssDt = codIssDt;
	}
	
	/**
	 * Column Info
	 * @param newPodNm
	 */
	public void setNewPodNm(String newPodNm) {
		this.newPodNm = newPodNm;
	}
	
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * Column Info
	 * @param carrierCd
	 */
	public void setCarrierCd(String carrierCd) {
		this.carrierCd = carrierCd;
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
	 * @param oldPol
	 */
	public void setOldPol(String oldPol) {
		this.oldPol = oldPol;
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
	 * @param newPod
	 */
	public void setNewPod(String newPod) {
		this.newPod = newPod;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param oldPodNm
	 */
	public void setOldPodNm(String oldPodNm) {
		this.oldPodNm = oldPodNm;
	}
	
	/**
	 * Column Info
	 * @param operationTeam
	 */
	public void setOperationTeam(String operationTeam) {
		this.operationTeam = operationTeam;
	}
	
	/**
	 * Column Info
	 * @param voyageNo
	 */
	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
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
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setRhndVvd(JSPUtil.getParameter(request, prefix + "rhnd_vvd", ""));
		setOldPolNm(JSPUtil.getParameter(request, prefix + "old_pol_nm", ""));
		setCodStsCd(JSPUtil.getParameter(request, prefix + "cod_sts_cd", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setOldPod(JSPUtil.getParameter(request, prefix + "old_pod", ""));
		setCodIssDt(JSPUtil.getParameter(request, prefix + "cod_iss_dt", ""));
		setNewPodNm(JSPUtil.getParameter(request, prefix + "new_pod_nm", ""));
		setHeader(JSPUtil.getParameter(request, prefix + "header", ""));
		setCarrierCd(JSPUtil.getParameter(request, prefix + "carrier_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOldPol(JSPUtil.getParameter(request, prefix + "old_pol", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNewPod(JSPUtil.getParameter(request, prefix + "new_pod", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setOldPodNm(JSPUtil.getParameter(request, prefix + "old_pod_nm", ""));
		setOperationTeam(JSPUtil.getParameter(request, prefix + "operation_team", ""));
		setVoyageNo(JSPUtil.getParameter(request, prefix + "voyage_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrnrCodRqstVO[]
	 */
	public PrnrCodRqstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrnrCodRqstVO[]
	 */
	public PrnrCodRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrnrCodRqstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rhndVvd = (JSPUtil.getParameter(request, prefix	+ "rhnd_vvd", length));
			String[] oldPolNm = (JSPUtil.getParameter(request, prefix	+ "old_pol_nm", length));
			String[] codStsCd = (JSPUtil.getParameter(request, prefix	+ "cod_sts_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] oldPod = (JSPUtil.getParameter(request, prefix	+ "old_pod", length));
			String[] codIssDt = (JSPUtil.getParameter(request, prefix	+ "cod_iss_dt", length));
			String[] newPodNm = (JSPUtil.getParameter(request, prefix	+ "new_pod_nm", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "header", length));
			String[] carrierCd = (JSPUtil.getParameter(request, prefix	+ "carrier_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oldPol = (JSPUtil.getParameter(request, prefix	+ "old_pol", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newPod = (JSPUtil.getParameter(request, prefix	+ "new_pod", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] oldPodNm = (JSPUtil.getParameter(request, prefix	+ "old_pod_nm", length));
			String[] operationTeam = (JSPUtil.getParameter(request, prefix	+ "operation_team", length));
			String[] voyageNo = (JSPUtil.getParameter(request, prefix	+ "voyage_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrnrCodRqstVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rhndVvd[i] != null)
					model.setRhndVvd(rhndVvd[i]);
				if (oldPolNm[i] != null)
					model.setOldPolNm(oldPolNm[i]);
				if (codStsCd[i] != null)
					model.setCodStsCd(codStsCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (oldPod[i] != null)
					model.setOldPod(oldPod[i]);
				if (codIssDt[i] != null)
					model.setCodIssDt(codIssDt[i]);
				if (newPodNm[i] != null)
					model.setNewPodNm(newPodNm[i]);
				if (header[i] != null)
					model.setHeader(header[i]);
				if (carrierCd[i] != null)
					model.setCarrierCd(carrierCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oldPol[i] != null)
					model.setOldPol(oldPol[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newPod[i] != null)
					model.setNewPod(newPod[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (oldPodNm[i] != null)
					model.setOldPodNm(oldPodNm[i]);
				if (operationTeam[i] != null)
					model.setOperationTeam(operationTeam[i]);
				if (voyageNo[i] != null)
					model.setVoyageNo(voyageNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrnrCodRqstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrnrCodRqstVO[]
	 */
	public PrnrCodRqstVO[] getPrnrCodRqstVOs(){
		PrnrCodRqstVO[] vos = (PrnrCodRqstVO[])models.toArray(new PrnrCodRqstVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhndVvd = this.rhndVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPolNm = this.oldPolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codStsCd = this.codStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPod = this.oldPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codIssDt = this.codIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodNm = this.newPodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCd = this.carrierCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPol = this.oldPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPod = this.newPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodNm = this.oldPodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.operationTeam = this.operationTeam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyageNo = this.voyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
