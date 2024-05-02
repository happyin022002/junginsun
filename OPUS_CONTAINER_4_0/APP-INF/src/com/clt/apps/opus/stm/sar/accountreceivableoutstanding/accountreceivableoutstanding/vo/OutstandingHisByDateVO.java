/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OutstandingHisByDateVO.java
*@FileTitle : OutstandingHisByDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class OutstandingHisByDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OutstandingHisByDateVO> models = new ArrayList<OutstandingHisByDateVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String ifNo = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String condGlIf = null;
	/* Column Info */
	private String tjSrcNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String condDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String otsRmk = null;
	/* Column Info */
	private String otsOfcCd = null;
	/* Column Info */
	private String otsHisTpCd = null;
	/* Column Info */
	private String otsAmt = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String revTpSrcCd = null;
	/* Column Info */
	private String invOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OutstandingHisByDateVO() {}

	public OutstandingHisByDateVO(String ibflag, String pagerows, String blNo, String invNo, String invOfcCd, String ifDt, String otsHisTpCd, String currCd, String otsAmt, String glDt, String refNo, String tjSrcNm, String otsRmk, String ifNo, String rhqCd, String otsOfcCd, String revTpSrcCd, String creUsrId, String bkgNo, String condDt, String condGlIf) {
		this.ifDt = ifDt;
		this.ifNo = ifNo;
		this.glDt = glDt;
		this.currCd = currCd;
		this.rhqCd = rhqCd;
		this.condGlIf = condGlIf;
		this.tjSrcNm = tjSrcNm;
		this.blNo = blNo;
		this.condDt = condDt;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.otsRmk = otsRmk;
		this.otsOfcCd = otsOfcCd;
		this.otsHisTpCd = otsHisTpCd;
		this.otsAmt = otsAmt;
		this.refNo = refNo;
		this.revTpSrcCd = revTpSrcCd;
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("cond_gl_if", getCondGlIf());
		this.hashColumns.put("tj_src_nm", getTjSrcNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cond_dt", getCondDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ots_rmk", getOtsRmk());
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());
		this.hashColumns.put("ots_his_tp_cd", getOtsHisTpCd());
		this.hashColumns.put("ots_amt", getOtsAmt());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("rev_tp_src_cd", getRevTpSrcCd());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("cond_gl_if", "condGlIf");
		this.hashFields.put("tj_src_nm", "tjSrcNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cond_dt", "condDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("ots_his_tp_cd", "otsHisTpCd");
		this.hashFields.put("ots_amt", "otsAmt");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("rev_tp_src_cd", "revTpSrcCd");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}
	
	/**
	 * Column Info
	 * @return ifNo
	 */
	public String getIfNo() {
		return this.ifNo;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return condGlIf
	 */
	public String getCondGlIf() {
		return this.condGlIf;
	}
	
	/**
	 * Column Info
	 * @return tjSrcNm
	 */
	public String getTjSrcNm() {
		return this.tjSrcNm;
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
	 * @return condDt
	 */
	public String getCondDt() {
		return this.condDt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return otsRmk
	 */
	public String getOtsRmk() {
		return this.otsRmk;
	}
	
	/**
	 * Column Info
	 * @return otsOfcCd
	 */
	public String getOtsOfcCd() {
		return this.otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return otsHisTpCd
	 */
	public String getOtsHisTpCd() {
		return this.otsHisTpCd;
	}
	
	/**
	 * Column Info
	 * @return otsAmt
	 */
	public String getOtsAmt() {
		return this.otsAmt;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return revTpSrcCd
	 */
	public String getRevTpSrcCd() {
		return this.revTpSrcCd;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	

	/**
	 * Column Info
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}
	
	/**
	 * Column Info
	 * @param ifNo
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param condGlIf
	 */
	public void setCondGlIf(String condGlIf) {
		this.condGlIf = condGlIf;
	}
	
	/**
	 * Column Info
	 * @param tjSrcNm
	 */
	public void setTjSrcNm(String tjSrcNm) {
		this.tjSrcNm = tjSrcNm;
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
	 * @param condDt
	 */
	public void setCondDt(String condDt) {
		this.condDt = condDt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param otsRmk
	 */
	public void setOtsRmk(String otsRmk) {
		this.otsRmk = otsRmk;
	}
	
	/**
	 * Column Info
	 * @param otsOfcCd
	 */
	public void setOtsOfcCd(String otsOfcCd) {
		this.otsOfcCd = otsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param otsHisTpCd
	 */
	public void setOtsHisTpCd(String otsHisTpCd) {
		this.otsHisTpCd = otsHisTpCd;
	}
	
	/**
	 * Column Info
	 * @param otsAmt
	 */
	public void setOtsAmt(String otsAmt) {
		this.otsAmt = otsAmt;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param revTpSrcCd
	 */
	public void setRevTpSrcCd(String revTpSrcCd) {
		this.revTpSrcCd = revTpSrcCd;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
		setIfDt(JSPUtil.getParameter(request, prefix + "if_dt", ""));
		setIfNo(JSPUtil.getParameter(request, prefix + "if_no", ""));
		setGlDt(JSPUtil.getParameter(request, prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setCondGlIf(JSPUtil.getParameter(request, prefix + "cond_gl_if", ""));
		setTjSrcNm(JSPUtil.getParameter(request, prefix + "tj_src_nm", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCondDt(JSPUtil.getParameter(request, prefix + "cond_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOtsRmk(JSPUtil.getParameter(request, prefix + "ots_rmk", ""));
		setOtsOfcCd(JSPUtil.getParameter(request, prefix + "ots_ofc_cd", ""));
		setOtsHisTpCd(JSPUtil.getParameter(request, prefix + "ots_his_tp_cd", ""));
		setOtsAmt(JSPUtil.getParameter(request, prefix + "ots_amt", ""));
		setRefNo(JSPUtil.getParameter(request, prefix + "ref_no", ""));
		setRevTpSrcCd(JSPUtil.getParameter(request, prefix + "rev_tp_src_cd", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutstandingHisByDateVO[]
	 */
	public OutstandingHisByDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OutstandingHisByDateVO[]
	 */
	public OutstandingHisByDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OutstandingHisByDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] condGlIf = (JSPUtil.getParameter(request, prefix	+ "cond_gl_if", length));
			String[] tjSrcNm = (JSPUtil.getParameter(request, prefix	+ "tj_src_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] condDt = (JSPUtil.getParameter(request, prefix	+ "cond_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] otsRmk = (JSPUtil.getParameter(request, prefix	+ "ots_rmk", length));
			String[] otsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ots_ofc_cd", length));
			String[] otsHisTpCd = (JSPUtil.getParameter(request, prefix	+ "ots_his_tp_cd", length));
			String[] otsAmt = (JSPUtil.getParameter(request, prefix	+ "ots_amt", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] revTpSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_src_cd", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OutstandingHisByDateVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (condGlIf[i] != null)
					model.setCondGlIf(condGlIf[i]);
				if (tjSrcNm[i] != null)
					model.setTjSrcNm(tjSrcNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (condDt[i] != null)
					model.setCondDt(condDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (otsRmk[i] != null)
					model.setOtsRmk(otsRmk[i]);
				if (otsOfcCd[i] != null)
					model.setOtsOfcCd(otsOfcCd[i]);
				if (otsHisTpCd[i] != null)
					model.setOtsHisTpCd(otsHisTpCd[i]);
				if (otsAmt[i] != null)
					model.setOtsAmt(otsAmt[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (revTpSrcCd[i] != null)
					model.setRevTpSrcCd(revTpSrcCd[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOutstandingHisByDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OutstandingHisByDateVO[]
	 */
	public OutstandingHisByDateVO[] getOutstandingHisByDateVOs(){
		OutstandingHisByDateVO[] vos = (OutstandingHisByDateVO[])models.toArray(new OutstandingHisByDateVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condGlIf = this.condGlIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjSrcNm = this.tjSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condDt = this.condDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk = this.otsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd = this.otsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHisTpCd = this.otsHisTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAmt = this.otsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrcCd = this.revTpSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
