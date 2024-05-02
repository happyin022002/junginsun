/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchYdChgNoDataInfoVO.java
*@FileTitle : SearchYdChgNoDataInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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

public class YdChgNoDataInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<YdChgNoDataInfoVO> models = new ArrayList<YdChgNoDataInfoVO>();
	
	/* Column Info */
	private String discount2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String regular = null;
	/* Column Info */
	private String regular2 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String surcharge2 = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String base = null;
	/* Column Info */
	private String surcharge = null;
	/* Column Info */
	private String base2 = null;
	/* Column Info */
	private String discount = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrSeq2 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String acctCd2 = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String newYdChgNo = null;
	/* Column Info */
	private String allInfo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String newYdCd = null;
	/* Column Info */
	private String vndrNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public YdChgNoDataInfoVO() {}

	public YdChgNoDataInfoVO(String ibflag, String pagerows, String acctCd, String vndrSeq, String base, String surcharge, String discount, String regular, String base2, String surcharge2, String discount2, String regular2, String vndrSeq2, String ydCd, String acctCd2, String ydChgNo, String ydChgVerSeq, String costCd, String newYdChgNo, String allInfo, String creUsrId, String updUsrId, String newYdCd, String vndrNm) {
		this.discount2  = discount2;
		this.ibflag     = ibflag;
		this.regular    = regular;
		this.regular2   = regular2;
		this.vndrSeq    = vndrSeq;
		this.vndrSeq2   = vndrSeq2;
		this.surcharge2 = surcharge2;
		this.acctCd     = acctCd;
		this.acctCd2    = acctCd2;
		this.costCd     = costCd;
		this.base = base;
		this.surcharge = surcharge;
		this.base2 = base2;
		this.discount = discount;
		this.ydCd     = ydCd;
		this.ydChgNo = ydChgNo;
		this.ydChgVerSeq = ydChgVerSeq;
		this.newYdChgNo  = newYdChgNo;
		this.creUsrId    = creUsrId;
		this.updUsrId    = updUsrId;
		this.pagerows = pagerows;
		this.allInfo  = allInfo;
		this.newYdCd  = newYdCd;
		this.vndrNm   = vndrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("discount2", getDiscount2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("regular", getRegular());
		this.hashColumns.put("regular2", getRegular2());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_seq2", getVndrSeq2());
		this.hashColumns.put("surcharge2", getSurcharge2());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("acct_cd2", getAcctCd2());
		this.hashColumns.put("base", getBase());
		this.hashColumns.put("surcharge", getSurcharge());
		this.hashColumns.put("base2", getBase2());
		this.hashColumns.put("discount", getDiscount());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("new_yd_chg_no", getNewYdChgNo());
		this.hashColumns.put("all_info", getAllInfo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("new_yd_cd", getNewYdCd());
		this.hashColumns.put("vndr_nm", getVndrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("discount2", "discount2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("regular", "regular");
		this.hashFields.put("regular2", "regular2");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_seq2", "vndrSeq2");
		this.hashFields.put("surcharge2", "surcharge2");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("acct_cd2", "acctCd2");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("base", "base");
		this.hashFields.put("surcharge", "surcharge");
		this.hashFields.put("base2", "base2");
		this.hashFields.put("discount", "discount");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("new_yd_chg_no", "newYdChgNo");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("all_info", "allInfo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("new_yd_cd", "newYdCd");
		this.hashFields.put("vndr_nm", "vndrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newYdCd
	 */
	public String getNewYdCd() {
		return this.newYdCd;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return allInfo
	 */
	public String getAllInfo() {
		return this.allInfo;
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
	 * @return discount2
	 */
	public String getDiscount2() {
		return this.discount2;
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
	 * @return regular
	 */
	public String getRegular() {
		return this.regular;
	}
	
	/**
	 * Column Info
	 * @return regular2
	 */
	public String getRegular2() {
		return this.regular2;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq2
	 */
	public String getVndrSeq2() {
		return this.vndrSeq2;
	}
	
	/**
	 * Column Info
	 * @return surcharge2
	 */
	public String getSurcharge2() {
		return this.surcharge2;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
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
	 * @return acctCd2
	 */
	public String getAcctCd2() {
		return this.acctCd2;
	}
	
	/**
	 * Column Info
	 * @return base
	 */
	public String getBase() {
		return this.base;
	}
	
	/**
	 * Column Info
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @return newYdChgNo
	 */
	public String getNewYdChgNo() {
		return this.newYdChgNo;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}
	
	/**
	 * Column Info
	 * @return surcharge
	 */
	public String getSurcharge() {
		return this.surcharge;
	}
	
	/**
	 * Column Info
	 * @return base2
	 */
	public String getBase2() {
		return this.base2;
	}
	
	/**
	 * Column Info
	 * @return discount
	 */
	public String getDiscount() {
		return this.discount;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param discount2
	 */
	public void setDiscount2(String discount2) {
		this.discount2 = discount2;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param newYdCd
	 */
	public void setNewYdCd(String newYdCd) {
		this.newYdCd = newYdCd;
	}
	
	/**
	 * Column Info
	 * @param regular
	 */
	public void setRegular(String regular) {
		this.regular = regular;
	}
	
	/**
	 * Column Info
	 * @param allInfo
	 */
	public void setAllInfo(String allInfo) {
		this.allInfo = allInfo;
	}
	
	/**
	 * Column Info
	 * @param regular2
	 */
	public void setRegular2(String regular2) {
		this.regular2 = regular2;
	}
	
	/**
	 * Column Info
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}
	
	/**
	 * Column Info
	 * @param newYdChgNo
	 */
	public void setNewYdChgNo(String newYdChgNo) {
		this.newYdChgNo = newYdChgNo;
	}
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSe2q
	 */
	public void setVndrSeq2(String vndrSeq2) {
		this.vndrSeq2 = vndrSeq2;
	}
	
	/**
	 * Column Info
	 * @param surcharge2
	 */
	public void setSurcharge2(String surcharge2) {
		this.surcharge2 = surcharge2;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	/**
	 * Column Info
	 * @param acctCd2
	 */
	public void setAcctCd2(String acctCd2) {
		this.acctCd2 = acctCd2;
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
	 * @param base
	 */
	public void setBase(String base) {
		this.base = base;
	}
	
	/**
	 * Column Info
	 * @param surcharge
	 */
	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}
	
	/**
	 * Column Info
	 * @param base2
	 */
	public void setBase2(String base2) {
		this.base2 = base2;
	}
	
	/**
	 * Column Info
	 * @param discount
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setDiscount2(JSPUtil.getParameter(request, prefix + "discount2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRegular(JSPUtil.getParameter(request, prefix + "regular", ""));
		setRegular2(JSPUtil.getParameter(request, prefix + "regular2", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrSeq2(JSPUtil.getParameter(request, prefix + "vndr_seq2", ""));
		setSurcharge2(JSPUtil.getParameter(request, prefix + "surcharge2", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setAcctCd2(JSPUtil.getParameter(request, prefix + "acct_cd2", ""));
		setBase(JSPUtil.getParameter(request, prefix + "base", ""));
		setSurcharge(JSPUtil.getParameter(request, prefix + "surcharge", ""));
		setBase2(JSPUtil.getParameter(request, prefix + "base2", ""));
		setDiscount(JSPUtil.getParameter(request, prefix + "discount", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setNewYdChgNo(JSPUtil.getParameter(request, "new_yd_chg_no", ""));
		setAllInfo(JSPUtil.getParameter(request, "all_info", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setNewYdCd(JSPUtil.getParameter(request, "new_yd_cd", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchYdChgNoDataInfoVO[]
	 */
	public YdChgNoDataInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchYdChgNoDataInfoVO[]
	 */
	public YdChgNoDataInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		YdChgNoDataInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] discount2 = (JSPUtil.getParameter(request, prefix	+ "discount2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] regular = (JSPUtil.getParameter(request, prefix	+ "regular", length));
			String[] regular2 = (JSPUtil.getParameter(request, prefix	+ "regular2", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrSeq2 = (JSPUtil.getParameter(request, prefix	+ "vndr_seq2", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] surcharge2 = (JSPUtil.getParameter(request, prefix	+ "surcharge2", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] acctCd2 = (JSPUtil.getParameter(request, prefix	+ "acct_cd2", length));
			String[] base = (JSPUtil.getParameter(request, prefix	+ "base", length));
			String[] surcharge = (JSPUtil.getParameter(request, prefix	+ "surcharge", length));
			String[] base2 = (JSPUtil.getParameter(request, prefix	+ "base2", length));
			String[] discount = (JSPUtil.getParameter(request, prefix	+ "discount", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] newYdChgNo = (JSPUtil.getParameter(request, prefix	+ "new_yd_chg_no", length));
			String[] allInfo = (JSPUtil.getParameter(request, prefix	+ "all_info", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] newYdCd = (JSPUtil.getParameter(request, prefix	+ "new_yd_cd", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new YdChgNoDataInfoVO();
				if (discount2[i] != null)
					model.setDiscount2(discount2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (regular[i] != null)
					model.setRegular(regular[i]);
				if (regular2[i] != null)
					model.setRegular2(regular2[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (vndrSeq2[i] != null)
					model.setVndrSeq2(vndrSeq2[i]);
				if (surcharge2[i] != null)
					model.setSurcharge2(surcharge2[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (acctCd2[i] != null)
					model.setAcctCd2(acctCd2[i]);
				if (base[i] != null)
					model.setBase(base[i]);
				if (surcharge[i] != null)
					model.setSurcharge(surcharge[i]);
				if (base2[i] != null)
					model.setBase2(base2[i]);
				if (discount[i] != null)
					model.setDiscount(discount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (newYdChgNo[i] != null)
					model.setNewYdChgNo(newYdChgNo[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (allInfo[i] != null)
					model.setAllInfo(allInfo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (newYdCd[i] != null)
					model.setNewYdCd(newYdCd[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getYdChgNoDataInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchYdChgNoDataInfoVO[]
	 */
	public YdChgNoDataInfoVO[] getYdChgNoDataInfoVOs(){
		YdChgNoDataInfoVO[] vos = (YdChgNoDataInfoVO[])models.toArray(new YdChgNoDataInfoVO[models.size()]);
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
		this.discount2 = this.discount2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regular = this.regular .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regular2 = this.regular2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq2 = this.vndrSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surcharge2 = this.surcharge2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd2 = this.acctCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.base = this.base .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.surcharge = this.surcharge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.base2 = this.base2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discount = this.discount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newYdChgNo = this.newYdChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allInfo = this.allInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newYdCd = this.newYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
