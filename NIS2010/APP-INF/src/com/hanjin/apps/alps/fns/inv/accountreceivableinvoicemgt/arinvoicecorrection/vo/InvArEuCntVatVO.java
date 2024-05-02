/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvArEuCntVatVO.java
*@FileTitle : InvArEuCntVatVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.30
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.03.30 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArEuCntVatVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArEuCntVatVO> models = new ArrayList<InvArEuCntVatVO>();
	
	/* Column Info */
	private String invEuroVatRt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String invEuroVatEndDt = null;
	/* Column Info */
	private String invEuCntSeq = null;
	/* Column Info */
	private String invEuroVatStDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArEuCntVatVO() {}

	public InvArEuCntVatVO(String ibflag, String pagerows, String cntCd, String invEuCntSeq, String invEuroVatRt, String invEuroVatStDt, String invEuroVatEndDt, String deltFlg, String deltDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.invEuroVatRt = invEuroVatRt;
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.deltDt = deltDt;
		this.invEuroVatEndDt = invEuroVatEndDt;
		this.invEuCntSeq = invEuCntSeq;
		this.invEuroVatStDt = invEuroVatStDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntCd = cntCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_euro_vat_rt", getInvEuroVatRt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("inv_euro_vat_end_dt", getInvEuroVatEndDt());
		this.hashColumns.put("inv_eu_cnt_seq", getInvEuCntSeq());
		this.hashColumns.put("inv_euro_vat_st_dt", getInvEuroVatStDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_euro_vat_rt", "invEuroVatRt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("inv_euro_vat_end_dt", "invEuroVatEndDt");
		this.hashFields.put("inv_eu_cnt_seq", "invEuCntSeq");
		this.hashFields.put("inv_euro_vat_st_dt", "invEuroVatStDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invEuroVatRt
	 */
	public String getInvEuroVatRt() {
		return this.invEuroVatRt;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return invEuroVatEndDt
	 */
	public String getInvEuroVatEndDt() {
		return this.invEuroVatEndDt;
	}
	
	/**
	 * Column Info
	 * @return invEuCntSeq
	 */
	public String getInvEuCntSeq() {
		return this.invEuCntSeq;
	}
	
	/**
	 * Column Info
	 * @return invEuroVatStDt
	 */
	public String getInvEuroVatStDt() {
		return this.invEuroVatStDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param invEuroVatRt
	 */
	public void setInvEuroVatRt(String invEuroVatRt) {
		this.invEuroVatRt = invEuroVatRt;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param invEuroVatEndDt
	 */
	public void setInvEuroVatEndDt(String invEuroVatEndDt) {
		this.invEuroVatEndDt = invEuroVatEndDt;
	}
	
	/**
	 * Column Info
	 * @param invEuCntSeq
	 */
	public void setInvEuCntSeq(String invEuCntSeq) {
		this.invEuCntSeq = invEuCntSeq;
	}
	
	/**
	 * Column Info
	 * @param invEuroVatStDt
	 */
	public void setInvEuroVatStDt(String invEuroVatStDt) {
		this.invEuroVatStDt = invEuroVatStDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
		setInvEuroVatRt(JSPUtil.getParameter(request, prefix + "inv_euro_vat_rt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setInvEuroVatEndDt(JSPUtil.getParameter(request, prefix + "inv_euro_vat_end_dt", ""));
		setInvEuCntSeq(JSPUtil.getParameter(request, prefix + "inv_eu_cnt_seq", ""));
		setInvEuroVatStDt(JSPUtil.getParameter(request, prefix + "inv_euro_vat_st_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArEuCntVatVO[]
	 */
	public InvArEuCntVatVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArEuCntVatVO[]
	 */
	public InvArEuCntVatVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArEuCntVatVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invEuroVatRt = (JSPUtil.getParameter(request, prefix	+ "inv_euro_vat_rt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] invEuroVatEndDt = (JSPUtil.getParameter(request, prefix	+ "inv_euro_vat_end_dt", length));
			String[] invEuCntSeq = (JSPUtil.getParameter(request, prefix	+ "inv_eu_cnt_seq", length));
			String[] invEuroVatStDt = (JSPUtil.getParameter(request, prefix	+ "inv_euro_vat_st_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArEuCntVatVO();
				if (invEuroVatRt[i] != null)
					model.setInvEuroVatRt(invEuroVatRt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (invEuroVatEndDt[i] != null)
					model.setInvEuroVatEndDt(invEuroVatEndDt[i]);
				if (invEuCntSeq[i] != null)
					model.setInvEuCntSeq(invEuCntSeq[i]);
				if (invEuroVatStDt[i] != null)
					model.setInvEuroVatStDt(invEuroVatStDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArEuCntVatVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArEuCntVatVO[]
	 */
	public InvArEuCntVatVO[] getInvArEuCntVatVOs(){
		InvArEuCntVatVO[] vos = (InvArEuCntVatVO[])models.toArray(new InvArEuCntVatVO[models.size()]);
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
		this.invEuroVatRt = this.invEuroVatRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEuroVatEndDt = this.invEuroVatEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEuCntSeq = this.invEuCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEuroVatStDt = this.invEuroVatStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
