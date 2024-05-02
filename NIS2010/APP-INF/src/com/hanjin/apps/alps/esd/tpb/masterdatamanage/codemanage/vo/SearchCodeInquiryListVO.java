/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCodeInquiryListVO.java
*@FileTitle : SearchCodeInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.07 황건하 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 황건하
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCodeInquiryListVO extends AbstractValueObject {
	
private static final long serialVersionUID = 1L;
	
	private Collection<SearchCodeInquiryListVO> models = new ArrayList<SearchCodeInquiryListVO>();
	
	/* Column Info */
	private String cmlSysIfCd = null;
	/* Column Info */
	private String sBillingCaseCd = null;
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String n3ptyIfTpCd = null;
	/* Column Info */
	private String copExptCsCd = null;
	/* Column Info */
	private String n3ptyBilTpDesc = null;
	/* Column Info */
	private String n3ptyBilTpNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sIfType = null;
	/* Column Info */
	private String sExpenseType = null;
	/* Column Info */
	private String revAcctCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String idaSacCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCodeInquiryListVO() {}

	public SearchCodeInquiryListVO(String ibflag, String pagerows, String n3ptyIfTpCd, String n3ptyExpnTpCd, String n3ptyBilTpCd, String n3ptyBilTpNm, String n3ptyBilTpDesc, String copExptCsCd, String cmlSysIfCd, String actFlg, String creUsrId, String updUsrId, String sBillingCaseCd, String sIfType, String sExpenseType, String revAcctCd, String chgCd, String idaSacCd) {
		this.cmlSysIfCd = cmlSysIfCd;
		this.sBillingCaseCd = sBillingCaseCd;
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.n3ptyIfTpCd = n3ptyIfTpCd;
		this.copExptCsCd = copExptCsCd;
		this.n3ptyBilTpDesc = n3ptyBilTpDesc;
		this.n3ptyBilTpNm = n3ptyBilTpNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.creUsrId = creUsrId;
		this.actFlg = actFlg;
		this.updUsrId = updUsrId;
		this.sIfType = sIfType;
		this.sExpenseType = sExpenseType;
		this.revAcctCd = revAcctCd;
		this.chgCd = chgCd;
		this.idaSacCd = idaSacCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cml_sys_if_cd", getCmlSysIfCd());
		this.hashColumns.put("s_billing_case_cd", getSBillingCaseCd());
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("n3pty_if_tp_cd", getN3ptyIfTpCd());
		this.hashColumns.put("cop_expt_cs_cd", getCopExptCsCd());
		this.hashColumns.put("n3pty_bil_tp_desc", getN3ptyBilTpDesc());
		this.hashColumns.put("n3pty_bil_tp_nm", getN3ptyBilTpNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s_if_type", getSIfType());
		this.hashColumns.put("s_expense_type", getSExpenseType());
		this.hashColumns.put("rev_acct_cd", getRevAcctCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("ida_sac_cd", getIdaSacCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cml_sys_if_cd", "cmlSysIfCd");
		this.hashFields.put("s_billing_case_cd", "sBillingCaseCd");
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("n3pty_if_tp_cd", "n3ptyIfTpCd");
		this.hashFields.put("cop_expt_cs_cd", "copExptCsCd");
		this.hashFields.put("n3pty_bil_tp_desc", "n3ptyBilTpDesc");
		this.hashFields.put("n3pty_bil_tp_nm", "n3ptyBilTpNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s_if_type", "sIfType");
		this.hashFields.put("s_expense_type", "sExpenseType");
		this.hashFields.put("rev_acct_cd", "revAcctCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("ida_sac_cd", "idaSacCd");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revAcctCd
	 */
	public String getRevAcctCd() {
		return this.revAcctCd;
	}
	
	/**
	 * Column Info
	 * @return sIfType
	 */
	public String getSIfType() {
		return this.sIfType;
	}
	
	/**
	 * Column Info
	 * @return sExpenseType
	 */
	public String getSExpenseType() {
		return this.sExpenseType;
	}
	
	/**
	 * Column Info
	 * @return cmlSysIfCd
	 */
	public String getCmlSysIfCd() {
		return this.cmlSysIfCd;
	}
	
	/**
	 * Column Info
	 * @return sBillingCaseCd
	 */
	public String getSBillingCaseCd() {
		return this.sBillingCaseCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCd
	 */
	public String getN3ptyExpnTpCd() {
		return this.n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyIfTpCd
	 */
	public String getN3ptyIfTpCd() {
		return this.n3ptyIfTpCd;
	}
	
	/**
	 * Column Info
	 * @return copExptCsCd
	 */
	public String getCopExptCsCd() {
		return this.copExptCsCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpDesc
	 */
	public String getN3ptyBilTpDesc() {
		return this.n3ptyBilTpDesc;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpNm
	 */
	public String getN3ptyBilTpNm() {
		return this.n3ptyBilTpNm;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
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
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return idaSacCd
	 */
	public String getIdaSacCd() {
		return this.idaSacCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param idaSacCd
	 */
	public void setIdaSacCd(String idaSacCd) {
		this.idaSacCd = idaSacCd;
	}
	
	/**
	 * Column Info
	 * @param cmlSysIfCd
	 */
	public void setCmlSysIfCd(String cmlSysIfCd) {
		this.cmlSysIfCd = cmlSysIfCd;
	}
	
	/**
	 * Column Info
	 * @param sBillingCaseCd
	 */
	public void setSBillingCaseCd(String sBillingCaseCd) {
		this.sBillingCaseCd = sBillingCaseCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyExpnTpCd
	 */
	public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyIfTpCd
	 */
	public void setN3ptyIfTpCd(String n3ptyIfTpCd) {
		this.n3ptyIfTpCd = n3ptyIfTpCd;
	}
	
	/**
	 * Column Info
	 * @param copExptCsCd
	 */
	public void setCopExptCsCd(String copExptCsCd) {
		this.copExptCsCd = copExptCsCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpDesc
	 */
	public void setN3ptyBilTpDesc(String n3ptyBilTpDesc) {
		this.n3ptyBilTpDesc = n3ptyBilTpDesc;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpNm
	 */
	public void setN3ptyBilTpNm(String n3ptyBilTpNm) {
		this.n3ptyBilTpNm = n3ptyBilTpNm;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
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
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
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
	 * @param sIfType
	 */
	public void setSIfType(String sIfType) {
		this.sIfType = sIfType;
	}
	
	/**
	 * Column Info
	 * @param sExpenseType
	 */
	public void setSExpenseType(String sExpenseType) {
		this.sExpenseType = sExpenseType;
	}
	
	/**
	 * Column Info
	 * @param revAcctCd
	 */
	public void setRevAcctCd(String revAcctCd) {
		this.revAcctCd = revAcctCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmlSysIfCd(JSPUtil.getParameter(request, "cml_sys_if_cd", ""));
		setSBillingCaseCd(JSPUtil.getParameter(request, "s_billing_case_cd", ""));
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, "n3pty_expn_tp_cd", ""));
		setN3ptyIfTpCd(JSPUtil.getParameter(request, "n3pty_if_tp_cd", ""));
		setCopExptCsCd(JSPUtil.getParameter(request, "cop_expt_cs_cd", ""));
		setN3ptyBilTpDesc(JSPUtil.getParameter(request, "n3pty_bil_tp_desc", ""));
		setN3ptyBilTpNm(JSPUtil.getParameter(request, "n3pty_bil_tp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setActFlg(JSPUtil.getParameter(request, "act_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSIfType(JSPUtil.getParameter(request,  "s_if_type", ""));
		setSExpenseType(JSPUtil.getParameter(request, "s_expense_type", ""));
		setRevAcctCd(JSPUtil.getParameter(request,  "rev_acct_cd", ""));
		setChgCd(JSPUtil.getParameter(request,  "chg_cd", ""));
		setIdaSacCd(JSPUtil.getParameter(request,  "ida_sac_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCodeInquiryListVO[]
	 */
	public SearchCodeInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCodeInquiryListVO[]
	 */
	public SearchCodeInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCodeInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmlSysIfCd = (JSPUtil.getParameter(request, prefix	+ "cml_sys_if_cd", length));
			String[] sBillingCaseCd = (JSPUtil.getParameter(request, prefix	+ "s_billing_case_cd", length));
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] n3ptyIfTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_if_tp_cd", length));
			String[] copExptCsCd = (JSPUtil.getParameter(request, prefix	+ "cop_expt_cs_cd", length));
			String[] n3ptyBilTpDesc = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_desc", length));
			String[] n3ptyBilTpNm = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sIfType = (JSPUtil.getParameter(request, prefix	+ "s_if_type", length));
			String[] sExpenseType = (JSPUtil.getParameter(request, prefix	+ "s_expense_type", length));
			String[] revAcctCd = (JSPUtil.getParameter(request, prefix	+ "rev_acct_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] idaSacCd = (JSPUtil.getParameter(request, prefix	+ "ida_sac_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCodeInquiryListVO();
				if (cmlSysIfCd[i] != null)
					model.setCmlSysIfCd(cmlSysIfCd[i]);
				if (sBillingCaseCd[i] != null)
					model.setSBillingCaseCd(sBillingCaseCd[i]);
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (n3ptyIfTpCd[i] != null)
					model.setN3ptyIfTpCd(n3ptyIfTpCd[i]);
				if (copExptCsCd[i] != null)
					model.setCopExptCsCd(copExptCsCd[i]);
				if (n3ptyBilTpDesc[i] != null)
					model.setN3ptyBilTpDesc(n3ptyBilTpDesc[i]);
				if (n3ptyBilTpNm[i] != null)
					model.setN3ptyBilTpNm(n3ptyBilTpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sIfType[i] != null)
					model.setSIfType(sIfType[i]);
				if (sExpenseType[i] != null)
					model.setSExpenseType(sExpenseType[i]);
				if (revAcctCd[i] != null)
					model.setRevAcctCd(revAcctCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (idaSacCd[i] != null)
					model.setIdaSacCd(idaSacCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCodeInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCodeInquiryListVO[]
	 */
	public SearchCodeInquiryListVO[] getSearchCodeInquiryListVOs(){
		SearchCodeInquiryListVO[] vos = (SearchCodeInquiryListVO[])models.toArray(new SearchCodeInquiryListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cmlSysIfCd = this.cmlSysIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBillingCaseCd = this.sBillingCaseCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyIfTpCd = this.n3ptyIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copExptCsCd = this.copExptCsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpDesc = this.n3ptyBilTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpNm = this.n3ptyBilTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sIfType = this.sIfType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpenseType = this.sExpenseType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAcctCd = this.revAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacCd = this.idaSacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
