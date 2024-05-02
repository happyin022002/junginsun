/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MtyRlseOrdExcelCMVO.java
*@FileTitle : MtyRlseOrdExcelCMVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
public class MtyRlseOrdExcelCMVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyRlseOrdExcelCMVO> models = new ArrayList<MtyRlseOrdExcelCMVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String bkgNo = null;

	/* Column Info */
	private String cntrNo = null;

	/* Column Info */
	private String cntrMfSeq = null;

	/* Column Info */
	private String pckQty = null;

	/* Column Info */
	private String pckTpCd = null;

	/* Column Info */
	private String cntrMfWgt = null;

	/* Column Info */
	private String wgtUtCd = null;

	/* Column Info */
	private String measQty = null;

	/* Column Info */
	private String measUtCd = null;

	/* Column Info */
	private String cntrMfGdsDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MtyRlseOrdExcelCMVO() {}

	public MtyRlseOrdExcelCMVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String cntrMfSeq, String pckQty, String pckTpCd, String cntrMfWgt, String wgtUtCd, String measQty, String measUtCd, String cntrMfGdsDesc) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cntrMfSeq = cntrMfSeq;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.cntrMfWgt = cntrMfWgt;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.measUtCd = measUtCd;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * 
	 * @return String bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 *
	 * @param String cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 
	 * @return String cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 *
	 * @param String cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
	}
	
	/**
	 * 
	 * @return String cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
	}
	
	/**
	 *
	 * @param String pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * 
	 * @return String pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 *
	 * @param String pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * 
	 * @return String pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 *
	 * @param String cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}
	
	/**
	 * 
	 * @return String cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	/**
	 *
	 * @param String wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * 
	 * @return String wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 *
	 * @param String measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * 
	 * @return String measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 *
	 * @param String measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * 
	 * @return String measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 *
	 * @param String cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * 
	 * @return String cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdExcelCMVO[]
	 */
	public MtyRlseOrdExcelCMVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdExcelCMVO[]
	 */
	public MtyRlseOrdExcelCMVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyRlseOrdExcelCMVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new MtyRlseOrdExcelCMVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null) 
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null) 
					model.setCntrNo(cntrNo[i]);
				if (cntrMfSeq[i] != null) 
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (pckQty[i] != null) 
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null) 
					model.setPckTpCd(pckTpCd[i]);
				if (cntrMfWgt[i] != null) 
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (wgtUtCd[i] != null) 
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null) 
					model.setMeasQty(measQty[i]);
				if (measUtCd[i] != null) 
					model.setMeasUtCd(measUtCd[i]);
				if (cntrMfGdsDesc[i] != null) 
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyRlseOrdExcelCMVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyRlseOrdExcelCMVO[]
	 */
	public MtyRlseOrdExcelCMVO[] getMtyRlseOrdExcelCMVOs(){
		MtyRlseOrdExcelCMVO[] vos = (MtyRlseOrdExcelCMVO[])models.toArray(new MtyRlseOrdExcelCMVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}