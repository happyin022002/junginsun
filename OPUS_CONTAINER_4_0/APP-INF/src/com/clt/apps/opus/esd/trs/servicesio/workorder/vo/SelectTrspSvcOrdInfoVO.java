/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SelectTrspSvcOrdInfoVO.java
*@FileTitle : SelectTrspSvcOrdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.servicesio.workorder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SelectTrspSvcOrdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SelectTrspSvcOrdInfoVO> models = new ArrayList<SelectTrspSvcOrdInfoVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String cutOffDt = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String cntcPsonPhnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SelectTrspSvcOrdInfoVO() {}

	public SelectTrspSvcOrdInfoVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String trspWoOfcCtyCd, String trspWoSeq, String bkgNo, String blNo, String cntcPsonNm, String cntcPsonPhnNo, String eqNo, String cutOffDt) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.trspWoSeq = trspWoSeq;
		this.cutOffDt = cutOffDt;
		this.cntcPsonNm = cntcPsonNm;
		this.trspSoSeq = trspSoSeq;
		this.cntcPsonPhnNo = cntcPsonPhnNo;
		this.blNo = blNo;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("cut_off_dt", getCutOffDt());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cntc_pson_phn_no", getCntcPsonPhnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("cut_off_dt", "cutOffDt");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cntc_pson_phn_no", "cntcPsonPhnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return cutOffDt
	 */
	public String getCutOffDt() {
		return this.cutOffDt;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
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
	 * @return cntcPsonPhnNo
	 */
	public String getCntcPsonPhnNo() {
		return this.cntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param cutOffDt
	 */
	public void setCutOffDt(String cutOffDt) {
		this.cutOffDt = cutOffDt;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
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
	 * @param cntcPsonPhnNo
	 */
	public void setCntcPsonPhnNo(String cntcPsonPhnNo) {
		this.cntcPsonPhnNo = cntcPsonPhnNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, prefix + "trsp_wo_seq", ""));
		setCutOffDt(JSPUtil.getParameter(request, prefix + "cut_off_dt", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCntcPsonPhnNo(JSPUtil.getParameter(request, prefix + "cntc_pson_phn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_wo_ofc_cty_cd", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SelectTrspSvcOrdInfoVO[]
	 */
	public SelectTrspSvcOrdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SelectTrspSvcOrdInfoVO[]
	 */
	public SelectTrspSvcOrdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SelectTrspSvcOrdInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] cutOffDt = (JSPUtil.getParameter(request, prefix	+ "cut_off_dt", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] cntcPsonPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_phn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SelectTrspSvcOrdInfoVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (cutOffDt[i] != null)
					model.setCutOffDt(cutOffDt[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (cntcPsonPhnNo[i] != null)
					model.setCntcPsonPhnNo(cntcPsonPhnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSelectTrspSvcOrdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SelectTrspSvcOrdInfoVO[]
	 */
	public SelectTrspSvcOrdInfoVO[] getSelectTrspSvcOrdInfoVOs(){
		SelectTrspSvcOrdInfoVO[] vos = (SelectTrspSvcOrdInfoVO[])models.toArray(new SelectTrspSvcOrdInfoVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cutOffDt = this.cutOffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonPhnNo = this.cntcPsonPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
