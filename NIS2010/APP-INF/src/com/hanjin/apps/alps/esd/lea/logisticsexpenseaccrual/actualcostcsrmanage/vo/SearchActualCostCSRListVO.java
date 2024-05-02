/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchActualCostCSRListVO.java
*@FileTitle : SearchActualCostCSRListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : LEE YONG JOON
*@LastVersion : 1.0
* 2009.08.28 Jeon Jae Hong 
* 1.0 Creation
******************************
*  2014.12.23 [CHM-201433314] CSR IF Inquiry 및 CSR Monitoring Inquiry 화면 보완-paging 처리 관련
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.actualcostcsrmanage.vo;

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
 * @author Jeon Jae Hong
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActualCostCSRListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActualCostCSRListVO> models = new ArrayList<SearchActualCostCSRListVO>();
	
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String frmLeaFlg = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String frmSrcCtnt = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String frmIfFlg = null;
	/* Column Info */
	private String frmStIfDt = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String ifErrRsn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String errCsrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frmInvOfcCd = null;
	/* Column Info */
	private String leaFlg = null;
	/* Column Info */
	private String frmEndIfDt = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String srcCtnt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String pageNo = null;    //paging을 위한 추가 ------이용준
	/* Column Info */
	private String totalCnt = null;	 //paging을 위한 추가 ------이용준
	/* Column Info */
	private String invDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActualCostCSRListVO() {}

	public SearchActualCostCSRListVO(String ibflag, String pagerows, String csrNo, String srcCtnt, String ifFlg, String ifDt, String ifErrRsn, String leaFlg, String csrCurrCd, String csrAmt, String errCsrNo, String glDt, String invOfcCd, String frmStIfDt, String frmEndIfDt, String frmSrcCtnt, String frmIfFlg, String frmLeaFlg, String frmInvOfcCd, String pageNo, String totalCnt, String invDt) {
		this.ifDt = ifDt;
		this.frmLeaFlg = frmLeaFlg;
		this.csrNo = csrNo;
		this.glDt = glDt;
		this.frmSrcCtnt = frmSrcCtnt;
		this.csrCurrCd = csrCurrCd;
		this.frmIfFlg = frmIfFlg;
		this.frmStIfDt = frmStIfDt;
		this.ifFlg = ifFlg;
		this.ifErrRsn = ifErrRsn;
		this.pagerows = pagerows;
		this.errCsrNo = errCsrNo;
		this.ibflag = ibflag;
		this.frmInvOfcCd = frmInvOfcCd;
		this.leaFlg = leaFlg;
		this.frmEndIfDt = frmEndIfDt;
		this.csrAmt = csrAmt;
		this.srcCtnt = srcCtnt;
		this.invOfcCd = invOfcCd;
		this.pageNo = pageNo;
		this.totalCnt = totalCnt;
		this.invDt = invDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("frm_lea_flg", getFrmLeaFlg());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("frm_src_ctnt", getFrmSrcCtnt());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("frm_if_flg", getFrmIfFlg());
		this.hashColumns.put("frm_st_if_dt", getFrmStIfDt());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("if_err_rsn", getIfErrRsn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("err_csr_no", getErrCsrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frm_inv_ofc_cd", getFrmInvOfcCd());
		this.hashColumns.put("lea_flg", getLeaFlg());
		this.hashColumns.put("frm_end_if_dt", getFrmEndIfDt());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("src_ctnt", getSrcCtnt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("inv_dt", getInvDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("frm_lea_flg", "frmLeaFlg");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("frm_src_ctnt", "frmSrcCtnt");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("frm_if_flg", "frmIfFlg");
		this.hashFields.put("frm_st_if_dt", "frmStIfDt");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("if_err_rsn", "ifErrRsn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("err_csr_no", "errCsrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frm_inv_ofc_cd", "frmInvOfcCd");
		this.hashFields.put("lea_flg", "leaFlg");
		this.hashFields.put("frm_end_if_dt", "frmEndIfDt");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("src_ctnt", "srcCtnt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("inv_dt", "invDt");
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
	 * @return frmLeaFlg
	 */
	public String getFrmLeaFlg() {
		return this.frmLeaFlg;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return frmSrcCtnt
	 */
	public String getFrmSrcCtnt() {
		return this.frmSrcCtnt;
	}
	
	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return frmIfFlg
	 */
	public String getFrmIfFlg() {
		return this.frmIfFlg;
	}
	
	/**
	 * Column Info
	 * @return frmStIfDt
	 */
	public String getFrmStIfDt() {
		return this.frmStIfDt;
	}
	
	/**
	 * Column Info
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return ifErrRsn
	 */
	public String getIfErrRsn() {
		return this.ifErrRsn;
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
	 * @return errCsrNo
	 */
	public String getErrCsrNo() {
		return this.errCsrNo;
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
	 * @return frmInvOfcCd
	 */
	public String getFrmInvOfcCd() {
		return this.frmInvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return leaFlg
	 */
	public String getLeaFlg() {
		return this.leaFlg;
	}
	
	/**
	 * Column Info
	 * @return frmEndIfDt
	 */
	public String getFrmEndIfDt() {
		return this.frmEndIfDt;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return srcCtnt
	 */
	public String getSrcCtnt() {
		return this.srcCtnt;
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
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @param frmLeaFlg
	 */
	public void setFrmLeaFlg(String frmLeaFlg) {
		this.frmLeaFlg = frmLeaFlg;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param frmSrcCtnt
	 */
	public void setFrmSrcCtnt(String frmSrcCtnt) {
		this.frmSrcCtnt = frmSrcCtnt;
	}
	
	/**
	 * Column Info
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param frmIfFlg
	 */
	public void setFrmIfFlg(String frmIfFlg) {
		this.frmIfFlg = frmIfFlg;
	}
	
	/**
	 * Column Info
	 * @param frmStIfDt
	 */
	public void setFrmStIfDt(String frmStIfDt) {
		this.frmStIfDt = frmStIfDt;
	}
	
	/**
	 * Column Info
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param ifErrRsn
	 */
	public void setIfErrRsn(String ifErrRsn) {
		this.ifErrRsn = ifErrRsn;
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
	 * @param errCsrNo
	 */
	public void setErrCsrNo(String errCsrNo) {
		this.errCsrNo = errCsrNo;
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
	 * @param frmInvOfcCd
	 */
	public void setFrmInvOfcCd(String frmInvOfcCd) {
		this.frmInvOfcCd = frmInvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param leaFlg
	 */
	public void setLeaFlg(String leaFlg) {
		this.leaFlg = leaFlg;
	}
	
	/**
	 * Column Info
	 * @param frmEndIfDt
	 */
	public void setFrmEndIfDt(String frmEndIfDt) {
		this.frmEndIfDt = frmEndIfDt;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param srcCtnt
	 */
	public void setSrcCtnt(String srcCtnt) {
		this.srcCtnt = srcCtnt;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param tatalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIfDt(JSPUtil.getParameter(request, "if_dt", ""));
		setFrmLeaFlg(JSPUtil.getParameter(request, "frm_lea_flg", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setFrmSrcCtnt(JSPUtil.getParameter(request, "frm_src_ctnt", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setFrmIfFlg(JSPUtil.getParameter(request, "frm_if_flg", ""));
		setFrmStIfDt(JSPUtil.getParameter(request, "frm_st_if_dt", ""));
		setIfFlg(JSPUtil.getParameter(request, "if_flg", ""));
		setIfErrRsn(JSPUtil.getParameter(request, "if_err_rsn", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setErrCsrNo(JSPUtil.getParameter(request, "err_csr_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrmInvOfcCd(JSPUtil.getParameter(request, "frm_inv_ofc_cd", ""));
		setLeaFlg(JSPUtil.getParameter(request, "lea_flg", ""));
		setFrmEndIfDt(JSPUtil.getParameter(request, "frm_end_if_dt", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setSrcCtnt(JSPUtil.getParameter(request, "src_ctnt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, "inv_ofc_cd", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setInvDt(JSPUtil.getParameter(request, "inv_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActualCostCSRListVO[]
	 */
	public SearchActualCostCSRListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActualCostCSRListVO[]
	 */
	public SearchActualCostCSRListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActualCostCSRListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] frmLeaFlg = (JSPUtil.getParameter(request, prefix	+ "frm_lea_flg", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] frmSrcCtnt = (JSPUtil.getParameter(request, prefix	+ "frm_src_ctnt", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] frmIfFlg = (JSPUtil.getParameter(request, prefix	+ "frm_if_flg", length));
			String[] frmStIfDt = (JSPUtil.getParameter(request, prefix	+ "frm_st_if_dt", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] ifErrRsn = (JSPUtil.getParameter(request, prefix	+ "if_err_rsn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] errCsrNo = (JSPUtil.getParameter(request, prefix	+ "err_csr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frmInvOfcCd = (JSPUtil.getParameter(request, prefix	+ "frm_inv_ofc_cd", length));
			String[] leaFlg = (JSPUtil.getParameter(request, prefix	+ "lea_flg", length));
			String[] frmEndIfDt = (JSPUtil.getParameter(request, prefix	+ "frm_end_if_dt", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] srcCtnt = (JSPUtil.getParameter(request, prefix	+ "src_ctnt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActualCostCSRListVO();
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (frmLeaFlg[i] != null)
					model.setFrmLeaFlg(frmLeaFlg[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (frmSrcCtnt[i] != null)
					model.setFrmSrcCtnt(frmSrcCtnt[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (frmIfFlg[i] != null)
					model.setFrmIfFlg(frmIfFlg[i]);
				if (frmStIfDt[i] != null)
					model.setFrmStIfDt(frmStIfDt[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (ifErrRsn[i] != null)
					model.setIfErrRsn(ifErrRsn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (errCsrNo[i] != null)
					model.setErrCsrNo(errCsrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frmInvOfcCd[i] != null)
					model.setFrmInvOfcCd(frmInvOfcCd[i]);
				if (leaFlg[i] != null)
					model.setLeaFlg(leaFlg[i]);
				if (frmEndIfDt[i] != null)
					model.setFrmEndIfDt(frmEndIfDt[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (srcCtnt[i] != null)
					model.setSrcCtnt(srcCtnt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActualCostCSRListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActualCostCSRListVO[]
	 */
	public SearchActualCostCSRListVO[] getSearchActualCostCSRListVOs(){
		SearchActualCostCSRListVO[] vos = (SearchActualCostCSRListVO[])models.toArray(new SearchActualCostCSRListVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmLeaFlg = this.frmLeaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmSrcCtnt = this.frmSrcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmIfFlg = this.frmIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmStIfDt = this.frmStIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrRsn = this.ifErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCsrNo = this.errCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmInvOfcCd = this.frmInvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leaFlg = this.leaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmEndIfDt = this.frmEndIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCtnt = this.srcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
