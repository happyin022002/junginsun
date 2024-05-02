/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsSndHisVO.java
*@FileTitle : AncsCstmsSndHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.11 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsSndHisVO extends CstmsSndHisVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsSndHisVO> models = new ArrayList<AncsCstmsSndHisVO>();
	
	/* Column Info */
	private String svcRqstNo = null;
	/* Column Info */
	private String ediSndUsrId = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String div = null;
	/* Column Info */
	private String blCntrNo = null;
	/* Column Info */
	private String sndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ediMsgErrId = null;
	/* Column Info */
	private String refSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String ediSndStsCd = null;
	/* Column Info */
	private String ediRcvStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String err = null;
	/* Column Info */
	private String anrDeclNo = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsSndHisVO() {}

	public AncsCstmsSndHisVO(String ibflag, String pagerows, String div, String blCntrNo, String ediMsgErrId, String errDesc, String cntrNo, String vvdNm, String svcRqstNo, String ediSndStsCd, String ediRcvStsCd, String sndDt, String rcvDt, String ediSndUsrId, String sndOfcCd, String vvd, String anrDeclNo, String refSeq, String err) {
		this.svcRqstNo = svcRqstNo;
		this.ediSndUsrId = ediSndUsrId;
		this.sndOfcCd = sndOfcCd;
		this.div = div;
		this.blCntrNo = blCntrNo;
		this.sndDt = sndDt;
		this.pagerows = pagerows;
		this.vvdNm = vvdNm;
		this.vvd = vvd;
		this.ediMsgErrId = ediMsgErrId;
		this.refSeq = refSeq;
		this.ibflag = ibflag;
		this.errDesc = errDesc;
		this.ediSndStsCd = ediSndStsCd;
		this.ediRcvStsCd = ediRcvStsCd;
		this.cntrNo = cntrNo;
		this.rcvDt = rcvDt;
		this.err = err;
		this.anrDeclNo = anrDeclNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_rqst_no", getSvcRqstNo());
		this.hashColumns.put("edi_snd_usr_id", getEdiSndUsrId());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("div", getDiv());
		this.hashColumns.put("bl_cntr_no", getBlCntrNo());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("edi_msg_err_id", getEdiMsgErrId());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("edi_snd_sts_cd", getEdiSndStsCd());
		this.hashColumns.put("edi_rcv_sts_cd", getEdiRcvStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("err", getErr());
		this.hashColumns.put("anr_decl_no", getAnrDeclNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_rqst_no", "svcRqstNo");
		this.hashFields.put("edi_snd_usr_id", "ediSndUsrId");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("div", "div");
		this.hashFields.put("bl_cntr_no", "blCntrNo");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("edi_msg_err_id", "ediMsgErrId");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("edi_snd_sts_cd", "ediSndStsCd");
		this.hashFields.put("edi_rcv_sts_cd", "ediRcvStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("err", "err");
		this.hashFields.put("anr_decl_no", "anrDeclNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svcRqstNo
	 */
	public String getSvcRqstNo() {
		return this.svcRqstNo;
	}
	
	/**
	 * Column Info
	 * @return ediSndUsrId
	 */
	public String getEdiSndUsrId() {
		return this.ediSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return div
	 */
	public String getDiv() {
		return this.div;
	}
	
	/**
	 * Column Info
	 * @return blCntrNo
	 */
	public String getBlCntrNo() {
		return this.blCntrNo;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return vvdNm
	 */
	public String getVvdNm() {
		return this.vvdNm;
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
	 * @return ediMsgErrId
	 */
	public String getEdiMsgErrId() {
		return this.ediMsgErrId;
	}
	
	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
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
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return ediSndStsCd
	 */
	public String getEdiSndStsCd() {
		return this.ediSndStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediRcvStsCd
	 */
	public String getEdiRcvStsCd() {
		return this.ediRcvStsCd;
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
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return err
	 */
	public String getErr() {
		return this.err;
	}
	
	/**
	 * Column Info
	 * @return anrDeclNo
	 */
	public String getAnrDeclNo() {
		return this.anrDeclNo;
	}
	

	/**
	 * Column Info
	 * @param svcRqstNo
	 */
	public void setSvcRqstNo(String svcRqstNo) {
		this.svcRqstNo = svcRqstNo;
	}
	
	/**
	 * Column Info
	 * @param ediSndUsrId
	 */
	public void setEdiSndUsrId(String ediSndUsrId) {
		this.ediSndUsrId = ediSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param div
	 */
	public void setDiv(String div) {
		this.div = div;
	}
	
	/**
	 * Column Info
	 * @param blCntrNo
	 */
	public void setBlCntrNo(String blCntrNo) {
		this.blCntrNo = blCntrNo;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param vvdNm
	 */
	public void setVvdNm(String vvdNm) {
		this.vvdNm = vvdNm;
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
	 * @param ediMsgErrId
	 */
	public void setEdiMsgErrId(String ediMsgErrId) {
		this.ediMsgErrId = ediMsgErrId;
	}
	
	/**
	 * Column Info
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
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
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	/**
	 * Column Info
	 * @param ediSndStsCd
	 */
	public void setEdiSndStsCd(String ediSndStsCd) {
		this.ediSndStsCd = ediSndStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediRcvStsCd
	 */
	public void setEdiRcvStsCd(String ediRcvStsCd) {
		this.ediRcvStsCd = ediRcvStsCd;
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
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param err
	 */
	public void setErr(String err) {
		this.err = err;
	}
	
	/**
	 * Column Info
	 * @param anrDeclNo
	 */
	public void setAnrDeclNo(String anrDeclNo) {
		this.anrDeclNo = anrDeclNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSvcRqstNo(JSPUtil.getParameter(request, "svc_rqst_no", ""));
		setEdiSndUsrId(JSPUtil.getParameter(request, "edi_snd_usr_id", ""));
		setSndOfcCd(JSPUtil.getParameter(request, "snd_ofc_cd", ""));
		setDiv(JSPUtil.getParameter(request, "div", ""));
		setBlCntrNo(JSPUtil.getParameter(request, "bl_cntr_no", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdNm(JSPUtil.getParameter(request, "vvd_nm", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setEdiMsgErrId(JSPUtil.getParameter(request, "edi_msg_err_id", ""));
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setErrDesc(JSPUtil.getParameter(request, "err_desc", ""));
		setEdiSndStsCd(JSPUtil.getParameter(request, "edi_snd_sts_cd", ""));
		setEdiRcvStsCd(JSPUtil.getParameter(request, "edi_rcv_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setErr(JSPUtil.getParameter(request, "err", ""));
		setAnrDeclNo(JSPUtil.getParameter(request, "anr_decl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsSndHisVO[]
	 */
	public AncsCstmsSndHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsSndHisVO[]
	 */
	public AncsCstmsSndHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsSndHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcRqstNo = (JSPUtil.getParameter(request, prefix	+ "svc_rqst_no", length));
			String[] ediSndUsrId = (JSPUtil.getParameter(request, prefix	+ "edi_snd_usr_id", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] div = (JSPUtil.getParameter(request, prefix	+ "div", length));
			String[] blCntrNo = (JSPUtil.getParameter(request, prefix	+ "bl_cntr_no", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ediMsgErrId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_err_id", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] ediSndStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_snd_sts_cd", length));
			String[] ediRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] err = (JSPUtil.getParameter(request, prefix	+ "err", length));
			String[] anrDeclNo = (JSPUtil.getParameter(request, prefix	+ "anr_decl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsSndHisVO();
				if (svcRqstNo[i] != null)
					model.setSvcRqstNo(svcRqstNo[i]);
				if (ediSndUsrId[i] != null)
					model.setEdiSndUsrId(ediSndUsrId[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (div[i] != null)
					model.setDiv(div[i]);
				if (blCntrNo[i] != null)
					model.setBlCntrNo(blCntrNo[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdNm[i] != null)
					model.setVvdNm(vvdNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ediMsgErrId[i] != null)
					model.setEdiMsgErrId(ediMsgErrId[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (ediSndStsCd[i] != null)
					model.setEdiSndStsCd(ediSndStsCd[i]);
				if (ediRcvStsCd[i] != null)
					model.setEdiRcvStsCd(ediRcvStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (err[i] != null)
					model.setErr(err[i]);
				if (anrDeclNo[i] != null)
					model.setAnrDeclNo(anrDeclNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsSndHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsSndHisVO[]
	 */
	public AncsCstmsSndHisVO[] getAncsCstmsSndHisVOs(){
		AncsCstmsSndHisVO[] vos = (AncsCstmsSndHisVO[])models.toArray(new AncsCstmsSndHisVO[models.size()]);
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
		this.svcRqstNo = this.svcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndUsrId = this.ediSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.div = this.div .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCntrNo = this.blCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm = this.vvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgErrId = this.ediMsgErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndStsCd = this.ediSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvStsCd = this.ediRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.err = this.err .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrDeclNo = this.anrDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
