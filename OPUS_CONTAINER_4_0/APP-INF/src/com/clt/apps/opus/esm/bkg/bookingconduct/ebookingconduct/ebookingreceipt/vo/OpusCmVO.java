/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpusCmVO.java
*@FileTitle : OpusCmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.07 전용진 
* 1.0 Creation
* -------------------------------------------------------
* history
* 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpusCmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpusCmVO> models = new ArrayList<OpusCmVO>();
	
	/* Column Info */
	private String hamoTrfCd = null;
	/* Column Info */
	private String ncmNo = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String cntrMfDtlDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String poNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String cntrMfNo = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String dcgoSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpusCmVO() {}

	public OpusCmVO(String ibflag, String pagerows, String cntrNo, String pckQty, String pckTpCd, String cntrMfWgt, String wgtUtCd, String measQty, String measUtCd, String cntrMfSeq, String hamoTrfCd, String ncmNo, String poNo, String cntrMfDtlDesc, String cntrMfGdsDesc, String cntrMfMkDesc, String cntrMfNo, String cmdtHsCd, String dcgoSeq) {
		this.hamoTrfCd = hamoTrfCd;
		this.ncmNo = ncmNo;
		this.cntrMfWgt = cntrMfWgt;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.cntrMfDtlDesc = cntrMfDtlDesc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.poNo = poNo;
		this.cntrNo = cntrNo;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.cntrMfSeq = cntrMfSeq;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.cntrMfNo = cntrMfNo;
		this.cmdtHsCd = cmdtHsCd;
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());
		this.hashColumns.put("ncm_no", getNcmNo());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("cntr_mf_dtl_desc", getCntrMfDtlDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("cntr_mf_no", getCntrMfNo());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
		this.hashFields.put("ncm_no", "ncmNo");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("cntr_mf_dtl_desc", "cntrMfDtlDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("cntr_mf_no", "cntrMfNo");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hamoTrfCd
	 */
	public String getHamoTrfCd() {
		return this.hamoTrfCd;
	}
	
	/**
	 * Column Info
	 * @return ncmNo
	 */
	public String getNcmNo() {
		return this.ncmNo;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc
	 */
	public String getCntrMfMkDesc() {
		return this.cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrMfDtlDesc
	 */
	public String getCntrMfDtlDesc() {
		return this.cntrMfDtlDesc;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return poNo
	 */
	public String getPoNo() {
		return this.poNo;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	

	/**
	 * Column Info
	 * @param hamoTrfCd
	 */
	public void setHamoTrfCd(String hamoTrfCd) {
		this.hamoTrfCd = hamoTrfCd;
	}
	
	/**
	 * Column Info
	 * @param ncmNo
	 */
	public void setNcmNo(String ncmNo) {
		this.ncmNo = ncmNo;
	}
	
	/**
	 * Column Info
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc
	 */
	public void setCntrMfMkDesc(String cntrMfMkDesc) {
		this.cntrMfMkDesc = cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrMfDtlDesc
	 */
	public void setCntrMfDtlDesc(String cntrMfDtlDesc) {
		this.cntrMfDtlDesc = cntrMfDtlDesc;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param poNo
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	public String getCntrMfNo() {
		return cntrMfNo;
	}

	public void setCntrMfNo(String cntrMfNo) {
		this.cntrMfNo = cntrMfNo;
	}

	public String getCmdtHsCd() {
		return cmdtHsCd;
	}

	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}

	public String getDcgoSeq() {
		return dcgoSeq;
	}

	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setHamoTrfCd(JSPUtil.getParameter(request, "hamo_trf_cd", ""));
		setNcmNo(JSPUtil.getParameter(request, "ncm_no", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, "cntr_mf_wgt", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, "cntr_mf_mk_desc", ""));
		setCntrMfDtlDesc(JSPUtil.getParameter(request, "cntr_mf_dtl_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPoNo(JSPUtil.getParameter(request, "po_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, "cntr_mf_seq", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, "cntr_mf_gds_desc", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setCntrMfNo(JSPUtil.getParameter(request, "cntr_mf_no", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, "cmdt_hs_cd", ""));
		setDcgoSeq(JSPUtil.getParameter(request, "dcgo_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpusCmVO[]
	 */
	public OpusCmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpusCmVO[]
	 */
	public OpusCmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpusCmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hamoTrfCd = (JSPUtil.getParameter(request, prefix	+ "hamo_trf_cd", length));
			String[] ncmNo = (JSPUtil.getParameter(request, prefix	+ "ncm_no", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] cntrMfDtlDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_dtl_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] cntrMfNo = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_no", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpusCmVO();
				if (hamoTrfCd[i] != null)
					model.setHamoTrfCd(hamoTrfCd[i]);
				if (ncmNo[i] != null)
					model.setNcmNo(ncmNo[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (cntrMfDtlDesc[i] != null)
					model.setCntrMfDtlDesc(cntrMfDtlDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (poNo[i] != null)
					model.setPoNo(poNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (cntrMfNo[i] != null)
					model.setCntrMfNo(cntrMfNo[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpusCmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpusCmVO[]
	 */
	public OpusCmVO[] getOpusCmVOs(){
		OpusCmVO[] vos = (OpusCmVO[])models.toArray(new OpusCmVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.hamoTrfCd = this.hamoTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmNo = this.ncmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfDtlDesc = this.cntrMfDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfNo = this.cntrMfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
