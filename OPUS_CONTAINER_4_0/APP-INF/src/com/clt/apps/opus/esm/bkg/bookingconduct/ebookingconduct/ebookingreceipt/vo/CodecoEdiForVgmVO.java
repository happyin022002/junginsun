/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CodecoEdiForVgmVO.java
*@FileTitle : CodecoEdiForVgmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
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

public class CodecoEdiForVgmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodecoEdiForVgmVO> models = new ArrayList<CodecoEdiForVgmVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vgmCustEml = null;
	/* Column Info */
	private String vgmCustCntcTpCd = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmDocIdNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vgmDocTpCd = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vgmCustCntcNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vgmDtTpCd = null;
	/* Column Info */
	private String ctmEdiTp = null;
		/* Column Info */
	private String vgmRcvDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CodecoEdiForVgmVO() {}

	public CodecoEdiForVgmVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String vgmWgt, String vgmWgtUtCd, String vgmCustCntcNm, String vgmCustEml, String vgmDocIdNo, String vgmCustCntcTpCd, String vgmDocTpCd, String vgmDtTpCd, String ctmEdiTp, String vgmRcvDt) {
		this.pagerows = pagerows;
		this.vgmCustEml = vgmCustEml;
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
		this.vgmWgt = vgmWgt;
		this.vgmDocIdNo = vgmDocIdNo;
		this.ibflag = ibflag;
		this.vgmDocTpCd = vgmDocTpCd;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.bkgNo = bkgNo;
		this.vgmCustCntcNm = vgmCustCntcNm;
		this.cntrNo = cntrNo;
		this.vgmDtTpCd = vgmDtTpCd;
		this.ctmEdiTp = ctmEdiTp;
		this.vgmRcvDt = vgmRcvDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vgm_cust_eml", getVgmCustEml());
		this.hashColumns.put("vgm_cust_cntc_tp_cd", getVgmCustCntcTpCd());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_doc_id_no", getVgmDocIdNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vgm_doc_tp_cd", getVgmDocTpCd());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vgm_cust_cntc_nm", getVgmCustCntcNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vgm_dt_tp_cd", getVgmDtTpCd());
		this.hashColumns.put("ctm_edi_tp", getCtmEdiTp());
		this.hashColumns.put("vgm_rcv_dt", getVgmRcvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vgm_cust_eml", "vgmCustEml");
		this.hashFields.put("vgm_cust_cntc_tp_cd", "vgmCustCntcTpCd");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_doc_id_no", "vgmDocIdNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vgm_doc_tp_cd", "vgmDocTpCd");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vgm_cust_cntc_nm", "vgmCustCntcNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vgm_dt_tp_cd", "vgmDtTpCd");
		this.hashFields.put("ctm_edi_tp", "ctmEdiTp");
		this.hashFields.put("vgm_rcv_dt", "vgmRcvDt");
		return this.hashFields;
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
	 * @return vgmCustEml
	 */
	public String getVgmCustEml() {
		return this.vgmCustEml;
	}
	
	/**
	 * Column Info
	 * @return vgmCustCntcTpCd
	 */
	public String getVgmCustCntcTpCd() {
		return this.vgmCustCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmDocIdNo
	 */
	public String getVgmDocIdNo() {
		return this.vgmDocIdNo;
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
	 * @return vgmDocTpCd
	 */
	public String getVgmDocTpCd() {
		return this.vgmDocTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
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
	 * @return vgmCustCntcNm
	 */
	public String getVgmCustCntcNm() {
		return this.vgmCustCntcNm;
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
	 * @return vgmDtTpCd
	 */
	public String getVgmDtTpCd() {
		return this.vgmDtTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctmEdiTp
	 */
	public String getCtmEdiTp() {
		return this.ctmEdiTp;
	}
	
		/**
	 * Column Info
	 * @return vgmRcvDt
	 */
	public String getVgmRcvDt() {
		return this.vgmRcvDt;
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
	 * @param vgmCustEml
	 */
	public void setVgmCustEml(String vgmCustEml) {
		this.vgmCustEml = vgmCustEml;
	}
	
	/**
	 * Column Info
	 * @param vgmCustCntcTpCd
	 */
	public void setVgmCustCntcTpCd(String vgmCustCntcTpCd) {
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	/**
	 * Column Info
	 * @param vgmDocIdNo
	 */
	public void setVgmDocIdNo(String vgmDocIdNo) {
		this.vgmDocIdNo = vgmDocIdNo;
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
	 * @param vgmDocTpCd
	 */
	public void setVgmDocTpCd(String vgmDocTpCd) {
		this.vgmDocTpCd = vgmDocTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
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
	 * @param vgmCustCntcNm
	 */
	public void setVgmCustCntcNm(String vgmCustCntcNm) {
		this.vgmCustCntcNm = vgmCustCntcNm;
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
	 * @param vgmDtTpCd
	 */
	public void setVgmDtTpCd(String vgmDtTpCd) {
		this.vgmDtTpCd = vgmDtTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctmEdiTp
	 */
	public void setCtmEdiTp(String ctmEdiTp) {
		this.ctmEdiTp = ctmEdiTp;
	}
	
		/**
	 * Column Info
	 * @param vgmRcvDt
	 */
	public void setVgmRcvDt(String vgmRcvDt) {
		this.vgmRcvDt = vgmRcvDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVgmCustEml(JSPUtil.getParameter(request, prefix + "vgm_cust_eml", ""));
		setVgmCustCntcTpCd(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_tp_cd", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmDocIdNo(JSPUtil.getParameter(request, prefix + "vgm_doc_id_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVgmDocTpCd(JSPUtil.getParameter(request, prefix + "vgm_doc_tp_cd", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVgmCustCntcNm(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setVgmDtTpCd(JSPUtil.getParameter(request, prefix + "vgm_dt_tp_cd", ""));
		setCtmEdiTp(JSPUtil.getParameter(request, prefix + "ctm_edi_tp", ""));
		setVgmRcvDt(JSPUtil.getParameter(request, prefix + "vgm_rcv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodecoEdiForVgmVO[]
	 */
	public CodecoEdiForVgmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodecoEdiForVgmVO[]
	 */
	public CodecoEdiForVgmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodecoEdiForVgmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vgmCustEml = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_eml", length));
			String[] vgmCustCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_tp_cd", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmDocIdNo = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_id_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vgmDocTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_tp_cd", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vgmCustCntcNm = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vgmDtTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_dt_tp_cd", length));
			String[] ctmEdiTp = (JSPUtil.getParameter(request, prefix	+ "ctm_edi_tp", length));
			String[] vgmRcvDt = (JSPUtil.getParameter(request, prefix	+ "vgm_rcv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodecoEdiForVgmVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vgmCustEml[i] != null)
					model.setVgmCustEml(vgmCustEml[i]);
				if (vgmCustCntcTpCd[i] != null)
					model.setVgmCustCntcTpCd(vgmCustCntcTpCd[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmDocIdNo[i] != null)
					model.setVgmDocIdNo(vgmDocIdNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vgmDocTpCd[i] != null)
					model.setVgmDocTpCd(vgmDocTpCd[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vgmCustCntcNm[i] != null)
					model.setVgmCustCntcNm(vgmCustCntcNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vgmDtTpCd[i] != null)
					model.setVgmDtTpCd(vgmDtTpCd[i]);
				if (ctmEdiTp[i] != null)
					model.setCtmEdiTp(ctmEdiTp[i]);
				if (vgmRcvDt[i] != null)
					model.setVgmRcvDt(vgmRcvDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodecoEdiForVgmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodecoEdiForVgmVO[]
	 */
	public CodecoEdiForVgmVO[] getCodecoEdiForVgmVOs(){
		CodecoEdiForVgmVO[] vos = (CodecoEdiForVgmVO[])models.toArray(new CodecoEdiForVgmVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustEml = this.vgmCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcTpCd = this.vgmCustCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocIdNo = this.vgmDocIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocTpCd = this.vgmDocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcNm = this.vgmCustCntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtTpCd = this.vgmDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctmEdiTp = this.ctmEdiTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmRcvDt = this.vgmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
