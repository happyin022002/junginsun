/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapDoHisListVO.java
*@FileTitle : JapDoHisListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JapDoHisListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapDoHisListVO> models = new ArrayList<JapDoHisListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String issueOfcCd = null;
	/* Column Info */
	private String rdFlag = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String doRmk = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String nfNm = null;
	/* Column Info */
	private String doRsnRmk = null;
	/* Column Info */
	private String cgoRmk = null;
	/* Column Info */
	private String cnNm = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String issueDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapDoHisListVO() {}

	public JapDoHisListVO(String ibflag, String pagerows, String blNo, String bkgNo, String cnNm, String delCd, String doNo, String doRmk, String cgoRmk, String doRsnRmk, String evntDt, String evntUsrId, String evntOfcCd, String issueDt, String issueOfcCd, String nfNm, String podCd, String rdFlag, String rlseStsCd, String skdDirCd, String skdVoyNo, String vslCd, String vvd, String rowCount) {
		this.vslCd = vslCd;
		this.evntOfcCd = evntOfcCd;
		this.issueOfcCd = issueOfcCd;
		this.rdFlag = rdFlag;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.rowCount = rowCount;
		this.blNo = blNo;
		this.doRmk = doRmk;
		this.cgoRmk = cgoRmk;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.doNo = doNo;
		this.rlseStsCd = rlseStsCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.nfNm = nfNm;
		this.doRsnRmk = doRsnRmk;
		this.cnNm = cnNm;
		this.evntDt = evntDt;
		this.evntUsrId = evntUsrId;
		this.issueDt = issueDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("issue_ofc_cd", getIssueOfcCd());
		this.hashColumns.put("rd_flag", getRdFlag());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("do_rmk", getDoRmk());
		this.hashColumns.put("cgo_rmk", getCgoRmk());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("nf_nm", getNfNm());
		this.hashColumns.put("do_rsn_rmk", getDoRsnRmk());
		this.hashColumns.put("cn_nm", getCnNm());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("issue_dt", getIssueDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("issue_ofc_cd", "issueOfcCd");
		this.hashFields.put("rd_flag", "rdFlag");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("do_rmk", "doRmk");
		this.hashFields.put("cgo_rmk", "cgoRmk");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("nf_nm", "nfNm");
		this.hashFields.put("do_rsn_rmk", "doRsnRmk");
		this.hashFields.put("cn_nm", "cnNm");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("issue_dt", "issueDt");
		return this.hashFields;
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
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return issueOfcCd
	 */
	public String getIssueOfcCd() {
		return this.issueOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rdFlag
	 */
	public String getRdFlag() {
		return this.rdFlag;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cgoRmk
	 */
	public String getCgoRmk() {
		return this.cgoRmk;
	}

	/**
	 * Column Info
	 * @return doRmk
	 */
	public String getDoRmk() {
		return this.doRmk;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return nfNm
	 */
	public String getNfNm() {
		return this.nfNm;
	}
	
	/**
	 * Column Info
	 * @return doRsnRmk
	 */
	public String getDoRsnRmk() {
		return this.doRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return cnNm
	 */
	public String getCnNm() {
		return this.cnNm;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}

	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return issueDt
	 */
	public String getIssueDt() {
		return this.issueDt;
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
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param issueOfcCd
	 */
	public void setIssueOfcCd(String issueOfcCd) {
		this.issueOfcCd = issueOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rdFlag
	 */
	public void setRdFlag(String rdFlag) {
		this.rdFlag = rdFlag;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param doRmk
	 */
	public void setDoRmk(String doRmk) {
		this.doRmk = doRmk;
	}

	/**
	 * Column Info
	 * @param cgoRmk
	 */
	public void setCgoRmk(String cgoRmk) {
		this.cgoRmk = cgoRmk;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param nfNm
	 */
	public void setNfNm(String nfNm) {
		this.nfNm = nfNm;
	}
	
	/**
	 * Column Info
	 * @param doRsnRmk
	 */
	public void setDoRsnRmk(String doRsnRmk) {
		this.doRsnRmk = doRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param cnNm
	 */
	public void setCnNm(String cnNm) {
		this.cnNm = cnNm;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}

	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param issueDt
	 */
	public void setIssueDt(String issueDt) {
		this.issueDt = issueDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setIssueOfcCd(JSPUtil.getParameter(request, "issue_ofc_cd", ""));
		setRdFlag(JSPUtil.getParameter(request, "rd_flag", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRowCount(JSPUtil.getParameter(request, "row_count", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setDoRmk(JSPUtil.getParameter(request, "do_rmk", ""));
		setCgoRmk(JSPUtil.getParameter(request, "cgo_rmk", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setNfNm(JSPUtil.getParameter(request, "nf_nm", ""));
		setDoRsnRmk(JSPUtil.getParameter(request, "do_rsn_rmk", ""));
		setCnNm(JSPUtil.getParameter(request, "cn_nm", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setIssueDt(JSPUtil.getParameter(request, "issue_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapDoHisListVO[]
	 */
	public JapDoHisListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapDoHisListVO[]
	 */
	public JapDoHisListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapDoHisListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] issueOfcCd = (JSPUtil.getParameter(request, prefix	+ "issue_ofc_cd", length));
			String[] rdFlag = (JSPUtil.getParameter(request, prefix	+ "rd_flag", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] doRmk = (JSPUtil.getParameter(request, prefix	+ "do_rmk", length));
			String[] cgoRmk = (JSPUtil.getParameter(request, prefix	+ "cgo_rmk", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] nfNm = (JSPUtil.getParameter(request, prefix	+ "nf_nm", length));
			String[] doRsnRmk = (JSPUtil.getParameter(request, prefix	+ "do_rsn_rmk", length));
			String[] cnNm = (JSPUtil.getParameter(request, prefix	+ "cn_nm", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] issueDt = (JSPUtil.getParameter(request, prefix	+ "issue_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapDoHisListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (issueOfcCd[i] != null)
					model.setIssueOfcCd(issueOfcCd[i]);
				if (rdFlag[i] != null)
					model.setRdFlag(rdFlag[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (doRmk[i] != null)
					model.setDoRmk(doRmk[i]);
				if (cgoRmk[i] != null)
					model.setCgoRmk(cgoRmk[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (nfNm[i] != null)
					model.setNfNm(nfNm[i]);
				if (doRsnRmk[i] != null)
					model.setDoRsnRmk(doRsnRmk[i]);
				if (cnNm[i] != null)
					model.setCnNm(cnNm[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (issueDt[i] != null)
					model.setIssueDt(issueDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapDoHisListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapDoHisListVO[]
	 */
	public JapDoHisListVO[] getJapDoHisListVOs(){
		JapDoHisListVO[] vos = (JapDoHisListVO[])models.toArray(new JapDoHisListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueOfcCd = this.issueOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlag = this.rdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doRmk = this.doRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoRmk = this.cgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfNm = this.nfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doRsnRmk = this.doRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnNm = this.cnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueDt = this.issueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
