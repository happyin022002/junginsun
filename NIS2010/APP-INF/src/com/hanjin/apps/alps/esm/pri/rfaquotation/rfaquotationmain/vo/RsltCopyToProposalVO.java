/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltCopyToProposalVO.java
*@FileTitle : RsltCopyToProposalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2010.01.05 이승준 
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

public class RsltCopyToProposalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCopyToProposalVO> models = new ArrayList<RsltCopyToProposalVO>();
	
	/* Column Info */
	private String frmGrpCmdtCnt = null;
	/* Column Info */
	private String dmdtFtTpCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String newPropNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
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
	private String frmGrpLocCnt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String qttnOfcCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCopyToProposalVO() {}

	public RsltCopyToProposalVO(String ibflag, String pagerows, String newPropNo, String creUsrId, String qttnOfcCd, String updUsrId, String qttnNo, String qttnVerNo, String frmGrpLocCnt, String frmGrpCmdtCnt, String frmRateGCnt, String frmRateSCnt, String genSpclRtTpCdFrom, String ofcCd, String custCntCd, String custSeq, String dmdtFtTpCd) {
		this.frmGrpCmdtCnt = frmGrpCmdtCnt;
		this.dmdtFtTpCd = dmdtFtTpCd;
		this.custSeq = custSeq;
		this.newPropNo = newPropNo;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.frmRateSCnt = frmRateSCnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.frmRateGCnt = frmRateGCnt;
		this.genSpclRtTpCdFrom = genSpclRtTpCdFrom;
		this.qttnNo = qttnNo;
		this.qttnVerNo = qttnVerNo;
		this.frmGrpLocCnt = frmGrpLocCnt;
		this.custCntCd = custCntCd;
		this.qttnOfcCd = qttnOfcCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_grp_cmdt_cnt", getFrmGrpCmdtCnt());
		this.hashColumns.put("dmdt_ft_tp_cd", getDmdtFtTpCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("new_prop_no", getNewPropNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("frm_rate_s_cnt", getFrmRateSCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("frm_rate_g_cnt", getFrmRateGCnt());
		this.hashColumns.put("gen_spcl_rt_tp_cd_from", getGenSpclRtTpCdFrom());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("frm_grp_loc_cnt", getFrmGrpLocCnt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("qttn_ofc_cd", getQttnOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_grp_cmdt_cnt", "frmGrpCmdtCnt");
		this.hashFields.put("dmdt_ft_tp_cd", "dmdtFtTpCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("new_prop_no", "newPropNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("frm_rate_s_cnt", "frmRateSCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("frm_rate_g_cnt", "frmRateGCnt");
		this.hashFields.put("gen_spcl_rt_tp_cd_from", "genSpclRtTpCdFrom");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("frm_grp_loc_cnt", "frmGrpLocCnt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("qttn_ofc_cd", "qttnOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return dmdtFtTpCd
	 */
	public String getDmdtFtTpCd() {
		return this.dmdtFtTpCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return newPropNo
	 */
	public String getNewPropNo() {
		return this.newPropNo;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return frmGrpLocCnt
	 */
	public String getFrmGrpLocCnt() {
		return this.frmGrpLocCnt;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param dmdtFtTpCd
	 */
	public void setDmdtFtTpCd(String dmdtFtTpCd) {
		this.dmdtFtTpCd = dmdtFtTpCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param newPropNo
	 */
	public void setNewPropNo(String newPropNo) {
		this.newPropNo = newPropNo;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param frmGrpLocCnt
	 */
	public void setFrmGrpLocCnt(String frmGrpLocCnt) {
		this.frmGrpLocCnt = frmGrpLocCnt;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param qttnOfcCd
	 */
	public void setQttnOfcCd(String qttnOfcCd) {
		this.qttnOfcCd = qttnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setDmdtFtTpCd(JSPUtil.getParameter(request, prefix + "dmdt_ft_tp_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setNewPropNo(JSPUtil.getParameter(request, prefix + "new_prop_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFrmRateSCnt(JSPUtil.getParameter(request, prefix + "frm_rate_s_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFrmRateGCnt(JSPUtil.getParameter(request, prefix + "frm_rate_g_cnt", ""));
		setGenSpclRtTpCdFrom(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd_from", ""));
		setQttnNo(JSPUtil.getParameter(request, prefix + "qttn_no", ""));
		setQttnVerNo(JSPUtil.getParameter(request, prefix + "qttn_ver_no", ""));
		setFrmGrpLocCnt(JSPUtil.getParameter(request, prefix + "frm_grp_loc_cnt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setQttnOfcCd(JSPUtil.getParameter(request, prefix + "qttn_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltCopyToProposalVO[]
	 */
	public RsltCopyToProposalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCopyToProposalVO[]
	 */
	public RsltCopyToProposalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCopyToProposalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmGrpCmdtCnt = (JSPUtil.getParameter(request, prefix	+ "frm_grp_cmdt_cnt", length));
			String[] dmdtFtTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ft_tp_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] newPropNo = (JSPUtil.getParameter(request, prefix	+ "new_prop_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] frmRateSCnt = (JSPUtil.getParameter(request, prefix	+ "frm_rate_s_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] frmRateGCnt = (JSPUtil.getParameter(request, prefix	+ "frm_rate_g_cnt", length));
			String[] genSpclRtTpCdFrom = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd_from", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] frmGrpLocCnt = (JSPUtil.getParameter(request, prefix	+ "frm_grp_loc_cnt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] qttnOfcCd = (JSPUtil.getParameter(request, prefix	+ "qttn_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltCopyToProposalVO();
				if (frmGrpCmdtCnt[i] != null)
					model.setFrmGrpCmdtCnt(frmGrpCmdtCnt[i]);
				if (dmdtFtTpCd[i] != null)
					model.setDmdtFtTpCd(dmdtFtTpCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (newPropNo[i] != null)
					model.setNewPropNo(newPropNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
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
				if (frmGrpLocCnt[i] != null)
					model.setFrmGrpLocCnt(frmGrpLocCnt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (qttnOfcCd[i] != null)
					model.setQttnOfcCd(qttnOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCopyToProposalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltCopyToProposalVO[]
	 */
	public RsltCopyToProposalVO[] getRsltCopyToProposalVOs(){
		RsltCopyToProposalVO[] vos = (RsltCopyToProposalVO[])models.toArray(new RsltCopyToProposalVO[models.size()]);
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
		this.dmdtFtTpCd = this.dmdtFtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPropNo = this.newPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRateSCnt = this.frmRateSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRateGCnt = this.frmRateGCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCdFrom = this.genSpclRtTpCdFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmGrpLocCnt = this.frmGrpLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnOfcCd = this.qttnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
