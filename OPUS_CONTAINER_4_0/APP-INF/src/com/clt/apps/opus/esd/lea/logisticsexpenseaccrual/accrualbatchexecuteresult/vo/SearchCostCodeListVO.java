/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCostCodeListVO.java
*@FileTitle : SearchCostCodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전재홍
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCostCodeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCostCodeListVO> models = new ArrayList<SearchCostCodeListVO>();
	
	/* Column Info */
	private String repAcctCd = null;
	/* Column Info */
	private String acclLgcTpCd = null;
	/* Column Info */
	private String acclAutoNm = null;
	/* Column Info */
	private String otrCrrAcctCd = null;
	/* Column Info */
	private String costSrcSysCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subCostTpNm = null;
	/* Column Info */
	private String frmAcclTypeCd = null;
	/* Column Info */
	private String mnCostTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acclAutoCd = null;
	/* Column Info */
	private String estmCostFlg = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String subCostTpCd = null;
	/* Column Info */
	private String frmAcctCd = null;
	/* Column Info */
	private String frmCostCd = null;
	/* Column Info */
	private String acctCdNm = null;
	/* Column Info */
	private String lgsCostFullNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCostCodeListVO() {}

	public SearchCostCodeListVO(String ibflag, String pagerows, String mnCostTpCd, String subCostTpCd, String subCostTpNm, String lgsCostCd, String lgsCostFullNm, String acctCd, String acctCdNm, String repAcctCd, String otrCrrAcctCd, String acclAutoCd, String acclAutoNm, String acclLgcTpCd, String estmCostFlg, String costSrcSysCd, String frmCostCd, String frmAcctCd, String frmAcclTypeCd) {
		this.repAcctCd = repAcctCd;
		this.acclLgcTpCd = acclLgcTpCd;
		this.acclAutoNm = acclAutoNm;
		this.otrCrrAcctCd = otrCrrAcctCd;
		this.costSrcSysCd = costSrcSysCd;
		this.pagerows = pagerows;
		this.subCostTpNm = subCostTpNm;
		this.frmAcclTypeCd = frmAcclTypeCd;
		this.mnCostTpCd = mnCostTpCd;
		this.ibflag = ibflag;
		this.acclAutoCd = acclAutoCd;
		this.estmCostFlg = estmCostFlg;
		this.lgsCostCd = lgsCostCd;
		this.acctCd = acctCd;
		this.subCostTpCd = subCostTpCd;
		this.frmAcctCd = frmAcctCd;
		this.frmCostCd = frmCostCd;
		this.acctCdNm = acctCdNm;
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_acct_cd", getRepAcctCd());
		this.hashColumns.put("accl_lgc_tp_cd", getAcclLgcTpCd());
		this.hashColumns.put("accl_auto_nm", getAcclAutoNm());
		this.hashColumns.put("otr_crr_acct_cd", getOtrCrrAcctCd());
		this.hashColumns.put("cost_src_sys_cd", getCostSrcSysCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sub_cost_tp_nm", getSubCostTpNm());
		this.hashColumns.put("frm_accl_type_cd", getFrmAcclTypeCd());
		this.hashColumns.put("mn_cost_tp_cd", getMnCostTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("accl_auto_cd", getAcclAutoCd());
		this.hashColumns.put("estm_cost_flg", getEstmCostFlg());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("sub_cost_tp_cd", getSubCostTpCd());
		this.hashColumns.put("frm_acct_cd", getFrmAcctCd());
		this.hashColumns.put("frm_cost_cd", getFrmCostCd());
		this.hashColumns.put("acct_cd_nm", getAcctCdNm());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rep_acct_cd", "repAcctCd");
		this.hashFields.put("accl_lgc_tp_cd", "acclLgcTpCd");
		this.hashFields.put("accl_auto_nm", "acclAutoNm");
		this.hashFields.put("otr_crr_acct_cd", "otrCrrAcctCd");
		this.hashFields.put("cost_src_sys_cd", "costSrcSysCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sub_cost_tp_nm", "subCostTpNm");
		this.hashFields.put("frm_accl_type_cd", "frmAcclTypeCd");
		this.hashFields.put("mn_cost_tp_cd", "mnCostTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("accl_auto_cd", "acclAutoCd");
		this.hashFields.put("estm_cost_flg", "estmCostFlg");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("sub_cost_tp_cd", "subCostTpCd");
		this.hashFields.put("frm_acct_cd", "frmAcctCd");
		this.hashFields.put("frm_cost_cd", "frmCostCd");
		this.hashFields.put("acct_cd_nm", "acctCdNm");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repAcctCd
	 */
	public String getRepAcctCd() {
		return this.repAcctCd;
	}
	
	/**
	 * Column Info
	 * @return acclLgcTpCd
	 */
	public String getAcclLgcTpCd() {
		return this.acclLgcTpCd;
	}
	
	/**
	 * Column Info
	 * @return acclAutoNm
	 */
	public String getAcclAutoNm() {
		return this.acclAutoNm;
	}
	
	/**
	 * Column Info
	 * @return otrCrrAcctCd
	 */
	public String getOtrCrrAcctCd() {
		return this.otrCrrAcctCd;
	}
	
	/**
	 * Column Info
	 * @return costSrcSysCd
	 */
	public String getCostSrcSysCd() {
		return this.costSrcSysCd;
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
	 * @return subCostTpNm
	 */
	public String getSubCostTpNm() {
		return this.subCostTpNm;
	}
	
	/**
	 * Column Info
	 * @return frmAcclTypeCd
	 */
	public String getFrmAcclTypeCd() {
		return this.frmAcclTypeCd;
	}
	
	/**
	 * Column Info
	 * @return mnCostTpCd
	 */
	public String getMnCostTpCd() {
		return this.mnCostTpCd;
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
	 * @return acclAutoCd
	 */
	public String getAcclAutoCd() {
		return this.acclAutoCd;
	}
	
	/**
	 * Column Info
	 * @return estmCostFlg
	 */
	public String getEstmCostFlg() {
		return this.estmCostFlg;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
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
	 * @return subCostTpCd
	 */
	public String getSubCostTpCd() {
		return this.subCostTpCd;
	}
	
	/**
	 * Column Info
	 * @return frmAcctCd
	 */
	public String getFrmAcctCd() {
		return this.frmAcctCd;
	}
	
	/**
	 * Column Info
	 * @return frmCostCd
	 */
	public String getFrmCostCd() {
		return this.frmCostCd;
	}
	
	/**
	 * Column Info
	 * @return acctCdNm
	 */
	public String getAcctCdNm() {
		return this.acctCdNm;
	}
	
	/**
	 * Column Info
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
	}
	

	/**
	 * Column Info
	 * @param repAcctCd
	 */
	public void setRepAcctCd(String repAcctCd) {
		this.repAcctCd = repAcctCd;
	}
	
	/**
	 * Column Info
	 * @param acclLgcTpCd
	 */
	public void setAcclLgcTpCd(String acclLgcTpCd) {
		this.acclLgcTpCd = acclLgcTpCd;
	}
	
	/**
	 * Column Info
	 * @param acclAutoNm
	 */
	public void setAcclAutoNm(String acclAutoNm) {
		this.acclAutoNm = acclAutoNm;
	}
	
	/**
	 * Column Info
	 * @param otrCrrAcctCd
	 */
	public void setOtrCrrAcctCd(String otrCrrAcctCd) {
		this.otrCrrAcctCd = otrCrrAcctCd;
	}
	
	/**
	 * Column Info
	 * @param costSrcSysCd
	 */
	public void setCostSrcSysCd(String costSrcSysCd) {
		this.costSrcSysCd = costSrcSysCd;
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
	 * @param subCostTpNm
	 */
	public void setSubCostTpNm(String subCostTpNm) {
		this.subCostTpNm = subCostTpNm;
	}
	
	/**
	 * Column Info
	 * @param frmAcclTypeCd
	 */
	public void setFrmAcclTypeCd(String frmAcclTypeCd) {
		this.frmAcclTypeCd = frmAcclTypeCd;
	}
	
	/**
	 * Column Info
	 * @param mnCostTpCd
	 */
	public void setMnCostTpCd(String mnCostTpCd) {
		this.mnCostTpCd = mnCostTpCd;
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
	 * @param acclAutoCd
	 */
	public void setAcclAutoCd(String acclAutoCd) {
		this.acclAutoCd = acclAutoCd;
	}
	
	/**
	 * Column Info
	 * @param estmCostFlg
	 */
	public void setEstmCostFlg(String estmCostFlg) {
		this.estmCostFlg = estmCostFlg;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
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
	 * @param subCostTpCd
	 */
	public void setSubCostTpCd(String subCostTpCd) {
		this.subCostTpCd = subCostTpCd;
	}
	
	/**
	 * Column Info
	 * @param frmAcctCd
	 */
	public void setFrmAcctCd(String frmAcctCd) {
		this.frmAcctCd = frmAcctCd;
	}
	
	/**
	 * Column Info
	 * @param frmCostCd
	 */
	public void setFrmCostCd(String frmCostCd) {
		this.frmCostCd = frmCostCd;
	}
	
	/**
	 * Column Info
	 * @param acctCdNm
	 */
	public void setAcctCdNm(String acctCdNm) {
		this.acctCdNm = acctCdNm;
	}
	
	/**
	 * Column Info
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepAcctCd(JSPUtil.getParameter(request, "rep_acct_cd", ""));
		setAcclLgcTpCd(JSPUtil.getParameter(request, "accl_lgc_tp_cd", ""));
		setAcclAutoNm(JSPUtil.getParameter(request, "accl_auto_nm", ""));
		setOtrCrrAcctCd(JSPUtil.getParameter(request, "otr_crr_acct_cd", ""));
		setCostSrcSysCd(JSPUtil.getParameter(request, "cost_src_sys_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSubCostTpNm(JSPUtil.getParameter(request, "sub_cost_tp_nm", ""));
		setFrmAcclTypeCd(JSPUtil.getParameter(request, "frm_accl_type_cd", ""));
		setMnCostTpCd(JSPUtil.getParameter(request, "mn_cost_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcclAutoCd(JSPUtil.getParameter(request, "accl_auto_cd", ""));
		setEstmCostFlg(JSPUtil.getParameter(request, "estm_cost_flg", ""));
		setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setSubCostTpCd(JSPUtil.getParameter(request, "sub_cost_tp_cd", ""));
		setFrmAcctCd(JSPUtil.getParameter(request, "frm_acct_cd", ""));
		setFrmCostCd(JSPUtil.getParameter(request, "frm_cost_cd", ""));
		setAcctCdNm(JSPUtil.getParameter(request, "acct_cd_nm", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, "lgs_cost_full_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCostCodeListVO[]
	 */
	public SearchCostCodeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCostCodeListVO[]
	 */
	public SearchCostCodeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCostCodeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repAcctCd = (JSPUtil.getParameter(request, prefix	+ "rep_acct_cd", length));
			String[] acclLgcTpCd = (JSPUtil.getParameter(request, prefix	+ "accl_lgc_tp_cd", length));
			String[] acclAutoNm = (JSPUtil.getParameter(request, prefix	+ "accl_auto_nm", length));
			String[] otrCrrAcctCd = (JSPUtil.getParameter(request, prefix	+ "otr_crr_acct_cd", length));
			String[] costSrcSysCd = (JSPUtil.getParameter(request, prefix	+ "cost_src_sys_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subCostTpNm = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_nm", length));
			String[] frmAcclTypeCd = (JSPUtil.getParameter(request, prefix	+ "frm_accl_type_cd", length));
			String[] mnCostTpCd = (JSPUtil.getParameter(request, prefix	+ "mn_cost_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acclAutoCd = (JSPUtil.getParameter(request, prefix	+ "accl_auto_cd", length));
			String[] estmCostFlg = (JSPUtil.getParameter(request, prefix	+ "estm_cost_flg", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] subCostTpCd = (JSPUtil.getParameter(request, prefix	+ "sub_cost_tp_cd", length));
			String[] frmAcctCd = (JSPUtil.getParameter(request, prefix	+ "frm_acct_cd", length));
			String[] frmCostCd = (JSPUtil.getParameter(request, prefix	+ "frm_cost_cd", length));
			String[] acctCdNm = (JSPUtil.getParameter(request, prefix	+ "acct_cd_nm", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCostCodeListVO();
				if (repAcctCd[i] != null)
					model.setRepAcctCd(repAcctCd[i]);
				if (acclLgcTpCd[i] != null)
					model.setAcclLgcTpCd(acclLgcTpCd[i]);
				if (acclAutoNm[i] != null)
					model.setAcclAutoNm(acclAutoNm[i]);
				if (otrCrrAcctCd[i] != null)
					model.setOtrCrrAcctCd(otrCrrAcctCd[i]);
				if (costSrcSysCd[i] != null)
					model.setCostSrcSysCd(costSrcSysCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subCostTpNm[i] != null)
					model.setSubCostTpNm(subCostTpNm[i]);
				if (frmAcclTypeCd[i] != null)
					model.setFrmAcclTypeCd(frmAcclTypeCd[i]);
				if (mnCostTpCd[i] != null)
					model.setMnCostTpCd(mnCostTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acclAutoCd[i] != null)
					model.setAcclAutoCd(acclAutoCd[i]);
				if (estmCostFlg[i] != null)
					model.setEstmCostFlg(estmCostFlg[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (subCostTpCd[i] != null)
					model.setSubCostTpCd(subCostTpCd[i]);
				if (frmAcctCd[i] != null)
					model.setFrmAcctCd(frmAcctCd[i]);
				if (frmCostCd[i] != null)
					model.setFrmCostCd(frmCostCd[i]);
				if (acctCdNm[i] != null)
					model.setAcctCdNm(acctCdNm[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCostCodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCostCodeListVO[]
	 */
	public SearchCostCodeListVO[] getSearchCostCodeListVOs(){
		SearchCostCodeListVO[] vos = (SearchCostCodeListVO[])models.toArray(new SearchCostCodeListVO[models.size()]);
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
		this.repAcctCd = this.repAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclLgcTpCd = this.acclLgcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAutoNm = this.acclAutoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrCrrAcctCd = this.otrCrrAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcSysCd = this.costSrcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpNm = this.subCostTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmAcclTypeCd = this.frmAcclTypeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnCostTpCd = this.mnCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAutoCd = this.acclAutoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCostFlg = this.estmCostFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subCostTpCd = this.subCostTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmAcctCd = this.frmAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmCostCd = this.frmCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCdNm = this.acctCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
