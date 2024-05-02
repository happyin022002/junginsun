/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsRcvHisVO.java
*@FileTitle : CndCstmsRcvHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.05.28 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
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

public class CndCstmsRcvHisVO extends CstmsRcvHisVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsRcvHisVO> models = new ArrayList<CndCstmsRcvHisVO>();
	
	/* Column Info */
	private String cndAckSubCd = null;
	/* Column Info */
	private String dtlRcvDt = null;
	/* Column Info */
	private String resultDesc = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String rcvDtFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cstmsRjctMsg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cndAckRcvId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String errTpCtnt = null;
	/* Column Info */
	private String cndAckErrNoteDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ackDesc = null;
	/* Column Info */
	private String errCdDesc = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String rcvMsgTpId = null;
	/* Column Info */
	private String rcvHm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsRcvHisVO() {}

	public CndCstmsRcvHisVO(String ibflag, String pagerows, String rcvMsgTpId, String rcvDt, String rcvHm, String vvdCd, String polCd, String podCd, String blNo, String cndAckSubCd, String cndAckRcvId, String cstmsRjctMsg, String ackDesc, String resultDesc, String cndAckErrNoteDesc, String errCdDesc, String errTpCtnt, String rcvDtFlg, String cntCd, String ioBndCd, String dtlRcvDt, String rcvSeq) {
		this.cndAckSubCd = cndAckSubCd;
		this.dtlRcvDt = dtlRcvDt;
		this.resultDesc = resultDesc;
		this.rcvSeq = rcvSeq;
		this.ioBndCd = ioBndCd;
		this.rcvDtFlg = rcvDtFlg;
		this.blNo = blNo;
		this.cstmsRjctMsg = cstmsRjctMsg;
		this.pagerows = pagerows;
		this.cndAckRcvId = cndAckRcvId;
		this.podCd = podCd;
		this.errTpCtnt = errTpCtnt;
		this.cndAckErrNoteDesc = cndAckErrNoteDesc;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.ackDesc = ackDesc;
		this.errCdDesc = errCdDesc;
		this.vvdCd = vvdCd;
		this.rcvDt = rcvDt;
		this.cntCd = cntCd;
		this.rcvMsgTpId = rcvMsgTpId;
		this.rcvHm = rcvHm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnd_ack_sub_cd", getCndAckSubCd());
		this.hashColumns.put("dtl_rcv_dt", getDtlRcvDt());
		this.hashColumns.put("result_desc", getResultDesc());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("rcv_dt_flg", getRcvDtFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cstms_rjct_msg", getCstmsRjctMsg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnd_ack_rcv_id", getCndAckRcvId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("err_tp_ctnt", getErrTpCtnt());
		this.hashColumns.put("cnd_ack_err_note_desc", getCndAckErrNoteDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ack_desc", getAckDesc());
		this.hashColumns.put("err_cd_desc", getErrCdDesc());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("rcv_msg_tp_id", getRcvMsgTpId());
		this.hashColumns.put("rcv_hm", getRcvHm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnd_ack_sub_cd", "cndAckSubCd");
		this.hashFields.put("dtl_rcv_dt", "dtlRcvDt");
		this.hashFields.put("result_desc", "resultDesc");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("rcv_dt_flg", "rcvDtFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cstms_rjct_msg", "cstmsRjctMsg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnd_ack_rcv_id", "cndAckRcvId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("err_tp_ctnt", "errTpCtnt");
		this.hashFields.put("cnd_ack_err_note_desc", "cndAckErrNoteDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ack_desc", "ackDesc");
		this.hashFields.put("err_cd_desc", "errCdDesc");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("rcv_msg_tp_id", "rcvMsgTpId");
		this.hashFields.put("rcv_hm", "rcvHm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cndAckSubCd
	 */
	public String getCndAckSubCd() {
		return this.cndAckSubCd;
	}
	
	/**
	 * Column Info
	 * @return dtlRcvDt
	 */
	public String getDtlRcvDt() {
		return this.dtlRcvDt;
	}
	
	/**
	 * Column Info
	 * @return resultDesc
	 */
	public String getResultDesc() {
		return this.resultDesc;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
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
	 * @return rcvDtFlg
	 */
	public String getRcvDtFlg() {
		return this.rcvDtFlg;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsRjctMsg
	 */
	public String getCstmsRjctMsg() {
		return this.cstmsRjctMsg;
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
	 * @return cndAckRcvId
	 */
	public String getCndAckRcvId() {
		return this.cndAckRcvId;
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
	 * @return errTpCtnt
	 */
	public String getErrTpCtnt() {
		return this.errTpCtnt;
	}
	
	/**
	 * Column Info
	 * @return cndAckErrNoteDesc
	 */
	public String getCndAckErrNoteDesc() {
		return this.cndAckErrNoteDesc;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return ackDesc
	 */
	public String getAckDesc() {
		return this.ackDesc;
	}
	
	/**
	 * Column Info
	 * @return errCdDesc
	 */
	public String getErrCdDesc() {
		return this.errCdDesc;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
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
	 * @return rcvMsgTpId
	 */
	public String getRcvMsgTpId() {
		return this.rcvMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return rcvHm
	 */
	public String getRcvHm() {
		return this.rcvHm;
	}
	

	/**
	 * Column Info
	 * @param cndAckSubCd
	 */
	public void setCndAckSubCd(String cndAckSubCd) {
		this.cndAckSubCd = cndAckSubCd;
	}
	
	/**
	 * Column Info
	 * @param dtlRcvDt
	 */
	public void setDtlRcvDt(String dtlRcvDt) {
		this.dtlRcvDt = dtlRcvDt;
	}
	
	/**
	 * Column Info
	 * @param resultDesc
	 */
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
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
	 * @param rcvDtFlg
	 */
	public void setRcvDtFlg(String rcvDtFlg) {
		this.rcvDtFlg = rcvDtFlg;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsRjctMsg
	 */
	public void setCstmsRjctMsg(String cstmsRjctMsg) {
		this.cstmsRjctMsg = cstmsRjctMsg;
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
	 * @param cndAckRcvId
	 */
	public void setCndAckRcvId(String cndAckRcvId) {
		this.cndAckRcvId = cndAckRcvId;
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
	 * @param errTpCtnt
	 */
	public void setErrTpCtnt(String errTpCtnt) {
		this.errTpCtnt = errTpCtnt;
	}
	
	/**
	 * Column Info
	 * @param cndAckErrNoteDesc
	 */
	public void setCndAckErrNoteDesc(String cndAckErrNoteDesc) {
		this.cndAckErrNoteDesc = cndAckErrNoteDesc;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param ackDesc
	 */
	public void setAckDesc(String ackDesc) {
		this.ackDesc = ackDesc;
	}
	
	/**
	 * Column Info
	 * @param errCdDesc
	 */
	public void setErrCdDesc(String errCdDesc) {
		this.errCdDesc = errCdDesc;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
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
	 * @param rcvMsgTpId
	 */
	public void setRcvMsgTpId(String rcvMsgTpId) {
		this.rcvMsgTpId = rcvMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param rcvHm
	 */
	public void setRcvHm(String rcvHm) {
		this.rcvHm = rcvHm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCndAckSubCd(JSPUtil.getParameter(request, "cnd_ack_sub_cd", ""));
		setDtlRcvDt(JSPUtil.getParameter(request, "dtl_rcv_dt", ""));
		setResultDesc(JSPUtil.getParameter(request, "result_desc", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setRcvDtFlg(JSPUtil.getParameter(request, "rcv_dt_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCstmsRjctMsg(JSPUtil.getParameter(request, "cstms_rjct_msg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCndAckRcvId(JSPUtil.getParameter(request, "cnd_ack_rcv_id", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setErrTpCtnt(JSPUtil.getParameter(request, "err_tp_ctnt", ""));
		setCndAckErrNoteDesc(JSPUtil.getParameter(request, "cnd_ack_err_note_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setAckDesc(JSPUtil.getParameter(request, "ack_desc", ""));
		setErrCdDesc(JSPUtil.getParameter(request, "err_cd_desc", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setRcvMsgTpId(JSPUtil.getParameter(request, "rcv_msg_tp_id", ""));
		setRcvHm(JSPUtil.getParameter(request, "rcv_hm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsRcvHisVO[]
	 */
	public CndCstmsRcvHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsRcvHisVO[]
	 */
	public CndCstmsRcvHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsRcvHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cndAckSubCd = (JSPUtil.getParameter(request, prefix	+ "cnd_ack_sub_cd".trim(), length));
			String[] dtlRcvDt = (JSPUtil.getParameter(request, prefix	+ "dtl_rcv_dt".trim(), length));
			String[] resultDesc = (JSPUtil.getParameter(request, prefix	+ "result_desc".trim(), length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] rcvDtFlg = (JSPUtil.getParameter(request, prefix	+ "rcv_dt_flg".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] cstmsRjctMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_rjct_msg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cndAckRcvId = (JSPUtil.getParameter(request, prefix	+ "cnd_ack_rcv_id".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] errTpCtnt = (JSPUtil.getParameter(request, prefix	+ "err_tp_ctnt".trim(), length));
			String[] cndAckErrNoteDesc = (JSPUtil.getParameter(request, prefix	+ "cnd_ack_err_note_desc".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] ackDesc = (JSPUtil.getParameter(request, prefix	+ "ack_desc".trim(), length));
			String[] errCdDesc = (JSPUtil.getParameter(request, prefix	+ "err_cd_desc".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] rcvMsgTpId = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_tp_id".trim(), length));
			String[] rcvHm = (JSPUtil.getParameter(request, prefix	+ "rcv_hm".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsRcvHisVO();
				if (cndAckSubCd[i] != null)
					model.setCndAckSubCd(cndAckSubCd[i]);
				if (dtlRcvDt[i] != null)
					model.setDtlRcvDt(dtlRcvDt[i]);
				if (resultDesc[i] != null)
					model.setResultDesc(resultDesc[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (rcvDtFlg[i] != null)
					model.setRcvDtFlg(rcvDtFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cstmsRjctMsg[i] != null)
					model.setCstmsRjctMsg(cstmsRjctMsg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cndAckRcvId[i] != null)
					model.setCndAckRcvId(cndAckRcvId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (errTpCtnt[i] != null)
					model.setErrTpCtnt(errTpCtnt[i]);
				if (cndAckErrNoteDesc[i] != null)
					model.setCndAckErrNoteDesc(cndAckErrNoteDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ackDesc[i] != null)
					model.setAckDesc(ackDesc[i]);
				if (errCdDesc[i] != null)
					model.setErrCdDesc(errCdDesc[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (rcvMsgTpId[i] != null)
					model.setRcvMsgTpId(rcvMsgTpId[i]);
				if (rcvHm[i] != null)
					model.setRcvHm(rcvHm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsRcvHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsRcvHisVO[]
	 */
	public CndCstmsRcvHisVO[] getCndCstmsRcvHisVOs(){
		CndCstmsRcvHisVO[] vos = (CndCstmsRcvHisVO[])models.toArray(new CndCstmsRcvHisVO[models.size()]);
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
		this.cndAckSubCd = this.cndAckSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlRcvDt = this.dtlRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resultDesc = this.resultDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDtFlg = this.rcvDtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRjctMsg = this.cstmsRjctMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndAckRcvId = this.cndAckRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errTpCtnt = this.errTpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndAckErrNoteDesc = this.cndAckErrNoteDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDesc = this.ackDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCdDesc = this.errCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgTpId = this.rcvMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvHm = this.rcvHm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
