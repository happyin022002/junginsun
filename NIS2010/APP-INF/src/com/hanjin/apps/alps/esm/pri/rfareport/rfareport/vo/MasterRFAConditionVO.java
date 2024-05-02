/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MasterRFAConditionVO.java
*@FileTitle : MasterRFAConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MasterRFAConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasterRFAConditionVO> models = new ArrayList<MasterRFAConditionVO>();
	
	/* Column Info */
	private String fCmdtDsp = null;
	/* Column Info */
	private String fDest = null;
	/* Column Info */
	private String fSts = null;
	/* Column Info */
	private String fOVia = null;
	/* Column Info */
	private String fRfaTp = null;
	/* Column Info */
	private String fTSDsp = null;
	/* Column Info */
	private String fTSPortDsp = null;
	/* Column Info */
	private String fRfaNo = null;
	/* Column Info */
	private String fMRfaNo = null;
	/* Column Info */
	private String fAmdtSeq = null;
	/* Column Info */
	private String fMRoutSeq = null;
	/* Column Info */
	private String fExpDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fReqOfc = null;
	/* Column Info */
	private String fSlsRep = null;
	/* Column Info */
	private String fOrg = null;
	/* Column Info */
	private String fChgDsp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fCmdt = null;
	/* Column Info */
	private String fReqRhq = null;
	/* Column Info */
	private String fEffDt = null;
	/* Column Info */
	private String fScp = null;
	/* Column Info */
	private String fDVia = null;
	/* Column Info */
	private String fCurrRtDsp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MasterRFAConditionVO() {}

	public MasterRFAConditionVO(String ibflag, String pagerows, String fRfaNo, String fMRfaNo, String fAmdtSeq, String fMRoutSeq, String fScp, String fReqRhq, String fReqOfc, String fSlsRep, String fEffDt, String fExpDt, String fOrg, String fOVia, String fDVia, String fDest, String fCmdt, String fSts, String fCurrRtDsp, String fChgDsp, String fCmdtDsp, String fTSDsp, String fTSPortDsp, String fRfaTp) {
		this.fCmdtDsp = fCmdtDsp;
		this.fDest = fDest;
		this.fSts = fSts;
		this.fOVia = fOVia;
		this.fRfaTp = fRfaTp;
		this.fTSDsp = fTSDsp;
		this.fTSPortDsp = fTSPortDsp;
		this.fRfaNo = fRfaNo;
		this.fMRfaNo = fMRfaNo;
		this.fAmdtSeq = fAmdtSeq;
		this.fMRoutSeq = fMRoutSeq;
		this.fExpDt = fExpDt;
		this.pagerows = pagerows;
		this.fReqOfc = fReqOfc;
		this.fSlsRep = fSlsRep;
		this.fOrg = fOrg;
		this.fChgDsp = fChgDsp;
		this.ibflag = ibflag;
		this.fCmdt = fCmdt;
		this.fReqRhq = fReqRhq;
		this.fEffDt = fEffDt;
		this.fScp = fScp;
		this.fDVia = fDVia;
		this.fCurrRtDsp = fCurrRtDsp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("f_cmdt_dsp", getFCmdtDsp());
		this.hashColumns.put("f_dest", getFDest());
		this.hashColumns.put("f_sts", getFSts());
		this.hashColumns.put("f_o_via", getFOVia());
		this.hashColumns.put("f_rfa_tp", getFRfaTp());
		this.hashColumns.put("f_t_s_dsp", getFTSDsp());
		this.hashColumns.put("f_t_s_port_dsp", getFTSPortDsp());
		this.hashColumns.put("f_rfa_no", getFRfaNo());
		this.hashColumns.put("f_m_rfa_no", getFMRfaNo());
		this.hashColumns.put("f_amdt_seq", getFAmdtSeq());
		this.hashColumns.put("f_m_rout_seq", getFMRoutSeq());
		this.hashColumns.put("f_exp_dt", getFExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("f_req_ofc", getFReqOfc());
		this.hashColumns.put("f_sls_rep", getFSlsRep());
		this.hashColumns.put("f_org", getFOrg());
		this.hashColumns.put("f_chg_dsp", getFChgDsp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_cmdt", getFCmdt());
		this.hashColumns.put("f_req_rhq", getFReqRhq());
		this.hashColumns.put("f_eff_dt", getFEffDt());
		this.hashColumns.put("f_scp", getFScp());
		this.hashColumns.put("f_d_via", getFDVia());
		this.hashColumns.put("f_curr_rt_dsp", getFCurrRtDsp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("f_cmdt_dsp", "fCmdtDsp");
		this.hashFields.put("f_dest", "fDest");
		this.hashFields.put("f_sts", "fSts");
		this.hashFields.put("f_o_via", "fOVia");
		this.hashFields.put("f_rfa_tp", "fRfaTp");
		this.hashFields.put("f_t_s_dsp", "fTSDsp");
		this.hashFields.put("f_t_s_port_dsp", "fTSPortDsp");
		this.hashFields.put("f_rfa_no", "fRfaNo");
		this.hashFields.put("f_m_rfa_no", "fMRfaNo");
		this.hashFields.put("f_amdt_seq", "fAmdtSeq");
		this.hashFields.put("f_m_rout_seq", "fMRoutSeq");
		this.hashFields.put("f_exp_dt", "fExpDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("f_req_ofc", "fReqOfc");
		this.hashFields.put("f_sls_rep", "fSlsRep");
		this.hashFields.put("f_org", "fOrg");
		this.hashFields.put("f_chg_dsp", "fChgDsp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_cmdt", "fCmdt");
		this.hashFields.put("f_req_rhq", "fReqRhq");
		this.hashFields.put("f_eff_dt", "fEffDt");
		this.hashFields.put("f_scp", "fScp");
		this.hashFields.put("f_d_via", "fDVia");
		this.hashFields.put("f_curr_rt_dsp", "fCurrRtDsp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fCmdtDsp
	 */
	public String getFCmdtDsp() {
		return this.fCmdtDsp;
	}
	
	/**
	 * Column Info
	 * @return fDest
	 */
	public String getFDest() {
		return this.fDest;
	}
	
	/**
	 * Column Info
	 * @return fSts
	 */
	public String getFSts() {
		return this.fSts;
	}
	
	/**
	 * Column Info
	 * @return fOVia
	 */
	public String getFOVia() {
		return this.fOVia;
	}
	
	/**
	 * Column Info
	 * @return fRfaTp
	 */
	public String getFRfaTp() {
		return this.fRfaTp;
	}
	
	/**
	 * Column Info
	 * @return fTSDsp
	 */
	public String getFTSDsp() {
		return this.fTSDsp;
	}
	
	/**
	 * Column Info
	 * @return fTSPortDsp
	 */
	public String getFTSPortDsp() {
		return this.fTSPortDsp;
	}
	
	/**
	 * Column Info
	 * @return fRfaNo
	 */
	public String getFRfaNo() {
		return this.fRfaNo;
	}
	
	/**
	 * Column Info
	 * @return fMRfaNo
	 */
	public String getFMRfaNo() {
		return this.fMRfaNo;
	}
	
	/**
	 * Column Info
	 * @return fAmdtSeq
	 */
	public String getFAmdtSeq() {
		return this.fAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return fMRoutSeq
	 */
	public String getFMRoutSeq() {
		return this.fMRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return fExpDt
	 */
	public String getFExpDt() {
		return this.fExpDt;
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
	 * @return fReqOfc
	 */
	public String getFReqOfc() {
		return this.fReqOfc;
	}
	
	/**
	 * Column Info
	 * @return fSlsRep
	 */
	public String getFSlsRep() {
		return this.fSlsRep;
	}
	
	/**
	 * Column Info
	 * @return fOrg
	 */
	public String getFOrg() {
		return this.fOrg;
	}
	
	/**
	 * Column Info
	 * @return fChgDsp
	 */
	public String getFChgDsp() {
		return this.fChgDsp;
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
	 * @return fCmdt
	 */
	public String getFCmdt() {
		return this.fCmdt;
	}
	
	/**
	 * Column Info
	 * @return fReqRhq
	 */
	public String getFReqRhq() {
		return this.fReqRhq;
	}
	
	/**
	 * Column Info
	 * @return fEffDt
	 */
	public String getFEffDt() {
		return this.fEffDt;
	}
	
	/**
	 * Column Info
	 * @return fScp
	 */
	public String getFScp() {
		return this.fScp;
	}
	
	/**
	 * Column Info
	 * @return fDVia
	 */
	public String getFDVia() {
		return this.fDVia;
	}
	
	/**
	 * Column Info
	 * @return fCurrRtDsp
	 */
	public String getFCurrRtDsp() {
		return this.fCurrRtDsp;
	}
	

	/**
	 * Column Info
	 * @param fCmdtDsp
	 */
	public void setFCmdtDsp(String fCmdtDsp) {
		this.fCmdtDsp = fCmdtDsp;
	}
	
	/**
	 * Column Info
	 * @param fDest
	 */
	public void setFDest(String fDest) {
		this.fDest = fDest;
	}
	
	/**
	 * Column Info
	 * @param fSts
	 */
	public void setFSts(String fSts) {
		this.fSts = fSts;
	}
	
	/**
	 * Column Info
	 * @param fOVia
	 */
	public void setFOVia(String fOVia) {
		this.fOVia = fOVia;
	}
	
	/**
	 * Column Info
	 * @param fRfaTp
	 */
	public void setFRfaTp(String fRfaTp) {
		this.fRfaTp = fRfaTp;
	}
	
	/**
	 * Column Info
	 * @param fTSDsp
	 */
	public void setFTSDsp(String fTSDsp) {
		this.fTSDsp = fTSDsp;
	}
	
	/**
	 * Column Info
	 * @param fTSPortDsp
	 */
	public void setFTSPortDsp(String fTSPortDsp) {
		this.fTSPortDsp = fTSPortDsp;
	}

	/**
	 * Column Info
	 * @param fRfaNo
	 */
	public void setFRfaNo(String fRfaNo) {
		this.fRfaNo = fRfaNo;
	}
	
	/**
	 * Column Info
	 * @param fFMRfaNo
	 */
	public void setFMRfaNo(String fMRfaNo) {
		this.fMRfaNo = fMRfaNo;
	}
	/**
	 * Column Info
	 * @param fAmdtSeq
	 */
	public void setFAmdtSeq(String fAmdtSeq) {
		this.fAmdtSeq = fAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param fMRoutSeq
	 */
	public void setFMRoutSeq(String fMRoutSeq) {
		this.fMRoutSeq = fMRoutSeq;
	}
	
	
	/**
	 * Column Info
	 * @param fExpDt
	 */
	public void setFExpDt(String fExpDt) {
		this.fExpDt = fExpDt;
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
	 * @param fReqOfc
	 */
	public void setFReqOfc(String fReqOfc) {
		this.fReqOfc = fReqOfc;
	}
	
	/**
	 * Column Info
	 * @param fSlsRep
	 */
	public void setFSlsRep(String fSlsRep) {
		this.fSlsRep = fSlsRep;
	}
	
	/**
	 * Column Info
	 * @param fOrg
	 */
	public void setFOrg(String fOrg) {
		this.fOrg = fOrg;
	}
	
	/**
	 * Column Info
	 * @param fChgDsp
	 */
	public void setFChgDsp(String fChgDsp) {
		this.fChgDsp = fChgDsp;
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
	 * @param fCmdt
	 */
	public void setFCmdt(String fCmdt) {
		this.fCmdt = fCmdt;
	}
	
	/**
	 * Column Info
	 * @param fReqRhq
	 */
	public void setFReqRhq(String fReqRhq) {
		this.fReqRhq = fReqRhq;
	}
	
	/**
	 * Column Info
	 * @param fEffDt
	 */
	public void setFEffDt(String fEffDt) {
		this.fEffDt = fEffDt;
	}
	
	/**
	 * Column Info
	 * @param fScp
	 */
	public void setFScp(String fScp) {
		this.fScp = fScp;
	}
	
	/**
	 * Column Info
	 * @param fDVia
	 */
	public void setFDVia(String fDVia) {
		this.fDVia = fDVia;
	}
	
	/**
	 * Column Info
	 * @param fCurrRtDsp
	 */
	public void setFCurrRtDsp(String fCurrRtDsp) {
		this.fCurrRtDsp = fCurrRtDsp;
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
		setFCmdtDsp(JSPUtil.getParameter(request, prefix + "f_cmdt_dsp", ""));
		setFDest(JSPUtil.getParameter(request, prefix + "f_dest", ""));
		setFSts(JSPUtil.getParameter(request, prefix + "f_sts", ""));
		setFOVia(JSPUtil.getParameter(request, prefix + "f_o_via", ""));
		setFRfaTp(JSPUtil.getParameter(request, prefix + "f_rfa_tp", ""));
		setFTSDsp(JSPUtil.getParameter(request, prefix + "f_t_s_dsp", ""));
		setFTSPortDsp(JSPUtil.getParameter(request, prefix + "f_t_s_port_dsp", ""));
		setFRfaNo(JSPUtil.getParameter(request, prefix + "f_rfa_no", ""));
		setFMRfaNo(JSPUtil.getParameter(request, prefix + "f_m_rfa_no", ""));
		setFAmdtSeq(JSPUtil.getParameter(request, prefix + "f_amdt_seq", ""));
		setFMRoutSeq(JSPUtil.getParameter(request, prefix + "f_m_rout_seq", ""));
		setFExpDt(JSPUtil.getParameter(request, prefix + "f_exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFReqOfc(JSPUtil.getParameter(request, prefix + "f_req_ofc", ""));
		setFSlsRep(JSPUtil.getParameter(request, prefix + "f_sls_rep", ""));
		setFOrg(JSPUtil.getParameter(request, prefix + "f_org", ""));
		setFChgDsp(JSPUtil.getParameter(request, prefix + "f_chg_dsp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFCmdt(JSPUtil.getParameter(request, prefix + "f_cmdt", ""));
		setFReqRhq(JSPUtil.getParameter(request, prefix + "f_req_rhq", ""));
		setFEffDt(JSPUtil.getParameter(request, prefix + "f_eff_dt", ""));
		setFScp(JSPUtil.getParameter(request, prefix + "f_scp", ""));
		setFDVia(JSPUtil.getParameter(request, prefix + "f_d_via", ""));
		setFCurrRtDsp(JSPUtil.getParameter(request, prefix + "f_curr_rt_dsp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasterRFAConditionVO[]
	 */
	public MasterRFAConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasterRFAConditionVO[]
	 */
	public MasterRFAConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasterRFAConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fCmdtDsp = (JSPUtil.getParameter(request, prefix	+ "f_cmdt_dsp", length));
			String[] fDest = (JSPUtil.getParameter(request, prefix	+ "f_dest", length));
			String[] fSts = (JSPUtil.getParameter(request, prefix	+ "f_sts", length));
			String[] fOVia = (JSPUtil.getParameter(request, prefix	+ "f_o_via", length));
			String[] fRfaTp = (JSPUtil.getParameter(request, prefix	+ "f_rfa_tp", length));
			String[] fTSDsp = (JSPUtil.getParameter(request, prefix	+ "f_t_s_dsp", length));
			String[] fTSPortDsp = (JSPUtil.getParameter(request, prefix	+ "f_t_s_port_dsp", length));
			String[] fRfaNo = (JSPUtil.getParameter(request, prefix	+ "f_rfa_no", length));
			String[] fMRfaNo = (JSPUtil.getParameter(request, prefix	+ "f_m_rfa_no", length));
			String[] fAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "f_amdt_seq", length));
			String[] fMRoutSeq = (JSPUtil.getParameter(request, prefix	+ "f_m_rout_seq", length));
			String[] fExpDt = (JSPUtil.getParameter(request, prefix	+ "f_exp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fReqOfc = (JSPUtil.getParameter(request, prefix	+ "f_req_ofc", length));
			String[] fSlsRep = (JSPUtil.getParameter(request, prefix	+ "f_sls_rep", length));
			String[] fOrg = (JSPUtil.getParameter(request, prefix	+ "f_org", length));
			String[] fChgDsp = (JSPUtil.getParameter(request, prefix	+ "f_chg_dsp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCmdt = (JSPUtil.getParameter(request, prefix	+ "f_cmdt", length));
			String[] fReqRhq = (JSPUtil.getParameter(request, prefix	+ "f_req_rhq", length));
			String[] fEffDt = (JSPUtil.getParameter(request, prefix	+ "f_eff_dt", length));
			String[] fScp = (JSPUtil.getParameter(request, prefix	+ "f_scp", length));
			String[] fDVia = (JSPUtil.getParameter(request, prefix	+ "f_d_via", length));
			String[] fCurrRtDsp = (JSPUtil.getParameter(request, prefix	+ "f_curr_rt_dsp", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasterRFAConditionVO();
				if (fCmdtDsp[i] != null)
					model.setFCmdtDsp(fCmdtDsp[i]);
				if (fDest[i] != null)
					model.setFDest(fDest[i]);
				if (fSts[i] != null)
					model.setFSts(fSts[i]);
				if (fOVia[i] != null)
					model.setFOVia(fOVia[i]);
				if (fRfaTp[i] != null)
					model.setFRfaTp(fRfaTp[i]);
				if (fTSDsp[i] != null)
					model.setFTSDsp(fTSDsp[i]);
				if (fTSPortDsp[i] != null)
					model.setFTSPortDsp(fTSPortDsp[i]);
				if (fRfaNo[i] != null)
					model.setFRfaNo(fRfaNo[i]);
				if (fMRfaNo[i] != null)
					model.setFMRfaNo(fMRfaNo[i]);
				if (fAmdtSeq[i] != null)
					model.setFAmdtSeq(fAmdtSeq[i]);
				if (fMRoutSeq[i] != null)
					model.setFMRoutSeq(fMRoutSeq[i]);
				if (fExpDt[i] != null)
					model.setFExpDt(fExpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fReqOfc[i] != null)
					model.setFReqOfc(fReqOfc[i]);
				if (fSlsRep[i] != null)
					model.setFSlsRep(fSlsRep[i]);
				if (fOrg[i] != null)
					model.setFOrg(fOrg[i]);
				if (fChgDsp[i] != null)
					model.setFChgDsp(fChgDsp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCmdt[i] != null)
					model.setFCmdt(fCmdt[i]);
				if (fReqRhq[i] != null)
					model.setFReqRhq(fReqRhq[i]);
				if (fEffDt[i] != null)
					model.setFEffDt(fEffDt[i]);
				if (fScp[i] != null)
					model.setFScp(fScp[i]);
				if (fDVia[i] != null)
					model.setFDVia(fDVia[i]);
				if (fCurrRtDsp[i] != null)
					model.setFCurrRtDsp(fCurrRtDsp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasterRFAConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasterRFAConditionVO[]
	 */
	public MasterRFAConditionVO[] getMasterRFAConditionVOs(){
		MasterRFAConditionVO[] vos = (MasterRFAConditionVO[])models.toArray(new MasterRFAConditionVO[models.size()]);
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
		this.fCmdtDsp = this.fCmdtDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDest = this.fDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSts = this.fSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOVia = this.fOVia .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfaTp = this.fRfaTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTSDsp = this.fTSDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTSPortDsp = this.fTSPortDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRfaNo = this.fRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMRfaNo = this.fMRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fAmdtSeq = this.fAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMRoutSeq = this.fMRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fExpDt = this.fExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fReqOfc = this.fReqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSlsRep = this.fSlsRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOrg = this.fOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fChgDsp = this.fChgDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmdt = this.fCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fReqRhq = this.fReqRhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fEffDt = this.fEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fScp = this.fScp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDVia = this.fDVia .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCurrRtDsp = this.fCurrRtDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
