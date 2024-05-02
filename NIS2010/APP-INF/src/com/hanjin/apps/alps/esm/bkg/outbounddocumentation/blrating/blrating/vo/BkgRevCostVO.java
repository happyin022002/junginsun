/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgRevCostVO.java
*@FileTitle : BkgRevCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BkgRevCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgRevCostVO> models = new ArrayList<BkgRevCostVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String eqMgmtUcAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String estmCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cmpbAmt = null;
	/* Column Info */
	private String oftAmt = null;
	/* Column Info */
	private String revAmt = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String revCostSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sglRevFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgRevCostVO() {}

	public BkgRevCostVO(String ibflag, String pagerows, String bkgNo, String revCostSeq, String revAmt, String estmCostAmt, String bkgTeuQty, String cmpbAmt, String creUsrId, String creDt, String updUsrId, String updDt, String eqMgmtUcAmt, String oftAmt, String rtAplyDt, String sglRevFlg) {
		this.updDt = updDt;
		this.rtAplyDt = rtAplyDt;
		this.eqMgmtUcAmt = eqMgmtUcAmt;
		this.creDt = creDt;
		this.estmCostAmt = estmCostAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.cmpbAmt = cmpbAmt;
		this.oftAmt = oftAmt;
		this.revAmt = revAmt;
		this.bkgTeuQty = bkgTeuQty;
		this.revCostSeq = revCostSeq;
		this.updUsrId = updUsrId;
		this.sglRevFlg = sglRevFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("eq_mgmt_uc_amt", getEqMgmtUcAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("estm_cost_amt", getEstmCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cmpb_amt", getCmpbAmt());
		this.hashColumns.put("oft_amt", getOftAmt());
		this.hashColumns.put("rev_amt", getRevAmt());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("rev_cost_seq", getRevCostSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sgl_rev_flg", getSglRevFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("eq_mgmt_uc_amt", "eqMgmtUcAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("estm_cost_amt", "estmCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cmpb_amt", "cmpbAmt");
		this.hashFields.put("oft_amt", "oftAmt");
		this.hashFields.put("rev_amt", "revAmt");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("rev_cost_seq", "revCostSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sgl_rev_flg", "sglRevFlg");
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
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return eqMgmtUcAmt
	 */
	public String getEqMgmtUcAmt() {
		return this.eqMgmtUcAmt;
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
	 * @return estmCostAmt
	 */
	public String getEstmCostAmt() {
		return this.estmCostAmt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cmpbAmt
	 */
	public String getCmpbAmt() {
		return this.cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return oftAmt
	 */
	public String getOftAmt() {
		return this.oftAmt;
	}
	
	/**
	 * Column Info
	 * @return revAmt
	 */
	public String getRevAmt() {
		return this.revAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @return revCostSeq
	 */
	public String getRevCostSeq() {
		return this.revCostSeq;
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
	 * @return sglRevFlg
	 */
	public String getSglRevFlg() {
		return this.sglRevFlg;
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
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param eqMgmtUcAmt
	 */
	public void setEqMgmtUcAmt(String eqMgmtUcAmt) {
		this.eqMgmtUcAmt = eqMgmtUcAmt;
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
	 * @param estmCostAmt
	 */
	public void setEstmCostAmt(String estmCostAmt) {
		this.estmCostAmt = estmCostAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cmpbAmt
	 */
	public void setCmpbAmt(String cmpbAmt) {
		this.cmpbAmt = cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param oftAmt
	 */
	public void setOftAmt(String oftAmt) {
		this.oftAmt = oftAmt;
	}
	
	/**
	 * Column Info
	 * @param revAmt
	 */
	public void setRevAmt(String revAmt) {
		this.revAmt = revAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
	}
	
	/**
	 * Column Info
	 * @param revCostSeq
	 */
	public void setRevCostSeq(String revCostSeq) {
		this.revCostSeq = revCostSeq;
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
	 * @param sglRevFlg
	 */
	public void setSglRevFlg(String sglRevFlg) {
		this.sglRevFlg = sglRevFlg;
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
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setEqMgmtUcAmt(JSPUtil.getParameter(request, prefix + "eq_mgmt_uc_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEstmCostAmt(JSPUtil.getParameter(request, prefix + "estm_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCmpbAmt(JSPUtil.getParameter(request, prefix + "cmpb_amt", ""));
		setOftAmt(JSPUtil.getParameter(request, prefix + "oft_amt", ""));
		setRevAmt(JSPUtil.getParameter(request, prefix + "rev_amt", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setRevCostSeq(JSPUtil.getParameter(request, prefix + "rev_cost_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgRevCostVO[]
	 */
	public BkgRevCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgRevCostVO[]
	 */
	public BkgRevCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgRevCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] eqMgmtUcAmt = (JSPUtil.getParameter(request, prefix	+ "eq_mgmt_uc_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] estmCostAmt = (JSPUtil.getParameter(request, prefix	+ "estm_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cmpbAmt = (JSPUtil.getParameter(request, prefix	+ "cmpb_amt", length));
			String[] oftAmt = (JSPUtil.getParameter(request, prefix	+ "oft_amt", length));
			String[] revAmt = (JSPUtil.getParameter(request, prefix	+ "rev_amt", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] revCostSeq = (JSPUtil.getParameter(request, prefix	+ "rev_cost_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sglRevFlg = (JSPUtil.getParameter(request, prefix	+ "sgl_rev_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgRevCostVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (eqMgmtUcAmt[i] != null)
					model.setEqMgmtUcAmt(eqMgmtUcAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (estmCostAmt[i] != null)
					model.setEstmCostAmt(estmCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cmpbAmt[i] != null)
					model.setCmpbAmt(cmpbAmt[i]);
				if (oftAmt[i] != null)
					model.setOftAmt(oftAmt[i]);
				if (revAmt[i] != null)
					model.setRevAmt(revAmt[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (revCostSeq[i] != null)
					model.setRevCostSeq(revCostSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sglRevFlg[i] != null)
					model.setSglRevFlg(sglRevFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgRevCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgRevCostVO[]
	 */
	public BkgRevCostVO[] getBkgRevCostVOs(){
		BkgRevCostVO[] vos = (BkgRevCostVO[])models.toArray(new BkgRevCostVO[models.size()]);
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
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMgmtUcAmt = this.eqMgmtUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostAmt = this.estmCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbAmt = this.cmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftAmt = this.oftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAmt = this.revAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCostSeq = this.revCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sglRevFlg = this.sglRevFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
