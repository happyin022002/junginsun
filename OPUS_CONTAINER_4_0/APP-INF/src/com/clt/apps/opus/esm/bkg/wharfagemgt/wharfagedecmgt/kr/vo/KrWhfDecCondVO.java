/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWhfDecCondVO.java
*@FileTitle : KrWhfDecCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.30  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecCondVO;
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

public class KrWhfDecCondVO extends WhfDecCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecCondVO> models = new ArrayList<KrWhfDecCondVO>();
	
	/* Column Info */
	private String cntr40UtRt = null;
	/* Column Info */
	private String ediMsgSndId = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String send = null;
	/* Column Info */
	private String whfBndCd = null;
	/* Column Info */
	private String whfDeclOfcCd = null;
	/* Column Info */
	private String whfNtcNo = null;
	/* Column Info */
	private String ntcAmt = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Column Info */
	private String cancelFlag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mfRefNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String blkRtRto = null;
	/* Column Info */
	private String whfRtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntr45UtRt = null;
	/* Column Info */
	private String rducAmt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String blkUtRt = null;
	/* Column Info */
	private String cntr20UtRt = null;
	/* Column Info */
	private String whfUsrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecCondVO() {}

	public KrWhfDecCondVO(String ibflag, String pagerows, String cntr40UtRt, String ediMsgSndId, String csrNo, String send, String whfBndCd, String whfDeclOfcCd, String whfNtcNo, String ntcAmt, String whfDeclNo, String mfRefNo, String blkRtRto, String vvd, String whfRtAmt, String rducAmt, String cntr45UtRt, String portCd, String blkUtRt, String cntr20UtRt, String whfUsrNm, String cancelFlag) {
		this.cntr40UtRt = cntr40UtRt;
		this.ediMsgSndId = ediMsgSndId;
		this.csrNo = csrNo;
		this.send = send;
		this.whfBndCd = whfBndCd;
		this.whfDeclOfcCd = whfDeclOfcCd;
		this.whfNtcNo = whfNtcNo;
		this.ntcAmt = ntcAmt;
		this.whfDeclNo = whfDeclNo;
		this.cancelFlag = cancelFlag;
		this.pagerows = pagerows;
		this.mfRefNo = mfRefNo;
		this.vvd = vvd;
		this.blkRtRto = blkRtRto;
		this.whfRtAmt = whfRtAmt;
		this.ibflag = ibflag;
		this.cntr45UtRt = cntr45UtRt;
		this.rducAmt = rducAmt;
		this.portCd = portCd;
		this.blkUtRt = blkUtRt;
		this.cntr20UtRt = cntr20UtRt;
		this.whfUsrNm = whfUsrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_40_ut_rt", getCntr40UtRt());
		this.hashColumns.put("edi_msg_snd_id", getEdiMsgSndId());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("send", getSend());
		this.hashColumns.put("whf_bnd_cd", getWhfBndCd());
		this.hashColumns.put("whf_decl_ofc_cd", getWhfDeclOfcCd());
		this.hashColumns.put("whf_ntc_no", getWhfNtcNo());
		this.hashColumns.put("ntc_amt", getNtcAmt());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("cancel_flag", getCancelFlag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mf_ref_no", getMfRefNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("blk_rt_rto", getBlkRtRto());
		this.hashColumns.put("whf_rt_amt", getWhfRtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_45_ut_rt", getCntr45UtRt());
		this.hashColumns.put("rduc_amt", getRducAmt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("blk_ut_rt", getBlkUtRt());
		this.hashColumns.put("cntr_20_ut_rt", getCntr20UtRt());
		this.hashColumns.put("whf_usr_nm", getWhfUsrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_40_ut_rt", "cntr40UtRt");
		this.hashFields.put("edi_msg_snd_id", "ediMsgSndId");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("send", "send");
		this.hashFields.put("whf_bnd_cd", "whfBndCd");
		this.hashFields.put("whf_decl_ofc_cd", "whfDeclOfcCd");
		this.hashFields.put("whf_ntc_no", "whfNtcNo");
		this.hashFields.put("ntc_amt", "ntcAmt");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("cancel_flag", "cancelFlag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mf_ref_no", "mfRefNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("blk_rt_rto", "blkRtRto");
		this.hashFields.put("whf_rt_amt", "whfRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_45_ut_rt", "cntr45UtRt");
		this.hashFields.put("rduc_amt", "rducAmt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("blk_ut_rt", "blkUtRt");
		this.hashFields.put("cntr_20_ut_rt", "cntr20UtRt");
		this.hashFields.put("whf_usr_nm", "whfUsrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntr40UtRt
	 */
	public String getCntr40UtRt() {
		return this.cntr40UtRt;
	}
	
	/**
	 * Column Info
	 * @return ediMsgSndId
	 */
	public String getEdiMsgSndId() {
		return this.ediMsgSndId;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return send
	 */
	public String getSend() {
		return this.send;
	}
	
	/**
	 * Column Info
	 * @return whfBndCd
	 */
	public String getWhfBndCd() {
		return this.whfBndCd;
	}
	
	/**
	 * Column Info
	 * @return whfDeclOfcCd
	 */
	public String getWhfDeclOfcCd() {
		return this.whfDeclOfcCd;
	}
	
	/**
	 * Column Info
	 * @return whfNtcNo
	 */
	public String getWhfNtcNo() {
		return this.whfNtcNo;
	}
	
	/**
	 * Column Info
	 * @return ntcAmt
	 */
	public String getNtcAmt() {
		return this.ntcAmt;
	}
	
	/**
	 * Column Info
	 * @return whfDeclNo
	 */
	public String getWhfDeclNo() {
		return this.whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @return cancelFlag
	 */
	public String getCancelFlag() {
		return this.cancelFlag;
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
	 * @return mfRefNo
	 */
	public String getMfRefNo() {
		return this.mfRefNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return blkRtRto
	 */
	public String getBlkRtRto() {
		return this.blkRtRto;
	}
	
	/**
	 * Column Info
	 * @return whfRtAmt
	 */
	public String getWhfRtAmt() {
		return this.whfRtAmt;
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
	 * @return cntr45UtRt
	 */
	public String getCntr45UtRt() {
		return this.cntr45UtRt;
	}
	
	/**
	 * Column Info
	 * @return rducAmt
	 */
	public String getRducAmt() {
		return this.rducAmt;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return blkUtRt
	 */
	public String getBlkUtRt() {
		return this.blkUtRt;
	}
	
	/**
	 * Column Info
	 * @return cntr20UtRt
	 */
	public String getCntr20UtRt() {
		return this.cntr20UtRt;
	}
	
	/**
	 * Column Info
	 * @return whfUsrNm
	 */
	public String getWhfUsrNm() {
		return this.whfUsrNm;
	}
	

	/**
	 * Column Info
	 * @param cntr40UtRt
	 */
	public void setCntr40UtRt(String cntr40UtRt) {
		this.cntr40UtRt = cntr40UtRt;
	}
	
	/**
	 * Column Info
	 * @param ediMsgSndId
	 */
	public void setEdiMsgSndId(String ediMsgSndId) {
		this.ediMsgSndId = ediMsgSndId;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param send
	 */
	public void setSend(String send) {
		this.send = send;
	}
	
	/**
	 * Column Info
	 * @param whfBndCd
	 */
	public void setWhfBndCd(String whfBndCd) {
		this.whfBndCd = whfBndCd;
	}
	
	/**
	 * Column Info
	 * @param whfDeclOfcCd
	 */
	public void setWhfDeclOfcCd(String whfDeclOfcCd) {
		this.whfDeclOfcCd = whfDeclOfcCd;
	}
	
	/**
	 * Column Info
	 * @param whfNtcNo
	 */
	public void setWhfNtcNo(String whfNtcNo) {
		this.whfNtcNo = whfNtcNo;
	}
	
	/**
	 * Column Info
	 * @param ntcAmt
	 */
	public void setNtcAmt(String ntcAmt) {
		this.ntcAmt = ntcAmt;
	}
	
	/**
	 * Column Info
	 * @param whfDeclNo
	 */
	public void setWhfDeclNo(String whfDeclNo) {
		this.whfDeclNo = whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @param cancelFlag
	 */
	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
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
	 * @param mfRefNo
	 */
	public void setMfRefNo(String mfRefNo) {
		this.mfRefNo = mfRefNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param blkRtRto
	 */
	public void setBlkRtRto(String blkRtRto) {
		this.blkRtRto = blkRtRto;
	}
	
	/**
	 * Column Info
	 * @param whfRtAmt
	 */
	public void setWhfRtAmt(String whfRtAmt) {
		this.whfRtAmt = whfRtAmt;
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
	 * @param cntr45UtRt
	 */
	public void setCntr45UtRt(String cntr45UtRt) {
		this.cntr45UtRt = cntr45UtRt;
	}
	
	/**
	 * Column Info
	 * @param rducAmt
	 */
	public void setRducAmt(String rducAmt) {
		this.rducAmt = rducAmt;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param blkUtRt
	 */
	public void setBlkUtRt(String blkUtRt) {
		this.blkUtRt = blkUtRt;
	}
	
	/**
	 * Column Info
	 * @param cntr20UtRt
	 */
	public void setCntr20UtRt(String cntr20UtRt) {
		this.cntr20UtRt = cntr20UtRt;
	}
	
	/**
	 * Column Info
	 * @param whfUsrNm
	 */
	public void setWhfUsrNm(String whfUsrNm) {
		this.whfUsrNm = whfUsrNm;
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
		setCntr40UtRt(JSPUtil.getParameter(request, prefix + "cntr_40_ut_rt", ""));
		setEdiMsgSndId(JSPUtil.getParameter(request, prefix + "edi_msg_snd_id", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setSend(JSPUtil.getParameter(request, prefix + "send", ""));
		setWhfBndCd(JSPUtil.getParameter(request, prefix + "whf_bnd_cd", ""));
		setWhfDeclOfcCd(JSPUtil.getParameter(request, prefix + "whf_decl_ofc_cd", ""));
		setWhfNtcNo(JSPUtil.getParameter(request, prefix + "whf_ntc_no", ""));
		setNtcAmt(JSPUtil.getParameter(request, prefix + "ntc_amt", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, prefix + "whf_decl_no", ""));
		setCancelFlag(JSPUtil.getParameter(request, prefix + "cancel_flag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMfRefNo(JSPUtil.getParameter(request, prefix + "mf_ref_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBlkRtRto(JSPUtil.getParameter(request, prefix + "blk_rt_rto", ""));
		setWhfRtAmt(JSPUtil.getParameter(request, prefix + "whf_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntr45UtRt(JSPUtil.getParameter(request, prefix + "cntr_45_ut_rt", ""));
		setRducAmt(JSPUtil.getParameter(request, prefix + "rduc_amt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setBlkUtRt(JSPUtil.getParameter(request, prefix + "blk_ut_rt", ""));
		setCntr20UtRt(JSPUtil.getParameter(request, prefix + "cntr_20_ut_rt", ""));
		setWhfUsrNm(JSPUtil.getParameter(request, prefix + "whf_usr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecCondVO[]
	 */
	public KrWhfDecCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecCondVO[]
	 */
	public KrWhfDecCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntr40UtRt = (JSPUtil.getParameter(request, prefix	+ "cntr_40_ut_rt", length));
			String[] ediMsgSndId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_snd_id", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] send = (JSPUtil.getParameter(request, prefix	+ "send", length));
			String[] whfBndCd = (JSPUtil.getParameter(request, prefix	+ "whf_bnd_cd", length));
			String[] whfDeclOfcCd = (JSPUtil.getParameter(request, prefix	+ "whf_decl_ofc_cd", length));
			String[] whfNtcNo = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no", length));
			String[] ntcAmt = (JSPUtil.getParameter(request, prefix	+ "ntc_amt", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] cancelFlag = (JSPUtil.getParameter(request, prefix	+ "cancel_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mfRefNo = (JSPUtil.getParameter(request, prefix	+ "mf_ref_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] blkRtRto = (JSPUtil.getParameter(request, prefix	+ "blk_rt_rto", length));
			String[] whfRtAmt = (JSPUtil.getParameter(request, prefix	+ "whf_rt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntr45UtRt = (JSPUtil.getParameter(request, prefix	+ "cntr_45_ut_rt", length));
			String[] rducAmt = (JSPUtil.getParameter(request, prefix	+ "rduc_amt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] blkUtRt = (JSPUtil.getParameter(request, prefix	+ "blk_ut_rt", length));
			String[] cntr20UtRt = (JSPUtil.getParameter(request, prefix	+ "cntr_20_ut_rt", length));
			String[] whfUsrNm = (JSPUtil.getParameter(request, prefix	+ "whf_usr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecCondVO();
				if (cntr40UtRt[i] != null)
					model.setCntr40UtRt(cntr40UtRt[i]);
				if (ediMsgSndId[i] != null)
					model.setEdiMsgSndId(ediMsgSndId[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (send[i] != null)
					model.setSend(send[i]);
				if (whfBndCd[i] != null)
					model.setWhfBndCd(whfBndCd[i]);
				if (whfDeclOfcCd[i] != null)
					model.setWhfDeclOfcCd(whfDeclOfcCd[i]);
				if (whfNtcNo[i] != null)
					model.setWhfNtcNo(whfNtcNo[i]);
				if (ntcAmt[i] != null)
					model.setNtcAmt(ntcAmt[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (cancelFlag[i] != null)
					model.setCancelFlag(cancelFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mfRefNo[i] != null)
					model.setMfRefNo(mfRefNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (blkRtRto[i] != null)
					model.setBlkRtRto(blkRtRto[i]);
				if (whfRtAmt[i] != null)
					model.setWhfRtAmt(whfRtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntr45UtRt[i] != null)
					model.setCntr45UtRt(cntr45UtRt[i]);
				if (rducAmt[i] != null)
					model.setRducAmt(rducAmt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (blkUtRt[i] != null)
					model.setBlkUtRt(blkUtRt[i]);
				if (cntr20UtRt[i] != null)
					model.setCntr20UtRt(cntr20UtRt[i]);
				if (whfUsrNm[i] != null)
					model.setWhfUsrNm(whfUsrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecCondVO[]
	 */
	public KrWhfDecCondVO[] getKrWhfDecCondVOs(){
		KrWhfDecCondVO[] vos = (KrWhfDecCondVO[])models.toArray(new KrWhfDecCondVO[models.size()]);
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
		this.cntr40UtRt = this.cntr40UtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgSndId = this.ediMsgSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.send = this.send .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBndCd = this.whfBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclOfcCd = this.whfDeclOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNo = this.whfNtcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcAmt = this.ntcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelFlag = this.cancelFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRefNo = this.mfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkRtRto = this.blkRtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfRtAmt = this.whfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45UtRt = this.cntr45UtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rducAmt = this.rducAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkUtRt = this.blkUtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20UtRt = this.cntr20UtRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfUsrNm = this.whfUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
