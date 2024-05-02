/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IFMnrFlagVO.java
*@FileTitle : IFMnrFlagVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.01.20 이주현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo;

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
 * @author 이주현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IFMnrFlagVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IFMnrFlagVO> models = new ArrayList<IFMnrFlagVO>();
	
	/* Column Info */
	private String mvmtCoCd = null;
	/* Column Info */
	private String retireFlag = null;
	/* Column Info */
	private String flagDt = null;
	/* Column Info */
	private String eqKindCd = null;
	/* Column Info */
	private String hbType = null;
	/* Column Info */
	private String stsFlag = null;
	/* Column Info */
	private String hrType = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String flagType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mvmtRsnCd = null;
	/* Column Info */
	private String flagOfcCd = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String chssOwnrCoCd = null;
	/* Column Info */
	private String hbCount = null;
	/* Column Info */
	private String flagUserId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ttlLssBilDt = null;
	/* Column Info */
	private String flagYdCd = null;
	/* Column Info */
	private String ttlLssNtfyDt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String gateIoCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IFMnrFlagVO() {}

	public IFMnrFlagVO(String ibflag, String pagerows, String mvmtCoCd, String retireFlag, String flagDt, String eqKindCd, String hbType, String stsFlag, String hrType, String custSeq, String flagType, String mvmtRsnCd, String flagOfcCd, String mvmtStsCd, String eqNo, String hbCount, String chssOwnrCoCd, String flagUserId, String vndrSeq, String ttlLssBilDt, String flagYdCd, String custCntCd, String gateIoCd, String ttlLssNtfyDt) {
		this.mvmtCoCd = mvmtCoCd;
		this.retireFlag = retireFlag;
		this.flagDt = flagDt;
		this.eqKindCd = eqKindCd;
		this.hbType = hbType;
		this.stsFlag = stsFlag;
		this.hrType = hrType;
		this.custSeq = custSeq;
		this.flagType = flagType;
		this.pagerows = pagerows;
		this.mvmtRsnCd = mvmtRsnCd;
		this.flagOfcCd = flagOfcCd;
		this.mvmtStsCd = mvmtStsCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.chssOwnrCoCd = chssOwnrCoCd;
		this.hbCount = hbCount;
		this.flagUserId = flagUserId;
		this.vndrSeq = vndrSeq;
		this.ttlLssBilDt = ttlLssBilDt;
		this.flagYdCd = flagYdCd;
		this.ttlLssNtfyDt = ttlLssNtfyDt;
		this.custCntCd = custCntCd;
		this.gateIoCd = gateIoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mvmt_co_cd", getMvmtCoCd());
		this.hashColumns.put("retire_flag", getRetireFlag());
		this.hashColumns.put("flag_dt", getFlagDt());
		this.hashColumns.put("eq_kind_cd", getEqKindCd());
		this.hashColumns.put("hb_type", getHbType());
		this.hashColumns.put("sts_flag", getStsFlag());
		this.hashColumns.put("hr_type", getHrType());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("flag_type", getFlagType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mvmt_rsn_cd", getMvmtRsnCd());
		this.hashColumns.put("flag_ofc_cd", getFlagOfcCd());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("chss_ownr_co_cd", getChssOwnrCoCd());
		this.hashColumns.put("hb_count", getHbCount());
		this.hashColumns.put("flag_user_id", getFlagUserId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("ttl_lss_bil_dt", getTtlLssBilDt());
		this.hashColumns.put("flag_yd_cd", getFlagYdCd());
		this.hashColumns.put("ttl_lss_ntfy_dt", getTtlLssNtfyDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("gate_io_cd", getGateIoCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mvmt_co_cd", "mvmtCoCd");
		this.hashFields.put("retire_flag", "retireFlag");
		this.hashFields.put("flag_dt", "flagDt");
		this.hashFields.put("eq_kind_cd", "eqKindCd");
		this.hashFields.put("hb_type", "hbType");
		this.hashFields.put("sts_flag", "stsFlag");
		this.hashFields.put("hr_type", "hrType");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("flag_type", "flagType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mvmt_rsn_cd", "mvmtRsnCd");
		this.hashFields.put("flag_ofc_cd", "flagOfcCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("chss_ownr_co_cd", "chssOwnrCoCd");
		this.hashFields.put("hb_count", "hbCount");
		this.hashFields.put("flag_user_id", "flagUserId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ttl_lss_bil_dt", "ttlLssBilDt");
		this.hashFields.put("flag_yd_cd", "flagYdCd");
		this.hashFields.put("ttl_lss_ntfy_dt", "ttlLssNtfyDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("gate_io_cd", "gateIoCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mvmtCoCd
	 */
	public String getMvmtCoCd() {
		return this.mvmtCoCd;
	}
	
	/**
	 * Column Info
	 * @return retireFlag
	 */
	public String getRetireFlag() {
		return this.retireFlag;
	}
	
	/**
	 * Column Info
	 * @return flagDt
	 */
	public String getFlagDt() {
		return this.flagDt;
	}
	
	/**
	 * Column Info
	 * @return eqKindCd
	 */
	public String getEqKindCd() {
		return this.eqKindCd;
	}
	
	/**
	 * Column Info
	 * @return hbType
	 */
	public String getHbType() {
		return this.hbType;
	}
	
	/**
	 * Column Info
	 * @return stsFlag
	 */
	public String getStsFlag() {
		return this.stsFlag;
	}
	
	/**
	 * Column Info
	 * @return hrType
	 */
	public String getHrType() {
		return this.hrType;
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
	 * @return flagType
	 */
	public String getFlagType() {
		return this.flagType;
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
	 * @return mvmtRsnCd
	 */
	public String getMvmtRsnCd() {
		return this.mvmtRsnCd;
	}
	
	/**
	 * Column Info
	 * @return flagOfcCd
	 */
	public String getFlagOfcCd() {
		return this.flagOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return chssOwnrCoCd
	 */
	public String getChssOwnrCoCd() {
		return this.chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @return hbCount
	 */
	public String getHbCount() {
		return this.hbCount;
	}
	
	/**
	 * Column Info
	 * @return flagUserId
	 */
	public String getFlagUserId() {
		return this.flagUserId;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlLssBilDt
	 */
	public String getTtlLssBilDt() {
		return this.ttlLssBilDt;
	}
	
	/**
	 * Column Info
	 * @return flagYdCd
	 */
	public String getFlagYdCd() {
		return this.flagYdCd;
	}
	
	/**
	 * Column Info
	 * @return ttlLssNtfyDt
	 */
	public String getTtlLssNtfyDt() {
		return this.ttlLssNtfyDt;
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
	 * @return gateIoCd
	 */
	public String getGateIoCd() {
		return this.gateIoCd;
	}
	

	/**
	 * Column Info
	 * @param mvmtCoCd
	 */
	public void setMvmtCoCd(String mvmtCoCd) {
		this.mvmtCoCd = mvmtCoCd;
	}
	
	/**
	 * Column Info
	 * @param retireFlag
	 */
	public void setRetireFlag(String retireFlag) {
		this.retireFlag = retireFlag;
	}
	
	/**
	 * Column Info
	 * @param flagDt
	 */
	public void setFlagDt(String flagDt) {
		this.flagDt = flagDt;
	}
	
	/**
	 * Column Info
	 * @param eqKindCd
	 */
	public void setEqKindCd(String eqKindCd) {
		this.eqKindCd = eqKindCd;
	}
	
	/**
	 * Column Info
	 * @param hbType
	 */
	public void setHbType(String hbType) {
		this.hbType = hbType;
	}
	
	/**
	 * Column Info
	 * @param stsFlag
	 */
	public void setStsFlag(String stsFlag) {
		this.stsFlag = stsFlag;
	}
	
	/**
	 * Column Info
	 * @param hrType
	 */
	public void setHrType(String hrType) {
		this.hrType = hrType;
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
	 * @param flagType
	 */
	public void setFlagType(String flagType) {
		this.flagType = flagType;
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
	 * @param mvmtRsnCd
	 */
	public void setMvmtRsnCd(String mvmtRsnCd) {
		this.mvmtRsnCd = mvmtRsnCd;
	}
	
	/**
	 * Column Info
	 * @param flagOfcCd
	 */
	public void setFlagOfcCd(String flagOfcCd) {
		this.flagOfcCd = flagOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param chssOwnrCoCd
	 */
	public void setChssOwnrCoCd(String chssOwnrCoCd) {
		this.chssOwnrCoCd = chssOwnrCoCd;
	}
	
	/**
	 * Column Info
	 * @param hbCount
	 */
	public void setHbCount(String hbCount) {
		this.hbCount = hbCount;
	}
	
	/**
	 * Column Info
	 * @param flagUserId
	 */
	public void setFlagUserId(String flagUserId) {
		this.flagUserId = flagUserId;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlLssBilDt
	 */
	public void setTtlLssBilDt(String ttlLssBilDt) {
		this.ttlLssBilDt = ttlLssBilDt;
	}
	
	/**
	 * Column Info
	 * @param flagYdCd
	 */
	public void setFlagYdCd(String flagYdCd) {
		this.flagYdCd = flagYdCd;
	}
	
	/**
	 * Column Info
	 * @param ttlLssNtfyDt
	 */
	public void setTtlLssNtfyDt(String ttlLssNtfyDt) {
		this.ttlLssNtfyDt = ttlLssNtfyDt;
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
	 * @param gateIoCd
	 */
	public void setGateIoCd(String gateIoCd) {
		this.gateIoCd = gateIoCd;
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
		setMvmtCoCd(JSPUtil.getParameter(request, prefix + "mvmt_co_cd", ""));
		setRetireFlag(JSPUtil.getParameter(request, prefix + "retire_flag", ""));
		setFlagDt(JSPUtil.getParameter(request, prefix + "flag_dt", ""));
		setEqKindCd(JSPUtil.getParameter(request, prefix + "eq_kind_cd", ""));
		setHbType(JSPUtil.getParameter(request, prefix + "hb_type", ""));
		setStsFlag(JSPUtil.getParameter(request, prefix + "sts_flag", ""));
		setHrType(JSPUtil.getParameter(request, prefix + "hr_type", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFlagType(JSPUtil.getParameter(request, prefix + "flag_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMvmtRsnCd(JSPUtil.getParameter(request, prefix + "mvmt_rsn_cd", ""));
		setFlagOfcCd(JSPUtil.getParameter(request, prefix + "flag_ofc_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setChssOwnrCoCd(JSPUtil.getParameter(request, prefix + "chss_ownr_co_cd", ""));
		setHbCount(JSPUtil.getParameter(request, prefix + "hb_count", ""));
		setFlagUserId(JSPUtil.getParameter(request, prefix + "flag_user_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTtlLssBilDt(JSPUtil.getParameter(request, prefix + "ttl_lss_bil_dt", ""));
		setFlagYdCd(JSPUtil.getParameter(request, prefix + "flag_yd_cd", ""));
		setTtlLssNtfyDt(JSPUtil.getParameter(request, prefix + "ttl_lss_ntfy_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setGateIoCd(JSPUtil.getParameter(request, prefix + "gate_io_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IFMnrFlagVO[]
	 */
	public IFMnrFlagVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IFMnrFlagVO[]
	 */
	public IFMnrFlagVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IFMnrFlagVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mvmtCoCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_co_cd", length));
			String[] retireFlag = (JSPUtil.getParameter(request, prefix	+ "retire_flag", length));
			String[] flagDt = (JSPUtil.getParameter(request, prefix	+ "flag_dt", length));
			String[] eqKindCd = (JSPUtil.getParameter(request, prefix	+ "eq_kind_cd", length));
			String[] hbType = (JSPUtil.getParameter(request, prefix	+ "hb_type", length));
			String[] stsFlag = (JSPUtil.getParameter(request, prefix	+ "sts_flag", length));
			String[] hrType = (JSPUtil.getParameter(request, prefix	+ "hr_type", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] flagType = (JSPUtil.getParameter(request, prefix	+ "flag_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mvmtRsnCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_rsn_cd", length));
			String[] flagOfcCd = (JSPUtil.getParameter(request, prefix	+ "flag_ofc_cd", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] chssOwnrCoCd = (JSPUtil.getParameter(request, prefix	+ "chss_ownr_co_cd", length));
			String[] hbCount = (JSPUtil.getParameter(request, prefix	+ "hb_count", length));
			String[] flagUserId = (JSPUtil.getParameter(request, prefix	+ "flag_user_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ttlLssBilDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_bil_dt", length));
			String[] flagYdCd = (JSPUtil.getParameter(request, prefix	+ "flag_yd_cd", length));
			String[] ttlLssNtfyDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_ntfy_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] gateIoCd = (JSPUtil.getParameter(request, prefix	+ "gate_io_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IFMnrFlagVO();
				if (mvmtCoCd[i] != null)
					model.setMvmtCoCd(mvmtCoCd[i]);
				if (retireFlag[i] != null)
					model.setRetireFlag(retireFlag[i]);
				if (flagDt[i] != null)
					model.setFlagDt(flagDt[i]);
				if (eqKindCd[i] != null)
					model.setEqKindCd(eqKindCd[i]);
				if (hbType[i] != null)
					model.setHbType(hbType[i]);
				if (stsFlag[i] != null)
					model.setStsFlag(stsFlag[i]);
				if (hrType[i] != null)
					model.setHrType(hrType[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (flagType[i] != null)
					model.setFlagType(flagType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mvmtRsnCd[i] != null)
					model.setMvmtRsnCd(mvmtRsnCd[i]);
				if (flagOfcCd[i] != null)
					model.setFlagOfcCd(flagOfcCd[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (chssOwnrCoCd[i] != null)
					model.setChssOwnrCoCd(chssOwnrCoCd[i]);
				if (hbCount[i] != null)
					model.setHbCount(hbCount[i]);
				if (flagUserId[i] != null)
					model.setFlagUserId(flagUserId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ttlLssBilDt[i] != null)
					model.setTtlLssBilDt(ttlLssBilDt[i]);
				if (flagYdCd[i] != null)
					model.setFlagYdCd(flagYdCd[i]);
				if (ttlLssNtfyDt[i] != null)
					model.setTtlLssNtfyDt(ttlLssNtfyDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (gateIoCd[i] != null)
					model.setGateIoCd(gateIoCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIFMnrFlagVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IFMnrFlagVO[]
	 */
	public IFMnrFlagVO[] getIFMnrFlagVOs(){
		IFMnrFlagVO[] vos = (IFMnrFlagVO[])models.toArray(new IFMnrFlagVO[models.size()]);
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
		this.mvmtCoCd = this.mvmtCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retireFlag = this.retireFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flagDt = this.flagDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKindCd = this.eqKindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbType = this.hbType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsFlag = this.stsFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrType = this.hrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flagType = this.flagType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRsnCd = this.mvmtRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flagOfcCd = this.flagOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssOwnrCoCd = this.chssOwnrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbCount = this.hbCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flagUserId = this.flagUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssBilDt = this.ttlLssBilDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flagYdCd = this.flagYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNtfyDt = this.ttlLssNtfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateIoCd = this.gateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
