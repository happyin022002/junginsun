/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CHSCpsInvoiceAuditResultCmmtCrMGTVO.java
*@FileTitle : CHSCpsInvoiceAuditResultCmmtCrMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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

public class CHSCpsInvoiceAuditResultCmmtCrMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSCpsInvoiceAuditResultCmmtCrMGTVO> models = new ArrayList<CHSCpsInvoiceAuditResultCmmtCrMGTVO>();
	
	/* Column Info */
	private String intgCdValDpDesc = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cmmt45ftAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String intgCdValDesc = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String costYrmonSeq = null;
	/* Column Info */
	private String cmmtCrCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String cmmt20ftAmt = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cmmt40ftAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CHSCpsInvoiceAuditResultCmmtCrMGTVO() {}

	public CHSCpsInvoiceAuditResultCmmtCrMGTVO(String ibflag, String pagerows, String cmmtCrCd, String intgCdValDpDesc, String intgCdValDesc, String cmmt20ftAmt, String cmmt40ftAmt, String cmmt45ftAmt, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String costYrmon, String costYrmonSeq, String creOfcCd, String creUsrId, String updUsrId) {
		this.intgCdValDpDesc = intgCdValDpDesc;
		this.agmtSeq = agmtSeq;
		this.cmmt45ftAmt = cmmt45ftAmt;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.intgCdValDesc = intgCdValDesc;
		this.costYrmon = costYrmon;
		this.costYrmonSeq = costYrmonSeq;
		this.cmmtCrCd = cmmtCrCd;
		this.creOfcCd = creOfcCd;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.cmmt20ftAmt = cmmt20ftAmt;
		this.agmtVerNo = agmtVerNo;
		this.updUsrId = updUsrId;
		this.cmmt40ftAmt = cmmt40ftAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cmmt_45ft_amt", getCmmt45ftAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("intg_cd_val_desc", getIntgCdValDesc());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cost_yrmon_seq", getCostYrmonSeq());
		this.hashColumns.put("cmmt_cr_cd", getCmmtCrCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("cmmt_20ft_amt", getCmmt20ftAmt());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cmmt_40ft_amt", getCmmt40ftAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cmmt_45ft_amt", "cmmt45ftAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("intg_cd_val_desc", "intgCdValDesc");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cost_yrmon_seq", "costYrmonSeq");
		this.hashFields.put("cmmt_cr_cd", "cmmtCrCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("cmmt_20ft_amt", "cmmt20ftAmt");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cmmt_40ft_amt", "cmmt40ftAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpDesc
	 */
	public String getIntgCdValDpDesc() {
		return this.intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return cmmt45ftAmt
	 */
	public String getCmmt45ftAmt() {
		return this.cmmt45ftAmt;
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
	 * @return intgCdValDesc
	 */
	public String getIntgCdValDesc() {
		return this.intgCdValDesc;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return costYrmonSeq
	 */
	public String getCostYrmonSeq() {
		return this.costYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @return cmmtCrCd
	 */
	public String getCmmtCrCd() {
		return this.cmmtCrCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return cmmt20ftAmt
	 */
	public String getCmmt20ftAmt() {
		return this.cmmt20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
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
	 * @return cmmt40ftAmt
	 */
	public String getCmmt40ftAmt() {
		return this.cmmt40ftAmt;
	}
	

	/**
	 * Column Info
	 * @param intgCdValDpDesc
	 */
	public void setIntgCdValDpDesc(String intgCdValDpDesc) {
		this.intgCdValDpDesc = intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param cmmt45ftAmt
	 */
	public void setCmmt45ftAmt(String cmmt45ftAmt) {
		this.cmmt45ftAmt = cmmt45ftAmt;
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
	 * @param intgCdValDesc
	 */
	public void setIntgCdValDesc(String intgCdValDesc) {
		this.intgCdValDesc = intgCdValDesc;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param costYrmonSeq
	 */
	public void setCostYrmonSeq(String costYrmonSeq) {
		this.costYrmonSeq = costYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @param cmmtCrCd
	 */
	public void setCmmtCrCd(String cmmtCrCd) {
		this.cmmtCrCd = cmmtCrCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param cmmt20ftAmt
	 */
	public void setCmmt20ftAmt(String cmmt20ftAmt) {
		this.cmmt20ftAmt = cmmt20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
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
	 * @param cmmt40ftAmt
	 */
	public void setCmmt40ftAmt(String cmmt40ftAmt) {
		this.cmmt40ftAmt = cmmt40ftAmt;
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
		setIntgCdValDpDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setCmmt45ftAmt(JSPUtil.getParameter(request, prefix + "cmmt_45ft_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIntgCdValDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_desc", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setCostYrmonSeq(JSPUtil.getParameter(request, prefix + "cost_yrmon_seq", ""));
		setCmmtCrCd(JSPUtil.getParameter(request, prefix + "cmmt_cr_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
		setCmmt20ftAmt(JSPUtil.getParameter(request, prefix + "cmmt_20ft_amt", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCmmt40ftAmt(JSPUtil.getParameter(request, prefix + "cmmt_40ft_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSCpsInvoiceAuditResultCmmtCrMGTVO[]
	 */
	public CHSCpsInvoiceAuditResultCmmtCrMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSCpsInvoiceAuditResultCmmtCrMGTVO[]
	 */
	public CHSCpsInvoiceAuditResultCmmtCrMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSCpsInvoiceAuditResultCmmtCrMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_desc", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] cmmt45ftAmt = (JSPUtil.getParameter(request, prefix	+ "cmmt_45ft_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] intgCdValDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_desc", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] costYrmonSeq = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon_seq", length));
			String[] cmmtCrCd = (JSPUtil.getParameter(request, prefix	+ "cmmt_cr_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] cmmt20ftAmt = (JSPUtil.getParameter(request, prefix	+ "cmmt_20ft_amt", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cmmt40ftAmt = (JSPUtil.getParameter(request, prefix	+ "cmmt_40ft_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSCpsInvoiceAuditResultCmmtCrMGTVO();
				if (intgCdValDpDesc[i] != null)
					model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cmmt45ftAmt[i] != null)
					model.setCmmt45ftAmt(cmmt45ftAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (intgCdValDesc[i] != null)
					model.setIntgCdValDesc(intgCdValDesc[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (costYrmonSeq[i] != null)
					model.setCostYrmonSeq(costYrmonSeq[i]);
				if (cmmtCrCd[i] != null)
					model.setCmmtCrCd(cmmtCrCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (cmmt20ftAmt[i] != null)
					model.setCmmt20ftAmt(cmmt20ftAmt[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cmmt40ftAmt[i] != null)
					model.setCmmt40ftAmt(cmmt40ftAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSCpsInvoiceAuditResultCmmtCrMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSCpsInvoiceAuditResultCmmtCrMGTVO[]
	 */
	public CHSCpsInvoiceAuditResultCmmtCrMGTVO[] getCHSCpsInvoiceAuditResultCmmtCrMGTVOs(){
		CHSCpsInvoiceAuditResultCmmtCrMGTVO[] vos = (CHSCpsInvoiceAuditResultCmmtCrMGTVO[])models.toArray(new CHSCpsInvoiceAuditResultCmmtCrMGTVO[models.size()]);
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
		this.intgCdValDpDesc = this.intgCdValDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmmt45ftAmt = this.cmmt45ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDesc = this.intgCdValDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmonSeq = this.costYrmonSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmmtCrCd = this.cmmtCrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmmt20ftAmt = this.cmmt20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmmt40ftAmt = this.cmmt40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
