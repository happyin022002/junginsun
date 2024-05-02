/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DblEdiCmdtCntrVO.java
*@FileTitle : DblEdiCmdtCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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

public class DblEdiCmdtCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DblEdiCmdtCntrVO> models = new ArrayList<DblEdiCmdtCntrVO>();
	
	/* Column Info */
	private String hamoTrfCd = null;
	/* Column Info */
	private String ncmNo = null;
	/* Column Info */
	private String netWgtUtCd = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String netCntrMfWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pckDes = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cmdtSeq = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DblEdiCmdtCntrVO() {}

	public DblEdiCmdtCntrVO(String ibflag, String pagerows, String pckQty, String pckTpCd, String pckDes, String cntrMfWgt, String wgtUtCd, String netCntrMfWgt, String netWgtUtCd, String measQty, String measUtCd, String hamoTrfCd, String cmdtHsCd, String ncmNo, String cntrMfGdsDesc, String cntrMfMkDesc, String cntrNo, String bkgNo, String cmdtSeq) {
		this.hamoTrfCd = hamoTrfCd;
		this.ncmNo = ncmNo;
		this.netWgtUtCd = netWgtUtCd;
		this.cntrMfWgt = cntrMfWgt;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.netCntrMfWgt = netCntrMfWgt;
		this.pagerows = pagerows;
		this.pckDes = pckDes;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.cmdtSeq = cmdtSeq;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.cmdtHsCd = cmdtHsCd;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hamo_trf_cd", getHamoTrfCd());
		this.hashColumns.put("ncm_no", getNcmNo());
		this.hashColumns.put("net_wgt_ut_cd", getNetWgtUtCd());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("net_cntr_mf_wgt", getNetCntrMfWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pck_des", getPckDes());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cmdt_seq", getCmdtSeq());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hamo_trf_cd", "hamoTrfCd");
		this.hashFields.put("ncm_no", "ncmNo");
		this.hashFields.put("net_wgt_ut_cd", "netWgtUtCd");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("net_cntr_mf_wgt", "netCntrMfWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pck_des", "pckDes");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cmdt_seq", "cmdtSeq");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
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
	 * @return netWgtUtCd
	 */
	public String getNetWgtUtCd() {
		return this.netWgtUtCd;
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
	 * @return netCntrMfWgt
	 */
	public String getNetCntrMfWgt() {
		return this.netCntrMfWgt;
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
	 * @return pckDes
	 */
	public String getPckDes() {
		return this.pckDes;
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
	 * @return cmdtSeq
	 */
	public String getCmdtSeq() {
		return this.cmdtSeq;
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
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
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
	 * @param netWgtUtCd
	 */
	public void setNetWgtUtCd(String netWgtUtCd) {
		this.netWgtUtCd = netWgtUtCd;
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
	 * @param netCntrMfWgt
	 */
	public void setNetCntrMfWgt(String netCntrMfWgt) {
		this.netCntrMfWgt = netCntrMfWgt;
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
	 * @param pckDes
	 */
	public void setPckDes(String pckDes) {
		this.pckDes = pckDes;
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
	 * @param cmdtSeq
	 */
	public void setCmdtSeq(String cmdtSeq) {
		this.cmdtSeq = cmdtSeq;
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
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
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
		setHamoTrfCd(JSPUtil.getParameter(request, prefix + "hamo_trf_cd", ""));
		setNcmNo(JSPUtil.getParameter(request, prefix + "ncm_no", ""));
		setNetWgtUtCd(JSPUtil.getParameter(request, prefix + "net_wgt_ut_cd", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setNetCntrMfWgt(JSPUtil.getParameter(request, prefix + "net_cntr_mf_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPckDes(JSPUtil.getParameter(request, prefix + "pck_des", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCmdtSeq(JSPUtil.getParameter(request, prefix + "cmdt_seq", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DblEdiCmdtCntrVO[]
	 */
	public DblEdiCmdtCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DblEdiCmdtCntrVO[]
	 */
	public DblEdiCmdtCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DblEdiCmdtCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hamoTrfCd = (JSPUtil.getParameter(request, prefix	+ "hamo_trf_cd", length));
			String[] ncmNo = (JSPUtil.getParameter(request, prefix	+ "ncm_no", length));
			String[] netWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "net_wgt_ut_cd", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] netCntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "net_cntr_mf_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pckDes = (JSPUtil.getParameter(request, prefix	+ "pck_des", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cmdtSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_seq", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DblEdiCmdtCntrVO();
				if (hamoTrfCd[i] != null)
					model.setHamoTrfCd(hamoTrfCd[i]);
				if (ncmNo[i] != null)
					model.setNcmNo(ncmNo[i]);
				if (netWgtUtCd[i] != null)
					model.setNetWgtUtCd(netWgtUtCd[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (netCntrMfWgt[i] != null)
					model.setNetCntrMfWgt(netCntrMfWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pckDes[i] != null)
					model.setPckDes(pckDes[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cmdtSeq[i] != null)
					model.setCmdtSeq(cmdtSeq[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDblEdiCmdtCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DblEdiCmdtCntrVO[]
	 */
	public DblEdiCmdtCntrVO[] getDblEdiCmdtCntrVOs(){
		DblEdiCmdtCntrVO[] vos = (DblEdiCmdtCntrVO[])models.toArray(new DblEdiCmdtCntrVO[models.size()]);
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
		this.hamoTrfCd = this.hamoTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncmNo = this.ncmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgtUtCd = this.netWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netCntrMfWgt = this.netCntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckDes = this.pckDes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtSeq = this.cmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
