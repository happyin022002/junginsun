/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TermChangeInquiryVO.java
*@FileTitle : TermChangeInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Search Param VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see ..
 */
public class TermChangeInquiryVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	private Collection<TermChangeInquiryVO> models = new ArrayList<TermChangeInquiryVO>();
	
	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo");

		
	/* Status */
	private String ibflag = null;	
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String befAgmtNo = null;
	/* Column Info */
	private String befLstmCd = null;
	/* Column Info */
	private String befRefNo = null;
	/* Column Info */
	private String befVndrAbbrNm = null;
	/* Column Info */
	private String befLstBefDt = null;
	/* Column Info */
	private String befLstExpDt = null;
	/* Column Info */
	private String aftAgmtNo = null;
	/* Column Info */
	private String aftLstmCd = null;
	/* Column Info */
	private String aftRefNo = null;
	/* Column Info */
	private String aftVndrAbbrNm = null;
	/* Column Info */
	private String aftFaIfDt = null;
	/* Column Info */
	private String aftFaIfStsCd = null;		
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private int iPage = 1;
	
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * @return the cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	/**
	 * @param cntrTpszCd the cntrTpszCd to set
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * @return the creDt
	 */
	public String getCreDt() {
		return creDt;
	}

	/**
	 * @param creDt the creDt to set
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * @return the cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return cnmvStsCd;
	}

	/**
	 * @param cnmvStsCd the cnmvStsCd to set
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}

	/**
	 * @return the befAgmtNo
	 */
	public String getBefAgmtNo() {
		return befAgmtNo;
	}

	/**
	 * @param befAgmtNo the befAgmtNo to set
	 */
	public void setBefAgmtNo(String befAgmtNo) {
		this.befAgmtNo = befAgmtNo;
	}

	/**
	 * @return the befLstmCd
	 */
	public String getBefLstmCd() {
		return befLstmCd;
	}

	/**
	 * @param befLstmCd the befLstmCd to set
	 */
	public void setBefLstmCd(String befLstmCd) {
		this.befLstmCd = befLstmCd;
	}

	/**
	 * @return the befRefNo
	 */
	public String getBefRefNo() {
		return befRefNo;
	}

	/**
	 * @param befRefNo the befRefNo to set
	 */
	public void setBefRefNo(String befRefNo) {
		this.befRefNo = befRefNo;
	}

	/**
	 * @return the befVndrAbbrNm
	 */
	public String getBefVndrAbbrNm() {
		return befVndrAbbrNm;
	}

	/**
	 * @param befVndrAbbrNm the befVndrAbbrNm to set
	 */
	public void setBefVndrAbbrNm(String befVndrAbbrNm) {
		this.befVndrAbbrNm = befVndrAbbrNm;
	}

	/**
	 * @return the befLstBefDt
	 */
	public String getBefLstBefDt() {
		return befLstBefDt;
	}

	/**
	 * @param befLstBefDt the befLstBefDt to set
	 */
	public void setBefLstBefDt(String befLstBefDt) {
		this.befLstBefDt = befLstBefDt;
	}

	/**
	 * @return the befLstExpDt
	 */
	public String getBefLstExpDt() {
		return befLstExpDt;
	}

	/**
	 * @param befLstExpDt the befLstExpDt to set
	 */
	public void setBefLstExpDt(String befLstExpDt) {
		this.befLstExpDt = befLstExpDt;
	}

	/**
	 * @return the aftAgmtNo
	 */
	public String getAftAgmtNo() {
		return aftAgmtNo;
	}

	/**
	 * @param aftAgmtNo the aftAgmtNo to set
	 */
	public void setAftAgmtNo(String aftAgmtNo) {
		this.aftAgmtNo = aftAgmtNo;
	}

	/**
	 * @return the aftLstmCd
	 */
	public String getAftLstmCd() {
		return aftLstmCd;
	}

	/**
	 * @param aftLstmCd the aftLstmCd to set
	 */
	public void setAftLstmCd(String aftLstmCd) {
		this.aftLstmCd = aftLstmCd;
	}

	/**
	 * @return the aftRefNo
	 */
	public String getAftRefNo() {
		return aftRefNo;
	}

	/**
	 * @param aftRefNo the aftRefNo to set
	 */
	public void setAftRefNo(String aftRefNo) {
		this.aftRefNo = aftRefNo;
	}

	/**
	 * @return the aftVndrAbbrNm
	 */
	public String getAftVndrAbbrNm() {
		return aftVndrAbbrNm;
	}

	/**
	 * @param aftVndrAbbrNm the aftVndrAbbrNm to set
	 */
	public void setAftVndrAbbrNm(String aftVndrAbbrNm) {
		this.aftVndrAbbrNm = aftVndrAbbrNm;
	}

	/**
	 * @return the aftFaIfDt
	 */
	public String getAftFaIfDt() {
		return aftFaIfDt;
	}

	/**
	 * @param aftFaIfDt the aftFaIfDt to set
	 */
	public void setAftFaIfDt(String aftFaIfDt) {
		this.aftFaIfDt = aftFaIfDt;
	}

	/**
	 * @return the aftFaIfStsCd
	 */
	public String getAftFaIfStsCd() {
		return aftFaIfStsCd;
	}

	/**
	 * @param aftFaIfStsCd the aftFaIfStsCd to set
	 */
	public void setAftFaIfStsCd(String aftFaIfStsCd) {
		this.aftFaIfStsCd = aftFaIfStsCd;
	}

	/**
	 * @return the pagerows
	 */
	public String getPagerows() {
		return pagerows;
	}

	/**
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param page the iPage to set
	 */
	public void setIPage(int page) {
		iPage = page;
	}

	/**
	 * Constructor
	 */
	public TermChangeInquiryVO() {}	

	/**
	 * Constructor
	 */
	public TermChangeInquiryVO(String ibflag, String cntrNo, String cntrTpszCd,
			String creDt, String cnmvStsCd, String befAgmtNo, String befLstmCd,
			String befRefNo, String befVndrAbbrNm, String befLstBefDt,
			String befLstExpDt, String aftAgmtNo, String aftLstmCd,
			String aftRefNo, String aftVndrAbbrNm, String aftFaIfDt,
			String aftFaIfStsCd, String pagerows) {
		super();
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.creDt = creDt;
		this.cnmvStsCd = cnmvStsCd;
		this.befAgmtNo = befAgmtNo;
		this.befLstmCd = befLstmCd;
		this.befRefNo = befRefNo;
		this.befVndrAbbrNm = befVndrAbbrNm;
		this.befLstBefDt = befLstBefDt;
		this.befLstExpDt = befLstExpDt;
		this.aftAgmtNo = aftAgmtNo;
		this.aftLstmCd = aftLstmCd;
		this.aftRefNo = aftRefNo;
		this.aftVndrAbbrNm = aftVndrAbbrNm;
		this.aftFaIfDt = aftFaIfDt;
		this.aftFaIfStsCd = aftFaIfStsCd;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("bef_agmt_no", getBefAgmtNo());
		this.hashColumns.put("bef_lstm_cd", getBefLstmCd());
		this.hashColumns.put("bef_ref_no", getBefRefNo());
		this.hashColumns.put("bef_vndr_abbr_nm", getBefVndrAbbrNm());
		this.hashColumns.put("bef_lst_bef_dt", getBefLstBefDt());		
		this.hashColumns.put("bef_lst_exp_dt", getBefLstExpDt());
		this.hashColumns.put("aft_agmt_no", getAftAgmtNo());
		this.hashColumns.put("aft_lstm_cd", getAftLstmCd());
		this.hashColumns.put("aft_ref_no", getAftRefNo());
		this.hashColumns.put("aft_vndr_abbr_nm", getAftVndrAbbrNm());
		this.hashColumns.put("aft_fa_if_dt", getAftFaIfDt());
		this.hashColumns.put("aft_fa_if_sts_cd", getAftFaIfStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");		
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("bef_agmt_no", "befAgmtNo");
		this.hashFields.put("bef_lstm_cd", "befLstmCd");
		this.hashFields.put("bef_ref_no", "befRefNo");
		this.hashFields.put("bef_vndr_abbr_nm", "befVndrAbbrNm");
		this.hashFields.put("bef_lst_bef_dt", "befLstBefDt");		
		this.hashFields.put("bef_lst_exp_dt", "befLstExpDt");
		this.hashFields.put("aft_agmt_no", "aftAgmtNo");
		this.hashFields.put("aft_lstm_cd", "aftLstmCd");		
		this.hashFields.put("aft_ref_no", "aftRefNo");
		this.hashFields.put("aft_vndr_abbr_nm", "aftVndrAbbrNm");
		this.hashFields.put("aft_fa_if_dt", "aftFaIfDt");		
		this.hashFields.put("aft_fa_if_sts_cd", "aftFaIfStsCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));		
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));		
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setBefAgmtNo(JSPUtil.getParameter(request, "bef_agmt_no", ""));
		setBefLstmCd(JSPUtil.getParameter(request, "bef_lstm_cd", ""));
		setBefRefNo(JSPUtil.getParameter(request, "bef_ref_no", ""));
		setBefVndrAbbrNm(JSPUtil.getParameter(request, "bef_vndr_abbr_nm", ""));
		setBefLstBefDt(JSPUtil.getParameter(request, "bef_lst_bef_dt", ""));		
		setBefLstExpDt(JSPUtil.getParameter(request, "bef_lst_exp_dt", ""));
		setAftLstmCd(JSPUtil.getParameter(request, "aft_lstm_cd", ""));
		setAftRefNo(JSPUtil.getParameter(request, "aft_ref_no", ""));
		setAftVndrAbbrNm(JSPUtil.getParameter(request, "aft_vndr_abbr_nm", ""));
		setAftFaIfDt(JSPUtil.getParameter(request, "aft_fa_if_dt", ""));
		setAftFaIfStsCd(JSPUtil.getParameter(request, "aft_fa_if_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
				
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public TermChangeInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	
	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public TermChangeInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TermChangeInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd".trim(), length));
			String[] befAgmtNo = (JSPUtil.getParameter(request, prefix	+ "bef_agmt_no".trim(), length));	
			String[] befLstmCd = (JSPUtil.getParameter(request, prefix	+ "bef_lstm_cd".trim(), length));
			String[] befRefNo = (JSPUtil.getParameter(request, prefix	+ "bef_ref_no".trim(), length));
			String[] befVndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "bef_vndr_abbr_nm".trim(), length));
			String[] befLstBefDt = (JSPUtil.getParameter(request, prefix	+ "bef_lst_bef_dt".trim(), length));			
			String[] befLstExpDt = (JSPUtil.getParameter(request, prefix	+ "bef_lst_exp_dt".trim(), length));
			String[] aftAgmtNo = (JSPUtil.getParameter(request, prefix	+ "aft_agmt_no".trim(), length));
			String[] aftLstmCd = (JSPUtil.getParameter(request, prefix	+ "aft_lstm_cd".trim(), length));
			String[] aftRefNo = (JSPUtil.getParameter(request, prefix	+ "aft_ref_no".trim(), length));
			String[] aftVndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "aft_vndr_abbr_nm".trim(), length));
			String[] aftFaIfDt = (JSPUtil.getParameter(request, prefix	+ "aft_fa_if_dt".trim(), length));
			String[] aftFaIfStsCd = (JSPUtil.getParameter(request, prefix	+ "aft_fa_if_sts_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TermChangeInquiryVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (befAgmtNo[i] != null)
					model.setBefAgmtNo(befAgmtNo[i]);
				if (befLstmCd[i] != null)
					model.setBefLstmCd(befLstmCd[i]);
				if (befRefNo[i] != null)
					model.setBefRefNo(befRefNo[i]);
				if (befVndrAbbrNm[i] != null)
					model.setBefVndrAbbrNm(befVndrAbbrNm[i]);
				if (befLstBefDt[i] != null)
					model.setBefLstBefDt(befLstBefDt[i]);
				if (befLstExpDt[i] != null)
					model.setBefLstExpDt(befLstExpDt[i]);
				if (aftAgmtNo[i] != null)
					model.setAftAgmtNo(aftAgmtNo[i]);
				if (aftLstmCd[i] != null)
					model.setAftLstmCd(aftLstmCd[i]);
				if (aftRefNo[i] != null)
					model.setAftRefNo(aftRefNo[i]);
				if (aftVndrAbbrNm[i] != null)
					model.setAftVndrAbbrNm(aftVndrAbbrNm[i]);
				if (aftFaIfDt[i] != null)
					model.setAftFaIfDt(aftFaIfDt[i]);
				if (aftFaIfStsCd[i] != null)
					model.setAftFaIfStsCd(aftFaIfStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getSearchParamVOs();
	}

	public TermChangeInquiryVO[] getSearchParamVOs(){
		TermChangeInquiryVO[] vos = (TermChangeInquiryVO[])models.toArray(new TermChangeInquiryVO[models.size()]);
		return vos;
	}
	
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
			log.error(ex.getMessage(), ex);
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
			log.error(ex.getMessage(), ex);
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){		
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befAgmtNo = this.befAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befLstmCd = this.befLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befRefNo = this.befRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befVndrAbbrNm = this.befVndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befLstBefDt = this.befLstBefDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befLstExpDt = this.befLstExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftAgmtNo = this.aftAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftLstmCd = this.aftLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftRefNo = this.aftRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVndrAbbrNm = this.aftVndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftFaIfDt = this.aftFaIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftFaIfStsCd = this.aftFaIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}