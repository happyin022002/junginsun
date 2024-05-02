/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpusRfVO.java
*@FileTitle : OpusRfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.10.26 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpusRfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpusRfVO> models = new ArrayList<OpusRfVO>();
	
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String maxRcSeq = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String pwrSplCblFlg = null;
	/* Column Info */
	private String fdoTemp = null;
	/* Column Info */
	private String clngTpCd = null;
	/* Column Info */
	private String ventRto = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String humidNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrVentCd = null;
	/* Column Info */
	private String cntrVentTpCd = null;
	/* Column Info */
	private String diffRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpusRfVO() {}

	public OpusRfVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String rcSeq, String cntrTpszCd, String status, String cmdtCd, String cmdtDesc, String fdoTemp, String cdoTemp, String pwrSplCblFlg, String ventRto, String clngTpCd, String humidNo, String maxRcSeq, String cntrVentCd, String cntrVentTpCd, String diffRmk) {
		this.rcSeq = rcSeq;
		this.maxRcSeq = maxRcSeq;
		this.status = status;
		this.pwrSplCblFlg = pwrSplCblFlg;
		this.fdoTemp = fdoTemp;
		this.clngTpCd = clngTpCd;
		this.ventRto = ventRto;
		this.pagerows = pagerows;
		this.humidNo = humidNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cdoTemp = cdoTemp;
		this.cmdtCd = cmdtCd;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrVentCd = cntrVentCd;
		this.cntrVentTpCd = cntrVentTpCd;
		this.diffRmk = diffRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("max_rc_seq", getMaxRcSeq());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("pwr_spl_cbl_flg", getPwrSplCblFlg());
		this.hashColumns.put("fdo_temp", getFdoTemp());
		this.hashColumns.put("clng_tp_cd", getClngTpCd());
		this.hashColumns.put("vent_rto", getVentRto());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("humid_no", getHumidNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_vent_cd", getCntrVentCd());
		this.hashColumns.put("cntr_vent_tp_cd", getCntrVentTpCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("max_rc_seq", "maxRcSeq");
		this.hashFields.put("status", "status");
		this.hashFields.put("pwr_spl_cbl_flg", "pwrSplCblFlg");
		this.hashFields.put("fdo_temp", "fdoTemp");
		this.hashFields.put("clng_tp_cd", "clngTpCd");
		this.hashFields.put("vent_rto", "ventRto");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("humid_no", "humidNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_vent_cd", "cntrVentCd");
		this.hashFields.put("cntr_vent_tp_cd", "cntrVentTpCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcSeq
	 */
	public String getRcSeq() {
		return this.rcSeq;
	}
	
	/**
	 * Column Info
	 * @return maxRcSeq
	 */
	public String getMaxRcSeq() {
		return this.maxRcSeq;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return pwrSplCblFlg
	 */
	public String getPwrSplCblFlg() {
		return this.pwrSplCblFlg;
	}
	
	/**
	 * Column Info
	 * @return fdoTemp
	 */
	public String getFdoTemp() {
		return this.fdoTemp;
	}
	
	/**
	 * Column Info
	 * @return clngTpCd
	 */
	public String getClngTpCd() {
		return this.clngTpCd;
	}
	
	/**
	 * Column Info
	 * @return ventRto
	 */
	public String getVentRto() {
		return this.ventRto;
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
	 * @return humidNo
	 */
	public String getHumidNo() {
		return this.humidNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrVentCd
	 */
	public String getCntrVentCd() {
		return this.cntrVentCd;
	}

	/**
	 * Column Info
	 * @return cntrVentTpCd
	 */
	public String getCntrVentTpCd() {
		return this.cntrVentTpCd;
	}
	

	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}

	/**
	 * Column Info
	 * @param rcSeq
	 */
	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
	}
	
	/**
	 * Column Info
	 * @param maxRcSeq
	 */
	public void setMaxRcSeq(String maxRcSeq) {
		this.maxRcSeq = maxRcSeq;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param pwrSplCblFlg
	 */
	public void setPwrSplCblFlg(String pwrSplCblFlg) {
		this.pwrSplCblFlg = pwrSplCblFlg;
	}
	
	/**
	 * Column Info
	 * @param fdoTemp
	 */
	public void setFdoTemp(String fdoTemp) {
		this.fdoTemp = fdoTemp;
	}
	
	/**
	 * Column Info
	 * @param clngTpCd
	 */
	public void setClngTpCd(String clngTpCd) {
		this.clngTpCd = clngTpCd;
	}
	
	/**
	 * Column Info
	 * @param ventRto
	 */
	public void setVentRto(String ventRto) {
		this.ventRto = ventRto;
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
	 * @param humidNo
	 */
	public void setHumidNo(String humidNo) {
		this.humidNo = humidNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrVentCd
	 */
	public void setCntrVentCd(String cntrVentCd) {
		this.cntrVentCd = cntrVentCd;
	}

	/**
	 * Column Info
	 * @param cntrVentTpCd
	 */
	public void setCntrVentTpCd(String cntrVentTpCd) {
		this.cntrVentTpCd = cntrVentTpCd;
	}

	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRcSeq(JSPUtil.getParameter(request, "rc_seq", ""));
		setMaxRcSeq(JSPUtil.getParameter(request, "max_rc_seq", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setPwrSplCblFlg(JSPUtil.getParameter(request, "pwr_spl_cbl_flg", ""));
		setFdoTemp(JSPUtil.getParameter(request, "fdo_temp", ""));
		setClngTpCd(JSPUtil.getParameter(request, "clng_tp_cd", ""));
		setVentRto(JSPUtil.getParameter(request, "vent_rto", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHumidNo(JSPUtil.getParameter(request, "humid_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCdoTemp(JSPUtil.getParameter(request, "cdo_temp", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrVentCd(JSPUtil.getParameter(request, "cntr_vent_cd", ""));
		setCntrVentTpCd(JSPUtil.getParameter(request, "cntr_vent_tp_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpusRfVO[]
	 */
	public OpusRfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpusRfVO[]
	 */
	public OpusRfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpusRfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] maxRcSeq = (JSPUtil.getParameter(request, prefix	+ "max_rc_seq", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] pwrSplCblFlg = (JSPUtil.getParameter(request, prefix	+ "pwr_spl_cbl_flg", length));
			String[] fdoTemp = (JSPUtil.getParameter(request, prefix	+ "fdo_temp", length));
			String[] clngTpCd = (JSPUtil.getParameter(request, prefix	+ "clng_tp_cd", length));
			String[] ventRto = (JSPUtil.getParameter(request, prefix	+ "vent_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] humidNo = (JSPUtil.getParameter(request, prefix	+ "humid_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrVentCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_cd", length));
			String[] cntrVentTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_tp_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpusRfVO();
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (maxRcSeq[i] != null)
					model.setMaxRcSeq(maxRcSeq[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (pwrSplCblFlg[i] != null)
					model.setPwrSplCblFlg(pwrSplCblFlg[i]);
				if (fdoTemp[i] != null)
					model.setFdoTemp(fdoTemp[i]);
				if (clngTpCd[i] != null)
					model.setClngTpCd(clngTpCd[i]);
				if (ventRto[i] != null)
					model.setVentRto(ventRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (humidNo[i] != null)
					model.setHumidNo(humidNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrVentCd[i] != null)
					model.setCntrVentCd(cntrVentCd[i]);
				if (cntrVentTpCd[i] != null)
					model.setCntrVentTpCd(cntrVentTpCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpusRfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpusRfVO[]
	 */
	public OpusRfVO[] getOpusRfVOs(){
		OpusRfVO[] vos = (OpusRfVO[])models.toArray(new OpusRfVO[models.size()]);
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
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxRcSeq = this.maxRcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pwrSplCblFlg = this.pwrSplCblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdoTemp = this.fdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clngTpCd = this.clngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ventRto = this.ventRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidNo = this.humidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentCd = this.cntrVentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentTpCd = this.cntrVentTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
