/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsSndHisVO.java
*@FileTitle : CndCstmsSndHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.05.28 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsSndHisVO extends CstmsSndHisVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsSndHisVO> models = new ArrayList<CndCstmsSndHisVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ackRcvTpId = null;
	/* Column Info */
	private String dtlSndDt = null;
	/* Column Info */
	private String ackRcvKnt = null;
	/* Column Info */
	private String ackSndKnt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String updHm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String sndUsrOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String ackRcvDesc = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String sndHm = null;
	/* Column Info */
	private String ackAcptKnt = null;
	/* Column Info */
	private String stwgSndId = null;
	/* Column Info */
	private String sndDate = null;
	/* Column Info */
	private String cntrKnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsSndHisVO() {}

	public CndCstmsSndHisVO(String ibflag, String pagerows, String trsmMsgTpId, String sndDt, String sndHm, String sndUsrOfcCd, String sndUsrId, String vvdCd, String polCd, String podCd, String blNo, String ackRcvTpId, String ackRcvDesc, String updDt, String updHm, String ackSndKnt, String ackRcvKnt, String ackAcptKnt, String cntCd, String ioBndCd, String dtlSndDt, String hisSeq, String stwgSndId, String sndDate, String cntrKnt) {
		this.updDt = updDt;
		this.ackRcvTpId = ackRcvTpId;
		this.dtlSndDt = dtlSndDt;
		this.ackRcvKnt = ackRcvKnt;
		this.ackSndKnt = ackSndKnt;
		this.ioBndCd = ioBndCd;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.updHm = updHm;
		this.ibflag = ibflag;
		this.sndUsrId = sndUsrId;
		this.polCd = polCd;
		this.trsmMsgTpId = trsmMsgTpId;
		this.vvdCd = vvdCd;
		this.sndUsrOfcCd = sndUsrOfcCd;
		this.cntCd = cntCd;
		this.ackRcvDesc = ackRcvDesc;
		this.hisSeq = hisSeq;
		this.sndHm = sndHm;
		this.ackAcptKnt = ackAcptKnt;
		this.stwgSndId = stwgSndId;		
		this.sndDate = sndDate;		
		this.cntrKnt = cntrKnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ack_rcv_tp_id", getAckRcvTpId());
		this.hashColumns.put("dtl_snd_dt", getDtlSndDt());
		this.hashColumns.put("ack_rcv_knt", getAckRcvKnt());
		this.hashColumns.put("ack_snd_knt", getAckSndKnt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("upd_hm", getUpdHm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("snd_usr_ofc_cd", getSndUsrOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ack_rcv_desc", getAckRcvDesc());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("snd_hm", getSndHm());
		this.hashColumns.put("ack_acpt_knt", getAckAcptKnt());
		this.hashColumns.put("snd_date", getSndDate());
		this.hashColumns.put("stwg_snd_id", getStwgSndId());
		this.hashColumns.put("cntr_knt", getCntrKnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ack_rcv_tp_id", "ackRcvTpId");
		this.hashFields.put("dtl_snd_dt", "dtlSndDt");
		this.hashFields.put("ack_rcv_knt", "ackRcvKnt");
		this.hashFields.put("ack_snd_knt", "ackSndKnt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("upd_hm", "updHm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("snd_usr_ofc_cd", "sndUsrOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ack_rcv_desc", "ackRcvDesc");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("snd_hm", "sndHm");
		this.hashFields.put("ack_acpt_knt", "ackAcptKnt");
		this.hashFields.put("stwg_snd_id", "stwgSndId");
		this.hashFields.put("snd_date", "sndDate");
		this.hashFields.put("cntr_knt", "cntrKnt");
		return this.hashFields;
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
	 * @return ackRcvTpId
	 */
	public String getAckRcvTpId() {
		return this.ackRcvTpId;
	}
	
	/**
	 * Column Info
	 * @return dtlSndDt
	 */
	public String getDtlSndDt() {
		return this.dtlSndDt;
	}
	
	/**
	 * Column Info
	 * @return ackRcvKnt
	 */
	public String getAckRcvKnt() {
		return this.ackRcvKnt;
	}
	
	/**
	 * Column Info
	 * @return ackSndKnt
	 */
	public String getAckSndKnt() {
		return this.ackSndKnt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return updHm
	 */
	public String getUpdHm() {
		return this.updHm;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return sndUsrOfcCd
	 */
	public String getSndUsrOfcCd() {
		return this.sndUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return ackRcvDesc
	 */
	public String getAckRcvDesc() {
		return this.ackRcvDesc;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return sndHm
	 */
	public String getSndHm() {
		return this.sndHm;
	}
	
	/**
	 * Column Info
	 * @return ackAcptKnt
	 */
	public String getAckAcptKnt() {
		return this.ackAcptKnt;
	}
		
	/**
	 * Column Info
	 * @return stwgSndId
	 */
	public String getStwgSndId() {
		return this.stwgSndId;
	}

	/**
	 * Column Info
	 * @return sndDate
	 */
	public String getSndDate() {
		return this.sndDate;
	}

	/**
	 * Column Info
	 * @return cntrKnt
	 */
	public String getCntrKnt() {
		return this.cntrKnt;
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
	 * @param ackRcvTpId
	 */
	public void setAckRcvTpId(String ackRcvTpId) {
		this.ackRcvTpId = ackRcvTpId;
	}
	
	/**
	 * Column Info
	 * @param dtlSndDt
	 */
	public void setDtlSndDt(String dtlSndDt) {
		this.dtlSndDt = dtlSndDt;
	}
	
	/**
	 * Column Info
	 * @param ackRcvKnt
	 */
	public void setAckRcvKnt(String ackRcvKnt) {
		this.ackRcvKnt = ackRcvKnt;
	}
	
	/**
	 * Column Info
	 * @param ackSndKnt
	 */
	public void setAckSndKnt(String ackSndKnt) {
		this.ackSndKnt = ackSndKnt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param updHm
	 */
	public void setUpdHm(String updHm) {
		this.updHm = updHm;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param sndUsrOfcCd
	 */
	public void setSndUsrOfcCd(String sndUsrOfcCd) {
		this.sndUsrOfcCd = sndUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param ackRcvDesc
	 */
	public void setAckRcvDesc(String ackRcvDesc) {
		this.ackRcvDesc = ackRcvDesc;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param sndHm
	 */
	public void setSndHm(String sndHm) {
		this.sndHm = sndHm;
	}
	
	/**
	 * Column Info
	 * @param ackAcptKnt
	 */
	public void setAckAcptKnt(String ackAcptKnt) {
		this.ackAcptKnt = ackAcptKnt;
	}
	
	/**
	 * Column Info
	 * @param stwgSndId
	 */
	public void setStwgSndId(String stwgSndId) {
		this.stwgSndId = stwgSndId;
	}
	
	/**
	 * Column Info
	 * @param sndDate
	 */
	public void setSndDate(String sndDate) {
		this.sndDate = sndDate;
	}
		
	/**
	 * Column Info
	 * @param cntrKnt
	 */
	public void setCntrKnt(String cntrKnt) {
		this.cntrKnt = cntrKnt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setAckRcvTpId(JSPUtil.getParameter(request, "ack_rcv_tp_id", ""));
		setDtlSndDt(JSPUtil.getParameter(request, "dtl_snd_dt", ""));
		setAckRcvKnt(JSPUtil.getParameter(request, "ack_rcv_knt", ""));
		setAckSndKnt(JSPUtil.getParameter(request, "ack_snd_knt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setUpdHm(JSPUtil.getParameter(request, "upd_hm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, "trsm_msg_tp_id", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setSndUsrOfcCd(JSPUtil.getParameter(request, "snd_usr_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setAckRcvDesc(JSPUtil.getParameter(request, "ack_rcv_desc", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setSndHm(JSPUtil.getParameter(request, "snd_hm", ""));
		setAckAcptKnt(JSPUtil.getParameter(request, "ack_acpt_knt", ""));
		setStwgSndId(JSPUtil.getParameter(request, "stwg_snd_id", ""));
		setSndDate(JSPUtil.getParameter(request, "snd_date", ""));
		setCntrKnt(JSPUtil.getParameter(request, "cntr_knt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsSndHisVO[]
	 */
	public CndCstmsSndHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsSndHisVO[]
	 */
	public CndCstmsSndHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsSndHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] ackRcvTpId = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_tp_id".trim(), length));
			String[] dtlSndDt = (JSPUtil.getParameter(request, prefix	+ "dtl_snd_dt".trim(), length));
			String[] ackRcvKnt = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_knt".trim(), length));
			String[] ackSndKnt = (JSPUtil.getParameter(request, prefix	+ "ack_snd_knt".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] updHm = (JSPUtil.getParameter(request, prefix	+ "upd_hm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] sndUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_usr_ofc_cd".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] ackRcvDesc = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_desc".trim(), length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq".trim(), length));
			String[] sndHm = (JSPUtil.getParameter(request, prefix	+ "snd_hm".trim(), length));
			String[] ackAcptKnt = (JSPUtil.getParameter(request, prefix	+ "ack_acpt_knt".trim(), length));
			String[] stwgSndId = (JSPUtil.getParameter(request, prefix	+ "stwg_snd_id", length));
			String[] sndDate = (JSPUtil.getParameter(request, prefix	+ "snd_date", length));
			String[] cntrKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_knt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsSndHisVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ackRcvTpId[i] != null)
					model.setAckRcvTpId(ackRcvTpId[i]);
				if (dtlSndDt[i] != null)
					model.setDtlSndDt(dtlSndDt[i]);
				if (ackRcvKnt[i] != null)
					model.setAckRcvKnt(ackRcvKnt[i]);
				if (ackSndKnt[i] != null)
					model.setAckSndKnt(ackSndKnt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (updHm[i] != null)
					model.setUpdHm(updHm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (sndUsrOfcCd[i] != null)
					model.setSndUsrOfcCd(sndUsrOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (ackRcvDesc[i] != null)
					model.setAckRcvDesc(ackRcvDesc[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (sndHm[i] != null)
					model.setSndHm(sndHm[i]);
				if (ackAcptKnt[i] != null)
					model.setAckAcptKnt(ackAcptKnt[i]);
				if (stwgSndId[i] != null)
					model.setStwgSndId(stwgSndId[i]);
				if (sndDate[i] != null)
					model.setSndDate(sndDate[i]);		
				if (cntrKnt[i] != null)
					model.setCntrKnt(cntrKnt[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsSndHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsSndHisVO[]
	 */
	public CndCstmsSndHisVO[] getCndCstmsSndHisVOs(){
		CndCstmsSndHisVO[] vos = (CndCstmsSndHisVO[])models.toArray(new CndCstmsSndHisVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvTpId = this.ackRcvTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSndDt = this.dtlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvKnt = this.ackRcvKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackSndKnt = this.ackSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updHm = this.updHm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrOfcCd = this.sndUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvDesc = this.ackRcvDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndHm = this.sndHm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackAcptKnt = this.ackAcptKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgSndId = this.stwgSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDate = this.sndDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrKnt = this.cntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
