/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EurCrnRcvMsgVO.java
*@FileTitle : EurCrnRcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.25
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.05.25 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo;

import java.lang.reflect.Field;
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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurCrnRcvMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurCrnRcvMsgVO> models = new ArrayList<EurCrnRcvMsgVO>();
	
	/* Column Info */
	private String searchPrevDocNo = null;
	/* Column Info */
	private String msgSndDt = null;
	/* Column Info */
	private String mfNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String prevDocNos = null;
	/* Column Info */
	private String fixed = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String preVslDchgYdNm = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrRgstKnt = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String msgSndOfcCd = null;
	/* Column Info */
	private String msgFuncId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String refGdsItmNm = null;
	/* Column Info */
	private String prevDocNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String fMsgFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurCrnRcvMsgVO() {}

	public EurCrnRcvMsgVO(String ibflag, String pagerows, String cntCd, String msgSndOfcCd, String mfNo, String refGdsItmNm, String msgFuncId, String msgSndDt, String podCd, String cntrRgstKnt, String creUsrId, String updUsrId, String blNo, String fMsgFlag, String creDt, String preVslDchgYdNm, String searchPrevDocNo, String prevDocNo, String prevDocNos, String fixed, String chk) {
		this.searchPrevDocNo = searchPrevDocNo;
		this.msgSndDt = msgSndDt;
		this.mfNo = mfNo;
		this.creDt = creDt;
		this.prevDocNos = prevDocNos;
		this.fixed = fixed;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.preVslDchgYdNm = preVslDchgYdNm;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrRgstKnt = cntrRgstKnt;
		this.chk = chk;
		this.msgSndOfcCd = msgSndOfcCd;
		this.msgFuncId = msgFuncId;
		this.cntCd = cntCd;
		this.refGdsItmNm = refGdsItmNm;
		this.prevDocNo = prevDocNo;
		this.updUsrId = updUsrId;
		this.fMsgFlag = fMsgFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_prev_doc_no", getSearchPrevDocNo());
		this.hashColumns.put("msg_snd_dt", getMsgSndDt());
		this.hashColumns.put("mf_no", getMfNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("prev_doc_nos", getPrevDocNos());
		this.hashColumns.put("fixed", getFixed());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_vsl_dchg_yd_nm", getPreVslDchgYdNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_rgst_knt", getCntrRgstKnt());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("msg_snd_ofc_cd", getMsgSndOfcCd());
		this.hashColumns.put("msg_func_id", getMsgFuncId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("ref_gds_itm_nm", getRefGdsItmNm());
		this.hashColumns.put("prev_doc_no", getPrevDocNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("f_msg_flag", getFMsgFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("search_prev_doc_no", "searchPrevDocNo");
		this.hashFields.put("msg_snd_dt", "msgSndDt");
		this.hashFields.put("mf_no", "mfNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("prev_doc_nos", "prevDocNos");
		this.hashFields.put("fixed", "fixed");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_vsl_dchg_yd_nm", "preVslDchgYdNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_rgst_knt", "cntrRgstKnt");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("msg_snd_ofc_cd", "msgSndOfcCd");
		this.hashFields.put("msg_func_id", "msgFuncId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("ref_gds_itm_nm", "refGdsItmNm");
		this.hashFields.put("prev_doc_no", "prevDocNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("f_msg_flag", "fMsgFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchPrevDocNo
	 */
	public String getSearchPrevDocNo() {
		return this.searchPrevDocNo;
	}
	
	/**
	 * Column Info
	 * @return msgSndDt
	 */
	public String getMsgSndDt() {
		return this.msgSndDt;
	}
	
	/**
	 * Column Info
	 * @return mfNo
	 */
	public String getMfNo() {
		return this.mfNo;
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
	 * @return prevDocNos
	 */
	public String getPrevDocNos() {
		return this.prevDocNos;
	}
	
	/**
	 * Column Info
	 * @return fixed
	 */
	public String getFixed() {
		return this.fixed;
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
	 * @return preVslDchgYdNm
	 */
	public String getPreVslDchgYdNm() {
		return this.preVslDchgYdNm;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return cntrRgstKnt
	 */
	public String getCntrRgstKnt() {
		return this.cntrRgstKnt;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return msgSndOfcCd
	 */
	public String getMsgSndOfcCd() {
		return this.msgSndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return msgFuncId
	 */
	public String getMsgFuncId() {
		return this.msgFuncId;
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
	 * @return refGdsItmNm
	 */
	public String getRefGdsItmNm() {
		return this.refGdsItmNm;
	}
	
	/**
	 * Column Info
	 * @return prevDocNo
	 */
	public String getPrevDocNo() {
		return this.prevDocNo;
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
	 * @return fMsgFlag
	 */
	public String getFMsgFlag() {
		return this.fMsgFlag;
	}
	

	/**
	 * Column Info
	 * @param searchPrevDocNo
	 */
	public void setSearchPrevDocNo(String searchPrevDocNo) {
		this.searchPrevDocNo = searchPrevDocNo;
	}
	
	/**
	 * Column Info
	 * @param msgSndDt
	 */
	public void setMsgSndDt(String msgSndDt) {
		this.msgSndDt = msgSndDt;
	}
	
	/**
	 * Column Info
	 * @param mfNo
	 */
	public void setMfNo(String mfNo) {
		this.mfNo = mfNo;
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
	 * @param prevDocNos
	 */
	public void setPrevDocNos(String prevDocNos) {
		this.prevDocNos = prevDocNos;
	}
	
	/**
	 * Column Info
	 * @param fixed
	 */
	public void setFixed(String fixed) {
		this.fixed = fixed;
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
	 * @param preVslDchgYdNm
	 */
	public void setPreVslDchgYdNm(String preVslDchgYdNm) {
		this.preVslDchgYdNm = preVslDchgYdNm;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param cntrRgstKnt
	 */
	public void setCntrRgstKnt(String cntrRgstKnt) {
		this.cntrRgstKnt = cntrRgstKnt;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param msgSndOfcCd
	 */
	public void setMsgSndOfcCd(String msgSndOfcCd) {
		this.msgSndOfcCd = msgSndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param msgFuncId
	 */
	public void setMsgFuncId(String msgFuncId) {
		this.msgFuncId = msgFuncId;
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
	 * @param refGdsItmNm
	 */
	public void setRefGdsItmNm(String refGdsItmNm) {
		this.refGdsItmNm = refGdsItmNm;
	}
	
	/**
	 * Column Info
	 * @param prevDocNo
	 */
	public void setPrevDocNo(String prevDocNo) {
		this.prevDocNo = prevDocNo;
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
	 * @param fMsgFlag
	 */
	public void setFMsgFlag(String fMsgFlag) {
		this.fMsgFlag = fMsgFlag;
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
		setSearchPrevDocNo(JSPUtil.getParameter(request, prefix + "search_prev_doc_no", ""));
		setMsgSndDt(JSPUtil.getParameter(request, prefix + "msg_snd_dt", ""));
		setMfNo(JSPUtil.getParameter(request, prefix + "mf_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPrevDocNos(JSPUtil.getParameter(request, prefix + "prev_doc_nos", ""));
		setFixed(JSPUtil.getParameter(request, prefix + "fixed", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPreVslDchgYdNm(JSPUtil.getParameter(request, prefix + "pre_vsl_dchg_yd_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrRgstKnt(JSPUtil.getParameter(request, prefix + "cntr_rgst_knt", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setMsgSndOfcCd(JSPUtil.getParameter(request, prefix + "msg_snd_ofc_cd", ""));
		setMsgFuncId(JSPUtil.getParameter(request, prefix + "msg_func_id", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setRefGdsItmNm(JSPUtil.getParameter(request, prefix + "ref_gds_itm_nm", ""));
		setPrevDocNo(JSPUtil.getParameter(request, prefix + "prev_doc_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFMsgFlag(JSPUtil.getParameter(request, prefix + "f_msg_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurCrnRcvMsgVO[]
	 */
	public EurCrnRcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurCrnRcvMsgVO[]
	 */
	public EurCrnRcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurCrnRcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchPrevDocNo = (JSPUtil.getParameter(request, prefix	+ "search_prev_doc_no", length));
			String[] msgSndDt = (JSPUtil.getParameter(request, prefix	+ "msg_snd_dt", length));
			String[] mfNo = (JSPUtil.getParameter(request, prefix	+ "mf_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] prevDocNos = (JSPUtil.getParameter(request, prefix	+ "prev_doc_nos", length));
			String[] fixed = (JSPUtil.getParameter(request, prefix	+ "fixed", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preVslDchgYdNm = (JSPUtil.getParameter(request, prefix	+ "pre_vsl_dchg_yd_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrRgstKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_rgst_knt", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] msgSndOfcCd = (JSPUtil.getParameter(request, prefix	+ "msg_snd_ofc_cd", length));
			String[] msgFuncId = (JSPUtil.getParameter(request, prefix	+ "msg_func_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] refGdsItmNm = (JSPUtil.getParameter(request, prefix	+ "ref_gds_itm_nm", length));
			String[] prevDocNo = (JSPUtil.getParameter(request, prefix	+ "prev_doc_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] fMsgFlag = (JSPUtil.getParameter(request, prefix	+ "f_msg_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurCrnRcvMsgVO();
				if (searchPrevDocNo[i] != null)
					model.setSearchPrevDocNo(searchPrevDocNo[i]);
				if (msgSndDt[i] != null)
					model.setMsgSndDt(msgSndDt[i]);
				if (mfNo[i] != null)
					model.setMfNo(mfNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (prevDocNos[i] != null)
					model.setPrevDocNos(prevDocNos[i]);
				if (fixed[i] != null)
					model.setFixed(fixed[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preVslDchgYdNm[i] != null)
					model.setPreVslDchgYdNm(preVslDchgYdNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrRgstKnt[i] != null)
					model.setCntrRgstKnt(cntrRgstKnt[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (msgSndOfcCd[i] != null)
					model.setMsgSndOfcCd(msgSndOfcCd[i]);
				if (msgFuncId[i] != null)
					model.setMsgFuncId(msgFuncId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (refGdsItmNm[i] != null)
					model.setRefGdsItmNm(refGdsItmNm[i]);
				if (prevDocNo[i] != null)
					model.setPrevDocNo(prevDocNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fMsgFlag[i] != null)
					model.setFMsgFlag(fMsgFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurCrnRcvMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurCrnRcvMsgVO[]
	 */
	public EurCrnRcvMsgVO[] getEurCrnRcvMsgVOs(){
		EurCrnRcvMsgVO[] vos = (EurCrnRcvMsgVO[])models.toArray(new EurCrnRcvMsgVO[models.size()]);
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
		this.searchPrevDocNo = this.searchPrevDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndDt = this.msgSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfNo = this.mfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDocNos = this.prevDocNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fixed = this.fixed .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVslDchgYdNm = this.preVslDchgYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRgstKnt = this.cntrRgstKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndOfcCd = this.msgSndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFuncId = this.msgFuncId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refGdsItmNm = this.refGdsItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDocNo = this.prevDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMsgFlag = this.fMsgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
