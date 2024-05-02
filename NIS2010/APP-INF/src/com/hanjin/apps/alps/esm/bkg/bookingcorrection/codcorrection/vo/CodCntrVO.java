/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CodCntrVO.java
*@FileTitle : CodCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.01.30 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodCntrVO> models = new ArrayList<CodCntrVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String rfEmlCtnt = null;
	/* Column Info */
	private String cntrStwgNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String dgEmlCtnt = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String reservedCntrFlg = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String akEmlCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodCntrVO() {}

	public CodCntrVO(String ibflag, String pagerows, String seq, String chk, String cntrNo, String cntrTpszCd, String cntrWgt, String wgtUtCd, String dcgoFlg, String bbCgoFlg, String awkCgoFlg, String rcFlg, String socFlg, String cntrStwgNo, String reservedCntrFlg, String mvmtStsCd, String dgEmlCtnt, String akEmlCtnt, String rfEmlCtnt) {
		this.cntrWgt = cntrWgt;
		this.awkCgoFlg = awkCgoFlg;
		this.rfEmlCtnt = rfEmlCtnt;
		this.cntrStwgNo = cntrStwgNo;
		this.pagerows = pagerows;
		this.socFlg = socFlg;
		this.dgEmlCtnt = dgEmlCtnt;
		this.mvmtStsCd = mvmtStsCd;
		this.ibflag = ibflag;
		this.chk = chk;
		this.cntrNo = cntrNo;
		this.bbCgoFlg = bbCgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.dcgoFlg = dcgoFlg;
		this.seq = seq;
		this.reservedCntrFlg = reservedCntrFlg;
		this.rcFlg = rcFlg;
		this.akEmlCtnt = akEmlCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("rf_eml_ctnt", getRfEmlCtnt());
		this.hashColumns.put("cntr_stwg_no", getCntrStwgNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("dg_eml_ctnt", getDgEmlCtnt());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("reserved_cntr_flg", getReservedCntrFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("ak_eml_ctnt", getAkEmlCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("rf_eml_ctnt", "rfEmlCtnt");
		this.hashFields.put("cntr_stwg_no", "cntrStwgNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("dg_eml_ctnt", "dgEmlCtnt");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("reserved_cntr_flg", "reservedCntrFlg");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("ak_eml_ctnt", "akEmlCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return rfEmlCtnt
	 */
	public String getRfEmlCtnt() {
		return this.rfEmlCtnt;
	}
	
	/**
	 * Column Info
	 * @return cntrStwgNo
	 */
	public String getCntrStwgNo() {
		return this.cntrStwgNo;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return dgEmlCtnt
	 */
	public String getDgEmlCtnt() {
		return this.dgEmlCtnt;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
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
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
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
	 * @return reservedCntrFlg
	 */
	public String getReservedCntrFlg() {
		return this.reservedCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return akEmlCtnt
	 */
	public String getAkEmlCtnt() {
		return this.akEmlCtnt;
	}
	

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param rfEmlCtnt
	 */
	public void setRfEmlCtnt(String rfEmlCtnt) {
		this.rfEmlCtnt = rfEmlCtnt;
	}
	
	/**
	 * Column Info
	 * @param cntrStwgNo
	 */
	public void setCntrStwgNo(String cntrStwgNo) {
		this.cntrStwgNo = cntrStwgNo;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param dgEmlCtnt
	 */
	public void setDgEmlCtnt(String dgEmlCtnt) {
		this.dgEmlCtnt = dgEmlCtnt;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
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
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
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
	 * @param reservedCntrFlg
	 */
	public void setReservedCntrFlg(String reservedCntrFlg) {
		this.reservedCntrFlg = reservedCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param akEmlCtnt
	 */
	public void setAkEmlCtnt(String akEmlCtnt) {
		this.akEmlCtnt = akEmlCtnt;
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
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setRfEmlCtnt(JSPUtil.getParameter(request, prefix + "rf_eml_ctnt", ""));
		setCntrStwgNo(JSPUtil.getParameter(request, prefix + "cntr_stwg_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setDgEmlCtnt(JSPUtil.getParameter(request, prefix + "dg_eml_ctnt", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setReservedCntrFlg(JSPUtil.getParameter(request, prefix + "reserved_cntr_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setAkEmlCtnt(JSPUtil.getParameter(request, prefix + "ak_eml_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodCntrVO[]
	 */
	public CodCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodCntrVO[]
	 */
	public CodCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] rfEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "rf_eml_ctnt", length));
			String[] cntrStwgNo = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] dgEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "dg_eml_ctnt", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] reservedCntrFlg = (JSPUtil.getParameter(request, prefix	+ "reserved_cntr_flg", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] akEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "ak_eml_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodCntrVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (rfEmlCtnt[i] != null)
					model.setRfEmlCtnt(rfEmlCtnt[i]);
				if (cntrStwgNo[i] != null)
					model.setCntrStwgNo(cntrStwgNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (dgEmlCtnt[i] != null)
					model.setDgEmlCtnt(dgEmlCtnt[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (reservedCntrFlg[i] != null)
					model.setReservedCntrFlg(reservedCntrFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (akEmlCtnt[i] != null)
					model.setAkEmlCtnt(akEmlCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodCntrVO[]
	 */
	public CodCntrVO[] getCodCntrVOs(){
		CodCntrVO[] vos = (CodCntrVO[])models.toArray(new CodCntrVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfEmlCtnt = this.rfEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgNo = this.cntrStwgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgEmlCtnt = this.dgEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reservedCntrFlg = this.reservedCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akEmlCtnt = this.akEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
