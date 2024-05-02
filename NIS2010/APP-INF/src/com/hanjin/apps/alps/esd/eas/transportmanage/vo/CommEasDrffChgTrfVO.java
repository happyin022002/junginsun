/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CommEasDrffChgTrfVO.java
*@FileTitle : CommEasDrffChgTrfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.transportmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommEasDrffChgTrfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommEasDrffChgTrfVO> models = new ArrayList<CommEasDrffChgTrfVO>();
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String chrrFrtTaxVal = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String portInlndCd = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String drffChgTrfDtlSeq = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String podCntCd = null;
	/* Column Info */
	private String podCntListCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String d2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String drffChgTrfSeq = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String drffChgTrfVerNo = null;
	/* Column Info */
	private String currListCtnt = null;
	/* Column Info */
	private String r9 = null;
	/* Column Info */
	private String expFlg = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommEasDrffChgTrfVO() {}

	public CommEasDrffChgTrfVO(String ibflag, String pagerows, String drffChgTrfSeq, String drffChgTrfVerNo, String drffChgTrfDtlSeq, String sccCd, String portInlndCd, String contiCd, String podCntCd, String podCntListCtnt, String currCd, String currListCtnt, String expFlg, String d2, String d4, String d5, String r2, String r5, String r9, String cntrTpszCd, String chrrFrtTaxVal, String maxSeq) {
		this.contiCd = contiCd;
		this.chrrFrtTaxVal = chrrFrtTaxVal;
		this.currCd = currCd;
		this.portInlndCd = portInlndCd;
		this.d5 = d5;
		this.drffChgTrfDtlSeq = drffChgTrfDtlSeq;
		this.d4 = d4;
		this.podCntCd = podCntCd;
		this.podCntListCtnt = podCntListCtnt;
		this.pagerows = pagerows;
		this.d2 = d2;
		this.ibflag = ibflag;
		this.drffChgTrfSeq = drffChgTrfSeq;
		this.sccCd = sccCd;
		this.maxSeq = maxSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.drffChgTrfVerNo = drffChgTrfVerNo;
		this.currListCtnt = currListCtnt;
		this.r9 = r9;
		this.expFlg = expFlg;
		this.r2 = r2;
		this.r5 = r5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("chrr_frt_tax_val", getChrrFrtTaxVal());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("port_inlnd_cd", getPortInlndCd());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("drff_chg_trf_dtl_seq", getDrffChgTrfDtlSeq());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("pod_cnt_cd", getPodCntCd());
		this.hashColumns.put("pod_cnt_list_ctnt", getPodCntListCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("drff_chg_trf_seq", getDrffChgTrfSeq());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("drff_chg_trf_ver_no", getDrffChgTrfVerNo());
		this.hashColumns.put("curr_list_ctnt", getCurrListCtnt());
		this.hashColumns.put("r9", getR9());
		this.hashColumns.put("exp_flg", getExpFlg());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r5", getR5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("chrr_frt_tax_val", "chrrFrtTaxVal");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("port_inlnd_cd", "portInlndCd");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("drff_chg_trf_dtl_seq", "drffChgTrfDtlSeq");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("pod_cnt_cd", "podCntCd");
		this.hashFields.put("pod_cnt_list_ctnt", "podCntListCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("drff_chg_trf_seq", "drffChgTrfSeq");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("drff_chg_trf_ver_no", "drffChgTrfVerNo");
		this.hashFields.put("curr_list_ctnt", "currListCtnt");
		this.hashFields.put("r9", "r9");
		this.hashFields.put("exp_flg", "expFlg");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r5", "r5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return chrrFrtTaxVal
	 */
	public String getChrrFrtTaxVal() {
		return this.chrrFrtTaxVal;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return portInlndCd
	 */
	public String getPortInlndCd() {
		return this.portInlndCd;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return drffChgTrfDtlSeq
	 */
	public String getDrffChgTrfDtlSeq() {
		return this.drffChgTrfDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return podCntCd
	 */
	public String getPodCntCd() {
		return this.podCntCd;
	}
	
	/**
	 * Column Info
	 * @return podCntListCtnt
	 */
	public String getPodCntListCtnt() {
		return this.podCntListCtnt;
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
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return drffChgTrfSeq
	 */
	public String getDrffChgTrfSeq() {
		return this.drffChgTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
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
	 * @return drffChgTrfVerNo
	 */
	public String getDrffChgTrfVerNo() {
		return this.drffChgTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @return currListCtnt
	 */
	public String getCurrListCtnt() {
		return this.currListCtnt;
	}
	
	/**
	 * Column Info
	 * @return r9
	 */
	public String getR9() {
		return this.r9;
	}
	
	/**
	 * Column Info
	 * @return expFlg
	 */
	public String getExpFlg() {
		return this.expFlg;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	

	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param chrrFrtTaxVal
	 */
	public void setChrrFrtTaxVal(String chrrFrtTaxVal) {
		this.chrrFrtTaxVal = chrrFrtTaxVal;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param portInlndCd
	 */
	public void setPortInlndCd(String portInlndCd) {
		this.portInlndCd = portInlndCd;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param drffChgTrfDtlSeq
	 */
	public void setDrffChgTrfDtlSeq(String drffChgTrfDtlSeq) {
		this.drffChgTrfDtlSeq = drffChgTrfDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param podCntCd
	 */
	public void setPodCntCd(String podCntCd) {
		this.podCntCd = podCntCd;
	}
	
	/**
	 * Column Info
	 * @param podCntListCtnt
	 */
	public void setPodCntListCtnt(String podCntListCtnt) {
		this.podCntListCtnt = podCntListCtnt;
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
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param drffChgTrfSeq
	 */
	public void setDrffChgTrfSeq(String drffChgTrfSeq) {
		this.drffChgTrfSeq = drffChgTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
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
	 * @param drffChgTrfVerNo
	 */
	public void setDrffChgTrfVerNo(String drffChgTrfVerNo) {
		this.drffChgTrfVerNo = drffChgTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @param currListCtnt
	 */
	public void setCurrListCtnt(String currListCtnt) {
		this.currListCtnt = currListCtnt;
	}
	
	/**
	 * Column Info
	 * @param r9
	 */
	public void setR9(String r9) {
		this.r9 = r9;
	}
	
	/**
	 * Column Info
	 * @param expFlg
	 */
	public void setExpFlg(String expFlg) {
		this.expFlg = expFlg;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
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
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setChrrFrtTaxVal(JSPUtil.getParameter(request, prefix + "chrr_frt_tax_val", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPortInlndCd(JSPUtil.getParameter(request, prefix + "port_inlnd_cd", ""));
		setD5(JSPUtil.getParameter(request, prefix + "d5", ""));
		setDrffChgTrfDtlSeq(JSPUtil.getParameter(request, prefix + "drff_chg_trf_dtl_seq", ""));
		setD4(JSPUtil.getParameter(request, prefix + "d4", ""));
		setPodCntCd(JSPUtil.getParameter(request, prefix + "pod_cnt_cd", ""));
		setPodCntListCtnt(JSPUtil.getParameter(request, prefix + "pod_cnt_list_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setD2(JSPUtil.getParameter(request, prefix + "d2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDrffChgTrfSeq(JSPUtil.getParameter(request, prefix + "drff_chg_trf_seq", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setMaxSeq(JSPUtil.getParameter(request, prefix + "max_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDrffChgTrfVerNo(JSPUtil.getParameter(request, prefix + "drff_chg_trf_ver_no", ""));
		setCurrListCtnt(JSPUtil.getParameter(request, prefix + "curr_list_ctnt", ""));
		setR9(JSPUtil.getParameter(request, prefix + "r9", ""));
		setExpFlg(JSPUtil.getParameter(request, prefix + "exp_flg", ""));
		setR2(JSPUtil.getParameter(request, prefix + "r2", ""));
		setR5(JSPUtil.getParameter(request, prefix + "r5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommEasDrffChgTrfVO[]
	 */
	public CommEasDrffChgTrfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommEasDrffChgTrfVO[]
	 */
	public CommEasDrffChgTrfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommEasDrffChgTrfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] chrrFrtTaxVal = (JSPUtil.getParameter(request, prefix	+ "chrr_frt_tax_val", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] portInlndCd = (JSPUtil.getParameter(request, prefix	+ "port_inlnd_cd", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] drffChgTrfDtlSeq = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_dtl_seq", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] podCntCd = (JSPUtil.getParameter(request, prefix	+ "pod_cnt_cd", length));
			String[] podCntListCtnt = (JSPUtil.getParameter(request, prefix	+ "pod_cnt_list_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] drffChgTrfSeq = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_seq", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] drffChgTrfVerNo = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_ver_no", length));
			String[] currListCtnt = (JSPUtil.getParameter(request, prefix	+ "curr_list_ctnt", length));
			String[] r9 = (JSPUtil.getParameter(request, prefix	+ "r9", length));
			String[] expFlg = (JSPUtil.getParameter(request, prefix	+ "exp_flg", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommEasDrffChgTrfVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (chrrFrtTaxVal[i] != null)
					model.setChrrFrtTaxVal(chrrFrtTaxVal[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (portInlndCd[i] != null)
					model.setPortInlndCd(portInlndCd[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (drffChgTrfDtlSeq[i] != null)
					model.setDrffChgTrfDtlSeq(drffChgTrfDtlSeq[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (podCntCd[i] != null)
					model.setPodCntCd(podCntCd[i]);
				if (podCntListCtnt[i] != null)
					model.setPodCntListCtnt(podCntListCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (drffChgTrfSeq[i] != null)
					model.setDrffChgTrfSeq(drffChgTrfSeq[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (drffChgTrfVerNo[i] != null)
					model.setDrffChgTrfVerNo(drffChgTrfVerNo[i]);
				if (currListCtnt[i] != null)
					model.setCurrListCtnt(currListCtnt[i]);
				if (r9[i] != null)
					model.setR9(r9[i]);
				if (expFlg[i] != null)
					model.setExpFlg(expFlg[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommEasDrffChgTrfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommEasDrffChgTrfVO[]
	 */
	public CommEasDrffChgTrfVO[] getCommEasDrffChgTrfVOs(){
		CommEasDrffChgTrfVO[] vos = (CommEasDrffChgTrfVO[])models.toArray(new CommEasDrffChgTrfVO[models.size()]);
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
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chrrFrtTaxVal = this.chrrFrtTaxVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portInlndCd = this.portInlndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfDtlSeq = this.drffChgTrfDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCntCd = this.podCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCntListCtnt = this.podCntListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfSeq = this.drffChgTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq = this.maxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfVerNo = this.drffChgTrfVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currListCtnt = this.currListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r9 = this.r9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expFlg = this.expFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
