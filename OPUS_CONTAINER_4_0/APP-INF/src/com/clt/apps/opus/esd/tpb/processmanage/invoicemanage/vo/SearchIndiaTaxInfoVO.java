/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchIndiaTaxInfoVO.java
*@FileTitle : SearchIndiaTaxInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.09.14 박성진 
* 1.0 Creation
=========================================================*/
  
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchIndiaTaxInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchIndiaTaxInfoVO> models = new ArrayList<SearchIndiaTaxInfoVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String sEffDt = null;
	/* Column Info */
	private String expnTax = null;
	/* Column Info */
	private String eduTax = null;
	/* Column Info */
	private String sOfcGrd = null;
	/* Column Info */
	private String updChk = null;
	/* Column Info */
	private String taxRgstNo = null;
	/* Column Info */
	private String editable = null;
	/* Column Info */
	private String highEduTax = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sCalendarDate1 = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String idaTaxSeq = null;
	/* Column Info */
	private String sCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String svcCateRmk = null;
	/* Column Info */
	private String pmntAcctNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchIndiaTaxInfoVO() {}

	public SearchIndiaTaxInfoVO(String ibflag, String pagerows, String updDt, String creDt, String sOfcCd, String expnTax, String eduTax, String sOfcGrd, String updChk, String taxRgstNo, String editable, String highEduTax, String sCalendarDate1, String ofcCd, String creUsrId, String effDt, String idaTaxSeq, String sCntCd, String updUsrId, String svcCateRmk, String pmntAcctNo, String userOfcCd, String sEffDt) {
		this.userOfcCd = userOfcCd;
		this.updDt = updDt;
		this.creDt = creDt;
		this.sOfcCd = sOfcCd;
		this.sEffDt = sEffDt;
		this.expnTax = expnTax;
		this.eduTax = eduTax;
		this.sOfcGrd = sOfcGrd;
		this.updChk = updChk;
		this.taxRgstNo = taxRgstNo;
		this.editable = editable;
		this.highEduTax = highEduTax;
		this.pagerows = pagerows;
		this.sCalendarDate1 = sCalendarDate1;
		this.ofcCd = ofcCd;
		this.effDt = effDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.idaTaxSeq = idaTaxSeq;
		this.sCntCd = sCntCd;
		this.updUsrId = updUsrId;
		this.svcCateRmk = svcCateRmk;
		this.pmntAcctNo = pmntAcctNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("s_eff_dt", getSEffDt());
		this.hashColumns.put("expn_tax", getExpnTax());
		this.hashColumns.put("edu_tax", getEduTax());
		this.hashColumns.put("s_ofc_grd", getSOfcGrd());
		this.hashColumns.put("upd_chk", getUpdChk());
		this.hashColumns.put("tax_rgst_no", getTaxRgstNo());
		this.hashColumns.put("editable", getEditable());
		this.hashColumns.put("high_edu_tax", getHighEduTax());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_calendar_date1", getSCalendarDate1());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ida_tax_seq", getIdaTaxSeq());
		this.hashColumns.put("s_cnt_cd", getSCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("svc_cate_rmk", getSvcCateRmk());
		this.hashColumns.put("pmnt_acct_no", getPmntAcctNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("s_eff_dt", "sEffDt");
		this.hashFields.put("expn_tax", "expnTax");
		this.hashFields.put("edu_tax", "eduTax");
		this.hashFields.put("s_ofc_grd", "sOfcGrd");
		this.hashFields.put("upd_chk", "updChk");
		this.hashFields.put("tax_rgst_no", "taxRgstNo");
		this.hashFields.put("editable", "editable");
		this.hashFields.put("high_edu_tax", "highEduTax");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_calendar_date1", "sCalendarDate1");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ida_tax_seq", "idaTaxSeq");
		this.hashFields.put("s_cnt_cd", "sCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("svc_cate_rmk", "svcCateRmk");
		this.hashFields.put("pmnt_acct_no", "pmntAcctNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sEffDt
	 */
	public String getSEffDt() {
		return this.sEffDt;
	}
	
	/**
	 * Column Info
	 * @return expnTax
	 */
	public String getExpnTax() {
		return this.expnTax;
	}
	
	/**
	 * Column Info
	 * @return eduTax
	 */
	public String getEduTax() {
		return this.eduTax;
	}
	
	/**
	 * Column Info
	 * @return sOfcGrd
	 */
	public String getSOfcGrd() {
		return this.sOfcGrd;
	}
	
	/**
	 * Column Info
	 * @return updChk
	 */
	public String getUpdChk() {
		return this.updChk;
	}
	
	/**
	 * Column Info
	 * @return taxRgstNo
	 */
	public String getTaxRgstNo() {
		return this.taxRgstNo;
	}
	
	/**
	 * Column Info
	 * @return editable
	 */
	public String getEditable() {
		return this.editable;
	}
	
	/**
	 * Column Info
	 * @return highEduTax
	 */
	public String getHighEduTax() {
		return this.highEduTax;
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
	 * @return sCalendarDate1
	 */
	public String getSCalendarDate1() {
		return this.sCalendarDate1;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return idaTaxSeq
	 */
	public String getIdaTaxSeq() {
		return this.idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @return sCntCd
	 */
	public String getSCntCd() {
		return this.sCntCd;
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
	 * @return svcCateRmk
	 */
	public String getSvcCateRmk() {
		return this.svcCateRmk;
	}
	
	/**
	 * Column Info
	 * @return pmntAcctNo
	 */
	public String getPmntAcctNo() {
		return this.pmntAcctNo;
	}
	
	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sEffDt
	 */
	public void setSEffDt(String sEffDt) {
		this.sEffDt = sEffDt;
	}
	
	/**
	 * Column Info
	 * @param expnTax
	 */
	public void setExpnTax(String expnTax) {
		this.expnTax = expnTax;
	}
	
	/**
	 * Column Info
	 * @param eduTax
	 */
	public void setEduTax(String eduTax) {
		this.eduTax = eduTax;
	}
	
	/**
	 * Column Info
	 * @param sOfcGrd
	 */
	public void setSOfcGrd(String sOfcGrd) {
		this.sOfcGrd = sOfcGrd;
	}
	
	/**
	 * Column Info
	 * @param updChk
	 */
	public void setUpdChk(String updChk) {
		this.updChk = updChk;
	}
	
	/**
	 * Column Info
	 * @param taxRgstNo
	 */
	public void setTaxRgstNo(String taxRgstNo) {
		this.taxRgstNo = taxRgstNo;
	}
	
	/**
	 * Column Info
	 * @param editable
	 */
	public void setEditable(String editable) {
		this.editable = editable;
	}
	
	/**
	 * Column Info
	 * @param highEduTax
	 */
	public void setHighEduTax(String highEduTax) {
		this.highEduTax = highEduTax;
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
	 * @param sCalendarDate1
	 */
	public void setSCalendarDate1(String sCalendarDate1) {
		this.sCalendarDate1 = sCalendarDate1;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param idaTaxSeq
	 */
	public void setIdaTaxSeq(String idaTaxSeq) {
		this.idaTaxSeq = idaTaxSeq;
	}
	
	/**
	 * Column Info
	 * @param sCntCd
	 */
	public void setSCntCd(String sCntCd) {
		this.sCntCd = sCntCd;
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
	 * @param svcCateRmk
	 */
	public void setSvcCateRmk(String svcCateRmk) {
		this.svcCateRmk = svcCateRmk;
	}
	
	/**
	 * Column Info
	 * @param pmntAcctNo
	 */
	public void setPmntAcctNo(String pmntAcctNo) {
		this.pmntAcctNo = pmntAcctNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSOfcCd(JSPUtil.getParameter(request, "s_ofc_cd", ""));
		setSEffDt(JSPUtil.getParameter(request, "s_eff_dt", ""));
		setExpnTax(JSPUtil.getParameter(request, "expn_tax", ""));
		setEduTax(JSPUtil.getParameter(request, "edu_tax", ""));
		setSOfcGrd(JSPUtil.getParameter(request, "s_ofc_grd", ""));
		setUpdChk(JSPUtil.getParameter(request, "upd_chk", ""));
		setTaxRgstNo(JSPUtil.getParameter(request, "tax_rgst_no", ""));
		setEditable(JSPUtil.getParameter(request, "editable", ""));
		setHighEduTax(JSPUtil.getParameter(request, "high_edu_tax", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSCalendarDate1(JSPUtil.getParameter(request, "s_calendar_date1", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIdaTaxSeq(JSPUtil.getParameter(request, "ida_tax_seq", ""));
		setSCntCd(JSPUtil.getParameter(request, "s_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSvcCateRmk(JSPUtil.getParameter(request, "svc_cate_rmk", ""));
		setPmntAcctNo(JSPUtil.getParameter(request, "pmnt_acct_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIndiaTaxInfoVO[]
	 */
	public SearchIndiaTaxInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIndiaTaxInfoVO[]
	 */
	public SearchIndiaTaxInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIndiaTaxInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] sEffDt = (JSPUtil.getParameter(request, prefix	+ "s_eff_dt", length));
			String[] expnTax = (JSPUtil.getParameter(request, prefix	+ "expn_tax", length));
			String[] eduTax = (JSPUtil.getParameter(request, prefix	+ "edu_tax", length));
			String[] sOfcGrd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_grd", length));
			String[] updChk = (JSPUtil.getParameter(request, prefix	+ "upd_chk", length));
			String[] taxRgstNo = (JSPUtil.getParameter(request, prefix	+ "tax_rgst_no", length));
			String[] editable = (JSPUtil.getParameter(request, prefix	+ "editable", length));
			String[] highEduTax = (JSPUtil.getParameter(request, prefix	+ "high_edu_tax", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sCalendarDate1 = (JSPUtil.getParameter(request, prefix	+ "s_calendar_date1", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] idaTaxSeq = (JSPUtil.getParameter(request, prefix	+ "ida_tax_seq", length));
			String[] sCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] svcCateRmk = (JSPUtil.getParameter(request, prefix	+ "svc_cate_rmk", length));
			String[] pmntAcctNo = (JSPUtil.getParameter(request, prefix	+ "pmnt_acct_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIndiaTaxInfoVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (sEffDt[i] != null)
					model.setSEffDt(sEffDt[i]);
				if (expnTax[i] != null)
					model.setExpnTax(expnTax[i]);
				if (eduTax[i] != null)
					model.setEduTax(eduTax[i]);
				if (sOfcGrd[i] != null)
					model.setSOfcGrd(sOfcGrd[i]);
				if (updChk[i] != null)
					model.setUpdChk(updChk[i]);
				if (taxRgstNo[i] != null)
					model.setTaxRgstNo(taxRgstNo[i]);
				if (editable[i] != null)
					model.setEditable(editable[i]);
				if (highEduTax[i] != null)
					model.setHighEduTax(highEduTax[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sCalendarDate1[i] != null)
					model.setSCalendarDate1(sCalendarDate1[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (idaTaxSeq[i] != null)
					model.setIdaTaxSeq(idaTaxSeq[i]);
				if (sCntCd[i] != null)
					model.setSCntCd(sCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (svcCateRmk[i] != null)
					model.setSvcCateRmk(svcCateRmk[i]);
				if (pmntAcctNo[i] != null)
					model.setPmntAcctNo(pmntAcctNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIndiaTaxInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIndiaTaxInfoVO[]
	 */
	public SearchIndiaTaxInfoVO[] getSearchIndiaTaxInfoVOs(){
		SearchIndiaTaxInfoVO[] vos = (SearchIndiaTaxInfoVO[])models.toArray(new SearchIndiaTaxInfoVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEffDt = this.sEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnTax = this.expnTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eduTax = this.eduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcGrd = this.sOfcGrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updChk = this.updChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxRgstNo = this.taxRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.editable = this.editable .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.highEduTax = this.highEduTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCalendarDate1 = this.sCalendarDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTaxSeq = this.idaTaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntCd = this.sCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateRmk = this.svcCateRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmntAcctNo = this.pmntAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
