/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaBlCustomsResultVO.java
*@FileTitle : UsaBlCustomsResultVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.21  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaBlCustomsResultVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBlCustomsResultVO> models = new ArrayList<UsaBlCustomsResultVO>();
	
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String dspoCd = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String entrTpNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String rjctFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String rcvDate = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String ibdRefNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cstmsBatNo = null;
	/* Column Info */
	private String rcvMsgTpId = null;
	/* Column Info */
	private String cstmsRmk = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String entrNo = null;
	/* Column Info */
	private String rcvLocCd = null;
	/* Column Info */
	private String cstmsLocDiffFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaBlCustomsResultVO() {}

	public UsaBlCustomsResultVO(String ibflag, String pagerows, String seq, String blNo, String dspoCd, String scacCd, String ibdRefNo, String cntrQty, String entrTpNo, String entrNo, String rcvLocCd, String vvd, String cstmsBatNo, String cstmsRmk, String cstmsClrCd, String rcvMsgTpId, String ioBndCd, String rcvSeq, String polCd, String podCd, String rcvDate, String rjctFlg, String cstmsLocDiffFlg) {
		this.cstmsClrCd = cstmsClrCd;
		this.dspoCd = dspoCd;
		this.rcvSeq = rcvSeq;
		this.ioBndCd = ioBndCd;
		this.entrTpNo = entrTpNo;
		this.blNo = blNo;
		this.rjctFlg = rjctFlg;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.rcvDate = rcvDate;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.scacCd = scacCd;
		this.ibdRefNo = ibdRefNo;
		this.seq = seq;
		this.cstmsBatNo = cstmsBatNo;
		this.rcvMsgTpId = rcvMsgTpId;
		this.cstmsRmk = cstmsRmk;
		this.cntrQty = cntrQty;
		this.entrNo = entrNo;
		this.rcvLocCd = rcvLocCd;
		this.cstmsLocDiffFlg = cstmsLocDiffFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("dspo_cd", getDspoCd());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("entr_tp_no", getEntrTpNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("rjct_flg", getRjctFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rcv_date", getRcvDate());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("ibd_ref_no", getIbdRefNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cstms_bat_no", getCstmsBatNo());
		this.hashColumns.put("rcv_msg_tp_id", getRcvMsgTpId());
		this.hashColumns.put("cstms_rmk", getCstmsRmk());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("entr_no", getEntrNo());
		this.hashColumns.put("rcv_loc_cd", getRcvLocCd());
		this.hashColumns.put("cstms_loc_diff_flg", getCstmsLocDiffFlg());
		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("dspo_cd", "dspoCd");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("entr_tp_no", "entrTpNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rjct_flg", "rjctFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rcv_date", "rcvDate");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("ibd_ref_no", "ibdRefNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cstms_bat_no", "cstmsBatNo");
		this.hashFields.put("rcv_msg_tp_id", "rcvMsgTpId");
		this.hashFields.put("cstms_rmk", "cstmsRmk");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("entr_no", "entrNo");
		this.hashFields.put("rcv_loc_cd", "rcvLocCd");
		this.hashFields.put("cstms_loc_diff_flg", "cstmsLocDiffFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return dspoCd
	 */
	public String getDspoCd() {
		return this.dspoCd;
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
	 * @return entrTpNo
	 */
	public String getEntrTpNo() {
		return this.entrTpNo;
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
	 * @return rjctFlg
	 */
	public String getRjctFlg() {
		return this.rjctFlg;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return rcvDate
	 */
	public String getRcvDate() {
		return this.rcvDate;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return scacCd
	 */
	public String getScacCd() {
		return this.scacCd;
	}
	
	/**
	 * Column Info
	 * @return ibdRefNo
	 */
	public String getIbdRefNo() {
		return this.ibdRefNo;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return cstmsBatNo
	 */
	public String getCstmsBatNo() {
		return this.cstmsBatNo;
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
	 * @return cstmsRmk
	 */
	public String getCstmsRmk() {
		return this.cstmsRmk;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return entrNo
	 */
	public String getEntrNo() {
		return this.entrNo;
	}
	
	/**
	 * Column Info
	 * @return rcvLocCd
	 */
	public String getRcvLocCd() {
		return this.rcvLocCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsLocDiffFlg
	 */
	public String getCstmsLocDiffFlg() {
		return this.cstmsLocDiffFlg;
	}

	/**
	 * Column Info
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param dspoCd
	 */
	public void setDspoCd(String dspoCd) {
		this.dspoCd = dspoCd;
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
	 * @param entrTpNo
	 */
	public void setEntrTpNo(String entrTpNo) {
		this.entrTpNo = entrTpNo;
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
	 * @param rjctFlg
	 */
	public void setRjctFlg(String rjctFlg) {
		this.rjctFlg = rjctFlg;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param rcvDate
	 */
	public void setRcvDate(String rcvDate) {
		this.rcvDate = rcvDate;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param scacCd
	 */
	public void setScacCd(String scacCd) {
		this.scacCd = scacCd;
	}
	
	/**
	 * Column Info
	 * @param ibdRefNo
	 */
	public void setIbdRefNo(String ibdRefNo) {
		this.ibdRefNo = ibdRefNo;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param cstmsBatNo
	 */
	public void setCstmsBatNo(String cstmsBatNo) {
		this.cstmsBatNo = cstmsBatNo;
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
	 * @param cstmsRmk
	 */
	public void setCstmsRmk(String cstmsRmk) {
		this.cstmsRmk = cstmsRmk;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param entrNo
	 */
	public void setEntrNo(String entrNo) {
		this.entrNo = entrNo;
	}
	
	/**
	 * Column Info
	 * @param rcvLocCd
	 */
	public void setRcvLocCd(String rcvLocCd) {
		this.rcvLocCd = rcvLocCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsLocDiffFlg
	 */
	public void setCstmsLocDiffFlg(String cstmsLocDiffFlg) {
		this.cstmsLocDiffFlg = cstmsLocDiffFlg;
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
		setCstmsClrCd(JSPUtil.getParameter(request, prefix + "cstms_clr_cd", ""));
		setDspoCd(JSPUtil.getParameter(request, prefix + "dspo_cd", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setEntrTpNo(JSPUtil.getParameter(request, prefix + "entr_tp_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRjctFlg(JSPUtil.getParameter(request, prefix + "rjct_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRcvDate(JSPUtil.getParameter(request, prefix + "rcv_date", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScacCd(JSPUtil.getParameter(request, prefix + "scac_cd", ""));
		setIbdRefNo(JSPUtil.getParameter(request, prefix + "ibd_ref_no", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setCstmsBatNo(JSPUtil.getParameter(request, prefix + "cstms_bat_no", ""));
		setRcvMsgTpId(JSPUtil.getParameter(request, prefix + "rcv_msg_tp_id", ""));
		setCstmsRmk(JSPUtil.getParameter(request, prefix + "cstms_rmk", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setEntrNo(JSPUtil.getParameter(request, prefix + "entr_no", ""));
		setRcvLocCd(JSPUtil.getParameter(request, prefix + "rcv_loc_cd", ""));
		setRcvLocCd(JSPUtil.getParameter(request, prefix + "cstms_loc_diff_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBlCustomsResultVO[]
	 */
	public UsaBlCustomsResultVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBlCustomsResultVO[]
	 */
	public UsaBlCustomsResultVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBlCustomsResultVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] dspoCd = (JSPUtil.getParameter(request, prefix	+ "dspo_cd", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] entrTpNo = (JSPUtil.getParameter(request, prefix	+ "entr_tp_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] rjctFlg = (JSPUtil.getParameter(request, prefix	+ "rjct_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] rcvDate = (JSPUtil.getParameter(request, prefix	+ "rcv_date", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd", length));
			String[] ibdRefNo = (JSPUtil.getParameter(request, prefix	+ "ibd_ref_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cstmsBatNo = (JSPUtil.getParameter(request, prefix	+ "cstms_bat_no", length));
			String[] rcvMsgTpId = (JSPUtil.getParameter(request, prefix	+ "rcv_msg_tp_id", length));
			String[] cstmsRmk = (JSPUtil.getParameter(request, prefix	+ "cstms_rmk", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] entrNo = (JSPUtil.getParameter(request, prefix	+ "entr_no", length));
			String[] rcvLocCd = (JSPUtil.getParameter(request, prefix	+ "rcv_loc_cd", length));
			String[] cstmsLocDiffFlg = (JSPUtil.getParameter(request, prefix	+ "cstms_loc_diff_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaBlCustomsResultVO();
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (dspoCd[i] != null)
					model.setDspoCd(dspoCd[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (entrTpNo[i] != null)
					model.setEntrTpNo(entrTpNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (rjctFlg[i] != null)
					model.setRjctFlg(rjctFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (rcvDate[i] != null)
					model.setRcvDate(rcvDate[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (ibdRefNo[i] != null)
					model.setIbdRefNo(ibdRefNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cstmsBatNo[i] != null)
					model.setCstmsBatNo(cstmsBatNo[i]);
				if (rcvMsgTpId[i] != null)
					model.setRcvMsgTpId(rcvMsgTpId[i]);
				if (cstmsRmk[i] != null)
					model.setCstmsRmk(cstmsRmk[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (entrNo[i] != null)
					model.setEntrNo(entrNo[i]);
				if (rcvLocCd[i] != null)
					model.setRcvLocCd(rcvLocCd[i]);
				if (cstmsLocDiffFlg[i] != null)
					model.setCstmsLocDiffFlg(cstmsLocDiffFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBlCustomsResultVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBlCustomsResultVO[]
	 */
	public UsaBlCustomsResultVO[] getUsaBlCustomsResultVOs(){
		UsaBlCustomsResultVO[] vos = (UsaBlCustomsResultVO[])models.toArray(new UsaBlCustomsResultVO[models.size()]);
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
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dspoCd = this.dspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrTpNo = this.entrTpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctFlg = this.rjctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDate = this.rcvDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdRefNo = this.ibdRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsBatNo = this.cstmsBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMsgTpId = this.rcvMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsRmk = this.cstmsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrNo = this.entrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLocCd = this.rcvLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsLocDiffFlg = this.cstmsLocDiffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
