/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltCopyToQuotationVO.java
*@FileTitle : RsltCopyToQuotationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.02.24 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltCopyToQuotationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCopyToQuotationVO> models = new ArrayList<RsltCopyToQuotationVO>();
	
	/* Column Info */
	private String frmGrpCmdtCnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String qttnSrepCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String qttnStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String qttnVerNoFrom = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String qttnNoFrom = null;
	/* Column Info */
	private String frmRateSCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String frmRateGCnt = null;
	/* Column Info */
	private String genSpclRtTpCdFrom = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String copyType = null;
	/* Column Info */
	private String frmGrpLocCnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String qttnOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCopyToQuotationVO() {}

	public RsltCopyToQuotationVO(String ibflag, String pagerows, String qttnNo, String qttnVerNo, String qttnOfcCd, String qttnSrepCd, String qttnStsCd, String svcScpCd, String qttnNoFrom, String qttnVerNoFrom, String genSpclRtTpCdFrom, String creUsrId, String creDt, String updUsrId, String updDt, String copyType, String frmGrpLocCnt, String frmGrpCmdtCnt, String frmRateGCnt, String frmRateSCnt) {
		this.frmGrpCmdtCnt = frmGrpCmdtCnt;
		this.updDt = updDt;
		this.qttnSrepCd = qttnSrepCd;
		this.svcScpCd = svcScpCd;
		this.qttnStsCd = qttnStsCd;
		this.creDt = creDt;
		this.qttnVerNoFrom = qttnVerNoFrom;
		this.pagerows = pagerows;
		this.qttnNoFrom = qttnNoFrom;
		this.frmRateSCnt = frmRateSCnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.frmRateGCnt = frmRateGCnt;
		this.genSpclRtTpCdFrom = genSpclRtTpCdFrom;
		this.qttnNo = qttnNo;
		this.qttnVerNo = qttnVerNo;
		this.copyType = copyType;
		this.frmGrpLocCnt = frmGrpLocCnt;
		this.updUsrId = updUsrId;
		this.qttnOfcCd = qttnOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_grp_cmdt_cnt", getFrmGrpCmdtCnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("qttn_srep_cd", getQttnSrepCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("qttn_sts_cd", getQttnStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("qttn_ver_no_from", getQttnVerNoFrom());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("qttn_no_from", getQttnNoFrom());
		this.hashColumns.put("frm_rate_s_cnt", getFrmRateSCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("frm_rate_g_cnt", getFrmRateGCnt());
		this.hashColumns.put("gen_spcl_rt_tp_cd_from", getGenSpclRtTpCdFrom());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("copy_type", getCopyType());
		this.hashColumns.put("frm_grp_loc_cnt", getFrmGrpLocCnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("qttn_ofc_cd", getQttnOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_grp_cmdt_cnt", "frmGrpCmdtCnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("qttn_srep_cd", "qttnSrepCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("qttn_sts_cd", "qttnStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("qttn_ver_no_from", "qttnVerNoFrom");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("qttn_no_from", "qttnNoFrom");
		this.hashFields.put("frm_rate_s_cnt", "frmRateSCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("frm_rate_g_cnt", "frmRateGCnt");
		this.hashFields.put("gen_spcl_rt_tp_cd_from", "genSpclRtTpCdFrom");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("copy_type", "copyType");
		this.hashFields.put("frm_grp_loc_cnt", "frmGrpLocCnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("qttn_ofc_cd", "qttnOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmGrpCmdtCnt
	 */
	public String getFrmGrpCmdtCnt() {
		return this.frmGrpCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return qttnSrepCd
	 */
	public String getQttnSrepCd() {
		return this.qttnSrepCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return qttnStsCd
	 */
	public String getQttnStsCd() {
		return this.qttnStsCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNoFrom
	 */
	public String getQttnVerNoFrom() {
		return this.qttnVerNoFrom;
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
	 * @return qttnNoFrom
	 */
	public String getQttnNoFrom() {
		return this.qttnNoFrom;
	}
	
	/**
	 * Column Info
	 * @return frmRateSCnt
	 */
	public String getFrmRateSCnt() {
		return this.frmRateSCnt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return frmRateGCnt
	 */
	public String getFrmRateGCnt() {
		return this.frmRateGCnt;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCdFrom
	 */
	public String getGenSpclRtTpCdFrom() {
		return this.genSpclRtTpCdFrom;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return copyType
	 */
	public String getCopyType() {
		return this.copyType;
	}
	
	/**
	 * Column Info
	 * @return frmGrpLocCnt
	 */
	public String getFrmGrpLocCnt() {
		return this.frmGrpLocCnt;
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
	 * @return qttnOfcCd
	 */
	public String getQttnOfcCd() {
		return this.qttnOfcCd;
	}
	

	/**
	 * Column Info
	 * @param frmGrpCmdtCnt
	 */
	public void setFrmGrpCmdtCnt(String frmGrpCmdtCnt) {
		this.frmGrpCmdtCnt = frmGrpCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param qttnSrepCd
	 */
	public void setQttnSrepCd(String qttnSrepCd) {
		this.qttnSrepCd = qttnSrepCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param qttnStsCd
	 */
	public void setQttnStsCd(String qttnStsCd) {
		this.qttnStsCd = qttnStsCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNoFrom
	 */
	public void setQttnVerNoFrom(String qttnVerNoFrom) {
		this.qttnVerNoFrom = qttnVerNoFrom;
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
	 * @param qttnNoFrom
	 */
	public void setQttnNoFrom(String qttnNoFrom) {
		this.qttnNoFrom = qttnNoFrom;
	}
	
	/**
	 * Column Info
	 * @param frmRateSCnt
	 */
	public void setFrmRateSCnt(String frmRateSCnt) {
		this.frmRateSCnt = frmRateSCnt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param frmRateGCnt
	 */
	public void setFrmRateGCnt(String frmRateGCnt) {
		this.frmRateGCnt = frmRateGCnt;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCdFrom
	 */
	public void setGenSpclRtTpCdFrom(String genSpclRtTpCdFrom) {
		this.genSpclRtTpCdFrom = genSpclRtTpCdFrom;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param copyType
	 */
	public void setCopyType(String copyType) {
		this.copyType = copyType;
	}
	
	/**
	 * Column Info
	 * @param frmGrpLocCnt
	 */
	public void setFrmGrpLocCnt(String frmGrpLocCnt) {
		this.frmGrpLocCnt = frmGrpLocCnt;
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
	 * @param qttnOfcCd
	 */
	public void setQttnOfcCd(String qttnOfcCd) {
		this.qttnOfcCd = qttnOfcCd;
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
		setFrmGrpCmdtCnt(JSPUtil.getParameter(request, prefix + "frm_grp_cmdt_cnt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setQttnSrepCd(JSPUtil.getParameter(request, prefix + "qttn_srep_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setQttnStsCd(JSPUtil.getParameter(request, prefix + "qttn_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setQttnVerNoFrom(JSPUtil.getParameter(request, prefix + "qttn_ver_no_from", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setQttnNoFrom(JSPUtil.getParameter(request, prefix + "qttn_no_from", ""));
		setFrmRateSCnt(JSPUtil.getParameter(request, prefix + "frm_rate_s_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFrmRateGCnt(JSPUtil.getParameter(request, prefix + "frm_rate_g_cnt", ""));
		setGenSpclRtTpCdFrom(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd_from", ""));
		setQttnNo(JSPUtil.getParameter(request, prefix + "qttn_no", ""));
		setQttnVerNo(JSPUtil.getParameter(request, prefix + "qttn_ver_no", ""));
		setCopyType(JSPUtil.getParameter(request, prefix + "copy_type", ""));
		setFrmGrpLocCnt(JSPUtil.getParameter(request, prefix + "frm_grp_loc_cnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setQttnOfcCd(JSPUtil.getParameter(request, prefix + "qttn_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltCopyToQuotationVO[]
	 */
	public RsltCopyToQuotationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCopyToQuotationVO[]
	 */
	public RsltCopyToQuotationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCopyToQuotationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmGrpCmdtCnt = (JSPUtil.getParameter(request, prefix	+ "frm_grp_cmdt_cnt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] qttnSrepCd = (JSPUtil.getParameter(request, prefix	+ "qttn_srep_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] qttnStsCd = (JSPUtil.getParameter(request, prefix	+ "qttn_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] qttnVerNoFrom = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no_from", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] qttnNoFrom = (JSPUtil.getParameter(request, prefix	+ "qttn_no_from", length));
			String[] frmRateSCnt = (JSPUtil.getParameter(request, prefix	+ "frm_rate_s_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] frmRateGCnt = (JSPUtil.getParameter(request, prefix	+ "frm_rate_g_cnt", length));
			String[] genSpclRtTpCdFrom = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd_from", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] copyType = (JSPUtil.getParameter(request, prefix	+ "copy_type", length));
			String[] frmGrpLocCnt = (JSPUtil.getParameter(request, prefix	+ "frm_grp_loc_cnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] qttnOfcCd = (JSPUtil.getParameter(request, prefix	+ "qttn_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltCopyToQuotationVO();
				if (frmGrpCmdtCnt[i] != null)
					model.setFrmGrpCmdtCnt(frmGrpCmdtCnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (qttnSrepCd[i] != null)
					model.setQttnSrepCd(qttnSrepCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (qttnStsCd[i] != null)
					model.setQttnStsCd(qttnStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (qttnVerNoFrom[i] != null)
					model.setQttnVerNoFrom(qttnVerNoFrom[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (qttnNoFrom[i] != null)
					model.setQttnNoFrom(qttnNoFrom[i]);
				if (frmRateSCnt[i] != null)
					model.setFrmRateSCnt(frmRateSCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (frmRateGCnt[i] != null)
					model.setFrmRateGCnt(frmRateGCnt[i]);
				if (genSpclRtTpCdFrom[i] != null)
					model.setGenSpclRtTpCdFrom(genSpclRtTpCdFrom[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (copyType[i] != null)
					model.setCopyType(copyType[i]);
				if (frmGrpLocCnt[i] != null)
					model.setFrmGrpLocCnt(frmGrpLocCnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (qttnOfcCd[i] != null)
					model.setQttnOfcCd(qttnOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCopyToQuotationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltCopyToQuotationVO[]
	 */
	public RsltCopyToQuotationVO[] getRsltCopyToQuotationVOs(){
		RsltCopyToQuotationVO[] vos = (RsltCopyToQuotationVO[])models.toArray(new RsltCopyToQuotationVO[models.size()]);
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
		this.frmGrpCmdtCnt = this.frmGrpCmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnSrepCd = this.qttnSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnStsCd = this.qttnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNoFrom = this.qttnVerNoFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNoFrom = this.qttnNoFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRateSCnt = this.frmRateSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRateGCnt = this.frmRateGCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCdFrom = this.genSpclRtTpCdFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyType = this.copyType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmGrpLocCnt = this.frmGrpLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnOfcCd = this.qttnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
