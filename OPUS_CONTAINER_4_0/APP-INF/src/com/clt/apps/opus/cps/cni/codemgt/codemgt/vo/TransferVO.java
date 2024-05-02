/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferVO.java
*@FileTitle : TransferVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2010.04.19 양정란 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TransferVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TransferVO> models = new ArrayList<TransferVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String trnsFmOfcCd = null;
	/* Column Info */
	private String trnsToUsrId = null;
	/* Column Info */
	private String trnsFmDt = null;
	/* Column Info */
	private String trnsKnt = null;
	/* Column Info */
	private String clmTrnsAuthCd = null;
	/* Column Info */
	private String trnsRmk = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String trnsFmUsrId = null;
	/* Column Info */
	private String trnsToDt = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clmMiscNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String clmTrnsAuthNm = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String trnsToOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String dwClmNo = null;
	/* Column Info */
	private String clmMiscCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TransferVO() {}

	public TransferVO(String ibflag, String pagerows, String div, String dwClmNo, String clmMiscNm, String clmMiscCd, String trnsKnt, String trnsFmOfcCd, String trnsFmUsrId, String trnsFmDt, String clmTrnsAuthCd, String clmTrnsAuthNm, String trnsToOfcCd, String trnsToUsrId, String trnsToDt, String trnsRmk, String hdlrUsrId, String hdlrOfcCd, String rowNum, String total, String updUsrId) {
		this.total = total;
		this.trnsFmOfcCd = trnsFmOfcCd;
		this.trnsToUsrId = trnsToUsrId;
		this.trnsFmDt = trnsFmDt;
		this.trnsKnt = trnsKnt;
		this.clmTrnsAuthCd = clmTrnsAuthCd;
		this.trnsRmk = trnsRmk;
		this.div = div;
		this.trnsFmUsrId = trnsFmUsrId;
		this.trnsToDt = trnsToDt;
		this.hdlrUsrId = hdlrUsrId;
		this.pagerows = pagerows;
		this.clmMiscNm = clmMiscNm;
		this.ibflag = ibflag;
		this.clmTrnsAuthNm = clmTrnsAuthNm;
		this.rowNum = rowNum;
		this.trnsToOfcCd = trnsToOfcCd;
		this.updUsrId = updUsrId;
		this.hdlrOfcCd = hdlrOfcCd;
		this.dwClmNo = dwClmNo;
		this.clmMiscCd = clmMiscCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("trns_fm_ofc_cd", getTrnsFmOfcCd());
		this.hashColumns.put("trns_to_usr_id", getTrnsToUsrId());
		this.hashColumns.put("trns_fm_dt", getTrnsFmDt());
		this.hashColumns.put("trns_knt", getTrnsKnt());
		this.hashColumns.put("clm_trns_auth_cd", getClmTrnsAuthCd());
		this.hashColumns.put("trns_rmk", getTrnsRmk());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("trns_fm_usr_id", getTrnsFmUsrId());
		this.hashColumns.put("trns_to_dt", getTrnsToDt());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clm_misc_nm", getClmMiscNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clm_trns_auth_nm", getClmTrnsAuthNm());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("trns_to_ofc_cd", getTrnsToOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		this.hashColumns.put("clm_misc_cd", getClmMiscCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("trns_fm_ofc_cd", "trnsFmOfcCd");
		this.hashFields.put("trns_to_usr_id", "trnsToUsrId");
		this.hashFields.put("trns_fm_dt", "trnsFmDt");
		this.hashFields.put("trns_knt", "trnsKnt");
		this.hashFields.put("clm_trns_auth_cd", "clmTrnsAuthCd");
		this.hashFields.put("trns_rmk", "trnsRmk");
		this.hashFields.put("div", "div");
		this.hashFields.put("trns_fm_usr_id", "trnsFmUsrId");
		this.hashFields.put("trns_to_dt", "trnsToDt");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clm_misc_nm", "clmMiscNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clm_trns_auth_nm", "clmTrnsAuthNm");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("trns_to_ofc_cd", "trnsToOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("dw_clm_no", "dwClmNo");
		this.hashFields.put("clm_misc_cd", "clmMiscCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return trnsFmOfcCd
	 */
	public String getTrnsFmOfcCd() {
		return this.trnsFmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trnsToUsrId
	 */
	public String getTrnsToUsrId() {
		return this.trnsToUsrId;
	}
	
	/**
	 * Column Info
	 * @return trnsFmDt
	 */
	public String getTrnsFmDt() {
		return this.trnsFmDt;
	}
	
	/**
	 * Column Info
	 * @return trnsKnt
	 */
	public String getTrnsKnt() {
		return this.trnsKnt;
	}
	
	/**
	 * Column Info
	 * @return clmTrnsAuthCd
	 */
	public String getClmTrnsAuthCd() {
		return this.clmTrnsAuthCd;
	}
	
	/**
	 * Column Info
	 * @return trnsRmk
	 */
	public String getTrnsRmk() {
		return this.trnsRmk;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return trnsFmUsrId
	 */
	public String getTrnsFmUsrId() {
		return this.trnsFmUsrId;
	}
	
	/**
	 * Column Info
	 * @return trnsToDt
	 */
	public String getTrnsToDt() {
		return this.trnsToDt;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
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
	 * @return clmMiscNm
	 */
	public String getClmMiscNm() {
		return this.clmMiscNm;
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
	 * @return clmTrnsAuthNm
	 */
	public String getClmTrnsAuthNm() {
		return this.clmTrnsAuthNm;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return trnsToOfcCd
	 */
	public String getTrnsToOfcCd() {
		return this.trnsToOfcCd;
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
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
	}
	
	/**
	 * Column Info
	 * @return clmMiscCd
	 */
	public String getClmMiscCd() {
		return this.clmMiscCd;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param trnsFmOfcCd
	 */
	public void setTrnsFmOfcCd(String trnsFmOfcCd) {
		this.trnsFmOfcCd = trnsFmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trnsToUsrId
	 */
	public void setTrnsToUsrId(String trnsToUsrId) {
		this.trnsToUsrId = trnsToUsrId;
	}
	
	/**
	 * Column Info
	 * @param trnsFmDt
	 */
	public void setTrnsFmDt(String trnsFmDt) {
		this.trnsFmDt = trnsFmDt;
	}
	
	/**
	 * Column Info
	 * @param trnsKnt
	 */
	public void setTrnsKnt(String trnsKnt) {
		this.trnsKnt = trnsKnt;
	}
	
	/**
	 * Column Info
	 * @param clmTrnsAuthCd
	 */
	public void setClmTrnsAuthCd(String clmTrnsAuthCd) {
		this.clmTrnsAuthCd = clmTrnsAuthCd;
	}
	
	/**
	 * Column Info
	 * @param trnsRmk
	 */
	public void setTrnsRmk(String trnsRmk) {
		this.trnsRmk = trnsRmk;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param trnsFmUsrId
	 */
	public void setTrnsFmUsrId(String trnsFmUsrId) {
		this.trnsFmUsrId = trnsFmUsrId;
	}
	
	/**
	 * Column Info
	 * @param trnsToDt
	 */
	public void setTrnsToDt(String trnsToDt) {
		this.trnsToDt = trnsToDt;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
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
	 * @param clmMiscNm
	 */
	public void setClmMiscNm(String clmMiscNm) {
		this.clmMiscNm = clmMiscNm;
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
	 * @param clmTrnsAuthNm
	 */
	public void setClmTrnsAuthNm(String clmTrnsAuthNm) {
		this.clmTrnsAuthNm = clmTrnsAuthNm;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param trnsToOfcCd
	 */
	public void setTrnsToOfcCd(String trnsToOfcCd) {
		this.trnsToOfcCd = trnsToOfcCd;
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
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * Column Info
	 * @param clmMiscCd
	 */
	public void setClmMiscCd(String clmMiscCd) {
		this.clmMiscCd = clmMiscCd;
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
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setTrnsFmOfcCd(JSPUtil.getParameter(request, prefix + "trns_fm_ofc_cd", ""));
		setTrnsToUsrId(JSPUtil.getParameter(request, prefix + "trns_to_usr_id", ""));
		setTrnsFmDt(JSPUtil.getParameter(request, prefix + "trns_fm_dt", ""));
		setTrnsKnt(JSPUtil.getParameter(request, prefix + "trns_knt", ""));
		setClmTrnsAuthCd(JSPUtil.getParameter(request, prefix + "clm_trns_auth_cd", ""));
		setTrnsRmk(JSPUtil.getParameter(request, prefix + "trns_rmk", ""));
		setDiv(JSPUtil.getParameter(request, prefix + "div", ""));
		setTrnsFmUsrId(JSPUtil.getParameter(request, prefix + "trns_fm_usr_id", ""));
		setTrnsToDt(JSPUtil.getParameter(request, prefix + "trns_to_dt", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClmMiscNm(JSPUtil.getParameter(request, prefix + "clm_misc_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setClmTrnsAuthNm(JSPUtil.getParameter(request, prefix + "clm_trns_auth_nm", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setTrnsToOfcCd(JSPUtil.getParameter(request, prefix + "trns_to_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setDwClmNo(JSPUtil.getParameter(request, prefix + "dw_clm_no", ""));
		setClmMiscCd(JSPUtil.getParameter(request, prefix + "clm_misc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TransferVO[]
	 */
	public TransferVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TransferVO[]
	 */
	public TransferVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TransferVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] trnsFmOfcCd = (JSPUtil.getParameter(request, prefix	+ "trns_fm_ofc_cd", length));
			String[] trnsToUsrId = (JSPUtil.getParameter(request, prefix	+ "trns_to_usr_id", length));
			String[] trnsFmDt = (JSPUtil.getParameter(request, prefix	+ "trns_fm_dt", length));
			String[] trnsKnt = (JSPUtil.getParameter(request, prefix	+ "trns_knt", length));
			String[] clmTrnsAuthCd = (JSPUtil.getParameter(request, prefix	+ "clm_trns_auth_cd", length));
			String[] trnsRmk = (JSPUtil.getParameter(request, prefix	+ "trns_rmk", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] trnsFmUsrId = (JSPUtil.getParameter(request, prefix	+ "trns_fm_usr_id", length));
			String[] trnsToDt = (JSPUtil.getParameter(request, prefix	+ "trns_to_dt", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clmMiscNm = (JSPUtil.getParameter(request, prefix	+ "clm_misc_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] clmTrnsAuthNm = (JSPUtil.getParameter(request, prefix	+ "clm_trns_auth_nm", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] trnsToOfcCd = (JSPUtil.getParameter(request, prefix	+ "trns_to_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			String[] clmMiscCd = (JSPUtil.getParameter(request, prefix	+ "clm_misc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TransferVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (trnsFmOfcCd[i] != null)
					model.setTrnsFmOfcCd(trnsFmOfcCd[i]);
				if (trnsToUsrId[i] != null)
					model.setTrnsToUsrId(trnsToUsrId[i]);
				if (trnsFmDt[i] != null)
					model.setTrnsFmDt(trnsFmDt[i]);
				if (trnsKnt[i] != null)
					model.setTrnsKnt(trnsKnt[i]);
				if (clmTrnsAuthCd[i] != null)
					model.setClmTrnsAuthCd(clmTrnsAuthCd[i]);
				if (trnsRmk[i] != null)
					model.setTrnsRmk(trnsRmk[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (trnsFmUsrId[i] != null)
					model.setTrnsFmUsrId(trnsFmUsrId[i]);
				if (trnsToDt[i] != null)
					model.setTrnsToDt(trnsToDt[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clmMiscNm[i] != null)
					model.setClmMiscNm(clmMiscNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clmTrnsAuthNm[i] != null)
					model.setClmTrnsAuthNm(clmTrnsAuthNm[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (trnsToOfcCd[i] != null)
					model.setTrnsToOfcCd(trnsToOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				if (clmMiscCd[i] != null)
					model.setClmMiscCd(clmMiscCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTransferVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TransferVO[]
	 */
	public TransferVO[] getTransferVOs(){
		TransferVO[] vos = (TransferVO[])models.toArray(new TransferVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsFmOfcCd = this.trnsFmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsToUsrId = this.trnsToUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsFmDt = this.trnsFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsKnt = this.trnsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTrnsAuthCd = this.clmTrnsAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRmk = this.trnsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsFmUsrId = this.trnsFmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsToDt = this.trnsToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscNm = this.clmMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTrnsAuthNm = this.clmTrnsAuthNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsToOfcCd = this.trnsToOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscCd = this.clmMiscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
