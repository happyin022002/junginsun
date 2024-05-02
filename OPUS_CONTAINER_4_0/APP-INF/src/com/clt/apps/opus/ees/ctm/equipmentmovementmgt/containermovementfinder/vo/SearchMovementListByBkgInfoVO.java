/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMovementListByBkgInfoVO.java
*@FileTitle : SearchMovementListByBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.18 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMovementListByBkgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchMovementListByBkgInfoVO> models = new ArrayList<SearchMovementListByBkgInfoVO>();

	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String splitBkgNoSplit = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String splitCd = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String postPolCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String tPolCd = null;
	/* Column Info */
	private String splitBkgNo = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String splitCount = null;
	/* Column Info */
	private String prePolCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String mtyPlnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchMovementListByBkgInfoVO() {}

	public SearchMovementListByBkgInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String bkgStsCd, String bkgCgoTpCd, String delCd, String deTermCd, String podCd, String bkgPolCd, String porCd, String rcvTermCd, String splitCd, String splitCount, String splitBkgNo, String splitBkgNoSplit, String shpr, String cnee, String ntfy, String prePolCd, String tVvd, String tPolCd, String postPolCd, String repCmdtNm, String mtyPlnNo) {
		this.ntfy = ntfy;
		this.splitBkgNoSplit = splitBkgNoSplit;
		this.porCd = porCd;
		this.bkgPolCd = bkgPolCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.splitCd = splitCd;
		this.repCmdtNm = repCmdtNm;
		this.bkgStsCd = bkgStsCd;
		this.delCd = delCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.postPolCd = postPolCd;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.tVvd = tVvd;
		this.tPolCd = tPolCd;
		this.splitBkgNo = splitBkgNo;
		this.cnee = cnee;
		this.splitCount = splitCount;
		this.prePolCd = prePolCd;
		this.rcvTermCd = rcvTermCd;
		this.shpr = shpr;
		this.mtyPlnNo = mtyPlnNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("split_bkg_no_split", getSplitBkgNoSplit());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("split_cd", getSplitCd());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("post_pol_cd", getPostPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("t_pol_cd", getTPolCd());
		this.hashColumns.put("split_bkg_no", getSplitBkgNo());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("split_count", getSplitCount());
		this.hashColumns.put("pre_pol_cd", getPrePolCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("split_bkg_no_split", "splitBkgNoSplit");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("split_cd", "splitCd");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("post_pol_cd", "postPolCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("t_pol_cd", "tPolCd");
		this.hashFields.put("split_bkg_no", "splitBkgNo");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("split_count", "splitCount");
		this.hashFields.put("pre_pol_cd", "prePolCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
	}

	/**
	 * Column Info
	 * @return splitBkgNoSplit
	 */
	public String getSplitBkgNoSplit() {
		return this.splitBkgNoSplit;
	}

	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}

	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @return splitCd
	 */
	public String getSplitCd() {
		return this.splitCd;
	}

	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}

	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return postPolCd
	 */
	public String getPostPolCd() {
		return this.postPolCd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}

	/**
	 * Column Info
	 * @return tPolCd
	 */
	public String getTPolCd() {
		return this.tPolCd;
	}

	/**
	 * Column Info
	 * @return splitBkgNo
	 */
	public String getSplitBkgNo() {
		return this.splitBkgNo;
	}

	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}

	/**
	 * Column Info
	 * @return splitCount
	 */
	public String getSplitCount() {
		return this.splitCount;
	}

	/**
	 * Column Info
	 * @return prePolCd
	 */
	public String getPrePolCd() {
		return this.prePolCd;
	}

	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}

	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}

	/**
	 * Column Info
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
	}


	/**
	 * Column Info
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
	}

	/**
	 * Column Info
	 * @param splitBkgNoSplit
	 */
	public void setSplitBkgNoSplit(String splitBkgNoSplit) {
		this.splitBkgNoSplit = splitBkgNoSplit;
	}

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}

	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}

	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @param splitCd
	 */
	public void setSplitCd(String splitCd) {
		this.splitCd = splitCd;
	}

	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}

	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param postPolCd
	 */
	public void setPostPolCd(String postPolCd) {
		this.postPolCd = postPolCd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}

	/**
	 * Column Info
	 * @param tPolCd
	 */
	public void setTPolCd(String tPolCd) {
		this.tPolCd = tPolCd;
	}

	/**
	 * Column Info
	 * @param splitBkgNo
	 */
	public void setSplitBkgNo(String splitBkgNo) {
		this.splitBkgNo = splitBkgNo;
	}

	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}

	/**
	 * Column Info
	 * @param splitCount
	 */
	public void setSplitCount(String splitCount) {
		this.splitCount = splitCount;
	}

	/**
	 * Column Info
	 * @param prePolCd
	 */
	public void setPrePolCd(String prePolCd) {
		this.prePolCd = prePolCd;
	}

	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}

	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}

	/**
	 * Column Info
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNtfy(JSPUtil.getParameter(request, "ntfy", ""));
		setSplitBkgNoSplit(JSPUtil.getParameter(request, "split_bkg_no_split", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setSplitCd(JSPUtil.getParameter(request, "split_cd", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPostPolCd(JSPUtil.getParameter(request, "post_pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTVvd(JSPUtil.getParameter(request, "t_vvd", ""));
		setTPolCd(JSPUtil.getParameter(request, "t_pol_cd", ""));
		setSplitBkgNo(JSPUtil.getParameter(request, "split_bkg_no", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setSplitCount(JSPUtil.getParameter(request, "split_count", ""));
		setPrePolCd(JSPUtil.getParameter(request, "pre_pol_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, "mty_pln_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMovementListByBkgInfoVO[]
	 */
	public SearchMovementListByBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchMovementListByBkgInfoVO[]
	 */
	public SearchMovementListByBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMovementListByBkgInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] splitBkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "split_bkg_no_split", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] splitCd = (JSPUtil.getParameter(request, prefix	+ "split_cd", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] postPolCd = (JSPUtil.getParameter(request, prefix	+ "post_pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] tPolCd = (JSPUtil.getParameter(request, prefix	+ "t_pol_cd", length));
			String[] splitBkgNo = (JSPUtil.getParameter(request, prefix	+ "split_bkg_no", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] splitCount = (JSPUtil.getParameter(request, prefix	+ "split_count", length));
			String[] prePolCd = (JSPUtil.getParameter(request, prefix	+ "pre_pol_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));

			for (int i = 0; i < length; i++) {
				model = new SearchMovementListByBkgInfoVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (splitBkgNoSplit[i] != null)
					model.setSplitBkgNoSplit(splitBkgNoSplit[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (splitCd[i] != null)
					model.setSplitCd(splitCd[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (postPolCd[i] != null)
					model.setPostPolCd(postPolCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (tPolCd[i] != null)
					model.setTPolCd(tPolCd[i]);
				if (splitBkgNo[i] != null)
					model.setSplitBkgNo(splitBkgNo[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (splitCount[i] != null)
					model.setSplitCount(splitCount[i]);
				if (prePolCd[i] != null)
					model.setPrePolCd(prePolCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMovementListByBkgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMovementListByBkgInfoVO[]
	 */
	public SearchMovementListByBkgInfoVO[] getSearchMovementListByBkgInfoVOs(){
		SearchMovementListByBkgInfoVO[] vos = (SearchMovementListByBkgInfoVO[])models.toArray(new SearchMovementListByBkgInfoVO[models.size()]);
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
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitBkgNoSplit = this.splitBkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitCd = this.splitCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postPolCd = this.postPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tPolCd = this.tPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitBkgNo = this.splitBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitCount = this.splitCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePolCd = this.prePolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
