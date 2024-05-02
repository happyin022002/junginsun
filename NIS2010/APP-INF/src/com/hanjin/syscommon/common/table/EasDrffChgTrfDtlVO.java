/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EasDrffChgTrfDtlVO.java
*@FileTitle : EasDrffChgTrfDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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

public class EasDrffChgTrfDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EasDrffChgTrfDtlVO> models = new ArrayList<EasDrffChgTrfDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String portInlndCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String drffChgTrfDtlSeq = null;
	/* Column Info */
	private String podCntCd = null;
	/* Column Info */
	private String podCntListCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String drffChgTrfSeq = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String tmpSavFlg = null;
	/* Column Info */
	private String drffChgTrfVerNo = null;
	/* Column Info */
	private String currListCtnt = null;
	/* Column Info */
	private String expFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EasDrffChgTrfDtlVO() {}

	public EasDrffChgTrfDtlVO(String ibflag, String pagerows, String drffChgTrfSeq, String drffChgTrfVerNo, String drffChgTrfDtlSeq, String sccCd, String portInlndCd, String contiCd, String podCntCd, String podCntListCtnt, String currCd, String currListCtnt, String expFlg, String custCntCd, String custSeq, String tmpSavFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.contiCd = contiCd;
		this.currCd = currCd;
		this.portInlndCd = portInlndCd;
		this.creDt = creDt;
		this.custSeq = custSeq;
		this.drffChgTrfDtlSeq = drffChgTrfDtlSeq;
		this.podCntCd = podCntCd;
		this.podCntListCtnt = podCntListCtnt;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.drffChgTrfSeq = drffChgTrfSeq;
		this.sccCd = sccCd;
		this.tmpSavFlg = tmpSavFlg;
		this.drffChgTrfVerNo = drffChgTrfVerNo;
		this.currListCtnt = currListCtnt;
		this.expFlg = expFlg;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("port_inlnd_cd", getPortInlndCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("drff_chg_trf_dtl_seq", getDrffChgTrfDtlSeq());
		this.hashColumns.put("pod_cnt_cd", getPodCntCd());
		this.hashColumns.put("pod_cnt_list_ctnt", getPodCntListCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("drff_chg_trf_seq", getDrffChgTrfSeq());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("tmp_sav_flg", getTmpSavFlg());
		this.hashColumns.put("drff_chg_trf_ver_no", getDrffChgTrfVerNo());
		this.hashColumns.put("curr_list_ctnt", getCurrListCtnt());
		this.hashColumns.put("exp_flg", getExpFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("port_inlnd_cd", "portInlndCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("drff_chg_trf_dtl_seq", "drffChgTrfDtlSeq");
		this.hashFields.put("pod_cnt_cd", "podCntCd");
		this.hashFields.put("pod_cnt_list_ctnt", "podCntListCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("drff_chg_trf_seq", "drffChgTrfSeq");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("tmp_sav_flg", "tmpSavFlg");
		this.hashFields.put("drff_chg_trf_ver_no", "drffChgTrfVerNo");
		this.hashFields.put("curr_list_ctnt", "currListCtnt");
		this.hashFields.put("exp_flg", "expFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
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
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return drffChgTrfDtlSeq
	 */
	public String getDrffChgTrfDtlSeq() {
		return this.drffChgTrfDtlSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return tmpSavFlg
	 */
	public String getTmpSavFlg() {
		return this.tmpSavFlg;
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
	 * @return expFlg
	 */
	public String getExpFlg() {
		return this.expFlg;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param drffChgTrfDtlSeq
	 */
	public void setDrffChgTrfDtlSeq(String drffChgTrfDtlSeq) {
		this.drffChgTrfDtlSeq = drffChgTrfDtlSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param tmpSavFlg
	 */
	public void setTmpSavFlg(String tmpSavFlg) {
		this.tmpSavFlg = tmpSavFlg;
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
	 * @param expFlg
	 */
	public void setExpFlg(String expFlg) {
		this.expFlg = expFlg;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPortInlndCd(JSPUtil.getParameter(request, prefix + "port_inlnd_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setDrffChgTrfDtlSeq(JSPUtil.getParameter(request, prefix + "drff_chg_trf_dtl_seq", ""));
		setPodCntCd(JSPUtil.getParameter(request, prefix + "pod_cnt_cd", ""));
		setPodCntListCtnt(JSPUtil.getParameter(request, prefix + "pod_cnt_list_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDrffChgTrfSeq(JSPUtil.getParameter(request, prefix + "drff_chg_trf_seq", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setTmpSavFlg(JSPUtil.getParameter(request, prefix + "tmp_sav_flg", ""));
		setDrffChgTrfVerNo(JSPUtil.getParameter(request, prefix + "drff_chg_trf_ver_no", ""));
		setCurrListCtnt(JSPUtil.getParameter(request, prefix + "curr_list_ctnt", ""));
		setExpFlg(JSPUtil.getParameter(request, prefix + "exp_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EasDrffChgTrfDtlVO[]
	 */
	public EasDrffChgTrfDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EasDrffChgTrfDtlVO[]
	 */
	public EasDrffChgTrfDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EasDrffChgTrfDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] portInlndCd = (JSPUtil.getParameter(request, prefix	+ "port_inlnd_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] drffChgTrfDtlSeq = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_dtl_seq", length));
			String[] podCntCd = (JSPUtil.getParameter(request, prefix	+ "pod_cnt_cd", length));
			String[] podCntListCtnt = (JSPUtil.getParameter(request, prefix	+ "pod_cnt_list_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] drffChgTrfSeq = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_seq", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] tmpSavFlg = (JSPUtil.getParameter(request, prefix	+ "tmp_sav_flg", length));
			String[] drffChgTrfVerNo = (JSPUtil.getParameter(request, prefix	+ "drff_chg_trf_ver_no", length));
			String[] currListCtnt = (JSPUtil.getParameter(request, prefix	+ "curr_list_ctnt", length));
			String[] expFlg = (JSPUtil.getParameter(request, prefix	+ "exp_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EasDrffChgTrfDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (portInlndCd[i] != null)
					model.setPortInlndCd(portInlndCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (drffChgTrfDtlSeq[i] != null)
					model.setDrffChgTrfDtlSeq(drffChgTrfDtlSeq[i]);
				if (podCntCd[i] != null)
					model.setPodCntCd(podCntCd[i]);
				if (podCntListCtnt[i] != null)
					model.setPodCntListCtnt(podCntListCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (drffChgTrfSeq[i] != null)
					model.setDrffChgTrfSeq(drffChgTrfSeq[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (tmpSavFlg[i] != null)
					model.setTmpSavFlg(tmpSavFlg[i]);
				if (drffChgTrfVerNo[i] != null)
					model.setDrffChgTrfVerNo(drffChgTrfVerNo[i]);
				if (currListCtnt[i] != null)
					model.setCurrListCtnt(currListCtnt[i]);
				if (expFlg[i] != null)
					model.setExpFlg(expFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEasDrffChgTrfDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EasDrffChgTrfDtlVO[]
	 */
	public EasDrffChgTrfDtlVO[] getEasDrffChgTrfDtlVOs(){
		EasDrffChgTrfDtlVO[] vos = (EasDrffChgTrfDtlVO[])models.toArray(new EasDrffChgTrfDtlVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portInlndCd = this.portInlndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfDtlSeq = this.drffChgTrfDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCntCd = this.podCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCntListCtnt = this.podCntListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfSeq = this.drffChgTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSavFlg = this.tmpSavFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drffChgTrfVerNo = this.drffChgTrfVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currListCtnt = this.currListCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expFlg = this.expFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
