/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BrogApPayInvDtlVO.java
*@FileTitle : BrogApPayInvDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.14 이정수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo;

import java.lang.reflect.Field;
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
 * @author 이정수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrogApPayInvDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrogApPayInvDtlVO> models = new ArrayList<BrogApPayInvDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String skdVoyCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String invDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String so20ftQty = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String so40ftQty = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String actVvdCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrogApPayInvDtlVO() {}

	public BrogApPayInvDtlVO(String ibflag, String pagerows, String acctCd, String vslCd, String skdVoyCd, String skdDirCd, String revDirCd, String actVvdCd, String ydCd, String cntrTpszCd, String invAmt, String so20ftQty, String so40ftQty, String creUsrId, String creDt, String updUsrId, String updDt, String invDesc) {
		this.updDt = updDt;
		this.vslCd = vslCd;
		this.creDt = creDt;
		this.skdVoyCd = skdVoyCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.invDesc = invDesc;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.so20ftQty = so20ftQty;
		this.ydCd = ydCd;
		this.acctCd = acctCd;
		this.cntrTpszCd = cntrTpszCd;
		this.so40ftQty = so40ftQty;
		this.invAmt = invAmt;
		this.actVvdCd = actVvdCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("skd_voy_cd", getSkdVoyCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("so_20ft_qty", getSo20ftQty());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("so_40ft_qty", getSo40ftQty());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("act_vvd_cd", getActVvdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("skd_voy_cd", "skdVoyCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("so_20ft_qty", "so20ftQty");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("so_40ft_qty", "so40ftQty");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("act_vvd_cd", "actVvdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return skdVoyCd
	 */
	public String getSkdVoyCd() {
		return this.skdVoyCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return invDesc
	 */
	public String getInvDesc() {
		return this.invDesc;
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
	 * @return so20ftQty
	 */
	public String getSo20ftQty() {
		return this.so20ftQty;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return so40ftQty
	 */
	public String getSo40ftQty() {
		return this.so40ftQty;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return actVvdCd
	 */
	public String getActVvdCd() {
		return this.actVvdCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param skdVoyCd
	 */
	public void setSkdVoyCd(String skdVoyCd) {
		this.skdVoyCd = skdVoyCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
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
	 * @param so20ftQty
	 */
	public void setSo20ftQty(String so20ftQty) {
		this.so20ftQty = so20ftQty;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param so40ftQty
	 */
	public void setSo40ftQty(String so40ftQty) {
		this.so40ftQty = so40ftQty;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param actVvdCd
	 */
	public void setActVvdCd(String actVvdCd) {
		this.actVvdCd = actVvdCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSkdVoyCd(JSPUtil.getParameter(request, prefix + "skd_voy_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setInvDesc(JSPUtil.getParameter(request, prefix + "inv_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSo20ftQty(JSPUtil.getParameter(request, prefix + "so_20ft_qty", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setSo40ftQty(JSPUtil.getParameter(request, prefix + "so_40ft_qty", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setActVvdCd(JSPUtil.getParameter(request, prefix + "act_vvd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrogApPayInvDtlVO[]
	 */
	public BrogApPayInvDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrogApPayInvDtlVO[]
	 */
	public BrogApPayInvDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrogApPayInvDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] skdVoyCd = (JSPUtil.getParameter(request, prefix	+ "skd_voy_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] so20ftQty = (JSPUtil.getParameter(request, prefix	+ "so_20ft_qty", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] so40ftQty = (JSPUtil.getParameter(request, prefix	+ "so_40ft_qty", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] actVvdCd = (JSPUtil.getParameter(request, prefix	+ "act_vvd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrogApPayInvDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (skdVoyCd[i] != null)
					model.setSkdVoyCd(skdVoyCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (so20ftQty[i] != null)
					model.setSo20ftQty(so20ftQty[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (so40ftQty[i] != null)
					model.setSo40ftQty(so40ftQty[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (actVvdCd[i] != null)
					model.setActVvdCd(actVvdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrogApPayInvDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrogApPayInvDtlVO[]
	 */
	public BrogApPayInvDtlVO[] getBrogApPayInvDtlVOs(){
		BrogApPayInvDtlVO[] vos = (BrogApPayInvDtlVO[])models.toArray(new BrogApPayInvDtlVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyCd = this.skdVoyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.so20ftQty = this.so20ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.so40ftQty = this.so40ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actVvdCd = this.actVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
