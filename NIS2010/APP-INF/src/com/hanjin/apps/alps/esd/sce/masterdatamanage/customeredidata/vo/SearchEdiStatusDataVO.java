/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEdiStatusDataVO.java
*@FileTitle : SearchEdiStatusDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.04 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEdiStatusDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEdiStatusDataVO> models = new ArrayList<SearchEdiStatusDataVO>();
	
	/* Column Info */
	private String ediCntrSndTpCd = null;
	/* Column Info */
	private String ediGrpDesc = null;
	/* Column Info */
	private String ediVslTpCd = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String custEdiStsCd = null;
	/* Column Info */
	private String ediSndItvalHrmnt = null;
	/* Column Info */
	private String ediDestTpCd = null;
	/* Column Info */
	private String provTrdPrnrId = null;
	/* Column Info */
	private String ediStndStsCd = null;
	/* Column Info */
	private String ediStsDesc = null;
	/* Column Info */
	private String ediEvntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rownum = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediOrgTpCd = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String ediSndFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEdiStatusDataVO() {}

	public SearchEdiStatusDataVO(String ibflag, String pagerows, String rownum, String ediGrpCd, String ediGrpDesc, String custTrdPrnrId, String provTrdPrnrId, String ediStndStsCd, String ediStsDesc, String ediSndFlg, String ediOrgTpCd, String ediDestTpCd, String ediVslTpCd, String ediEvntCd, String ediSndItvalHrmnt, String ediCntrSndTpCd, String custEdiStsCd) {
		this.ediCntrSndTpCd = ediCntrSndTpCd;
		this.ediGrpDesc = ediGrpDesc;
		this.ediVslTpCd = ediVslTpCd;
		this.ediGrpCd = ediGrpCd;
		this.custEdiStsCd = custEdiStsCd;
		this.ediSndItvalHrmnt = ediSndItvalHrmnt;
		this.ediDestTpCd = ediDestTpCd;
		this.provTrdPrnrId = provTrdPrnrId;
		this.ediStndStsCd = ediStndStsCd;
		this.ediStsDesc = ediStsDesc;
		this.ediEvntCd = ediEvntCd;
		this.pagerows = pagerows;
		this.rownum = rownum;
		this.ibflag = ibflag;
		this.ediOrgTpCd = ediOrgTpCd;
		this.custTrdPrnrId = custTrdPrnrId;
		this.ediSndFlg = ediSndFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_cntr_snd_tp_cd", getEdiCntrSndTpCd());
		this.hashColumns.put("edi_grp_desc", getEdiGrpDesc());
		this.hashColumns.put("edi_vsl_tp_cd", getEdiVslTpCd());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("cust_edi_sts_cd", getCustEdiStsCd());
		this.hashColumns.put("edi_snd_itval_hrmnt", getEdiSndItvalHrmnt());
		this.hashColumns.put("edi_dest_tp_cd", getEdiDestTpCd());
		this.hashColumns.put("prov_trd_prnr_id", getProvTrdPrnrId());
		this.hashColumns.put("edi_stnd_sts_cd", getEdiStndStsCd());
		this.hashColumns.put("edi_sts_desc", getEdiStsDesc());
		this.hashColumns.put("edi_evnt_cd", getEdiEvntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rownum", getRownum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_org_tp_cd", getEdiOrgTpCd());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_cntr_snd_tp_cd", "ediCntrSndTpCd");
		this.hashFields.put("edi_grp_desc", "ediGrpDesc");
		this.hashFields.put("edi_vsl_tp_cd", "ediVslTpCd");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("cust_edi_sts_cd", "custEdiStsCd");
		this.hashFields.put("edi_snd_itval_hrmnt", "ediSndItvalHrmnt");
		this.hashFields.put("edi_dest_tp_cd", "ediDestTpCd");
		this.hashFields.put("prov_trd_prnr_id", "provTrdPrnrId");
		this.hashFields.put("edi_stnd_sts_cd", "ediStndStsCd");
		this.hashFields.put("edi_sts_desc", "ediStsDesc");
		this.hashFields.put("edi_evnt_cd", "ediEvntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rownum", "rownum");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_org_tp_cd", "ediOrgTpCd");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ediCntrSndTpCd
	 */
	public String getEdiCntrSndTpCd() {
		return this.ediCntrSndTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediGrpDesc
	 */
	public String getEdiGrpDesc() {
		return this.ediGrpDesc;
	}
	
	/**
	 * Column Info
	 * @return ediVslTpCd
	 */
	public String getEdiVslTpCd() {
		return this.ediVslTpCd;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return custEdiStsCd
	 */
	public String getCustEdiStsCd() {
		return this.custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndItvalHrmnt
	 */
	public String getEdiSndItvalHrmnt() {
		return this.ediSndItvalHrmnt;
	}
	
	/**
	 * Column Info
	 * @return ediDestTpCd
	 */
	public String getEdiDestTpCd() {
		return this.ediDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return provTrdPrnrId
	 */
	public String getProvTrdPrnrId() {
		return this.provTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return ediStndStsCd
	 */
	public String getEdiStndStsCd() {
		return this.ediStndStsCd;
	}
	
	/**
	 * Column Info
	 * @return ediStsDesc
	 */
	public String getEdiStsDesc() {
		return this.ediStsDesc;
	}
	
	/**
	 * Column Info
	 * @return ediEvntCd
	 */
	public String getEdiEvntCd() {
		return this.ediEvntCd;
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
	 * @return rownum
	 */
	public String getRownum() {
		return this.rownum;
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
	 * @return ediOrgTpCd
	 */
	public String getEdiOrgTpCd() {
		return this.ediOrgTpCd;
	}
	
	/**
	 * Column Info
	 * @return custTrdPrnrId
	 */
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return ediSndFlg
	 */
	public String getEdiSndFlg() {
		return this.ediSndFlg;
	}
	

	/**
	 * Column Info
	 * @param ediCntrSndTpCd
	 */
	public void setEdiCntrSndTpCd(String ediCntrSndTpCd) {
		this.ediCntrSndTpCd = ediCntrSndTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediGrpDesc
	 */
	public void setEdiGrpDesc(String ediGrpDesc) {
		this.ediGrpDesc = ediGrpDesc;
	}
	
	/**
	 * Column Info
	 * @param ediVslTpCd
	 */
	public void setEdiVslTpCd(String ediVslTpCd) {
		this.ediVslTpCd = ediVslTpCd;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param custEdiStsCd
	 */
	public void setCustEdiStsCd(String custEdiStsCd) {
		this.custEdiStsCd = custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndItvalHrmnt
	 */
	public void setEdiSndItvalHrmnt(String ediSndItvalHrmnt) {
		this.ediSndItvalHrmnt = ediSndItvalHrmnt;
	}
	
	/**
	 * Column Info
	 * @param ediDestTpCd
	 */
	public void setEdiDestTpCd(String ediDestTpCd) {
		this.ediDestTpCd = ediDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param provTrdPrnrId
	 */
	public void setProvTrdPrnrId(String provTrdPrnrId) {
		this.provTrdPrnrId = provTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param ediStndStsCd
	 */
	public void setEdiStndStsCd(String ediStndStsCd) {
		this.ediStndStsCd = ediStndStsCd;
	}
	
	/**
	 * Column Info
	 * @param ediStsDesc
	 */
	public void setEdiStsDesc(String ediStsDesc) {
		this.ediStsDesc = ediStsDesc;
	}
	
	/**
	 * Column Info
	 * @param ediEvntCd
	 */
	public void setEdiEvntCd(String ediEvntCd) {
		this.ediEvntCd = ediEvntCd;
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
	 * @param rownum
	 */
	public void setRownum(String rownum) {
		this.rownum = rownum;
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
	 * @param ediOrgTpCd
	 */
	public void setEdiOrgTpCd(String ediOrgTpCd) {
		this.ediOrgTpCd = ediOrgTpCd;
	}
	
	/**
	 * Column Info
	 * @param custTrdPrnrId
	 */
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param ediSndFlg
	 */
	public void setEdiSndFlg(String ediSndFlg) {
		this.ediSndFlg = ediSndFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEdiCntrSndTpCd(JSPUtil.getParameter(request, "edi_cntr_snd_tp_cd", ""));
		setEdiGrpDesc(JSPUtil.getParameter(request, "edi_grp_desc", ""));
		setEdiVslTpCd(JSPUtil.getParameter(request, "edi_vsl_tp_cd", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
		setCustEdiStsCd(JSPUtil.getParameter(request, "cust_edi_sts_cd", ""));
		setEdiSndItvalHrmnt(JSPUtil.getParameter(request, "edi_snd_itval_hrmnt", ""));
		setEdiDestTpCd(JSPUtil.getParameter(request, "edi_dest_tp_cd", ""));
		setProvTrdPrnrId(JSPUtil.getParameter(request, "prov_trd_prnr_id", ""));
		setEdiStndStsCd(JSPUtil.getParameter(request, "edi_stnd_sts_cd", ""));
		setEdiStsDesc(JSPUtil.getParameter(request, "edi_sts_desc", ""));
		setEdiEvntCd(JSPUtil.getParameter(request, "edi_evnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRownum(JSPUtil.getParameter(request, "rownum", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiOrgTpCd(JSPUtil.getParameter(request, "edi_org_tp_cd", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, "cust_trd_prnr_id", ""));
		setEdiSndFlg(JSPUtil.getParameter(request, "edi_snd_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEdiStatusDataVO[]
	 */
	public SearchEdiStatusDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEdiStatusDataVO[]
	 */
	public SearchEdiStatusDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEdiStatusDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediCntrSndTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_cntr_snd_tp_cd", length));
			String[] ediGrpDesc = (JSPUtil.getParameter(request, prefix	+ "edi_grp_desc", length));
			String[] ediVslTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_vsl_tp_cd", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] custEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_edi_sts_cd", length));
			String[] ediSndItvalHrmnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_itval_hrmnt", length));
			String[] ediDestTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_dest_tp_cd", length));
			String[] provTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "prov_trd_prnr_id", length));
			String[] ediStndStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_stnd_sts_cd", length));
			String[] ediStsDesc = (JSPUtil.getParameter(request, prefix	+ "edi_sts_desc", length));
			String[] ediEvntCd = (JSPUtil.getParameter(request, prefix	+ "edi_evnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rownum = (JSPUtil.getParameter(request, prefix	+ "rownum", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediOrgTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_org_tp_cd", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] ediSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEdiStatusDataVO();
				if (ediCntrSndTpCd[i] != null)
					model.setEdiCntrSndTpCd(ediCntrSndTpCd[i]);
				if (ediGrpDesc[i] != null)
					model.setEdiGrpDesc(ediGrpDesc[i]);
				if (ediVslTpCd[i] != null)
					model.setEdiVslTpCd(ediVslTpCd[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (custEdiStsCd[i] != null)
					model.setCustEdiStsCd(custEdiStsCd[i]);
				if (ediSndItvalHrmnt[i] != null)
					model.setEdiSndItvalHrmnt(ediSndItvalHrmnt[i]);
				if (ediDestTpCd[i] != null)
					model.setEdiDestTpCd(ediDestTpCd[i]);
				if (provTrdPrnrId[i] != null)
					model.setProvTrdPrnrId(provTrdPrnrId[i]);
				if (ediStndStsCd[i] != null)
					model.setEdiStndStsCd(ediStndStsCd[i]);
				if (ediStsDesc[i] != null)
					model.setEdiStsDesc(ediStsDesc[i]);
				if (ediEvntCd[i] != null)
					model.setEdiEvntCd(ediEvntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rownum[i] != null)
					model.setRownum(rownum[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediOrgTpCd[i] != null)
					model.setEdiOrgTpCd(ediOrgTpCd[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (ediSndFlg[i] != null)
					model.setEdiSndFlg(ediSndFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEdiStatusDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEdiStatusDataVO[]
	 */
	public SearchEdiStatusDataVO[] getSearchEdiStatusDataVOs(){
		SearchEdiStatusDataVO[] vos = (SearchEdiStatusDataVO[])models.toArray(new SearchEdiStatusDataVO[models.size()]);
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
		this.ediCntrSndTpCd = this.ediCntrSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpDesc = this.ediGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVslTpCd = this.ediVslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEdiStsCd = this.custEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndItvalHrmnt = this.ediSndItvalHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediDestTpCd = this.ediDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.provTrdPrnrId = this.provTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStndStsCd = this.ediStndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStsDesc = this.ediStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediEvntCd = this.ediEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rownum = this.rownum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediOrgTpCd = this.ediOrgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg = this.ediSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
